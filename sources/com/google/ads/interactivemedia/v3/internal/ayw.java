package com.google.ads.interactivemedia.v3.internal;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ayw implements ayv {
    public static final ayw a;
    private static final Set b;
    private static final /* synthetic */ ayw[] c;

    static {
        ayw aywVar = new ayw();
        a = aywVar;
        c = new ayw[]{aywVar};
        b = new CopyOnWriteArraySet();
    }

    private ayw() {
    }

    public static ayw[] values() {
        return (ayw[]) c.clone();
    }

    public final void a(Class cls) {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            if (cls.equals(((WeakReference) it.next()).get())) {
                return;
            }
        }
        ayy.c(cls);
        Set set = b;
        if (set.size() > 1000) {
            set.clear();
        }
        set.add(new WeakReference(cls));
    }
}
