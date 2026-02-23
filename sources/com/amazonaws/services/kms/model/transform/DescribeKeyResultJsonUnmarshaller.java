package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.DescribeKeyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeKeyResultJsonUnmarshaller implements Unmarshaller {
    private static DescribeKeyResultJsonUnmarshaller instance;

    public static DescribeKeyResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeKeyResultJsonUnmarshaller();
        }
        return instance;
    }

    public DescribeKeyResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeKeyResult describeKeyResult = new DescribeKeyResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("KeyMetadata")) {
                describeKeyResult.setKeyMetadata(KeyMetadataJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeKeyResult;
    }
}
