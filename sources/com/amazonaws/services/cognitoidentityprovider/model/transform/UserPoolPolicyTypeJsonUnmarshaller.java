package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UserPoolPolicyType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class UserPoolPolicyTypeJsonUnmarshaller implements Unmarshaller {
    private static UserPoolPolicyTypeJsonUnmarshaller instance;

    public static UserPoolPolicyTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UserPoolPolicyTypeJsonUnmarshaller();
        }
        return instance;
    }

    public UserPoolPolicyType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        UserPoolPolicyType userPoolPolicyType = new UserPoolPolicyType();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("PasswordPolicy")) {
                userPoolPolicyType.setPasswordPolicy(PasswordPolicyTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return userPoolPolicyType;
    }
}
