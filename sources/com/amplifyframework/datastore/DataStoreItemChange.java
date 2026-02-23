package com.amplifyframework.datastore;

import android.annotation.SuppressLint;
import com.amplifyframework.core.model.Model;
import j$.util.Objects;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class DataStoreItemChange {
    private final Initiator initiator;
    private final Model item;
    private final Class itemClass;
    private final Type type;
    private final UUID uuid;

    public static final class Builder {
        private Initiator initiator;
        private Model item;
        private Class itemClass;
        private Type type;
        private UUID uuid;

        @SuppressLint({"SyntheticAccessor"})
        public DataStoreItemChange build() {
            UUID uuid = this.uuid;
            if (uuid == null) {
                uuid = UUID.randomUUID();
            }
            UUID uuid2 = uuid;
            randomUuid();
            Objects.requireNonNull(uuid2);
            Type type = this.type;
            Objects.requireNonNull(type);
            Model model = this.item;
            Objects.requireNonNull(model);
            Class cls = this.itemClass;
            Objects.requireNonNull(cls);
            Initiator initiator = this.initiator;
            Objects.requireNonNull(initiator);
            return new DataStoreItemChange(uuid2, type, model, cls, initiator, null);
        }

        public Builder initiator(Initiator initiator) {
            Objects.requireNonNull(initiator);
            this.initiator = initiator;
            return this;
        }

        public Builder item(Model model) {
            Objects.requireNonNull(model);
            this.item = model;
            return this;
        }

        public Builder itemClass(Class cls) {
            Objects.requireNonNull(cls);
            this.itemClass = cls;
            return this;
        }

        public Builder randomUuid() {
            this.uuid = null;
            return this;
        }

        public Builder type(Type type) {
            Objects.requireNonNull(type);
            this.type = type;
            return this;
        }

        public Builder uuid(String str) {
            Objects.requireNonNull(str);
            this.uuid = UUID.fromString(str);
            return this;
        }
    }

    public enum Initiator {
        LOCAL,
        REMOTE
    }

    public enum Type {
        CREATE,
        UPDATE,
        DELETE
    }

    private DataStoreItemChange(UUID uuid, Type type, Model model, Class cls, Initiator initiator) {
        this.uuid = uuid;
        this.type = type;
        this.item = model;
        this.itemClass = cls;
        this.initiator = initiator;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DataStoreItemChange.class != obj.getClass()) {
            return false;
        }
        DataStoreItemChange dataStoreItemChange = (DataStoreItemChange) obj;
        return this.uuid.equals(dataStoreItemChange.uuid) && this.type == dataStoreItemChange.type && this.item.equals(dataStoreItemChange.item) && this.itemClass.equals(dataStoreItemChange.itemClass) && this.initiator == dataStoreItemChange.initiator;
    }

    public int hashCode() {
        return (((((((this.uuid.hashCode() * 31) + this.type.hashCode()) * 31) + this.item.hashCode()) * 31) + this.itemClass.hashCode()) * 31) + this.initiator.hashCode();
    }

    public Initiator initiator() {
        return this.initiator;
    }

    public Model item() {
        return this.item;
    }

    public Class itemClass() {
        return this.itemClass;
    }

    public String toString() {
        return "DataStoreItemChange{uuid=" + this.uuid + ", type=" + this.type + ", item=" + this.item + ", itemClass=" + this.itemClass + ", initiator=" + this.initiator + '}';
    }

    public Type type() {
        return this.type;
    }

    public UUID uuid() {
        return this.uuid;
    }

    public /* synthetic */ DataStoreItemChange(UUID uuid, Type type, Model model, Class cls, Initiator initiator, 1 r6) {
        this(uuid, type, model, cls, initiator);
    }
}
