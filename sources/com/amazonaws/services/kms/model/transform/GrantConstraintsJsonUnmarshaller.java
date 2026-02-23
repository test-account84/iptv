package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GrantConstraints;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class GrantConstraintsJsonUnmarshaller implements Unmarshaller {
    private static GrantConstraintsJsonUnmarshaller instance;

    public static GrantConstraintsJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GrantConstraintsJsonUnmarshaller();
        }
        return instance;
    }

    public GrantConstraints unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GrantConstraints grantConstraints = new GrantConstraints();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("EncryptionContextSubset")) {
                grantConstraints.setEncryptionContextSubset(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("EncryptionContextEquals")) {
                grantConstraints.setEncryptionContextEquals(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return grantConstraints;
    }
}
