package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeIdentityProviderResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeIdentityProviderResultJsonUnmarshaller implements Unmarshaller {
    private static DescribeIdentityProviderResultJsonUnmarshaller instance;

    public static DescribeIdentityProviderResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeIdentityProviderResultJsonUnmarshaller();
        }
        return instance;
    }

    public DescribeIdentityProviderResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeIdentityProviderResult describeIdentityProviderResult = new DescribeIdentityProviderResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("IdentityProvider")) {
                describeIdentityProviderResult.setIdentityProvider(IdentityProviderTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeIdentityProviderResult;
    }
}
