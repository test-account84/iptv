package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.util.StringUtils;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3StringResponseHandler extends AbstractS3ResponseHandler {
    private static final int DEFAULT_BYTE_SIZE = 1024;

    public AmazonWebServiceResponse handle(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse parseResponseMetadata = parseResponseMetadata(httpResponse);
        byte[] bArr = new byte[1024];
        StringBuilder sb = new StringBuilder();
        InputStream content = httpResponse.getContent();
        while (true) {
            int read = content.read(bArr);
            if (read <= 0) {
                parseResponseMetadata.setResult(sb.toString());
                return parseResponseMetadata;
            }
            sb.append(new String(bArr, 0, read, StringUtils.UTF8));
        }
    }
}
