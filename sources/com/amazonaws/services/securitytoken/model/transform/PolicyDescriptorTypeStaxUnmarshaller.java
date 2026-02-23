package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class PolicyDescriptorTypeStaxUnmarshaller implements Unmarshaller {
    private static PolicyDescriptorTypeStaxUnmarshaller instance;

    public static PolicyDescriptorTypeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyDescriptorTypeStaxUnmarshaller();
        }
        return instance;
    }

    public PolicyDescriptorType unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PolicyDescriptorType policyDescriptorType = new PolicyDescriptorType();
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
            } else if (staxUnmarshallerContext.testExpression("arn", i)) {
                policyDescriptorType.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            }
        }
        return policyDescriptorType;
    }
}
