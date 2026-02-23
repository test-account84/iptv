package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class act {
    static final String[] a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int b = 0;

    public static an a(cj cjVar) {
        String str;
        String str2;
        int c = cjVar.c() + cjVar.e();
        int e = cjVar.e();
        int i = (e >> 24) & 255;
        an anVar = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & e;
                if (i2 == 6516084) {
                    int e2 = cjVar.e();
                    if (cjVar.e() == 1684108385) {
                        cjVar.G(8);
                        String t = cjVar.t(e2 - 16);
                        anVar = new aau("und", t, t);
                    } else {
                        cd.e("MetadataUtil", "Failed to parse comment attribute: ".concat(String.valueOf(ace.g(e))));
                    }
                    cjVar.F(c);
                    return anVar;
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    abe e3 = e(e, "TIT2", cjVar);
                    cjVar.F(c);
                    return e3;
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    abe e4 = e(e, "TCOM", cjVar);
                    cjVar.F(c);
                    return e4;
                }
                if (i2 == 6578553) {
                    abe e5 = e(e, "TDRC", cjVar);
                    cjVar.F(c);
                    return e5;
                }
                if (i2 == 4280916) {
                    abe e6 = e(e, "TPE1", cjVar);
                    cjVar.F(c);
                    return e6;
                }
                if (i2 == 7630703) {
                    abe e7 = e(e, "TSSE", cjVar);
                    cjVar.F(c);
                    return e7;
                }
                if (i2 == 6384738) {
                    abe e8 = e(e, "TALB", cjVar);
                    cjVar.F(c);
                    return e8;
                }
                if (i2 == 7108978) {
                    abe e9 = e(e, "USLT", cjVar);
                    cjVar.F(c);
                    return e9;
                }
                if (i2 == 6776174) {
                    abe e10 = e(e, "TCON", cjVar);
                    cjVar.F(c);
                    return e10;
                }
                if (i2 == 6779504) {
                    abe e11 = e(e, "TIT1", cjVar);
                    cjVar.F(c);
                    return e11;
                }
            } else {
                if (e == 1735291493) {
                    int b2 = b(cjVar);
                    String str3 = (b2 <= 0 || b2 > 192) ? null : a[b2 - 1];
                    if (str3 != null) {
                        anVar = new abe("TCON", null, str3);
                    } else {
                        cd.e("MetadataUtil", "Failed to parse standard genre code");
                    }
                    cjVar.F(c);
                    return anVar;
                }
                if (e == 1684632427) {
                    abe d = d(1684632427, "TPOS", cjVar);
                    cjVar.F(c);
                    return d;
                }
                if (e == 1953655662) {
                    abe d2 = d(1953655662, "TRCK", cjVar);
                    cjVar.F(c);
                    return d2;
                }
                if (e == 1953329263) {
                    aba c2 = c(1953329263, "TBPM", cjVar, true, false);
                    cjVar.F(c);
                    return c2;
                }
                if (e == 1668311404) {
                    aba c3 = c(1668311404, "TCMP", cjVar, true, true);
                    cjVar.F(c);
                    return c3;
                }
                if (e == 1668249202) {
                    int e12 = cjVar.e();
                    if (cjVar.e() == 1684108385) {
                        int e13 = ace.e(cjVar.e());
                        if (e13 == 13) {
                            str2 = "image/jpeg";
                        } else if (e13 == 14) {
                            str2 = "image/png";
                            e13 = 14;
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            cjVar.G(4);
                            int i3 = e12 - 16;
                            byte[] bArr = new byte[i3];
                            cjVar.A(bArr, 0, i3);
                            anVar = new aap(str2, null, 3, bArr);
                            cjVar.F(c);
                            return anVar;
                        }
                        str = "Unrecognized cover art flags: " + e13;
                    } else {
                        str = "Failed to parse cover art attribute";
                    }
                    cd.e("MetadataUtil", str);
                    cjVar.F(c);
                    return anVar;
                }
                if (e == 1631670868) {
                    abe e14 = e(1631670868, "TPE2", cjVar);
                    cjVar.F(c);
                    return e14;
                }
                if (e == 1936682605) {
                    abe e15 = e(1936682605, "TSOT", cjVar);
                    cjVar.F(c);
                    return e15;
                }
                if (e == 1936679276) {
                    abe e16 = e(1936679276, "TSO2", cjVar);
                    cjVar.F(c);
                    return e16;
                }
                if (e == 1936679282) {
                    abe e17 = e(1936679282, "TSOA", cjVar);
                    cjVar.F(c);
                    return e17;
                }
                if (e == 1936679265) {
                    abe e18 = e(1936679265, "TSOP", cjVar);
                    cjVar.F(c);
                    return e18;
                }
                if (e == 1936679791) {
                    abe e19 = e(1936679791, "TSOC", cjVar);
                    cjVar.F(c);
                    return e19;
                }
                if (e == 1920233063) {
                    aba c4 = c(1920233063, "ITUNESADVISORY", cjVar, false, false);
                    cjVar.F(c);
                    return c4;
                }
                if (e == 1885823344) {
                    aba c5 = c(1885823344, "ITUNESGAPLESS", cjVar, false, true);
                    cjVar.F(c);
                    return c5;
                }
                if (e == 1936683886) {
                    abe e20 = e(1936683886, "TVSHOWSORT", cjVar);
                    cjVar.F(c);
                    return e20;
                }
                if (e == 1953919848) {
                    abe e21 = e(1953919848, "TVSHOW", cjVar);
                    cjVar.F(c);
                    return e21;
                }
                if (e == 757935405) {
                    String str4 = null;
                    String str5 = null;
                    int i4 = -1;
                    int i5 = -1;
                    while (cjVar.c() < c) {
                        int c6 = cjVar.c();
                        int e22 = cjVar.e();
                        int e23 = cjVar.e();
                        cjVar.G(4);
                        if (e23 == 1835360622) {
                            str4 = cjVar.t(e22 - 12);
                        } else if (e23 == 1851878757) {
                            str5 = cjVar.t(e22 - 12);
                        } else {
                            if (e23 == 1684108385) {
                                i5 = e22;
                            }
                            if (e23 == 1684108385) {
                                i4 = c6;
                            }
                            cjVar.G(e22 - 12);
                        }
                    }
                    if (str4 != null && str5 != null && i4 != -1) {
                        cjVar.F(i4);
                        cjVar.G(16);
                        anVar = new abb(str4, str5, cjVar.t(i5 - 16));
                    }
                    return anVar;
                }
            }
            cd.a("MetadataUtil", "Skipped unknown metadata entry: " + ace.g(e));
            cjVar.F(c);
            return null;
        } finally {
            cjVar.F(c);
        }
    }

    private static int b(cj cjVar) {
        cjVar.G(4);
        if (cjVar.e() == 1684108385) {
            cjVar.G(8);
            return cjVar.i();
        }
        cd.e("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static aba c(int i, String str, cj cjVar, boolean z, boolean z2) {
        int b2 = b(cjVar);
        if (z2) {
            b2 = Math.min(1, b2);
        }
        if (b2 >= 0) {
            return z ? new abe(str, null, Integer.toString(b2)) : new aau("und", str, Integer.toString(b2));
        }
        cd.e("MetadataUtil", "Failed to parse uint8 attribute: ".concat(String.valueOf(ace.g(i))));
        return null;
    }

    private static abe d(int i, String str, cj cjVar) {
        int e = cjVar.e();
        if (cjVar.e() == 1684108385 && e >= 22) {
            cjVar.G(10);
            int m = cjVar.m();
            if (m > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(m);
                String sb2 = sb.toString();
                int m2 = cjVar.m();
                if (m2 > 0) {
                    sb2 = sb2 + "/" + m2;
                }
                return new abe(str, null, sb2);
            }
        }
        cd.e("MetadataUtil", "Failed to parse index/count attribute: ".concat(String.valueOf(ace.g(i))));
        return null;
    }

    private static abe e(int i, String str, cj cjVar) {
        int e = cjVar.e();
        if (cjVar.e() == 1684108385) {
            cjVar.G(8);
            return new abe(str, null, cjVar.t(e - 16));
        }
        cd.e("MetadataUtil", "Failed to parse text attribute: ".concat(String.valueOf(ace.g(i))));
        return null;
    }
}
