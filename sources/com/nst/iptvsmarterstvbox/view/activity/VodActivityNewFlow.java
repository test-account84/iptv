package com.nst.iptvsmarterstvbox.view.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.nst.iptvsmarterstvbox.model.LiveStreamCategoryIdDBModel;
import com.nst.iptvsmarterstvbox.model.database.DatabaseUpdatedStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.database.PasswordStatusDBModel;
import com.nst.iptvsmarterstvbox.model.database.SeriesRecentWatchDatabase;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m7.w;
import q7.j0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class VodActivityNewFlow extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ProgressBar W;
    public ArrayList A;
    public j0 B;
    public SearchView C;
    public ArrayList E;
    public ArrayList F;
    public ArrayList G;
    public ArrayList H;
    public ArrayList I;
    public PopupWindow K;
    public Handler L;
    public MenuItem M;
    public Menu N;
    public ImageView Q;
    public SeriesRecentWatchDatabase R;
    public List T;
    public Boolean U;
    public Boolean V;
    public ProgressBar d;
    public Toolbar e;
    public AppBarLayout f;
    public LinearLayout g;
    public ProgressBar h;
    public RecyclerView i;
    public TextView j;
    public FrameLayout k;
    public TextView l;
    public RelativeLayout m;
    public RelativeLayout n;
    public Button o;
    public ImageView p;
    public Context q;
    public SharedPreferences r;
    public RecyclerView.o s;
    public LiveStreamDBHandler w;
    public ArrayList y;
    public ArrayList z;
    public String t = "";
    public String u = "";
    public DatabaseUpdatedStatusDBModel v = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel x = new DatabaseUpdatedStatusDBModel();
    public ArrayList D = new ArrayList();
    public int J = -1;
    public AsyncTask O = null;
    public int P = 0;
    public ArrayList S = new ArrayList();

    public class a implements SearchView.m {
        public a() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            m7.a.k0 = str.length() > 0 ? Boolean.FALSE : Boolean.TRUE;
            VodActivityNewFlow.this.j.setVisibility(8);
            if (VodActivityNewFlow.x1(VodActivityNewFlow.this) == null || (textView = VodActivityNewFlow.this.j) == null || textView.getVisibility() == 0) {
                return false;
            }
            VodActivityNewFlow.x1(VodActivityNewFlow.this).x0(str, VodActivityNewFlow.this.j);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            VodActivityNewFlow.y1(VodActivityNewFlow.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Activity d;

        public c(RadioGroup radioGroup, View view, Activity activity) {
            this.a = radioGroup;
            this.c = view;
            this.d = activity;
        }

        public void onClick(View view) {
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            SharepreferenceDBHandler.setVodActivitynewFlowSort(findViewById.getText().toString().equals(VodActivityNewFlow.this.getResources().getString(a7.j.f7)) ? "1" : findViewById.getText().toString().equals(VodActivityNewFlow.this.getResources().getString(a7.j.k7)) ? "2" : "0", this.d);
            VodActivityNewFlow.z1(VodActivityNewFlow.this, VodActivityNewFlow.this.new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]));
            VodActivityNewFlow.y1(VodActivityNewFlow.this).dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            VodActivityNewFlow.u1(VodActivityNewFlow.this).startActivity(new Intent(VodActivityNewFlow.u1(VodActivityNewFlow.this), NewDashboardActivity.class));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            w.j(VodActivityNewFlow.u1(VodActivityNewFlow.this));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            VodActivityNewFlow.this.onBackPressed();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(VodActivityNewFlow.u1(VodActivityNewFlow.this));
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(VodActivityNewFlow.u1(VodActivityNewFlow.this));
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class m implements View.OnFocusChangeListener {
        public final View a;

        public m(View view) {
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
            if (z) {
                b(1.15f);
                c(1.15f);
            } else {
                if (z) {
                    return;
                }
                b(1.0f);
                c(1.0f);
                a(z);
            }
        }
    }

    public class n extends AsyncTask {
        public n() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(VodActivityNewFlow.v1(VodActivityNewFlow.this));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            VodActivityNewFlow.w1(VodActivityNewFlow.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    public VodActivityNewFlow() {
        Boolean bool = Boolean.FALSE;
        this.U = bool;
        this.V = bool;
    }

    private void A1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    private ArrayList B1() {
        ArrayList allPasswordStatus = this.w.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.q));
        this.E = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.D.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.D;
    }

    private ArrayList C1(ArrayList arrayList, ArrayList arrayList2) {
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
                        ArrayList arrayList3 = this.F;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamCategoryIdDBModel);
                        }
                    }
                }
            }
        }
        return this.F;
    }

    private void D1() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    private void E1() {
        this.Q = findViewById(a7.f.Xa);
        this.d = findViewById(a7.f.ec);
        this.e = findViewById(a7.f.kh);
        this.f = findViewById(a7.f.W);
        this.g = findViewById(a7.f.cb);
        this.h = findViewById(a7.f.oc);
        this.i = findViewById(a7.f.ub);
        this.j = findViewById(a7.f.Q2);
        this.k = findViewById(a7.f.Q3);
        this.l = findViewById(a7.f.j4);
        this.m = findViewById(a7.f.Af);
        this.n = findViewById(a7.f.Oe);
        this.o = findViewById(a7.f.s0);
        this.p = findViewById(a7.f.F4);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0130 A[Catch: NullPointerException | Exception -> 0x0376, NullPointerException | Exception -> 0x0376, TryCatch #0 {NullPointerException | Exception -> 0x0376, blocks: (B:3:0x0007, B:5:0x000c, B:8:0x0091, B:8:0x0091, B:9:0x00a1, B:9:0x00a1, B:12:0x00b1, B:12:0x00b1, B:15:0x00bd, B:15:0x00bd, B:16:0x00cf, B:16:0x00cf, B:17:0x00f4, B:17:0x00f4, B:20:0x010b, B:20:0x010b, B:22:0x011b, B:22:0x011b, B:24:0x011f, B:24:0x011f, B:26:0x012d, B:26:0x012d, B:27:0x0133, B:27:0x0133, B:29:0x013f, B:29:0x013f, B:31:0x0143, B:31:0x0143, B:34:0x014b, B:34:0x014b, B:36:0x0153, B:36:0x0153, B:38:0x0157, B:38:0x0157, B:42:0x015f, B:42:0x015f, B:44:0x0171, B:44:0x0171, B:46:0x0183, B:46:0x0183, B:48:0x0195, B:48:0x0195, B:50:0x01a9, B:50:0x01a9, B:51:0x0220, B:51:0x0220, B:53:0x0225, B:53:0x0225, B:55:0x01d2, B:55:0x01d2, B:57:0x01f6, B:57:0x01f6, B:58:0x01f8, B:58:0x01f8, B:60:0x0229, B:60:0x0229, B:62:0x022d, B:62:0x022d, B:64:0x0233, B:64:0x0233, B:65:0x031e, B:65:0x031e, B:68:0x0323, B:68:0x0323, B:70:0x032b, B:70:0x032b, B:74:0x0239, B:74:0x0239, B:76:0x023d, B:76:0x023d, B:79:0x0245, B:79:0x0245, B:81:0x024d, B:81:0x024d, B:83:0x0251, B:83:0x0251, B:87:0x0259, B:87:0x0259, B:89:0x026b, B:89:0x026b, B:91:0x027d, B:91:0x027d, B:93:0x028f, B:93:0x028f, B:95:0x02a1, B:95:0x02a1, B:97:0x02b5, B:97:0x02b5, B:98:0x030c, B:98:0x030c, B:100:0x030e, B:100:0x030e, B:102:0x02e1, B:102:0x02e1, B:104:0x0312, B:104:0x0312, B:106:0x0316, B:106:0x0316, B:109:0x0130, B:109:0x0130, B:110:0x0107, B:110:0x0107, B:111:0x00d7, B:111:0x00d7, B:114:0x00e3, B:114:0x00e3), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0107 A[Catch: NullPointerException | Exception -> 0x0376, NullPointerException | Exception -> 0x0376, TryCatch #0 {NullPointerException | Exception -> 0x0376, blocks: (B:3:0x0007, B:5:0x000c, B:8:0x0091, B:8:0x0091, B:9:0x00a1, B:9:0x00a1, B:12:0x00b1, B:12:0x00b1, B:15:0x00bd, B:15:0x00bd, B:16:0x00cf, B:16:0x00cf, B:17:0x00f4, B:17:0x00f4, B:20:0x010b, B:20:0x010b, B:22:0x011b, B:22:0x011b, B:24:0x011f, B:24:0x011f, B:26:0x012d, B:26:0x012d, B:27:0x0133, B:27:0x0133, B:29:0x013f, B:29:0x013f, B:31:0x0143, B:31:0x0143, B:34:0x014b, B:34:0x014b, B:36:0x0153, B:36:0x0153, B:38:0x0157, B:38:0x0157, B:42:0x015f, B:42:0x015f, B:44:0x0171, B:44:0x0171, B:46:0x0183, B:46:0x0183, B:48:0x0195, B:48:0x0195, B:50:0x01a9, B:50:0x01a9, B:51:0x0220, B:51:0x0220, B:53:0x0225, B:53:0x0225, B:55:0x01d2, B:55:0x01d2, B:57:0x01f6, B:57:0x01f6, B:58:0x01f8, B:58:0x01f8, B:60:0x0229, B:60:0x0229, B:62:0x022d, B:62:0x022d, B:64:0x0233, B:64:0x0233, B:65:0x031e, B:65:0x031e, B:68:0x0323, B:68:0x0323, B:70:0x032b, B:70:0x032b, B:74:0x0239, B:74:0x0239, B:76:0x023d, B:76:0x023d, B:79:0x0245, B:79:0x0245, B:81:0x024d, B:81:0x024d, B:83:0x0251, B:83:0x0251, B:87:0x0259, B:87:0x0259, B:89:0x026b, B:89:0x026b, B:91:0x027d, B:91:0x027d, B:93:0x028f, B:93:0x028f, B:95:0x02a1, B:95:0x02a1, B:97:0x02b5, B:97:0x02b5, B:98:0x030c, B:98:0x030c, B:100:0x030e, B:100:0x030e, B:102:0x02e1, B:102:0x02e1, B:104:0x0312, B:104:0x0312, B:106:0x0316, B:106:0x0316, B:109:0x0130, B:109:0x0130, B:110:0x0107, B:110:0x0107, B:111:0x00d7, B:111:0x00d7, B:114:0x00e3, B:114:0x00e3), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013f A[Catch: NullPointerException | Exception -> 0x0376, NullPointerException | Exception -> 0x0376, TryCatch #0 {NullPointerException | Exception -> 0x0376, blocks: (B:3:0x0007, B:5:0x000c, B:8:0x0091, B:8:0x0091, B:9:0x00a1, B:9:0x00a1, B:12:0x00b1, B:12:0x00b1, B:15:0x00bd, B:15:0x00bd, B:16:0x00cf, B:16:0x00cf, B:17:0x00f4, B:17:0x00f4, B:20:0x010b, B:20:0x010b, B:22:0x011b, B:22:0x011b, B:24:0x011f, B:24:0x011f, B:26:0x012d, B:26:0x012d, B:27:0x0133, B:27:0x0133, B:29:0x013f, B:29:0x013f, B:31:0x0143, B:31:0x0143, B:34:0x014b, B:34:0x014b, B:36:0x0153, B:36:0x0153, B:38:0x0157, B:38:0x0157, B:42:0x015f, B:42:0x015f, B:44:0x0171, B:44:0x0171, B:46:0x0183, B:46:0x0183, B:48:0x0195, B:48:0x0195, B:50:0x01a9, B:50:0x01a9, B:51:0x0220, B:51:0x0220, B:53:0x0225, B:53:0x0225, B:55:0x01d2, B:55:0x01d2, B:57:0x01f6, B:57:0x01f6, B:58:0x01f8, B:58:0x01f8, B:60:0x0229, B:60:0x0229, B:62:0x022d, B:62:0x022d, B:64:0x0233, B:64:0x0233, B:65:0x031e, B:65:0x031e, B:68:0x0323, B:68:0x0323, B:70:0x032b, B:70:0x032b, B:74:0x0239, B:74:0x0239, B:76:0x023d, B:76:0x023d, B:79:0x0245, B:79:0x0245, B:81:0x024d, B:81:0x024d, B:83:0x0251, B:83:0x0251, B:87:0x0259, B:87:0x0259, B:89:0x026b, B:89:0x026b, B:91:0x027d, B:91:0x027d, B:93:0x028f, B:93:0x028f, B:95:0x02a1, B:95:0x02a1, B:97:0x02b5, B:97:0x02b5, B:98:0x030c, B:98:0x030c, B:100:0x030e, B:100:0x030e, B:102:0x02e1, B:102:0x02e1, B:104:0x0312, B:104:0x0312, B:106:0x0316, B:106:0x0316, B:109:0x0130, B:109:0x0130, B:110:0x0107, B:110:0x0107, B:111:0x00d7, B:111:0x00d7, B:114:0x00e3, B:114:0x00e3), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0239 A[Catch: NullPointerException | Exception -> 0x0376, NullPointerException | Exception -> 0x0376, TryCatch #0 {NullPointerException | Exception -> 0x0376, blocks: (B:3:0x0007, B:5:0x000c, B:8:0x0091, B:8:0x0091, B:9:0x00a1, B:9:0x00a1, B:12:0x00b1, B:12:0x00b1, B:15:0x00bd, B:15:0x00bd, B:16:0x00cf, B:16:0x00cf, B:17:0x00f4, B:17:0x00f4, B:20:0x010b, B:20:0x010b, B:22:0x011b, B:22:0x011b, B:24:0x011f, B:24:0x011f, B:26:0x012d, B:26:0x012d, B:27:0x0133, B:27:0x0133, B:29:0x013f, B:29:0x013f, B:31:0x0143, B:31:0x0143, B:34:0x014b, B:34:0x014b, B:36:0x0153, B:36:0x0153, B:38:0x0157, B:38:0x0157, B:42:0x015f, B:42:0x015f, B:44:0x0171, B:44:0x0171, B:46:0x0183, B:46:0x0183, B:48:0x0195, B:48:0x0195, B:50:0x01a9, B:50:0x01a9, B:51:0x0220, B:51:0x0220, B:53:0x0225, B:53:0x0225, B:55:0x01d2, B:55:0x01d2, B:57:0x01f6, B:57:0x01f6, B:58:0x01f8, B:58:0x01f8, B:60:0x0229, B:60:0x0229, B:62:0x022d, B:62:0x022d, B:64:0x0233, B:64:0x0233, B:65:0x031e, B:65:0x031e, B:68:0x0323, B:68:0x0323, B:70:0x032b, B:70:0x032b, B:74:0x0239, B:74:0x0239, B:76:0x023d, B:76:0x023d, B:79:0x0245, B:79:0x0245, B:81:0x024d, B:81:0x024d, B:83:0x0251, B:83:0x0251, B:87:0x0259, B:87:0x0259, B:89:0x026b, B:89:0x026b, B:91:0x027d, B:91:0x027d, B:93:0x028f, B:93:0x028f, B:95:0x02a1, B:95:0x02a1, B:97:0x02b5, B:97:0x02b5, B:98:0x030c, B:98:0x030c, B:100:0x030e, B:100:0x030e, B:102:0x02e1, B:102:0x02e1, B:104:0x0312, B:104:0x0312, B:106:0x0316, B:106:0x0316, B:109:0x0130, B:109:0x0130, B:110:0x0107, B:110:0x0107, B:111:0x00d7, B:111:0x00d7, B:114:0x00e3, B:114:0x00e3), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean F1() {
        /*
            Method dump skipped, instructions count: 887
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.VodActivityNewFlow.F1():boolean");
    }

    private void G1() {
        ProgressBar progressBar;
        int i2 = 8;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.q).equals("m3u")) {
            if (this.H == null || this.P == 0) {
                ProgressBar progressBar2 = this.d;
                if (progressBar2 == null) {
                    return;
                }
                progressBar2.setVisibility(8);
                progressBar = this.n;
                i2 = 0;
            } else {
                this.B = new j0(this.T, this.q);
                this.i.setItemAnimator(new androidx.recyclerview.widget.c());
                this.i.setAdapter(this.B);
                progressBar = this.d;
                if (progressBar == null) {
                    return;
                }
            }
        } else {
            if (this.H == null) {
                return;
            }
            this.B = new j0(this.T, this.q);
            this.i.setItemAnimator(new androidx.recyclerview.widget.c());
            this.i.setAdapter(this.B);
            progressBar = this.d;
            if (progressBar == null) {
                return;
            }
        }
        progressBar.setVisibility(i2);
    }

    private void H1(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a7.g.C4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.K = popupWindow;
            popupWindow.setContentView(inflate);
            this.K.setWidth(-1);
            this.K.setHeight(-1);
            this.K.setFocusable(true);
            this.K.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.H0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            RadioGroup findViewById3 = inflate.findViewById(a7.f.Kd);
            RadioButton findViewById4 = inflate.findViewById(a7.f.rd);
            RadioButton findViewById5 = inflate.findViewById(a7.f.md);
            findViewById5.setVisibility(8);
            RadioButton findViewById6 = inflate.findViewById(a7.f.fd);
            RadioButton findViewById7 = inflate.findViewById(a7.f.zd);
            RadioButton findViewById8 = inflate.findViewById(a7.f.gd);
            findViewById8.setVisibility(8);
            RadioButton findViewById9 = inflate.findViewById(a7.f.hd);
            findViewById9.setVisibility(8);
            findViewById4.setOnFocusChangeListener(new m(findViewById4));
            findViewById5.setOnFocusChangeListener(new m(findViewById5));
            findViewById6.setOnFocusChangeListener(new m(findViewById6));
            findViewById7.setOnFocusChangeListener(new m(findViewById7));
            findViewById8.setOnFocusChangeListener(new m(findViewById8));
            findViewById9.setOnFocusChangeListener(new m(findViewById9));
            String vodActivitynewFlowSort = SharepreferenceDBHandler.getVodActivitynewFlowSort(activity);
            if (vodActivitynewFlowSort.equals("1")) {
                findViewById6.setChecked(true);
            } else if (vodActivitynewFlowSort.equals("2")) {
                findViewById7.setChecked(true);
            } else {
                findViewById4.setChecked(true);
            }
            findViewById2.setOnClickListener(new b());
            findViewById.setOnClickListener(new c(findViewById3, inflate, activity));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public static /* synthetic */ Context u1(VodActivityNewFlow vodActivityNewFlow) {
        return vodActivityNewFlow.q;
    }

    public static /* synthetic */ boolean v1(VodActivityNewFlow vodActivityNewFlow) {
        return vodActivityNewFlow.F1();
    }

    public static /* synthetic */ void w1(VodActivityNewFlow vodActivityNewFlow) {
        vodActivityNewFlow.G1();
    }

    public static /* synthetic */ j0 x1(VodActivityNewFlow vodActivityNewFlow) {
        return vodActivityNewFlow.B;
    }

    public static /* synthetic */ PopupWindow y1(VodActivityNewFlow vodActivityNewFlow) {
        return vodActivityNewFlow.K;
    }

    public static /* synthetic */ AsyncTask z1(VodActivityNewFlow vodActivityNewFlow, AsyncTask asyncTask) {
        vodActivityNewFlow.O = asyncTask;
        return asyncTask;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void onBackPressed() {
        ProgressBar progressBar;
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        RecyclerView recyclerView = this.i;
        if (recyclerView != null) {
            recyclerView.setClickable(true);
        }
        j0 j0Var = this.B;
        if (j0Var != null && (progressBar = W) != null) {
            j0Var.F0(progressBar);
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        } else if (id == a7.f.M4) {
            this.O = new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        D1();
        setContentView(a7.g.D1);
        E1();
        this.q = this;
        AppBarLayout appBarLayout = this.f;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        m7.a.k0 = Boolean.FALSE;
        A1();
        r1(findViewById(a7.f.kh));
        getWindow().setFlags(1024, 1024);
        Handler handler = new Handler();
        this.L = handler;
        handler.removeCallbacksAndMessages((Object) null);
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.w = new LiveStreamDBHandler(this.q);
        this.i.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        this.s = gridLayoutManager;
        this.i.setLayoutManager(gridLayoutManager);
        this.i.setVisibility(0);
        this.O = new n().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        this.l.setOnClickListener(new d());
        this.k.setVisibility(8);
        this.Q.setOnClickListener(new e());
        this.p.setOnClickListener(new f());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.e.x(a7.h.r);
        this.N = menu;
        this.M = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843499, typedValue, true)) {
            TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
            if (this.e.getChildAt(i2) instanceof ActionMenuView) {
                ((a.a) this.e.getChildAt(i2).getLayoutParams()).a = 16;
            }
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        AsyncTask asyncTask = this.O;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            return;
        }
        this.O.cancel(true);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.N;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.M = menuItem;
        this.e.e();
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.q) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new h()).g(getResources().getString(a7.j.d4), new g()).n();
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.q.getResources().getString(a7.j.u0));
            aVar.f(this.q.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.q.getResources().getString(a7.j.S8), new i());
            aVar.g(this.q.getResources().getString(a7.j.d4), new j());
            aVar.n();
        }
        if (itemId == a7.f.ib) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.q.getResources().getString(a7.j.u0));
            aVar2.f(this.q.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.q.getResources().getString(a7.j.S8), new k());
            aVar2.g(this.q.getResources().getString(a7.j.d4), new l());
            aVar2.n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.C = b2;
            b2.setQueryHint(getResources().getString(a7.j.I6));
            this.C.setIconifiedByDefault(false);
            this.C.setOnQueryTextListener(new a());
        }
        if (itemId == a7.f.mb) {
            H1(this);
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        D1();
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.q);
        w.z0(this.q);
        getWindow().setFlags(1024, 1024);
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        j0 j0Var = this.B;
        if (j0Var != null) {
            j0Var.F0(W);
            this.B.w();
        }
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.r = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.r.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        D1();
    }
}
