package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateDataKeyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GenerateDataKeyResultJsonUnmarshaller implements Unmarshaller {
    private static GenerateDataKeyResultJsonUnmarshaller instance;

    public static GenerateDataKeyResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GenerateDataKeyResultJsonUnmarshaller();
        }
        return instance;
    }

    public GenerateDataKeyResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateDataKeyResult generateDataKeyResult = new GenerateDataKeyResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("CiphertextBlob")) {
                generateDataKeyResult.setCiphertextBlob(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Plaintext")) {
                generateDataKeyResult.setPlaintext(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyId")) {
                generateDataKeyResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return generateDataKeyResult;
    }
}
