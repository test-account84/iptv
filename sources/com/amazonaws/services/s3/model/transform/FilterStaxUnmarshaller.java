package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.model.Filter;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class FilterStaxUnmarshaller implements Unmarshaller {
    private static FilterStaxUnmarshaller instance = new FilterStaxUnmarshaller();

    private FilterStaxUnmarshaller() {
    }

    public static FilterStaxUnmarshaller getInstance() {
        return instance;
    }

    public Filter unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i = currentDepth + 2;
        }
        Filter filter = new Filter();
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent == 1) {
                return filter;
            }
            if (nextEvent == 2) {
                if (staxUnmarshallerContext.testExpression("S3Key", i)) {
                    filter.withS3KeyFilter(S3KeyFilterStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return filter;
            }
        }
    }
}
