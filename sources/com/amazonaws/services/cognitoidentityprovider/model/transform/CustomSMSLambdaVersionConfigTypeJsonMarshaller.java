package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CustomSMSLambdaVersionConfigType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class CustomSMSLambdaVersionConfigTypeJsonMarshaller {
    private static CustomSMSLambdaVersionConfigTypeJsonMarshaller instance;

    public static CustomSMSLambdaVersionConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new CustomSMSLambdaVersionConfigTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(CustomSMSLambdaVersionConfigType customSMSLambdaVersionConfigType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (customSMSLambdaVersionConfigType.getLambdaVersion() != null) {
            String lambdaVersion = customSMSLambdaVersionConfigType.getLambdaVersion();
            awsJsonWriter.name("LambdaVersion");
            awsJsonWriter.value(lambdaVersion);
        }
        if (customSMSLambdaVersionConfigType.getLambdaArn() != null) {
            String lambdaArn = customSMSLambdaVersionConfigType.getLambdaArn();
            awsJsonWriter.name("LambdaArn");
            awsJsonWriter.value(lambdaArn);
        }
        awsJsonWriter.endObject();
    }
}
