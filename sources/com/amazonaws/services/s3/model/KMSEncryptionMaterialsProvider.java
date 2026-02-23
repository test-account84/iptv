package com.amazonaws.services.s3.model;

import java.io.Serializable;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class KMSEncryptionMaterialsProvider extends StaticEncryptionMaterialsProvider implements Serializable {
    public KMSEncryptionMaterialsProvider(KMSEncryptionMaterials kMSEncryptionMaterials) {
        super(kMSEncryptionMaterials);
    }

    public KMSEncryptionMaterialsProvider(String str) {
        this(new KMSEncryptionMaterials(str));
    }
}
