package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverActionsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AccountTakeoverActionsTypeJsonUnmarshaller implements Unmarshaller {
    private static AccountTakeoverActionsTypeJsonUnmarshaller instance;

    public static AccountTakeoverActionsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AccountTakeoverActionsTypeJsonUnmarshaller();
        }
        return instance;
    }

    public AccountTakeoverActionsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AccountTakeoverActionsType accountTakeoverActionsType = new AccountTakeoverActionsType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("LowAction")) {
                accountTakeoverActionsType.setLowAction(AccountTakeoverActionTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("MediumAction")) {
                accountTakeoverActionsType.setMediumAction(AccountTakeoverActionTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("HighAction")) {
                accountTakeoverActionsType.setHighAction(AccountTakeoverActionTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return accountTakeoverActionsType;
    }
}
