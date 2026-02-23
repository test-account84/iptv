package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConfirmForgotPasswordResultJsonUnmarshaller implements Unmarshaller {
    private static ConfirmForgotPasswordResultJsonUnmarshaller instance;

    public static ConfirmForgotPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConfirmForgotPasswordResultJsonUnmarshaller();
        }
        return instance;
    }

    public ConfirmForgotPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ConfirmForgotPasswordResult();
    }
}
