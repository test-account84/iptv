package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.CreateKeyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateKeyResultJsonUnmarshaller implements Unmarshaller {
    private static CreateKeyResultJsonUnmarshaller instance;

    public static CreateKeyResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateKeyResultJsonUnmarshaller();
        }
        return instance;
    }

    public CreateKeyResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateKeyResult createKeyResult = new CreateKeyResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("KeyMetadata")) {
                createKeyResult.setKeyMetadata(KeyMetadataJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createKeyResult;
    }
}
