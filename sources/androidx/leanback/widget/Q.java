package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class q {
    public int a = 0;
    public final a b;
    public final a c;
    public a d;
    public a e;

    public static final class a extends r.a {
        public int g;

        public a(int i) {
            this.g = i;
        }

        public int i(View view) {
            return s.a(view, this, this.g);
        }
    }

    public q() {
        a aVar = new a(1);
        this.b = aVar;
        a aVar2 = new a(0);
        this.c = aVar2;
        this.d = aVar2;
        this.e = aVar;
    }

    public final a a() {
        return this.d;
    }

    public final void b(int i) {
        a aVar;
        this.a = i;
        if (i == 0) {
            this.d = this.c;
            aVar = this.b;
        } else {
            this.d = this.b;
            aVar = this.c;
        }
        this.e = aVar;
    }
}
