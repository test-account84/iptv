package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.NotifyEmailType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class NotifyEmailTypeJsonUnmarshaller implements Unmarshaller {
    private static NotifyEmailTypeJsonUnmarshaller instance;

    public static NotifyEmailTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new NotifyEmailTypeJsonUnmarshaller();
        }
        return instance;
    }

    public NotifyEmailType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        NotifyEmailType notifyEmailType = new NotifyEmailType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Subject")) {
                notifyEmailType.setSubject(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("HtmlBody")) {
                notifyEmailType.setHtmlBody(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TextBody")) {
                notifyEmailType.setTextBody(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return notifyEmailType;
    }
}
