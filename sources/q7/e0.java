package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.NativeAd;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.TVArchiveActivityLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class e0 extends RecyclerView.g {
    public List d;
    public Context e;
    public List f;
    public List g;
    public int h;
    public int i;
    public LiveStreamDBHandler j;
    public DatabaseHandler k;
    public String n;
    public boolean l = true;
    public ArrayList m = new ArrayList();
    public int o = 0;

    public class a implements View.OnKeyListener {
        public final /* synthetic */ RecyclerView a;

        public a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            e0 e0Var;
            int i2;
            RecyclerView.o layoutManager = this.a.getLayoutManager();
            if (keyEvent.getAction() != 0) {
                return false;
            }
            if (i == 20) {
                e0Var = e0.this;
                i2 = 1;
            } else {
                if (i != 19) {
                    return false;
                }
                e0Var = e0.this;
                i2 = -1;
            }
            return e0.j0(e0Var, layoutManager, i2);
        }
    }

    public class b implements Comparator {
        public b() {
        }

        public int compare(Object obj, Object obj2) {
            try {
                return ((w) obj).b().compareTo(((w) obj2).b());
            } catch (Exception unused) {
                return -1;
            }
        }
    }

    public class c implements Comparator {
        public c() {
        }

        public int compare(Object obj, Object obj2) {
            try {
                return ((w) obj2).b().compareTo(((w) obj).b());
            } catch (Exception unused) {
                return -1;
            }
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ RecyclerView.D a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public d(RecyclerView.D d, String str, String str2) {
            this.a = d;
            this.c = str;
            this.d = str2;
        }

        public void onClick(View view) {
            e0.m0(e0.this, this.a.p());
            Intent intent = new Intent(e0.n0(e0.this), TVArchiveActivityLayout.class);
            intent.putExtra("category_id", this.c);
            intent.putExtra("category_name", this.d);
            e0.n0(e0.this).startActivity(intent);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                e0 e0Var;
                List p0;
                if (!TextUtils.isEmpty(e.this.a)) {
                    if (!e0.p0(e0.this).isEmpty() || e0.p0(e0.this).isEmpty()) {
                        e0Var = e0.this;
                        p0 = e0.p0(e0Var);
                    }
                    if (e0.x0(e0.this) != null && e0.x0(e0.this).size() == 0) {
                        e.this.c.setVisibility(0);
                    }
                    e0 e0Var2 = e0.this;
                    e0.l0(e0Var2, e0.r0(e0Var2));
                    e0.this.w();
                }
                e0Var = e0.this;
                p0 = e0.t0(e0Var);
                e0.z0(e0Var, p0);
                if (e0.x0(e0.this) != null) {
                    e.this.c.setVisibility(0);
                }
                e0 e0Var22 = e0.this;
                e0.l0(e0Var22, e0.r0(e0Var22));
                e0.this.w();
            }
        }

        public e(String str, TextView textView) {
            this.a = str;
            this.c = textView;
        }

        public void run() {
            e0.q0(e0.this, new ArrayList());
            e0.s0(e0.this, this.a.length());
            if (e0.p0(e0.this) != null) {
                e0.p0(e0.this).clear();
            }
            if (TextUtils.isEmpty(this.a)) {
                e0.p0(e0.this).addAll(e0.t0(e0.this));
            } else {
                if ((e0.x0(e0.this) != null && e0.x0(e0.this).size() == 0) || e0.k0(e0.this) > e0.r0(e0.this)) {
                    e0 e0Var = e0.this;
                    e0.z0(e0Var, e0.t0(e0Var));
                }
                if (e0.x0(e0.this) != null) {
                    for (int i = 0; i < e0.x0(e0.this).size(); i++) {
                        try {
                            w wVar = (w) e0.x0(e0.this).get(i);
                            if (wVar.b().toLowerCase().contains(this.a.toLowerCase())) {
                                e0.p0(e0.this).add(wVar);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            e0.n0(e0.this).runOnUiThread(new a());
        }
    }

    public class f implements View.OnFocusChangeListener {
        public final View a;

        public f(View view) {
            this.a = view;
        }

        public final void a(boolean z) {
            if (z) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{z ? 0.6f : 0.5f});
                ofFloat.setDuration(150L);
                ofFloat.start();
            }
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void c(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            float f;
            View view2;
            int i;
            if (z) {
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                Log.e("id is", "" + this.a.getTag());
                view2 = this.a;
                i = a7.e.q2;
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                b(f);
                c(f);
                a(z);
                view2 = this.a;
                i = a7.e.p2;
            }
            view2.setBackgroundResource(i);
        }
    }

    public static class g extends RecyclerView.D {
        public TextView t;
        public ProgressBar u;
        public RelativeLayout v;
        public RelativeLayout w;
        public RelativeLayout x;
        public TextView y;

        public g(View view) {
            super(view);
            this.t = view.findViewById(a7.f.fk);
            this.u = view.findViewById(a7.f.oc);
            this.v = view.findViewById(a7.f.Re);
            this.x = view.findViewById(a7.f.Wg);
            this.w = view.findViewById(a7.f.ze);
            this.y = view.findViewById(a7.f.Vl);
            J(false);
        }

        public static /* synthetic */ TextView P(g gVar) {
            return gVar.t;
        }

        public static /* synthetic */ TextView Q(g gVar) {
            return gVar.y;
        }

        public static /* synthetic */ RelativeLayout R(g gVar) {
            return gVar.v;
        }
    }

    public e0(List list, Context context) {
        this.n = "";
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.addAll(list);
        this.g = list;
        this.d = list;
        this.e = context;
        this.j = new LiveStreamDBHandler(context);
        this.k = new DatabaseHandler(context);
        this.n = context.getSharedPreferences("selected_language", 0).getString("selected_language", "");
        String string = context.getSharedPreferences("sortcatch", 0).getString("sort", "");
        if (string.equals("1")) {
            Collections.sort(list, new b());
        }
        if (string.equals("2")) {
            Collections.sort(list, new c());
        }
    }

    private void B0(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleX", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private void F0(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleY", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private boolean K0(RecyclerView.o oVar, int i) {
        int i2 = this.o + i;
        if (i2 < 0 || i2 >= n()) {
            return false;
        }
        x(this.o);
        this.o = i2;
        x(i2);
        oVar.U1(this.o);
        return true;
    }

    public static /* synthetic */ boolean j0(e0 e0Var, RecyclerView.o oVar, int i) {
        return e0Var.K0(oVar, i);
    }

    public static /* synthetic */ int k0(e0 e0Var) {
        return e0Var.h;
    }

    public static /* synthetic */ int l0(e0 e0Var, int i) {
        e0Var.h = i;
        return i;
    }

    public static /* synthetic */ int m0(e0 e0Var, int i) {
        e0Var.o = i;
        return i;
    }

    public static /* synthetic */ Context n0(e0 e0Var) {
        return e0Var.e;
    }

    public static /* synthetic */ List p0(e0 e0Var) {
        return e0Var.f;
    }

    public static /* synthetic */ List q0(e0 e0Var, List list) {
        e0Var.f = list;
        return list;
    }

    public static /* synthetic */ int r0(e0 e0Var) {
        return e0Var.i;
    }

    public static /* synthetic */ int s0(e0 e0Var, int i) {
        e0Var.i = i;
        return i;
    }

    public static /* synthetic */ List t0(e0 e0Var) {
        return e0Var.g;
    }

    public static /* synthetic */ List x0(e0 e0Var) {
        return e0Var.d;
    }

    public static /* synthetic */ List z0(e0 e0Var, List list) {
        e0Var.d = list;
        return list;
    }

    public void A0(String str, TextView textView) {
        new Thread(new e(str, textView)).start();
    }

    public void D(RecyclerView recyclerView) {
        super.D(recyclerView);
        recyclerView.setOnKeyListener(new a(recyclerView));
    }

    public void E(RecyclerView.D d2, int i) {
        TextView Q;
        try {
            Bundle bundle = new Bundle();
            int i2 = 0;
            if (p(i) == 1) {
                G g2 = (G) d2;
                NativeAd nativeAd = (NativeAd) this.d.get(i);
                g2.T().setText(nativeAd.getAdvertiserName());
                g2.S().setText(nativeAd.getAdSocialContext());
                g2.Q().setText(nativeAd.getAdCallToAction());
                Button Q2 = g2.Q();
                if (!nativeAd.hasCallToAction()) {
                    i2 = 4;
                }
                Q2.setVisibility(i2);
                ArrayList arrayList = new ArrayList();
                arrayList.add(g2.Q());
                arrayList.add(g2.P());
                nativeAd.registerViewForInteraction(g2.P(), g2.R(), arrayList);
                return;
            }
            g gVar = (g) d2;
            w wVar = (w) this.d.get(i);
            String b2 = wVar.b();
            String a2 = wVar.a();
            int c2 = wVar.c();
            bundle.putString("category_id", a2);
            bundle.putString("category_name", b2);
            String str = "";
            if (b2 != null && !b2.equals("") && !b2.isEmpty()) {
                g.P(gVar).setText(b2);
            }
            if (a2.hashCode() == 48 && a2.equals("0")) {
                ArrayList allLiveStreamsArchive = this.j.getAllLiveStreamsArchive("0");
                if (allLiveStreamsArchive != null && allLiveStreamsArchive.size() != 0) {
                    g.Q(gVar).setText(String.valueOf(allLiveStreamsArchive.size()));
                    if (new u7.a(this.e).A().equals(m7.a.K0) && this.i == 0 && !m7.a.k0.booleanValue() && i == this.o) {
                        g.R(gVar).requestFocus();
                        B0(1.09f, g.R(gVar));
                        F0(1.09f, g.R(gVar));
                        g.R(gVar).setBackgroundResource(a7.e.q2);
                    }
                    g.R(gVar).setOnClickListener(new d(d2, a2, b2));
                    g.R(gVar).setOnFocusChangeListener(new f(g.R(gVar)));
                    if (i == 0 || !this.l) {
                    }
                    g.R(gVar).requestFocus();
                    this.l = false;
                    return;
                }
                Q = g.Q(gVar);
            } else {
                Q = g.Q(gVar);
                str = String.valueOf(c2);
            }
            Q.setText(str);
            if (new u7.a(this.e).A().equals(m7.a.K0)) {
                g.R(gVar).requestFocus();
                B0(1.09f, g.R(gVar));
                F0(1.09f, g.R(gVar));
                g.R(gVar).setBackgroundResource(a7.e.q2);
            }
            g.R(gVar).setOnClickListener(new d(d2, a2, b2));
            g.R(gVar).setOnFocusChangeListener(new f(g.R(gVar)));
            if (i == 0) {
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    public void J0(ProgressBar progressBar) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public RecyclerView.D L(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new G(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.I1, viewGroup, false));
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.k3, viewGroup, false);
        ImageView findViewById = inflate.findViewById(a7.f.i5);
        if (SharepreferenceDBHandler.getSelectedLanguage(this.e).equalsIgnoreCase("Arabic")) {
            findViewById.setImageResource(a7.e.W0);
        }
        return new g(inflate);
    }

    public int n() {
        return this.d.size();
    }

    public int p(int i) {
        return this.d.get(i) instanceof NativeAd ? 1 : 0;
    }
}
