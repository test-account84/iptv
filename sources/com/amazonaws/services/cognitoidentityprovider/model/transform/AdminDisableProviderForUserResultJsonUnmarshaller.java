package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminDisableProviderForUserResultJsonUnmarshaller implements Unmarshaller {
    private static AdminDisableProviderForUserResultJsonUnmarshaller instance;

    public static AdminDisableProviderForUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminDisableProviderForUserResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminDisableProviderForUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminDisableProviderForUserResult();
    }
}
