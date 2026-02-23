package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaConfigType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SoftwareTokenMfaConfigTypeJsonMarshaller {
    private static SoftwareTokenMfaConfigTypeJsonMarshaller instance;

    public static SoftwareTokenMfaConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SoftwareTokenMfaConfigTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(SoftwareTokenMfaConfigType softwareTokenMfaConfigType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (softwareTokenMfaConfigType.getEnabled() != null) {
            Boolean enabled = softwareTokenMfaConfigType.getEnabled();
            awsJsonWriter.name("Enabled");
            awsJsonWriter.value(enabled.booleanValue());
        }
        awsJsonWriter.endObject();
    }
}
