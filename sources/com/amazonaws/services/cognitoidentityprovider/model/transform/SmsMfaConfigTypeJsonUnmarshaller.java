package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SmsMfaConfigType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SmsMfaConfigTypeJsonUnmarshaller implements Unmarshaller {
    private static SmsMfaConfigTypeJsonUnmarshaller instance;

    public static SmsMfaConfigTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SmsMfaConfigTypeJsonUnmarshaller();
        }
        return instance;
    }

    public SmsMfaConfigType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SmsMfaConfigType smsMfaConfigType = new SmsMfaConfigType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("SmsAuthenticationMessage")) {
                smsMfaConfigType.setSmsAuthenticationMessage(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SmsConfiguration")) {
                smsMfaConfigType.setSmsConfiguration(SmsConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return smsMfaConfigType;
    }
}
