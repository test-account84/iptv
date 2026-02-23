package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminDeleteUserAttributesResultJsonUnmarshaller implements Unmarshaller {
    private static AdminDeleteUserAttributesResultJsonUnmarshaller instance;

    public static AdminDeleteUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminDeleteUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminDeleteUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminDeleteUserAttributesResult();
    }
}
