package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GenerateDataKeyPairWithoutPlaintextResultJsonUnmarshaller implements Unmarshaller {
    private static GenerateDataKeyPairWithoutPlaintextResultJsonUnmarshaller instance;

    public static GenerateDataKeyPairWithoutPlaintextResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GenerateDataKeyPairWithoutPlaintextResultJsonUnmarshaller();
        }
        return instance;
    }

    public GenerateDataKeyPairWithoutPlaintextResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateDataKeyPairWithoutPlaintextResult generateDataKeyPairWithoutPlaintextResult = new GenerateDataKeyPairWithoutPlaintextResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("PrivateKeyCiphertextBlob")) {
                generateDataKeyPairWithoutPlaintextResult.setPrivateKeyCiphertextBlob(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("PublicKey")) {
                generateDataKeyPairWithoutPlaintextResult.setPublicKey(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyId")) {
                generateDataKeyPairWithoutPlaintextResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyPairSpec")) {
                generateDataKeyPairWithoutPlaintextResult.setKeyPairSpec(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return generateDataKeyPairWithoutPlaintextResult;
    }
}
