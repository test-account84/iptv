package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentity.model.UnlinkIdentityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UnlinkIdentityRequestMarshaller implements Marshaller {
    public Request marshall(UnlinkIdentityRequest unlinkIdentityRequest) {
        if (unlinkIdentityRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UnlinkIdentityRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(unlinkIdentityRequest, "AmazonCognitoIdentity");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityService.UnlinkIdentity");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (unlinkIdentityRequest.getIdentityId() != null) {
                String identityId = unlinkIdentityRequest.getIdentityId();
                jsonWriter.name("IdentityId");
                jsonWriter.value(identityId);
            }
            if (unlinkIdentityRequest.getLogins() != null) {
                Map logins = unlinkIdentityRequest.getLogins();
                jsonWriter.name("Logins");
                jsonWriter.beginObject();
                for (Map.Entry entry : logins.entrySet()) {
                    String str = (String) entry.getValue();
                    if (str != null) {
                        jsonWriter.name((String) entry.getKey());
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endObject();
            }
            if (unlinkIdentityRequest.getLoginsToRemove() != null) {
                List<String> loginsToRemove = unlinkIdentityRequest.getLoginsToRemove();
                jsonWriter.name("LoginsToRemove");
                jsonWriter.beginArray();
                for (String str2 : loginsToRemove) {
                    if (str2 != null) {
                        jsonWriter.value(str2);
                    }
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
            jsonWriter.close();
            String stringWriter2 = stringWriter.toString();
            byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
            defaultRequest.setContent(new StringInputStream(stringWriter2));
            defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
            if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
            }
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
