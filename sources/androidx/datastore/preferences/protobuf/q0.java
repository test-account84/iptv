package androidx.datastore.preferences.protobuf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class q0 {
    public static final b a;

    public static class a {
        public static /* synthetic */ void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
            h(b, b2, b3, b4, cArr, i);
        }

        public static /* synthetic */ boolean b(byte b) {
            return n(b);
        }

        public static /* synthetic */ void c(byte b, char[] cArr, int i) {
            i(b, cArr, i);
        }

        public static /* synthetic */ boolean d(byte b) {
            return p(b);
        }

        public static /* synthetic */ void e(byte b, byte b2, char[] cArr, int i) {
            k(b, b2, cArr, i);
        }

        public static /* synthetic */ boolean f(byte b) {
            return o(b);
        }

        public static /* synthetic */ void g(byte b, byte b2, byte b3, char[] cArr, int i) {
            j(b, b2, b3, cArr, i);
        }

        public static void h(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
            if (m(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m(b3) || m(b4)) {
                throw z.c();
            }
            int r = ((b & 7) << 18) | (r(b2) << 12) | (r(b3) << 6) | r(b4);
            cArr[i] = l(r);
            cArr[i + 1] = q(r);
        }

        public static void i(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        public static void j(byte b, byte b2, byte b3, char[] cArr, int i) {
            if (m(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m(b3)))) {
                throw z.c();
            }
            cArr[i] = (char) (((b & 15) << 12) | (r(b2) << 6) | r(b3));
        }

        public static void k(byte b, byte b2, char[] cArr, int i) {
            if (b < -62 || m(b2)) {
                throw z.c();
            }
            cArr[i] = (char) (((b & 31) << 6) | r(b2));
        }

        public static char l(int i) {
            return (char) ((i >>> 10) + 55232);
        }

        public static boolean m(byte b) {
            return b > -65;
        }

        public static boolean n(byte b) {
            return b >= 0;
        }

        public static boolean o(byte b) {
            return b < -16;
        }

        public static boolean p(byte b) {
            return b < -32;
        }

        public static char q(int i) {
            return (char) ((i & 1023) + 56320);
        }

        public static int r(byte b) {
            return b & 63;
        }
    }

    public static abstract class b {
        public abstract String a(byte[] bArr, int i, int i2);

        public abstract int b(CharSequence charSequence, byte[] bArr, int i, int i2);

        public final boolean c(byte[] bArr, int i, int i2) {
            return d(0, bArr, i, i2) == 0;
        }

        public abstract int d(int i, byte[] bArr, int i2, int i3);
    }

    public static final class c extends b {
        public static int e(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return f(bArr, i, i2);
        }

        public static int f(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i += 2;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b >= -16) {
                        if (i3 >= i2 - 2) {
                            return q0.c(bArr, i3, i2);
                        }
                        int i4 = i + 2;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                            int i5 = i + 3;
                            if (bArr[i4] <= -65) {
                                i += 4;
                                if (bArr[i5] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i3 >= i2 - 1) {
                        return q0.c(bArr, i3, i2);
                    }
                    int i6 = i + 2;
                    byte b3 = bArr[i3];
                    if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                        i += 3;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                }
                i = i3;
            }
            return 0;
        }

        public String a(byte[] bArr, int i, int i2) {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!a.b(b)) {
                    break;
                }
                i++;
                a.c(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (a.b(b2)) {
                    int i7 = i5 + 1;
                    a.c(b2, cArr, i5);
                    while (i6 < i3) {
                        byte b3 = bArr[i6];
                        if (!a.b(b3)) {
                            break;
                        }
                        i6++;
                        a.c(b3, cArr, i7);
                        i7++;
                    }
                    i5 = i7;
                    i = i6;
                } else if (a.d(b2)) {
                    if (i6 >= i3) {
                        throw z.c();
                    }
                    i += 2;
                    a.e(b2, bArr[i6], cArr, i5);
                    i5++;
                } else if (a.f(b2)) {
                    if (i6 >= i3 - 1) {
                        throw z.c();
                    }
                    int i8 = i + 2;
                    i += 3;
                    a.g(b2, bArr[i6], bArr[i8], cArr, i5);
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw z.c();
                    }
                    byte b4 = bArr[i6];
                    int i9 = i + 3;
                    byte b5 = bArr[i + 2];
                    i += 4;
                    a.a(b2, b4, b5, bArr[i9], cArr, i5);
                    i5 += 2;
                }
            }
            return new String(cArr, 0, i5);
        }

        public int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            char charAt;
            int length = charSequence.length();
            int i5 = i2 + i;
            int i6 = 0;
            while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
                bArr[i4] = (byte) charAt;
                i6++;
            }
            if (i6 == length) {
                return i + length;
            }
            int i7 = i + i6;
            while (i6 < length) {
                char charAt2 = charSequence.charAt(i6);
                if (charAt2 < 128 && i7 < i5) {
                    bArr[i7] = (byte) charAt2;
                    i7++;
                } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                    i7 += 2;
                    bArr[i8] = (byte) ((charAt2 & '?') | 128);
                } else {
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || i7 > i5 - 3) {
                        if (i7 > i5 - 4) {
                            if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i6 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                                throw new d(i6, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
                        }
                        int i9 = i6 + 1;
                        if (i9 != charSequence.length()) {
                            char charAt3 = charSequence.charAt(i9);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i10 = i7 + 3;
                                bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i7 += 4;
                                bArr[i10] = (byte) ((codePoint & 63) | 128);
                                i6 = i9;
                            } else {
                                i6 = i9;
                            }
                        }
                        throw new d(i6 - 1, length);
                    }
                    bArr[i7] = (byte) ((charAt2 >>> '\f') | 480);
                    int i11 = i7 + 2;
                    bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i7 += 3;
                    bArr[i11] = (byte) ((charAt2 & '?') | 128);
                }
                i6++;
            }
            return i7;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int d(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = androidx.datastore.preferences.protobuf.q0.a(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = androidx.datastore.preferences.protobuf.q0.a(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = androidx.datastore.preferences.protobuf.q0.b(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = e(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.c.d(int, byte[], int, int):int");
        }
    }

    public static class d extends IllegalArgumentException {
        public d(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    public static final class e extends b {
        public static boolean e() {
            return p0.C() && p0.D();
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x0064, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0039, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int f(byte[] r10, long r11, int r13) {
            /*
                int r0 = g(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = androidx.datastore.preferences.protobuf.p0.s(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = androidx.datastore.preferences.protobuf.p0.s(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = h(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.p0.s(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = androidx.datastore.preferences.protobuf.p0.s(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = h(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = androidx.datastore.preferences.protobuf.p0.s(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = androidx.datastore.preferences.protobuf.p0.s(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = androidx.datastore.preferences.protobuf.p0.s(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.e.f(byte[], long, int):int");
        }

        public static int g(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            while (i2 < i) {
                long j2 = 1 + j;
                if (p0.s(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = j2;
            }
            return i;
        }

        public static int h(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return q0.d(i);
            }
            if (i2 == 1) {
                return q0.a(i, p0.s(bArr, j));
            }
            if (i2 == 2) {
                return q0.b(i, p0.s(bArr, j), p0.s(bArr, j + 1));
            }
            throw new AssertionError();
        }

        public String a(byte[] bArr, int i, int i2) {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte s = p0.s(bArr, i);
                if (!a.b(s)) {
                    break;
                }
                i++;
                a.c(s, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte s2 = p0.s(bArr, i);
                if (a.b(s2)) {
                    int i7 = i5 + 1;
                    a.c(s2, cArr, i5);
                    while (i6 < i3) {
                        byte s3 = p0.s(bArr, i6);
                        if (!a.b(s3)) {
                            break;
                        }
                        i6++;
                        a.c(s3, cArr, i7);
                        i7++;
                    }
                    i5 = i7;
                    i = i6;
                } else if (a.d(s2)) {
                    if (i6 >= i3) {
                        throw z.c();
                    }
                    i += 2;
                    a.e(s2, p0.s(bArr, i6), cArr, i5);
                    i5++;
                } else if (a.f(s2)) {
                    if (i6 >= i3 - 1) {
                        throw z.c();
                    }
                    int i8 = i + 2;
                    i += 3;
                    a.g(s2, p0.s(bArr, i6), p0.s(bArr, i8), cArr, i5);
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw z.c();
                    }
                    byte s4 = p0.s(bArr, i6);
                    int i9 = i + 3;
                    byte s5 = p0.s(bArr, i + 2);
                    i += 4;
                    a.a(s2, s4, s5, p0.s(bArr, i9), cArr, i5);
                    i5 += 2;
                }
            }
            return new String(cArr, 0, i5);
        }

        public int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
            long j;
            String str;
            String str2;
            int i3;
            long j2;
            long j3;
            char charAt;
            long j4 = i;
            long j5 = i2 + j4;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i4 = 0;
            while (true) {
                j = 1;
                if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                p0.H(bArr, j4, (byte) charAt);
                i4++;
                j4 = 1 + j4;
            }
            if (i4 == length) {
                return (int) j4;
            }
            while (i4 < length) {
                char charAt2 = charSequence.charAt(i4);
                if (charAt2 >= 128 || j4 >= j5) {
                    if (charAt2 >= 2048 || j4 > j5 - 2) {
                        str = str3;
                        str2 = str4;
                        if ((charAt2 >= 55296 && 57343 >= charAt2) || j4 > j5 - 3) {
                            if (j4 > j5 - 4) {
                                if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                                    throw new d(i4, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + charAt2 + str + j4);
                            }
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    j2 = 1;
                                    p0.H(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    j3 = j5;
                                    p0.H(bArr, j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j6 = j4 + 3;
                                    p0.H(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 += 4;
                                    p0.H(bArr, j6, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new d(i4 - 1, length);
                        }
                        p0.H(bArr, j4, (byte) ((charAt2 >>> '\f') | 480));
                        long j7 = j4 + 2;
                        p0.H(bArr, j4 + 1, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j4 += 3;
                        p0.H(bArr, j7, (byte) ((charAt2 & '?') | 128));
                    } else {
                        str = str3;
                        str2 = str4;
                        long j8 = j4 + j;
                        p0.H(bArr, j4, (byte) ((charAt2 >>> 6) | 960));
                        j4 += 2;
                        p0.H(bArr, j8, (byte) ((charAt2 & '?') | 128));
                    }
                    j3 = j5;
                    j2 = 1;
                } else {
                    p0.H(bArr, j4, (byte) charAt2);
                    j3 = j5;
                    str2 = str4;
                    j2 = j;
                    j4 += j;
                    str = str3;
                }
                i4++;
                str3 = str;
                str4 = str2;
                j = j2;
                j5 = j3;
            }
            return (int) j4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            if (androidx.datastore.preferences.protobuf.p0.s(r13, r1) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (androidx.datastore.preferences.protobuf.p0.s(r13, r1) > (-65)) goto L59;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int d(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.e.d(int, byte[], int, int):int");
        }
    }

    static {
        a = (!e.e() || androidx.datastore.preferences.protobuf.d.c()) ? new c() : new e();
    }

    public static /* synthetic */ int a(int i, int i2) {
        return j(i, i2);
    }

    public static /* synthetic */ int b(int i, int i2, int i3) {
        return k(i, i2, i3);
    }

    public static /* synthetic */ int c(byte[] bArr, int i, int i2) {
        return l(bArr, i, i2);
    }

    public static /* synthetic */ int d(int i) {
        return i(i);
    }

    public static String e(byte[] bArr, int i, int i2) {
        return a.a(bArr, i, i2);
    }

    public static int f(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return a.b(charSequence, bArr, i, i2);
    }

    public static int g(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += h(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i2 + 4294967296L));
    }

    public static int h(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new d(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    public static int i(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int j(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int k(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static int l(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return i(b2);
        }
        if (i3 == 1) {
            return j(b2, bArr[i]);
        }
        if (i3 == 2) {
            return k(b2, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static boolean m(byte[] bArr) {
        return a.c(bArr, 0, bArr.length);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return a.c(bArr, i, i2);
    }
}
