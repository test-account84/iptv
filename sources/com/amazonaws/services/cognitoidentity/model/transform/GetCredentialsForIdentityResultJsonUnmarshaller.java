package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetCredentialsForIdentityResultJsonUnmarshaller implements Unmarshaller {
    private static GetCredentialsForIdentityResultJsonUnmarshaller instance;

    public static GetCredentialsForIdentityResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetCredentialsForIdentityResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetCredentialsForIdentityResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetCredentialsForIdentityResult getCredentialsForIdentityResult = new GetCredentialsForIdentityResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IdentityId")) {
                getCredentialsForIdentityResult.setIdentityId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Credentials")) {
                getCredentialsForIdentityResult.setCredentials(CredentialsJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getCredentialsForIdentityResult;
    }
}
