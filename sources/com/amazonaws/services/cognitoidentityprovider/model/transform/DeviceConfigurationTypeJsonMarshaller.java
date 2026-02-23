package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeviceConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class DeviceConfigurationTypeJsonMarshaller {
    private static DeviceConfigurationTypeJsonMarshaller instance;

    public static DeviceConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new DeviceConfigurationTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(DeviceConfigurationType deviceConfigurationType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (deviceConfigurationType.getChallengeRequiredOnNewDevice() != null) {
            Boolean challengeRequiredOnNewDevice = deviceConfigurationType.getChallengeRequiredOnNewDevice();
            awsJsonWriter.name("ChallengeRequiredOnNewDevice");
            awsJsonWriter.value(challengeRequiredOnNewDevice.booleanValue());
        }
        if (deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt() != null) {
            Boolean deviceOnlyRememberedOnUserPrompt = deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt();
            awsJsonWriter.name("DeviceOnlyRememberedOnUserPrompt");
            awsJsonWriter.value(deviceOnlyRememberedOnUserPrompt.booleanValue());
        }
        awsJsonWriter.endObject();
    }
}
