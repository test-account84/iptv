package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateResourceServerResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateResourceServerResultJsonUnmarshaller implements Unmarshaller {
    private static UpdateResourceServerResultJsonUnmarshaller instance;

    public static UpdateResourceServerResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateResourceServerResultJsonUnmarshaller();
        }
        return instance;
    }

    public UpdateResourceServerResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateResourceServerResult updateResourceServerResult = new UpdateResourceServerResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("ResourceServer")) {
                updateResourceServerResult.setResourceServer(ResourceServerTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateResourceServerResult;
    }
}
