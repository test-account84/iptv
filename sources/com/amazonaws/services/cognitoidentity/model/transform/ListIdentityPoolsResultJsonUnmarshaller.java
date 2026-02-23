package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListIdentityPoolsResultJsonUnmarshaller implements Unmarshaller {
    private static ListIdentityPoolsResultJsonUnmarshaller instance;

    public static ListIdentityPoolsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListIdentityPoolsResultJsonUnmarshaller();
        }
        return instance;
    }

    public ListIdentityPoolsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListIdentityPoolsResult listIdentityPoolsResult = new ListIdentityPoolsResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IdentityPools")) {
                listIdentityPoolsResult.setIdentityPools(new ListUnmarshaller(IdentityPoolShortDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextToken")) {
                listIdentityPoolsResult.setNextToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listIdentityPoolsResult;
    }
}
