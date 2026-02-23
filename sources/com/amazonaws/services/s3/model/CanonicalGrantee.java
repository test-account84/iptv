package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CanonicalGrantee implements Grantee, Serializable {
    private String id = null;
    private String displayName = null;

    public CanonicalGrantee(String str) {
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CanonicalGrantee) {
            return this.id.equals(((CanonicalGrantee) obj).id);
        }
        return false;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getIdentifier() {
        return this.id;
    }

    public String getTypeIdentifier() {
        return "id";
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setIdentifier(String str) {
        this.id = str;
    }
}
