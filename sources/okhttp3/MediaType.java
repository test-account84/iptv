package okhttp3;

import B8.h;
import E8.n;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;

    @NotNull
    private final String subtype;

    @NotNull
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MediaType -deprecated_get(@NotNull String mediaType) {
            l.e(mediaType, "mediaType");
            return get(mediaType);
        }

        @Nullable
        public final MediaType -deprecated_parse(@NotNull String mediaType) {
            l.e(mediaType, "mediaType");
            return parse(mediaType);
        }

        @NotNull
        public final MediaType get(@NotNull String toMediaType) {
            l.e(toMediaType, "$this$toMediaType");
            Matcher matcher = MediaType.access$getTYPE_SUBTYPE$cp().matcher(toMediaType);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
            }
            String group = matcher.group(1);
            l.d(group, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            l.d(locale, "Locale.US");
            if (group == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = group.toLowerCase(locale);
            l.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String group2 = matcher.group(2);
            l.d(group2, "typeSubtype.group(2)");
            l.d(locale, "Locale.US");
            if (group2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = group2.toLowerCase(locale);
            l.d(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.access$getPARAMETER$cp().matcher(toMediaType);
            for (int end = matcher.end(); end < toMediaType.length(); end = matcher2.end()) {
                matcher2.region(end, toMediaType.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter is not formatted correctly: \"");
                    String substring = toMediaType.substring(end);
                    l.d(substring, "(this as java.lang.String).substring(startIndex)");
                    sb.append(substring);
                    sb.append("\" for: \"");
                    sb.append(toMediaType);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String group3 = matcher2.group(1);
                if (group3 != null) {
                    String group4 = matcher2.group(2);
                    if (group4 == null) {
                        group4 = matcher2.group(3);
                    } else if (n.B(group4, "'", false, 2, null) && n.n(group4, "'", false, 2, null) && group4.length() > 2) {
                        group4 = group4.substring(1, group4.length() - 1);
                        l.d(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(group3);
                    arrayList.add(group4);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new MediaType(toMediaType, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        @Nullable
        public final MediaType parse(@NotNull String toMediaTypeOrNull) {
            l.e(toMediaTypeOrNull, "$this$toMediaTypeOrNull");
            try {
                return get(toMediaTypeOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static final /* synthetic */ Pattern access$getPARAMETER$cp() {
        return PARAMETER;
    }

    public static final /* synthetic */ Pattern access$getTYPE_SUBTYPE$cp() {
        return TYPE_SUBTYPE;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    @NotNull
    public static final MediaType get(@NotNull String str) {
        return Companion.get(str);
    }

    @Nullable
    public static final MediaType parse(@NotNull String str) {
        return Companion.parse(str);
    }

    @NotNull
    public final String -deprecated_subtype() {
        return this.subtype;
    }

    @NotNull
    public final String -deprecated_type() {
        return this.type;
    }

    @Nullable
    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof MediaType) && l.a(((MediaType) obj).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    @Nullable
    public final String parameter(@NotNull String name) {
        l.e(name, "name");
        B8.a l = h.l(l8.h.q(this.parameterNamesAndValues), 2);
        int d = l.d();
        int f = l.f();
        int g = l.g();
        if (g >= 0) {
            if (d > f) {
                return null;
            }
        } else if (d < f) {
            return null;
        }
        while (!n.o(this.parameterNamesAndValues[d], name, true)) {
            if (d == f) {
                return null;
            }
            d += g;
        }
        return this.parameterNamesAndValues[d + 1];
    }

    @NotNull
    public final String subtype() {
        return this.subtype;
    }

    @NotNull
    public String toString() {
        return this.mediaType;
    }

    @NotNull
    public final String type() {
        return this.type;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, g gVar) {
        this(str, str2, str3, strArr);
    }

    @Nullable
    public final Charset charset(@Nullable Charset charset) {
        String parameter = parameter("charset");
        if (parameter == null) {
            return charset;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
