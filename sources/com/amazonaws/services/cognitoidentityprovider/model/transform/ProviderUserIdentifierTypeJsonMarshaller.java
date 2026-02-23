package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ProviderUserIdentifierType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ProviderUserIdentifierTypeJsonMarshaller {
    private static ProviderUserIdentifierTypeJsonMarshaller instance;

    public static ProviderUserIdentifierTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ProviderUserIdentifierTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(ProviderUserIdentifierType providerUserIdentifierType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (providerUserIdentifierType.getProviderName() != null) {
            String providerName = providerUserIdentifierType.getProviderName();
            awsJsonWriter.name("ProviderName");
            awsJsonWriter.value(providerName);
        }
        if (providerUserIdentifierType.getProviderAttributeName() != null) {
            String providerAttributeName = providerUserIdentifierType.getProviderAttributeName();
            awsJsonWriter.name("ProviderAttributeName");
            awsJsonWriter.value(providerAttributeName);
        }
        if (providerUserIdentifierType.getProviderAttributeValue() != null) {
            String providerAttributeValue = providerUserIdentifierType.getProviderAttributeValue();
            awsJsonWriter.name("ProviderAttributeValue");
            awsJsonWriter.value(providerAttributeValue);
        }
        awsJsonWriter.endObject();
    }
}
