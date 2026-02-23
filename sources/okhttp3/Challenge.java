package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.l;
import l8.B;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Challenge {

    @NotNull
    private final Map authParams;

    @NotNull
    private final String scheme;

    /* JADX WARN: Illegal instructions before constructor call */
    public Challenge(@NotNull String scheme, @NotNull String realm) {
        l.e(scheme, "scheme");
        l.e(realm, "realm");
        Map singletonMap = Collections.singletonMap("realm", realm);
        l.d(singletonMap, "singletonMap(\"realm\", realm)");
        this(scheme, singletonMap);
    }

    @NotNull
    public final Map -deprecated_authParams() {
        return this.authParams;
    }

    @NotNull
    public final Charset -deprecated_charset() {
        return charset();
    }

    @Nullable
    public final String -deprecated_realm() {
        return realm();
    }

    @NotNull
    public final String -deprecated_scheme() {
        return this.scheme;
    }

    @NotNull
    public final Map authParams() {
        return this.authParams;
    }

    @NotNull
    public final Charset charset() {
        String str = (String) this.authParams.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                l.d(forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        l.d(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (l.a(challenge.scheme, this.scheme) && l.a(challenge.authParams, this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    @Nullable
    public final String realm() {
        return (String) this.authParams.get("realm");
    }

    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    @NotNull
    public final Challenge withCharset(@NotNull Charset charset) {
        l.e(charset, "charset");
        Map n = B.n(this.authParams);
        String name = charset.name();
        l.d(name, "charset.name()");
        n.put("charset", name);
        return new Challenge(this.scheme, n);
    }

    public Challenge(@NotNull String scheme, @NotNull Map authParams) {
        String str;
        l.e(scheme, "scheme");
        l.e(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : authParams.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (str2 != null) {
                Locale US = Locale.US;
                l.d(US, "US");
                str = str2.toLowerCase(US);
                l.d(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            linkedHashMap.put(str, str3);
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        l.d(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }
}
