package com.squareup.okhttp.internal.tls;

import javax.security.auth.x500.X500Principal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x004d, code lost:
    
        r2 = r8.beg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0057, code lost:
    
        return new java.lang.String(r1, r2, r8.end - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L6:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.chars
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L58
            if (r2 == r5) goto L4d
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L4d
            if (r2 == r3) goto L4d
            int r3 = r8.end
            int r4 = r3 + 1
            r8.end = r4
            r1[r3] = r2
        L39:
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L3e:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.getEscaped()
            r1[r0] = r2
            int r0 = r8.pos
            goto L39
        L4d:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L58:
            int r2 = r8.end
            r8.cur = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L66:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L7f
            char[] r2 = r8.chars
            char r7 = r2[r0]
            if (r7 != r6) goto L7f
            int r1 = r8.end
            int r7 = r1 + 1
            r8.end = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L66
        L7f:
            if (r0 == r1) goto L8b
            char[] r1 = r8.chars
            char r0 = r1[r0]
            if (r0 == r3) goto L8b
            if (r0 == r4) goto L8b
            if (r0 != r5) goto L6
        L8b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.cur
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.tls.DistinguishedNameParser.escapedAV():java.lang.String");
    }

    private int getByte(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        char[] cArr = this.chars;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i2 = c - '7';
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    private char getEscaped() {
        int i = this.pos + 1;
        this.pos = i;
        if (i == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        char c = this.chars[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return getUTF8();
                }
        }
    }

    private char getUTF8() {
        int i;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            return (char) i3;
        }
        if (i3 < 192 || i3 > 247) {
            return '?';
        }
        if (i3 <= 223) {
            i = i3 & 31;
            i2 = 1;
        } else if (i3 <= 239) {
            i = i3 & 15;
            i2 = 2;
        } else {
            i = i3 & 7;
            i2 = 3;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.pos;
            int i6 = i5 + 1;
            this.pos = i6;
            if (i6 == this.length || this.chars[i6] != '\\') {
                return '?';
            }
            int i7 = i5 + 2;
            this.pos = i7;
            int i8 = getByte(i7);
            this.pos++;
            if ((i8 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (i8 & 63);
        }
        return (char) i;
    }

    private String hexAV() {
        char[] cArr;
        char c;
        int i = this.pos;
        if (i + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.beg = i;
        while (true) {
            this.pos = i + 1;
            i = this.pos;
            if (i == this.length || (c = (cArr = this.chars)[i]) == '+' || c == ',' || c == ';') {
                break;
            }
            if (c == ' ') {
                this.end = i;
                do {
                    this.pos = i + 1;
                    i = this.pos;
                    if (i >= this.length) {
                        break;
                    }
                } while (this.chars[i] == ' ');
            } else if (c >= 'A' && c <= 'F') {
                cArr[i] = (char) (c + ' ');
            }
        }
        this.end = i;
        int i2 = this.end;
        int i3 = this.beg;
        int i4 = i2 - i3;
        if (i4 < 5 || (i4 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        int i5 = i4 / 2;
        byte[] bArr = new byte[i5];
        int i6 = i3 + 1;
        for (int i7 = 0; i7 < i5; i7++) {
            bArr[i7] = (byte) getByte(i6);
            i6 += 2;
        }
        return new String(this.chars, this.beg, i4);
    }

    private String nextAT() {
        int i;
        int i2;
        int i3;
        char c;
        int i4;
        int i5;
        char c2;
        char c3;
        while (true) {
            i = this.pos;
            i2 = this.length;
            if (i >= i2 || this.chars[i] != ' ') {
                break;
            }
            this.pos = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.beg = i;
        do {
            this.pos = i + 1;
            i = this.pos;
            i3 = this.length;
            if (i >= i3 || (c3 = this.chars[i]) == '=') {
                break;
            }
        } while (c3 != ' ');
        if (i >= i3) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.end = i;
        if (this.chars[i] == ' ') {
            while (true) {
                i4 = this.pos;
                i5 = this.length;
                if (i4 >= i5 || (c2 = this.chars[i4]) == '=' || c2 != ' ') {
                    break;
                }
                this.pos = i4 + 1;
            }
            if (this.chars[i4] != '=' || i4 == i5) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        int i6 = this.pos;
        do {
            this.pos = i6 + 1;
            i6 = this.pos;
            if (i6 >= this.length) {
                break;
            }
        } while (this.chars[i6] == ' ');
        int i7 = this.end;
        int i8 = this.beg;
        if (i7 - i8 > 4) {
            char[] cArr = this.chars;
            if (cArr[i8 + 3] == '.' && (((c = cArr[i8]) == 'O' || c == 'o') && ((cArr[i8 + 1] == 'I' || cArr[i8 + 1] == 'i') && (cArr[i8 + 2] == 'D' || cArr[i8 + 2] == 'd')))) {
                this.beg = i8 + 4;
            }
        }
        char[] cArr2 = this.chars;
        int i9 = this.beg;
        return new String(cArr2, i9, i7 - i9);
    }

    private String quotedAV() {
        int i = this.pos + 1;
        this.pos = i;
        this.beg = i;
        while (true) {
            this.end = i;
            int i2 = this.pos;
            if (i2 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            char[] cArr = this.chars;
            char c = cArr[i2];
            if (c == '\"') {
                do {
                    this.pos = i2 + 1;
                    i2 = this.pos;
                    if (i2 >= this.length) {
                        break;
                    }
                } while (this.chars[i2] == ' ');
                char[] cArr2 = this.chars;
                int i3 = this.beg;
                return new String(cArr2, i3, this.end - i3);
            }
            if (c == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = c;
            }
            this.pos++;
            i = this.end + 1;
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c = this.chars[i];
            String escapedAV = c != '\"' ? c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : escapedAV() : hexAV() : quotedAV();
            if (str.equalsIgnoreCase(nextAT)) {
                return escapedAV;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char c2 = this.chars[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            this.pos = i2 + 1;
            nextAT = nextAT();
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
