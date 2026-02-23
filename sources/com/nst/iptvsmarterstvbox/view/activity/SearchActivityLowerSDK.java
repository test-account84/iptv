package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.SeriesAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import java.util.ArrayList;
import q7.S;
import q7.Z;
import q7.m0;
import q7.q;
import q7.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SearchActivityLowerSDK extends Activity implements View.OnClickListener {
    public static u7.a C;
    public Context A;
    public final int B = 1;
    public RecyclerView a;
    public RecyclerView c;
    public RecyclerView d;
    public LinearLayout e;
    public RecyclerView f;
    public RecyclerView g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public ProgressBar s;
    public ImageView t;
    public u u;
    public m0 v;
    public Z w;
    public q x;
    public ArrayList y;
    public S z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            TextView textView = SearchActivityLowerSDK.this.i;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            RecyclerView recyclerView = SearchActivityLowerSDK.this.a;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            SearchActivityLowerSDK.this.o();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            TextView textView = SearchActivityLowerSDK.this.j;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            RecyclerView recyclerView = SearchActivityLowerSDK.this.c;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            SearchActivityLowerSDK.this.q();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            TextView textView = SearchActivityLowerSDK.this.k;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            RecyclerView recyclerView = SearchActivityLowerSDK.this.d;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            SearchActivityLowerSDK.this.x();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            TextView textView = SearchActivityLowerSDK.this.l;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            LinearLayout linearLayout = SearchActivityLowerSDK.this.e;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SearchActivityLowerSDK.this.u();
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ String a;

        public i(String str) {
            this.a = str;
        }

        public void run() {
            TextView textView = SearchActivityLowerSDK.this.q;
            if (textView != null) {
                textView.setText(this.a);
                SearchActivityLowerSDK.this.q.setVisibility(0);
            }
        }
    }

    public class j implements View.OnFocusChangeListener {
        public final View a;

        public j(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            View view2;
            TextView textView;
            int i;
            if (z) {
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null) {
                    return;
                }
                if (this.a.getTag().equals("10")) {
                    RecyclerView recyclerView = SearchActivityLowerSDK.this.a;
                    if (recyclerView == null || recyclerView.getVisibility() != 0) {
                        textView = SearchActivityLowerSDK.this.i;
                        i = a7.e.T;
                    } else {
                        textView = SearchActivityLowerSDK.this.i;
                        i = a7.e.U;
                    }
                } else if (this.a.getTag().equals("11")) {
                    RecyclerView recyclerView2 = SearchActivityLowerSDK.this.c;
                    if (recyclerView2 == null || recyclerView2.getVisibility() != 0) {
                        textView = SearchActivityLowerSDK.this.j;
                        i = a7.e.T;
                    } else {
                        textView = SearchActivityLowerSDK.this.j;
                        i = a7.e.U;
                    }
                } else if (this.a.getTag().equals("12")) {
                    RecyclerView recyclerView3 = SearchActivityLowerSDK.this.d;
                    if (recyclerView3 == null || recyclerView3.getVisibility() != 0) {
                        textView = SearchActivityLowerSDK.this.k;
                        i = a7.e.T;
                    } else {
                        textView = SearchActivityLowerSDK.this.k;
                        i = a7.e.U;
                    }
                } else {
                    if (!this.a.getTag().equals("13")) {
                        a(1.15f);
                        b(1.15f);
                        return;
                    }
                    LinearLayout linearLayout = SearchActivityLowerSDK.this.e;
                    if (linearLayout == null || linearLayout.getVisibility() != 0) {
                        textView = SearchActivityLowerSDK.this.l;
                        i = a7.e.T;
                    } else {
                        textView = SearchActivityLowerSDK.this.l;
                        i = a7.e.U;
                    }
                }
            } else {
                if (z || (view2 = this.a) == null || view2.getTag() == null) {
                    return;
                }
                float f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                if (this.a.getTag() != null && this.a.getTag().equals("10")) {
                    RecyclerView recyclerView4 = SearchActivityLowerSDK.this.a;
                    if (recyclerView4 == null || recyclerView4.getVisibility() != 0) {
                        textView = SearchActivityLowerSDK.this.i;
                        i = a7.e.R;
                    } else {
                        textView = SearchActivityLowerSDK.this.i;
                        i = a7.e.S;
                    }
                } else if (this.a.getTag() != null && this.a.getTag().equals("11")) {
                    RecyclerView recyclerView5 = SearchActivityLowerSDK.this.c;
                    if (recyclerView5 == null || recyclerView5.getVisibility() != 0) {
                        textView = SearchActivityLowerSDK.this.j;
                        i = a7.e.R;
                    } else {
                        textView = SearchActivityLowerSDK.this.j;
                        i = a7.e.S;
                    }
                } else if (this.a.getTag() != null && this.a.getTag().equals("12")) {
                    RecyclerView recyclerView6 = SearchActivityLowerSDK.this.d;
                    if (recyclerView6 == null || recyclerView6.getVisibility() != 0) {
                        textView = SearchActivityLowerSDK.this.k;
                        i = a7.e.R;
                    } else {
                        textView = SearchActivityLowerSDK.this.k;
                        i = a7.e.S;
                    }
                } else {
                    if (this.a.getTag() == null || !this.a.getTag().equals("13")) {
                        return;
                    }
                    LinearLayout linearLayout2 = SearchActivityLowerSDK.this.e;
                    if (linearLayout2 == null || linearLayout2.getVisibility() != 0) {
                        textView = SearchActivityLowerSDK.this.l;
                        i = a7.e.R;
                    } else {
                        textView = SearchActivityLowerSDK.this.l;
                        i = a7.e.S;
                    }
                }
            }
            textView.setBackgroundResource(i);
        }
    }

    public void A(ArrayList arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    VodAllCategoriesSingleton.getInstance().setLiveList(arrayList);
                    this.a.setLayoutManager(new GridLayoutManager(this, 7));
                    this.a.setItemAnimator((RecyclerView.l) null);
                    u uVar = new u(this.A, arrayList);
                    this.u = uVar;
                    this.a.setAdapter(uVar);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void B(ArrayList arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    VodAllCategoriesSingleton.getInstance().setVodList(arrayList);
                    this.c.setLayoutManager(new GridLayoutManager(this, 7));
                    this.c.setItemAnimator((RecyclerView.l) null);
                    m0 m0Var = new m0(this.A, "vod", 1);
                    this.v = m0Var;
                    this.c.setAdapter(m0Var);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void C(ArrayList arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    SeriesAllCategoriesSingleton.getInstance().setSeriesList(arrayList);
                    this.d.setLayoutManager(new GridLayoutManager(this, 7));
                    this.d.setItemAnimator((RecyclerView.l) null);
                    Z z = new Z(this.A, "series", 0);
                    this.w = z;
                    this.d.setAdapter(z);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void D() {
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        p();
    }

    public void E() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void F() {
        RecyclerView recyclerView = this.c;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        r();
    }

    public void G() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void H(String str) {
        runOnUiThread(new i(str));
    }

    public void I() {
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        v();
    }

    public void J() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void K() {
        RecyclerView recyclerView = this.d;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        y();
    }

    public void L() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void M(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.y;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.A).equals("m3u")) {
                for (int i2 = 0; i2 < this.y.size(); i2++) {
                    if (((XMLTVProgrammePojo) this.y.get(i2)).getUrl().equals(str)) {
                        arrayList.add((XMLTVProgrammePojo) this.y.get(i2));
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.y.size(); i3++) {
                    if (((XMLTVProgrammePojo) this.y.get(i3)).getLiveStreamID().equals(str)) {
                        arrayList.add((XMLTVProgrammePojo) this.y.get(i3));
                    }
                }
            }
            this.g.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.g.setItemAnimator((RecyclerView.l) null);
            S s = new S(this.A, arrayList);
            this.z = s;
            this.g.setAdapter(s);
        } catch (Exception unused) {
        }
    }

    public void a(int i2) {
        z(this.y, i2);
    }

    public boolean b() {
        TextView textView = this.i;
        return textView != null && textView.getVisibility() == 0;
    }

    public boolean c() {
        TextView textView = this.j;
        return textView != null && textView.getVisibility() == 0;
    }

    public boolean d() {
        TextView textView = this.k;
        return textView != null && textView.getVisibility() == 0;
    }

    public void e() {
        runOnUiThread(new b());
    }

    public void f() {
        runOnUiThread(new a());
    }

    public void g() {
        runOnUiThread(new d());
    }

    public void h() {
        runOnUiThread(new c());
    }

    public void i() {
        TextView textView = this.q;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void j() {
        runOnUiThread(new h());
    }

    public void k() {
        runOnUiThread(new g());
    }

    public void l() {
        runOnUiThread(new f());
    }

    public void m() {
        runOnUiThread(new e());
    }

    public final void n() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    public void o() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setBackgroundResource(a7.e.R);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.J6) {
            p();
            g();
            l();
            j();
            D();
            return;
        }
        if (id == a7.f.rb) {
            r();
            e();
            l();
            j();
            F();
            return;
        }
        if (id == a7.f.bg) {
            y();
            e();
            g();
            j();
            K();
            return;
        }
        if (id != a7.f.Lc) {
            if (id == a7.f.F4) {
                onBackPressed();
            }
        } else {
            v();
            e();
            g();
            l();
            I();
        }
    }

    public void onCreate(Bundle bundle) {
        this.A = this;
        super.onCreate(bundle);
        C = new u7.a(this.A);
        if (m7.a.o.booleanValue() && !C.m().booleanValue()) {
            finish();
            startActivity(new Intent(this, APPInPurchaseActivity.class));
            overridePendingTransition(a7.b.f, a7.b.d);
        }
        setContentView(C.A().equals(m7.a.K0) ? a7.g.H0 : a7.g.G0);
        this.a = findViewById(a7.f.K6);
        this.c = findViewById(a7.f.qb);
        this.d = findViewById(a7.f.ag);
        this.e = findViewById(a7.f.z9);
        this.f = findViewById(a7.f.T1);
        this.g = findViewById(a7.f.Kc);
        this.h = findViewById(a7.f.Rg);
        this.i = findViewById(a7.f.J6);
        this.j = findViewById(a7.f.rb);
        this.k = findViewById(a7.f.bg);
        this.l = findViewById(a7.f.Lc);
        this.m = findViewById(a7.f.bl);
        this.n = findViewById(a7.f.dl);
        this.o = findViewById(a7.f.fl);
        this.p = findViewById(a7.f.Di);
        this.q = findViewById(a7.f.wk);
        this.r = findViewById(a7.f.l9);
        this.s = findViewById(a7.f.pc);
        this.t = findViewById(a7.f.F4);
        s();
        t();
    }

    public boolean onSearchRequested() {
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        n();
    }

    public void p() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setBackgroundResource(a7.e.S);
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setBackgroundResource(a7.e.R);
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setBackgroundResource(a7.e.R);
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setBackgroundResource(a7.e.R);
        }
    }

    public void q() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setBackgroundResource(a7.e.R);
        }
    }

    public void r() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setBackgroundResource(a7.e.S);
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setBackgroundResource(a7.e.R);
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setBackgroundResource(a7.e.R);
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setBackgroundResource(a7.e.R);
        }
    }

    public final void s() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setOnClickListener(this);
        }
        this.t.setOnClickListener(this);
    }

    public final void t() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setOnFocusChangeListener(new j(textView));
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setOnFocusChangeListener(new j(textView2));
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setOnFocusChangeListener(new j(textView3));
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setOnFocusChangeListener(new j(textView4));
        }
    }

    public void u() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setBackgroundResource(a7.e.R);
        }
    }

    public void v() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setBackgroundResource(a7.e.S);
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setBackgroundResource(a7.e.R);
        }
        TextView textView3 = this.j;
        if (textView3 != null) {
            textView3.setBackgroundResource(a7.e.R);
        }
        TextView textView4 = this.k;
        if (textView4 != null) {
            textView4.setBackgroundResource(a7.e.R);
        }
    }

    public void w(String str, String str2, String str3, String str4, int i2) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.p;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = this.n;
        if (textView3 != null) {
            textView3.setText(str3);
        }
        TextView textView4 = this.o;
        if (textView4 != null) {
            textView4.setText(str4);
        }
        if (i2 != 0) {
            ProgressBar progressBar = this.s;
            if (progressBar != null) {
                progressBar.setProgress(i2);
            }
            LinearLayout linearLayout = this.r;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.r;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        ProgressBar progressBar2 = this.s;
        if (progressBar2 != null) {
            progressBar2.setProgress(0);
        }
    }

    public void x() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setBackgroundResource(a7.e.R);
        }
    }

    public void y() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setBackgroundResource(a7.e.S);
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setBackgroundResource(a7.e.R);
        }
        TextView textView3 = this.j;
        if (textView3 != null) {
            textView3.setBackgroundResource(a7.e.R);
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setBackgroundResource(a7.e.R);
        }
    }

    public void z(ArrayList arrayList, int i2) {
        try {
            this.y = arrayList;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < this.y.size(); i3++) {
                if (!arrayList3.contains(((XMLTVProgrammePojo) this.y.get(i3)).getLiveName())) {
                    arrayList3.add(((XMLTVProgrammePojo) this.y.get(i3)).getLiveName());
                    arrayList2.add((XMLTVProgrammePojo) this.y.get(i3));
                }
            }
            if (arrayList2.size() > 0) {
                Log.e("honey", "setLeftChannelsAdapter: " + arrayList2.size());
            }
            this.f.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.f.setItemAnimator((RecyclerView.l) null);
            q qVar = new q(this.A, arrayList2, i2);
            this.x = qVar;
            this.f.setAdapter(qVar);
            this.f.m1(i2);
        } catch (Exception unused) {
        }
    }
}
