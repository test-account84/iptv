package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminDisableUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminDisableUserResultJsonUnmarshaller implements Unmarshaller {
    private static AdminDisableUserResultJsonUnmarshaller instance;

    public static AdminDisableUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminDisableUserResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminDisableUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminDisableUserResult();
    }
}
