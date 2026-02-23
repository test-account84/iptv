package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateMacResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GenerateMacResultJsonUnmarshaller implements Unmarshaller {
    private static GenerateMacResultJsonUnmarshaller instance;

    public static GenerateMacResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GenerateMacResultJsonUnmarshaller();
        }
        return instance;
    }

    public GenerateMacResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateMacResult generateMacResult = new GenerateMacResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Mac")) {
                generateMacResult.setMac(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("MacAlgorithm")) {
                generateMacResult.setMacAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyId")) {
                generateMacResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return generateMacResult;
    }
}
