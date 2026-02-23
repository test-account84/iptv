package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.VerifyMacResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VerifyMacResultJsonUnmarshaller implements Unmarshaller {
    private static VerifyMacResultJsonUnmarshaller instance;

    public static VerifyMacResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VerifyMacResultJsonUnmarshaller();
        }
        return instance;
    }

    public VerifyMacResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        VerifyMacResult verifyMacResult = new VerifyMacResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("KeyId")) {
                verifyMacResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("MacValid")) {
                verifyMacResult.setMacValid(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("MacAlgorithm")) {
                verifyMacResult.setMacAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return verifyMacResult;
    }
}
