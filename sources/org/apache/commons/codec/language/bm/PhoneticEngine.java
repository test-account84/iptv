package org.apache.commons.codec.language.bm;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PhoneticEngine {
    private static final int DEFAULT_MAX_PHONEMES = 20;
    private static final Map NAME_PREFIXES;
    private final boolean concat;
    private final Lang lang;
    private final int maxPhonemes;
    private final NameType nameType;
    private final RuleType ruleType;

    public static /* synthetic */ class 1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$codec$language$bm$NameType;

        static {
            int[] iArr = new int[NameType.values().length];
            $SwitchMap$org$apache$commons$codec$language$bm$NameType = iArr;
            try {
                iArr[NameType.SEPHARDIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.ASHKENAZI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class PhonemeBuilder {
        private final Set phonemes;

        private PhonemeBuilder(Set set) {
            this.phonemes = set;
        }

        public static PhonemeBuilder empty(Languages.LanguageSet languageSet) {
            return new PhonemeBuilder(new Rule.Phoneme((CharSequence) "", languageSet));
        }

        public void append(CharSequence charSequence) {
            Iterator it = this.phonemes.iterator();
            while (it.hasNext()) {
                ((Rule.Phoneme) it.next()).append(charSequence);
            }
        }

        public void apply(Rule.PhonemeExpr phonemeExpr, int i) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(i);
            loop0: for (Rule.Phoneme phoneme : this.phonemes) {
                for (Rule.Phoneme phoneme2 : phonemeExpr.getPhonemes()) {
                    Languages.LanguageSet restrictTo = phoneme.getLanguages().restrictTo(phoneme2.getLanguages());
                    if (!restrictTo.isEmpty()) {
                        Rule.Phoneme phoneme3 = new Rule.Phoneme(phoneme, phoneme2, restrictTo);
                        if (linkedHashSet.size() < i) {
                            linkedHashSet.add(phoneme3);
                            if (linkedHashSet.size() >= i) {
                                break loop0;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            this.phonemes.clear();
            this.phonemes.addAll(linkedHashSet);
        }

        public Set getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            StringBuilder sb = new StringBuilder();
            for (Rule.Phoneme phoneme : this.phonemes) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(phoneme.getPhonemeText());
            }
            return sb.toString();
        }

        public /* synthetic */ PhonemeBuilder(Set set, 1 r2) {
            this(set);
        }

        private PhonemeBuilder(Rule.Phoneme phoneme) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.phonemes = linkedHashSet;
            linkedHashSet.add(phoneme);
        }
    }

    public static final class RulesApplication {
        private final Map finalRules;
        private boolean found;
        private int i;
        private final CharSequence input;
        private final int maxPhonemes;
        private PhonemeBuilder phonemeBuilder;

        public RulesApplication(Map map, CharSequence charSequence, PhonemeBuilder phonemeBuilder, int i, int i2) {
            if (map == null) {
                throw new NullPointerException("The finalRules argument must not be null");
            }
            this.finalRules = map;
            this.phonemeBuilder = phonemeBuilder;
            this.input = charSequence;
            this.i = i;
            this.maxPhonemes = i2;
        }

        public int getI() {
            return this.i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public RulesApplication invoke() {
            int i;
            this.found = false;
            Map map = this.finalRules;
            CharSequence charSequence = this.input;
            int i2 = this.i;
            List list = (List) map.get(charSequence.subSequence(i2, i2 + 1));
            if (list != null) {
                Iterator it = list.iterator();
                i = 1;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Rule rule = (Rule) it.next();
                    int length = rule.getPattern().length();
                    if (rule.patternAndContextMatches(this.input, this.i)) {
                        this.phonemeBuilder.apply(rule.getPhoneme(), this.maxPhonemes);
                        this.found = true;
                        i = length;
                        break;
                    }
                    i = length;
                }
            } else {
                i = 1;
            }
            this.i += this.found ? i : 1;
            return this;
        }

        public boolean isFound() {
            return this.found;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(NameType.class);
        NAME_PREFIXES = enumMap;
        enumMap.put(NameType.ASHKENAZI, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"bar", "ben", "da", "de", "van", "von"}))));
        enumMap.put(NameType.SEPHARDIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"}))));
        enumMap.put(NameType.GENERIC, Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", "dos", "du", "van", "von"}))));
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z) {
        this(nameType, ruleType, z, 20);
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, Map map) {
        if (map == null) {
            throw new NullPointerException("finalRules can not be null");
        }
        if (map.isEmpty()) {
            return phonemeBuilder;
        }
        TreeMap treeMap = new TreeMap(Rule.Phoneme.COMPARATOR);
        for (Rule.Phoneme phoneme : phonemeBuilder.getPhonemes()) {
            PhonemeBuilder empty = PhonemeBuilder.empty(phoneme.getLanguages());
            String charSequence = phoneme.getPhonemeText().toString();
            PhonemeBuilder phonemeBuilder2 = empty;
            int i = 0;
            while (i < charSequence.length()) {
                RulesApplication invoke = new RulesApplication(map, charSequence, phonemeBuilder2, i, this.maxPhonemes).invoke();
                boolean isFound = invoke.isFound();
                phonemeBuilder2 = invoke.getPhonemeBuilder();
                if (!isFound) {
                    phonemeBuilder2.append(charSequence.subSequence(i, i + 1));
                }
                i = invoke.getI();
            }
            for (Rule.Phoneme phoneme2 : phonemeBuilder2.getPhonemes()) {
                if (treeMap.containsKey(phoneme2)) {
                    phoneme2 = ((Rule.Phoneme) treeMap.remove(phoneme2)).mergeWithLanguage(phoneme2.getLanguages());
                }
                treeMap.put(phoneme2, phoneme2);
            }
        }
        return new PhonemeBuilder(treeMap.keySet(), null);
    }

    private static String join(Iterable iterable, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            sb.append((String) it.next());
        }
        while (it.hasNext()) {
            sb.append(str);
            sb.append((String) it.next());
        }
        return sb.toString();
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public Lang getLang() {
        return this.lang;
    }

    public int getMaxPhonemes() {
        return this.maxPhonemes;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }

    public PhoneticEngine(NameType nameType, RuleType ruleType, boolean z, int i) {
        RuleType ruleType2 = RuleType.RULES;
        if (ruleType == ruleType2) {
            throw new IllegalArgumentException("ruleType must not be " + ruleType2);
        }
        this.nameType = nameType;
        this.ruleType = ruleType;
        this.concat = z;
        this.lang = Lang.instance(nameType);
        this.maxPhonemes = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x017e A[LOOP:1: B:30:0x0178->B:32:0x017e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String encode(java.lang.String r14, org.apache.commons.codec.language.bm.Languages.LanguageSet r15) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.bm.PhoneticEngine.encode(java.lang.String, org.apache.commons.codec.language.bm.Languages$LanguageSet):java.lang.String");
    }
}
