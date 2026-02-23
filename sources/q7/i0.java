package q7;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity;
import com.nst.iptvsmarterstvbox.view.activity.ViewDetailsTMDBActivity;
import com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k.U;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class i0 extends RecyclerView.g {
    public static String G;
    public static String H;
    public ArrayList A;
    public VodActivityNewFlowSubCategories B;
    public String C;
    public boolean D;
    public o4.e E;
    public int F;
    public Context d;
    public List e;
    public SharedPreferences f;
    public List g;
    public String h;
    public List i;
    public DatabaseHandler j;
    public LiveStreamDBHandler k;
    public String l;
    public RecentWatchDBHandler m;
    public SimpleDateFormat n;
    public SharedPreferences o;
    public SharedPreferences.Editor p;
    public SharedPreferences q;
    public SharedPreferences.Editor r;
    public int s;
    public int t;
    public Boolean u;
    public Date v;
    public Handler w;
    public int x = 0;
    public DateFormat y;
    public Boolean z;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ TextView c;

        public class a implements Runnable {
            public a() {
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0049  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r2 = this;
                    q7.i0$a r0 = q7.i0.a.this
                    java.lang.String r0 = r0.a
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L16
                    q7.i0$a r0 = q7.i0.a.this
                    q7.i0 r0 = q7.i0.this
                    java.util.List r1 = q7.i0.l0(r0)
                L12:
                    q7.i0.n0(r0, r1)
                    goto L3b
                L16:
                    q7.i0$a r0 = q7.i0.a.this
                    q7.i0 r0 = q7.i0.this
                    java.util.List r0 = q7.i0.A0(r0)
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L32
                    q7.i0$a r0 = q7.i0.a.this
                    q7.i0 r0 = q7.i0.this
                    java.util.List r0 = q7.i0.A0(r0)
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L3b
                L32:
                    q7.i0$a r0 = q7.i0.a.this
                    q7.i0 r0 = q7.i0.this
                    java.util.List r1 = q7.i0.A0(r0)
                    goto L12
                L3b:
                    q7.i0$a r0 = q7.i0.a.this
                    q7.i0 r0 = q7.i0.this
                    java.util.List r0 = q7.i0.m0(r0)
                    int r0 = r0.size()
                    if (r0 != 0) goto L51
                    q7.i0$a r0 = q7.i0.a.this
                    android.widget.TextView r0 = r0.c
                    r1 = 0
                    r0.setVisibility(r1)
                L51:
                    q7.i0$a r0 = q7.i0.a.this
                    q7.i0 r0 = q7.i0.this
                    int r1 = r0.t
                    r0.s = r1
                    r0.w()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: q7.i0.a.a.run():void");
            }
        }

        public a(String str, TextView textView) {
            this.a = str;
            this.c = textView;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0051 A[Catch: Exception -> 0x00a4, TryCatch #0 {Exception -> 0x00a4, blocks: (B:2:0x0000, B:4:0x001c, B:5:0x0025, B:7:0x002d, B:8:0x0094, B:12:0x003d, B:14:0x0049, B:16:0x005a, B:17:0x0064, B:19:0x006a, B:22:0x0076, B:25:0x008a, B:31:0x0051), top: B:1:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> La4
                r1.<init>()     // Catch: java.lang.Exception -> La4
                q7.i0.B0(r0, r1)     // Catch: java.lang.Exception -> La4
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.lang.String r1 = r4.a     // Catch: java.lang.Exception -> La4
                int r1 = r1.length()     // Catch: java.lang.Exception -> La4
                r0.t = r1     // Catch: java.lang.Exception -> La4
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.List r0 = q7.i0.A0(r0)     // Catch: java.lang.Exception -> La4
                if (r0 == 0) goto L25
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.List r0 = q7.i0.A0(r0)     // Catch: java.lang.Exception -> La4
                r0.clear()     // Catch: java.lang.Exception -> La4
            L25:
                java.lang.String r0 = r4.a     // Catch: java.lang.Exception -> La4
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> La4
                if (r0 == 0) goto L3d
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.List r0 = q7.i0.A0(r0)     // Catch: java.lang.Exception -> La4
                q7.i0 r1 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.List r1 = q7.i0.l0(r1)     // Catch: java.lang.Exception -> La4
                r0.addAll(r1)     // Catch: java.lang.Exception -> La4
                goto L94
            L3d:
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.List r0 = q7.i0.m0(r0)     // Catch: java.lang.Exception -> La4
                int r0 = r0.size()     // Catch: java.lang.Exception -> La4
                if (r0 == 0) goto L51
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                int r1 = r0.s     // Catch: java.lang.Exception -> La4
                int r0 = r0.t     // Catch: java.lang.Exception -> La4
                if (r1 <= r0) goto L5a
            L51:
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.List r1 = q7.i0.l0(r0)     // Catch: java.lang.Exception -> La4
                q7.i0.n0(r0, r1)     // Catch: java.lang.Exception -> La4
            L5a:
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.List r0 = q7.i0.m0(r0)     // Catch: java.lang.Exception -> La4
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> La4
            L64:
                boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> La4
                if (r1 == 0) goto L94
                java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> La4
                com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel r1 = (com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel) r1     // Catch: java.lang.Exception -> La4
                java.lang.String r2 = r1.getName()     // Catch: java.lang.Exception -> La4
                if (r2 == 0) goto L64
                java.lang.String r2 = r1.getName()     // Catch: java.lang.Exception -> La4
                java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Exception -> La4
                java.lang.String r3 = r4.a     // Catch: java.lang.Exception -> La4
                java.lang.String r3 = r3.toLowerCase()     // Catch: java.lang.Exception -> La4
                boolean r2 = r2.contains(r3)     // Catch: java.lang.Exception -> La4
                if (r2 == 0) goto L64
                q7.i0 r2 = q7.i0.this     // Catch: java.lang.Exception -> La4
                java.util.List r2 = q7.i0.A0(r2)     // Catch: java.lang.Exception -> La4
                r2.add(r1)     // Catch: java.lang.Exception -> La4
                goto L64
            L94:
                q7.i0 r0 = q7.i0.this     // Catch: java.lang.Exception -> La4
                android.content.Context r0 = q7.i0.k0(r0)     // Catch: java.lang.Exception -> La4
                android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> La4
                q7.i0$a$a r1 = new q7.i0$a$a     // Catch: java.lang.Exception -> La4
                r1.<init>()     // Catch: java.lang.Exception -> La4
                r0.runOnUiThread(r1)     // Catch: java.lang.Exception -> La4
            La4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.i0.a.run():void");
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        public b(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.a = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = str7;
            this.j = str8;
        }

        public void onClick(View view) {
            i0.j0(i0.this, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        public c(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.a = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = str7;
            this.j = str8;
        }

        public void onClick(View view) {
            i0.j0(i0.this, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        public d(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.a = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = str7;
            this.j = str8;
        }

        public void onClick(View view) {
            i0.j0(i0.this, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
    }

    public class e implements View.OnLongClickListener {
        public final /* synthetic */ k a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;

        public e(k kVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            this.a = kVar;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.j = str7;
            this.k = str8;
            this.l = str9;
            this.m = str10;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(i0.k0(i0.this)).equals("m3u")) {
                i0.p0(i0.this, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                return true;
            }
            i0.q0(i0.this, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.l, this.m);
            return true;
        }
    }

    public class f implements View.OnLongClickListener {
        public final /* synthetic */ k a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ int l;
        public final /* synthetic */ String m;
        public final /* synthetic */ String n;

        public f(k kVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10) {
            this.a = kVar;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.j = str7;
            this.k = str8;
            this.l = i2;
            this.m = str9;
            this.n = str10;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(i0.k0(i0.this)).equals("m3u")) {
                i0.p0(i0.this, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                return true;
            }
            i0.q0(i0.this, this.a, this.l, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.m, this.n);
            return true;
        }
    }

    public class g implements View.OnLongClickListener {
        public final /* synthetic */ k a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ int l;
        public final /* synthetic */ String m;
        public final /* synthetic */ String n;

        public g(k kVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10) {
            this.a = kVar;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.j = str7;
            this.k = str8;
            this.l = i2;
            this.m = str9;
            this.n = str10;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(i0.k0(i0.this)).equals("m3u")) {
                i0.p0(i0.this, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
                return true;
            }
            i0.q0(i0.this, this.a, this.l, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.m, this.n);
            return true;
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ k a;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;

        public h(k kVar, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            this.a = kVar;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
            this.j = str7;
            this.k = str8;
            this.l = str9;
        }

        public void onClick(View view) {
            i0.q0(i0.this, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }
    }

    public class i implements U.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ k j;

        public i(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, k kVar) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
            this.j = kVar;
        }

        private void a() {
            FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
            favouriteM3UModel.setUrl(this.a);
            favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(i0.k0(i0.this)));
            favouriteM3UModel.setName(this.c);
            favouriteM3UModel.setCategoryID(this.g);
            i0.this.k.addToFavourite(favouriteM3UModel);
            this.j.y.setVisibility(0);
        }

        private void b() {
            m7.w.w0(i0.k0(i0.this), this.d, this.b, this.e, this.f, this.h, this.c, this.a, 0, "", "", "");
        }

        private void c() {
            i0 i0Var = i0.this;
            i0Var.k.deleteFavourite(this.a, SharepreferenceDBHandler.getUserID(i0.k0(i0Var)));
            this.j.y.setVisibility(4);
        }

        private void d(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            if (i0.k0(i0.this) == null) {
                Log.e("Null hai context", ">>>>>>>>>>>True its Null");
                return;
            }
            Intent intent = new Intent(i0.k0(i0.this), ViewDetailsTMDBActivity.class);
            intent.putExtra(m7.a.Q, String.valueOf(i));
            intent.putExtra("movie", str);
            intent.putExtra("movie_icon", str7);
            intent.putExtra("selectedPlayer", str2);
            intent.putExtra("streamType", str3);
            intent.putExtra("containerExtension", str4);
            intent.putExtra("categoryID", str5);
            intent.putExtra("num", str6);
            intent.putExtra("videoURL", str8);
            i0.k0(i0.this).startActivity(intent);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
        
            r2 = new android.content.Intent(q7.i0.k0(r12.k), com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity.class);
            r2.putExtra("url", r12.a);
            r2.putExtra("app_name", ((com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) q7.i0.s0(r12.k).get(r1)).getAppname());
            r2.putExtra("packagename", ((com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) q7.i0.s0(r12.k).get(r1)).getPackagename());
            q7.i0.k0(r12.k).startActivity(r2);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onMenuItemClick(android.view.MenuItem r13) {
            /*
                r12 = this;
                r0 = 0
                q7.i0 r1 = q7.i0.this     // Catch: java.lang.Exception -> L7c
                java.lang.Boolean r1 = q7.i0.r0(r1)     // Catch: java.lang.Exception -> L7c
                boolean r1 = r1.booleanValue()     // Catch: java.lang.Exception -> L7c
                if (r1 == 0) goto L81
                q7.i0 r1 = q7.i0.this     // Catch: java.lang.Exception -> L7c
                java.util.ArrayList r1 = q7.i0.s0(r1)     // Catch: java.lang.Exception -> L7c
                if (r1 == 0) goto L81
                q7.i0 r1 = q7.i0.this     // Catch: java.lang.Exception -> L7c
                java.util.ArrayList r1 = q7.i0.s0(r1)     // Catch: java.lang.Exception -> L7c
                int r1 = r1.size()     // Catch: java.lang.Exception -> L7c
                if (r1 <= 0) goto L81
                r1 = 0
            L22:
                q7.i0 r2 = q7.i0.this     // Catch: java.lang.Exception -> L7c
                java.util.ArrayList r2 = q7.i0.s0(r2)     // Catch: java.lang.Exception -> L7c
                int r2 = r2.size()     // Catch: java.lang.Exception -> L7c
                if (r1 >= r2) goto L81
                int r2 = r13.getItemId()     // Catch: java.lang.Exception -> L7c
                if (r2 != r1) goto L7e
                android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Exception -> L7c
                q7.i0 r3 = q7.i0.this     // Catch: java.lang.Exception -> L7c
                android.content.Context r3 = q7.i0.k0(r3)     // Catch: java.lang.Exception -> L7c
                java.lang.Class<com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity> r4 = com.nst.iptvsmarterstvbox.view.activity.PlayExternalPlayerActivity.class
                r2.<init>(r3, r4)     // Catch: java.lang.Exception -> L7c
                java.lang.String r3 = "url"
                java.lang.String r4 = r12.a     // Catch: java.lang.Exception -> L7c
                r2.putExtra(r3, r4)     // Catch: java.lang.Exception -> L7c
                java.lang.String r3 = "app_name"
                q7.i0 r4 = q7.i0.this     // Catch: java.lang.Exception -> L7c
                java.util.ArrayList r4 = q7.i0.s0(r4)     // Catch: java.lang.Exception -> L7c
                java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Exception -> L7c
                com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass r4 = (com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r4     // Catch: java.lang.Exception -> L7c
                java.lang.String r4 = r4.getAppname()     // Catch: java.lang.Exception -> L7c
                r2.putExtra(r3, r4)     // Catch: java.lang.Exception -> L7c
                java.lang.String r3 = "packagename"
                q7.i0 r4 = q7.i0.this     // Catch: java.lang.Exception -> L7c
                java.util.ArrayList r4 = q7.i0.s0(r4)     // Catch: java.lang.Exception -> L7c
                java.lang.Object r1 = r4.get(r1)     // Catch: java.lang.Exception -> L7c
                com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass r1 = (com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass) r1     // Catch: java.lang.Exception -> L7c
                java.lang.String r1 = r1.getPackagename()     // Catch: java.lang.Exception -> L7c
                r2.putExtra(r3, r1)     // Catch: java.lang.Exception -> L7c
                q7.i0 r1 = q7.i0.this     // Catch: java.lang.Exception -> L7c
                android.content.Context r1 = q7.i0.k0(r1)     // Catch: java.lang.Exception -> L7c
                r1.startActivity(r2)     // Catch: java.lang.Exception -> L7c
                goto L81
            L7c:
                goto L81
            L7e:
                int r1 = r1 + 1
                goto L22
            L81:
                int r13 = r13.getItemId()
                int r1 = a7.f.Hb
                if (r13 != r1) goto L99
                q7.i0 r13 = q7.i0.this
                java.lang.Boolean r13 = q7.i0.r0(r13)
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto Lf7
                r12.b()
                goto Lf7
            L99:
                int r1 = a7.f.Bb
                if (r13 != r1) goto La1
                r12.a()
                goto Lf7
            La1:
                int r1 = a7.f.Lb
                if (r13 != r1) goto La9
                r12.c()
                goto Lf7
            La9:
                int r1 = a7.f.nb
                if (r13 != r1) goto Lc4
                int r3 = r12.b
                java.lang.String r4 = r12.c
                java.lang.String r5 = r12.d
                java.lang.String r6 = r12.e
                java.lang.String r7 = r12.f
                java.lang.String r8 = r12.g
                java.lang.String r9 = r12.h
                java.lang.String r10 = r12.i
                java.lang.String r11 = r12.a
                r2 = r12
                r2.d(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                goto Lf7
            Lc4:
                int r1 = a7.f.Eb
                if (r13 != r1) goto Lf7
                q7.i0 r13 = q7.i0.this
                com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories r13 = q7.i0.t0(r13)
                if (r13 != 0) goto Ld8
                q7.i0 r13 = q7.i0.this
                boolean r13 = q7.i0.x0(r13)
                if (r13 != 0) goto Lf7
            Ld8:
                q7.i0 r13 = q7.i0.this
                com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories r13 = q7.i0.t0(r13)
                if (r13 == 0) goto Lf7
                q7.i0 r13 = q7.i0.this
                com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlowSubCategories r13 = q7.i0.t0(r13)
                int r1 = r12.b
                java.lang.String r2 = r12.c
                q7.i0 r3 = q7.i0.this
                android.content.Context r3 = q7.i0.k0(r3)
                q7.i0 r4 = q7.i0.this
                com.nst.iptvsmarterstvbox.model.database.RecentWatchDBHandler r4 = r4.m
                r13.J1(r1, r2, r3, r4)
            Lf7:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.i0.i.onMenuItemClick(android.view.MenuItem):boolean");
        }
    }

    public class j implements U.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ k k;

        public j(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, k kVar) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
            this.j = str9;
            this.k = kVar;
        }

        private void a() {
            FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
            favouriteDBModel.setCategoryID(this.g);
            favouriteDBModel.setStreamID(this.b);
            favouriteDBModel.setStreamIDOneStream(this.j);
            favouriteDBModel.setName(this.d);
            favouriteDBModel.setNum(this.h);
            favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(i0.k0(i0.this)));
            i0.this.j.addToFavourite(favouriteDBModel, "vod");
            this.k.y.setVisibility(0);
        }

        private void b() {
            m7.w.w0(i0.k0(i0.this), this.e, this.b, this.f, this.c, this.h, this.d, "", 0, "", "", "");
        }

        private void c() {
            i0 i0Var = i0.this;
            i0Var.j.deleteFavourite(this.b, this.g, "vod", this.d, SharepreferenceDBHandler.getUserID(i0.k0(i0Var)), this.j);
            this.k.y.setVisibility(4);
        }

        public final void d(int i, String str, String str2, String str3, String str4, String str5, String str6) {
            if (i0.k0(i0.this) != null) {
                Intent intent = new Intent(i0.k0(i0.this), ViewDetailsActivity.class);
                intent.putExtra(m7.a.Q, String.valueOf(i));
                intent.putExtra("movie", str);
                intent.putExtra("selectedPlayer", str2);
                intent.putExtra("streamType", str3);
                intent.putExtra("containerExtension", str4);
                intent.putExtra("categoryID", str5);
                intent.putExtra("num", str6);
                i0.k0(i0.this).startActivity(intent);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00fb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onMenuItemClick(android.view.MenuItem r12) {
            /*
                Method dump skipped, instructions count: 461
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: q7.i0.j.onMenuItemClick(android.view.MenuItem):boolean");
        }
    }

    public static class k extends RecyclerView.D {
        public ImageView A;
        public TextView t;
        public RelativeLayout u;
        public ImageView v;
        public CardView w;
        public TextView x;
        public ImageView y;
        public LinearLayout z;

        public k(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Fl);
            this.u = view.findViewById(a7.f.Ge);
            this.v = view.findViewById(a7.f.B5);
            this.w = view.findViewById(a7.f.J1);
            this.x = view.findViewById(a7.f.Ul);
            this.y = view.findViewById(a7.f.g5);
            this.z = view.findViewById(a7.f.O8);
            this.A = view.findViewById(a7.f.X5);
            J(false);
        }
    }

    public class l implements View.OnFocusChangeListener {
        public final View a;

        public l(View view) {
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
                f = z ? 1.1f : 1.0f;
                Log.e("id is", "" + this.a.getTag());
                if (this.a.getTag() != null && this.a.getTag().equals("1")) {
                    b(f);
                    view2 = this.a;
                    i = a7.e.h;
                } else if (this.a.getTag() == null || !this.a.getTag().equals("2")) {
                    b(f);
                    return;
                } else {
                    b(f);
                    view2 = this.a;
                    i = a7.e.k1;
                }
            } else {
                if (z) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(z);
                if ((this.a.getTag() == null || !this.a.getTag().equals("1")) && (this.a.getTag() == null || !this.a.getTag().equals("2"))) {
                    b(f);
                    c(f);
                    return;
                } else {
                    b(f);
                    c(f);
                    view2 = this.a;
                    i = a7.e.o;
                }
            }
            view2.setBackgroundResource(i);
        }
    }

    public i0(List list, Context context, boolean z) {
        String str;
        String str2;
        this.u = Boolean.TRUE;
        Boolean bool = Boolean.FALSE;
        this.z = bool;
        this.C = "";
        this.D = true;
        this.F = 0;
        this.e = list;
        this.d = context;
        this.h = m7.w.S0(w7.a.a());
        H = context.getApplicationContext().getPackageName();
        this.g = new ArrayList();
        G = K0(context);
        this.l = m7.w.S0(w7.d.d());
        this.g.addAll(list);
        Locale locale = Locale.US;
        this.n = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.i = list;
        this.y = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.j = new DatabaseHandler(context);
        this.k = new LiveStreamDBHandler(context);
        this.v = new Date();
        this.m = new RecentWatchDBHandler(context);
        SimpleDateFormat simpleDateFormat = this.n;
        if (F0(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(context))), this.y.format(this.v)) >= w7.c.p() && (str = this.h) != null && this.l != null && (!G.equals(str) || (this.h != null && (str2 = this.l) != null && !H.equals(str2)))) {
            this.u = bool;
        }
        this.w = new Handler();
        this.D = z;
    }

    public static /* synthetic */ List A0(i0 i0Var) {
        return i0Var.g;
    }

    public static /* synthetic */ List B0(i0 i0Var, List list) {
        i0Var.g = list;
        return list;
    }

    public static long F0(SimpleDateFormat simpleDateFormat, String str, String str2) {
        try {
            return TimeUnit.DAYS.convert(simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String K0(Context context) {
        return String.valueOf(context.getApplicationInfo().loadLabel(context.getPackageManager()));
    }

    private void R0(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (this.d == null) {
            Log.e("Null hai context", ">>>>>>>>>>>True its Null");
            return;
        }
        Intent intent = (m7.a.u.booleanValue() && SharepreferenceDBHandler.getCurrentAPPType(this.d).equals("m3u")) ? new Intent(this.d, ViewDetailsTMDBActivity.class) : new Intent(this.d, ViewDetailsActivity.class);
        intent.putExtra(m7.a.Q, String.valueOf(i2));
        intent.putExtra("movie", str);
        intent.putExtra("movie_icon", str7);
        intent.putExtra("selectedPlayer", str2);
        intent.putExtra("streamType", str3);
        intent.putExtra("containerExtension", str4);
        intent.putExtra("categoryID", str5);
        intent.putExtra("num", str6);
        intent.putExtra("videoURL", str8);
        this.d.startActivity(intent);
    }

    public static /* synthetic */ void j0(i0 i0Var, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        i0Var.R0(i2, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public static /* synthetic */ Context k0(i0 i0Var) {
        return i0Var.d;
    }

    public static /* synthetic */ List l0(i0 i0Var) {
        return i0Var.i;
    }

    public static /* synthetic */ List m0(i0 i0Var) {
        return i0Var.e;
    }

    public static /* synthetic */ List n0(i0 i0Var, List list) {
        i0Var.e = list;
        return list;
    }

    public static /* synthetic */ void p0(i0 i0Var, k kVar, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        i0Var.Q0(kVar, i2, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public static /* synthetic */ void q0(i0 i0Var, k kVar, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i0Var.O0(kVar, i2, str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public static /* synthetic */ Boolean r0(i0 i0Var) {
        return i0Var.u;
    }

    public static /* synthetic */ ArrayList s0(i0 i0Var) {
        return i0Var.A;
    }

    public static /* synthetic */ VodActivityNewFlowSubCategories t0(i0 i0Var) {
        return i0Var.B;
    }

    public static /* synthetic */ boolean x0(i0 i0Var) {
        return i0Var.D;
    }

    public static /* synthetic */ o4.e z0(i0 i0Var) {
        return i0Var.E;
    }

    public void J0(String str, TextView textView) {
        new Thread(new a(str, textView)).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5  */
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(q7.i0.k r30, int r31) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.i0.E(q7.i0$k, int):void");
    }

    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public k L(ViewGroup viewGroup, int i2) {
        LayoutInflater from;
        int i3;
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("showhidemoviename", 0);
        this.o = sharedPreferences;
        this.F = sharedPreferences.getInt("vod", 1);
        this.p = this.o.edit();
        SharedPreferences sharedPreferences2 = this.d.getSharedPreferences("listgridview", 0);
        this.q = sharedPreferences2;
        this.r = sharedPreferences2.edit();
        int i4 = this.q.getInt("vod", 0);
        m7.a.N = i4;
        if (i4 == 1) {
            from = LayoutInflater.from(viewGroup.getContext());
            i3 = a7.g.V4;
        } else {
            from = LayoutInflater.from(viewGroup.getContext());
            i3 = a7.g.y4;
        }
        return new k(from.inflate(i3, viewGroup, false));
    }

    public final void O0(k kVar, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Menu b2;
        int i3;
        Context context = this.d;
        if (context != null) {
            k.U u = new k.U(context, kVar.x);
            u.d(a7.h.h);
            ArrayList checkFavourite = this.j.checkFavourite(i2, str, "vod", SharepreferenceDBHandler.getUserID(this.d), str8);
            if (checkFavourite == null || checkFavourite.size() <= 0) {
                b2 = u.b();
                i3 = 3;
            } else {
                b2 = u.b();
                i3 = 4;
            }
            b2.getItem(i3).setVisible(true);
            if (this.D) {
                u.b().getItem(5).setVisible(false);
            } else {
                u.b().getItem(5).setVisible(true);
            }
            try {
                o4.e c2 = o4.b.e(this.d).c().c();
                this.E = c2;
                if (c2 == null || !c2.c()) {
                    u.b().getItem(7).setVisible(false);
                } else {
                    u.b().getItem(7).setVisible(true);
                }
            } catch (Exception e2) {
                Log.e("sdng", "" + e2);
            }
            try {
                if (this.u.booleanValue()) {
                    this.A = new ArrayList();
                    ArrayList externalPlayer = new ExternalPlayerDataBase(this.d).getExternalPlayer();
                    this.A = externalPlayer;
                    if (externalPlayer != null && externalPlayer.size() > 0) {
                        for (int i4 = 0; i4 < this.A.size(); i4++) {
                            u.b().add(0, i4, i4, ((ExternalPlayerModelClass) this.A.get(i4)).getAppname());
                        }
                    }
                }
            } catch (Exception unused) {
            }
            u.f(new j(str9, i2, str5, str2, str3, str4, str, str6, str7, str8, kVar));
            u.g();
        }
    }

    public final void Q0(k kVar, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Menu b2;
        int i3;
        Context context = this.d;
        if (context != null) {
            k.U u = new k.U(context, kVar.x);
            u.d(a7.h.h);
            ArrayList checkFavourite = this.k.checkFavourite(str8, SharepreferenceDBHandler.getUserID(this.d));
            if (checkFavourite == null || checkFavourite.size() <= 0) {
                b2 = u.b();
                i3 = 3;
            } else {
                b2 = u.b();
                i3 = 4;
            }
            b2.getItem(i3).setVisible(true);
            if (this.D) {
                u.b().getItem(5).setVisible(false);
            } else {
                u.b().getItem(5).setVisible(true);
            }
            try {
                o4.e c2 = o4.b.e(this.d).c().c();
                this.E = c2;
                if (c2 == null || !c2.c()) {
                    u.b().getItem(7).setVisible(false);
                } else {
                    u.b().getItem(7).setVisible(true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.A = new ArrayList();
            ArrayList externalPlayer = new ExternalPlayerDataBase(this.d).getExternalPlayer();
            this.A = externalPlayer;
            if (externalPlayer != null && externalPlayer.size() > 0) {
                for (int i4 = 0; i4 < this.A.size(); i4++) {
                    u.b().add(0, i4, i4, ((ExternalPlayerModelClass) this.A.get(i4)).getAppname());
                }
            }
            u.f(new i(str8, i2, str2, str3, str4, str5, str, str6, str7, kVar));
            u.g();
        }
    }

    public int n() {
        return this.e.size();
    }

    public i0(List list, Context context, boolean z, VodActivityNewFlowSubCategories vodActivityNewFlowSubCategories) {
        String str;
        String str2;
        this.u = Boolean.TRUE;
        Boolean bool = Boolean.FALSE;
        this.z = bool;
        this.C = "";
        this.D = true;
        this.F = 0;
        this.e = list;
        this.d = context;
        this.h = m7.w.S0(w7.a.a());
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.addAll(list);
        H = context.getApplicationContext().getPackageName();
        this.i = list;
        G = K0(context);
        this.j = new DatabaseHandler(context);
        this.k = new LiveStreamDBHandler(context);
        this.l = m7.w.S0(w7.d.d());
        Locale locale = Locale.US;
        this.n = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.m = new RecentWatchDBHandler(context);
        this.y = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.w = new Handler();
        this.v = new Date();
        this.D = z;
        SimpleDateFormat simpleDateFormat = this.n;
        if (F0(simpleDateFormat, simpleDateFormat.format(new Date(w7.e.a(context))), this.y.format(this.v)) >= w7.c.p() && (str = this.h) != null && this.l != null && (!G.equals(str) || (this.h != null && (str2 = this.l) != null && !H.equals(str2)))) {
            this.u = bool;
        }
        this.B = vodActivityNewFlowSubCategories;
    }
}
