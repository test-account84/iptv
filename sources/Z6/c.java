package Z6;

import Z6.i;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {
    public static final Pattern a = Pattern.compile(";");

    public static List a(int i) {
        int i2 = -i;
        return Collections.singletonList(new Camera.Area(new Rect(i2, i2, i, i), 1));
    }

    public static String b(String str, Collection collection, String... strArr) {
        Log.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    public static void c(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String b = b("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (b != null) {
            parameters.setSceneMode(b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(android.hardware.Camera.Parameters r6, boolean r7) {
        /*
            int r0 = r6.getMinExposureCompensation()
            int r1 = r6.getMaxExposureCompensation()
            float r2 = r6.getExposureCompensationStep()
            java.lang.String r3 = "CameraConfiguration"
            if (r0 != 0) goto L12
            if (r1 == 0) goto L6a
        L12:
            r4 = 0
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 <= 0) goto L6a
            if (r7 == 0) goto L1a
            goto L1c
        L1a:
            r4 = 1069547520(0x3fc00000, float:1.5)
        L1c:
            float r4 = r4 / r2
            int r7 = java.lang.Math.round(r4)
            float r4 = (float) r7
            float r2 = r2 * r4
            int r7 = java.lang.Math.min(r7, r1)
            int r7 = java.lang.Math.max(r7, r0)
            int r0 = r6.getExposureCompensation()
            java.lang.String r1 = " / "
            if (r0 != r7) goto L4c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Exposure compensation already set to "
            r6.append(r0)
            r6.append(r7)
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            goto L6c
        L4c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Setting exposure compensation to "
            r0.append(r4)
            r0.append(r7)
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r3, r0)
            r6.setExposureCompensation(r7)
            goto L6f
        L6a:
            java.lang.String r6 = "Camera does not support exposure compensation"
        L6c:
            android.util.Log.i(r3, r6)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Z6.c.d(android.hardware.Camera$Parameters, boolean):void");
    }

    public static void e(Camera.Parameters parameters) {
        f(parameters, 10, 20);
    }

    public static void f(Camera.Parameters parameters, int i, int i2) {
        int[] iArr;
        String str;
        List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i("CameraConfiguration", "Supported FPS ranges: " + n(supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        Iterator it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                iArr = null;
                break;
            }
            iArr = (int[]) it.next();
            int i3 = iArr[0];
            int i4 = iArr[1];
            if (i3 >= i * 1000 && i4 <= i2 * 1000) {
                break;
            }
        }
        if (iArr == null) {
            str = "No suitable FPS range?";
        } else {
            int[] iArr2 = new int[2];
            parameters.getPreviewFpsRange(iArr2);
            if (!Arrays.equals(iArr2, iArr)) {
                Log.i("CameraConfiguration", "Setting FPS range to " + Arrays.toString(iArr));
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                return;
            }
            str = "FPS range already set to " + Arrays.toString(iArr);
        }
        Log.i("CameraConfiguration", str);
    }

    public static void g(Camera.Parameters parameters, i.a aVar, boolean z) {
        List supportedFocusModes = parameters.getSupportedFocusModes();
        String b = (z || aVar == i.a.AUTO) ? b("focus mode", supportedFocusModes, "auto") : aVar == i.a.CONTINUOUS ? b("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : aVar == i.a.INFINITY ? b("focus mode", supportedFocusModes, "infinity") : aVar == i.a.MACRO ? b("focus mode", supportedFocusModes, "macro") : null;
        if (!z && b == null) {
            b = b("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (b != null) {
            if (!b.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(b);
                return;
            }
            Log.i("CameraConfiguration", "Focus mode already set to " + b);
        }
    }

    public static void h(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support focus areas");
            return;
        }
        Log.i("CameraConfiguration", "Old focus areas: " + m(parameters.getFocusAreas()));
        List a2 = a(400);
        Log.i("CameraConfiguration", "Setting focus area to : " + m(a2));
        parameters.setFocusAreas(a2);
    }

    public static void i(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String b = b("color effect", parameters.getSupportedColorEffects(), "negative");
        if (b != null) {
            parameters.setColorEffect(b);
        }
    }

    public static void j(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support metering areas");
            return;
        }
        Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
        List a2 = a(400);
        Log.i("CameraConfiguration", "Setting metering area to : " + m(a2));
        parameters.setMeteringAreas(a2);
    }

    public static void k(Camera.Parameters parameters, boolean z) {
        List supportedFlashModes = parameters.getSupportedFlashModes();
        String b = z ? b("flash mode", supportedFlashModes, "torch", "on") : b("flash mode", supportedFlashModes, "off");
        if (b != null) {
            if (b.equals(parameters.getFlashMode())) {
                Log.i("CameraConfiguration", "Flash mode already set to " + b);
                return;
            }
            Log.i("CameraConfiguration", "Setting flash mode to " + b);
            parameters.setFlashMode(b);
        }
    }

    public static void l(Camera.Parameters parameters) {
        String str;
        if (!parameters.isVideoStabilizationSupported()) {
            str = "This device does not support video stabilization";
        } else {
            if (!parameters.getVideoStabilization()) {
                Log.i("CameraConfiguration", "Enabling video stabilization...");
                parameters.setVideoStabilization(true);
                return;
            }
            str = "Video stabilization already enabled";
        }
        Log.i("CameraConfiguration", str);
    }

    public static String m(Iterable iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Camera.Area area = (Camera.Area) it.next();
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String n(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString((int[]) it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
