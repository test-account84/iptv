package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountRecoverySettingType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AccountRecoverySettingTypeJsonUnmarshaller implements Unmarshaller {
    private static AccountRecoverySettingTypeJsonUnmarshaller instance;

    public static AccountRecoverySettingTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AccountRecoverySettingTypeJsonUnmarshaller();
        }
        return instance;
    }

    public AccountRecoverySettingType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AccountRecoverySettingType accountRecoverySettingType = new AccountRecoverySettingType();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("RecoveryMechanisms")) {
                accountRecoverySettingType.setRecoveryMechanisms(new ListUnmarshaller(RecoveryOptionTypeJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return accountRecoverySettingType;
    }
}
