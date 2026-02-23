package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminSetUserPasswordResultJsonUnmarshaller implements Unmarshaller {
    private static AdminSetUserPasswordResultJsonUnmarshaller instance;

    public static AdminSetUserPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminSetUserPasswordResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminSetUserPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminSetUserPasswordResult();
    }
}
