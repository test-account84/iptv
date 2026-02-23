package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateAuthEventFeedbackResultJsonUnmarshaller implements Unmarshaller {
    private static UpdateAuthEventFeedbackResultJsonUnmarshaller instance;

    public static UpdateAuthEventFeedbackResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateAuthEventFeedbackResultJsonUnmarshaller();
        }
        return instance;
    }

    public UpdateAuthEventFeedbackResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UpdateAuthEventFeedbackResult();
    }
}
