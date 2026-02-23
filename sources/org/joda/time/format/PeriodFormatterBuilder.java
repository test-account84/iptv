package org.joda.time.format;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.joda.time.DurationFieldType;
import org.joda.time.PeriodType;
import org.joda.time.ReadWritablePeriod;
import org.joda.time.ReadablePeriod;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PeriodFormatterBuilder {
    private static final int DAYS = 3;
    private static final int HOURS = 4;
    private static final int MAX_FIELD = 9;
    private static final int MILLIS = 7;
    private static final int MINUTES = 5;
    private static final int MONTHS = 1;
    private static final ConcurrentMap PATTERNS = new ConcurrentHashMap();
    private static final int PRINT_ZERO_ALWAYS = 4;
    private static final int PRINT_ZERO_IF_SUPPORTED = 3;
    private static final int PRINT_ZERO_NEVER = 5;
    private static final int PRINT_ZERO_RARELY_FIRST = 1;
    private static final int PRINT_ZERO_RARELY_LAST = 2;
    private static final int SECONDS = 6;
    private static final int SECONDS_MILLIS = 8;
    private static final int SECONDS_OPTIONAL_MILLIS = 9;
    private static final int WEEKS = 2;
    private static final int YEARS = 0;
    private List iElementPairs;
    private FieldFormatter[] iFieldFormatters;
    private int iMaxParsedDigits;
    private int iMinPrintedDigits;
    private boolean iNotParser;
    private boolean iNotPrinter;
    private PeriodFieldAffix iPrefix;
    private int iPrintZeroSetting;
    private boolean iRejectSignedValues;

    public static class Composite implements PeriodPrinter, PeriodParser {
        private final PeriodParser[] iParsers;
        private final PeriodPrinter[] iPrinters;

        public Composite(List list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            decompose(list, arrayList, arrayList2);
            if (arrayList.size() <= 0) {
                this.iPrinters = null;
            } else {
                this.iPrinters = (PeriodPrinter[]) arrayList.toArray(new PeriodPrinter[arrayList.size()]);
            }
            if (arrayList2.size() <= 0) {
                this.iParsers = null;
            } else {
                this.iParsers = (PeriodParser[]) arrayList2.toArray(new PeriodParser[arrayList2.size()]);
            }
        }

        private void addArrayToList(List list, Object[] objArr) {
            if (objArr != null) {
                for (Object obj : objArr) {
                    list.add(obj);
                }
            }
        }

        private void decompose(List list, List list2, List list3) {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = list.get(i);
                if (obj instanceof PeriodPrinter) {
                    if (obj instanceof Composite) {
                        addArrayToList(list2, ((Composite) obj).iPrinters);
                    } else {
                        list2.add(obj);
                    }
                }
                Object obj2 = list.get(i + 1);
                if (obj2 instanceof PeriodParser) {
                    if (obj2 instanceof Composite) {
                        addArrayToList(list3, ((Composite) obj2).iParsers);
                    } else {
                        list3.add(obj2);
                    }
                }
            }
        }

        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            PeriodPrinter[] periodPrinterArr = this.iPrinters;
            int length = periodPrinterArr.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i;
                }
                i += periodPrinterArr[length].calculatePrintedLength(readablePeriod, locale);
            }
        }

        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i, Locale locale) {
            PeriodPrinter[] periodPrinterArr = this.iPrinters;
            int length = periodPrinterArr.length;
            int i2 = 0;
            while (i2 < i) {
                length--;
                if (length < 0) {
                    break;
                }
                i2 += periodPrinterArr[length].countFieldsToPrint(readablePeriod, Integer.MAX_VALUE, locale);
            }
            return i2;
        }

        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i, Locale locale) {
            PeriodParser[] periodParserArr = this.iParsers;
            if (periodParserArr == null) {
                throw new UnsupportedOperationException();
            }
            int length = periodParserArr.length;
            for (int i2 = 0; i2 < length && i >= 0; i2++) {
                i = periodParserArr[i2].parseInto(readWritablePeriod, str, i, locale);
            }
            return i;
        }

        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            for (PeriodPrinter periodPrinter : this.iPrinters) {
                periodPrinter.printTo(writer, readablePeriod, locale);
            }
        }

        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            for (PeriodPrinter periodPrinter : this.iPrinters) {
                periodPrinter.printTo(stringBuffer, readablePeriod, locale);
            }
        }
    }

    public static class CompositeAffix extends IgnorableAffix {
        private final PeriodFieldAffix iLeft;
        private final String[] iLeftRightCombinations;
        private final PeriodFieldAffix iRight;

        public CompositeAffix(PeriodFieldAffix periodFieldAffix, PeriodFieldAffix periodFieldAffix2) {
            this.iLeft = periodFieldAffix;
            this.iRight = periodFieldAffix2;
            HashSet hashSet = new HashSet();
            for (String str : periodFieldAffix.getAffixes()) {
                for (String str2 : this.iRight.getAffixes()) {
                    hashSet.add(str + str2);
                }
            }
            this.iLeftRightCombinations = (String[]) hashSet.toArray(new String[hashSet.size()]);
        }

        public int calculatePrintedLength(int i) {
            return this.iLeft.calculatePrintedLength(i) + this.iRight.calculatePrintedLength(i);
        }

        public String[] getAffixes() {
            return (String[]) this.iLeftRightCombinations.clone();
        }

        public int parse(String str, int i) {
            int parse = this.iLeft.parse(str, i);
            return (parse < 0 || (parse = this.iRight.parse(str, parse)) < 0 || !matchesOtherAffix(parse(str, parse) - parse, str, i)) ? parse : ~i;
        }

        public void printTo(Writer writer, int i) throws IOException {
            this.iLeft.printTo(writer, i);
            this.iRight.printTo(writer, i);
        }

        public int scan(String str, int i) {
            int scan;
            int scan2 = this.iLeft.scan(str, i);
            return (scan2 < 0 || ((scan = this.iRight.scan(str, this.iLeft.parse(str, scan2))) >= 0 && matchesOtherAffix(this.iRight.parse(str, scan) - scan2, str, i))) ? ~i : scan2 > 0 ? scan2 : scan;
        }

        public void printTo(StringBuffer stringBuffer, int i) {
            this.iLeft.printTo(stringBuffer, i);
            this.iRight.printTo(stringBuffer, i);
        }
    }

    public static class FieldFormatter implements PeriodPrinter, PeriodParser {
        private final FieldFormatter[] iFieldFormatters;
        private final int iFieldType;
        private final int iMaxParsedDigits;
        private final int iMinPrintedDigits;
        private final PeriodFieldAffix iPrefix;
        private final int iPrintZeroSetting;
        private final boolean iRejectSignedValues;
        private final PeriodFieldAffix iSuffix;

        public FieldFormatter(int i, int i2, int i3, boolean z, int i4, FieldFormatter[] fieldFormatterArr, PeriodFieldAffix periodFieldAffix, PeriodFieldAffix periodFieldAffix2) {
            this.iMinPrintedDigits = i;
            this.iPrintZeroSetting = i2;
            this.iMaxParsedDigits = i3;
            this.iRejectSignedValues = z;
            this.iFieldType = i4;
            this.iFieldFormatters = fieldFormatterArr;
            this.iPrefix = periodFieldAffix;
            this.iSuffix = periodFieldAffix2;
        }

        private int parseInt(String str, int i, int i2) {
            if (i2 >= 10) {
                return Integer.parseInt(str.substring(i, i2 + i));
            }
            boolean z = false;
            if (i2 <= 0) {
                return 0;
            }
            int i3 = i + 1;
            char charAt = str.charAt(i);
            int i4 = i2 - 1;
            if (charAt == '-') {
                i4 = i2 - 2;
                if (i4 < 0) {
                    return 0;
                }
                charAt = str.charAt(i3);
                z = true;
                i3 = i + 2;
            }
            int i5 = charAt - '0';
            while (true) {
                int i6 = i4 - 1;
                if (i4 <= 0) {
                    break;
                }
                int charAt2 = (((i5 << 3) + (i5 << 1)) + str.charAt(i3)) - 48;
                i4 = i6;
                i3++;
                i5 = charAt2;
            }
            return z ? -i5 : i5;
        }

        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue == Long.MAX_VALUE) {
                return 0;
            }
            int max = Math.max(FormatUtils.calculateDigitCount(fieldValue), this.iMinPrintedDigits);
            if (this.iFieldType >= 8) {
                int max2 = Math.max(max, fieldValue < 0 ? 5 : 4);
                max = (this.iFieldType == 9 && Math.abs(fieldValue) % 1000 == 0) ? max2 - 3 : max2 + 1;
                fieldValue /= 1000;
            }
            int i = (int) fieldValue;
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                max += periodFieldAffix.calculatePrintedLength(i);
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            return periodFieldAffix2 != null ? max + periodFieldAffix2.calculatePrintedLength(i) : max;
        }

        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i, Locale locale) {
            if (i <= 0) {
                return 0;
            }
            return (this.iPrintZeroSetting == 4 || getFieldValue(readablePeriod) != Long.MAX_VALUE) ? 1 : 0;
        }

        public void finish(FieldFormatter[] fieldFormatterArr) {
            Set hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            for (FieldFormatter fieldFormatter : fieldFormatterArr) {
                if (fieldFormatter != null && !equals(fieldFormatter)) {
                    hashSet.add(fieldFormatter.iPrefix);
                    hashSet2.add(fieldFormatter.iSuffix);
                }
            }
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                periodFieldAffix.finish(hashSet);
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            if (periodFieldAffix2 != null) {
                periodFieldAffix2.finish(hashSet2);
            }
        }

        public int getFieldType() {
            return this.iFieldType;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long getFieldValue(org.joda.time.ReadablePeriod r10) {
            /*
                r9 = this;
                int r0 = r9.iPrintZeroSetting
                r1 = 4
                if (r0 != r1) goto L7
                r0 = 0
                goto Lb
            L7:
                org.joda.time.PeriodType r0 = r10.getPeriodType()
            Lb:
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                if (r0 == 0) goto L1b
                int r3 = r9.iFieldType
                boolean r3 = r9.isSupported(r0, r3)
                if (r3 != 0) goto L1b
                return r1
            L1b:
                int r3 = r9.iFieldType
                switch(r3) {
                    case 0: goto L61;
                    case 1: goto L5c;
                    case 2: goto L57;
                    case 3: goto L52;
                    case 4: goto L4d;
                    case 5: goto L48;
                    case 6: goto L43;
                    case 7: goto L39;
                    case 8: goto L21;
                    case 9: goto L21;
                    default: goto L20;
                }
            L20:
                return r1
            L21:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.seconds()
                int r3 = r10.get(r3)
                org.joda.time.DurationFieldType r4 = org.joda.time.DurationFieldType.millis()
                int r4 = r10.get(r4)
                long r5 = (long) r3
                r7 = 1000(0x3e8, double:4.94E-321)
                long r5 = r5 * r7
                long r3 = (long) r4
                long r5 = r5 + r3
                goto L66
            L39:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.millis()
            L3d:
                int r3 = r10.get(r3)
                long r5 = (long) r3
                goto L66
            L43:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.seconds()
                goto L3d
            L48:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.minutes()
                goto L3d
            L4d:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.hours()
                goto L3d
            L52:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.days()
                goto L3d
            L57:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.weeks()
                goto L3d
            L5c:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.months()
                goto L3d
            L61:
                org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.years()
                goto L3d
            L66:
                r3 = 0
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 != 0) goto Lc4
                int r3 = r9.iPrintZeroSetting
                r4 = 9
                r7 = 1
                if (r3 == r7) goto L9d
                r8 = 2
                if (r3 == r8) goto L7b
                r10 = 5
                if (r3 == r10) goto L7a
                goto Lc4
            L7a:
                return r1
            L7b:
                boolean r10 = r9.isZero(r10)
                if (r10 == 0) goto L9c
                org.joda.time.format.PeriodFormatterBuilder$FieldFormatter[] r10 = r9.iFieldFormatters
                int r3 = r9.iFieldType
                r10 = r10[r3]
                if (r10 != r9) goto L9c
                int r3 = r3 + r7
            L8a:
                if (r3 > r4) goto Lc4
                boolean r10 = r9.isSupported(r0, r3)
                if (r10 == 0) goto L99
                org.joda.time.format.PeriodFormatterBuilder$FieldFormatter[] r10 = r9.iFieldFormatters
                r10 = r10[r3]
                if (r10 == 0) goto L99
                return r1
            L99:
                int r3 = r3 + 1
                goto L8a
            L9c:
                return r1
            L9d:
                boolean r10 = r9.isZero(r10)
                if (r10 == 0) goto Lc3
                org.joda.time.format.PeriodFormatterBuilder$FieldFormatter[] r10 = r9.iFieldFormatters
                int r3 = r9.iFieldType
                r10 = r10[r3]
                if (r10 != r9) goto Lc3
                r10 = 8
                int r10 = java.lang.Math.min(r3, r10)
            Lb1:
                int r10 = r10 + (-1)
                if (r10 < 0) goto Lc4
                if (r10 > r4) goto Lc4
                boolean r3 = r9.isSupported(r0, r10)
                if (r3 == 0) goto Lb1
                org.joda.time.format.PeriodFormatterBuilder$FieldFormatter[] r3 = r9.iFieldFormatters
                r3 = r3[r10]
                if (r3 == 0) goto Lb1
            Lc3:
                return r1
            Lc4:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.PeriodFormatterBuilder.FieldFormatter.getFieldValue(org.joda.time.ReadablePeriod):long");
        }

        public boolean isSupported(PeriodType periodType, int i) {
            DurationFieldType years;
            switch (i) {
                case 0:
                    years = DurationFieldType.years();
                    break;
                case 1:
                    years = DurationFieldType.months();
                    break;
                case 2:
                    years = DurationFieldType.weeks();
                    break;
                case 3:
                    years = DurationFieldType.days();
                    break;
                case 4:
                    years = DurationFieldType.hours();
                    break;
                case 5:
                    years = DurationFieldType.minutes();
                    break;
                case 6:
                    years = DurationFieldType.seconds();
                    break;
                case 7:
                    years = DurationFieldType.millis();
                    break;
                case 8:
                case 9:
                    return periodType.isSupported(DurationFieldType.seconds()) || periodType.isSupported(DurationFieldType.millis());
                default:
                    return false;
            }
            return periodType.isSupported(years);
        }

        public boolean isZero(ReadablePeriod readablePeriod) {
            int size = readablePeriod.size();
            for (int i = 0; i < size; i++) {
                if (readablePeriod.getValue(i) != 0) {
                    return false;
                }
            }
            return true;
        }

        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i, Locale locale) {
            int i2;
            int i3;
            PeriodFieldAffix periodFieldAffix;
            int i4;
            char charAt;
            int i5 = i;
            boolean z = this.iPrintZeroSetting == 4;
            if (i5 >= str.length()) {
                return z ? ~i5 : i5;
            }
            PeriodFieldAffix periodFieldAffix2 = this.iPrefix;
            if (periodFieldAffix2 != null) {
                i5 = periodFieldAffix2.parse(str, i5);
                if (i5 < 0) {
                    return !z ? ~i5 : i5;
                }
                z = true;
            }
            PeriodFieldAffix periodFieldAffix3 = this.iSuffix;
            int i6 = -1;
            if (periodFieldAffix3 == null || z) {
                i2 = -1;
            } else {
                i2 = periodFieldAffix3.scan(str, i5);
                if (i2 < 0) {
                    return !z ? ~i2 : i2;
                }
                z = true;
            }
            if (!z && !isSupported(readWritablePeriod.getPeriodType(), this.iFieldType)) {
                return i5;
            }
            int min = Math.min(this.iMaxParsedDigits, i2 > 0 ? i2 - i5 : str.length() - i5);
            int i7 = 0;
            boolean z2 = false;
            while (i7 < min) {
                int i8 = i5 + i7;
                char charAt2 = str.charAt(i8);
                if (i7 == 0 && ((charAt2 == '-' || charAt2 == '+') && !this.iRejectSignedValues)) {
                    boolean z3 = charAt2 == '-';
                    int i9 = i7 + 1;
                    if (i9 >= min || (charAt = str.charAt(i8 + 1)) < '0' || charAt > '9') {
                        break;
                    }
                    if (z3) {
                        i7 = i9;
                    } else {
                        i5++;
                    }
                    min = Math.min(min + 1, str.length() - i5);
                } else {
                    if (charAt2 >= '0' && charAt2 <= '9') {
                        z2 = true;
                    } else {
                        if ((charAt2 != '.' && charAt2 != ',') || (((i4 = this.iFieldType) != 8 && i4 != 9) || i6 >= 0)) {
                            break;
                        }
                        min = Math.min(min + 1, str.length() - i5);
                        i6 = i8 + 1;
                    }
                    i7++;
                }
            }
            if (!z2) {
                return ~i5;
            }
            if (i2 >= 0 && i5 + i7 != i2) {
                return i5;
            }
            int i10 = this.iFieldType;
            if (i10 == 8 || i10 == 9) {
                if (i6 < 0) {
                    setFieldValue(readWritablePeriod, 6, parseInt(str, i5, i7));
                    i3 = 0;
                } else {
                    i3 = 0;
                    int parseInt = parseInt(str, i5, (i6 - i5) - 1);
                    setFieldValue(readWritablePeriod, 6, parseInt);
                    int i11 = (i5 + i7) - i6;
                    if (i11 > 0) {
                        if (i11 >= 3) {
                            i3 = parseInt(str, i6, 3);
                        } else {
                            int parseInt2 = parseInt(str, i6, i11);
                            i3 = i11 == 1 ? parseInt2 * 100 : parseInt2 * 10;
                        }
                        if (parseInt < 0) {
                            i3 = -i3;
                        }
                    }
                }
                setFieldValue(readWritablePeriod, 7, i3);
            } else {
                setFieldValue(readWritablePeriod, i10, parseInt(str, i5, i7));
            }
            int i12 = i5 + i7;
            return (i12 < 0 || (periodFieldAffix = this.iSuffix) == null) ? i12 : periodFieldAffix.parse(str, i12);
        }

        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue == Long.MAX_VALUE) {
                return;
            }
            int i = (int) fieldValue;
            if (this.iFieldType >= 8) {
                i = (int) (fieldValue / 1000);
            }
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                periodFieldAffix.printTo(writer, i);
            }
            int i2 = this.iMinPrintedDigits;
            if (i2 <= 1) {
                FormatUtils.writeUnpaddedInteger(writer, i);
            } else {
                FormatUtils.writePaddedInteger(writer, i, i2);
            }
            if (this.iFieldType >= 8) {
                int abs = (int) (Math.abs(fieldValue) % 1000);
                if (this.iFieldType == 8 || abs > 0) {
                    writer.write(46);
                    FormatUtils.writePaddedInteger(writer, abs, 3);
                }
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            if (periodFieldAffix2 != null) {
                periodFieldAffix2.printTo(writer, i);
            }
        }

        public void setFieldValue(ReadWritablePeriod readWritablePeriod, int i, int i2) {
            switch (i) {
                case 0:
                    readWritablePeriod.setYears(i2);
                    break;
                case 1:
                    readWritablePeriod.setMonths(i2);
                    break;
                case 2:
                    readWritablePeriod.setWeeks(i2);
                    break;
                case 3:
                    readWritablePeriod.setDays(i2);
                    break;
                case 4:
                    readWritablePeriod.setHours(i2);
                    break;
                case 5:
                    readWritablePeriod.setMinutes(i2);
                    break;
                case 6:
                    readWritablePeriod.setSeconds(i2);
                    break;
                case 7:
                    readWritablePeriod.setMillis(i2);
                    break;
            }
        }

        public FieldFormatter(FieldFormatter fieldFormatter, PeriodFieldAffix periodFieldAffix) {
            this.iMinPrintedDigits = fieldFormatter.iMinPrintedDigits;
            this.iPrintZeroSetting = fieldFormatter.iPrintZeroSetting;
            this.iMaxParsedDigits = fieldFormatter.iMaxParsedDigits;
            this.iRejectSignedValues = fieldFormatter.iRejectSignedValues;
            this.iFieldType = fieldFormatter.iFieldType;
            this.iFieldFormatters = fieldFormatter.iFieldFormatters;
            this.iPrefix = fieldFormatter.iPrefix;
            PeriodFieldAffix periodFieldAffix2 = fieldFormatter.iSuffix;
            this.iSuffix = periodFieldAffix2 != null ? new CompositeAffix(periodFieldAffix2, periodFieldAffix) : periodFieldAffix;
        }

        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue == Long.MAX_VALUE) {
                return;
            }
            int i = (int) fieldValue;
            if (this.iFieldType >= 8) {
                i = (int) (fieldValue / 1000);
            }
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                periodFieldAffix.printTo(stringBuffer, i);
            }
            int length = stringBuffer.length();
            int i2 = this.iMinPrintedDigits;
            if (i2 <= 1) {
                FormatUtils.appendUnpaddedInteger(stringBuffer, i);
            } else {
                FormatUtils.appendPaddedInteger(stringBuffer, i, i2);
            }
            if (this.iFieldType >= 8) {
                int abs = (int) (Math.abs(fieldValue) % 1000);
                if (this.iFieldType == 8 || abs > 0) {
                    if (fieldValue < 0 && fieldValue > -1000) {
                        stringBuffer.insert(length, '-');
                    }
                    stringBuffer.append('.');
                    FormatUtils.appendPaddedInteger(stringBuffer, abs, 3);
                }
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            if (periodFieldAffix2 != null) {
                periodFieldAffix2.printTo(stringBuffer, i);
            }
        }
    }

    public static abstract class IgnorableAffix implements PeriodFieldAffix {
        private volatile String[] iOtherAffixes;

        public void finish(Set set) {
            if (this.iOtherAffixes == null) {
                int i = Integer.MAX_VALUE;
                String str = null;
                for (String str2 : getAffixes()) {
                    if (str2.length() < i) {
                        i = str2.length();
                        str = str2;
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    PeriodFieldAffix periodFieldAffix = (PeriodFieldAffix) it.next();
                    if (periodFieldAffix != null) {
                        for (String str3 : periodFieldAffix.getAffixes()) {
                            if (str3.length() > i || (str3.equalsIgnoreCase(str) && !str3.equals(str))) {
                                hashSet.add(str3);
                            }
                        }
                    }
                }
                this.iOtherAffixes = (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
        }

        public boolean matchesOtherAffix(int i, String str, int i2) {
            if (this.iOtherAffixes != null) {
                for (String str2 : this.iOtherAffixes) {
                    int length = str2.length();
                    if (i < length && str.regionMatches(true, i2, str2, 0, length)) {
                        return true;
                    }
                    if (i == length && str.regionMatches(false, i2, str2, 0, length)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class Literal implements PeriodPrinter, PeriodParser {
        static final Literal EMPTY = new Literal("");
        private final String iText;

        public Literal(String str) {
            this.iText = str;
        }

        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            return this.iText.length();
        }

        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i, Locale locale) {
            return 0;
        }

        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i, Locale locale) {
            String str2 = this.iText;
            return str.regionMatches(true, i, str2, 0, str2.length()) ? i + this.iText.length() : ~i;
        }

        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            writer.write(this.iText);
        }

        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            stringBuffer.append(this.iText);
        }
    }

    public interface PeriodFieldAffix {
        int calculatePrintedLength(int i);

        void finish(Set set);

        String[] getAffixes();

        int parse(String str, int i);

        void printTo(Writer writer, int i) throws IOException;

        void printTo(StringBuffer stringBuffer, int i);

        int scan(String str, int i);
    }

    public static class PluralAffix extends IgnorableAffix {
        private final String iPluralText;
        private final String iSingularText;

        public PluralAffix(String str, String str2) {
            this.iSingularText = str;
            this.iPluralText = str2;
        }

        public int calculatePrintedLength(int i) {
            return (i == 1 ? this.iSingularText : this.iPluralText).length();
        }

        public String[] getAffixes() {
            return new String[]{this.iSingularText, this.iPluralText};
        }

        public int parse(String str, int i) {
            String str2;
            int length;
            String str3 = this.iPluralText;
            String str4 = this.iSingularText;
            if (str3.length() < str4.length()) {
                str2 = str3;
                str3 = str4;
            } else {
                str2 = str4;
            }
            if (!str.regionMatches(true, i, str3, 0, str3.length()) || matchesOtherAffix(str3.length(), str, i)) {
                if (!str.regionMatches(true, i, str2, 0, str2.length()) || matchesOtherAffix(str2.length(), str, i)) {
                    return ~i;
                }
                length = str2.length();
            } else {
                length = str3.length();
            }
            return i + length;
        }

        public void printTo(Writer writer, int i) throws IOException {
            writer.write(i == 1 ? this.iSingularText : this.iPluralText);
        }

        public int scan(String str, int i) {
            String str2;
            String str3;
            String str4 = this.iPluralText;
            String str5 = this.iSingularText;
            if (str4.length() < str5.length()) {
                str3 = str4;
                str2 = str5;
            } else {
                str2 = str4;
                str3 = str5;
            }
            int length = str2.length();
            int length2 = str3.length();
            int length3 = str.length();
            for (int i2 = i; i2 < length3; i2++) {
                if (str.regionMatches(true, i2, str2, 0, length) && !matchesOtherAffix(str2.length(), str, i2)) {
                    return i2;
                }
                if (str.regionMatches(true, i2, str3, 0, length2) && !matchesOtherAffix(str3.length(), str, i2)) {
                    return i2;
                }
            }
            return ~i;
        }

        public void printTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append(i == 1 ? this.iSingularText : this.iPluralText);
        }
    }

    public static class RegExAffix extends IgnorableAffix {
        private static final Comparator LENGTH_DESC_COMPARATOR = new 1();
        private final Pattern[] iPatterns;
        private final String[] iSuffixes;
        private final String[] iSuffixesSortedDescByLength;

        public static class 1 implements Comparator {
            public int compare(String str, String str2) {
                return str2.length() - str.length();
            }
        }

        public RegExAffix(String[] strArr, String[] strArr2) {
            this.iSuffixes = (String[]) strArr2.clone();
            this.iPatterns = new Pattern[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                Pattern pattern = (Pattern) PeriodFormatterBuilder.access$200().get(strArr[i]);
                if (pattern == null) {
                    pattern = Pattern.compile(strArr[i]);
                    PeriodFormatterBuilder.access$200().putIfAbsent(strArr[i], pattern);
                }
                this.iPatterns[i] = pattern;
            }
            String[] strArr3 = (String[]) this.iSuffixes.clone();
            this.iSuffixesSortedDescByLength = strArr3;
            Arrays.sort(strArr3, LENGTH_DESC_COMPARATOR);
        }

        private int selectSuffixIndex(int i) {
            String valueOf = String.valueOf(i);
            int i2 = 0;
            while (true) {
                Pattern[] patternArr = this.iPatterns;
                if (i2 >= patternArr.length) {
                    return patternArr.length - 1;
                }
                if (patternArr[i2].matcher(valueOf).matches()) {
                    return i2;
                }
                i2++;
            }
        }

        public int calculatePrintedLength(int i) {
            return this.iSuffixes[selectSuffixIndex(i)].length();
        }

        public String[] getAffixes() {
            return (String[]) this.iSuffixes.clone();
        }

        public int parse(String str, int i) {
            for (String str2 : this.iSuffixesSortedDescByLength) {
                if (str.regionMatches(true, i, str2, 0, str2.length()) && !matchesOtherAffix(str2.length(), str, i)) {
                    return i + str2.length();
                }
            }
            return ~i;
        }

        public void printTo(Writer writer, int i) throws IOException {
            writer.write(this.iSuffixes[selectSuffixIndex(i)]);
        }

        public int scan(String str, int i) {
            int length = str.length();
            for (int i2 = i; i2 < length; i2++) {
                for (String str2 : this.iSuffixesSortedDescByLength) {
                    if (str.regionMatches(true, i2, str2, 0, str2.length()) && !matchesOtherAffix(str2.length(), str, i2)) {
                        return i2;
                    }
                }
            }
            return ~i;
        }

        public void printTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append(this.iSuffixes[selectSuffixIndex(i)]);
        }
    }

    public static class Separator implements PeriodPrinter, PeriodParser {
        private volatile PeriodParser iAfterParser;
        private volatile PeriodPrinter iAfterPrinter;
        private final PeriodParser iBeforeParser;
        private final PeriodPrinter iBeforePrinter;
        private final String iFinalText;
        private final String[] iParsedForms;
        private final String iText;
        private final boolean iUseAfter;
        private final boolean iUseBefore;

        public Separator(String str, String str2, String[] strArr, PeriodPrinter periodPrinter, PeriodParser periodParser, boolean z, boolean z2) {
            this.iText = str;
            this.iFinalText = str2;
            if ((str2 == null || str.equals(str2)) && (strArr == null || strArr.length == 0)) {
                this.iParsedForms = new String[]{str};
            } else {
                TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                treeSet.add(str);
                treeSet.add(str2);
                if (strArr != null) {
                    int length = strArr.length;
                    while (true) {
                        length--;
                        if (length < 0) {
                            break;
                        } else {
                            treeSet.add(strArr[length]);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList(treeSet);
                Collections.reverse(arrayList);
                this.iParsedForms = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            this.iBeforePrinter = periodPrinter;
            this.iBeforeParser = periodParser;
            this.iUseBefore = z;
            this.iUseAfter = z2;
        }

        public static /* synthetic */ PeriodParser access$000(Separator separator) {
            return separator.iAfterParser;
        }

        public static /* synthetic */ PeriodPrinter access$100(Separator separator) {
            return separator.iAfterPrinter;
        }

        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            String str;
            PeriodPrinter periodPrinter = this.iBeforePrinter;
            PeriodPrinter periodPrinter2 = this.iAfterPrinter;
            int calculatePrintedLength = periodPrinter.calculatePrintedLength(readablePeriod, locale) + periodPrinter2.calculatePrintedLength(readablePeriod, locale);
            if (this.iUseBefore) {
                if (periodPrinter.countFieldsToPrint(readablePeriod, 1, locale) <= 0) {
                    return calculatePrintedLength;
                }
                if (this.iUseAfter) {
                    int countFieldsToPrint = periodPrinter2.countFieldsToPrint(readablePeriod, 2, locale);
                    if (countFieldsToPrint <= 0) {
                        return calculatePrintedLength;
                    }
                    if (countFieldsToPrint <= 1) {
                        str = this.iFinalText;
                    }
                }
                return calculatePrintedLength + str.length();
            }
            if (!this.iUseAfter || periodPrinter2.countFieldsToPrint(readablePeriod, 1, locale) <= 0) {
                return calculatePrintedLength;
            }
            str = this.iText;
            return calculatePrintedLength + str.length();
        }

        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i, Locale locale) {
            int countFieldsToPrint = this.iBeforePrinter.countFieldsToPrint(readablePeriod, i, locale);
            return countFieldsToPrint < i ? countFieldsToPrint + this.iAfterPrinter.countFieldsToPrint(readablePeriod, i, locale) : countFieldsToPrint;
        }

        public Separator finish(PeriodPrinter periodPrinter, PeriodParser periodParser) {
            this.iAfterPrinter = periodPrinter;
            this.iAfterParser = periodParser;
            return this;
        }

        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i, Locale locale) {
            int i2;
            int parseInto = this.iBeforeParser.parseInto(readWritablePeriod, str, i, locale);
            if (parseInto < 0) {
                return parseInto;
            }
            if (parseInto > i) {
                String[] strArr = this.iParsedForms;
                int length = strArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    String str2 = strArr[i3];
                    if (str2 == null || str2.length() == 0 || str.regionMatches(true, parseInto, str2, 0, str2.length())) {
                        r7 = str2 != null ? str2.length() : 0;
                        parseInto += r7;
                        i2 = r7;
                        r7 = 1;
                    }
                }
                i2 = -1;
            } else {
                i2 = -1;
            }
            int parseInto2 = this.iAfterParser.parseInto(readWritablePeriod, str, parseInto, locale);
            return parseInto2 < 0 ? parseInto2 : (r7 == 0 || parseInto2 != parseInto || i2 <= 0) ? (parseInto2 <= parseInto || r7 != 0 || this.iUseBefore) ? parseInto2 : ~parseInto : ~parseInto;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        
            if (r1.countFieldsToPrint(r6, 1, r7) > 0) goto L13;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void printTo(java.io.Writer r5, org.joda.time.ReadablePeriod r6, java.util.Locale r7) throws java.io.IOException {
            /*
                r4 = this;
                org.joda.time.format.PeriodPrinter r0 = r4.iBeforePrinter
                org.joda.time.format.PeriodPrinter r1 = r4.iAfterPrinter
                r0.printTo(r5, r6, r7)
                boolean r2 = r4.iUseBefore
                r3 = 1
                if (r2 == 0) goto L29
                int r0 = r0.countFieldsToPrint(r6, r3, r7)
                if (r0 <= 0) goto L34
                boolean r0 = r4.iUseAfter
                if (r0 == 0) goto L23
                r0 = 2
                int r0 = r1.countFieldsToPrint(r6, r0, r7)
                if (r0 <= 0) goto L34
                if (r0 <= r3) goto L20
                goto L23
            L20:
                java.lang.String r0 = r4.iFinalText
                goto L25
            L23:
                java.lang.String r0 = r4.iText
            L25:
                r5.write(r0)
                goto L34
            L29:
                boolean r0 = r4.iUseAfter
                if (r0 == 0) goto L34
                int r0 = r1.countFieldsToPrint(r6, r3, r7)
                if (r0 <= 0) goto L34
                goto L23
            L34:
                r1.printTo(r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.PeriodFormatterBuilder.Separator.printTo(java.io.Writer, org.joda.time.ReadablePeriod, java.util.Locale):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
        
            if (r1.countFieldsToPrint(r6, 1, r7) > 0) goto L13;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void printTo(java.lang.StringBuffer r5, org.joda.time.ReadablePeriod r6, java.util.Locale r7) {
            /*
                r4 = this;
                org.joda.time.format.PeriodPrinter r0 = r4.iBeforePrinter
                org.joda.time.format.PeriodPrinter r1 = r4.iAfterPrinter
                r0.printTo(r5, r6, r7)
                boolean r2 = r4.iUseBefore
                r3 = 1
                if (r2 == 0) goto L29
                int r0 = r0.countFieldsToPrint(r6, r3, r7)
                if (r0 <= 0) goto L34
                boolean r0 = r4.iUseAfter
                if (r0 == 0) goto L23
                r0 = 2
                int r0 = r1.countFieldsToPrint(r6, r0, r7)
                if (r0 <= 0) goto L34
                if (r0 <= r3) goto L20
                goto L23
            L20:
                java.lang.String r0 = r4.iFinalText
                goto L25
            L23:
                java.lang.String r0 = r4.iText
            L25:
                r5.append(r0)
                goto L34
            L29:
                boolean r0 = r4.iUseAfter
                if (r0 == 0) goto L34
                int r0 = r1.countFieldsToPrint(r6, r3, r7)
                if (r0 <= 0) goto L34
                goto L23
            L34:
                r1.printTo(r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.PeriodFormatterBuilder.Separator.printTo(java.lang.StringBuffer, org.joda.time.ReadablePeriod, java.util.Locale):void");
        }
    }

    public static class SimpleAffix extends IgnorableAffix {
        private final String iText;

        public SimpleAffix(String str) {
            this.iText = str;
        }

        public int calculatePrintedLength(int i) {
            return this.iText.length();
        }

        public String[] getAffixes() {
            return new String[]{this.iText};
        }

        public int parse(String str, int i) {
            String str2 = this.iText;
            int length = str2.length();
            return (!str.regionMatches(true, i, str2, 0, length) || matchesOtherAffix(length, str, i)) ? ~i : i + length;
        }

        public void printTo(Writer writer, int i) throws IOException {
            writer.write(this.iText);
        }

        public int scan(String str, int i) {
            String str2 = this.iText;
            int length = str2.length();
            int length2 = str.length();
            for (int i2 = i; i2 < length2; i2++) {
                if (str.regionMatches(true, i2, str2, 0, length) && !matchesOtherAffix(length, str, i2)) {
                    return i2;
                }
                switch (str.charAt(i2)) {
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                }
                return ~i;
            }
            return ~i;
        }

        public void printTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append(this.iText);
        }
    }

    public PeriodFormatterBuilder() {
        clear();
    }

    public static /* synthetic */ ConcurrentMap access$200() {
        return PATTERNS;
    }

    private PeriodFormatterBuilder append0(PeriodPrinter periodPrinter, PeriodParser periodParser) {
        this.iElementPairs.add(periodPrinter);
        this.iElementPairs.add(periodParser);
        this.iNotPrinter = (periodPrinter == null) | this.iNotPrinter;
        this.iNotParser |= periodParser == null;
        return this;
    }

    private void appendField(int i) {
        appendField(i, this.iMinPrintedDigits);
    }

    private void clearPrefix() throws IllegalStateException {
        if (this.iPrefix != null) {
            throw new IllegalStateException("Prefix not followed by field");
        }
        this.iPrefix = null;
    }

    private static Object[] createComposite(List list) {
        int size = list.size();
        if (size == 0) {
            Literal literal = Literal.EMPTY;
            return new Object[]{literal, literal};
        }
        if (size == 1) {
            return new Object[]{list.get(0), list.get(1)};
        }
        Composite composite = new Composite(list);
        return new Object[]{composite, composite};
    }

    public PeriodFormatterBuilder append(PeriodFormatter periodFormatter) {
        if (periodFormatter == null) {
            throw new IllegalArgumentException("No formatter supplied");
        }
        clearPrefix();
        append0(periodFormatter.getPrinter(), periodFormatter.getParser());
        return this;
    }

    public PeriodFormatterBuilder appendDays() {
        appendField(3);
        return this;
    }

    public PeriodFormatterBuilder appendHours() {
        appendField(4);
        return this;
    }

    public PeriodFormatterBuilder appendLiteral(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Literal must not be null");
        }
        clearPrefix();
        Literal literal = new Literal(str);
        append0(literal, literal);
        return this;
    }

    public PeriodFormatterBuilder appendMillis() {
        appendField(7);
        return this;
    }

    public PeriodFormatterBuilder appendMillis3Digit() {
        appendField(7, 3);
        return this;
    }

    public PeriodFormatterBuilder appendMinutes() {
        appendField(5);
        return this;
    }

    public PeriodFormatterBuilder appendMonths() {
        appendField(1);
        return this;
    }

    public PeriodFormatterBuilder appendPrefix(String str) {
        if (str != null) {
            return appendPrefix(new SimpleAffix(str));
        }
        throw new IllegalArgumentException();
    }

    public PeriodFormatterBuilder appendSeconds() {
        appendField(6);
        return this;
    }

    public PeriodFormatterBuilder appendSecondsWithMillis() {
        appendField(8);
        return this;
    }

    public PeriodFormatterBuilder appendSecondsWithOptionalMillis() {
        appendField(9);
        return this;
    }

    public PeriodFormatterBuilder appendSeparator(String str) {
        return appendSeparator(str, str, null, true, true);
    }

    public PeriodFormatterBuilder appendSeparatorIfFieldsAfter(String str) {
        return appendSeparator(str, str, null, false, true);
    }

    public PeriodFormatterBuilder appendSeparatorIfFieldsBefore(String str) {
        return appendSeparator(str, str, null, true, false);
    }

    public PeriodFormatterBuilder appendSuffix(String str) {
        if (str != null) {
            return appendSuffix(new SimpleAffix(str));
        }
        throw new IllegalArgumentException();
    }

    public PeriodFormatterBuilder appendWeeks() {
        appendField(2);
        return this;
    }

    public PeriodFormatterBuilder appendYears() {
        appendField(0);
        return this;
    }

    public void clear() {
        this.iMinPrintedDigits = 1;
        this.iPrintZeroSetting = 2;
        this.iMaxParsedDigits = 10;
        this.iRejectSignedValues = false;
        this.iPrefix = null;
        List list = this.iElementPairs;
        if (list == null) {
            this.iElementPairs = new ArrayList();
        } else {
            list.clear();
        }
        this.iNotPrinter = false;
        this.iNotParser = false;
        this.iFieldFormatters = new FieldFormatter[10];
    }

    public PeriodFormatterBuilder maximumParsedDigits(int i) {
        this.iMaxParsedDigits = i;
        return this;
    }

    public PeriodFormatterBuilder minimumPrintedDigits(int i) {
        this.iMinPrintedDigits = i;
        return this;
    }

    public PeriodFormatterBuilder printZeroAlways() {
        this.iPrintZeroSetting = 4;
        return this;
    }

    public PeriodFormatterBuilder printZeroIfSupported() {
        this.iPrintZeroSetting = 3;
        return this;
    }

    public PeriodFormatterBuilder printZeroNever() {
        this.iPrintZeroSetting = 5;
        return this;
    }

    public PeriodFormatterBuilder printZeroRarelyFirst() {
        this.iPrintZeroSetting = 1;
        return this;
    }

    public PeriodFormatterBuilder printZeroRarelyLast() {
        this.iPrintZeroSetting = 2;
        return this;
    }

    public PeriodFormatterBuilder rejectSignedValues(boolean z) {
        this.iRejectSignedValues = z;
        return this;
    }

    public PeriodFormatter toFormatter() {
        PeriodFormatter formatter = toFormatter(this.iElementPairs, this.iNotPrinter, this.iNotParser);
        for (FieldFormatter fieldFormatter : this.iFieldFormatters) {
            if (fieldFormatter != null) {
                fieldFormatter.finish(this.iFieldFormatters);
            }
        }
        this.iFieldFormatters = (FieldFormatter[]) this.iFieldFormatters.clone();
        return formatter;
    }

    public PeriodParser toParser() {
        if (this.iNotParser) {
            return null;
        }
        return toFormatter().getParser();
    }

    public PeriodPrinter toPrinter() {
        if (this.iNotPrinter) {
            return null;
        }
        return toFormatter().getPrinter();
    }

    private void appendField(int i, int i2) {
        FieldFormatter fieldFormatter = new FieldFormatter(i2, this.iPrintZeroSetting, this.iMaxParsedDigits, this.iRejectSignedValues, i, this.iFieldFormatters, this.iPrefix, null);
        append0(fieldFormatter, fieldFormatter);
        this.iFieldFormatters[i] = fieldFormatter;
        this.iPrefix = null;
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    private static org.joda.time.format.PeriodFormatter toFormatter(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r5v0 ??
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

    public PeriodFormatterBuilder append(PeriodPrinter periodPrinter, PeriodParser periodParser) {
        if (periodPrinter == null && periodParser == null) {
            throw new IllegalArgumentException("No printer or parser supplied");
        }
        clearPrefix();
        append0(periodPrinter, periodParser);
        return this;
    }

    public PeriodFormatterBuilder appendPrefix(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        return appendPrefix(new PluralAffix(str, str2));
    }

    public PeriodFormatterBuilder appendSeparator(String str, String str2) {
        return appendSeparator(str, str2, null, true, true);
    }

    public PeriodFormatterBuilder appendSuffix(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        return appendSuffix(new PluralAffix(str, str2));
    }

    private PeriodFormatterBuilder appendPrefix(PeriodFieldAffix periodFieldAffix) {
        if (periodFieldAffix == null) {
            throw new IllegalArgumentException();
        }
        PeriodFieldAffix periodFieldAffix2 = this.iPrefix;
        if (periodFieldAffix2 != null) {
            periodFieldAffix = new CompositeAffix(periodFieldAffix2, periodFieldAffix);
        }
        this.iPrefix = periodFieldAffix;
        return this;
    }

    private PeriodFormatterBuilder appendSuffix(PeriodFieldAffix periodFieldAffix) {
        Object obj;
        Object obj2;
        if (this.iElementPairs.size() > 0) {
            obj = this.iElementPairs.get(r0.size() - 2);
            obj2 = this.iElementPairs.get(r1.size() - 1);
        } else {
            obj = null;
            obj2 = null;
        }
        if (obj == null || obj2 == null || obj != obj2 || !(obj instanceof FieldFormatter)) {
            throw new IllegalStateException("No field to apply suffix to");
        }
        clearPrefix();
        FieldFormatter fieldFormatter = new FieldFormatter((FieldFormatter) obj, periodFieldAffix);
        this.iElementPairs.set(r4.size() - 2, fieldFormatter);
        this.iElementPairs.set(r4.size() - 1, fieldFormatter);
        this.iFieldFormatters[fieldFormatter.getFieldType()] = fieldFormatter;
        return this;
    }

    public PeriodFormatterBuilder appendSeparator(String str, String str2, String[] strArr) {
        return appendSeparator(str, str2, strArr, true, true);
    }

    private PeriodFormatterBuilder appendSeparator(String str, String str2, String[] strArr, boolean z, boolean z2) {
        Separator separator;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        clearPrefix();
        List list = this.iElementPairs;
        if (list.size() == 0) {
            if (z2 && !z) {
                Literal literal = Literal.EMPTY;
                Separator separator2 = new Separator(str, str2, strArr, literal, literal, z, z2);
                append0(separator2, separator2);
            }
            return this;
        }
        int size = list.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                separator = null;
                break;
            }
            if (list.get(i) instanceof Separator) {
                separator = (Separator) list.get(i);
                list = list.subList(size, list.size());
                break;
            }
            size -= 2;
        }
        List list2 = list;
        if (separator != null && list2.size() == 0) {
            throw new IllegalStateException("Cannot have two adjacent separators");
        }
        Object[] createComposite = createComposite(list2);
        list2.clear();
        Separator separator3 = new Separator(str, str2, strArr, (PeriodPrinter) createComposite[0], (PeriodParser) createComposite[1], z, z2);
        list2.add(separator3);
        list2.add(separator3);
        return this;
    }

    public PeriodFormatterBuilder appendPrefix(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length < 1 || strArr.length != strArr2.length) {
            throw new IllegalArgumentException();
        }
        return appendPrefix(new RegExAffix(strArr, strArr2));
    }

    public PeriodFormatterBuilder appendSuffix(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length < 1 || strArr.length != strArr2.length) {
            throw new IllegalArgumentException();
        }
        return appendSuffix(new RegExAffix(strArr, strArr2));
    }
}
