package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminConfirmSignUpResultJsonUnmarshaller implements Unmarshaller {
    private static AdminConfirmSignUpResultJsonUnmarshaller instance;

    public static AdminConfirmSignUpResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminConfirmSignUpResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminConfirmSignUpResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminConfirmSignUpResult();
    }
}
