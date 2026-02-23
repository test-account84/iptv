package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetIdentityPoolRolesResultJsonUnmarshaller implements Unmarshaller {
    private static GetIdentityPoolRolesResultJsonUnmarshaller instance;

    public static GetIdentityPoolRolesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetIdentityPoolRolesResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetIdentityPoolRolesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetIdentityPoolRolesResult getIdentityPoolRolesResult = new GetIdentityPoolRolesResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IdentityPoolId")) {
                getIdentityPoolRolesResult.setIdentityPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Roles")) {
                getIdentityPoolRolesResult.setRoles(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("RoleMappings")) {
                getIdentityPoolRolesResult.setRoleMappings(new MapUnmarshaller(RoleMappingJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getIdentityPoolRolesResult;
    }
}
