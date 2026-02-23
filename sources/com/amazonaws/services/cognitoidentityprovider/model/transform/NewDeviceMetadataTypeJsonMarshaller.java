package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.NewDeviceMetadataType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class NewDeviceMetadataTypeJsonMarshaller {
    private static NewDeviceMetadataTypeJsonMarshaller instance;

    public static NewDeviceMetadataTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new NewDeviceMetadataTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(NewDeviceMetadataType newDeviceMetadataType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (newDeviceMetadataType.getDeviceKey() != null) {
            String deviceKey = newDeviceMetadataType.getDeviceKey();
            awsJsonWriter.name("DeviceKey");
            awsJsonWriter.value(deviceKey);
        }
        if (newDeviceMetadataType.getDeviceGroupKey() != null) {
            String deviceGroupKey = newDeviceMetadataType.getDeviceGroupKey();
            awsJsonWriter.name("DeviceGroupKey");
            awsJsonWriter.value(deviceGroupKey);
        }
        awsJsonWriter.endObject();
    }
}
