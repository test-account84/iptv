package J1;

import J1.e;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b extends e {
    public static final ByteString n = ByteString.encodeUtf8("'\\");
    public static final ByteString o = ByteString.encodeUtf8("\"\\");
    public static final ByteString p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    public static final ByteString q = ByteString.encodeUtf8("\n\r");
    public final BufferedSource d;
    public final Buffer e;
    public long g;
    public int h;
    public String i;
    public final int[] j;
    public final String[] l;
    public final int[] m;
    public boolean a = false;
    public boolean c = false;
    public int f = 0;
    public int k = 1;

    public b(BufferedSource bufferedSource) {
        int[] iArr = new int[32];
        this.j = iArr;
        iArr[0] = 6;
        this.l = new String[32];
        this.m = new int[32];
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.d = bufferedSource;
        this.e = bufferedSource.buffer();
    }

    public final void T(ByteString byteString) {
        while (true) {
            long indexOfElement = this.d.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw c0("Unterminated string");
            }
            if (this.e.getByte(indexOfElement) != 92) {
                this.e.skip(indexOfElement + 1);
                return;
            } else {
                this.e.skip(indexOfElement + 1);
                w();
            }
        }
    }

    public final boolean V(String str) {
        while (true) {
            if (!this.d.request(str.length())) {
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                if (this.e.getByte(i) != str.charAt(i)) {
                    break;
                }
            }
            return true;
            this.e.readByte();
        }
    }

    public final void Y() {
        long indexOfElement = this.d.indexOfElement(q);
        Buffer buffer = this.e;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    public void a() {
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        if (i == 3) {
            v(1);
            this.m[this.k - 1] = 0;
            this.f = 0;
        } else {
            throw new N1.a("Expected BEGIN_ARRAY but was " + k() + " at path " + getPath());
        }
    }

    public final void b0() {
        long indexOfElement = this.d.indexOfElement(p);
        Buffer buffer = this.e;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    public void c() {
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        if (i == 1) {
            v(3);
            this.f = 0;
            return;
        }
        throw new N1.a("Expected BEGIN_OBJECT but was " + k() + " at path " + getPath());
    }

    public final N1.b c0(String str) {
        throw new N1.b(str + " at path " + getPath());
    }

    public void close() {
        this.f = 0;
        this.j[0] = 8;
        this.k = 1;
        this.e.clear();
        this.d.close();
    }

    public void d() {
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        if (i != 4) {
            throw new N1.a("Expected END_ARRAY but was " + k() + " at path " + getPath());
        }
        int i2 = this.k;
        this.k = i2 - 1;
        int[] iArr = this.m;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f = 0;
    }

    public void e() {
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        if (i != 2) {
            throw new N1.a("Expected END_OBJECT but was " + k() + " at path " + getPath());
        }
        int i2 = this.k;
        int i3 = i2 - 1;
        this.k = i3;
        this.l[i3] = null;
        int[] iArr = this.m;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f = 0;
    }

    public boolean g() {
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public String getPath() {
        return f.a(this.k, this.j, this.l, this.m);
    }

    public boolean h() {
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        if (i == 5) {
            this.f = 0;
            int[] iArr = this.m;
            int i2 = this.k - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i == 6) {
            this.f = 0;
            int[] iArr2 = this.m;
            int i3 = this.k - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new N1.a("Expected a boolean but was " + k() + " at path " + getPath());
    }

    public String i() {
        ByteString byteString;
        String q2;
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        if (i == 14) {
            q2 = r();
        } else {
            if (i == 13) {
                byteString = o;
            } else {
                if (i != 12) {
                    throw new N1.a("Expected a name but was " + k() + " at path " + getPath());
                }
                byteString = n;
            }
            q2 = q(byteString);
        }
        this.f = 0;
        this.l[this.k - 1] = q2;
        return q2;
    }

    public String j() {
        String readUtf8;
        ByteString byteString;
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        if (i == 10) {
            readUtf8 = r();
        } else {
            if (i == 9) {
                byteString = o;
            } else if (i == 8) {
                byteString = n;
            } else if (i == 11) {
                readUtf8 = this.i;
                this.i = null;
            } else if (i == 15) {
                readUtf8 = Long.toString(this.g);
            } else {
                if (i != 16) {
                    throw new N1.a("Expected a string but was " + k() + " at path " + getPath());
                }
                readUtf8 = this.e.readUtf8(this.h);
            }
            readUtf8 = q(byteString);
        }
        this.f = 0;
        int[] iArr = this.m;
        int i2 = this.k - 1;
        iArr[i2] = iArr[i2] + 1;
        return readUtf8;
    }

    public e.a k() {
        int i = this.f;
        if (i == 0) {
            i = n();
        }
        switch (i) {
            case 1:
                return e.a.BEGIN_OBJECT;
            case 2:
                return e.a.END_OBJECT;
            case 3:
                return e.a.BEGIN_ARRAY;
            case 4:
                return e.a.END_ARRAY;
            case 5:
            case 6:
                return e.a.BOOLEAN;
            case 7:
                return e.a.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return e.a.STRING;
            case 12:
            case 13:
            case 14:
                return e.a.NAME;
            case 15:
            case 16:
                return e.a.NUMBER;
            case 17:
                return e.a.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void l() {
        ByteString byteString;
        if (this.c) {
            throw new N1.a("Cannot skip unexpected " + k() + " at " + getPath());
        }
        int i = 0;
        do {
            int i2 = this.f;
            if (i2 == 0) {
                i2 = n();
            }
            if (i2 == 3) {
                v(1);
            } else if (i2 == 1) {
                v(3);
            } else {
                if (i2 == 4 || i2 == 2) {
                    this.k--;
                    i--;
                } else if (i2 == 14 || i2 == 10) {
                    b0();
                } else {
                    if (i2 == 9 || i2 == 13) {
                        byteString = o;
                    } else if (i2 == 8 || i2 == 12) {
                        byteString = n;
                    } else if (i2 == 16) {
                        this.e.skip(this.h);
                    }
                    T(byteString);
                }
                this.f = 0;
            }
            i++;
            this.f = 0;
        } while (i != 0);
        int[] iArr = this.m;
        int i3 = this.k;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.l[i3 - 1] = "null";
    }

    public final void m() {
        if (!this.a) {
            throw c0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int n() {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.b.n():int");
    }

    public final boolean o(int i) {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.e.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 != 47) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (r6.d.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        m();
        r3 = r6.e.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (r3 == 42) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        r6.e.readByte();
        r6.e.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (V("*\/") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        r6.e.readByte();
        r6.e.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        throw c0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
    
        r6.e.readByte();
        r6.e.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0056, code lost:
    
        Y();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0039, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
    
        if (r2 != 35) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0082, code lost:
    
        m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0086, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int p(boolean r7) {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.BufferedSource r2 = r6.d
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L8a
            okio.Buffer r2 = r6.e
            long r4 = (long) r1
            byte r2 = r2.getByte(r4)
            r4 = 10
            if (r2 == r4) goto L87
            r4 = 32
            if (r2 == r4) goto L87
            r4 = 13
            if (r2 == r4) goto L87
            r4 = 9
            if (r2 != r4) goto L25
            goto L87
        L25:
            okio.Buffer r3 = r6.e
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L7e
            okio.BufferedSource r3 = r6.d
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3a
            return r2
        L3a:
            r6.m()
            okio.Buffer r3 = r6.e
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            return r2
        L4c:
            okio.Buffer r1 = r6.e
            r1.readByte()
            okio.Buffer r1 = r6.e
            r1.readByte()
        L56:
            r6.Y()
            goto L1
        L5a:
            okio.Buffer r1 = r6.e
            r1.readByte()
            okio.Buffer r1 = r6.e
            r1.readByte()
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r6.V(r1)
            if (r1 == 0) goto L77
            okio.Buffer r1 = r6.e
            r1.readByte()
            okio.Buffer r1 = r6.e
            r1.readByte()
            goto L1
        L77:
            java.lang.String r7 = "Unterminated comment"
            N1.b r7 = r6.c0(r7)
            throw r7
        L7e:
            r1 = 35
            if (r2 != r1) goto L86
            r6.m()
            goto L56
        L86:
            return r2
        L87:
            r1 = r3
            goto L2
        L8a:
            if (r7 != 0) goto L8e
            r7 = -1
            return r7
        L8e:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.b.p(boolean):int");
    }

    public final String q(ByteString byteString) {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.d.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw c0("Unterminated string");
            }
            if (this.e.getByte(indexOfElement) != 92) {
                String readUtf8 = this.e.readUtf8(indexOfElement);
                if (sb == null) {
                    this.e.readByte();
                    return readUtf8;
                }
                sb.append(readUtf8);
                this.e.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.e.readUtf8(indexOfElement));
            this.e.readByte();
            sb.append(w());
        }
    }

    public final String r() {
        long indexOfElement = this.d.indexOfElement(p);
        return indexOfElement != -1 ? this.e.readUtf8(indexOfElement) : this.e.readUtf8();
    }

    public final int s() {
        String str;
        String str2;
        int i;
        byte b = this.e.getByte(0L);
        if (b == 116 || b == 84) {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (b == 102 || b == 70) {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (b != 110 && b != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.d.request(i3)) {
                return 0;
            }
            byte b2 = this.e.getByte(i2);
            if (b2 != str.charAt(i2) && b2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.d.request(length + 1) && o(this.e.getByte(length))) {
            return 0;
        }
        this.e.skip(length);
        this.f = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0080, code lost:
    
        if (o(r11) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
    
        if (r6 != 2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0084, code lost:
    
        if (r7 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008a, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008c, code lost:
    
        if (r10 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008e, code lost:
    
        if (r10 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        r16.g = r8;
        r16.e.skip(r5);
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
    
        r16.f = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r6 == 2) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a2, code lost:
    
        if (r6 == 4) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a5, code lost:
    
        if (r6 != 7) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00a8, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a9, code lost:
    
        r16.h = r5;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ae, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int t() {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.b.t():int");
    }

    public String toString() {
        return "JsonReader(" + this.d + ")";
    }

    public final void v(int i) {
        int i2 = this.k;
        int[] iArr = this.j;
        if (i2 != iArr.length) {
            this.k = i2 + 1;
            iArr[i2] = i;
        } else {
            throw new N1.a("Nesting too deep at " + getPath());
        }
    }

    public final char w() {
        int i;
        if (!this.d.request(1L)) {
            throw c0("Unterminated escape sequence");
        }
        byte readByte = this.e.readByte();
        if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
            return (char) readByte;
        }
        if (readByte == 98) {
            return '\b';
        }
        if (readByte == 102) {
            return '\f';
        }
        if (readByte == 110) {
            return '\n';
        }
        if (readByte == 114) {
            return '\r';
        }
        if (readByte == 116) {
            return '\t';
        }
        if (readByte != 117) {
            if (this.a) {
                return (char) readByte;
            }
            throw c0("Invalid escape sequence: \\" + ((char) readByte));
        }
        if (!this.d.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = this.e.getByte(i2);
            char c2 = (char) (c << 4);
            if (b >= 48 && b <= 57) {
                i = b - 48;
            } else if (b >= 97 && b <= 102) {
                i = b - 87;
            } else {
                if (b < 65 || b > 70) {
                    throw c0("\\u" + this.e.readUtf8(4L));
                }
                i = b - 55;
            }
            c = (char) (c2 + i);
        }
        this.e.skip(4L);
        return c;
    }
}
