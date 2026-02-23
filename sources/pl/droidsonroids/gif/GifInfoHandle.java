package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.Os;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class GifInfoHandle {
    public volatile long a;

    static {
        g.b();
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) {
        try {
            this.a = n(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    public static native int createTempNativeFileDescriptor() throws GifIOException;

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z) throws GifIOException;

    private static native void free(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native int getWidth(long j);

    public static int h(FileDescriptor fileDescriptor, boolean z) {
        try {
            int createTempNativeFileDescriptor = createTempNativeFileDescriptor();
            Os.dup2(fileDescriptor, createTempNativeFileDescriptor);
            return createTempNativeFileDescriptor;
        } finally {
            if (z) {
                Os.close(fileDescriptor);
            }
        }
    }

    private static native boolean isOpaque(long j);

    public static long n(FileDescriptor fileDescriptor, long j, boolean z) {
        int h;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                h = h(fileDescriptor, z);
            } catch (Exception e) {
                throw new GifIOException(b.OPEN_FAILED.errorCode, e.getMessage());
            }
        } else {
            h = extractNativeFileDescriptor(fileDescriptor, z);
        }
        return openNativeFileDescriptor(h, j);
    }

    public static GifInfoHandle o(ContentResolver contentResolver, Uri uri) {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return new GifInfoHandle(openAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for " + uri);
    }

    public static native long openFile(String str) throws GifIOException;

    public static native long openNativeFileDescriptor(int i, long j) throws GifIOException;

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    public synchronized int a() {
        return getCurrentFrameIndex(this.a);
    }

    public synchronized int b() {
        return getCurrentLoop(this.a);
    }

    public synchronized int c() {
        return getCurrentPosition(this.a);
    }

    public synchronized int d() {
        return getDuration(this.a);
    }

    public synchronized int e() {
        return getHeight(this.a);
    }

    public synchronized int f() {
        return getLoopCount(this.a);
    }

    public void finalize() {
        try {
            p();
        } finally {
            super.finalize();
        }
    }

    public synchronized int g() {
        return getNativeErrorCode(this.a);
    }

    public synchronized int i() {
        return getNumberOfFrames(this.a);
    }

    public synchronized long[] j() {
        return getSavedState(this.a);
    }

    public synchronized int k() {
        return getWidth(this.a);
    }

    public synchronized boolean l() {
        return isOpaque(this.a);
    }

    public synchronized boolean m() {
        return this.a == 0;
    }

    public synchronized void p() {
        free(this.a);
        this.a = 0L;
    }

    public synchronized long q(Bitmap bitmap) {
        return renderFrame(this.a, bitmap);
    }

    public synchronized boolean r() {
        return reset(this.a);
    }

    public synchronized long s() {
        return restoreRemainder(this.a);
    }

    public synchronized int t(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.a, jArr, bitmap);
    }

    public synchronized void u() {
        saveRemainder(this.a);
    }

    public synchronized void v(int i, Bitmap bitmap) {
        seekToTime(this.a, i, bitmap);
    }

    public void w(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.a, (char) i);
        }
    }

    public GifInfoHandle(String str) {
        this.a = openFile(str);
    }
}
