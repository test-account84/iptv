package com.google.android.recaptcha.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import l8.j;
import l8.k;
import l8.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzad extends SQLiteOpenHelper {

    @NotNull
    public static final zzab zza = new zzab(null);

    @Nullable
    private static zzad zzb;

    public /* synthetic */ zzad(Context context, g gVar) {
        super(context, "cesdb", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static final /* synthetic */ zzad zzc() {
        return zzb;
    }

    public static final /* synthetic */ void zze(zzad zzadVar) {
        zzb = zzadVar;
    }

    public final void onCreate(@NotNull SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    public final void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    public final int zza(@NotNull List list) {
        if (list.isEmpty()) {
            return 0;
        }
        return getWritableDatabase().delete("ce", "id IN ".concat(String.valueOf(s.A(list, ", ", "(", ")", 0, (CharSequence) null, zzac.zza, 24, (Object) null))), (String[]) null);
    }

    public final int zzb() {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM ce", (String[]) null);
        try {
            if (rawQuery.moveToNext()) {
                return rawQuery.getInt(0);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        } finally {
            rawQuery.close();
        }
    }

    @NotNull
    public final List zzd() {
        Cursor query = getReadableDatabase().query("ce", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "ts ASC");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzae(query.getString(query.getColumnIndexOrThrow("ss")), query.getLong(query.getColumnIndexOrThrow("ts")), query.getInt(query.getColumnIndexOrThrow("id"))));
            } catch (Exception unused) {
                return k.f();
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public final boolean zzf(@NotNull zzae zzaeVar) {
        return zza(j.b(zzaeVar)) == 1;
    }
}
