package okhttp3.internal;

import E8.n;
import E8.o;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.jvm.internal.l;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (l.f(charAt, 31) <= 0 || l.f(charAt, 127) >= 0 || o.Q(" #%/:?@[\\]", charAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (l.f(charAt, 48) < 0 || l.f(charAt, 57) > 0) {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
    
        if (r13 == 16) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
    
        if (r14 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
    
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 175
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i2 < bArr.length) {
            if (i2 == i) {
                buffer.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i2], 255) << 8) | Util.and(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }

    @Nullable
    public static final String toCanonicalHost(@NotNull String toCanonicalHost) {
        int length;
        l.e(toCanonicalHost, "$this$toCanonicalHost");
        int i = 0;
        if (!o.G(toCanonicalHost, ":", false, 2, null)) {
            try {
                String ascii = IDN.toASCII(toCanonicalHost);
                l.d(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                l.d(locale, "Locale.US");
                if (ascii == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                l.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() != 0 && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (n.B(toCanonicalHost, "[", false, 2, null) && n.n(toCanonicalHost, "]", false, 2, null)) {
            i = 1;
            length = toCanonicalHost.length() - 1;
        } else {
            length = toCanonicalHost.length();
        }
        InetAddress decodeIpv6 = decodeIpv6(toCanonicalHost, i, length);
        if (decodeIpv6 == null) {
            return null;
        }
        byte[] address = decodeIpv6.getAddress();
        if (address.length == 16) {
            l.d(address, "address");
            return inet6AddressToAscii(address);
        }
        if (address.length == 4) {
            return decodeIpv6.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
    }
}
