package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CreateGroupResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateGroupResultJsonUnmarshaller implements Unmarshaller {
    private static CreateGroupResultJsonUnmarshaller instance;

    public static CreateGroupResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateGroupResultJsonUnmarshaller();
        }
        return instance;
    }

    public CreateGroupResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateGroupResult createGroupResult = new CreateGroupResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Group")) {
                createGroupResult.setGroup(GroupTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createGroupResult;
    }
}
