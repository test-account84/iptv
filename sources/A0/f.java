package a0;

import androidx.datastore.preferences.protobuf.H;
import androidx.datastore.preferences.protobuf.I;
import androidx.datastore.preferences.protobuf.P;
import androidx.datastore.preferences.protobuf.X;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.w;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class f extends w implements P {
    private static final f DEFAULT_INSTANCE;
    private static volatile X PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private I preferences_ = I.f();

    public static final class a extends w.a implements P {
        public a() {
            super(f.H());
        }

        public a u(String str, h hVar) {
            str.getClass();
            hVar.getClass();
            o();
            f.I((f) this.c).put(str, hVar);
            return this;
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public static final class b {
        public static final H a = H.d(r0.b.STRING, "", r0.b.MESSAGE, h.Q());
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        w.F(f.class, fVar);
    }

    public static /* synthetic */ f H() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ Map I(f fVar) {
        return fVar.J();
    }

    public static a N() {
        return (a) DEFAULT_INSTANCE.o();
    }

    public static f O(InputStream inputStream) {
        return (f) w.D(DEFAULT_INSTANCE, inputStream);
    }

    public final Map J() {
        return L();
    }

    public Map K() {
        return Collections.unmodifiableMap(M());
    }

    public final I L() {
        if (!this.preferences_.j()) {
            this.preferences_ = this.preferences_.n();
        }
        return this.preferences_;
    }

    public final I M() {
        return this.preferences_;
    }

    public final Object s(w.d dVar, Object obj, Object obj2) {
        switch (e.a[dVar.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return new a(null);
            case 3:
                return w.C(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                X x = PARSER;
                if (x == null) {
                    synchronized (f.class) {
                        try {
                            x = PARSER;
                            if (x == null) {
                                x = new w.b(DEFAULT_INSTANCE);
                                PARSER = x;
                            }
                        } finally {
                        }
                    }
                }
                return x;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
