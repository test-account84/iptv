package org.joda.time.tz;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DateTimeZoneBuilder {
    private final ArrayList iRuleSets = new ArrayList(10);

    public static final class DSTZone extends DateTimeZone {
        private static final long serialVersionUID = 6941492635554961361L;
        final Recurrence iEndRecurrence;
        final int iStandardOffset;
        final Recurrence iStartRecurrence;

        public DSTZone(String str, int i, Recurrence recurrence, Recurrence recurrence2) {
            super(str);
            this.iStandardOffset = i;
            this.iStartRecurrence = recurrence;
            this.iEndRecurrence = recurrence2;
        }

        private Recurrence findMatchingRecurrence(long j) {
            long j2;
            int i = this.iStandardOffset;
            Recurrence recurrence = this.iStartRecurrence;
            Recurrence recurrence2 = this.iEndRecurrence;
            try {
                j2 = recurrence.next(j, i, recurrence2.getSaveMillis());
            } catch (IllegalArgumentException | ArithmeticException unused) {
                j2 = j;
            }
            try {
                j = recurrence2.next(j, i, recurrence.getSaveMillis());
            } catch (IllegalArgumentException | ArithmeticException unused2) {
            }
            return j2 > j ? recurrence : recurrence2;
        }

        public static DSTZone readFrom(DataInput dataInput, String str) throws IOException {
            return new DSTZone(str, (int) DateTimeZoneBuilder.readMillis(dataInput), Recurrence.readFrom(dataInput), Recurrence.readFrom(dataInput));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DSTZone)) {
                return false;
            }
            DSTZone dSTZone = (DSTZone) obj;
            return getID().equals(dSTZone.getID()) && this.iStandardOffset == dSTZone.iStandardOffset && this.iStartRecurrence.equals(dSTZone.iStartRecurrence) && this.iEndRecurrence.equals(dSTZone.iEndRecurrence);
        }

        public String getNameKey(long j) {
            return findMatchingRecurrence(j).getNameKey();
        }

        public int getOffset(long j) {
            return this.iStandardOffset + findMatchingRecurrence(j).getSaveMillis();
        }

        public int getStandardOffset(long j) {
            return this.iStandardOffset;
        }

        public boolean isFixed() {
            return false;
        }

        public long nextTransition(long j) {
            long j2;
            int i = this.iStandardOffset;
            Recurrence recurrence = this.iStartRecurrence;
            Recurrence recurrence2 = this.iEndRecurrence;
            try {
                j2 = recurrence.next(j, i, recurrence2.getSaveMillis());
            } catch (IllegalArgumentException | ArithmeticException unused) {
            }
            if (j > 0 && j2 < 0) {
                j2 = j;
            }
            try {
                long next = recurrence2.next(j, i, recurrence.getSaveMillis());
                if (j <= 0 || next >= 0) {
                    j = next;
                }
            } catch (IllegalArgumentException | ArithmeticException unused2) {
            }
            return j2 > j ? j : j2;
        }

        public long previousTransition(long j) {
            long j2;
            long j3 = j + 1;
            int i = this.iStandardOffset;
            Recurrence recurrence = this.iStartRecurrence;
            Recurrence recurrence2 = this.iEndRecurrence;
            try {
                j2 = recurrence.previous(j3, i, recurrence2.getSaveMillis());
            } catch (IllegalArgumentException | ArithmeticException unused) {
            }
            if (j3 < 0 && j2 > 0) {
                j2 = j3;
            }
            try {
                long previous = recurrence2.previous(j3, i, recurrence.getSaveMillis());
                if (j3 >= 0 || previous <= 0) {
                    j3 = previous;
                }
            } catch (IllegalArgumentException | ArithmeticException unused2) {
            }
            if (j2 <= j3) {
                j2 = j3;
            }
            return j2 - 1;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            DateTimeZoneBuilder.writeMillis(dataOutput, this.iStandardOffset);
            this.iStartRecurrence.writeTo(dataOutput);
            this.iEndRecurrence.writeTo(dataOutput);
        }
    }

    public static final class OfYear {
        final boolean iAdvance;
        final int iDayOfMonth;
        final int iDayOfWeek;
        final int iMillisOfDay;
        final char iMode;
        final int iMonthOfYear;

        public OfYear(char c, int i, int i2, int i3, boolean z, int i4) {
            if (c != 'u' && c != 'w' && c != 's') {
                throw new IllegalArgumentException("Unknown mode: " + c);
            }
            this.iMode = c;
            this.iMonthOfYear = i;
            this.iDayOfMonth = i2;
            this.iDayOfWeek = i3;
            this.iAdvance = z;
            this.iMillisOfDay = i4;
        }

        public static OfYear readFrom(DataInput dataInput) throws IOException {
            return new OfYear((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) DateTimeZoneBuilder.readMillis(dataInput));
        }

        private long setDayOfMonth(Chronology chronology, long j) {
            if (this.iDayOfMonth >= 0) {
                return chronology.dayOfMonth().set(j, this.iDayOfMonth);
            }
            return chronology.dayOfMonth().add(chronology.monthOfYear().add(chronology.dayOfMonth().set(j, 1), 1), this.iDayOfMonth);
        }

        private long setDayOfMonthNext(Chronology chronology, long j) {
            try {
                return setDayOfMonth(chronology, j);
            } catch (IllegalArgumentException e) {
                if (this.iMonthOfYear != 2 || this.iDayOfMonth != 29) {
                    throw e;
                }
                while (!chronology.year().isLeap(j)) {
                    j = chronology.year().add(j, 1);
                }
                return setDayOfMonth(chronology, j);
            }
        }

        private long setDayOfMonthPrevious(Chronology chronology, long j) {
            try {
                return setDayOfMonth(chronology, j);
            } catch (IllegalArgumentException e) {
                if (this.iMonthOfYear != 2 || this.iDayOfMonth != 29) {
                    throw e;
                }
                while (!chronology.year().isLeap(j)) {
                    j = chronology.year().add(j, -1);
                }
                return setDayOfMonth(chronology, j);
            }
        }

        private long setDayOfWeek(Chronology chronology, long j) {
            int i = this.iDayOfWeek - chronology.dayOfWeek().get(j);
            if (i == 0) {
                return j;
            }
            if (this.iAdvance) {
                if (i < 0) {
                    i += 7;
                }
            } else if (i > 0) {
                i -= 7;
            }
            return chronology.dayOfWeek().add(j, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfYear)) {
                return false;
            }
            OfYear ofYear = (OfYear) obj;
            return this.iMode == ofYear.iMode && this.iMonthOfYear == ofYear.iMonthOfYear && this.iDayOfMonth == ofYear.iDayOfMonth && this.iDayOfWeek == ofYear.iDayOfWeek && this.iAdvance == ofYear.iAdvance && this.iMillisOfDay == ofYear.iMillisOfDay;
        }

        public long next(long j, int i, int i2) {
            char c = this.iMode;
            if (c == 'w') {
                i += i2;
            } else if (c != 's') {
                i = 0;
            }
            long j2 = i;
            long j3 = j + j2;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonthNext = setDayOfMonthNext(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j3, this.iMonthOfYear), 0), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonthNext = setDayOfWeek(instanceUTC, dayOfMonthNext);
                if (dayOfMonthNext <= j3) {
                    dayOfMonthNext = setDayOfWeek(instanceUTC, setDayOfMonthNext(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(dayOfMonthNext, 1), this.iMonthOfYear)));
                }
            } else if (dayOfMonthNext <= j3) {
                dayOfMonthNext = setDayOfMonthNext(instanceUTC, instanceUTC.year().add(dayOfMonthNext, 1));
            }
            return dayOfMonthNext - j2;
        }

        public long previous(long j, int i, int i2) {
            char c = this.iMode;
            if (c == 'w') {
                i += i2;
            } else if (c != 's') {
                i = 0;
            }
            long j2 = i;
            long j3 = j + j2;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonthPrevious = setDayOfMonthPrevious(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j3, this.iMonthOfYear), 0), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonthPrevious = setDayOfWeek(instanceUTC, dayOfMonthPrevious);
                if (dayOfMonthPrevious >= j3) {
                    dayOfMonthPrevious = setDayOfWeek(instanceUTC, setDayOfMonthPrevious(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(dayOfMonthPrevious, -1), this.iMonthOfYear)));
                }
            } else if (dayOfMonthPrevious >= j3) {
                dayOfMonthPrevious = setDayOfMonthPrevious(instanceUTC, instanceUTC.year().add(dayOfMonthPrevious, -1));
            }
            return dayOfMonthPrevious - j2;
        }

        public long setInstant(int i, int i2, int i3) {
            char c = this.iMode;
            if (c == 'w') {
                i2 += i3;
            } else if (c != 's') {
                i2 = 0;
            }
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long dayOfMonth = setDayOfMonth(instanceUTC, instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(instanceUTC.year().set(0L, i), this.iMonthOfYear), this.iMillisOfDay));
            if (this.iDayOfWeek != 0) {
                dayOfMonth = setDayOfWeek(instanceUTC, dayOfMonth);
            }
            return dayOfMonth - i2;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(this.iMode);
            dataOutput.writeByte(this.iMonthOfYear);
            dataOutput.writeByte(this.iDayOfMonth);
            dataOutput.writeByte(this.iDayOfWeek);
            dataOutput.writeBoolean(this.iAdvance);
            DateTimeZoneBuilder.writeMillis(dataOutput, this.iMillisOfDay);
        }
    }

    public static final class PrecalculatedZone extends DateTimeZone {
        private static final long serialVersionUID = 7811976468055766265L;
        private final String[] iNameKeys;
        private final int[] iStandardOffsets;
        private final DSTZone iTailZone;
        private final long[] iTransitions;
        private final int[] iWallOffsets;

        private PrecalculatedZone(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, DSTZone dSTZone) {
            super(str);
            this.iTransitions = jArr;
            this.iWallOffsets = iArr;
            this.iStandardOffsets = iArr2;
            this.iNameKeys = strArr;
            this.iTailZone = dSTZone;
        }

        public static PrecalculatedZone create(String str, boolean z, ArrayList arrayList, DSTZone dSTZone) {
            DSTZone dSTZone2;
            DSTZone dSTZone3 = dSTZone;
            int size = arrayList.size();
            if (size == 0) {
                throw new IllegalArgumentException();
            }
            long[] jArr = new long[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            String[] strArr = new String[size];
            int i = 0;
            Transition transition = null;
            int i2 = 0;
            while (i2 < size) {
                Transition transition2 = (Transition) arrayList.get(i2);
                if (!transition2.isTransitionFrom(transition)) {
                    throw new IllegalArgumentException(str);
                }
                jArr[i2] = transition2.getMillis();
                iArr[i2] = transition2.getWallOffset();
                iArr2[i2] = transition2.getStandardOffset();
                strArr[i2] = transition2.getNameKey();
                i2++;
                transition = transition2;
            }
            String[] strArr2 = new String[5];
            for (String[] strArr3 : new DateFormatSymbols(Locale.ENGLISH).getZoneStrings()) {
                if (strArr3 != null && strArr3.length == 5 && str.equals(strArr3[0])) {
                    strArr2 = strArr3;
                }
            }
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            while (i < size - 1) {
                String str2 = strArr[i];
                int i3 = i + 1;
                String str3 = strArr[i3];
                long j = iArr[i];
                long j2 = iArr[i3];
                String[] strArr4 = strArr;
                String[] strArr5 = strArr2;
                long j3 = iArr2[i];
                int[] iArr3 = iArr;
                int[] iArr4 = iArr2;
                long j4 = iArr2[i3];
                int i4 = size;
                Period period = new Period(jArr[i], jArr[i3], PeriodType.yearMonthDay(), instanceUTC);
                if (j != j2 && j3 == j4 && str2.equals(str3) && period.getYears() == 0 && period.getMonths() > 4 && period.getMonths() < 8 && str2.equals(strArr5[2]) && str2.equals(strArr5[4])) {
                    if (ZoneInfoCompiler.verbose()) {
                        PrintStream printStream = System.out;
                        printStream.println("Fixing duplicate name key - " + str3);
                        printStream.println("     - " + new DateTime(jArr[i], instanceUTC) + " - " + new DateTime(jArr[i3], instanceUTC));
                    }
                    if (j > j2) {
                        strArr4[i] = (str2 + "-Summer").intern();
                    } else if (j < j2) {
                        strArr4[i3] = (str3 + "-Summer").intern();
                        i = i3;
                    }
                }
                i++;
                strArr2 = strArr5;
                dSTZone3 = dSTZone;
                strArr = strArr4;
                iArr = iArr3;
                iArr2 = iArr4;
                size = i4;
            }
            DSTZone dSTZone4 = dSTZone3;
            int[] iArr5 = iArr;
            int[] iArr6 = iArr2;
            String[] strArr6 = strArr;
            if (dSTZone4 == null || !dSTZone4.iStartRecurrence.getNameKey().equals(dSTZone4.iEndRecurrence.getNameKey())) {
                dSTZone2 = dSTZone4;
            } else {
                if (ZoneInfoCompiler.verbose()) {
                    System.out.println("Fixing duplicate recurrent name key - " + dSTZone4.iStartRecurrence.getNameKey());
                }
                dSTZone2 = dSTZone4.iStartRecurrence.getSaveMillis() > 0 ? new DSTZone(dSTZone.getID(), dSTZone4.iStandardOffset, dSTZone4.iStartRecurrence.renameAppend("-Summer"), dSTZone4.iEndRecurrence) : new DSTZone(dSTZone.getID(), dSTZone4.iStandardOffset, dSTZone4.iStartRecurrence, dSTZone4.iEndRecurrence.renameAppend("-Summer"));
            }
            return new PrecalculatedZone(z ? str : "", jArr, iArr5, iArr6, strArr6, dSTZone2);
        }

        public static PrecalculatedZone readFrom(DataInput dataInput, String str) throws IOException {
            int readUnsignedByte;
            int readUnsignedShort = dataInput.readUnsignedShort();
            String[] strArr = new String[readUnsignedShort];
            for (int i = 0; i < readUnsignedShort; i++) {
                strArr[i] = dataInput.readUTF();
            }
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            String[] strArr2 = new String[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                jArr[i2] = DateTimeZoneBuilder.readMillis(dataInput);
                iArr[i2] = (int) DateTimeZoneBuilder.readMillis(dataInput);
                iArr2[i2] = (int) DateTimeZoneBuilder.readMillis(dataInput);
                if (readUnsignedShort < 256) {
                    try {
                        readUnsignedByte = dataInput.readUnsignedByte();
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new IOException("Invalid encoding");
                    }
                } else {
                    readUnsignedByte = dataInput.readUnsignedShort();
                }
                strArr2[i2] = strArr[readUnsignedByte];
            }
            return new PrecalculatedZone(str, jArr, iArr, iArr2, strArr2, dataInput.readBoolean() ? DSTZone.readFrom(dataInput, str) : null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrecalculatedZone)) {
                return false;
            }
            PrecalculatedZone precalculatedZone = (PrecalculatedZone) obj;
            if (getID().equals(precalculatedZone.getID()) && Arrays.equals(this.iTransitions, precalculatedZone.iTransitions) && Arrays.equals(this.iNameKeys, precalculatedZone.iNameKeys) && Arrays.equals(this.iWallOffsets, precalculatedZone.iWallOffsets) && Arrays.equals(this.iStandardOffsets, precalculatedZone.iStandardOffsets)) {
                DSTZone dSTZone = this.iTailZone;
                DSTZone dSTZone2 = precalculatedZone.iTailZone;
                if (dSTZone == null) {
                    if (dSTZone2 == null) {
                        return true;
                    }
                } else if (dSTZone.equals(dSTZone2)) {
                    return true;
                }
            }
            return false;
        }

        public String getNameKey(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.iNameKeys[binarySearch];
            }
            int i = ~binarySearch;
            if (i < jArr.length) {
                return i > 0 ? this.iNameKeys[i - 1] : "UTC";
            }
            DSTZone dSTZone = this.iTailZone;
            return dSTZone == null ? this.iNameKeys[i - 1] : dSTZone.getNameKey(j);
        }

        public int getOffset(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.iWallOffsets[binarySearch];
            }
            int i = ~binarySearch;
            if (i >= jArr.length) {
                DSTZone dSTZone = this.iTailZone;
                return dSTZone == null ? this.iWallOffsets[i - 1] : dSTZone.getOffset(j);
            }
            if (i > 0) {
                return this.iWallOffsets[i - 1];
            }
            return 0;
        }

        public int getStandardOffset(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return this.iStandardOffsets[binarySearch];
            }
            int i = ~binarySearch;
            if (i >= jArr.length) {
                DSTZone dSTZone = this.iTailZone;
                return dSTZone == null ? this.iStandardOffsets[i - 1] : dSTZone.getStandardOffset(j);
            }
            if (i > 0) {
                return this.iStandardOffsets[i - 1];
            }
            return 0;
        }

        public boolean isCachable() {
            if (this.iTailZone != null) {
                return true;
            }
            long[] jArr = this.iTransitions;
            if (jArr.length <= 1) {
                return false;
            }
            double d = 0.0d;
            int i = 0;
            for (int i2 = 1; i2 < jArr.length; i2++) {
                long j = jArr[i2] - jArr[i2 - 1];
                if (j < 63158400000L) {
                    d += j;
                    i++;
                }
            }
            return i > 0 && (d / ((double) i)) / 8.64E7d >= 25.0d;
        }

        public boolean isFixed() {
            return false;
        }

        public long nextTransition(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            int i = binarySearch >= 0 ? binarySearch + 1 : ~binarySearch;
            if (i < jArr.length) {
                return jArr[i];
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone == null) {
                return j;
            }
            long j2 = jArr[jArr.length - 1];
            if (j < j2) {
                j = j2;
            }
            return dSTZone.nextTransition(j);
        }

        public long previousTransition(long j) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j);
            if (binarySearch >= 0) {
                return j > Long.MIN_VALUE ? j - 1 : j;
            }
            int i = ~binarySearch;
            if (i < jArr.length) {
                if (i > 0) {
                    long j2 = jArr[i - 1];
                    if (j2 > Long.MIN_VALUE) {
                        return j2 - 1;
                    }
                }
                return j;
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone != null) {
                long previousTransition = dSTZone.previousTransition(j);
                if (previousTransition < j) {
                    return previousTransition;
                }
            }
            long j3 = jArr[i - 1];
            return j3 > Long.MIN_VALUE ? j3 - 1 : j;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            int length = this.iTransitions.length;
            HashSet hashSet = new HashSet();
            for (int i = 0; i < length; i++) {
                hashSet.add(this.iNameKeys[i]);
            }
            int size = hashSet.size();
            if (size > 65535) {
                throw new UnsupportedOperationException("String pool is too large");
            }
            String[] strArr = new String[size];
            Iterator it = hashSet.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                strArr[i2] = (String) it.next();
                i2++;
            }
            dataOutput.writeShort(size);
            for (int i3 = 0; i3 < size; i3++) {
                dataOutput.writeUTF(strArr[i3]);
            }
            dataOutput.writeInt(length);
            for (int i4 = 0; i4 < length; i4++) {
                DateTimeZoneBuilder.writeMillis(dataOutput, this.iTransitions[i4]);
                DateTimeZoneBuilder.writeMillis(dataOutput, this.iWallOffsets[i4]);
                DateTimeZoneBuilder.writeMillis(dataOutput, this.iStandardOffsets[i4]);
                String str = this.iNameKeys[i4];
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    if (!strArr[i5].equals(str)) {
                        i5++;
                    } else if (size < 256) {
                        dataOutput.writeByte(i5);
                    } else {
                        dataOutput.writeShort(i5);
                    }
                }
            }
            dataOutput.writeBoolean(this.iTailZone != null);
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone != null) {
                dSTZone.writeTo(dataOutput);
            }
        }
    }

    public static final class Recurrence {
        final String iNameKey;
        final OfYear iOfYear;
        final int iSaveMillis;

        public Recurrence(OfYear ofYear, String str, int i) {
            this.iOfYear = ofYear;
            this.iNameKey = str;
            this.iSaveMillis = i;
        }

        public static Recurrence readFrom(DataInput dataInput) throws IOException {
            return new Recurrence(OfYear.readFrom(dataInput), dataInput.readUTF(), (int) DateTimeZoneBuilder.readMillis(dataInput));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Recurrence)) {
                return false;
            }
            Recurrence recurrence = (Recurrence) obj;
            return this.iSaveMillis == recurrence.iSaveMillis && this.iNameKey.equals(recurrence.iNameKey) && this.iOfYear.equals(recurrence.iOfYear);
        }

        public String getNameKey() {
            return this.iNameKey;
        }

        public OfYear getOfYear() {
            return this.iOfYear;
        }

        public int getSaveMillis() {
            return this.iSaveMillis;
        }

        public long next(long j, int i, int i2) {
            return this.iOfYear.next(j, i, i2);
        }

        public long previous(long j, int i, int i2) {
            return this.iOfYear.previous(j, i, i2);
        }

        public Recurrence rename(String str) {
            return new Recurrence(this.iOfYear, str, this.iSaveMillis);
        }

        public Recurrence renameAppend(String str) {
            return rename((this.iNameKey + str).intern());
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            this.iOfYear.writeTo(dataOutput);
            dataOutput.writeUTF(this.iNameKey);
            DateTimeZoneBuilder.writeMillis(dataOutput, this.iSaveMillis);
        }
    }

    public static final class Rule {
        final int iFromYear;
        final Recurrence iRecurrence;
        final int iToYear;

        public Rule(Recurrence recurrence, int i, int i2) {
            this.iRecurrence = recurrence;
            this.iFromYear = i;
            this.iToYear = i2;
        }

        public int getFromYear() {
            return this.iFromYear;
        }

        public String getNameKey() {
            return this.iRecurrence.getNameKey();
        }

        public OfYear getOfYear() {
            return this.iRecurrence.getOfYear();
        }

        public int getSaveMillis() {
            return this.iRecurrence.getSaveMillis();
        }

        public int getToYear() {
            return this.iToYear;
        }

        public long next(long j, int i, int i2) {
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            int i3 = i + i2;
            long next = this.iRecurrence.next(((j > Long.MIN_VALUE ? 1 : (j == Long.MIN_VALUE ? 0 : -1)) == 0 ? Integer.MIN_VALUE : instanceUTC.year().get(((long) i3) + j)) < this.iFromYear ? (instanceUTC.year().set(0L, this.iFromYear) - i3) - 1 : j, i, i2);
            return (next <= j || instanceUTC.year().get(((long) i3) + next) <= this.iToYear) ? next : j;
        }
    }

    public static final class RuleSet {
        private static final int YEAR_LIMIT = ISOChronology.getInstanceUTC().year().get(DateTimeUtils.currentTimeMillis()) + 100;
        private String iInitialNameKey;
        private int iInitialSaveMillis;
        private ArrayList iRules;
        private int iStandardOffset;
        private OfYear iUpperOfYear;
        private int iUpperYear;

        public RuleSet() {
            this.iRules = new ArrayList(10);
            this.iUpperYear = Integer.MAX_VALUE;
        }

        public void addRule(Rule rule) {
            if (this.iRules.contains(rule)) {
                return;
            }
            this.iRules.add(rule);
        }

        public DSTZone buildTailZone(String str) {
            if (this.iRules.size() != 2) {
                return null;
            }
            Rule rule = (Rule) this.iRules.get(0);
            Rule rule2 = (Rule) this.iRules.get(1);
            if (rule.getToYear() == Integer.MAX_VALUE && rule2.getToYear() == Integer.MAX_VALUE) {
                return new DSTZone(str, this.iStandardOffset, rule.iRecurrence, rule2.iRecurrence);
            }
            return null;
        }

        public Transition firstTransition(long j) {
            String str = this.iInitialNameKey;
            if (str != null) {
                int i = this.iStandardOffset;
                return new Transition(j, str, i + this.iInitialSaveMillis, i);
            }
            ArrayList arrayList = new ArrayList(this.iRules);
            long j2 = Long.MIN_VALUE;
            int i2 = 0;
            Transition transition = null;
            while (true) {
                Transition nextTransition = nextTransition(j2, i2);
                if (nextTransition == null) {
                    break;
                }
                long millis = nextTransition.getMillis();
                if (millis == j) {
                    transition = new Transition(j, nextTransition);
                    break;
                }
                if (millis > j) {
                    if (transition == null) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Rule rule = (Rule) it.next();
                            if (rule.getSaveMillis() == 0) {
                                transition = new Transition(j, rule, this.iStandardOffset);
                                break;
                            }
                        }
                    }
                    if (transition == null) {
                        String nameKey = nextTransition.getNameKey();
                        int i3 = this.iStandardOffset;
                        transition = new Transition(j, nameKey, i3, i3);
                    }
                } else {
                    transition = new Transition(j, nextTransition);
                    i2 = nextTransition.getSaveMillis();
                    j2 = millis;
                }
            }
            this.iRules = arrayList;
            return transition;
        }

        public int getStandardOffset() {
            return this.iStandardOffset;
        }

        public long getUpperLimit(int i) {
            int i2 = this.iUpperYear;
            if (i2 == Integer.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            return this.iUpperOfYear.setInstant(i2, this.iStandardOffset, i);
        }

        public Transition nextTransition(long j, int i) {
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            Iterator it = this.iRules.iterator();
            long j2 = Long.MAX_VALUE;
            Rule rule = null;
            while (it.hasNext()) {
                Rule rule2 = (Rule) it.next();
                long next = rule2.next(j, this.iStandardOffset, i);
                if (next <= j) {
                    it.remove();
                } else if (next <= j2) {
                    rule = rule2;
                    j2 = next;
                }
            }
            if (rule == null || instanceUTC.year().get(j2) >= YEAR_LIMIT) {
                return null;
            }
            int i2 = this.iUpperYear;
            if (i2 >= Integer.MAX_VALUE || j2 < this.iUpperOfYear.setInstant(i2, this.iStandardOffset, i)) {
                return new Transition(j2, rule, this.iStandardOffset);
            }
            return null;
        }

        public void setFixedSavings(String str, int i) {
            this.iInitialNameKey = str;
            this.iInitialSaveMillis = i;
        }

        public void setStandardOffset(int i) {
            this.iStandardOffset = i;
        }

        public void setUpperLimit(int i, OfYear ofYear) {
            this.iUpperYear = i;
            this.iUpperOfYear = ofYear;
        }

        public RuleSet(RuleSet ruleSet) {
            this.iStandardOffset = ruleSet.iStandardOffset;
            this.iRules = new ArrayList(ruleSet.iRules);
            this.iInitialNameKey = ruleSet.iInitialNameKey;
            this.iInitialSaveMillis = ruleSet.iInitialSaveMillis;
            this.iUpperYear = ruleSet.iUpperYear;
            this.iUpperOfYear = ruleSet.iUpperOfYear;
        }
    }

    public static final class Transition {
        private final long iMillis;
        private final String iNameKey;
        private final int iStandardOffset;
        private final int iWallOffset;

        public Transition(long j, String str, int i, int i2) {
            this.iMillis = j;
            this.iNameKey = str;
            this.iWallOffset = i;
            this.iStandardOffset = i2;
        }

        public long getMillis() {
            return this.iMillis;
        }

        public String getNameKey() {
            return this.iNameKey;
        }

        public int getSaveMillis() {
            return this.iWallOffset - this.iStandardOffset;
        }

        public int getStandardOffset() {
            return this.iStandardOffset;
        }

        public int getWallOffset() {
            return this.iWallOffset;
        }

        public boolean isTransitionFrom(Transition transition) {
            if (transition == null) {
                return true;
            }
            return this.iMillis > transition.iMillis && !(this.iWallOffset == transition.iWallOffset && this.iNameKey.equals(transition.iNameKey));
        }

        public Transition(long j, Rule rule, int i) {
            this.iMillis = j;
            this.iNameKey = rule.getNameKey();
            this.iWallOffset = rule.getSaveMillis() + i;
            this.iStandardOffset = i;
        }

        public Transition(long j, Transition transition) {
            this.iMillis = j;
            this.iNameKey = transition.iNameKey;
            this.iWallOffset = transition.iWallOffset;
            this.iStandardOffset = transition.iStandardOffset;
        }
    }

    private boolean addTransition(ArrayList arrayList, Transition transition) {
        int size = arrayList.size();
        if (size == 0) {
            arrayList.add(transition);
            return true;
        }
        int i = size - 1;
        Transition transition2 = (Transition) arrayList.get(i);
        if (!transition.isTransitionFrom(transition2)) {
            return false;
        }
        if (transition.getMillis() + transition2.getWallOffset() != transition2.getMillis() + (size >= 2 ? ((Transition) arrayList.get(size - 2)).getWallOffset() : 0)) {
            arrayList.add(transition);
            return true;
        }
        arrayList.remove(i);
        return addTransition(arrayList, transition);
    }

    private static DateTimeZone buildFixedZone(String str, String str2, int i, int i2) {
        return ("UTC".equals(str) && str.equals(str2) && i == 0 && i2 == 0) ? DateTimeZone.UTC : new FixedDateTimeZone(str, str2, i, i2);
    }

    private RuleSet getLastRuleSet() {
        if (this.iRuleSets.size() == 0) {
            addCutover(Integer.MIN_VALUE, 'w', 1, 1, 0, false, 0);
        }
        return (RuleSet) this.iRuleSets.get(r0.size() - 1);
    }

    public static DateTimeZone readFrom(DataInput dataInput, String str) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 67) {
            return CachedDateTimeZone.forZone(PrecalculatedZone.readFrom(dataInput, str));
        }
        if (readUnsignedByte != 70) {
            if (readUnsignedByte == 80) {
                return PrecalculatedZone.readFrom(dataInput, str);
            }
            throw new IOException("Invalid encoding");
        }
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone(str, dataInput.readUTF(), (int) readMillis(dataInput), (int) readMillis(dataInput));
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        return fixedDateTimeZone.equals(dateTimeZone) ? dateTimeZone : fixedDateTimeZone;
    }

    public static long readMillis(DataInput dataInput) throws IOException {
        long readUnsignedByte;
        long j;
        int readUnsignedByte2 = dataInput.readUnsignedByte();
        int i = readUnsignedByte2 >> 6;
        if (i == 1) {
            readUnsignedByte = dataInput.readUnsignedByte() | ((readUnsignedByte2 << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8);
            j = 60000;
        } else if (i == 2) {
            readUnsignedByte = ((readUnsignedByte2 << 58) >> 26) | (dataInput.readUnsignedByte() << 24) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8) | dataInput.readUnsignedByte();
            j = 1000;
        } else {
            if (i == 3) {
                return dataInput.readLong();
            }
            readUnsignedByte = (readUnsignedByte2 << 26) >> 26;
            j = 1800000;
        }
        return readUnsignedByte * j;
    }

    public static void writeMillis(DataOutput dataOutput, long j) throws IOException {
        if (j % 1800000 == 0) {
            long j2 = j / 1800000;
            if (((j2 << 58) >> 58) == j2) {
                dataOutput.writeByte((int) (j2 & 63));
                return;
            }
        }
        if (j % 60000 == 0) {
            long j3 = j / 60000;
            if (((j3 << 34) >> 34) == j3) {
                dataOutput.writeInt(1073741824 | ((int) (1073741823 & j3)));
                return;
            }
        }
        if (j % 1000 == 0) {
            long j4 = j / 1000;
            if (((j4 << 26) >> 26) == j4) {
                dataOutput.writeByte(((int) ((j4 >> 32) & 63)) | 128);
                dataOutput.writeInt((int) j4);
                return;
            }
        }
        dataOutput.writeByte(j < 0 ? 255 : 192);
        dataOutput.writeLong(j);
    }

    public DateTimeZoneBuilder addCutover(int i, char c, int i2, int i3, int i4, boolean z, int i5) {
        if (this.iRuleSets.size() > 0) {
            ((RuleSet) this.iRuleSets.get(r10.size() - 1)).setUpperLimit(i, new OfYear(c, i2, i3, i4, z, i5));
        }
        this.iRuleSets.add(new RuleSet());
        return this;
    }

    public DateTimeZoneBuilder addRecurringSavings(String str, int i, int i2, int i3, char c, int i4, int i5, int i6, boolean z, int i7) {
        if (i2 <= i3) {
            getLastRuleSet().addRule(new Rule(new Recurrence(new OfYear(c, i4, i5, i6, z, i7), str, i), i2, i3));
        }
        return this;
    }

    public DateTimeZoneBuilder setFixedSavings(String str, int i) {
        getLastRuleSet().setFixedSavings(str, i);
        return this;
    }

    public DateTimeZoneBuilder setStandardOffset(int i) {
        getLastRuleSet().setStandardOffset(i);
        return this;
    }

    public DateTimeZone toDateTimeZone(String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.iRuleSets.size();
        DSTZone dSTZone = null;
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            RuleSet ruleSet = (RuleSet) this.iRuleSets.get(i);
            Transition firstTransition = ruleSet.firstTransition(j);
            if (firstTransition != null) {
                addTransition(arrayList, firstTransition);
                long millis = firstTransition.getMillis();
                int saveMillis = firstTransition.getSaveMillis();
                RuleSet ruleSet2 = new RuleSet(ruleSet);
                while (true) {
                    Transition nextTransition = ruleSet2.nextTransition(millis, saveMillis);
                    if (nextTransition == null || (addTransition(arrayList, nextTransition) && dSTZone != null)) {
                        break;
                    }
                    long millis2 = nextTransition.getMillis();
                    int saveMillis2 = nextTransition.getSaveMillis();
                    if (dSTZone == null && i == size - 1) {
                        dSTZone = ruleSet2.buildTailZone(str);
                    }
                    saveMillis = saveMillis2;
                    millis = millis2;
                }
                j = ruleSet2.getUpperLimit(saveMillis);
            }
        }
        if (arrayList.size() == 0) {
            return dSTZone != null ? dSTZone : buildFixedZone(str, "UTC", 0, 0);
        }
        if (arrayList.size() == 1 && dSTZone == null) {
            Transition transition = (Transition) arrayList.get(0);
            return buildFixedZone(str, transition.getNameKey(), transition.getWallOffset(), transition.getStandardOffset());
        }
        PrecalculatedZone create = PrecalculatedZone.create(str, z, arrayList, dSTZone);
        return create.isCachable() ? CachedDateTimeZone.forZone(create) : create;
    }

    public void writeTo(String str, DataOutput dataOutput) throws IOException {
        DateTimeZone dateTimeZone = toDateTimeZone(str, false);
        if (dateTimeZone instanceof FixedDateTimeZone) {
            dataOutput.writeByte(70);
            dataOutput.writeUTF(dateTimeZone.getNameKey(0L));
            writeMillis(dataOutput, dateTimeZone.getOffset(0L));
            writeMillis(dataOutput, dateTimeZone.getStandardOffset(0L));
            return;
        }
        if (dateTimeZone instanceof CachedDateTimeZone) {
            dataOutput.writeByte(67);
            dateTimeZone = ((CachedDateTimeZone) dateTimeZone).getUncachedZone();
        } else {
            dataOutput.writeByte(80);
        }
        ((PrecalculatedZone) dateTimeZone).writeTo(dataOutput);
    }

    public static DateTimeZone readFrom(InputStream inputStream, String str) throws IOException {
        return inputStream instanceof DataInput ? readFrom((DataInput) inputStream, str) : readFrom((DataInput) new DataInputStream(inputStream), str);
    }

    public void writeTo(String str, OutputStream outputStream) throws IOException {
        if (outputStream instanceof DataOutput) {
            writeTo(str, (DataOutput) outputStream);
        } else {
            writeTo(str, (DataOutput) new DataOutputStream(outputStream));
        }
    }
}
