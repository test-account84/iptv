package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolClientResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeUserPoolClientResultJsonUnmarshaller implements Unmarshaller {
    private static DescribeUserPoolClientResultJsonUnmarshaller instance;

    public static DescribeUserPoolClientResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeUserPoolClientResultJsonUnmarshaller();
        }
        return instance;
    }

    public DescribeUserPoolClientResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeUserPoolClientResult describeUserPoolClientResult = new DescribeUserPoolClientResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserPoolClient")) {
                describeUserPoolClientResult.setUserPoolClient(UserPoolClientTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeUserPoolClientResult;
    }
}
