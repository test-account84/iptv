package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaConfigType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SoftwareTokenMfaConfigTypeJsonUnmarshaller implements Unmarshaller {
    private static SoftwareTokenMfaConfigTypeJsonUnmarshaller instance;

    public static SoftwareTokenMfaConfigTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SoftwareTokenMfaConfigTypeJsonUnmarshaller();
        }
        return instance;
    }

    public SoftwareTokenMfaConfigType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SoftwareTokenMfaConfigType softwareTokenMfaConfigType = new SoftwareTokenMfaConfigType();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Enabled")) {
                softwareTokenMfaConfigType.setEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return softwareTokenMfaConfigType;
    }
}
