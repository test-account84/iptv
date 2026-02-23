package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class InstanceFactory {
    private final Cache cache = new ConcurrentCache();

    public class ClassInstance implements Instance {
        private Class type;
        private Object value;

        public ClassInstance(Class cls) {
            this.type = cls;
        }

        public Object getInstance() throws Exception {
            if (this.value == null) {
                this.value = InstanceFactory.this.getObject(this.type);
            }
            return this.value;
        }

        public Class getType() {
            return this.type;
        }

        public boolean isReference() {
            return false;
        }

        public Object setInstance(Object obj) throws Exception {
            this.value = obj;
            return obj;
        }
    }

    public class ValueInstance implements Instance {
        private final Class type;
        private final Value value;

        public ValueInstance(Value value) {
            this.type = value.getType();
            this.value = value;
        }

        public Object getInstance() throws Exception {
            if (this.value.isReference()) {
                return this.value.getValue();
            }
            Object object = InstanceFactory.this.getObject(this.type);
            Value value = this.value;
            if (value != null) {
                value.setValue(object);
            }
            return object;
        }

        public Class getType() {
            return this.type;
        }

        public boolean isReference() {
            return this.value.isReference();
        }

        public Object setInstance(Object obj) {
            Value value = this.value;
            if (value != null) {
                value.setValue(obj);
            }
            return obj;
        }
    }

    public Instance getInstance(Class cls) {
        return new ClassInstance(cls);
    }

    public Object getObject(Class cls) throws Exception {
        Constructor constructor = (Constructor) this.cache.fetch(cls);
        if (constructor == null) {
            constructor = cls.getDeclaredConstructor((Class[]) null);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            this.cache.cache(cls, constructor);
        }
        return constructor.newInstance((Object[]) null);
    }

    public Instance getInstance(Value value) {
        return new ValueInstance(value);
    }
}
