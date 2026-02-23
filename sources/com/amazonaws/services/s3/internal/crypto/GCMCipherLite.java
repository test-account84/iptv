package com.amazonaws.services.s3.internal.crypto;

import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class GCMCipherLite extends CipherLite {
    private static final int BITS = 8;
    private static final int TAG_LENGTH = ContentCryptoScheme.AES_GCM.getTagLengthInBits() / 8;
    private CipherLite aux;
    private long currentCount;
    private boolean doneFinal;
    private byte[] finalBytes;
    private boolean invisiblyProcessed;
    private long markedCount;
    private long outputByteCount;
    private boolean securityViolated;
    private final int tagLen;

    public GCMCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        super(cipher, ContentCryptoScheme.AES_GCM, secretKey, i);
        this.tagLen = i == 1 ? TAG_LENGTH : 0;
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
    }

    private int checkMax(int i) {
        if (this.outputByteCount + i <= 68719476704L) {
            return i;
        }
        this.securityViolated = true;
        throw new SecurityException("Number of bytes processed has exceeded the maximum allowed by AES/GCM; [outputByteCount=" + this.outputByteCount + ", delta=" + i + "]");
    }

    private final byte[] doFinal0(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (!this.doneFinal) {
            this.doneFinal = true;
            byte[] doFinal = super.doFinal(bArr, i, i2);
            this.finalBytes = doFinal;
            if (doFinal == null) {
                return null;
            }
            this.outputByteCount += checkMax(doFinal.length - this.tagLen);
            return (byte[]) this.finalBytes.clone();
        }
        if (this.securityViolated) {
            throw new SecurityException();
        }
        if (2 == getCipherMode()) {
            byte[] bArr2 = this.finalBytes;
            if (bArr2 == null) {
                return null;
            }
            return (byte[]) bArr2.clone();
        }
        byte[] bArr3 = this.finalBytes;
        int length = bArr3.length;
        int i3 = this.tagLen;
        int i4 = length - i3;
        if (i2 == i4) {
            return (byte[]) bArr3.clone();
        }
        if (i2 >= i4 || i2 + this.currentCount != this.outputByteCount) {
            throw new IllegalStateException("Inconsistent re-rencryption");
        }
        return Arrays.copyOfRange(bArr3, (bArr3.length - i3) - i2, bArr3.length);
    }

    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        if (this.doneFinal) {
            if (this.securityViolated) {
                throw new SecurityException();
            }
            byte[] bArr = this.finalBytes;
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        }
        this.doneFinal = true;
        byte[] doFinal = super.doFinal();
        this.finalBytes = doFinal;
        if (doFinal == null) {
            return null;
        }
        this.outputByteCount += checkMax(doFinal.length - this.tagLen);
        return (byte[]) this.finalBytes.clone();
    }

    public long getCurrentCount() {
        return this.currentCount;
    }

    public byte[] getFinalBytes() {
        byte[] bArr = this.finalBytes;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public long getMarkedCount() {
        return this.markedCount;
    }

    public long getOutputByteCount() {
        return this.outputByteCount;
    }

    public byte[] getTag() {
        byte[] bArr;
        if (getCipherMode() != 1 || (bArr = this.finalBytes) == null) {
            return null;
        }
        return Arrays.copyOfRange(bArr, bArr.length - this.tagLen, bArr.length);
    }

    public long mark() {
        long j = this.aux == null ? this.outputByteCount : this.currentCount;
        this.markedCount = j;
        return j;
    }

    public boolean markSupported() {
        return true;
    }

    public void reset() {
        long j = this.markedCount;
        if (j < this.outputByteCount || this.invisiblyProcessed) {
            try {
                this.aux = createAuxiliary(j);
                this.currentCount = this.markedCount;
            } catch (Exception e) {
                if (!(e instanceof RuntimeException)) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        byte[] update;
        CipherLite cipherLite = this.aux;
        r1 = false;
        boolean z = false;
        if (cipherLite == null) {
            update = super.update(bArr, i, i2);
            if (update == null) {
                this.invisiblyProcessed = bArr.length > 0;
                return null;
            }
            this.outputByteCount += checkMax(update.length);
            if (update.length == 0 && i2 > 0) {
                z = true;
            }
            this.invisiblyProcessed = z;
        } else {
            update = cipherLite.update(bArr, i, i2);
            if (update == null) {
                return null;
            }
            long length = this.currentCount + update.length;
            this.currentCount = length;
            long j = this.outputByteCount;
            if (length == j) {
                this.aux = null;
            } else if (length > j) {
                if (1 == getCipherMode()) {
                    throw new IllegalStateException("currentCount=" + this.currentCount + " > outputByteCount=" + this.outputByteCount);
                }
                byte[] bArr2 = this.finalBytes;
                int length2 = bArr2 != null ? bArr2.length : 0;
                long j2 = this.outputByteCount;
                long j3 = length2;
                long length3 = (j2 - (this.currentCount - update.length)) - j3;
                this.currentCount = j2 - j3;
                this.aux = null;
                return Arrays.copyOf(update, (int) length3);
            }
        }
        return update;
    }

    public final byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal0(bArr, 0, bArr.length);
    }

    public final byte[] doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal0(bArr, i, i2);
    }
}
