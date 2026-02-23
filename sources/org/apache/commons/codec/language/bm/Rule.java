package org.apache.commons.codec.language.bm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.Languages;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Rule {
    public static final String ALL = "ALL";
    private static final String DOUBLE_QUOTE = "\"";
    private static final String HASH_INCLUDE = "#include";
    private final RPattern lContext;
    private final String pattern;
    private final PhonemeExpr phoneme;
    private final RPattern rContext;
    public static final RPattern ALL_STRINGS_RMATCHER = new 1();
    private static final Map RULES = new EnumMap(NameType.class);

    public static class 1 implements RPattern {
        public boolean isMatch(CharSequence charSequence) {
            return true;
        }
    }

    public static class 10 implements RPattern {
        Pattern pattern;
        final /* synthetic */ String val$regex;

        public 10(String str) {
            this.val$regex = str;
            this.pattern = Pattern.compile(str);
        }

        public boolean isMatch(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).find();
        }
    }

    public static class 2 extends Rule {
        private final String loc;
        private final int myLine;
        final /* synthetic */ int val$cLine;
        final /* synthetic */ String val$lCon;
        final /* synthetic */ String val$location;
        final /* synthetic */ String val$pat;
        final /* synthetic */ String val$rCon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 2(String str, String str2, String str3, PhonemeExpr phonemeExpr, int i, String str4, String str5, String str6, String str7) {
            super(str, str2, str3, phonemeExpr);
            this.val$cLine = i;
            this.val$location = str4;
            this.val$pat = str5;
            this.val$lCon = str6;
            this.val$rCon = str7;
            this.myLine = i;
            this.loc = str4;
        }

        public String toString() {
            return "Rule{line=" + this.myLine + ", loc='" + this.loc + "', pat='" + this.val$pat + "', lcon='" + this.val$lCon + "', rcon='" + this.val$rCon + "'}";
        }
    }

    public static class 3 implements RPattern {
        public boolean isMatch(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    public static class 4 implements RPattern {
        final /* synthetic */ String val$content;

        public 4(String str) {
            this.val$content = str;
        }

        public boolean isMatch(CharSequence charSequence) {
            return charSequence.equals(this.val$content);
        }
    }

    public static class 5 implements RPattern {
        final /* synthetic */ String val$content;

        public 5(String str) {
            this.val$content = str;
        }

        public boolean isMatch(CharSequence charSequence) {
            return Rule.access$100(charSequence, this.val$content);
        }
    }

    public static class 6 implements RPattern {
        final /* synthetic */ String val$content;

        public 6(String str) {
            this.val$content = str;
        }

        public boolean isMatch(CharSequence charSequence) {
            return Rule.access$200(charSequence, this.val$content);
        }
    }

    public static class 7 implements RPattern {
        final /* synthetic */ String val$bContent;
        final /* synthetic */ boolean val$shouldMatch;

        public 7(String str, boolean z) {
            this.val$bContent = str;
            this.val$shouldMatch = z;
        }

        public boolean isMatch(CharSequence charSequence) {
            return charSequence.length() == 1 && Rule.access$300(this.val$bContent, charSequence.charAt(0)) == this.val$shouldMatch;
        }
    }

    public static class 8 implements RPattern {
        final /* synthetic */ String val$bContent;
        final /* synthetic */ boolean val$shouldMatch;

        public 8(String str, boolean z) {
            this.val$bContent = str;
            this.val$shouldMatch = z;
        }

        public boolean isMatch(CharSequence charSequence) {
            return charSequence.length() > 0 && Rule.access$300(this.val$bContent, charSequence.charAt(0)) == this.val$shouldMatch;
        }
    }

    public static class 9 implements RPattern {
        final /* synthetic */ String val$bContent;
        final /* synthetic */ boolean val$shouldMatch;

        public 9(String str, boolean z) {
            this.val$bContent = str;
            this.val$shouldMatch = z;
        }

        public boolean isMatch(CharSequence charSequence) {
            return charSequence.length() > 0 && Rule.access$300(this.val$bContent, charSequence.charAt(charSequence.length() - 1)) == this.val$shouldMatch;
        }
    }

    public static final class Phoneme implements PhonemeExpr {
        public static final Comparator COMPARATOR = new 1();
        private final Languages.LanguageSet languages;
        private final StringBuilder phonemeText;

        public static class 1 implements Comparator {
            public int compare(Phoneme phoneme, Phoneme phoneme2) {
                for (int i = 0; i < Phoneme.access$000(phoneme).length(); i++) {
                    if (i >= Phoneme.access$000(phoneme2).length()) {
                        return 1;
                    }
                    int charAt = Phoneme.access$000(phoneme).charAt(i) - Phoneme.access$000(phoneme2).charAt(i);
                    if (charAt != 0) {
                        return charAt;
                    }
                }
                return Phoneme.access$000(phoneme).length() < Phoneme.access$000(phoneme2).length() ? -1 : 0;
            }
        }

        public Phoneme(CharSequence charSequence, Languages.LanguageSet languageSet) {
            this.phonemeText = new StringBuilder(charSequence);
            this.languages = languageSet;
        }

        public static /* synthetic */ StringBuilder access$000(Phoneme phoneme) {
            return phoneme.phonemeText;
        }

        public Phoneme append(CharSequence charSequence) {
            this.phonemeText.append(charSequence);
            return this;
        }

        public Languages.LanguageSet getLanguages() {
            return this.languages;
        }

        public CharSequence getPhonemeText() {
            return this.phonemeText;
        }

        public Iterable getPhonemes() {
            return Collections.singleton(this);
        }

        @Deprecated
        public Phoneme join(Phoneme phoneme) {
            return new Phoneme((CharSequence) (this.phonemeText.toString() + phoneme.phonemeText.toString()), this.languages.restrictTo(phoneme.languages));
        }

        public Phoneme mergeWithLanguage(Languages.LanguageSet languageSet) {
            return new Phoneme((CharSequence) this.phonemeText.toString(), this.languages.merge(languageSet));
        }

        public String toString() {
            return this.phonemeText.toString() + "[" + this.languages + "]";
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2) {
            this((CharSequence) phoneme.phonemeText, phoneme.languages);
            this.phonemeText.append(phoneme2.phonemeText);
        }

        public Phoneme(Phoneme phoneme, Phoneme phoneme2, Languages.LanguageSet languageSet) {
            this((CharSequence) phoneme.phonemeText, languageSet);
            this.phonemeText.append(phoneme2.phonemeText);
        }
    }

    public interface PhonemeExpr {
        Iterable getPhonemes();
    }

    public static final class PhonemeList implements PhonemeExpr {
        private final List phonemes;

        public PhonemeList(List list) {
            this.phonemes = list;
        }

        public List getPhonemes() {
            return this.phonemes;
        }
    }

    public interface RPattern {
        boolean isMatch(CharSequence charSequence);
    }

    static {
        for (NameType nameType : NameType.values()) {
            EnumMap enumMap = new EnumMap(RuleType.class);
            for (RuleType ruleType : RuleType.values()) {
                HashMap hashMap = new HashMap();
                for (String str : Languages.getInstance(nameType).getLanguages()) {
                    try {
                        hashMap.put(str, parseRules(createScanner(nameType, ruleType, str), createResourceName(nameType, ruleType, str)));
                    } catch (IllegalStateException e) {
                        throw new IllegalStateException("Problem processing " + createResourceName(nameType, ruleType, str), e);
                    }
                }
                if (!ruleType.equals(RuleType.RULES)) {
                    hashMap.put("common", parseRules(createScanner(nameType, ruleType, "common"), createResourceName(nameType, ruleType, "common")));
                }
                enumMap.put(ruleType, Collections.unmodifiableMap(hashMap));
            }
            RULES.put(nameType, Collections.unmodifiableMap(enumMap));
        }
    }

    public Rule(String str, String str2, String str3, PhonemeExpr phonemeExpr) {
        this.pattern = str;
        this.lContext = pattern(str2 + "$");
        this.rContext = pattern("^" + str3);
        this.phoneme = phonemeExpr;
    }

    public static /* synthetic */ boolean access$100(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2);
    }

    public static /* synthetic */ boolean access$200(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2);
    }

    public static /* synthetic */ boolean access$300(CharSequence charSequence, char c) {
        return contains(charSequence, c);
    }

    private static boolean contains(CharSequence charSequence, char c) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    private static String createResourceName(NameType nameType, RuleType ruleType, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", new Object[]{nameType.getName(), ruleType.getName(), str});
    }

    private static Scanner createScanner(String str) {
        String format = String.format("org/apache/commons/codec/language/bm/%s.txt", new Object[]{str});
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(format);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + format);
    }

    private static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        for (int length2 = charSequence2.length() - 1; length2 >= 0; length2--) {
            if (charSequence.charAt(length) != charSequence2.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    public static List getInstance(NameType nameType, RuleType ruleType, String str) {
        return getInstance(nameType, ruleType, Languages.LanguageSet.from(new HashSet(Arrays.asList(new String[]{str}))));
    }

    public static Map getInstanceMap(NameType nameType, RuleType ruleType, String str) {
        Map map = (Map) ((Map) ((Map) RULES.get(nameType)).get(ruleType)).get(str);
        if (map != null) {
            return map;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", new Object[]{nameType.getName(), ruleType.getName(), str}));
    }

    private static Phoneme parsePhoneme(String str) {
        int indexOf = str.indexOf("[");
        if (indexOf < 0) {
            return new Phoneme((CharSequence) str, Languages.ANY_LANGUAGE);
        }
        if (str.endsWith("]")) {
            return new Phoneme((CharSequence) str.substring(0, indexOf), Languages.LanguageSet.from(new HashSet(Arrays.asList(str.substring(indexOf + 1, str.length() - 1).split("[+]")))));
        }
        throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
    }

    private static PhonemeExpr parsePhonemeExpr(String str) {
        if (!str.startsWith("(")) {
            return parsePhoneme(str);
        }
        if (!str.endsWith(")")) {
            throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
        }
        ArrayList arrayList = new ArrayList();
        String substring = str.substring(1, str.length() - 1);
        for (String str2 : substring.split("[|]")) {
            arrayList.add(parsePhoneme(str2));
        }
        if (substring.startsWith("|") || substring.endsWith("|")) {
            arrayList.add(new Phoneme((CharSequence) "", Languages.ANY_LANGUAGE));
        }
        return new PhonemeList(arrayList);
    }

    private static Map parseRules(Scanner scanner, String str) {
        String str2;
        String stripQuotes;
        String stripQuotes2;
        String stripQuotes3;
        HashMap hashMap = new HashMap();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (scanner.hasNextLine()) {
            int i3 = i2 + 1;
            String nextLine = scanner.nextLine();
            if (z) {
                if (nextLine.endsWith("*/")) {
                    z = false;
                }
            } else if (nextLine.startsWith("/*")) {
                z = true;
            } else {
                int indexOf = nextLine.indexOf("//");
                String trim = (indexOf >= 0 ? nextLine.substring(i, indexOf) : nextLine).trim();
                if (trim.length() == 0) {
                    i2 = i3;
                } else if (trim.startsWith("#include")) {
                    String trim2 = trim.substring(8).trim();
                    if (trim2.contains(" ")) {
                        throw new IllegalArgumentException("Malformed import statement '" + nextLine + "' in " + str);
                    }
                    hashMap.putAll(parseRules(createScanner(trim2), str + "->" + trim2));
                } else {
                    String[] split = trim.split("\\s+");
                    if (split.length != 4) {
                        throw new IllegalArgumentException("Malformed rule statement split into " + split.length + " parts: " + nextLine + " in " + str);
                    }
                    try {
                        stripQuotes = stripQuotes(split[i]);
                        stripQuotes2 = stripQuotes(split[1]);
                        stripQuotes3 = stripQuotes(split[2]);
                        str2 = "' in ";
                    } catch (IllegalArgumentException e) {
                        e = e;
                        str2 = "' in ";
                    }
                    try {
                        2 r7 = new 2(stripQuotes, stripQuotes2, stripQuotes3, parsePhonemeExpr(stripQuotes(split[3])), i3, str, stripQuotes, stripQuotes2, stripQuotes3);
                        String substring = ((Rule) r7).pattern.substring(0, 1);
                        ArrayList arrayList = (List) hashMap.get(substring);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            hashMap.put(substring, arrayList);
                        }
                        arrayList.add(r7);
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        throw new IllegalStateException("Problem parsing line '" + i3 + str2 + str, e);
                    }
                }
            }
            i2 = i3;
            i = 0;
        }
        return hashMap;
    }

    private static RPattern pattern(String str) {
        boolean startsWith = str.startsWith("^");
        boolean endsWith = str.endsWith("$");
        int length = str.length();
        if (endsWith) {
            length--;
        }
        String substring = str.substring(startsWith ? 1 : 0, length);
        if (substring.contains("[")) {
            boolean startsWith2 = substring.startsWith("[");
            boolean endsWith2 = substring.endsWith("]");
            if (startsWith2 && endsWith2) {
                String substring2 = substring.substring(1, substring.length() - 1);
                if (!substring2.contains("[")) {
                    boolean startsWith3 = substring2.startsWith("^");
                    if (startsWith3) {
                        substring2 = substring2.substring(1);
                    }
                    boolean z = !startsWith3;
                    if (startsWith && endsWith) {
                        return new 7(substring2, z);
                    }
                    if (startsWith) {
                        return new 8(substring2, z);
                    }
                    if (endsWith) {
                        return new 9(substring2, z);
                    }
                }
            }
        } else {
            if (startsWith && endsWith) {
                return substring.length() == 0 ? new 3() : new 4(substring);
            }
            if ((startsWith || endsWith) && substring.length() == 0) {
                return ALL_STRINGS_RMATCHER;
            }
            if (startsWith) {
                return new 5(substring);
            }
            if (endsWith) {
                return new 6(substring);
            }
        }
        return new 10(str);
    }

    private static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i = 0; i < charSequence2.length(); i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static String stripQuotes(String str) {
        if (str.startsWith("\"")) {
            str = str.substring(1);
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }

    public RPattern getLContext() {
        return this.lContext;
    }

    public String getPattern() {
        return this.pattern;
    }

    public PhonemeExpr getPhoneme() {
        return this.phoneme;
    }

    public RPattern getRContext() {
        return this.rContext;
    }

    public boolean patternAndContextMatches(CharSequence charSequence, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
        }
        int length = this.pattern.length() + i;
        if (length <= charSequence.length() && charSequence.subSequence(i, length).equals(this.pattern) && this.rContext.isMatch(charSequence.subSequence(length, charSequence.length()))) {
            return this.lContext.isMatch(charSequence.subSequence(0, i));
        }
        return false;
    }

    private static Scanner createScanner(NameType nameType, RuleType ruleType, String str) {
        String createResourceName = createResourceName(nameType, ruleType, str);
        InputStream resourceAsStream = Languages.class.getClassLoader().getResourceAsStream(createResourceName);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + createResourceName);
    }

    public static List getInstance(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        Map instanceMap = getInstanceMap(nameType, ruleType, languageSet);
        ArrayList arrayList = new ArrayList();
        Iterator it = instanceMap.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll((List) it.next());
        }
        return arrayList;
    }

    public static Map getInstanceMap(NameType nameType, RuleType ruleType, Languages.LanguageSet languageSet) {
        return getInstanceMap(nameType, ruleType, languageSet.isSingleton() ? languageSet.getAny() : "any");
    }
}
