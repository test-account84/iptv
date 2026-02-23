package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.EventRiskType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class EventRiskTypeJsonMarshaller {
    private static EventRiskTypeJsonMarshaller instance;

    public static EventRiskTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new EventRiskTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(EventRiskType eventRiskType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (eventRiskType.getRiskDecision() != null) {
            String riskDecision = eventRiskType.getRiskDecision();
            awsJsonWriter.name("RiskDecision");
            awsJsonWriter.value(riskDecision);
        }
        if (eventRiskType.getRiskLevel() != null) {
            String riskLevel = eventRiskType.getRiskLevel();
            awsJsonWriter.name("RiskLevel");
            awsJsonWriter.value(riskLevel);
        }
        if (eventRiskType.getCompromisedCredentialsDetected() != null) {
            Boolean compromisedCredentialsDetected = eventRiskType.getCompromisedCredentialsDetected();
            awsJsonWriter.name("CompromisedCredentialsDetected");
            awsJsonWriter.value(compromisedCredentialsDetected.booleanValue());
        }
        awsJsonWriter.endObject();
    }
}
