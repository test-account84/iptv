package com.google.android.recaptcha;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class RecaptchaAction {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final RecaptchaAction LOGIN = new RecaptchaAction("login");

    @NotNull
    public static final RecaptchaAction SIGNUP = new RecaptchaAction("signup");

    @NotNull
    private final String action;

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final RecaptchaAction custom(String str) {
            return new RecaptchaAction(str, null);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    private RecaptchaAction(String str) {
        this.action = str;
    }

    public static /* synthetic */ RecaptchaAction copy$default(RecaptchaAction recaptchaAction, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recaptchaAction.action;
        }
        return recaptchaAction.copy(str);
    }

    @NotNull
    public static final RecaptchaAction custom(String str) {
        return Companion.custom(str);
    }

    @NotNull
    public final String component1() {
        return this.action;
    }

    @NotNull
    public final RecaptchaAction copy(String str) {
        return new RecaptchaAction(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecaptchaAction) && l.a(this.action, ((RecaptchaAction) obj).action);
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    public int hashCode() {
        return this.action.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecaptchaAction(action=" + this.action + ")";
    }

    public /* synthetic */ RecaptchaAction(String str, g gVar) {
        this(str);
    }
}
