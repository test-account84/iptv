package com.nst.iptvsmarterstvbox.vpn.activities;

import F7.c;
import F7.e;
import a7.g;
import a7.j;
import a7.k;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import com.google.gson.JsonElement;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.AdsLastUpdateResponseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.getAnnouncementsFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.readAnnouncementFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationinterface.FirebaseInterface;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import j$.util.Objects;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import m7.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ImportVPNActivity extends androidx.appcompat.app.b implements H7.a, FirebaseInterface, View.OnClickListener {
    public static u7.a F;
    public String C;
    public Uri D;
    public FirebasePresenter E;
    public EditText d;
    public Button e;
    public Button f;
    public TextView g;
    public TextView h;
    public RadioButton i;
    public RadioButton j;
    public LinearLayout k;
    public Button l;
    public LinearLayout m;
    public TextView n;
    public TextView o;
    public Context p;
    public androidx.appcompat.app.a q;
    public List y;
    public List z;
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public int v = 1024;
    public String w = "url";
    public String x = "";
    public ArrayList A = null;
    public Thread B = null;

    public class a implements c.a {
        public a() {
        }

        public void a(File file) {
            Log.i("main", "file download completed");
            if (file == null || !file.exists()) {
                Toast.makeText(ImportVPNActivity.u1(ImportVPNActivity.this), ImportVPNActivity.this.getResources().getString(j.a2), 0).show();
                w.X();
            } else {
                ImportVPNActivity importVPNActivity = ImportVPNActivity.this;
                new F7.a(importVPNActivity, file, importVPNActivity).b("IMPORT_URL");
            }
            Log.i("main", "file unzip completed");
        }
    }

    public class b implements e.g {
        public final /* synthetic */ String[] a;

        public b(String[] strArr) {
            this.a = strArr;
        }

        public void a(String str) {
            this.a[0] = str;
            if (!str.endsWith(".zip") && !str.endsWith(".ovpn")) {
                ImportVPNActivity.this.o.setVisibility(8);
                ImportVPNActivity.this.n.setVisibility(0);
                ImportVPNActivity importVPNActivity = ImportVPNActivity.this;
                importVPNActivity.n.setText(importVPNActivity.getResources().getString(j.g2));
                return;
            }
            ImportVPNActivity.this.o.setVisibility(0);
            ImportVPNActivity.this.o.setText(str);
            ImportVPNActivity.v1(ImportVPNActivity.this, str);
            if (!ImportVPNActivity.w1(ImportVPNActivity.this).equals(m7.a.K0) && Build.VERSION.SDK_INT >= 23) {
                ImportVPNActivity.this.H1(str);
            } else {
                ImportVPNActivity.this.I1(str);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                String date = Calendar.getInstance().getTime().toString();
                String R = w.R(ImportVPNActivity.u1(ImportVPNActivity.this));
                String A = w.A(date);
                TextView textView = ImportVPNActivity.this.h;
                if (textView != null) {
                    textView.setText(R);
                }
                TextView textView2 = ImportVPNActivity.this.g;
                if (textView2 != null) {
                    textView2.setText(A);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", ImportVPNActivity.this.getPackageName(), (String) null));
                ImportVPNActivity.this.startActivityForResult(intent, 101);
                Toast.makeText(ImportVPNActivity.u1(ImportVPNActivity.this), ImportVPNActivity.u1(ImportVPNActivity.this).getResources().getString(j.o2), 1).show();
            } catch (Exception unused) {
            }
            ImportVPNActivity.x1(ImportVPNActivity.this).dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            ImportVPNActivity.x1(ImportVPNActivity.this).dismiss();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ImportVPNActivity.this.z1();
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                } catch (InterruptedException unused2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005f A[Catch: Exception -> 0x0038, TryCatch #2 {Exception -> 0x0038, blocks: (B:6:0x000a, B:9:0x0019, B:11:0x0025, B:14:0x005f, B:16:0x006e, B:18:0x0076, B:20:0x007a, B:22:0x0080, B:24:0x0088, B:26:0x0095, B:29:0x00b4, B:31:0x00cf, B:33:0x00d7, B:34:0x00da, B:35:0x00f4, B:41:0x013f, B:50:0x0146, B:51:0x0149, B:55:0x014a, B:61:0x016e, B:57:0x018c, B:65:0x0175, B:66:0x0178, B:67:0x003b, B:69:0x0041, B:71:0x004d, B:73:0x0179, B:60:0x0150), top: B:5:0x000a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void D1(android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.vpn.activities.ImportVPNActivity.D1(android.content.Intent):void");
    }

    public static /* synthetic */ Context u1(ImportVPNActivity importVPNActivity) {
        return importVPNActivity.p;
    }

    public static /* synthetic */ String v1(ImportVPNActivity importVPNActivity, String str) {
        importVPNActivity.x = str;
        return str;
    }

    public static /* synthetic */ String w1(ImportVPNActivity importVPNActivity) {
        return importVPNActivity.C;
    }

    public static /* synthetic */ androidx.appcompat.app.a x1(ImportVPNActivity importVPNActivity) {
        return importVPNActivity.q;
    }

    public final void A1() {
        String str = this.w;
        if (str != null && str.equalsIgnoreCase("url")) {
            B1();
            return;
        }
        try {
            if (!this.C.equals(m7.a.K0) && Build.VERSION.SDK_INT >= 23) {
                Intent intent = new Intent();
                intent.setType("application/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(Intent.createChooser(intent, "Select File"), 201);
            } else {
                y1();
            }
        } catch (Exception unused) {
        }
    }

    public final void B1() {
        File file;
        w.M0(this);
        if (this.C.equals(m7.a.K0)) {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNIPTVSmarters/vpncertificate.zip");
        } else if (Build.VERSION.SDK_INT >= 23) {
            file = new File(this.p.getFilesDir() + "/VPNIPTVSmarters/vpncertificate.zip");
        } else {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNIPTVSmarters/vpncertificate.zip");
        }
        File file2 = new File(String.valueOf(file));
        if (file2.exists()) {
            file2.deleteOnExit();
        }
        new F7.c(String.valueOf(file), this, new a()).execute(new String[]{this.s});
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0244 A[Catch: Exception -> 0x02a1, TryCatch #7 {Exception -> 0x02a1, blocks: (B:116:0x023a, B:118:0x0244, B:119:0x028b, B:121:0x0254, B:123:0x025a, B:124:0x027c), top: B:115:0x023a }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0254 A[Catch: Exception -> 0x02a1, TryCatch #7 {Exception -> 0x02a1, blocks: (B:116:0x023a, B:118:0x0244, B:119:0x028b, B:121:0x0254, B:123:0x025a, B:124:0x027c), top: B:115:0x023a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C1(java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 781
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nst.iptvsmarterstvbox.vpn.activities.ImportVPNActivity.C1(java.lang.String, java.lang.String):void");
    }

    public final void E1(String str, String str2, String str3, File file) {
        L7.a aVar = new L7.a();
        if (str3.contains("auth-user-pass")) {
            aVar.l("1");
        } else {
            aVar.l("0");
        }
        aVar.p("0");
        aVar.v("");
        aVar.u("");
        aVar.r(str2);
        aVar.m(str);
        aVar.t("0");
        aVar.q(String.valueOf(file));
        aVar.s("");
        this.A.add(aVar);
    }

    public final void F1() {
        w.X();
        startActivity(new Intent(this, ProfileActivity.class));
        finish();
    }

    public final void G1() {
        String str = this.w;
        if (str == null || !str.equalsIgnoreCase("url")) {
            String str2 = this.x;
            if (str2 == null || !str2.trim().isEmpty()) {
                if (!this.C.equals(m7.a.K0) && Build.VERSION.SDK_INT >= 23) {
                    H1(this.x);
                    return;
                } else {
                    I1(this.x);
                    return;
                }
            }
        } else {
            String obj = this.d.getText().toString();
            this.s = obj;
            if (obj == null || !obj.isEmpty()) {
                A1();
                return;
            }
        }
        Toast.makeText(this.p, getResources().getString(j.J5), 0).show();
    }

    public void H1(String str) {
        w.N0(this.p);
        Cursor query = this.p.getContentResolver().query(this.D, new String[]{"_display_name", "_size"}, (String) null, (String[]) null, (String) null);
        int columnIndex = query.getColumnIndex("_display_name");
        query.moveToFirst();
        String string = query.getString(columnIndex);
        File file = new File(this.p.getFilesDir() + "/VPNIPTVSmarters");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(this.p.getFilesDir() + "/VPNIPTVSmarters/" + string);
        try {
            InputStream openInputStream = this.p.getContentResolver().openInputStream(this.D);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
            openInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            Log.e("Exception", e2.getMessage());
        }
        File file3 = new File(this.p.getFilesDir() + "/VPNIPTVSmarters/" + string);
        if (file3.exists() && str.contains(".zip")) {
            new F7.b(this, file3, this).b();
        } else if (str.contains(".ovpn")) {
            C1(str, ".ovpn");
        } else {
            Toast.makeText(this.p, getResources().getString(j.Y1), 0).show();
            w.X();
        }
    }

    public void I1(String str) {
        w.N0(this.p);
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNIPTVSmarters");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (file2.exists() && str.contains(".zip")) {
            new F7.b(this, file2, this).b();
        } else if (str.contains(".ovpn")) {
            C1(str, ".ovpn");
        } else {
            Toast.makeText(this.p, getResources().getString(j.Y1), 0).show();
            w.X();
        }
    }

    public void Q0(getAnnouncementsFirebaseCallback getannouncementsfirebasecallback) {
    }

    public void h(AdsLastUpdateResponseCallback adsLastUpdateResponseCallback) {
    }

    public void k0(readAnnouncementFirebaseCallback readannouncementfirebasecallback) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.e*/.onActivityResult(i, i2, intent);
        if (i == 201) {
            D1(intent);
        }
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.Q0) {
            onBackPressed();
        } else if (id == a7.f.d1) {
            G1();
        } else if (id == a7.f.j0) {
            A1();
        }
    }

    public void onCreate(Bundle bundle) {
        this.p = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.p);
        F = aVar;
        String A = aVar.A();
        this.C = A;
        setContentView(A.equals(m7.a.K0) ? g.O : g.N);
        this.d = findViewById(a7.f.Z2);
        this.e = findViewById(a7.f.d1);
        this.f = findViewById(a7.f.Q0);
        this.g = findViewById(a7.f.E2);
        this.h = findViewById(a7.f.gh);
        this.i = findViewById(a7.f.kd);
        this.j = findViewById(a7.f.wd);
        this.k = findViewById(a7.f.Wd);
        this.l = findViewById(a7.f.j0);
        this.m = findViewById(a7.f.Ba);
        this.n = findViewById(a7.f.Nh);
        this.o = findViewById(a7.f.pj);
        this.f.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.E = new FirebasePresenter(this.p, this);
        Thread thread = this.B;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new f());
            this.B = thread2;
            thread2.start();
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.t = intent.getStringExtra("typeid");
        }
        Button button = this.e;
        button.setOnFocusChangeListener(new w.k(button, this));
        Button button2 = this.f;
        button2.setOnFocusChangeListener(new w.k(button2, this));
        Button button3 = this.l;
        button3.setOnFocusChangeListener(new w.k(button3, this));
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        try {
            Thread thread = this.B;
            if (thread == null || !thread.isAlive()) {
                return;
            }
            this.B.interrupt();
        } catch (Exception unused) {
        }
    }

    public void onRadioButtonClicked(View view) {
        TextView textView;
        boolean isChecked = ((RadioButton) view).isChecked();
        if (view.getId() == a7.f.kd) {
            if (!isChecked) {
                return;
            }
            this.w = "file";
            this.m.setVisibility(8);
            this.k.setVisibility(0);
            this.n.setVisibility(8);
            textView = this.o;
        } else {
            if (view.getId() != a7.f.wd || !isChecked) {
                return;
            }
            this.w = "url";
            this.m.setVisibility(0);
            textView = this.k;
        }
        textView.setVisibility(8);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 101) {
            return;
        }
        try {
            if (iArr.length > 0 && iArr[0] == 0 && iArr[1] == 0) {
                A1();
            } else if (Build.VERSION.SDK_INT >= 23 && !G7.b.a(this, strArr[0])) {
                a.a aVar = new a.a(this, k.a);
                View inflate = LayoutInflater.from(this).inflate(g.W3, (ViewGroup) null);
                Button findViewById = inflate.findViewById(a7.f.c1);
                Button findViewById2 = inflate.findViewById(a7.f.U0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this));
                findViewById.setOnClickListener(new d());
                findViewById2.setOnClickListener(new e());
                aVar.setView(inflate);
                this.q = aVar.create();
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                Window window = this.q.getWindow();
                Objects.requireNonNull(window);
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                this.q.show();
                this.q.getWindow().setAttributes(layoutParams);
                this.q.setCancelable(false);
                this.q.show();
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.z0(this.p);
        Thread thread = this.B;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new f());
            this.B = thread2;
            thread2.start();
        }
    }

    public void x0(String str) {
        C1(str, ".zip");
    }

    public void y1() {
        F7.e eVar = new F7.e(this.p, new b(new String[]{""}));
        if (Build.VERSION.SDK_INT >= 30) {
            eVar.v("");
        } else {
            eVar.u("");
        }
    }

    public void z(JsonElement jsonElement) {
    }

    public void z0(String str) {
        w.X();
        Toast.makeText(this.p, "" + str, 0).show();
    }

    public void z1() {
        runOnUiThread(new c());
    }
}
