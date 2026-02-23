package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminUpdateUserAttributesResultJsonUnmarshaller implements Unmarshaller {
    private static AdminUpdateUserAttributesResultJsonUnmarshaller instance;

    public static AdminUpdateUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUpdateUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminUpdateUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUpdateUserAttributesResult();
    }
}
