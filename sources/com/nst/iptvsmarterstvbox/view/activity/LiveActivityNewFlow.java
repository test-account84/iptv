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
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m7.w;
import q7.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LiveActivityNewFlow extends androidx.appcompat.app.b implements View.OnClickListener {
    public static ProgressBar Z;
    public LiveStreamDBHandler B;
    public ArrayList C;
    public ArrayList D;
    public ArrayList E;
    public ArrayList F;
    public ArrayList G;
    public ArrayList H;
    public PopupWindow M;
    public SearchView O;
    public Handler P;
    public MenuItem R;
    public Menu S;
    public List W;
    public Boolean X;
    public Boolean Y;
    public ProgressBar d;
    public Toolbar e;
    public AppBarLayout f;
    public ProgressBar g;
    public RecyclerView h;
    public TextView i;
    public FrameLayout j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public RelativeLayout n;
    public Button o;
    public ImageView p;
    public Context q;
    public SharedPreferences r;
    public GridLayoutManager s;
    public r t;
    public boolean u = false;
    public int v = -1;
    public boolean w = false;
    public int x = 1;
    public int y = 0;
    public int z = 20;
    public ArrayList A = new ArrayList();
    public String I = "";
    public String J = "";
    public DatabaseUpdatedStatusDBModel K = new DatabaseUpdatedStatusDBModel();
    public DatabaseUpdatedStatusDBModel L = new DatabaseUpdatedStatusDBModel();
    public ArrayList N = new ArrayList();
    public int Q = -1;
    public AsyncTask T = null;
    public int U = 0;
    public ArrayList V = new ArrayList();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            LiveActivityNewFlow.x1(LiveActivityNewFlow.this).dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ RadioGroup a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Activity d;

        public b(RadioGroup radioGroup, View view, Activity activity) {
            this.a = radioGroup;
            this.c = view;
            this.d = activity;
        }

        public void onClick(View view) {
            RadioButton findViewById = this.c.findViewById(this.a.getCheckedRadioButtonId());
            SharepreferenceDBHandler.setLiveActivitynewFlowSort(findViewById.getText().toString().equals(LiveActivityNewFlow.this.getResources().getString(a7.j.f7)) ? "1" : findViewById.getText().toString().equals(LiveActivityNewFlow.this.getResources().getString(a7.j.k7)) ? "2" : "0", this.d);
            LiveActivityNewFlow.y1(LiveActivityNewFlow.this, LiveActivityNewFlow.this.new l().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]));
            LiveActivityNewFlow.x1(LiveActivityNewFlow.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            w.j(LiveActivityNewFlow.u1(LiveActivityNewFlow.this));
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.n0(LiveActivityNewFlow.u1(LiveActivityNewFlow.this));
        }
    }

    public class g implements SearchView.m {
        public g() {
        }

        public boolean onQueryTextChange(String str) {
            TextView textView;
            m7.a.k0 = str.length() > 0 ? Boolean.FALSE : Boolean.TRUE;
            LiveActivityNewFlow.this.m.setVisibility(8);
            LiveActivityNewFlow liveActivityNewFlow = LiveActivityNewFlow.this;
            if (liveActivityNewFlow.t == null || (textView = liveActivityNewFlow.l) == null || textView.getVisibility() == 0) {
                return false;
            }
            LiveActivityNewFlow liveActivityNewFlow2 = LiveActivityNewFlow.this;
            liveActivityNewFlow2.t.B0(str, liveActivityNewFlow2.m);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.m0(LiveActivityNewFlow.u1(LiveActivityNewFlow.this));
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class l extends AsyncTask {
        public l() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            try {
                return Boolean.valueOf(LiveActivityNewFlow.v1(LiveActivityNewFlow.this));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            LiveActivityNewFlow.w1(LiveActivityNewFlow.this);
        }

        public void onPreExecute() {
            super.onPreExecute();
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

    public LiveActivityNewFlow() {
        Boolean bool = Boolean.FALSE;
        this.X = bool;
        this.Y = bool;
    }

    public static /* synthetic */ Context u1(LiveActivityNewFlow liveActivityNewFlow) {
        return liveActivityNewFlow.q;
    }

    public static /* synthetic */ boolean v1(LiveActivityNewFlow liveActivityNewFlow) {
        return liveActivityNewFlow.C1();
    }

    public static /* synthetic */ void w1(LiveActivityNewFlow liveActivityNewFlow) {
        liveActivityNewFlow.D1();
    }

    public static /* synthetic */ PopupWindow x1(LiveActivityNewFlow liveActivityNewFlow) {
        return liveActivityNewFlow.M;
    }

    public static /* synthetic */ AsyncTask y1(LiveActivityNewFlow liveActivityNewFlow, AsyncTask asyncTask) {
        liveActivityNewFlow.T = asyncTask;
        return asyncTask;
    }

    private void z1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(E.b.getColor(this, a7.c.k));
    }

    public final ArrayList A1() {
        ArrayList allPasswordStatus = this.B.getAllPasswordStatus(SharepreferenceDBHandler.getUserID(this.q));
        this.C = allPasswordStatus;
        if (allPasswordStatus != null) {
            Iterator it = allPasswordStatus.iterator();
            while (it.hasNext()) {
                PasswordStatusDBModel passwordStatusDBModel = (PasswordStatusDBModel) it.next();
                if (passwordStatusDBModel.getPasswordStatus().equals("1")) {
                    this.A.add(passwordStatusDBModel.getPasswordStatusCategoryId());
                }
            }
        }
        return this.A;
    }

    public final ArrayList B1(ArrayList arrayList, ArrayList arrayList2) {
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
                        ArrayList arrayList3 = this.D;
                        if (arrayList3 != null) {
                            arrayList3.add(liveStreamCategoryIdDBModel);
                        }
                    }
                }
            }
        }
        return this.D;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0107 A[Catch: NullPointerException | Exception -> 0x034e, NullPointerException | Exception -> 0x034e, TryCatch #0 {NullPointerException | Exception -> 0x034e, blocks: (B:3:0x0009, B:5:0x000e, B:8:0x008d, B:8:0x008d, B:11:0x0099, B:11:0x0099, B:12:0x00ad, B:12:0x00ad, B:13:0x00d4, B:13:0x00d4, B:15:0x00e2, B:15:0x00e2, B:17:0x00e6, B:17:0x00e6, B:19:0x00f8, B:19:0x00f8, B:20:0x0100, B:20:0x0100, B:22:0x0104, B:22:0x0104, B:23:0x0114, B:23:0x0114, B:25:0x0120, B:25:0x0120, B:27:0x012e, B:27:0x012e, B:30:0x0136, B:30:0x0136, B:32:0x013e, B:32:0x013e, B:34:0x0142, B:34:0x0142, B:38:0x014a, B:38:0x014a, B:40:0x015c, B:40:0x015c, B:42:0x016e, B:42:0x016e, B:44:0x0182, B:44:0x0182, B:45:0x01f9, B:45:0x01f9, B:47:0x01fe, B:47:0x01fe, B:49:0x01ab, B:49:0x01ab, B:51:0x01cf, B:51:0x01cf, B:52:0x01d1, B:52:0x01d1, B:54:0x0202, B:54:0x0202, B:56:0x0206, B:56:0x0206, B:58:0x020c, B:58:0x020c, B:59:0x02f6, B:59:0x02f6, B:62:0x02fb, B:62:0x02fb, B:64:0x0303, B:64:0x0303, B:68:0x0212, B:68:0x0212, B:70:0x0216, B:70:0x0216, B:73:0x021e, B:73:0x021e, B:75:0x0226, B:75:0x0226, B:77:0x022a, B:77:0x022a, B:81:0x0232, B:81:0x0232, B:83:0x0244, B:83:0x0244, B:85:0x0256, B:85:0x0256, B:87:0x026a, B:87:0x026a, B:88:0x02e1, B:88:0x02e1, B:90:0x02e6, B:90:0x02e6, B:92:0x0293, B:92:0x0293, B:94:0x02b7, B:94:0x02b7, B:95:0x02b9, B:95:0x02b9, B:97:0x02ea, B:97:0x02ea, B:99:0x02ee, B:99:0x02ee, B:102:0x0107, B:102:0x0107, B:103:0x00b5, B:103:0x00b5, B:106:0x00c1, B:106:0x00c1), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0120 A[Catch: NullPointerException | Exception -> 0x034e, NullPointerException | Exception -> 0x034e, TryCatch #0 {NullPointerException | Exception -> 0x034e, blocks: (B:3:0x0009, B:5:0x000e, B:8:0x008d, B:8:0x008d, B:11:0x0099, B:11:0x0099, B:12:0x00ad, B:12:0x00ad, B:13:0x00d4, B:13:0x00d4, B:15:0x00e2, B:15:0x00e2, B:17:0x00e6, B:17:0x00e6, B:19:0x00f8, B:19:0x00f8, B:20:0x0100, B:20:0x0100, B:22:0x0104, B:22:0x0104, B:23:0x0114, B:23:0x0114, B:25:0x0120, B:25:0x0120, B:27:0x012e, B:27:0x012e, B:30:0x0136, B:30:0x0136, B:32:0x013e, B:32:0x013e, B:34:0x0142, B:34:0x0142, B:38:0x014a, B:38:0x014a, B:40:0x015c, B:40:0x015c, B:42:0x016e, B:42:0x016e, B:44:0x0182, B:44:0x0182, B:45:0x01f9, B:45:0x01f9, B:47:0x01fe, B:47:0x01fe, B:49:0x01ab, B:49:0x01ab, B:51:0x01cf, B:51:0x01cf, B:52:0x01d1, B:52:0x01d1, B:54:0x0202, B:54:0x0202, B:56:0x0206, B:56:0x0206, B:58:0x020c, B:58:0x020c, B:59:0x02f6, B:59:0x02f6, B:62:0x02fb, B:62:0x02fb, B:64:0x0303, B:64:0x0303, B:68:0x0212, B:68:0x0212, B:70:0x0216, B:70:0x0216, B:73:0x021e, B:73:0x021e, B:75:0x0226, B:75:0x0226, B:77:0x022a, B:77:0x022a, B:81:0x0232, B:81:0x0232, B:83:0x0244, B:83:0x0244, B:85:0x0256, B:85:0x0256, B:87:0x026a, B:87:0x026a, B:88:0x02e1, B:88:0x02e1, B:90:0x02e6, B:90:0x02e6, B:92:0x0293, B:92:0x0293, B:94:0x02b7, B:94:0x02b7, B:95:0x02b9, B:95:0x02b9, B:97:0x02ea, B:97:0x02ea, B:99:0x02ee, B:99:0x02ee, B:102:0x0107, B:102:0x0107, B:103:0x00b5, B:103:0x00b5, B:106:0x00c1, B:106:0x00c1), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0212 A[Catch: NullPointerException | Exception -> 0x034e, NullPointerException | Exception -> 0x034e, TryCatch #0 {NullPointerException | Exception -> 0x034e, blocks: (B:3:0x0009, B:5:0x000e, B:8:0x008d, B:8:0x008d, B:11:0x0099, B:11:0x0099, B:12:0x00ad, B:12:0x00ad, B:13:0x00d4, B:13:0x00d4, B:15:0x00e2, B:15:0x00e2, B:17:0x00e6, B:17:0x00e6, B:19:0x00f8, B:19:0x00f8, B:20:0x0100, B:20:0x0100, B:22:0x0104, B:22:0x0104, B:23:0x0114, B:23:0x0114, B:25:0x0120, B:25:0x0120, B:27:0x012e, B:27:0x012e, B:30:0x0136, B:30:0x0136, B:32:0x013e, B:32:0x013e, B:34:0x0142, B:34:0x0142, B:38:0x014a, B:38:0x014a, B:40:0x015c, B:40:0x015c, B:42:0x016e, B:42:0x016e, B:44:0x0182, B:44:0x0182, B:45:0x01f9, B:45:0x01f9, B:47:0x01fe, B:47:0x01fe, B:49:0x01ab, B:49:0x01ab, B:51:0x01cf, B:51:0x01cf, B:52:0x01d1, B:52:0x01d1, B:54:0x0202, B:54:0x0202, B:56:0x0206, B:56:0x0206, B:58:0x020c, B:58:0x020c, B:59:0x02f6, B:59:0x02f6, B:62:0x02fb, B:62:0x02fb, B:64:0x0303, B:64:0x0303, B:68:0x0212, B:68:0x0212, B:70:0x0216, B:70:0x0216, B:73:0x021e, B:73:0x021e, B:75:0x0226, B:75:0x0226, B:77:0x022a, B:77:0x022a, B:81:0x0232, B:81:0x0232, B:83:0x0244, B:83:0x0244, B:85:0x0256, B:85:0x0256, B:87:0x026a, B:87:0x026a, B:88:0x02e1, B:88:0x02e1, B:90:0x02e6, B:90:0x02e6, B:92:0x0293, B:92:0x0293, B:94:0x02b7, B:94:0x02b7, B:95:0x02b9, B:95:0x02b9, B:97:0x02ea, B:97:0x02ea, B:99:0x02ee, B:99:0x02ee, B:102:0x0107, B:102:0x0107, B:103:0x00b5, B:103:0x00b5, B:106:0x00c1, B:106:0x00c1), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean C1() {
        /*
            Method dump skipped, instructions count: 847
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.view.activity.LiveActivityNewFlow.C1():boolean");
    }

    public final void D1() {
        List list;
        ProgressBar progressBar;
        List list2;
        int i2 = 8;
        if (SharepreferenceDBHandler.getCurrentAPPType(this.q).equals("m3u")) {
            if (this.F == null || this.U == 0 || (list2 = this.W) == null) {
                ProgressBar progressBar2 = this.d;
                if (progressBar2 == null) {
                    return;
                }
                progressBar2.setVisibility(8);
                progressBar = this.n;
                i2 = 0;
            } else {
                this.t = new r(list2, this.q);
                this.s = new u7.a(this.q).A().equals(m7.a.K0) ? new GridLayoutManager(this.q, 2) : new GridLayoutManager(this.q, 2);
                this.h.setLayoutManager(this.s);
                this.h.setItemAnimator(new androidx.recyclerview.widget.c());
                this.h.setAdapter(this.t);
                progressBar = this.d;
                if (progressBar == null) {
                    return;
                }
            }
        } else {
            if (this.F == null || (list = this.W) == null) {
                return;
            }
            this.t = new r(list, this.q);
            this.s = new u7.a(this.q).A().equals(m7.a.K0) ? new GridLayoutManager(this.q, 2) : new GridLayoutManager(this.q, 2);
            this.h.setLayoutManager(this.s);
            this.h.setItemAnimator(new androidx.recyclerview.widget.c());
            this.h.setAdapter(this.t);
            progressBar = this.d;
            if (progressBar == null) {
                return;
            }
        }
        progressBar.setVisibility(i2);
    }

    public final void E1(Activity activity) {
        try {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(a7.g.C4, activity.findViewById(a7.f.Ve));
            PopupWindow popupWindow = new PopupWindow(activity);
            this.M = popupWindow;
            popupWindow.setContentView(inflate);
            this.M.setWidth(-1);
            this.M.setHeight(-1);
            this.M.setFocusable(true);
            this.M.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.H0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            RadioGroup findViewById3 = inflate.findViewById(a7.f.Kd);
            RadioButton findViewById4 = inflate.findViewById(a7.f.rd);
            findViewById4.requestFocus();
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
            String liveActivitynewFlowSort = SharepreferenceDBHandler.getLiveActivitynewFlowSort(activity);
            if (liveActivitynewFlowSort.equals("1")) {
                findViewById6.setChecked(true);
            } else if (liveActivitynewFlowSort.equals("2")) {
                findViewById7.setChecked(true);
            } else {
                findViewById4.setChecked(true);
            }
            findViewById2.setOnClickListener(new a());
            findViewById.setOnClickListener(new b(findViewById3, inflate, activity));
        } catch (NullPointerException | Exception unused) {
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return keyCode == 82 ? keyEvent.getAction() == 0 ? onKeyDown(keyCode, keyEvent) : onKeyUp(keyCode, keyEvent) : super.dispatchKeyEvent(keyEvent);
    }

    public void onBackPressed() {
        ProgressBar progressBar;
        RecyclerView recyclerView = this.h;
        if (recyclerView != null) {
            recyclerView.setClickable(true);
        }
        r rVar = this.t;
        if (rVar != null && (progressBar = Z) != null) {
            rVar.L0(progressBar);
            this.t.w();
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(a7.b.f, a7.b.d);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.Bj) {
            startActivity(new Intent(this, NewDashboardActivity.class));
        } else if (id == a7.f.M4) {
            this.T = new l().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else if (id == a7.f.Xa) {
            w.j(this.q);
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(a7.g.R);
        this.d = findViewById(a7.f.ec);
        this.e = findViewById(a7.f.kh);
        this.f = findViewById(a7.f.W);
        this.g = findViewById(a7.f.oc);
        this.h = findViewById(a7.f.ub);
        this.i = findViewById(a7.f.Q2);
        this.j = findViewById(a7.f.Q3);
        this.k = findViewById(a7.f.M4);
        this.l = findViewById(a7.f.sk);
        this.m = findViewById(a7.f.wk);
        this.n = findViewById(a7.f.Oe);
        this.o = findViewById(a7.f.s0);
        this.p = findViewById(a7.f.Xa);
        m7.a.k0 = Boolean.FALSE;
        AppBarLayout appBarLayout = this.f;
        if (appBarLayout != null) {
            appBarLayout.setBackground(getResources().getDrawable(a7.e.n));
        }
        z1();
        r1(findViewById(a7.f.kh));
        this.q = this;
        Handler handler = new Handler();
        this.P = handler;
        handler.removeCallbacksAndMessages((Object) null);
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.p.setOnClickListener(new c());
        this.T = new l().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        this.j.setVisibility(8);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super/*android.app.Activity*/.onCreateOptionsMenu(menu);
        this.e.x(a7.h.r);
        this.S = menu;
        this.R = menu.getItem(2).getSubMenu().findItem(a7.f.P2);
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
        AsyncTask asyncTask = this.T;
        if (asyncTask == null || !asyncTask.getStatus().equals(AsyncTask.Status.RUNNING)) {
            return;
        }
        this.T.cancel(true);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 82) {
            return super/*android.app.Activity*/.onKeyUp(i2, keyEvent);
        }
        Menu menu = this.S;
        if (menu == null) {
            return true;
        }
        menu.performIdentifierAction(a7.f.P2, 0);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Context context;
        this.R = menuItem;
        int itemId = menuItem.getItemId();
        if (itemId == a7.f.Gb) {
            startActivity(new Intent(this, NewDashboardActivity.class));
            finish();
        }
        if (itemId == a7.f.Mb) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        if (itemId == a7.f.f && (context = this.q) != null) {
            new a.a(context, a7.k.a).setTitle(getResources().getString(a7.j.f3)).f(getResources().getString(a7.j.e3)).j(getResources().getString(a7.j.S8), new f()).g(getResources().getString(a7.j.d4), new e()).n();
        }
        if (itemId == a7.f.g) {
            SearchView b2 = P.w.b(menuItem);
            this.O = b2;
            b2.setQueryHint(getResources().getString(a7.j.D6));
            this.O.setIconifiedByDefault(false);
            this.O.setOnQueryTextListener(new g());
            return true;
        }
        if (itemId == a7.f.gb) {
            a.a aVar = new a.a(this);
            aVar.setTitle(this.q.getResources().getString(a7.j.u0));
            aVar.f(this.q.getResources().getString(a7.j.T0));
            aVar.d(a7.e.s1);
            aVar.j(this.q.getResources().getString(a7.j.S8), new h());
            aVar.g(this.q.getResources().getString(a7.j.d4), new i());
            aVar.n();
        }
        if (itemId == a7.f.ib) {
            a.a aVar2 = new a.a(this);
            aVar2.setTitle(this.q.getResources().getString(a7.j.u0));
            aVar2.f(this.q.getResources().getString(a7.j.T0));
            aVar2.d(a7.e.s1);
            aVar2.j(this.q.getResources().getString(a7.j.S8), new j());
            aVar2.g(this.q.getResources().getString(a7.j.d4), new k());
            aVar2.n();
        }
        if (itemId == a7.f.mb) {
            this.m.setVisibility(8);
            E1(this);
        }
        return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.m(this.q);
        w.z0(this.q);
        getWindow().setFlags(1024, 1024);
        FrameLayout frameLayout = this.j;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        r rVar = this.t;
        if (rVar != null) {
            rVar.w();
        }
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        this.r = sharedPreferences;
        if (sharedPreferences.getString("username", "").equals("") && this.r.getString("password", "").equals("")) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
