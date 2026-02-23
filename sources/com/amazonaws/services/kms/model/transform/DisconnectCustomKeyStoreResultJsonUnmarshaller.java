package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DisconnectCustomKeyStoreResultJsonUnmarshaller implements Unmarshaller {
    private static DisconnectCustomKeyStoreResultJsonUnmarshaller instance;

    public static DisconnectCustomKeyStoreResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DisconnectCustomKeyStoreResultJsonUnmarshaller();
        }
        return instance;
    }

    public DisconnectCustomKeyStoreResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new DisconnectCustomKeyStoreResult();
    }
}
