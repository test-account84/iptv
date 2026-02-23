package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SetUserMFAPreferenceResultJsonUnmarshaller implements Unmarshaller {
    private static SetUserMFAPreferenceResultJsonUnmarshaller instance;

    public static SetUserMFAPreferenceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetUserMFAPreferenceResultJsonUnmarshaller();
        }
        return instance;
    }

    public SetUserMFAPreferenceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new SetUserMFAPreferenceResult();
    }
}
