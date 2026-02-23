package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminUpdateDeviceStatusResultJsonUnmarshaller implements Unmarshaller {
    private static AdminUpdateDeviceStatusResultJsonUnmarshaller instance;

    public static AdminUpdateDeviceStatusResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUpdateDeviceStatusResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminUpdateDeviceStatusResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUpdateDeviceStatusResult();
    }
}
