package q7;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.ExpandedControlsActivity;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.LiveStreamsDBModel;
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
import com.nst.iptvsmarterstvbox.view.activity.ViewDetailsActivity;
import com.nst.iptvsmarterstvbox.view.activity.ViewDetailsTMDBActivity;
import com.nst.iptvsmarterstvbox.view.activity.VodAllDataSingleActivity;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import k.U;
import q7.Z;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class m0 extends RecyclerView.g implements Filterable, z7.g {
    public RecentWatchDBHandler B;
    public LiveStreamDBHandler C;
    public n7.e D;
    public x E;
    public Context i;
    public DatabaseHandler k;
    public Animation l;
    public String m;
    public String p;
    public int s;
    public SharedPreferences t;
    public o4.e u;
    public Boolean j = Boolean.FALSE;
    public u n = new u(this, null);
    public v o = new v(this, null);
    public String q = "";
    public boolean r = true;
    public String v = "";
    public String w = "0";
    public String x = "";
    public String y = "";
    public String z = "";
    public int A = 0;
    public String F = "";
    public boolean G = false;
    public String H = "";
    public String I = "";
    public String J = "";
    public boolean K = false;
    public boolean L = false;
    public ArrayList d = VodAllCategoriesSingleton.getInstance().getvodList();
    public ArrayList e = VodAllCategoriesSingleton.getInstance().getvodList();
    public final ArrayList f = VodAllCategoriesSingleton.getInstance().getContinueWatchingList();
    public ArrayList g = VodAllCategoriesSingleton.getInstance().getVodFavList();
    public ArrayList h = VodAllCategoriesSingleton.getInstance().getContinueWatchingList();

    public class e implements View.OnClickListener {
        public final /* synthetic */ int a;
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
        public final /* synthetic */ String n;
        public final /* synthetic */ String o;
        public final /* synthetic */ String p;
        public final /* synthetic */ String q;
        public final /* synthetic */ String r;
        public final /* synthetic */ String s;
        public final /* synthetic */ String t;

        public e(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
            this.a = i;
            this.c = i2;
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
            this.n = str11;
            this.o = str12;
            this.p = str13;
            this.q = str14;
            this.r = str15;
            this.s = str16;
            this.t = str17;
        }

        public void onClick(View view) {
            int i;
            try {
                i = ((LiveStreamsDBModel) m0.m0(m0.this).get(this.a)).getFav();
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            m0.s0(m0.this, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.a, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, i, this.t);
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ int a;
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
        public final /* synthetic */ String n;
        public final /* synthetic */ String o;
        public final /* synthetic */ String p;
        public final /* synthetic */ String q;
        public final /* synthetic */ String r;
        public final /* synthetic */ String s;
        public final /* synthetic */ String t;

        public f(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
            this.a = i;
            this.c = i2;
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
            this.n = str11;
            this.o = str12;
            this.p = str13;
            this.q = str14;
            this.r = str15;
            this.s = str16;
            this.t = str17;
        }

        public void onClick(View view) {
            int i;
            int i2 = 0;
            try {
                if (m0.m0(m0.this) != null && m0.m0(m0.this).size() > 0 && m0.m0(m0.this).get(this.a) != null) {
                    i2 = ((LiveStreamsDBModel) m0.m0(m0.this).get(this.a)).getFav();
                }
                i = i2;
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            m0.s0(m0.this, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.a, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, i, this.t);
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ int a;
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
        public final /* synthetic */ String n;
        public final /* synthetic */ String o;
        public final /* synthetic */ String p;
        public final /* synthetic */ String q;
        public final /* synthetic */ String r;
        public final /* synthetic */ String s;
        public final /* synthetic */ String t;

        public g(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
            this.a = i;
            this.c = i2;
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
            this.n = str11;
            this.o = str12;
            this.p = str13;
            this.q = str14;
            this.r = str15;
            this.s = str16;
            this.t = str17;
        }

        public void onClick(View view) {
            int i;
            try {
                i = ((LiveStreamsDBModel) m0.m0(m0.this).get(this.a)).getFav();
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            m0.s0(m0.this, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.a, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, i, this.t);
        }
    }

    public class h implements View.OnLongClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ x d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;

        public h(int i, String str, x xVar, int i2, String str2, String str3, int i3) {
            this.a = i;
            this.c = str;
            this.d = xVar;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = i3;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(m0.A0(m0.this)).equals("m3u")) {
                ArrayList checkFavourite = m0.t0(m0.this).checkFavourite(this.c, SharepreferenceDBHandler.getUserID(m0.A0(m0.this)));
                m0 m0Var = m0.this;
                m0.x0(m0Var, checkFavourite, this.d, this.a, m0.m0(m0Var));
                return true;
            }
            if (!SharepreferenceDBHandler.getCurrentAPPType(m0.A0(m0.this)).equals("stalker_api")) {
                ArrayList checkFavourite2 = m0.F0(m0.this).checkFavourite(this.e, this.g, "vod", SharepreferenceDBHandler.getUserID(m0.A0(m0.this)), this.f);
                m0 m0Var2 = m0.this;
                m0.J0(m0Var2, checkFavourite2, this.d, this.a, m0.m0(m0Var2), m0.p0(m0.this), this.h, this.d.u);
                return true;
            }
            m7.w.N0(m0.A0(m0.this));
            try {
                if (this.d.y.getVisibility() == 0) {
                    m0.z0(m0.this, this.e, this.d, this.a);
                } else {
                    m0.B0(m0.this, this.e, this.d, this.a);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    public class i implements View.OnLongClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ x d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;

        public i(int i, String str, x xVar, int i2, String str2, String str3, int i3) {
            this.a = i;
            this.c = str;
            this.d = xVar;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = i3;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(m0.A0(m0.this)).equals("m3u")) {
                ArrayList checkFavourite = m0.t0(m0.this).checkFavourite(this.c, SharepreferenceDBHandler.getUserID(m0.A0(m0.this)));
                m0 m0Var = m0.this;
                m0.x0(m0Var, checkFavourite, this.d, this.a, m0.m0(m0Var));
                return true;
            }
            if (!SharepreferenceDBHandler.getCurrentAPPType(m0.A0(m0.this)).equals("stalker_api")) {
                ArrayList checkFavourite2 = m0.F0(m0.this).checkFavourite(this.e, this.g, "vod", SharepreferenceDBHandler.getUserID(m0.A0(m0.this)), this.f);
                m0 m0Var2 = m0.this;
                m0.J0(m0Var2, checkFavourite2, this.d, this.a, m0.m0(m0Var2), m0.p0(m0.this), this.h, this.d.u);
                return true;
            }
            m7.w.N0(m0.A0(m0.this));
            try {
                if (this.d.y.getVisibility() == 0) {
                    m0.z0(m0.this, this.e, this.d, this.a);
                } else {
                    m0.B0(m0.this, this.e, this.d, this.a);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    public class j implements View.OnLongClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ x d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ int h;

        public j(int i, String str, x xVar, int i2, String str2, String str3, int i3) {
            this.a = i;
            this.c = str;
            this.d = xVar;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = i3;
        }

        public boolean onLongClick(View view) {
            if (SharepreferenceDBHandler.getCurrentAPPType(m0.A0(m0.this)).equals("m3u")) {
                ArrayList checkFavourite = m0.t0(m0.this).checkFavourite(this.c, SharepreferenceDBHandler.getUserID(m0.A0(m0.this)));
                m0 m0Var = m0.this;
                m0.x0(m0Var, checkFavourite, this.d, this.a, m0.m0(m0Var));
                return true;
            }
            if (!SharepreferenceDBHandler.getCurrentAPPType(m0.A0(m0.this)).equals("stalker_api")) {
                ArrayList checkFavourite2 = m0.F0(m0.this).checkFavourite(this.e, this.g, "vod", SharepreferenceDBHandler.getUserID(m0.A0(m0.this)), this.f);
                m0 m0Var2 = m0.this;
                m0.J0(m0Var2, checkFavourite2, this.d, this.a, m0.m0(m0Var2), m0.p0(m0.this), this.h, this.d.u);
                return true;
            }
            m7.w.N0(m0.A0(m0.this));
            try {
                if (this.d.y.getVisibility() == 0) {
                    m0.z0(m0.this, this.e, this.d, this.a);
                } else {
                    m0.B0(m0.this, this.e, this.d, this.a);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    public class k implements U.d {
        public final /* synthetic */ RecyclerView.D a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ int e;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                m0.this.w();
            }
        }

        public class b extends Dialog implements View.OnClickListener {
            public Activity a;
            public TextView c;
            public TextView d;
            public TextView e;
            public LinearLayout f;
            public LinearLayout g;

            public class a implements Runnable {
                public a() {
                }

                public void run() {
                    if (m0.A0(m0.this) instanceof VodAllDataSingleActivity) {
                        m0.A0(m0.this).v2();
                    }
                }
            }

            public class b implements View.OnFocusChangeListener {
                public View a;

                public b(View view) {
                    this.a = view;
                }

                public void onFocusChange(View view, boolean z) {
                    LinearLayout b;
                    int i;
                    if (z) {
                        View view2 = this.a;
                        if (view2 == null || view2.getTag() == null || !this.a.getTag().equals("1")) {
                            View view3 = this.a;
                            if (view3 == null || view3.getTag() == null || !this.a.getTag().equals("2")) {
                                return;
                            } else {
                                b = b.b(b.this);
                            }
                        } else {
                            b = b.a(b.this);
                        }
                        i = a7.e.p;
                    } else {
                        View view4 = this.a;
                        if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("1")) {
                            View view5 = this.a;
                            if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("2")) {
                                return;
                            } else {
                                b = b.b(b.this);
                            }
                        } else {
                            b = b.a(b.this);
                        }
                        i = a7.e.o;
                    }
                    b.setBackgroundResource(i);
                }
            }

            public b(Activity activity) {
                super(activity);
                this.a = activity;
            }

            public static /* synthetic */ LinearLayout a(b bVar) {
                return bVar.f;
            }

            public static /* synthetic */ LinearLayout b(b bVar) {
                return bVar.g;
            }

            public void onClick(View view) {
                RecentWatchDBHandler N0;
                String streamId;
                if (view.getId() == a7.f.u1) {
                    try {
                        if (SharepreferenceDBHandler.getCurrentAPPType(m0.A0(m0.this)).equals("onestream_api")) {
                            N0 = m0.N0(m0.this);
                            k kVar = k.this;
                            streamId = ((LiveStreamsDBModel) kVar.d.get(kVar.b)).getStreamIdOneStream();
                        } else {
                            N0 = m0.N0(m0.this);
                            k kVar2 = k.this;
                            streamId = ((LiveStreamsDBModel) kVar2.d.get(kVar2.b)).getStreamId();
                        }
                        N0.updateAllRecordsRecentWatchDB(streamId);
                        if (m0.A0(m0.this) instanceof VodAllDataSingleActivity) {
                            m0.A0(m0.this).A2();
                        }
                        new Handler().postDelayed(new a(), 100L);
                    } catch (Exception unused) {
                    }
                } else if (view.getId() == a7.f.h1) {
                    dismiss();
                }
                dismiss();
            }

            public void onCreate(Bundle bundle) {
                super.onCreate(bundle);
                setContentView(new u7.a(m0.A0(m0.this)).A().equals(m7.a.K0) ? a7.g.X1 : a7.g.W1);
                this.c = findViewById(a7.f.u1);
                this.d = findViewById(a7.f.h1);
                this.f = findViewById(a7.f.V8);
                this.g = findViewById(a7.f.Ia);
                TextView findViewById = findViewById(a7.f.um);
                this.e = findViewById;
                findViewById.setText(m0.A0(m0.this).getResources().getString(a7.j.Z8));
                this.c.setOnClickListener(this);
                this.d.setOnClickListener(this);
                TextView textView = this.c;
                textView.setOnFocusChangeListener(new b(textView));
                TextView textView2 = this.d;
                textView2.setOnFocusChangeListener(new b(textView2));
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                m0.this.w();
            }
        }

        public k(RecyclerView.D d, int i, ArrayList arrayList, ArrayList arrayList2, int i2) {
            this.a = d;
            this.b = i;
            this.c = arrayList;
            this.d = arrayList2;
            this.e = i2;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() == a7.f.Bb) {
                m0.K0(m0.this, this.a, this.b, this.c, this.d, this.e);
                new Handler().postDelayed(new a(), 300L);
                if (!(m0.A0(m0.this) instanceof VodAllDataSingleActivity)) {
                    return true;
                }
                m0.A0(m0.this).v2();
                return true;
            }
            if (menuItem.getItemId() != a7.f.Lb) {
                if (menuItem.getItemId() != a7.f.jb) {
                    return false;
                }
                new b(m0.A0(m0.this)).show();
                return false;
            }
            m0.L0(m0.this, this.a, this.b, this.c, this.d, this.e);
            new Handler().postDelayed(new c(), 300L);
            if (!(m0.A0(m0.this) instanceof VodAllDataSingleActivity)) {
                return false;
            }
            m0.A0(m0.this).v2();
            return false;
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

        public n(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
            this.j = str9;
            this.k = i;
        }

        public void onClick(View view) {
            m0.R0(m0.this, String.valueOf(this.a));
            m0.S0(m0.this, this.c);
            m0.W0(m0.this, this.d);
            m0.Y0(m0.this, this.e);
            m0.Z0(m0.this, this.f);
            m0.a1(m0.this, this.g);
            m0.b1(m0.this, this.h);
            m0.j0(m0.this, this.i);
            m0.k0(m0.this, m7.w.r0(this.j));
            m7.a.l0 = this.k;
            m0.l0(m0.this);
        }
    }

    public class o implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

        public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
            this.j = str9;
            this.k = i;
        }

        public void onClick(View view) {
            m0.R0(m0.this, String.valueOf(this.a));
            m0.S0(m0.this, this.c);
            m0.W0(m0.this, this.d);
            m0.Y0(m0.this, this.e);
            m0.Z0(m0.this, this.f);
            m0.a1(m0.this, this.g);
            m0.b1(m0.this, this.h);
            m0.j0(m0.this, this.i);
            m0.k0(m0.this, m7.w.r0(this.j));
            m7.a.l0 = this.k;
            m0.l0(m0.this);
        }
    }

    public class p implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ int k;

        public p(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i) {
            this.a = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = str6;
            this.h = str7;
            this.i = str8;
            this.j = str9;
            this.k = i;
        }

        public void onClick(View view) {
            m0.R0(m0.this, String.valueOf(this.a));
            m0.S0(m0.this, this.c);
            m0.W0(m0.this, this.d);
            m0.Y0(m0.this, this.e);
            m0.Z0(m0.this, this.f);
            m0.a1(m0.this, this.g);
            m0.b1(m0.this, this.h);
            m0.j0(m0.this, this.i);
            m0.k0(m0.this, m7.w.r0(this.j));
            m7.a.l0 = this.k;
            m0.l0(m0.this);
        }
    }

    public class q implements View.OnLongClickListener {
        public final /* synthetic */ t a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public q(t tVar, int i, int i2) {
            this.a = tVar;
            this.c = i;
            this.d = i2;
        }

        public boolean onLongClick(View view) {
            try {
                m0 m0Var = m0.this;
                m0.r0(m0Var, this.a, this.c, m0.m0(m0Var), m0.p0(m0.this), this.d);
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class r implements View.OnLongClickListener {
        public final /* synthetic */ t a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public r(t tVar, int i, int i2) {
            this.a = tVar;
            this.c = i;
            this.d = i2;
        }

        public boolean onLongClick(View view) {
            try {
                m0 m0Var = m0.this;
                m0.r0(m0Var, this.a, this.c, m0.m0(m0Var), m0.p0(m0.this), this.d);
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class s implements View.OnLongClickListener {
        public final /* synthetic */ t a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public s(t tVar, int i, int i2) {
            this.a = tVar;
            this.c = i;
            this.d = i2;
        }

        public boolean onLongClick(View view) {
            try {
                m0 m0Var = m0.this;
                m0.r0(m0Var, this.a, this.c, m0.m0(m0Var), m0.p0(m0.this), this.d);
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class t extends RecyclerView.D {
        public ProgressBar A;
        public CardView B;
        public TextView C;
        public TextView t;
        public TextView u;
        public RelativeLayout v;
        public ImageView w;
        public CardView x;
        public ImageView y;
        public LinearLayout z;

        public t(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Fl);
            this.u = view.findViewById(a7.f.wl);
            this.v = view.findViewById(a7.f.Ge);
            this.w = view.findViewById(a7.f.B5);
            this.x = view.findViewById(a7.f.J1);
            this.y = view.findViewById(a7.f.g5);
            this.z = view.findViewById(a7.f.l9);
            this.A = view.findViewById(a7.f.pc);
            this.B = view.findViewById(a7.f.C2);
            this.C = view.findViewById(a7.f.jl);
        }
    }

    public class u extends Filter {
        public u() {
        }

        public final String a(String str) {
            return Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(Normalizer.normalize(str, Normalizer.Form.NFD)).replaceAll("");
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            String a = a(charSequence.toString().toLowerCase());
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList O0 = m0.O0(m0.this);
            if (O0 == null) {
                filterResults.values = null;
                filterResults.count = 0;
                return filterResults;
            }
            int size = O0.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) O0.get(i);
                if (liveStreamsDBModel.getLiveStreamNameFilter().contains(a)) {
                    arrayList.add(liveStreamsDBModel);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            try {
                m0.n0(m0.this, (ArrayList) filterResults.values);
                if (m0.m0(m0.this) != null) {
                    m0.this.w();
                    if (m0.m0(m0.this) == null || m0.m0(m0.this).size() != 0) {
                        m0.A0(m0.this).L2();
                        m0.A0(m0.this).f2();
                    } else {
                        m0.A0(m0.this).j2();
                        m0.A0(m0.this).H2(m0.A0(m0.this).getResources().getString(a7.j.s4));
                    }
                }
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ u(m0 m0Var, a aVar) {
            this();
        }
    }

    public class v extends Filter {
        public v() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            String lowerCase = charSequence.toString().toLowerCase();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList Q0 = m0.Q0(m0.this);
            if (Q0 == null) {
                filterResults.values = null;
                filterResults.count = 0;
                return filterResults;
            }
            int size = Q0.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                LiveStreamsDBModel liveStreamsDBModel = (LiveStreamsDBModel) Q0.get(i);
                if (liveStreamsDBModel.getName().toLowerCase().contains(lowerCase) || liveStreamsDBModel.getName().contains(lowerCase)) {
                    arrayList.add(liveStreamsDBModel);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            try {
                m0.q0(m0.this, (ArrayList) filterResults.values);
                if (m0.p0(m0.this) != null) {
                    m0.this.w();
                    if (m0.p0(m0.this).size() == 0) {
                        m0.A0(m0.this).j2();
                        m0.A0(m0.this).H2(m0.A0(m0.this).getResources().getString(a7.j.s4));
                    } else {
                        m0.A0(m0.this).L2();
                        m0.A0(m0.this).f2();
                    }
                }
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ v(m0 m0Var, a aVar) {
            this();
        }
    }

    public class w implements View.OnFocusChangeListener {
        public int a;

        public w(int i) {
            this.a = i;
        }

        public void onFocusChange(View view, boolean z) {
            int i;
            m0 m0Var = m0.this;
            if (z) {
                if (m0.A0(m0Var) instanceof VodAllDataSingleActivity) {
                    m0.A0(m0.this).D2(this.a);
                }
                m0Var = m0.this;
                i = this.a;
            } else {
                i = -1;
            }
            m0Var.s = i;
        }
    }

    public static class x extends RecyclerView.D {
        public TextView A;
        public LinearLayout B;
        public TextView t;
        public RelativeLayout u;
        public ImageView v;
        public CardView w;
        public TextView x;
        public ImageView y;
        public CardView z;

        public x(View view) {
            super(view);
            this.t = view.findViewById(a7.f.Fl);
            this.u = view.findViewById(a7.f.Ge);
            this.v = view.findViewById(a7.f.B5);
            this.w = view.findViewById(a7.f.J1);
            this.x = view.findViewById(a7.f.Ul);
            this.y = view.findViewById(a7.f.g5);
            this.z = view.findViewById(a7.f.C2);
            this.A = view.findViewById(a7.f.jl);
            this.B = view.findViewById(a7.f.O8);
        }
    }

    public m0(Context context, String str, int i2) {
        this.m = "";
        this.p = "mobile";
        this.s = -1;
        this.i = context;
        this.k = new DatabaseHandler(context);
        this.C = new LiveStreamDBHandler(context);
        this.B = new RecentWatchDBHandler(context);
        this.l = AnimationUtils.loadAnimation(context, a7.b.a);
        this.m = str;
        this.s = i2;
        this.D = new n7.e(this, context);
        if (new u7.a(context).A().equals(m7.a.K0)) {
            this.p = "tv";
        } else {
            this.p = "mobile";
        }
        if (this.p.equals("mobile")) {
            try {
                this.u = o4.b.e(context).c().c();
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ Context A0(m0 m0Var) {
        return m0Var.i;
    }

    public static /* synthetic */ void B0(m0 m0Var, int i2, x xVar, int i3) {
        m0Var.c1(i2, xVar, i3);
    }

    public static /* synthetic */ DatabaseHandler F0(m0 m0Var) {
        return m0Var.k;
    }

    public static /* synthetic */ void J0(m0 m0Var, ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2, List list, int i3, RelativeLayout relativeLayout) {
        m0Var.f1(arrayList, d2, i2, arrayList2, list, i3, relativeLayout);
    }

    public static /* synthetic */ void K0(m0 m0Var, RecyclerView.D d2, int i2, ArrayList arrayList, List list, int i3) {
        m0Var.d1(d2, i2, arrayList, list, i3);
    }

    public static /* synthetic */ void L0(m0 m0Var, RecyclerView.D d2, int i2, ArrayList arrayList, List list, int i3) {
        m0Var.m1(d2, i2, arrayList, list, i3);
    }

    public static /* synthetic */ RecentWatchDBHandler N0(m0 m0Var) {
        return m0Var.B;
    }

    public static /* synthetic */ ArrayList O0(m0 m0Var) {
        return m0Var.d;
    }

    public static /* synthetic */ ArrayList Q0(m0 m0Var) {
        return m0Var.f;
    }

    public static /* synthetic */ String R0(m0 m0Var, String str) {
        m0Var.y = str;
        return str;
    }

    public static /* synthetic */ String S0(m0 m0Var, String str) {
        m0Var.I = str;
        return str;
    }

    public static /* synthetic */ String W0(m0 m0Var, String str) {
        m0Var.J = str;
        return str;
    }

    public static /* synthetic */ String Y0(m0 m0Var, String str) {
        m0Var.v = str;
        return str;
    }

    public static /* synthetic */ String Z0(m0 m0Var, String str) {
        m0Var.z = str;
        return str;
    }

    public static /* synthetic */ String a1(m0 m0Var, String str) {
        m0Var.q = str;
        return str;
    }

    public static /* synthetic */ String b1(m0 m0Var, String str) {
        m0Var.w = str;
        return str;
    }

    private void d1(RecyclerView.D d2, int i2, ArrayList arrayList, List list, int i3) {
        ImageView imageView;
        if (i3 == 1) {
            t tVar = (t) d2;
            FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
            favouriteDBModel.setCategoryID(((LiveStreamsDBModel) list.get(i2)).getCategoryId());
            favouriteDBModel.setStreamID(m7.w.r0(((LiveStreamsDBModel) list.get(i2)).getStreamId()));
            favouriteDBModel.setStreamIDOneStream(((LiveStreamsDBModel) list.get(i2)).getStreamId());
            favouriteDBModel.setName(((LiveStreamsDBModel) list.get(i2)).getName());
            favouriteDBModel.setNum(((LiveStreamsDBModel) list.get(i2)).getNum());
            favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(this.i));
            this.k.addToFavourite(favouriteDBModel, "vod");
            tVar.y.startAnimation(this.l);
            imageView = tVar.y;
        } else {
            x xVar = (x) d2;
            FavouriteDBModel favouriteDBModel2 = new FavouriteDBModel();
            favouriteDBModel2.setCategoryID(((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId());
            favouriteDBModel2.setStreamID(m7.w.r0(((LiveStreamsDBModel) arrayList.get(i2)).getStreamId()));
            favouriteDBModel2.setStreamIDOneStream(((LiveStreamsDBModel) arrayList.get(i2)).getStreamId());
            favouriteDBModel2.setName(((LiveStreamsDBModel) arrayList.get(i2)).getName());
            favouriteDBModel2.setNum(((LiveStreamsDBModel) arrayList.get(i2)).getNum());
            favouriteDBModel2.setUserID(SharepreferenceDBHandler.getUserID(this.i));
            this.k.addToFavourite(favouriteDBModel2, "vod");
            xVar.y.startAnimation(this.l);
            imageView = xVar.y;
        }
        imageView.setVisibility(0);
    }

    private void e1(RecyclerView.D d2, int i2, ArrayList arrayList) {
        x xVar = (x) d2;
        FavouriteM3UModel favouriteM3UModel = new FavouriteM3UModel();
        favouriteM3UModel.setUrl(((LiveStreamsDBModel) arrayList.get(i2)).getUrl());
        favouriteM3UModel.setUserID(SharepreferenceDBHandler.getUserID(this.i));
        favouriteM3UModel.setName(((LiveStreamsDBModel) arrayList.get(i2)).getName());
        favouriteM3UModel.setCategoryID(((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId());
        this.C.addToFavourite(favouriteM3UModel);
        xVar.y.startAnimation(this.l);
        xVar.y.setVisibility(0);
    }

    private void f1(ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2, List list, int i3, RelativeLayout relativeLayout) {
        if (arrayList.size() > 0) {
            m1(d2, i2, arrayList2, list, i3);
        } else {
            d1(d2, i2, arrayList2, list, i3);
        }
        this.r = true;
        VodAllDataSingleActivity vodAllDataSingleActivity = this.i;
        if (vodAllDataSingleActivity instanceof VodAllDataSingleActivity) {
            vodAllDataSingleActivity.v2();
        }
    }

    private void g1(ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2) {
        if (arrayList.size() > 0) {
            n1(d2, i2, arrayList2);
        } else {
            e1(d2, i2, arrayList2);
        }
        this.r = true;
        VodAllDataSingleActivity vodAllDataSingleActivity = this.i;
        if (vodAllDataSingleActivity instanceof VodAllDataSingleActivity) {
            vodAllDataSingleActivity.v2();
        }
    }

    public static /* synthetic */ String j0(m0 m0Var, String str) {
        m0Var.x = str;
        return str;
    }

    private void j1() {
        if (this.p.equals("mobile")) {
            try {
                this.u = o4.b.e(this.i).c().c();
            } catch (Exception unused) {
            }
        }
        o4.e eVar = this.u;
        if (eVar == null || !eVar.c()) {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.i).equals("onestream_api")) {
                m7.w.w0(this.i, "", 0, "movie", this.q, "0", this.z, this.J, this.A, this.I, "", "");
                return;
            } else {
                m7.a.q0 = true;
                m7.w.w0(this.i, "", m7.w.r0(this.y), "movie", this.q, "0", this.z, "", this.A, "", "", "");
                return;
            }
        }
        String U = SharepreferenceDBHandler.getCurrentAPPType(this.i).equals("onestream_api") ? this.J : m7.w.U(this.i, m7.w.r0(this.y), this.q, "movie");
        o4.e eVar2 = this.u;
        if (((eVar2 == null || eVar2.r() == null || this.u.r().j() == null || this.u.r().j().J() == null) ? "" : this.u.r().j().J()).equals(U)) {
            this.i.startActivity(new Intent(this.i, ExpandedControlsActivity.class));
        } else {
            i7.a.c(m7.w.r0(this.w), true, i7.a.a(this.z, "", "", 0, U, "videos/mp4", this.v, "", (List) null), this.u, this.i);
        }
    }

    public static /* synthetic */ int k0(m0 m0Var, int i2) {
        m0Var.A = i2;
        return i2;
    }

    public static /* synthetic */ void l0(m0 m0Var) {
        m0Var.j1();
    }

    public static /* synthetic */ ArrayList m0(m0 m0Var) {
        return m0Var.e;
    }

    private void m1(RecyclerView.D d2, int i2, ArrayList arrayList, List list, int i3) {
        if (i3 == 1) {
            this.k.deleteFavourite(m7.w.r0(((LiveStreamsDBModel) list.get(i2)).getStreamId()), ((LiveStreamsDBModel) list.get(i2)).getCategoryId(), "vod", ((LiveStreamsDBModel) list.get(i2)).getName(), SharepreferenceDBHandler.getUserID(this.i), ((LiveStreamsDBModel) list.get(i2)).getStreamIdOneStream());
            ((t) d2).y.setVisibility(4);
        } else {
            this.k.deleteFavourite(m7.w.r0(((LiveStreamsDBModel) arrayList.get(i2)).getStreamId()), ((LiveStreamsDBModel) arrayList.get(i2)).getCategoryId(), "vod", ((LiveStreamsDBModel) arrayList.get(i2)).getName(), SharepreferenceDBHandler.getUserID(this.i), ((LiveStreamsDBModel) arrayList.get(i2)).getStreamIdOneStream());
            ((x) d2).y.setVisibility(4);
            boolean z = this.i instanceof VodAllDataSingleActivity;
        }
    }

    public static /* synthetic */ ArrayList n0(m0 m0Var, ArrayList arrayList) {
        m0Var.e = arrayList;
        return arrayList;
    }

    private void n1(RecyclerView.D d2, int i2, ArrayList arrayList) {
        this.C.deleteFavourite(((LiveStreamsDBModel) arrayList.get(i2)).getUrl(), SharepreferenceDBHandler.getUserID(this.i));
        ((x) d2).y.setVisibility(4);
    }

    public static /* synthetic */ ArrayList p0(m0 m0Var) {
        return m0Var.h;
    }

    public static /* synthetic */ ArrayList q0(m0 m0Var, ArrayList arrayList) {
        m0Var.h = arrayList;
        return arrayList;
    }

    public static /* synthetic */ void r0(m0 m0Var, RecyclerView.D d2, int i2, ArrayList arrayList, ArrayList arrayList2, int i3) {
        m0Var.k1(d2, i2, arrayList, arrayList2, i3);
    }

    public static /* synthetic */ void s0(m0 m0Var, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17) {
        m0Var.r1(i2, str, str2, str3, str4, str5, str6, str7, str8, i3, str9, str10, str11, str12, str13, str14, str15, str16, i4, str17);
    }

    public static /* synthetic */ LiveStreamDBHandler t0(m0 m0Var) {
        return m0Var.C;
    }

    public static /* synthetic */ void x0(m0 m0Var, ArrayList arrayList, RecyclerView.D d2, int i2, ArrayList arrayList2) {
        m0Var.g1(arrayList, d2, i2, arrayList2);
    }

    public static /* synthetic */ void z0(m0 m0Var, int i2, x xVar, int i3) {
        m0Var.l1(i2, xVar, i3);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:11|(1:13)|14|(1:16)|(1:89)(5:20|21|22|23|24)|25|(1:27)(1:82)|(17:29|(0)(1:33)|34|35|37|38|39|40|41|(1:43)|44|(8:66|67|48|(1:50)(1:65)|51|(0)(1:55)|56|(2:58|(2:60|(1:62))(1:63)))(1:46)|47|48|(0)(0)|51|(1:53))(1:81)|80|34|35|37|38|39|40|41|(0)|44|(0)(0)|47|48|(0)(0)|51|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0175, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0177, code lost:
    
        r0.printStackTrace();
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0161, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0165, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0168, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0163, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0164, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03d2 A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e5 A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03ee A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03fd A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x040c A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x041b A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x042a A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0439 A[Catch: Exception -> 0x0340, TRY_LEAVE, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0464 A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0481 A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0493 A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0500 A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0540 A[Catch: Exception -> 0x0340, TRY_ENTER, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x06d5 A[Catch: Exception -> 0x06ea, TryCatch #2 {Exception -> 0x06ea, blocks: (B:195:0x06cb, B:197:0x06d5, B:199:0x06e3, B:201:0x06e7, B:202:0x06ed, B:204:0x06f1, B:206:0x06f7, B:207:0x070a, B:209:0x070e, B:211:0x0712, B:213:0x0716, B:214:0x071b, B:216:0x072c, B:218:0x0730, B:220:0x0736, B:222:0x073e, B:224:0x0742, B:225:0x0768, B:226:0x076c, B:227:0x0794, B:228:0x07a1, B:230:0x07af, B:232:0x07b5, B:234:0x07b9, B:237:0x07c1), top: B:194:0x06cb }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x070e A[Catch: Exception -> 0x06ea, TryCatch #2 {Exception -> 0x06ea, blocks: (B:195:0x06cb, B:197:0x06d5, B:199:0x06e3, B:201:0x06e7, B:202:0x06ed, B:204:0x06f1, B:206:0x06f7, B:207:0x070a, B:209:0x070e, B:211:0x0712, B:213:0x0716, B:214:0x071b, B:216:0x072c, B:218:0x0730, B:220:0x0736, B:222:0x073e, B:224:0x0742, B:225:0x0768, B:226:0x076c, B:227:0x0794, B:228:0x07a1, B:230:0x07af, B:232:0x07b5, B:234:0x07b9, B:237:0x07c1), top: B:194:0x06cb }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x07af A[Catch: Exception -> 0x06ea, TryCatch #2 {Exception -> 0x06ea, blocks: (B:195:0x06cb, B:197:0x06d5, B:199:0x06e3, B:201:0x06e7, B:202:0x06ed, B:204:0x06f1, B:206:0x06f7, B:207:0x070a, B:209:0x070e, B:211:0x0712, B:213:0x0716, B:214:0x071b, B:216:0x072c, B:218:0x0730, B:220:0x0736, B:222:0x073e, B:224:0x0742, B:225:0x0768, B:226:0x076c, B:227:0x0794, B:228:0x07a1, B:230:0x07af, B:232:0x07b5, B:234:0x07b9, B:237:0x07c1), top: B:194:0x06cb }] */
    /* JADX WARN: Removed duplicated region for block: B:239:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0705  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0563 A[Catch: Exception -> 0x0340, TRY_LEAVE, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04a5 A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0488 A[Catch: Exception -> 0x0340, TryCatch #9 {Exception -> 0x0340, blocks: (B:99:0x0312, B:101:0x0316, B:103:0x031c, B:105:0x0320, B:107:0x0339, B:108:0x0346, B:110:0x034c, B:111:0x0353, B:113:0x0359, B:114:0x0362, B:300:0x0368, B:301:0x0372, B:117:0x0380, B:119:0x0386, B:120:0x038d, B:122:0x0393, B:123:0x039a, B:125:0x03a0, B:127:0x03aa, B:129:0x03ae, B:132:0x03b4, B:134:0x03cc, B:136:0x03d2, B:137:0x03db, B:139:0x03e5, B:140:0x03e8, B:142:0x03ee, B:143:0x03f7, B:145:0x03fd, B:146:0x0406, B:148:0x040c, B:149:0x0415, B:151:0x041b, B:152:0x0424, B:154:0x042a, B:155:0x0433, B:157:0x0439, B:159:0x043d, B:162:0x0443, B:164:0x045e, B:166:0x0464, B:167:0x046d, B:169:0x0481, B:170:0x0484, B:171:0x048d, B:173:0x0493, B:175:0x0499, B:176:0x04a1, B:177:0x04aa, B:181:0x0530, B:184:0x0540, B:186:0x0554, B:187:0x0557, B:189:0x05b9, B:252:0x055b, B:253:0x0563, B:263:0x0580, B:264:0x0583, B:265:0x0589, B:255:0x058d, B:257:0x05aa, B:258:0x05b2, B:269:0x0579, B:179:0x0500, B:180:0x04fc, B:273:0x04cd, B:274:0x04a5, B:275:0x0488, B:279:0x0454, B:292:0x03c5, B:271:0x04b0, B:260:0x0571), top: B:98:0x0312, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011f A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012e A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017d A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01dc A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x022e A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02c7 A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02ed A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02d9 A[PHI: r13 r14
      0x02d9: PHI (r13v7 q7.m0$t) = (r13v6 q7.m0$t), (r13v9 q7.m0$t), (r13v9 q7.m0$t) binds: [B:90:0x02db, B:52:0x02c5, B:54:0x02c9] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r14v6 int) = (r14v0 int), (r14v11 int), (r14v11 int) binds: [B:90:0x02db, B:52:0x02c5, B:54:0x02c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0234 A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0125 A[Catch: Exception -> 0x00c5, TryCatch #14 {Exception -> 0x00c5, blocks: (B:5:0x0029, B:7:0x002d, B:9:0x0033, B:11:0x0037, B:13:0x00b9, B:14:0x00c8, B:16:0x00d6, B:18:0x00e3, B:21:0x00e9, B:24:0x00ef, B:25:0x0104, B:27:0x011f, B:29:0x012e, B:31:0x0136, B:33:0x013c, B:43:0x017d, B:44:0x0187, B:48:0x020b, B:50:0x022e, B:51:0x0239, B:53:0x02c7, B:55:0x02cb, B:56:0x02dd, B:58:0x02ed, B:60:0x02f3, B:62:0x02f7, B:63:0x02ff, B:65:0x0234, B:46:0x01dc, B:47:0x01d8, B:69:0x01aa, B:73:0x0177, B:76:0x0165, B:80:0x0149, B:82:0x0125, B:85:0x00fe, B:67:0x018d, B:41:0x0170), top: B:4:0x0029, inners: #3, #6 }] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void E(androidx.recyclerview.widget.RecyclerView.D r51, int r52) {
        /*
            Method dump skipped, instructions count: 1995
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.m0.E(androidx.recyclerview.widget.RecyclerView$D, int):void");
    }

    public void I(x xVar, int i2) {
        try {
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.i);
            String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.i);
            this.E = xVar;
            this.F = "remove";
            this.D.f(loggedInMacAddress, stalkerToken, i2);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public RecyclerView.D L(ViewGroup viewGroup, int i2) {
        return i2 == 1 ? new t(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.z4, viewGroup, false)) : new x(LayoutInflater.from(viewGroup.getContext()).inflate(a7.g.y4, viewGroup, false));
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
        VodAllDataSingleActivity vodAllDataSingleActivity;
        String streamId;
        try {
            m7.w.X();
            String str = this.F;
            if (str == null || !str.equals("add")) {
                this.E.y.setVisibility(4);
                ArrayList arrayList = this.e;
                if (arrayList == null || arrayList.size() <= 0 || this.e.get(i2) == null) {
                    return;
                }
                ((LiveStreamsDBModel) this.e.get(i2)).setFav(0);
                vodAllDataSingleActivity = this.i;
                streamId = ((LiveStreamsDBModel) this.e.get(i2)).getStreamId();
            } else {
                this.E.y.startAnimation(this.l);
                this.E.y.setVisibility(0);
                ArrayList arrayList2 = this.e;
                if (arrayList2 == null || arrayList2.size() <= 0 || this.e.get(i2) == null) {
                    return;
                }
                ((LiveStreamsDBModel) this.e.get(i2)).setFav(1);
                vodAllDataSingleActivity = (VodAllDataSingleActivity) this.i;
                streamId = ((LiveStreamsDBModel) this.e.get(i2)).getStreamId();
            }
            vodAllDataSingleActivity.q2(streamId, this.F);
        } catch (Exception unused) {
        }
    }

    public void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, x xVar, int i2) {
        if (stalkerSetLiveFavCallback != null) {
            try {
                if (stalkerSetLiveFavCallback.getJs() == null || !stalkerSetLiveFavCallback.getJs().equals(Boolean.TRUE)) {
                    return;
                }
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.i);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.i);
                this.E = xVar;
                this.F = "add";
                this.D.f(loggedInMacAddress, stalkerToken, i2);
            } catch (Exception unused) {
                m7.w.X();
            }
        }
    }

    public final void c1(int i2, x xVar, int i3) {
        try {
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.i);
            this.D.e(SharepreferenceDBHandler.getLoggedInMacAddress(this.i), stalkerToken, xVar, String.valueOf(i2), i3);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public Filter getFilter() {
        return this.m.equals("continue_watching") ? this.o : this.n;
    }

    public boolean h1() {
        return this.r;
    }

    public int i1() {
        return this.s;
    }

    public final void k1(RecyclerView.D d2, int i2, ArrayList arrayList, ArrayList arrayList2, int i3) {
        if (i3 == 1) {
            k.U u2 = new k.U(this.i, ((t) d2).x);
            u2.d(a7.h.i);
            if (this.k.checkFavourite(m7.w.r0(((LiveStreamsDBModel) arrayList2.get(i2)).getStreamId()), ((LiveStreamsDBModel) arrayList2.get(i2)).getCategoryId(), "vod", SharepreferenceDBHandler.getUserID(this.i), ((LiveStreamsDBModel) arrayList2.get(i2)).getStreamId()).size() > 0) {
                u2.b().getItem(0).setVisible(false);
                u2.b().getItem(1).setVisible(true);
            } else {
                u2.b().getItem(0).setVisible(true);
                u2.b().getItem(1).setVisible(false);
            }
            u2.f(new k(d2, i2, arrayList, arrayList2, i3));
            u2.g();
        }
    }

    public final void l1(int i2, x xVar, int i3) {
        try {
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.i);
            this.D.s(SharepreferenceDBHandler.getLoggedInMacAddress(this.i), stalkerToken, xVar, String.valueOf(i2), i3);
        } catch (Exception unused) {
            m7.w.X();
        }
    }

    public int n() {
        ArrayList arrayList;
        if (this.m.equals("continue_watching")) {
            ArrayList arrayList2 = this.h;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return 0;
            }
            arrayList = this.h;
        } else {
            ArrayList arrayList3 = this.e;
            if (arrayList3 == null || arrayList3.size() <= 0) {
                return 0;
            }
            arrayList = this.e;
        }
        return arrayList.size();
    }

    public void o0(String str) {
        try {
            m7.w.X();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void o1() {
        this.r = false;
    }

    public int p(int i2) {
        return this.m.equals("continue_watching") ? 1 : 0;
    }

    public void q1() {
        this.d = VodAllCategoriesSingleton.getInstance().getvodList();
        this.e = VodAllCategoriesSingleton.getInstance().getvodList();
    }

    public final void r1(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i4, String str17) {
        String str18;
        String valueOf;
        if (this.i == null) {
            Log.e("Null hai context", ">>>>>>>>>>>True its Null");
            return;
        }
        Intent intent = (m7.a.u.booleanValue() && SharepreferenceDBHandler.getCurrentAPPType(this.i).equals("m3u")) ? new Intent(this.i, ViewDetailsTMDBActivity.class) : new Intent(this.i, ViewDetailsActivity.class);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.i).equals("onestream_api")) {
            str18 = m7.a.Q;
            valueOf = String.valueOf(str17);
        } else {
            str18 = m7.a.Q;
            valueOf = String.valueOf(i2);
        }
        intent.putExtra(str18, valueOf);
        intent.putExtra("movie", str);
        intent.putExtra("movie_icon", str7);
        intent.putExtra("selectedPlayer", str2);
        intent.putExtra("streamType", str3);
        intent.putExtra("containerExtension", str4);
        intent.putExtra("categoryID", str5);
        intent.putExtra("num", str6);
        intent.putExtra("videoURL", str8);
        intent.putExtra("movie_director", str9);
        intent.putExtra("movie_cast", str10);
        intent.putExtra("movie_genre", str11);
        intent.putExtra("movie_description", str12);
        intent.putExtra("movie_cmd", str13);
        intent.putExtra("movie_rating", str14);
        intent.putExtra("movie_duration_min", str15);
        intent.putExtra("movie_year", str16);
        intent.putExtra("movie_fav", i4);
        SharepreferenceDBHandler.setOneStreamVideourl(str8, this.i);
        m7.a.l0 = i3;
        this.i.startActivity(intent);
    }

    public void v0(String str) {
        try {
            m7.w.X();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void y0(String str) {
        try {
            m7.w.X();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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

    public void p1(m7.c cVar) {
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
    }

    public class a implements com.squareup.picasso.e {
        public final /* synthetic */ t a;

        public a(t tVar) {
            this.a = tVar;
        }

        public void a() {
            com.squareup.picasso.t.q(m0.A0(m0.this)).l(String.valueOf(m0.A0(m0.this).getResources().getDrawable(a7.e.B1))).e().a().h(this.a.w, new a());
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

    public class b implements com.squareup.picasso.e {
        public final /* synthetic */ x a;

        public b(x xVar) {
            this.a = xVar;
        }

        public void a() {
            com.squareup.picasso.t.q(m0.A0(m0.this)).l(String.valueOf(m0.A0(m0.this).getResources().getDrawable(a7.e.B1))).e().a().h(this.a.v, new a());
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

    public class l implements com.squareup.picasso.e {
        public l() {
        }

        public void a() {
        }

        public void onSuccess() {
        }
    }

    public class m implements com.squareup.picasso.e {
        public m() {
        }

        public void a() {
        }

        public void onSuccess() {
        }
    }

    public void O(Z.E e2, int i2) {
    }

    public void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e2, int i2) {
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
    }
}
