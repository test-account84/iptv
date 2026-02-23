package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateAuthEventFeedbackResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminUpdateAuthEventFeedbackResultJsonUnmarshaller implements Unmarshaller {
    private static AdminUpdateAuthEventFeedbackResultJsonUnmarshaller instance;

    public static AdminUpdateAuthEventFeedbackResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUpdateAuthEventFeedbackResultJsonUnmarshaller();
        }
        return instance;
    }

    public AdminUpdateAuthEventFeedbackResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUpdateAuthEventFeedbackResult();
    }
}
