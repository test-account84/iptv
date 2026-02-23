package com.nytimes.android.external.cache;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class p {
    private static final /* synthetic */ p[] $VALUES;
    public static final p COLLECTED;
    public static final p EXPIRED;
    public static final p EXPLICIT;
    public static final p REPLACED;
    public static final p SIZE;

    public enum a extends p {
        public a(String str, int i) {
            super(str, i, null);
        }

        public boolean wasEvicted() {
            return false;
        }
    }

    public enum b extends p {
        public b(String str, int i) {
            super(str, i, null);
        }

        public boolean wasEvicted() {
            return false;
        }
    }

    public enum c extends p {
        public c(String str, int i) {
            super(str, i, null);
        }

        public boolean wasEvicted() {
            return true;
        }
    }

    public enum d extends p {
        public d(String str, int i) {
            super(str, i, null);
        }

        public boolean wasEvicted() {
            return true;
        }
    }

    public enum e extends p {
        public e(String str, int i) {
            super(str, i, null);
        }

        public boolean wasEvicted() {
            return true;
        }
    }

    static {
        a aVar = new a("EXPLICIT", 0);
        EXPLICIT = aVar;
        b bVar = new b("REPLACED", 1);
        REPLACED = bVar;
        c cVar = new c("COLLECTED", 2);
        COLLECTED = cVar;
        d dVar = new d("EXPIRED", 3);
        EXPIRED = dVar;
        e eVar = new e("SIZE", 4);
        SIZE = eVar;
        $VALUES = new p[]{aVar, bVar, cVar, dVar, eVar};
    }

    private p(String str, int i) {
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) $VALUES.clone();
    }

    public abstract boolean wasEvicted();

    public /* synthetic */ p(String str, int i, a aVar) {
        this(str, i);
    }
}
