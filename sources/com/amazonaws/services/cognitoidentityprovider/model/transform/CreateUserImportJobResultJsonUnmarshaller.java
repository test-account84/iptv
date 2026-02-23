package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CreateUserImportJobResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateUserImportJobResultJsonUnmarshaller implements Unmarshaller {
    private static CreateUserImportJobResultJsonUnmarshaller instance;

    public static CreateUserImportJobResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateUserImportJobResultJsonUnmarshaller();
        }
        return instance;
    }

    public CreateUserImportJobResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateUserImportJobResult createUserImportJobResult = new CreateUserImportJobResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserImportJob")) {
                createUserImportJobResult.setUserImportJob(UserImportJobTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createUserImportJobResult;
    }
}
