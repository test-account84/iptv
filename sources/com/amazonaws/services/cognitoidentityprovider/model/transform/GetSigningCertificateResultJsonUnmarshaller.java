package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetSigningCertificateResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetSigningCertificateResultJsonUnmarshaller implements Unmarshaller {
    private static GetSigningCertificateResultJsonUnmarshaller instance;

    public static GetSigningCertificateResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetSigningCertificateResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetSigningCertificateResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetSigningCertificateResult getSigningCertificateResult = new GetSigningCertificateResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Certificate")) {
                getSigningCertificateResult.setCertificate(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getSigningCertificateResult;
    }
}
