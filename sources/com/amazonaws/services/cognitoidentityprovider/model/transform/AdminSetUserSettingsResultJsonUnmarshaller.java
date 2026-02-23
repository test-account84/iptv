package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserSettingsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminSetUserSettingsResultJsonUnmarshaller implements Unmarshaller {
    private static AdminSetUserSettingsResultJsonUnmarshaller instance;

    public static AdminSetUserSettingsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminSetUserSettingsResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminSetUserSettingsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminSetUserSettingsResult();
    }
}
