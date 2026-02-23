package q6;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import q6.l0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class i0 extends Binder {
    public final a a;

    public interface a {
        Task a(Intent intent);
    }

    public i0(a aVar) {
        this.a = aVar;
    }

    public static /* synthetic */ void a(l0.a aVar, Task task) {
        aVar.b();
    }

    public void b(l0.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        this.a.a(aVar.a).addOnCompleteListener(h0.a, new g0(aVar));
    }
}
