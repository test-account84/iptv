package B7;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.nst.iptvsmarterstvbox.model.database.EPGSourcesModel;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import com.nst.iptvsmarterstvbox.model.pojo.XMLTVProgrammePojo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class d extends DefaultHandler {
    public SharedPreferences g;
    public Context h;
    public LiveStreamDBHandler i;
    public SimpleDateFormat l;
    public String a = "";
    public String c = "XMLHelper";
    public Boolean d = Boolean.FALSE;
    public String e = "";
    public XMLTVProgrammePojo f = null;
    public String j = "0";
    public int k = 0;
    public ArrayList m = new ArrayList();

    public void a(Context context) {
        this.h = context;
        this.i = new LiveStreamDBHandler(context);
        try {
            m7.a.I0 = true;
            this.g = context.getSharedPreferences("loginPrefs", 0);
            this.l = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            ArrayList activeEPGSource = this.i.getActiveEPGSource();
            if (activeEPGSource != null && activeEPGSource.size() > 0) {
                this.a = ((EPGSourcesModel) activeEPGSource.get(0)).getEpgurl();
                this.j = String.valueOf(((EPGSourcesModel) activeEPGSource.get(0)).getIdAuto());
            }
            String str = this.a;
            if (str == null || str.isEmpty() || this.a.equalsIgnoreCase("")) {
                return;
            }
            if (!this.a.contains(".gz")) {
                XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                xMLReader.setContentHandler(this);
                InputStream openStream = new URL(this.a).openStream();
                InputSource inputSource = new InputSource(openStream);
                inputSource.setEncoding("UTF-8");
                xMLReader.parse(inputSource);
                openStream.close();
                return;
            }
            File file = new File(context.getFilesDir() + "/epgZip.xml");
            File file2 = new File(String.valueOf(file));
            if (file2.exists()) {
                file2.delete();
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new InputSource(new GZIPInputStream(new URL(this.a).openConnection().getInputStream())).getByteStream());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[2097152];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        XMLReader xMLReader2 = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                        xMLReader2.setContentHandler(this);
                        InputSource inputSource2 = new InputSource(new FileInputStream(file.getPath()));
                        inputSource2.setEncoding("UTF-8");
                        xMLReader2.parse(inputSource2);
                        return;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e) {
                Log.e("honey", "Exception: " + e.getMessage());
            }
        } catch (Exception e2) {
            Log.e(this.c, "Exception: " + e2.getMessage());
        }
    }

    public ArrayList b() {
        return this.m;
    }

    public void characters(char[] cArr, int i, int i2) {
        if (this.d.booleanValue()) {
            try {
                this.e += new String(cArr, i, i2);
            } catch (Exception unused) {
                this.e = "";
            }
        }
    }

    public void endElement(String str, String str2, String str3) {
        this.d = Boolean.FALSE;
        XMLTVProgrammePojo xMLTVProgrammePojo = this.f;
        if (xMLTVProgrammePojo != null) {
            xMLTVProgrammePojo.setSourceRef(this.j);
        }
        if (str2.equalsIgnoreCase("title")) {
            XMLTVProgrammePojo xMLTVProgrammePojo2 = this.f;
            if (xMLTVProgrammePojo2 != null) {
                xMLTVProgrammePojo2.setTitle(this.e);
                return;
            }
            return;
        }
        if (str2.equalsIgnoreCase("desc")) {
            XMLTVProgrammePojo xMLTVProgrammePojo3 = this.f;
            if (xMLTVProgrammePojo3 != null) {
                xMLTVProgrammePojo3.setDesc(this.e);
                return;
            }
            return;
        }
        if (str2.equalsIgnoreCase("programme")) {
            this.m.add(this.f);
            int i = this.k + 1;
            this.k = i;
            if (i > 10000) {
                this.k = 0;
                LiveStreamDBHandler liveStreamDBHandler = this.i;
                if (liveStreamDBHandler != null && liveStreamDBHandler.addEPGTesting2(this.m)) {
                    this.m.clear();
                }
            }
            this.f = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startElement(java.lang.String r9, java.lang.String r10, java.lang.String r11, org.xml.sax.Attributes r12) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: B7.d.startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes):void");
    }
}
