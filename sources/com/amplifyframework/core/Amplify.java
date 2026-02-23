package com.amplifyframework.core;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.analytics.AnalyticsCategory;
import com.amplifyframework.api.ApiCategory;
import com.amplifyframework.auth.AuthCategory;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.plugin.Plugin;
import com.amplifyframework.datastore.DataStoreCategory;
import com.amplifyframework.devmenu.DeveloperMenu;
import com.amplifyframework.geo.GeoCategory;
import com.amplifyframework.hub.HubCategory;
import com.amplifyframework.logging.LoggingCategory;
import com.amplifyframework.predictions.PredictionsCategory;
import com.amplifyframework.storage.StorageCategory;
import com.amplifyframework.util.Empty;
import com.amplifyframework.util.Immutable;
import com.amplifyframework.util.UserAgent;
import j$.util.Objects;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Amplify {
    private static final LinkedHashMap CATEGORIES;
    private static final AtomicBoolean CONFIGURATION_LOCK;
    private static final ExecutorService INITIALIZATION_POOL;
    public static final AnalyticsCategory Analytics = new AnalyticsCategory();
    public static final ApiCategory API = new ApiCategory();
    public static final AuthCategory Auth = new AuthCategory();
    public static final LoggingCategory Logging = new LoggingCategory();
    public static final StorageCategory Storage = new StorageCategory();
    public static final GeoCategory Geo = new GeoCategory();
    public static final HubCategory Hub = new HubCategory();
    public static final DataStoreCategory DataStore = new DataStoreCategory();
    public static final PredictionsCategory Predictions = new PredictionsCategory();

    public static final class AlreadyConfiguredException extends AmplifyException {
        private static final long serialVersionUID = 1;

        private AlreadyConfiguredException(String str) {
            super("Amplify has already been configured.", str);
        }

        public /* synthetic */ AlreadyConfiguredException(String str, 1 r2) {
            this(str);
        }
    }

    public enum RegistryUpdateType {
        ADD,
        REMOVE
    }

    static {
        LinkedHashMap buildCategoriesMap = buildCategoriesMap();
        CATEGORIES = buildCategoriesMap;
        CONFIGURATION_LOCK = new AtomicBoolean(false);
        INITIALIZATION_POOL = Executors.newFixedThreadPool(buildCategoriesMap.size());
    }

    private Amplify() {
        throw new UnsupportedOperationException("No instances allowed.");
    }

    public static /* synthetic */ void a(Category category, Context context) {
        lambda$beginInitialization$0(category, context);
    }

    public static void addPlugin(Plugin plugin) throws AmplifyException {
        updatePluginRegistry(plugin, RegistryUpdateType.ADD);
    }

    private static void beginInitialization(Category category, Context context) {
        INITIALIZATION_POOL.execute(new a(category, context));
    }

    private static LinkedHashMap buildCategoriesMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CategoryType.AUTH, Auth);
        linkedHashMap.put(CategoryType.ANALYTICS, Analytics);
        linkedHashMap.put(CategoryType.API, API);
        linkedHashMap.put(CategoryType.LOGGING, Logging);
        linkedHashMap.put(CategoryType.STORAGE, Storage);
        linkedHashMap.put(CategoryType.GEO, Geo);
        linkedHashMap.put(CategoryType.HUB, Hub);
        linkedHashMap.put(CategoryType.DATASTORE, DataStore);
        linkedHashMap.put(CategoryType.PREDICTIONS, Predictions);
        return linkedHashMap;
    }

    public static void configure(Context context) throws AmplifyException {
        configure(AmplifyConfiguration.fromConfigFile(context), context);
    }

    public static Map getCategoriesMap() {
        return Immutable.of((Map) CATEGORIES);
    }

    private static /* synthetic */ void lambda$beginInitialization$0(Category category, Context context) {
        category.initialize(context);
    }

    public static void removePlugin(Plugin plugin) throws AmplifyException {
        updatePluginRegistry(plugin, RegistryUpdateType.REMOVE);
    }

    private static void updatePluginRegistry(Plugin plugin, RegistryUpdateType registryUpdateType) throws AmplifyException {
        AtomicBoolean atomicBoolean = CONFIGURATION_LOCK;
        synchronized (atomicBoolean) {
            Category category = null;
            if (atomicBoolean.get()) {
                throw new AlreadyConfiguredException("Do not add plugins after calling `Amplify.configure()`.", null);
            }
            if (Empty.check(plugin.getPluginKey())) {
                throw new AmplifyException("Plugin key was missing for + " + plugin.getClass().getSimpleName(), "This should never happen - contact the plugin developers to find out why this is.");
            }
            LinkedHashMap linkedHashMap = CATEGORIES;
            if (!linkedHashMap.containsKey(plugin.getCategoryType())) {
                throw new AmplifyException("Plugin category does not exist. ", "Verify that the library version is correct and supports the plugin's category.");
            }
            try {
                category = (Category) linkedHashMap.get(plugin.getCategoryType());
            } catch (ClassCastException unused) {
            }
            if (category == null) {
                throw new AmplifyException("A plugin is being added to the wrong category", "Sorry, we don't have a suggested fix for this error yet.");
            }
            if (RegistryUpdateType.REMOVE.equals(registryUpdateType)) {
                category.removePlugin(plugin);
            } else {
                category.addPlugin(plugin);
            }
        }
    }

    public static void configure(AmplifyConfiguration amplifyConfiguration, Context context) throws AmplifyException {
        Objects.requireNonNull(amplifyConfiguration);
        Objects.requireNonNull(context);
        AtomicBoolean atomicBoolean = CONFIGURATION_LOCK;
        synchronized (atomicBoolean) {
            try {
                if (atomicBoolean.get()) {
                    throw new AlreadyConfiguredException("Remove the duplicate call to `Amplify.configure()`.", null);
                }
                UserAgent.configure(amplifyConfiguration.getPlatformVersions());
                if (amplifyConfiguration.isDevMenuEnabled()) {
                    DeveloperMenu.singletonInstance(context).enableDeveloperMenu();
                }
                for (Category category : CATEGORIES.values()) {
                    if (category.getPlugins().size() > 0) {
                        category.configure(amplifyConfiguration.forCategoryType(category.getCategoryType()), context);
                        beginInitialization(category, context);
                    }
                }
                CONFIGURATION_LOCK.set(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
