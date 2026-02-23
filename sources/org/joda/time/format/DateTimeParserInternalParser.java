package org.joda.time.format;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class DateTimeParserInternalParser implements InternalParser {
    private final DateTimeParser underlying;

    private DateTimeParserInternalParser(DateTimeParser dateTimeParser) {
        this.underlying = dateTimeParser;
    }

    public static InternalParser of(DateTimeParser dateTimeParser) {
        if (dateTimeParser instanceof InternalParserDateTimeParser) {
            return (InternalParser) dateTimeParser;
        }
        if (dateTimeParser == null) {
            return null;
        }
        return new DateTimeParserInternalParser(dateTimeParser);
    }

    public int estimateParsedLength() {
        return this.underlying.estimateParsedLength();
    }

    public DateTimeParser getUnderlying() {
        return this.underlying;
    }

    public int parseInto(DateTimeParserBucket dateTimeParserBucket, CharSequence charSequence, int i) {
        return this.underlying.parseInto(dateTimeParserBucket, charSequence.toString(), i);
    }
}
