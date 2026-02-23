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
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class j0 extends RecyclerView.g {
    public List d;
    public Context e;
    public LiveStreamDBHandler f;
    public List g;
    public List h;
    public int i;
    public int j;
    public DatabaseHandler k;
    public int l;
    public RecentWatchDBHandler m;
    public String n;
    public int o;
    public int p;

    public class a implements View.OnKeyListener {
        public final /* synthetic */ RecyclerView a;

        public a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            j0 j0Var;
            int i2;
            RecyclerView.o layoutManager = this.a.getLayoutManager();
            if (keyEvent.getAction() != 0) {
                return false;
            }
            if (i == 20) {
                j0Var = j0.this;
                i2 = 1;
            } else {
                if (i != 19) {
                    return false;
                }
                j0Var = j0.this;
                i2 = -1;
            }
            return j0.j0(j0Var, layoutManager, i2);
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
            j0.k0(j0.this, this.a.p());
            Intent intent = new Intent(j0.l0(j0.this), VodActivityNewFlowSubCategories.class);
            intent.putExtra("category_id", this.c);
            intent.putExtra("category_name", this.d);
            j0.l0(j0.this).startActivity(intent);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                j0 j0Var;
                List m0;
                if (!TextUtils.isEmpty(e.this.a)) {
                    if (!j0.m0(j0.this).isEmpty() || j0.m0(j0.this).isEmpty()) {
                        j0Var = j0.this;
                        m0 = j0.m0(j0Var);
                    }
                    if (j0.q0(j0.this) != null && j0.q0(j0.this).size() == 0) {
                        e.this.c.setVisibility(0);
                        e eVar = e.this;
                        eVar.c.setText(j0.l0(j0.this).getResources().getString(a7.j.y4));
                    }
                    j0 j0Var2 = j0.this;
                    j0Var2.i = j0Var2.j;
                    j0Var2.w();
                }
                j0Var = j0.this;
                m0 = j0.p0(j0Var);
                j0.r0(j0Var, m0);
                if (j0.q0(j0.this) != null) {
                    e.this.c.setVisibility(0);
                    e eVar2 = e.this;
                    eVar2.c.setText(j0.l0(j0.this).getResources().getString(a7.j.y4));
                }
                j0 j0Var22 = j0.this;
                j0Var22.i = j0Var22.j;
                j0Var22.w();
            }
        }

        public e(String str, TextView textView) {
            this.a = str;
            this.c = textView;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                q7.j0 r0 = q7.j0.this
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                q7.j0.n0(r0, r1)
                q7.j0 r0 = q7.j0.this
                java.lang.String r1 = r4.a
                int r1 = r1.length()
                r0.j = r1
                q7.j0 r0 = q7.j0.this
                java.util.List r0 = q7.j0.m0(r0)
                if (r0 == 0) goto L25
                q7.j0 r0 = q7.j0.this
                java.util.List r0 = q7.j0.m0(r0)
                r0.clear()
            L25:
                java.lang.String r0 = r4.a
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L3d
                q7.j0 r0 = q7.j0.this
                java.util.List r0 = q7.j0.m0(r0)
                q7.j0 r1 = q7.j0.this
                java.util.List r1 = q7.j0.p0(r1)
                r0.addAll(r1)
                goto La3
            L3d:
                q7.j0 r0 = q7.j0.this
                java.util.List r0 = q7.j0.q0(r0)
                if (r0 == 0) goto L51
                q7.j0 r0 = q7.j0.this
                java.util.List r0 = q7.j0.q0(r0)
                int r0 = r0.size()
                if (r0 == 0) goto L59
            L51:
                q7.j0 r0 = q7.j0.this
                int r1 = r0.i
                int r0 = r0.j
                if (r1 <= r0) goto L62
            L59:
                q7.j0 r0 = q7.j0.this
                java.util.List r1 = q7.j0.p0(r0)
                q7.j0.r0(r0, r1)
            L62:
                q7.j0 r0 = q7.j0.this
                java.util.List r0 = q7.j0.q0(r0)
                if (r0 == 0) goto La3
                r0 = 0
            L6b:
                q7.j0 r1 = q7.j0.this
                java.util.List r1 = q7.j0.q0(r1)
                int r1 = r1.size()
                if (r0 >= r1) goto La3
                q7.j0 r1 = q7.j0.this     // Catch: java.lang.Exception -> La0
                java.util.List r1 = q7.j0.q0(r1)     // Catch: java.lang.Exception -> La0
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Exception -> La0
                q7.w r1 = (q7.w) r1     // Catch: java.lang.Exception -> La0
                java.lang.String r2 = r1.b()     // Catch: java.lang.Exception -> La0
                java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Exception -> La0
                java.lang.String r3 = r4.a     // Catch: java.lang.Exception -> La0
                java.lang.String r3 = r3.toLowerCase()     // Catch: java.lang.Exception -> La0
                boolean r2 = r2.contains(r3)     // Catch: java.lang.Exception -> La0
                if (r2 == 0) goto La0
                q7.j0 r2 = q7.j0.this     // Catch: java.lang.Exception -> La0
                java.util.List r2 = q7.j0.m0(r2)     // Catch: java.lang.Exception -> La0
                r2.add(r1)     // Catch: java.lang.Exception -> La0
            La0:
                int r0 = r0 + 1
                goto L6b
            La3:
                q7.j0 r0 = q7.j0.this
                android.content.Context r0 = q7.j0.l0(r0)
                android.app.Activity r0 = (android.app.Activity) r0
                q7.j0$e$a r1 = new q7.j0$e$a
                r1.<init>()
                r0.runOnUiThread(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.j0.e.run():void");
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

    public class g extends AsyncTask {
        public h a;

        public g(h hVar) {
            this.a = hVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(h... hVarArr) {
            try {
                return SharepreferenceDBHandler.getCurrentAPPType(j0.l0(j0.this)).equals("m3u") ? Integer.valueOf(j0.s0(j0.this).getFavouriteCountM3U("movie")) : Integer.valueOf(j0.t0(j0.this).getFavouriteCount("vod", SharepreferenceDBHandler.getUserID(j0.l0(j0.this))));
            } catch (Exception unused) {
                return 0;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (num.intValue() == 0 || num.intValue() == -1) {
                this.a.z.setText("0");
            } else {
                this.a.z.setText(String.valueOf(num));
            }
            this.a.z.setVisibility(0);
        }

        public void onPreExecute() {
            super.onPreExecute();
            this.a.z.setVisibility(8);
        }
    }

    public static class h extends RecyclerView.D {
        public ImageView t;
        public TextView u;
        public ImageView v;
        public ProgressBar w;
        public RelativeLayout x;
        public RelativeLayout y;
        public TextView z;

        public h(View view) {
            super(view);
            this.t = view.findViewById(a7.f.h6);
            this.u = view.findViewById(a7.f.fk);
            this.v = view.findViewById(a7.f.i5);
            this.w = view.findViewById(a7.f.oc);
            this.x = view.findViewById(a7.f.ze);
            this.y = view.findViewById(a7.f.Re);
            this.z = view.findViewById(a7.f.Vl);
            J(false);
        }
    }

    public j0() {
        this.l = -1;
        this.n = "";
        this.o = 0;
        this.p = 0;
    }

    private void A0(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleY", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private boolean J0(RecyclerView.o oVar, int i) {
        int i2 = this.p + i;
        if (i2 < 0 || i2 >= n()) {
            return false;
        }
        x(this.p);
        this.p = i2;
        x(i2);
        oVar.U1(this.p);
        return true;
    }

    public static /* synthetic */ boolean j0(j0 j0Var, RecyclerView.o oVar, int i) {
        return j0Var.J0(oVar, i);
    }

    public static /* synthetic */ int k0(j0 j0Var, int i) {
        j0Var.p = i;
        return i;
    }

    public static /* synthetic */ Context l0(j0 j0Var) {
        return j0Var.e;
    }

    public static /* synthetic */ List m0(j0 j0Var) {
        return j0Var.g;
    }

    public static /* synthetic */ List n0(j0 j0Var, List list) {
        j0Var.g = list;
        return list;
    }

    public static /* synthetic */ List p0(j0 j0Var) {
        return j0Var.h;
    }

    public static /* synthetic */ List q0(j0 j0Var) {
        return j0Var.d;
    }

    public static /* synthetic */ List r0(j0 j0Var, List list) {
        j0Var.d = list;
        return list;
    }

    public static /* synthetic */ LiveStreamDBHandler s0(j0 j0Var) {
        return j0Var.f;
    }

    public static /* synthetic */ DatabaseHandler t0(j0 j0Var) {
        return j0Var.k;
    }

    private void z0(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleX", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    public final void B0(h hVar) {
        new g(hVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new h[]{hVar});
    }

    public void D(RecyclerView recyclerView) {
        super.D(recyclerView);
        recyclerView.setOnKeyListener(new a(recyclerView));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0133, code lost:
    
        if (r1 != (-1)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014f, code lost:
    
        if (r1 != (-1)) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(androidx.recyclerview.widget.RecyclerView.D r17, int r18) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.j0.E(androidx.recyclerview.widget.RecyclerView$D, int):void");
    }

    public void F0(ProgressBar progressBar) {
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public RecyclerView.D L(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new G(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.I1, viewGroup, false));
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.r3, viewGroup, false);
        ImageView findViewById = inflate.findViewById(a7.f.i5);
        if (this.n.equalsIgnoreCase("Arabic")) {
            findViewById.setImageResource(a7.e.W0);
        }
        return new h(inflate);
    }

    public int n() {
        return this.d.size();
    }

    public int p(int i) {
        return this.d.get(i) instanceof NativeAd ? 1 : 0;
    }

    public void x0(String str, TextView textView) {
        new Thread(new e(str, textView)).start();
    }

    public j0(List list, Context context) {
        this.l = -1;
        this.n = "";
        this.o = 0;
        this.p = 0;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.addAll(list);
        this.h = list;
        this.d = list;
        this.e = context;
        this.f = new LiveStreamDBHandler(context);
        this.k = new DatabaseHandler(context);
        this.l = SharepreferenceDBHandler.getUserID(context);
        this.m = new RecentWatchDBHandler(context);
        String vodActivitynewFlowSort = SharepreferenceDBHandler.getVodActivitynewFlowSort(context);
        if (vodActivitynewFlowSort.equals("1")) {
            Collections.sort(list, new b());
        }
        if (vodActivitynewFlowSort.equals("2")) {
            Collections.sort(list, new c());
        }
    }
}
