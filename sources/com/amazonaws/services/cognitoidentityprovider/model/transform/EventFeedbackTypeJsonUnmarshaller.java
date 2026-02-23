package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.EventFeedbackType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class EventFeedbackTypeJsonUnmarshaller implements Unmarshaller {
    private static EventFeedbackTypeJsonUnmarshaller instance;

    public static EventFeedbackTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new EventFeedbackTypeJsonUnmarshaller();
        }
        return instance;
    }

    public EventFeedbackType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        EventFeedbackType eventFeedbackType = new EventFeedbackType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("FeedbackValue")) {
                eventFeedbackType.setFeedbackValue(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Provider")) {
                eventFeedbackType.setProvider(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("FeedbackDate")) {
                eventFeedbackType.setFeedbackDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return eventFeedbackType;
    }
}
