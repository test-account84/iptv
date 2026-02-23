package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.security.KeyPair;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class KMSEncryptionMaterials extends EncryptionMaterials implements Serializable {
    public static final String CUSTOMER_MASTER_KEY_ID = "kms_cmk_id";

    public KMSEncryptionMaterials(String str) {
        super(null, null);
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The default customer master key id must be specified");
        }
        addDescription("kms_cmk_id", str);
    }

    public String getCustomerMasterKeyId() {
        return getDescription("kms_cmk_id");
    }

    public final KeyPair getKeyPair() {
        throw new UnsupportedOperationException();
    }

    public final SecretKey getSymmetricKey() {
        throw new UnsupportedOperationException();
    }

    public final boolean isKMSEnabled() {
        return true;
    }

    public String toString() {
        return String.valueOf(getMaterialsDescription());
    }
}
