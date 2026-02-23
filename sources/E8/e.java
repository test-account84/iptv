package E8;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class e implements Serializable {
    public static final a c = new a(null);
    public final Pattern a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e(String pattern) {
        kotlin.jvm.internal.l.e(pattern, "pattern");
        Pattern compile = Pattern.compile(pattern);
        kotlin.jvm.internal.l.d(compile, "compile(pattern)");
        this(compile);
    }

    public final boolean a(CharSequence input) {
        kotlin.jvm.internal.l.e(input, "input");
        return this.a.matcher(input).matches();
    }

    public final String b(CharSequence input, String replacement) {
        kotlin.jvm.internal.l.e(input, "input");
        kotlin.jvm.internal.l.e(replacement, "replacement");
        String replaceAll = this.a.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.l.d(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.a.toString();
        kotlin.jvm.internal.l.d(pattern, "nativePattern.toString()");
        return pattern;
    }

    public e(Pattern nativePattern) {
        kotlin.jvm.internal.l.e(nativePattern, "nativePattern");
        this.a = nativePattern;
    }
}
