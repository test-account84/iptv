package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CompromisedCredentialsRiskConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller implements Unmarshaller {
    private static CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller instance;

    public static CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }

    public CompromisedCredentialsRiskConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType = new CompromisedCredentialsRiskConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("EventFilter")) {
                compromisedCredentialsRiskConfigurationType.setEventFilter(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Actions")) {
                compromisedCredentialsRiskConfigurationType.setActions(CompromisedCredentialsActionsTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return compromisedCredentialsRiskConfigurationType;
    }
}
