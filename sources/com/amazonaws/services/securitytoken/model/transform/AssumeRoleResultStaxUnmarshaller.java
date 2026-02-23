package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AssumeRoleResultStaxUnmarshaller implements Unmarshaller {
    private static AssumeRoleResultStaxUnmarshaller instance;

    public static AssumeRoleResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AssumeRoleResultStaxUnmarshaller();
        }
        return instance;
    }

    public AssumeRoleResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AssumeRoleResult assumeRoleResult = new AssumeRoleResult();
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
            } else if (staxUnmarshallerContext.testExpression("Credentials", i)) {
                assumeRoleResult.setCredentials(CredentialsStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            } else if (staxUnmarshallerContext.testExpression("AssumedRoleUser", i)) {
                assumeRoleResult.setAssumedRoleUser(AssumedRoleUserStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            } else if (staxUnmarshallerContext.testExpression("PackedPolicySize", i)) {
                assumeRoleResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            } else if (staxUnmarshallerContext.testExpression("SourceIdentity", i)) {
                assumeRoleResult.setSourceIdentity(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
            }
        }
        return assumeRoleResult;
    }
}
