package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CustomDomainConfigType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class CustomDomainConfigTypeJsonMarshaller {
    private static CustomDomainConfigTypeJsonMarshaller instance;

    public static CustomDomainConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new CustomDomainConfigTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(CustomDomainConfigType customDomainConfigType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (customDomainConfigType.getCertificateArn() != null) {
            String certificateArn = customDomainConfigType.getCertificateArn();
            awsJsonWriter.name("CertificateArn");
            awsJsonWriter.value(certificateArn);
        }
        awsJsonWriter.endObject();
    }
}
