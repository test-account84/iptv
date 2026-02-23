package O2;

import O2.n;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class p1 extends Exception implements n {
    public static final String d = d4.k0.A0(0);
    public static final String e = d4.k0.A0(1);
    public static final String f = d4.k0.A0(2);
    public static final String g = d4.k0.A0(3);
    public static final String h = d4.k0.A0(4);
    public static final n.a i = new o1();
    public final int a;
    public final long c;

    public p1(Bundle bundle) {
        this(bundle.getString(f), c(bundle), bundle.getInt(d, 1000), bundle.getLong(e, SystemClock.elapsedRealtime()));
    }

    public static RemoteException a(String str) {
        return new RemoteException(str);
    }

    public static Throwable b(Class cls, String str) {
        return (Throwable) cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
    }

    public static Throwable c(Bundle bundle) {
        String string = bundle.getString(g);
        String string2 = bundle.getString(h);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class cls = Class.forName(string, true, p1.class.getClassLoader());
            Throwable b = Throwable.class.isAssignableFrom(cls) ? b(cls, string2) : null;
            if (b != null) {
                return b;
            }
        } catch (Throwable unused) {
        }
        return a(string2);
    }

    public static String e(int i2) {
        if (i2 == 5001) {
            return "ERROR_CODE_AUDIO_TRACK_INIT_FAILED";
        }
        if (i2 == 5002) {
            return "ERROR_CODE_AUDIO_TRACK_WRITE_FAILED";
        }
        if (i2 == 7000) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSOR_INIT_FAILED";
        }
        if (i2 == 7001) {
            return "ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED";
        }
        switch (i2) {
            case 1000:
                return "ERROR_CODE_UNSPECIFIED";
            case 1001:
                return "ERROR_CODE_REMOTE_ERROR";
            case 1002:
                return "ERROR_CODE_BEHIND_LIVE_WINDOW";
            case 1003:
                return "ERROR_CODE_TIMEOUT";
            case 1004:
                return "ERROR_CODE_FAILED_RUNTIME_CHECK";
            default:
                switch (i2) {
                    case 2000:
                        return "ERROR_CODE_IO_UNSPECIFIED";
                    case 2001:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_FAILED";
                    case 2002:
                        return "ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT";
                    case 2003:
                        return "ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE";
                    case 2004:
                        return "ERROR_CODE_IO_BAD_HTTP_STATUS";
                    case 2005:
                        return "ERROR_CODE_IO_FILE_NOT_FOUND";
                    case 2006:
                        return "ERROR_CODE_IO_NO_PERMISSION";
                    case 2007:
                        return "ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED";
                    case 2008:
                        return "ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE";
                    default:
                        switch (i2) {
                            case 3001:
                                return "ERROR_CODE_PARSING_CONTAINER_MALFORMED";
                            case 3002:
                                return "ERROR_CODE_PARSING_MANIFEST_MALFORMED";
                            case 3003:
                                return "ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED";
                            case 3004:
                                return "ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED";
                            default:
                                switch (i2) {
                                    case 4001:
                                        return "ERROR_CODE_DECODER_INIT_FAILED";
                                    case 4002:
                                        return "ERROR_CODE_DECODER_QUERY_FAILED";
                                    case 4003:
                                        return "ERROR_CODE_DECODING_FAILED";
                                    case 4004:
                                        return "ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES";
                                    case 4005:
                                        return "ERROR_CODE_DECODING_FORMAT_UNSUPPORTED";
                                    default:
                                        switch (i2) {
                                            case 6000:
                                                return "ERROR_CODE_DRM_UNSPECIFIED";
                                            case 6001:
                                                return "ERROR_CODE_DRM_SCHEME_UNSUPPORTED";
                                            case 6002:
                                                return "ERROR_CODE_DRM_PROVISIONING_FAILED";
                                            case 6003:
                                                return "ERROR_CODE_DRM_CONTENT_ERROR";
                                            case 6004:
                                                return "ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED";
                                            case 6005:
                                                return "ERROR_CODE_DRM_DISALLOWED_OPERATION";
                                            case 6006:
                                                return "ERROR_CODE_DRM_SYSTEM_ERROR";
                                            case 6007:
                                                return "ERROR_CODE_DRM_DEVICE_REVOKED";
                                            case 6008:
                                                return "ERROR_CODE_DRM_LICENSE_EXPIRED";
                                            default:
                                                return i2 >= 1000000 ? "custom error code" : "invalid error code";
                                        }
                                }
                        }
                }
        }
    }

    public final String d() {
        return e(this.a);
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(d, this.a);
        bundle.putLong(e, this.c);
        bundle.putString(f, getMessage());
        Throwable cause = getCause();
        if (cause != null) {
            bundle.putString(g, cause.getClass().getName());
            bundle.putString(h, cause.getMessage());
        }
        return bundle;
    }

    public p1(String str, Throwable th, int i2, long j) {
        super(str, th);
        this.a = i2;
        this.c = j;
    }
}
