package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DefaultDateTypeAdapter extends TypeAdapter {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List dateFormats;
    private final DateType dateType;

    public static abstract class DateType {
        public static final DateType DATE = new 1(Date.class);
        private final Class dateClass;

        public class 1 extends DateType {
            public 1(Class cls) {
                super(cls);
            }

            public Date deserialize(Date date) {
                return date;
            }
        }

        public DateType(Class cls) {
            this.dateClass = cls;
        }

        private final TypeAdapterFactory createFactory(DefaultDateTypeAdapter defaultDateTypeAdapter) {
            return TypeAdapters.newFactory(this.dateClass, defaultDateTypeAdapter);
        }

        public final TypeAdapterFactory createAdapterFactory(int i) {
            return createFactory(new DefaultDateTypeAdapter(this, i, (1) null));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            return createFactory(new DefaultDateTypeAdapter(this, 2, 2, null));
        }

        public abstract Date deserialize(Date date);

        public final TypeAdapterFactory createAdapterFactory(int i, int i2) {
            return createFactory(new DefaultDateTypeAdapter(this, i, i2, null));
        }

        public final TypeAdapterFactory createAdapterFactory(String str) {
            return createFactory(new DefaultDateTypeAdapter(this, str, (1) null));
        }
    }

    private DefaultDateTypeAdapter(DateType dateType, int i) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) $Gson$Preconditions.checkNotNull(dateType);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateFormat(i));
        }
    }

    private Date deserializeToDate(String str) {
        synchronized (this.dateFormats) {
            try {
                Iterator it = this.dateFormats.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(str);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return ISO8601Utils.parse(str, new ParsePosition(0));
                } catch (ParseException e) {
                    throw new JsonSyntaxException(str, e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        StringBuilder sb;
        String simpleName;
        SimpleDateFormat simpleDateFormat = (DateFormat) this.dateFormats.get(0);
        if (simpleDateFormat instanceof SimpleDateFormat) {
            sb = new StringBuilder();
            sb.append("DefaultDateTypeAdapter(");
            simpleName = simpleDateFormat.toPattern();
        } else {
            sb = new StringBuilder();
            sb.append("DefaultDateTypeAdapter(");
            simpleName = simpleDateFormat.getClass().getSimpleName();
        }
        sb.append(simpleName);
        sb.append(')');
        return sb.toString();
    }

    private DefaultDateTypeAdapter(DateType dateType, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) $Gson$Preconditions.checkNotNull(dateType);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.isJava9OrLater()) {
            arrayList.add(PreJava9DateFormatProvider.getUSDateTimeFormat(i, i2));
        }
    }

    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.dateType.deserialize(deserializeToDate(jsonReader.nextString()));
    }

    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            jsonWriter.value(((DateFormat) this.dateFormats.get(0)).format(date));
        }
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType dateType, int i, int i2, 1 r4) {
        this(dateType, i, i2);
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType dateType, int i, 1 r3) {
        this(dateType, i);
    }

    private DefaultDateTypeAdapter(DateType dateType, String str) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (DateType) $Gson$Preconditions.checkNotNull(dateType);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType dateType, String str, 1 r3) {
        this(dateType, str);
    }
}
