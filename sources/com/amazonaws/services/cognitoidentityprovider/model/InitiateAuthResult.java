package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InitiateAuthResult implements Serializable {
    private AuthenticationResultType authenticationResult;
    private String challengeName;
    private Map challengeParameters;
    private String session;

    public InitiateAuthResult addChallengeParametersEntry(String str, String str2) {
        if (this.challengeParameters == null) {
            this.challengeParameters = new HashMap();
        }
        if (!this.challengeParameters.containsKey(str)) {
            this.challengeParameters.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public InitiateAuthResult clearChallengeParametersEntries() {
        this.challengeParameters = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InitiateAuthResult)) {
            return false;
        }
        InitiateAuthResult initiateAuthResult = (InitiateAuthResult) obj;
        if ((initiateAuthResult.getChallengeName() == null) ^ (getChallengeName() == null)) {
            return false;
        }
        if (initiateAuthResult.getChallengeName() != null && !initiateAuthResult.getChallengeName().equals(getChallengeName())) {
            return false;
        }
        if ((initiateAuthResult.getSession() == null) ^ (getSession() == null)) {
            return false;
        }
        if (initiateAuthResult.getSession() != null && !initiateAuthResult.getSession().equals(getSession())) {
            return false;
        }
        if ((initiateAuthResult.getChallengeParameters() == null) ^ (getChallengeParameters() == null)) {
            return false;
        }
        if (initiateAuthResult.getChallengeParameters() != null && !initiateAuthResult.getChallengeParameters().equals(getChallengeParameters())) {
            return false;
        }
        if ((initiateAuthResult.getAuthenticationResult() == null) ^ (getAuthenticationResult() == null)) {
            return false;
        }
        return initiateAuthResult.getAuthenticationResult() == null || initiateAuthResult.getAuthenticationResult().equals(getAuthenticationResult());
    }

    public AuthenticationResultType getAuthenticationResult() {
        return this.authenticationResult;
    }

    public String getChallengeName() {
        return this.challengeName;
    }

    public Map getChallengeParameters() {
        return this.challengeParameters;
    }

    public String getSession() {
        return this.session;
    }

    public int hashCode() {
        return (((((((getChallengeName() == null ? 0 : getChallengeName().hashCode()) + 31) * 31) + (getSession() == null ? 0 : getSession().hashCode())) * 31) + (getChallengeParameters() == null ? 0 : getChallengeParameters().hashCode())) * 31) + (getAuthenticationResult() != null ? getAuthenticationResult().hashCode() : 0);
    }

    public void setAuthenticationResult(AuthenticationResultType authenticationResultType) {
        this.authenticationResult = authenticationResultType;
    }

    public void setChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
    }

    public void setChallengeParameters(Map map) {
        this.challengeParameters = map;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getChallengeName() != null) {
            sb.append("ChallengeName: " + getChallengeName() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession() + ",");
        }
        if (getChallengeParameters() != null) {
            sb.append("ChallengeParameters: " + getChallengeParameters() + ",");
        }
        if (getAuthenticationResult() != null) {
            sb.append("AuthenticationResult: " + getAuthenticationResult());
        }
        sb.append("}");
        return sb.toString();
    }

    public InitiateAuthResult withAuthenticationResult(AuthenticationResultType authenticationResultType) {
        this.authenticationResult = authenticationResultType;
        return this;
    }

    public InitiateAuthResult withChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
        return this;
    }

    public InitiateAuthResult withChallengeParameters(Map map) {
        this.challengeParameters = map;
        return this;
    }

    public InitiateAuthResult withSession(String str) {
        this.session = str;
        return this;
    }

    public void setChallengeName(String str) {
        this.challengeName = str;
    }

    public InitiateAuthResult withChallengeName(String str) {
        this.challengeName = str;
        return this;
    }
}
