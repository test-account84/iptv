package de.blinkt.openvpn.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;
import de.blinkt.openvpn.core.G;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Locale;
import java.util.UnknownFormatConversionException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class k implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public Object[] a;
    public String c;
    public int d;
    public G.c e;
    public long f;
    public int g;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }
    }

    public k(Parcel parcel) {
        this.a = null;
        this.c = null;
        this.e = G.c.INFO;
        this.f = System.currentTimeMillis();
        this.g = -1;
        this.a = parcel.readArray(Object.class.getClassLoader());
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = G.c.getEnumByValue(parcel.readInt());
        this.g = parcel.readInt();
        this.f = parcel.readLong();
    }

    public static String g(CharSequence charSequence, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object obj : objArr) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    public long a() {
        return this.f;
    }

    public byte[] c() {
        String obj;
        ByteBuffer allocate = ByteBuffer.allocate(16384);
        allocate.put((byte) 0);
        allocate.putLong(this.f);
        allocate.putInt(this.g);
        allocate.putInt(this.e.getInt());
        allocate.putInt(this.d);
        String str = this.c;
        if (str == null || str.length() == 0) {
            allocate.putInt(0);
        } else {
            h(this.c, allocate);
        }
        Object[] objArr = this.a;
        if (objArr == null || objArr.length == 0) {
            allocate.putInt(0);
        } else {
            allocate.putInt(objArr.length);
            for (Object obj2 : this.a) {
                if (obj2 instanceof String) {
                    allocate.putChar('s');
                    obj = (String) obj2;
                } else {
                    if (obj2 instanceof Integer) {
                        allocate.putChar('i');
                        allocate.putInt(((Integer) obj2).intValue());
                    } else if (obj2 instanceof Float) {
                        allocate.putChar('f');
                        allocate.putFloat(((Float) obj2).floatValue());
                    } else if (obj2 instanceof Double) {
                        allocate.putChar('d');
                        allocate.putDouble(((Double) obj2).doubleValue());
                    } else if (obj2 instanceof Long) {
                        allocate.putChar('l');
                        allocate.putLong(((Long) obj2).longValue());
                    } else if (obj2 == null) {
                        allocate.putChar('0');
                    } else {
                        G.m("Unknown object for LogItem marschaling " + obj2);
                        allocate.putChar('s');
                        obj = obj2.toString();
                    }
                }
                h(obj, allocate);
            }
        }
        int position = allocate.position();
        allocate.rewind();
        return Arrays.copyOf(allocate.array(), position);
    }

    public final String d(Context context) {
        String str;
        X509Certificate generateCertificate;
        byte[] digest;
        int i;
        context.getPackageManager();
        String str2 = "error getting package signature";
        try {
            generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()));
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(generateCertificate.getEncoded());
            digest = messageDigest.digest();
        } catch (PackageManager.NameNotFoundException | CertificateException | NoSuchAlgorithmException unused) {
            str = "error getting version";
        }
        if (Arrays.equals(digest, G.m)) {
            i = a7.j.O4;
        } else {
            if (!Arrays.equals(digest, G.n)) {
                str2 = Arrays.equals(digest, G.o) ? "amazon version" : Arrays.equals(digest, G.p) ? "F-Droid built and signed version" : context.getString(a7.j.Y, new Object[]{generateCertificate.getSubjectX500Principal().getName()});
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                Object[] objArr = this.a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                copyOf[copyOf.length - 1] = str2;
                copyOf[copyOf.length - 2] = str;
                return context.getString(a7.j.I3, copyOf);
            }
            i = a7.j.F0;
        }
        str2 = context.getString(i);
        str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        Object[] objArr2 = this.a;
        Object[] copyOf2 = Arrays.copyOf(objArr2, objArr2.length);
        copyOf2[copyOf2.length - 1] = str2;
        copyOf2[copyOf2.length - 2] = str;
        return context.getString(a7.j.I3, copyOf2);
    }

    public int describeContents() {
        return 0;
    }

    public String e(Context context) {
        try {
            String str = this.c;
            if (str != null) {
                return str;
            }
            if (context != null) {
                int i = this.d;
                if (i == a7.j.I3) {
                    return d(context);
                }
                Object[] objArr = this.a;
                return objArr == null ? context.getString(i) : context.getString(i, objArr);
            }
            String format = String.format(Locale.ENGLISH, "Log (no context) resid %d", new Object[]{Integer.valueOf(this.d)});
            if (this.a == null) {
                return format;
            }
            return format + g("|", this.a);
        } catch (FormatFlagsConversionMismatchException e) {
            if (context == null) {
                throw e;
            }
            throw new FormatFlagsConversionMismatchException(e.getLocalizedMessage() + e(null), e.getConversion());
        } catch (UnknownFormatConversionException e2) {
            if (context == null) {
                throw e2;
            }
            throw new UnknownFormatConversionException(e2.getLocalizedMessage() + e(null));
        }
    }

    public boolean equals(Object obj) {
        String str;
        G.c cVar;
        if (!(obj instanceof k)) {
            return obj.equals(this);
        }
        k kVar = (k) obj;
        return Arrays.equals(this.a, kVar.a) && (((str = kVar.c) == null && this.c == str) || this.c.equals(str)) && this.d == kVar.d && ((((cVar = this.e) == null && kVar.e == cVar) || kVar.e.equals(cVar)) && this.g == kVar.g && this.f == kVar.f);
    }

    public int f() {
        int i = this.g;
        return i == -1 ? this.e.getInt() : i;
    }

    public final void h(String str, ByteBuffer byteBuffer) {
        byte[] bytes = str.getBytes("UTF-8");
        byteBuffer.putInt(bytes.length);
        byteBuffer.put(bytes);
    }

    public String toString() {
        return e(null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeArray(this.a);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e.getInt());
        parcel.writeInt(this.g);
        parcel.writeLong(this.f);
    }

    public k(G.c cVar, int i) {
        this.a = null;
        this.c = null;
        this.e = G.c.INFO;
        this.f = System.currentTimeMillis();
        this.g = -1;
        this.d = i;
        this.e = cVar;
    }

    public k(G.c cVar, int i, String str) {
        this.a = null;
        this.c = null;
        this.e = G.c.INFO;
        this.f = System.currentTimeMillis();
        this.c = str;
        this.e = cVar;
        this.g = i;
    }

    public k(G.c cVar, int i, Object... objArr) {
        this.a = null;
        this.c = null;
        this.e = G.c.INFO;
        this.f = System.currentTimeMillis();
        this.g = -1;
        this.d = i;
        this.a = objArr;
        this.e = cVar;
    }

    public k(G.c cVar, String str) {
        this.a = null;
        this.c = null;
        this.e = G.c.INFO;
        this.f = System.currentTimeMillis();
        this.g = -1;
        this.e = cVar;
        this.c = str;
    }
}
