package b;

import B8.h;
import android.content.Context;
import android.content.Intent;
import b.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import k8.i;
import k8.m;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import l8.A;
import l8.B;
import l8.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b extends b.a {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public final Intent a(String[] strArr) {
            l.e(strArr, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            l.d(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        l.e(context, "context");
        l.e(strArr, "input");
        return a.a(strArr);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a.a b(Context context, String[] strArr) {
        l.e(context, "context");
        l.e(strArr, "input");
        if (strArr.length == 0) {
            return new a.a(B.d());
        }
        for (String str : strArr) {
            if (E.b.checkSelfPermission(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.c(A.a(strArr.length), 16));
        for (String str2 : strArr) {
            i a2 = m.a(str2, Boolean.TRUE);
            linkedHashMap.put(a2.c(), a2.d());
        }
        return new a.a(linkedHashMap);
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i, Intent intent) {
        if (i != -1) {
            return B.d();
        }
        if (intent == null) {
            return B.d();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return B.d();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i2 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i2 == 0));
        }
        return B.j(s.Q(l8.h.o(stringArrayExtra), arrayList));
    }
}
