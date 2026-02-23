package com.onesignal;

import D.l;
import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import com.onesignal.F1;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class x {
    public static Class a = NotificationOpenedReceiver.class;
    public static Class b = NotificationDismissReceiver.class;
    public static Resources c;
    public static Context d;
    public static String e;
    public static Integer f;

    public static class b {
        public l.e a;
        public boolean b;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static int A(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (!OSUtils.J(trim)) {
            return 0;
        }
        int w = w(trim);
        if (w != 0) {
            return w;
        }
        try {
            return R.drawable.class.getField(str).getInt((Object) null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int B(JSONObject jSONObject) {
        int A = A(jSONObject.optString("sicon", (String) null));
        return A != 0 ? A : v();
    }

    public static CharSequence C(JSONObject jSONObject) {
        String optString = jSONObject.optString("title", (String) null);
        return optString != null ? optString : p();
    }

    public static void D() {
        f = Integer.valueOf(Build.VERSION.SDK_INT >= 24 ? 2 : 1);
    }

    public static void E() {
        if (OSUtils.H()) {
            throw new s1("Process for showing a notification should never been done on Main Thread!");
        }
    }

    public static boolean F(JSONObject jSONObject) {
        String optString = jSONObject.optString("sound", (String) null);
        return ("null".equals(optString) || "nil".equals(optString)) ? false : true;
    }

    public static void G(l.e eVar) {
        eVar.z(true).o(0).E((Uri) null).H((long[]) null).G((CharSequence) null);
    }

    public static Bitmap H(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int dimension = (int) c.getDimension(17104902);
            int dimension2 = (int) c.getDimension(17104901);
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width <= dimension2 && height <= dimension) {
                return bitmap;
            }
            if (height > width) {
                dimension2 = (int) (dimension * (width / height));
            } else if (width > height) {
                dimension = (int) (dimension2 * (height / width));
            }
            return Bitmap.createScaledBitmap(bitmap, dimension2, dimension, true);
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    public static Integer I(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return Integer.valueOf(new BigInteger(jSONObject.optString(str), 16).intValue());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void J(JSONObject jSONObject, l.e eVar) {
        int e2 = e(jSONObject.optInt("pri", 6));
        eVar.A(e2);
        if (e2 < 0) {
            return;
        }
        int i = 4;
        if (jSONObject.has("ledc") && jSONObject.optInt("led", 1) == 1) {
            try {
                eVar.v(new BigInteger(jSONObject.optString("ledc"), 16).intValue(), 2000, 5000);
                i = 0;
            } catch (Throwable unused) {
            }
        }
        if (jSONObject.optInt("vib", 1) == 1) {
            if (jSONObject.has("vib_pt")) {
                long[] Q = OSUtils.Q(jSONObject);
                if (Q != null) {
                    eVar.H(Q);
                }
            } else {
                i |= 2;
            }
        }
        if (F(jSONObject)) {
            Uri n = OSUtils.n(d, jSONObject.optString("sound", (String) null));
            if (n != null) {
                eVar.E(n);
            } else {
                i |= 1;
            }
        }
        eVar.o(i);
    }

    public static void K(Context context) {
        d = context;
        e = context.getPackageName();
        c = d.getResources();
    }

    public static void L(RemoteViews remoteViews, JSONObject jSONObject, int i, String str, String str2) {
        int b2;
        Integer I = I(jSONObject, str);
        if (I != null) {
            b2 = I.intValue();
        } else {
            int identifier = c.getIdentifier(str2, "color", e);
            if (identifier == 0) {
                return;
            } else {
                b2 = h.b(d, identifier);
            }
        }
        remoteViews.setTextColor(i, b2);
    }

    public static boolean M(V0 v0) {
        Notification h;
        int intValue = v0.a().intValue();
        JSONObject e2 = v0.e();
        String optString = e2.optString("grp", (String) null);
        G g = new G(d);
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList = Q1.c(d);
            if (optString == null && arrayList.size() >= 3) {
                optString = Q1.g();
                Q1.b(d, arrayList);
            }
        }
        b q = q(v0);
        l.e eVar = q.a;
        b(e2, g, eVar, intValue, null);
        try {
            a(e2, eVar);
        } catch (Throwable th) {
            F1.b(F1.v.ERROR, "Could not set background notification image!", th);
        }
        d(v0, eVar);
        if (v0.n()) {
            G(eVar);
        }
        k0.a(d, optString != null ? 2 : 1);
        if (optString != null) {
            g(eVar, g, e2, optString, intValue);
            h = j(v0, eVar);
            if (Build.VERSION.SDK_INT < 24 || !optString.equals(Q1.g())) {
                l(v0, q);
            } else {
                i(v0, g, arrayList.size() + 1);
            }
        } else {
            h = h(eVar, g, e2, intValue);
        }
        c(q, h);
        D.L.d(d).f(intValue, h);
        if (Build.VERSION.SDK_INT >= 26) {
            return Q1.a(d, w.a(h));
        }
        return true;
    }

    public static void N(V0 v0) {
        K(v0.d());
        l(v0, null);
    }

    public static void a(JSONObject jSONObject, l.e eVar) {
        Bitmap bitmap;
        JSONObject jSONObject2;
        String string;
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            F1.a(F1.v.VERBOSE, "Cannot use background images in notifications for device on version: " + i);
            return;
        }
        String optString = jSONObject.optString("bg_img", (String) null);
        if (optString != null) {
            jSONObject2 = new JSONObject(optString);
            bitmap = r(jSONObject2.optString("img", (String) null));
        } else {
            bitmap = null;
            jSONObject2 = null;
        }
        if (bitmap == null) {
            bitmap = s("onesignal_bgimage_default_image");
        }
        if (bitmap != null) {
            RemoteViews remoteViews = new RemoteViews(d.getPackageName(), f2.a);
            remoteViews.setTextViewText(e2.e, C(jSONObject));
            remoteViews.setTextViewText(e2.d, jSONObject.optString("alert"));
            L(remoteViews, jSONObject2, e2.e, "tc", "onesignal_bgimage_notif_title_color");
            L(remoteViews, jSONObject2, e2.d, "bc", "onesignal_bgimage_notif_body_color");
            if (jSONObject2 == null || !jSONObject2.has("img_align")) {
                int identifier = c.getIdentifier("onesignal_bgimage_notif_image_align", "string", e);
                string = identifier != 0 ? c.getString(identifier) : null;
            } else {
                string = jSONObject2.getString("img_align");
            }
            if ("right".equals(string)) {
                remoteViews.setViewPadding(e2.b, -5000, 0, 0, 0);
                remoteViews.setImageViewBitmap(e2.c, bitmap);
                remoteViews.setViewVisibility(e2.c, 0);
                remoteViews.setViewVisibility(e2.a, 2);
            } else {
                remoteViews.setImageViewBitmap(e2.a, bitmap);
            }
            eVar.k(remoteViews);
            eVar.F((l.h) null);
        }
    }

    public static void b(JSONObject jSONObject, G g, l.e eVar, int i, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            if (jSONObject2.has("a")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
                if (jSONObject3.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("actionButtons");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        JSONObject jSONObject4 = new JSONObject(jSONObject.toString());
                        Intent b2 = g.b(i);
                        b2.setAction("" + i2);
                        b2.putExtra("action_button", true);
                        jSONObject4.put("actionId", optJSONObject.optString("id"));
                        b2.putExtra("onesignalData", jSONObject4.toString());
                        if (str != null) {
                            b2.putExtra("summary", str);
                        } else if (jSONObject.has("grp")) {
                            b2.putExtra("grp", jSONObject.optString("grp"));
                        }
                        eVar.a(optJSONObject.has("icon") ? A(optJSONObject.optString("icon")) : 0, optJSONObject.optString("text"), g.a(i, b2));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(b bVar, Notification notification) {
        if (bVar.b) {
            try {
                Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
                Field declaredField = newInstance.getClass().getDeclaredField("customizedIcon");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, Boolean.TRUE);
                Field field = notification.getClass().getField("extraNotification");
                field.setAccessible(true);
                field.set(notification, newInstance);
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(V0 v0, l.e eVar) {
        if (v0.l()) {
            try {
                Field declaredField = l.e.class.getDeclaredField("R");
                declaredField.setAccessible(true);
                Notification notification = (Notification) declaredField.get(eVar);
                v0.s(Integer.valueOf(notification.flags));
                v0.t(notification.sound);
                v0.f().f();
                eVar.d((l.f) null);
                Notification notification2 = (Notification) declaredField.get(eVar);
                Field declaredField2 = l.e.class.getDeclaredField("f");
                declaredField2.setAccessible(true);
                CharSequence charSequence = (CharSequence) declaredField2.get(eVar);
                Field declaredField3 = l.e.class.getDeclaredField("e");
                declaredField3.setAccessible(true);
                CharSequence charSequence2 = (CharSequence) declaredField3.get(eVar);
                v0.u(charSequence);
                v0.x(charSequence2);
                if (v0.n()) {
                    return;
                }
                v0.v(Integer.valueOf(notification2.flags));
                v0.w(notification2.sound);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static int e(int i) {
        if (i > 9) {
            return 2;
        }
        if (i > 7) {
            return 1;
        }
        if (i > 4) {
            return 0;
        }
        return i > 2 ? -1 : -2;
    }

    public static Intent f(int i, G g, JSONObject jSONObject, String str) {
        return g.b(i).putExtra("onesignalData", jSONObject.toString()).putExtra("summary", str);
    }

    public static void g(l.e eVar, G g, JSONObject jSONObject, String str, int i) {
        SecureRandom secureRandom = new SecureRandom();
        eVar.l(g.a(secureRandom.nextInt(), g.b(i).putExtra("onesignalData", jSONObject.toString()).putExtra("grp", str)));
        eVar.p(z(secureRandom.nextInt(), y(i).putExtra("grp", str)));
        eVar.r(str);
        try {
            eVar.s(f.intValue());
        } catch (Throwable unused) {
        }
    }

    public static Notification h(l.e eVar, G g, JSONObject jSONObject, int i) {
        SecureRandom secureRandom = new SecureRandom();
        eVar.l(g.a(secureRandom.nextInt(), g.b(i).putExtra("onesignalData", jSONObject.toString())));
        eVar.p(z(secureRandom.nextInt(), y(i)));
        return eVar.c();
    }

    public static void i(V0 v0, G g, int i) {
        JSONObject e2 = v0.e();
        SecureRandom secureRandom = new SecureRandom();
        String g2 = Q1.g();
        String str = i + " new messages";
        int f2 = Q1.f();
        k(M1.i(d), g2, f2);
        PendingIntent a2 = g.a(secureRandom.nextInt(), f(f2, g, e2, g2));
        PendingIntent z = z(secureRandom.nextInt(), y(0).putExtra("summary", g2));
        l.e eVar = q(v0).a;
        if (v0.i() != null) {
            eVar.E(v0.i());
        }
        if (v0.h() != null) {
            eVar.o(v0.h().intValue());
        }
        eVar.l(a2).p(z).n(p()).m(str).x(i).D(v()).u(u()).z(true).h(false).r(g2).t(true);
        try {
            eVar.s(f.intValue());
        } catch (Throwable unused) {
        }
        l.g gVar = new l.g();
        gVar.i(str);
        eVar.F(gVar);
        D.L.d(d).f(f2, eVar.c());
    }

    public static Notification j(V0 v0, l.e eVar) {
        boolean z = Build.VERSION.SDK_INT < 24 && !v0.n();
        if (z && v0.i() != null && !v0.i().equals(v0.g())) {
            eVar.E((Uri) null);
        }
        Notification c2 = eVar.c();
        if (z) {
            eVar.E(v0.i());
        }
        return c2;
    }

    public static void k(M1 m1, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("android_notification_id", Integer.valueOf(i));
        contentValues.put("group_id", str);
        contentValues.put("is_summary", 1);
        m1.l("notification", null, contentValues);
    }

    public static void l(V0 v0, b bVar) {
        String str;
        JSONObject jSONObject;
        ArrayList arrayList;
        Integer num;
        Notification c2;
        String replace;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "message";
        String str7 = "title";
        String str8 = "is_summary";
        boolean n = v0.n();
        JSONObject e2 = v0.e();
        G g = new G(d);
        Cursor cursor = null;
        String optString = e2.optString("grp", (String) null);
        SecureRandom secureRandom = new SecureRandom();
        PendingIntent z = z(secureRandom.nextInt(), y(0).putExtra("summary", optString));
        M1 i = M1.i(d);
        try {
            String[] strArr = {"android_notification_id", "full_data", "is_summary", "title", "message"};
            String[] strArr2 = {optString};
            if (n) {
                str = "group_id = ? AND dismissed = 0 AND opened = 0";
            } else {
                try {
                    str = "group_id = ? AND dismissed = 0 AND opened = 0 AND android_notification_id <> " + v0.a();
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            try {
                cursor = i.d("notification", strArr, str, strArr2, null, null, "_id DESC");
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            String str9 = "";
            if (cursor.moveToFirst()) {
                arrayList = new ArrayList();
                String str10 = null;
                num = null;
                while (true) {
                    String str11 = str8;
                    if (cursor.getInt(cursor.getColumnIndex(str8)) == 1) {
                        num = Integer.valueOf(cursor.getInt(cursor.getColumnIndex("android_notification_id")));
                        str3 = str6;
                        str4 = str7;
                    } else {
                        String string = cursor.getString(cursor.getColumnIndex(str7));
                        if (string == null) {
                            str2 = "";
                        } else {
                            str2 = string + " ";
                        }
                        str3 = str6;
                        str4 = str7;
                        SpannableString spannableString = new SpannableString(str2 + cursor.getString(cursor.getColumnIndex(str6)));
                        if (str2.length() > 0) {
                            spannableString.setSpan(new StyleSpan(1), 0, str2.length(), 0);
                        }
                        arrayList.add(spannableString);
                        if (str10 == null) {
                            str10 = cursor.getString(cursor.getColumnIndex("full_data"));
                        }
                    }
                    str5 = str10;
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    str10 = str5;
                    str8 = str11;
                    str6 = str3;
                    str7 = str4;
                }
                if (!n || str5 == null) {
                    jSONObject = e2;
                } else {
                    try {
                        jSONObject = new JSONObject(str5);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                jSONObject = e2;
                arrayList = null;
                num = null;
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            if (num == null) {
                int nextInt = secureRandom.nextInt();
                num = Integer.valueOf(nextInt);
                k(i, optString, nextInt);
            }
            PendingIntent a2 = g.a(secureRandom.nextInt(), f(num.intValue(), g, jSONObject, optString));
            if (arrayList == null || ((!n || arrayList.size() <= 1) && (n || arrayList.size() <= 0))) {
                l.e eVar = bVar.a;
                eVar.b.clear();
                b(jSONObject, g, eVar, num.intValue(), optString);
                eVar.l(a2).p(z).z(n).h(false).r(optString).t(true);
                try {
                    eVar.s(f.intValue());
                } catch (Throwable unused) {
                }
                c2 = eVar.c();
                c(bVar, c2);
            } else {
                int size = arrayList.size() + (!n ? 1 : 0);
                String optString2 = jSONObject.optString("grp_msg", (String) null);
                if (optString2 == null) {
                    replace = size + " new messages";
                } else {
                    replace = optString2.replace("$[notif_count]", "" + size);
                }
                l.e eVar2 = q(v0).a;
                if (n) {
                    G(eVar2);
                } else {
                    if (v0.i() != null) {
                        eVar2.E(v0.i());
                    }
                    if (v0.h() != null) {
                        eVar2.o(v0.h().intValue());
                    }
                }
                eVar2.l(a2).p(z).n(p()).m(replace).x(size).D(v()).u(u()).z(n).h(false).r(optString).t(true);
                try {
                    eVar2.s(f.intValue());
                } catch (Throwable unused2) {
                }
                if (!n) {
                    eVar2.G(replace);
                }
                l.g gVar = new l.g();
                if (!n) {
                    String charSequence = v0.k() != null ? v0.k().toString() : null;
                    if (charSequence != null) {
                        str9 = charSequence + " ";
                    }
                    SpannableString spannableString2 = new SpannableString(str9 + v0.c().toString());
                    if (str9.length() > 0) {
                        spannableString2.setSpan(new StyleSpan(1), 0, str9.length(), 0);
                    }
                    gVar.h(spannableString2);
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    gVar.h((SpannableString) it.next());
                }
                gVar.i(replace);
                eVar2.F(gVar);
                c2 = eVar2.c();
            }
            D.L.d(d).f(num.intValue(), c2);
        } catch (Throwable th4) {
            th = th4;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean m(V0 v0) {
        K(v0.d());
        return M(v0);
    }

    public static boolean n(V0 v0) {
        K(v0.d());
        E();
        D();
        return M(v0);
    }

    public static BigInteger o(JSONObject jSONObject) {
        try {
            if (jSONObject.has("bgac")) {
                return new BigInteger(jSONObject.optString("bgac", (String) null), 16);
            }
        } catch (Throwable unused) {
        }
        try {
            String k = OSUtils.k(F1.b, "onesignal_notification_accent_color", null);
            if (k != null) {
                return new BigInteger(k, 16);
            }
        } catch (Throwable unused2) {
        }
        try {
            String f2 = OSUtils.f(F1.b, "com.onesignal.NotificationAccentColor.DEFAULT");
            if (f2 != null) {
                return new BigInteger(f2, 16);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    public static CharSequence p() {
        ApplicationInfo a2 = j.a.a(d);
        return a2 == null ? "" : d.getPackageManager().getApplicationLabel(a2);
    }

    public static b q(V0 v0) {
        l.e eVar;
        JSONObject e2 = v0.e();
        b bVar = new b(null);
        try {
            eVar = new l.e(d, j0.c(v0));
        } catch (Throwable unused) {
            eVar = new l.e(d);
        }
        String optString = e2.optString("alert", (String) null);
        eVar.h(true).D(B(e2)).F(new l.c().h(optString)).m(optString).G(optString);
        if (Build.VERSION.SDK_INT < 24 || !e2.optString("title").equals("")) {
            eVar.n(C(e2));
        }
        try {
            BigInteger o = o(e2);
            if (o != null) {
                eVar.j(o.intValue());
            }
        } catch (Throwable unused2) {
        }
        try {
            eVar.I(e2.has("vis") ? Integer.parseInt(e2.optString("vis")) : 1);
        } catch (Throwable unused3) {
        }
        Bitmap x = x(e2);
        if (x != null) {
            bVar.b = true;
            eVar.u(x);
        }
        Bitmap r = r(e2.optString("bicon", (String) null));
        if (r != null) {
            eVar.F(new l.b().i(r).j(optString));
        }
        if (v0.j() != null) {
            try {
                eVar.J(v0.j().longValue() * 1000);
            } catch (Throwable unused4) {
            }
        }
        J(e2, eVar);
        bVar.a = eVar;
        return bVar;
    }

    public static Bitmap r(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        return (trim.startsWith("http://") || trim.startsWith("https://")) ? t(trim) : s(str);
    }

    public static Bitmap s(String str) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(d.getAssets().open(str));
        } catch (Throwable unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            for (String str2 : Arrays.asList(new String[]{".png", ".webp", ".jpg", ".gif", ".bmp"})) {
                try {
                    bitmap = BitmapFactory.decodeStream(d.getAssets().open(str + str2));
                } catch (Throwable unused2) {
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            int A = A(str);
            if (A != 0) {
                return BitmapFactory.decodeResource(c, A);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    public static Bitmap t(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            F1.b(F1.v.WARN, "Could not download image!", th);
            return null;
        }
    }

    public static Bitmap u() {
        return H(s("ic_onesignal_large_icon_default"));
    }

    public static int v() {
        int w = w("ic_stat_onesignal_default");
        if (w != 0) {
            return w;
        }
        int w2 = w("corona_statusbar_icon_default");
        if (w2 != 0) {
            return w2;
        }
        int w3 = w("ic_os_notification_fallback_white_24dp");
        if (w3 != 0) {
            return w3;
        }
        return 17301598;
    }

    public static int w(String str) {
        return c.getIdentifier(str, "drawable", e);
    }

    public static Bitmap x(JSONObject jSONObject) {
        Bitmap r = r(jSONObject.optString("licon"));
        if (r == null) {
            r = s("ic_onesignal_large_icon_default");
        }
        if (r == null) {
            return null;
        }
        return H(r);
    }

    public static Intent y(int i) {
        return new Intent(d, b).putExtra("androidNotificationId", i).putExtra("dismissed", true);
    }

    public static PendingIntent z(int i, Intent intent) {
        return PendingIntent.getBroadcast(d, i, intent, 201326592);
    }
}
