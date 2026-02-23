package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteCustomKeyStoreResultJsonUnmarshaller implements Unmarshaller {
    private static DeleteCustomKeyStoreResultJsonUnmarshaller instance;

    public static DeleteCustomKeyStoreResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteCustomKeyStoreResultJsonUnmarshaller();
        }
        return instance;
    }

    public DeleteCustomKeyStoreResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new DeleteCustomKeyStoreResult();
    }
}
