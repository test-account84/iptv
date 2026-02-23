package B6;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements SensorEventListener {
    public Z6.h a;
    public Z6.i b;
    public Sensor c;
    public Context d;
    public Handler e = new Handler();

    public b(Context context, Z6.h hVar, Z6.i iVar) {
        this.d = context;
        this.a = hVar;
        this.b = iVar;
    }

    public static /* synthetic */ void a(b bVar, boolean z) {
        bVar.b(z);
    }

    public final /* synthetic */ void b(boolean z) {
        this.a.t(z);
    }

    public final void c(boolean z) {
        this.e.post(new a(this, z));
    }

    public void d() {
        if (this.b.d()) {
            SensorManager sensorManager = (SensorManager) this.d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void e() {
        if (this.c != null) {
            ((SensorManager) this.d.getSystemService("sensor")).unregisterListener(this);
            this.c = null;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.a != null) {
            if (f <= 45.0f) {
                c(true);
            } else if (f >= 450.0f) {
                c(false);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
