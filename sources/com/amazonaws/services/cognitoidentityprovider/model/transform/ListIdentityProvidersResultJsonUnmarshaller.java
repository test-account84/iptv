package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListIdentityProvidersResultJsonUnmarshaller implements Unmarshaller {
    private static ListIdentityProvidersResultJsonUnmarshaller instance;

    public static ListIdentityProvidersResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListIdentityProvidersResultJsonUnmarshaller();
        }
        return instance;
    }

    public ListIdentityProvidersResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListIdentityProvidersResult listIdentityProvidersResult = new ListIdentityProvidersResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Providers")) {
                listIdentityProvidersResult.setProviders(new ListUnmarshaller(ProviderDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextToken")) {
                listIdentityProvidersResult.setNextToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listIdentityProvidersResult;
    }
}
