package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaSettingsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SoftwareTokenMfaSettingsTypeJsonUnmarshaller implements Unmarshaller {
    private static SoftwareTokenMfaSettingsTypeJsonUnmarshaller instance;

    public static SoftwareTokenMfaSettingsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SoftwareTokenMfaSettingsTypeJsonUnmarshaller();
        }
        return instance;
    }

    public SoftwareTokenMfaSettingsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType = new SoftwareTokenMfaSettingsType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Enabled")) {
                softwareTokenMfaSettingsType.setEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("PreferredMfa")) {
                softwareTokenMfaSettingsType.setPreferredMfa(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return softwareTokenMfaSettingsType;
    }
}
