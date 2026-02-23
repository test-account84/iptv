package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class UserContextDataTypeJsonMarshaller {
    private static UserContextDataTypeJsonMarshaller instance;

    public static UserContextDataTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new UserContextDataTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(UserContextDataType userContextDataType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (userContextDataType.getIpAddress() != null) {
            String ipAddress = userContextDataType.getIpAddress();
            awsJsonWriter.name("IpAddress");
            awsJsonWriter.value(ipAddress);
        }
        if (userContextDataType.getEncodedData() != null) {
            String encodedData = userContextDataType.getEncodedData();
            awsJsonWriter.name("EncodedData");
            awsJsonWriter.value(encodedData);
        }
        awsJsonWriter.endObject();
    }
}
