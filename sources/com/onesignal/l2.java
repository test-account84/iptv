package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.android.vending.billing.IInAppBillingService;
import com.onesignal.F1;
import com.onesignal.T1;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class l2 {
    public static int i = -99;
    public static Class j;
    public ServiceConnection a;
    public Object b;
    public Method c;
    public Method d;
    public Context e;
    public boolean g;
    public boolean h = false;
    public ArrayList f = new ArrayList();

    public class a implements ServiceConnection {
        public a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                int i = IInAppBillingService.Stub.a;
                Method h = l2.h(IInAppBillingService.Stub.class);
                h.setAccessible(true);
                l2.f(l2.this, h.invoke((Object) null, new Object[]{iBinder}));
                l2.i(l2.this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            l2.c(-99);
            l2.f(l2.this, null);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            l2.j(l2.this, true);
            try {
                if (l2.k(l2.this) == null) {
                    l2.l(l2.this, l2.n(l2.m()));
                    l2.k(l2.this).setAccessible(true);
                }
                Bundle bundle = (Bundle) l2.k(l2.this).invoke(l2.d(l2.this), new Object[]{3, l2.o(l2.this).getPackageName(), "inapp", null});
                if (bundle.getInt("RESPONSE_CODE") == 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    for (int i = 0; i < stringArrayList2.size(); i++) {
                        String str = (String) stringArrayList2.get(i);
                        String str2 = (String) stringArrayList.get(i);
                        String string = new JSONObject(str).getString("purchaseToken");
                        if (!l2.p(l2.this).contains(string) && !arrayList2.contains(string)) {
                            arrayList2.add(string);
                            arrayList.add(str2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        l2.e(l2.this, arrayList, arrayList2);
                    } else if (stringArrayList2.size() == 0) {
                        l2.g(l2.this, false);
                        R1.j("GTPlayerPurchases", "ExistingPurchases", false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            l2.j(l2.this, false);
        }
    }

    public class c extends T1.g {
        public final /* synthetic */ ArrayList a;

        public c(ArrayList arrayList) {
            this.a = arrayList;
        }

        public void b(String str) {
            l2.p(l2.this).addAll(this.a);
            R1.m("GTPlayerPurchases", "purchaseTokens", l2.p(l2.this).toString());
            R1.j("GTPlayerPurchases", "ExistingPurchases", true);
            l2.g(l2.this, false);
            l2.j(l2.this, false);
        }
    }

    public l2(Context context) {
        this.g = true;
        this.e = context;
        try {
            JSONArray jSONArray = new JSONArray(R1.f("GTPlayerPurchases", "purchaseTokens", "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.f.add(jSONArray.get(i2).toString());
            }
            boolean z = jSONArray.length() == 0;
            this.g = z;
            if (z) {
                this.g = R1.b("GTPlayerPurchases", "ExistingPurchases", true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        u();
    }

    public static boolean a(Context context) {
        if (i == -99) {
            i = context.checkCallingOrSelfPermission("com.android.vending.BILLING");
        }
        try {
            int i2 = i;
            if (i2 == 0) {
                j = IInAppBillingService.class;
            }
            return i2 == 0;
        } catch (Throwable unused) {
            i = 0;
            return false;
        }
    }

    public static /* synthetic */ int c(int i2) {
        i = i2;
        return i2;
    }

    public static /* synthetic */ Object d(l2 l2Var) {
        return l2Var.b;
    }

    public static /* synthetic */ void e(l2 l2Var, ArrayList arrayList, ArrayList arrayList2) {
        l2Var.t(arrayList, arrayList2);
    }

    public static /* synthetic */ Object f(l2 l2Var, Object obj) {
        l2Var.b = obj;
        return obj;
    }

    public static /* synthetic */ boolean g(l2 l2Var, boolean z) {
        l2Var.g = z;
        return z;
    }

    public static /* synthetic */ Method h(Class cls) {
        return q(cls);
    }

    public static /* synthetic */ void i(l2 l2Var) {
        l2Var.b();
    }

    public static /* synthetic */ boolean j(l2 l2Var, boolean z) {
        l2Var.h = z;
        return z;
    }

    public static /* synthetic */ Method k(l2 l2Var) {
        return l2Var.c;
    }

    public static /* synthetic */ Method l(l2 l2Var, Method method) {
        l2Var.c = method;
        return method;
    }

    public static /* synthetic */ Class m() {
        return j;
    }

    public static /* synthetic */ Method n(Class cls) {
        return r(cls);
    }

    public static /* synthetic */ Context o(l2 l2Var) {
        return l2Var.e;
    }

    public static /* synthetic */ ArrayList p(l2 l2Var) {
        return l2Var.f;
    }

    public static Method q(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == IBinder.class) {
                return method;
            }
        }
        return null;
    }

    public static Method r(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == String.class && parameterTypes[2] == String.class && parameterTypes[3] == String.class) {
                return method;
            }
        }
        return null;
    }

    public static Method s(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            Class returnType = method.getReturnType();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == String.class && parameterTypes[2] == String.class && parameterTypes[3] == Bundle.class && returnType == Bundle.class) {
                return method;
            }
        }
        return null;
    }

    public final void b() {
        if (this.h) {
            return;
        }
        new Thread(new b()).start();
    }

    public final void t(ArrayList arrayList, ArrayList arrayList2) {
        try {
            if (this.d == null) {
                Method s = s(j);
                this.d = s;
                s.setAccessible(true);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle bundle2 = (Bundle) this.d.invoke(this.b, new Object[]{3, this.e.getPackageName(), "inapp", bundle});
            if (bundle2.getInt("RESPONSE_CODE") == 0) {
                ArrayList stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                HashMap hashMap = new HashMap();
                Iterator it = stringArrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject((String) it.next());
                    String string = jSONObject.getString("productId");
                    BigDecimal divide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sku", string);
                    jSONObject2.put("iso", jSONObject.getString("price_currency_code"));
                    jSONObject2.put("amount", divide.toString());
                    hashMap.put(string, jSONObject2);
                }
                JSONArray jSONArray = new JSONArray();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (hashMap.containsKey(str)) {
                        jSONArray.put(hashMap.get(str));
                    }
                }
                if (jSONArray.length() > 0) {
                    F1.x1(jSONArray, this.g, new c(arrayList2));
                }
            }
        } catch (Throwable th) {
            F1.b(F1.v.WARN, "Failed to track IAP purchases", th);
        }
    }

    public void u() {
        if (this.a != null) {
            if (this.b != null) {
                b();
            }
        } else {
            this.a = new a();
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this.e.bindService(intent, this.a, 1);
        }
    }
}
