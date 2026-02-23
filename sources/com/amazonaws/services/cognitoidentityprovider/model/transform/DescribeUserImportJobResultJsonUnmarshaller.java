package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeUserImportJobResultJsonUnmarshaller implements Unmarshaller {
    private static DescribeUserImportJobResultJsonUnmarshaller instance;

    public static DescribeUserImportJobResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeUserImportJobResultJsonUnmarshaller();
        }
        return instance;
    }

    public DescribeUserImportJobResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeUserImportJobResult describeUserImportJobResult = new DescribeUserImportJobResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserImportJob")) {
                describeUserImportJobResult.setUserImportJob(UserImportJobTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeUserImportJobResult;
    }
}
