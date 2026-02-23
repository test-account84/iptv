package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class atn implements Serializable, atm {
    private static final long serialVersionUID = 0;
    private final List a;

    public /* synthetic */ atn(List list) {
        this.a = list;
    }

    public final boolean a(Object obj) {
        for (int i = 0; i < this.a.size(); i++) {
            if (!((atm) this.a.get(i)).a(obj)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof atn) {
            return this.a.equals(((atn) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + 306654252;
    }

    public final String toString() {
        List list = this.a;
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append("and");
        sb.append('(');
        boolean z = true;
        for (Object obj : list) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
