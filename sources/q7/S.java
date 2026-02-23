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
import com.nst.iptvsmarterstvbox.model.StalkerLiveFavIdsSingleton;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class s extends RecyclerView.g implements Filterable {
    public String f;
    public Context g;
    public DatabaseHandler h;
    public String j;
    public String k;
    public LiveStreamDBHandler l;
    public b i = new b(this, null);
    public final ArrayList d = VodAllCategoriesSingleton.getInstance().getLiveCategoriesList();
    public ArrayList e = VodAllCategoriesSingleton.getInstance().getLiveCategoriesList();

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ f c;

        public a(int i, f fVar) {
            this.a = i;
            this.c = fVar;
        }

        public void onClick(View view) {
            s.j0(s.this).n2();
            s sVar = s.this;
            s.k0(sVar, ((LiveStreamCategoryIdDBModel) s.l0(sVar).get(this.a)).getLiveStreamCategoryID());
            this.c.v.setBackground(s.j0(s.this).getResources().getDrawable(a7.c.r));
            if (s.j0(s.this) instanceof LiveAllDataSingleActivity) {
                AsyncTask asyncTask = m7.w.o;
                if (asyncTask != null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
                    m7.w.o.cancel(true);
                }
                s.j0(s.this).h2(((LiveStreamCategoryIdDBModel) s.l0(s.this).get(this.a)).getLiveStreamCategoryID(), ((LiveStreamCategoryIdDBModel) s.l0(s.this).get(this.a)).getLiveStreamCategoryName());
            }
            s.this.w();
        }
    }

    public class b extends Filter {
        public b() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            String lowerCase = charSequence.toString().toLowerCase();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList r0 = s.r0(s.this);
            int size = r0.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) r0.get(i);
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
                s.m0(s.this, (ArrayList) filterResults.values);
                s.this.w();
                if (s.l0(s.this) == null || s.l0(s.this).size() != 0) {
                    s.j0(s.this).W1();
                } else {
                    s.j0(s.this).i2();
                }
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ b(s sVar, a aVar) {
            this();
        }
    }

    public class c extends AsyncTask {
        public f a;

        public c(f fVar) {
            this.a = fVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(f... fVarArr) {
            int favouriteCount;
            if (SharepreferenceDBHandler.getCurrentAPPType(s.j0(s.this)).equals("m3u")) {
                favouriteCount = s.n0(s.this).getFavouriteCountM3U("live");
            } else if (SharepreferenceDBHandler.getCurrentAPPType(s.j0(s.this)).equals("stalker_api")) {
                List favIdsList = StalkerLiveFavIdsSingleton.getInstance().getFavIdsList();
                favouriteCount = (favIdsList == null || favIdsList.size() <= 0) ? 0 : favIdsList.size();
            } else {
                favouriteCount = s.p0(s.this).equals("true") ? s.q0(s.this).getFavouriteCount("radio_streams", SharepreferenceDBHandler.getUserID(s.j0(s.this))) : s.q0(s.this).getFavouriteCount("live", SharepreferenceDBHandler.getUserID(s.j0(s.this)));
            }
            return Integer.valueOf(favouriteCount);
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

    public class d extends AsyncTask {
        public f a;

        public d(f fVar) {
            this.a = fVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(f... fVarArr) {
            try {
                return s.p0(s.this).equals("true") ? Integer.valueOf(s.n0(s.this).liveRecentlyWatchedCount("radio_streams")) : Integer.valueOf(s.n0(s.this).liveRecentlyWatchedCount("live"));
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

    public class e implements View.OnFocusChangeListener {
        public final View a;
        public final f b;
        public int c;

        public e(View view, f fVar, int i) {
            this.a = view;
            this.b = fVar;
            this.c = i;
        }

        public void onFocusChange(View view, boolean z) {
            f fVar;
            TextView textView;
            if (!z || (fVar = this.b) == null || (textView = fVar.t) == null) {
                return;
            }
            textView.setTextColor(-1);
        }
    }

    public static class f extends RecyclerView.D {
        public TextView t;
        public TextView u;
        public RelativeLayout v;

        public f(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Yh);
            this.u = view.findViewById(a7.f.Xh);
            this.v = view.findViewById(a7.f.nf);
        }
    }

    public s(Context context, String str, String str2) {
        this.j = "mobile";
        this.k = "false";
        this.g = context;
        this.h = new DatabaseHandler(context);
        this.l = new LiveStreamDBHandler(context);
        this.f = str2;
        if (new u7.a(context).A().equals(m7.a.K0)) {
            this.j = "tv";
        } else {
            this.j = "mobile";
        }
        this.k = str;
    }

    public static /* synthetic */ Context j0(s sVar) {
        return sVar.g;
    }

    public static /* synthetic */ String k0(s sVar, String str) {
        sVar.f = str;
        return str;
    }

    public static /* synthetic */ ArrayList l0(s sVar) {
        return sVar.e;
    }

    public static /* synthetic */ ArrayList m0(s sVar, ArrayList arrayList) {
        sVar.e = arrayList;
        return arrayList;
    }

    public static /* synthetic */ LiveStreamDBHandler n0(s sVar) {
        return sVar.l;
    }

    public static /* synthetic */ String p0(s sVar) {
        return sVar.k;
    }

    public static /* synthetic */ DatabaseHandler q0(s sVar) {
        return sVar.h;
    }

    public static /* synthetic */ ArrayList r0(s sVar) {
        return sVar.d;
    }

    public void A0(String str) {
        this.f = str;
    }

    public Filter getFilter() {
        return this.i;
    }

    public int n() {
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void E(f fVar, int i) {
        RelativeLayout relativeLayout;
        Drawable f2;
        try {
            fVar.t.setText(((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryName());
            if (((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryID().equalsIgnoreCase("-1")) {
                x0(fVar);
            } else if (((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryID().equalsIgnoreCase("-6")) {
                z0(fVar);
            } else {
                fVar.u.setVisibility(0);
                fVar.u.setText(String.valueOf(((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCounter()));
            }
            fVar.v.setOnClickListener(new a(i, fVar));
            if (!this.f.equals(((LiveStreamCategoryIdDBModel) this.e.get(i)).getLiveStreamCategoryID())) {
                relativeLayout = fVar.v;
                f2 = F.h.f(this.g.getResources(), a7.e.X0, this.g.getTheme());
            } else {
                if (!this.g.I1()) {
                    fVar.v.setBackground(this.g.getResources().getDrawable(a7.c.r));
                    if (!this.g.d2()) {
                        fVar.v.requestFocus();
                    }
                    RelativeLayout relativeLayout2 = fVar.v;
                    relativeLayout2.setOnFocusChangeListener(new e(relativeLayout2, fVar, i));
                }
                relativeLayout = fVar.v;
                f2 = this.g.getResources().getDrawable(a7.c.r);
            }
            relativeLayout.setBackground(f2);
            RelativeLayout relativeLayout22 = fVar.v;
            relativeLayout22.setOnFocusChangeListener(new e(relativeLayout22, fVar, i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public f L(ViewGroup viewGroup, int i) {
        return new f(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.x4, viewGroup, false));
    }

    public final void x0(f fVar) {
        new c(fVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new f[]{fVar});
    }

    public final void z0(f fVar) {
        new d(fVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new f[]{fVar});
    }
}
