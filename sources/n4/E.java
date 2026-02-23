package n4;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.api.a;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class e {
    public static final com.google.android.gms.common.api.a a;
    public static final b b;
    public static final a.a c;

    public interface a extends com.google.android.gms.common.api.h {
        n4.d A();

        boolean d();

        String f();

        String getSessionId();
    }

    public interface b {
    }

    public static final class c implements a.d {
        public final CastDevice b;
        public final d c;
        public final Bundle d;
        public final int e;
        public final String f = UUID.randomUUID().toString();

        public static final class a {
            public final CastDevice a;
            public final d b;
            public int c;
            public Bundle d;

            public a(CastDevice castDevice, d dVar) {
                com.google.android.gms.common.internal.r.n(castDevice, "CastDevice parameter cannot be null");
                com.google.android.gms.common.internal.r.n(dVar, "CastListener parameter cannot be null");
                this.a = castDevice;
                this.b = dVar;
                this.c = 0;
            }

            public static /* bridge */ /* synthetic */ int b(a aVar) {
                return aVar.c;
            }

            public static /* bridge */ /* synthetic */ Bundle c(a aVar) {
                return aVar.d;
            }

            public c a() {
                return new c(this, null);
            }

            public final a d(Bundle bundle) {
                this.d = bundle;
                return this;
            }
        }

        public /* synthetic */ c(a aVar, B0 b0) {
            this.b = aVar.a;
            this.c = aVar.b;
            this.e = a.b(aVar);
            this.d = a.c(aVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return com.google.android.gms.common.internal.q.b(this.b, cVar.b) && com.google.android.gms.common.internal.q.a(this.d, cVar.d) && this.e == cVar.e && com.google.android.gms.common.internal.q.b(this.f, cVar.f);
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.q.c(this.b, this.d, Integer.valueOf(this.e), this.f);
        }
    }

    public interface e {
        void a(CastDevice castDevice, String str, String str2);
    }

    static {
        z0 z0Var = new z0();
        c = z0Var;
        a = new com.google.android.gms.common.api.a("Cast.API", z0Var, t4.m.a);
        b = new A0();
    }

    public static D0 a(Context context, c cVar) {
        return new Y(context, cVar);
    }

    public static class d {
        public void onApplicationStatusChanged() {
        }

        public void onDeviceNameChanged() {
        }

        public void onVolumeChanged() {
        }

        public void onActiveInputStateChanged(int i) {
        }

        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(n4.d dVar) {
        }

        public void onStandbyStateChanged(int i) {
        }
    }
}
