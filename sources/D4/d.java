package d4;

import O2.n;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class d {
    public static HashMap a(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle == Bundle.EMPTY) {
            return hashMap;
        }
        for (String str : bundle.keySet()) {
            String string = bundle.getString(str);
            if (string != null) {
                hashMap.put(str, string);
            }
        }
        return hashMap;
    }

    public static s5.A b(Bundle bundle) {
        return bundle == Bundle.EMPTY ? s5.A.k() : s5.A.d(a(bundle));
    }

    public static void c(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) k0.j(d.class.getClassLoader()));
        }
    }

    public static s5.y d(n.a aVar, List list) {
        y.a p = s5.y.p();
        for (int i = 0; i < list.size(); i++) {
            p.h(aVar.a((Bundle) a.e((Bundle) list.get(i))));
        }
        return p.k();
    }

    public static SparseArray e(n.a aVar, SparseArray sparseArray) {
        SparseArray sparseArray2 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), aVar.a((Bundle) sparseArray.valueAt(i)));
        }
        return sparseArray2;
    }

    public static Bundle f(Bundle bundle, String str, Bundle bundle2) {
        Bundle bundle3 = bundle.getBundle(str);
        return bundle3 != null ? bundle3 : bundle2;
    }

    public static ArrayList g(Bundle bundle, String str, ArrayList arrayList) {
        ArrayList integerArrayList = bundle.getIntegerArrayList(str);
        return integerArrayList != null ? integerArrayList : arrayList;
    }

    public static Bundle h(Map map) {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return bundle;
    }

    public static ArrayList i(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((O2.n) it.next()).h());
        }
        return arrayList;
    }

    public static SparseArray j(SparseArray sparseArray) {
        SparseArray sparseArray2 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), ((O2.n) sparseArray.valueAt(i)).h());
        }
        return sparseArray2;
    }
}
