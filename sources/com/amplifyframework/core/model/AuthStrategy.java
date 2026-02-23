package com.amplifyframework.core.model;

import j$.util.Objects;

/* JADX WARN: Enum visitor error
LL1ili1iI1iI.IIiLliI1l1li1: Init of enum field 'OWNER' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(Unknown Source:111)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(Unknown Source:90)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(Unknown Source:51)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(Unknown Source:47)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(Unknown Source:135)
	at jadx.core.dex.visitors.EnumVisitor.visit(Unknown Source:6)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthStrategy {
    private static final /* synthetic */ AuthStrategy[] $VALUES;
    public static final AuthStrategy CUSTOM;
    public static final AuthStrategy GROUPS;
    public static final AuthStrategy OWNER;
    public static final AuthStrategy PRIVATE;
    public static final AuthStrategy PUBLIC;
    private final Provider defaultAuthProvider;
    private final int priority;

    public enum Provider {
        FUNCTION("function", 1),
        USER_POOLS("userPools", 2),
        OIDC("oidc", 3),
        IAM("iam", 4),
        API_KEY("apiKey", 5);

        private final String authDirectiveProviderName;
        private final int priority;

        Provider(String str, int i) {
            this.authDirectiveProviderName = str;
            this.priority = i;
        }

        public static Provider from(String str) {
            Objects.requireNonNull(str);
            for (Provider provider : values()) {
                if (str.equals(provider.authDirectiveProviderName)) {
                    return provider;
                }
            }
            throw new IllegalArgumentException("Unable to find a matching auth strategy for " + str);
        }

        public String getAuthDirectiveProviderName() {
            return this.authDirectiveProviderName;
        }

        public int getPriority() {
            return this.priority;
        }
    }

    static {
        AuthStrategy authStrategy = new AuthStrategy("CUSTOM", 0, Provider.FUNCTION, 1);
        CUSTOM = authStrategy;
        Provider provider = Provider.USER_POOLS;
        AuthStrategy authStrategy2 = new AuthStrategy("OWNER", 1, provider, 2);
        OWNER = authStrategy2;
        AuthStrategy authStrategy3 = new AuthStrategy("GROUPS", 2, provider, 3);
        GROUPS = authStrategy3;
        AuthStrategy authStrategy4 = new AuthStrategy("PRIVATE", 3, provider, 4);
        PRIVATE = authStrategy4;
        AuthStrategy authStrategy5 = new AuthStrategy("PUBLIC", 4, Provider.API_KEY, 5);
        PUBLIC = authStrategy5;
        $VALUES = new AuthStrategy[]{authStrategy, authStrategy2, authStrategy3, authStrategy4, authStrategy5};
    }

    private AuthStrategy(String str, int i, Provider provider, int i2) {
        this.defaultAuthProvider = provider;
        this.priority = i2;
    }

    public static AuthStrategy valueOf(String str) {
        return (AuthStrategy) Enum.valueOf(AuthStrategy.class, str);
    }

    public static AuthStrategy[] values() {
        return (AuthStrategy[]) $VALUES.clone();
    }

    public Provider getDefaultAuthProvider() {
        return this.defaultAuthProvider;
    }

    public int getPriority() {
        return this.priority;
    }
}
