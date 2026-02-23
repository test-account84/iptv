package com.amazonaws.services.s3.model;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StaticEncryptionMaterialsProvider implements EncryptionMaterialsProvider {
    private final EncryptionMaterials materials;

    public StaticEncryptionMaterialsProvider(EncryptionMaterials encryptionMaterials) {
        this.materials = encryptionMaterials;
    }

    public EncryptionMaterials getEncryptionMaterials() {
        return this.materials;
    }

    public void refresh() {
    }

    public EncryptionMaterials getEncryptionMaterials(Map map) {
        EncryptionMaterials encryptionMaterials;
        Map materialsDescription = this.materials.getMaterialsDescription();
        if (map != null && map.equals(materialsDescription)) {
            return this.materials;
        }
        EncryptionMaterialsAccessor accessor = this.materials.getAccessor();
        if (accessor != null && (encryptionMaterials = accessor.getEncryptionMaterials(map)) != null) {
            return encryptionMaterials;
        }
        boolean z = true;
        boolean z2 = map == null || map.size() == 0;
        if (materialsDescription != null && materialsDescription.size() != 0) {
            z = false;
        }
        if (z2 && z) {
            return this.materials;
        }
        return null;
    }
}
