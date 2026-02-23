package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.util.StringUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class PolicyDescriptorTypeStaxMarshaller {
    private static PolicyDescriptorTypeStaxMarshaller instance;

    public static PolicyDescriptorTypeStaxMarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyDescriptorTypeStaxMarshaller();
        }
        return instance;
    }

    public void marshall(PolicyDescriptorType policyDescriptorType, Request request, String str) {
        if (policyDescriptorType.getArn() != null) {
            request.addParameter(str + "arn", StringUtils.fromString(policyDescriptorType.getArn()));
        }
    }
}
