package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.SetPrincipalTagAttributeMapResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SetPrincipalTagAttributeMapResultJsonUnmarshaller implements Unmarshaller {
    private static SetPrincipalTagAttributeMapResultJsonUnmarshaller instance;

    public static SetPrincipalTagAttributeMapResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetPrincipalTagAttributeMapResultJsonUnmarshaller();
        }
        return instance;
    }

    public SetPrincipalTagAttributeMapResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        SetPrincipalTagAttributeMapResult setPrincipalTagAttributeMapResult = new SetPrincipalTagAttributeMapResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IdentityPoolId")) {
                setPrincipalTagAttributeMapResult.setIdentityPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("IdentityProviderName")) {
                setPrincipalTagAttributeMapResult.setIdentityProviderName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("UseDefaults")) {
                setPrincipalTagAttributeMapResult.setUseDefaults(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("PrincipalTags")) {
                setPrincipalTagAttributeMapResult.setPrincipalTags(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return setPrincipalTagAttributeMapResult;
    }
}
