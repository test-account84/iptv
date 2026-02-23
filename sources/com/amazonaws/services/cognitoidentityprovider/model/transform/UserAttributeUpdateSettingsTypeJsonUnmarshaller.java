package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UserAttributeUpdateSettingsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class UserAttributeUpdateSettingsTypeJsonUnmarshaller implements Unmarshaller {
    private static UserAttributeUpdateSettingsTypeJsonUnmarshaller instance;

    public static UserAttributeUpdateSettingsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UserAttributeUpdateSettingsTypeJsonUnmarshaller();
        }
        return instance;
    }

    public UserAttributeUpdateSettingsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        UserAttributeUpdateSettingsType userAttributeUpdateSettingsType = new UserAttributeUpdateSettingsType();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("AttributesRequireVerificationBeforeUpdate")) {
                userAttributeUpdateSettingsType.setAttributesRequireVerificationBeforeUpdate(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return userAttributeUpdateSettingsType;
    }
}
