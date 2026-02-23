package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ReplicateKeyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ReplicateKeyResultJsonUnmarshaller implements Unmarshaller {
    private static ReplicateKeyResultJsonUnmarshaller instance;

    public static ReplicateKeyResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicateKeyResultJsonUnmarshaller();
        }
        return instance;
    }

    public ReplicateKeyResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ReplicateKeyResult replicateKeyResult = new ReplicateKeyResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("ReplicaKeyMetadata")) {
                replicateKeyResult.setReplicaKeyMetadata(KeyMetadataJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaPolicy")) {
                replicateKeyResult.setReplicaPolicy(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaTags")) {
                replicateKeyResult.setReplicaTags(new ListUnmarshaller(TagJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return replicateKeyResult;
    }
}
