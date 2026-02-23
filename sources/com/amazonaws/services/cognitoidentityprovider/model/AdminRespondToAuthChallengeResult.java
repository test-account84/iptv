package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminRespondToAuthChallengeResult implements Serializable {
    private AuthenticationResultType authenticationResult;
    private String challengeName;
    private Map challengeParameters;
    private String session;

    public AdminRespondToAuthChallengeResult addChallengeParametersEntry(String str, String str2) {
        if (this.challengeParameters == null) {
            this.challengeParameters = new HashMap();
        }
        if (!this.challengeParameters.containsKey(str)) {
            this.challengeParameters.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminRespondToAuthChallengeResult clearChallengeParametersEntries() {
        this.challengeParameters = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminRespondToAuthChallengeResult)) {
            return false;
        }
        AdminRespondToAuthChallengeResult adminRespondToAuthChallengeResult = (AdminRespondToAuthChallengeResult) obj;
        if ((adminRespondToAuthChallengeResult.getChallengeName() == null) ^ (getChallengeName() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeResult.getChallengeName() != null && !adminRespondToAuthChallengeResult.getChallengeName().equals(getChallengeName())) {
            return false;
        }
        if ((adminRespondToAuthChallengeResult.getSession() == null) ^ (getSession() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeResult.getSession() != null && !adminRespondToAuthChallengeResult.getSession().equals(getSession())) {
            return false;
        }
        if ((adminRespondToAuthChallengeResult.getChallengeParameters() == null) ^ (getChallengeParameters() == null)) {
            return false;
        }
        if (adminRespondToAuthChallengeResult.getChallengeParameters() != null && !adminRespondToAuthChallengeResult.getChallengeParameters().equals(getChallengeParameters())) {
            return false;
        }
        if ((adminRespondToAuthChallengeResult.getAuthenticationResult() == null) ^ (getAuthenticationResult() == null)) {
            return false;
        }
        return adminRespondToAuthChallengeResult.getAuthenticationResult() == null || adminRespondToAuthChallengeResult.getAuthenticationResult().equals(getAuthenticationResult());
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

    public AdminRespondToAuthChallengeResult withAuthenticationResult(AuthenticationResultType authenticationResultType) {
        this.authenticationResult = authenticationResultType;
        return this;
    }

    public AdminRespondToAuthChallengeResult withChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
        return this;
    }

    public AdminRespondToAuthChallengeResult withChallengeParameters(Map map) {
        this.challengeParameters = map;
        return this;
    }

    public AdminRespondToAuthChallengeResult withSession(String str) {
        this.session = str;
        return this;
    }

    public void setChallengeName(String str) {
        this.challengeName = str;
    }

    public AdminRespondToAuthChallengeResult withChallengeName(String str) {
        this.challengeName = str;
        return this;
    }
}
