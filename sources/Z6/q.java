package Z6;

import Y6.v;
import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class q {
    public static final String a = "q";

    public class a implements Comparator {
        public final /* synthetic */ v a;

        public a(v vVar) {
            this.a = vVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(v vVar, v vVar2) {
            return Float.compare(q.this.c(vVar2, this.a), q.this.c(vVar, this.a));
        }
    }

    public List a(List list, v vVar) {
        if (vVar == null) {
            return list;
        }
        Collections.sort(list, new a(vVar));
        return list;
    }

    public v b(List list, v vVar) {
        List a2 = a(list, vVar);
        String str = a;
        Log.i(str, "Viewfinder size: " + vVar);
        Log.i(str, "Preview in order of preference: " + a2);
        return (v) a2.get(0);
    }

    public abstract float c(v vVar, v vVar2);

    public abstract Rect d(v vVar, v vVar2);
}
