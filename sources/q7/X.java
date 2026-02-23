package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class x extends RecyclerView.g {
    public GridLayoutManager A;
    public TextView B;
    public TextView C;
    public z7.h D;
    public PopupWindow E;
    public ArrayList F;
    public ArrayList G;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public DatabaseHandler L;
    public List d;
    public Context e;
    public List f;
    public List g;
    public LiveStreamDBHandler h;
    public DatabaseHandler i;
    public RecyclerView n;
    public ProgressBar o;
    public RelativeLayout p;
    public AppBarLayout r;
    public PopupWindow s;
    public ArrayList u;
    public ArrayList v;
    public ArrayList w;
    public ArrayList x;
    public y z;
    public boolean j = true;
    public int k = 0;
    public AsyncTask l = null;
    public int m = 0;
    public AsyncTask q = null;
    public AsyncTask t = null;
    public String y = "";
    public ArrayList H = new ArrayList();

    public class a implements View.OnKeyListener {
        public final /* synthetic */ RecyclerView a;

        public a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            x xVar;
            int i2;
            RecyclerView.o layoutManager = this.a.getLayoutManager();
            if (keyEvent.getAction() != 0) {
                return false;
            }
            if (i == 20) {
                xVar = x.this;
                i2 = 1;
            } else {
                if (i != 19) {
                    return false;
                }
                xVar = x.this;
                i2 = -1;
            }
            return x.j0(xVar, layoutManager, i2);
        }
    }

    public class b implements Comparator {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel, LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2) {
            return liveStreamCategoryIdDBModel.getLiveStreamCategoryName().compareTo(liveStreamCategoryIdDBModel2.getLiveStreamCategoryName());
        }
    }

    public class c implements Comparator {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel, LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel2) {
            return liveStreamCategoryIdDBModel2.getLiveStreamCategoryName().compareTo(liveStreamCategoryIdDBModel.getLiveStreamCategoryName());
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ h a;
        public final /* synthetic */ String c;

        public d(h hVar, String str) {
            this.a = hVar;
            this.c = str;
        }

        public void onClick(View view) {
            x.k0(x.this, this.a.p());
            x xVar = x.this;
            x.p0(xVar, x.n0(xVar), view, this.c);
        }
    }

    public class f extends AsyncTask {
        public h a;

        public f(h hVar) {
            this.a = hVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(h... hVarArr) {
            try {
                return SharepreferenceDBHandler.getCurrentAPPType(x.n0(x.this)).equals("m3u") ? Integer.valueOf(x.l0(x.this).getFavouriteCountM3U("live")) : Integer.valueOf(x.m0(x.this).getFavouriteCount("live", SharepreferenceDBHandler.getUserID(x.n0(x.this))));
            } catch (Exception unused) {
                return 0;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (num.intValue() == 0 || num.intValue() == -1) {
                this.a.y.setText("0");
            } else {
                this.a.y.setText(String.valueOf(num));
            }
            this.a.y.setVisibility(0);
        }

        public void onPreExecute() {
            super.onPreExecute();
            this.a.y.setVisibility(8);
        }
    }

    public class g extends AsyncTask {
        public g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r0 = 0
                r6 = r6[r0]     // Catch: java.lang.Exception -> L54
                int r1 = r6.hashCode()     // Catch: java.lang.Exception -> L54
                r2 = -74797390(0xfffffffffb8aaeb2, float:-1.4401604E36)
                r3 = 2
                r4 = 1
                if (r1 == r2) goto L2c
                r2 = 47612238(0x2d6814e, float:3.1518691E-37)
                if (r1 == r2) goto L22
                r2 = 613425326(0x249020ae, float:6.2505407E-17)
                if (r1 == r2) goto L19
                goto L36
            L19:
                java.lang.String r1 = "all_channels"
                boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L54
                if (r6 == 0) goto L36
                goto L37
            L22:
                java.lang.String r0 = "all_channels_with_cat"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L54
                if (r6 == 0) goto L36
                r0 = 1
                goto L37
            L2c:
                java.lang.String r0 = "get_fav"
                boolean r6 = r6.equals(r0)     // Catch: java.lang.Exception -> L54
                if (r6 == 0) goto L36
                r0 = 2
                goto L37
            L36:
                r0 = -1
            L37:
                if (r0 == 0) goto L4d
                if (r0 == r4) goto L46
                if (r0 == r3) goto L3f
                r6 = 0
                return r6
            L3f:
                q7.x r6 = q7.x.this     // Catch: java.lang.Exception -> L54
                java.lang.String r6 = r6.O0()     // Catch: java.lang.Exception -> L54
                return r6
            L46:
                q7.x r6 = q7.x.this     // Catch: java.lang.Exception -> L54
                java.lang.String r6 = q7.x.r0(r6)     // Catch: java.lang.Exception -> L54
                return r6
            L4d:
                q7.x r6 = q7.x.this     // Catch: java.lang.Exception -> L54
                java.lang.String r6 = q7.x.q0(r6)     // Catch: java.lang.Exception -> L54
                return r6
            L54:
                java.lang.String r6 = "error"
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.x.g.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            try {
                if (x.s0(x.this) == null || x.s0(x.this).size() == 0) {
                    ProgressBar progressBar = x.this.o;
                    if (progressBar != null) {
                        progressBar.setVisibility(4);
                        x.x0(x.this).setVisibility(0);
                    }
                } else {
                    x xVar = x.this;
                    x.t0(xVar, x.s0(xVar));
                }
            } catch (Exception unused) {
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static class h extends RecyclerView.D {
        public TextView t;
        public ProgressBar u;
        public RelativeLayout v;
        public RelativeLayout w;
        public RelativeLayout x;
        public TextView y;
        public ImageView z;

        public h(View view) {
            super(view);
            this.t = view.findViewById(a7.f.fk);
            this.u = view.findViewById(a7.f.oc);
            this.v = view.findViewById(a7.f.Re);
            this.w = view.findViewById(a7.f.ze);
            this.x = view.findViewById(a7.f.Wg);
            this.y = view.findViewById(a7.f.Vl);
            this.z = view.findViewById(a7.f.i5);
            J(false);
        }
    }

    public class i implements View.OnFocusChangeListener {
        public final View a;

        public i(View view) {
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

    public x(List list, Context context, z7.h hVar, PopupWindow popupWindow, int i2) {
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        arrayList.addAll(list);
        this.g = list;
        this.d = list;
        this.e = context;
        this.h = new LiveStreamDBHandler(context);
        this.i = new DatabaseHandler(context);
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.D = hVar;
        this.E = popupWindow;
        this.L = new DatabaseHandler(context);
        String liveActivitynewFlowSort = SharepreferenceDBHandler.getLiveActivitynewFlowSort(context);
        if (liveActivitynewFlowSort.equals("1")) {
            Collections.sort(list, new b());
        }
        if (liveActivitynewFlowSort.equals("2")) {
            Collections.sort(list, new c());
        }
    }

    private String A0() {
        try {
            ArrayList arrayList = this.u;
            if (arrayList != null && this.v != null) {
                arrayList.clear();
                this.v.clear();
            }
            int parentalStatusCount = this.h.getParentalStatusCount(SharepreferenceDBHandler.getUserID(this.e));
            ArrayList allLiveStreasWithCategoryId = this.h.getAllLiveStreasWithCategoryId("0", "live");
            this.G = allLiveStreasWithCategoryId;
            if (parentalStatusCount <= 0 || allLiveStreasWithCategoryId == null) {
                this.u = allLiveStreasWithCategoryId;
                return "all_channels";
            }
            ArrayList arrayList2 = this.H;
            if (arrayList2 != null) {
                this.w = R0(allLiveStreasWithCategoryId, arrayList2);
            }
            this.u = this.w;
            return "all_channels";
        } catch (Exception unused) {
            return "all_channels";
        }
    }

    private String F0() {
        try {
            ArrayList arrayList = this.u;
            if (arrayList != null && this.v != null) {
                arrayList.clear();
                this.v.clear();
            }
            LiveStreamDBHandler liveStreamDBHandler = this.h;
            if (liveStreamDBHandler != null) {
                this.x = liveStreamDBHandler.getAllLiveStreasWithCategoryId(this.y, "live");
            }
            this.u = this.x;
            return "all_channels_with_cat";
        } catch (Exception unused) {
            return "all_channels_with_cat";
        }
    }

    private void L0() {
        AsyncTask asyncTask = this.t;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            SharepreferenceDBHandler.setAsyncTaskStatus(0, this.e);
        } else {
            SharepreferenceDBHandler.setAsyncTaskStatus(1, this.e);
            this.t.cancel(true);
        }
    }

    private ArrayList Q0() {
        ArrayList allPasswordStatus = this.h.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.e));
        this.I = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.H.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.H;
    }

    private ArrayList R0(ArrayList arrayList, ArrayList arrayList2) {
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) it.next();
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        this.v.add(liveStreamsDBModel);
                        break;
                    }
                    if (liveStreamsDBModel.getCategoryId().equals((String) it2.next())) {
                        break;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return this.v;
    }

    private ArrayList S0(ArrayList arrayList, ArrayList arrayList2) {
        try {
            this.K = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        this.K.add(favouriteDBModel);
                        break;
                    }
                    if (favouriteDBModel.getCategoryID().equals((String) it2.next())) {
                        break;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return this.K;
    }

    private ArrayList W0(ArrayList arrayList, ArrayList arrayList2) {
        this.J = new ArrayList();
        if (arrayList == null) {
            return null;
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                if (arrayList2 != null) {
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            this.J.add(favouriteM3UModel);
                            break;
                        }
                        if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    }
                }
            }
            return this.J;
        } catch (Exception unused) {
            return null;
        }
    }

    private void a1(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleX", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private void b1(float f2, RelativeLayout relativeLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleY", new float[]{f2});
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private void d1(ArrayList arrayList) {
        this.z = new y(arrayList, this.e, this.s, this.D, this.E);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.e, 1);
        this.A = gridLayoutManager;
        this.n.setLayoutManager(gridLayoutManager);
        this.n.setItemAnimator(new androidx.recyclerview.widget.c());
        this.n.setAdapter(this.z);
        ProgressBar progressBar = this.o;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    private boolean e1(RecyclerView.o oVar, int i2) {
        int i3 = this.m + i2;
        if (i3 < 0 || i3 >= n()) {
            return false;
        }
        x(this.m);
        this.m = i3;
        x(i3);
        oVar.U1(this.m);
        return true;
    }

    public static /* synthetic */ boolean j0(x xVar, RecyclerView.o oVar, int i2) {
        return xVar.e1(oVar, i2);
    }

    public static /* synthetic */ int k0(x xVar, int i2) {
        xVar.m = i2;
        return i2;
    }

    public static /* synthetic */ LiveStreamDBHandler l0(x xVar) {
        return xVar.h;
    }

    public static /* synthetic */ DatabaseHandler m0(x xVar) {
        return xVar.i;
    }

    public static /* synthetic */ Context n0(x xVar) {
        return xVar.e;
    }

    public static /* synthetic */ void p0(x xVar, Context context, View view, String str) {
        xVar.K0(context, view, str);
    }

    public static /* synthetic */ String q0(x xVar) {
        return xVar.A0();
    }

    public static /* synthetic */ String r0(x xVar) {
        return xVar.F0();
    }

    public static /* synthetic */ ArrayList s0(x xVar) {
        return xVar.u;
    }

    public static /* synthetic */ void t0(x xVar, ArrayList arrayList) {
        xVar.d1(arrayList);
    }

    public static /* synthetic */ TextView x0(x xVar) {
        return xVar.C;
    }

    public void B0() {
        L0();
        this.t = new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels_with_cat"});
    }

    public void D(RecyclerView recyclerView) {
        super.D(recyclerView);
        recyclerView.setOnKeyListener(new a(recyclerView));
    }

    public void J0() {
        L0();
        this.t = new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"get_fav"});
    }

    public final void K0(Context context, View view, String str) {
        this.y = str;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a7.g.U1, view.findViewById(a7.f.M9));
        this.o = inflate.findViewById(a7.f.ec);
        this.n = inflate.findViewById(a7.f.ub);
        this.p = inflate.findViewById(a7.f.Oe);
        this.r = inflate.findViewById(a7.f.W);
        this.B = inflate.findViewById(a7.f.Jl);
        this.C = inflate.findViewById(a7.f.Qb);
        this.B.setText(context.getResources().getString(a7.j.T2));
        PopupWindow popupWindow = new PopupWindow(context);
        this.s = popupWindow;
        popupWindow.setContentView(inflate);
        this.s.setWidth(-1);
        this.s.setHeight(-1);
        this.s.setFocusable(true);
        this.s.setOnDismissListener(new e());
        ProgressBar progressBar = this.o;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        AppBarLayout appBarLayout = this.r;
        if (appBarLayout != null) {
            appBarLayout.setBackground(context.getResources().getDrawable(a7.c.C));
        }
        this.H = Q0();
        String str2 = this.y;
        if (str2 == null || str2.equals("") || !this.y.equals("0")) {
            String str3 = this.y;
            if (str3 == null || str3.equals("") || !this.y.equals("-1")) {
                B0();
            } else {
                J0();
            }
        } else {
            z0();
        }
        this.s.showAtLocation(inflate, 1, 0, 0);
    }

    public void N0() {
        String categoryID;
        String valueOf;
        String timestamp;
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.e).equals("m3u")) {
                new ArrayList();
                LiveStreamDBHandler liveStreamDBHandler = this.h;
                if (liveStreamDBHandler != null) {
                    ArrayList favouriteM3U = liveStreamDBHandler.getFavouriteM3U("live");
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = this.H;
                    if (arrayList2 != null && arrayList2.size() > 0 && favouriteM3U != null && favouriteM3U.size() > 0) {
                        favouriteM3U = W0(favouriteM3U, this.H);
                    }
                    if (favouriteM3U == null || favouriteM3U.size() <= 0) {
                        return;
                    }
                    Iterator it = favouriteM3U.iterator();
                    while (it.hasNext()) {
                        FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                        ArrayList m3UFavouriteRow = this.h.getM3UFavouriteRow(favouriteM3UModel.getCategoryID(), favouriteM3UModel.getUrl(), favouriteM3UModel.getTimestamp());
                        if (m3UFavouriteRow != null && m3UFavouriteRow.size() > 0) {
                            arrayList.add((LiveStreamsDBModel) m3UFavouriteRow.get(0));
                        }
                    }
                    if (arrayList.size() != 0) {
                        this.F = arrayList;
                        return;
                    }
                    return;
                }
                return;
            }
            new ArrayList();
            DatabaseHandler databaseHandler = this.L;
            if (databaseHandler != null) {
                ArrayList allFavourites = databaseHandler.getAllFavourites("live", SharepreferenceDBHandler.getUserID(this.e));
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = this.H;
                if (arrayList4 != null && arrayList4.size() > 0 && allFavourites != null && allFavourites.size() > 0) {
                    allFavourites = S0(allFavourites, this.H);
                }
                if (allFavourites == null || allFavourites.size() <= 0) {
                    return;
                }
                Iterator it2 = allFavourites.iterator();
                while (it2.hasNext()) {
                    FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it2.next();
                    LiveStreamDBHandler liveStreamDBHandler2 = new LiveStreamDBHandler(this.e);
                    if (SharepreferenceDBHandler.getCurrentAPPType(this.e).equalsIgnoreCase("onestream_api")) {
                        categoryID = favouriteDBModel.getCategoryID();
                        valueOf = String.valueOf(favouriteDBModel.getStreamIDOneStream());
                        timestamp = favouriteDBModel.getTimestamp();
                    } else {
                        categoryID = favouriteDBModel.getCategoryID();
                        valueOf = String.valueOf(favouriteDBModel.getStreamID());
                        timestamp = favouriteDBModel.getTimestamp();
                    }
                    LiveStreamsDBModel liveStreamFavouriteRow = liveStreamDBHandler2.getLiveStreamFavouriteRow(categoryID, valueOf, timestamp, "live");
                    if (liveStreamFavouriteRow != null) {
                        arrayList3.add(liveStreamFavouriteRow);
                    }
                }
                if (arrayList3.size() != 0) {
                    this.F = arrayList3;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String O0() {
        try {
            ArrayList arrayList = this.u;
            if (arrayList != null && this.v != null) {
                arrayList.clear();
                this.v.clear();
            }
            this.F = new ArrayList();
            N0();
            this.u = this.F;
            return "get_fav";
        } catch (Exception unused) {
            return "get_fav";
        }
    }

    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void E(h hVar, int i2) {
        LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) this.d.get(i2);
        String liveStreamCategoryName = liveStreamCategoryIdDBModel.getLiveStreamCategoryName();
        String liveStreamCategoryID = liveStreamCategoryIdDBModel.getLiveStreamCategoryID();
        Bundle bundle = new Bundle();
        bundle.putString("category_id", liveStreamCategoryID);
        bundle.putString("category_name", liveStreamCategoryName);
        if (liveStreamCategoryName != null && !liveStreamCategoryName.equals("") && !liveStreamCategoryName.isEmpty()) {
            hVar.t.setText(liveStreamCategoryName);
        }
        if (SharepreferenceDBHandler.getCurrentAPPType(this.e).equals("m3u")) {
            if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equals("-1")) {
                c1(hVar);
            } else {
                hVar.y.setText(String.valueOf(liveStreamCategoryIdDBModel.getLiveStreamCounter()));
            }
            if (liveStreamCategoryID.equals("0")) {
                this.k = liveStreamCategoryIdDBModel.getLiveStreamCounter();
            }
        } else {
            if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equals("-1")) {
                c1(hVar);
            } else {
                hVar.y.setText(String.valueOf(liveStreamCategoryIdDBModel.getLiveStreamCounter()));
            }
            if (liveStreamCategoryID.equals("0")) {
                int streamsCount = this.h.getStreamsCount("live");
                if (streamsCount == 0 || streamsCount == -1) {
                    hVar.y.setText("");
                } else {
                    hVar.y.setText(String.valueOf(streamsCount));
                }
            }
        }
        if (new u7.a(this.e).A().equals(m7.a.K0) && i2 == this.m) {
            hVar.v.requestFocus();
            a1(1.09f, hVar.v);
            b1(1.09f, hVar.v);
            hVar.v.setBackgroundResource(a7.e.q2);
        }
        hVar.v.setOnClickListener(new d(hVar, liveStreamCategoryID));
        RelativeLayout relativeLayout = hVar.v;
        relativeLayout.setOnFocusChangeListener(new i(relativeLayout));
    }

    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public h L(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.k3, viewGroup, false);
        ImageView findViewById = inflate.findViewById(a7.f.i5);
        if (SharepreferenceDBHandler.getSelectedLanguage(this.e).equalsIgnoreCase("Arabic")) {
            findViewById.setImageResource(a7.e.W0);
        }
        return new h(inflate);
    }

    public final void c1(h hVar) {
        new f(hVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new h[]{hVar});
    }

    public int n() {
        return this.d.size();
    }

    public void z0() {
        L0();
        this.t = new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{"all_channels"});
    }

    public class e implements PopupWindow.OnDismissListener {
        public e() {
        }

        public void onDismiss() {
        }
    }
}
