package X0;

import Q0.k;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h extends c {
    public static final String i = k.f("StorageNotLowTracker");

    public h(Context context, c1.a aVar) {
        super(context, aVar);
    }

    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    public void h(Context context, Intent intent) {
        Boolean bool;
        if (intent.getAction() == null) {
            return;
        }
        k.c().a(i, String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            bool = Boolean.FALSE;
        } else if (!action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return;
        } else {
            bool = Boolean.TRUE;
        }
        d(bool);
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent registerReceiver = this.b.registerReceiver((BroadcastReceiver) null, g());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = registerReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return Boolean.TRUE;
        }
        return null;
    }
}
