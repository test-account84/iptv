package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, i.a {
    public e a;
    public androidx.appcompat.app.a c;
    public c d;
    public i.a e;

    public f(e eVar) {
        this.a = eVar;
    }

    public void a() {
        androidx.appcompat.app.a aVar = this.c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void b(e eVar, boolean z) {
        if (z || eVar == this.a) {
            a();
        }
        i.a aVar = this.e;
        if (aVar != null) {
            aVar.b(eVar, z);
        }
    }

    public boolean c(e eVar) {
        i.a aVar = this.e;
        if (aVar != null) {
            return aVar.c(eVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        e eVar = this.a;
        a.a aVar = new a.a(eVar.u());
        c cVar = new c(aVar.getContext(), c.g.j);
        this.d = cVar;
        cVar.d(this);
        this.a.b(this.d);
        aVar.a(this.d.a(), this);
        View y = eVar.y();
        if (y != null) {
            aVar.c(y);
        } else {
            aVar.e(eVar.w()).setTitle(eVar.x());
        }
        aVar.i(this);
        androidx.appcompat.app.a create = aVar.create();
        this.c = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.L((g) this.d.a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.d.b(this.a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.a.performShortcut(i, keyEvent, 0);
    }
}
