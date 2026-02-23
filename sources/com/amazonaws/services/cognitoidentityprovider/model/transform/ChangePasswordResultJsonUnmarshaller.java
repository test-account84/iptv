package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ChangePasswordResultJsonUnmarshaller implements Unmarshaller {
    private static ChangePasswordResultJsonUnmarshaller instance;

    public static ChangePasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ChangePasswordResultJsonUnmarshaller();
        }
        return instance;
    }

    public ChangePasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ChangePasswordResult();
    }
}
