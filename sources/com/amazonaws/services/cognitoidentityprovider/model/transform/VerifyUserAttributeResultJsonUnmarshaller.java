package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VerifyUserAttributeResultJsonUnmarshaller implements Unmarshaller {
    private static VerifyUserAttributeResultJsonUnmarshaller instance;

    public static VerifyUserAttributeResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VerifyUserAttributeResultJsonUnmarshaller();
        }
        return instance;
    }

    public VerifyUserAttributeResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new VerifyUserAttributeResult();
    }
}
