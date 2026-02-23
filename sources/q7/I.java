package q7;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nst.iptvsmarterstvbox.model.database.DatabaseHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class i extends BaseAdapter {
    public List a;
    public List d;
    public LayoutInflater e;
    public Context f;
    public DatabaseHandler g;
    public a h;
    public File k;
    public File l;
    public String s;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int t = 0;
    public List i = new ArrayList();
    public List j = new ArrayList();
    public List c = new ArrayList();

    public static class a {
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public LinearLayout e;
    }

    public i(Context context, List list) {
        this.d = list;
        this.a = list;
        this.f = context;
        this.e = LayoutInflater.from(context);
        this.g = new DatabaseHandler(context);
    }

    public int getCount() {
        return this.d.size();
    }

    public Object getItem(int i) {
        return this.d.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0101 A[Catch: all -> 0x00f1, Exception -> 0x00f5, TryCatch #6 {Exception -> 0x00f5, all -> 0x00f1, blocks: (B:6:0x0099, B:8:0x00cd, B:10:0x00d1, B:12:0x00e3, B:14:0x00eb, B:16:0x00fe, B:17:0x00f9, B:140:0x0101, B:143:0x0111, B:145:0x011f, B:147:0x012d, B:149:0x014f, B:150:0x0168, B:151:0x016d, B:153:0x0175, B:155:0x017f, B:157:0x0187, B:159:0x0192, B:160:0x018d, B:163:0x0195, B:164:0x01cb), top: B:5:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x014f A[Catch: all -> 0x00f1, Exception -> 0x00f5, TryCatch #6 {Exception -> 0x00f5, all -> 0x00f1, blocks: (B:6:0x0099, B:8:0x00cd, B:10:0x00d1, B:12:0x00e3, B:14:0x00eb, B:16:0x00fe, B:17:0x00f9, B:140:0x0101, B:143:0x0111, B:145:0x011f, B:147:0x012d, B:149:0x014f, B:150:0x0168, B:151:0x016d, B:153:0x0175, B:155:0x017f, B:157:0x0187, B:159:0x0192, B:160:0x018d, B:163:0x0195, B:164:0x01cb), top: B:5:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x016d A[Catch: all -> 0x00f1, Exception -> 0x00f5, TryCatch #6 {Exception -> 0x00f5, all -> 0x00f1, blocks: (B:6:0x0099, B:8:0x00cd, B:10:0x00d1, B:12:0x00e3, B:14:0x00eb, B:16:0x00fe, B:17:0x00f9, B:140:0x0101, B:143:0x0111, B:145:0x011f, B:147:0x012d, B:149:0x014f, B:150:0x0168, B:151:0x016d, B:153:0x0175, B:155:0x017f, B:157:0x0187, B:159:0x0192, B:160:0x018d, B:163:0x0195, B:164:0x01cb), top: B:5:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0221 A[Catch: all -> 0x0238, Exception -> 0x023c, TRY_ENTER, TryCatch #5 {Exception -> 0x023c, all -> 0x0238, blocks: (B:20:0x0211, B:23:0x0221, B:24:0x0227, B:25:0x046a, B:27:0x0487, B:30:0x04d2, B:32:0x04e2, B:33:0x04f3, B:34:0x04f8, B:36:0x0506, B:38:0x0516, B:40:0x0524, B:42:0x052c, B:43:0x053e, B:45:0x0546, B:46:0x0557, B:48:0x0563, B:50:0x056b, B:52:0x057b, B:53:0x0598, B:54:0x05ab, B:55:0x0240, B:57:0x024e, B:58:0x0255, B:60:0x0263, B:61:0x026a, B:64:0x0294, B:66:0x02a2, B:68:0x02b0, B:70:0x02be, B:72:0x02cc, B:74:0x02da, B:76:0x02e8, B:78:0x02f6, B:80:0x0304, B:82:0x0312, B:83:0x0318, B:84:0x031f, B:86:0x032d, B:87:0x0334, B:89:0x0346, B:92:0x0358, B:94:0x0366, B:97:0x0376, B:99:0x0384, B:101:0x0392, B:103:0x03a0, B:105:0x03ae, B:107:0x03bc, B:109:0x03ca, B:112:0x03da, B:114:0x03e2, B:116:0x03f0, B:118:0x03fe, B:120:0x040c, B:122:0x041a, B:124:0x0428, B:126:0x0436, B:128:0x0444, B:129:0x044a, B:130:0x044e, B:131:0x0455, B:132:0x045c, B:133:0x0463), top: B:19:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0487 A[Catch: all -> 0x0238, Exception -> 0x023c, TryCatch #5 {Exception -> 0x023c, all -> 0x0238, blocks: (B:20:0x0211, B:23:0x0221, B:24:0x0227, B:25:0x046a, B:27:0x0487, B:30:0x04d2, B:32:0x04e2, B:33:0x04f3, B:34:0x04f8, B:36:0x0506, B:38:0x0516, B:40:0x0524, B:42:0x052c, B:43:0x053e, B:45:0x0546, B:46:0x0557, B:48:0x0563, B:50:0x056b, B:52:0x057b, B:53:0x0598, B:54:0x05ab, B:55:0x0240, B:57:0x024e, B:58:0x0255, B:60:0x0263, B:61:0x026a, B:64:0x0294, B:66:0x02a2, B:68:0x02b0, B:70:0x02be, B:72:0x02cc, B:74:0x02da, B:76:0x02e8, B:78:0x02f6, B:80:0x0304, B:82:0x0312, B:83:0x0318, B:84:0x031f, B:86:0x032d, B:87:0x0334, B:89:0x0346, B:92:0x0358, B:94:0x0366, B:97:0x0376, B:99:0x0384, B:101:0x0392, B:103:0x03a0, B:105:0x03ae, B:107:0x03bc, B:109:0x03ca, B:112:0x03da, B:114:0x03e2, B:116:0x03f0, B:118:0x03fe, B:120:0x040c, B:122:0x041a, B:124:0x0428, B:126:0x0436, B:128:0x0444, B:129:0x044a, B:130:0x044e, B:131:0x0455, B:132:0x045c, B:133:0x0463), top: B:19:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x04d2 A[Catch: all -> 0x0238, Exception -> 0x023c, TryCatch #5 {Exception -> 0x023c, all -> 0x0238, blocks: (B:20:0x0211, B:23:0x0221, B:24:0x0227, B:25:0x046a, B:27:0x0487, B:30:0x04d2, B:32:0x04e2, B:33:0x04f3, B:34:0x04f8, B:36:0x0506, B:38:0x0516, B:40:0x0524, B:42:0x052c, B:43:0x053e, B:45:0x0546, B:46:0x0557, B:48:0x0563, B:50:0x056b, B:52:0x057b, B:53:0x0598, B:54:0x05ab, B:55:0x0240, B:57:0x024e, B:58:0x0255, B:60:0x0263, B:61:0x026a, B:64:0x0294, B:66:0x02a2, B:68:0x02b0, B:70:0x02be, B:72:0x02cc, B:74:0x02da, B:76:0x02e8, B:78:0x02f6, B:80:0x0304, B:82:0x0312, B:83:0x0318, B:84:0x031f, B:86:0x032d, B:87:0x0334, B:89:0x0346, B:92:0x0358, B:94:0x0366, B:97:0x0376, B:99:0x0384, B:101:0x0392, B:103:0x03a0, B:105:0x03ae, B:107:0x03bc, B:109:0x03ca, B:112:0x03da, B:114:0x03e2, B:116:0x03f0, B:118:0x03fe, B:120:0x040c, B:122:0x041a, B:124:0x0428, B:126:0x0436, B:128:0x0444, B:129:0x044a, B:130:0x044e, B:131:0x0455, B:132:0x045c, B:133:0x0463), top: B:19:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0240 A[Catch: all -> 0x0238, Exception -> 0x023c, TryCatch #5 {Exception -> 0x023c, all -> 0x0238, blocks: (B:20:0x0211, B:23:0x0221, B:24:0x0227, B:25:0x046a, B:27:0x0487, B:30:0x04d2, B:32:0x04e2, B:33:0x04f3, B:34:0x04f8, B:36:0x0506, B:38:0x0516, B:40:0x0524, B:42:0x052c, B:43:0x053e, B:45:0x0546, B:46:0x0557, B:48:0x0563, B:50:0x056b, B:52:0x057b, B:53:0x0598, B:54:0x05ab, B:55:0x0240, B:57:0x024e, B:58:0x0255, B:60:0x0263, B:61:0x026a, B:64:0x0294, B:66:0x02a2, B:68:0x02b0, B:70:0x02be, B:72:0x02cc, B:74:0x02da, B:76:0x02e8, B:78:0x02f6, B:80:0x0304, B:82:0x0312, B:83:0x0318, B:84:0x031f, B:86:0x032d, B:87:0x0334, B:89:0x0346, B:92:0x0358, B:94:0x0366, B:97:0x0376, B:99:0x0384, B:101:0x0392, B:103:0x03a0, B:105:0x03ae, B:107:0x03bc, B:109:0x03ca, B:112:0x03da, B:114:0x03e2, B:116:0x03f0, B:118:0x03fe, B:120:0x040c, B:122:0x041a, B:124:0x0428, B:126:0x0436, B:128:0x0444, B:129:0x044a, B:130:0x044e, B:131:0x0455, B:132:0x045c, B:133:0x0463), top: B:19:0x0211 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r23, android.view.View r24, android.view.ViewGroup r25) {
        /*
            Method dump skipped, instructions count: 1475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.i.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
