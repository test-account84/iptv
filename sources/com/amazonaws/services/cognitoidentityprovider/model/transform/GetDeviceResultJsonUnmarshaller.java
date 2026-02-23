package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetDeviceResultJsonUnmarshaller implements Unmarshaller {
    private static GetDeviceResultJsonUnmarshaller instance;

    public static GetDeviceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetDeviceResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetDeviceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetDeviceResult getDeviceResult = new GetDeviceResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Device")) {
                getDeviceResult.setDevice(DeviceTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getDeviceResult;
    }
}
