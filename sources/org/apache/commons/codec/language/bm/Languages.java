package org.apache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Languages {
    public static final String ANY = "any";
    public static final LanguageSet ANY_LANGUAGE;
    private static final Map LANGUAGES = new EnumMap(NameType.class);
    public static final LanguageSet NO_LANGUAGES;
    private final Set languages;

    public static class 1 extends LanguageSet {
        public boolean contains(String str) {
            return false;
        }

        public String getAny() {
            throw new NoSuchElementException("Can't fetch any language from the empty language set.");
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean isSingleton() {
            return false;
        }

        public LanguageSet merge(LanguageSet languageSet) {
            return languageSet;
        }

        public LanguageSet restrictTo(LanguageSet languageSet) {
            return this;
        }

        public String toString() {
            return "NO_LANGUAGES";
        }
    }

    public static class 2 extends LanguageSet {
        public boolean contains(String str) {
            return true;
        }

        public String getAny() {
            throw new NoSuchElementException("Can't fetch any language from the any language set.");
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean isSingleton() {
            return false;
        }

        public LanguageSet merge(LanguageSet languageSet) {
            return languageSet;
        }

        public LanguageSet restrictTo(LanguageSet languageSet) {
            return languageSet;
        }

        public String toString() {
            return "ANY_LANGUAGE";
        }
    }

    public static abstract class LanguageSet {
        public static LanguageSet from(Set set) {
            return set.isEmpty() ? Languages.NO_LANGUAGES : new SomeLanguages(set, null);
        }

        public abstract boolean contains(String str);

        public abstract String getAny();

        public abstract boolean isEmpty();

        public abstract boolean isSingleton();

        public abstract LanguageSet merge(LanguageSet languageSet);

        public abstract LanguageSet restrictTo(LanguageSet languageSet);
    }

    public static final class SomeLanguages extends LanguageSet {
        private final Set languages;

        private SomeLanguages(Set set) {
            this.languages = Collections.unmodifiableSet(set);
        }

        public boolean contains(String str) {
            return this.languages.contains(str);
        }

        public String getAny() {
            return (String) this.languages.iterator().next();
        }

        public Set getLanguages() {
            return this.languages;
        }

        public boolean isEmpty() {
            return this.languages.isEmpty();
        }

        public boolean isSingleton() {
            return this.languages.size() == 1;
        }

        public LanguageSet merge(LanguageSet languageSet) {
            if (languageSet == Languages.NO_LANGUAGES) {
                return this;
            }
            if (languageSet == Languages.ANY_LANGUAGE) {
                return languageSet;
            }
            HashSet hashSet = new HashSet(this.languages);
            Iterator it = ((SomeLanguages) languageSet).languages.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            return LanguageSet.from(hashSet);
        }

        public LanguageSet restrictTo(LanguageSet languageSet) {
            if (languageSet == Languages.NO_LANGUAGES) {
                return languageSet;
            }
            if (languageSet == Languages.ANY_LANGUAGE) {
                return this;
            }
            SomeLanguages someLanguages = (SomeLanguages) languageSet;
            HashSet hashSet = new HashSet(Math.min(this.languages.size(), someLanguages.languages.size()));
            for (String str : this.languages) {
                if (someLanguages.languages.contains(str)) {
                    hashSet.add(str);
                }
            }
            return LanguageSet.from(hashSet);
        }

        public String toString() {
            return "Languages(" + this.languages.toString() + ")";
        }

        public /* synthetic */ SomeLanguages(Set set, 1 r2) {
            this(set);
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            LANGUAGES.put(nameType, getInstance(langResourceName(nameType)));
        }
        NO_LANGUAGES = new 1();
        ANY_LANGUAGE = new 2();
    }

    private Languages(Set set) {
        this.languages = set;
    }

    public static Languages getInstance(String str) {
        HashSet hashSet = new HashSet();
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalArgumentException("Unable to resolve required resource: " + str);
        }
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                try {
                    String trim = scanner.nextLine().trim();
                    if (z) {
                        if (trim.endsWith("*/")) {
                            break;
                        }
                    } else if (trim.startsWith("/*")) {
                        z = true;
                    } else if (trim.length() > 0) {
                        hashSet.add(trim);
                    }
                } catch (Throwable th) {
                    scanner.close();
                    throw th;
                }
            }
            scanner.close();
            return new Languages(Collections.unmodifiableSet(hashSet));
        }
    }

    private static String langResourceName(NameType nameType) {
        return String.format("org/apache/commons/codec/language/bm/%s_languages.txt", new Object[]{nameType.getName()});
    }

    public Set getLanguages() {
        return this.languages;
    }

    public static Languages getInstance(NameType nameType) {
        return (Languages) LANGUAGES.get(nameType);
    }
}
