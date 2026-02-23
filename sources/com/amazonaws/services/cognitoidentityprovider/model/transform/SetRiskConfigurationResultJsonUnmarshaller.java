package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SetRiskConfigurationResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SetRiskConfigurationResultJsonUnmarshaller implements Unmarshaller {
    private static SetRiskConfigurationResultJsonUnmarshaller instance;

    public static SetRiskConfigurationResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetRiskConfigurationResultJsonUnmarshaller();
        }
        return instance;
    }

    public SetRiskConfigurationResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        SetRiskConfigurationResult setRiskConfigurationResult = new SetRiskConfigurationResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("RiskConfiguration")) {
                setRiskConfigurationResult.setRiskConfiguration(RiskConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return setRiskConfigurationResult;
    }
}
