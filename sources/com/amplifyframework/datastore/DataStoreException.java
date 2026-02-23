package com.amplifyframework.datastore;

import O.c;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DataStoreException extends AmplifyException {
    private static final long serialVersionUID = 1;

    public static final class GraphQLResponseException extends DataStoreException {
        private static final long serialVersionUID = 1;
        private final List errors;

        public GraphQLResponseException(String str, List list) {
            super(str, "See attached list of GraphQLResponse.Error objects.");
            Objects.requireNonNull(list);
            this.errors = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && GraphQLResponseException.class == obj.getClass() && super.equals(obj)) {
                return c.a(this.errors, ((GraphQLResponseException) obj).errors);
            }
            return false;
        }

        public List getErrors() {
            return Immutable.of(this.errors);
        }

        public int hashCode() {
            return c.b(Integer.valueOf(super.hashCode()), this.errors);
        }

        public String toString() {
            return "GraphQLResponseException{message=" + getMessage() + ", errors=" + this.errors + ", recoverySuggestion=" + getRecoverySuggestion() + '}';
        }
    }

    public static class IrRecoverableException extends DataStoreException {
        private static final long serialVersionUID = 1;

        public IrRecoverableException(@NotNull String str, @NotNull String str2) {
            super(str, str2);
        }
    }

    public DataStoreException(String str, String str2) {
        super(str, str2);
    }

    public DataStoreException(String str, Throwable th, String str2) {
        super(str, th, str2);
    }
}
