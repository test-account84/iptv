package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateCustomKeyStoreResultJsonUnmarshaller implements Unmarshaller {
    private static UpdateCustomKeyStoreResultJsonUnmarshaller instance;

    public static UpdateCustomKeyStoreResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateCustomKeyStoreResultJsonUnmarshaller();
        }
        return instance;
    }

    public UpdateCustomKeyStoreResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UpdateCustomKeyStoreResult();
    }
}
