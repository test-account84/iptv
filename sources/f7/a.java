package F7;

import a7.j;
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
public class a {
    public static H7.a e;
    public File a;
    public InputStream b;
    public Context c;
    public String d;

    public a(Context context, File file, H7.a aVar) {
        this.a = file;
        this.c = context;
        String name = file.getName();
        this.d = name;
        if (name != null && name.endsWith(".zip")) {
            this.d = this.d.replaceAll(".zip", "");
        }
        a("");
        e = aVar;
    }

    public final void a(String str) {
        File file = new File(str);
        Log.i("UNZIPUTIL", "creating dir " + str);
        if (str.length() < 0 || file.isDirectory()) {
            return;
        }
        file.mkdirs();
    }

    public void b(String str) {
        File file;
        new u7.a(this.c).A();
        if (str.equals("SBP_URL")) {
            file = Build.VERSION.SDK_INT >= 23 ? new File(this.c.getFilesDir() + "/VPNSBPIPTVSmarters/" + this.d) : new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNSBPIPTVSmarters/" + this.d);
            File file2 = new File(String.valueOf(file));
            if (file2.exists()) {
                file2.deleteOnExit();
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            file = new File(this.c.getFilesDir() + "/VPNIPTVSmarters/" + this.d);
        } else {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "VPNIPTVSmarters/" + this.d);
        }
        try {
            try {
                File file3 = new File(String.valueOf(file));
                if (file3.isDirectory()) {
                    for (File file4 : file3.listFiles()) {
                        file4.delete();
                    }
                }
                file3.delete();
            } catch (Exception unused) {
                Log.e("mszz: ", "error deleting file");
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
                    e.x0(String.valueOf(file));
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
        } catch (Exception e2) {
            Log.e("UNZIPUTIL", "Unzip Error", e2);
            e.z0(this.c.getResources().getString(j.e7));
            e.x0(String.valueOf(file));
        }
    }
}
