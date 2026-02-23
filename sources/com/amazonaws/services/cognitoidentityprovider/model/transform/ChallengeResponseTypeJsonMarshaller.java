package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ChallengeResponseType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ChallengeResponseTypeJsonMarshaller {
    private static ChallengeResponseTypeJsonMarshaller instance;

    public static ChallengeResponseTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ChallengeResponseTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(ChallengeResponseType challengeResponseType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (challengeResponseType.getChallengeName() != null) {
            String challengeName = challengeResponseType.getChallengeName();
            awsJsonWriter.name("ChallengeName");
            awsJsonWriter.value(challengeName);
        }
        if (challengeResponseType.getChallengeResponse() != null) {
            String challengeResponse = challengeResponseType.getChallengeResponse();
            awsJsonWriter.name("ChallengeResponse");
            awsJsonWriter.value(challengeResponse);
        }
        awsJsonWriter.endObject();
    }
}
