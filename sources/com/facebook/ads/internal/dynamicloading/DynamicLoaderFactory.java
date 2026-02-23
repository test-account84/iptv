package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.internal.api.AudienceNetworkAdsApi;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import com.facebook.ads.internal.util.common.Preconditions;
import dalvik.system.DexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DynamicLoaderFactory {
    private static final String AUDIENCE_NETWORK_CODE_PATH = "audience_network";
    public static final String AUDIENCE_NETWORK_DEX = "audience_network.dex";
    private static final String CODE_CACHE_DIR = "code_cache";
    static final String DEX_LOADING_ERROR_MESSAGE = "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.";
    private static final int DEX_LOAD_RETRY_COUNT = 3;
    private static final int DEX_LOAD_RETRY_DELAY_MS = 200;
    private static final String DYNAMIC_LOADING_BUILD_TYPE = "releaseDL";
    private static final String OPTIMIZED_DEX_PATH = "optimized";
    private static boolean sFallbackMode;
    public static final boolean LOAD_FROM_ASSETS = "releaseDL".equals(BuildConfig.BUILD_TYPE);
    private static final AtomicReference sDynamicLoader = new AtomicReference();
    private static final AtomicBoolean sInitializing = new AtomicBoolean();
    private static boolean sUseLegacyClassLoader = true;

    public static class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ MultithreadedBundleWrapper d;
        public final /* synthetic */ AudienceNetworkAds.InitListener e;

        public a(Context context, boolean z, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener) {
            this.a = context;
            this.c = z;
            this.d = multithreadedBundleWrapper;
            this.e = initListener;
        }

        public void run() {
            Throwable th;
            DynamicLoader dynamicLoader;
            int i;
            ANActivityLifecycleCallbacksListener.registerActivityCallbacks(this.a);
            synchronized (DynamicLoaderFactory.class) {
                DynamicLoader dynamicLoader2 = null;
                th = null;
                int i2 = 0;
                while (i2 < 3) {
                    try {
                        dynamicLoader2 = DynamicLoaderFactory.access$000(this.a, false);
                        break;
                    } finally {
                        if (i2 == i) {
                            try {
                            } catch (Throwable th2) {
                            }
                        }
                    }
                }
                dynamicLoader = dynamicLoader2;
            }
            DynamicLoaderFactory.access$200(this.a, dynamicLoader, th, this.c, this.d, this.e);
            DynamicLoaderFactory.access$300().set(false);
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ AudienceNetworkAds.InitListener a;
        public final /* synthetic */ Throwable c;

        public b(AudienceNetworkAds.InitListener initListener, Throwable th) {
            this.a = initListener;
            this.c = th;
        }

        public void run() {
            this.a.onInitialized(DynamicLoaderFactory.access$400(this.c));
        }
    }

    public static class c implements AudienceNetworkAds.InitResult {
        public final /* synthetic */ Throwable a;

        public c(Throwable th) {
            this.a = th;
        }

        public String getMessage() {
            return DynamicLoaderFactory.access$100(this.a);
        }

        public boolean isSuccess() {
            return false;
        }
    }

    public static /* synthetic */ DynamicLoader access$000(Context context, boolean z) throws Exception {
        return doMakeLoader(context, z);
    }

    public static /* synthetic */ String access$100(Throwable th) {
        return createErrorMessage(th);
    }

    public static /* synthetic */ void access$200(Context context, DynamicLoader dynamicLoader, Throwable th, boolean z, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener) {
        doCallInitialize(context, dynamicLoader, th, z, multithreadedBundleWrapper, initListener);
    }

    public static /* synthetic */ AtomicBoolean access$300() {
        return sInitializing;
    }

    public static /* synthetic */ AudienceNetworkAds.InitResult access$400(Throwable th) {
        return createErrorInitResult(th);
    }

    private static AudienceNetworkAds.InitResult createErrorInitResult(Throwable th) {
        return new c(th);
    }

    private static String createErrorMessage(Throwable th) {
        return "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.\n" + stackTraceToString(th);
    }

    @TargetApi(26)
    private static ClassLoader createInMemoryClassLoader(Context context) throws IOException {
        InputStream open = context.getAssets().open("audience_network.dex");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read <= 0) {
                open.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                ByteBuffer wrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                com.facebook.ads.internal.dynamicloading.b.a();
                return com.facebook.ads.internal.dynamicloading.a.a(wrap, DynamicLoaderFactory.class.getClassLoader());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static void doCallInitialize(Context context, DynamicLoader dynamicLoader, Throwable th, boolean z, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener) {
        if (th != null) {
            if (initListener != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new b(initListener, th), 100L);
                return;
            } else {
                Log.e("FBAudienceNetwork", "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.", th);
                return;
            }
        }
        if (dynamicLoader != null) {
            AudienceNetworkAdsApi createAudienceNetworkAdsApi = dynamicLoader.createAudienceNetworkAdsApi();
            if (z) {
                createAudienceNetworkAdsApi.onContentProviderCreated(context);
            } else {
                createAudienceNetworkAdsApi.initialize(context, multithreadedBundleWrapper, initListener);
            }
        }
    }

    private static DynamicLoader doMakeLoader(Context context, boolean z) throws Exception {
        DynamicLoader dynamicLoader;
        AtomicReference atomicReference = sDynamicLoader;
        DynamicLoader dynamicLoader2 = (DynamicLoader) atomicReference.get();
        if (dynamicLoader2 != null) {
            return dynamicLoader2;
        }
        if (LOAD_FROM_ASSETS) {
            long currentTimeMillis = System.currentTimeMillis();
            dynamicLoader = (DynamicLoader) makeAdsSdkClassLoader(context.getApplicationContext()).loadClass("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
            Log.d("FBAudienceNetwork", "SDK dex loading time: " + (System.currentTimeMillis() - currentTimeMillis));
        } else {
            dynamicLoader = (DynamicLoader) Class.forName("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
        }
        if (z) {
            dynamicLoader.maybeInitInternally(context);
        }
        atomicReference.set(dynamicLoader);
        return dynamicLoader;
    }

    @SuppressLint({"PrivateApi", "CatchGeneralException"})
    private static Context getApplicationContextViaReflection() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Throwable th) {
            Log.e("FBAudienceNetwork", "Failed to fetch Context from  ActivityThread. Audience Network SDK won't work unless you call AudienceNetworkAds.buildInitSettings().withListener(InitListener).initialize().", th);
            return null;
        }
    }

    private static File getCacheCodeDirLegacy(Context context, File file) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            mkdirChecked(file2);
            return file2;
        } catch (IOException unused) {
            File dir = context.getDir("code_cache", 0);
            mkdirChecked(dir);
            return dir;
        }
    }

    private static File getCodeCacheDir(Context context, File file) throws IOException {
        return context.getCodeCacheDir();
    }

    public static DynamicLoader getDynamicLoader() {
        return (DynamicLoader) sDynamicLoader.get();
    }

    private static File getSecondaryDir(File file) throws IOException {
        File file2 = new File(file, "audience_network");
        mkdirChecked(file2);
        return file2;
    }

    public static void initialize(Context context, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener, boolean z) {
        if (z || !sInitializing.getAndSet(true)) {
            new Thread(new a(context, z, multithreadedBundleWrapper, initListener)).start();
        }
    }

    public static synchronized boolean isFallbackMode() {
        boolean z;
        synchronized (DynamicLoaderFactory.class) {
            z = sFallbackMode;
        }
        return z;
    }

    private static ClassLoader makeAdsSdkClassLoader(Context context) throws Exception {
        if (Build.VERSION.SDK_INT >= 26) {
            return createInMemoryClassLoader(context);
        }
        if (sUseLegacyClassLoader) {
            return makeLegacyAdsSdkClassLoader(context);
        }
        File secondaryDir = getSecondaryDir(getCodeCacheDir(context, new File(context.getApplicationInfo().dataDir)));
        String str = secondaryDir.getPath() + File.separator + "audience_network.dex";
        InputStream open = context.getAssets().open("audience_network.dex");
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read <= 0) {
                open.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                File file = new File(secondaryDir.getPath() + File.separator + "optimized");
                mkdirChecked(file);
                return new DexClassLoader(str, file.getPath(), (String) null, context.getClassLoader());
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    private static DexClassLoader makeLegacyAdsSdkClassLoader(Context context) throws Exception {
        String str = context.getFilesDir().getPath() + File.separator + "audience_network.dex";
        InputStream open = context.getAssets().open("audience_network.dex");
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read <= 0) {
                open.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return new DexClassLoader(str, context.getDir("optimized", 0).getPath(), (String) null, DynamicLoaderFactory.class.getClassLoader());
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public static synchronized DynamicLoader makeLoader(Context context) {
        DynamicLoader makeLoader;
        synchronized (DynamicLoaderFactory.class) {
            makeLoader = makeLoader(context, true);
        }
        return makeLoader;
    }

    @SuppressLint({"CatchGeneralException"})
    public static synchronized DynamicLoader makeLoaderUnsafe() {
        synchronized (DynamicLoaderFactory.class) {
            AtomicReference atomicReference = sDynamicLoader;
            if (atomicReference.get() != null) {
                return (DynamicLoader) atomicReference.get();
            }
            Context applicationContextViaReflection = getApplicationContextViaReflection();
            if (applicationContextViaReflection == null) {
                throw new RuntimeException("You must call AudienceNetworkAds.buildInitSettings(Context).initialize() before you can use Audience Network SDK.");
            }
            return makeLoader(applicationContextViaReflection, true);
        }
    }

    private static void mkdirChecked(File file) throws IOException {
        String str;
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            str = "Failed to create dir " + file.getPath() + ". Parent file is null.";
        } else {
            str = "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite();
        }
        Log.e("FBAudienceNetwork", str);
        throw new IOException("Failed to create directory " + file.getPath() + ", detailed message: " + str);
    }

    public static synchronized void setFallbackMode(boolean z) {
        synchronized (DynamicLoaderFactory.class) {
            try {
                if (z) {
                    sDynamicLoader.set(DynamicLoaderFallback.makeFallbackLoader());
                    sFallbackMode = true;
                } else {
                    sDynamicLoader.set((Object) null);
                    sFallbackMode = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setUseLegacyClassLoader(boolean z) {
        sUseLegacyClassLoader = z;
    }

    private static String stackTraceToString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @SuppressLint({"CatchGeneralException"})
    public static synchronized DynamicLoader makeLoader(Context context, boolean z) {
        DynamicLoader doMakeLoader;
        synchronized (DynamicLoaderFactory.class) {
            Preconditions.checkNotNull(context, "Context can not be null.");
            try {
                doMakeLoader = doMakeLoader(context, z);
            } catch (Throwable th) {
                Log.e("FBAudienceNetwork", "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.", th);
                DexLoadErrorReporter.reportDexLoadingIssue(context, createErrorMessage(th), 0.1d);
                DynamicLoader makeFallbackLoader = DynamicLoaderFallback.makeFallbackLoader();
                sDynamicLoader.set(makeFallbackLoader);
                sFallbackMode = true;
                return makeFallbackLoader;
            }
        }
        return doMakeLoader;
    }
}
