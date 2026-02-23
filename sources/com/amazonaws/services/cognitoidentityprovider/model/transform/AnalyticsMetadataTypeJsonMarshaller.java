package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AnalyticsMetadataTypeJsonMarshaller {
    private static AnalyticsMetadataTypeJsonMarshaller instance;

    public static AnalyticsMetadataTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AnalyticsMetadataTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(AnalyticsMetadataType analyticsMetadataType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (analyticsMetadataType.getAnalyticsEndpointId() != null) {
            String analyticsEndpointId = analyticsMetadataType.getAnalyticsEndpointId();
            awsJsonWriter.name("AnalyticsEndpointId");
            awsJsonWriter.value(analyticsEndpointId);
        }
        awsJsonWriter.endObject();
    }
}
