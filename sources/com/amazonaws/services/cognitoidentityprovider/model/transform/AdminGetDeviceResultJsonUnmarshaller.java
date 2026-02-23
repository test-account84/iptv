package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminGetDeviceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminGetDeviceResultJsonUnmarshaller implements Unmarshaller {
    private static AdminGetDeviceResultJsonUnmarshaller instance;

    public static AdminGetDeviceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminGetDeviceResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminGetDeviceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AdminGetDeviceResult adminGetDeviceResult = new AdminGetDeviceResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Device")) {
                adminGetDeviceResult.setDevice(DeviceTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return adminGetDeviceResult;
    }
}
