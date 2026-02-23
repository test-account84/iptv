package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteUserPoolDomainResultJsonUnmarshaller implements Unmarshaller {
    private static DeleteUserPoolDomainResultJsonUnmarshaller instance;

    public static DeleteUserPoolDomainResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteUserPoolDomainResultJsonUnmarshaller();
        }
        return instance;
    }

    public DeleteUserPoolDomainResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new DeleteUserPoolDomainResult();
    }
}
