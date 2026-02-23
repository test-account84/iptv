package com.amplifyframework.core.category;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.InitializationResult;
import com.amplifyframework.core.InitializationStatus;
import com.amplifyframework.core.plugin.Plugin;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.util.Immutable;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class Category implements CategoryTypeable {
    private final Map plugins = new ConcurrentHashMap();
    private final AtomicReference state = new AtomicReference(State.NOT_CONFIGURED);
    private final AtomicReference categoryInitializationResult = new AtomicReference((Object) null);

    public enum State {
        NOT_CONFIGURED,
        CONFIGURING,
        CONFIGURED,
        INITIALIZING,
        INITIALIZED,
        CONFIGURATION_FAILED,
        INITIALIZATION_FAILED
    }

    private Plugin getPluginIfConfiguredOrThrow(Plugin plugin) throws IllegalStateException {
        if (plugin == null) {
            throw new IllegalStateException("Tried to get a plugin but that plugin was not present. Check if the plugin was added originally or perhaps was already removed.");
        }
        if (State.CONFIGURATION_FAILED.equals(this.state.get())) {
            throw new IllegalStateException("Failed to get plugin because configuration previously failed.  Check for failures by logging any exceptions thrown by Amplify.configure().");
        }
        if (State.INITIALIZATION_FAILED.equals(this.state.get())) {
            CategoryInitializationResult categoryInitializationResult = (CategoryInitializationResult) this.categoryInitializationResult.get();
            throw new IllegalStateException("Failed to get plugin because initialization previously failed.  See attached exception for details.", categoryInitializationResult != null ? (Throwable) categoryInitializationResult.getPluginInitializationFailures().get(plugin.getPluginKey()) : null);
        }
        if (isConfigured()) {
            return plugin;
        }
        throw new IllegalStateException("Tried to get a plugin before it was configured.  Make sure you call Amplify.configure() first.");
    }

    public final void addPlugin(Plugin plugin) throws AmplifyException {
        if (State.NOT_CONFIGURED.equals(this.state.get())) {
            this.plugins.put(plugin.getPluginKey(), plugin);
        } else {
            throw new AmplifyException("Category " + getCategoryType() + " has already been configured or is configuring.", "Make sure that you have added all plugins before attempting configuration.");
        }
    }

    public final synchronized void configure(CategoryConfiguration categoryConfiguration, Context context) throws AmplifyException {
        synchronized (this.state) {
            if (!State.NOT_CONFIGURED.equals(this.state.get())) {
                throw new AmplifyException("Category " + getCategoryType() + " has already been configured or is currently configuring.", "Ensure that you are only attempting configuration once.");
            }
            this.state.set(State.CONFIGURING);
            try {
                for (Plugin plugin : getPlugins()) {
                    JSONObject pluginConfig = categoryConfiguration.getPluginConfig(plugin.getPluginKey());
                    if (pluginConfig == null) {
                        pluginConfig = new JSONObject();
                    }
                    plugin.configure(pluginConfig, context);
                }
                this.state.set(State.CONFIGURED);
            } catch (Throwable th) {
                this.state.set(State.CONFIGURATION_FAILED);
                throw th;
            }
        }
    }

    public final Plugin getPlugin(String str) throws IllegalStateException {
        return getPluginIfConfiguredOrThrow((Plugin) this.plugins.get(str));
    }

    public final Set getPlugins() {
        return Immutable.of((Set) new HashSet(this.plugins.values()));
    }

    public Plugin getSelectedPlugin() throws IllegalStateException {
        if (this.plugins.size() > 1) {
            throw new IllegalStateException("Tried to get a default plugin but there are more than one to choose from in this category. Call getPlugin(pluginKey) to choose the specific plugin you want to use in this case.");
        }
        Iterator it = getPlugins().iterator();
        return getPluginIfConfiguredOrThrow(it.hasNext() ? (Plugin) it.next() : null);
    }

    public final synchronized CategoryInitializationResult initialize(Context context) {
        InitializationResult failure;
        CategoryInitializationResult with;
        AtomicReference atomicReference;
        State state;
        try {
            HashMap hashMap = new HashMap();
            if (State.CONFIGURED.equals(this.state.get())) {
                this.state.set(State.CONFIGURING);
                for (Plugin plugin : getPlugins()) {
                    try {
                        plugin.initialize(context);
                        failure = InitializationResult.success();
                    } catch (AmplifyException e) {
                        failure = InitializationResult.failure(e);
                    }
                    hashMap.put(plugin.getPluginKey(), failure);
                }
            } else {
                Iterator it = getPlugins().iterator();
                while (it.hasNext()) {
                    hashMap.put(((Plugin) it.next()).getPluginKey(), InitializationResult.failure(new AmplifyException("Tried to init before category was not configured.", "Call configure() on category, first.")));
                }
            }
            with = CategoryInitializationResult.with(hashMap);
            this.categoryInitializationResult.set(with);
            if (with.isFailure()) {
                atomicReference = this.state;
                state = State.INITIALIZATION_FAILED;
            } else {
                atomicReference = this.state;
                state = State.INITIALIZED;
            }
            atomicReference.set(state);
            Amplify.Hub.publish(HubChannel.forCategoryType(getCategoryType()), HubEvent.create(with.isFailure() ? InitializationStatus.FAILED : InitializationStatus.SUCCEEDED, with));
        } catch (Throwable th) {
            throw th;
        }
        return with;
    }

    public synchronized boolean isConfigured() {
        return Arrays.asList(new State[]{State.CONFIGURED, State.INITIALIZING, State.INITIALIZED}).contains(this.state.get());
    }

    public synchronized boolean isInitialized() {
        return State.INITIALIZED.equals(this.state.get());
    }

    public final void removePlugin(Plugin plugin) {
        this.plugins.remove(plugin.getPluginKey());
    }
}
