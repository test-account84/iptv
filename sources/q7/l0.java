package q7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity;
import java.util.ArrayList;
import q7.Z;
import q7.m0;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class l0 extends RecyclerView.g implements Filterable, z7.g {
    public String f;
    public Context g;
    public DatabaseHandler h;
    public RecentWatchDBHandler i;
    public String k;
    public LiveStreamDBHandler l;
    public n7.e m;
    public b j = new b(this, null);
    public final ArrayList d = VodAllCategoriesSingleton.getInstance().getVodCategoriesList();
    public ArrayList e = VodAllCategoriesSingleton.getInstance().getVodCategoriesList();

    public class b extends Filter {
        public b() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            String lowerCase = charSequence.toString().toLowerCase();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList n0 = l0.n0(l0.this);
            int size = n0.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) n0.get(i);
                if (liveStreamCategoryIdDBModel.getLiveStreamCategoryName().toLowerCase().contains(lowerCase) || liveStreamCategoryIdDBModel.getLiveStreamCategoryName().contains(lowerCase)) {
                    arrayList.add(liveStreamCategoryIdDBModel);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            try {
                l0.q0(l0.this, (ArrayList) filterResults.values);
                l0.this.w();
                if (l0.p0(l0.this) == null || l0.p0(l0.this).size() != 0) {
                    l0.k0(l0.this).e2();
                } else {
                    l0.k0(l0.this).u2();
                }
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ b(l0 l0Var, a aVar) {
            this();
        }
    }

    public class c implements View.OnFocusChangeListener {
        public final View a;
        public final d b;
        public int c;

        public c(View view, d dVar, int i) {
            this.a = view;
            this.b = dVar;
            this.c = i;
        }

        public void onFocusChange(View view, boolean z) {
            d dVar;
            TextView textView;
            m7.a.a = this.c;
            if (!z || (dVar = this.b) == null || (textView = dVar.t) == null) {
                return;
            }
            textView.setTextColor(-1);
        }
    }

    public static class d extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public RelativeLayout v;

        public d(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Yh);
            this.u = view.findViewById(a7.f.Xh);
            this.v = view.findViewById(a7.f.nf);
        }
    }

    public class e extends AsyncTask {
        public d a;

        public e(d dVar) {
            this.a = dVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(d... dVarArr) {
            try {
                return SharepreferenceDBHandler.getCurrentAPPType(l0.k0(l0.this)).equals("m3u") ? Integer.valueOf(l0.l0(l0.this).getFavouriteCountM3U("movie")) : Integer.valueOf(l0.m0(l0.this).getFavouriteCount("vod", SharepreferenceDBHandler.getUserID(l0.k0(l0.this))));
            } catch (Exception unused) {
                return 0;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (num.intValue() == 0 || num.intValue() == -1) {
                this.a.u.setText("0");
            } else {
                this.a.u.setText(String.valueOf(num));
            }
            this.a.u.setVisibility(0);
        }

        public void onPreExecute() {
            super.onPreExecute();
            this.a.u.setVisibility(8);
        }
    }

    public l0(Context context, String str) {
        this.k = "mobile";
        this.g = context;
        this.h = new DatabaseHandler(context);
        this.l = new LiveStreamDBHandler(context);
        this.i = new RecentWatchDBHandler(context);
        this.f = str;
        this.m = new n7.e(this, context);
        if (new u7.a(context).A().equals(m7.a.K0)) {
            this.k = "tv";
        } else {
            this.k = "mobile";
        }
    }

    public static /* synthetic */ void j0(l0 l0Var, int i, d dVar, View view) {
        l0Var.r0(i, dVar, view);
    }

    public static /* synthetic */ Context k0(l0 l0Var) {
        return l0Var.g;
    }

    public static /* synthetic */ LiveStreamDBHandler l0(l0 l0Var) {
        return l0Var.l;
    }

    public static /* synthetic */ DatabaseHandler m0(l0 l0Var) {
        return l0Var.h;
    }

    public static /* synthetic */ ArrayList n0(l0 l0Var) {
        return l0Var.d;
    }

    public static /* synthetic */ ArrayList p0(l0 l0Var) {
        return l0Var.e;
    }

    public static /* synthetic */ ArrayList q0(l0 l0Var, ArrayList arrayList) {
        l0Var.e = arrayList;
        return arrayList;
    }

    public Filter getFilter() {
        return this.j;
    }

    public int n() {
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final /* synthetic */ void r0(int i, d dVar, View view) {
        this.g.z2();
        this.f = ((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryID();
        dVar.v.setBackground(this.g.getResources().getDrawable(a7.c.r));
        if (this.g instanceof VodAllDataSingleActivity) {
            AsyncTask asyncTask = m7.w.n;
            if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
                m7.w.n.cancel(true);
            }
            this.g.E2(i);
            this.g.t2(((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryID(), ((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryName());
        }
        w();
        if (SharepreferenceDBHandler.getCurrentAPPType(this.g).equals("stalker_api")) {
            dVar.u.setVisibility(8);
            m7.a.M0 = "-1";
        }
    }

    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void E(d dVar, int i) {
        String valueOf;
        TextView textView;
        RelativeLayout relativeLayout;
        Drawable f;
        try {
            dVar.t.setText(((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryName());
            if (SharepreferenceDBHandler.getCurrentAPPType(this.g).equals("stalker_api")) {
                dVar.u.setVisibility(8);
            } else if (((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryID().equalsIgnoreCase("-1")) {
                x0(dVar);
            } else {
                if (((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryID().equalsIgnoreCase("-4")) {
                    int vodRecentwatchmCount = this.i.getVodRecentwatchmCount();
                    if (vodRecentwatchmCount == 0 || vodRecentwatchmCount == -1) {
                        dVar.u.setText("0");
                    } else {
                        textView = dVar.u;
                        valueOf = String.valueOf(vodRecentwatchmCount);
                    }
                } else {
                    valueOf = String.valueOf(((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCounter());
                    textView = dVar.u;
                }
                textView.setText(valueOf);
            }
            dVar.v.setOnClickListener(new k0(this, i, dVar));
            if (this.f.equals(((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryID())) {
                if (!m7.a.M0.equals("-1")) {
                    dVar.u.setVisibility(0);
                    dVar.u.setText(m7.a.M0);
                }
                if (!this.g.S1()) {
                    dVar.v.setBackground(this.g.getResources().getDrawable(a7.c.r));
                    if (!this.g.p2()) {
                        dVar.v.requestFocus();
                    }
                    RelativeLayout relativeLayout2 = dVar.v;
                    relativeLayout2.setOnFocusChangeListener(new c(relativeLayout2, dVar, i));
                }
                relativeLayout = dVar.v;
                f = this.g.getResources().getDrawable(a7.c.r);
            } else {
                relativeLayout = dVar.v;
                f = F.h.f(this.g.getResources(), a7.e.X0, this.g.getTheme());
            }
            relativeLayout.setBackground(f);
            RelativeLayout relativeLayout22 = dVar.v;
            relativeLayout22.setOnFocusChangeListener(new c(relativeLayout22, dVar, i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public d L(ViewGroup viewGroup, int i) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.x4, viewGroup, false));
    }

    public final void x0(d dVar) {
        new e(dVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new d[]{dVar});
    }

    public void z0(String str) {
        this.f = str;
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public void H(String str) {
    }

    public void P0(String str) {
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public void c(String str) {
    }

    public void e(String str) {
    }

    public void e0(String str) {
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void o0(String str) {
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public void v0(String str) {
    }

    public void y0(String str) {
    }

    public void I(m0.x xVar, int i) {
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i) {
    }

    public void O(Z.E e2, int i) {
    }

    public void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e2, int i) {
    }

    public void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, m0.x xVar, int i) {
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
    }
}
