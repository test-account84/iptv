package com.nst.iptvsmarterstvbox.view.ijkplayer.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerMulti1;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerMulti2;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerMulti3;
import com.nst.iptvsmarterstvbox.view.ijkplayer.widget.media.NSTIJKPlayerMulti4;
import d4.B;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import m7.w;
import org.json.JSONObject;
import q7.x;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NSTIJKPlayerMultiActivity extends androidx.appcompat.app.b implements z7.h, View.OnClickListener, View.OnLongClickListener {
    public static String h1;
    public static String i1;
    public LiveStreamDBHandler A;
    public PopupWindow A0;
    public String B;
    public ArrayList B0;
    public String C;
    public ArrayList C0;
    public TextView D;
    public String E;
    public ArrayList E0;
    public TextView F;
    public ArrayList F0;
    public DateFormat G;
    public ArrayList G0;
    public ArrayList H0;
    public x J0;
    public GridLayoutManager K0;
    public RecyclerView L0;
    public ProgressBar M0;
    public RelativeLayout N0;
    public AppBarLayout P0;
    public TextView Q0;
    public ProgressBar R0;
    public ProgressBar S0;
    public ProgressBar T0;
    public ProgressBar U0;
    public ImageView V0;
    public ImageView W0;
    public SimpleDateFormat X;
    public ImageView X0;
    public NSTIJKPlayerMulti1 Y;
    public ImageView Y0;
    public NSTIJKPlayerMulti2 Z;
    public ImageView Z0;
    public ImageView a1;
    public Runnable b1;
    public Handler c1;
    public Context d;
    public String e;
    public NSTIJKPlayerMulti3 e0;
    public SharedPreferences e1;
    public LinearLayout f;
    public NSTIJKPlayerMulti4 f0;
    public String f1;
    public LinearLayout g;
    public Date g0;
    public LinearLayout h;
    public LinearLayout i;
    public String i0;
    public TextView j;
    public String j0;
    public TextView k;
    public SharedPreferences k0;
    public TextView l;
    public u7.a l0;
    public TextView m;
    public LinearLayout n;
    public LinearLayout o;
    public LinearLayout p;
    public LinearLayout q;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;
    public PopupWindow z0;
    public boolean r = false;
    public String H = "";
    public String I = "";
    public String J = "";
    public String K = "";
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public int O = 0;
    public String P = "";
    public String Q = "";
    public String R = "";
    public String S = "";
    public String T = "";
    public String U = "";
    public String V = "";
    public String W = "";
    public Boolean h0 = Boolean.TRUE;
    public int m0 = 0;
    public String n0 = "";
    public String o0 = "";
    public String p0 = "";
    public String q0 = "";
    public String r0 = "";
    public String s0 = "";
    public String t0 = "";
    public String u0 = "";
    public String v0 = "";
    public String w0 = "";
    public String x0 = "";
    public String y0 = "";
    public ArrayList D0 = new ArrayList();
    public int I0 = 0;
    public AsyncTask O0 = null;
    public View d1 = null;
    public final boolean[] g1 = {false};

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public void onDismiss() {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity = NSTIJKPlayerMultiActivity.this;
            NSTIJKPlayerMultiActivity.u1(nSTIJKPlayerMultiActivity, nSTIJKPlayerMultiActivity.d);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            if (NSTIJKPlayerMultiActivity.v1(NSTIJKPlayerMultiActivity.this) == null) {
                NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity = NSTIJKPlayerMultiActivity.this;
                nSTIJKPlayerMultiActivity.g1[0] = false;
                nSTIJKPlayerMultiActivity.c1.postDelayed(NSTIJKPlayerMultiActivity.A1(nSTIJKPlayerMultiActivity), 100L);
            } else if (NSTIJKPlayerMultiActivity.v1(NSTIJKPlayerMultiActivity.this).isShowing()) {
                NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity2 = NSTIJKPlayerMultiActivity.this;
                nSTIJKPlayerMultiActivity2.g1[0] = true;
                nSTIJKPlayerMultiActivity2.c1.removeCallbacks(NSTIJKPlayerMultiActivity.A1(nSTIJKPlayerMultiActivity2));
            } else {
                NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity3 = NSTIJKPlayerMultiActivity.this;
                NSTIJKPlayerMultiActivity.u1(nSTIJKPlayerMultiActivity3, nSTIJKPlayerMultiActivity3.d);
            }
            NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity4 = NSTIJKPlayerMultiActivity.this;
            if (nSTIJKPlayerMultiActivity4.g1[0]) {
                return;
            }
            nSTIJKPlayerMultiActivity4.c1.postDelayed(NSTIJKPlayerMultiActivity.A1(nSTIJKPlayerMultiActivity4), 100L);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            NSTIJKPlayerMultiActivity.B1(NSTIJKPlayerMultiActivity.this, "default");
            NSTIJKPlayerMultiActivity.C1(NSTIJKPlayerMultiActivity.this);
            NSTIJKPlayerMultiActivity.v1(NSTIJKPlayerMultiActivity.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            NSTIJKPlayerMultiActivity.B1(NSTIJKPlayerMultiActivity.this, "screen1");
            NSTIJKPlayerMultiActivity.C1(NSTIJKPlayerMultiActivity.this);
            NSTIJKPlayerMultiActivity.v1(NSTIJKPlayerMultiActivity.this).dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            NSTIJKPlayerMultiActivity.B1(NSTIJKPlayerMultiActivity.this, "screen2");
            NSTIJKPlayerMultiActivity.C1(NSTIJKPlayerMultiActivity.this);
            NSTIJKPlayerMultiActivity.v1(NSTIJKPlayerMultiActivity.this).dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            NSTIJKPlayerMultiActivity.B1(NSTIJKPlayerMultiActivity.this, "screen3");
            NSTIJKPlayerMultiActivity.C1(NSTIJKPlayerMultiActivity.this);
            NSTIJKPlayerMultiActivity.v1(NSTIJKPlayerMultiActivity.this).dismiss();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            NSTIJKPlayerMultiActivity.B1(NSTIJKPlayerMultiActivity.this, "screen4");
            NSTIJKPlayerMultiActivity.C1(NSTIJKPlayerMultiActivity.this);
            NSTIJKPlayerMultiActivity.v1(NSTIJKPlayerMultiActivity.this).dismiss();
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            NSTIJKPlayerMultiActivity.B1(NSTIJKPlayerMultiActivity.this, "screen5");
            NSTIJKPlayerMultiActivity.C1(NSTIJKPlayerMultiActivity.this);
            NSTIJKPlayerMultiActivity.v1(NSTIJKPlayerMultiActivity.this).dismiss();
        }
    }

    public class j implements PopupMenu.OnMenuItemClickListener {
        public final /* synthetic */ int a;

        public j(int i) {
            this.a = i;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == a7.f.Fb) {
                NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity = NSTIJKPlayerMultiActivity.this;
                NSTIJKPlayerMultiActivity.D1(nSTIJKPlayerMultiActivity, nSTIJKPlayerMultiActivity.d);
                return false;
            }
            if (itemId != a7.f.Kb) {
                return false;
            }
            NSTIJKPlayerMultiActivity.this.Y1(this.a);
            NSTIJKPlayerMultiActivity.E1(NSTIJKPlayerMultiActivity.this, this.a);
            return false;
        }
    }

    public class k extends AsyncTask {
        public k() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(NSTIJKPlayerMultiActivity.F1(NSTIJKPlayerMultiActivity.this));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity;
            GridLayoutManager gridLayoutManager;
            ProgressBar progressBar;
            NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity2;
            GridLayoutManager gridLayoutManager2;
            super.onPostExecute(bool);
            int i = 8;
            if (SharepreferenceDBHandler.getCurrentAPPType(NSTIJKPlayerMultiActivity.this.d).equals("m3u")) {
                if (NSTIJKPlayerMultiActivity.G1(NSTIJKPlayerMultiActivity.this) == null || NSTIJKPlayerMultiActivity.H1(NSTIJKPlayerMultiActivity.this) == 0) {
                    ProgressBar progressBar2 = NSTIJKPlayerMultiActivity.this.M0;
                    if (progressBar2 == null) {
                        return;
                    }
                    progressBar2.setVisibility(8);
                    progressBar = NSTIJKPlayerMultiActivity.this.N0;
                    i = 0;
                } else {
                    NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity3 = NSTIJKPlayerMultiActivity.this;
                    ArrayList G1 = NSTIJKPlayerMultiActivity.G1(NSTIJKPlayerMultiActivity.this);
                    NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity4 = NSTIJKPlayerMultiActivity.this;
                    z7.h hVar = nSTIJKPlayerMultiActivity4.d;
                    nSTIJKPlayerMultiActivity3.J0 = new x(G1, hVar, hVar, NSTIJKPlayerMultiActivity.w1(nSTIJKPlayerMultiActivity4), NSTIJKPlayerMultiActivity.x1(NSTIJKPlayerMultiActivity.this));
                    if (new u7.a(NSTIJKPlayerMultiActivity.this.d).A().equals(m7.a.K0)) {
                        nSTIJKPlayerMultiActivity2 = NSTIJKPlayerMultiActivity.this;
                        gridLayoutManager2 = new GridLayoutManager(nSTIJKPlayerMultiActivity2.d, 2);
                    } else {
                        nSTIJKPlayerMultiActivity2 = NSTIJKPlayerMultiActivity.this;
                        gridLayoutManager2 = new GridLayoutManager(nSTIJKPlayerMultiActivity2.d, 2);
                    }
                    NSTIJKPlayerMultiActivity.z1(nSTIJKPlayerMultiActivity2, gridLayoutManager2);
                    NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity5 = NSTIJKPlayerMultiActivity.this;
                    nSTIJKPlayerMultiActivity5.L0.setLayoutManager(NSTIJKPlayerMultiActivity.y1(nSTIJKPlayerMultiActivity5));
                    NSTIJKPlayerMultiActivity.this.L0.setItemAnimator(new androidx.recyclerview.widget.c());
                    NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity6 = NSTIJKPlayerMultiActivity.this;
                    nSTIJKPlayerMultiActivity6.L0.setAdapter(nSTIJKPlayerMultiActivity6.J0);
                    progressBar = NSTIJKPlayerMultiActivity.this.M0;
                    if (progressBar == null) {
                        return;
                    }
                }
            } else {
                if (NSTIJKPlayerMultiActivity.G1(NSTIJKPlayerMultiActivity.this) == null) {
                    return;
                }
                NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity7 = NSTIJKPlayerMultiActivity.this;
                ArrayList G12 = NSTIJKPlayerMultiActivity.G1(NSTIJKPlayerMultiActivity.this);
                NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity8 = NSTIJKPlayerMultiActivity.this;
                z7.h hVar2 = nSTIJKPlayerMultiActivity8.d;
                nSTIJKPlayerMultiActivity7.J0 = new x(G12, hVar2, hVar2, NSTIJKPlayerMultiActivity.w1(nSTIJKPlayerMultiActivity8), NSTIJKPlayerMultiActivity.x1(NSTIJKPlayerMultiActivity.this));
                if (new u7.a(NSTIJKPlayerMultiActivity.this.d).A().equals(m7.a.K0)) {
                    nSTIJKPlayerMultiActivity = NSTIJKPlayerMultiActivity.this;
                    gridLayoutManager = new GridLayoutManager(nSTIJKPlayerMultiActivity.d, 2);
                } else {
                    nSTIJKPlayerMultiActivity = NSTIJKPlayerMultiActivity.this;
                    gridLayoutManager = new GridLayoutManager(nSTIJKPlayerMultiActivity.d, 2);
                }
                NSTIJKPlayerMultiActivity.z1(nSTIJKPlayerMultiActivity, gridLayoutManager);
                NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity9 = NSTIJKPlayerMultiActivity.this;
                nSTIJKPlayerMultiActivity9.L0.setLayoutManager(NSTIJKPlayerMultiActivity.y1(nSTIJKPlayerMultiActivity9));
                NSTIJKPlayerMultiActivity.this.L0.setItemAnimator(new androidx.recyclerview.widget.c());
                NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity10 = NSTIJKPlayerMultiActivity.this;
                nSTIJKPlayerMultiActivity10.L0.setAdapter(nSTIJKPlayerMultiActivity10.J0);
                progressBar = NSTIJKPlayerMultiActivity.this.M0;
                if (progressBar == null) {
                    return;
                }
            }
            progressBar.setVisibility(i);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public static /* synthetic */ Runnable A1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        return nSTIJKPlayerMultiActivity.b1;
    }

    public static /* synthetic */ String B1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity, String str) {
        nSTIJKPlayerMultiActivity.j0 = str;
        return str;
    }

    public static /* synthetic */ void C1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        nSTIJKPlayerMultiActivity.c2();
    }

    public static /* synthetic */ void D1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity, Context context) {
        nSTIJKPlayerMultiActivity.J1(context);
    }

    public static /* synthetic */ void E1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity, int i2) {
        nSTIJKPlayerMultiActivity.P1(i2);
    }

    public static /* synthetic */ boolean F1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        return nSTIJKPlayerMultiActivity.R1();
    }

    public static /* synthetic */ ArrayList G1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        return nSTIJKPlayerMultiActivity.B0;
    }

    public static /* synthetic */ int H1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        return nSTIJKPlayerMultiActivity.I0;
    }

    public static long K1(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String M1(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private ArrayList N1() {
        ArrayList allPasswordStatus = this.A.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.d));
        this.G0 = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.D0.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.D0;
    }

    private ArrayList O1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (liveStreamCategoryIdDBModel.getLiveStreamCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    } else {
                        ArrayList arrayList3 = this.F0;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamCategoryIdDBModel);
                        }
                    }
                }
            }
        }
        return this.F0;
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x004c A[PHI: r1
      0x004c: PHI (r1v14 java.lang.String) = (r1v2 java.lang.String), (r1v3 java.lang.String) binds: [B:2:0x004a, B:13:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Q1() {
        /*
            Method dump skipped, instructions count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerMultiActivity.Q1():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3 A[Catch: NullPointerException | Exception -> 0x0275, NullPointerException | Exception -> 0x0275, TRY_ENTER, TryCatch #0 {NullPointerException | Exception -> 0x0275, blocks: (B:3:0x0005, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:10:0x001a, B:12:0x005f, B:14:0x0063, B:16:0x0075, B:17:0x007d, B:19:0x0081, B:20:0x0093, B:23:0x00a3, B:23:0x00a3, B:25:0x00ac, B:25:0x00ac, B:28:0x00b4, B:28:0x00b4, B:30:0x00bc, B:30:0x00bc, B:32:0x00c0, B:32:0x00c0, B:36:0x00c8, B:36:0x00c8, B:38:0x00da, B:38:0x00da, B:40:0x00ec, B:40:0x00ec, B:42:0x0100, B:42:0x0100, B:43:0x0177, B:43:0x0177, B:45:0x017c, B:45:0x017c, B:47:0x0129, B:47:0x0129, B:49:0x014d, B:49:0x014d, B:50:0x014f, B:50:0x014f, B:52:0x0180, B:52:0x0180, B:54:0x0184, B:54:0x0184, B:56:0x018a, B:56:0x018a, B:58:0x0190, B:58:0x0190, B:60:0x0194, B:60:0x0194, B:63:0x019c, B:63:0x019c, B:65:0x01a4, B:65:0x01a4, B:67:0x01a8, B:67:0x01a8, B:71:0x01b0, B:71:0x01b0, B:73:0x01c2, B:73:0x01c2, B:75:0x01d4, B:75:0x01d4, B:77:0x01e8, B:77:0x01e8, B:78:0x025f, B:78:0x025f, B:80:0x0264, B:80:0x0264, B:82:0x0211, B:82:0x0211, B:84:0x0235, B:84:0x0235, B:85:0x0237, B:85:0x0237, B:87:0x0268, B:87:0x0268, B:89:0x026c, B:89:0x026c, B:91:0x0084, B:93:0x0088), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018a A[Catch: NullPointerException | Exception -> 0x0275, NullPointerException | Exception -> 0x0275, TryCatch #0 {NullPointerException | Exception -> 0x0275, blocks: (B:3:0x0005, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:10:0x001a, B:12:0x005f, B:14:0x0063, B:16:0x0075, B:17:0x007d, B:19:0x0081, B:20:0x0093, B:23:0x00a3, B:23:0x00a3, B:25:0x00ac, B:25:0x00ac, B:28:0x00b4, B:28:0x00b4, B:30:0x00bc, B:30:0x00bc, B:32:0x00c0, B:32:0x00c0, B:36:0x00c8, B:36:0x00c8, B:38:0x00da, B:38:0x00da, B:40:0x00ec, B:40:0x00ec, B:42:0x0100, B:42:0x0100, B:43:0x0177, B:43:0x0177, B:45:0x017c, B:45:0x017c, B:47:0x0129, B:47:0x0129, B:49:0x014d, B:49:0x014d, B:50:0x014f, B:50:0x014f, B:52:0x0180, B:52:0x0180, B:54:0x0184, B:54:0x0184, B:56:0x018a, B:56:0x018a, B:58:0x0190, B:58:0x0190, B:60:0x0194, B:60:0x0194, B:63:0x019c, B:63:0x019c, B:65:0x01a4, B:65:0x01a4, B:67:0x01a8, B:67:0x01a8, B:71:0x01b0, B:71:0x01b0, B:73:0x01c2, B:73:0x01c2, B:75:0x01d4, B:75:0x01d4, B:77:0x01e8, B:77:0x01e8, B:78:0x025f, B:78:0x025f, B:80:0x0264, B:80:0x0264, B:82:0x0211, B:82:0x0211, B:84:0x0235, B:84:0x0235, B:85:0x0237, B:85:0x0237, B:87:0x0268, B:87:0x0268, B:89:0x026c, B:89:0x026c, B:91:0x0084, B:93:0x0088), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0190 A[Catch: NullPointerException | Exception -> 0x0275, NullPointerException | Exception -> 0x0275, TryCatch #0 {NullPointerException | Exception -> 0x0275, blocks: (B:3:0x0005, B:5:0x000a, B:7:0x000e, B:9:0x0012, B:10:0x001a, B:12:0x005f, B:14:0x0063, B:16:0x0075, B:17:0x007d, B:19:0x0081, B:20:0x0093, B:23:0x00a3, B:23:0x00a3, B:25:0x00ac, B:25:0x00ac, B:28:0x00b4, B:28:0x00b4, B:30:0x00bc, B:30:0x00bc, B:32:0x00c0, B:32:0x00c0, B:36:0x00c8, B:36:0x00c8, B:38:0x00da, B:38:0x00da, B:40:0x00ec, B:40:0x00ec, B:42:0x0100, B:42:0x0100, B:43:0x0177, B:43:0x0177, B:45:0x017c, B:45:0x017c, B:47:0x0129, B:47:0x0129, B:49:0x014d, B:49:0x014d, B:50:0x014f, B:50:0x014f, B:52:0x0180, B:52:0x0180, B:54:0x0184, B:54:0x0184, B:56:0x018a, B:56:0x018a, B:58:0x0190, B:58:0x0190, B:60:0x0194, B:60:0x0194, B:63:0x019c, B:63:0x019c, B:65:0x01a4, B:65:0x01a4, B:67:0x01a8, B:67:0x01a8, B:71:0x01b0, B:71:0x01b0, B:73:0x01c2, B:73:0x01c2, B:75:0x01d4, B:75:0x01d4, B:77:0x01e8, B:77:0x01e8, B:78:0x025f, B:78:0x025f, B:80:0x0264, B:80:0x0264, B:82:0x0211, B:82:0x0211, B:84:0x0235, B:84:0x0235, B:85:0x0237, B:85:0x0237, B:87:0x0268, B:87:0x0268, B:89:0x026c, B:89:0x026c, B:91:0x0084, B:93:0x0088), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean R1() {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerMultiActivity.R1():boolean");
    }

    private void b2(Context context) {
        try {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(new u7.a(context).A().equals(m7.a.K0) ? a7.g.q4 : a7.g.p4, findViewById(a7.f.Rf));
            this.V0 = inflate.findViewById(a7.f.F2);
            this.W0 = inflate.findViewById(a7.f.Mf);
            this.X0 = inflate.findViewById(a7.f.Nf);
            this.Y0 = inflate.findViewById(a7.f.Of);
            this.Z0 = inflate.findViewById(a7.f.Pf);
            this.a1 = inflate.findViewById(a7.f.Qf);
            PopupWindow popupWindow = new PopupWindow(context);
            this.A0 = popupWindow;
            popupWindow.setContentView(inflate);
            this.A0.setWidth(-1);
            this.A0.setHeight(-1);
            this.A0.setFocusable(true);
            this.A0.showAtLocation(inflate, 0, 0, 0);
            this.V0.setOnClickListener(new d());
            this.W0.setOnClickListener(new e());
            this.X0.setOnClickListener(new f());
            this.Y0.setOnClickListener(new g());
            this.Z0.setOnClickListener(new h());
            this.a1.setOnClickListener(new i());
        } catch (Exception unused) {
        }
    }

    private void c2() {
        int i2;
        Y1(0);
        String str = this.j0;
        str.hashCode();
        switch (str) {
            case "screen1":
                i2 = a7.g.v1;
                break;
            case "screen2":
                i2 = a7.g.w1;
                break;
            case "screen3":
                i2 = a7.g.x1;
                break;
            case "screen4":
                i2 = a7.g.y1;
                break;
            case "screen5":
                i2 = a7.g.z1;
                break;
            default:
                i2 = a7.g.u1;
                break;
        }
        setContentView(i2);
        Q1();
        if (this.T.equals("0") || this.H.equals("")) {
            a2(1, false, false);
        } else {
            T1();
        }
    }

    public static /* synthetic */ void u1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity, Context context) {
        nSTIJKPlayerMultiActivity.b2(context);
    }

    public static /* synthetic */ PopupWindow v1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        return nSTIJKPlayerMultiActivity.A0;
    }

    public static /* synthetic */ PopupWindow w1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        return nSTIJKPlayerMultiActivity.z0;
    }

    public static /* synthetic */ int x1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        return nSTIJKPlayerMultiActivity.m0;
    }

    public static /* synthetic */ GridLayoutManager y1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity) {
        return nSTIJKPlayerMultiActivity.K0;
    }

    public static /* synthetic */ GridLayoutManager z1(NSTIJKPlayerMultiActivity nSTIJKPlayerMultiActivity, GridLayoutManager gridLayoutManager) {
        nSTIJKPlayerMultiActivity.K0 = gridLayoutManager;
        return gridLayoutManager;
    }

    public final boolean I1() {
        String str;
        String str2;
        SimpleDateFormat simpleDateFormat = this.X;
        if (K1(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(this.d))), this.G.format(this.g0)) >= w7.c.p() && (str = this.C) != null && this.B != null && (!h1.equals(str) || (this.C != null && (str2 = this.B) != null && !i1.equals(str2)))) {
            this.h0 = Boolean.FALSE;
        }
        return this.h0.booleanValue();
    }

    public final void J1(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a7.g.U1, findViewById(a7.f.M9));
        this.M0 = inflate.findViewById(a7.f.ec);
        this.L0 = inflate.findViewById(a7.f.ub);
        this.N0 = inflate.findViewById(a7.f.Oe);
        this.P0 = inflate.findViewById(a7.f.W);
        TextView findViewById = inflate.findViewById(a7.f.Jl);
        this.Q0 = findViewById;
        findViewById.setText(context.getResources().getString(a7.j.h0));
        PopupWindow popupWindow = new PopupWindow(context);
        this.z0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.z0.setWidth(-1);
        this.z0.setHeight(-1);
        this.z0.setFocusable(true);
        this.z0.setOnDismissListener(new a());
        ProgressBar progressBar = this.M0;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        AppBarLayout appBarLayout = this.P0;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.c.C));
        }
        this.O0 = new k().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        this.z0.showAtLocation(inflate, 1, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void L1(int r14) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerMultiActivity.L1(int):void");
    }

    public final void P1(int i2) {
        LinearLayout linearLayout;
        if (i2 == 1) {
            this.Y.setVisibility(8);
            linearLayout = this.f;
        } else if (i2 == 2) {
            this.Z.setVisibility(8);
            linearLayout = this.g;
        } else if (i2 == 3) {
            this.e0.setVisibility(8);
            linearLayout = this.h;
        } else {
            if (i2 != 4) {
                return;
            }
            this.f0.setVisibility(8);
            linearLayout = this.i;
        }
        linearLayout.setVisibility(8);
    }

    public void S1(int i2) {
        if (i2 == 1) {
            this.Y.d0();
            this.Z.R();
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    this.e0.d0();
                    this.Y.R();
                    this.Z.R();
                    this.f0.R();
                }
                if (i2 == 4) {
                    this.f0.d0();
                    this.Y.R();
                    this.Z.R();
                    this.e0.R();
                    return;
                }
                return;
            }
            this.Z.d0();
            this.Y.R();
        }
        this.e0.R();
        this.f0.R();
    }

    public final void T1() {
        String str;
        NSTIJKPlayerMulti1 nSTIJKPlayerMulti1;
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        a2(1, true, true);
        if (!I1()) {
            d2(1);
            return;
        }
        ArrayList channelDetails = this.A.getChannelDetails(this.T, "live");
        if (channelDetails != null && channelDetails.size() != 0) {
            this.n0 = ((LiveStreamsDBModel) channelDetails.get(0)).getName();
            this.s = ((LiveStreamsDBModel) channelDetails.get(0)).getEpgChannelId();
            this.w = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIcon();
            this.r0 = ((LiveStreamsDBModel) channelDetails.get(0)).getCategoryId();
            this.v0 = ((LiveStreamsDBModel) channelDetails.get(0)).getUrl();
            try {
                this.L = Integer.parseInt(((LiveStreamsDBModel) channelDetails.get(0)).getStreamId());
            } catch (NumberFormatException unused) {
                this.L = -1;
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                try {
                    this.P = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIdOneStream();
                } catch (Exception unused2) {
                }
            }
        }
        this.Y.V();
        if (this.h0.booleanValue()) {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("onestream_api")) {
                try {
                    jSONObject = new JSONObject(this.v0);
                    String str6 = this.f1;
                    str2 = "m3u8";
                    str3 = "ts";
                    if (str6 == null || str6.isEmpty() || !this.f1.equals("ts")) {
                        str = "";
                        str4 = str;
                    } else {
                        Iterator keys = jSONObject.keys();
                        while (true) {
                            if (!keys.hasNext()) {
                                str4 = "";
                                break;
                            } else if (((String) keys.next()).equals("ts")) {
                                str4 = "ts";
                                break;
                            }
                        }
                        if (str4.equals("")) {
                            while (true) {
                                if (!keys.hasNext()) {
                                    break;
                                } else if (((String) keys.next()).equals("m3u8")) {
                                    str4 = "m3u8";
                                    break;
                                }
                            }
                        }
                        str = jSONObject.getString(str4);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    String str7 = this.f1;
                    if (str7 != null && !str7.isEmpty() && this.f1.equals("m3u8")) {
                        Iterator keys2 = jSONObject.keys();
                        while (true) {
                            if (!keys2.hasNext()) {
                                str2 = str4;
                                break;
                            } else if (((String) keys2.next()).equals("m3u8")) {
                                break;
                            }
                        }
                        if (str2.equals("")) {
                            while (keys2.hasNext()) {
                                if (((String) keys2.next()).equals("ts")) {
                                    break;
                                }
                            }
                            str3 = str2;
                            str = jSONObject.getString(str3);
                        } else {
                            str3 = str2;
                            str = jSONObject.getString(str3);
                        }
                    }
                } catch (Exception e3) {
                    String str8 = str;
                    e = e3;
                    str5 = str8;
                    B.d("exce", String.valueOf(e));
                    str = str5;
                    nSTIJKPlayerMulti1 = this.Y;
                    nSTIJKPlayerMulti1.Y(Uri.parse(str), true, this.n0);
                    NSTIJKPlayerMulti1 nSTIJKPlayerMulti12 = this.Y;
                    nSTIJKPlayerMulti12.z = 0;
                    nSTIJKPlayerMulti12.B = false;
                    nSTIJKPlayerMulti12.start();
                }
                nSTIJKPlayerMulti1 = this.Y;
            } else {
                nSTIJKPlayerMulti1 = this.Y;
                str = this.H;
            }
            nSTIJKPlayerMulti1.Y(Uri.parse(str), true, this.n0);
            NSTIJKPlayerMulti1 nSTIJKPlayerMulti122 = this.Y;
            nSTIJKPlayerMulti122.z = 0;
            nSTIJKPlayerMulti122.B = false;
            nSTIJKPlayerMulti122.start();
        }
    }

    public void U1() {
        String str;
        NSTIJKPlayerMulti2 nSTIJKPlayerMulti2;
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        a2(2, true, true);
        if (!I1()) {
            d2(2);
            return;
        }
        ArrayList channelDetails = this.A.getChannelDetails(this.U, "live");
        if (channelDetails != null && channelDetails.size() != 0) {
            this.o0 = ((LiveStreamsDBModel) channelDetails.get(0)).getName();
            this.t = ((LiveStreamsDBModel) channelDetails.get(0)).getEpgChannelId();
            this.x = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIcon();
            this.s0 = ((LiveStreamsDBModel) channelDetails.get(0)).getCategoryId();
            this.w0 = ((LiveStreamsDBModel) channelDetails.get(0)).getUrl();
            try {
                this.M = Integer.parseInt(((LiveStreamsDBModel) channelDetails.get(0)).getStreamId());
            } catch (NumberFormatException unused) {
                this.M = -1;
            }
            try {
                this.Q = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIdOneStream();
            } catch (Exception unused2) {
            }
        }
        this.Z.V();
        if (this.h0.booleanValue()) {
            if (this.i0.equals("onestream_api")) {
                try {
                    jSONObject = new JSONObject(this.w0);
                    String str6 = this.f1;
                    str2 = "m3u8";
                    str3 = "ts";
                    if (str6 == null || str6.isEmpty() || !this.f1.equals("ts")) {
                        str = "";
                        str4 = str;
                    } else {
                        Iterator keys = jSONObject.keys();
                        while (true) {
                            if (!keys.hasNext()) {
                                str4 = "";
                                break;
                            } else if (((String) keys.next()).equals("ts")) {
                                str4 = "ts";
                                break;
                            }
                        }
                        if (str4.equals("")) {
                            while (true) {
                                if (!keys.hasNext()) {
                                    break;
                                } else if (((String) keys.next()).equals("m3u8")) {
                                    str4 = "m3u8";
                                    break;
                                }
                            }
                        }
                        str = jSONObject.getString(str4);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    String str7 = this.f1;
                    if (str7 != null && !str7.isEmpty() && this.f1.equals("m3u8")) {
                        Iterator keys2 = jSONObject.keys();
                        while (true) {
                            if (!keys2.hasNext()) {
                                str2 = str4;
                                break;
                            } else if (((String) keys2.next()).equals("m3u8")) {
                                break;
                            }
                        }
                        if (str2.equals("")) {
                            while (keys2.hasNext()) {
                                if (((String) keys2.next()).equals("ts")) {
                                    break;
                                }
                            }
                            str3 = str2;
                            str = jSONObject.getString(str3);
                        } else {
                            str3 = str2;
                            str = jSONObject.getString(str3);
                        }
                    }
                } catch (Exception e3) {
                    String str8 = str;
                    e = e3;
                    str5 = str8;
                    B.d("exce", String.valueOf(e));
                    str = str5;
                    nSTIJKPlayerMulti2 = this.Z;
                    nSTIJKPlayerMulti2.Y(Uri.parse(str), true, this.o0);
                    NSTIJKPlayerMulti2 nSTIJKPlayerMulti22 = this.Z;
                    nSTIJKPlayerMulti22.z = 0;
                    nSTIJKPlayerMulti22.B = false;
                    nSTIJKPlayerMulti22.start();
                }
                nSTIJKPlayerMulti2 = this.Z;
            } else {
                nSTIJKPlayerMulti2 = this.Z;
                str = this.I;
            }
            nSTIJKPlayerMulti2.Y(Uri.parse(str), true, this.o0);
            NSTIJKPlayerMulti2 nSTIJKPlayerMulti222 = this.Z;
            nSTIJKPlayerMulti222.z = 0;
            nSTIJKPlayerMulti222.B = false;
            nSTIJKPlayerMulti222.start();
        }
    }

    public void V1() {
        String str;
        NSTIJKPlayerMulti3 nSTIJKPlayerMulti3;
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        a2(3, true, true);
        if (!I1()) {
            d2(3);
            return;
        }
        ArrayList channelDetails = this.A.getChannelDetails(this.V, "live");
        if (channelDetails != null && channelDetails.size() != 0) {
            this.p0 = ((LiveStreamsDBModel) channelDetails.get(0)).getName();
            this.u = ((LiveStreamsDBModel) channelDetails.get(0)).getEpgChannelId();
            this.y = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIcon();
            this.t0 = ((LiveStreamsDBModel) channelDetails.get(0)).getCategoryId();
            this.x0 = ((LiveStreamsDBModel) channelDetails.get(0)).getUrl();
            try {
                this.N = Integer.parseInt(((LiveStreamsDBModel) channelDetails.get(0)).getStreamId());
            } catch (NumberFormatException unused) {
                this.N = -1;
            }
            try {
                this.R = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIdOneStream();
            } catch (Exception unused2) {
            }
        }
        this.e0.V();
        if (this.h0.booleanValue()) {
            if (this.i0.equals("onestream_api")) {
                try {
                    jSONObject = new JSONObject(this.x0);
                    String str6 = this.f1;
                    str2 = "m3u8";
                    str3 = "ts";
                    if (str6 == null || str6.isEmpty() || !this.f1.equals("ts")) {
                        str = "";
                        str4 = str;
                    } else {
                        Iterator keys = jSONObject.keys();
                        while (true) {
                            if (!keys.hasNext()) {
                                str4 = "";
                                break;
                            } else if (((String) keys.next()).equals("ts")) {
                                str4 = "ts";
                                break;
                            }
                        }
                        if (str4.equals("")) {
                            while (true) {
                                if (!keys.hasNext()) {
                                    break;
                                } else if (((String) keys.next()).equals("m3u8")) {
                                    str4 = "m3u8";
                                    break;
                                }
                            }
                        }
                        str = jSONObject.getString(str4);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    String str7 = this.f1;
                    if (str7 != null && !str7.isEmpty() && this.f1.equals("m3u8")) {
                        Iterator keys2 = jSONObject.keys();
                        while (true) {
                            if (!keys2.hasNext()) {
                                str2 = str4;
                                break;
                            } else if (((String) keys2.next()).equals("m3u8")) {
                                break;
                            }
                        }
                        if (str2.equals("")) {
                            while (keys2.hasNext()) {
                                if (((String) keys2.next()).equals("ts")) {
                                    break;
                                }
                            }
                            str3 = str2;
                            str = jSONObject.getString(str3);
                        } else {
                            str3 = str2;
                            str = jSONObject.getString(str3);
                        }
                    }
                } catch (Exception e3) {
                    String str8 = str;
                    e = e3;
                    str5 = str8;
                    B.d("exce", String.valueOf(e));
                    str = str5;
                    nSTIJKPlayerMulti3 = this.e0;
                    nSTIJKPlayerMulti3.Y(Uri.parse(str), true, this.p0);
                    NSTIJKPlayerMulti3 nSTIJKPlayerMulti32 = this.e0;
                    nSTIJKPlayerMulti32.z = 0;
                    nSTIJKPlayerMulti32.B = false;
                    nSTIJKPlayerMulti32.start();
                }
                nSTIJKPlayerMulti3 = this.e0;
            } else {
                nSTIJKPlayerMulti3 = this.e0;
                str = this.J;
            }
            nSTIJKPlayerMulti3.Y(Uri.parse(str), true, this.p0);
            NSTIJKPlayerMulti3 nSTIJKPlayerMulti322 = this.e0;
            nSTIJKPlayerMulti322.z = 0;
            nSTIJKPlayerMulti322.B = false;
            nSTIJKPlayerMulti322.start();
        }
    }

    public void W1() {
        String str;
        NSTIJKPlayerMulti4 nSTIJKPlayerMulti4;
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        a2(4, true, true);
        if (!I1()) {
            d2(4);
            return;
        }
        ArrayList channelDetails = this.A.getChannelDetails(this.W, "live");
        if (channelDetails != null && channelDetails.size() != 0) {
            this.q0 = ((LiveStreamsDBModel) channelDetails.get(0)).getName();
            this.v = ((LiveStreamsDBModel) channelDetails.get(0)).getEpgChannelId();
            this.z = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIcon();
            this.u0 = ((LiveStreamsDBModel) channelDetails.get(0)).getCategoryId();
            this.y0 = ((LiveStreamsDBModel) channelDetails.get(0)).getUrl();
            try {
                this.O = Integer.parseInt(((LiveStreamsDBModel) channelDetails.get(0)).getStreamId());
            } catch (NumberFormatException unused) {
                this.O = -1;
            }
            try {
                this.S = ((LiveStreamsDBModel) channelDetails.get(0)).getStreamIdOneStream();
            } catch (Exception unused2) {
            }
        }
        this.f0.V();
        if (this.h0.booleanValue()) {
            if (this.i0.equals("onestream_api")) {
                try {
                    jSONObject = new JSONObject(this.y0);
                    String str6 = this.f1;
                    str2 = "m3u8";
                    str3 = "ts";
                    if (str6 == null || str6.isEmpty() || !this.f1.equals("ts")) {
                        str = "";
                        str4 = str;
                    } else {
                        Iterator keys = jSONObject.keys();
                        while (true) {
                            if (!keys.hasNext()) {
                                str4 = "";
                                break;
                            } else if (((String) keys.next()).equals("ts")) {
                                str4 = "ts";
                                break;
                            }
                        }
                        if (str4.equals("")) {
                            while (true) {
                                if (!keys.hasNext()) {
                                    break;
                                } else if (((String) keys.next()).equals("m3u8")) {
                                    str4 = "m3u8";
                                    break;
                                }
                            }
                        }
                        str = jSONObject.getString(str4);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    String str7 = this.f1;
                    if (str7 != null && !str7.isEmpty() && this.f1.equals("m3u8")) {
                        Iterator keys2 = jSONObject.keys();
                        while (true) {
                            if (!keys2.hasNext()) {
                                str2 = str4;
                                break;
                            } else if (((String) keys2.next()).equals("m3u8")) {
                                break;
                            }
                        }
                        if (str2.equals("")) {
                            while (keys2.hasNext()) {
                                if (((String) keys2.next()).equals("ts")) {
                                    break;
                                }
                            }
                            str3 = str2;
                            str = jSONObject.getString(str3);
                        } else {
                            str3 = str2;
                            str = jSONObject.getString(str3);
                        }
                    }
                } catch (Exception e3) {
                    String str8 = str;
                    e = e3;
                    str5 = str8;
                    B.d("exce", String.valueOf(e));
                    str = str5;
                    nSTIJKPlayerMulti4 = this.f0;
                    nSTIJKPlayerMulti4.Y(Uri.parse(str), true, this.q0);
                    NSTIJKPlayerMulti4 nSTIJKPlayerMulti42 = this.f0;
                    nSTIJKPlayerMulti42.z = 0;
                    nSTIJKPlayerMulti42.B = false;
                    nSTIJKPlayerMulti42.start();
                }
                nSTIJKPlayerMulti4 = this.f0;
            } else {
                nSTIJKPlayerMulti4 = this.f0;
                str = this.K;
            }
            nSTIJKPlayerMulti4.Y(Uri.parse(str), true, this.q0);
            NSTIJKPlayerMulti4 nSTIJKPlayerMulti422 = this.f0;
            nSTIJKPlayerMulti422.z = 0;
            nSTIJKPlayerMulti422.B = false;
            nSTIJKPlayerMulti422.start();
        }
    }

    public final void X1(int i2, View view) {
        if (this.d != null) {
            this.m0 = i2;
            PopupMenu popupMenu = new PopupMenu(this, view);
            popupMenu.getMenuInflater().inflate(a7.h.l, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new j(i2));
            popupMenu.show();
        }
    }

    public void Y1(int i2) {
        NSTIJKPlayerMulti1 nSTIJKPlayerMulti1;
        NSTIJKPlayerMulti2 nSTIJKPlayerMulti2;
        NSTIJKPlayerMulti3 nSTIJKPlayerMulti3;
        NSTIJKPlayerMulti4 nSTIJKPlayerMulti4;
        NSTIJKPlayerMulti1 nSTIJKPlayerMulti12;
        NSTIJKPlayerMulti2 nSTIJKPlayerMulti22;
        NSTIJKPlayerMulti3 nSTIJKPlayerMulti32;
        NSTIJKPlayerMulti4 nSTIJKPlayerMulti42;
        Boolean bool = Boolean.FALSE;
        if (i2 == 0) {
            bool = Boolean.TRUE;
        }
        if ((bool.booleanValue() || i2 == 1) && (nSTIJKPlayerMulti1 = this.Y) != null) {
            nSTIJKPlayerMulti1.pause();
        }
        if ((bool.booleanValue() || i2 == 2) && (nSTIJKPlayerMulti2 = this.Z) != null) {
            nSTIJKPlayerMulti2.pause();
        }
        if ((bool.booleanValue() || i2 == 3) && (nSTIJKPlayerMulti3 = this.e0) != null) {
            nSTIJKPlayerMulti3.pause();
        }
        if ((bool.booleanValue() || i2 == 4) && (nSTIJKPlayerMulti4 = this.f0) != null) {
            nSTIJKPlayerMulti4.pause();
        }
        try {
            if ((bool.booleanValue() || i2 == 1) && (nSTIJKPlayerMulti12 = this.Y) != null) {
                if (nSTIJKPlayerMulti12.P()) {
                    this.Y.J();
                } else {
                    this.Y.c0();
                    this.Y.T(true);
                    this.Y.b0();
                }
                IjkMediaPlayer.native_profileEnd();
                if (i2 == 1) {
                    this.H = "";
                    this.Y.c = null;
                    this.R0.setVisibility(8);
                }
            }
            if ((bool.booleanValue() || i2 == 2) && (nSTIJKPlayerMulti22 = this.Z) != null) {
                if (nSTIJKPlayerMulti22.P()) {
                    this.Z.J();
                } else {
                    this.Z.c0();
                    this.Z.T(true);
                    this.Z.b0();
                }
                IjkMediaPlayer.native_profileEnd();
                if (i2 == 2) {
                    this.I = "";
                    this.Z.c = null;
                    this.S0.setVisibility(8);
                }
            }
            if ((bool.booleanValue() || i2 == 3) && (nSTIJKPlayerMulti32 = this.e0) != null) {
                if (nSTIJKPlayerMulti32.P()) {
                    this.e0.J();
                } else {
                    this.e0.c0();
                    this.e0.T(true);
                    this.e0.b0();
                }
                IjkMediaPlayer.native_profileEnd();
                if (i2 == 3) {
                    this.J = "";
                    this.e0.c = null;
                    this.T0.setVisibility(8);
                }
            }
            if ((bool.booleanValue() || i2 == 4) && (nSTIJKPlayerMulti42 = this.f0) != null) {
                if (nSTIJKPlayerMulti42.P()) {
                    this.f0.J();
                } else {
                    this.f0.c0();
                    this.f0.T(true);
                    this.f0.b0();
                }
                IjkMediaPlayer.native_profileEnd();
                if (i2 == 4) {
                    this.K = "";
                    this.f0.c = null;
                    this.U0.setVisibility(8);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void Z1() {
        findViewById(a7.f.q).setBackground(getResources().getDrawable(a7.e.I1));
        findViewById(a7.f.r).setBackground(getResources().getDrawable(a7.e.I1));
        findViewById(a7.f.s).setBackground(getResources().getDrawable(a7.e.I1));
        findViewById(a7.f.t).setBackground(getResources().getDrawable(a7.e.I1));
    }

    public final void a2(int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        Z1();
        if (i2 == 1) {
            if ((z && this.f.getVisibility() != 0) || (z && z2)) {
                this.Y.setVisibility(0);
            }
            findViewById(a7.f.q).setFocusable(true);
            findViewById(a7.f.q).requestFocus();
            findViewById(a7.f.q).setBackground(getResources().getDrawable(a7.e.o2));
            i5 = a7.f.r;
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    if ((z && this.h.getVisibility() != 0) || (z && z2)) {
                        this.e0.setVisibility(0);
                    }
                    findViewById(a7.f.s).setFocusable(true);
                    findViewById(a7.f.s).requestFocus();
                    findViewById(a7.f.s).setBackground(getResources().getDrawable(a7.e.o2));
                    findViewById(a7.f.q).setFocusable(false);
                    i4 = a7.f.r;
                    findViewById(i4).setFocusable(false);
                    i3 = a7.f.t;
                    findViewById(i3).setFocusable(false);
                }
                if (i2 == 4) {
                    if ((z && this.i.getVisibility() != 0) || (z && z2)) {
                        this.f0.setVisibility(0);
                    }
                    findViewById(a7.f.t).setFocusable(true);
                    findViewById(a7.f.t).requestFocus();
                    findViewById(a7.f.t).setBackground(getResources().getDrawable(a7.e.o2));
                    findViewById(a7.f.q).setFocusable(false);
                    findViewById(a7.f.r).setFocusable(false);
                    i3 = a7.f.s;
                    findViewById(i3).setFocusable(false);
                }
                return;
            }
            if ((z && this.g.getVisibility() != 0) || (z && z2)) {
                this.Z.setVisibility(0);
            }
            findViewById(a7.f.r).setFocusable(true);
            findViewById(a7.f.r).requestFocus();
            findViewById(a7.f.r).setBackground(getResources().getDrawable(a7.e.o2));
            i5 = a7.f.q;
        }
        findViewById(i5).setFocusable(false);
        i4 = a7.f.s;
        findViewById(i4).setFocusable(false);
        i3 = a7.f.t;
        findViewById(i3).setFocusable(false);
    }

    public final void d2(int i2) {
        TextView textView;
        StringBuilder sb;
        String S0 = w.S0(w7.k.a() + w7.k.i());
        if (i2 == 1) {
            this.Y.setVisibility(8);
            this.f.setVisibility(0);
            textView = this.j;
            sb = new StringBuilder();
        } else if (i2 == 2) {
            this.Z.setVisibility(8);
            this.g.setVisibility(0);
            textView = this.k;
            sb = new StringBuilder();
        } else if (i2 == 3) {
            this.e0.setVisibility(8);
            this.h.setVisibility(0);
            textView = this.l;
            sb = new StringBuilder();
        } else {
            if (i2 != 4) {
                return;
            }
            this.f0.setVisibility(8);
            this.i.setVisibility(0);
            textView = this.m;
            sb = new StringBuilder();
        }
        sb.append(S0);
        sb.append(this.e);
        sb.append(this.E);
        textView.setText(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyEvent.getAction() == 0;
        if (keyCode == 82) {
            try {
                keyEvent = z ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent);
                return keyEvent;
            } catch (Exception unused) {
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void e2(String str) {
        int i2;
        int i3;
        int i4;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        Z1();
        switch (c2) {
            case 0:
            default:
                this.m0 = 1;
                S1(1);
                findViewById(a7.f.q).setFocusable(true);
                findViewById(a7.f.q).requestFocus();
                findViewById(a7.f.q).setBackground(getResources().getDrawable(a7.e.o2));
                i2 = a7.f.r;
                findViewById(i2).setFocusable(false);
                i3 = a7.f.s;
                findViewById(i3).setFocusable(false);
                i4 = a7.f.t;
                break;
            case 1:
                this.m0 = 2;
                S1(2);
                findViewById(a7.f.r).setFocusable(true);
                findViewById(a7.f.r).requestFocus();
                findViewById(a7.f.r).setBackground(getResources().getDrawable(a7.e.o2));
                i2 = a7.f.q;
                findViewById(i2).setFocusable(false);
                i3 = a7.f.s;
                findViewById(i3).setFocusable(false);
                i4 = a7.f.t;
                break;
            case 2:
                this.m0 = 3;
                S1(3);
                findViewById(a7.f.s).setFocusable(true);
                findViewById(a7.f.s).requestFocus();
                findViewById(a7.f.s).setBackground(getResources().getDrawable(a7.e.o2));
                findViewById(a7.f.q).setFocusable(false);
                i3 = a7.f.r;
                findViewById(i3).setFocusable(false);
                i4 = a7.f.t;
                break;
            case 3:
                this.m0 = 4;
                S1(4);
                findViewById(a7.f.t).setFocusable(true);
                findViewById(a7.f.t).requestFocus();
                findViewById(a7.f.t).setBackground(getResources().getDrawable(a7.e.o2));
                findViewById(a7.f.q).setFocusable(false);
                findViewById(a7.f.r).setFocusable(false);
                i4 = a7.f.s;
                break;
        }
        findViewById(i4).setFocusable(false);
    }

    public final void f2() {
        try {
            this.c1 = new Handler();
            c cVar = new c();
            this.b1 = cVar;
            if (this.g1[0]) {
                return;
            }
            cVar.run();
        } catch (Exception e2) {
            B.b("", "" + e2);
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int i2;
        int id = view.getId();
        if (id == a7.f.q) {
            i2 = 1;
        } else if (id == a7.f.r) {
            i2 = 2;
        } else if (id == a7.f.s) {
            i2 = 3;
        } else if (id != a7.f.t) {
            return;
        } else {
            i2 = 4;
        }
        try {
            L1(i2);
        } catch (Exception unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        this.d = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        this.j0 = SharepreferenceDBHandler.getScreenTYPE(this.d);
        c2();
        if (SharepreferenceDBHandler.getShowPopup(this.d)) {
            new Handler().postDelayed(new b(), 100L);
            f2();
        }
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("allowedFormat", 0);
        this.e1 = sharedPreferences;
        this.f1 = sharedPreferences.getString("allowedFormat", "");
        overridePendingTransition(a7.b.f, a7.b.d);
        this.H = getIntent().getStringExtra("url");
        String valueOf = String.valueOf(getIntent().getIntExtra("CHANNEL_NUM", 0));
        this.T = valueOf;
        if (valueOf.equals("0") || this.H.equals("")) {
            a2(1, false, false);
        } else {
            T1();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            Y1(0);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r11, android.view.KeyEvent r12) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.ijkplayer.activities.NSTIJKPlayerMultiActivity.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
    }

    public boolean onLongClick(View view) {
        int id = view.getId();
        if (id == a7.f.q) {
            try {
                if (!this.H.equals("")) {
                    S1(1);
                    a2(1, true, false);
                    X1(1, view);
                }
            } catch (Exception unused) {
            }
            return true;
        }
        if (id == a7.f.r) {
            try {
                if (!this.I.equals("")) {
                    S1(2);
                    a2(2, true, false);
                    X1(2, view);
                }
            } catch (Exception unused2) {
            }
            return true;
        }
        if (id == a7.f.s) {
            try {
                if (!this.J.equals("")) {
                    S1(3);
                    a2(3, true, false);
                    X1(3, view);
                }
            } catch (Exception unused3) {
            }
            return true;
        }
        if (id == a7.f.t) {
            try {
                if (!this.K.equals("")) {
                    S1(4);
                    a2(4, true, false);
                    X1(4, view);
                }
            } catch (Exception unused4) {
            }
        }
        return true;
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.d);
    }

    public void onStop() {
        super.onStop();
        try {
            Y1(0);
        } catch (Exception unused) {
        }
    }

    public void p(String str, String str2) {
        int i2 = this.m0;
        if (i2 == 1) {
            if (this.Y != null) {
                this.H = str;
                this.T = str2;
                findViewById(a7.f.q).setFocusable(true);
                T1();
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (this.Z != null) {
                this.I = str;
                this.U = str2;
                findViewById(a7.f.r).setFocusable(true);
                U1();
                return;
            }
            return;
        }
        if (i2 == 3) {
            if (this.e0 != null) {
                this.J = str;
                this.V = str2;
                findViewById(a7.f.s).setFocusable(true);
                V1();
                return;
            }
            return;
        }
        if (i2 != 4 || this.f0 == null) {
            return;
        }
        this.K = str;
        this.W = str2;
        findViewById(a7.f.t).setFocusable(true);
        W1();
    }
}
