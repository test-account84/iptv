package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.RevokeTokenResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RevokeTokenResultJsonUnmarshaller implements Unmarshaller {
    private static RevokeTokenResultJsonUnmarshaller instance;

    public static RevokeTokenResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RevokeTokenResultJsonUnmarshaller();
        }
        return instance;
    }

    public RevokeTokenResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new RevokeTokenResult();
    }
}
