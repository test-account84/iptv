package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetCSVHeaderResultJsonUnmarshaller implements Unmarshaller {
    private static GetCSVHeaderResultJsonUnmarshaller instance;

    public static GetCSVHeaderResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetCSVHeaderResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetCSVHeaderResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetCSVHeaderResult getCSVHeaderResult = new GetCSVHeaderResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("UserPoolId")) {
                getCSVHeaderResult.setUserPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("CSVHeader")) {
                getCSVHeaderResult.setCSVHeader(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getCSVHeaderResult;
    }
}
