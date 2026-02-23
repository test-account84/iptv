package de.blinkt.openvpn;

import F7.d;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.nst.iptvsmarterstvbox.model.VPNSingleton;
import com.nst.iptvsmarterstvbox.vpn.activities.ProfileActivity;
import com.skyfishjy.library.RippleBackground;
import de.blinkt.openvpn.core.B;
import de.blinkt.openvpn.core.C;
import de.blinkt.openvpn.core.F;
import de.blinkt.openvpn.core.G;
import de.blinkt.openvpn.core.OpenVPNService;
import de.blinkt.openvpn.core.OpenVPNStatusService;
import de.blinkt.openvpn.core.h;
import de.blinkt.openvpn.core.i;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import m7.w;
import mbanje.kurt.fabbutton.FabButton;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class LaunchVPN extends androidx.appcompat.app.b implements G.e, G.b, View.OnClickListener {
    public static u7.a E;
    public TextView A;
    public RippleBackground B;
    public f8.l d;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public de.blinkt.openvpn.core.h p;
    public F7.d q;
    public Context r;
    public FabButton s;
    public g7.l t;
    public J7.a u;
    public L7.a v;
    public PopupWindow x;
    public LinearLayout y;
    public LinearLayout z;
    public boolean e = false;
    public boolean f = false;
    public FileInputStream w = null;
    public ServiceConnection C = new j();
    public ServiceConnection D = new k();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            LaunchVPN.I1(LaunchVPN.this).dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            LaunchVPN.I1(LaunchVPN.this).dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ L7.a c;
        public final /* synthetic */ String[] d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ EditText f;
        public final /* synthetic */ EditText g;

        public c(String str, L7.a aVar, String[] strArr, String[] strArr2, EditText editText, EditText editText2) {
            this.a = str;
            this.c = aVar;
            this.d = strArr;
            this.e = strArr2;
            this.f = editText;
            this.g = editText2;
        }

        public final boolean a() {
            Context L1;
            Resources resources;
            int i;
            if (this.a.equals("AUTH_FAILED")) {
                this.d[0] = String.valueOf(this.f.getText());
                this.e[0] = String.valueOf(this.g.getText());
                String str = this.d[0];
                if (str != null && str.equals("")) {
                    L1 = LaunchVPN.L1(LaunchVPN.this);
                    resources = LaunchVPN.L1(LaunchVPN.this).getResources();
                    i = a7.j.A1;
                    Toast.makeText(L1, resources.getString(i), 1).show();
                    return false;
                }
                String str2 = this.e[0];
                if (str2 == null || !str2.equals("")) {
                    String str3 = this.d[0];
                    return (str3 == null || this.e[0] == null || str3.equals("") || this.e[0].equals("")) ? false : true;
                }
            } else {
                this.e[0] = String.valueOf(this.g.getText());
                String str4 = this.e[0];
                if (str4 == null || !str4.equals("")) {
                    String str5 = this.e[0];
                    return (str5 == null || str5.equals("")) ? false : true;
                }
            }
            L1 = LaunchVPN.L1(LaunchVPN.this);
            resources = LaunchVPN.L1(LaunchVPN.this).getResources();
            i = a7.j.v1;
            Toast.makeText(L1, resources.getString(i), 1).show();
            return false;
        }

        public void onClick(View view) {
            L7.a aVar;
            String str;
            if (a()) {
                if (this.a.equals("AUTH_FAILED")) {
                    this.c.v(this.d[0]);
                    aVar = this.c;
                    str = this.e[0];
                } else {
                    this.c.v("");
                    aVar = this.c;
                    str = this.e[0];
                }
                aVar.u(str);
                LaunchVPN.J1(LaunchVPN.this).o(this.c);
                LaunchVPN.I1(LaunchVPN.this).dismiss();
                LaunchVPN.x1(LaunchVPN.this, this.c);
                LaunchVPN.this.T1();
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            LaunchVPN.this.finish();
        }
    }

    public class e implements DialogInterface.OnCancelListener {
        public e() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            LaunchVPN.this.finish();
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            LaunchVPN.this.finish();
        }
    }

    public class g implements d.a {
        public g() {
        }

        public void a() {
            LaunchVPN.this.a2();
        }

        public void b(String str) {
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ String a;

        public h(String str) {
            this.a = str;
        }

        public void run() {
            if (this.a.equalsIgnoreCase(LaunchVPN.this.getString(a7.j.t7))) {
                LaunchVPN.z1(LaunchVPN.this);
                LaunchVPN launchVPN = LaunchVPN.this;
                launchVPN.Q1(true, launchVPN.getResources().getString(a7.j.t7));
                LaunchVPN.A1(LaunchVPN.this).setVisibility(0);
            } else {
                if (!this.a.equals("USERPAUSE")) {
                    String str = "AUTH_FAILED";
                    if (!this.a.equals("AUTH_FAILED")) {
                        str = "AUTH_FAILED_PRIVATE_KEY";
                        if (!this.a.equals("AUTH_FAILED_PRIVATE_KEY")) {
                            if (this.a.equalsIgnoreCase("Not running") || this.a.equalsIgnoreCase(LaunchVPN.this.getString(a7.j.w7)) || this.a.equalsIgnoreCase("NOPROCESS")) {
                                LaunchVPN.B1(LaunchVPN.this);
                                LaunchVPN.u1(LaunchVPN.this).c();
                                LaunchVPN.this.Q1(false, "");
                                return;
                            }
                            if (this.a.equalsIgnoreCase("WAIT") || this.a.equalsIgnoreCase("AUTH") || this.a.equalsIgnoreCase("GET_CONFIG") || this.a.equalsIgnoreCase("NONETWORK") || this.a.equalsIgnoreCase("VPN_GENERATE_CONFIG") || this.a.equalsIgnoreCase("RECONNECTING") || this.a.equalsIgnoreCase("RESOLVE") || this.a.equalsIgnoreCase("AUTH_PENDING") || this.a.equalsIgnoreCase("TCP_CONNECT")) {
                                LaunchVPN.B1(LaunchVPN.this);
                                LaunchVPN launchVPN2 = LaunchVPN.this;
                                launchVPN2.Q1(true, launchVPN2.getResources().getString(a7.j.u7));
                                if (LaunchVPN.u1(LaunchVPN.this).a()) {
                                    return;
                                }
                            } else {
                                LaunchVPN.B1(LaunchVPN.this);
                                LaunchVPN launchVPN3 = LaunchVPN.this;
                                launchVPN3.Q1(true, launchVPN3.getResources().getString(a7.j.u7));
                                if (LaunchVPN.u1(LaunchVPN.this).a()) {
                                    return;
                                }
                            }
                            LaunchVPN.u1(LaunchVPN.this).b();
                            return;
                        }
                    }
                    LaunchVPN.B1(LaunchVPN.this);
                    LaunchVPN.u1(LaunchVPN.this).c();
                    LaunchVPN.this.Q1(false, "");
                    LaunchVPN.C1(LaunchVPN.this, str);
                    return;
                }
                LaunchVPN.B1(LaunchVPN.this);
                LaunchVPN launchVPN4 = LaunchVPN.this;
                launchVPN4.Q1(true, launchVPN4.getResources().getString(a7.j.D8));
                if (!LaunchVPN.u1(LaunchVPN.this).a()) {
                    return;
                }
            }
            LaunchVPN.u1(LaunchVPN.this).c();
        }
    }

    public class i implements ServiceConnection {
        public i() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            de.blinkt.openvpn.core.h A = h.a.A(iBinder);
            if (A != null) {
                try {
                    A.a(false);
                } catch (RemoteException e) {
                    G.r(e);
                }
            }
            LaunchVPN.this.unbindService(this);
            if (!LaunchVPN.u1(LaunchVPN.this).a()) {
                LaunchVPN.u1(LaunchVPN.this).b();
            }
            LaunchVPN.v1(LaunchVPN.this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class j implements ServiceConnection {
        public j() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LaunchVPN.D1(LaunchVPN.this, h.a.A(iBinder));
        }

        public void onServiceDisconnected(ComponentName componentName) {
            LaunchVPN.D1(LaunchVPN.this, null);
        }
    }

    public class k implements ServiceConnection {
        public k() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            de.blinkt.openvpn.core.i A = i.a.A(iBinder);
            try {
                if (LaunchVPN.E1(LaunchVPN.this) != null) {
                    A.g0(LaunchVPN.F1(LaunchVPN.this).B(), 3, LaunchVPN.E1(LaunchVPN.this));
                }
                if (LaunchVPN.G1(LaunchVPN.this) != null) {
                    A.g0(LaunchVPN.F1(LaunchVPN.this).B(), 2, LaunchVPN.G1(LaunchVPN.this));
                }
                LaunchVPN.this.onActivityResult(70, -1, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            LaunchVPN.this.unbindService(this);
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        public void onClick(View view) {
            LaunchVPN.I1(LaunchVPN.this).dismiss();
            G.J("USER_VPN_PASSWORD_CANCELLED", "", a7.j.F7, de.blinkt.openvpn.core.e.LEVEL_NOTCONNECTED);
            LaunchVPN.this.finish();
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        public void onClick(View view) {
            LaunchVPN.I1(LaunchVPN.this).dismiss();
            G.J("USER_VPN_PASSWORD_CANCELLED", "", a7.j.F7, de.blinkt.openvpn.core.e.LEVEL_NOTCONNECTED);
            LaunchVPN.this.finish();
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ L7.a a;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ EditText d;

        public n(L7.a aVar, String[] strArr, EditText editText) {
            this.a = aVar;
            this.c = strArr;
            this.d = editText;
        }

        public final boolean a() {
            this.c[0] = String.valueOf(this.d.getText());
            String str = this.c[0];
            if (str == null || !str.equals("")) {
                String str2 = this.c[0];
                return (str2 == null || str2.equals("")) ? false : true;
            }
            Toast.makeText(LaunchVPN.L1(LaunchVPN.this), LaunchVPN.L1(LaunchVPN.this).getResources().getString(a7.j.v1), 1).show();
            return false;
        }

        public void onClick(View view) {
            if (a()) {
                this.a.v("");
                this.a.u(this.c[0]);
                LaunchVPN.J1(LaunchVPN.this).o(this.a);
                LaunchVPN.I1(LaunchVPN.this).dismiss();
                LaunchVPN.H1(LaunchVPN.this, this.c[0]);
                Intent intent = new Intent(LaunchVPN.this, OpenVPNStatusService.class);
                LaunchVPN launchVPN = LaunchVPN.this;
                launchVPN.bindService(intent, LaunchVPN.K1(launchVPN), 1);
            }
        }
    }

    public class o implements View.OnClickListener {
        public final /* synthetic */ String a;

        public o(String str) {
            this.a = str;
        }

        public void onClick(View view) {
            if (LaunchVPN.I1(LaunchVPN.this) != null && LaunchVPN.I1(LaunchVPN.this).isShowing()) {
                LaunchVPN.I1(LaunchVPN.this).dismiss();
            }
            LaunchVPN launchVPN = LaunchVPN.this;
            LaunchVPN.y1(launchVPN, LaunchVPN.w1(launchVPN), this.a);
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        public void onClick(View view) {
            if (LaunchVPN.I1(LaunchVPN.this) == null || !LaunchVPN.I1(LaunchVPN.this).isShowing()) {
                return;
            }
            LaunchVPN.I1(LaunchVPN.this).dismiss();
        }
    }

    public class q implements PopupWindow.OnDismissListener {
        public q() {
        }

        public void onDismiss() {
        }
    }

    public static /* synthetic */ RippleBackground A1(LaunchVPN launchVPN) {
        return launchVPN.B;
    }

    public static /* synthetic */ void B1(LaunchVPN launchVPN) {
        launchVPN.c2();
    }

    public static /* synthetic */ void C1(LaunchVPN launchVPN, String str) {
        launchVPN.W1(str);
    }

    public static /* synthetic */ de.blinkt.openvpn.core.h D1(LaunchVPN launchVPN, de.blinkt.openvpn.core.h hVar) {
        launchVPN.p = hVar;
        return hVar;
    }

    public static /* synthetic */ String E1(LaunchVPN launchVPN) {
        return launchVPN.g;
    }

    public static /* synthetic */ f8.l F1(LaunchVPN launchVPN) {
        return launchVPN.d;
    }

    public static /* synthetic */ String G1(LaunchVPN launchVPN) {
        return launchVPN.h;
    }

    public static /* synthetic */ String H1(LaunchVPN launchVPN, String str) {
        launchVPN.h = str;
        return str;
    }

    public static /* synthetic */ PopupWindow I1(LaunchVPN launchVPN) {
        return launchVPN.x;
    }

    public static /* synthetic */ J7.a J1(LaunchVPN launchVPN) {
        return launchVPN.u;
    }

    public static /* synthetic */ ServiceConnection K1(LaunchVPN launchVPN) {
        return launchVPN.D;
    }

    public static /* synthetic */ Context L1(LaunchVPN launchVPN) {
        return launchVPN.r;
    }

    private void f1() {
        this.r = this;
        FabButton findViewById = findViewById(a7.f.I2);
        this.s = findViewById;
        this.t = new g7.l(findViewById, this);
        this.u = new J7.a(this.r);
    }

    public static /* synthetic */ g7.l u1(LaunchVPN launchVPN) {
        return launchVPN.t;
    }

    public static /* synthetic */ void v1(LaunchVPN launchVPN) {
        launchVPN.V1();
    }

    public static /* synthetic */ L7.a w1(LaunchVPN launchVPN) {
        return launchVPN.v;
    }

    public static /* synthetic */ L7.a x1(LaunchVPN launchVPN, L7.a aVar) {
        launchVPN.v = aVar;
        return aVar;
    }

    public static /* synthetic */ void y1(LaunchVPN launchVPN, L7.a aVar, String str) {
        launchVPN.O1(aVar, str);
    }

    public static /* synthetic */ void z1(LaunchVPN launchVPN) {
        launchVPN.Z1();
    }

    public void E(long j2, long j3, long j4, long j5) {
    }

    public final void M1(int i2) {
        try {
            View inflate = ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(a7.g.f3, this.r.findViewById(a7.f.Sd));
            PopupWindow popupWindow = new PopupWindow(this.r);
            this.x = popupWindow;
            popupWindow.setContentView(inflate);
            this.x.setWidth(-1);
            this.x.setHeight(-1);
            this.x.setFocusable(true);
            this.x.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.C0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this.r));
            }
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this.r));
            }
            inflate.findViewById(a7.f.jk).setText("Need Private Key Password");
            EditText findViewById3 = inflate.findViewById(a7.f.pm);
            findViewById3.setVisibility(8);
            EditText findViewById4 = inflate.findViewById(a7.f.om);
            TextView findViewById5 = inflate.findViewById(a7.f.b3);
            ImageView findViewById6 = inflate.findViewById(a7.f.N4);
            findViewById5.setText(this.r.getResources().getString(a7.j.E8) + " " + this.d.d);
            if (this.r.getSharedPreferences("selected_language", 0).getString("selected_language", "English").equalsIgnoreCase("Arabic")) {
                findViewById3.setGravity(21);
                findViewById4.setGravity(21);
            }
            String[] strArr = {""};
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new l());
            }
            if (findViewById6 != null) {
                findViewById6.setOnClickListener(new m());
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new n(this.v, strArr, findViewById4));
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    public void N1() {
        Intent intent = new Intent(this, OpenVPNService.class);
        intent.setAction("de.blinkt.openvpn.START_SERVICE");
        bindService(intent, new i(), 1);
    }

    public final void O1(L7.a aVar, String str) {
        new L7.a();
        try {
            View inflate = ((LayoutInflater) this.r.getSystemService("layout_inflater")).inflate(a7.g.f3, this.r.findViewById(a7.f.Sd));
            PopupWindow popupWindow = new PopupWindow(this.r);
            this.x = popupWindow;
            popupWindow.setContentView(inflate);
            this.x.setWidth(-1);
            this.x.setHeight(-1);
            this.x.setFocusable(true);
            this.x.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.C0);
            Button findViewById2 = inflate.findViewById(a7.f.o0);
            if (findViewById != null) {
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this.r));
            }
            if (findViewById2 != null) {
                findViewById2.setOnFocusChangeListener(new w.k(findViewById2, this.r));
            }
            EditText findViewById3 = inflate.findViewById(a7.f.pm);
            EditText findViewById4 = inflate.findViewById(a7.f.om);
            TextView findViewById5 = inflate.findViewById(a7.f.b3);
            ImageView findViewById6 = inflate.findViewById(a7.f.N4);
            if (str.equals("AUTH_FAILED")) {
                findViewById3.setVisibility(0);
            } else if (str.equals("AUTH_FAILED_PRIVATE_KEY")) {
                findViewById3.setVisibility(8);
            }
            findViewById3.setText(aVar.i());
            findViewById4.setText(aVar.h());
            findViewById5.setText(this.r.getResources().getString(a7.j.E8) + " " + aVar.e());
            if (this.r.getSharedPreferences("selected_language", 0).getString("selected_language", "English").equalsIgnoreCase("Arabic")) {
                findViewById3.setGravity(21);
                findViewById4.setGravity(21);
            }
            String[] strArr = {""};
            String[] strArr2 = {""};
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new a());
            }
            if (findViewById6 != null) {
                findViewById6.setOnClickListener(new b());
            }
            if (findViewById != null) {
                findViewById.setOnClickListener(new c(str, aVar, strArr, strArr2, findViewById3, findViewById4));
            }
        } catch (NullPointerException | Exception unused) {
        }
    }

    public final void P1(String str) {
        try {
            if (new ProcessBuilder(new String[]{"su", "-c", str}).start().waitFor() == 0) {
                this.f = true;
            }
        } catch (InterruptedException | IOException e2) {
            G.s("SU command", e2);
        }
    }

    public void Q1(boolean z, String str) {
        if (!z) {
            this.z.setVisibility(8);
            this.y.setVisibility(0);
        } else {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.A.setText(str);
        }
    }

    public final void R1() {
        if (!G.k()) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            if (!this.t.a()) {
                this.t.b();
            }
            V1();
            return;
        }
        C.s(this.r);
        de.blinkt.openvpn.core.h hVar = this.p;
        if (hVar != null) {
            try {
                hVar.a(false);
            } catch (RemoteException e2) {
                G.r(e2);
            }
        }
    }

    public void S1() {
        int c2 = this.d.c(this);
        if (c2 != a7.j.j4) {
            X1(c2);
            return;
        }
        Intent prepare = VpnService.prepare(this);
        SharedPreferences a2 = B.a(this);
        boolean z = a2.getBoolean("useCM9Fix", false);
        if (a2.getBoolean("loadTunModule", false)) {
            P1("insmod /system/lib/modules/tun.ko");
        }
        if (z && !this.f) {
            P1("chown system /dev/tun");
        }
        if (prepare == null) {
            onActivityResult(70, -1, null);
            return;
        }
        G.J("USER_VPN_PERMISSION", "", a7.j.G7, de.blinkt.openvpn.core.e.LEVEL_WAITING_FOR_USER_INPUT);
        try {
            startActivityForResult(prepare, 70);
        } catch (ActivityNotFoundException unused) {
            G.n(a7.j.F4);
        }
    }

    public void T1() {
        L7.a aVar;
        if (!G.k()) {
            if (!this.t.a()) {
                this.t.b();
            }
            V1();
            return;
        }
        f8.l i2 = C.i();
        if (i2 == null || i2.d == null || (aVar = this.v) == null || aVar.e() == null || i2.d.equals(this.v.e())) {
            return;
        }
        C.s(this.r);
        N1();
    }

    public final void U1(AlertDialog.Builder builder) {
        builder.setOnDismissListener(new f());
    }

    public final void V1() {
        L7.a aVar = this.v;
        if (aVar != null) {
            this.n = aVar.i();
            this.m = this.v.h();
            this.k = this.v.e();
            this.l = this.v.d();
            this.o = this.v.c();
            this.w = null;
            try {
                this.w = new FileInputStream(this.l);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            if (this.w != null) {
                FileInputStream fileInputStream = this.w;
                String str = this.k;
                F7.d dVar = new F7.d(this, fileInputStream, str, this.l, str, new g());
                this.q = dVar;
                dVar.execute(new Void[0]);
                return;
            }
            Toast.makeText(this.r, this.k + " profile not found.", 0).show();
            c2();
            this.t.c();
            Q1(false, "");
        }
    }

    public final void W1(String str) {
        String str2;
        try {
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(a7.g.N4, findViewById(a7.f.We));
            PopupWindow popupWindow = new PopupWindow(this);
            this.x = popupWindow;
            popupWindow.setContentView(inflate);
            this.x.setWidth(-1);
            this.x.setHeight(-1);
            this.x.setFocusable(true);
            this.x.showAtLocation(inflate, 17, 0, 0);
            Button findViewById = inflate.findViewById(a7.f.i1);
            TextView findViewById2 = inflate.findViewById(a7.f.nk);
            if (!str.equals("AUTH_FAILED")) {
                str2 = str.equals("AUTH_FAILED_PRIVATE_KEY") ? "Authenticate failed ! Invalid private key password" : "Authenticate failed ! Invalid Username or password";
                Button findViewById3 = inflate.findViewById(a7.f.Z0);
                findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
                findViewById3.setOnFocusChangeListener(new w.k(findViewById3, this));
                findViewById3.setOnClickListener(new o(str));
                findViewById.setOnClickListener(new p());
                this.x.setOnDismissListener(new q());
            }
            findViewById2.setText(str2);
            Button findViewById32 = inflate.findViewById(a7.f.Z0);
            findViewById.setOnFocusChangeListener(new w.k(findViewById, this));
            findViewById32.setOnFocusChangeListener(new w.k(findViewById32, this));
            findViewById32.setOnClickListener(new o(str));
            findViewById.setOnClickListener(new p());
            this.x.setOnDismissListener(new q());
        } catch (Exception unused) {
        }
    }

    public void X1(int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(a7.j.r0);
        builder.setMessage(i2);
        builder.setPositiveButton(17039370, new d());
        builder.setOnCancelListener(new e());
        if (Build.VERSION.SDK_INT >= 22) {
            U1(builder);
        }
        builder.show();
    }

    public final void Y1() {
        this.t.c();
        c2();
        Q1(false, "");
    }

    public void Z(String str) {
    }

    public final void Z1() {
        this.B.e();
    }

    public void a2() {
        try {
            b2(C.g(this).j(this.k));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b2(f8.l lVar) {
        m7.a.h0 = this.n;
        m7.a.g0 = this.m;
        m7.a.e0 = this.o;
        String str = this.k;
        if (str != null && str.contains(".ovpn")) {
            this.k = this.k.replaceAll(".ovpn", "");
        }
        m7.a.f0 = this.k;
        m7.a.i0 = this.l;
        m7.a.e0 = this.o;
        if (B.a(this).getBoolean("clearlogconnect", true)) {
            G.d();
        }
        f8.l c2 = C.c(this, lVar.A().toString());
        if (c2 == null) {
            G.n(a7.j.Y6);
            return;
        }
        this.d = c2;
        this.i = this.n;
        this.j = this.m;
        S1();
    }

    public void c0(String str, String str2, int i2, de.blinkt.openvpn.core.e eVar, Intent intent) {
        runOnUiThread(new h(str));
    }

    public final void c2() {
        this.B.f();
        this.B.clearAnimation();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Intent intent2;
        super/*androidx.fragment.app.e*/.onActivityResult(i2, i3, intent);
        if (i2 == 70) {
            if (i3 != -1) {
                if (i3 == 0) {
                    G.J("USER_VPN_PERMISSION_CANCELLED", "", a7.j.H7, de.blinkt.openvpn.core.e.LEVEL_NOTCONNECTED);
                    if (Build.VERSION.SDK_INT >= 24) {
                        G.n(a7.j.J4);
                    }
                    Y1();
                    return;
                }
                return;
            }
            f8.l lVar = this.d;
            if (lVar != null) {
                int H = lVar.H(this.h, this.g);
                if (H == 0) {
                    G.J("USER_VPN_PASSWORD", "", a7.j.E7, de.blinkt.openvpn.core.e.LEVEL_WAITING_FOR_USER_INPUT);
                    f8.l lVar2 = this.d;
                    lVar2.B = this.i;
                    String str = this.j;
                    lVar2.A = str;
                    this.g = str;
                    B.a(this);
                    C.u(this, this.d);
                    F.f(this.d, getBaseContext());
                    return;
                }
                if (H == a7.j.G5) {
                    G.J("USER_VPN_PASSWORD", "", a7.j.E7, de.blinkt.openvpn.core.e.LEVEL_WAITING_FOR_USER_INPUT);
                    if (this.j.equals("")) {
                        this.d.B = "";
                        M1(H);
                        return;
                    } else {
                        this.d.B = "";
                        this.h = this.j;
                        intent2 = new Intent(this, OpenVPNStatusService.class);
                    }
                } else {
                    G.J("USER_VPN_PASSWORD", "", a7.j.E7, de.blinkt.openvpn.core.e.LEVEL_WAITING_FOR_USER_INPUT);
                    f8.l lVar3 = this.d;
                    lVar3.B = this.i;
                    String str2 = this.j;
                    lVar3.A = str2;
                    this.g = str2;
                    intent2 = new Intent(this, OpenVPNStatusService.class);
                }
                bindService(intent2, this.D, 1);
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a7.f.yh || id == a7.f.L8 || id == a7.f.v4) {
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (id == M8.c.a || id == M8.c.b || id == a7.f.I2) {
            R1();
        }
    }

    public void onCreate(Bundle bundle) {
        this.r = this;
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        u7.a aVar = new u7.a(this.r);
        E = aVar;
        setContentView(aVar.A().equals(m7.a.K0) ? a7.g.G1 : a7.g.F1);
        w.Y(this);
        this.y = findViewById(a7.f.pa);
        this.z = findViewById(a7.f.ja);
        this.A = findViewById(a7.f.hm);
        this.B = findViewById(a7.f.Ld);
        findViewById(a7.f.I2).setOnClickListener(this);
        findViewById(a7.f.yh).setOnClickListener(this);
        findViewById(a7.f.L8).setOnClickListener(this);
        findViewById(a7.f.v4).setOnClickListener(this);
        f1();
        Intent intent = getIntent();
        if (this.v == null) {
            L7.a aVar2 = (L7.a) intent.getSerializableExtra("vpnProfile");
            this.v = aVar2;
            if (aVar2 == null) {
                this.v = VPNSingleton.getInstance().getProfileData();
            }
            VPNSingleton.getInstance().setProfileData(this.v);
        }
        T1();
        try {
            overridePendingTransition(a7.b.f, a7.b.d);
        } catch (Exception unused) {
        }
    }

    public void onPause() {
        super/*androidx.fragment.app.e*/.onPause();
        ServiceConnection serviceConnection = this.C;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.e*/.onResume();
        w.z0(this.r);
        G.c(this);
        G.a(this);
        Intent intent = new Intent(this, OpenVPNService.class);
        intent.setAction("de.blinkt.openvpn.START_SERVICE");
        bindService(intent, this.C, 1);
    }

    public void onStop() {
        G.E(this);
        G.C(this);
        super.onStop();
    }
}
