package v4;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c {
    public static int h;
    public static PendingIntent i;
    public static final Executor j = D.a;
    public static final Pattern k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    public final Context b;
    public final x c;
    public final ScheduledExecutorService d;
    public Messenger f;
    public h g;
    public final s.i a = new s.i();
    public Messenger e = new Messenger(new e(this, Looper.getMainLooper()));

    public c(Context context) {
        this.b = context;
        this.c = new x(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.d = scheduledThreadPoolExecutor;
    }

    public static /* synthetic */ Task b(Bundle bundle) {
        return j(bundle) ? Tasks.forResult(null) : Tasks.forResult(bundle);
    }

    public static /* bridge */ /* synthetic */ void d(c cVar, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new g());
                if (intent.hasExtra("google.messenger")) {
                    Messenger parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof h) {
                        cVar.g = (h) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        cVar.f = parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String valueOf = String.valueOf(action);
                        Log.d("Rpc", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = k.matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                            return;
                        }
                        return;
                    }
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (group != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", group2);
                        cVar.i(group, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf2 = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(valueOf2.length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(valueOf2);
                    Log.w("Rpc", sb.toString());
                    return;
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (cVar.a) {
                        for (int i2 = 0; i2 < cVar.a.size(); i2++) {
                            try {
                                cVar.i((String) cVar.a.j(i2), intent2.getExtras());
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    return;
                }
                String[] split = stringExtra2.split("\\|");
                if (split.length <= 2 || !"ID".equals(split[1])) {
                    Log.w("Rpc", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                    return;
                }
                String str = split[2];
                String str2 = split[3];
                if (str2.startsWith(":")) {
                    str2 = str2.substring(1);
                }
                cVar.i(str, intent2.putExtra("error", str2).getExtras());
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    public static synchronized String g() {
        String num;
        synchronized (c.class) {
            int i2 = h;
            h = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }

    public static synchronized void h(Context context, Intent intent) {
        synchronized (c.class) {
            try {
                if (i == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    i = zza.zza(context, 0, intent2, zza.zza);
                }
                intent.putExtra("app", i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean j(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    public Task a(Bundle bundle) {
        return this.c.a() < 12000000 ? this.c.b() != 0 ? f(bundle).continueWithTask(j, new y(this, bundle)) : Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE")) : w.b(this.b).d(1, bundle).continueWith(j, z.a);
    }

    public final /* synthetic */ Task c(Bundle bundle, Task task) {
        return !task.isSuccessful() ? task : !j((Bundle) task.getResult()) ? task : f(bundle).onSuccessTask(j, B.a);
    }

    public final /* synthetic */ void e(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.a) {
            this.a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    public final Task f(Bundle bundle) {
        String g = g();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.a) {
            this.a.put(g, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(this.c.b() == 2 ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
        intent.putExtras(bundle);
        h(this.b, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(g).length() + 5);
        sb.append("|ID|");
        sb.append(g);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
            sb2.append("Sending ");
            sb2.append(valueOf);
            Log.d("Rpc", sb2.toString());
        }
        intent.putExtra("google.messenger", this.e);
        if (this.f != null || this.g != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.g.c(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
        } else if (this.c.b() == 2) {
            this.b.sendBroadcast(intent);
        } else {
            this.b.startService(intent);
        }
        taskCompletionSource.getTask().addOnCompleteListener(j, new A(this, g, this.d.schedule(new C(taskCompletionSource), 30L, TimeUnit.SECONDS)));
        return taskCompletionSource.getTask();
    }

    public final void i(String str, Bundle bundle) {
        synchronized (this.a) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.a.remove(str);
                if (taskCompletionSource != null) {
                    taskCompletionSource.setResult(bundle);
                } else {
                    String valueOf = String.valueOf(str);
                    Log.w("Rpc", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
