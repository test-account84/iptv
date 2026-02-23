package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UntagResourceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UntagResourceResultJsonUnmarshaller implements Unmarshaller {
    private static UntagResourceResultJsonUnmarshaller instance;

    public static UntagResourceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UntagResourceResultJsonUnmarshaller();
        }
        return instance;
    }

    public UntagResourceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UntagResourceResult();
    }
}
