package com.nst.iptvsmarterstvbox.view.activity;

import E.b;
import a7.e;
import a7.f;
import a7.g;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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
import p7.I;
import q7.S;
import q7.Z;
import q7.m0;
import q7.q;
import q7.u;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SearchActivity extends I implements View.OnClickListener {
    public static u7.a E;
    public Context A;
    public final int B = 1;
    public ArrayList C = new ArrayList();
    public ArrayList D = new ArrayList();
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

    public class a implements View.OnFocusChangeListener {
        public final View a;

        public a(View view) {
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
            TextView o1;
            int i;
            if (z) {
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null) {
                    return;
                }
                if (this.a.getTag().equals("10")) {
                    if (SearchActivity.h1(SearchActivity.this) == null || SearchActivity.h1(SearchActivity.this).getVisibility() != 0) {
                        o1 = SearchActivity.i1(SearchActivity.this);
                        i = e.T;
                    } else {
                        o1 = SearchActivity.i1(SearchActivity.this);
                        i = e.U;
                    }
                } else if (this.a.getTag().equals("11")) {
                    if (SearchActivity.j1(SearchActivity.this) == null || SearchActivity.j1(SearchActivity.this).getVisibility() != 0) {
                        o1 = SearchActivity.k1(SearchActivity.this);
                        i = e.T;
                    } else {
                        o1 = SearchActivity.k1(SearchActivity.this);
                        i = e.U;
                    }
                } else if (this.a.getTag().equals("12")) {
                    if (SearchActivity.l1(SearchActivity.this) == null || SearchActivity.l1(SearchActivity.this).getVisibility() != 0) {
                        o1 = SearchActivity.m1(SearchActivity.this);
                        i = e.T;
                    } else {
                        o1 = SearchActivity.m1(SearchActivity.this);
                        i = e.U;
                    }
                } else if (!this.a.getTag().equals("13")) {
                    a(1.15f);
                    b(1.15f);
                    return;
                } else if (SearchActivity.n1(SearchActivity.this) == null || SearchActivity.n1(SearchActivity.this).getVisibility() != 0) {
                    o1 = SearchActivity.o1(SearchActivity.this);
                    i = e.T;
                } else {
                    o1 = SearchActivity.o1(SearchActivity.this);
                    i = e.U;
                }
            } else {
                if (z || (view2 = this.a) == null || view2.getTag() == null) {
                    return;
                }
                float f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                if (this.a.getTag() == null || !this.a.getTag().equals("10")) {
                    if (this.a.getTag() == null || !this.a.getTag().equals("11")) {
                        if (this.a.getTag() == null || !this.a.getTag().equals("12")) {
                            if (this.a.getTag() == null || !this.a.getTag().equals("13")) {
                                return;
                            }
                            if (SearchActivity.n1(SearchActivity.this) == null || SearchActivity.n1(SearchActivity.this).getVisibility() != 0) {
                                o1 = SearchActivity.o1(SearchActivity.this);
                                i = e.R;
                            } else {
                                o1 = SearchActivity.o1(SearchActivity.this);
                                i = e.S;
                            }
                        } else if (SearchActivity.l1(SearchActivity.this) == null || SearchActivity.l1(SearchActivity.this).getVisibility() != 0) {
                            o1 = SearchActivity.m1(SearchActivity.this);
                            i = e.R;
                        } else {
                            o1 = SearchActivity.m1(SearchActivity.this);
                            i = e.S;
                        }
                    } else if (SearchActivity.j1(SearchActivity.this) == null || SearchActivity.j1(SearchActivity.this).getVisibility() != 0) {
                        o1 = SearchActivity.k1(SearchActivity.this);
                        i = e.R;
                    } else {
                        o1 = SearchActivity.k1(SearchActivity.this);
                        i = e.S;
                    }
                } else if (SearchActivity.h1(SearchActivity.this) == null || SearchActivity.h1(SearchActivity.this).getVisibility() != 0) {
                    o1 = SearchActivity.i1(SearchActivity.this);
                    i = e.R;
                } else {
                    o1 = SearchActivity.i1(SearchActivity.this);
                    i = e.S;
                }
            }
            o1.setBackgroundResource(i);
        }
    }

    private void C1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void K1() {
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

    private void L1() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setOnFocusChangeListener(new a(textView));
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setOnFocusChangeListener(new a(textView2));
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setOnFocusChangeListener(new a(textView3));
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setOnFocusChangeListener(new a(textView4));
        }
    }

    public static /* synthetic */ RecyclerView h1(SearchActivity searchActivity) {
        return searchActivity.a;
    }

    public static /* synthetic */ TextView i1(SearchActivity searchActivity) {
        return searchActivity.i;
    }

    public static /* synthetic */ RecyclerView j1(SearchActivity searchActivity) {
        return searchActivity.c;
    }

    public static /* synthetic */ TextView k1(SearchActivity searchActivity) {
        return searchActivity.j;
    }

    public static /* synthetic */ RecyclerView l1(SearchActivity searchActivity) {
        return searchActivity.d;
    }

    public static /* synthetic */ TextView m1(SearchActivity searchActivity) {
        return searchActivity.k;
    }

    public static /* synthetic */ LinearLayout n1(SearchActivity searchActivity) {
        return searchActivity.e;
    }

    public static /* synthetic */ TextView o1(SearchActivity searchActivity) {
        return searchActivity.l;
    }

    public void A1() {
        RecyclerView recyclerView = this.d;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        Q1();
    }

    public void B1() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void D1() {
        ArrayList arrayList = new ArrayList();
        this.a.setLayoutManager(new GridLayoutManager(this, 7));
        this.a.setItemAnimator((RecyclerView.l) null);
        u uVar = new u(this.A, arrayList);
        this.u = uVar;
        uVar.e1(null);
        this.u.d1();
        this.a.setAdapter(this.u);
    }

    public final void E1() {
        this.c.setLayoutManager(new GridLayoutManager(this, 7));
        this.c.setItemAnimator((RecyclerView.l) null);
        m0 m0Var = new m0(this.A, "vod", 0);
        this.v = m0Var;
        m0Var.p1(null);
        this.c.setAdapter(this.v);
    }

    public final void F1() {
        this.d.setLayoutManager(new GridLayoutManager(this, 7));
        this.d.setItemAnimator((RecyclerView.l) null);
        Z z = new Z(this.A, "series", 0);
        this.w = z;
        z.E1(null);
        this.d.setAdapter(this.w);
    }

    public void G1() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setBackgroundResource(e.R);
        }
    }

    public void H1() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setBackgroundResource(e.S);
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setBackgroundResource(e.R);
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setBackgroundResource(e.R);
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setBackgroundResource(e.R);
        }
    }

    public void I1() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setBackgroundResource(e.R);
        }
    }

    public void J1() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setBackgroundResource(e.S);
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setBackgroundResource(e.R);
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setBackgroundResource(e.R);
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setBackgroundResource(e.R);
        }
    }

    public void M1() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setBackgroundResource(e.R);
        }
    }

    public void N1() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setBackgroundResource(e.S);
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setBackgroundResource(e.R);
        }
        TextView textView3 = this.j;
        if (textView3 != null) {
            textView3.setBackgroundResource(e.R);
        }
        TextView textView4 = this.k;
        if (textView4 != null) {
            textView4.setBackgroundResource(e.R);
        }
    }

    public final void O1() {
        if (b.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0) {
            b.checkSelfPermission(this, "android.permission.RECORD_AUDIO");
            return;
        }
        String[] strArr = {"android.permission.RECORD_AUDIO"};
        if (D.b.l(this, "android.permission.RECORD_AUDIO")) {
            D.b.h(this, strArr, 1);
        } else {
            D.b.h(this, strArr, 1);
        }
    }

    public void P1(String str, String str2, String str3, String str4, int i) {
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
        if (i != 0) {
            ProgressBar progressBar = this.s;
            if (progressBar != null) {
                progressBar.setProgress(i);
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

    public void Q1() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setBackgroundResource(e.R);
        }
    }

    public void R1() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setBackgroundResource(e.S);
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setBackgroundResource(e.R);
        }
        TextView textView3 = this.j;
        if (textView3 != null) {
            textView3.setBackgroundResource(e.R);
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setBackgroundResource(e.R);
        }
    }

    public void S1(ArrayList arrayList, int i) {
        try {
            this.y = arrayList;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i2 = 0; i2 < this.y.size(); i2++) {
                if (!arrayList3.contains(((XMLTVProgrammePojo) this.y.get(i2)).getLiveName())) {
                    arrayList3.add(((XMLTVProgrammePojo) this.y.get(i2)).getLiveName());
                    arrayList2.add((XMLTVProgrammePojo) this.y.get(i2));
                }
            }
            if (arrayList2.size() > 0) {
                Log.e("honey", "setLeftChannelsAdapter: " + arrayList2.size());
            }
            this.f.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.f.setItemAnimator((RecyclerView.l) null);
            q qVar = new q(this.A, arrayList2, i);
            this.x = qVar;
            qVar.n0(null);
            this.f.setAdapter(this.x);
            this.f.m1(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void T1(ArrayList arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    VodAllCategoriesSingleton.getInstance().setLiveList(arrayList);
                    u uVar = this.u;
                    if (uVar == null) {
                        this.a.setLayoutManager(new GridLayoutManager(this, 7));
                        this.a.setItemAnimator((RecyclerView.l) null);
                        u uVar2 = new u(this.A, arrayList);
                        this.u = uVar2;
                        uVar2.d1();
                        this.a.setAdapter(this.u);
                    } else {
                        uVar.d1();
                        this.u.g1(arrayList);
                        this.u.w();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void U1(ArrayList arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    VodAllCategoriesSingleton.getInstance().setVodList(arrayList);
                    m0 m0Var = this.v;
                    if (m0Var == null) {
                        this.c.setLayoutManager(new GridLayoutManager(this, 7));
                        this.c.setItemAnimator((RecyclerView.l) null);
                        m0 m0Var2 = new m0(this.A, "vod", 0);
                        this.v = m0Var2;
                        this.c.setAdapter(m0Var2);
                    } else {
                        m0Var.q1();
                        this.v.w();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void V1(ArrayList arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    SeriesAllCategoriesSingleton.getInstance().setSeriesList(arrayList);
                    Z z = this.w;
                    if (z == null) {
                        this.d.setLayoutManager(new GridLayoutManager(this, 7));
                        this.d.setItemAnimator((RecyclerView.l) null);
                        Z z2 = new Z(this.A, "series", 0);
                        this.w = z2;
                        this.d.setAdapter(z2);
                    } else {
                        z.F1();
                        this.w.w();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void W1() {
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        H1();
    }

    public void X1() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void Y1() {
        RecyclerView recyclerView = this.c;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        J1();
    }

    public void Z1() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void a2(String str) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setText(str);
            this.q.setVisibility(0);
        }
    }

    public void b2() {
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        N1();
    }

    public void c2() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void d2() {
        RecyclerView recyclerView = this.d;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        R1();
    }

    public void e2() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void f2(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.y;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.A).equals("m3u")) {
                for (int i = 0; i < this.y.size(); i++) {
                    if (((XMLTVProgrammePojo) this.y.get(i)).getUrl().equals(str)) {
                        arrayList.add((XMLTVProgrammePojo) this.y.get(i));
                    }
                }
            } else {
                for (int i2 = 0; i2 < this.y.size(); i2++) {
                    if (((XMLTVProgrammePojo) this.y.get(i2)).getLiveStreamID().equals(str)) {
                        arrayList.add((XMLTVProgrammePojo) this.y.get(i2));
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

    public void onBackPressed() {
        finish();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.J6) {
            H1();
            v1();
            A1();
            y1();
            W1();
            return;
        }
        if (id == f.rb) {
            J1();
            t1();
            A1();
            y1();
            Y1();
            return;
        }
        if (id == f.bg) {
            R1();
            t1();
            v1();
            y1();
            d2();
            return;
        }
        if (id != f.Lc) {
            if (id == f.F4) {
                onBackPressed();
            }
        } else {
            N1();
            t1();
            v1();
            A1();
            b2();
        }
    }

    public void onCreate(Bundle bundle) {
        this.A = this;
        super.onCreate(bundle);
        u7.a aVar = new u7.a(this.A);
        E = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? g.I0 : g.F0);
        this.a = findViewById(f.K6);
        this.c = findViewById(f.qb);
        this.d = findViewById(f.ag);
        this.e = findViewById(f.z9);
        this.f = findViewById(f.T1);
        this.g = findViewById(f.Kc);
        this.h = findViewById(f.Rg);
        this.i = findViewById(f.J6);
        this.j = findViewById(f.rb);
        this.k = findViewById(f.bg);
        this.l = findViewById(f.Lc);
        this.m = findViewById(f.bl);
        this.n = findViewById(f.dl);
        this.o = findViewById(f.fl);
        this.p = findViewById(f.Di);
        this.q = findViewById(f.wk);
        this.r = findViewById(f.l9);
        this.s = findViewById(f.pc);
        this.t = findViewById(f.F4);
        O1();
        K1();
        L1();
        F1();
        D1();
        E1();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super/*android.app.Activity*/.onKeyDown(i, keyEvent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1) {
            return;
        }
        try {
            if (iArr.length > 0) {
                int i2 = iArr[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onSearchRequested() {
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        C1();
    }

    public void p1(int i) {
        S1(this.y, i);
    }

    public boolean q1() {
        TextView textView = this.i;
        return textView != null && textView.getVisibility() == 0;
    }

    public boolean r1() {
        TextView textView = this.j;
        return textView != null && textView.getVisibility() == 0;
    }

    public boolean s1() {
        TextView textView = this.k;
        return textView != null && textView.getVisibility() == 0;
    }

    public void t1() {
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        G1();
    }

    public void u1() {
        TextView textView = this.i;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void v1() {
        RecyclerView recyclerView = this.c;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        I1();
    }

    public void w1() {
        TextView textView = this.j;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void x1() {
        TextView textView = this.q;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void y1() {
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        M1();
    }

    public void z1() {
        TextView textView = this.l;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }
}
