package org.apache.http.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.util.Args;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RegistryBuilder {
    private final Map items = new HashMap();

    public static RegistryBuilder create() {
        return new RegistryBuilder();
    }

    public Registry build() {
        return new Registry(this.items);
    }

    public RegistryBuilder register(String str, Object obj) {
        Args.notEmpty((CharSequence) str, "ID");
        Args.notNull(obj, "Item");
        this.items.put(str.toLowerCase(Locale.ROOT), obj);
        return this;
    }

    public String toString() {
        return this.items.toString();
    }
}
