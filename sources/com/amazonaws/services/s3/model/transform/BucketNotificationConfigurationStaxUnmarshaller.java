package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BucketNotificationConfigurationStaxUnmarshaller implements Unmarshaller {
    private static BucketNotificationConfigurationStaxUnmarshaller instance = new BucketNotificationConfigurationStaxUnmarshaller();
    private static final XmlPullParserFactory xmlPullParserFactory;

    static {
        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new AmazonClientException("Couldn't initialize XmlPullParserFactory", e);
        }
    }

    private BucketNotificationConfigurationStaxUnmarshaller() {
    }

    public static BucketNotificationConfigurationStaxUnmarshaller getInstance() {
        return instance;
    }

    public BucketNotificationConfiguration unmarshall(InputStream inputStream) throws Exception {
        NotificationConfigurationStaxUnmarshaller topicConfigurationStaxUnmarshaller;
        Map.Entry unmarshall;
        XmlPullParser newPullParser = xmlPullParserFactory.newPullParser();
        newPullParser.setInput(inputStream, (String) null);
        StaxUnmarshallerContext staxUnmarshallerContext = new StaxUnmarshallerContext(newPullParser, null);
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i = currentDepth + 2;
        }
        BucketNotificationConfiguration bucketNotificationConfiguration = new BucketNotificationConfiguration();
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent == 1) {
                return bucketNotificationConfiguration;
            }
            if (nextEvent == 2) {
                if (staxUnmarshallerContext.testExpression("TopicConfiguration", i)) {
                    topicConfigurationStaxUnmarshaller = TopicConfigurationStaxUnmarshaller.getInstance();
                } else if (staxUnmarshallerContext.testExpression("QueueConfiguration", i)) {
                    topicConfigurationStaxUnmarshaller = QueueConfigurationStaxUnmarshaller.getInstance();
                } else if (staxUnmarshallerContext.testExpression("CloudFunctionConfiguration", i)) {
                    unmarshall = LambdaConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    bucketNotificationConfiguration.addConfiguration((String) unmarshall.getKey(), (NotificationConfiguration) unmarshall.getValue());
                }
                unmarshall = topicConfigurationStaxUnmarshaller.unmarshall(staxUnmarshallerContext);
                bucketNotificationConfiguration.addConfiguration((String) unmarshall.getKey(), (NotificationConfiguration) unmarshall.getValue());
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return bucketNotificationConfiguration;
            }
        }
    }
}
