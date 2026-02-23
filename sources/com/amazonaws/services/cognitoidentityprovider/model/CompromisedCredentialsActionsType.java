package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CompromisedCredentialsActionsType implements Serializable {
    private String eventAction;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CompromisedCredentialsActionsType)) {
            return false;
        }
        CompromisedCredentialsActionsType compromisedCredentialsActionsType = (CompromisedCredentialsActionsType) obj;
        if ((compromisedCredentialsActionsType.getEventAction() == null) ^ (getEventAction() == null)) {
            return false;
        }
        return compromisedCredentialsActionsType.getEventAction() == null || compromisedCredentialsActionsType.getEventAction().equals(getEventAction());
    }

    public String getEventAction() {
        return this.eventAction;
    }

    public int hashCode() {
        return 31 + (getEventAction() == null ? 0 : getEventAction().hashCode());
    }

    public void setEventAction(CompromisedCredentialsEventActionType compromisedCredentialsEventActionType) {
        this.eventAction = compromisedCredentialsEventActionType.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEventAction() != null) {
            sb.append("EventAction: " + getEventAction());
        }
        sb.append("}");
        return sb.toString();
    }

    public CompromisedCredentialsActionsType withEventAction(CompromisedCredentialsEventActionType compromisedCredentialsEventActionType) {
        this.eventAction = compromisedCredentialsEventActionType.toString();
        return this;
    }

    public void setEventAction(String str) {
        this.eventAction = str;
    }

    public CompromisedCredentialsActionsType withEventAction(String str) {
        this.eventAction = str;
        return this;
    }
}
