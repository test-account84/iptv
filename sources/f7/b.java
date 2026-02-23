package F7;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b {
    public static H7.a f;
    public File a;
    public InputStream b;
    public Context c;
    public String d;
    public String e = "";

    public b(Context context, File file, H7.a aVar) {
        this.d = "";
        this.a = file;
        String name = file.getName();
        this.d = name;
        if (name != null && name.endsWith(".zip")) {
            this.d = this.d.replaceAll(".zip", "");
        }
        this.c = context;
        a("");
        f = aVar;
    }

    public final void a(String str) {
        File file = new File(str);
        Log.i("UNZIPUTIL", "creating dir " + str);
        if (str.length() < 0 || file.isDirectory()) {
            return;
        }
        file.mkdirs();
    }

    public void b() {
        File file;
        try {
            if (new u7.a(this.c).A().equals(m7.a.K0)) {
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNIPTVSmarters/" + this.d);
            } else if (Build.VERSION.SDK_INT >= 23) {
                file = new File(this.c.getFilesDir() + "/VPNIPTVSmarters/" + this.d);
            } else {
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNIPTVSmarters/" + this.d);
            }
            a(String.valueOf(file));
            Log.i("UNZIPUTIL", "Starting to unzip");
            FileInputStream fileInputStream = this.b;
            if (fileInputStream == null) {
                fileInputStream = new FileInputStream(this.a);
            }
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    f.x0(String.valueOf(file));
                    Log.i("UNZIPUTIL", "Finished unzip");
                    return;
                }
                Log.v("UNZIPUTIL", "Unzipping " + nextEntry.getName());
                if (!nextEntry.isDirectory()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file, nextEntry.getName()));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.reset();
                    }
                    fileOutputStream.close();
                    zipInputStream.closeEntry();
                }
            }
        } catch (Exception e) {
            Log.e("UNZIPUTIL", "Unzip Error", e);
            f.z0("failed to Extract zip file ");
        }
    }
}
