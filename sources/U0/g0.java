package u0;

import android.os.Build;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g0 {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Bundle e;

    public static final class a {
        public int a = 1;
        public boolean b;
        public boolean c;
        public boolean d;
        public Bundle e;

        public a() {
            this.b = Build.VERSION.SDK_INT >= 30;
        }

        public g0 a() {
            return new g0(this);
        }

        public a b(boolean z) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.b = z;
            }
            return this;
        }

        public a c(boolean z) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.c = z;
            }
            return this;
        }

        public a d(boolean z) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.d = z;
            }
            return this;
        }
    }

    public g0(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        Bundle bundle = aVar.e;
        this.e = bundle == null ? Bundle.EMPTY : new Bundle(bundle);
    }

    public int a() {
        return this.a;
    }

    public Bundle b() {
        return this.e;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }
}
