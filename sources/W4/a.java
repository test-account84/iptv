package w4;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a implements ServiceConnection {
    public boolean a = false;
    public final BlockingQueue c = new LinkedBlockingQueue();

    public IBinder a(long j, TimeUnit timeUnit) {
        com.google.android.gms.common.internal.r.l("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.a = true;
        IBinder iBinder = (IBinder) this.c.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.c.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
