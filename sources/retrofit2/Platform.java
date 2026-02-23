package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Platform {
    private static final Platform PLATFORM = findPlatform();

    public static class Android extends Platform {

        public static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        public List defaultCallAdapterFactories(Executor executor) {
            if (executor == null) {
                throw new AssertionError();
            }
            ExecutorCallAdapterFactory executorCallAdapterFactory = new ExecutorCallAdapterFactory(executor);
            return Build.VERSION.SDK_INT >= 24 ? Arrays.asList(new CallAdapter.Factory[]{CompletableFutureCallAdapterFactory.INSTANCE, executorCallAdapterFactory}) : Collections.singletonList(executorCallAdapterFactory);
        }

        public int defaultCallAdapterFactoriesSize() {
            return Build.VERSION.SDK_INT >= 24 ? 2 : 1;
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        public List defaultConverterFactories() {
            return Build.VERSION.SDK_INT >= 24 ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList();
        }

        public int defaultConverterFactoriesSize() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        @IgnoreJRERequirement
        public boolean isDefaultMethod(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return d.a(method);
        }
    }

    @IgnoreJRERequirement
    public static class Java8 extends Platform {
        public List defaultCallAdapterFactories(Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(CompletableFutureCallAdapterFactory.INSTANCE);
            if (executor != null) {
                arrayList.add(new ExecutorCallAdapterFactory(executor));
            } else {
                arrayList.add(DefaultCallAdapterFactory.INSTANCE);
            }
            return Collections.unmodifiableList(arrayList);
        }

        public int defaultCallAdapterFactoriesSize() {
            return 2;
        }

        public List defaultConverterFactories() {
            return Collections.singletonList(OptionalConverterFactory.INSTANCE);
        }

        public int defaultConverterFactoriesSize() {
            return 1;
        }

        public Object invokeDefaultMethod(Method method, Class cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = e.a().getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return i.a(h.a(g.a(f.a(declaredConstructor.newInstance(new Object[]{cls, -1})), method, cls), obj), objArr);
        }

        public boolean isDefaultMethod(Method method) {
            return d.a(method);
        }
    }

    private static Platform findPlatform() {
        try {
            try {
                Class.forName("android.os.Build");
                return new Android();
            } catch (ClassNotFoundException unused) {
                return new Platform();
            }
        } catch (ClassNotFoundException unused2) {
            Class.forName("j$.util.Optional");
            return new Java8();
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    public List defaultCallAdapterFactories(Executor executor) {
        return executor != null ? Collections.singletonList(new ExecutorCallAdapterFactory(executor)) : Collections.singletonList(DefaultCallAdapterFactory.INSTANCE);
    }

    public int defaultCallAdapterFactoriesSize() {
        return 1;
    }

    public Executor defaultCallbackExecutor() {
        return null;
    }

    public List defaultConverterFactories() {
        return Collections.emptyList();
    }

    public int defaultConverterFactoriesSize() {
        return 0;
    }

    public Object invokeDefaultMethod(Method method, Class cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    public boolean isDefaultMethod(Method method) {
        return false;
    }
}
