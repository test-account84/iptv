package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ForgotPasswordResultJsonUnmarshaller implements Unmarshaller {
    private static ForgotPasswordResultJsonUnmarshaller instance;

    public static ForgotPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ForgotPasswordResultJsonUnmarshaller();
        }
        return instance;
    }

    public ForgotPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ForgotPasswordResult forgotPasswordResult = new ForgotPasswordResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CodeDeliveryDetails")) {
                forgotPasswordResult.setCodeDeliveryDetails(CodeDeliveryDetailsTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return forgotPasswordResult;
    }
}
