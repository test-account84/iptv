package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UserPoolAddOnsType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class UserPoolAddOnsTypeJsonMarshaller {
    private static UserPoolAddOnsTypeJsonMarshaller instance;

    public static UserPoolAddOnsTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new UserPoolAddOnsTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(UserPoolAddOnsType userPoolAddOnsType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (userPoolAddOnsType.getAdvancedSecurityMode() != null) {
            String advancedSecurityMode = userPoolAddOnsType.getAdvancedSecurityMode();
            awsJsonWriter.name("AdvancedSecurityMode");
            awsJsonWriter.value(advancedSecurityMode);
        }
        awsJsonWriter.endObject();
    }
}
