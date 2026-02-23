package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class CodeDeliveryDetailsTypeJsonUnmarshaller implements Unmarshaller {
    private static CodeDeliveryDetailsTypeJsonUnmarshaller instance;

    public static CodeDeliveryDetailsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CodeDeliveryDetailsTypeJsonUnmarshaller();
        }
        return instance;
    }

    public CodeDeliveryDetailsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        CodeDeliveryDetailsType codeDeliveryDetailsType = new CodeDeliveryDetailsType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Destination")) {
                codeDeliveryDetailsType.setDestination(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("DeliveryMedium")) {
                codeDeliveryDetailsType.setDeliveryMedium(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AttributeName")) {
                codeDeliveryDetailsType.setAttributeName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return codeDeliveryDetailsType;
    }
}
