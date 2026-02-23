package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetGroupResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetGroupResultJsonUnmarshaller implements Unmarshaller {
    private static GetGroupResultJsonUnmarshaller instance;

    public static GetGroupResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetGroupResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetGroupResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetGroupResult getGroupResult = new GetGroupResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Group")) {
                getGroupResult.setGroup(GroupTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getGroupResult;
    }
}
