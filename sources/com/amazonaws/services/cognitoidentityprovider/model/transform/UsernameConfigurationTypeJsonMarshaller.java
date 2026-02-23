package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UsernameConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class UsernameConfigurationTypeJsonMarshaller {
    private static UsernameConfigurationTypeJsonMarshaller instance;

    public static UsernameConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new UsernameConfigurationTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(UsernameConfigurationType usernameConfigurationType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (usernameConfigurationType.getCaseSensitive() != null) {
            Boolean caseSensitive = usernameConfigurationType.getCaseSensitive();
            awsJsonWriter.name("CaseSensitive");
            awsJsonWriter.value(caseSensitive.booleanValue());
        }
        awsJsonWriter.endObject();
    }
}
