package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ImportKeyMaterialResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ImportKeyMaterialResultJsonUnmarshaller implements Unmarshaller {
    private static ImportKeyMaterialResultJsonUnmarshaller instance;

    public static ImportKeyMaterialResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ImportKeyMaterialResultJsonUnmarshaller();
        }
        return instance;
    }

    public ImportKeyMaterialResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ImportKeyMaterialResult();
    }
}
