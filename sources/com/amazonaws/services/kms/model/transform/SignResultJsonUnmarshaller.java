package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.SignResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignResultJsonUnmarshaller implements Unmarshaller {
    private static SignResultJsonUnmarshaller instance;

    public static SignResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SignResultJsonUnmarshaller();
        }
        return instance;
    }

    public SignResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        SignResult signResult = new SignResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("KeyId")) {
                signResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Signature")) {
                signResult.setSignature(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SigningAlgorithm")) {
                signResult.setSigningAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return signResult;
    }
}
