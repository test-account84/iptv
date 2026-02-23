package com.amplifyframework.geo;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.geo.models.Coordinates;
import com.amplifyframework.geo.options.GeoSearchByCoordinatesOptions;
import com.amplifyframework.geo.options.GeoSearchByTextOptions;
import com.amplifyframework.geo.options.GetMapStyleDescriptorOptions;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class GeoCategory extends Category implements GeoCategoryBehavior {
    public void getAvailableMaps(Consumer consumer, Consumer consumer2) {
        ((GeoCategoryPlugin) getSelectedPlugin()).getAvailableMaps(consumer, consumer2);
    }

    public CategoryType getCategoryType() {
        return CategoryType.GEO;
    }

    public void getDefaultMap(Consumer consumer, Consumer consumer2) {
        ((GeoCategoryPlugin) getSelectedPlugin()).getDefaultMap(consumer, consumer2);
    }

    public void getMapStyleDescriptor(Consumer consumer, Consumer consumer2) {
        ((GeoCategoryPlugin) getSelectedPlugin()).getMapStyleDescriptor(consumer, consumer2);
    }

    public void searchByCoordinates(Coordinates coordinates, Consumer consumer, Consumer consumer2) {
        ((GeoCategoryPlugin) getSelectedPlugin()).searchByCoordinates(coordinates, consumer, consumer2);
    }

    public void searchByText(String str, Consumer consumer, Consumer consumer2) {
        ((GeoCategoryPlugin) getSelectedPlugin()).searchByText(str, consumer, consumer2);
    }

    public void getMapStyleDescriptor(GetMapStyleDescriptorOptions getMapStyleDescriptorOptions, Consumer consumer, Consumer consumer2) {
        ((GeoCategoryPlugin) getSelectedPlugin()).getMapStyleDescriptor(getMapStyleDescriptorOptions, consumer, consumer2);
    }

    public void searchByCoordinates(Coordinates coordinates, GeoSearchByCoordinatesOptions geoSearchByCoordinatesOptions, Consumer consumer, Consumer consumer2) {
        ((GeoCategoryPlugin) getSelectedPlugin()).searchByCoordinates(coordinates, geoSearchByCoordinatesOptions, consumer, consumer2);
    }

    public void searchByText(String str, GeoSearchByTextOptions geoSearchByTextOptions, Consumer consumer, Consumer consumer2) {
        ((GeoCategoryPlugin) getSelectedPlugin()).searchByText(str, geoSearchByTextOptions, consumer, consumer2);
    }
}
