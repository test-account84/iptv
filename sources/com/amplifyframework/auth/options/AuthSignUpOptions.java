package com.amplifyframework.auth.options;

import O.c;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthSignUpOptions {
    private final List userAttributes;

    public static abstract class Builder {
        private AuthUserAttribute singleUserAttribute;
        private final List userAttributes = new ArrayList();

        public AuthSignUpOptions build() {
            return new AuthSignUpOptions(Immutable.of(getUserAttributes()));
        }

        public abstract Builder getThis();

        public List getUserAttributes() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.userAttributes);
            AuthUserAttribute authUserAttribute = this.singleUserAttribute;
            if (authUserAttribute != null && !arrayList.contains(authUserAttribute)) {
                arrayList.add(this.singleUserAttribute);
            }
            return arrayList;
        }

        public Builder userAttribute(AuthUserAttributeKey authUserAttributeKey, String str) {
            Objects.requireNonNull(authUserAttributeKey);
            Objects.requireNonNull(str);
            this.singleUserAttribute = new AuthUserAttribute(authUserAttributeKey, str);
            return getThis();
        }

        public Builder userAttributes(List list) {
            Objects.requireNonNull(list);
            this.userAttributes.clear();
            this.userAttributes.addAll(list);
            return getThis();
        }
    }

    public static final class CoreBuilder extends Builder {
        public CoreBuilder getThis() {
            return this;
        }
    }

    public AuthSignUpOptions(List list) {
        this.userAttributes = list;
    }

    public static Builder builder() {
        return new CoreBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(getUserAttributes(), ((AuthSignUpOptions) obj).getUserAttributes());
    }

    public List getUserAttributes() {
        return this.userAttributes;
    }

    public int hashCode() {
        return c.b(getUserAttributes());
    }

    public String toString() {
        return "AuthSignUpOptions{userAttributes=" + this.userAttributes + '}';
    }
}
