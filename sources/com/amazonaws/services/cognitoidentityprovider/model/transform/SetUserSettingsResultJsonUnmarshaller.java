package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SetUserSettingsResultJsonUnmarshaller implements Unmarshaller {
    private static SetUserSettingsResultJsonUnmarshaller instance;

    public static SetUserSettingsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetUserSettingsResultJsonUnmarshaller();
        }
        return instance;
    }

    public SetUserSettingsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new SetUserSettingsResult();
    }
}
