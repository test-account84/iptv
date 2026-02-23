package com.amplifyframework.devmenu;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.amplifyframework.util.Time;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ShakeDetector {
    private static final double SHAKE_THRESHOLD = 13.042844772338867d;
    private static final int SHAKE_TIME = 1000;
    private Sensor accelerometer;
    private final Listener listener;
    private final SensorEventListener sensorEventListener = new 1();
    private SensorManager sensorManager;
    private long shakeStart;

    public class 1 implements SensorEventListener {
        public 1() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)) > 13.042844772338867d) {
                long now = Time.now();
                if (ShakeDetector.access$000(ShakeDetector.this) == 0) {
                    ShakeDetector.access$002(ShakeDetector.this, now);
                } else if (now - ShakeDetector.access$000(ShakeDetector.this) > 1000) {
                    ShakeDetector.access$100(ShakeDetector.this).onShakeDetected();
                    ShakeDetector.access$002(ShakeDetector.this, 0L);
                }
            }
        }
    }

    public interface Listener {
        void onShakeDetected();
    }

    public ShakeDetector(Context context, Listener listener) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.sensorManager = sensorManager;
        if (sensorManager != null) {
            this.accelerometer = sensorManager.getDefaultSensor(1);
        }
        this.listener = listener;
        this.shakeStart = 0L;
    }

    public static /* synthetic */ long access$000(ShakeDetector shakeDetector) {
        return shakeDetector.shakeStart;
    }

    public static /* synthetic */ long access$002(ShakeDetector shakeDetector, long j) {
        shakeDetector.shakeStart = j;
        return j;
    }

    public static /* synthetic */ Listener access$100(ShakeDetector shakeDetector) {
        return shakeDetector.listener;
    }

    public void startDetecting() {
        Sensor sensor = this.accelerometer;
        if (sensor != null) {
            this.sensorManager.registerListener(this.sensorEventListener, sensor, 3);
        }
    }

    public void stopDetecting() {
        if (this.accelerometer != null) {
            this.sensorManager.unregisterListener(this.sensorEventListener);
        }
    }
}
