package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.TagResourceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TagResourceResultJsonUnmarshaller implements Unmarshaller {
    private static TagResourceResultJsonUnmarshaller instance;

    public static TagResourceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TagResourceResultJsonUnmarshaller();
        }
        return instance;
    }

    public TagResourceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new TagResourceResult();
    }
}
