package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ResourceServerScopeType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ResourceServerScopeTypeJsonMarshaller {
    private static ResourceServerScopeTypeJsonMarshaller instance;

    public static ResourceServerScopeTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ResourceServerScopeTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(ResourceServerScopeType resourceServerScopeType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (resourceServerScopeType.getScopeName() != null) {
            String scopeName = resourceServerScopeType.getScopeName();
            awsJsonWriter.name("ScopeName");
            awsJsonWriter.value(scopeName);
        }
        if (resourceServerScopeType.getScopeDescription() != null) {
            String scopeDescription = resourceServerScopeType.getScopeDescription();
            awsJsonWriter.name("ScopeDescription");
            awsJsonWriter.value(scopeDescription);
        }
        awsJsonWriter.endObject();
    }
}
