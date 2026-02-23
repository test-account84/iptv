package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.NotifyConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class NotifyConfigurationTypeJsonUnmarshaller implements Unmarshaller {
    private static NotifyConfigurationTypeJsonUnmarshaller instance;

    public static NotifyConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new NotifyConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }

    public NotifyConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        NotifyConfigurationType notifyConfigurationType = new NotifyConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("From")) {
                notifyConfigurationType.setFrom(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplyTo")) {
                notifyConfigurationType.setReplyTo(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SourceArn")) {
                notifyConfigurationType.setSourceArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BlockEmail")) {
                notifyConfigurationType.setBlockEmail(NotifyEmailTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NoActionEmail")) {
                notifyConfigurationType.setNoActionEmail(NotifyEmailTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("MfaEmail")) {
                notifyConfigurationType.setMfaEmail(NotifyEmailTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return notifyConfigurationType;
    }
}
