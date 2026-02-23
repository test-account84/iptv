package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaSettingsType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class SoftwareTokenMfaSettingsTypeJsonMarshaller {
    private static SoftwareTokenMfaSettingsTypeJsonMarshaller instance;

    public static SoftwareTokenMfaSettingsTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SoftwareTokenMfaSettingsTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (softwareTokenMfaSettingsType.getEnabled() != null) {
            Boolean enabled = softwareTokenMfaSettingsType.getEnabled();
            awsJsonWriter.name("Enabled");
            awsJsonWriter.value(enabled.booleanValue());
        }
        if (softwareTokenMfaSettingsType.getPreferredMfa() != null) {
            Boolean preferredMfa = softwareTokenMfaSettingsType.getPreferredMfa();
            awsJsonWriter.name("PreferredMfa");
            awsJsonWriter.value(preferredMfa.booleanValue());
        }
        awsJsonWriter.endObject();
    }
}
