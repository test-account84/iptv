package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k0 extends RuntimeException {
    public final List a;

    public k0(O o) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }

    public z a() {
        return new z(getMessage());
    }
}
