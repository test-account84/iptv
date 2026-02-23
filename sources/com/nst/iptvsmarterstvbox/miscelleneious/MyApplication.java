package com.nst.iptvsmarterstvbox.miscelleneious;

import A5.f;
import G5.u;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.amazonaws.amplify.generated.graphql.GetSmartersNewQuery;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.AppSyncQueryCall;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;
import com.nst.iptvsmarterstvbox.model.FavouriteDBModel;
import com.nst.iptvsmarterstvbox.model.FavouriteM3UModel;
import com.nst.iptvsmarterstvbox.model.database.SharepreferenceDBHandler;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationcallBack.AddDeviceFirebaseCallback;
import com.nst.iptvsmarterstvbox.sbpfunction.pushnotificationpresenter.FirebasePresenter;
import g7.g;
import g7.h;
import g7.k;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.Executors;
import m7.j;
import m7.w;
import u1.c;
import v1.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MyApplication extends Application {
    public static Context g;
    public static u h;
    public static MyApplication i;
    public static Activity j;
    public static ArrayList k = new ArrayList();
    public AWSAppSyncClient a;
    public d d;
    public j f;
    public BroadcastReceiver c = new a();
    public final c.a e = new c();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null) {
                return;
            }
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("notification")) {
                if (intent.hasExtra("noti_announcements")) {
                    com.nst.iptvsmarterstvbox.miscelleneious.a.l();
                    return;
                }
                if (intent.hasExtra("notification_popup")) {
                    String stringExtra = intent.getStringExtra("notification_popup");
                    if (stringExtra == null || !stringExtra.equalsIgnoreCase("firebase")) {
                        com.nst.iptvsmarterstvbox.miscelleneious.a.n("local");
                        return;
                    } else {
                        com.nst.iptvsmarterstvbox.miscelleneious.a.n("firebase");
                        return;
                    }
                }
                if (intent.hasExtra("app_version")) {
                    com.nst.iptvsmarterstvbox.miscelleneious.a.p();
                } else if (intent.hasExtra("sbp_maintenance_mode")) {
                    com.nst.iptvsmarterstvbox.miscelleneious.a.o();
                } else if (intent.hasExtra("sbp_panel_ads")) {
                    com.nst.iptvsmarterstvbox.miscelleneious.a.d();
                }
            }
        }
    }

    public class b implements OnCompleteListener {
        public final /* synthetic */ FirebaseAuth a;

        public b(FirebaseAuth firebaseAuth) {
            this.a = firebaseAuth;
        }

        public void onComplete(Task task) {
            if (task.isSuccessful()) {
                MyApplication.g(this.a.c());
                return;
            }
            Log.d("jaskirat", task.isCanceled() ? "signInAnonymously:canceled" : "signInAnonymously:failed");
            if (task.getException() != null) {
                Log.e("jaskirat", "Exception: ", task.getException());
            }
        }
    }

    public class c extends c.a {
        public c() {
        }

        public void onFailure(B1.b bVar) {
            if (MyApplication.i(MyApplication.this) != null) {
                MyApplication.i(MyApplication.this).a("100");
            }
        }

        public void onResponse(i iVar) {
            d i;
            String str;
            if (m7.a.o.booleanValue()) {
                try {
                    if (iVar.b() == null || ((GetSmartersNewQuery.Data) iVar.b()).equals("")) {
                        MyApplication.this.C("response null");
                        if (MyApplication.i(MyApplication.this) != null) {
                            MyApplication.i(MyApplication.this).a("101");
                            return;
                        }
                        return;
                    }
                    if (((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew() == null) {
                        if (MyApplication.i(MyApplication.this) != null) {
                            MyApplication.i(MyApplication.this).a("103");
                            return;
                        }
                        return;
                    }
                    if (((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config6() == null || ((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config2() == null || ((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config3() == null) {
                        if (MyApplication.i(MyApplication.this) == null) {
                            return;
                        }
                        i = MyApplication.i(MyApplication.this);
                        str = "104";
                    } else {
                        if (!((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config3().isEmpty() && !((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config6().isEmpty() && !((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config2().isEmpty()) {
                            m7.a.R0 = ((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config6();
                            m7.a.S0 = ((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config2();
                            m7.a.T0 = ((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config3();
                            MyApplication.this.C(m7.a.R0);
                            MyApplication.this.C(m7.a.S0);
                            MyApplication.this.C(m7.a.T0);
                            SharepreferenceDBHandler.setDemoAWSCredentials(MyApplication.h(), m7.a.R0, m7.a.S0, m7.a.T0);
                            if (MyApplication.i(MyApplication.this) != null) {
                                MyApplication.i(MyApplication.this).onSuccess();
                                return;
                            }
                            return;
                        }
                        if (MyApplication.i(MyApplication.this) == null) {
                            return;
                        }
                        i = MyApplication.i(MyApplication.this);
                        str = "105";
                    }
                    i.a(str);
                    return;
                } catch (Exception unused) {
                    if (MyApplication.i(MyApplication.this) == null) {
                        return;
                    }
                }
            } else {
                try {
                    if (iVar.b() == null || ((GetSmartersNewQuery.Data) iVar.b()).equals("")) {
                        if (MyApplication.i(MyApplication.this) != null) {
                            MyApplication.i(MyApplication.this).b("101");
                            return;
                        }
                        return;
                    }
                    if (((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew() != null) {
                        if (((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config1() == null || ((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config1().isEmpty()) {
                            if (MyApplication.i(MyApplication.this) != null) {
                                MyApplication.i(MyApplication.this).b("106");
                                return;
                            }
                            return;
                        }
                        String config1 = ((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config1();
                        m7.a.P0 = config1;
                        MyApplication.this.C(config1);
                        SharepreferenceDBHandler.setClientSecurityCred(MyApplication.h(), m7.a.P0);
                        if (((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config3() != null && !((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config3().isEmpty()) {
                            String config3 = ((GetSmartersNewQuery.Data) iVar.b()).getSmartersNew().config3();
                            m7.a.R0 = config3;
                            MyApplication.this.C(config3);
                            SharepreferenceDBHandler.setSBPBaseCredentials(MyApplication.h(), m7.a.R0);
                        } else if (MyApplication.i(MyApplication.this) != null) {
                            MyApplication.i(MyApplication.this).b("107");
                        }
                        if (MyApplication.i(MyApplication.this) != null) {
                            MyApplication.i(MyApplication.this).onSuccess();
                        }
                    } else if (MyApplication.i(MyApplication.this) != null) {
                        MyApplication.i(MyApplication.this).b("103");
                    }
                    MyApplication.this.C(m7.a.R0);
                    return;
                } catch (Exception unused2) {
                    if (MyApplication.i(MyApplication.this) == null) {
                        return;
                    }
                }
            }
            MyApplication.i(MyApplication.this).a("102");
        }
    }

    public interface d {
        void a(String str);

        void b(String str);

        void onSuccess();
    }

    public static void E(String str) {
    }

    public static void F(String str) {
    }

    public static /* synthetic */ void a(MyApplication myApplication) {
        myApplication.w();
    }

    public static /* synthetic */ void b(MyApplication myApplication, Context context, boolean z, Task task) {
        myApplication.u(context, z, task);
    }

    public static /* synthetic */ void c(AddDeviceFirebaseCallback addDeviceFirebaseCallback) {
        t(addDeviceFirebaseCallback);
    }

    public static /* synthetic */ void d(MyApplication myApplication) {
        myApplication.x();
    }

    public static /* synthetic */ void e(Activity activity) {
        v(activity);
    }

    public static /* synthetic */ u g(u uVar) {
        h = uVar;
        return uVar;
    }

    public static /* synthetic */ Context h() {
        return g;
    }

    public static /* synthetic */ d i(MyApplication myApplication) {
        return myApplication.d;
    }

    public static String j(Activity activity) {
        try {
            return activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c2 : charArray) {
            if (z && Character.isLetter(c2)) {
                sb.append(Character.toUpperCase(c2));
                z = false;
            } else {
                if (Character.isWhitespace(c2)) {
                    z = true;
                }
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public static String l() {
        return Build.VERSION.RELEASE + " " + Build.VERSION_CODES.class.getFields()[Build.VERSION.SDK_INT].getName();
    }

    public static Context m() {
        return g;
    }

    public static String n() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return k(str2);
        }
        return k(str) + " " + str2;
    }

    public static MyApplication p() {
        if (i == null) {
            i = new MyApplication();
        }
        return i;
    }

    public static ArrayList r(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FavouriteDBModel favouriteDBModel = (FavouriteDBModel) it.next();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    arrayList3.add(favouriteDBModel);
                    break;
                }
                String str = (String) it2.next();
                if (favouriteDBModel.getCategoryID() == null || !favouriteDBModel.getCategoryID().equals(str)) {
                }
            }
        }
        return arrayList3;
    }

    public static ArrayList s(ArrayList arrayList, ArrayList arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        if (arrayList == null) {
            return null;
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                FavouriteM3UModel favouriteM3UModel = (FavouriteM3UModel) it.next();
                if (arrayList2 != null) {
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            arrayList3.add(favouriteM3UModel);
                            break;
                        }
                        if (favouriteM3UModel.getCategoryID().equals((String) it2.next())) {
                            break;
                        }
                    }
                }
            }
            return arrayList3;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ void t(AddDeviceFirebaseCallback addDeviceFirebaseCallback) {
    }

    public static /* synthetic */ void v(Activity activity) {
        j = activity;
    }

    public static String z(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final void w() {
        AppSyncQueryCall responseFetcher;
        c.a aVar;
        try {
            if (this.a != null) {
                if (m7.a.o.booleanValue()) {
                    responseFetcher = this.a.query(GetSmartersNewQuery.builder().id("874673642923694wrong").build()).responseFetcher(AppSyncResponseFetchers.NETWORK_ONLY);
                    aVar = this.e;
                } else {
                    responseFetcher = this.a.query(GetSmartersNewQuery.builder().id("874673642923694555wrong").build()).responseFetcher(AppSyncResponseFetchers.NETWORK_ONLY);
                    aVar = this.e;
                }
                responseFetcher.enqueue(aVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void B() {
        if (!m7.a.o.booleanValue()) {
            if (SharepreferenceDBHandler.getSBPDemoAndClientUrl(g) == null || SharepreferenceDBHandler.getSBPDemoAndClientUrl(g).length() <= 0) {
                return;
            }
            m7.a.R0 = SharepreferenceDBHandler.getSBPDemoAndClientUrl(g);
            return;
        }
        if (SharepreferenceDBHandler.getSBPDemoAndClientUrl(g) == null || SharepreferenceDBHandler.getDemoUsername(g) == null || SharepreferenceDBHandler.getDemoPassword(g) == null) {
            return;
        }
        if (SharepreferenceDBHandler.getSBPDemoAndClientUrl(g).length() > 0) {
            m7.a.R0 = SharepreferenceDBHandler.getSBPDemoAndClientUrl(g);
        }
        if (SharepreferenceDBHandler.getDemoUsername(g).length() > 0) {
            m7.a.S0 = SharepreferenceDBHandler.getDemoUsername(g);
        }
        if (SharepreferenceDBHandler.getDemoPassword(g).length() > 0) {
            m7.a.T0 = SharepreferenceDBHandler.getDemoPassword(g);
        }
    }

    public void C(String str) {
    }

    public void D(String str, Context context) {
        if (context != null) {
            Toast.makeText(context, "Something went wrong, Please try again" + str, 0).show();
        }
    }

    public void G(Context context, d dVar) {
        this.d = dVar;
        this.a = AWSAppSyncClient.builder().context(context).awsConfiguration(new AWSConfiguration(context)).build();
        Executors.newSingleThreadExecutor().execute(new g7.i(this));
    }

    public void H(String str, int i2, String str2, boolean z, String str3) {
        if (this.f != null) {
            this.f = null;
        }
        j jVar = new j(str, i2, str2, z, str3);
        this.f = jVar;
        jVar.P(new h(this));
    }

    public void I() {
        E("recordingChannelTask: " + this.f);
        j jVar = this.f;
        if (jVar != null) {
            jVar.T();
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        v0.a.l(this);
    }

    public void f(boolean z, Context context) {
        if (context != null) {
            try {
                if (w.o(context) && SharepreferenceDBHandler.getFirebaseToken(context) != null && SharepreferenceDBHandler.getFirebaseToken(context).length() == 0) {
                    FirebaseMessaging.f().i().addOnCompleteListener(new g7.j(this, context, z));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public CharSequence o(String str) {
        return Build.VERSION.SDK_INT >= 24 ? com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications.a.a(str, 0) : str;
    }

    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        g = applicationContext;
        f.s(applicationContext);
        B();
        SharepreferenceDBHandler.setLocalDb(g, false);
        com.nst.iptvsmarterstvbox.miscelleneious.a.j(g, this, new g());
        if (m7.a.V0.booleanValue()) {
            SharepreferenceDBHandler.setShowPopup(g, true);
            y();
            p0.a.b(this).c(this.c, new IntentFilter("notification"));
        }
    }

    public void q() {
        b7.b.b = String.valueOf(new Random().nextInt(8378600) + 10000);
    }

    public final /* synthetic */ void u(Context context, boolean z, Task task) {
        StringBuilder sb;
        if (!task.isSuccessful()) {
            Log.w("Firebase Token<<<>>>", "Fetching FCM registration token failed", task.getException());
            return;
        }
        String F = w.F(context);
        Log.e("Dashboard", F);
        String str = (String) task.getResult();
        m7.a.U0 = str;
        E("Firebase Token<<<>>>" + str);
        if (str == null || str.length() <= 0) {
            return;
        }
        if (str.length() > 10) {
            sb = new StringBuilder();
            sb.append(F);
            sb.append(str.substring(0, 9));
        } else {
            sb = new StringBuilder();
            sb.append(F);
            sb.append(str);
        }
        String sb2 = sb.toString();
        Log.e("tokenBreak", sb2);
        if (context == null || SharepreferenceDBHandler.getFirebaseToken(context) == null || SharepreferenceDBHandler.getFirebaseToken(context).length() != 0) {
            return;
        }
        String format = new SimpleDateFormat("yyyy-MM").format(new Date());
        q();
        new FirebasePresenter(g, new k()).g(m7.a.S0, m7.a.T0, format, w.o0(m7.a.S0 + "*Njh0&$@HAH828283636JSJSHS*" + b7.b.b + "*" + format), str, sb2, z);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Firebase Token<<<>>>");
        sb3.append(str);
        E(sb3.toString());
    }

    public final /* synthetic */ void x() {
        this.f = null;
    }

    public final void y() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.i().addOnCompleteListener(new b(firebaseAuth));
    }
}
