package com.google.ads.interactivemedia.v3.internal;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyAgreement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bjh {
    public static final byte[] A(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length - i3 < i || bArr2.length - i3 < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = (byte) (bArr[i4 + i] ^ bArr2[i4 + i2]);
        }
        return bArr3;
    }

    private static ECParameterSpec B(String str, String str2, String str3, String str4, String str5) {
        BigInteger bigInteger = new BigInteger(str);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(str3, 16)), new ECPoint(new BigInteger(str4, 16), new BigInteger(str5, 16)), new BigInteger(str2), 1);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] copyOf = Arrays.copyOf(bArr, 32);
        int i = 0;
        copyOf[0] = (byte) (copyOf[0] & 248);
        int i2 = copyOf[31] & Byte.MAX_VALUE;
        copyOf[31] = (byte) i2;
        copyOf[31] = (byte) (i2 | 64);
        int i3 = biq.b;
        if (bArr2.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        byte[] copyOf2 = Arrays.copyOf(bArr2, 32);
        copyOf2[31] = (byte) (copyOf2[31] & Byte.MAX_VALUE);
        for (int i4 = 0; i4 < 7; i4++) {
            byte[][] bArr3 = biq.a;
            if (x(bArr3[i4], copyOf2)) {
                throw new InvalidKeyException("Banned public key: ".concat(String.valueOf(g(bArr3[i4]))));
            }
        }
        long[] k = biy.k(copyOf2);
        long[] jArr2 = new long[19];
        long[] jArr3 = new long[19];
        jArr3[0] = 1;
        long[] jArr4 = new long[19];
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        jArr7[0] = 1;
        long[] jArr8 = new long[19];
        long[] jArr9 = new long[19];
        jArr9[0] = 1;
        System.arraycopy(k, 0, jArr2, 0, 10);
        while (i < 32) {
            int i5 = copyOf[31 - i] & 255;
            int i6 = 0;
            while (i6 < 8) {
                int i7 = (i5 >> (7 - i6)) & 1;
                biq.a(jArr4, jArr2, i7);
                biq.a(jArr5, jArr3, i7);
                byte[] bArr4 = copyOf;
                long[] copyOf3 = Arrays.copyOf(jArr4, 10);
                int i8 = i5;
                long[] jArr10 = new long[19];
                long[] jArr11 = jArr;
                long[] jArr12 = new long[19];
                int i9 = i;
                long[] jArr13 = new long[19];
                int i10 = i6;
                long[] jArr14 = new long[19];
                long[] jArr15 = new long[19];
                long[] jArr16 = jArr9;
                long[] jArr17 = new long[19];
                long[] jArr18 = new long[19];
                biy.i(jArr4, jArr4, jArr5);
                biy.h(jArr5, copyOf3, jArr5);
                long[] copyOf4 = Arrays.copyOf(jArr2, 10);
                biy.i(jArr2, jArr2, jArr3);
                biy.h(jArr3, copyOf4, jArr3);
                biy.b(jArr14, jArr2, jArr5);
                biy.b(jArr15, jArr4, jArr3);
                biy.e(jArr14);
                biy.d(jArr14);
                biy.e(jArr15);
                biy.d(jArr15);
                long[] jArr19 = jArr2;
                System.arraycopy(jArr14, 0, copyOf4, 0, 10);
                biy.i(jArr14, jArr14, jArr15);
                biy.h(jArr15, copyOf4, jArr15);
                biy.g(jArr18, jArr14);
                biy.g(jArr17, jArr15);
                biy.b(jArr15, jArr17, k);
                biy.e(jArr15);
                biy.d(jArr15);
                System.arraycopy(jArr18, 0, jArr6, 0, 10);
                System.arraycopy(jArr15, 0, jArr7, 0, 10);
                biy.g(jArr12, jArr4);
                biy.g(jArr13, jArr5);
                biy.b(jArr8, jArr12, jArr13);
                biy.e(jArr8);
                biy.d(jArr8);
                biy.h(jArr13, jArr12, jArr13);
                Arrays.fill(jArr10, 10, 18, 0L);
                biy.f(jArr10, jArr13, 121665L);
                biy.d(jArr10);
                biy.i(jArr10, jArr10, jArr12);
                biy.b(jArr16, jArr13, jArr10);
                biy.e(jArr16);
                biy.d(jArr16);
                biq.a(jArr8, jArr6, i7);
                biq.a(jArr16, jArr7, i7);
                i6 = i10 + 1;
                jArr2 = jArr6;
                jArr9 = jArr5;
                i5 = i8;
                jArr = jArr11;
                i = i9;
                jArr6 = jArr19;
                jArr5 = jArr16;
                copyOf = bArr4;
                long[] jArr20 = jArr3;
                jArr3 = jArr7;
                jArr7 = jArr20;
                long[] jArr21 = jArr4;
                jArr4 = jArr8;
                jArr8 = jArr21;
            }
            i++;
            copyOf = copyOf;
        }
        long[] jArr22 = jArr;
        long[] jArr23 = new long[10];
        long[] jArr24 = new long[10];
        long[] jArr25 = new long[10];
        long[] jArr26 = new long[10];
        long[] jArr27 = new long[10];
        long[] jArr28 = new long[10];
        long[] jArr29 = new long[10];
        long[] jArr30 = new long[10];
        long[] jArr31 = new long[10];
        long[] jArr32 = new long[10];
        long[] jArr33 = jArr2;
        long[] jArr34 = new long[10];
        biy.g(jArr24, jArr5);
        biy.g(jArr34, jArr24);
        biy.g(jArr32, jArr34);
        biy.a(jArr25, jArr32, jArr5);
        biy.a(jArr26, jArr25, jArr24);
        biy.g(jArr32, jArr26);
        biy.a(jArr27, jArr32, jArr25);
        biy.g(jArr32, jArr27);
        biy.g(jArr34, jArr32);
        biy.g(jArr32, jArr34);
        biy.g(jArr34, jArr32);
        biy.g(jArr32, jArr34);
        biy.a(jArr28, jArr32, jArr27);
        biy.g(jArr32, jArr28);
        biy.g(jArr34, jArr32);
        int i11 = 2;
        for (int i12 = 10; i11 < i12; i12 = 10) {
            biy.g(jArr32, jArr34);
            biy.g(jArr34, jArr32);
            i11 += 2;
        }
        biy.a(jArr29, jArr34, jArr28);
        biy.g(jArr32, jArr29);
        biy.g(jArr34, jArr32);
        for (int i13 = 2; i13 < 20; i13 += 2) {
            biy.g(jArr32, jArr34);
            biy.g(jArr34, jArr32);
        }
        biy.a(jArr32, jArr34, jArr29);
        biy.g(jArr34, jArr32);
        biy.g(jArr32, jArr34);
        int i14 = 2;
        for (int i15 = 10; i14 < i15; i15 = 10) {
            biy.g(jArr34, jArr32);
            biy.g(jArr32, jArr34);
            i14 += 2;
        }
        biy.a(jArr30, jArr32, jArr28);
        biy.g(jArr32, jArr30);
        biy.g(jArr34, jArr32);
        for (int i16 = 2; i16 < 50; i16 += 2) {
            biy.g(jArr32, jArr34);
            biy.g(jArr34, jArr32);
        }
        biy.a(jArr31, jArr34, jArr30);
        biy.g(jArr34, jArr31);
        biy.g(jArr32, jArr34);
        for (int i17 = 2; i17 < 100; i17 += 2) {
            biy.g(jArr34, jArr32);
            biy.g(jArr32, jArr34);
        }
        biy.a(jArr34, jArr32, jArr31);
        biy.g(jArr32, jArr34);
        biy.g(jArr34, jArr32);
        for (int i18 = 2; i18 < 50; i18 += 2) {
            biy.g(jArr32, jArr34);
            biy.g(jArr34, jArr32);
        }
        biy.a(jArr32, jArr34, jArr30);
        biy.g(jArr34, jArr32);
        biy.g(jArr32, jArr34);
        biy.g(jArr34, jArr32);
        biy.g(jArr32, jArr34);
        biy.g(jArr34, jArr32);
        biy.a(jArr23, jArr34, jArr26);
        biy.a(jArr22, jArr4, jArr23);
        long[] jArr35 = new long[10];
        long[] jArr36 = new long[10];
        long[] jArr37 = new long[11];
        long[] jArr38 = new long[11];
        long[] jArr39 = new long[11];
        biy.a(jArr35, k, jArr22);
        biy.i(jArr36, k, jArr22);
        long[] jArr40 = new long[10];
        jArr40[0] = 486662;
        biy.i(jArr38, jArr36, jArr40);
        biy.a(jArr38, jArr38, jArr3);
        biy.i(jArr38, jArr38, jArr33);
        biy.a(jArr38, jArr38, jArr35);
        biy.a(jArr38, jArr38, jArr33);
        biy.f(jArr37, jArr38, 4L);
        biy.d(jArr37);
        biy.a(jArr38, jArr35, jArr3);
        biy.h(jArr38, jArr38, jArr3);
        biy.a(jArr39, jArr36, jArr33);
        biy.i(jArr38, jArr38, jArr39);
        biy.g(jArr38, jArr38);
        if (x(biy.j(jArr37), biy.j(jArr38))) {
            return biy.j(jArr22);
        }
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(String.valueOf(g(bArr2))));
    }

    public static byte[] b() {
        byte[] b = bjf.b(32);
        b[0] = (byte) (b[0] | 7);
        int i = b[31] & 63;
        b[31] = (byte) i;
        b[31] = (byte) (i | 128);
        return b;
    }

    public static byte[] c(byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr2 = new byte[32];
        bArr2[0] = 9;
        return a(bArr, bArr2);
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static DateFormat e(int i, int i2) {
        return new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.US);
    }

    public static boolean f() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }

    public static String g(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : bArr) {
            sb.append("0123456789abcdef".charAt((b & 255) >> 4));
            sb.append("0123456789abcdef".charAt(b & 15));
        }
        return sb.toString();
    }

    public static int h(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (i(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    public static BigInteger i(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        ECFieldFp field = ellipticCurve.getField();
        if (field instanceof ECFieldFp) {
            return field.getP();
        }
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    public static BigInteger j(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger i = i(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(i);
        if (i.signum() != 1) {
            throw new InvalidAlgorithmParameterException("p must be positive");
        }
        BigInteger mod2 = mod.mod(i);
        BigInteger bigInteger2 = BigInteger.ZERO;
        if (!mod2.equals(bigInteger2)) {
            if (i.testBit(0) && i.testBit(1)) {
                bigInteger2 = mod2.modPow(i.add(BigInteger.ONE).shiftRight(2), i);
            } else if (i.testBit(0) && !i.testBit(1)) {
                bigInteger2 = BigInteger.ONE;
                BigInteger shiftRight = i.subtract(bigInteger2).shiftRight(1);
                int i2 = 0;
                while (true) {
                    BigInteger mod3 = bigInteger2.multiply(bigInteger2).subtract(mod2).mod(i);
                    if (mod3.equals(BigInteger.ZERO)) {
                        break;
                    }
                    BigInteger modPow = mod3.modPow(shiftRight, i);
                    BigInteger bigInteger3 = BigInteger.ONE;
                    if (modPow.add(bigInteger3).equals(i)) {
                        BigInteger shiftRight2 = i.add(bigInteger3).shiftRight(1);
                        BigInteger bigInteger4 = bigInteger2;
                        for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                            BigInteger multiply = bigInteger4.multiply(bigInteger3);
                            bigInteger4 = bigInteger4.multiply(bigInteger4).add(bigInteger3.multiply(bigInteger3).mod(i).multiply(mod3)).mod(i);
                            BigInteger mod4 = multiply.add(multiply).mod(i);
                            if (shiftRight2.testBit(bitLength)) {
                                BigInteger mod5 = bigInteger4.multiply(bigInteger2).add(mod4.multiply(mod3)).mod(i);
                                bigInteger3 = bigInteger2.multiply(mod4).add(bigInteger4).mod(i);
                                bigInteger4 = mod5;
                            } else {
                                bigInteger3 = mod4;
                            }
                        }
                        bigInteger2 = bigInteger4;
                    } else {
                        if (!modPow.equals(bigInteger3)) {
                            throw new InvalidAlgorithmParameterException("p is not prime");
                        }
                        bigInteger2 = bigInteger2.add(bigInteger3);
                        i2++;
                        if (i2 == 128 && !i.isProbablePrime(80)) {
                            throw new InvalidAlgorithmParameterException("p is not prime");
                        }
                    }
                }
            } else {
                bigInteger2 = null;
            }
            if (bigInteger2 != null && bigInteger2.multiply(bigInteger2).mod(i).compareTo(mod2) != 0) {
                throw new GeneralSecurityException("Could not find a modular square root");
            }
        }
        return z != bigInteger2.testBit(0) ? i.subtract(bigInteger2).mod(i) : bigInteger2;
    }

    public static KeyPair k(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) biv.d.a("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    public static void l(ECPoint eCPoint, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger i = i(ellipticCurve);
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        if (affineX == null || affineY == null) {
            throw new GeneralSecurityException("point is at infinity");
        }
        if (affineX.signum() == -1 || affineX.compareTo(i) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        }
        if (affineY.signum() == -1 || affineY.compareTo(i) >= 0) {
            throw new GeneralSecurityException("y is out of range");
        }
        if (!affineY.multiply(affineY).mod(i).equals(affineX.multiply(affineX).add(ellipticCurve.getA()).multiply(affineX).add(ellipticCurve.getB()).mod(i))) {
            throw new GeneralSecurityException("Point is not on curve");
        }
    }

    public static void m(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        n(eCPublicKey, eCPrivateKey);
        l(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    public static void n(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            ECParameterSpec params = eCPublicKey.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor()) {
            } else {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (NullPointerException e) {
            e = e;
            throw new GeneralSecurityException(e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] o(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        n(eCPublicKey, eCPrivateKey);
        ECPoint w = eCPublicKey.getW();
        l(w, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = ((KeyFactory) biv.e.a("EC")).generatePublic(new ECPublicKeySpec(w, eCPrivateKey.getParams()));
        KeyAgreement keyAgreement = (KeyAgreement) biv.c.a("ECDH");
        keyAgreement.init(eCPrivateKey);
        try {
            keyAgreement.doPhase(generatePublic, true);
            byte[] generateSecret = keyAgreement.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, generateSecret);
            if (bigInteger.signum() == -1 || bigInteger.compareTo(i(curve)) >= 0) {
                throw new GeneralSecurityException("shared secret is out of range");
            }
            j(bigInteger, true, curve);
            return generateSecret;
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException(e);
        }
    }

    public static KeyPair p(int i) throws GeneralSecurityException {
        return k(t(i));
    }

    public static ECPrivateKey q(int i, byte[] bArr) throws GeneralSecurityException {
        return ((KeyFactory) biv.e.a("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), t(i)));
    }

    public static ECPublicKey r(int i, int i2, byte[] bArr) throws GeneralSecurityException {
        ECParameterSpec t = t(i);
        EllipticCurve curve = t.getCurve();
        int h = h(curve);
        int length = bArr.length;
        if (length != h + h + 1) {
            throw new GeneralSecurityException("invalid point size");
        }
        if (bArr[0] != 4) {
            throw new GeneralSecurityException("invalid point format");
        }
        int i3 = h + 1;
        ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i3)), new BigInteger(1, Arrays.copyOfRange(bArr, i3, length)));
        l(eCPoint, curve);
        return ((KeyFactory) biv.e.a("EC")).generatePublic(new ECPublicKeySpec(eCPoint, t));
    }

    public static ECPublicKey s(int i, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ECParameterSpec t = t(i);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        l(eCPoint, t.getCurve());
        return ((KeyFactory) biv.e.a("EC")).generatePublic(new ECPublicKeySpec(eCPoint, t));
    }

    public static ECParameterSpec t(int i) throws NoSuchAlgorithmException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2 = i - 1;
        if (i2 == 0) {
            str = "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296";
            str2 = "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5";
            str3 = "115792089210356248762697446949407573530086143415290314195533631308867097853951";
            str4 = "115792089210356248762697446949407573529996955224135760342422259061068512044369";
            str5 = "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b";
        } else if (i2 != 1) {
            str = "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66";
            str2 = "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650";
            str3 = "6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151";
            str4 = "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449";
            str5 = "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00";
        } else {
            str = "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7";
            str2 = "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f";
            str3 = "39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319";
            str4 = "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643";
            str5 = "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef";
        }
        return B(str3, str4, str5, str, str2);
    }

    public static byte[] u(int i, int i2, ECPoint eCPoint) throws GeneralSecurityException {
        return v(t(i).getCurve(), 1, eCPoint);
    }

    public static byte[] v(EllipticCurve ellipticCurve, int i, ECPoint eCPoint) throws GeneralSecurityException {
        l(eCPoint, ellipticCurve);
        int h = h(ellipticCurve);
        int i2 = i - 1;
        if (i2 == 0) {
            int i3 = h + h + 1;
            byte[] bArr = new byte[i3];
            byte[] byteArray = eCPoint.getAffineX().toByteArray();
            byte[] byteArray2 = eCPoint.getAffineY().toByteArray();
            int length = byteArray2.length;
            System.arraycopy(byteArray2, 0, bArr, i3 - length, length);
            int length2 = byteArray.length;
            System.arraycopy(byteArray, 0, bArr, (h + 1) - length2, length2);
            bArr[0] = 4;
            return bArr;
        }
        if (i2 != 2) {
            int i4 = h + 1;
            byte[] bArr2 = new byte[i4];
            byte[] byteArray3 = eCPoint.getAffineX().toByteArray();
            int length3 = byteArray3.length;
            System.arraycopy(byteArray3, 0, bArr2, i4 - length3, length3);
            bArr2[0] = true == eCPoint.getAffineY().testBit(0) ? (byte) 3 : (byte) 2;
            return bArr2;
        }
        int i5 = h + h;
        byte[] bArr3 = new byte[i5];
        byte[] byteArray4 = eCPoint.getAffineX().toByteArray();
        int length4 = byteArray4.length;
        if (length4 > h) {
            byteArray4 = Arrays.copyOfRange(byteArray4, length4 - h, length4);
        }
        byte[] byteArray5 = eCPoint.getAffineY().toByteArray();
        int length5 = byteArray5.length;
        if (length5 > h) {
            byteArray5 = Arrays.copyOfRange(byteArray5, length5 - h, length5);
        }
        int length6 = byteArray5.length;
        System.arraycopy(byteArray5, 0, bArr3, i5 - length6, length6);
        int length7 = byteArray4.length;
        System.arraycopy(byteArray4, 0, bArr3, h - length7, length7);
        return bArr3;
    }

    public static final void w(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final boolean x(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null && bArr.length == bArr2.length) {
            int i = 0;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                i |= bArr[i2] ^ bArr2[i2];
            }
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    public static byte[] y(byte[]... bArr) throws GeneralSecurityException {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            int length = bArr2.length;
            if (i > Integer.MAX_VALUE - length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i += length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            int length2 = bArr4.length;
            System.arraycopy(bArr4, 0, bArr3, i2, length2);
            i2 += length2;
        }
        return bArr3;
    }

    public static final byte[] z(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length == bArr2.length) {
            return A(bArr, 0, bArr2, 0, length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }
}
