package y4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b {

    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static void A(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + z(parcel, i));
    }

    public static int B(Parcel parcel) {
        int s = s(parcel);
        int z = z(parcel, s);
        int l = l(s);
        int dataPosition = parcel.dataPosition();
        if (l != 20293) {
            throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(s))), parcel);
        }
        int i = z + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new a("Size read is invalid start=" + dataPosition + " end=" + i, parcel);
    }

    public static void C(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        throw new a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
    }

    public static void D(Parcel parcel, int i, int i2) {
        int z = z(parcel, i);
        if (z == i2) {
            return;
        }
        throw new a("Expected size " + i2 + " got " + z + " (0x" + Integer.toHexString(z) + ")", parcel);
    }

    public static Bundle a(Parcel parcel, int i) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + z);
        return readBundle;
    }

    public static byte[] b(Parcel parcel, int i) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + z);
        return createByteArray;
    }

    public static int[] c(Parcel parcel, int i) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + z);
        return createIntArray;
    }

    public static long[] d(Parcel parcel, int i) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + z);
        return createLongArray;
    }

    public static Parcelable e(Parcel parcel, int i, Parcelable.Creator creator) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + z);
        return parcelable;
    }

    public static String f(Parcel parcel, int i) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + z);
        return readString;
    }

    public static String[] g(Parcel parcel, int i) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + z);
        return createStringArray;
    }

    public static ArrayList h(Parcel parcel, int i) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        ArrayList createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + z);
        return createStringArrayList;
    }

    public static Object[] i(Parcel parcel, int i, Parcelable.Creator creator) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + z);
        return createTypedArray;
    }

    public static ArrayList j(Parcel parcel, int i, Parcelable.Creator creator) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + z);
        return createTypedArrayList;
    }

    public static void k(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new a("Overread allowed size end=" + i, parcel);
    }

    public static int l(int i) {
        return (char) i;
    }

    public static boolean m(Parcel parcel, int i) {
        D(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean n(Parcel parcel, int i) {
        int z = z(parcel, i);
        if (z == 0) {
            return null;
        }
        C(parcel, i, z, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double o(Parcel parcel, int i) {
        D(parcel, i, 8);
        return parcel.readDouble();
    }

    public static Double p(Parcel parcel, int i) {
        int z = z(parcel, i);
        if (z == 0) {
            return null;
        }
        C(parcel, i, z, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float q(Parcel parcel, int i) {
        D(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Float r(Parcel parcel, int i) {
        int z = z(parcel, i);
        if (z == 0) {
            return null;
        }
        C(parcel, i, z, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int s(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder t(Parcel parcel, int i) {
        int z = z(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (z == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + z);
        return readStrongBinder;
    }

    public static int u(Parcel parcel, int i) {
        D(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer v(Parcel parcel, int i) {
        int z = z(parcel, i);
        if (z == 0) {
            return null;
        }
        C(parcel, i, z, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long w(Parcel parcel, int i) {
        D(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long x(Parcel parcel, int i) {
        int z = z(parcel, i);
        if (z == 0) {
            return null;
        }
        C(parcel, i, z, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short y(Parcel parcel, int i) {
        D(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int z(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }
}
