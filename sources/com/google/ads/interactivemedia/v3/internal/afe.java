package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class afe {
    public static long a(ByteBuffer byteBuffer) {
        j(byteBuffer);
        return h(byteBuffer, byteBuffer.position() + 16);
    }

    public static long b(ByteBuffer byteBuffer) {
        j(byteBuffer);
        return h(byteBuffer, byteBuffer.position() + 12);
    }

    public static Pair c(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair i = i(randomAccessFile, 0);
        return i != null ? i : i(randomAccessFile, 65535);
    }

    public static void d(ByteBuffer byteBuffer, long j) {
        j(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j >= 0 && j <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + position, (int) j);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: " + j);
    }

    public static X509Certificate[][] e(String str) throws afb, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair c = c(randomAccessFile);
            if (c == null) {
                throw new afb("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
            }
            ByteBuffer byteBuffer = (ByteBuffer) c.first;
            long longValue = ((Long) c.second).longValue();
            long j = (-20) + longValue;
            if (j >= 0) {
                randomAccessFile.seek(j);
                if (randomAccessFile.readInt() == 1347094023) {
                    throw new afb("ZIP64 APK not supported");
                }
            }
            long a = a(byteBuffer);
            if (a >= longValue) {
                throw new afb("ZIP Central Directory offset out of range: " + a + ". ZIP End of Central Directory offset: " + longValue);
            }
            if (b(byteBuffer) + a != longValue) {
                throw new afb("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            if (a < 32) {
                throw new afb("APK too small for APK Signing Block. ZIP Central Directory offset: " + a);
            }
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(a - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) != 2334950737559900225L || allocate.getLong(16) != 3617552046287187010L) {
                throw new afb("No APK Signing Block before ZIP Central Directory");
            }
            int i = 0;
            long j2 = allocate.getLong(0);
            if (j2 < allocate.capacity() || j2 > 2147483639) {
                throw new afb("APK Signing Block size out of range: " + j2);
            }
            int i2 = (int) (8 + j2);
            long j3 = a - i2;
            if (j3 < 0) {
                throw new afb("APK Signing Block offset out of range: " + j3);
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(i2);
            allocate2.order(byteOrder);
            randomAccessFile.seek(j3);
            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
            long j4 = allocate2.getLong(0);
            if (j4 != j2) {
                throw new afb("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
            }
            Pair create = Pair.create(allocate2, Long.valueOf(j3));
            ByteBuffer byteBuffer2 = (ByteBuffer) create.first;
            long longValue2 = ((Long) create.second).longValue();
            if (byteBuffer2.order() != byteOrder) {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
            int capacity = byteBuffer2.capacity() - 24;
            if (capacity < 8) {
                throw new IllegalArgumentException("end < start: " + capacity + " < 8");
            }
            int capacity2 = byteBuffer2.capacity();
            if (capacity > byteBuffer2.capacity()) {
                throw new IllegalArgumentException("end > capacity: " + capacity + " > " + capacity2);
            }
            int limit = byteBuffer2.limit();
            int position = byteBuffer2.position();
            try {
                byteBuffer2.position(0);
                byteBuffer2.limit(capacity);
                byteBuffer2.position(8);
                ByteBuffer slice = byteBuffer2.slice();
                slice.order(byteBuffer2.order());
                while (slice.hasRemaining()) {
                    i++;
                    if (slice.remaining() < 8) {
                        throw new afb("Insufficient data to read size of APK Signing Block entry #" + i);
                    }
                    long j5 = slice.getLong();
                    if (j5 < 4 || j5 > 2147483647L) {
                        throw new afb("APK Signing Block entry #" + i + " size out of range: " + j5);
                    }
                    int i3 = (int) j5;
                    int position2 = slice.position() + i3;
                    if (i3 > slice.remaining()) {
                        throw new afb("APK Signing Block entry #" + i + " size out of range: " + i3 + ", available: " + slice.remaining());
                    }
                    if (slice.getInt() == 1896449818) {
                        X509Certificate[][] t = t(randomAccessFile.getChannel(), new afa(n(slice, i3 - 4), longValue2, a, longValue, byteBuffer));
                        randomAccessFile.close();
                        return t;
                    }
                    slice.position(position2);
                }
                throw new afb("No APK Signature Scheme v2 block in APK Signing Block");
            } finally {
                byteBuffer2.position(0);
                byteBuffer2.limit(limit);
                byteBuffer2.position(position);
            }
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int f(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long g(cj cjVar, int i, int i2) {
        cjVar.F(i);
        if (cjVar.a() < 5) {
            return -9223372036854775807L;
        }
        int e = cjVar.e();
        if ((8388608 & e) != 0 || ((e >> 8) & 8191) != i2 || (e & 32) == 0 || cjVar.i() < 7 || cjVar.a() < 7 || (cjVar.i() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        cjVar.A(bArr, 0, 6);
        byte b = bArr[0];
        long j = bArr[3] & 255;
        return ((bArr[1] & 255) << 17) | ((b & 255) << 25) | ((bArr[2] & 255) << 9) | (j + j) | ((bArr[4] & 255) >> 7);
    }

    private static long h(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & 4294967295L;
    }

    private static Pair i(RandomAccessFile randomAccessFile, int i) throws IOException {
        int i2;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i, (-22) + length)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        j(allocate);
        int capacity2 = allocate.capacity();
        if (capacity2 < 22) {
            i2 = -1;
        } else {
            int i3 = capacity2 - 22;
            int min = Math.min(i3, 65535);
            for (int i4 = 0; i4 < min; i4++) {
                i2 = i3 - i4;
                if (allocate.getInt(i2) == 101010256 && ((char) allocate.getShort(i2 + 20)) == i4) {
                    break;
                }
            }
            i2 = -1;
        }
        if (i2 == -1) {
            return null;
        }
        allocate.position(i2);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + i2));
    }

    private static void j(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int k(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    private static int l(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i))));
        }
    }

    private static String m(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
    }

    private static ByteBuffer n(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static ByteBuffer o(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            return n(byteBuffer, i);
        }
        throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
    }

    private static void p(Map map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        aez aezVar = new aez(fileChannel, 0L, j);
        aez aezVar2 = new aez(fileChannel, j2, j3 - j2);
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        d(duplicate, j);
        aex aexVar = new aex(duplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        try {
            byte[][] s = s(iArr, new aey[]{aezVar, aezVar2, aexVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i3)), s[i2])) {
                    throw new SecurityException(m(i3).concat(" digest of contents did not verify"));
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[] q(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    private static java.security.cert.X509Certificate[] r(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r22v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
        	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
        	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
        	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
        	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
        	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
        	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
        	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
        	at java.util.ArrayList.forEach(ArrayList.java:1262)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
        */

    private static byte[][] s(int[] iArr, aey[] aeyVarArr) throws DigestException {
        long j;
        int i;
        int length;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        while (true) {
            j = 1048576;
            if (i2 >= 3) {
                break;
            }
            j3 += (aeyVarArr[i2].a() + 1048575) / 1048576;
            i2++;
        }
        if (j3 >= 2097151) {
            throw new DigestException("Too many chunks: " + j3);
        }
        int i3 = (int) j3;
        byte[][] bArr = new byte[iArr.length][];
        int i4 = 0;
        while (true) {
            length = iArr.length;
            if (i4 >= length) {
                break;
            }
            byte[] bArr2 = new byte[(k(iArr[i4]) * i3) + 5];
            bArr2[0] = 90;
            u(i3, bArr2);
            bArr[i4] = bArr2;
            i4++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            String m = m(iArr[i5]);
            try {
                messageDigestArr[i5] = MessageDigest.getInstance(m);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(m.concat(" digest not supported"), e);
            }
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (i = 3; i6 < i; i = 3) {
            aey aeyVar = aeyVarArr[i6];
            long j4 = j2;
            int i9 = i6;
            long a = aeyVar.a();
            while (a > j2) {
                int min = (int) Math.min(a, j);
                u(min, bArr3);
                for (int i10 = 0; i10 < length; i10++) {
                    messageDigestArr[i10].update(bArr3);
                }
                long j5 = j4;
                try {
                    aeyVar.b(messageDigestArr, j5, min);
                    int i11 = 0;
                    while (i11 < iArr.length) {
                        int i12 = iArr[i11];
                        aey aeyVar2 = aeyVar;
                        byte[] bArr4 = bArr[i11];
                        int k = k(i12);
                        byte[] bArr5 = bArr3;
                        MessageDigest messageDigest = messageDigestArr[i11];
                        MessageDigest[] messageDigestArr2 = messageDigestArr;
                        int digest = messageDigest.digest(bArr4, (i7 * k) + 5, k);
                        if (digest != k) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                        }
                        i11++;
                        aeyVar = aeyVar2;
                        bArr3 = bArr5;
                        messageDigestArr = messageDigestArr2;
                    }
                    aey aeyVar3 = aeyVar;
                    long j6 = min;
                    long j7 = j5 + j6;
                    a -= j6;
                    i7++;
                    j2 = 0;
                    j = 1048576;
                    aeyVar = aeyVar3;
                    j4 = j7;
                    bArr3 = bArr3;
                } catch (IOException e2) {
                    throw new DigestException("Failed to digest chunk #" + i7 + " of section #" + i8, e2);
                }
            }
            i8++;
            i6 = i9 + 1;
            j2 = 0;
            j = 1048576;
        }
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String m2 = m(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(m2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(m2.concat(" digest not supported"), e3);
            }
        }
        return bArr6;
    }

    private static X509Certificate[][] t(FileChannel fileChannel, afa afaVar) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer o = o(afa.e(afaVar));
                int i = 0;
                while (o.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(r(o(o), hashMap, certificateFactory));
                    } catch (SecurityException | BufferUnderflowException | IOException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (hashMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                p(hashMap, fileChannel, afa.a(afaVar), afa.b(afaVar), afa.c(afaVar), afa.d(afaVar));
                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static void u(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }
}
