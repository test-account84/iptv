package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminResetUserPasswordResultJsonUnmarshaller implements Unmarshaller {
    private static AdminResetUserPasswordResultJsonUnmarshaller instance;

    public static AdminResetUserPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminResetUserPasswordResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminResetUserPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminResetUserPasswordResult();
    }
}
