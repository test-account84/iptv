package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.RecoveryOptionType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class RecoveryOptionTypeJsonUnmarshaller implements Unmarshaller {
    private static RecoveryOptionTypeJsonUnmarshaller instance;

    public static RecoveryOptionTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RecoveryOptionTypeJsonUnmarshaller();
        }
        return instance;
    }

    public RecoveryOptionType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        RecoveryOptionType recoveryOptionType = new RecoveryOptionType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Priority")) {
                recoveryOptionType.setPriority(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Name")) {
                recoveryOptionType.setName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return recoveryOptionType;
    }
}
