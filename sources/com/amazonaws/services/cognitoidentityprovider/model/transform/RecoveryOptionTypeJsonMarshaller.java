package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.RecoveryOptionType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class RecoveryOptionTypeJsonMarshaller {
    private static RecoveryOptionTypeJsonMarshaller instance;

    public static RecoveryOptionTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RecoveryOptionTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(RecoveryOptionType recoveryOptionType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (recoveryOptionType.getPriority() != null) {
            Integer priority = recoveryOptionType.getPriority();
            awsJsonWriter.name("Priority");
            awsJsonWriter.value((Number) priority);
        }
        if (recoveryOptionType.getName() != null) {
            String name = recoveryOptionType.getName();
            awsJsonWriter.name("Name");
            awsJsonWriter.value(name);
        }
        awsJsonWriter.endObject();
    }
}
