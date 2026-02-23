package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverActionType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AccountTakeoverActionTypeJsonUnmarshaller implements Unmarshaller {
    private static AccountTakeoverActionTypeJsonUnmarshaller instance;

    public static AccountTakeoverActionTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AccountTakeoverActionTypeJsonUnmarshaller();
        }
        return instance;
    }

    public AccountTakeoverActionType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AccountTakeoverActionType accountTakeoverActionType = new AccountTakeoverActionType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Notify")) {
                accountTakeoverActionType.setNotify(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("EventAction")) {
                accountTakeoverActionType.setEventAction(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return accountTakeoverActionType;
    }
}
