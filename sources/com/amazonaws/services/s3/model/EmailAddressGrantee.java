package com.amazonaws.services.s3.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EmailAddressGrantee implements Grantee {
    private String emailAddress = null;

    public EmailAddressGrantee(String str) {
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.emailAddress;
        String str2 = ((EmailAddressGrantee) obj).emailAddress;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public String getIdentifier() {
        return this.emailAddress;
    }

    public String getTypeIdentifier() {
        return "emailAddress";
    }

    public int hashCode() {
        String str = this.emailAddress;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setIdentifier(String str) {
        this.emailAddress = str;
    }

    public String toString() {
        return this.emailAddress;
    }
}
