package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateDataKeyPairResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GenerateDataKeyPairResultJsonUnmarshaller implements Unmarshaller {
    private static GenerateDataKeyPairResultJsonUnmarshaller instance;

    public static GenerateDataKeyPairResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GenerateDataKeyPairResultJsonUnmarshaller();
        }
        return instance;
    }

    public GenerateDataKeyPairResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateDataKeyPairResult generateDataKeyPairResult = new GenerateDataKeyPairResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("PrivateKeyCiphertextBlob")) {
                generateDataKeyPairResult.setPrivateKeyCiphertextBlob(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("PrivateKeyPlaintext")) {
                generateDataKeyPairResult.setPrivateKeyPlaintext(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("PublicKey")) {
                generateDataKeyPairResult.setPublicKey(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyId")) {
                generateDataKeyPairResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyPairSpec")) {
                generateDataKeyPairResult.setKeyPairSpec(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return generateDataKeyPairResult;
    }
}
