package com.google.android.exoplayer2.ext.ffmpeg;

import O2.w0;
import d4.B;
import d4.x;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class FfmpegLibrary {
    public static final x a;
    public static String b;
    public static int c;

    public class a extends x {
        public a(String... strArr) {
            super(strArr);
        }

        public void b(String str) {
            System.loadLibrary(str);
        }
    }

    static {
        w0.a("goog.exo.ffmpeg");
        a = new a("ffmpegJNI");
        c = -1;
    }

    public static String a(String str) {
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/eac3":
                return "eac3";
            case "audio/amr-wb":
                return "amrwb";
            case "audio/vnd.dts":
            case "audio/vnd.dts.hd":
                return "dca";
            case "audio/vorbis":
                return "vorbis";
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/mpeg":
                return "mp3";
            case "audio/mp4a-latm":
                return "aac";
            case "audio/ac3":
                return "ac3";
            case "audio/3gpp":
                return "amrnb";
            case "audio/alac":
                return "alac";
            case "audio/flac":
                return "flac";
            case "audio/opus":
                return "opus";
            case "audio/true-hd":
                return "truehd";
            case "audio/g711-alaw":
                return "pcm_alaw";
            case "audio/g711-mlaw":
                return "pcm_mulaw";
            default:
                return null;
        }
    }

    public static int b() {
        if (!d()) {
            return -1;
        }
        if (c == -1) {
            c = ffmpegGetInputBufferPaddingSize();
        }
        return c;
    }

    public static String c() {
        if (!d()) {
            return null;
        }
        if (b == null) {
            b = ffmpegGetVersion();
        }
        return b;
    }

    public static boolean d() {
        return a.a();
    }

    public static boolean e(String str) {
        String a2;
        if (!d() || (a2 = a(str)) == null) {
            return false;
        }
        if (ffmpegHasDecoder(a2)) {
            return true;
        }
        B.j("FfmpegLibrary", "No " + a2 + " decoder available. Check the FFmpeg build configuration.");
        return false;
    }

    private static native int ffmpegGetInputBufferPaddingSize();

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);
}
