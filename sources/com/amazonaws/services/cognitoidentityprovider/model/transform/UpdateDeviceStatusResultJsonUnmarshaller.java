package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateDeviceStatusResultJsonUnmarshaller implements Unmarshaller {
    private static UpdateDeviceStatusResultJsonUnmarshaller instance;

    public static UpdateDeviceStatusResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateDeviceStatusResultJsonUnmarshaller();
        }
        return instance;
    }

    public UpdateDeviceStatusResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UpdateDeviceStatusResult();
    }
}
