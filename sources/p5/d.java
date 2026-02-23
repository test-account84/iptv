package P5;

import O5.i;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d {
    public static final Charset b = Charset.forName("UTF-8");
    public final T5.f a;

    public d(T5.f fVar) {
        this.a = fVar;
    }

    public static Map d(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, j(jSONObject, str2));
        }
        return hashMap;
    }

    public static String f(Map map) {
        return new JSONObject(map).toString();
    }

    public static void i(File file) {
        if (file.exists() && file.delete()) {
            L5.f.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    public static String j(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, (String) null);
    }

    public File a(String str) {
        return this.a.o(str, "internal-keys");
    }

    public File b(String str) {
        return this.a.o(str, "keys");
    }

    public File c(String str) {
        return this.a.o(str, "user-data");
    }

    public final String e(String str) {
        return j(new JSONObject(str), "userId");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    public Map g(String str, boolean z) {
        FileInputStream fileInputStream;
        Exception e;
        File a = z ? a(str) : b(str);
        if (a.exists()) {
            ?? length = a.length();
            if (length != 0) {
                Closeable closeable = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(a);
                        try {
                            Map d = d(i.D(fileInputStream));
                            i.e(fileInputStream, "Failed to close user metadata file.");
                            return d;
                        } catch (Exception e2) {
                            e = e2;
                            L5.f.f().l("Error deserializing user metadata.", e);
                            i(a);
                            i.e(fileInputStream, "Failed to close user metadata file.");
                            return Collections.emptyMap();
                        }
                    } catch (Throwable th) {
                        th = th;
                        closeable = length;
                        i.e(closeable, "Failed to close user metadata file.");
                        throw th;
                    }
                } catch (Exception e3) {
                    fileInputStream = null;
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                    i.e(closeable, "Failed to close user metadata file.");
                    throw th;
                }
            }
        }
        i(a);
        return Collections.emptyMap();
    }

    public String h(String str) {
        FileInputStream fileInputStream;
        File c = c(str);
        FileInputStream fileInputStream2 = null;
        if (!c.exists() || c.length() == 0) {
            L5.f.f().b("No userId set for session " + str);
            i(c);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(c);
            try {
                try {
                    String e = e(i.D(fileInputStream));
                    L5.f.f().b("Loaded userId " + e + " for session " + str);
                    i.e(fileInputStream, "Failed to close user metadata file.");
                    return e;
                } catch (Exception e2) {
                    e = e2;
                    L5.f.f().l("Error deserializing user metadata.", e);
                    i(c);
                    i.e(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                i.e(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            i.e(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void k(String str, Map map, boolean z) {
        String f;
        Closeable bufferedWriter;
        File a = z ? a(str) : b(str);
        Closeable closeable = null;
        try {
            try {
                f = f(map);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a), b));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            bufferedWriter.write(f);
            bufferedWriter.flush();
            i.e(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e2) {
            e = e2;
            closeable = bufferedWriter;
            L5.f.f().l("Error serializing key/value metadata.", e);
            i(a);
            i.e(closeable, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            closeable = bufferedWriter;
            i.e(closeable, "Failed to close key/value metadata file.");
            throw th;
        }
    }
}
