package l6;

import A5.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c {
    public File a;
    public final f b;

    public enum a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public c(f fVar) {
        this.b = fVar;
    }

    public final File a() {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = new File(this.b.l().getFilesDir(), "PersistedInstallation." + this.b.q() + ".json");
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    public d b(d dVar) {
        File createTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", dVar.d());
            jSONObject.put("Status", dVar.g().ordinal());
            jSONObject.put("AuthToken", dVar.b());
            jSONObject.put("RefreshToken", dVar.f());
            jSONObject.put("TokenCreationEpochInSecs", dVar.h());
            jSONObject.put("ExpiresInSecs", dVar.c());
            jSONObject.put("FisError", dVar.e());
            createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.b.l().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (JSONException | IOException unused) {
        }
        if (createTempFile.renameTo(a())) {
            return dVar;
        }
        throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }

    public final JSONObject c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, 16384);
                    if (read < 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                        fileInputStream.close();
                        return jSONObject;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        }
    }

    public d d() {
        JSONObject c = c();
        String optString = c.optString("Fid", (String) null);
        int optInt = c.optInt("Status", a.ATTEMPT_MIGRATION.ordinal());
        String optString2 = c.optString("AuthToken", (String) null);
        String optString3 = c.optString("RefreshToken", (String) null);
        long optLong = c.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = c.optLong("ExpiresInSecs", 0L);
        return d.a().d(optString).g(a.values()[optInt]).b(optString2).f(optString3).h(optLong).c(optLong2).e(c.optString("FisError", (String) null)).a();
    }
}
