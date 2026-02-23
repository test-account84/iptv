package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthenticationDetails {
    private Map authenticationParameters;
    private String authenticationType;
    private String password;
    private final String userId;
    private List validationData;

    public AuthenticationDetails(String str, String str2, Map map) {
        this.authenticationType = "PASSWORD_VERIFIER";
        this.userId = str;
        this.password = str2;
        setValidationData(map);
    }

    private void setValidationData(Map map) {
        if (map == null) {
            this.validationData = null;
            return;
        }
        this.validationData = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            AttributeType attributeType = new AttributeType();
            attributeType.setName((String) entry.getKey());
            attributeType.setValue((String) entry.getValue());
            this.validationData.add(attributeType);
        }
    }

    public Map getAuthenticationParameters() {
        return this.authenticationParameters;
    }

    public String getAuthenticationType() {
        return this.authenticationType;
    }

    public String getCustomChallenge() {
        return (String) this.authenticationParameters.get("CHALLENGE_NAME");
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserId() {
        return this.userId;
    }

    public List getValidationData() {
        return this.validationData;
    }

    public void setAuthenticationParameter(String str, String str2) {
        if (str == null) {
            throw new CognitoParameterInvalidException("A null key was used to add a new authentications parameter.");
        }
        if (this.authenticationParameters == null) {
            this.authenticationParameters = new HashMap();
        }
        this.authenticationParameters.put(str, str2);
    }

    public void setAuthenticationParameters(Map map) {
        this.authenticationParameters = map;
    }

    public void setAuthenticationType(String str) {
        this.authenticationType = str;
        if ("PASSWORD_VERIFIER".equals(str) || "USER_PASSWORD".equals(this.authenticationType)) {
            this.authenticationParameters = null;
        } else if ("CUSTOM_CHALLENGE".equals(this.authenticationType)) {
            this.password = null;
        }
    }

    public void setCustomChallenge(String str) {
        if ("PASSWORD_VERIFIER".equals(this.authenticationType) || "USER_PASSWORD".equals(this.authenticationType)) {
            throw new CognitoParameterInvalidException(String.format("Cannot set custom challenge when the authentication type is %s.", new Object[]{this.authenticationType}));
        }
        this.authenticationType = "CUSTOM_CHALLENGE";
        setAuthenticationParameter("CHALLENGE_NAME", str);
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public AuthenticationDetails(String str, String str2, Map map, Map map2) {
        this.userId = str;
        this.password = str2;
        if (map == null) {
            this.authenticationType = null;
            return;
        }
        this.authenticationType = "CUSTOM_CHALLENGE";
        this.authenticationParameters = map;
        setAuthenticationParameter("USERNAME", str);
        setCustomChallenge("SRP_A");
        setValidationData(map2);
    }

    public AuthenticationDetails(String str, Map map, Map map2) {
        this.userId = str;
        if (map == null) {
            this.authenticationType = null;
            return;
        }
        this.authenticationType = "CUSTOM_CHALLENGE";
        this.authenticationParameters = map;
        setAuthenticationParameter("USERNAME", str);
        setValidationData(map2);
    }
}
