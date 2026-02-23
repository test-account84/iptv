package com.amazonaws.transform;

import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.AwsJsonToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListUnmarshaller implements Unmarshaller {
    private final Unmarshaller itemUnmarshaller;

    public ListUnmarshaller(Unmarshaller unmarshaller) {
        this.itemUnmarshaller = unmarshaller;
    }

    public List unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (reader.peek() == AwsJsonToken.VALUE_NULL) {
            reader.skipValue();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        reader.beginArray();
        while (reader.hasNext()) {
            arrayList.add(this.itemUnmarshaller.unmarshall(jsonUnmarshallerContext));
        }
        reader.endArray();
        return arrayList;
    }
}
