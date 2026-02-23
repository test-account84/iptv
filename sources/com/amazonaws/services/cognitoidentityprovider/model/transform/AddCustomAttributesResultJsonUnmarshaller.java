package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AddCustomAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AddCustomAttributesResultJsonUnmarshaller implements Unmarshaller {
    private static AddCustomAttributesResultJsonUnmarshaller instance;

    public static AddCustomAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AddCustomAttributesResultJsonUnmarshaller();
        }
        return instance;
    }

    public AddCustomAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AddCustomAttributesResult();
    }
}
