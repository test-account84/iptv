package h8;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Binder;
import de.blinkt.openvpn.api.ConfirmDialog;
import de.blinkt.openvpn.core.B;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b {
    public Context a;

    public b(Context context) {
        this.a = context;
    }

    public void a(String str) {
        Set e = e();
        e.add(str);
        h(e);
    }

    public String b(PackageManager packageManager) {
        for (String str : e()) {
            try {
            } catch (PackageManager.NameNotFoundException unused) {
                g(str);
            }
            if (Binder.getCallingUid() == packageManager.getApplicationInfo(str, 0).uid) {
                return str;
            }
        }
        throw new SecurityException("Unauthorized OpenVPN API Caller");
    }

    public boolean c(Context context, String str) {
        if (str == null) {
            str = "de.blinkt.openvpn.ANYPACKAGE";
        }
        if (f(str)) {
            return true;
        }
        Intent intent = new Intent(context, ConfirmDialog.class);
        intent.addFlags(268435456);
        intent.putExtra("android.intent.extra.PACKAGE_NAME", str);
        context.startActivity(intent);
        return false;
    }

    public void d() {
        h(new HashSet());
    }

    public Set e() {
        return B.a(this.a).getStringSet("allowed_apps", new HashSet());
    }

    public boolean f(String str) {
        return e().contains(str);
    }

    public void g(String str) {
        Set e = e();
        e.remove(str);
        h(e);
    }

    public final void h(Set set) {
        SharedPreferences a = B.a(this.a);
        SharedPreferences.Editor edit = a.edit();
        edit.putStringSet("allowed_apps", set);
        edit.putInt("counter", a.getInt("counter", 0) + 1);
        edit.apply();
    }
}
