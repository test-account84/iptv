package com.amplifyframework.analytics;

import O.c;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserProfile {
    private final AnalyticsProperties customProperties;
    private final String email;
    private final Location location;
    private final String name;
    private final String plan;

    public static class Builder {
        private AnalyticsProperties customProperties;
        private String email;
        private Location location;
        private String name;
        private String plan;

        public static /* synthetic */ String access$000(Builder builder) {
            return builder.name;
        }

        public static /* synthetic */ String access$100(Builder builder) {
            return builder.email;
        }

        public static /* synthetic */ String access$200(Builder builder) {
            return builder.plan;
        }

        public static /* synthetic */ Location access$300(Builder builder) {
            return builder.location;
        }

        public static /* synthetic */ AnalyticsProperties access$400(Builder builder) {
            return builder.customProperties;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }

        public Builder customProperties(AnalyticsProperties analyticsProperties) {
            Objects.requireNonNull(analyticsProperties);
            this.customProperties = analyticsProperties;
            return this;
        }

        public Builder email(String str) {
            Objects.requireNonNull(str);
            this.email = str;
            return this;
        }

        public Builder location(Location location) {
            Objects.requireNonNull(location);
            this.location = location;
            return this;
        }

        public Builder name(String str) {
            Objects.requireNonNull(str);
            this.name = str;
            return this;
        }

        public Builder plan(String str) {
            Objects.requireNonNull(str);
            this.plan = str;
            return this;
        }
    }

    public static final class Location {
        private final String city;
        private final String country;
        private final Double latitude;
        private final Double longitude;
        private final String postalCode;
        private final String region;

        public static final class Builder {
            private String city;
            private String country;
            private Double latitude;
            private Double longitude;
            private String postalCode;
            private String region;

            public static /* synthetic */ String access$1000(Builder builder) {
                return builder.country;
            }

            public static /* synthetic */ Double access$500(Builder builder) {
                return builder.latitude;
            }

            public static /* synthetic */ Double access$600(Builder builder) {
                return builder.longitude;
            }

            public static /* synthetic */ String access$700(Builder builder) {
                return builder.postalCode;
            }

            public static /* synthetic */ String access$800(Builder builder) {
                return builder.city;
            }

            public static /* synthetic */ String access$900(Builder builder) {
                return builder.region;
            }

            public Location build() {
                return new Location(this, null);
            }

            public Builder city(String str) {
                Objects.requireNonNull(str);
                this.city = str;
                return this;
            }

            public Builder country(String str) {
                Objects.requireNonNull(str);
                this.country = str;
                return this;
            }

            public Builder latitude(Double d) {
                Objects.requireNonNull(d);
                this.latitude = d;
                return this;
            }

            public Builder longitude(Double d) {
                Objects.requireNonNull(d);
                this.longitude = d;
                return this;
            }

            public Builder postalCode(String str) {
                Objects.requireNonNull(str);
                this.postalCode = str;
                return this;
            }

            public Builder region(String str) {
                Objects.requireNonNull(str);
                this.region = str;
                return this;
            }
        }

        private Location(Builder builder) {
            this.latitude = Builder.access$500(builder);
            this.longitude = Builder.access$600(builder);
            this.postalCode = Builder.access$700(builder);
            this.city = Builder.access$800(builder);
            this.region = Builder.access$900(builder);
            this.country = Builder.access$1000(builder);
        }

        public static Builder builder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Location.class != obj.getClass()) {
                return false;
            }
            Location location = (Location) obj;
            if (c.a(this.latitude, location.latitude) && c.a(this.longitude, location.longitude) && c.a(this.postalCode, location.postalCode) && c.a(this.city, location.city) && c.a(this.region, location.region)) {
                return c.a(this.country, location.country);
            }
            return false;
        }

        public String getCity() {
            return this.city;
        }

        public String getCountry() {
            return this.country;
        }

        public Double getLatitude() {
            return this.latitude;
        }

        public Double getLongitude() {
            return this.longitude;
        }

        public String getPostalCode() {
            return this.postalCode;
        }

        public String getRegion() {
            return this.region;
        }

        public int hashCode() {
            Double d = this.latitude;
            int hashCode = (d != null ? d.hashCode() : 0) * 31;
            Double d2 = this.longitude;
            int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
            String str = this.postalCode;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.city;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.region;
            int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.country;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", postalCode='" + this.postalCode + "', city='" + this.city + "', region='" + this.region + "', country='" + this.country + "'}";
        }

        public /* synthetic */ Location(Builder builder, 1 r2) {
            this(builder);
        }
    }

    public UserProfile(Builder builder) {
        this.name = Builder.access$000(builder);
        this.email = Builder.access$100(builder);
        this.plan = Builder.access$200(builder);
        this.location = Builder.access$300(builder);
        this.customProperties = Builder.access$400(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserProfile userProfile = (UserProfile) obj;
        if (c.a(this.name, userProfile.name) && c.a(this.email, userProfile.email) && c.a(this.plan, userProfile.plan) && c.a(this.location, userProfile.location)) {
            return c.a(this.customProperties, userProfile.customProperties);
        }
        return false;
    }

    public AnalyticsProperties getCustomProperties() {
        return this.customProperties;
    }

    public String getEmail() {
        return this.email;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getPlan() {
        return this.plan;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.email;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.plan;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Location location = this.location;
        int hashCode4 = (hashCode3 + (location != null ? location.hashCode() : 0)) * 31;
        AnalyticsProperties analyticsProperties = this.customProperties;
        return hashCode4 + (analyticsProperties != null ? analyticsProperties.hashCode() : 0);
    }

    public String toString() {
        return "UserProfile{name='" + this.name + "', email='" + this.email + "', plan='" + this.plan + "', location=" + this.location + ", customProperties=" + this.customProperties + '}';
    }
}
