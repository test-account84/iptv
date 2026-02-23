package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverActionType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AccountTakeoverActionTypeJsonMarshaller {
    private static AccountTakeoverActionTypeJsonMarshaller instance;

    public static AccountTakeoverActionTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AccountTakeoverActionTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(AccountTakeoverActionType accountTakeoverActionType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (accountTakeoverActionType.getNotify() != null) {
            Boolean notify = accountTakeoverActionType.getNotify();
            awsJsonWriter.name("Notify");
            awsJsonWriter.value(notify.booleanValue());
        }
        if (accountTakeoverActionType.getEventAction() != null) {
            String eventAction = accountTakeoverActionType.getEventAction();
            awsJsonWriter.name("EventAction");
            awsJsonWriter.value(eventAction);
        }
        awsJsonWriter.endObject();
    }
}
