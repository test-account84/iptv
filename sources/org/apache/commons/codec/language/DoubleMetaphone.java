package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DoubleMetaphone implements StringEncoder {
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", "T", "K", "S", "N", "M", "B", "Z"};

    public class DoubleMetaphoneResult {
        private final StringBuilder alternate;
        private final int maxLength;
        private final StringBuilder primary;

        public DoubleMetaphoneResult(int i) {
            this.primary = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.alternate = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.maxLength = i;
        }

        public void append(char c) {
            appendPrimary(c);
            appendAlternate(c);
        }

        public void appendAlternate(char c) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c);
            }
        }

        public void appendPrimary(char c) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c);
            }
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }

        public void append(char c, char c2) {
            appendPrimary(c);
            appendAlternate(c2);
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }
    }

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    private boolean conditionC0(String str, int i) {
        if (contains(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int i2 = i - 2;
        if (isVowel(charAt(str, i2)) || !contains(str, i - 1, 3, "ACH")) {
            return false;
        }
        char charAt = charAt(str, i + 2);
        return !(charAt == 'I' || charAt == 'E') || contains(str, i2, 6, "BACHER", "MACHER");
    }

    private boolean conditionCH0(String str, int i) {
        if (i != 0) {
            return false;
        }
        int i2 = i + 1;
        return (contains(str, i2, 5, "HARAC", "HARIS") || contains(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) && !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int i) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH") && !contains(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i2 = i + 2;
            if (!contains(str, i2, 1, "T", "S")) {
                if (!contains(str, i - 1, 1, "A", "O", "U", "E") && i != 0) {
                    return false;
                }
                if (!contains(str, i2, 1, L_R_N_M_B_H_F_V_W_SPACE) && i + 1 != str.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean conditionL0(String str, int i) {
        if (i == str.length() - 3 && contains(str, i - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (contains(str, str.length() - 2, 2, "AS", "OS") || contains(str, str.length() - 1, 1, "A", "O")) && contains(str, i - 1, 4, "ALLE");
    }

    private boolean conditionM0(String str, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'M') {
            return true;
        }
        return contains(str, i + (-1), 3, "UMB") && (i2 == str.length() - 1 || contains(str, i + 2, 2, "ER"));
    }

    public static boolean contains(String str, int i, int i2, String... strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        String substring = str.substring(i, i3);
        for (String str2 : strArr) {
            if (substring.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0009  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int handleC(java.lang.String r12, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r13, int r14) {
        /*
            r11 = this;
            boolean r0 = r11.conditionC0(r12, r14)
            r1 = 75
            r2 = 2
            if (r0 == 0) goto Lf
        L9:
            r13.append(r1)
        Lc:
            int r14 = r14 + r2
            goto Leb
        Lf:
            r0 = 83
            if (r14 != 0) goto L24
            java.lang.String r3 = "CAESAR"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 6
            boolean r3 = contains(r12, r14, r4, r3)
            if (r3 == 0) goto L24
        L20:
            r13.append(r0)
            goto Lc
        L24:
            java.lang.String r3 = "CH"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r12, r14, r2, r3)
            if (r3 == 0) goto L36
            int r14 = r11.handleCH(r12, r13, r14)
            goto Leb
        L36:
            java.lang.String r3 = "CZ"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            boolean r3 = contains(r12, r14, r2, r3)
            r4 = 88
            if (r3 == 0) goto L57
            int r3 = r14 + (-2)
            java.lang.String r5 = "WICZ"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r6 = 4
            boolean r3 = contains(r12, r3, r6, r5)
            if (r3 != 0) goto L57
        L53:
            r13.append(r0, r4)
            goto Lc
        L57:
            int r3 = r14 + 1
            java.lang.String r5 = "CIA"
            java.lang.String[] r6 = new java.lang.String[]{r5}
            r7 = 3
            boolean r6 = contains(r12, r3, r7, r6)
            if (r6 == 0) goto L6c
            r13.append(r4)
        L69:
            int r14 = r14 + r7
            goto Leb
        L6c:
            java.lang.String r6 = "CC"
            java.lang.String[] r6 = new java.lang.String[]{r6}
            boolean r6 = contains(r12, r14, r2, r6)
            r8 = 1
            if (r6 == 0) goto L89
            if (r14 != r8) goto L84
            r6 = 0
            char r6 = r11.charAt(r12, r6)
            r9 = 77
            if (r6 == r9) goto L89
        L84:
            int r12 = r11.handleCC(r12, r13, r14)
            return r12
        L89:
            java.lang.String r6 = "CG"
            java.lang.String r9 = "CQ"
            java.lang.String r10 = "CK"
            java.lang.String[] r6 = new java.lang.String[]{r10, r6, r9}
            boolean r6 = contains(r12, r14, r2, r6)
            if (r6 == 0) goto L9b
            goto L9
        L9b:
            java.lang.String r6 = "CY"
            java.lang.String r9 = "CI"
            java.lang.String r10 = "CE"
            java.lang.String[] r6 = new java.lang.String[]{r9, r10, r6}
            boolean r6 = contains(r12, r14, r2, r6)
            if (r6 == 0) goto Lba
            java.lang.String r1 = "CIO"
            java.lang.String r3 = "CIE"
            java.lang.String[] r1 = new java.lang.String[]{r1, r3, r5}
            boolean r12 = contains(r12, r14, r7, r1)
            if (r12 == 0) goto L20
            goto L53
        Lba:
            r13.append(r1)
            java.lang.String r13 = " Q"
            java.lang.String r0 = " G"
            java.lang.String r1 = " C"
            java.lang.String[] r13 = new java.lang.String[]{r1, r13, r0}
            boolean r13 = contains(r12, r3, r2, r13)
            if (r13 == 0) goto Lce
            goto L69
        Lce:
            java.lang.String r13 = "K"
            java.lang.String r0 = "Q"
            java.lang.String r1 = "C"
            java.lang.String[] r13 = new java.lang.String[]{r1, r13, r0}
            boolean r13 = contains(r12, r3, r8, r13)
            if (r13 == 0) goto Lea
            java.lang.String[] r13 = new java.lang.String[]{r10, r9}
            boolean r12 = contains(r12, r3, r2, r13)
            if (r12 != 0) goto Lea
            goto Lc
        Lea:
            r14 = r3
        Leb:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleC(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (!contains(str, i2, 1, "I", "E", "H") || contains(str, i2, 2, "HU")) {
            doubleMetaphoneResult.append('K');
            return i2;
        }
        if ((i == 1 && charAt(str, i - 1) == 'A') || contains(str, i - 1, 5, "UCCEE", "UCCES")) {
            doubleMetaphoneResult.append("KS");
        } else {
            doubleMetaphoneResult.append('X');
        }
        return i + 3;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && contains(str, i, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else {
            if (!conditionCH0(str, i) && !conditionCH1(str, i)) {
                if (i <= 0) {
                    doubleMetaphoneResult.append('X');
                } else if (contains(str, 0, 2, "MC")) {
                    doubleMetaphoneResult.append('K');
                } else {
                    doubleMetaphoneResult.append('X', 'K');
                }
                return i + 2;
            }
            doubleMetaphoneResult.append('K');
        }
        return i + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (!contains(str, i, 2, "DG")) {
            boolean contains = contains(str, i, 2, "DT", "DD");
            doubleMetaphoneResult.append('T');
            return contains ? i + 2 : i + 1;
        }
        int i2 = i + 2;
        if (contains(str, i2, 1, "I", "E", "Y")) {
            doubleMetaphoneResult.append('J');
            return i + 3;
        }
        doubleMetaphoneResult.append("TK");
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int handleG(java.lang.String r12, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r13, int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleG(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int handleGH(java.lang.String r11, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r12, int r13) {
        /*
            r10 = this;
            r0 = 75
            r1 = 2
            if (r13 <= 0) goto L17
            int r2 = r13 + (-1)
            char r2 = r10.charAt(r11, r2)
            boolean r2 = r10.isVowel(r2)
            if (r2 != 0) goto L17
        L11:
            r12.append(r0)
        L14:
            int r13 = r13 + r1
            goto L94
        L17:
            r2 = 73
            if (r13 != 0) goto L2d
            int r13 = r13 + r1
            char r11 = r10.charAt(r11, r13)
            if (r11 != r2) goto L29
            r11 = 74
            r12.append(r11)
            goto L94
        L29:
            r12.append(r0)
            goto L94
        L2d:
            java.lang.String r3 = "D"
            java.lang.String r4 = "H"
            java.lang.String r5 = "B"
            r6 = 1
            if (r13 <= r6) goto L42
            int r7 = r13 + (-2)
            java.lang.String[] r8 = new java.lang.String[]{r5, r4, r3}
            boolean r7 = contains(r11, r7, r6, r8)
            if (r7 != 0) goto L14
        L42:
            if (r13 <= r1) goto L50
            int r7 = r13 + (-3)
            java.lang.String[] r3 = new java.lang.String[]{r5, r4, r3}
            boolean r3 = contains(r11, r7, r6, r3)
            if (r3 != 0) goto L14
        L50:
            r3 = 3
            if (r13 <= r3) goto L60
            int r3 = r13 + (-4)
            java.lang.String[] r4 = new java.lang.String[]{r5, r4}
            boolean r3 = contains(r11, r3, r6, r4)
            if (r3 == 0) goto L60
            goto L14
        L60:
            if (r13 <= r1) goto L88
            int r3 = r13 + (-1)
            char r3 = r10.charAt(r11, r3)
            r4 = 85
            if (r3 != r4) goto L88
            int r3 = r13 + (-3)
            java.lang.String r4 = "R"
            java.lang.String r5 = "T"
            java.lang.String r7 = "C"
            java.lang.String r8 = "G"
            java.lang.String r9 = "L"
            java.lang.String[] r4 = new java.lang.String[]{r7, r8, r9, r4, r5}
            boolean r3 = contains(r11, r3, r6, r4)
            if (r3 == 0) goto L88
            r11 = 70
            r12.append(r11)
            goto L14
        L88:
            if (r13 <= 0) goto L14
            int r3 = r13 + (-1)
            char r11 = r10.charAt(r11, r3)
            if (r11 == r2) goto L14
            goto L11
        L94:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleGH(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if ((i != 0 && !isVowel(charAt(str, i - 1))) || !isVowel(charAt(str, i + 1))) {
            return i + 1;
        }
        doubleMetaphoneResult.append('H');
        return i + 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int handleJ(java.lang.String r10, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r11, int r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = "JOSE"
            java.lang.String[] r1 = new java.lang.String[]{r0}
            r2 = 4
            boolean r1 = contains(r10, r12, r2, r1)
            r3 = 32
            java.lang.String r4 = "SAN "
            r5 = 0
            r6 = 72
            r7 = 74
            r8 = 1
            if (r1 != 0) goto L89
            java.lang.String[] r1 = new java.lang.String[]{r4}
            boolean r1 = contains(r10, r5, r2, r1)
            if (r1 == 0) goto L22
            goto L89
        L22:
            r1 = 65
            if (r12 != 0) goto L34
            java.lang.String[] r0 = new java.lang.String[]{r0}
            boolean r0 = contains(r10, r12, r2, r0)
            if (r0 != 0) goto L34
            r11.append(r7, r1)
            goto L7e
        L34:
            int r0 = r12 + (-1)
            char r2 = r9.charAt(r10, r0)
            boolean r2 = r9.isVowel(r2)
            if (r2 == 0) goto L56
            if (r13 != 0) goto L56
            int r13 = r12 + 1
            char r2 = r9.charAt(r10, r13)
            if (r2 == r1) goto L52
            char r13 = r9.charAt(r10, r13)
            r1 = 79
            if (r13 != r1) goto L56
        L52:
            r11.append(r7, r6)
            goto L7e
        L56:
            int r13 = r10.length()
            int r13 = r13 - r8
            if (r12 != r13) goto L61
            r11.append(r7, r3)
            goto L7e
        L61:
            int r13 = r12 + 1
            java.lang.String[] r1 = org.apache.commons.codec.language.DoubleMetaphone.L_T_K_S_N_M_B_Z
            boolean r13 = contains(r10, r13, r8, r1)
            if (r13 != 0) goto L7e
            java.lang.String r13 = "K"
            java.lang.String r1 = "L"
            java.lang.String r2 = "S"
            java.lang.String[] r13 = new java.lang.String[]{r2, r13, r1}
            boolean r13 = contains(r10, r0, r8, r13)
            if (r13 != 0) goto L7e
            r11.append(r7)
        L7e:
            int r11 = r12 + 1
            char r10 = r9.charAt(r10, r11)
            if (r10 != r7) goto Lad
            int r11 = r12 + 2
            goto Lad
        L89:
            if (r12 != 0) goto L93
            int r13 = r12 + 4
            char r13 = r9.charAt(r10, r13)
            if (r13 == r3) goto La8
        L93:
            int r13 = r10.length()
            if (r13 == r2) goto La8
            java.lang.String[] r13 = new java.lang.String[]{r4}
            boolean r10 = contains(r10, r5, r2, r13)
            if (r10 == 0) goto La4
            goto La8
        La4:
            r11.append(r7, r6)
            goto Lab
        La8:
            r11.append(r6)
        Lab:
            int r11 = r12 + 1
        Lad:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleJ(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) != 'L') {
            doubleMetaphoneResult.append('L');
            return i2;
        }
        if (conditionL0(str, i)) {
            doubleMetaphoneResult.appendPrimary('L');
        } else {
            doubleMetaphoneResult.append('L');
        }
        return i + 2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('F');
            return i + 2;
        }
        doubleMetaphoneResult.append('P');
        if (contains(str, i2, 1, "P", "B")) {
            i2 = i + 2;
        }
        return i2;
    }

    private int handleR(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (i != str.length() - 1 || z || !contains(str, i - 2, 2, "IE") || contains(str, i - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.append('R');
        } else {
            doubleMetaphoneResult.appendAlternate('R');
        }
        int i2 = i + 1;
        return charAt(str, i2) == 'R' ? i + 2 : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int handleS(java.lang.String r10, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleS(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int handleSC(java.lang.String r13, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r14, int r15) {
        /*
            r12 = this;
            int r0 = r15 + 2
            char r1 = r12.charAt(r13, r0)
            r2 = 72
            r3 = 83
            java.lang.String r4 = "SK"
            r5 = 3
            if (r1 != r2) goto L5e
            int r0 = r15 + 3
            java.lang.String r10 = "ED"
            java.lang.String r11 = "EM"
            java.lang.String r6 = "OO"
            java.lang.String r7 = "ER"
            java.lang.String r8 = "EN"
            java.lang.String r9 = "UY"
            java.lang.String[] r1 = new java.lang.String[]{r6, r7, r8, r9, r10, r11}
            r2 = 2
            boolean r1 = contains(r13, r0, r2, r1)
            if (r1 == 0) goto L40
            java.lang.String r1 = "ER"
            java.lang.String r3 = "EN"
            java.lang.String[] r1 = new java.lang.String[]{r1, r3}
            boolean r13 = contains(r13, r0, r2, r1)
            if (r13 == 0) goto L3c
            java.lang.String r13 = "X"
            r14.append(r13, r4)
            goto L72
        L3c:
            r14.append(r4)
            goto L72
        L40:
            r0 = 88
            if (r15 != 0) goto L5a
            char r1 = r12.charAt(r13, r5)
            boolean r1 = r12.isVowel(r1)
            if (r1 != 0) goto L5a
            char r13 = r12.charAt(r13, r5)
            r1 = 87
            if (r13 == r1) goto L5a
            r14.append(r0, r3)
            goto L72
        L5a:
            r14.append(r0)
            goto L72
        L5e:
            java.lang.String r1 = "E"
            java.lang.String r2 = "Y"
            java.lang.String r6 = "I"
            java.lang.String[] r1 = new java.lang.String[]{r6, r1, r2}
            r2 = 1
            boolean r13 = contains(r13, r0, r2, r1)
            if (r13 == 0) goto L3c
            r14.append(r3)
        L72:
            int r15 = r15 + r5
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleSC(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 4, "TION") || contains(str, i, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
            return i + 3;
        }
        if (!contains(str, i, 2, "TH") && !contains(str, i, 3, "TTH")) {
            doubleMetaphoneResult.append('T');
            int i2 = i + 1;
            return contains(str, i2, 1, "T", "D") ? i + 2 : i2;
        }
        int i3 = i + 2;
        if (contains(str, i3, 2, "OM", "AM") || contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH")) {
            doubleMetaphoneResult.append('T');
            return i3;
        }
        doubleMetaphoneResult.append('0', 'T');
        return i3;
    }

    private int handleW(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = 2;
        if (!contains(str, i, 2, "WR")) {
            if (i == 0) {
                int i3 = i + 1;
                if (isVowel(charAt(str, i3)) || contains(str, i, 2, "WH")) {
                    if (isVowel(charAt(str, i3))) {
                        doubleMetaphoneResult.append('A', 'F');
                    } else {
                        doubleMetaphoneResult.append('A');
                    }
                    return i3;
                }
            }
            if ((i == str.length() - 1 && isVowel(charAt(str, i - 1))) || contains(str, i - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || contains(str, 0, 3, "SCH")) {
                doubleMetaphoneResult.appendAlternate('F');
            } else {
                i2 = 4;
                if (contains(str, i, 4, "WICZ", "WITZ")) {
                    doubleMetaphoneResult.append("TS", "FX");
                }
            }
            return i + 1;
        }
        doubleMetaphoneResult.append('R');
        return i + i2;
    }

    private int handleX(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('S');
            return i + 1;
        }
        if (i != str.length() - 1 || (!contains(str, i - 3, 3, "IAU", "EAU") && !contains(str, i - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append("KS");
        }
        int i2 = i + 1;
        return contains(str, i2, 1, "C", "X") ? i + 2 : i2;
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('J');
            return i + 2;
        }
        if (contains(str, i2, 2, "ZO", "ZI", "ZA") || (z && i > 0 && charAt(str, i - 1) != 'T')) {
            doubleMetaphoneResult.append("S", "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        if (charAt(str, i2) == 'Z') {
            i2 = i + 2;
        }
        return i2;
    }

    private boolean isSilentStart(String str) {
        for (String str2 : SILENT_START) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c) {
        return "AEIOUY".indexOf(c) != -1;
    }

    public char charAt(String str, int i) {
        if (i < 0 || i >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i);
    }

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.commons.codec.language.DoubleMetaphone] */
    public String doubleMetaphone(String str, boolean z) {
        int i;
        String cleanInput = cleanInput(str);
        if (cleanInput == null) {
            return null;
        }
        boolean isSlavoGermanic = isSlavoGermanic(cleanInput);
        ?? isSilentStart = isSilentStart(cleanInput);
        DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(getMaxCodeLen());
        while (!doubleMetaphoneResult.isComplete() && isSilentStart <= cleanInput.length() - 1) {
            char charAt = cleanInput.charAt((int) isSilentStart);
            if (charAt == 199) {
                doubleMetaphoneResult.append('S');
            } else if (charAt != 209) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        isSilentStart = handleAEIOUY(doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'B':
                        doubleMetaphoneResult.append('P');
                        i = isSilentStart + 1;
                        if (charAt(cleanInput, i) != 'B') {
                            isSilentStart = i;
                            break;
                        } else {
                            isSilentStart += 2;
                            break;
                        }
                    case 'C':
                        isSilentStart = handleC(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'D':
                        isSilentStart = handleD(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'F':
                        doubleMetaphoneResult.append('F');
                        i = isSilentStart + 1;
                        if (charAt(cleanInput, i) != 'F') {
                            isSilentStart = i;
                            break;
                        } else {
                            isSilentStart += 2;
                            break;
                        }
                    case 'G':
                        isSilentStart = handleG(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                    case 'H':
                        isSilentStart = handleH(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'J':
                        isSilentStart = handleJ(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                    case 'K':
                        doubleMetaphoneResult.append('K');
                        i = isSilentStart + 1;
                        if (charAt(cleanInput, i) != 'K') {
                            isSilentStart = i;
                            break;
                        } else {
                            isSilentStart += 2;
                            break;
                        }
                    case 'L':
                        isSilentStart = handleL(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'M':
                        doubleMetaphoneResult.append('M');
                        if (!conditionM0(cleanInput, isSilentStart)) {
                            break;
                        } else {
                            isSilentStart += 2;
                            break;
                        }
                    case 'N':
                        doubleMetaphoneResult.append('N');
                        i = isSilentStart + 1;
                        if (charAt(cleanInput, i) != 'N') {
                            isSilentStart = i;
                            break;
                        } else {
                            isSilentStart += 2;
                            break;
                        }
                    case 'P':
                        isSilentStart = handleP(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'Q':
                        doubleMetaphoneResult.append('K');
                        i = isSilentStart + 1;
                        if (charAt(cleanInput, i) != 'Q') {
                            isSilentStart = i;
                            break;
                        } else {
                            isSilentStart += 2;
                            break;
                        }
                    case 'R':
                        isSilentStart = handleR(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                    case 'S':
                        isSilentStart = handleS(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                    case 'T':
                        isSilentStart = handleT(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'V':
                        doubleMetaphoneResult.append('F');
                        i = isSilentStart + 1;
                        if (charAt(cleanInput, i) != 'V') {
                            isSilentStart = i;
                            break;
                        } else {
                            isSilentStart += 2;
                            break;
                        }
                    case 'W':
                        isSilentStart = handleW(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'X':
                        isSilentStart = handleX(cleanInput, doubleMetaphoneResult, isSilentStart);
                        break;
                    case 'Z':
                        isSilentStart = handleZ(cleanInput, doubleMetaphoneResult, isSilentStart, isSlavoGermanic);
                        break;
                }
            } else {
                doubleMetaphoneResult.append('N');
            }
            isSilentStart++;
        }
        return z ? doubleMetaphoneResult.getAlternate() : doubleMetaphoneResult.getPrimary();
    }

    public String encode(String str) {
        return doubleMetaphone(str);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return StringUtils.equals(doubleMetaphone(str, z), doubleMetaphone(str2, z));
    }
}
