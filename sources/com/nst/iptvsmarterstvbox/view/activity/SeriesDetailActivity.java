package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.JsonElement;
import com.nst.iptvsmarterstvbox.miscelleneious.chromecastfeature.ExpandedControlsActivity;
import com.nst.iptvsmarterstvbox.model.EpisodesUsingSinglton;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.callback.GetEpisdoeDetailsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerCreatePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerDeletePlayerLinkCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAdCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetAllChannelsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetGenresCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetSeriesCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVODByCatCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerGetVodCategoriesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerLiveFavIdsCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerProfilesCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerSetLiveFavCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerShortEPGCallback;
import com.nst.iptvsmarterstvbox.model.callback.StalkerTokenCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBCastsCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTVShowsInfoCallback;
import com.nst.iptvsmarterstvbox.model.callback.TMDBTrailerCallback;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.ExternalPlayerDataBase;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.ExternalPlayerModelClass;
import com.nst.iptvsmarterstvbox.model.pojo.StalkerGetVODByCatPojo2;
import com.squareup.picasso.C;
import com.squareup.picasso.t;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import k.U;
import m7.w;
import org.json.JSONArray;
import org.json.JSONObject;
import q7.U;
import q7.Z;
import q7.m0;
import q7.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SeriesDetailActivity extends androidx.appcompat.app.b implements View.OnClickListener, z7.l, z7.m, z7.g, z7.j {
    public TextView A;
    public String A1;
    public TextView B;
    public n7.e B1;
    public TextView C;
    public n7.g C1;
    public TextView D;
    public TextView E;
    public TextView F;
    public RatingBar G;
    public ImageView H;
    public TextView I;
    public DatabaseHandler I0;
    public TextView J;
    public PopupWindow J0;
    public TextView K;
    public Button K0;
    public TextView L;
    public String L0;
    public LinearLayout M;
    public String M0;
    public ScrollView N;
    public TextView N0;
    public NestedScrollView O;
    public TextView O0;
    public LinearLayout P;
    public MenuItem P0;
    public LinearLayout Q;
    public Menu Q0;
    public LinearLayout R;
    public Button R0;
    public LinearLayout S;
    public LinearLayout T;
    public n7.i T0;
    public LinearLayout U;
    public n7.j U0;
    public LinearLayout V;
    public LinearLayout W;
    public LinearLayout X;
    public LinearLayout Y;
    public SharedPreferences Y0;
    public TextView Z;
    public SharedPreferences.Editor Z0;
    public q7.n b1;
    public U c1;
    public LinearLayout e0;
    public JSONArray e1;
    public TextView f0;
    public ImageView g0;
    public PopupWindow g1;
    public RecyclerView h0;
    public RecyclerView h1;
    public ProgressBar i0;
    public LinearLayout j0;
    public SeriesRecentWatchDatabase j1;
    public LinearLayout k0;
    public int k1;
    public LinearLayout l0;
    public String l1;
    public RelativeLayout m0;
    public RecyclerView n0;
    public o4.e n1;
    public TextView o0;
    public TextView p0;
    public int q;
    public ImageView q0;
    public q7.f r0;
    public ImageView s;
    public String s0;
    public Toolbar t;
    public Context t0;
    public AppBarLayout u;
    public ProgressDialog u0;
    public RelativeLayout v;
    public SharedPreferences v0;
    public ImageView w;
    public LiveStreamDBHandler w0;
    public TextView x;
    public TextView y;
    public TextView z;
    public int z1;
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String r = "";
    public DatabaseUpdatedStatusDBModel x0 = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel y0 = new DatabaseUpdatedStatusDBModel();
    public String z0 = "";
    public String A0 = "";
    public String B0 = "";
    public String C0 = "";
    public String D0 = "";
    public String E0 = "";
    public String F0 = "";
    public int G0 = -1;
    public String H0 = "";
    public String S0 = "";
    public ArrayList V0 = new ArrayList();
    public ArrayList W0 = new ArrayList();
    public String X0 = "";
    public ArrayList a1 = new ArrayList();
    public List d1 = new ArrayList();
    public ArrayList f1 = new ArrayList();
    public ArrayList i1 = new ArrayList();
    public boolean m1 = false;
    public int o1 = 0;
    public String p1 = "";
    public String q1 = "";
    public String r1 = "";
    public int s1 = 0;
    public int t1 = 0;
    public String u1 = "mobile";
    public String v1 = "";
    public String w1 = "";
    public int x1 = 1;
    public int y1 = 0;
    public String D1 = "";
    public String E1 = "";
    public String F1 = "0";
    public ArrayList G1 = new ArrayList();
    public String H1 = "";
    public String I1 = "";
    public ArrayList J1 = new ArrayList();
    public ArrayList K1 = new ArrayList();

    public class a implements com.squareup.picasso.e {
        public a() {
        }

        public void a() {
            SeriesDetailActivity.this.w.setBackgroundResource(a7.e.o1);
        }

        public void onSuccess() {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            SeriesDetailActivity.z1(SeriesDetailActivity.this, view);
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(SeriesDetailActivity.u1(SeriesDetailActivity.this));
            SeriesDetailActivity.this.finishAffinity();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class g implements U.d {
        public final /* synthetic */ ArrayList a;

        public g(ArrayList arrayList) {
            this.a = arrayList;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Context u1;
            String str;
            int I1;
            String str2;
            String F1;
            String str3;
            String G1;
            String str4;
            String str5;
            String str6;
            try {
                ArrayList arrayList = this.a;
                if (arrayList != null && arrayList.size() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= this.a.size()) {
                            break;
                        }
                        if (menuItem.getItemId() != i) {
                            i++;
                        } else if (menuItem.getItemId() == 0) {
                            if (SharepreferenceDBHandler.getCurrentAPPType(SeriesDetailActivity.u1(SeriesDetailActivity.this)).equals("onestream_api")) {
                                u1 = SeriesDetailActivity.u1(SeriesDetailActivity.this);
                                str = "";
                                str2 = "series";
                                F1 = SeriesDetailActivity.F1(SeriesDetailActivity.this);
                                str3 = "0";
                                G1 = SeriesDetailActivity.G1(SeriesDetailActivity.this);
                                SeriesDetailActivity seriesDetailActivity = SeriesDetailActivity.this;
                                str4 = seriesDetailActivity.l1;
                                str5 = SeriesDetailActivity.H1(seriesDetailActivity);
                                str6 = SeriesDetailActivity.this.d;
                                I1 = 0;
                            } else {
                                u1 = SeriesDetailActivity.u1(SeriesDetailActivity.this);
                                str = "";
                                I1 = SeriesDetailActivity.I1(SeriesDetailActivity.this);
                                str2 = "series";
                                F1 = SeriesDetailActivity.F1(SeriesDetailActivity.this);
                                str3 = "0";
                                G1 = SeriesDetailActivity.G1(SeriesDetailActivity.this);
                                SeriesDetailActivity seriesDetailActivity2 = SeriesDetailActivity.this;
                                str4 = seriesDetailActivity2.l1;
                                str5 = "";
                                str6 = seriesDetailActivity2.d;
                            }
                            w.v0(u1, str, I1, str2, F1, str3, G1, (List) null, str4, str5, str6);
                        } else {
                            String G = w.G(w.U(SeriesDetailActivity.u1(SeriesDetailActivity.this), SeriesDetailActivity.I1(SeriesDetailActivity.this), SeriesDetailActivity.F1(SeriesDetailActivity.this), "series"));
                            if (SharepreferenceDBHandler.getCurrentAPPType(SeriesDetailActivity.u1(SeriesDetailActivity.this)).equals("onestream_api")) {
                                Intent intent = new Intent(SeriesDetailActivity.u1(SeriesDetailActivity.this), PlayExternalPlayerActivity.class);
                                intent.putExtra("url", SeriesDetailActivity.this.l1);
                                intent.putExtra("app_name", ((ExternalPlayerModelClass) this.a.get(i)).getAppname());
                                intent.putExtra("packagename", ((ExternalPlayerModelClass) this.a.get(i)).getPackagename());
                                SeriesDetailActivity.u1(SeriesDetailActivity.this).startActivity(intent);
                            } else {
                                Intent intent2 = new Intent(SeriesDetailActivity.u1(SeriesDetailActivity.this), PlayExternalPlayerActivity.class);
                                intent2.putExtra("url", G);
                                intent2.putExtra("app_name", ((ExternalPlayerModelClass) this.a.get(i)).getAppname());
                                intent2.putExtra("packagename", ((ExternalPlayerModelClass) this.a.get(i)).getPackagename());
                                SeriesDetailActivity.u1(SeriesDetailActivity.this).startActivity(intent2);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            SeriesDetailActivity.J1(SeriesDetailActivity.this).dismiss();
        }
    }

    public class j implements NestedScrollView.c {
        public j() {
        }

        public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            if (i2 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
                SeriesDetailActivity.this.x1++;
                Log.e("honey", "onScrollChange page:" + SeriesDetailActivity.this.x1 + " Total:" + SeriesDetailActivity.this.y1);
                SeriesDetailActivity seriesDetailActivity = SeriesDetailActivity.this;
                if (seriesDetailActivity.x1 <= seriesDetailActivity.y1) {
                    w.M0(seriesDetailActivity);
                    try {
                        n7.e O1 = SeriesDetailActivity.O1(SeriesDetailActivity.this);
                        SeriesDetailActivity seriesDetailActivity2 = SeriesDetailActivity.this;
                        O1.j(seriesDetailActivity2.v1, seriesDetailActivity2.w1, SeriesDetailActivity.x1(seriesDetailActivity2), String.valueOf(SeriesDetailActivity.this.x1), SeriesDetailActivity.L1(SeriesDetailActivity.this));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        public void onClick(View view) {
            SeriesDetailActivity.this.o0.setBackgroundResource(a7.e.U);
            SeriesDetailActivity.this.p0.setBackgroundResource(a7.e.R);
            RecyclerView recyclerView = SeriesDetailActivity.this.h0;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            RecyclerView recyclerView2 = SeriesDetailActivity.this.n0;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        public void onClick(View view) {
            SeriesDetailActivity.K1(SeriesDetailActivity.this).dismiss();
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        public void onClick(View view) {
            SeriesDetailActivity.K1(SeriesDetailActivity.this).dismiss();
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        public void onClick(View view) {
            SeriesDetailActivity.K1(SeriesDetailActivity.this).dismiss();
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        public void onClick(View view) {
            SeriesDetailActivity.this.p0.setBackgroundResource(a7.e.U);
            SeriesDetailActivity.this.o0.setBackgroundResource(a7.e.R);
            RecyclerView recyclerView = SeriesDetailActivity.this.n0;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            RecyclerView recyclerView2 = SeriesDetailActivity.this.h0;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        public void onClick(View view) {
            w.j(SeriesDetailActivity.u1(SeriesDetailActivity.this));
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        public void onClick(View view) {
            SeriesDetailActivity.this.onBackPressed();
        }
    }

    public class r implements C {
        public r() {
        }

        public void a(Drawable drawable) {
            Log.d("TAG", "FAILED");
        }

        public void b(Bitmap bitmap, t.e eVar) {
            SeriesDetailActivity.this.u.setBackground(new BitmapDrawable(SeriesDetailActivity.u1(SeriesDetailActivity.this).getResources(), bitmap));
            SeriesDetailActivity seriesDetailActivity = SeriesDetailActivity.this;
            seriesDetailActivity.m0.setBackgroundColor(seriesDetailActivity.getResources().getColor(a7.c.B));
            SeriesDetailActivity seriesDetailActivity2 = SeriesDetailActivity.this;
            seriesDetailActivity2.t.setBackgroundColor(seriesDetailActivity2.getResources().getColor(a7.c.B));
        }

        public void c(Drawable drawable) {
            Log.d("TAG", "Prepare Load");
        }
    }

    public class s implements C {
        public s() {
        }

        public void a(Drawable drawable) {
            Log.d("TAG", "FAILED");
        }

        public void b(Bitmap bitmap, t.e eVar) {
            SeriesDetailActivity.this.u.setBackground(new BitmapDrawable(SeriesDetailActivity.u1(SeriesDetailActivity.this).getResources(), bitmap));
            SeriesDetailActivity seriesDetailActivity = SeriesDetailActivity.this;
            seriesDetailActivity.m0.setBackgroundColor(seriesDetailActivity.getResources().getColor(a7.c.B));
            SeriesDetailActivity seriesDetailActivity2 = SeriesDetailActivity.this;
            seriesDetailActivity2.t.setBackgroundColor(seriesDetailActivity2.getResources().getColor(a7.c.B));
        }

        public void c(Drawable drawable) {
            Log.d("TAG", "Prepare Load");
        }
    }

    public class t implements View.OnClickListener {
        public final /* synthetic */ Context a;

        public t(Context context) {
            this.a = context;
        }

        public void onClick(View view) {
            try {
                if (!SharepreferenceDBHandler.getCurrentAPPType(this.a).equals("stalker_api")) {
                    DatabaseHandler y1 = SeriesDetailActivity.y1(SeriesDetailActivity.this);
                    SeriesDetailActivity seriesDetailActivity = SeriesDetailActivity.this;
                    if (y1.checkFavourite(seriesDetailActivity.q, SeriesDetailActivity.x1(seriesDetailActivity), "series", SharepreferenceDBHandler.getUserID(this.a), SeriesDetailActivity.this.r).size() > 0) {
                        SeriesDetailActivity.N1(SeriesDetailActivity.this);
                    } else {
                        SeriesDetailActivity.M1(SeriesDetailActivity.this);
                    }
                } else if (SeriesDetailActivity.P1(SeriesDetailActivity.this) == 1) {
                    SeriesDetailActivity.v1(SeriesDetailActivity.this);
                } else {
                    SeriesDetailActivity.w1(SeriesDetailActivity.this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class u extends AsyncTask {
        public u() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List doInBackground(String... strArr) {
            try {
                return SeriesDetailActivity.this.h2();
            } catch (Exception e) {
                Log.e("honeya", "doInBackground: " + e.getMessage());
                return null;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List list) {
            TextView textView;
            super.onPostExecute(list);
            if (list != null) {
                try {
                    if (list.get(0) != null && !((String) list.get(0)).equals("") && (textView = SeriesDetailActivity.this.z) != null) {
                        textView.setText((CharSequence) list.get(0));
                    }
                    if (list.get(1) != null && !((String) list.get(1)).equals("") && SeriesDetailActivity.this.i0 != null) {
                        if (((String) list.get(1)).equals("gone")) {
                            SeriesDetailActivity.this.i0.setVisibility(8);
                        }
                        if (((String) list.get(1)).equals("visible")) {
                            SeriesDetailActivity.this.i0.setVisibility(0);
                        }
                    }
                    if (list.get(2) != null && !((String) list.get(2)).equals("") && SeriesDetailActivity.this.i0 != null) {
                        if (!((String) list.get(2)).equals("0")) {
                            SeriesDetailActivity.this.i0.setProgress(w.r0((String) list.get(2)));
                            SeriesDetailActivity.this.i0.setVisibility(0);
                        } else if (SeriesDetailActivity.this.i0.getVisibility() == 0) {
                            SeriesDetailActivity.this.i0.setProgress(w.r0((String) list.get(2)));
                            SeriesDetailActivity.this.i0.setVisibility(8);
                        }
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            if (SeriesDetailActivity.B1(SeriesDetailActivity.this) != null) {
                SeriesDetailActivity.B1(SeriesDetailActivity.this).w();
            } else {
                SeriesDetailActivity seriesDetailActivity = SeriesDetailActivity.this;
                if (seriesDetailActivity.n0 != null) {
                    Context u1 = SeriesDetailActivity.u1(seriesDetailActivity);
                    String D1 = SeriesDetailActivity.D1(SeriesDetailActivity.this);
                    List E1 = SeriesDetailActivity.E1(SeriesDetailActivity.this);
                    SeriesDetailActivity seriesDetailActivity2 = SeriesDetailActivity.this;
                    SeriesDetailActivity.C1(seriesDetailActivity, new q7.n(u1, D1, null, E1, "", seriesDetailActivity2.u1, seriesDetailActivity2.n0));
                    SeriesDetailActivity seriesDetailActivity3 = SeriesDetailActivity.this;
                    seriesDetailActivity3.n0.setAdapter(SeriesDetailActivity.B1(seriesDetailActivity3));
                }
            }
            if (SeriesDetailActivity.A1(SeriesDetailActivity.this) == null || !SeriesDetailActivity.A1(SeriesDetailActivity.this).isShowing()) {
                return;
            }
            SeriesDetailActivity.A1(SeriesDetailActivity.this).dismiss();
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (SeriesDetailActivity.A1(SeriesDetailActivity.this) == null || SeriesDetailActivity.A1(SeriesDetailActivity.this).isShowing()) {
                return;
            }
            SeriesDetailActivity.A1(SeriesDetailActivity.this).show();
        }
    }

    public class v implements View.OnFocusChangeListener {
        public final View a;

        public v(View view) {
            this.a = view;
        }

        public final void a(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public final void b(float f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{f});
            ofFloat.setDuration(150L);
            ofFloat.start();
        }

        public void onFocusChange(View view, boolean z) {
            View view2;
            float f;
            LinearLayout linearLayout;
            int i;
            if (z) {
                f = z ? 1.05f : 1.0f;
                View view3 = this.a;
                if (view3 == null || view3.getTag() == null) {
                    return;
                }
                if (this.a.getTag().equals("1")) {
                    a(f);
                    b(f);
                    linearLayout = SeriesDetailActivity.this.j0;
                } else if (this.a.getTag().equals("2")) {
                    a(f);
                    b(f);
                    linearLayout = SeriesDetailActivity.this.k0;
                } else if (this.a.getTag().equals("3")) {
                    a(f);
                    b(f);
                    linearLayout = this.a;
                } else if (this.a.getTag().equals("5")) {
                    a(f);
                    b(f);
                    linearLayout = SeriesDetailActivity.this.l0;
                } else {
                    View view4 = this.a;
                    if (view4 == null || view4.getTag() == null || !this.a.getTag().equals("8")) {
                        View view5 = this.a;
                        if (view5 == null || view5.getTag() == null || !this.a.getTag().equals("10")) {
                            View view6 = this.a;
                            if (view6 == null || view6.getTag() == null || !this.a.getTag().equals("11")) {
                                View view7 = this.a;
                                float f2 = (view7 == null || view7.getTag() == null || !this.a.getTag().equals("12")) ? 1.15f : 1.2f;
                                a(f2);
                                b(f2);
                                return;
                            }
                            RecyclerView recyclerView = SeriesDetailActivity.this.h0;
                            if (recyclerView == null || recyclerView.getVisibility() != 0) {
                                linearLayout = SeriesDetailActivity.this.p0;
                                i = a7.e.T;
                            } else {
                                linearLayout = SeriesDetailActivity.this.p0;
                                i = a7.e.U;
                            }
                        } else {
                            RecyclerView recyclerView2 = SeriesDetailActivity.this.n0;
                            if (recyclerView2 == null || recyclerView2.getVisibility() != 0) {
                                linearLayout = SeriesDetailActivity.this.o0;
                                i = a7.e.T;
                            } else {
                                linearLayout = SeriesDetailActivity.this.o0;
                                i = a7.e.U;
                            }
                        }
                    } else {
                        a(f);
                        b(f);
                        linearLayout = SeriesDetailActivity.this.R0;
                        i = a7.e.h;
                    }
                }
                i = a7.e.p;
            } else {
                if (z || (view2 = this.a) == null || view2.getTag() == null) {
                    return;
                }
                f = z ? 1.09f : 1.0f;
                a(f);
                b(f);
                if (this.a.getTag().equals("1")) {
                    linearLayout = SeriesDetailActivity.this.j0;
                } else if (this.a.getTag().equals("2")) {
                    linearLayout = SeriesDetailActivity.this.k0;
                } else {
                    if (this.a.getTag().equals("3")) {
                        linearLayout = this.a;
                    } else if (this.a.getTag().equals("5")) {
                        linearLayout = SeriesDetailActivity.this.l0;
                    } else if (this.a.getTag() != null && this.a.getTag().equals("8")) {
                        linearLayout = SeriesDetailActivity.this.R0;
                    } else if (this.a.getTag() != null && this.a.getTag().equals("10")) {
                        RecyclerView recyclerView3 = SeriesDetailActivity.this.n0;
                        if (recyclerView3 == null || recyclerView3.getVisibility() != 0) {
                            linearLayout = SeriesDetailActivity.this.o0;
                            i = a7.e.R;
                        } else {
                            linearLayout = SeriesDetailActivity.this.o0;
                            i = a7.e.S;
                        }
                    } else {
                        if (this.a.getTag() == null || !this.a.getTag().equals("11")) {
                            return;
                        }
                        SeriesDetailActivity.this.p0.setBackgroundResource(a7.e.R);
                        RecyclerView recyclerView4 = SeriesDetailActivity.this.h0;
                        if (recyclerView4 == null || recyclerView4.getVisibility() != 0) {
                            linearLayout = SeriesDetailActivity.this.p0;
                            i = a7.e.R;
                        } else {
                            linearLayout = SeriesDetailActivity.this.p0;
                            i = a7.e.S;
                        }
                    }
                    i = a7.e.o;
                }
                i = a7.e.A1;
            }
            linearLayout.setBackgroundResource(i);
        }
    }

    public static /* synthetic */ ProgressDialog A1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.u0;
    }

    public static /* synthetic */ q7.n B1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.b1;
    }

    public static /* synthetic */ q7.n C1(SeriesDetailActivity seriesDetailActivity, q7.n nVar) {
        seriesDetailActivity.b1 = nVar;
        return nVar;
    }

    public static /* synthetic */ String D1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.j;
    }

    public static /* synthetic */ List E1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.d1;
    }

    public static /* synthetic */ String F1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.p1;
    }

    public static /* synthetic */ String G1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.q1;
    }

    public static /* synthetic */ String H1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.I1;
    }

    public static /* synthetic */ int I1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.o1;
    }

    public static /* synthetic */ PopupWindow J1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.g1;
    }

    public static /* synthetic */ PopupWindow K1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.J0;
    }

    public static /* synthetic */ String L1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.m;
    }

    public static /* synthetic */ void M1(SeriesDetailActivity seriesDetailActivity) {
        seriesDetailActivity.Q1();
    }

    public static /* synthetic */ void N1(SeriesDetailActivity seriesDetailActivity) {
        seriesDetailActivity.Y1();
    }

    public static /* synthetic */ n7.e O1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.B1;
    }

    public static /* synthetic */ int P1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.z1;
    }

    private void S1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private void V1() {
        this.w0 = new LiveStreamDBHandler(this.t0);
        this.B1 = new n7.e(this, this.t0);
        this.C1 = new n7.g(this, this.t0);
        TextView textView = this.y;
        if (textView != null) {
            textView.setSelected(true);
        }
        this.i1.clear();
        this.G1.clear();
        this.V0.clear();
        if (this.u1.equals("mobile")) {
            try {
                this.n1 = o4.b.e(this.t0).c().c();
            } catch (Exception unused) {
            }
        }
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.u0 = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.u0.setMessage(this.t0.getResources().getString(a7.j.t5));
        this.u0.show();
        this.j1 = new SeriesRecentWatchDatabase(this.t0);
        SharedPreferences sharedPreferences = getSharedPreferences("sort_episodes", 0);
        this.Y0 = sharedPreferences;
        this.Z0 = sharedPreferences.edit();
        if (this.Y0.getString("sort", "").equals("")) {
            this.Z0.putString("sort", "0");
            this.Z0.apply();
        }
        RecyclerView recyclerView = this.n0;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.n0.setItemAnimator(new androidx.recyclerview.widget.c());
        }
        this.I0 = new DatabaseHandler(this.t0);
        this.z.requestFocus();
        this.z.setFocusable(true);
        SharedPreferences sharedPreferences2 = getSharedPreferences("loginPrefs", 0);
        this.v0 = sharedPreferences2;
        String string = sharedPreferences2.getString("username", "");
        String string2 = this.v0.getString("password", "");
        if (string == null || string2 == null || string.isEmpty() || string2.isEmpty()) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            g2(this.t0, string, string2);
        }
    }

    public static /* synthetic */ Context u1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.t0;
    }

    public static /* synthetic */ void v1(SeriesDetailActivity seriesDetailActivity) {
        seriesDetailActivity.Z1();
    }

    public static /* synthetic */ void w1(SeriesDetailActivity seriesDetailActivity) {
        seriesDetailActivity.R1();
    }

    public static /* synthetic */ String x1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.l;
    }

    public static /* synthetic */ DatabaseHandler y1(SeriesDetailActivity seriesDetailActivity) {
        return seriesDetailActivity.I0;
    }

    public static /* synthetic */ void z1(SeriesDetailActivity seriesDetailActivity, View view) {
        seriesDetailActivity.X1(view);
    }

    public void C0(TMDBTVShowsInfoCallback tMDBTVShowsInfoCallback) {
    }

    public void D0(String str) {
    }

    public void F(StalkerGetSeriesCategoriesCallback stalkerGetSeriesCategoriesCallback) {
    }

    public void G(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, Z.E e2, int i2) {
        if (stalkerSetLiveFavCallback != null) {
            try {
                if (stalkerSetLiveFavCallback.getJs() == null || !stalkerSetLiveFavCallback.getJs().equals(Boolean.TRUE)) {
                    return;
                }
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.t0);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.t0);
                this.D1 = "add";
                this.B1.f(loggedInMacAddress, stalkerToken, i2);
            } catch (Exception unused) {
                w.X();
            }
        }
    }

    public void G0(StalkerTokenCallback stalkerTokenCallback) {
    }

    public void H(String str) {
    }

    public void H0(TMDBTrailerCallback tMDBTrailerCallback) {
    }

    public void I0(JsonElement jsonElement) {
        JSONArray jSONArray;
        if (jsonElement != null) {
            try {
                JSONObject jSONObject = new JSONObject(jsonElement.toString());
                String string = jSONObject.getString("seasons");
                String string2 = jSONObject.getString("episodes");
                try {
                    if (jSONObject.getJSONObject("info").getJSONArray("backdrop_path") != null) {
                        this.e1 = jSONObject.getJSONObject("info").getJSONArray("backdrop_path");
                    }
                    if (this.u != null && (jSONArray = this.e1) != null && jSONArray.length() > 0) {
                        this.p = this.e1.get(new Random().nextInt(this.e1.length())).toString();
                        Context context = this.t0;
                        if (context != null) {
                            com.squareup.picasso.t.q(context).l(this.p).i(new r());
                        }
                    }
                } catch (Exception unused) {
                }
                if (!string.equals("[]")) {
                    try {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("seasons");
                        int length = jSONArray2.length();
                        this.W0.clear();
                        for (int i2 = 0; i2 < length; i2++) {
                            if (jSONArray2.get(i2) instanceof JSONObject) {
                                b2((JSONObject) jSONArray2.get(i2));
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("seasons");
                        Iterator keys = jSONObject2.keys();
                        this.W0.clear();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            if (jSONObject2.get(str) instanceof JSONObject) {
                                c2(jSONObject2, str);
                            }
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (!string2.equals("[]")) {
                    try {
                        JSONArray jSONArray3 = jSONObject.getJSONArray("episodes");
                        int length2 = jSONArray3.length();
                        this.V0.clear();
                        for (int i3 = 0; i3 < length2; i3++) {
                            if (jSONArray3.get(i3) instanceof JSONArray) {
                                JSONArray jSONArray4 = new JSONArray(jSONArray3.get(i3).toString());
                                T1(jSONArray4, jSONArray4.length());
                            }
                        }
                    } catch (Exception unused4) {
                    }
                    JSONObject jSONObject3 = jSONObject.getJSONObject("episodes");
                    this.V0.clear();
                    Iterator keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        String str2 = (String) keys2.next();
                        if (jSONObject3.get(str2) instanceof JSONArray) {
                            JSONArray jSONArray5 = new JSONArray(jSONObject3.get(str2).toString());
                            T1(jSONArray5, jSONArray5.length());
                        }
                    }
                }
            } catch (Exception unused5) {
            }
        }
        e2();
        this.T0.d(this.e);
    }

    public void M(StalkerGetAdCallback stalkerGetAdCallback, int i2) {
        try {
            w.X();
            String str = this.D1;
            if (str == null || !str.equals("add")) {
                this.z1 = 0;
                Y1();
            } else {
                this.z1 = 1;
                Q1();
            }
        } catch (Exception e2) {
            Log.e("honey", "Exception: " + e2.getMessage());
        }
    }

    public void M0(String str) {
        try {
            w.X();
        } catch (Exception unused) {
        }
    }

    public void O(Z.E e2, int i2) {
        try {
            String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.t0);
            String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.t0);
            this.D1 = "remove";
            this.B1.f(loggedInMacAddress, stalkerToken, i2);
        } catch (Exception unused) {
            w.X();
        }
    }

    public void P(String str) {
    }

    public void P0(String str) {
    }

    public void Q(TMDBCastsCallback tMDBCastsCallback) {
        if (tMDBCastsCallback != null) {
            try {
                if (tMDBCastsCallback.getCast() == null || tMDBCastsCallback.getCast().size() <= 0) {
                    return;
                }
                this.h0.setLayoutManager(new LinearLayoutManager(this, 0, false));
                this.h0.setItemAnimator((RecyclerView.l) null);
                q7.f fVar = new q7.f(tMDBCastsCallback.getCast(), this.t0, true, this.p);
                this.r0 = fVar;
                this.h0.setAdapter(fVar);
            } catch (Exception unused) {
            }
        }
    }

    public final void Q1() {
        try {
            FavouriteDBModel favouriteDBModel = new FavouriteDBModel();
            favouriteDBModel.setCategoryID(this.l);
            favouriteDBModel.setStreamID(this.q);
            favouriteDBModel.setStreamIDOneStream(this.r);
            favouriteDBModel.setName(this.e);
            favouriteDBModel.setNum(this.F0);
            favouriteDBModel.setUserID(SharepreferenceDBHandler.getUserID(this.t0));
            this.I0.addToFavourite(favouriteDBModel, "series");
            if (Build.VERSION.SDK_INT <= 21) {
                this.H.setImageResource(a7.e.V);
            }
            this.H.setImageDrawable(this.t0.getResources().getDrawable(a7.e.V, (Resources.Theme) null));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void R(JsonElement jsonElement) {
        JSONArray jSONArray;
        if (jsonElement != null) {
            try {
                JSONObject jSONObject = new JSONObject(jsonElement.toString());
                String string = jSONObject.getString("seasons");
                String string2 = jSONObject.getString("episodes");
                try {
                    if (jSONObject.getJSONObject("info").getJSONArray("backdrop_path") != null) {
                        this.e1 = jSONObject.getJSONObject("info").getJSONArray("backdrop_path");
                    }
                    if (this.u != null && (jSONArray = this.e1) != null && jSONArray.length() > 0) {
                        String obj = this.e1.get(new Random().nextInt(this.e1.length())).toString();
                        this.p = obj;
                        if (this.t0 != null && !obj.isEmpty()) {
                            com.squareup.picasso.t.q(this.t0).l(this.p).i(new s());
                        }
                    }
                } catch (Exception unused) {
                }
                if (!string.equals("[]")) {
                    try {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("seasons");
                        int length = jSONArray2.length();
                        this.W0.clear();
                        for (int i2 = 0; i2 < length; i2++) {
                            if (jSONArray2.get(i2) instanceof JSONObject) {
                                b2((JSONObject) jSONArray2.get(i2));
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("seasons");
                        Iterator keys = jSONObject2.keys();
                        this.W0.clear();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            if (jSONObject2.get(str) instanceof JSONObject) {
                                c2(jSONObject2, str);
                            }
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (!string2.equals("[]")) {
                    try {
                        JSONArray jSONArray3 = jSONObject.getJSONArray("episodes");
                        int length2 = jSONArray3.length();
                        this.V0.clear();
                        for (int i3 = 0; i3 < length2; i3++) {
                            if (jSONArray3.get(i3) instanceof JSONArray) {
                                JSONArray jSONArray4 = new JSONArray(jSONArray3.get(i3).toString());
                                T1(jSONArray4, jSONArray4.length());
                            }
                        }
                    } catch (Exception unused4) {
                    }
                    JSONObject jSONObject3 = jSONObject.getJSONObject("episodes");
                    this.V0.clear();
                    Iterator keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        String str2 = (String) keys2.next();
                        if (jSONObject3.get(str2) instanceof JSONArray) {
                            JSONArray jSONArray5 = new JSONArray(jSONObject3.get(str2).toString());
                            T1(jSONArray5, jSONArray5.length());
                        }
                    }
                }
            } catch (Exception unused5) {
            }
        }
        this.s0 = SharepreferenceDBHandler.getOneStreamToken(this.t0);
        e2();
        this.T0.d(this.e);
    }

    public final void R1() {
        w.N0(this.t0);
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.t0);
        try {
            this.B1.d(SharepreferenceDBHandler.getLoggedInMacAddress(this.t0), stalkerToken, (Z.E) null, String.valueOf(this.q), 0);
        } catch (Exception unused) {
        }
    }

    public void T0(StalkerDeletePlayerLinkCallback stalkerDeletePlayerLinkCallback) {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(45:4|5|6|(1:196)(1:10)|11|(1:13)(1:195)|14|15|(1:194)(1:19)|(3:20|21|(1:189)(1:23))|24|(1:184)(1:28)|(3:29|30|(1:179)(1:32))|(3:33|34|(1:170)(1:36))|37|(1:165)(1:41)|42|43|(1:45)|(3:46|47|(1:157)(1:51))|(2:52|53)|(27:55|56|57|58|(1:60)|61|62|63|(2:65|(7:67|68|69|70|71|72|73)(1:146))(1:147)|74|75|(19:77|78|79|80|(1:82)|83|84|(15:86|87|88|89|(1:91)|92|93|(11:95|96|97|98|(1:100)|101|102|(7:104|105|106|107|(1:109)|110|111)(1:116)|112|110|111)(1:123)|119|101|102|(0)(0)|112|110|111)(1:130)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111)(1:137)|133|83|84|(0)(0)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111)(1:154)|150|61|62|63|(0)(0)|74|75|(0)(0)|133|83|84|(0)(0)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111) */
    /* JADX WARN: Can't wrap try/catch for region: R(51:3|4|5|6|(1:196)(1:10)|11|(1:13)(1:195)|14|15|(1:194)(1:19)|20|21|(1:189)(1:23)|24|(1:184)(1:28)|(3:29|30|(1:179)(1:32))|(3:33|34|(1:170)(1:36))|37|(1:165)(1:41)|42|43|(1:45)|46|47|(1:157)(1:51)|52|53|(27:55|56|57|58|(1:60)|61|62|63|(2:65|(7:67|68|69|70|71|72|73)(1:146))(1:147)|74|75|(19:77|78|79|80|(1:82)|83|84|(15:86|87|88|89|(1:91)|92|93|(11:95|96|97|98|(1:100)|101|102|(7:104|105|106|107|(1:109)|110|111)(1:116)|112|110|111)(1:123)|119|101|102|(0)(0)|112|110|111)(1:130)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111)(1:137)|133|83|84|(0)(0)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111)(1:154)|150|61|62|63|(0)(0)|74|75|(0)(0)|133|83|84|(0)(0)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111) */
    /* JADX WARN: Can't wrap try/catch for region: R(55:3|4|5|6|(1:196)(1:10)|11|(1:13)(1:195)|14|15|(1:194)(1:19)|20|21|(1:189)(1:23)|24|(1:184)(1:28)|29|30|(1:179)(1:32)|33|34|(1:170)(1:36)|37|(1:165)(1:41)|42|43|(1:45)|46|47|(1:157)(1:51)|52|53|(27:55|56|57|58|(1:60)|61|62|63|(2:65|(7:67|68|69|70|71|72|73)(1:146))(1:147)|74|75|(19:77|78|79|80|(1:82)|83|84|(15:86|87|88|89|(1:91)|92|93|(11:95|96|97|98|(1:100)|101|102|(7:104|105|106|107|(1:109)|110|111)(1:116)|112|110|111)(1:123)|119|101|102|(0)(0)|112|110|111)(1:130)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111)(1:137)|133|83|84|(0)(0)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111)(1:154)|150|61|62|63|(0)(0)|74|75|(0)(0)|133|83|84|(0)(0)|126|92|93|(0)(0)|119|101|102|(0)(0)|112|110|111) */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02c9, code lost:
    
        r17 = r2;
        r2 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0299, code lost:
    
        r19 = r2;
        r2 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x026d, code lost:
    
        r3 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0243, code lost:
    
        r2 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0212, code lost:
    
        r24 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02af A[Catch: Exception -> 0x02c9, TRY_LEAVE, TryCatch #7 {Exception -> 0x02c9, blocks: (B:102:0x02a9, B:104:0x02af), top: B:101:0x02a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x021a A[Catch: Exception -> 0x0222, TRY_LEAVE, TryCatch #17 {Exception -> 0x0222, blocks: (B:73:0x01ff, B:147:0x021a), top: B:72:0x01ff }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e1 A[Catch: Exception -> 0x0212, TryCatch #11 {Exception -> 0x0212, blocks: (B:63:0x01db, B:65:0x01e1, B:67:0x01ef), top: B:62:0x01db }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022b A[Catch: Exception -> 0x0243, TRY_LEAVE, TryCatch #16 {Exception -> 0x0243, blocks: (B:75:0x0225, B:77:0x022b), top: B:74:0x0225 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0255 A[Catch: Exception -> 0x026d, TRY_LEAVE, TryCatch #1 {Exception -> 0x026d, blocks: (B:84:0x024f, B:86:0x0255), top: B:83:0x024f }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x027f A[Catch: Exception -> 0x0299, TRY_LEAVE, TryCatch #14 {Exception -> 0x0299, blocks: (B:93:0x0279, B:95:0x027f), top: B:92:0x0279 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void T1(org.json.JSONArray r27, int r28) {
        /*
            Method dump skipped, instructions count: 779
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesDetailActivity.T1(org.json.JSONArray, int):void");
    }

    public void U(StalkerLiveFavIdsCallback stalkerLiveFavIdsCallback) {
    }

    public void U1() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public void V(StalkerProfilesCallback stalkerProfilesCallback) {
    }

    public final void W1(SeriesDetailActivity seriesDetailActivity) {
        View inflate = ((LayoutInflater) seriesDetailActivity.getSystemService("layout_inflater")).inflate(a7.g.l3, seriesDetailActivity.findViewById(a7.f.We));
        PopupWindow popupWindow = new PopupWindow(seriesDetailActivity);
        this.J0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.J0.setWidth(-1);
        this.J0.setHeight(-1);
        this.J0.setFocusable(true);
        this.J0.setBackgroundDrawable(new BitmapDrawable());
        this.J0.showAtLocation(inflate, 17, 0, 0);
        this.R0 = inflate.findViewById(a7.f.H0);
        TextView findViewById = inflate.findViewById(a7.f.j3);
        this.K0 = inflate.findViewById(a7.f.o0);
        findViewById.setText("Series trailer is not available");
        Button button = this.R0;
        if (button != null) {
            button.setOnFocusChangeListener(new v(button));
        }
        Button button2 = this.K0;
        if (button2 != null) {
            button2.setOnFocusChangeListener(new v(button2));
        }
        this.K0.setOnClickListener(new m());
        this.R0.setOnClickListener(new n());
    }

    public void X(StalkerShortEPGCallback stalkerShortEPGCallback) {
    }

    public final void X1(View view) {
        if (SharepreferenceDBHandler.getCurrentAPPType(this.t0).equals("stalker_api")) {
            w.v0(this.t0, "", this.o1, "series", this.p1, "0", this.q1, (List) null, this.E1, "", this.d);
            return;
        }
        if (this.u1.equals("mobile")) {
            try {
                this.n1 = o4.b.e(this.t0).c().c();
            } catch (Exception unused) {
            }
        }
        try {
            o4.e eVar = this.n1;
            if (eVar != null && eVar.c()) {
                String str = this.t0.getResources().getString(a7.j.J6) + " - " + this.s1;
                String G = w.G(w.U(this.t0, this.o1, this.p1, "series"));
                String str2 = "";
                o4.e eVar2 = this.n1;
                if (eVar2 != null && eVar2.r() != null && this.n1.r().j() != null && this.n1.r().j().J() != null) {
                    str2 = this.n1.r().j().J();
                }
                if (str2.equals(G)) {
                    this.t0.startActivity(new Intent(this.t0, ExpandedControlsActivity.class));
                    return;
                } else {
                    i7.a.c(this.t1, true, i7.a.a(this.q1, str, "", 0, G, "videos/mp4", this.r1, "", (List) null), this.n1, this.t0);
                    return;
                }
            }
            new ArrayList();
            ArrayList arrayList = new ArrayList();
            k.U u2 = new k.U(this, view);
            u2.c().inflate(a7.h.m, u2.b());
            ArrayList externalPlayer = new ExternalPlayerDataBase(this.t0).getExternalPlayer();
            if (externalPlayer == null || externalPlayer.size() <= 0) {
                if (SharepreferenceDBHandler.getCurrentAPPType(this.t0).equals("onestream_api")) {
                    w.v0(this.t0, "", 0, "series", this.p1, "0", this.q1, (List) null, this.H1, this.I1, this.d);
                    return;
                } else {
                    w.v0(this.t0, "", this.o1, "series", this.p1, "0", this.q1, (List) null, this.E1, "", this.d);
                    return;
                }
            }
            u2.b().add(0, 0, 0, this.t0.getResources().getString(a7.j.V3));
            ExternalPlayerModelClass externalPlayerModelClass = new ExternalPlayerModelClass();
            externalPlayerModelClass.setId(0);
            externalPlayerModelClass.setAppname(this.t0.getResources().getString(a7.j.h5));
            arrayList.add(externalPlayerModelClass);
            int i2 = 0;
            while (i2 < externalPlayer.size()) {
                int i3 = i2 + 1;
                u2.b().add(0, i3, 0, this.t0.getResources().getString(a7.j.h5) + " " + ((ExternalPlayerModelClass) externalPlayer.get(i2)).getAppname());
                arrayList.add((ExternalPlayerModelClass) externalPlayer.get(i2));
                i2 = i3;
            }
            u2.f(new g(arrayList));
            u2.e(new h());
            u2.g();
        } catch (Exception unused2) {
        }
    }

    public final void Y1() {
        DatabaseHandler databaseHandler;
        int i2;
        String str;
        String str2;
        String str3;
        int userID;
        String str4;
        try {
            if (SharepreferenceDBHandler.getCurrentAPPType(this.t0).equals("onestream_api")) {
                databaseHandler = this.I0;
                i2 = this.q;
                str = this.l;
                str2 = "series";
                str3 = this.e;
                userID = SharepreferenceDBHandler.getUserID(this.t0);
                str4 = this.r;
            } else {
                databaseHandler = this.I0;
                i2 = this.q;
                str = this.l;
                str2 = "series";
                str3 = this.e;
                userID = SharepreferenceDBHandler.getUserID(this.t0);
                str4 = "";
            }
            databaseHandler.deleteFavourite(i2, str, str2, str3, userID, str4);
            if (Build.VERSION.SDK_INT <= 21) {
                this.H.setImageResource(a7.e.W);
            }
            this.H.setImageDrawable(this.t0.getResources().getDrawable(a7.e.W, (Resources.Theme) null));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void Z1() {
        w.N0(this.t0);
        String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.t0);
        try {
            this.B1.r(SharepreferenceDBHandler.getLoggedInMacAddress(this.t0), stalkerToken, (Z.E) null, String.valueOf(this.q), 0);
        } catch (Exception unused) {
        }
    }

    public void a() {
    }

    public void a0(String str) {
    }

    public void a2() {
        new u().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public void b() {
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Can't find top splitter block for handler:B:48:0x00fc
        	at ILlL1lil1i1i.LLll11I1I1lL.llLliLLIll1lI(Unknown Source:36)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(Unknown Source:67)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(Unknown Source:9)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:40)
        */
    public final void b2(org.json.JSONObject r12) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesDetailActivity.b2(org.json.JSONObject):void");
    }

    public void c(String str) {
    }

    /*  JADX ERROR: IIiLliI1l1li1 in pass: RegionMakerVisitor
        LL1ili1iI1iI.IIiLliI1l1li1: Can't find top splitter block for handler:B:48:0x0192
        	at ILlL1lil1i1i.LLll11I1I1lL.llLliLLIll1lI(Unknown Source:36)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(Unknown Source:67)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(Unknown Source:9)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(Unknown Source:40)
        */
    public final void c2(org.json.JSONObject r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesDetailActivity.c2(org.json.JSONObject, java.lang.String):void");
    }

    public void d(String str) {
        try {
            ProgressDialog progressDialog = this.u0;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.u0.dismiss();
            Toast.makeText(this, this.t0.getResources().getString(a7.j.e7), 1).show();
        } catch (Exception unused) {
        }
    }

    public final void d2(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.u1.equals("mobile") ? a7.g.r4 : a7.g.s4, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(context);
        this.g1 = popupWindow;
        popupWindow.setContentView(inflate);
        this.g1.setWidth(-1);
        this.g1.setHeight(-1);
        this.g1.setFocusable(true);
        this.g1.showAtLocation(inflate, 0, 0, 0);
        this.h1 = inflate.findViewById(a7.f.Wf);
        NestedScrollView findViewById = inflate.findViewById(a7.f.n4);
        TextView findViewById2 = inflate.findViewById(a7.f.ki);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new i());
        }
        try {
            RecyclerView recyclerView = this.h1;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(this, 4, 1, false));
                this.h1.setItemAnimator(new androidx.recyclerview.widget.c());
                ArrayList arrayList = this.i1;
                if (arrayList != null && arrayList.size() > 0) {
                    q7.U u2 = new q7.U(context, this.i1, this.g1, this.k1, 0);
                    this.c1 = u2;
                    this.h1.setAdapter(u2);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    findViewById.setOnScrollChangeListener(new j());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void e(String str) {
    }

    public void e0(String str) {
        ProgressDialog progressDialog = this.u0;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.u0.dismiss();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0325 A[Catch: Exception -> 0x0474, TryCatch #10 {Exception -> 0x0474, blocks: (B:3:0x0002, B:5:0x000b, B:7:0x000f, B:9:0x0015, B:11:0x004c, B:14:0x0065, B:17:0x00c8, B:18:0x00d1, B:21:0x00df, B:23:0x00fb, B:25:0x0111, B:26:0x0132, B:28:0x0136, B:31:0x018f, B:33:0x019b, B:34:0x01b7, B:37:0x01f3, B:51:0x0249, B:54:0x0254, B:56:0x025c, B:53:0x0266, B:73:0x026b, B:75:0x0273, B:77:0x028b, B:78:0x0294, B:80:0x029a, B:84:0x02b6, B:96:0x0305, B:82:0x0309, B:97:0x030c, B:110:0x0311, B:112:0x0325, B:114:0x0347, B:117:0x034b, B:119:0x034f, B:121:0x0353, B:123:0x0359, B:125:0x0389, B:127:0x038d, B:131:0x03a5, B:133:0x03b1, B:134:0x03cd, B:137:0x041b, B:139:0x0428, B:141:0x042e, B:142:0x0437, B:148:0x0462, B:152:0x006d, B:154:0x0071, B:155:0x0092, B:157:0x0096, B:158:0x00c0, B:160:0x00c4, B:162:0x0055, B:163:0x0465, B:165:0x0469, B:167:0x046f), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0347 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e2() {
        /*
            Method dump skipped, instructions count: 1141
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesDetailActivity.e2():void");
    }

    public void f0(StalkerGetGenresCallback stalkerGetGenresCallback) {
    }

    public final void f2(SeriesDetailActivity seriesDetailActivity) {
        View inflate = ((LayoutInflater) seriesDetailActivity.getSystemService("layout_inflater")).inflate(a7.g.g3, seriesDetailActivity.findViewById(a7.f.We));
        this.N0 = inflate.findViewById(a7.f.Wh);
        TextView findViewById = inflate.findViewById(a7.f.Ik);
        this.O0 = findViewById;
        findViewById.setText(getResources().getString(a7.j.w5));
        this.N0.setText(this.L0);
        PopupWindow popupWindow = new PopupWindow(seriesDetailActivity);
        this.J0 = popupWindow;
        popupWindow.setContentView(inflate);
        this.J0.setWidth(-1);
        this.J0.setHeight(-1);
        this.J0.setFocusable(true);
        this.J0.showAtLocation(inflate, 17, 0, 0);
        Button findViewById2 = inflate.findViewById(a7.f.o0);
        this.K0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnFocusChangeListener(new v(findViewById2));
        }
        this.K0.setOnClickListener(new l());
    }

    public final void g2(Context context, String str, String str2) {
        ImageView imageView;
        Drawable drawable;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ImageView imageView2;
        Resources resources;
        int i2;
        TextView textView;
        String str8;
        String str9;
        this.T0 = new n7.i(this, context);
        this.U0 = new n7.j(context, this);
        this.O.setVisibility(0);
        this.N.setVisibility(0);
        Intent intent = getIntent();
        if (intent != null) {
            this.e = intent.getStringExtra("series_name");
            this.f = intent.getStringExtra("series_plot");
            this.g = intent.getStringExtra("series_rating");
            this.h = intent.getStringExtra("series_director");
            this.j = intent.getStringExtra("series_cover");
            this.k = intent.getStringExtra("series_releaseDate");
            this.i = intent.getStringExtra("series_genre");
            this.F0 = intent.getStringExtra("series_num");
            this.l = intent.getStringExtra("series_categoryId");
            this.m = intent.getStringExtra("series_seriesID");
            this.n = intent.getStringExtra("series_youtube_trailer");
            this.z1 = intent.getIntExtra("series_fav", 0);
            this.A1 = intent.getStringExtra("series_cmd");
            try {
                this.q = w.r0(this.m);
            } catch (NumberFormatException unused) {
                this.q = -1;
            }
            this.r = this.m;
            this.L0 = this.f;
            this.M0 = this.i;
            ImageView imageView3 = this.H;
            if (imageView3 != null) {
                imageView3.setOnFocusChangeListener(new v(imageView3));
                this.H.setOnClickListener(new t(context));
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("stalker_api")) {
                try {
                    TextView textView2 = this.p0;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    this.w1 = SharepreferenceDBHandler.getStalkerToken(context);
                    String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(context);
                    this.v1 = loggedInMacAddress;
                    this.B1.j(loggedInMacAddress, this.w1, this.l, String.valueOf(this.x1), this.m);
                } catch (Exception e2) {
                    Log.e("honey", "startViewingDetails: " + e2.getMessage());
                }
            } else if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("onestream_api")) {
                this.U0.c(this.m, this.s0);
            } else {
                this.U0.b(str, str2, this.m);
            }
            if (context == null || (str9 = this.j) == null || str9.isEmpty()) {
                this.w.setBackgroundResource(a7.e.o1);
            } else {
                com.squareup.picasso.t.q(context).l(this.j).j(a7.e.B1).h(this.w, new a());
            }
            ImageView imageView4 = this.w;
            if (imageView4 != null) {
                imageView4.setOnClickListener(new b());
            }
            if (this.f0 != null && (str8 = this.n) != null && str8.isEmpty() && this.n.equals("")) {
                this.f0.setVisibility(8);
                LinearLayout linearLayout = this.e0;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                TextView textView3 = this.z;
                if (textView3 != null) {
                    textView3.requestFocus();
                }
            }
            if (this.B0 != null && (textView = this.y) != null) {
                textView.setText(this.e);
            }
            if (SharepreferenceDBHandler.getCurrentAPPType(context).equals("stalker_api")) {
                try {
                    if (this.z1 == 1) {
                        if (Build.VERSION.SDK_INT <= 21) {
                            this.H.setImageResource(a7.e.V);
                        }
                        imageView = this.H;
                        drawable = context.getResources().getDrawable(a7.e.V, (Resources.Theme) null);
                    } else {
                        if (Build.VERSION.SDK_INT <= 21) {
                            this.H.setImageResource(a7.e.W);
                        }
                        imageView = this.H;
                        drawable = context.getResources().getDrawable(a7.e.W, (Resources.Theme) null);
                    }
                    imageView.setImageDrawable(drawable);
                } catch (Exception unused2) {
                }
            } else {
                if (this.I0.checkFavourite(this.q, this.l, "series", SharepreferenceDBHandler.getUserID(context), this.r).size() > 0) {
                    if (Build.VERSION.SDK_INT <= 21) {
                        this.H.setImageResource(a7.e.V);
                    }
                    imageView2 = this.H;
                    resources = context.getResources();
                    i2 = a7.e.V;
                } else {
                    if (Build.VERSION.SDK_INT <= 21) {
                        this.H.setImageResource(a7.e.W);
                    }
                    imageView2 = this.H;
                    resources = context.getResources();
                    i2 = a7.e.W;
                }
                imageView2.setImageDrawable(resources.getDrawable(i2, (Resources.Theme) null));
            }
            if (this.Q == null || this.V == null || this.F == null || (str7 = this.k) == null || str7.isEmpty() || this.k.equals("n/A")) {
                LinearLayout linearLayout2 = this.Q;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                LinearLayout linearLayout3 = this.V;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                TextView textView4 = this.F;
                if (textView4 != null) {
                    textView4.setText("N/A");
                }
            } else {
                this.Q.setVisibility(0);
                this.V.setVisibility(0);
                this.F.setText(this.k);
            }
            if (this.B == null || this.U == null || this.P == null || (str6 = this.h) == null || str6.isEmpty() || this.h.equals("n/A")) {
                LinearLayout linearLayout4 = this.P;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                LinearLayout linearLayout5 = this.U;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                }
                TextView textView5 = this.B;
                if (textView5 != null) {
                    textView5.setText("N/A");
                }
            } else {
                this.P.setVisibility(0);
                this.U.setVisibility(0);
                this.B.setText(this.h);
            }
            if (this.T == null || this.Y == null || this.D == null || (str5 = this.f) == null || str5.isEmpty()) {
                LinearLayout linearLayout6 = this.T;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
                LinearLayout linearLayout7 = this.Y;
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(0);
                }
                TextView textView6 = this.Z;
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
                TextView textView7 = this.D;
                if (textView7 != null) {
                    textView7.setText("N/A");
                }
            } else {
                this.T.setVisibility(0);
                this.Y.setVisibility(0);
                if (this.f.length() > 150) {
                    this.D.setText(this.f);
                    this.Z.setVisibility(0);
                } else {
                    this.D.setText(this.f);
                    this.Z.setVisibility(8);
                }
            }
            if (this.G != null && (str4 = this.g) != null && !str4.isEmpty() && !this.g.equals("n/A")) {
                this.G.setVisibility(0);
                try {
                    this.G.setRating(Float.parseFloat(this.g) / 2.0f);
                } catch (NumberFormatException unused3) {
                    this.G.setRating(0.0f);
                }
            }
            if (this.S != null && this.X != null && this.J != null && (str3 = this.i) != null && !str3.isEmpty()) {
                this.S.setVisibility(0);
                this.X.setVisibility(0);
                this.i.length();
                this.J.setText(this.i);
                return;
            }
            LinearLayout linearLayout8 = this.S;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(0);
            }
            LinearLayout linearLayout9 = this.X;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(0);
            }
            TextView textView8 = this.J;
            if (textView8 != null) {
                textView8.setText("N/A");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:66|67|68|69|(4:71|72|(2:88|89)(1:74)|75)|76|77|78|79) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0285, code lost:
    
        r6 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List h2() {
        /*
            Method dump skipped, instructions count: 868
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesDetailActivity.h2():java.util.List");
    }

    public void i(StalkerGetAllChannelsCallback stalkerGetAllChannelsCallback) {
    }

    public void i2(int i2) {
        boolean z;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i3;
        int i4;
        int i5;
        int i6;
        String durationSec;
        int i7;
        int i8;
        int i9;
        GetEpisdoeDetailsCallback getEpisdoeDetailsCallback;
        this.k1 = i2;
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(getResources().getString(a7.j.J6) + " - " + i2);
        }
        ArrayList arrayList3 = this.f1;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        ArrayList recentWatchedBySeriesID = this.j1.getRecentWatchedBySeriesID(this.m);
        if (recentWatchedBySeriesID == null || recentWatchedBySeriesID.size() <= 0) {
            TextView textView2 = this.z;
            if (textView2 != null) {
                textView2.setText(getResources().getString(a7.j.a7) + " - S" + i2 + ":E1");
                this.F1 = "1";
            }
            ProgressBar progressBar = this.i0;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            z = false;
        } else {
            z = true;
        }
        if (this.a1 != null) {
            ArrayList allSeriesRecentWatch = this.j1.getAllSeriesRecentWatch("getalldata");
            for (int i10 = 0; i10 < this.a1.size(); i10++) {
                if (z && ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getId().equals(((GetEpisdoeDetailsCallback) recentWatchedBySeriesID.get(0)).getId())) {
                    TextView textView3 = this.z;
                    if (textView3 != null) {
                        textView3.setText(getResources().getString(a7.j.c7) + " - S" + ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getSeasonNumber() + ":E" + ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getEpisodeNumber());
                        this.F1 = ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getEpisodeNumber().toString();
                        try {
                            this.o1 = w.r0(((GetEpisdoeDetailsCallback) this.a1.get(i10)).getId());
                        } catch (Exception unused) {
                        }
                        if (SharepreferenceDBHandler.getCurrentAPPType(this.t0).equals("onestream_api")) {
                            this.I1 = ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getId();
                            this.H1 = ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getLinks();
                        }
                        this.d = ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getTmdb_id();
                        this.p1 = ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getContainerExtension();
                        this.q1 = ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getTitle();
                        this.r1 = ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getMovieImage();
                        this.s1 = ((GetEpisdoeDetailsCallback) this.a1.get(i10)).getSeasonNumber().intValue();
                    }
                    if (this.i0 != null) {
                        try {
                            int r0 = w.r0(((GetEpisdoeDetailsCallback) recentWatchedBySeriesID.get(0)).getElapsed_time());
                            i8 = Math.round(r0 / 1000.0f);
                            try {
                                this.t1 = r0;
                                i7 = w.r0(((GetEpisdoeDetailsCallback) this.a1.get(i10)).getDurationSec());
                                if (i7 == 0) {
                                    try {
                                        getEpisdoeDetailsCallback = (GetEpisdoeDetailsCallback) recentWatchedBySeriesID.get(0);
                                    } catch (Exception unused2) {
                                    }
                                } else {
                                    getEpisdoeDetailsCallback = (GetEpisdoeDetailsCallback) this.a1.get(i10);
                                }
                                i7 = w.r0(getEpisdoeDetailsCallback.getDurationSec());
                            } catch (Exception unused3) {
                                i7 = 0;
                            }
                        } catch (Exception unused4) {
                            i7 = 0;
                            i8 = 0;
                        }
                        try {
                            i9 = Math.round((i8 / i7) * 100.0f);
                        } catch (Exception unused5) {
                            i9 = 0;
                        }
                        ProgressBar progressBar2 = this.i0;
                        if (i9 != 0) {
                            progressBar2.setProgress(i9);
                            this.i0.setVisibility(0);
                        } else if (progressBar2.getVisibility() == 0) {
                            this.i0.setProgress(i9);
                            this.i0.setVisibility(8);
                        }
                    }
                }
                if (((GetEpisdoeDetailsCallback) this.a1.get(i10)).getSeasonNumber().equals(Integer.valueOf(i2))) {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback2 = (GetEpisdoeDetailsCallback) this.a1.get(i10);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= allSeriesRecentWatch.size()) {
                            break;
                        }
                        if (((GetEpisdoeDetailsCallback) this.a1.get(i10)).getId().equals(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i11)).getId())) {
                            getEpisdoeDetailsCallback2.setElapsed_time(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i11)).getElapsed_time());
                            try {
                                i3 = Math.round(w.r0(((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i11)).getElapsed_time()) / 1000.0f);
                            } catch (Exception unused6) {
                                i3 = 0;
                            }
                            try {
                                i4 = w.r0(getEpisdoeDetailsCallback2.getDurationSec());
                                if (i4 == 0) {
                                    try {
                                        durationSec = ((GetEpisdoeDetailsCallback) allSeriesRecentWatch.get(i11)).getDurationSec();
                                    } catch (Exception unused7) {
                                        i5 = i4;
                                        i6 = Math.round((i3 / i5) * 100.0f);
                                        getEpisdoeDetailsCallback2.setEpisode_watched_percentage(i6);
                                        this.f1.add(getEpisdoeDetailsCallback2);
                                    }
                                } else {
                                    durationSec = getEpisdoeDetailsCallback2.getDurationSec();
                                }
                                i5 = w.r0(durationSec);
                            } catch (Exception unused8) {
                                i4 = 0;
                                i5 = i4;
                                i6 = Math.round((i3 / i5) * 100.0f);
                                getEpisdoeDetailsCallback2.setEpisode_watched_percentage(i6);
                                this.f1.add(getEpisdoeDetailsCallback2);
                            }
                            try {
                                i6 = Math.round((i3 / i5) * 100.0f);
                            } catch (Exception unused9) {
                                i6 = 0;
                            }
                            getEpisdoeDetailsCallback2.setEpisode_watched_percentage(i6);
                        } else {
                            i11++;
                        }
                    }
                    this.f1.add(getEpisdoeDetailsCallback2);
                }
            }
            if (this.o0 != null && (arrayList2 = this.f1) != null && arrayList2.size() > 0) {
                this.o0.setText(getResources().getString(a7.j.G1) + " (" + this.f1.size() + ")");
            }
            if (!z && (arrayList = this.f1) != null && arrayList.size() > 0) {
                try {
                    this.o1 = w.r0(((GetEpisdoeDetailsCallback) this.f1.get(0)).getId());
                } catch (Exception unused10) {
                }
                if (SharepreferenceDBHandler.getCurrentAPPType(this.t0).equals("onestream_api")) {
                    this.I1 = ((GetEpisdoeDetailsCallback) this.f1.get(0)).getId();
                    this.H1 = ((GetEpisdoeDetailsCallback) this.f1.get(0)).getLinks();
                }
                this.d = ((GetEpisdoeDetailsCallback) this.a1.get(0)).getTmdb_id();
                this.p1 = ((GetEpisdoeDetailsCallback) this.f1.get(0)).getContainerExtension();
                this.q1 = ((GetEpisdoeDetailsCallback) this.f1.get(0)).getTitle();
                this.t1 = w.r0(((GetEpisdoeDetailsCallback) this.f1.get(0)).getElapsed_time());
                this.r1 = ((GetEpisdoeDetailsCallback) this.f1.get(0)).getMovieImage();
                this.s1 = ((GetEpisdoeDetailsCallback) this.f1.get(0)).getSeasonNumber().intValue();
            }
            EpisodesUsingSinglton.getInstance().setEpisodeList(this.a1);
            EpisodesUsingSinglton.getInstance().setCurrentSeasonEpisodeList(this.f1);
            q7.n nVar = this.b1;
            if (nVar != null) {
                nVar.w();
            } else {
                q7.n nVar2 = new q7.n(this.t0, this.j, null, this.d1, "", this.u1, this.n0);
                this.b1 = nVar2;
                this.n0.setAdapter(nVar2);
            }
        }
        TextView textView4 = this.o0;
        if (textView4 != null) {
            textView4.setBackgroundResource(a7.e.U);
        }
        TextView textView5 = this.p0;
        if (textView5 != null) {
            textView5.setBackgroundResource(a7.e.R);
        }
        RecyclerView recyclerView = this.h0;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        RecyclerView recyclerView2 = this.n0;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
    }

    public void j(StalkerGetVodCategoriesCallback stalkerGetVodCategoriesCallback) {
    }

    public void o0(String str) {
        try {
            w.X();
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        PopupWindow popupWindow = this.g1;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.g1.dismiss();
            return;
        }
        q7.n nVar = this.b1;
        if (nVar != null) {
            nVar.b1();
        }
        m7.a.m0 = true;
        m7.a.n0 = this.z1;
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        Intent putExtra;
        int i2;
        int id = view.getId();
        if (id == a7.f.Bj) {
            putExtra = new Intent(this, NewDashboardActivity.class);
        } else {
            if (id == a7.f.Pk) {
                if (!SharepreferenceDBHandler.getCurrentAPPType(this.t0).equals("stalker_api")) {
                    X1(view);
                    return;
                }
                w.N0(this.t0);
                String stalkerToken = SharepreferenceDBHandler.getStalkerToken(this.t0);
                String loggedInMacAddress = SharepreferenceDBHandler.getLoggedInMacAddress(this.t0);
                ArrayList arrayList = this.i1;
                if (arrayList == null || arrayList.size() <= 0) {
                    i2 = -1;
                } else {
                    i2 = 0;
                    while (i2 < this.i1.size()) {
                        if (((Integer) this.i1.get(i2)).equals(Integer.valueOf(this.k1))) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    i2 = -1;
                }
                ArrayList arrayList2 = this.G1;
                if (arrayList2 != null && arrayList2.size() > 0 && i2 != -1) {
                    try {
                        this.A1 = (String) this.G1.get(i2);
                    } catch (Exception unused) {
                    }
                }
                try {
                    this.C1.c(loggedInMacAddress, stalkerToken, this.A1, this.F1, view, "vod", 0, 0, "", "", "", "", "", "", 0, "", "");
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (id == a7.f.xl) {
                d2(this.t0);
                return;
            }
            if (id == a7.f.kl) {
                f2(this);
                return;
            }
            if (id != a7.f.qm) {
                return;
            }
            String str = this.n;
            if (str == null || str.isEmpty()) {
                W1(this);
                return;
            }
            putExtra = new Intent(this, YouTubePlayerActivity.class).putExtra("you_tube_trailer", this.n);
        }
        startActivity(putExtra);
    }

    public void onCreate(Bundle bundle) {
        int i2;
        this.t0 = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        U1();
        if (new u7.a(this.t0).A().equals(m7.a.K0)) {
            this.u1 = "tv";
            i2 = a7.g.P0;
        } else {
            this.u1 = "mobile";
            i2 = a7.g.N0;
        }
        setContentView(i2);
        this.t = findViewById(a7.f.kh);
        this.u = findViewById(a7.f.W);
        this.v = findViewById(a7.f.Nd);
        this.w = findViewById(a7.f.B5);
        this.x = findViewById(a7.f.xl);
        this.y = findViewById(a7.f.lk);
        this.z = findViewById(a7.f.Pk);
        this.A = findViewById(a7.f.Hi);
        this.B = findViewById(a7.f.Ii);
        this.C = findViewById(a7.f.Rh);
        this.D = findViewById(a7.f.Th);
        this.E = findViewById(a7.f.tl);
        this.F = findViewById(a7.f.ul);
        this.G = findViewById(a7.f.bd);
        this.H = findViewById(a7.f.g5);
        this.I = findViewById(a7.f.ik);
        this.J = findViewById(a7.f.zj);
        this.K = findViewById(a7.f.gk);
        this.L = findViewById(a7.f.hk);
        this.M = findViewById(a7.f.R8);
        this.N = findViewById(a7.f.Tf);
        this.O = findViewById(a7.f.Nb);
        this.P = findViewById(a7.f.I7);
        this.Q = findViewById(a7.f.H9);
        this.R = findViewById(a7.f.S7);
        this.S = findViewById(a7.f.r8);
        this.T = findViewById(a7.f.p7);
        this.U = findViewById(a7.f.J7);
        this.V = findViewById(a7.f.I9);
        this.W = findViewById(a7.f.T7);
        this.X = findViewById(a7.f.s8);
        this.Y = findViewById(a7.f.q7);
        this.Z = findViewById(a7.f.kl);
        this.e0 = findViewById(a7.f.Ga);
        this.f0 = findViewById(a7.f.qm);
        this.g0 = findViewById(a7.f.Xa);
        this.h0 = findViewById(a7.f.Df);
        this.i0 = findViewById(a7.f.Zb);
        this.j0 = findViewById(a7.f.p9);
        this.k0 = findViewById(a7.f.Q9);
        this.l0 = findViewById(a7.f.Ha);
        this.m0 = findViewById(a7.f.vf);
        this.n0 = findViewById(a7.f.ub);
        this.o0 = findViewById(a7.f.W2);
        this.p0 = findViewById(a7.f.L1);
        this.q0 = findViewById(a7.f.F4);
        overridePendingTransition(a7.b.f, a7.b.d);
        this.s0 = SharepreferenceDBHandler.getOneStreamToken(this.t0);
        this.z.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        AppBarLayout appBarLayout = this.u;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.H));
        }
        TextView textView = this.z;
        if (textView != null) {
            textView.setOnFocusChangeListener(new v(textView));
        }
        TextView textView2 = this.x;
        if (textView2 != null) {
            textView2.setOnFocusChangeListener(new v(textView2));
        }
        TextView textView3 = this.Z;
        if (textView3 != null) {
            textView3.setOnFocusChangeListener(new v(textView3));
        }
        TextView textView4 = this.f0;
        if (textView4 != null) {
            textView4.setOnFocusChangeListener(new v(textView4));
        }
        this.m1 = true;
        this.a1.clear();
        TextView textView5 = this.o0;
        if (textView5 != null) {
            textView5.setOnClickListener(new k());
            TextView textView6 = this.o0;
            textView6.setOnFocusChangeListener(new v(textView6));
        }
        TextView textView7 = this.p0;
        if (textView7 != null) {
            textView7.setOnFocusChangeListener(new v(textView7));
            this.p0.setOnClickListener(new o());
        }
        getWindow().setFlags(1024, 1024);
        r1(findViewById(a7.f.kh));
        S1();
        V1();
        this.g0.setOnClickListener(new p());
        this.q0.setOnClickListener(new q());
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.t.x(a7.h.v);
        this.Q0 = menu;
        this.P0 = menu.getItem(1).getSubMenu().findItem(a7.f.P2);
        if (SharepreferenceDBHandler.getCurrentAPPType(this.t0).equals("api")) {
            menu.getItem(1).getSubMenu().findItem(a7.f.fb).setVisible(false);
        }
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.t.getChildCount(); i2++) {
            if (this.t.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.t.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public void onDestroy() {
        p4.i r2;
        super.onDestroy();
        try {
            q7.n nVar = this.b1;
            if (nVar != null) {
                nVar.b1();
            }
            o4.e eVar = this.n1;
            if (eVar == null || this.b1 == null || (r2 = eVar.r()) == null) {
                return;
            }
            r2.X(this.b1.R);
        } catch (Exception unused) {
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 20) {
            if (i2 != 19) {
                return super.onKeyDown(i2, keyEvent);
            }
            View currentFocus = getCurrentFocus();
            if ((currentFocus != null && currentFocus.getTag() != null && currentFocus.getTag().equals("11")) || (currentFocus != null && currentFocus.getTag() != null && currentFocus.getTag().equals("10"))) {
                this.N.setVisibility(0);
            }
            return false;
        }
        View currentFocus2 = getCurrentFocus();
        if ((currentFocus2 != null && currentFocus2.getTag() != null && currentFocus2.getTag().equals("11")) || (currentFocus2 != null && currentFocus2.getTag() != null && currentFocus2.getTag().equals("10"))) {
            this.N.setVisibility(8);
            RecyclerView recyclerView = this.n0;
            if (recyclerView != null && recyclerView.getVisibility() == 0) {
                m7.a.p0 = true;
                m7.a.o0 = 0;
                q7.n nVar = this.b1;
                if (nVar != null) {
                    nVar.w();
                }
            }
            RecyclerView recyclerView2 = this.h0;
            if (recyclerView2 != null && recyclerView2.getVisibility() == 0) {
                this.h0.requestFocus();
            }
        }
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.Q0;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.P0 = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.e && (context = this.t0) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new d()).g(getResources().getString(a7.j.d4), new c()).n();
        }
        if (itemId == a7.f.fb) {
            w.A0(this.t0);
            if (itemId == a7.f.hb) {
                a.a aVar = new a.a(this);
                aVar.setTitle(this.t0.getResources().getString(a7.j.u0));
                aVar.f(this.t0.getResources().getString(a7.j.T0));
                aVar.d(a7.e.s1);
                aVar.j(this.t0.getResources().getString(a7.j.S8), new e());
                aVar.g(this.t0.getResources().getString(a7.j.d4), new f());
                aVar.n();
            }
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        U1();
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.t0);
        w.z0(this.t0);
        if (this.u1.equals("mobile")) {
            try {
                this.n1 = o4.b.e(this.t0).c().c();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!this.m1) {
            a2();
            try {
                q7.n nVar = new q7.n(this.t0, this.j, null, this.d1, "", this.u1, this.n0);
                this.b1 = nVar;
                this.n0.setAdapter(nVar);
            } catch (Exception unused) {
            }
        }
        this.m1 = false;
    }

    public void onStop() {
        p4.i r2;
        super.onStop();
        try {
            q7.n nVar = this.b1;
            if (nVar != null) {
                nVar.b1();
            }
            o4.e eVar = this.n1;
            if (eVar == null || this.b1 == null || (r2 = eVar.r()) == null) {
                return;
            }
            r2.X(this.b1.R);
        } catch (Exception unused) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        U1();
    }

    public void q(StalkerGetVODByCatCallback stalkerGetVODByCatCallback) {
        int i2;
        ProgressDialog progressDialog = this.u0;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.u0.dismiss();
        }
        w.X();
        if (stalkerGetVODByCatCallback == null || stalkerGetVODByCatCallback.getJs() == null || stalkerGetVODByCatCallback.getJs().getData() == null || stalkerGetVODByCatCallback.getJs().getData().size() <= 0) {
            return;
        }
        this.y1 = w.v(stalkerGetVODByCatCallback.getJs().getTotalItems().intValue(), stalkerGetVODByCatCallback.getJs().getMaxPageItems().intValue());
        for (int i3 = 0; i3 < stalkerGetVODByCatCallback.getJs().getData().size(); i3++) {
            String[] split = ((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i3)).getId().split(":", 0);
            if (split.length == 2) {
                i2 = w.r0(split[1]);
                this.i1.add(Integer.valueOf(i2));
                this.G1.add(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i3)).getCmd());
            } else {
                i2 = 0;
            }
            if (stalkerGetVODByCatCallback.getJs().getData().get(i3) != null && ((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i3)).getSeries() != null) {
                for (int i4 = 0; i4 < ((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i3)).getSeries().size(); i4++) {
                    GetEpisdoeDetailsCallback getEpisdoeDetailsCallback = new GetEpisdoeDetailsCallback();
                    getEpisdoeDetailsCallback.setId(((Integer) ((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i3)).getSeries().get(i4)).toString());
                    getEpisdoeDetailsCallback.setSeasonNumber(Integer.valueOf(i2));
                    getEpisdoeDetailsCallback.setImage(this.j);
                    getEpisdoeDetailsCallback.setTitle(this.e + " - S" + i2 + ":E" + ((Integer) ((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i3)).getSeries().get(i4)).toString());
                    getEpisdoeDetailsCallback.setAdded("");
                    getEpisdoeDetailsCallback.setContainerExtension("");
                    getEpisdoeDetailsCallback.setEpisodeNum((Integer) ((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i3)).getSeries().get(i4));
                    String str = this.l;
                    if (str != null) {
                        getEpisdoeDetailsCallback.setCategoryId(str);
                    }
                    getEpisdoeDetailsCallback.setMovieImage(this.j);
                    getEpisdoeDetailsCallback.setRating("");
                    getEpisdoeDetailsCallback.setDuration("");
                    getEpisdoeDetailsCallback.setDurationSec("");
                    getEpisdoeDetailsCallback.setDesc("");
                    getEpisdoeDetailsCallback.setSeriesId(this.m);
                    getEpisdoeDetailsCallback.setMainSeriesImg(this.j);
                    getEpisdoeDetailsCallback.setSeriesNum(this.F0);
                    getEpisdoeDetailsCallback.setSeriesName(this.e);
                    getEpisdoeDetailsCallback.setCMD(((StalkerGetVODByCatPojo2) stalkerGetVODByCatCallback.getJs().getData().get(i3)).getCmd());
                    this.V0.add(getEpisdoeDetailsCallback);
                }
            }
        }
        ArrayList arrayList = this.i1;
        if (arrayList != null && arrayList.size() > 0 && this.g1 != null) {
            q7.U u2 = this.c1;
            q7.U u3 = new q7.U(this.t0, this.i1, this.g1, this.k1, u2 != null ? u2.m0() : 0);
            this.c1 = u3;
            this.h1.setAdapter(u3);
        }
        e2();
    }

    public void u(StalkerCreatePlayerLinkCallback stalkerCreatePlayerLinkCallback, View view, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7, String str8) {
        try {
            w.X();
            if (stalkerCreatePlayerLinkCallback == null || stalkerCreatePlayerLinkCallback.getJs() == null || stalkerCreatePlayerLinkCallback.getJs().getCmd() == null || stalkerCreatePlayerLinkCallback.getJs().getId() == null) {
                return;
            }
            this.E1 = stalkerCreatePlayerLinkCallback.getJs().getCmd();
            X1(view);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b A[Catch: Exception -> 0x0047, TryCatch #1 {Exception -> 0x0047, blocks: (B:30:0x0004, B:32:0x000a, B:34:0x0018, B:36:0x001e, B:38:0x0028, B:41:0x0040, B:4:0x004b, B:6:0x0051, B:8:0x005b, B:10:0x0061, B:12:0x006b, B:14:0x0081, B:16:0x0098, B:19:0x009b), top: B:29:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void u0(com.nst.iptvsmarterstvbox.model.callback.SearchTMDBTVShowsCallback r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L49
            java.lang.Integer r2 = r5.getTotalResults()     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto L49
            java.lang.Integer r2 = r5.getTotalResults()     // Catch: java.lang.Exception -> L47
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L47
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto L49
            java.util.List r2 = r5.getResults()     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto L49
            java.util.List r2 = r5.getResults()     // Catch: java.lang.Exception -> L47
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto L49
            java.util.List r5 = r5.getResults()     // Catch: java.lang.Exception -> L47
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L47
            com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo r5 = (com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo) r5     // Catch: java.lang.Exception -> L47
            java.lang.Integer r5 = r5.getId()     // Catch: java.lang.Exception -> L47
            int r5 = r5.intValue()     // Catch: java.lang.Exception -> L47
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L40
            r4.d = r0     // Catch: java.lang.Exception -> L40
        L40:
            n7.i r0 = r4.T0     // Catch: java.lang.Exception -> L47
            r0.b(r5)     // Catch: java.lang.Exception -> L47
            goto Lbc
        L47:
            goto Lb3
        L49:
            if (r5 == 0) goto Lb3
            java.lang.Integer r2 = r5.getTotalResults()     // Catch: java.lang.Exception -> L47
            if (r2 == 0) goto Lb3
            java.lang.Integer r2 = r5.getTotalResults()     // Catch: java.lang.Exception -> L47
            int r2 = r2.intValue()     // Catch: java.lang.Exception -> L47
            if (r2 <= r1) goto Lb3
            java.util.List r1 = r5.getResults()     // Catch: java.lang.Exception -> L47
            if (r1 == 0) goto Lb3
        L61:
            java.util.List r1 = r5.getResults()     // Catch: java.lang.Exception -> L47
            int r1 = r1.size()     // Catch: java.lang.Exception -> L47
            if (r0 >= r1) goto Lb3
            java.util.List r1 = r5.getResults()     // Catch: java.lang.Exception -> L47
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Exception -> L47
            com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo r1 = (com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo) r1     // Catch: java.lang.Exception -> L47
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Exception -> L47
            java.lang.String r2 = r4.e     // Catch: java.lang.Exception -> L47
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L47
            if (r1 != 0) goto L9b
            java.util.List r1 = r5.getResults()     // Catch: java.lang.Exception -> L47
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Exception -> L47
            com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo r1 = (com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo) r1     // Catch: java.lang.Exception -> L47
            java.lang.String r1 = r1.getOriginalName()     // Catch: java.lang.Exception -> L47
            java.lang.String r2 = r4.e     // Catch: java.lang.Exception -> L47
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Exception -> L47
            if (r1 == 0) goto L98
            goto L9b
        L98:
            int r0 = r0 + 1
            goto L61
        L9b:
            n7.i r1 = r4.T0     // Catch: java.lang.Exception -> L47
            java.util.List r5 = r5.getResults()     // Catch: java.lang.Exception -> L47
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L47
            com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo r5 = (com.nst.iptvsmarterstvbox.model.pojo.SearchTMDBTVShowsResultPojo) r5     // Catch: java.lang.Exception -> L47
            java.lang.Integer r5 = r5.getId()     // Catch: java.lang.Exception -> L47
            int r5 = r5.intValue()     // Catch: java.lang.Exception -> L47
            r1.b(r5)     // Catch: java.lang.Exception -> L47
            goto Lbc
        Lb3:
            android.widget.TextView r5 = r4.p0
            if (r5 == 0) goto Lbc
            r0 = 8
            r5.setVisibility(r0)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.SeriesDetailActivity.u0(com.nst.iptvsmarterstvbox.model.callback.SearchTMDBTVShowsCallback):void");
    }

    public void v0(String str) {
        try {
            w.X();
        } catch (Exception unused) {
        }
    }

    public void y0(String str) {
        try {
            w.X();
        } catch (Exception unused) {
        }
    }

    public class h implements U.c {
        public h() {
        }

        public void a(k.U u) {
        }
    }

    public void I(m0.x xVar, int i2) {
    }

    public void V0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, m0.x xVar, int i2) {
    }

    public void d0(StalkerSetLiveFavCallback stalkerSetLiveFavCallback, t.o oVar, String str, String str2) {
    }
}
