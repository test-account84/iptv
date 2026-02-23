package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminLinkProviderForUserResultJsonUnmarshaller implements Unmarshaller {
    private static AdminLinkProviderForUserResultJsonUnmarshaller instance;

    public static AdminLinkProviderForUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminLinkProviderForUserResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminLinkProviderForUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminLinkProviderForUserResult();
    }
}
