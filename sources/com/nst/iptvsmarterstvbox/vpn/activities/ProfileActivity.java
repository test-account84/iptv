package com.nst.iptvsmarterstvbox.vpn.activities;

import F7.c;
import a7.f;
import a7.g;
import a7.j;
import a7.k;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonElement;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.VPNCredentialsPojo;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.AdsLastUpdateResponseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.getAnnouncementsFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.readAnnouncementFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationinterface.FirebaseInterface;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import de.blinkt.openvpn.core.B;
import de.blinkt.openvpn.core.C;
import de.blinkt.openvpn.core.F;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.OpenVPNStatusService;
import de.blinkt.openvpn.core.h;
import f8.l;
import j$.util.Objects;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import m7.w;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ProfileActivity extends androidx.appcompat.app.b implements FirebaseInterface, H7.a, View.OnClickListener {
    public static u7.a J;
    public String B;
    public FirebasePresenter C;
    public List D;
    public List E;
    public HashMap H;
    public LinearLayout d;
    public LinearLayout e;
    public ProgressBar f;
    public RecyclerView g;
    public RelativeLayout h;
    public TextView i;
    public androidx.appcompat.app.a j;
    public l k;
    public String n;
    public String o;
    public String p;
    public ArrayList q;
    public ArrayList r;
    public ArrayList s;
    public J7.a t;
    public Context u;
    public h x;
    public I7.a y;
    public int z;
    public boolean l = false;
    public boolean m = false;
    public String v = "";
    public String w = "";
    public ArrayList A = null;
    public String F = "";
    public boolean G = false;
    public ServiceConnection I = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ProfileActivity.w1(ProfileActivity.this, h.a.A(iBinder));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ProfileActivity.w1(ProfileActivity.this, null);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", ProfileActivity.this.getPackageName(), (String) null));
                ProfileActivity.this.startActivityForResult(intent, 101);
                Toast.makeText(ProfileActivity.B1(ProfileActivity.this), ProfileActivity.B1(ProfileActivity.this).getResources().getString(j.o2), 1).show();
            } catch (Exception unused) {
            }
            ProfileActivity.C1(ProfileActivity.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            ProfileActivity.C1(ProfileActivity.this).dismiss();
            ProfileActivity.this.onBackPressed();
        }
    }

    public class d implements c.a {
        public d() {
        }

        public void a(File file) {
            Log.i("main", "file download completed");
            if (file == null || !file.exists()) {
                Toast.makeText(ProfileActivity.B1(ProfileActivity.this), ProfileActivity.this.getResources().getString(j.a2), 0).show();
                w.X();
            } else {
                ProfileActivity profileActivity = ProfileActivity.this;
                new F7.a(profileActivity, file, profileActivity).b("SBP_URL");
            }
            Log.i("main", "file unzip completed");
        }
    }

    public class e extends AsyncTask {
        public e() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Boolean... boolArr) {
            return ProfileActivity.z1(ProfileActivity.this);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (!bool.booleanValue()) {
                ProfileActivity.A1(ProfileActivity.this, false);
            } else {
                ProfileActivity.A1(ProfileActivity.this, true);
                ProfileActivity.this.K1();
            }
        }

        public void onPreExecute() {
            super.onPreExecute();
            if (m7.a.e.booleanValue()) {
                ProfileActivity.x1(ProfileActivity.this).setVisibility(0);
                ProfileActivity.y1(ProfileActivity.this).setVisibility(8);
            }
        }
    }

    public static /* synthetic */ void A1(ProfileActivity profileActivity, boolean z) {
        profileActivity.v1(z);
    }

    public static /* synthetic */ Context B1(ProfileActivity profileActivity) {
        return profileActivity.u;
    }

    public static /* synthetic */ androidx.appcompat.app.a C1(ProfileActivity profileActivity) {
        return profileActivity.j;
    }

    private void D1() {
        File file;
        if (Build.VERSION.SDK_INT >= 23) {
            file = new File(this.u.getFilesDir() + "/VPNSBPIPTVSmarters/vpncertificate.zip");
        } else {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNSBPIPTVSmarters/vpncertificate.zip");
        }
        File file2 = new File(String.valueOf(file));
        if (file2.exists()) {
            file2.deleteOnExit();
        }
        new F7.c(String.valueOf(file), this, new d()).execute(new String[]{this.F});
    }

    private Boolean F1() {
        try {
            this.q = this.t.j();
        } catch (Exception unused) {
        }
        ArrayList arrayList = this.q;
        return (arrayList == null || arrayList.size() <= 0) ? Boolean.FALSE : Boolean.TRUE;
    }

    private void I1() {
        if (Build.VERSION.SDK_INT < 33 || G7.c.a(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            return;
        }
        D.b.h(this, w.s0(), 1);
    }

    private void M1() {
        w.X();
        N1();
    }

    public static /* synthetic */ h w1(ProfileActivity profileActivity, h hVar) {
        profileActivity.x = hVar;
        return hVar;
    }

    public static /* synthetic */ ProgressBar x1(ProfileActivity profileActivity) {
        return profileActivity.f;
    }

    public static /* synthetic */ LinearLayout y1(ProfileActivity profileActivity) {
        return profileActivity.d;
    }

    public static /* synthetic */ Boolean z1(ProfileActivity profileActivity) {
        return profileActivity.F1();
    }

    public final void E1() {
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        u1();
        String o0 = w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format);
        w.M0(this);
        this.C.j(m7.a.S0, m7.a.T0, format, o0);
    }

    public void G1() {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && i < 33) {
                if (G7.c.a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && G7.c.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    return;
                }
                D.b.h(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:94|(2:95|96)|(8:97|(3:99|(3:126|127|128)(6:101|102|103|104|105|107)|108)(1:129)|110|111|(1:113)(3:118|119|(2:122|123)(1:121))|114|117|83)|130|110|111|(0)(0)|114|117|83) */
    /* JADX WARN: Removed duplicated region for block: B:113:0x020a A[Catch: Exception -> 0x01cf, TryCatch #0 {Exception -> 0x01cf, blocks: (B:111:0x0200, B:113:0x020a, B:118:0x021c), top: B:110:0x0200 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x021c A[Catch: Exception -> 0x01cf, TRY_LEAVE, TryCatch #0 {Exception -> 0x01cf, blocks: (B:111:0x0200, B:113:0x020a, B:118:0x021c), top: B:110:0x0200 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void H1(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.vpn.activities.ProfileActivity.H1(java.lang.String, java.lang.String):void");
    }

    public void J1() {
        startActivity(new Intent(this, ImportVPNActivity.class));
        finish();
    }

    public void K1() {
        this.g.setLayoutManager(new GridLayoutManager(this, 2));
        if (this.y != null) {
            this.y = null;
        }
        I7.a aVar = new I7.a(this.u, this.q, this);
        this.y = aVar;
        this.g.setAdapter(aVar);
    }

    public final void L1(String str, String str2, String str3, File file) {
        String str4;
        String str5;
        HashMap hashMap = this.H;
        if (hashMap == null || hashMap.size() <= 0) {
            str4 = "";
            str5 = "";
        } else {
            for (String str6 : this.H.keySet()) {
                if (str6.equalsIgnoreCase(str2)) {
                    VPNCredentialsPojo vPNCredentialsPojo = (VPNCredentialsPojo) this.H.get(str6);
                    str4 = vPNCredentialsPojo.getUsername();
                    str5 = vPNCredentialsPojo.getPassword();
                    break;
                }
            }
            str4 = "";
            str5 = "";
        }
        L7.a aVar = new L7.a();
        if (str3.contains("auth-user-pass")) {
            aVar.l("1");
        } else {
            aVar.l("0");
        }
        aVar.p("0");
        aVar.v(str4);
        aVar.u(str5);
        aVar.r(str2);
        aVar.m(str);
        aVar.t("0");
        aVar.q(String.valueOf(file));
        aVar.s("sbp");
        this.A.add(aVar);
    }

    public void N1() {
        new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Boolean[0]);
    }

    public void Q0(getAnnouncementsFirebaseCallback getannouncementsfirebasecallback) {
    }

    public void h(AdsLastUpdateResponseCallback adsLastUpdateResponseCallback) {
    }

    public void k0(readAnnouncementFirebaseCallback readannouncementfirebasecallback) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i, i2, intent);
        if (i != 70) {
            if (i == 101) {
                try {
                    G1();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (i2 == -1) {
            if (this.k.H(this.o, this.n) != 0) {
                G.J("USER_VPN_PASSWORD", "", j.E7, de.blinkt.openvpn.core.e.LEVEL_WAITING_FOR_USER_INPUT);
                l lVar = this.k;
                lVar.B = this.v;
                String str = this.w;
                lVar.A = str;
                this.n = str;
                bindService(new Intent(this, OpenVPNStatusService.class), this.I, 1);
                return;
            }
            boolean z = B.a(this).getBoolean("showlogwindow", true);
            if (!this.l && z) {
                C.u(this, this.k);
            }
            F.f(this.k, getBaseContext());
        } else {
            if (i2 != 0) {
                return;
            }
            G.J("USER_VPN_PERMISSION_CANCELLED", "", j.H7, de.blinkt.openvpn.core.e.LEVEL_NOTCONNECTED);
            if (Build.VERSION.SDK_INT >= 24) {
                G.n(j.J4);
            }
        }
        finish();
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    public void onClick(View view) {
        if (view.getId() == f.R6 || view.getId() == f.U6) {
            J1();
        }
    }

    public void onCreate(Bundle bundle) {
        this.u = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.u);
        J = aVar;
        String A = aVar.A();
        this.B = A;
        setContentView(A.equals(m7.a.K0) ? g.t0 : g.s0);
        w.Y(this);
        this.d = findViewById(f.R6);
        this.e = findViewById(f.U6);
        this.f = findViewById(f.Nc);
        this.g = findViewById(f.Cd);
        this.h = findViewById(f.Vd);
        this.i = findViewById(f.yk);
        I1();
        this.C = new FirebasePresenter(this.u, this);
        this.t = new J7.a(this.u);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.q = new ArrayList();
        this.s = new ArrayList();
        this.r = new ArrayList();
        this.A = new ArrayList();
        if (m7.a.e.booleanValue()) {
            this.d.setVisibility(0);
            this.e.setVisibility(0);
        }
        this.p = getIntent().getStringExtra("typeid");
        h8.b bVar = new h8.b(this.u);
        bVar.d();
        bVar.a("com.nst.iptvsmarterstvbox");
        if (m7.a.V0.booleanValue()) {
            E1();
        }
        this.G = true;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 101) {
            return;
        }
        try {
            if (iArr.length > 0 && iArr[0] == 0 && iArr[1] == 0) {
                G1();
            } else if (Build.VERSION.SDK_INT < 23 || G7.d.a(this, strArr[0])) {
                onBackPressed();
            } else {
                a.a aVar = new a.a(this, k.a);
                View inflate = LayoutInflater.from(this).inflate(g.W3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(f.c1);
                Button findViewById2 = inflate.findViewById(f.U0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
                findViewById.requestFocus();
                findViewById.setOnClickListener(new b());
                findViewById2.setOnClickListener(new c());
                aVar.setView(inflate);
                this.j = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.j.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.j.show();
                this.j.getWindow().setAttributes(layoutParams);
                this.j.setCancelable(false);
                this.j.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        if (!this.G && m7.a.V0.booleanValue() && SharepreferenceDBHandler.getVPNLastUpdate(this.u)) {
            E1();
        }
        this.G = false;
        if (m7.a.e.booleanValue()) {
            N1();
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void u1() {
        int nextInt = new Random().nextInt(8378600) + 10000;
        this.z = nextInt;
        b7.b.b = String.valueOf(nextInt);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r4 != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v1(boolean r4) {
        /*
            r3 = this;
            android.widget.ProgressBar r0 = r3.f
            r1 = 8
            r0.setVisibility(r1)
            java.lang.Boolean r0 = m7.a.e
            boolean r0 = r0.booleanValue()
            r2 = 0
            if (r0 == 0) goto L37
            if (r4 == 0) goto L22
            android.widget.LinearLayout r4 = r3.d
            r4.setVisibility(r1)
        L17:
            androidx.recyclerview.widget.RecyclerView r4 = r3.g
            r4.setVisibility(r2)
            android.widget.RelativeLayout r4 = r3.h
            r4.setVisibility(r2)
            goto L3a
        L22:
            android.widget.LinearLayout r4 = r3.d
            r4.setVisibility(r2)
            android.widget.LinearLayout r4 = r3.d
            r4.requestFocus()
        L2c:
            androidx.recyclerview.widget.RecyclerView r4 = r3.g
            r4.setVisibility(r1)
            android.widget.RelativeLayout r4 = r3.h
            r4.setVisibility(r1)
            goto L3a
        L37:
            if (r4 == 0) goto L2c
            goto L17
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.vpn.activities.ProfileActivity.v1(boolean):void");
    }

    public void x0(String str) {
        H1(str, ".zip");
    }

    public void z(JsonElement jsonElement) {
        try {
            this.H = new HashMap();
            JSONObject jSONObject = new JSONObject(jsonElement.toString());
            jSONObject.getString("result");
            if (jSONObject.getString("vpnstatus").equals("on")) {
                String string = jSONObject.getString("link");
                this.F = string;
                if (!string.isEmpty() && !string.equals("")) {
                    if (jSONObject.has("access")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("access");
                        Iterator keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String str = (String) keys.next();
                            if (jSONObject2.get(str) instanceof JSONObject) {
                                String string2 = ((JSONObject) jSONObject2.get(str)).getString("username");
                                String string3 = ((JSONObject) jSONObject2.get(str)).getString("password");
                                VPNCredentialsPojo vPNCredentialsPojo = new VPNCredentialsPojo();
                                vPNCredentialsPojo.setUsername(string2);
                                vPNCredentialsPojo.setPassword(string3);
                                this.H.put(str, vPNCredentialsPojo);
                            }
                        }
                    }
                    D1();
                    return;
                }
                J7.a aVar = this.t;
                if (aVar != null) {
                    aVar.g();
                    N1();
                }
                SharepreferenceDBHandler.setVPNLastUpdate(false, this.u);
            } else {
                J7.a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.g();
                    N1();
                }
            }
            w.X();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void z0(String str) {
    }
}
