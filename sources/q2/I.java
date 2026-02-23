package Q2;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i {
    public final Context a;
    public final f b;
    public final Handler c;
    public final c d;
    public final BroadcastReceiver e;
    public final d f;
    public h g;
    public boolean h;

    public static final class b {
        public static void a(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            k.a((AudioManager) d4.a.e((AudioManager) context.getSystemService("audio")), audioDeviceCallback, handler);
        }

        public static void b(Context context, AudioDeviceCallback audioDeviceCallback) {
            j.a((AudioManager) d4.a.e((AudioManager) context.getSystemService("audio")), audioDeviceCallback);
        }
    }

    public final class c extends AudioDeviceCallback {
        public c() {
        }

        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            i iVar = i.this;
            i.a(iVar, h.c(i.b(iVar)));
        }

        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            i iVar = i.this;
            i.a(iVar, h.c(i.b(iVar)));
        }

        public /* synthetic */ c(i iVar, a aVar) {
            this();
        }
    }

    public final class d extends ContentObserver {
        public final ContentResolver a;
        public final Uri b;

        public d(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.a = contentResolver;
            this.b = uri;
        }

        public void a() {
            this.a.registerContentObserver(this.b, false, this);
        }

        public void b() {
            this.a.unregisterContentObserver(this);
        }

        public void onChange(boolean z) {
            i iVar = i.this;
            i.a(iVar, h.c(i.b(iVar)));
        }
    }

    public final class e extends BroadcastReceiver {
        public e() {
        }

        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            i.a(i.this, h.d(context, intent));
        }

        public /* synthetic */ e(i iVar, a aVar) {
            this();
        }
    }

    public interface f {
        void a(h hVar);
    }

    public i(Context context, f fVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = (f) d4.a.e(fVar);
        Handler z = d4.k0.z();
        this.c = z;
        int i = d4.k0.a;
        this.d = i >= 23 ? new c(this, null) : null;
        this.e = i >= 21 ? new e(this, null) : null;
        Uri g = h.g();
        this.f = g != null ? new d(z, applicationContext.getContentResolver(), g) : null;
    }

    public static /* synthetic */ void a(i iVar, h hVar) {
        iVar.c(hVar);
    }

    public static /* synthetic */ Context b(i iVar) {
        return iVar.a;
    }

    public final void c(h hVar) {
        if (!this.h || hVar.equals(this.g)) {
            return;
        }
        this.g = hVar;
        this.b.a(hVar);
    }

    public h d() {
        c cVar;
        if (this.h) {
            return (h) d4.a.e(this.g);
        }
        this.h = true;
        d dVar = this.f;
        if (dVar != null) {
            dVar.a();
        }
        if (d4.k0.a >= 23 && (cVar = this.d) != null) {
            b.a(this.a, cVar, this.c);
        }
        h d2 = h.d(this.a, this.e != null ? this.a.registerReceiver(this.e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), (String) null, this.c) : null);
        this.g = d2;
        return d2;
    }

    public void e() {
        c cVar;
        if (this.h) {
            this.g = null;
            if (d4.k0.a >= 23 && (cVar = this.d) != null) {
                b.b(this.a, cVar);
            }
            BroadcastReceiver broadcastReceiver = this.e;
            if (broadcastReceiver != null) {
                this.a.unregisterReceiver(broadcastReceiver);
            }
            d dVar = this.f;
            if (dVar != null) {
                dVar.b();
            }
            this.h = false;
        }
    }
}
