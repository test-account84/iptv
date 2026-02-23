package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetUserPoolMfaConfigResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetUserPoolMfaConfigResultJsonUnmarshaller implements Unmarshaller {
    private static GetUserPoolMfaConfigResultJsonUnmarshaller instance;

    public static GetUserPoolMfaConfigResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetUserPoolMfaConfigResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetUserPoolMfaConfigResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetUserPoolMfaConfigResult getUserPoolMfaConfigResult = new GetUserPoolMfaConfigResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("SmsMfaConfiguration")) {
                getUserPoolMfaConfigResult.setSmsMfaConfiguration(SmsMfaConfigTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SoftwareTokenMfaConfiguration")) {
                getUserPoolMfaConfigResult.setSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("MfaConfiguration")) {
                getUserPoolMfaConfigResult.setMfaConfiguration(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getUserPoolMfaConfigResult;
    }
}
