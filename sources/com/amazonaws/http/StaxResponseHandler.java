package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.VoidStaxUnmarshaller;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StaxResponseHandler implements HttpResponseHandler {
    private static final XmlPullParserFactory XML_PULL_PARSER_FACTORY;
    private static final Log log = LogFactory.getLog("com.amazonaws.request");
    private Unmarshaller responseUnmarshaller;

    static {
        try {
            XML_PULL_PARSER_FACTORY = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new AmazonClientException("Couldn't initialize XmlPullParserFactory", e);
        }
    }

    public StaxResponseHandler(Unmarshaller unmarshaller) {
        this.responseUnmarshaller = unmarshaller;
        if (unmarshaller == null) {
            this.responseUnmarshaller = new VoidStaxUnmarshaller();
        }
    }

    public AmazonWebServiceResponse handle(HttpResponse httpResponse) throws Exception {
        Log log2 = log;
        log2.trace("Parsing service response XML");
        ByteArrayInputStream content = httpResponse.getContent();
        if (content == null) {
            content = new ByteArrayInputStream("<eof/>".getBytes(StringUtils.UTF8));
        }
        XmlPullParser newPullParser = XML_PULL_PARSER_FACTORY.newPullParser();
        newPullParser.setInput(content, (String) null);
        AmazonWebServiceResponse amazonWebServiceResponse = new AmazonWebServiceResponse();
        StaxUnmarshallerContext staxUnmarshallerContext = new StaxUnmarshallerContext(newPullParser, httpResponse.getHeaders());
        staxUnmarshallerContext.registerMetadataExpression("ResponseMetadata/RequestId", 2, "AWS_REQUEST_ID");
        staxUnmarshallerContext.registerMetadataExpression("requestId", 2, "AWS_REQUEST_ID");
        registerAdditionalMetadataExpressions(staxUnmarshallerContext);
        amazonWebServiceResponse.setResult(this.responseUnmarshaller.unmarshall(staxUnmarshallerContext));
        Map metadata = staxUnmarshallerContext.getMetadata();
        Map headers = httpResponse.getHeaders();
        if (headers != null && headers.get("x-amzn-RequestId") != null) {
            metadata.put("AWS_REQUEST_ID", headers.get("x-amzn-RequestId"));
        }
        amazonWebServiceResponse.setResponseMetadata(new ResponseMetadata(metadata));
        log2.trace("Done parsing service response");
        return amazonWebServiceResponse;
    }

    public boolean needsConnectionLeftOpen() {
        return false;
    }

    public void registerAdditionalMetadataExpressions(StaxUnmarshallerContext staxUnmarshallerContext) {
    }
}
