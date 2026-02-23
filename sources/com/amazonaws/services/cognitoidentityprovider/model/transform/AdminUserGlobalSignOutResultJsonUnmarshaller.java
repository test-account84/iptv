package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUserGlobalSignOutResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminUserGlobalSignOutResultJsonUnmarshaller implements Unmarshaller {
    private static AdminUserGlobalSignOutResultJsonUnmarshaller instance;

    public static AdminUserGlobalSignOutResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUserGlobalSignOutResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminUserGlobalSignOutResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUserGlobalSignOutResult();
    }
}
