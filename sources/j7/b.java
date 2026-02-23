package j7;

import d.D;
import j7.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends j7.a {
    public static final List j = new a();
    public static final Map k = new b();
    public static Map l = new HashMap();
    public final List h;
    public final boolean i;

    public class a extends ArrayList {
        public a() {
            add("index.html");
            add("index.htm");
        }
    }

    public class b extends HashMap {
        public b() {
            put("css", "text/css");
            put("htm", "text/html");
            put("html", "text/html");
            put("xml", "text/xml");
            put("java", "text/x-java-source, text/java");
            put("md", "text/plain");
            put("txt", "text/plain");
            put("asc", "text/plain");
            put("gif", "image/gif");
            put("jpg", "image/jpeg");
            put("jpeg", "image/jpeg");
            put("png", "image/png");
            put("mp3", "audio/mpeg");
            put("m3u", "audio/mpeg-url");
            put("mp4", "video/mp4");
            put("ogv", "video/ogg");
            put("flv", "video/x-flv");
            put("mov", "video/quicktime");
            put("swf", "application/x-shockwave-flash");
            put("js", "application/javascript");
            put("pdf", "application/pdf");
            put("doc", "application/msword");
            put("ogg", "application/x-ogg");
            put("zip", "application/octet-stream");
            put("exe", "application/octet-stream");
            put("class", "application/octet-stream");
        }
    }

    public class c extends FileInputStream {
        public final /* synthetic */ long a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(File file, long j) {
            super(file);
            this.a = j;
        }

        public int available() {
            return (int) this.a;
        }
    }

    public class d implements FilenameFilter {
        public d() {
        }

        public boolean accept(File file, String str) {
            return new File(file, str).isFile();
        }
    }

    public class e implements FilenameFilter {
        public e() {
        }

        public boolean accept(File file, String str) {
            return new File(file, str).isDirectory();
        }
    }

    public b(String str, int i, File file, boolean z) {
        super(str, i);
        this.i = z;
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        arrayList.add(file);
        B();
    }

    public final List A() {
        return this.h;
    }

    public String C(String str, File file) {
        String str2;
        String substring;
        int lastIndexOf;
        String str3 = "Directory " + str;
        StringBuilder sb = new StringBuilder("<html><head><title>" + str3 + "</title><style><!--\nspan.dirname { font-weight: bold; }\nspan.filesize { font-size: 75%; }\n// -->\n</style></head><body><h1>" + str3 + "</h1>");
        String substring2 = (str.length() <= 1 || (lastIndexOf = (substring = str.substring(0, str.length() - 1)).lastIndexOf(47)) < 0 || lastIndexOf >= substring.length()) ? null : str.substring(0, lastIndexOf + 1);
        List<String> asList = Arrays.asList(file.list(new d()));
        Collections.sort(asList);
        List asList2 = Arrays.asList(file.list(new e()));
        Collections.sort(asList2);
        if (substring2 != null || asList2.size() + asList.size() > 0) {
            sb.append("<ul>");
            if (substring2 != null || asList2.size() > 0) {
                sb.append("<section class=\"directories\">");
                if (substring2 != null) {
                    sb.append("<li><a rel=\"directory\" href=\"");
                    sb.append(substring2);
                    sb.append("\"><span class=\"dirname\">..</span></a></b></li>");
                }
                Iterator it = asList2.iterator();
                while (it.hasNext()) {
                    String str4 = ((String) it.next()) + "/";
                    sb.append("<li><a rel=\"directory\" href=\"");
                    sb.append(u(str + str4));
                    sb.append("\"><span class=\"dirname\">");
                    sb.append(str4);
                    sb.append("</span></a></b></li>");
                }
                sb.append("</section>");
            }
            if (asList.size() > 0) {
                sb.append("<section class=\"files\">");
                for (String str5 : asList) {
                    sb.append("<li><a href=\"");
                    sb.append(u(str + str5));
                    sb.append("\"><span class=\"filename\">");
                    sb.append(str5);
                    sb.append("</span></a>");
                    long length = new File(file, str5).length();
                    sb.append("&nbsp;<span class=\"filesize\">(");
                    if (length < 1024) {
                        sb.append(length);
                        str2 = " bytes";
                    } else if (length < 1048576) {
                        sb.append(length / 1024);
                        sb.append(".");
                        sb.append(((length % 1024) / 10) % 100);
                        str2 = " KB";
                    } else {
                        sb.append(length / 1048576);
                        sb.append(".");
                        sb.append(((length % 1048576) / 10) % 100);
                        str2 = " MB";
                    }
                    sb.append(str2);
                    sb.append(")</span></li>");
                }
                sb.append("</section>");
            }
            sb.append("</ul>");
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    public final a.j D(Map map, a.h hVar, String str) {
        String replace = str.trim().replace(File.separatorChar, '/');
        boolean z = false;
        if (replace.indexOf(63) >= 0) {
            replace = replace.substring(0, replace.indexOf(63));
        }
        if (replace.startsWith("src/main") || replace.endsWith("src/main") || replace.contains("../")) {
            return w("Won't serve ../ for security reasons.");
        }
        List A = A();
        File file = null;
        for (int i = 0; !z && i < A.size(); i++) {
            file = (File) A.get(i);
            z = r(replace, file);
        }
        if (!z) {
            return z();
        }
        File file2 = new File(file, replace);
        if (!file2.isDirectory() || replace.endsWith("/")) {
            if (!file2.isDirectory()) {
                String y = y(replace);
                D.a(l.get(y));
                a.j E = E(replace, map, file2, y);
                return E != null ? E : z();
            }
            String v = v(file2);
            if (v == null) {
                return file2.canRead() ? t(a.j.b.OK, "text/html", C(replace, file2)) : w("No directory listing.");
            }
            return D(map, hVar, replace + v);
        }
        String str2 = replace + "/";
        a.j t = t(a.j.b.REDIRECT, "text/html", "<html><body>Redirected: <a href=\"" + str2 + "\">" + str2 + "</a></body></html>");
        t.a("Location", str2);
        return t;
    }

    public a.j E(String str, Map map, File file, String str2) {
        long j2;
        a.j s;
        int indexOf;
        try {
            String hexString = Integer.toHexString((file.getAbsolutePath() + file.lastModified() + "" + file.length()).hashCode());
            String str3 = (String) map.get("range");
            long j3 = 0;
            long j4 = -1;
            if (str3 == null || !str3.startsWith("bytes=") || (indexOf = (str3 = str3.substring(6)).indexOf(45)) <= 0) {
                j2 = 0;
            } else {
                try {
                    j2 = Long.parseLong(str3.substring(0, indexOf));
                    try {
                        j4 = Long.parseLong(str3.substring(indexOf + 1));
                    } catch (NumberFormatException unused) {
                    }
                } catch (NumberFormatException unused2) {
                }
            }
            long length = file.length();
            String str4 = "ETag";
            if (str3 == null || j2 < 0) {
                if (hexString.equals(map.get("if-none-match"))) {
                    return t(a.j.b.NOT_MODIFIED, str2, "");
                }
                a.j s2 = s(a.j.b.OK, str2, new FileInputStream(file));
                s2.a("Content-Length", "" + length);
                s2.a("ETag", hexString);
                return s2;
            }
            if (j2 >= length) {
                s = t(a.j.b.RANGE_NOT_SATISFIABLE, "text/plain", "");
                s.a("Content-Range", "bytes 0-0/" + length);
            } else {
                if (j4 < 0) {
                    j4 = length - 1;
                }
                long j5 = (j4 - j2) + 1;
                if (j5 >= 0) {
                    j3 = j5;
                }
                c cVar = new c(file, j3);
                cVar.skip(j2);
                s = s(a.j.b.PARTIAL_CONTENT, str2, cVar);
                s.a("Content-Length", "" + j3);
                s.a("Content-Range", "bytes " + j2 + "-" + j4 + "/" + length);
                str4 = "ETag";
            }
            s.a(str4, hexString);
            return s;
        } catch (IOException unused3) {
            return w("Reading file failed.");
        }
    }

    public a.j l(a.h hVar) {
        Map headers = hVar.getHeaders();
        Map a2 = hVar.a();
        String uri = hVar.getUri();
        if (!this.i) {
            System.out.println(hVar.getMethod() + " '" + uri + "' ");
            for (String str : headers.keySet()) {
                System.out.println("  HDR: '" + str + "' = '" + ((String) headers.get(str)) + "'");
            }
            for (String str2 : a2.keySet()) {
                System.out.println("  PRM: '" + str2 + "' = '" + ((String) a2.get(str2)) + "'");
            }
        }
        for (File file : A()) {
            if (!file.isDirectory()) {
                return x("given path is not a directory (" + file + ").");
            }
        }
        return D(Collections.unmodifiableMap(headers), hVar, uri);
    }

    public final boolean r(String str, File file) {
        boolean exists = new File(file, str).exists();
        if (!exists) {
            D.a(l.get(y(str)));
        }
        return exists;
    }

    public final a.j s(a.j.b bVar, String str, InputStream inputStream) {
        a.j jVar = new a.j(bVar, str, inputStream);
        jVar.a("Accept-Ranges", "bytes");
        return jVar;
    }

    public final a.j t(a.j.b bVar, String str, String str2) {
        a.j jVar = new a.j(bVar, str, str2);
        jVar.a("Accept-Ranges", "bytes");
        return jVar;
    }

    public final String u(String str) {
        StringBuilder sb;
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/ ", true);
        String str2 = "";
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("/")) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("/");
            } else if (nextToken.equals(" ")) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("%20");
            } else {
                try {
                    str2 = str2 + URLEncoder.encode(nextToken, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
            }
            str2 = sb.toString();
        }
        return str2;
    }

    public final String v(File file) {
        for (String str : j) {
            if (new File(file, str).exists()) {
                return str;
            }
        }
        return null;
    }

    public a.j w(String str) {
        return t(a.j.b.FORBIDDEN, "text/plain", "FORBIDDEN: " + str);
    }

    public a.j x(String str) {
        return t(a.j.b.INTERNAL_ERROR, "text/plain", "INTERNAL ERRROR: " + str);
    }

    public final String y(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = lastIndexOf >= 0 ? (String) k.get(str.substring(lastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? "application/octet-stream" : str2;
    }

    public a.j z() {
        return t(a.j.b.NOT_FOUND, "text/plain", "Error 404, file not found.");
    }

    public void B() {
    }
}
