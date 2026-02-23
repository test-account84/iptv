package org.joda.time;

import com.google.ads.interactivemedia.v3.internal.z1;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.chrono.ISOChronology;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DateTimeUtils {
    private static final SystemMillisProvider SYSTEM_MILLIS_PROVIDER;
    private static volatile MillisProvider cMillisProvider;
    private static final AtomicReference cZoneNames;

    public static class FixedMillisProvider implements MillisProvider {
        private final long iMillis;

        public FixedMillisProvider(long j) {
            this.iMillis = j;
        }

        public long getMillis() {
            return this.iMillis;
        }
    }

    public interface MillisProvider {
        long getMillis();
    }

    public static class OffsetMillisProvider implements MillisProvider {
        private final long iMillis;

        public OffsetMillisProvider(long j) {
            this.iMillis = j;
        }

        public long getMillis() {
            return System.currentTimeMillis() + this.iMillis;
        }
    }

    public static class SystemMillisProvider implements MillisProvider {
        public long getMillis() {
            return System.currentTimeMillis();
        }
    }

    static {
        SystemMillisProvider systemMillisProvider = new SystemMillisProvider();
        SYSTEM_MILLIS_PROVIDER = systemMillisProvider;
        cMillisProvider = systemMillisProvider;
        cZoneNames = new AtomicReference();
    }

    private static Map buildDefaultTimeZoneNames() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        linkedHashMap.put("UT", dateTimeZone);
        linkedHashMap.put("UTC", dateTimeZone);
        linkedHashMap.put("GMT", dateTimeZone);
        put(linkedHashMap, "EST", "America/New_York");
        put(linkedHashMap, "EDT", "America/New_York");
        put(linkedHashMap, "CST", "America/Chicago");
        put(linkedHashMap, "CDT", "America/Chicago");
        put(linkedHashMap, "MST", "America/Denver");
        put(linkedHashMap, "MDT", "America/Denver");
        put(linkedHashMap, "PST", "America/Los_Angeles");
        put(linkedHashMap, "PDT", "America/Los_Angeles");
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static void checkPermission() throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JodaTimePermission("CurrentTime.setProvider"));
        }
    }

    public static final long currentTimeMillis() {
        return cMillisProvider.getMillis();
    }

    public static final long fromJulianDay(double d) {
        return (long) ((d - 2440587.5d) * 8.64E7d);
    }

    public static final Chronology getChronology(Chronology chronology) {
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final DateFormatSymbols getDateFormatSymbols(Locale locale) {
        try {
            return (DateFormatSymbols) DateFormatSymbols.class.getMethod("getInstance", new Class[]{Locale.class}).invoke((Object) null, new Object[]{locale});
        } catch (Exception unused) {
            return new DateFormatSymbols(locale);
        }
    }

    public static final Map getDefaultTimeZoneNames() {
        AtomicReference atomicReference = cZoneNames;
        Map map = (Map) atomicReference.get();
        if (map != null) {
            return map;
        }
        Map buildDefaultTimeZoneNames = buildDefaultTimeZoneNames();
        return !z1.a(atomicReference, (Object) null, buildDefaultTimeZoneNames) ? (Map) atomicReference.get() : buildDefaultTimeZoneNames;
    }

    public static final long getDurationMillis(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            return 0L;
        }
        return readableDuration.getMillis();
    }

    public static final Chronology getInstantChronology(ReadableInstant readableInstant) {
        Chronology chronology;
        return (readableInstant == null || (chronology = readableInstant.getChronology()) == null) ? ISOChronology.getInstance() : chronology;
    }

    public static final long getInstantMillis(ReadableInstant readableInstant) {
        return readableInstant == null ? currentTimeMillis() : readableInstant.getMillis();
    }

    public static final Chronology getIntervalChronology(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        Chronology chronology = readableInstant != null ? readableInstant.getChronology() : readableInstant2 != null ? readableInstant2.getChronology() : null;
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    public static final PeriodType getPeriodType(PeriodType periodType) {
        return periodType == null ? PeriodType.standard() : periodType;
    }

    public static final ReadableInterval getReadableInterval(ReadableInterval readableInterval) {
        if (readableInterval != null) {
            return readableInterval;
        }
        long currentTimeMillis = currentTimeMillis();
        return new Interval(currentTimeMillis, currentTimeMillis);
    }

    public static final DateTimeZone getZone(DateTimeZone dateTimeZone) {
        return dateTimeZone == null ? DateTimeZone.getDefault() : dateTimeZone;
    }

    public static final boolean isContiguous(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("Partial must not be null");
        }
        DurationFieldType durationFieldType = null;
        for (int i = 0; i < readablePartial.size(); i++) {
            DateTimeField field = readablePartial.getField(i);
            if (i > 0 && (field.getRangeDurationField() == null || field.getRangeDurationField().getType() != durationFieldType)) {
                return false;
            }
            durationFieldType = field.getDurationField().getType();
        }
        return true;
    }

    private static void put(Map map, String str, String str2) {
        try {
            map.put(str, DateTimeZone.forID(str2));
        } catch (RuntimeException unused) {
        }
    }

    public static final void setCurrentMillisFixed(long j) throws SecurityException {
        checkPermission();
        cMillisProvider = new FixedMillisProvider(j);
    }

    public static final void setCurrentMillisOffset(long j) throws SecurityException {
        checkPermission();
        if (j == 0) {
            cMillisProvider = SYSTEM_MILLIS_PROVIDER;
        } else {
            cMillisProvider = new OffsetMillisProvider(j);
        }
    }

    public static final void setCurrentMillisProvider(MillisProvider millisProvider) throws SecurityException {
        if (millisProvider == null) {
            throw new IllegalArgumentException("The MillisProvider must not be null");
        }
        checkPermission();
        cMillisProvider = millisProvider;
    }

    public static final void setCurrentMillisSystem() throws SecurityException {
        checkPermission();
        cMillisProvider = SYSTEM_MILLIS_PROVIDER;
    }

    public static final void setDefaultTimeZoneNames(Map map) {
        cZoneNames.set(Collections.unmodifiableMap(new HashMap(map)));
    }

    public static final double toJulianDay(long j) {
        return (j / 8.64E7d) + 2440587.5d;
    }

    public static final long toJulianDayNumber(long j) {
        return (long) Math.floor(toJulianDay(j) + 0.5d);
    }

    public static final Chronology getIntervalChronology(ReadableInterval readableInterval) {
        Chronology chronology;
        return (readableInterval == null || (chronology = readableInterval.getChronology()) == null) ? ISOChronology.getInstance() : chronology;
    }
}
