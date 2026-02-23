package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListResourceServersResultJsonUnmarshaller implements Unmarshaller {
    private static ListResourceServersResultJsonUnmarshaller instance;

    public static ListResourceServersResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListResourceServersResultJsonUnmarshaller();
        }
        return instance;
    }

    public ListResourceServersResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListResourceServersResult listResourceServersResult = new ListResourceServersResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("ResourceServers")) {
                listResourceServersResult.setResourceServers(new ListUnmarshaller(ResourceServerTypeJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextToken")) {
                listResourceServersResult.setNextToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listResourceServersResult;
    }
}
