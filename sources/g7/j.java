package g7;

import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.nst.iptvsmarterstvbox.miscelleneious.MyApplication;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final /* synthetic */ class j implements OnCompleteListener {
    public final /* synthetic */ MyApplication a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ j(MyApplication myApplication, Context context, boolean z) {
        this.a = myApplication;
        this.b = context;
        this.c = z;
    }

    public final void onComplete(Task task) {
        MyApplication.b(this.a, this.b, this.c, task);
    }
}
