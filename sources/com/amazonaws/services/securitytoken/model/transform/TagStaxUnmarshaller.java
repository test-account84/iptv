package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.Tag;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class TagStaxUnmarshaller implements Unmarshaller {
    private static TagStaxUnmarshaller instance;

    public static TagStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TagStaxUnmarshaller();
        }
        return instance;
    }

    public Tag unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Tag tag = new Tag();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i = currentDepth + 3;
        }
        while (true) {
            int nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent == 1) {
                break;
            }
            if (nextEvent != 2) {
                if (nextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                    break;
                }
            } else if (staxUnmarshallerContext.testExpression("Key", i)) {
                tag.setKey(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            } else if (staxUnmarshallerContext.testExpression("Value", i)) {
                tag.setValue(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            }
        }
        return tag;
    }
}
