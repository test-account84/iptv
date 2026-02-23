package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateRandomResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GenerateRandomResultJsonUnmarshaller implements Unmarshaller {
    private static GenerateRandomResultJsonUnmarshaller instance;

    public static GenerateRandomResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GenerateRandomResultJsonUnmarshaller();
        }
        return instance;
    }

    public GenerateRandomResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateRandomResult generateRandomResult = new GenerateRandomResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Plaintext")) {
                generateRandomResult.setPlaintext(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return generateRandomResult;
    }
}
