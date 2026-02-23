package l3;

import O2.z0;
import d4.B;
import d4.M;
import q3.a;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h {
    public static final String[] a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    public static v3.e a(int i, M m) {
        int q = m.q();
        if (m.q() == 1684108385) {
            m.V(8);
            String C = m.C(q - 16);
            return new v3.e("und", C, C);
        }
        B.j("MetadataUtil", "Failed to parse comment attribute: " + a.a(i));
        return null;
    }

    public static v3.a b(M m) {
        String str;
        int q = m.q();
        if (m.q() == 1684108385) {
            int b = a.b(m.q());
            String str2 = b == 13 ? "image/jpeg" : b == 14 ? "image/png" : null;
            if (str2 != null) {
                m.V(4);
                int i = q - 16;
                byte[] bArr = new byte[i];
                m.l(bArr, 0, i);
                return new v3.a(str2, null, 3, bArr);
            }
            str = "Unrecognized cover art flags: " + b;
        } else {
            str = "Failed to parse cover art attribute";
        }
        B.j("MetadataUtil", str);
        return null;
    }

    public static a.b c(M m) {
        int f = m.f() + m.q();
        int q = m.q();
        int i = (q >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & q;
                if (i2 == 6516084) {
                    return a(q, m);
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    return h(q, "TIT2", m);
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    return h(q, "TCOM", m);
                }
                if (i2 == 6578553) {
                    return h(q, "TDRC", m);
                }
                if (i2 == 4280916) {
                    return h(q, "TPE1", m);
                }
                if (i2 == 7630703) {
                    return h(q, "TSSE", m);
                }
                if (i2 == 6384738) {
                    return h(q, "TALB", m);
                }
                if (i2 == 7108978) {
                    return h(q, "USLT", m);
                }
                if (i2 == 6776174) {
                    return h(q, "TCON", m);
                }
                if (i2 == 6779504) {
                    return h(q, "TIT1", m);
                }
            } else {
                if (q == 1735291493) {
                    return g(m);
                }
                if (q == 1684632427) {
                    return d(q, "TPOS", m);
                }
                if (q == 1953655662) {
                    return d(q, "TRCK", m);
                }
                if (q == 1953329263) {
                    return i(q, "TBPM", m, true, false);
                }
                if (q == 1668311404) {
                    return i(q, "TCMP", m, true, true);
                }
                if (q == 1668249202) {
                    return b(m);
                }
                if (q == 1631670868) {
                    return h(q, "TPE2", m);
                }
                if (q == 1936682605) {
                    return h(q, "TSOT", m);
                }
                if (q == 1936679276) {
                    return h(q, "TSO2", m);
                }
                if (q == 1936679282) {
                    return h(q, "TSOA", m);
                }
                if (q == 1936679265) {
                    return h(q, "TSOP", m);
                }
                if (q == 1936679791) {
                    return h(q, "TSOC", m);
                }
                if (q == 1920233063) {
                    return i(q, "ITUNESADVISORY", m, false, false);
                }
                if (q == 1885823344) {
                    return i(q, "ITUNESGAPLESS", m, false, true);
                }
                if (q == 1936683886) {
                    return h(q, "TVSHOWSORT", m);
                }
                if (q == 1953919848) {
                    return h(q, "TVSHOW", m);
                }
                if (q == 757935405) {
                    return e(m, f);
                }
            }
            B.b("MetadataUtil", "Skipped unknown metadata entry: " + a.a(q));
            m.U(f);
            return null;
        } finally {
            m.U(f);
        }
    }

    public static v3.m d(int i, String str, M m) {
        int q = m.q();
        if (m.q() == 1684108385 && q >= 22) {
            m.V(10);
            int N = m.N();
            if (N > 0) {
                String str2 = "" + N;
                int N2 = m.N();
                if (N2 > 0) {
                    str2 = str2 + "/" + N2;
                }
                return new v3.m(str, null, y.A(str2));
            }
        }
        B.j("MetadataUtil", "Failed to parse index/count attribute: " + a.a(i));
        return null;
    }

    public static v3.i e(M m, int i) {
        String str = null;
        String str2 = null;
        int i2 = -1;
        int i3 = -1;
        while (m.f() < i) {
            int f = m.f();
            int q = m.q();
            int q2 = m.q();
            m.V(4);
            if (q2 == 1835360622) {
                str = m.C(q - 12);
            } else if (q2 == 1851878757) {
                str2 = m.C(q - 12);
            } else {
                if (q2 == 1684108385) {
                    i2 = f;
                    i3 = q;
                }
                m.V(q - 12);
            }
        }
        if (str == null || str2 == null || i2 == -1) {
            return null;
        }
        m.U(i2);
        m.V(16);
        return new v3.j(str, str2, m.C(i3 - 16));
    }

    public static w3.a f(M m, int i, String str) {
        while (true) {
            int f = m.f();
            if (f >= i) {
                return null;
            }
            int q = m.q();
            if (m.q() == 1684108385) {
                int q2 = m.q();
                int q3 = m.q();
                int i2 = q - 16;
                byte[] bArr = new byte[i2];
                m.l(bArr, 0, i2);
                return new w3.a(str, bArr, q3, q2);
            }
            m.U(f + q);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static v3.m g(d4.M r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = l3.h.a
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L20
            v3.m r1 = new v3.m
            java.lang.String r2 = "TCON"
            s5.y r3 = s5.y.A(r3)
            r1.<init>(r2, r0, r3)
            return r1
        L20:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            d4.B.j(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.h.g(d4.M):v3.m");
    }

    public static v3.m h(int i, String str, M m) {
        int q = m.q();
        if (m.q() == 1684108385) {
            m.V(8);
            return new v3.m(str, null, y.A(m.C(q - 16)));
        }
        B.j("MetadataUtil", "Failed to parse text attribute: " + a.a(i));
        return null;
    }

    public static v3.i i(int i, String str, M m, boolean z, boolean z2) {
        int j = j(m);
        if (z2) {
            j = Math.min(1, j);
        }
        if (j >= 0) {
            return z ? new v3.m(str, null, y.A(Integer.toString(j))) : new v3.e("und", str, Integer.toString(j));
        }
        B.j("MetadataUtil", "Failed to parse uint8 attribute: " + a.a(i));
        return null;
    }

    public static int j(M m) {
        m.V(4);
        if (m.q() == 1684108385) {
            m.V(8);
            return m.H();
        }
        B.j("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i, d3.r rVar, z0.b bVar) {
        if (i == 1 && rVar.a()) {
            bVar.P(rVar.a).Q(rVar.b);
        }
    }

    public static void l(int i, q3.a aVar, q3.a aVar2, z0.b bVar, q3.a... aVarArr) {
        q3.a aVar3 = new q3.a(new a.b[0]);
        if (i != 1 || aVar == null) {
            aVar = aVar3;
        }
        if (aVar2 != null) {
            for (int i2 = 0; i2 < aVar2.f(); i2++) {
                a.b e = aVar2.e(i2);
                if (e instanceof w3.a) {
                    w3.a aVar4 = (w3.a) e;
                    if (!aVar4.a.equals("com.android.capture.fps")) {
                        aVar = aVar.a(aVar4);
                    } else if (i == 2) {
                        aVar = aVar.a(aVar4);
                    }
                }
            }
        }
        for (q3.a aVar5 : aVarArr) {
            aVar = aVar.c(aVar5);
        }
        if (aVar.f() > 0) {
            bVar.Z(aVar);
        }
    }
}
