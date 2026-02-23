package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
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
import com.nst.iptvsmarterstvbox.view.activity.NewEPGActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class l extends RecyclerView.g {
    public Context d;
    public List e;
    public List f;
    public int g;
    public int h;
    public LiveStreamDBHandler i;
    public DatabaseHandler j;
    public String l;
    public List n;
    public boolean k = true;
    public int m = 0;

    public class a implements View.OnKeyListener {
        public final /* synthetic */ RecyclerView a;

        public a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            l lVar;
            int i2;
            RecyclerView.o layoutManager = this.a.getLayoutManager();
            if (keyEvent.getAction() != 0) {
                return false;
            }
            if (i == 20) {
                lVar = l.this;
                i2 = 1;
            } else {
                if (i != 19) {
                    return false;
                }
                lVar = l.this;
                i2 = -1;
            }
            return l.j0(lVar, layoutManager, i2);
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
            l.q0(l.this, this.a.p());
            Intent intent = new Intent(l.r0(l.this), NewEPGActivity.class);
            intent.putExtra("category_id", this.c);
            intent.putExtra("category_name", this.d);
            l.r0(l.this).startActivity(intent);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                l lVar;
                List x0;
                if (!TextUtils.isEmpty(e.this.a)) {
                    if (!l.x0(l.this).isEmpty() || l.x0(l.this).isEmpty()) {
                        lVar = l.this;
                        x0 = l.x0(lVar);
                    }
                    if (l.l0(l.this) != null && l.l0(l.this).size() == 0) {
                        e.this.c.setVisibility(0);
                    }
                    l lVar2 = l.this;
                    l.p0(lVar2, l.A0(lVar2));
                    l.this.w();
                }
                lVar = l.this;
                x0 = l.k0(lVar);
                l.m0(lVar, x0);
                if (l.l0(l.this) != null) {
                    e.this.c.setVisibility(0);
                }
                l lVar22 = l.this;
                l.p0(lVar22, l.A0(lVar22));
                l.this.w();
            }
        }

        public e(String str, TextView textView) {
            this.a = str;
            this.c = textView;
        }

        public void run() {
            l.z0(l.this, new ArrayList());
            l.B0(l.this, this.a.length());
            if (l.x0(l.this) != null) {
                l.x0(l.this).clear();
            }
            if (TextUtils.isEmpty(this.a)) {
                l.x0(l.this).addAll(l.k0(l.this));
            } else {
                if ((l.l0(l.this) != null && l.l0(l.this).size() == 0) || l.n0(l.this) > l.A0(l.this)) {
                    l lVar = l.this;
                    l.m0(lVar, l.k0(lVar));
                }
                if (l.l0(l.this) != null) {
                    for (int i = 0; i < l.l0(l.this).size(); i++) {
                        try {
                            w wVar = (w) l.l0(l.this).get(i);
                            if (wVar.b().toLowerCase().contains(this.a.toLowerCase())) {
                                l.x0(l.this).add(wVar);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            l.r0(l.this).runOnUiThread(new a());
        }
    }

    public class f extends AsyncTask {
        public g a;

        public f(g gVar) {
            this.a = gVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(g... gVarArr) {
            try {
                return SharepreferenceDBHandler.getCurrentAPPType(l.r0(l.this)).equals("m3u") ? Integer.valueOf(l.s0(l.this).getFavouriteCountM3U("live")) : Integer.valueOf(l.t0(l.this).getFavouriteCount("live", SharepreferenceDBHandler.getUserID(l.r0(l.this))));
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

    public static class g extends RecyclerView.D {
        public TextView t;
        public ProgressBar u;
        public RelativeLayout v;
        public RelativeLayout w;
        public TextView x;

        public g(View view) {
            super(view);
            this.t = view.findViewById(a7.f.fk);
            this.u = view.findViewById(a7.f.oc);
            this.v = view.findViewById(a7.f.Re);
            this.w = view.findViewById(a7.f.ze);
            this.x = view.findViewById(a7.f.Vl);
            J(false);
        }

        public static /* synthetic */ TextView P(g gVar) {
            return gVar.t;
        }

        public static /* synthetic */ TextView Q(g gVar) {
            return gVar.x;
        }

        public static /* synthetic */ RelativeLayout R(g gVar) {
            return gVar.v;
        }
    }

    public class h implements View.OnFocusChangeListener {
        public final View a;

        public h(View view) {
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

    public l(Context context, List list) {
        this.l = "";
        this.n = list;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.addAll(list);
        this.f = list;
        this.d = context;
        this.i = new LiveStreamDBHandler(context);
        this.j = new DatabaseHandler(context);
        this.l = context.getSharedPreferences("selected_language", 0).getString("selected_language", "");
        String string = context.getSharedPreferences("sortepg", 0).getString("sort", "");
        if (string.equals("1")) {
            Collections.sort(list, new b());
        }
        if (string.equals("2")) {
            Collections.sort(list, new c());
        }
    }

    public static /* synthetic */ int A0(l lVar) {
        return lVar.h;
    }

    public static /* synthetic */ int B0(l lVar, int i) {
        lVar.h = i;
        return i;
    }

    public static /* synthetic */ boolean j0(l lVar, RecyclerView.o oVar, int i) {
        return lVar.O0(oVar, i);
    }

    public static /* synthetic */ List k0(l lVar) {
        return lVar.f;
    }

    public static /* synthetic */ List l0(l lVar) {
        return lVar.n;
    }

    public static /* synthetic */ List m0(l lVar, List list) {
        lVar.n = list;
        return list;
    }

    public static /* synthetic */ int n0(l lVar) {
        return lVar.g;
    }

    public static /* synthetic */ int p0(l lVar, int i) {
        lVar.g = i;
        return i;
    }

    public static /* synthetic */ int q0(l lVar, int i) {
        lVar.m = i;
        return i;
    }

    public static /* synthetic */ Context r0(l lVar) {
        return lVar.d;
    }

    public static /* synthetic */ LiveStreamDBHandler s0(l lVar) {
        return lVar.i;
    }

    public static /* synthetic */ DatabaseHandler t0(l lVar) {
        return lVar.j;
    }

    public static /* synthetic */ List x0(l lVar) {
        return lVar.e;
    }

    public static /* synthetic */ List z0(l lVar, List list) {
        lVar.e = list;
        return list;
    }

    public void D(RecyclerView recyclerView) {
        super.D(recyclerView);
        recyclerView.setOnKeyListener(new a(recyclerView));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8 A[PHI: r0
      0x00a8: PHI (r0v10 int) = (r0v8 int), (r0v12 int) binds: [B:45:0x00c4, B:40:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(androidx.recyclerview.widget.RecyclerView.D r14, int r15) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.l.E(androidx.recyclerview.widget.RecyclerView$D, int):void");
    }

    public void F0(String str, TextView textView) {
        new Thread(new e(str, textView)).start();
    }

    public final void J0(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleX", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    public final void K0(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleY", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    public RecyclerView.D L(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new G(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.I1, viewGroup, false));
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.k3, viewGroup, false);
        ImageView findViewById = inflate.findViewById(a7.f.i5);
        if (this.l.equalsIgnoreCase("Arabic")) {
            findViewById.setImageResource(a7.e.W0);
        }
        return new g(inflate);
    }

    public final void L0(g gVar) {
        new f(gVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new g[]{gVar});
    }

    public void N0(ProgressBar progressBar) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public final boolean O0(RecyclerView.o oVar, int i) {
        int i2 = this.m + i;
        if (i2 < 0 || i2 >= n()) {
            return false;
        }
        x(this.m);
        this.m = i2;
        x(i2);
        oVar.U1(this.m);
        return true;
    }

    public int n() {
        return this.n.size();
    }

    public int p(int i) {
        return this.n.get(i) instanceof NativeAd ? 1 : 0;
    }
}
