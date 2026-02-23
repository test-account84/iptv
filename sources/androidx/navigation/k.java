package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class k {
    public static final HashMap j = new HashMap();
    public final String a;
    public l c;
    public int d;
    public String e;
    public CharSequence f;
    public ArrayList g;
    public s.j h;
    public HashMap i;

    public static class a implements Comparable {
        public final k a;
        public final Bundle c;
        public final boolean d;
        public final boolean e;
        public final int f;

        public a(k kVar, Bundle bundle, boolean z, boolean z2, int i) {
            this.a = kVar;
            this.c = bundle;
            this.d = z;
            this.e = z2;
            this.f = i;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            boolean z = this.d;
            if (z && !aVar.d) {
                return 1;
            }
            if (!z && aVar.d) {
                return -1;
            }
            Bundle bundle = this.c;
            if (bundle != null && aVar.c == null) {
                return 1;
            }
            if (bundle == null && aVar.c != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - aVar.c.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z2 = this.e;
            if (z2 && !aVar.e) {
                return 1;
            }
            if (z2 || !aVar.e) {
                return this.f - aVar.f;
            }
            return -1;
        }

        public k b() {
            return this.a;
        }

        public Bundle h() {
            return this.c;
        }
    }

    public k(s sVar) {
        this(t.c(sVar.getClass()));
    }

    public static String h(Context context, int i) {
        if (i <= 16777215) {
            return Integer.toString(i);
        }
        try {
            return context.getResources().getResourceName(i);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i);
        }
    }

    public final void a(String str, d dVar) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.i.put(str, dVar);
    }

    public final void b(h hVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(hVar);
    }

    public Bundle c(Bundle bundle) {
        HashMap hashMap;
        if (bundle == null && ((hashMap = this.i) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap hashMap2 = this.i;
        if (hashMap2 != null) {
            for (Map.Entry entry : hashMap2.entrySet()) {
                ((d) entry.getValue()).c((String) entry.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap hashMap3 = this.i;
            if (hashMap3 != null) {
                for (Map.Entry entry2 : hashMap3.entrySet()) {
                    if (!((d) entry2.getValue()).d((String) entry2.getKey(), bundle)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + ((String) entry2.getKey()) + "' in argument bundle. " + ((d) entry2.getValue()).a().c() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    public int[] d() {
        ArrayDeque arrayDeque = new ArrayDeque();
        k kVar = this;
        while (true) {
            l n = kVar.n();
            if (n == null || n.E() != kVar.i()) {
                arrayDeque.addFirst(kVar);
            }
            if (n == null) {
                break;
            }
            kVar = n;
        }
        int[] iArr = new int[arrayDeque.size()];
        Iterator it = arrayDeque.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((k) it.next()).i();
            i++;
        }
        return iArr;
    }

    public final c e(int i) {
        s.j jVar = this.h;
        c cVar = jVar == null ? null : (c) jVar.g(i);
        if (cVar != null) {
            return cVar;
        }
        if (n() != null) {
            return n().e(i);
        }
        return null;
    }

    public final Map f() {
        HashMap hashMap = this.i;
        return hashMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(hashMap);
    }

    public String g() {
        if (this.e == null) {
            this.e = Integer.toString(this.d);
        }
        return this.e;
    }

    public final int i() {
        return this.d;
    }

    public final CharSequence j() {
        return this.f;
    }

    public final String l() {
        return this.a;
    }

    public final l n() {
        return this.c;
    }

    public a o(j jVar) {
        ArrayList arrayList = this.g;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        a aVar = null;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            Uri c = jVar.c();
            Bundle c2 = c != null ? hVar.c(c, f()) : null;
            String a2 = jVar.a();
            boolean z = a2 != null && a2.equals(hVar.b());
            String b = jVar.b();
            int d = b != null ? hVar.d(b) : -1;
            if (c2 != null || z || d > -1) {
                a aVar2 = new a(this, c2, hVar.e(), z, d);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    public void p(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, w0.a.A);
        r(obtainAttributes.getResourceId(w0.a.C, 0));
        this.e = h(context, this.d);
        s(obtainAttributes.getText(w0.a.B));
        obtainAttributes.recycle();
    }

    public final void q(int i, c cVar) {
        if (y()) {
            if (i == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            if (this.h == null) {
                this.h = new s.j();
            }
            this.h.k(i, cVar);
            return;
        }
        throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    public final void r(int i) {
        this.d = i;
        this.e = null;
    }

    public final void s(CharSequence charSequence) {
        this.f = charSequence;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.e;
        if (str == null) {
            sb.append("0x");
            str = Integer.toHexString(this.d);
        }
        sb.append(str);
        sb.append(")");
        if (this.f != null) {
            sb.append(" label=");
            sb.append(this.f);
        }
        return sb.toString();
    }

    public final void u(l lVar) {
        this.c = lVar;
    }

    public boolean y() {
        return true;
    }

    public k(String str) {
        this.a = str;
    }
}
