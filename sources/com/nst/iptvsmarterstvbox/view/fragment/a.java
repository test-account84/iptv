package com.nst.iptvsmarterstvbox.view.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.C;
import androidx.leanback.widget.D;
import androidx.leanback.widget.E;
import androidx.leanback.widget.J;
import androidx.leanback.widget.M;
import androidx.leanback.widget.SearchBar;
import androidx.leanback.widget.U;
import androidx.leanback.widget.VerticalGridView;
import androidx.leanback.widget.y;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends Fragment {
    public static final String w = "a";
    public static final String x;
    public static final String y;
    public androidx.leanback.app.b g;
    public SearchBar h;
    public i i;
    public D k;
    public C l;
    public y m;
    public String n;
    public Drawable o;
    public h p;
    public SpeechRecognizer q;
    public int r;
    public boolean t;
    public boolean u;
    public final y.b a = new a();
    public final Handler c = new Handler();
    public final Runnable d = new b();
    public final Runnable e = new c();
    public final Runnable f = new d();
    public String j = null;
    public boolean s = true;
    public SearchBar.l v = new e();

    public class a extends y.b {
        public a() {
        }

        public void a() {
            a aVar = a.this;
            aVar.c.removeCallbacks(aVar.d);
            a aVar2 = a.this;
            aVar2.c.post(aVar2.d);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            androidx.leanback.app.b bVar = a.this.g;
            if (bVar != null) {
                y z = bVar.z();
                a aVar = a.this;
                if (z != aVar.m && (aVar.g.z() != null || a.this.m.i() != 0)) {
                    a aVar2 = a.this;
                    aVar2.g.P(aVar2.m);
                    a.this.g.T(0);
                }
            }
            a.this.l0();
            a aVar3 = a.this;
            int i = aVar3.r | 1;
            aVar3.r = i;
            if ((i & 2) != 0) {
                aVar3.j0();
            }
            a.this.k0();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            y yVar;
            a aVar = a.this;
            if (aVar.g == null) {
                return;
            }
            y n = aVar.i.n();
            a aVar2 = a.this;
            y yVar2 = aVar2.m;
            if (n != yVar2) {
                boolean z = yVar2 == null;
                aVar2.J();
                a aVar3 = a.this;
                aVar3.m = n;
                if (n != null) {
                    n.g(aVar3.a);
                }
                if (!z || ((yVar = a.this.m) != null && yVar.i() != 0)) {
                    a aVar4 = a.this;
                    aVar4.g.P(aVar4.m);
                }
                a.this.z();
            }
            a.this.k0();
            a aVar5 = a.this;
            if (!aVar5.s) {
                aVar5.j0();
                return;
            }
            aVar5.c.removeCallbacks(aVar5.f);
            a aVar6 = a.this;
            aVar6.c.postDelayed(aVar6.f, 300L);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            a aVar = a.this;
            aVar.s = false;
            aVar.h.i();
        }
    }

    public class e implements SearchBar.l {
        public e() {
        }

        public void a() {
            a.this.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 0);
        }
    }

    public class f implements SearchBar.k {
        public f() {
        }

        public void a(String str) {
            a aVar = a.this;
            if (aVar.i != null) {
                aVar.P(str);
            } else {
                aVar.j = str;
            }
        }

        public void b(String str) {
            a.this.D();
        }

        public void c(String str) {
            a.this.i0(str);
        }
    }

    public class g implements D {
        public g() {
        }

        public /* bridge */ /* synthetic */ void a(E.a aVar, Object obj, M.b bVar, Object obj2) {
            d.D.a(obj2);
            b(aVar, obj, bVar, null);
        }

        public void b(E.a aVar, Object obj, M.b bVar, J j) {
            a.this.l0();
            D d = a.this.k;
            if (d != null) {
                d.a(aVar, obj, bVar, j);
            }
        }
    }

    public static class h {
        public String a;
        public boolean b;

        public h(String str, boolean z) {
            this.a = str;
            this.b = z;
        }
    }

    public interface i {
        y n();

        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    static {
        String canonicalName = a.class.getCanonicalName();
        x = canonicalName + ".query";
        y = canonicalName + ".title";
    }

    public final void A() {
        androidx.leanback.app.b bVar = this.g;
        if (bVar == null || bVar.E() == null || this.m.i() == 0 || !this.g.E().requestFocus()) {
            return;
        }
        this.r &= -2;
    }

    public final void B() {
        this.c.removeCallbacks(this.e);
        this.c.post(this.e);
    }

    public void D() {
        this.r |= 2;
        A();
    }

    public final void E(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String str = x;
        if (bundle.containsKey(str)) {
            X(bundle.getString(str));
        }
        String str2 = y;
        if (bundle.containsKey(str2)) {
            b0(bundle.getString(str2));
        }
    }

    public void J() {
        y yVar = this.m;
        if (yVar != null) {
            yVar.j(this.a);
            this.m = null;
        }
    }

    public final void L() {
        try {
            if (this.q != null) {
                this.h.setSpeechRecognizer((SpeechRecognizer) null);
                this.q.destroy();
                this.q = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e(w, e2.getMessage());
        }
    }

    public void P(String str) {
        if (this.i.onQueryTextChange(str)) {
            this.r &= -3;
        }
    }

    public void S(Drawable drawable) {
        this.o = drawable;
        SearchBar searchBar = this.h;
        if (searchBar != null) {
            searchBar.setBadgeDrawable(drawable);
        }
    }

    public void T(C c2) {
        if (c2 != this.l) {
            this.l = c2;
            androidx.leanback.app.b bVar = this.g;
            if (bVar != null) {
                bVar.i0(c2);
            }
        }
    }

    public void W(Intent intent, boolean z) {
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            return;
        }
        Y((String) stringArrayListExtra.get(0), z);
    }

    public final void X(String str) {
        this.h.setSearchQuery(str);
    }

    public void Y(String str, boolean z) {
        if (str == null) {
            return;
        }
        this.p = new h(str, z);
        x();
        if (this.s) {
            this.s = false;
            this.c.removeCallbacks(this.f);
        }
    }

    public void Z(i iVar) {
        if (this.i != iVar) {
            this.i = iVar;
            B();
        }
    }

    public void b0(String str) {
        this.n = str;
        SearchBar searchBar = this.h;
        if (searchBar != null) {
            searchBar.setTitle(str);
        }
    }

    public void c0() {
        if (this.t) {
            this.u = true;
        } else {
            this.h.i();
        }
    }

    public void i0(String str) {
        D();
        i iVar = this.i;
        if (iVar != null) {
            iVar.onQueryTextSubmit(str);
        }
    }

    public void j0() {
        androidx.leanback.app.b bVar;
        y yVar = this.m;
        if (yVar == null || yVar.i() <= 0 || (bVar = this.g) == null || bVar.z() != this.m) {
            this.h.requestFocus();
        } else {
            A();
        }
    }

    public void k0() {
        y yVar;
        androidx.leanback.app.b bVar;
        if (this.h == null || (yVar = this.m) == null) {
            return;
        }
        this.h.setNextFocusDownId((yVar.i() == 0 || (bVar = this.g) == null || bVar.E() == null) ? 0 : this.g.E().getId());
    }

    public void l0() {
        y yVar;
        androidx.leanback.app.b bVar = this.g;
        this.h.setVisibility(((bVar != null ? bVar.D() : -1) <= 0 || (yVar = this.m) == null || yVar.i() == 0) ? 0 : 8);
    }

    public void onCreate(Bundle bundle) {
        if (this.s) {
            this.s = bundle == null;
        }
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a7.g.s3, viewGroup, false);
        SearchBar findViewById = inflate.findViewById(a7.f.A6).findViewById(a7.f.z6);
        this.h = findViewById;
        findViewById.setSearchBarListener(new f());
        this.h.setSpeechRecognitionCallback((U) null);
        this.h.setPermissionListener(this.v);
        x();
        E(getArguments());
        Drawable drawable = this.o;
        if (drawable != null) {
            S(drawable);
        }
        String str = this.n;
        if (str != null) {
            b0(str);
        }
        if (getChildFragmentManager().g0(a7.f.y6) == null) {
            this.g = new androidx.leanback.app.b();
            getChildFragmentManager().m().q(a7.f.y6, this.g).i();
        } else {
            this.g = getChildFragmentManager().g0(a7.f.y6);
        }
        this.g.j0(new g());
        this.g.i0(this.l);
        this.g.c0(true);
        if (this.i != null) {
            B();
        }
        return inflate;
    }

    public void onDestroy() {
        J();
        super.onDestroy();
    }

    public void onPause() {
        L();
        this.t = true;
        super.onPause();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 0 && strArr.length > 0 && strArr[0].equals("android.permission.RECORD_AUDIO") && iArr[0] == 0) {
            c0();
        }
    }

    public void onResume() {
        super.onResume();
        this.t = false;
        if (this.q == null) {
            SpeechRecognizer createSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getContext());
            this.q = createSpeechRecognizer;
            this.h.setSpeechRecognizer(createSpeechRecognizer);
        }
        if (!this.u) {
            this.h.j();
        } else {
            this.u = false;
            this.h.i();
        }
    }

    public void onStart() {
        super.onStart();
        VerticalGridView E = this.g.E();
        int dimensionPixelSize = getResources().getDimensionPixelSize(a7.d.m);
        E.setItemAlignmentOffset(0);
        E.setItemAlignmentOffsetPercent(-1.0f);
        E.setWindowAlignmentOffset(dimensionPixelSize);
        E.setWindowAlignmentOffsetPercent(-1.0f);
        E.setWindowAlignment(0);
        E.setFocusable(false);
        E.setFocusableInTouchMode(false);
    }

    public final void x() {
        SearchBar searchBar;
        h hVar = this.p;
        if (hVar == null || (searchBar = this.h) == null) {
            return;
        }
        searchBar.setSearchQuery(hVar.a);
        h hVar2 = this.p;
        if (hVar2.b) {
            i0(hVar2.a);
        }
        this.p = null;
    }

    public void z() {
        String str = this.j;
        if (str == null || this.m == null) {
            return;
        }
        this.j = null;
        P(str);
    }
}
