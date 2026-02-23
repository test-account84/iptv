package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GrantConstraints;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class GrantConstraintsJsonMarshaller {
    private static GrantConstraintsJsonMarshaller instance;

    public static GrantConstraintsJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new GrantConstraintsJsonMarshaller();
        }
        return instance;
    }

    public void marshall(GrantConstraints grantConstraints, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (grantConstraints.getEncryptionContextSubset() != null) {
            Map encryptionContextSubset = grantConstraints.getEncryptionContextSubset();
            awsJsonWriter.name("EncryptionContextSubset");
            awsJsonWriter.beginObject();
            for (Map.Entry entry : encryptionContextSubset.entrySet()) {
                String str = (String) entry.getValue();
                if (str != null) {
                    awsJsonWriter.name((String) entry.getKey());
                    awsJsonWriter.value(str);
                }
            }
            awsJsonWriter.endObject();
        }
        if (grantConstraints.getEncryptionContextEquals() != null) {
            Map encryptionContextEquals = grantConstraints.getEncryptionContextEquals();
            awsJsonWriter.name("EncryptionContextEquals");
            awsJsonWriter.beginObject();
            for (Map.Entry entry2 : encryptionContextEquals.entrySet()) {
                String str2 = (String) entry2.getValue();
                if (str2 != null) {
                    awsJsonWriter.name((String) entry2.getKey());
                    awsJsonWriter.value(str2);
                }
            }
            awsJsonWriter.endObject();
        }
        awsJsonWriter.endObject();
    }
}
