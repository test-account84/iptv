package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Date;
import java.sql.Timestamp;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SqlTypesSupport {
    public static final DefaultDateTypeAdapter.DateType DATE_DATE_TYPE;
    public static final TypeAdapterFactory DATE_FACTORY;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final DefaultDateTypeAdapter.DateType TIMESTAMP_DATE_TYPE;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapterFactory TIME_FACTORY;

    public class 1 extends DefaultDateTypeAdapter.DateType {
        public 1(Class cls) {
            super(cls);
        }

        public Date deserialize(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    public class 2 extends DefaultDateTypeAdapter.DateType {
        public 2(Class cls) {
            super(cls);
        }

        public Timestamp deserialize(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        TypeAdapterFactory typeAdapterFactory;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        SUPPORTS_SQL_TYPES = z;
        if (z) {
            DATE_DATE_TYPE = new 1(Date.class);
            TIMESTAMP_DATE_TYPE = new 2(Timestamp.class);
            DATE_FACTORY = SqlDateTypeAdapter.FACTORY;
            TIME_FACTORY = SqlTimeTypeAdapter.FACTORY;
            typeAdapterFactory = SqlTimestampTypeAdapter.FACTORY;
        } else {
            typeAdapterFactory = null;
            DATE_DATE_TYPE = null;
            TIMESTAMP_DATE_TYPE = null;
            DATE_FACTORY = null;
            TIME_FACTORY = null;
        }
        TIMESTAMP_FACTORY = typeAdapterFactory;
    }

    private SqlTypesSupport() {
    }
}
