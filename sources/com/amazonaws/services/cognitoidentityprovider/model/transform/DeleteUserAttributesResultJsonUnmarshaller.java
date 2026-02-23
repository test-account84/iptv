package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteUserAttributesResultJsonUnmarshaller implements Unmarshaller {
    private static DeleteUserAttributesResultJsonUnmarshaller instance;

    public static DeleteUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }

    public DeleteUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new DeleteUserAttributesResult();
    }
}
