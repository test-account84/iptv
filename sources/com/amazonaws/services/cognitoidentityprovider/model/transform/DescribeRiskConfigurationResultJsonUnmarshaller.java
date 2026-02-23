package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeRiskConfigurationResultJsonUnmarshaller implements Unmarshaller {
    private static DescribeRiskConfigurationResultJsonUnmarshaller instance;

    public static DescribeRiskConfigurationResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeRiskConfigurationResultJsonUnmarshaller();
        }
        return instance;
    }

    public DescribeRiskConfigurationResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeRiskConfigurationResult describeRiskConfigurationResult = new DescribeRiskConfigurationResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("RiskConfiguration")) {
                describeRiskConfigurationResult.setRiskConfiguration(RiskConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeRiskConfigurationResult;
    }
}
