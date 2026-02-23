package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UpdateIdentityProviderRequestMarshaller implements Marshaller {
    public Request marshall(UpdateIdentityProviderRequest updateIdentityProviderRequest) {
        if (updateIdentityProviderRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateIdentityProviderRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateIdentityProviderRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateIdentityProvider");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateIdentityProviderRequest.getUserPoolId() != null) {
                String userPoolId = updateIdentityProviderRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (updateIdentityProviderRequest.getProviderName() != null) {
                String providerName = updateIdentityProviderRequest.getProviderName();
                jsonWriter.name("ProviderName");
                jsonWriter.value(providerName);
            }
            if (updateIdentityProviderRequest.getProviderDetails() != null) {
                Map providerDetails = updateIdentityProviderRequest.getProviderDetails();
                jsonWriter.name("ProviderDetails");
                jsonWriter.beginObject();
                for (Map.Entry entry : providerDetails.entrySet()) {
                    String str = (String) entry.getValue();
                    if (str != null) {
                        jsonWriter.name((String) entry.getKey());
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endObject();
            }
            if (updateIdentityProviderRequest.getAttributeMapping() != null) {
                Map attributeMapping = updateIdentityProviderRequest.getAttributeMapping();
                jsonWriter.name("AttributeMapping");
                jsonWriter.beginObject();
                for (Map.Entry entry2 : attributeMapping.entrySet()) {
                    String str2 = (String) entry2.getValue();
                    if (str2 != null) {
                        jsonWriter.name((String) entry2.getKey());
                        jsonWriter.value(str2);
                    }
                }
                jsonWriter.endObject();
            }
            if (updateIdentityProviderRequest.getIdpIdentifiers() != null) {
                List<String> idpIdentifiers = updateIdentityProviderRequest.getIdpIdentifiers();
                jsonWriter.name("IdpIdentifiers");
                jsonWriter.beginArray();
                for (String str3 : idpIdentifiers) {
                    if (str3 != null) {
                        jsonWriter.value(str3);
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
