package org.joda.time.format;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadablePartial;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDateTimeField;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DateTimeFormatterBuilder {
    private ArrayList iElementPairs = new ArrayList();
    private Object iFormatter;

    public static class CharacterLiteral implements InternalPrinter, InternalParser {
        private final char iValue;

        public CharacterLiteral(char c) {
            this.iValue = c;
        }

        public int estimateParsedLength() {
            return 1;
        }

        public int estimatePrintedLength() {
            return 1;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            char upperCase;
            char upperCase2;
            if (i >= charSequence.length()) {
                return ~i;
            }
            char charAt = charSequence.charAt(i);
            char c = this.iValue;
            return (charAt == c || (upperCase = Character.toUpperCase(charAt)) == (upperCase2 = Character.toUpperCase(c)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) ? i + 1 : ~i;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }
    }

    public static class Composite implements InternalPrinter, InternalParser {
        private final int iParsedLengthEstimate;
        private final InternalParser[] iParsers;
        private final int iPrintedLengthEstimate;
        private final InternalPrinter[] iPrinters;

        public Composite(List list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            decompose(list, arrayList, arrayList2);
            if (arrayList.contains((Object) null) || arrayList.isEmpty()) {
                this.iPrinters = null;
                this.iPrintedLengthEstimate = 0;
            } else {
                int size = arrayList.size();
                this.iPrinters = new InternalPrinter[size];
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    InternalPrinter internalPrinter = (InternalPrinter) arrayList.get(i2);
                    i += internalPrinter.estimatePrintedLength();
                    this.iPrinters[i2] = internalPrinter;
                }
                this.iPrintedLengthEstimate = i;
            }
            if (arrayList2.contains((Object) null) || arrayList2.isEmpty()) {
                this.iParsers = null;
                this.iParsedLengthEstimate = 0;
                return;
            }
            int size2 = arrayList2.size();
            this.iParsers = new InternalParser[size2];
            int i3 = 0;
            for (int i4 = 0; i4 < size2; i4++) {
                InternalParser internalParser = (InternalParser) arrayList2.get(i4);
                i3 += internalParser.estimateParsedLength();
                this.iParsers[i4] = internalParser;
            }
            this.iParsedLengthEstimate = i3;
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
                if (obj instanceof Composite) {
                    addArrayToList(list2, ((Composite) obj).iPrinters);
                } else {
                    list2.add(obj);
                }
                Object obj2 = list.get(i + 1);
                if (obj2 instanceof Composite) {
                    addArrayToList(list3, ((Composite) obj2).iParsers);
                } else {
                    list3.add(obj2);
                }
            }
        }

        public int estimateParsedLength() {
            return this.iParsedLengthEstimate;
        }

        public int estimatePrintedLength() {
            return this.iPrintedLengthEstimate;
        }

        public boolean isParser() {
            return this.iParsers != null;
        }

        public boolean isPrinter() {
            return this.iPrinters != null;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            InternalParser[] internalParserArr = this.iParsers;
            if (internalParserArr == null) {
                throw new UnsupportedOperationException();
            }
            int length = internalParserArr.length;
            for (int i2 = 0; i2 < length && i >= 0; i2++) {
                i = internalParserArr[i2].parseInto(dateTimeParserBucket, charSequence, i);
            }
            return i;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            InternalPrinter[] internalPrinterArr = this.iPrinters;
            if (internalPrinterArr == null) {
                throw new UnsupportedOperationException();
            }
            Locale locale2 = locale == null ? Locale.getDefault() : locale;
            for (InternalPrinter internalPrinter : internalPrinterArr) {
                internalPrinter.printTo(appendable, j, chronology, i, dateTimeZone, locale2);
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            InternalPrinter[] internalPrinterArr = this.iPrinters;
            if (internalPrinterArr == null) {
                throw new UnsupportedOperationException();
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            for (InternalPrinter internalPrinter : internalPrinterArr) {
                internalPrinter.printTo(appendable, readablePartial, locale);
            }
        }
    }

    public static class FixedNumber extends PaddedNumber {
        public FixedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            super(dateTimeFieldType, i, z, i);
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int i2;
            char charAt;
            int parseInto = super.parseInto(dateTimeParserBucket, charSequence, i);
            if (parseInto < 0 || parseInto == (i2 = this.iMaxParsedDigits + i)) {
                return parseInto;
            }
            if (this.iSigned && ((charAt = charSequence.charAt(i)) == '-' || charAt == '+')) {
                i2++;
            }
            return parseInto > i2 ? ~(i2 + 1) : parseInto < i2 ? ~parseInto : parseInto;
        }
    }

    public static class Fraction implements InternalPrinter, InternalParser {
        private final DateTimeFieldType iFieldType;
        protected int iMaxDigits;
        protected int iMinDigits;

        public Fraction(DateTimeFieldType dateTimeFieldType, int i, int i2) {
            this.iFieldType = dateTimeFieldType;
            i2 = i2 > 18 ? 18 : i2;
            this.iMinDigits = i;
            this.iMaxDigits = i2;
        }

        private long[] getFractionData(long j, DateTimeField dateTimeField) {
            long j2;
            long unitMillis = dateTimeField.getDurationField().getUnitMillis();
            int i = this.iMaxDigits;
            while (true) {
                switch (i) {
                    case 1:
                        j2 = 10;
                        break;
                    case 2:
                        j2 = 100;
                        break;
                    case 3:
                        j2 = 1000;
                        break;
                    case 4:
                        j2 = 10000;
                        break;
                    case 5:
                        j2 = 100000;
                        break;
                    case 6:
                        j2 = 1000000;
                        break;
                    case 7:
                        j2 = 10000000;
                        break;
                    case 8:
                        j2 = 100000000;
                        break;
                    case 9:
                        j2 = 1000000000;
                        break;
                    case 10:
                        j2 = 10000000000L;
                        break;
                    case 11:
                        j2 = 100000000000L;
                        break;
                    case 12:
                        j2 = 1000000000000L;
                        break;
                    case 13:
                        j2 = 10000000000000L;
                        break;
                    case 14:
                        j2 = 100000000000000L;
                        break;
                    case 15:
                        j2 = 1000000000000000L;
                        break;
                    case 16:
                        j2 = 10000000000000000L;
                        break;
                    case 17:
                        j2 = 100000000000000000L;
                        break;
                    case 18:
                        j2 = 1000000000000000000L;
                        break;
                    default:
                        j2 = 1;
                        break;
                }
                if ((unitMillis * j2) / j2 == unitMillis) {
                    return new long[]{(j * j2) / unitMillis, i};
                }
                i--;
            }
        }

        public int estimateParsedLength() {
            return this.iMaxDigits;
        }

        public int estimatePrintedLength() {
            return this.iMaxDigits;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            DateTimeField field = this.iFieldType.getField(dateTimeParserBucket.getChronology());
            int min = Math.min(this.iMaxDigits, charSequence.length() - i);
            long unitMillis = field.getDurationField().getUnitMillis() * 10;
            long j = 0;
            int i2 = 0;
            while (i2 < min) {
                char charAt = charSequence.charAt(i + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2++;
                unitMillis /= 10;
                j += (charAt - '0') * unitMillis;
            }
            long j2 = j / 10;
            if (i2 != 0 && j2 <= 2147483647L) {
                dateTimeParserBucket.saveField(new PreciseDateTimeField(DateTimeFieldType.millisOfSecond(), MillisDurationField.INSTANCE, field.getDurationField()), (int) j2);
                return i + i2;
            }
            return ~i;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology) throws IOException {
            DateTimeField field = this.iFieldType.getField(chronology);
            int i = this.iMinDigits;
            try {
                long remainder = field.remainder(j);
                if (remainder != 0) {
                    long[] fractionData = getFractionData(remainder, field);
                    long j2 = fractionData[0];
                    int i2 = (int) fractionData[1];
                    String num = (2147483647L & j2) == j2 ? Integer.toString((int) j2) : Long.toString(j2);
                    int length = num.length();
                    while (length < i2) {
                        appendable.append('0');
                        i--;
                        i2--;
                    }
                    if (i < i2) {
                        while (i < i2 && length > 1 && num.charAt(length - 1) == '0') {
                            i2--;
                            length--;
                        }
                        if (length < num.length()) {
                            for (int i3 = 0; i3 < length; i3++) {
                                appendable.append(num.charAt(i3));
                            }
                            return;
                        }
                    }
                    appendable.append(num);
                    return;
                }
                while (true) {
                    i--;
                    if (i < 0) {
                        return;
                    } else {
                        appendable.append('0');
                    }
                }
            } catch (RuntimeException unused) {
                DateTimeFormatterBuilder.appendUnknownString(appendable, i);
            }
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            printTo(appendable, j, chronology);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            printTo(appendable, readablePartial.getChronology().set(readablePartial, 0L), readablePartial.getChronology());
        }
    }

    public static class MatchingParser implements InternalParser {
        private final int iParsedLengthEstimate;
        private final InternalParser[] iParsers;

        public MatchingParser(InternalParser[] internalParserArr) {
            int estimateParsedLength;
            this.iParsers = internalParserArr;
            int length = internalParserArr.length;
            int i = 0;
            while (true) {
                length--;
                if (length < 0) {
                    this.iParsedLengthEstimate = i;
                    return;
                }
                InternalParser internalParser = internalParserArr[length];
                if (internalParser != null && (estimateParsedLength = internalParser.estimateParsedLength()) > i) {
                    i = estimateParsedLength;
                }
            }
        }

        public int estimateParsedLength() {
            return this.iParsedLengthEstimate;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        
            return r8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r10, java.lang.CharSequence r11, int r12) {
            /*
                r9 = this;
                org.joda.time.format.InternalParser[] r0 = r9.iParsers
                int r1 = r0.length
                java.lang.Object r2 = r10.saveState()
                r3 = 0
                r4 = 0
                r6 = r12
                r7 = r6
                r5 = 0
            Lc:
                if (r5 >= r1) goto L41
                r8 = r0[r5]
                if (r8 != 0) goto L17
                if (r6 > r12) goto L15
                return r12
            L15:
                r3 = 1
                goto L41
            L17:
                int r8 = r8.parseInto(r10, r11, r12)
                if (r8 < r12) goto L35
                if (r8 <= r6) goto L3b
                int r4 = r11.length()
                if (r8 >= r4) goto L34
                int r4 = r5 + 1
                if (r4 >= r1) goto L34
                r4 = r0[r4]
                if (r4 != 0) goto L2e
                goto L34
            L2e:
                java.lang.Object r4 = r10.saveState()
                r6 = r8
                goto L3b
            L34:
                return r8
            L35:
                if (r8 >= 0) goto L3b
                int r8 = ~r8
                if (r8 <= r7) goto L3b
                r7 = r8
            L3b:
                r10.restoreState(r2)
                int r5 = r5 + 1
                goto Lc
            L41:
                if (r6 > r12) goto L4a
                if (r6 != r12) goto L48
                if (r3 == 0) goto L48
                goto L4a
            L48:
                int r10 = ~r7
                return r10
            L4a:
                if (r4 == 0) goto L4f
                r10.restoreState(r4)
            L4f:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.MatchingParser.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.CharSequence, int):int");
        }
    }

    public static abstract class NumberFormatter implements InternalPrinter, InternalParser {
        protected final DateTimeFieldType iFieldType;
        protected final int iMaxParsedDigits;
        protected final boolean iSigned;

        public NumberFormatter(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            this.iFieldType = dateTimeFieldType;
            this.iMaxParsedDigits = i;
            this.iSigned = z;
        }

        public int estimateParsedLength() {
            return this.iMaxParsedDigits;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int i2;
            int i3;
            char charAt;
            int min = Math.min(this.iMaxParsedDigits, charSequence.length() - i);
            int i4 = 0;
            boolean z = false;
            while (i4 < min) {
                int i5 = i + i4;
                char charAt2 = charSequence.charAt(i5);
                if (i4 != 0 || ((charAt2 != '-' && charAt2 != '+') || !this.iSigned)) {
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    i4++;
                } else {
                    z = charAt2 == '-';
                    int i6 = i4 + 1;
                    if (i6 >= min || (charAt = charSequence.charAt(i5 + 1)) < '0' || charAt > '9') {
                        break;
                    }
                    if (z) {
                        i4 = i6;
                    } else {
                        i++;
                    }
                    min = Math.min(min + 1, charSequence.length() - i);
                }
            }
            if (i4 == 0) {
                return ~i;
            }
            if (i4 >= 9) {
                i2 = i4 + i;
                i3 = Integer.parseInt(charSequence.subSequence(i, i2).toString());
            } else {
                int i7 = z ? i + 1 : i;
                int i8 = i7 + 1;
                try {
                    int charAt3 = charSequence.charAt(i7) - '0';
                    i2 = i4 + i;
                    while (i8 < i2) {
                        int charAt4 = (((charAt3 << 3) + (charAt3 << 1)) + charSequence.charAt(i8)) - 48;
                        i8++;
                        charAt3 = charAt4;
                    }
                    i3 = z ? -charAt3 : charAt3;
                } catch (StringIndexOutOfBoundsException unused) {
                    return ~i;
                }
            }
            dateTimeParserBucket.saveField(this.iFieldType, i3);
            return i2;
        }
    }

    public static class PaddedNumber extends NumberFormatter {
        protected final int iMinPrintedDigits;

        public PaddedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z, int i2) {
            super(dateTimeFieldType, i, z);
            this.iMinPrintedDigits = i2;
        }

        public int estimatePrintedLength() {
            return this.iMaxParsedDigits;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.appendPaddedInteger(appendable, this.iFieldType.getField(chronology).get(j), this.iMinPrintedDigits);
            } catch (RuntimeException unused) {
                DateTimeFormatterBuilder.appendUnknownString(appendable, this.iMinPrintedDigits);
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            if (readablePartial.isSupported(this.iFieldType)) {
                try {
                    FormatUtils.appendPaddedInteger(appendable, readablePartial.get(this.iFieldType), this.iMinPrintedDigits);
                    return;
                } catch (RuntimeException unused) {
                }
            }
            DateTimeFormatterBuilder.appendUnknownString(appendable, this.iMinPrintedDigits);
        }
    }

    public static class StringLiteral implements InternalPrinter, InternalParser {
        private final String iValue;

        public StringLiteral(String str) {
            this.iValue = str;
        }

        public int estimateParsedLength() {
            return this.iValue.length();
        }

        public int estimatePrintedLength() {
            return this.iValue.length();
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            return DateTimeFormatterBuilder.csStartsWithIgnoreCase(charSequence, i, this.iValue) ? i + this.iValue.length() : ~i;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            appendable.append(this.iValue);
        }
    }

    public static class TextField implements InternalPrinter, InternalParser {
        private static Map cParseCache = new ConcurrentHashMap();
        private final DateTimeFieldType iFieldType;
        private final boolean iShort;

        public TextField(DateTimeFieldType dateTimeFieldType, boolean z) {
            this.iFieldType = dateTimeFieldType;
            this.iShort = z;
        }

        private String print(long j, Chronology chronology, Locale locale) {
            DateTimeField field = this.iFieldType.getField(chronology);
            return this.iShort ? field.getAsShortText(j, locale) : field.getAsText(j, locale);
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int estimatePrintedLength() {
            return this.iShort ? 6 : 20;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int intValue;
            ConcurrentHashMap concurrentHashMap;
            Locale locale = dateTimeParserBucket.getLocale();
            ConcurrentHashMap concurrentHashMap2 = (Map) cParseCache.get(locale);
            if (concurrentHashMap2 == null) {
                concurrentHashMap2 = new ConcurrentHashMap();
                cParseCache.put(locale, concurrentHashMap2);
            }
            Object[] objArr = (Object[]) concurrentHashMap2.get(this.iFieldType);
            if (objArr == null) {
                concurrentHashMap = new ConcurrentHashMap(32);
                MutableDateTime.Property property = new MutableDateTime(0L, DateTimeZone.UTC).property(this.iFieldType);
                int minimumValueOverall = property.getMinimumValueOverall();
                int maximumValueOverall = property.getMaximumValueOverall();
                if (maximumValueOverall - minimumValueOverall > 32) {
                    return ~i;
                }
                intValue = property.getMaximumTextLength(locale);
                while (minimumValueOverall <= maximumValueOverall) {
                    property.set(minimumValueOverall);
                    String asShortText = property.getAsShortText(locale);
                    Boolean bool = Boolean.TRUE;
                    concurrentHashMap.put(asShortText, bool);
                    concurrentHashMap.put(property.getAsShortText(locale).toLowerCase(locale), bool);
                    concurrentHashMap.put(property.getAsShortText(locale).toUpperCase(locale), bool);
                    concurrentHashMap.put(property.getAsText(locale), bool);
                    concurrentHashMap.put(property.getAsText(locale).toLowerCase(locale), bool);
                    concurrentHashMap.put(property.getAsText(locale).toUpperCase(locale), bool);
                    minimumValueOverall++;
                }
                if ("en".equals(locale.getLanguage()) && this.iFieldType == DateTimeFieldType.era()) {
                    Boolean bool2 = Boolean.TRUE;
                    concurrentHashMap.put("BCE", bool2);
                    concurrentHashMap.put("bce", bool2);
                    concurrentHashMap.put("CE", bool2);
                    concurrentHashMap.put("ce", bool2);
                    intValue = 3;
                }
                concurrentHashMap2.put(this.iFieldType, new Object[]{concurrentHashMap, Integer.valueOf(intValue)});
            } else {
                ConcurrentHashMap concurrentHashMap3 = (Map) objArr[0];
                intValue = ((Integer) objArr[1]).intValue();
                concurrentHashMap = concurrentHashMap3;
            }
            for (int min = Math.min(charSequence.length(), intValue + i); min > i; min--) {
                String obj = charSequence.subSequence(i, min).toString();
                if (concurrentHashMap.containsKey(obj)) {
                    dateTimeParserBucket.saveField(this.iFieldType, obj, locale);
                    return min;
                }
            }
            return ~i;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                appendable.append(print(j, chronology, locale));
            } catch (RuntimeException unused) {
                appendable.append((char) 65533);
            }
        }

        private String print(ReadablePartial readablePartial, Locale locale) {
            if (!readablePartial.isSupported(this.iFieldType)) {
                return "�";
            }
            DateTimeField field = this.iFieldType.getField(readablePartial.getChronology());
            return this.iShort ? field.getAsShortText(readablePartial, locale) : field.getAsText(readablePartial, locale);
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            try {
                appendable.append(print(readablePartial, locale));
            } catch (RuntimeException unused) {
                appendable.append((char) 65533);
            }
        }
    }

    public enum TimeZoneId implements InternalPrinter, InternalParser {
        INSTANCE;

        static final Set ALL_IDS;
        static final int MAX_LENGTH;

        static {
            int i = 0;
            Set availableIDs = DateTimeZone.getAvailableIDs();
            ALL_IDS = availableIDs;
            Iterator it = availableIDs.iterator();
            while (it.hasNext()) {
                i = Math.max(i, ((String) it.next()).length());
            }
            MAX_LENGTH = i;
        }

        public int estimateParsedLength() {
            return MAX_LENGTH;
        }

        public int estimatePrintedLength() {
            return MAX_LENGTH;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            String str = null;
            for (String str2 : ALL_IDS) {
                if (DateTimeFormatterBuilder.csStartsWith(charSequence, i, str2) && (str == null || str2.length() > str.length())) {
                    str = str2;
                }
            }
            if (str == null) {
                return ~i;
            }
            dateTimeParserBucket.setZone(DateTimeZone.forID(str));
            return i + str.length();
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(dateTimeZone != null ? dateTimeZone.getID() : "");
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }
    }

    public static class TimeZoneName implements InternalPrinter, InternalParser {
        static final int LONG_NAME = 0;
        static final int SHORT_NAME = 1;
        private final Map iParseLookup;
        private final int iType;

        public TimeZoneName(int i, Map map) {
            this.iType = i;
            this.iParseLookup = map;
        }

        private String print(long j, DateTimeZone dateTimeZone, Locale locale) {
            if (dateTimeZone == null) {
                return "";
            }
            int i = this.iType;
            return i != 0 ? i != 1 ? "" : dateTimeZone.getShortName(j, locale) : dateTimeZone.getName(j, locale);
        }

        public int estimateParsedLength() {
            return this.iType == 1 ? 4 : 20;
        }

        public int estimatePrintedLength() {
            return this.iType == 1 ? 4 : 20;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            Map map = this.iParseLookup;
            if (map == null) {
                map = DateTimeUtils.getDefaultTimeZoneNames();
            }
            String str = null;
            for (String str2 : map.keySet()) {
                if (DateTimeFormatterBuilder.csStartsWith(charSequence, i, str2) && (str == null || str2.length() > str.length())) {
                    str = str2;
                }
            }
            if (str == null) {
                return ~i;
            }
            dateTimeParserBucket.setZone((DateTimeZone) map.get(str));
            return i + str.length();
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            appendable.append(print(j - i, dateTimeZone, locale));
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }
    }

    public static class TimeZoneOffset implements InternalPrinter, InternalParser {
        private final int iMaxFields;
        private final int iMinFields;
        private final boolean iShowSeparators;
        private final String iZeroOffsetParseText;
        private final String iZeroOffsetPrintText;

        public TimeZoneOffset(String str, String str2, boolean z, int i, int i2) {
            this.iZeroOffsetPrintText = str;
            this.iZeroOffsetParseText = str2;
            this.iShowSeparators = z;
            if (i <= 0 || i2 < i) {
                throw new IllegalArgumentException();
            }
            if (i > 4) {
                i = 4;
                i2 = 4;
            }
            this.iMinFields = i;
            this.iMaxFields = i2;
        }

        private int digitCount(CharSequence charSequence, int i, int i2) {
            int i3 = 0;
            for (int min = Math.min(charSequence.length() - i, i2); min > 0; min--) {
                char charAt = charSequence.charAt(i + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public int estimateParsedLength() {
            return estimatePrintedLength();
        }

        public int estimatePrintedLength() {
            int i = this.iMinFields;
            int i2 = (i + 1) << 1;
            if (this.iShowSeparators) {
                i2 += i - 1;
            }
            String str = this.iZeroOffsetPrintText;
            return (str == null || str.length() <= i2) ? i2 : this.iZeroOffsetPrintText.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:83:0x00e9 A[PHI: r0 r6
          0x00e9: PHI (r0v4 int) = (r0v3 int), (r0v5 int), (r0v3 int) binds: [B:63:0x00d4, B:77:0x0107, B:68:0x00e7] A[DONT_GENERATE, DONT_INLINE]
          0x00e9: PHI (r6v8 int) = (r6v7 int), (r6v9 int), (r6v7 int) binds: [B:63:0x00d4, B:77:0x0107, B:68:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parseInto(org.joda.time.format.DateTimeParserBucket r12, java.lang.CharSequence r13, int r14) {
            /*
                Method dump skipped, instructions count: 300
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.DateTimeFormatterBuilder.TimeZoneOffset.parseInto(org.joda.time.format.DateTimeParserBucket, java.lang.CharSequence, int):int");
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            String str;
            if (dateTimeZone == null) {
                return;
            }
            if (i == 0 && (str = this.iZeroOffsetPrintText) != null) {
                appendable.append(str);
                return;
            }
            if (i >= 0) {
                appendable.append('+');
            } else {
                appendable.append('-');
                i = -i;
            }
            int i2 = i / 3600000;
            FormatUtils.appendPaddedInteger(appendable, i2, 2);
            if (this.iMaxFields == 1) {
                return;
            }
            int i3 = i - (i2 * 3600000);
            if (i3 != 0 || this.iMinFields > 1) {
                int i4 = i3 / 60000;
                if (this.iShowSeparators) {
                    appendable.append(':');
                }
                FormatUtils.appendPaddedInteger(appendable, i4, 2);
                if (this.iMaxFields == 2) {
                    return;
                }
                int i5 = i3 - (i4 * 60000);
                if (i5 != 0 || this.iMinFields > 2) {
                    int i6 = i5 / 1000;
                    if (this.iShowSeparators) {
                        appendable.append(':');
                    }
                    FormatUtils.appendPaddedInteger(appendable, i6, 2);
                    if (this.iMaxFields == 3) {
                        return;
                    }
                    int i7 = i5 - (i6 * 1000);
                    if (i7 != 0 || this.iMinFields > 3) {
                        if (this.iShowSeparators) {
                            appendable.append('.');
                        }
                        FormatUtils.appendPaddedInteger(appendable, i7, 3);
                    }
                }
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
        }
    }

    public static class TwoDigitYear implements InternalPrinter, InternalParser {
        private final boolean iLenientParse;
        private final int iPivot;
        private final DateTimeFieldType iType;

        public TwoDigitYear(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            this.iType = dateTimeFieldType;
            this.iPivot = i;
            this.iLenientParse = z;
        }

        private int getTwoDigitYear(long j, Chronology chronology) {
            try {
                int i = this.iType.getField(chronology).get(j);
                if (i < 0) {
                    i = -i;
                }
                return i % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        public int estimateParsedLength() {
            return this.iLenientParse ? 4 : 2;
        }

        public int estimatePrintedLength() {
            return 2;
        }

        public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
            int i2;
            int i3;
            int length = charSequence.length() - i;
            if (this.iLenientParse) {
                int i4 = 0;
                boolean z = false;
                boolean z2 = false;
                while (i4 < length) {
                    char charAt = charSequence.charAt(i + i4);
                    if (i4 != 0 || (charAt != '-' && charAt != '+')) {
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i4++;
                    } else {
                        z2 = charAt == '-';
                        if (z2) {
                            i4++;
                        } else {
                            i++;
                            length--;
                        }
                        z = true;
                    }
                }
                if (i4 == 0) {
                    return ~i;
                }
                if (z || i4 != 2) {
                    if (i4 >= 9) {
                        i2 = i4 + i;
                        i3 = Integer.parseInt(charSequence.subSequence(i, i2).toString());
                    } else {
                        int i5 = z2 ? i + 1 : i;
                        int i6 = i5 + 1;
                        try {
                            int charAt2 = charSequence.charAt(i5) - '0';
                            i2 = i4 + i;
                            while (i6 < i2) {
                                int charAt3 = (((charAt2 << 3) + (charAt2 << 1)) + charSequence.charAt(i6)) - 48;
                                i6++;
                                charAt2 = charAt3;
                            }
                            i3 = z2 ? -charAt2 : charAt2;
                        } catch (StringIndexOutOfBoundsException unused) {
                            return ~i;
                        }
                    }
                    dateTimeParserBucket.saveField(this.iType, i3);
                    return i2;
                }
            } else if (Math.min(2, length) < 2) {
                return ~i;
            }
            char charAt4 = charSequence.charAt(i);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i;
            }
            int i7 = charAt4 - '0';
            char charAt5 = charSequence.charAt(i + 1);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i;
            }
            int i8 = (((i7 << 3) + (i7 << 1)) + charAt5) - 48;
            int i9 = this.iPivot;
            if (dateTimeParserBucket.getPivotYear() != null) {
                i9 = dateTimeParserBucket.getPivotYear().intValue();
            }
            int i10 = i9 - 50;
            int i11 = i10 >= 0 ? i10 % 100 : ((i9 - 49) % 100) + 99;
            dateTimeParserBucket.saveField(this.iType, i8 + ((i10 + (i8 < i11 ? 100 : 0)) - i11));
            return i + 2;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            int twoDigitYear = getTwoDigitYear(j, chronology);
            if (twoDigitYear >= 0) {
                FormatUtils.appendPaddedInteger(appendable, twoDigitYear, 2);
            } else {
                appendable.append((char) 65533);
                appendable.append((char) 65533);
            }
        }

        private int getTwoDigitYear(ReadablePartial readablePartial) {
            if (!readablePartial.isSupported(this.iType)) {
                return -1;
            }
            try {
                int i = readablePartial.get(this.iType);
                if (i < 0) {
                    i = -i;
                }
                return i % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            int twoDigitYear = getTwoDigitYear(readablePartial);
            if (twoDigitYear >= 0) {
                FormatUtils.appendPaddedInteger(appendable, twoDigitYear, 2);
            } else {
                appendable.append((char) 65533);
                appendable.append((char) 65533);
            }
        }
    }

    public static class UnpaddedNumber extends NumberFormatter {
        public UnpaddedNumber(DateTimeFieldType dateTimeFieldType, int i, boolean z) {
            super(dateTimeFieldType, i, z);
        }

        public int estimatePrintedLength() {
            return this.iMaxParsedDigits;
        }

        public void printTo(Appendable appendable, long j, Chronology chronology, int i, DateTimeZone dateTimeZone, Locale locale) throws IOException {
            try {
                FormatUtils.appendUnpaddedInteger(appendable, this.iFieldType.getField(chronology).get(j));
            } catch (RuntimeException unused) {
                appendable.append((char) 65533);
            }
        }

        public void printTo(Appendable appendable, ReadablePartial readablePartial, Locale locale) throws IOException {
            if (readablePartial.isSupported(this.iFieldType)) {
                try {
                    FormatUtils.appendUnpaddedInteger(appendable, readablePartial.get(this.iFieldType));
                    return;
                } catch (RuntimeException unused) {
                }
            }
            appendable.append((char) 65533);
        }
    }

    private DateTimeFormatterBuilder append0(Object obj) {
        this.iFormatter = null;
        this.iElementPairs.add(obj);
        this.iElementPairs.add(obj);
        return this;
    }

    public static void appendUnknownString(Appendable appendable, int i) throws IOException {
        while (true) {
            i--;
            if (i < 0) {
                return;
            } else {
                appendable.append((char) 65533);
            }
        }
    }

    private void checkParser(DateTimeParser dateTimeParser) {
        if (dateTimeParser == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    private void checkPrinter(DateTimePrinter dateTimePrinter) {
        if (dateTimePrinter == null) {
            throw new IllegalArgumentException("No printer supplied");
        }
    }

    public static boolean csStartsWith(CharSequence charSequence, int i, String str) {
        int length = str.length();
        if (charSequence.length() - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i + i2) != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean csStartsWithIgnoreCase(CharSequence charSequence, int i, String str) {
        char upperCase;
        char upperCase2;
        int length = str.length();
        if (charSequence.length() - i < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i + i2);
            char charAt2 = str.charAt(i2);
            if (charAt != charAt2 && (upperCase = Character.toUpperCase(charAt)) != (upperCase2 = Character.toUpperCase(charAt2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
        }
        return true;
    }

    private Object getFormatter() {
        Object obj = this.iFormatter;
        if (obj == null) {
            if (this.iElementPairs.size() == 2) {
                Object obj2 = this.iElementPairs.get(0);
                Object obj3 = this.iElementPairs.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new Composite(this.iElementPairs);
            }
            this.iFormatter = obj;
        }
        return obj;
    }

    private boolean isFormatter(Object obj) {
        return isPrinter(obj) || isParser(obj);
    }

    private boolean isParser(Object obj) {
        if (!(obj instanceof InternalParser)) {
            return false;
        }
        if (obj instanceof Composite) {
            return ((Composite) obj).isParser();
        }
        return true;
    }

    private boolean isPrinter(Object obj) {
        if (!(obj instanceof InternalPrinter)) {
            return false;
        }
        if (obj instanceof Composite) {
            return ((Composite) obj).isPrinter();
        }
        return true;
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter != null) {
            return append0(dateTimeFormatter.getPrinter0(), dateTimeFormatter.getParser0());
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public DateTimeFormatterBuilder appendCenturyOfEra(int i, int i2) {
        return appendSignedDecimal(DateTimeFieldType.centuryOfEra(), i, i2);
    }

    public DateTimeFormatterBuilder appendClockhourOfDay(int i) {
        return appendDecimal(DateTimeFieldType.clockhourOfDay(), i, 2);
    }

    public DateTimeFormatterBuilder appendClockhourOfHalfday(int i) {
        return appendDecimal(DateTimeFieldType.clockhourOfHalfday(), i, 2);
    }

    public DateTimeFormatterBuilder appendDayOfMonth(int i) {
        return appendDecimal(DateTimeFieldType.dayOfMonth(), i, 2);
    }

    public DateTimeFormatterBuilder appendDayOfWeek(int i) {
        return appendDecimal(DateTimeFieldType.dayOfWeek(), i, 1);
    }

    public DateTimeFormatterBuilder appendDayOfWeekShortText() {
        return appendShortText(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder appendDayOfWeekText() {
        return appendText(DateTimeFieldType.dayOfWeek());
    }

    public DateTimeFormatterBuilder appendDayOfYear(int i) {
        return appendDecimal(DateTimeFieldType.dayOfYear(), i, 3);
    }

    public DateTimeFormatterBuilder appendDecimal(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        return i <= 1 ? append0(new UnpaddedNumber(dateTimeFieldType, i2, false)) : append0(new PaddedNumber(dateTimeFieldType, i2, false, i));
    }

    public DateTimeFormatterBuilder appendEraText() {
        return appendText(DateTimeFieldType.era());
    }

    public DateTimeFormatterBuilder appendFixedDecimal(DateTimeFieldType dateTimeFieldType, int i) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i > 0) {
            return append0(new FixedNumber(dateTimeFieldType, i, false));
        }
        throw new IllegalArgumentException("Illegal number of digits: " + i);
    }

    public DateTimeFormatterBuilder appendFixedSignedDecimal(DateTimeFieldType dateTimeFieldType, int i) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i > 0) {
            return append0(new FixedNumber(dateTimeFieldType, i, true));
        }
        throw new IllegalArgumentException("Illegal number of digits: " + i);
    }

    public DateTimeFormatterBuilder appendFraction(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        return append0(new Fraction(dateTimeFieldType, i, i2));
    }

    public DateTimeFormatterBuilder appendFractionOfDay(int i, int i2) {
        return appendFraction(DateTimeFieldType.dayOfYear(), i, i2);
    }

    public DateTimeFormatterBuilder appendFractionOfHour(int i, int i2) {
        return appendFraction(DateTimeFieldType.hourOfDay(), i, i2);
    }

    public DateTimeFormatterBuilder appendFractionOfMinute(int i, int i2) {
        return appendFraction(DateTimeFieldType.minuteOfDay(), i, i2);
    }

    public DateTimeFormatterBuilder appendFractionOfSecond(int i, int i2) {
        return appendFraction(DateTimeFieldType.secondOfDay(), i, i2);
    }

    public DateTimeFormatterBuilder appendHalfdayOfDayText() {
        return appendText(DateTimeFieldType.halfdayOfDay());
    }

    public DateTimeFormatterBuilder appendHourOfDay(int i) {
        return appendDecimal(DateTimeFieldType.hourOfDay(), i, 2);
    }

    public DateTimeFormatterBuilder appendHourOfHalfday(int i) {
        return appendDecimal(DateTimeFieldType.hourOfHalfday(), i, 2);
    }

    public DateTimeFormatterBuilder appendLiteral(char c) {
        return append0(new CharacterLiteral(c));
    }

    public DateTimeFormatterBuilder appendMillisOfDay(int i) {
        return appendDecimal(DateTimeFieldType.millisOfDay(), i, 8);
    }

    public DateTimeFormatterBuilder appendMillisOfSecond(int i) {
        return appendDecimal(DateTimeFieldType.millisOfSecond(), i, 3);
    }

    public DateTimeFormatterBuilder appendMinuteOfDay(int i) {
        return appendDecimal(DateTimeFieldType.minuteOfDay(), i, 4);
    }

    public DateTimeFormatterBuilder appendMinuteOfHour(int i) {
        return appendDecimal(DateTimeFieldType.minuteOfHour(), i, 2);
    }

    public DateTimeFormatterBuilder appendMonthOfYear(int i) {
        return appendDecimal(DateTimeFieldType.monthOfYear(), i, 2);
    }

    public DateTimeFormatterBuilder appendMonthOfYearShortText() {
        return appendShortText(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder appendMonthOfYearText() {
        return appendText(DateTimeFieldType.monthOfYear());
    }

    public DateTimeFormatterBuilder appendOptional(DateTimeParser dateTimeParser) {
        checkParser(dateTimeParser);
        return append0(null, new MatchingParser(new InternalParser[]{DateTimeParserInternalParser.of(dateTimeParser), null}));
    }

    public DateTimeFormatterBuilder appendPattern(String str) {
        DateTimeFormat.appendPatternTo(this, str);
        return this;
    }

    public DateTimeFormatterBuilder appendSecondOfDay(int i) {
        return appendDecimal(DateTimeFieldType.secondOfDay(), i, 5);
    }

    public DateTimeFormatterBuilder appendSecondOfMinute(int i) {
        return appendDecimal(DateTimeFieldType.secondOfMinute(), i, 2);
    }

    public DateTimeFormatterBuilder appendShortText(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return append0(new TextField(dateTimeFieldType, true));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder appendSignedDecimal(DateTimeFieldType dateTimeFieldType, int i, int i2) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field type must not be null");
        }
        if (i2 < i) {
            i2 = i;
        }
        if (i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        return i <= 1 ? append0(new UnpaddedNumber(dateTimeFieldType, i2, true)) : append0(new PaddedNumber(dateTimeFieldType, i2, true, i));
    }

    public DateTimeFormatterBuilder appendText(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return append0(new TextField(dateTimeFieldType, false));
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public DateTimeFormatterBuilder appendTimeZoneId() {
        TimeZoneId timeZoneId = TimeZoneId.INSTANCE;
        return append0(timeZoneId, timeZoneId);
    }

    public DateTimeFormatterBuilder appendTimeZoneName() {
        return append0(new TimeZoneName(0, null), null);
    }

    public DateTimeFormatterBuilder appendTimeZoneOffset(String str, String str2, boolean z, int i, int i2) {
        return append0(new TimeZoneOffset(str, str2, z, i, i2));
    }

    public DateTimeFormatterBuilder appendTimeZoneShortName() {
        return append0(new TimeZoneName(1, null), null);
    }

    public DateTimeFormatterBuilder appendTwoDigitWeekyear(int i) {
        return appendTwoDigitWeekyear(i, false);
    }

    public DateTimeFormatterBuilder appendTwoDigitYear(int i) {
        return appendTwoDigitYear(i, false);
    }

    public DateTimeFormatterBuilder appendWeekOfWeekyear(int i) {
        return appendDecimal(DateTimeFieldType.weekOfWeekyear(), i, 2);
    }

    public DateTimeFormatterBuilder appendWeekyear(int i, int i2) {
        return appendSignedDecimal(DateTimeFieldType.weekyear(), i, i2);
    }

    public DateTimeFormatterBuilder appendYear(int i, int i2) {
        return appendSignedDecimal(DateTimeFieldType.year(), i, i2);
    }

    public DateTimeFormatterBuilder appendYearOfCentury(int i, int i2) {
        return appendDecimal(DateTimeFieldType.yearOfCentury(), i, i2);
    }

    public DateTimeFormatterBuilder appendYearOfEra(int i, int i2) {
        return appendDecimal(DateTimeFieldType.yearOfEra(), i, i2);
    }

    public boolean canBuildFormatter() {
        return isFormatter(getFormatter());
    }

    public boolean canBuildParser() {
        return isParser(getFormatter());
    }

    public boolean canBuildPrinter() {
        return isPrinter(getFormatter());
    }

    public void clear() {
        this.iFormatter = null;
        this.iElementPairs.clear();
    }

    public DateTimeFormatter toFormatter() {
        Object formatter = getFormatter();
        InternalPrinter internalPrinter = isPrinter(formatter) ? (InternalPrinter) formatter : null;
        InternalParser internalParser = isParser(formatter) ? (InternalParser) formatter : null;
        if (internalPrinter == null && internalParser == null) {
            throw new UnsupportedOperationException("Both printing and parsing not supported");
        }
        return new DateTimeFormatter(internalPrinter, internalParser);
    }

    public DateTimeParser toParser() {
        Object formatter = getFormatter();
        if (isParser(formatter)) {
            return InternalParserDateTimeParser.of((InternalParser) formatter);
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    public DateTimePrinter toPrinter() {
        Object formatter = getFormatter();
        if (isPrinter(formatter)) {
            return InternalPrinterDateTimePrinter.of((InternalPrinter) formatter);
        }
        throw new UnsupportedOperationException("Printing is not supported");
    }

    private DateTimeFormatterBuilder append0(InternalPrinter internalPrinter, InternalParser internalParser) {
        this.iFormatter = null;
        this.iElementPairs.add(internalPrinter);
        this.iElementPairs.add(internalParser);
        return this;
    }

    public DateTimeFormatterBuilder append(DateTimeParser dateTimeParser) {
        checkParser(dateTimeParser);
        return append0(null, DateTimeParserInternalParser.of(dateTimeParser));
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Literal must not be null");
        }
        int length = str.length();
        if (length != 0) {
            return append0(length != 1 ? new StringLiteral(str) : new CharacterLiteral(str.charAt(0)));
        }
        return this;
    }

    public DateTimeFormatterBuilder appendTimeZoneName(Map map) {
        TimeZoneName timeZoneName = new TimeZoneName(0, map);
        return append0(timeZoneName, timeZoneName);
    }

    public DateTimeFormatterBuilder appendTimeZoneOffset(String str, boolean z, int i, int i2) {
        return append0(new TimeZoneOffset(str, str, z, i, i2));
    }

    public DateTimeFormatterBuilder appendTimeZoneShortName(Map map) {
        TimeZoneName timeZoneName = new TimeZoneName(1, map);
        return append0(timeZoneName, timeZoneName);
    }

    public DateTimeFormatterBuilder appendTwoDigitWeekyear(int i, boolean z) {
        return append0(new TwoDigitYear(DateTimeFieldType.weekyear(), i, z));
    }

    public DateTimeFormatterBuilder appendTwoDigitYear(int i, boolean z) {
        return append0(new TwoDigitYear(DateTimeFieldType.year(), i, z));
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter) {
        checkPrinter(dateTimePrinter);
        return append0(DateTimePrinterInternalPrinter.of(dateTimePrinter), null);
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter, DateTimeParser dateTimeParser) {
        checkPrinter(dateTimePrinter);
        checkParser(dateTimeParser);
        return append0(DateTimePrinterInternalPrinter.of(dateTimePrinter), DateTimeParserInternalParser.of(dateTimeParser));
    }

    public DateTimeFormatterBuilder append(DateTimePrinter dateTimePrinter, DateTimeParser[] dateTimeParserArr) {
        InternalPrinter of;
        InternalParser matchingParser;
        if (dateTimePrinter != null) {
            checkPrinter(dateTimePrinter);
        }
        if (dateTimeParserArr == null) {
            throw new IllegalArgumentException("No parsers supplied");
        }
        int length = dateTimeParserArr.length;
        int i = 0;
        if (length != 1) {
            InternalParser[] internalParserArr = new InternalParser[length];
            while (i < length - 1) {
                InternalParser of2 = DateTimeParserInternalParser.of(dateTimeParserArr[i]);
                internalParserArr[i] = of2;
                if (of2 == null) {
                    throw new IllegalArgumentException("Incomplete parser array");
                }
                i++;
            }
            internalParserArr[i] = DateTimeParserInternalParser.of(dateTimeParserArr[i]);
            of = DateTimePrinterInternalPrinter.of(dateTimePrinter);
            matchingParser = new MatchingParser(internalParserArr);
        } else {
            if (dateTimeParserArr[0] == null) {
                throw new IllegalArgumentException("No parser supplied");
            }
            of = DateTimePrinterInternalPrinter.of(dateTimePrinter);
            matchingParser = DateTimeParserInternalParser.of(dateTimeParserArr[0]);
        }
        return append0(of, matchingParser);
    }
}
