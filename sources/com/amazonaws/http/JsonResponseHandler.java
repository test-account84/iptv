package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.VoidJsonUnmarshaller;
import com.amazonaws.util.CRC32ChecksumCalculatingInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.JsonUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class JsonResponseHandler implements HttpResponseHandler {
    private static final Log log = LogFactory.getLog("com.amazonaws.request");
    public boolean needsConnectionLeftOpen = false;
    private Unmarshaller responseUnmarshaller;

    public JsonResponseHandler(Unmarshaller unmarshaller) {
        this.responseUnmarshaller = unmarshaller;
        if (unmarshaller == null) {
            this.responseUnmarshaller = new VoidJsonUnmarshaller();
        }
    }

    public AmazonWebServiceResponse handle(HttpResponse httpResponse) throws Exception {
        ByteArrayInputStream byteArrayInputStream;
        Log log2 = log;
        log2.trace("Parsing service response JSON");
        String str = (String) httpResponse.getHeaders().get("x-amz-crc32");
        ByteArrayInputStream rawContent = httpResponse.getRawContent();
        if (rawContent == null) {
            rawContent = new ByteArrayInputStream("{}".getBytes(StringUtils.UTF8));
        }
        log2.debug("CRC32Checksum = " + str);
        log2.debug("content encoding = " + ((String) httpResponse.getHeaders().get("Content-Encoding")));
        boolean equals = "gzip".equals(httpResponse.getHeaders().get("Content-Encoding"));
        if (str != null) {
            byteArrayInputStream = new CRC32ChecksumCalculatingInputStream(rawContent);
            rawContent = byteArrayInputStream;
        } else {
            byteArrayInputStream = null;
        }
        if (equals) {
            rawContent = new GZIPInputStream(rawContent);
        }
        AwsJsonReader jsonReader = JsonUtils.getJsonReader(new InputStreamReader(rawContent, StringUtils.UTF8));
        try {
            AmazonWebServiceResponse amazonWebServiceResponse = new AmazonWebServiceResponse();
            Object unmarshall = this.responseUnmarshaller.unmarshall(new JsonUnmarshallerContext(jsonReader, httpResponse));
            if (byteArrayInputStream != null) {
                if (byteArrayInputStream.getCRC32Checksum() != Long.parseLong(str)) {
                    throw new CRC32MismatchException("Client calculated crc32 checksum didn't match that calculated by server side");
                }
            }
            amazonWebServiceResponse.setResult(unmarshall);
            HashMap hashMap = new HashMap();
            hashMap.put("AWS_REQUEST_ID", httpResponse.getHeaders().get("x-amzn-RequestId"));
            amazonWebServiceResponse.setResponseMetadata(new ResponseMetadata((Map) hashMap));
            log2.trace("Done parsing service response");
            if (!this.needsConnectionLeftOpen) {
                try {
                    jsonReader.close();
                } catch (IOException e) {
                    log.warn("Error closing json parser", e);
                }
            }
            return amazonWebServiceResponse;
        } catch (Throwable th) {
            if (!this.needsConnectionLeftOpen) {
                try {
                    jsonReader.close();
                } catch (IOException e2) {
                    log.warn("Error closing json parser", e2);
                }
            }
            throw th;
        }
    }

    public boolean needsConnectionLeftOpen() {
        return this.needsConnectionLeftOpen;
    }

    @Deprecated
    public void registerAdditionalMetadataExpressions(JsonUnmarshallerContext jsonUnmarshallerContext) {
    }
}
