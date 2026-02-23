package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeUserPoolResultJsonUnmarshaller implements Unmarshaller {
    private static DescribeUserPoolResultJsonUnmarshaller instance;

    public static DescribeUserPoolResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeUserPoolResultJsonUnmarshaller();
        }
        return instance;
    }

    public DescribeUserPoolResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeUserPoolResult describeUserPoolResult = new DescribeUserPoolResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserPool")) {
                describeUserPoolResult.setUserPool(UserPoolTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeUserPoolResult;
    }
}
