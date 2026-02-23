package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeviceSecretVerifierConfigType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class DeviceSecretVerifierConfigTypeJsonMarshaller {
    private static DeviceSecretVerifierConfigTypeJsonMarshaller instance;

    public static DeviceSecretVerifierConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new DeviceSecretVerifierConfigTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(DeviceSecretVerifierConfigType deviceSecretVerifierConfigType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (deviceSecretVerifierConfigType.getPasswordVerifier() != null) {
            String passwordVerifier = deviceSecretVerifierConfigType.getPasswordVerifier();
            awsJsonWriter.name("PasswordVerifier");
            awsJsonWriter.value(passwordVerifier);
        }
        if (deviceSecretVerifierConfigType.getSalt() != null) {
            String salt = deviceSecretVerifierConfigType.getSalt();
            awsJsonWriter.name("Salt");
            awsJsonWriter.value(salt);
        }
        awsJsonWriter.endObject();
    }
}
