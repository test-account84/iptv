package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateUserAttributesResultJsonUnmarshaller implements Unmarshaller {
    private static UpdateUserAttributesResultJsonUnmarshaller instance;

    public static UpdateUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }

    public UpdateUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateUserAttributesResult updateUserAttributesResult = new UpdateUserAttributesResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CodeDeliveryDetailsList")) {
                updateUserAttributesResult.setCodeDeliveryDetailsList(new ListUnmarshaller(CodeDeliveryDetailsTypeJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateUserAttributesResult;
    }
}
