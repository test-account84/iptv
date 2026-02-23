package com.amazonaws.transform;

import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.AwsJsonToken;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MapUnmarshaller implements Unmarshaller {
    private final Unmarshaller valueUnmarshaller;

    public MapUnmarshaller(Unmarshaller unmarshaller) {
        this.valueUnmarshaller = unmarshaller;
    }

    public Map unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (reader.peek() == AwsJsonToken.VALUE_NULL) {
            reader.skipValue();
            return null;
        }
        HashMap hashMap = new HashMap();
        reader.beginObject();
        while (reader.hasNext()) {
            hashMap.put(reader.nextName(), this.valueUnmarshaller.unmarshall(jsonUnmarshallerContext));
        }
        reader.endObject();
        return hashMap;
    }
}
