package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.StopUserImportJobResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StopUserImportJobResultJsonUnmarshaller implements Unmarshaller {
    private static StopUserImportJobResultJsonUnmarshaller instance;

    public static StopUserImportJobResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StopUserImportJobResultJsonUnmarshaller();
        }
        return instance;
    }

    public StopUserImportJobResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        StopUserImportJobResult stopUserImportJobResult = new StopUserImportJobResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserImportJob")) {
                stopUserImportJobResult.setUserImportJob(UserImportJobTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return stopUserImportJobResult;
    }
}
