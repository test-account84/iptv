package org.apache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.Languages;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Lang {
    private static final String LANGUAGE_RULES_RN = "org/apache/commons/codec/language/bm/%s_lang.txt";
    private static final Map Langs = new EnumMap(NameType.class);
    private final Languages languages;
    private final List rules;

    public static final class LangRule {
        private final boolean acceptOnMatch;
        private final Set languages;
        private final Pattern pattern;

        private LangRule(Pattern pattern, Set set, boolean z) {
            this.pattern = pattern;
            this.languages = set;
            this.acceptOnMatch = z;
        }

        public static /* synthetic */ boolean access$100(LangRule langRule) {
            return langRule.acceptOnMatch;
        }

        public static /* synthetic */ Set access$200(LangRule langRule) {
            return langRule.languages;
        }

        public boolean matches(String str) {
            return this.pattern.matcher(str).find();
        }

        public /* synthetic */ LangRule(Pattern pattern, Set set, boolean z, 1 r4) {
            this(pattern, set, z);
        }
    }

    static {
        for (NameType nameType : NameType.values()) {
            Langs.put(nameType, loadFromResource(String.format("org/apache/commons/codec/language/bm/%s_lang.txt", new Object[]{nameType.getName()}), Languages.getInstance(nameType)));
        }
    }

    private Lang(List list, Languages languages) {
        this.rules = Collections.unmodifiableList(list);
        this.languages = languages;
    }

    public static Lang instance(NameType nameType) {
        return (Lang) Langs.get(nameType);
    }

    public static Lang loadFromResource(String str, Languages languages) {
        ArrayList arrayList = new ArrayList();
        InputStream resourceAsStream = Lang.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/%s_lang.txt");
        }
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                try {
                    String nextLine = scanner.nextLine();
                    if (z) {
                        if (nextLine.endsWith("*/")) {
                            break;
                        }
                    } else if (nextLine.startsWith("/*")) {
                        z = true;
                    } else {
                        int indexOf = nextLine.indexOf("//");
                        String trim = (indexOf >= 0 ? nextLine.substring(0, indexOf) : nextLine).trim();
                        if (trim.length() != 0) {
                            String[] split = trim.split("\\s+");
                            if (split.length != 3) {
                                throw new IllegalArgumentException("Malformed line '" + nextLine + "' in language resource '" + str + "'");
                            }
                            arrayList.add(new LangRule(Pattern.compile(split[0]), new HashSet(Arrays.asList(split[1].split("\\+"))), split[2].equals("true"), null));
                        }
                    }
                } catch (Throwable th) {
                    scanner.close();
                    throw th;
                }
            }
            scanner.close();
            return new Lang(arrayList, languages);
        }
    }

    public String guessLanguage(String str) {
        Languages.LanguageSet guessLanguages = guessLanguages(str);
        return guessLanguages.isSingleton() ? guessLanguages.getAny() : "any";
    }

    public Languages.LanguageSet guessLanguages(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.languages.getLanguages());
        for (LangRule langRule : this.rules) {
            if (langRule.matches(lowerCase)) {
                boolean access$100 = LangRule.access$100(langRule);
                Set access$200 = LangRule.access$200(langRule);
                if (access$100) {
                    hashSet.retainAll(access$200);
                } else {
                    hashSet.removeAll(access$200);
                }
            }
        }
        Languages.LanguageSet from = Languages.LanguageSet.from(hashSet);
        return from.equals(Languages.NO_LANGUAGES) ? Languages.ANY_LANGUAGE : from;
    }
}
