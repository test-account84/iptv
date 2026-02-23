package org.spongycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Base64Encoder implements Encoder {
    protected final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    protected final byte[] decodingTable = new byte[128];
    protected byte padding = 61;

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c, char c2, char c3, char c4) throws IOException {
        char c5 = this.padding;
        if (c3 == c5) {
            byte[] bArr = this.decodingTable;
            outputStream.write((bArr[c] << 2) | (bArr[c2] >> 4));
            return 1;
        }
        if (c4 == c5) {
            byte[] bArr2 = this.decodingTable;
            byte b = bArr2[c];
            byte b2 = bArr2[c2];
            byte b3 = bArr2[c3];
            outputStream.write((b << 2) | (b2 >> 4));
            outputStream.write((b2 << 4) | (b3 >> 2));
            return 2;
        }
        byte[] bArr3 = this.decodingTable;
        byte b4 = bArr3[c];
        byte b5 = bArr3[c2];
        byte b6 = bArr3[c3];
        byte b7 = bArr3[c4];
        outputStream.write((b4 << 2) | (b5 >> 4));
        outputStream.write((b5 << 4) | (b6 >> 2));
        outputStream.write((b6 << 6) | b7);
        return 3;
    }

    private boolean ignore(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    private int nextI(String str, int i, int i2) {
        while (i < i2 && ignore(str.charAt(i))) {
            i++;
        }
        return i;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        int i = length - 4;
        int i2 = 0;
        int nextI = nextI(str, 0, i);
        while (nextI < i) {
            int i3 = nextI + 1;
            byte b = this.decodingTable[str.charAt(nextI)];
            int nextI2 = nextI(str, i3, i);
            int i4 = nextI2 + 1;
            byte b2 = this.decodingTable[str.charAt(nextI2)];
            int nextI3 = nextI(str, i4, i);
            int i5 = nextI3 + 1;
            byte b3 = this.decodingTable[str.charAt(nextI3)];
            int nextI4 = nextI(str, i5, i);
            int i6 = nextI4 + 1;
            byte b4 = this.decodingTable[str.charAt(nextI4)];
            outputStream.write((b << 2) | (b2 >> 4));
            outputStream.write((b2 << 4) | (b3 >> 2));
            outputStream.write((b3 << 6) | b4);
            i2 += 3;
            nextI = nextI(str, i6, i);
        }
        return i2 + decodeLastBlock(outputStream, str.charAt(i), str.charAt(length - 3), str.charAt(length - 2), str.charAt(length - 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int encode(byte[] r11, int r12, int r13, java.io.OutputStream r14) throws java.io.IOException {
        /*
            r10 = this;
            int r0 = r13 % 3
            int r13 = r13 - r0
            r1 = r12
        L4:
            int r2 = r12 + r13
            r3 = 4
            r4 = 2
            if (r1 >= r2) goto L4c
            r2 = r11[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r5 = r1 + 1
            r5 = r11[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r1 + 2
            r6 = r11[r6]
            r7 = r6 & 255(0xff, float:3.57E-43)
            byte[] r8 = r10.encodingTable
            int r9 = r2 >>> 2
            r9 = r9 & 63
            r8 = r8[r9]
            r14.write(r8)
            byte[] r8 = r10.encodingTable
            int r2 = r2 << r3
            int r3 = r5 >>> 4
            r2 = r2 | r3
            r2 = r2 & 63
            r2 = r8[r2]
            r14.write(r2)
            byte[] r2 = r10.encodingTable
            int r3 = r5 << 2
            int r4 = r7 >>> 6
            r3 = r3 | r4
            r3 = r3 & 63
            r2 = r2[r3]
            r14.write(r2)
            byte[] r2 = r10.encodingTable
            r3 = r6 & 63
            r2 = r2[r3]
            r14.write(r2)
            int r1 = r1 + 3
            goto L4
        L4c:
            r12 = 1
            if (r0 == r12) goto L83
            if (r0 == r4) goto L52
            goto L9f
        L52:
            r1 = r11[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r2 = r2 + r12
            r11 = r11[r2]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r12 = r1 >>> 2
            r12 = r12 & 63
            int r1 = r1 << r3
            int r2 = r11 >>> 4
            r1 = r1 | r2
            r1 = r1 & 63
            int r11 = r11 << r4
            r11 = r11 & 63
            byte[] r2 = r10.encodingTable
            r12 = r2[r12]
            r14.write(r12)
            byte[] r12 = r10.encodingTable
            r12 = r12[r1]
            r14.write(r12)
            byte[] r12 = r10.encodingTable
            r11 = r12[r11]
        L7a:
            r14.write(r11)
            byte r11 = r10.padding
            r14.write(r11)
            goto L9f
        L83:
            r11 = r11[r2]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r12 = r11 >>> 2
            r12 = r12 & 63
            int r11 = r11 << r3
            r11 = r11 & 63
            byte[] r1 = r10.encodingTable
            r12 = r1[r12]
            r14.write(r12)
            byte[] r12 = r10.encodingTable
            r11 = r12[r11]
            r14.write(r11)
            byte r11 = r10.padding
            goto L7a
        L9f:
            int r13 = r13 / 3
            int r13 = r13 * 4
            if (r0 != 0) goto La6
            r3 = 0
        La6:
            int r13 = r13 + r3
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.encoders.Base64Encoder.encode(byte[], int, int, java.io.OutputStream):int");
    }

    public void initialiseDecodingTable() {
        int i = 0;
        while (true) {
            byte[] bArr = this.encodingTable;
            if (i >= bArr.length) {
                return;
            }
            this.decodingTable[bArr[i]] = (byte) i;
            i++;
        }
    }

    private int nextI(byte[] bArr, int i, int i2) {
        while (i < i2 && ignore((char) bArr[i])) {
            i++;
        }
        return i;
    }

    public int decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3 = i2 + i;
        while (i3 > i && ignore((char) bArr[i3 - 1])) {
            i3--;
        }
        int i4 = i3 - 4;
        int nextI = nextI(bArr, i, i4);
        int i5 = 0;
        while (nextI < i4) {
            int i6 = nextI + 1;
            byte b = this.decodingTable[bArr[nextI]];
            int nextI2 = nextI(bArr, i6, i4);
            int i7 = nextI2 + 1;
            byte b2 = this.decodingTable[bArr[nextI2]];
            int nextI3 = nextI(bArr, i7, i4);
            int i8 = nextI3 + 1;
            byte b3 = this.decodingTable[bArr[nextI3]];
            int nextI4 = nextI(bArr, i8, i4);
            int i9 = nextI4 + 1;
            byte b4 = this.decodingTable[bArr[nextI4]];
            outputStream.write((b << 2) | (b2 >> 4));
            outputStream.write((b2 << 4) | (b3 >> 2));
            outputStream.write((b3 << 6) | b4);
            i5 += 3;
            nextI = nextI(bArr, i9, i4);
        }
        return i5 + decodeLastBlock(outputStream, (char) bArr[i4], (char) bArr[i3 - 3], (char) bArr[i3 - 2], (char) bArr[i3 - 1]);
    }
}
