package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetUserAttributeVerificationCodeResultJsonUnmarshaller implements Unmarshaller {
    private static GetUserAttributeVerificationCodeResultJsonUnmarshaller instance;

    public static GetUserAttributeVerificationCodeResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetUserAttributeVerificationCodeResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetUserAttributeVerificationCodeResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetUserAttributeVerificationCodeResult getUserAttributeVerificationCodeResult = new GetUserAttributeVerificationCodeResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CodeDeliveryDetails")) {
                getUserAttributeVerificationCodeResult.setCodeDeliveryDetails(CodeDeliveryDetailsTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getUserAttributeVerificationCodeResult;
    }
}
