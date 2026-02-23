package org.joda.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.format.ISODateTimeFormat;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class GJChronology extends AssembledChronology {
    static final Instant DEFAULT_CUTOVER = new Instant(-12219292800000L);
    private static final ConcurrentHashMap cCache = new ConcurrentHashMap();
    private static final long serialVersionUID = -2545574827706931671L;
    private Instant iCutoverInstant;
    private long iCutoverMillis;
    private long iGapDuration;
    private GregorianChronology iGregorianChronology;
    private JulianChronology iJulianChronology;

    public class CutoverField extends BaseDateTimeField {
        private static final long serialVersionUID = 3528501219481026402L;
        final boolean iConvertByWeekyear;
        final long iCutover;
        protected DurationField iDurationField;
        final DateTimeField iGregorianField;
        final DateTimeField iJulianField;
        protected DurationField iRangeDurationField;

        public CutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j) {
            this(gJChronology, dateTimeField, dateTimeField2, j, false);
        }

        public long add(long j, int i) {
            return this.iGregorianField.add(j, i);
        }

        public int get(long j) {
            return (j >= this.iCutover ? this.iGregorianField : this.iJulianField).get(j);
        }

        public String getAsShortText(int i, Locale locale) {
            return this.iGregorianField.getAsShortText(i, locale);
        }

        public String getAsText(int i, Locale locale) {
            return this.iGregorianField.getAsText(i, locale);
        }

        public int getDifference(long j, long j2) {
            return this.iGregorianField.getDifference(j, j2);
        }

        public long getDifferenceAsLong(long j, long j2) {
            return this.iGregorianField.getDifferenceAsLong(j, j2);
        }

        public DurationField getDurationField() {
            return this.iDurationField;
        }

        public int getLeapAmount(long j) {
            return (j >= this.iCutover ? this.iGregorianField : this.iJulianField).getLeapAmount(j);
        }

        public DurationField getLeapDurationField() {
            return this.iGregorianField.getLeapDurationField();
        }

        public int getMaximumShortTextLength(Locale locale) {
            return Math.max(this.iJulianField.getMaximumShortTextLength(locale), this.iGregorianField.getMaximumShortTextLength(locale));
        }

        public int getMaximumTextLength(Locale locale) {
            return Math.max(this.iJulianField.getMaximumTextLength(locale), this.iGregorianField.getMaximumTextLength(locale));
        }

        public int getMaximumValue() {
            return this.iGregorianField.getMaximumValue();
        }

        public int getMinimumValue() {
            return this.iJulianField.getMinimumValue();
        }

        public DurationField getRangeDurationField() {
            return this.iRangeDurationField;
        }

        public long gregorianToJulian(long j) {
            return this.iConvertByWeekyear ? GJChronology.this.gregorianToJulianByWeekyear(j) : GJChronology.this.gregorianToJulianByYear(j);
        }

        public boolean isLeap(long j) {
            return (j >= this.iCutover ? this.iGregorianField : this.iJulianField).isLeap(j);
        }

        public boolean isLenient() {
            return false;
        }

        public long julianToGregorian(long j) {
            return this.iConvertByWeekyear ? GJChronology.this.julianToGregorianByWeekyear(j) : GJChronology.this.julianToGregorianByYear(j);
        }

        public long roundCeiling(long j) {
            if (j >= this.iCutover) {
                return this.iGregorianField.roundCeiling(j);
            }
            long roundCeiling = this.iJulianField.roundCeiling(j);
            return (roundCeiling < this.iCutover || roundCeiling - GJChronology.access$000(GJChronology.this) < this.iCutover) ? roundCeiling : julianToGregorian(roundCeiling);
        }

        public long roundFloor(long j) {
            if (j < this.iCutover) {
                return this.iJulianField.roundFloor(j);
            }
            long roundFloor = this.iGregorianField.roundFloor(j);
            return (roundFloor >= this.iCutover || GJChronology.access$000(GJChronology.this) + roundFloor >= this.iCutover) ? roundFloor : gregorianToJulian(roundFloor);
        }

        public long set(long j, int i) {
            long j2;
            if (j >= this.iCutover) {
                j2 = this.iGregorianField.set(j, i);
                if (j2 < this.iCutover) {
                    if (GJChronology.access$000(GJChronology.this) + j2 < this.iCutover) {
                        j2 = gregorianToJulian(j2);
                    }
                    if (get(j2) != i) {
                        throw new IllegalFieldValueException(this.iGregorianField.getType(), (Number) Integer.valueOf(i), (Number) null, (Number) null);
                    }
                }
            } else {
                j2 = this.iJulianField.set(j, i);
                if (j2 >= this.iCutover) {
                    if (j2 - GJChronology.access$000(GJChronology.this) >= this.iCutover) {
                        j2 = julianToGregorian(j2);
                    }
                    if (get(j2) != i) {
                        throw new IllegalFieldValueException(this.iJulianField.getType(), (Number) Integer.valueOf(i), (Number) null, (Number) null);
                    }
                }
            }
            return j2;
        }

        public CutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j, boolean z) {
            this(dateTimeField, dateTimeField2, null, j, z);
        }

        public long add(long j, long j2) {
            return this.iGregorianField.add(j, j2);
        }

        public String getAsShortText(long j, Locale locale) {
            return (j >= this.iCutover ? this.iGregorianField : this.iJulianField).getAsShortText(j, locale);
        }

        public String getAsText(long j, Locale locale) {
            return (j >= this.iCutover ? this.iGregorianField : this.iJulianField).getAsText(j, locale);
        }

        public int getMaximumValue(long j) {
            if (j >= this.iCutover) {
                return this.iGregorianField.getMaximumValue(j);
            }
            int maximumValue = this.iJulianField.getMaximumValue(j);
            long j2 = this.iJulianField.set(j, maximumValue);
            long j3 = this.iCutover;
            if (j2 < j3) {
                return maximumValue;
            }
            DateTimeField dateTimeField = this.iJulianField;
            return dateTimeField.get(dateTimeField.add(j3, -1));
        }

        public int getMinimumValue(long j) {
            if (j < this.iCutover) {
                return this.iJulianField.getMinimumValue(j);
            }
            int minimumValue = this.iGregorianField.getMinimumValue(j);
            long j2 = this.iGregorianField.set(j, minimumValue);
            long j3 = this.iCutover;
            return j2 < j3 ? this.iGregorianField.get(j3) : minimumValue;
        }

        public long set(long j, String str, Locale locale) {
            if (j >= this.iCutover) {
                long j2 = this.iGregorianField.set(j, str, locale);
                return (j2 >= this.iCutover || GJChronology.access$000(GJChronology.this) + j2 >= this.iCutover) ? j2 : gregorianToJulian(j2);
            }
            long j3 = this.iJulianField.set(j, str, locale);
            return (j3 < this.iCutover || j3 - GJChronology.access$000(GJChronology.this) < this.iCutover) ? j3 : julianToGregorian(j3);
        }

        public CutoverField(DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j, boolean z) {
            super(dateTimeField2.getType());
            this.iJulianField = dateTimeField;
            this.iGregorianField = dateTimeField2;
            this.iCutover = j;
            this.iConvertByWeekyear = z;
            this.iDurationField = dateTimeField2.getDurationField();
            if (durationField == null && (durationField = dateTimeField2.getRangeDurationField()) == null) {
                durationField = dateTimeField.getRangeDurationField();
            }
            this.iRangeDurationField = durationField;
        }

        public int[] add(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
            if (i2 == 0) {
                return iArr;
            }
            if (!DateTimeUtils.isContiguous(readablePartial)) {
                return super.add(readablePartial, i, iArr, i2);
            }
            int size = readablePartial.size();
            long j = 0;
            for (int i3 = 0; i3 < size; i3++) {
                j = readablePartial.getFieldType(i3).getField(GJChronology.this).set(j, iArr[i3]);
            }
            return GJChronology.this.get(readablePartial, add(j, i2));
        }

        public int getMaximumValue(ReadablePartial readablePartial) {
            return getMaximumValue(GJChronology.getInstanceUTC().set(readablePartial, 0L));
        }

        public int getMinimumValue(ReadablePartial readablePartial) {
            return this.iJulianField.getMinimumValue(readablePartial);
        }

        public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
            GJChronology instanceUTC = GJChronology.getInstanceUTC();
            int size = readablePartial.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                DateTimeField field = readablePartial.getFieldType(i).getField(instanceUTC);
                if (iArr[i] <= field.getMaximumValue(j)) {
                    j = field.set(j, iArr[i]);
                }
            }
            return getMaximumValue(j);
        }

        public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
            return this.iJulianField.getMinimumValue(readablePartial, iArr);
        }
    }

    public final class ImpreciseCutoverField extends CutoverField {
        private static final long serialVersionUID = 3410248757173576441L;

        public ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j) {
            this(dateTimeField, dateTimeField2, (DurationField) null, j, false);
        }

        public long add(long j, int i) {
            DateTimeField year;
            if (j < this.iCutover) {
                long add = this.iJulianField.add(j, i);
                return (add < this.iCutover || add - GJChronology.access$000(GJChronology.this) < this.iCutover) ? add : julianToGregorian(add);
            }
            long add2 = this.iGregorianField.add(j, i);
            if (add2 >= this.iCutover || GJChronology.access$000(GJChronology.this) + add2 >= this.iCutover) {
                return add2;
            }
            if (this.iConvertByWeekyear) {
                if (GJChronology.access$100(GJChronology.this).weekyear().get(add2) <= 0) {
                    year = GJChronology.access$100(GJChronology.this).weekyear();
                    add2 = year.add(add2, -1);
                }
            } else if (GJChronology.access$100(GJChronology.this).year().get(add2) <= 0) {
                year = GJChronology.access$100(GJChronology.this).year();
                add2 = year.add(add2, -1);
            }
            return gregorianToJulian(add2);
        }

        public int getDifference(long j, long j2) {
            DateTimeField dateTimeField;
            long j3 = this.iCutover;
            if (j >= j3) {
                if (j2 < j3) {
                    j = gregorianToJulian(j);
                    dateTimeField = this.iJulianField;
                }
                dateTimeField = this.iGregorianField;
            } else {
                if (j2 >= j3) {
                    j = julianToGregorian(j);
                    dateTimeField = this.iGregorianField;
                }
                dateTimeField = this.iJulianField;
            }
            return dateTimeField.getDifference(j, j2);
        }

        public long getDifferenceAsLong(long j, long j2) {
            DateTimeField dateTimeField;
            long j3 = this.iCutover;
            if (j >= j3) {
                if (j2 < j3) {
                    j = gregorianToJulian(j);
                    dateTimeField = this.iJulianField;
                }
                dateTimeField = this.iGregorianField;
            } else {
                if (j2 >= j3) {
                    j = julianToGregorian(j);
                    dateTimeField = this.iGregorianField;
                }
                dateTimeField = this.iJulianField;
            }
            return dateTimeField.getDifferenceAsLong(j, j2);
        }

        public int getMaximumValue(long j) {
            return (j >= this.iCutover ? this.iGregorianField : this.iJulianField).getMaximumValue(j);
        }

        public int getMinimumValue(long j) {
            return (j >= this.iCutover ? this.iGregorianField : this.iJulianField).getMinimumValue(j);
        }

        public ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j) {
            this(dateTimeField, dateTimeField2, durationField, j, false);
        }

        public long add(long j, long j2) {
            DateTimeField year;
            if (j < this.iCutover) {
                long add = this.iJulianField.add(j, j2);
                return (add < this.iCutover || add - GJChronology.access$000(GJChronology.this) < this.iCutover) ? add : julianToGregorian(add);
            }
            long add2 = this.iGregorianField.add(j, j2);
            if (add2 >= this.iCutover || GJChronology.access$000(GJChronology.this) + add2 >= this.iCutover) {
                return add2;
            }
            if (this.iConvertByWeekyear) {
                if (GJChronology.access$100(GJChronology.this).weekyear().get(add2) <= 0) {
                    year = GJChronology.access$100(GJChronology.this).weekyear();
                    add2 = year.add(add2, -1);
                }
            } else if (GJChronology.access$100(GJChronology.this).year().get(add2) <= 0) {
                year = GJChronology.access$100(GJChronology.this).year();
                add2 = year.add(add2, -1);
            }
            return gregorianToJulian(add2);
        }

        public ImpreciseCutoverField(DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j, boolean z) {
            super(GJChronology.this, dateTimeField, dateTimeField2, j, z);
            this.iDurationField = durationField == null ? new LinkedDurationField(this.iDurationField, this) : durationField;
        }

        public ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, DurationField durationField2, long j) {
            this(dateTimeField, dateTimeField2, durationField, j, false);
            this.iRangeDurationField = durationField2;
        }
    }

    public static class LinkedDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 4097975388007713084L;
        private final ImpreciseCutoverField iField;

        public LinkedDurationField(DurationField durationField, ImpreciseCutoverField impreciseCutoverField) {
            super(durationField, durationField.getType());
            this.iField = impreciseCutoverField;
        }

        public long add(long j, int i) {
            return this.iField.add(j, i);
        }

        public int getDifference(long j, long j2) {
            return this.iField.getDifference(j, j2);
        }

        public long getDifferenceAsLong(long j, long j2) {
            return this.iField.getDifferenceAsLong(j, j2);
        }

        public long add(long j, long j2) {
            return this.iField.add(j, j2);
        }
    }

    private GJChronology(Chronology chronology, JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super(chronology, new Object[]{julianChronology, gregorianChronology, instant});
    }

    public static /* synthetic */ long access$000(GJChronology gJChronology) {
        return gJChronology.iGapDuration;
    }

    public static /* synthetic */ GregorianChronology access$100(GJChronology gJChronology) {
        return gJChronology.iGregorianChronology;
    }

    private static long convertByWeekyear(long j, Chronology chronology, Chronology chronology2) {
        return chronology2.millisOfDay().set(chronology2.dayOfWeek().set(chronology2.weekOfWeekyear().set(chronology2.weekyear().set(0L, chronology.weekyear().get(j)), chronology.weekOfWeekyear().get(j)), chronology.dayOfWeek().get(j)), chronology.millisOfDay().get(j));
    }

    private static long convertByYear(long j, Chronology chronology, Chronology chronology2) {
        return chronology2.getDateTimeMillis(chronology.year().get(j), chronology.monthOfYear().get(j), chronology.dayOfMonth().get(j), chronology.millisOfDay().get(j));
    }

    public static GJChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstanceUTC() {
        return getInstance(DateTimeZone.UTC, DEFAULT_CUTOVER, 4);
    }

    private Object readResolve() {
        return getInstance(getZone(), this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    public void assemble(AssembledChronology.Fields fields) {
        Object[] objArr = (Object[]) getParam();
        JulianChronology julianChronology = (JulianChronology) objArr[0];
        GregorianChronology gregorianChronology = (GregorianChronology) objArr[1];
        Instant instant = (Instant) objArr[2];
        this.iCutoverMillis = instant.getMillis();
        this.iJulianChronology = julianChronology;
        this.iGregorianChronology = gregorianChronology;
        this.iCutoverInstant = instant;
        if (getBase() != null) {
            return;
        }
        if (julianChronology.getMinimumDaysInFirstWeek() != gregorianChronology.getMinimumDaysInFirstWeek()) {
            throw new IllegalArgumentException();
        }
        long j = this.iCutoverMillis;
        this.iGapDuration = j - julianToGregorianByYear(j);
        fields.copyFieldsFrom(gregorianChronology);
        if (gregorianChronology.millisOfDay().get(this.iCutoverMillis) == 0) {
            fields.millisOfSecond = new CutoverField(this, julianChronology.millisOfSecond(), fields.millisOfSecond, this.iCutoverMillis);
            fields.millisOfDay = new CutoverField(this, julianChronology.millisOfDay(), fields.millisOfDay, this.iCutoverMillis);
            fields.secondOfMinute = new CutoverField(this, julianChronology.secondOfMinute(), fields.secondOfMinute, this.iCutoverMillis);
            fields.secondOfDay = new CutoverField(this, julianChronology.secondOfDay(), fields.secondOfDay, this.iCutoverMillis);
            fields.minuteOfHour = new CutoverField(this, julianChronology.minuteOfHour(), fields.minuteOfHour, this.iCutoverMillis);
            fields.minuteOfDay = new CutoverField(this, julianChronology.minuteOfDay(), fields.minuteOfDay, this.iCutoverMillis);
            fields.hourOfDay = new CutoverField(this, julianChronology.hourOfDay(), fields.hourOfDay, this.iCutoverMillis);
            fields.hourOfHalfday = new CutoverField(this, julianChronology.hourOfHalfday(), fields.hourOfHalfday, this.iCutoverMillis);
            fields.clockhourOfDay = new CutoverField(this, julianChronology.clockhourOfDay(), fields.clockhourOfDay, this.iCutoverMillis);
            fields.clockhourOfHalfday = new CutoverField(this, julianChronology.clockhourOfHalfday(), fields.clockhourOfHalfday, this.iCutoverMillis);
            fields.halfdayOfDay = new CutoverField(this, julianChronology.halfdayOfDay(), fields.halfdayOfDay, this.iCutoverMillis);
        }
        fields.era = new CutoverField(this, julianChronology.era(), fields.era, this.iCutoverMillis);
        ImpreciseCutoverField impreciseCutoverField = new ImpreciseCutoverField(this, julianChronology.year(), fields.year, this.iCutoverMillis);
        fields.year = impreciseCutoverField;
        fields.years = impreciseCutoverField.getDurationField();
        fields.yearOfEra = new ImpreciseCutoverField(this, julianChronology.yearOfEra(), fields.yearOfEra, fields.years, this.iCutoverMillis);
        ImpreciseCutoverField impreciseCutoverField2 = new ImpreciseCutoverField(this, julianChronology.centuryOfEra(), fields.centuryOfEra, this.iCutoverMillis);
        fields.centuryOfEra = impreciseCutoverField2;
        fields.centuries = impreciseCutoverField2.getDurationField();
        fields.yearOfCentury = new ImpreciseCutoverField(this, julianChronology.yearOfCentury(), fields.yearOfCentury, fields.years, fields.centuries, this.iCutoverMillis);
        ImpreciseCutoverField impreciseCutoverField3 = new ImpreciseCutoverField(this, julianChronology.monthOfYear(), fields.monthOfYear, (DurationField) null, fields.years, this.iCutoverMillis);
        fields.monthOfYear = impreciseCutoverField3;
        fields.months = impreciseCutoverField3.getDurationField();
        ImpreciseCutoverField impreciseCutoverField4 = new ImpreciseCutoverField(julianChronology.weekyear(), fields.weekyear, (DurationField) null, this.iCutoverMillis, true);
        fields.weekyear = impreciseCutoverField4;
        fields.weekyears = impreciseCutoverField4.getDurationField();
        fields.weekyearOfCentury = new ImpreciseCutoverField(this, julianChronology.weekyearOfCentury(), fields.weekyearOfCentury, fields.weekyears, fields.centuries, this.iCutoverMillis);
        fields.dayOfYear = new CutoverField(julianChronology.dayOfYear(), fields.dayOfYear, fields.years, gregorianChronology.year().roundCeiling(this.iCutoverMillis), false);
        fields.weekOfWeekyear = new CutoverField(julianChronology.weekOfWeekyear(), fields.weekOfWeekyear, fields.weekyears, gregorianChronology.weekyear().roundCeiling(this.iCutoverMillis), true);
        CutoverField cutoverField = new CutoverField(this, julianChronology.dayOfMonth(), fields.dayOfMonth, this.iCutoverMillis);
        cutoverField.iRangeDurationField = fields.months;
        fields.dayOfMonth = cutoverField;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GJChronology)) {
            return false;
        }
        GJChronology gJChronology = (GJChronology) obj;
        return this.iCutoverMillis == gJChronology.iCutoverMillis && getMinimumDaysInFirstWeek() == gJChronology.getMinimumDaysInFirstWeek() && getZone().equals(gJChronology.getZone());
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i, i2, i3, i4);
        }
        long dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i, i2, i3, i4);
        if (dateTimeMillis < this.iCutoverMillis) {
            dateTimeMillis = this.iJulianChronology.getDateTimeMillis(i, i2, i3, i4);
            if (dateTimeMillis >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return dateTimeMillis;
    }

    public Instant getGregorianCutover() {
        return this.iCutoverInstant;
    }

    public int getMinimumDaysInFirstWeek() {
        return this.iGregorianChronology.getMinimumDaysInFirstWeek();
    }

    public DateTimeZone getZone() {
        Chronology base = getBase();
        return base != null ? base.getZone() : DateTimeZone.UTC;
    }

    public long gregorianToJulianByWeekyear(long j) {
        return convertByWeekyear(j, this.iGregorianChronology, this.iJulianChronology);
    }

    public long gregorianToJulianByYear(long j) {
        return convertByYear(j, this.iGregorianChronology, this.iJulianChronology);
    }

    public int hashCode() {
        return 25025 + getZone().hashCode() + getMinimumDaysInFirstWeek() + this.iCutoverInstant.hashCode();
    }

    public long julianToGregorianByWeekyear(long j) {
        return convertByWeekyear(j, this.iJulianChronology, this.iGregorianChronology);
    }

    public long julianToGregorianByYear(long j) {
        return convertByYear(j, this.iJulianChronology, this.iGregorianChronology);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("GJChronology");
        stringBuffer.append('[');
        stringBuffer.append(getZone().getID());
        if (this.iCutoverMillis != DEFAULT_CUTOVER.getMillis()) {
            stringBuffer.append(",cutover=");
            (withUTC().dayOfYear().remainder(this.iCutoverMillis) == 0 ? ISODateTimeFormat.date() : ISODateTimeFormat.dateTime()).withChronology(withUTC()).printTo(stringBuffer, this.iCutoverMillis);
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            stringBuffer.append(",mdfw=");
            stringBuffer.append(getMinimumDaysInFirstWeek());
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public Chronology withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone, this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    private GJChronology(JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super(null, new Object[]{julianChronology, gregorianChronology, instant});
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, DEFAULT_CUTOVER, 4);
    }

    public long getDateTimeMillis(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        long dateTimeMillis;
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i, i2, i3, i4, i5, i6, i7);
        }
        try {
            dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i, i2, i3, i4, i5, i6, i7);
        } catch (IllegalFieldValueException e) {
            if (i2 != 2 || i3 != 29) {
                throw e;
            }
            dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i, i2, 28, i4, i5, i6, i7);
            if (dateTimeMillis >= this.iCutoverMillis) {
                throw e;
            }
        }
        if (dateTimeMillis < this.iCutoverMillis) {
            dateTimeMillis = this.iJulianChronology.getDateTimeMillis(i, i2, i3, i4, i5, i6, i7);
            if (dateTimeMillis >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return dateTimeMillis;
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, long j, int i) {
        return getInstance(dateTimeZone, j == DEFAULT_CUTOVER.getMillis() ? null : new Instant(j), i);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, ReadableInstant readableInstant) {
        return getInstance(dateTimeZone, readableInstant, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, ReadableInstant readableInstant, int i) {
        Instant instant;
        GJChronology gJChronology;
        DateTimeZone zone = DateTimeUtils.getZone(dateTimeZone);
        if (readableInstant == null) {
            instant = DEFAULT_CUTOVER;
        } else {
            instant = readableInstant.toInstant();
            if (new LocalDate(instant.getMillis(), GregorianChronology.getInstance(zone)).getYear() <= 0) {
                throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
            }
        }
        GJCacheKey gJCacheKey = new GJCacheKey(zone, instant, i);
        ConcurrentHashMap concurrentHashMap = cCache;
        GJChronology gJChronology2 = (GJChronology) concurrentHashMap.get(gJCacheKey);
        if (gJChronology2 != null) {
            return gJChronology2;
        }
        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
        if (zone == dateTimeZone2) {
            gJChronology = new GJChronology(JulianChronology.getInstance(zone, i), GregorianChronology.getInstance(zone, i), instant);
        } else {
            GJChronology gJChronology3 = getInstance(dateTimeZone2, instant, i);
            gJChronology = new GJChronology(ZonedChronology.getInstance(gJChronology3, zone), gJChronology3.iJulianChronology, gJChronology3.iGregorianChronology, gJChronology3.iCutoverInstant);
        }
        GJChronology gJChronology4 = (GJChronology) concurrentHashMap.putIfAbsent(gJCacheKey, gJChronology);
        return gJChronology4 != null ? gJChronology4 : gJChronology;
    }
}
