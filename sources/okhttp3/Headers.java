package okhttp3;

import B8.h;
import E8.n;
import E8.o;
import j$.time.Instant;
import j$.util.DateRetargetClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import k8.i;
import k8.m;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import l8.k;
import l8.p;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Headers implements Iterable, x8.a {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    public static final class Builder {

        @NotNull
        private final List namesAndValues = new ArrayList(20);

        @NotNull
        public final Builder add(@NotNull String line) {
            l.e(line, "line");
            int Q = o.Q(line, ':', 0, false, 6, null);
            if (!(Q != -1)) {
                throw new IllegalArgumentException(("Unexpected header: " + line).toString());
            }
            String substring = line.substring(0, Q);
            l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String obj = o.D0(substring).toString();
            String substring2 = line.substring(Q + 1);
            l.d(substring2, "(this as java.lang.String).substring(startIndex)");
            add(obj, substring2);
            return this;
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            l.e(headers, "headers");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                addLenient$okhttp(headers.name(i), headers.value(i));
            }
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String line) {
            l.e(line, "line");
            int Q = o.Q(line, ':', 1, false, 4, null);
            if (Q != -1) {
                String substring = line.substring(0, Q);
                l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = line.substring(Q + 1);
                l.d(substring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else {
                if (line.charAt(0) == ':') {
                    line = line.substring(1);
                    l.d(line, "(this as java.lang.String).substring(startIndex)");
                }
                addLenient$okhttp("", line);
            }
            return this;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            Companion.access$checkName(Headers.Companion, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        @Nullable
        public final String get(@NotNull String name) {
            l.e(name, "name");
            B8.a l = h.l(h.j(this.namesAndValues.size() - 2, 0), 2);
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
            while (!n.o(name, (String) this.namesAndValues.get(d), true)) {
                if (d == f) {
                    return null;
                }
                d += g;
            }
            return (String) this.namesAndValues.get(d + 1);
        }

        @NotNull
        public final List getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String name) {
            l.e(name, "name");
            int i = 0;
            while (i < this.namesAndValues.size()) {
                if (n.o(name, (String) this.namesAndValues.get(i), true)) {
                    this.namesAndValues.remove(i);
                    this.namesAndValues.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            Companion companion = Headers.Companion;
            Companion.access$checkName(companion, name);
            Companion.access$checkValue(companion, value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            Companion companion = Headers.Companion;
            Companion.access$checkName(companion, name);
            Companion.access$checkValue(companion, value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String name, @NotNull String value) {
            l.e(name, "name");
            l.e(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(o.D0(value).toString());
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String name, @NotNull Instant value) {
            l.e(name, "name");
            l.e(value, "value");
            return set(name, new Date(value.toEpochMilli()));
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String name, @NotNull Instant value) {
            l.e(name, "name");
            l.e(value, "value");
            add(name, new Date(value.toEpochMilli()));
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Date value) {
            l.e(name, "name");
            l.e(value, "value");
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Date value) {
            l.e(name, "name");
            l.e(value, "value");
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$checkName(Companion companion, String str) {
            companion.checkName(str);
        }

        public static final /* synthetic */ void access$checkValue(Companion companion, String str, String str2) {
            companion.checkValue(str, str2);
        }

        public static final /* synthetic */ String access$get(Companion companion, String[] strArr, String str) {
            return companion.get(strArr, str);
        }

        private final void checkName(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (!('!' <= charAt && '~' >= charAt)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        private final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (!(charAt == '\t' || (' ' <= charAt && '~' >= charAt))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i), str2));
                    sb.append(Util.isSensitiveHeader(str2) ? "" : ": " + str);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        private final String get(String[] strArr, String str) {
            B8.a l = h.l(h.j(strArr.length - 2, 0), 2);
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
            while (!n.o(str, strArr[d], true)) {
                if (d == f) {
                    return null;
                }
                d += g;
            }
            return strArr[d + 1];
        }

        @NotNull
        public final Headers -deprecated_of(@NotNull Map headers) {
            l.e(headers, "headers");
            return of(headers);
        }

        @NotNull
        public final Headers of(@NotNull Map toHeaders) {
            l.e(toHeaders, "$this$toHeaders");
            String[] strArr = new String[toHeaders.size() * 2];
            int i = 0;
            for (Map.Entry entry : toHeaders.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj = o.D0(str).toString();
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj2 = o.D0(str2).toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i] = obj;
                strArr[i + 1] = obj2;
                i += 2;
            }
            return new Headers(strArr, null);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @NotNull
        public final Headers -deprecated_of(@NotNull String... namesAndValues) {
            l.e(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @NotNull
        public final Headers of(@NotNull String... namesAndValues) {
            l.e(namesAndValues, "namesAndValues");
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object clone = namesAndValues.clone();
            if (clone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            CharSequence[] charSequenceArr = (String[]) clone;
            int length = charSequenceArr.length;
            for (int i = 0; i < length; i++) {
                CharSequence charSequence = charSequenceArr[i];
                if (!(charSequence != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                if (charSequence == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                charSequenceArr[i] = o.D0(charSequence).toString();
            }
            B8.a l = h.l(l8.h.q(charSequenceArr), 2);
            int d = l.d();
            int f = l.f();
            int g = l.g();
            if (g < 0 ? d >= f : d <= f) {
                while (true) {
                    CharSequence charSequence2 = charSequenceArr[d];
                    CharSequence charSequence3 = charSequenceArr[d + 1];
                    checkName(charSequence2);
                    checkValue(charSequence3, charSequence2);
                    if (d == f) {
                        break;
                    }
                    d += g;
                }
            }
            return new Headers(charSequenceArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @NotNull
    public static final Headers of(@NotNull Map map) {
        return Companion.of(map);
    }

    public final int -deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i = 0; i < strArr.length; i++) {
            length += this.namesAndValues[i].length();
        }
        return length;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    @Nullable
    public final String get(@NotNull String name) {
        l.e(name, "name");
        return Companion.access$get(Companion, this.namesAndValues, name);
    }

    @Nullable
    public final Date getDate(@NotNull String name) {
        l.e(name, "name");
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String name) {
        l.e(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return DateRetargetClass.toInstant(date);
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @NotNull
    public Iterator iterator() {
        int size = size();
        i[] iVarArr = new i[size];
        for (int i = 0; i < size; i++) {
            iVarArr[i] = m.a(name(i), value(i));
        }
        return b.a(iVarArr);
    }

    @NotNull
    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    @NotNull
    public final Set names() {
        TreeSet treeSet = new TreeSet(n.p(E.a));
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        Set unmodifiableSet = Collections.unmodifiableSet(treeSet);
        l.d(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        p.r(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @NotNull
    public final Map toMultimap() {
        TreeMap treeMap = new TreeMap(n.p(E.a));
        int size = size();
        for (int i = 0; i < size; i++) {
            String name = name(i);
            Locale locale = Locale.US;
            l.d(locale, "Locale.US");
            if (name == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = name.toLowerCase(locale);
            l.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i));
        }
        return treeMap;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String name = name(i);
            String value = value(i);
            sb.append(name);
            sb.append(": ");
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        l.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    @NotNull
    public final List values(@NotNull String name) {
        l.e(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (n.o(name, name(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i));
            }
        }
        if (arrayList == null) {
            return k.f();
        }
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        l.d(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    public /* synthetic */ Headers(String[] strArr, g gVar) {
        this(strArr);
    }

    @NotNull
    public static final Headers of(@NotNull String... strArr) {
        return Companion.of(strArr);
    }
}
