package Q0;

import Q0.v;
import android.os.Build;
import androidx.work.OverwritingInputMerger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class m extends v {
    public m(a aVar) {
        super(aVar.b, aVar.c, aVar.d);
    }

    public static m d(Class cls) {
        return (m) new a(cls).b();
    }

    public static final class a extends v.a {
        public a(Class cls) {
            super(cls);
            this.c.d = OverwritingInputMerger.class.getName();
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public m c() {
            if (this.a && Build.VERSION.SDK_INT >= 23 && this.c.j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new m(this);
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }
    }
}
