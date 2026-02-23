package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.NativeAd;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class r extends RecyclerView.g {
    public List d;
    public Context e;
    public List f;
    public List g;
    public int h;
    public int i;
    public LiveStreamDBHandler j;
    public DatabaseHandler k;
    public boolean l = true;
    public int m = 0;
    public AsyncTask n = null;
    public int o = 0;

    public class a implements Comparator {
        public a() {
        }

        public int compare(Object obj, Object obj2) {
            try {
                return ((w) obj).b().compareTo(((w) obj2).b());
            } catch (Exception unused) {
                return -1;
            }
        }
    }

    public class b implements Comparator {
        public b() {
        }

        public int compare(Object obj, Object obj2) {
            try {
                return ((w) obj2).b().compareTo(((w) obj).b());
            } catch (Exception unused) {
                return -1;
            }
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public c(g gVar, String str, String str2) {
            this.a = gVar;
            this.c = str;
            this.d = str2;
        }

        public void onClick(View view) {
            r.l0(r.this, this.a.p());
            m7.w.x0(r.m0(r.this), "Built-in Player ( Default )", -1, "live", 0, "", "", "", this.c, "", this.d);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                r rVar;
                List n0;
                if (!TextUtils.isEmpty(d.this.a)) {
                    if (!r.n0(r.this).isEmpty() || r.n0(r.this).isEmpty()) {
                        rVar = r.this;
                        n0 = r.n0(rVar);
                    }
                    if (r.t0(r.this) != null && r.t0(r.this).size() == 0) {
                        d.this.c.setVisibility(0);
                    }
                    r rVar2 = r.this;
                    r.A0(rVar2, r.q0(rVar2));
                    r.this.w();
                }
                rVar = r.this;
                n0 = r.s0(rVar);
                r.x0(rVar, n0);
                if (r.t0(r.this) != null) {
                    d.this.c.setVisibility(0);
                }
                r rVar22 = r.this;
                r.A0(rVar22, r.q0(rVar22));
                r.this.w();
            }
        }

        public d(String str, TextView textView) {
            this.a = str;
            this.c = textView;
        }

        public void run() {
            r.p0(r.this, new ArrayList());
            r.r0(r.this, this.a.length());
            if (r.n0(r.this) != null) {
                r.n0(r.this).clear();
            }
            if (TextUtils.isEmpty(this.a)) {
                r.n0(r.this).addAll(r.s0(r.this));
            } else {
                if ((r.t0(r.this) != null && r.t0(r.this).size() == 0) || r.z0(r.this) > r.q0(r.this)) {
                    r rVar = r.this;
                    r.x0(rVar, r.s0(rVar));
                }
                if (r.t0(r.this) != null) {
                    for (int i = 0; i < r.t0(r.this).size(); i++) {
                        try {
                            w wVar = (w) r.t0(r.this).get(i);
                            if (wVar.b().toLowerCase().contains(this.a.toLowerCase())) {
                                r.n0(r.this).add(wVar);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            r.m0(r.this).runOnUiThread(new a());
        }
    }

    public class e extends AsyncTask {
        public g a;

        public e(g gVar) {
            this.a = gVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(g... gVarArr) {
            try {
                return SharepreferenceDBHandler.getCurrentAPPType(r.m0(r.this)).equals("m3u") ? Integer.valueOf(r.j0(r.this).getFavouriteCountM3U("live")) : Integer.valueOf(r.k0(r.this).getFavouriteCount("live", SharepreferenceDBHandler.getUserID(r.m0(r.this))));
            } catch (Exception unused) {
                return 0;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (num.intValue() == 0 || num.intValue() == -1) {
                g.Q(this.a).setText("0");
            } else {
                g.Q(this.a).setText(String.valueOf(num));
            }
            g.Q(this.a).setVisibility(0);
        }

        public void onPreExecute() {
            super.onPreExecute();
            g.Q(this.a).setVisibility(8);
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
            View view2;
            int i;
            if (z) {
                b(1.09f);
                c(1.09f);
                Log.e("id is", "" + this.a.getTag());
                view2 = this.a;
                i = a7.e.q2;
            } else {
                if (z) {
                    return;
                }
                b(1.0f);
                c(1.0f);
                a(false);
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
        public ImageView z;

        public g(View view) {
            super(view);
            this.t = view.findViewById(a7.f.fk);
            this.u = view.findViewById(a7.f.oc);
            this.v = view.findViewById(a7.f.Re);
            this.x = view.findViewById(a7.f.Wg);
            this.w = view.findViewById(a7.f.ze);
            this.y = view.findViewById(a7.f.Vl);
            this.z = view.findViewById(a7.f.i5);
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

    public r(List list, Context context) {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.addAll(list);
        this.g = list;
        this.d = list;
        this.e = context;
        this.j = new LiveStreamDBHandler(context);
        this.k = new DatabaseHandler(context);
        String liveActivitynewFlowSort = SharepreferenceDBHandler.getLiveActivitynewFlowSort(context);
        if (liveActivitynewFlowSort.equals("1")) {
            Collections.sort(list, new a());
        }
        if (liveActivitynewFlowSort.equals("2")) {
            Collections.sort(list, new b());
        }
    }

    public static /* synthetic */ int A0(r rVar, int i) {
        rVar.h = i;
        return i;
    }

    private void F0(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleX", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private void J0(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleY", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    public static /* synthetic */ LiveStreamDBHandler j0(r rVar) {
        return rVar.j;
    }

    public static /* synthetic */ DatabaseHandler k0(r rVar) {
        return rVar.k;
    }

    public static /* synthetic */ int l0(r rVar, int i) {
        rVar.o = i;
        return i;
    }

    public static /* synthetic */ Context m0(r rVar) {
        return rVar.e;
    }

    public static /* synthetic */ List n0(r rVar) {
        return rVar.f;
    }

    public static /* synthetic */ List p0(r rVar, List list) {
        rVar.f = list;
        return list;
    }

    public static /* synthetic */ int q0(r rVar) {
        return rVar.i;
    }

    public static /* synthetic */ int r0(r rVar, int i) {
        rVar.i = i;
        return i;
    }

    public static /* synthetic */ List s0(r rVar) {
        return rVar.g;
    }

    public static /* synthetic */ List t0(r rVar) {
        return rVar.d;
    }

    public static /* synthetic */ List x0(r rVar, List list) {
        rVar.d = list;
        return list;
    }

    public static /* synthetic */ int z0(r rVar) {
        return rVar.h;
    }

    public void B0(String str, TextView textView) {
        new Thread(new d(str, textView)).start();
    }

    public void E(RecyclerView.D d2, int i) {
        try {
            if (p(i) == 1) {
                G g2 = (G) d2;
                NativeAd nativeAd = (NativeAd) this.d.get(i);
                g2.T().setText(nativeAd.getAdvertiserName());
                g2.S().setText(nativeAd.getAdSocialContext());
                g2.Q().setText(nativeAd.getAdCallToAction());
                g2.Q().setVisibility(nativeAd.hasCallToAction() ? 0 : 4);
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
            if (b2 != null && !b2.equals("") && !b2.isEmpty()) {
                g.P(gVar).setText(b2);
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.e).equals("m3u")) {
                if (a2.equals("-1")) {
                    K0(gVar);
                } else {
                    g.Q(gVar).setText(String.valueOf(c2));
                }
                if (a2.equals("0")) {
                    this.m = c2;
                }
            } else {
                if (a2.equals("-1")) {
                    K0(gVar);
                } else {
                    g.Q(gVar).setText(String.valueOf(c2));
                }
                if (a2.equals("0")) {
                    int streamsCount = this.j.getStreamsCount("live");
                    if (streamsCount == 0 || streamsCount == -1) {
                        g.Q(gVar).setText("");
                    } else {
                        g.Q(gVar).setText(String.valueOf(streamsCount));
                    }
                }
            }
            if (new u7.a(this.e).A().equals(m7.a.K0) && this.i == 0 && !m7.a.k0.booleanValue() && i == this.o) {
                g.R(gVar).requestFocus();
                F0(1.09f, g.R(gVar));
                J0(1.09f, g.R(gVar));
                g.R(gVar).setBackgroundResource(a7.e.q2);
            }
            g.R(gVar).setOnClickListener(new c(gVar, a2, b2));
            g.R(gVar).setOnFocusChangeListener(new f(g.R(gVar)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void K0(g gVar) {
        new e(gVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new g[]{gVar});
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

    public void L0(ProgressBar progressBar) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public int n() {
        List list = this.d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int p(int i) {
        return this.d.get(i) instanceof NativeAd ? 1 : 0;
    }
}
