package q7;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.ExpandedControlsActivity;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.activity.LiveAllDataSingleActivity;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class u extends RecyclerView.g {
    public SharedPreferences.Editor C;
    public SharedPreferences D;
    public ArrayList d;
    public Context e;
    public DatabaseHandler g;
    public Animation h;
    public String i;
    public ProgressDialog k;
    public SharedPreferences n;
    public o4.e o;
    public Handler q;
    public LiveStreamDBHandler s;
    public ArrayList w;
    public Boolean f = Boolean.FALSE;
    public String j = "";
    public boolean l = false;
    public int m = -1;
    public String p = "";
    public int t = -1;
    public ArrayList u = new ArrayList();
    public String x = "";
    public String y = "";
    public int z = 0;
    public String A = "";
    public String B = "";
    public final ArrayList E = new ArrayList();
    public boolean F = false;
    public ArrayList r = new ArrayList();
    public ArrayList v = new ArrayList();

    public class b implements View.OnLongClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ m f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;

        public b(String str, String str2, String str3, int i, m mVar, int i2, int i3) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
            this.f = mVar;
            this.g = i2;
            this.h = i3;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(u.k0(u.this)).equals("m3u")) {
                ArrayList checkFavourite = u.x0(u.this).checkFavourite(this.a, SharepreferenceDBHandler.getUserID(u.k0(u.this)));
                u uVar = u.this;
                u.A0(uVar, checkFavourite, this.f, this.g, u.z0(uVar));
                return true;
            }
            ArrayList checkFavourite2 = u.B0(u.this).checkFavourite(this.e, this.d, "live", SharepreferenceDBHandler.getUserID(u.k0(u.this)), this.c);
            u uVar2 = u.this;
            u.F0(uVar2, checkFavourite2, this.f, this.g, u.z0(uVar2), this.h, this.f.u);
            return true;
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public e(String str, int i, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        public void onClick(View view) {
            try {
                u uVar = u.this;
                u.n0(uVar, o4.b.e(u.k0(uVar)).c().c());
            } catch (Exception unused) {
            }
            if (u.l0(u.this) == null || !u.l0(u.this).c()) {
                u.t0(u.this, this.c, this.f, this.a, this.g);
                return;
            }
            if (u.l0(u.this) != null && u.l0(u.this).r() != null && u.l0(u.this).r().j() != null && u.l0(u.this).r().j().J() != null) {
                u uVar2 = u.this;
                u.s0(uVar2, u.l0(uVar2).r().j().J());
            }
            String U = SharepreferenceDBHandler.getCurrentAPPType(u.k0(u.this)).equals("m3u") ? this.a : m7.w.U(u.k0(u.this), this.c, "m3u8", "live");
            if (u.r0(u.this).contains(String.valueOf(U))) {
                u.k0(u.this).startActivity(new Intent(u.k0(u.this), ExpandedControlsActivity.class));
                return;
            }
            n4.m mVar = new n4.m(1);
            mVar.M("com.google.android.gms.cast.metadata.TITLE", this.d);
            mVar.c(new x4.a(Uri.parse(this.e)));
            u uVar3 = u.this;
            i7.a.b(uVar3.q, u.l0(uVar3).r(), U, mVar, u.k0(u.this));
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public f(String str, int i, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        public void onClick(View view) {
            try {
                u uVar = u.this;
                u.n0(uVar, o4.b.e(u.k0(uVar)).c().c());
            } catch (Exception unused) {
            }
            if (u.l0(u.this) == null || !u.l0(u.this).c()) {
                u.t0(u.this, this.c, this.f, this.a, this.g);
                return;
            }
            if (u.l0(u.this) != null && u.l0(u.this).r() != null && u.l0(u.this).r().j() != null && u.l0(u.this).r().j().J() != null) {
                u uVar2 = u.this;
                u.s0(uVar2, u.l0(uVar2).r().j().J());
            }
            String U = SharepreferenceDBHandler.getCurrentAPPType(u.k0(u.this)).equals("m3u") ? this.a : m7.w.U(u.k0(u.this), this.c, "m3u8", "live");
            if (u.r0(u.this).contains(String.valueOf(U))) {
                u.k0(u.this).startActivity(new Intent(u.k0(u.this), ExpandedControlsActivity.class));
                return;
            }
            n4.m mVar = new n4.m(1);
            mVar.M("com.google.android.gms.cast.metadata.TITLE", this.d);
            mVar.c(new x4.a(Uri.parse(this.e)));
            u uVar3 = u.this;
            i7.a.b(uVar3.q, u.l0(uVar3).r(), U, mVar, u.k0(u.this));
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public g(String str, int i, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        public void onClick(View view) {
            try {
                u uVar = u.this;
                u.n0(uVar, o4.b.e(u.k0(uVar)).c().c());
            } catch (Exception unused) {
            }
            if (u.l0(u.this) == null || !u.l0(u.this).c()) {
                u.t0(u.this, this.c, this.f, this.a, this.g);
                return;
            }
            if (u.l0(u.this) != null && u.l0(u.this).r() != null && u.l0(u.this).r().j() != null && u.l0(u.this).r().j().J() != null) {
                u uVar2 = u.this;
                u.s0(uVar2, u.l0(uVar2).r().j().J());
            }
            String U = SharepreferenceDBHandler.getCurrentAPPType(u.k0(u.this)).equals("m3u") ? this.a : m7.w.U(u.k0(u.this), this.c, "m3u8", "live");
            if (u.r0(u.this).contains(String.valueOf(U))) {
                u.k0(u.this).startActivity(new Intent(u.k0(u.this), ExpandedControlsActivity.class));
                return;
            }
            n4.m mVar = new n4.m(1);
            mVar.M("com.google.android.gms.cast.metadata.TITLE", this.d);
            mVar.c(new x4.a(Uri.parse(this.e)));
            u uVar3 = u.this;
            i7.a.b(uVar3.q, u.l0(uVar3).r(), U, mVar, u.k0(u.this));
        }
    }

    public class h implements View.OnLongClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ m f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;

        public h(String str, String str2, String str3, int i, m mVar, int i2, int i3) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
            this.f = mVar;
            this.g = i2;
            this.h = i3;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(u.k0(u.this)).equals("m3u")) {
                ArrayList checkFavourite = u.x0(u.this).checkFavourite(this.a, SharepreferenceDBHandler.getUserID(u.k0(u.this)));
                u uVar = u.this;
                u.A0(uVar, checkFavourite, this.f, this.g, u.z0(uVar));
                return true;
            }
            ArrayList checkFavourite2 = u.B0(u.this).checkFavourite(this.e, this.d, "live", SharepreferenceDBHandler.getUserID(u.k0(u.this)), this.c);
            u uVar2 = u.this;
            u.F0(uVar2, checkFavourite2, this.f, this.g, u.z0(uVar2), this.h, this.f.u);
            return true;
        }
    }

    public class i implements View.OnLongClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ m f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;

        public i(String str, String str2, String str3, int i, m mVar, int i2, int i3) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
            this.f = mVar;
            this.g = i2;
            this.h = i3;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(u.k0(u.this)).equals("m3u")) {
                ArrayList checkFavourite = u.x0(u.this).checkFavourite(this.a, SharepreferenceDBHandler.getUserID(u.k0(u.this)));
                u uVar = u.this;
                u.A0(uVar, checkFavourite, this.f, this.g, u.z0(uVar));
                return true;
            }
            ArrayList checkFavourite2 = u.B0(u.this).checkFavourite(this.e, this.d, "live", SharepreferenceDBHandler.getUserID(u.k0(u.this)), this.c);
            u uVar2 = u.this;
            u.F0(uVar2, checkFavourite2, this.f, this.g, u.z0(uVar2), this.h, this.f.u);
            return true;
        }
    }

    public class j implements View.OnLongClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ m f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;

        public j(String str, String str2, String str3, int i, m mVar, int i2, int i3) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
            this.f = mVar;
            this.g = i2;
            this.h = i3;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(u.k0(u.this)).equals("m3u")) {
                ArrayList checkFavourite = u.x0(u.this).checkFavourite(this.a, SharepreferenceDBHandler.getUserID(u.k0(u.this)));
                u uVar = u.this;
                u.A0(uVar, checkFavourite, this.f, this.g, u.z0(uVar));
                return true;
            }
            ArrayList checkFavourite2 = u.B0(u.this).checkFavourite(this.e, this.d, "live", SharepreferenceDBHandler.getUserID(u.k0(u.this)), this.c);
            u uVar2 = u.this;
            u.F0(uVar2, checkFavourite2, this.f, this.g, u.z0(uVar2), this.h, this.f.u);
            return true;
        }
    }

    public class k extends AsyncTask {
        public k() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            try {
                return u.this.Q0(strArr[1]);
            } catch (Exception unused) {
                return "error";
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            u.q0(u.this);
            u.this.j0();
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public class l implements View.OnFocusChangeListener {
        public int a;

        public l(int i) {
            this.a = i;
        }

        public void onFocusChange(View view, boolean z) {
            u.this.m = z ? this.a : -1;
        }
    }

    public static class m extends RecyclerView.D {
        public RelativeLayout A;
        public TextView t;
        public RelativeLayout u;
        public ImageView v;
        public CardView w;
        public TextView x;
        public ImageView y;
        public LinearLayout z;

        public m(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Fl);
            this.u = view.findViewById(a7.f.Ge);
            this.v = view.findViewById(a7.f.B5);
            this.w = view.findViewById(a7.f.J1);
            this.x = view.findViewById(a7.f.Ul);
            this.y = view.findViewById(a7.f.g5);
            this.z = view.findViewById(a7.f.O8);
            this.A = view.findViewById(a7.f.Ie);
        }
    }

    public class n extends AsyncTask {
        public n() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return u.m0(u.this);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            u.p0(u.this);
        }

        public void onPreExecute() {
            u.J0(u.this);
            super.onPreExecute();
        }
    }

    public u(Context context, ArrayList arrayList) {
        this.i = "mobile";
        this.e = context;
        this.d = arrayList;
        this.g = new DatabaseHandler(context);
        this.h = AnimationUtils.loadAnimation(context, a7.b.a);
        this.s = new LiveStreamDBHandler(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("currentlyPlayingVideo", 0);
        this.D = sharedPreferences;
        this.C = sharedPreferences.edit();
        if (new u7.a(context).A().equals(m7.a.K0)) {
            this.i = "tv";
        } else {
            this.i = "mobile";
        }
        this.q = new Handler(Looper.getMainLooper());
        if (this.i.equals("mobile")) {
            try {
                this.o = o4.b.e(context).c().c();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void A0(u uVar, ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2) {
        uVar.O0(arrayList, d2, i2, arrayList2);
    }

    public static /* synthetic */ DatabaseHandler B0(u uVar) {
        return uVar.g;
    }

    public static /* synthetic */ void F0(u uVar, ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2, int i3, RelativeLayout relativeLayout) {
        uVar.N0(arrayList, d2, i2, arrayList2, i3, relativeLayout);
    }

    public static /* synthetic */ void J0(u uVar) {
        uVar.h1();
    }

    private void L0(RecyclerView.D d2, int i2, ArrayList arrayList) {
        m mVar = (m) d2;
        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
        favouriteM3UModel.setUrl(((LiveStreamsDBModel) arrayList.get(i2)).getUrl());
        favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(this.e));
        favouriteM3UModel.setName(((LiveStreamsDBModel) arrayList.get(i2)).getName());
        favouriteM3UModel.setCategoryID(((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId());
        this.s.addToFavourite(favouriteM3UModel);
        mVar.y.startAnimation(this.h);
        mVar.y.setVisibility(0);
    }

    private void O0(ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2) {
        if (arrayList.size() > 0) {
            c1(d2, i2, arrayList2);
        } else {
            L0(d2, i2, arrayList2);
        }
        this.l = true;
        LiveAllDataSingleActivity liveAllDataSingleActivity = this.e;
        if (liveAllDataSingleActivity instanceof LiveAllDataSingleActivity) {
            liveAllDataSingleActivity.j2();
        }
    }

    private void W0() {
        ProgressDialog progressDialog = this.k;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.k.dismiss();
    }

    private Boolean Y0() {
        try {
            if (this.e != null) {
                ArrayList arrayList = this.r;
                if (arrayList != null) {
                    arrayList.clear();
                }
                this.r = this.s.getAllliveCategories();
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = new LiveStreamCategoryIdDBModel();
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2 = new LiveStreamCategoryIdDBModel();
                LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel3 = new LiveStreamCategoryIdDBModel();
                int streamsCount = this.s.getStreamsCount("live");
                liveStreamCategoryIdDBModel.setLiveStreamCategoryID("0");
                liveStreamCategoryIdDBModel.setLiveStreamCategoryName(this.e.getResources().getString(a7.j.x));
                liveStreamCategoryIdDBModel.setLiveStreamCounter(streamsCount);
                liveStreamCategoryIdDBModel2.setLiveStreamCategoryID("-1");
                liveStreamCategoryIdDBModel2.setLiveStreamCategoryName(this.e.getResources().getString(a7.j.b2));
                int uncatCount = this.s.getUncatCount("-2", "live");
                this.t = uncatCount;
                if (uncatCount != 0 && uncatCount > 0) {
                    liveStreamCategoryIdDBModel3.setLiveStreamCategoryID("-2");
                    liveStreamCategoryIdDBModel3.setLiveStreamCategoryName(this.e.getResources().getString(a7.j.b8));
                    liveStreamCategoryIdDBModel3.setLiveStreamCounter(this.t);
                    ArrayList arrayList2 = this.r;
                    arrayList2.add(arrayList2.size(), liveStreamCategoryIdDBModel3);
                }
                this.r.add(0, liveStreamCategoryIdDBModel);
                this.r.add(1, liveStreamCategoryIdDBModel2);
            }
            return Boolean.TRUE;
        } catch (NullPointerException unused) {
            return Boolean.FALSE;
        } catch (Exception unused2) {
            return Boolean.FALSE;
        }
    }

    private void Z0() {
        new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    private void c1(RecyclerView.D d2, int i2, ArrayList arrayList) {
        this.s.deleteFavourite(((LiveStreamsDBModel) arrayList.get(i2)).getUrl(), SharepreferenceDBHandler.getUserID(this.e));
        ((m) d2).y.setVisibility(4);
    }

    private void f1() {
        ArrayList arrayList = this.r;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = this.v;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList arrayList3 = new ArrayList();
        this.v = arrayList3;
        arrayList3.addAll(this.r);
        int i2 = 0;
        while (true) {
            if (i2 >= this.r.size()) {
                break;
            }
            if (this.x.equals(String.valueOf(((LiveStreamCategoryIdDBModel) this.r.get(i2)).getLiveStreamCategoryID()))) {
                this.y = ((LiveStreamCategoryIdDBModel) this.r.get(i2)).getLiveStreamCategoryName();
                break;
            }
            i2++;
        }
        ArrayList arrayList4 = this.v;
        if (arrayList4 == null || arrayList4.size() <= 0) {
            return;
        }
        VodAllCategoriesSingleton.getInstance().setLiveCategoriesList(this.v);
        m7.w.o = new k().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_all", this.x});
    }

    private void h1() {
        ProgressDialog progressDialog = new ProgressDialog(this.e);
        this.k = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.k.setMessage(this.e.getResources().getString(a7.j.t5));
        this.k.show();
    }

    public static /* synthetic */ Context k0(u uVar) {
        return uVar.e;
    }

    public static /* synthetic */ o4.e l0(u uVar) {
        return uVar.o;
    }

    public static /* synthetic */ Boolean m0(u uVar) {
        return uVar.Y0();
    }

    public static /* synthetic */ o4.e n0(u uVar, o4.e eVar) {
        uVar.o = eVar;
        return eVar;
    }

    public static /* synthetic */ void p0(u uVar) {
        uVar.f1();
    }

    public static /* synthetic */ void q0(u uVar) {
        uVar.W0();
    }

    public static /* synthetic */ String r0(u uVar) {
        return uVar.p;
    }

    public static /* synthetic */ String s0(u uVar, String str) {
        uVar.p = str;
        return str;
    }

    public static /* synthetic */ void t0(u uVar, int i2, String str, String str2, String str3) {
        uVar.a1(i2, str, str2, str3);
    }

    public static /* synthetic */ LiveStreamDBHandler x0(u uVar) {
        return uVar.s;
    }

    public static /* synthetic */ ArrayList z0(u uVar) {
        return uVar.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x017e A[Catch: Exception -> 0x004c, TryCatch #1 {Exception -> 0x004c, blocks: (B:3:0x0022, B:5:0x0026, B:7:0x002c, B:9:0x0030, B:11:0x0048, B:12:0x004f, B:14:0x0055, B:15:0x005c, B:17:0x0062, B:18:0x0065, B:20:0x0071, B:22:0x007f, B:25:0x0085, B:29:0x00a1, B:31:0x00a7, B:32:0x00ae, B:34:0x00b4, B:35:0x00bb, B:37:0x00c1, B:38:0x00ca, B:40:0x00e0, B:41:0x00ed, B:45:0x0171, B:47:0x017e, B:49:0x0190, B:50:0x0192, B:51:0x01be, B:53:0x026b, B:55:0x026f, B:56:0x0196, B:57:0x0198, B:58:0x019c, B:60:0x01b8, B:61:0x01bb, B:43:0x0142, B:44:0x013e, B:65:0x0110, B:66:0x00e6, B:73:0x009d, B:78:0x027c, B:80:0x028c, B:82:0x0292, B:84:0x0296, B:88:0x029f, B:63:0x00f3, B:28:0x0096), top: B:2:0x0022, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019c A[Catch: Exception -> 0x004c, TryCatch #1 {Exception -> 0x004c, blocks: (B:3:0x0022, B:5:0x0026, B:7:0x002c, B:9:0x0030, B:11:0x0048, B:12:0x004f, B:14:0x0055, B:15:0x005c, B:17:0x0062, B:18:0x0065, B:20:0x0071, B:22:0x007f, B:25:0x0085, B:29:0x00a1, B:31:0x00a7, B:32:0x00ae, B:34:0x00b4, B:35:0x00bb, B:37:0x00c1, B:38:0x00ca, B:40:0x00e0, B:41:0x00ed, B:45:0x0171, B:47:0x017e, B:49:0x0190, B:50:0x0192, B:51:0x01be, B:53:0x026b, B:55:0x026f, B:56:0x0196, B:57:0x0198, B:58:0x019c, B:60:0x01b8, B:61:0x01bb, B:43:0x0142, B:44:0x013e, B:65:0x0110, B:66:0x00e6, B:73:0x009d, B:78:0x027c, B:80:0x028c, B:82:0x0292, B:84:0x0296, B:88:0x029f, B:63:0x00f3, B:28:0x0096), top: B:2:0x0022, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(androidx.recyclerview.widget.RecyclerView.D r25, int r26) {
        /*
            Method dump skipped, instructions count: 681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.u.E(androidx.recyclerview.widget.RecyclerView$D, int):void");
    }

    public final void K0(RecyclerView.D d2, int i2, ArrayList arrayList, int i3) {
        m mVar = (m) d2;
        FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
        favouriteDBModel.setCategoryID(((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId());
        favouriteDBModel.setStreamID(m7.w.r0(((LiveStreamsDBModel) arrayList.get(i2)).getStreamId()));
        favouriteDBModel.setStreamIDOneStream(((LiveStreamsDBModel) arrayList.get(i2)).getStreamId());
        favouriteDBModel.setName(((LiveStreamsDBModel) arrayList.get(i2)).getName());
        favouriteDBModel.setNum(((LiveStreamsDBModel) arrayList.get(i2)).getNum());
        favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(this.e));
        this.g.addToFavourite(favouriteDBModel, "live");
        mVar.y.startAnimation(this.h);
        mVar.y.setVisibility(0);
    }

    public RecyclerView.D L(ViewGroup viewGroup, int i2) {
        LayoutInflater from;
        int i3;
        if (this.i.equals("tv")) {
            from = LayoutInflater.from(viewGroup.getContext());
            i3 = a7.g.y3;
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i3 = a7.g.x3;
        }
        return new m(from.inflate(i3, viewGroup, false));
    }

    public final void N0(ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2, int i3, RelativeLayout relativeLayout) {
        if (arrayList.size() > 0) {
            b1(d2, i2, arrayList2, i3);
        } else {
            K0(d2, i2, arrayList2, i3);
        }
        this.l = true;
        LiveAllDataSingleActivity liveAllDataSingleActivity = this.e;
        if (liveAllDataSingleActivity instanceof LiveAllDataSingleActivity) {
            liveAllDataSingleActivity.j2();
        }
    }

    public String Q0(String str) {
        try {
            this.w = this.s.getAllLiveStreasWithCategoryId(str, "live");
            return "get_all";
        } catch (Exception unused) {
            return "get_all";
        }
    }

    public int R0() {
        return this.m;
    }

    public int S0(String str, String str2) {
        ArrayList arrayList = this.w;
        if (arrayList != null && arrayList.size() > 0) {
            if (str2.equals("m3u")) {
                for (int i2 = 0; i2 < this.w.size(); i2++) {
                    if (((LiveStreamsDBModel) this.w.get(i2)).getUrl().equals(str)) {
                        return i2;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.w.size(); i3++) {
                    if (((LiveStreamsDBModel) this.w.get(i3)).getStreamId().equals(str)) {
                        return i3;
                    }
                }
            }
        }
        return 0;
    }

    public final void a1(int i2, String str, String str2, String str3) {
        this.x = str;
        this.z = i2;
        this.B = str2;
        this.A = str3;
        Z0();
    }

    public final void b1(RecyclerView.D d2, int i2, ArrayList arrayList, int i3) {
        this.g.deleteFavourite(m7.w.r0(((LiveStreamsDBModel) arrayList.get(i2)).getStreamId()), ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId(), "live", ((LiveStreamsDBModel) arrayList.get(i2)).getName(), SharepreferenceDBHandler.getUserID(this.e), ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream());
        ((m) d2).y.setVisibility(4);
    }

    public void g1(ArrayList arrayList) {
        this.d = arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e A[Catch: Exception -> 0x00c2, TryCatch #0 {Exception -> 0x00c2, blocks: (B:3:0x0004, B:5:0x0010, B:6:0x0012, B:8:0x0034, B:10:0x003e, B:12:0x0046, B:14:0x004e, B:15:0x0061, B:18:0x0058, B:19:0x008f, B:21:0x0093, B:23:0x0099, B:25:0x00ba, B:27:0x0018, B:29:0x0024, B:30:0x002b), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008f A[Catch: Exception -> 0x00c2, TryCatch #0 {Exception -> 0x00c2, blocks: (B:3:0x0004, B:5:0x0010, B:6:0x0012, B:8:0x0034, B:10:0x003e, B:12:0x0046, B:14:0x004e, B:15:0x0061, B:18:0x0058, B:19:0x008f, B:21:0x0093, B:23:0x0099, B:25:0x00ba, B:27:0x0018, B:29:0x0024, B:30:0x002b), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j0() {
        /*
            r12 = this;
            java.lang.String r0 = "onestream_api"
            java.lang.String r1 = "m3u"
            android.content.Context r2 = r12.e     // Catch: java.lang.Exception -> Lc2
            java.lang.String r2 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r2)     // Catch: java.lang.Exception -> Lc2
            boolean r2 = r2.equals(r1)     // Catch: java.lang.Exception -> Lc2
            if (r2 == 0) goto L18
            java.lang.String r0 = r12.B     // Catch: java.lang.Exception -> Lc2
        L12:
            int r0 = r12.S0(r0, r1)     // Catch: java.lang.Exception -> Lc2
        L16:
            r5 = r0
            goto L34
        L18:
            android.content.Context r1 = r12.e     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getCurrentAPPType(r1)     // Catch: java.lang.Exception -> Lc2
            boolean r1 = r1.equals(r0)     // Catch: java.lang.Exception -> Lc2
            if (r1 == 0) goto L2b
            java.lang.String r1 = r12.A     // Catch: java.lang.Exception -> Lc2
            int r0 = r12.S0(r1, r0)     // Catch: java.lang.Exception -> Lc2
            goto L16
        L2b:
            int r0 = r12.z     // Catch: java.lang.Exception -> Lc2
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = "api"
            goto L12
        L34:
            java.lang.String r0 = r12.i     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = "tv"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> Lc2
            if (r0 == 0) goto L8f
            android.content.Context r0 = r12.e     // Catch: java.lang.Exception -> Lc2
            java.lang.String r0 = com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler.getLivePlayerPkgName(r0)     // Catch: java.lang.Exception -> Lc2
            if (r0 == 0) goto L58
            java.lang.String r1 = "default_native"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch: java.lang.Exception -> Lc2
            if (r0 == 0) goto L58
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> Lc2
            android.content.Context r1 = r12.e     // Catch: java.lang.Exception -> Lc2
            java.lang.Class<com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity> r2 = com.nst.iptvsmarterstvbox.view.demo.NSTEXOPlayerSkyTvActivity.class
            r0.<init>(r1, r2)     // Catch: java.lang.Exception -> Lc2
            goto L61
        L58:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> Lc2
            android.content.Context r1 = r12.e     // Catch: java.lang.Exception -> Lc2
            java.lang.Class<com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity> r2 = com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerSkyTvActivity.class
            r0.<init>(r1, r2)     // Catch: java.lang.Exception -> Lc2
        L61:
            java.lang.String r1 = "OPENED_STREAM_ID"
            int r2 = r12.z     // Catch: java.lang.Exception -> Lc2
            r0.putExtra(r1, r2)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = "VIDEO_NUM"
            r0.putExtra(r1, r5)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = "OPENED_CAT_ID"
            java.lang.String r2 = r12.x     // Catch: java.lang.Exception -> Lc2
            r0.putExtra(r1, r2)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = "VIDEO_URL"
            java.lang.String r2 = r12.B     // Catch: java.lang.Exception -> Lc2
            r0.putExtra(r1, r2)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = "OPENED_CAT_NAME"
            java.lang.String r2 = r12.y     // Catch: java.lang.Exception -> Lc2
            r0.putExtra(r1, r2)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r1 = "FROM_SEARCH"
            java.lang.String r2 = "true"
            r0.putExtra(r1, r2)     // Catch: java.lang.Exception -> Lc2
            android.content.Context r1 = r12.e     // Catch: java.lang.Exception -> Lc2
            r1.startActivity(r0)     // Catch: java.lang.Exception -> Lc2
            goto Lc2
        L8f:
            java.util.ArrayList r0 = r12.w     // Catch: java.lang.Exception -> Lc2
            if (r0 == 0) goto Lba
            int r0 = r0.size()     // Catch: java.lang.Exception -> Lc2
            if (r0 <= 0) goto Lba
            com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton r0 = com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton.getInstance()     // Catch: java.lang.Exception -> Lc2
            java.util.ArrayList r1 = r12.w     // Catch: java.lang.Exception -> Lc2
            r0.setLiveList(r1)     // Catch: java.lang.Exception -> Lc2
            android.content.Context r1 = r12.e     // Catch: java.lang.Exception -> Lc2
            java.lang.String r2 = "Built-in Player ( Default )"
            int r3 = r12.z     // Catch: java.lang.Exception -> Lc2
            java.lang.String r4 = "live"
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = r12.x     // Catch: java.lang.Exception -> Lc2
            java.lang.String r10 = r12.B     // Catch: java.lang.Exception -> Lc2
            java.lang.String r11 = r12.y     // Catch: java.lang.Exception -> Lc2
            m7.w.x0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> Lc2
            goto Lc2
        Lba:
            com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton r0 = com.nst.iptvsmarterstvbox.model.VodAllCategoriesSingleton.getInstance()     // Catch: java.lang.Exception -> Lc2
            r1 = 0
            r0.setLiveList(r1)     // Catch: java.lang.Exception -> Lc2
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.u.j0():void");
    }

    public int n() {
        ArrayList arrayList = this.d;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.d.size();
    }

    public int p(int i2) {
        return 0;
    }

    public void e1(m7.c cVar) {
    }

    public class a implements com.squareup.picasso.e {
        public final /* synthetic */ m a;

        public a(m mVar) {
            this.a = mVar;
        }

        public void a() {
            com.squareup.picasso.t.q(u.k0(u.this)).l(String.valueOf(u.k0(u.this).getResources().getDrawable(a7.e.B1))).e().b().h(this.a.v, new a());
            this.a.t.setVisibility(0);
        }

        public class a implements com.squareup.picasso.e {
            public a() {
            }

            public void a() {
            }

            public void onSuccess() {
            }
        }

        public void onSuccess() {
        }
    }

    public class c implements com.squareup.picasso.e {
        public c() {
        }

        public void a() {
        }

        public void onSuccess() {
        }
    }

    public class d implements com.squareup.picasso.e {
        public d() {
        }

        public void a() {
        }

        public void onSuccess() {
        }
    }

    public void d1() {
    }
}
