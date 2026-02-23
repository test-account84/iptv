package M4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends E4 {
    public static final String[] f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;"};
    public static final String[] i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public final k d;
    public final A4 e;

    public l(S4 s4) {
        super(s4);
        this.e = new A4(this.a.a());
        this.a.z();
        this.d = new k(this, this.a.c(), "google_app_measurement.db");
    }

    public static /* bridge */ /* synthetic */ String[] A() {
        return f;
    }

    public static /* bridge */ /* synthetic */ String[] B() {
        return k;
    }

    public static /* bridge */ /* synthetic */ String[] C() {
        return l;
    }

    public static /* bridge */ /* synthetic */ String[] D() {
        return j;
    }

    public static /* bridge */ /* synthetic */ String[] E() {
        return i;
    }

    public static /* bridge */ /* synthetic */ String[] F() {
        return g;
    }

    public static final void H(ContentValues contentValues, String str, Object obj) {
        com.google.android.gms.common.internal.r.g("value");
        com.google.android.gms.common.internal.r.m(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    public static /* bridge */ /* synthetic */ A4 W(l lVar) {
        return lVar.e;
    }

    public static /* bridge */ /* synthetic */ String[] y() {
        return m;
    }

    public static /* bridge */ /* synthetic */ String[] z() {
        return h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0079: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:101:0x0079 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void G(String str, long j2, long j3, P4 p4) {
        Cursor cursor;
        String str2;
        SQLiteDatabase P;
        String rawQuery;
        String string;
        String str3;
        String query;
        String str4;
        String[] strArr;
        com.google.android.gms.common.internal.r.m(p4);
        h();
        i();
        String str5 = null;
        try {
            try {
                P = P();
                cursor = TextUtils.isEmpty((CharSequence) null);
                try {
                    if (cursor != 0) {
                        rawQuery = P.rawQuery("select app_id, metadata_fingerprint from raw_events where " + (j3 != -1 ? "rowid <= ? and " : "") + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", j3 != -1 ? new String[]{String.valueOf(j3), String.valueOf(j2)} : new String[]{String.valueOf(j2)});
                        if (!rawQuery.moveToFirst()) {
                            rawQuery.close();
                            return;
                        } else {
                            str5 = rawQuery.getString(0);
                            string = rawQuery.getString(1);
                            rawQuery.close();
                        }
                    } else {
                        rawQuery = P.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + (j3 != -1 ? " and rowid <= ?" : "") + " order by rowid limit 1;", j3 != -1 ? new String[]{null, String.valueOf(j3)} : new String[]{null});
                        if (!rawQuery.moveToFirst()) {
                            rawQuery.close();
                            return;
                        } else {
                            string = rawQuery.getString(0);
                            rawQuery.close();
                        }
                    }
                    String str6 = rawQuery;
                    str3 = string;
                    try {
                        query = P.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str5, str3}, (String) null, (String) null, "rowid", "2");
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = str6;
                    } catch (Throwable th) {
                        th = th;
                        str5 = str6;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
                str5 = str2;
            }
            try {
                if (!query.moveToFirst()) {
                    this.a.d().r().b("Raw event metadata record is missing. appId", z1.z(str5));
                    query.close();
                    return;
                }
                try {
                    zzgd zzgdVar = (zzgd) ((zzgc) U4.E(zzgd.zzu(), query.getBlob(0))).zzaD();
                    if (query.moveToNext()) {
                        this.a.d().w().b("Get multiple raw event metadata records, expected one. appId", z1.z(str5));
                    }
                    query.close();
                    com.google.android.gms.common.internal.r.m(zzgdVar);
                    p4.a = zzgdVar;
                    if (j3 != -1) {
                        str4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                        strArr = new String[]{str5, str3, String.valueOf(j3)};
                    } else {
                        str4 = "app_id = ? and metadata_fingerprint = ?";
                        strArr = new String[]{str5, str3};
                    }
                    Cursor query2 = P.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str4, strArr, (String) null, (String) null, "rowid", (String) null);
                    if (!query2.moveToFirst()) {
                        this.a.d().w().b("Raw event data disappeared while in transaction. appId", z1.z(str5));
                        query2.close();
                        return;
                    }
                    do {
                        long j4 = query2.getLong(0);
                        try {
                            zzfs zzfsVar = (zzfs) U4.E(zzft.zze(), query2.getBlob(3));
                            zzfsVar.zzi(query2.getString(1));
                            zzfsVar.zzm(query2.getLong(2));
                            if (!p4.a(j4, (zzft) zzfsVar.zzaD())) {
                                query2.close();
                                return;
                            }
                        } catch (IOException e3) {
                            this.a.d().r().c("Data loss. Failed to merge raw event. appId", z1.z(str5), e3);
                        }
                    } while (query2.moveToNext());
                    query2.close();
                } catch (IOException e4) {
                    this.a.d().r().c("Data loss. Failed to merge raw event metadata. appId", z1.z(str5), e4);
                    query.close();
                }
            } catch (SQLiteException e5) {
                e = e5;
                cursor = query;
                this.a.d().r().c("Data loss. Error selecting raw event. appId", z1.z(str5), e);
                if (cursor != 0) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                th = th3;
                str5 = query;
                if (str5 != null) {
                    str5.close();
                }
                throw th;
            }
        } catch (SQLiteException e6) {
            e = e6;
            cursor = 0;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final long I(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = P().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j2 = rawQuery.getLong(0);
                rawQuery.close();
                return j2;
            } catch (SQLiteException e) {
                this.a.d().r().c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final int J(String str, String str2) {
        com.google.android.gms.common.internal.r.g(str);
        com.google.android.gms.common.internal.r.g(str2);
        h();
        i();
        try {
            return P().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.a.d().r().d("Error deleting conditional property", z1.z(str), this.a.D().f(str2), e);
            return 0;
        }
    }

    public final long K(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            try {
                cursor = P().rawQuery(str, strArr);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return j2;
                }
                long j3 = cursor.getLong(0);
                cursor.close();
                return j3;
            } catch (SQLiteException e) {
                this.a.d().r().c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long L(String str, String str2) {
        long K;
        com.google.android.gms.common.internal.r.g(str);
        com.google.android.gms.common.internal.r.g("first_open_count");
        h();
        i();
        SQLiteDatabase P = P();
        P.beginTransaction();
        long j2 = 0;
        try {
            try {
                K = K("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                if (K == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", 0);
                    contentValues.put("previous_install_count", 0);
                    if (P.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                        this.a.d().r().c("Failed to insert column (got -1). appId", z1.z(str), "first_open_count");
                        return -1L;
                    }
                    K = 0;
                }
            } catch (SQLiteException e) {
                e = e;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + K));
                if (P.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    this.a.d().r().c("Failed to update column (got 0). appId", z1.z(str), "first_open_count");
                    return -1L;
                }
                P.setTransactionSuccessful();
                return K;
            } catch (SQLiteException e2) {
                e = e2;
                j2 = K;
                this.a.d().r().d("Error inserting column. appId", z1.z(str), "first_open_count", e);
                P.endTransaction();
                return j2;
            }
        } finally {
            P.endTransaction();
        }
    }

    public final long M() {
        return K("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long N() {
        return K("select max(timestamp) from raw_events", null, 0L);
    }

    public final long O(String str) {
        com.google.android.gms.common.internal.r.g(str);
        return K("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final SQLiteDatabase P() {
        h();
        try {
            return this.d.getWritableDatabase();
        } catch (SQLiteException e) {
            this.a.d().w().b("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00bf: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:192), block:B:58:0x00bf */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle Q(java.lang.String r8) {
        /*
            r7 = this;
            r7.h()
            r7.i()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.P()     // Catch: java.lang.Throwable -> Lc1 android.database.sqlite.SQLiteException -> Lc3
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> Lc1 android.database.sqlite.SQLiteException -> Lc3
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> Lc1 android.database.sqlite.SQLiteException -> Lc3
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r2 != 0) goto L34
            M4.l2 r8 = r7.a     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            M4.z1 r8 = r8.d()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            M4.x1 r8 = r8.v()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.lang.String r2 = "Default event parameters not found"
            r8.a(r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r1.close()
            return r0
        L2e:
            r8 = move-exception
            goto Lbf
        L31:
            r8 = move-exception
            goto Lc5
        L34:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            com.google.android.gms.internal.measurement.zzfs r3 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            com.google.android.gms.internal.measurement.zzmh r2 = M4.U4.E(r3, r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            com.google.android.gms.internal.measurement.zzlb r2 = r2.zzaD()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31 java.io.IOException -> La7
            M4.S4 r8 = r7.b     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r8.g0()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.util.List r8 = r2.zzi()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            android.os.Bundle r2 = new android.os.Bundle     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.<init>()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
        L5b:
            boolean r3 = r8.hasNext()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r3 == 0) goto La3
            java.lang.Object r3 = r8.next()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.lang.String r4 = r3.zzg()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            boolean r5 = r3.zzu()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 == 0) goto L79
            double r5 = r3.zza()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.putDouble(r4, r5)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            goto L5b
        L79:
            boolean r5 = r3.zzv()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 == 0) goto L87
            float r3 = r3.zzb()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.putFloat(r4, r3)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            goto L5b
        L87:
            boolean r5 = r3.zzy()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 == 0) goto L95
            java.lang.String r3 = r3.zzh()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.putString(r4, r3)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            goto L5b
        L95:
            boolean r5 = r3.zzw()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            if (r5 == 0) goto L5b
            long r5 = r3.zzd()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r2.putLong(r4, r5)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            goto L5b
        La3:
            r1.close()
            return r2
        La7:
            r2 = move-exception
            M4.l2 r3 = r7.a     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            M4.z1 r3 = r3.d()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            M4.x1 r3 = r3.r()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = M4.z1.z(r8)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r3.c(r4, r8, r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L31
            r1.close()
            return r0
        Lbf:
            r0 = r1
            goto Lda
        Lc1:
            r8 = move-exception
            goto Lda
        Lc3:
            r8 = move-exception
            r1 = r0
        Lc5:
            M4.l2 r2 = r7.a     // Catch: java.lang.Throwable -> L2e
            M4.z1 r2 = r2.d()     // Catch: java.lang.Throwable -> L2e
            M4.x1 r2 = r2.r()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r8)     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto Ld9
            r1.close()
        Ld9:
            return r0
        Lda:
            if (r0 == 0) goto Ldf
            r0.close()
        Ldf:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.Q(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x025b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final M4.I2 R(java.lang.String r39) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.R(java.lang.String):M4.I2");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final M4.d S(java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.S(java.lang.String, java.lang.String):M4.d");
    }

    public final j T(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return U(j2, str, 1L, false, false, z3, false, z5);
    }

    public final j U(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        com.google.android.gms.common.internal.r.g(str);
        h();
        i();
        String[] strArr = {str};
        j jVar = new j();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase P = P();
                Cursor query = P.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
                if (!query.moveToFirst()) {
                    this.a.d().w().b("Not updating daily counts, app is not known. appId", z1.z(str));
                    query.close();
                    return jVar;
                }
                if (query.getLong(0) == j2) {
                    jVar.b = query.getLong(1);
                    jVar.a = query.getLong(2);
                    jVar.c = query.getLong(3);
                    jVar.d = query.getLong(4);
                    jVar.e = query.getLong(5);
                }
                if (z) {
                    jVar.b += j3;
                }
                if (z2) {
                    jVar.a += j3;
                }
                if (z3) {
                    jVar.c += j3;
                }
                if (z4) {
                    jVar.d += j3;
                }
                if (z5) {
                    jVar.e += j3;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j2));
                contentValues.put("daily_public_events_count", Long.valueOf(jVar.a));
                contentValues.put("daily_events_count", Long.valueOf(jVar.b));
                contentValues.put("daily_conversions_count", Long.valueOf(jVar.c));
                contentValues.put("daily_error_events_count", Long.valueOf(jVar.d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(jVar.e));
                P.update("apps", contentValues, "app_id=?", strArr);
                query.close();
                return jVar;
            } catch (SQLiteException e) {
                this.a.d().r().c("Error updating daily counts. appId", z1.z(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return jVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final M4.r V(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.V(java.lang.String, java.lang.String):M4.r");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0073: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:116), block:B:29:0x0073 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final M4.X4 X(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.r.g(r11)
            com.google.android.gms.common.internal.r.g(r12)
            r10.h()
            r10.i()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.P()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L77
            java.lang.String r2 = "user_attributes"
            java.lang.String r3 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L77
            java.lang.String r4 = "app_id=? and name=?"
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L77
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteException -> L77
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            if (r2 != 0) goto L34
            r1.close()
            return r0
        L34:
            r2 = 0
            long r7 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r2 = 1
            java.lang.Object r9 = r10.Y(r1, r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            if (r9 != 0) goto L44
            r1.close()
            return r0
        L44:
            r2 = 2
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            M4.X4 r2 = new M4.X4     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r3 = r2
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            if (r3 == 0) goto L6f
            M4.l2 r3 = r10.a     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            M4.z1 r3 = r3.d()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            M4.x1 r3 = r3.r()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r4 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r5 = M4.z1.z(r11)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r3.b(r4, r5)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            goto L6f
        L6b:
            r11 = move-exception
            goto L73
        L6d:
            r2 = move-exception
            goto L7a
        L6f:
            r1.close()
            return r2
        L73:
            r0 = r1
            goto L9d
        L75:
            r11 = move-exception
            goto L9d
        L77:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L7a:
            M4.l2 r3 = r10.a     // Catch: java.lang.Throwable -> L6b
            M4.z1 r3 = r3.d()     // Catch: java.lang.Throwable -> L6b
            M4.x1 r3 = r3.r()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r4 = "Error querying user property. appId"
            java.lang.Object r11 = M4.z1.z(r11)     // Catch: java.lang.Throwable -> L6b
            M4.l2 r5 = r10.a     // Catch: java.lang.Throwable -> L6b
            M4.u1 r5 = r5.D()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r12 = r5.f(r12)     // Catch: java.lang.Throwable -> L6b
            r3.d(r4, r11, r12, r2)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L9c
            r1.close()
        L9c:
            return r0
        L9d:
            if (r0 == 0) goto La2
            r0.close()
        La2:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.X(java.lang.String, java.lang.String):M4.X4");
    }

    public final Object Y(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            this.a.d().r().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type != 4) {
            this.a.d().r().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.a.d().r().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String Z() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.P()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L26 android.database.sqlite.SQLiteException -> L28
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L1e
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r2 = move-exception
            goto L2b
        L1e:
            r0.close()
            return r1
        L22:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L40
        L26:
            r0 = move-exception
            goto L40
        L28:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L2b:
            M4.l2 r3 = r6.a     // Catch: java.lang.Throwable -> L1a
            M4.z1 r3 = r3.d()     // Catch: java.lang.Throwable -> L1a
            M4.x1 r3 = r3.r()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L3f
            r0.close()
        L3f:
            return r1
        L40:
            if (r1 == 0) goto L45
            r1.close()
        L45:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.Z():java.lang.String");
    }

    public final List a0(String str, String str2, String str3) {
        com.google.android.gms.common.internal.r.g(str);
        h();
        i();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return b0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        r2 = r27.a.d().r();
        r27.a.z();
        r2.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List b0(java.lang.String r28, java.lang.String[] r29) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.b0(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final List c0(String str) {
        com.google.android.gms.common.internal.r.g(str);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                this.a.z();
                cursor = P().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j2 = cursor.getLong(2);
                    Object Y = Y(cursor, 3);
                    if (Y == null) {
                        this.a.d().r().b("Read invalid user property value, ignoring it. appId", z1.z(str));
                    } else {
                        arrayList.add(new X4(str, str2, string, j2, Y));
                    }
                } while (cursor.moveToNext());
                cursor.close();
                return arrayList;
            } catch (SQLiteException e) {
                this.a.d().r().c("Error querying user properties. appId", z1.z(str), e);
                List emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
    
        r0 = r17.a.d().r();
        r17.a.z();
        r0.b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List d0(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.d0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void e0() {
        i();
        P().beginTransaction();
    }

    public final void f0() {
        i();
        P().endTransaction();
    }

    public final void g0(List list) {
        h();
        i();
        com.google.android.gms.common.internal.r.m(list);
        com.google.android.gms.common.internal.r.o(list.size());
        if (u()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (I("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                this.a.d().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                P().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                this.a.d().r().b("Error incrementing retry count. error", e);
            }
        }
    }

    public final void h0() {
        h();
        i();
        if (u()) {
            long a = this.b.e0().e.a();
            long b = this.a.a().b();
            long abs = Math.abs(b - a);
            this.a.z();
            if (abs > ((Long) m1.A.a(null)).longValue()) {
                this.b.e0().e.b(b);
                h();
                i();
                if (u()) {
                    SQLiteDatabase P = P();
                    String valueOf = String.valueOf(this.a.a().a());
                    this.a.z();
                    int delete = P.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(h.i())});
                    if (delete > 0) {
                        this.a.d().v().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    public final boolean l() {
        return false;
    }

    public final void m(String str, String str2) {
        com.google.android.gms.common.internal.r.g(str);
        com.google.android.gms.common.internal.r.g(str2);
        h();
        i();
        try {
            P().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.a.d().r().d("Error deleting user property. appId", z1.z(str), this.a.D().f(str2), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0250, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0234, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01de, code lost:
    
        r0 = r23.a.d().w();
        r10 = M4.z1.z(r24);
        r12 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f6, code lost:
    
        if (r11.zzp() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f8, code lost:
    
        r16 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0205, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r16));
        r21 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0203, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0296, code lost:
    
        r21 = r7;
        r0 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02a4, code lost:
    
        if (r0.hasNext() == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02a6, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzet) r0.next();
        i();
        h();
        com.google.android.gms.common.internal.r.g(r24);
        com.google.android.gms.common.internal.r.m(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02c0, code lost:
    
        if (r3.zze().isEmpty() == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02f2, code lost:
    
        r7 = r3.zzbx();
        r10 = new android.content.ContentValues();
        r10.put("app_id", r24);
        r10.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0309, code lost:
    
        if (r3.zzj() == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x030b, code lost:
    
        r11 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0315, code lost:
    
        r10.put("filter_id", r11);
        r22 = r0;
        r10.put("property_name", r3.zze());
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0327, code lost:
    
        if (r3.zzk() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0329, code lost:
    
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0333, code lost:
    
        r10.put("session_scoped", r0);
        r10.put("data", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0347, code lost:
    
        if (P().insertWithOnConflict("property_filters", (java.lang.String) null, r10, 5) != (-1)) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x035f, code lost:
    
        r0 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0349, code lost:
    
        r23.a.d().r().b("Failed to insert property filter (got -1). appId", M4.z1.z(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x035d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0363, code lost:
    
        r3 = r23.a.d().r();
        r7 = "Error storing property filter. appId";
        r8 = M4.z1.z(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0332, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0314, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02c2, code lost:
    
        r0 = r23.a.d().w();
        r8 = M4.z1.z(r24);
        r10 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02da, code lost:
    
        if (r3.zzj() == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02dc, code lost:
    
        r16 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02e9, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r10, java.lang.String.valueOf(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02e7, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0177, code lost:
    
        r0.c(r8, r10, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017b, code lost:
    
        r10 = r0.zzh().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0187, code lost:
    
        if (r10.hasNext() == false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0193, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzet) r10.next()).zzj() != false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0195, code lost:
    
        r0 = r23.a.d().w();
        r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
        r10 = M4.z1.z(r24);
        r9 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01aa, code lost:
    
        r10 = r0.zzg().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c0, code lost:
    
        if (r10.hasNext() == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01c2, code lost:
    
        r11 = (com.google.android.gms.internal.measurement.zzek) r10.next();
        i();
        h();
        com.google.android.gms.common.internal.r.g(r24);
        com.google.android.gms.common.internal.r.m(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01dc, code lost:
    
        if (r11.zzg().isEmpty() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0210, code lost:
    
        r3 = r11.zzbx();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r24);
        r7.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0229, code lost:
    
        if (r11.zzp() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x022b, code lost:
    
        r8 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0235, code lost:
    
        r7.put("filter_id", r8);
        r7.put("event_name", r11.zzg());
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0245, code lost:
    
        if (r11.zzq() == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0247, code lost:
    
        r8 = java.lang.Boolean.valueOf(r11.zzn());
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0251, code lost:
    
        r7.put("session_scoped", r8);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0265, code lost:
    
        if (P().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != (-1)) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0267, code lost:
    
        r23.a.d().r().b("Failed to insert event filter (got -1). appId", M4.z1.z(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x027a, code lost:
    
        r7 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0280, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0281, code lost:
    
        r3 = r23.a.d().r();
        r7 = "Error storing event filter. appId";
        r8 = M4.z1.z(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0291, code lost:
    
        r3.c(r7, r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0375, code lost:
    
        i();
        h();
        com.google.android.gms.common.internal.r.g(r24);
        r0 = P();
        r7 = r18;
        r0.delete("property_filters", r7, new java.lang.String[]{r24, java.lang.String.valueOf(r9)});
        r0.delete("event_filters", r7, new java.lang.String[]{r24, java.lang.String.valueOf(r9)});
        r18 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x039e, code lost:
    
        r7 = r21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(java.lang.String r24, java.util.List r25) {
        /*
            Method dump skipped, instructions count: 1155
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l.n(java.lang.String, java.util.List):void");
    }

    public final void o() {
        i();
        P().setTransactionSuccessful();
    }

    public final void p(I2 i2) {
        com.google.android.gms.common.internal.r.m(i2);
        h();
        i();
        String l0 = i2.l0();
        com.google.android.gms.common.internal.r.m(l0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", l0);
        contentValues.put("app_instance_id", i2.m0());
        contentValues.put("gmp_app_id", i2.a());
        contentValues.put("resettable_device_id_hash", i2.c());
        contentValues.put("last_bundle_index", Long.valueOf(i2.e0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(i2.f0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(i2.d0()));
        contentValues.put("app_version", i2.o0());
        contentValues.put("app_store", i2.n0());
        contentValues.put("gmp_version", Long.valueOf(i2.c0()));
        contentValues.put("dev_cert_hash", Long.valueOf(i2.Z()));
        contentValues.put("measurement_enabled", Boolean.valueOf(i2.O()));
        contentValues.put("day", Long.valueOf(i2.Y()));
        contentValues.put("daily_public_events_count", Long.valueOf(i2.W()));
        contentValues.put("daily_events_count", Long.valueOf(i2.V()));
        contentValues.put("daily_conversions_count", Long.valueOf(i2.T()));
        contentValues.put("config_fetched_time", Long.valueOf(i2.S()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(i2.b0()));
        contentValues.put("app_version_int", Long.valueOf(i2.R()));
        contentValues.put("firebase_instance_id", i2.p0());
        contentValues.put("daily_error_events_count", Long.valueOf(i2.U()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(i2.X()));
        contentValues.put("health_monitor_sample", i2.b());
        i2.A();
        contentValues.put("android_id", 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(i2.N()));
        contentValues.put("admob_app_id", i2.j0());
        contentValues.put("dynamite_version", Long.valueOf(i2.a0()));
        contentValues.put("session_stitching_token", i2.d());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(i2.Q()));
        contentValues.put("target_os_version", Long.valueOf(i2.h0()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(i2.g0()));
        List e = i2.e();
        if (e != null) {
            if (e.isEmpty()) {
                this.a.d().w().b("Safelisted events should not be an empty list. appId", l0);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", e));
            }
        }
        zzop.zzc();
        if (this.a.z().B(null, m1.m0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase P = P();
            if (P.update("apps", contentValues, "app_id = ?", new String[]{l0}) == 0 && P.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                this.a.d().r().b("Failed to insert/update app (got -1). appId", z1.z(l0));
            }
        } catch (SQLiteException e2) {
            this.a.d().r().c("Error storing app. appId", z1.z(l0), e2);
        }
    }

    public final void q(r rVar) {
        com.google.android.gms.common.internal.r.m(rVar);
        h();
        i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", rVar.a);
        contentValues.put("name", rVar.b);
        contentValues.put("lifetime_count", Long.valueOf(rVar.c));
        contentValues.put("current_bundle_count", Long.valueOf(rVar.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(rVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(rVar.g));
        contentValues.put("last_bundled_day", rVar.h);
        contentValues.put("last_sampled_complex_event_id", rVar.i);
        contentValues.put("last_sampling_rate", rVar.j);
        contentValues.put("current_session_count", Long.valueOf(rVar.e));
        Boolean bool = rVar.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (P().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                this.a.d().r().b("Failed to insert/update event aggregates (got -1). appId", z1.z(rVar.a));
            }
        } catch (SQLiteException e) {
            this.a.d().r().c("Error storing event aggregates. appId", z1.z(rVar.a), e);
        }
    }

    public final boolean r() {
        return I("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean s() {
        return I("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final boolean t() {
        return I("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final boolean u() {
        Context c = this.a.c();
        this.a.z();
        return c.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean v(String str, Long l2, long j2, zzft zzftVar) {
        h();
        i();
        com.google.android.gms.common.internal.r.m(zzftVar);
        com.google.android.gms.common.internal.r.g(str);
        com.google.android.gms.common.internal.r.m(l2);
        byte[] zzbx = zzftVar.zzbx();
        this.a.d().v().c("Saving complex main event, appId, data size", this.a.D().d(str), Integer.valueOf(zzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", zzbx);
        try {
            if (P().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.a.d().r().b("Failed to insert complex main event (got -1). appId", z1.z(str));
            return false;
        } catch (SQLiteException e) {
            this.a.d().r().c("Error storing complex main event. appId", z1.z(str), e);
            return false;
        }
    }

    public final boolean w(d dVar) {
        com.google.android.gms.common.internal.r.m(dVar);
        h();
        i();
        String str = dVar.f;
        com.google.android.gms.common.internal.r.m(str);
        if (X(str, dVar.h.g) == null) {
            long I = I("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.a.z();
            if (I >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", dVar.g);
        contentValues.put("name", dVar.h.g);
        H(contentValues, "value", com.google.android.gms.common.internal.r.m(dVar.h.H()));
        contentValues.put("active", Boolean.valueOf(dVar.j));
        contentValues.put("trigger_event_name", dVar.k);
        contentValues.put("trigger_timeout", Long.valueOf(dVar.m));
        contentValues.put("timed_out_event", this.a.N().e0(dVar.l));
        contentValues.put("creation_timestamp", Long.valueOf(dVar.i));
        contentValues.put("triggered_event", this.a.N().e0(dVar.n));
        contentValues.put("triggered_timestamp", Long.valueOf(dVar.h.h));
        contentValues.put("time_to_live", Long.valueOf(dVar.o));
        contentValues.put("expired_event", this.a.N().e0(dVar.p));
        try {
            if (P().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.a.d().r().b("Failed to insert/update conditional user property (got -1)", z1.z(str));
            return true;
        } catch (SQLiteException e) {
            this.a.d().r().c("Error storing conditional user property", z1.z(str), e);
            return true;
        }
    }

    public final boolean x(X4 x4) {
        com.google.android.gms.common.internal.r.m(x4);
        h();
        i();
        if (X(x4.a, x4.c) == null) {
            if (a5.Z(x4.c)) {
                if (I("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{x4.a}) >= this.a.z().p(x4.a, m1.I, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(x4.c)) {
                long I = I("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{x4.a, x4.b});
                this.a.z();
                if (I >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", x4.a);
        contentValues.put("origin", x4.b);
        contentValues.put("name", x4.c);
        contentValues.put("set_timestamp", Long.valueOf(x4.d));
        H(contentValues, "value", x4.e);
        try {
            if (P().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.a.d().r().b("Failed to insert/update user property (got -1). appId", z1.z(x4.a));
            return true;
        } catch (SQLiteException e) {
            this.a.d().r().c("Error storing user property. appId", z1.z(x4.a), e);
            return true;
        }
    }
}
