package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminEnableUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminEnableUserResultJsonUnmarshaller implements Unmarshaller {
    private static AdminEnableUserResultJsonUnmarshaller instance;

    public static AdminEnableUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminEnableUserResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminEnableUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminEnableUserResult();
    }
}
