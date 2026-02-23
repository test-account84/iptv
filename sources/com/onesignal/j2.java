package com.onesignal;

import android.content.Context;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.onesignal.F1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class j2 {
    public Context a;
    public boolean b;
    public b c;
    public boolean d;
    public Object e;
    public Field f;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            PurchasingService.registerListener(j2.a(j2.this), j2.b(j2.this));
        }
    }

    public class b implements PurchasingListener {
        public PurchasingListener a;

        public b() {
        }

        public /* synthetic */ b(j2 j2Var, a aVar) {
            this();
        }
    }

    public j2(Context context) {
        this.b = false;
        this.d = false;
        this.a = context;
        try {
            Class cls = Class.forName("com.amazon.device.iap.internal.d");
            try {
                this.e = cls.getMethod("d", (Class[]) null).invoke((Object) null, (Object[]) null);
            } catch (NullPointerException unused) {
                this.e = cls.getMethod("e", (Class[]) null).invoke((Object) null, (Object[]) null);
                this.d = true;
            }
            Field declaredField = cls.getDeclaredField("f");
            this.f = declaredField;
            declaredField.setAccessible(true);
            b bVar = new b(this, null);
            this.c = bVar;
            bVar.a = (PurchasingListener) this.f.get(this.e);
            this.b = true;
            e();
        } catch (IllegalAccessException | ClassCastException | InvocationTargetException | ClassNotFoundException | NoSuchFieldException | NoSuchMethodException e) {
            d(e);
        }
    }

    public static /* synthetic */ Context a(j2 j2Var) {
        return j2Var.a;
    }

    public static /* synthetic */ b b(j2 j2Var) {
        return j2Var.c;
    }

    public static void d(Exception exc) {
        F1.b(F1.v.ERROR, "Error adding Amazon IAP listener.", exc);
        exc.printStackTrace();
    }

    public void c() {
        if (this.b) {
            try {
                PurchasingListener purchasingListener = (PurchasingListener) this.f.get(this.e);
                b bVar = this.c;
                if (purchasingListener != bVar) {
                    bVar.a = purchasingListener;
                    e();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public final void e() {
        if (this.d) {
            OSUtils.S(new a());
        } else {
            PurchasingService.registerListener(this.a, this.c);
        }
    }
}
