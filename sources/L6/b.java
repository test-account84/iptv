package l6;

import A5.f;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b {
    public static final String[] c = {"*", "FCM", "GCM", ""};
    public final SharedPreferences a;
    public final String b;

    public b(f fVar) {
        this.a = fVar.l().getSharedPreferences("com.google.android.gms.appid", 0);
        this.b = b(fVar);
    }

    public static String b(f fVar) {
        String d = fVar.p().d();
        if (d != null) {
            return d;
        }
        String c2 = fVar.p().c();
        if (!c2.startsWith("1:") && !c2.startsWith("2:")) {
            return c2;
        }
        String[] split = c2.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String c(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    public final String a(String str, String str2) {
        return "|T|" + str + "|" + str2;
    }

    public final String d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    public final PublicKey e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | InvalidKeySpecException | NoSuchAlgorithmException e) {
            Log.w("ContentValues", "Invalid key stored " + e);
            return null;
        }
    }

    public String f() {
        synchronized (this.a) {
            try {
                String g = g();
                if (g != null) {
                    return g;
                }
                return h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String g() {
        String string;
        synchronized (this.a) {
            string = this.a.getString("|S|id", (String) null);
        }
        return string;
    }

    public final String h() {
        synchronized (this.a) {
            try {
                String string = this.a.getString("|S||P|", (String) null);
                if (string == null) {
                    return null;
                }
                PublicKey e = e(string);
                if (e == null) {
                    return null;
                }
                return c(e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String i() {
        synchronized (this.a) {
            try {
                for (String str : c) {
                    String string = this.a.getString(a(this.b, str), (String) null);
                    if (string != null && !string.isEmpty()) {
                        if (string.startsWith("{")) {
                            string = d(string);
                        }
                        return string;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
