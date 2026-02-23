package q7;

import android.content.Context;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b0 extends androidx.fragment.app.r {
    public final ArrayList h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public Context p;
    public final int q;
    public List r;
    public Map s;
    public androidx.fragment.app.m t;

    public b0(List list, ArrayList arrayList, String str, String str2, String str3, String str4, String str5, String str6, String str7, androidx.fragment.app.m mVar, Context context) {
        super(mVar);
        this.t = mVar;
        this.s = new HashMap();
        this.q = list.size();
        this.r = list;
        this.h = arrayList;
        this.i = str;
        this.j = str2;
        this.k = str3;
        this.l = str4;
        this.m = str5;
        this.n = str6;
        this.o = str7;
        this.p = context;
    }

    public int c() {
        return this.q;
    }

    public CharSequence e(int i) {
        return (CharSequence) this.r.get(i);
    }

    public Fragment p(int i) {
        return s7.i.z((String) this.r.get(i), this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }
}
