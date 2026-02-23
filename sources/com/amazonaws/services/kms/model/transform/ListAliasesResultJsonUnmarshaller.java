package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ListAliasesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListAliasesResultJsonUnmarshaller implements Unmarshaller {
    private static ListAliasesResultJsonUnmarshaller instance;

    public static ListAliasesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListAliasesResultJsonUnmarshaller();
        }
        return instance;
    }

    public ListAliasesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListAliasesResult listAliasesResult = new ListAliasesResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Aliases")) {
                listAliasesResult.setAliases(new ListUnmarshaller(AliasListEntryJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextMarker")) {
                listAliasesResult.setNextMarker(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Truncated")) {
                listAliasesResult.setTruncated(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listAliasesResult;
    }
}
