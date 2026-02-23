package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListKeysResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListKeysResultJsonUnmarshaller implements Unmarshaller {
    private static ListKeysResultJsonUnmarshaller instance;

    public static ListKeysResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListKeysResultJsonUnmarshaller();
        }
        return instance;
    }

    public ListKeysResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListKeysResult listKeysResult = new ListKeysResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Keys")) {
                listKeysResult.setKeys(new ListUnmarshaller(KeyListEntryJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextMarker")) {
                listKeysResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Truncated")) {
                listKeysResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listKeysResult;
    }
}
