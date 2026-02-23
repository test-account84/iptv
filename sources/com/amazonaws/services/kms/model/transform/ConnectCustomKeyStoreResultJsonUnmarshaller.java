package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConnectCustomKeyStoreResultJsonUnmarshaller implements Unmarshaller {
    private static ConnectCustomKeyStoreResultJsonUnmarshaller instance;

    public static ConnectCustomKeyStoreResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConnectCustomKeyStoreResultJsonUnmarshaller();
        }
        return instance;
    }

    public ConnectCustomKeyStoreResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ConnectCustomKeyStoreResult();
    }
}
