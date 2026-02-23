package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.MultiRegionKey;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class MultiRegionKeyJsonUnmarshaller implements Unmarshaller {
    private static MultiRegionKeyJsonUnmarshaller instance;

    public static MultiRegionKeyJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new MultiRegionKeyJsonUnmarshaller();
        }
        return instance;
    }

    public MultiRegionKey unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        MultiRegionKey multiRegionKey = new MultiRegionKey();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Arn")) {
                multiRegionKey.setArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Region")) {
                multiRegionKey.setRegion(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return multiRegionKey;
    }
}
