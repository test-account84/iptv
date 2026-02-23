package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.AssumedRoleUser;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AssumedRoleUserStaxUnmarshaller implements Unmarshaller {
    private static AssumedRoleUserStaxUnmarshaller instance;

    public static AssumedRoleUserStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AssumedRoleUserStaxUnmarshaller();
        }
        return instance;
    }

    public AssumedRoleUser unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AssumedRoleUser assumedRoleUser = new AssumedRoleUser();
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
            } else if (staxUnmarshallerContext.testExpression("AssumedRoleId", i)) {
                assumedRoleUser.setAssumedRoleId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            } else if (staxUnmarshallerContext.testExpression("Arn", i)) {
                assumedRoleUser.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            }
        }
        return assumedRoleUser;
    }
}
