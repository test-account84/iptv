package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AssumeRoleWithSAMLRequestMarshaller implements Marshaller {
    public Request marshall(AssumeRoleWithSAMLRequest assumeRoleWithSAMLRequest) {
        if (assumeRoleWithSAMLRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AssumeRoleWithSAMLRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(assumeRoleWithSAMLRequest, "AWSSecurityTokenService");
        defaultRequest.addParameter("Action", "AssumeRoleWithSAML");
        defaultRequest.addParameter("Version", "2011-06-15");
        if (assumeRoleWithSAMLRequest.getRoleArn() != null) {
            defaultRequest.addParameter("RoleArn", StringUtils.fromString(assumeRoleWithSAMLRequest.getRoleArn()));
        }
        if (assumeRoleWithSAMLRequest.getPrincipalArn() != null) {
            defaultRequest.addParameter("PrincipalArn", StringUtils.fromString(assumeRoleWithSAMLRequest.getPrincipalArn()));
        }
        if (assumeRoleWithSAMLRequest.getSAMLAssertion() != null) {
            defaultRequest.addParameter("SAMLAssertion", StringUtils.fromString(assumeRoleWithSAMLRequest.getSAMLAssertion()));
        }
        if (assumeRoleWithSAMLRequest.getPolicyArns() != null) {
            int i = 1;
            for (PolicyDescriptorType policyDescriptorType : assumeRoleWithSAMLRequest.getPolicyArns()) {
                String str = "PolicyArns.member." + i;
                if (policyDescriptorType != null) {
                    PolicyDescriptorTypeStaxMarshaller.getInstance().marshall(policyDescriptorType, defaultRequest, str + ".");
                }
                i++;
            }
        }
        if (assumeRoleWithSAMLRequest.getPolicy() != null) {
            defaultRequest.addParameter("Policy", StringUtils.fromString(assumeRoleWithSAMLRequest.getPolicy()));
        }
        if (assumeRoleWithSAMLRequest.getDurationSeconds() != null) {
            defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(assumeRoleWithSAMLRequest.getDurationSeconds()));
        }
        return defaultRequest;
    }
}
