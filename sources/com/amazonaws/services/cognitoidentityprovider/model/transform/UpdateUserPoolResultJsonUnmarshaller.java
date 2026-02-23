package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateUserPoolResultJsonUnmarshaller implements Unmarshaller {
    private static UpdateUserPoolResultJsonUnmarshaller instance;

    public static UpdateUserPoolResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateUserPoolResultJsonUnmarshaller();
        }
        return instance;
    }

    public UpdateUserPoolResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UpdateUserPoolResult();
    }
}
