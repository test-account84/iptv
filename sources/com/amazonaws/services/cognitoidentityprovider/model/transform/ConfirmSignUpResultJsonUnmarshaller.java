package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConfirmSignUpResultJsonUnmarshaller implements Unmarshaller {
    private static ConfirmSignUpResultJsonUnmarshaller instance;

    public static ConfirmSignUpResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConfirmSignUpResultJsonUnmarshaller();
        }
        return instance;
    }

    public ConfirmSignUpResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ConfirmSignUpResult();
    }
}
