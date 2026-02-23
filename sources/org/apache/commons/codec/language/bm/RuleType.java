package org.apache.commons.codec.language.bm;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");

    private final String name;

    RuleType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
