package Y6;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class r {
    public int a;
    public WindowManager b;
    public OrientationEventListener c;
    public q d;

    public class a extends OrientationEventListener {
        public a(Context context, int i) {
            super(context, i);
        }

        public void onOrientationChanged(int i) {
            int rotation;
            WindowManager a = r.a(r.this);
            q b = r.b(r.this);
            if (r.a(r.this) == null || b == null || (rotation = a.getDefaultDisplay().getRotation()) == r.c(r.this)) {
                return;
            }
            r.d(r.this, rotation);
            b.a(rotation);
        }
    }

    public static /* synthetic */ WindowManager a(r rVar) {
        return rVar.b;
    }

    public static /* synthetic */ q b(r rVar) {
        return rVar.d;
    }

    public static /* synthetic */ int c(r rVar) {
        return rVar.a;
    }

    public static /* synthetic */ int d(r rVar, int i) {
        rVar.a = i;
        return i;
    }

    public void e(Context context, q qVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.d = qVar;
        this.b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.c = aVar;
        aVar.enable();
        this.a = this.b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.c = null;
        this.b = null;
        this.d = null;
    }
}
