package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CreateIdentityProviderResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateIdentityProviderResultJsonUnmarshaller implements Unmarshaller {
    private static CreateIdentityProviderResultJsonUnmarshaller instance;

    public static CreateIdentityProviderResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateIdentityProviderResultJsonUnmarshaller();
        }
        return instance;
    }

    public CreateIdentityProviderResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateIdentityProviderResult createIdentityProviderResult = new CreateIdentityProviderResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("IdentityProvider")) {
                createIdentityProviderResult.setIdentityProvider(IdentityProviderTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createIdentityProviderResult;
    }
}
