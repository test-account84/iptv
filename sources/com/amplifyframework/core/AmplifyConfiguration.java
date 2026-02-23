package com.amplifyframework.core;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.analytics.AnalyticsCategoryConfiguration;
import com.amplifyframework.api.ApiCategoryConfiguration;
import com.amplifyframework.auth.AuthCategoryConfiguration;
import com.amplifyframework.core.Resources;
import com.amplifyframework.core.category.CategoryConfiguration;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.category.EmptyCategoryConfiguration;
import com.amplifyframework.datastore.DataStoreCategoryConfiguration;
import com.amplifyframework.geo.GeoCategoryConfiguration;
import com.amplifyframework.hub.HubCategoryConfiguration;
import com.amplifyframework.logging.LoggingCategoryConfiguration;
import com.amplifyframework.predictions.PredictionsCategoryConfiguration;
import com.amplifyframework.storage.StorageCategoryConfiguration;
import com.amplifyframework.util.Immutable;
import com.amplifyframework.util.UserAgent;
import j$.util.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AmplifyConfiguration {
    private static final String DEFAULT_IDENTIFIER = "amplifyconfiguration";
    private final Map categoryConfigurations;
    private final boolean devMenuEnabled;
    private final Map platformVersions;

    public static final class Builder {
        private final Map categoryConfiguration;
        private boolean devMenuEnabled;
        private final Map platformVersions;

        private Builder(Map map) {
            this.devMenuEnabled = false;
            this.categoryConfiguration = map;
            this.platformVersions = new LinkedHashMap();
        }

        public Builder addPlatform(UserAgent.Platform platform, String str) {
            if (!UserAgent.Platform.ANDROID.equals(platform)) {
                Map map = this.platformVersions;
                Objects.requireNonNull(platform);
                Objects.requireNonNull(str);
                map.put(platform, str);
            }
            return this;
        }

        public AmplifyConfiguration build() {
            return new AmplifyConfiguration(this.categoryConfiguration, this.platformVersions, this.devMenuEnabled, null);
        }

        public Builder devMenuEnabled(boolean z) {
            this.devMenuEnabled = z;
            return this;
        }

        public /* synthetic */ Builder(Map map, 1 r2) {
            this(map);
        }
    }

    public AmplifyConfiguration(Map map) {
        this(map, new LinkedHashMap(), false);
    }

    public static Builder builder(Context context) throws AmplifyException {
        try {
            return builder(context, Resources.getRawResourceId(context, "amplifyconfiguration"));
        } catch (Resources.ResourceLoadingException e) {
            throw new AmplifyException("Failed to load the amplifyconfiguration configuration file.", e, "Is there an Amplify configuration file present in your app project, under ./app/src/main/res/raw/amplifyconfiguration?");
        }
    }

    private static Map configsFromJson(JSONObject jSONObject) throws AmplifyException {
        List<CategoryConfiguration> asList = Arrays.asList(new CategoryConfiguration[]{new AnalyticsCategoryConfiguration(), new ApiCategoryConfiguration(), new AuthCategoryConfiguration(), new DataStoreCategoryConfiguration(), new GeoCategoryConfiguration(), new HubCategoryConfiguration(), new LoggingCategoryConfiguration(), new PredictionsCategoryConfiguration(), new StorageCategoryConfiguration()});
        HashMap hashMap = new HashMap();
        try {
            for (CategoryConfiguration categoryConfiguration : asList) {
                String configurationKey = categoryConfiguration.getCategoryType().getConfigurationKey();
                if (jSONObject.has(configurationKey)) {
                    categoryConfiguration.populateFromJSON(jSONObject.getJSONObject(configurationKey));
                    hashMap.put(configurationKey, categoryConfiguration);
                }
            }
            return Immutable.of((Map) hashMap);
        } catch (JSONException e) {
            throw new AmplifyException("Could not parse amplifyconfiguration.json ", e, "Check any modifications made to the file.");
        }
    }

    public static AmplifyConfiguration fromConfigFile(Context context) throws AmplifyException {
        return builder(context).build();
    }

    public static AmplifyConfiguration fromJson(JSONObject jSONObject) throws AmplifyException {
        return builder(jSONObject).build();
    }

    public CategoryConfiguration forCategoryType(CategoryType categoryType) {
        CategoryConfiguration categoryConfiguration = (CategoryConfiguration) this.categoryConfigurations.get(categoryType.getConfigurationKey());
        return categoryConfiguration == null ? EmptyCategoryConfiguration.forCategoryType(categoryType) : categoryConfiguration;
    }

    public Map getPlatformVersions() {
        return Immutable.of(this.platformVersions);
    }

    public boolean isDevMenuEnabled() {
        return this.devMenuEnabled;
    }

    private AmplifyConfiguration(Map map, Map map2, boolean z) {
        HashMap hashMap = new HashMap();
        this.categoryConfigurations = hashMap;
        hashMap.putAll(map);
        this.platformVersions = map2;
        this.devMenuEnabled = z;
    }

    public static Builder builder(Context context, int i) throws AmplifyException {
        Objects.requireNonNull(context);
        try {
            return builder(Resources.readJsonResourceFromId(context, i));
        } catch (Resources.ResourceLoadingException e) {
            throw new AmplifyException("Failed to read JSON from resource = " + i, e, "If you are attempting to load a custom configuration file, please ensure that it exists in your application project under app/src/main/res/raw/<YOUR_CUSTOM_CONFIG_FILE>.");
        }
    }

    public static AmplifyConfiguration fromConfigFile(Context context, int i) throws AmplifyException {
        return builder(context, i).build();
    }

    public /* synthetic */ AmplifyConfiguration(Map map, Map map2, boolean z, 1 r4) {
        this(map, map2, z);
    }

    public static Builder builder(JSONObject jSONObject) throws AmplifyException {
        Objects.requireNonNull(jSONObject);
        return new Builder(configsFromJson(jSONObject), null);
    }

    public AmplifyConfiguration(Map map, boolean z) {
        this(map, new LinkedHashMap(), z);
    }
}
