package com.amplifyframework.geo;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.geo.models.Coordinates;
import com.amplifyframework.geo.options.GeoSearchByCoordinatesOptions;
import com.amplifyframework.geo.options.GeoSearchByTextOptions;
import com.amplifyframework.geo.options.GetMapStyleDescriptorOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface GeoCategoryBehavior {
    void getAvailableMaps(Consumer consumer, Consumer consumer2);

    void getDefaultMap(Consumer consumer, Consumer consumer2);

    void getMapStyleDescriptor(Consumer consumer, Consumer consumer2);

    void getMapStyleDescriptor(GetMapStyleDescriptorOptions getMapStyleDescriptorOptions, Consumer consumer, Consumer consumer2);

    void searchByCoordinates(Coordinates coordinates, Consumer consumer, Consumer consumer2);

    void searchByCoordinates(Coordinates coordinates, GeoSearchByCoordinatesOptions geoSearchByCoordinatesOptions, Consumer consumer, Consumer consumer2);

    void searchByText(String str, Consumer consumer, Consumer consumer2);

    void searchByText(String str, GeoSearchByTextOptions geoSearchByTextOptions, Consumer consumer, Consumer consumer2);
}
