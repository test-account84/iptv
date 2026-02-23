package t1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends t1.a {
    public static final Date j;
    public static final Date k;
    public IInAppBillingService b;
    public String c;
    public String d;
    public t1.b e;
    public t1.b f;
    public c g;
    public String h;
    public ServiceConnection i;

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.k(c.this, IInAppBillingService.Stub.asInterface(iBinder));
            new b(c.this, null).execute(new Void[0]);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            c.k(c.this, null);
        }
    }

    public class b extends AsyncTask {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            if (c.h(c.this)) {
                return Boolean.FALSE;
            }
            c.this.q();
            return Boolean.TRUE;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                c.i(c.this);
                if (c.j(c.this) != null) {
                    c.j(c.this).a();
                }
            }
            if (c.j(c.this) != null) {
                c.j(c.this).c();
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    public interface c {
        void a();

        void b(int i, Throwable th);

        void c();
    }

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, 11, 5);
        j = calendar.getTime();
        calendar.set(2015, 6, 21);
        k = calendar.getTime();
    }

    public c(Context context, String str, String str2, c cVar) {
        this(context, str, str2, cVar, true);
    }

    public static /* synthetic */ boolean h(c cVar) {
        return cVar.o();
    }

    public static /* synthetic */ void i(c cVar) {
        cVar.t();
    }

    public static /* synthetic */ c j(c cVar) {
        return cVar.g;
    }

    public static /* synthetic */ IInAppBillingService k(c cVar, IInAppBillingService iInAppBillingService) {
        cVar.b = iInAppBillingService;
        return iInAppBillingService;
    }

    public static Intent m() {
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        return intent;
    }

    public final void l() {
        try {
            a().bindService(m(), this.i, 1);
        } catch (Exception e) {
            Log.e("iabv3", "error in bindPlayServices", e);
            s(113, e);
        }
    }

    public boolean n() {
        return this.b != null;
    }

    public final boolean o() {
        return d(c() + ".products.restored.v2_6", false);
    }

    public boolean p(String str) {
        return this.e.m(str);
    }

    public boolean q() {
        return r("inapp", this.e) && r("subs", this.f);
    }

    public final boolean r(String str, t1.b bVar) {
        if (!n()) {
            return false;
        }
        try {
            Bundle purchases = this.b.getPurchases(3, this.c, str, null);
            if (purchases.getInt("RESPONSE_CODE") == 0) {
                bVar.h();
                ArrayList stringArrayList = purchases.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList2 = purchases.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                if (stringArrayList == null) {
                    return true;
                }
                int i = 0;
                while (i < stringArrayList.size()) {
                    String str2 = (String) stringArrayList.get(i);
                    if (!TextUtils.isEmpty(str2)) {
                        bVar.o(new JSONObject(str2).getString("productId"), str2, (stringArrayList2 == null || stringArrayList2.size() <= i) ? null : (String) stringArrayList2.get(i));
                    }
                    i++;
                }
                return true;
            }
        } catch (Exception e) {
            s(100, e);
            Log.e("iabv3", "Error in loadPurchasesByType", e);
        }
        return false;
    }

    public final void s(int i, Throwable th) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.b(i, th);
        }
    }

    public final void t() {
        f(c() + ".products.restored.v2_6", Boolean.TRUE);
    }

    public c(Context context, String str, String str2, c cVar, boolean z) {
        super(context.getApplicationContext());
        this.i = new a();
        this.d = str;
        this.g = cVar;
        this.c = a().getPackageName();
        this.e = new t1.b(a(), ".products.cache.v2_6");
        this.f = new t1.b(a(), ".subscriptions.cache.v2_6");
        this.h = str2;
        if (z) {
            l();
        }
    }
}
