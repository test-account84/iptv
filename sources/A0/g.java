package a0;

import androidx.datastore.preferences.protobuf.P;
import androidx.datastore.preferences.protobuf.X;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.y;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class g extends w implements P {
    private static final g DEFAULT_INSTANCE;
    private static volatile X PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private y.b strings_ = w.t();

    public static final class a extends w.a implements P {
        public a() {
            super(g.H());
        }

        public a u(Iterable iterable) {
            o();
            g.I((g) this.c, iterable);
            return this;
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        w.F(g.class, gVar);
    }

    public static /* synthetic */ g H() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void I(g gVar, Iterable iterable) {
        gVar.J(iterable);
    }

    public static g L() {
        return DEFAULT_INSTANCE;
    }

    public static a N() {
        return (a) DEFAULT_INSTANCE.o();
    }

    public final void J(Iterable iterable) {
        K();
        androidx.datastore.preferences.protobuf.a.c(iterable, this.strings_);
    }

    public final void K() {
        if (this.strings_.t()) {
            return;
        }
        this.strings_ = w.A(this.strings_);
    }

    public List M() {
        return this.strings_;
    }

    public final Object s(w.d dVar, Object obj, Object obj2) {
        switch (e.a[dVar.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new a(null);
            case 3:
                return w.C(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                X x = PARSER;
                if (x == null) {
                    synchronized (g.class) {
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
