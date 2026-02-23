package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import q6.U;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a {
    public final Executor a;
    public final Map b = new s.a();

    public interface a {
        Task start();
    }

    public a(Executor executor) {
        this.a = executor;
    }

    public synchronized Task a(String str, a aVar) {
        try {
            Task task = (Task) this.b.get(str);
            if (task != null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    String valueOf = String.valueOf(str);
                    Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Joining ongoing request for: ".concat(valueOf) : new String("Joining ongoing request for: "));
                }
                return task;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(str);
                Log.d("FirebaseMessaging", valueOf2.length() != 0 ? "Making new request for: ".concat(valueOf2) : new String("Making new request for: "));
            }
            Task continueWithTask = aVar.start().continueWithTask(this.a, new U(this, str));
            this.b.put(str, continueWithTask);
            return continueWithTask;
        } catch (Throwable th) {
            throw th;
        }
    }

    public /* synthetic */ Task b(String str, Task task) {
        synchronized (this) {
            this.b.remove(str);
        }
        return task;
    }
}
