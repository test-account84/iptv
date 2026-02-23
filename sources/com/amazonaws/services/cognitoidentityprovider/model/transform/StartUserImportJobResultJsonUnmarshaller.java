package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.StartUserImportJobResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StartUserImportJobResultJsonUnmarshaller implements Unmarshaller {
    private static StartUserImportJobResultJsonUnmarshaller instance;

    public static StartUserImportJobResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StartUserImportJobResultJsonUnmarshaller();
        }
        return instance;
    }

    public StartUserImportJobResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        StartUserImportJobResult startUserImportJobResult = new StartUserImportJobResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserImportJob")) {
                startUserImportJobResult.setUserImportJob(UserImportJobTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return startUserImportJobResult;
    }
}
