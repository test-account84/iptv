package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NewPasswordContinuation extends ChallengeContinuation {
    private final AuthenticationHandler callback;
    private Map currentUserAttributes;
    private List requiredAttributes;

    public NewPasswordContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        super(cognitoUser, context, str, str2, str3, respondToAuthChallengeResult, z, authenticationHandler);
        this.callback = authenticationHandler;
        parseUserAttributes((String) getParameters().get("userAttributes"));
        parseRequiredAttributes((String) getParameters().get("requiredAttributes"));
    }

    private void parseRequiredAttributes(String str) {
        this.requiredAttributes = new ArrayList();
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.requiredAttributes.add(jSONArray.getString(i).split("userAttributes.", 2)[1]);
                }
            } catch (Exception e) {
                this.callback.onFailure(e);
            }
        }
    }

    private void parseUserAttributes(String str) {
        this.currentUserAttributes = new HashMap();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    this.currentUserAttributes.put(str2, jSONObject.getString(str2));
                }
            } catch (Exception e) {
                this.callback.onFailure(e);
            }
        }
    }

    public void continueTask() {
        List list = this.requiredAttributes;
        if (list != null && list.size() > 1) {
            for (String str : this.requiredAttributes) {
                if (!this.challengeResponses.containsKey("userAttributes." + str)) {
                    throw new CognitoParameterInvalidException(String.format("Missing required attribute: %s", new Object[]{str}));
                }
            }
        }
        if (!this.challengeResponses.containsKey("NEW_PASSWORD") || this.challengeResponses.get("NEW_PASSWORD") == null) {
            throw new CognitoParameterInvalidException("New password was not set");
        }
        super.continueTask();
    }

    public Map getCurrentUserAttributes() {
        return this.currentUserAttributes;
    }

    public List getRequiredAttributes() {
        return this.requiredAttributes;
    }

    public void setPassword(String str) {
        if (str != null) {
            setChallengeResponse("NEW_PASSWORD", str);
        }
    }

    public void setUserAttribute(String str, String str2) {
        setChallengeResponse("userAttributes." + str, str2);
    }
}
