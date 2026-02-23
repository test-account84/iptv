package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateUserPoolDomainResultJsonUnmarshaller implements Unmarshaller {
    private static CreateUserPoolDomainResultJsonUnmarshaller instance;

    public static CreateUserPoolDomainResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateUserPoolDomainResultJsonUnmarshaller();
        }
        return instance;
    }

    public CreateUserPoolDomainResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateUserPoolDomainResult createUserPoolDomainResult = new CreateUserPoolDomainResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CloudFrontDomain")) {
                createUserPoolDomainResult.setCloudFrontDomain(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createUserPoolDomainResult;
    }
}
