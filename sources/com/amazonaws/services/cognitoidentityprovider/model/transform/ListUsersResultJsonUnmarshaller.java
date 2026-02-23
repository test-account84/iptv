package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ListUsersResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListUsersResultJsonUnmarshaller implements Unmarshaller {
    private static ListUsersResultJsonUnmarshaller instance;

    public static ListUsersResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListUsersResultJsonUnmarshaller();
        }
        return instance;
    }

    public ListUsersResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListUsersResult listUsersResult = new ListUsersResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Users")) {
                listUsersResult.setUsers(new ListUnmarshaller(UserTypeJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("PaginationToken")) {
                listUsersResult.setPaginationToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listUsersResult;
    }
}
