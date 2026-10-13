package com.netflix.hawkins.consumer.tokens;

import com.netflix.ale.AleCryptoBouncyCastle;
import com.netflix.android.org.json.zip.JSONzip;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import net.zetetic.database.CursorWindow;
import p000o.AbstractC11247f;
import p000o.AbstractC3480bQn;
import p000o.AbstractC34853zG;
import p000o.AbstractC4079bgY;
import p000o.C1546aWg;
import p000o.C30372nWu;
import p000o.C3770bah;
import p000o.aFV;
import p000o.aIX;
import p000o.nYA;
import p000o.nZN;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.netflix.hawkins.consumer.tokens.HawkinsTheme[], still in use, count: 1, list:
  (r0v1 com.netflix.hawkins.consumer.tokens.HawkinsTheme[]) from 0x0024: INVOKE (r0v1 com.netflix.hawkins.consumer.tokens.HawkinsTheme[]) STATIC call: kotlin.enums.EnumEntriesKt.b(java.lang.Enum[]):o.nYA A[MD:(java.lang.Enum[]):o.nYA (m), WRAPPED] (LINE:37)
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b \b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u001d\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!"}, d2 = {"Lcom/netflix/hawkins/consumer/tokens/HawkinsTheme;", "", "d", "b", "e", "c", "a", "f", "i", "g", "h", "j", "n", "k", "m", "o", "l", "r", "q", "p", "s", "t", "w", "y", "u", "x", "v", "D", "z", "B", "A", "Base", "Eclipse", "Debug"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HawkinsTheme {
    Base,
    Eclipse,
    Debug;

    private static final /* synthetic */ nYA $ENTRIES;

    public static final class D {
        public final e a;
        public final b b;
        public final c e;

        public D(c cVar, b bVar, e eVar) {
            this.e = cVar;
            this.b = bVar;
            this.a = eVar;
        }

        public final int hashCode() {
            int iHashCode = this.e.hashCode();
            return this.a.hashCode() + ((this.b.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class c {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            private long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            private long l;
            private long m;

            public c(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
                this.d = j;
                this.a = j2;
                this.e = j3;
                this.c = j4;
                this.b = j5;
                this.i = j6;
                this.g = j7;
                this.j = j8;
                this.h = j9;
                this.f = j10;
                this.m = j11;
                this.l = j12;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.l) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.d) * 31, 31, this.a), 31, this.e), 31, this.c), 31, this.b), 31, this.i), 31, this.g), 31, this.j), 31, this.h), 31, this.f), 31, this.m);
            }

            public final String toString() {
                String strG = aFV.g(this.d);
                String strG2 = aFV.g(this.a);
                String strG3 = aFV.g(this.e);
                String strG4 = aFV.g(this.c);
                String strG5 = aFV.g(this.b);
                String strG6 = aFV.g(this.i);
                String strG7 = aFV.g(this.g);
                String strG8 = aFV.g(this.j);
                String strG9 = aFV.g(this.h);
                String strG10 = aFV.g(this.f);
                String strG11 = aFV.g(this.m);
                String strG12 = aFV.g(this.l);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", borderFill=", strG2, ", borderOffers=");
                AbstractC4079bgY.e(sbD, strG3, ", borderSupplemental=", strG4, ", foreground=");
                AbstractC4079bgY.e(sbD, strG5, ", foregroundFill=", strG6, ", foregroundOffers=");
                AbstractC4079bgY.e(sbD, strG7, ", foregroundSupplemental=", strG8, ", surfaceFill=");
                AbstractC4079bgY.e(sbD, strG9, ", surfaceOffersLeading=", strG10, ", surfaceOffersTrailing=");
                return AbstractC3480bQn.b(sbD, strG11, ", surfaceSupplemental=", strG12, ")");
            }

            public static c c(c cVar, long j, long j2) {
                return new c(cVar.d, cVar.a, cVar.e, cVar.c, cVar.b, j, cVar.g, cVar.j, j2, cVar.f, cVar.m, cVar.l);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                long j = cVar.d;
                int i = aFV.b;
                return C30372nWu.d(this.d, j) && C30372nWu.d(this.a, cVar.a) && C30372nWu.d(this.e, cVar.e) && C30372nWu.d(this.c, cVar.c) && C30372nWu.d(this.b, cVar.b) && C30372nWu.d(this.i, cVar.i) && C30372nWu.d(this.g, cVar.g) && C30372nWu.d(this.j, cVar.j) && C30372nWu.d(this.h, cVar.h) && C30372nWu.d(this.f, cVar.f) && C30372nWu.d(this.m, cVar.m) && C30372nWu.d(this.l, cVar.l);
            }
        }

        public static final class b {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float i;
            private float j;

            public b(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
                this.a = f;
                this.c = f2;
                this.d = f3;
                this.j = f4;
                this.e = f5;
                this.b = f6;
                this.i = f7;
            }

            public final int hashCode() {
                return Float.hashCode(this.i) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.a) * 31, this.c, 31), this.d, 31), this.j, 31), this.e, 31), this.b, 31), 1.5f, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.a);
                String strD2 = C3770bah.d(this.c);
                String strD3 = C3770bah.d(this.d);
                String strD4 = C3770bah.d(this.j);
                String strD5 = C3770bah.d(this.e);
                String strD6 = C3770bah.d(this.b);
                String strD7 = C3770bah.d(1.5f);
                String strD8 = C3770bah.d(this.i);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadiusExtraSmall=", strD, ", borderRadiusSmall=", strD2, ", borderWidth=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetween=", strD4, ", spaceBetweenIconText=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceHorizontal=", strD6, ", spaceVerticalExtraSmall=");
                return AbstractC3480bQn.b(sbD, strD7, ", spaceVerticalSmall=", strD8, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return C3770bah.b(this.a, bVar.a) && C3770bah.b(this.c, bVar.c) && C3770bah.b(this.d, bVar.d) && C3770bah.b(this.j, bVar.j) && C3770bah.b(this.e, bVar.e) && C3770bah.b(this.b, bVar.b) && C3770bah.b(1.5f, 1.5f) && C3770bah.b(this.i, bVar.i);
            }
        }

        public static final class e {
            public final C1546aWg a;
            public final C1546aWg c;

            public e(C1546aWg c1546aWg, C1546aWg c1546aWg2) {
                this.a = c1546aWg;
                this.c = c1546aWg2;
            }

            public final int hashCode() {
                return this.c.hashCode() + (this.a.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return this.a.equals(eVar.a) && this.c.equals(eVar.c);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textExtraSmall=");
                sb.append(this.a);
                sb.append(", textSmall=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof D)) {
                return false;
            }
            D d = (D) obj;
            return this.e.equals(d.e) && this.b.equals(d.b) && this.a.equals(d.a);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Tag(colors=");
            sb.append(this.e);
            sb.append(", dimensions=");
            sb.append(this.b);
            sb.append(", typographies=");
            sb.append(this.a);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class c {
        public final b a;
        public final C0010c c;
        public final a e;

        public static c e(c cVar, C0010c c0010c) {
            return new c(cVar.e, c0010c, cVar.a);
        }

        public final int hashCode() {
            int iHashCode = this.e.hashCode();
            return this.a.hashCode() + ((this.c.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final long A;
            public final long B;
            public final long C;
            public final long D;
            public final long E;
            public final long F;
            public final long G;
            public final long H;
            public final long I;
            public final long K;
            public final long L;
            public final long N;
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            public final long k;
            public final long l;
            public final long m;
            public final long n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final long f110o;
            public final long p;
            public final long q;
            public final long r;
            public final long s;
            public final long t;
            public final long u;
            public final long v;
            public final long w;
            public final long x;
            public final long y;
            public final long z;

            public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38) {
                this.c = j;
                this.d = j2;
                this.b = j3;
                this.e = j4;
                this.a = j5;
                this.g = j6;
                this.f = j7;
                this.i = j8;
                this.j = j9;
                this.h = j10;
                this.f110o = j11;
                this.m = j12;
                this.n = j13;
                this.k = j14;
                this.l = j15;
                this.p = j16;
                this.s = j17;
                this.q = j18;
                this.r = j19;
                this.t = j20;
                this.w = j21;
                this.y = j22;
                this.x = j23;
                this.v = j24;
                this.u = j25;
                this.B = j26;
                this.z = j27;
                this.D = j28;
                this.A = j29;
                this.C = j30;
                this.G = j31;
                this.H = j32;
                this.I = j33;
                this.E = j34;
                this.F = j35;
                this.N = j36;
                this.L = j37;
                this.K = j38;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.K) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.c) * 31, 31, this.d), 31, this.b), 31, this.e), 31, this.a), 31, this.g), 31, this.f), 31, this.i), 31, this.j), 31, this.h), 31, this.f110o), 31, this.m), 31, this.n), 31, this.k), 31, this.l), 31, this.p), 31, this.s), 31, this.q), 31, this.r), 31, this.t), 31, this.w), 31, this.y), 31, this.x), 31, this.v), 31, this.u), 31, this.B), 31, this.z), 31, this.D), 31, this.A), 31, this.C), 31, this.G), 31, this.H), 31, this.I), 31, this.E), 31, this.F), 31, this.N), 31, this.L);
            }

            public final String toString() {
                String strG = aFV.g(this.c);
                String strG2 = aFV.g(this.d);
                String strG3 = aFV.g(this.b);
                String strG4 = aFV.g(this.e);
                String strG5 = aFV.g(this.a);
                String strG6 = aFV.g(this.g);
                String strG7 = aFV.g(this.f);
                String strG8 = aFV.g(this.i);
                String strG9 = aFV.g(this.j);
                String strG10 = aFV.g(this.h);
                String strG11 = aFV.g(this.f110o);
                String strG12 = aFV.g(this.m);
                String strG13 = aFV.g(this.n);
                String strG14 = aFV.g(this.k);
                String strG15 = aFV.g(this.l);
                String strG16 = aFV.g(this.p);
                String strG17 = aFV.g(this.s);
                String strG18 = aFV.g(this.q);
                String strG19 = aFV.g(this.r);
                String strG20 = aFV.g(this.t);
                String strG21 = aFV.g(this.w);
                String strG22 = aFV.g(this.y);
                String strG23 = aFV.g(this.x);
                String strG24 = aFV.g(this.v);
                String strG25 = aFV.g(this.u);
                String strG26 = aFV.g(this.B);
                String strG27 = aFV.g(this.z);
                String strG28 = aFV.g(this.D);
                String strG29 = aFV.g(this.A);
                String strG30 = aFV.g(this.C);
                String strG31 = aFV.g(this.G);
                String strG32 = aFV.g(this.H);
                String strG33 = aFV.g(this.I);
                String strG34 = aFV.g(this.E);
                String strG35 = aFV.g(this.F);
                String strG36 = aFV.g(this.N);
                String strG37 = aFV.g(this.L);
                String strG38 = aFV.g(this.K);
                StringBuilder sbD = AbstractC34853zG.d("Colors(borderSupplemental=", strG, ", borderSupplementalDisabled=", strG2, ", borderSupplementalPressed=");
                AbstractC4079bgY.e(sbD, strG3, ", foregroundBrand=", strG4, ", foregroundBrandDisabled=");
                AbstractC4079bgY.e(sbD, strG5, ", foregroundDestructive=", strG6, ", foregroundDestructiveDisabled=");
                AbstractC4079bgY.e(sbD, strG7, ", foregroundPrimary=", strG8, ", foregroundPrimaryDisabled=");
                AbstractC4079bgY.e(sbD, strG9, ", foregroundSecondary=", strG10, ", foregroundSecondaryDisabled=");
                AbstractC4079bgY.e(sbD, strG11, ", foregroundSupplemental=", strG12, ", foregroundSupplementalDisabled=");
                AbstractC4079bgY.e(sbD, strG13, ", foregroundTertiary=", strG14, ", foregroundTertiaryDisabled=");
                AbstractC4079bgY.e(sbD, strG15, ", surfaceBrand=", strG16, ", surfaceBrandDisabled=");
                AbstractC4079bgY.e(sbD, strG17, ", surfaceBrandPressed=", strG18, ", surfaceBrandRipple=");
                AbstractC4079bgY.e(sbD, strG19, ", surfaceDestructive=", strG20, ", surfaceDestructiveDisabled=");
                AbstractC4079bgY.e(sbD, strG21, ", surfaceDestructivePressed=", strG22, ", surfaceDestructiveRipple=");
                AbstractC4079bgY.e(sbD, strG23, ", surfacePrimary=", strG24, ", surfacePrimaryDisabled=");
                AbstractC4079bgY.e(sbD, strG25, ", surfacePrimaryPressed=", strG26, ", surfacePrimaryRipple=");
                AbstractC4079bgY.e(sbD, strG27, ", surfaceSecondary=", strG28, ", surfaceSecondaryDisabled=");
                AbstractC4079bgY.e(sbD, strG29, ", surfaceSecondaryPressed=", strG30, ", surfaceSecondaryRipple=");
                AbstractC4079bgY.e(sbD, strG31, ", surfaceSupplemental=", strG32, ", surfaceSupplementalDisabled=");
                AbstractC4079bgY.e(sbD, strG33, ", surfaceSupplementalPressed=", strG34, ", surfaceSupplementalRipple=");
                AbstractC4079bgY.e(sbD, strG35, ", surfaceTertiary=", strG36, ", surfaceTertiaryPressed=");
                return AbstractC3480bQn.b(sbD, strG37, ", surfaceTertiaryRipple=", strG38, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.c;
                int i = aFV.b;
                return C30372nWu.d(this.c, j) && C30372nWu.d(this.d, aVar.d) && C30372nWu.d(this.b, aVar.b) && C30372nWu.d(this.e, aVar.e) && C30372nWu.d(this.a, aVar.a) && C30372nWu.d(this.g, aVar.g) && C30372nWu.d(this.f, aVar.f) && C30372nWu.d(this.i, aVar.i) && C30372nWu.d(this.j, aVar.j) && C30372nWu.d(this.h, aVar.h) && C30372nWu.d(this.f110o, aVar.f110o) && C30372nWu.d(this.m, aVar.m) && C30372nWu.d(this.n, aVar.n) && C30372nWu.d(this.k, aVar.k) && C30372nWu.d(this.l, aVar.l) && C30372nWu.d(this.p, aVar.p) && C30372nWu.d(this.s, aVar.s) && C30372nWu.d(this.q, aVar.q) && C30372nWu.d(this.r, aVar.r) && C30372nWu.d(this.t, aVar.t) && C30372nWu.d(this.w, aVar.w) && C30372nWu.d(this.y, aVar.y) && C30372nWu.d(this.x, aVar.x) && C30372nWu.d(this.v, aVar.v) && C30372nWu.d(this.u, aVar.u) && C30372nWu.d(this.B, aVar.B) && C30372nWu.d(this.z, aVar.z) && C30372nWu.d(this.D, aVar.D) && C30372nWu.d(this.A, aVar.A) && C30372nWu.d(this.C, aVar.C) && C30372nWu.d(this.G, aVar.G) && C30372nWu.d(this.H, aVar.H) && C30372nWu.d(this.I, aVar.I) && C30372nWu.d(this.E, aVar.E) && C30372nWu.d(this.F, aVar.F) && C30372nWu.d(this.N, aVar.N) && C30372nWu.d(this.L, aVar.L) && C30372nWu.d(this.K, aVar.K);
            }
        }

        public static final class b {
            public final C1546aWg a;
            public final C1546aWg c;
            public final C1546aWg d;

            public final int hashCode() {
                return this.c.hashCode() + aIX.a(this.d, this.a.hashCode() * 31);
            }

            public b(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3) {
                this.a = c1546aWg;
                this.d = c1546aWg2;
                this.c = c1546aWg3;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return nZN.c(this.a, bVar.a) && this.d.equals(bVar.d) && this.c.equals(bVar.c);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.a);
                sb.append(", textLarge=");
                sb.append(this.d);
                sb.append(", textSmall=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$c$c, reason: collision with other inner class name */
        public static final class C0010c {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            public final float j;
            public final float l;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final float f111o;

            public C0010c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
                this.c = f;
                this.d = f2;
                this.e = f3;
                this.a = f4;
                this.b = f5;
                this.f = f6;
                this.i = f7;
                this.h = f8;
                this.j = f9;
                this.g = f10;
                this.f111o = f11;
                this.l = f12;
            }

            public final int hashCode() {
                return Float.hashCode(this.l) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.c) * 31, this.d, 31), this.e, 31), this.a, 31), this.b, 31), this.f, 31), this.i, 31), this.h, 31), this.j, 31), this.g, 31), this.f111o, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.c);
                String strD2 = C3770bah.d(this.d);
                String strD3 = C3770bah.d(this.e);
                String strD4 = C3770bah.d(this.a);
                String strD5 = C3770bah.d(this.b);
                String strD6 = C3770bah.d(this.f);
                String strD7 = C3770bah.d(this.i);
                String strD8 = C3770bah.d(this.h);
                String strD9 = C3770bah.d(this.j);
                String strD10 = C3770bah.d(this.g);
                String strD11 = C3770bah.d(this.f111o);
                String strD12 = C3770bah.d(this.l);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderWidth=", strD2, ", spaceBetweenIconText=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBottom=", strD4, ", spaceBottomLarge=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceBottomSmall=", strD6, ", spaceHorizontal=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceHorizontalLarge=", strD8, ", spaceHorizontalSmall=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceTop=", strD10, ", spaceTopLarge=");
                return AbstractC3480bQn.b(sbD, strD11, ", spaceTopSmall=", strD12, ")");
            }

            public static C0010c a(C0010c c0010c, float f, int i) {
                if ((i & 1) != 0) {
                    f = c0010c.c;
                }
                return new C0010c(f, c0010c.d, c0010c.e, c0010c.a, c0010c.b, (i & 32) != 0 ? c0010c.f : 2.0f, c0010c.i, c0010c.h, (i & JSONzip.end) != 0 ? c0010c.j : 8.0f, c0010c.g, c0010c.f111o, (i & 2048) != 0 ? c0010c.l : 2.0f);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0010c)) {
                    return false;
                }
                C0010c c0010c = (C0010c) obj;
                return C3770bah.b(this.c, c0010c.c) && C3770bah.b(this.d, c0010c.d) && C3770bah.b(this.e, c0010c.e) && C3770bah.b(this.a, c0010c.a) && C3770bah.b(this.b, c0010c.b) && C3770bah.b(this.f, c0010c.f) && C3770bah.b(this.i, c0010c.i) && C3770bah.b(this.h, c0010c.h) && C3770bah.b(this.j, c0010c.j) && C3770bah.b(this.g, c0010c.g) && C3770bah.b(this.f111o, c0010c.f111o) && C3770bah.b(this.l, c0010c.l);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return nZN.c(this.e, cVar.e) && nZN.c(this.c, cVar.c) && nZN.c(this.a, cVar.a);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Button(colors=");
            sb.append(this.e);
            sb.append(", dimensions=");
            sb.append(this.c);
            sb.append(", typographies=");
            sb.append(this.a);
            sb.append(")");
            return sb.toString();
        }

        public c(a aVar, C0010c c0010c, b bVar) {
            this.e = aVar;
            this.c = c0010c;
            this.a = bVar;
        }
    }

    public static final class e {
        public final c a;
        public final C0012e b;
        public final a d;

        public e(c cVar, C0012e c0012e, a aVar) {
            this.a = cVar;
            this.b = c0012e;
            this.d = aVar;
        }

        public final int hashCode() {
            int iHashCode = this.a.hashCode();
            return this.d.hashCode() + ((this.b.hashCode() + (iHashCode * 31)) * 31);
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$e$e, reason: collision with other inner class name */
        public static final class C0012e {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            public final float j;
            private float k;
            public final float m;
            public final float n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final float f112o;

            public C0012e(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
                this.a = f;
                this.d = f2;
                this.b = f3;
                this.c = f4;
                this.e = f5;
                this.k = f6;
                this.h = f7;
                this.j = f8;
                this.i = f9;
                this.g = f10;
                this.f = f11;
                this.f112o = f12;
                this.m = f13;
                this.n = f14;
            }

            public final int hashCode() {
                return Float.hashCode(this.n) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.a) * 31, this.d, 31), this.b, 31), this.c, 31), this.e, 31), this.k, 31), this.h, 31), this.j, 31), this.i, 31), this.g, 31), this.f, 31), this.f112o, 31), this.m, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.a);
                String strD2 = C3770bah.d(this.d);
                String strD3 = C3770bah.d(this.b);
                String strD4 = C3770bah.d(this.c);
                String strD5 = C3770bah.d(this.e);
                String strD6 = C3770bah.d(this.k);
                String strD7 = C3770bah.d(this.h);
                String strD8 = C3770bah.d(this.j);
                String strD9 = C3770bah.d(this.i);
                String strD10 = C3770bah.d(this.g);
                String strD11 = C3770bah.d(this.f);
                String strD12 = C3770bah.d(this.f112o);
                String strD13 = C3770bah.d(this.m);
                String strD14 = C3770bah.d(this.n);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderWidth=", strD2, ", spaceActionStart=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetweenContent=", strD4, ", spaceBetweenContentDismiss=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceCompactAccessoryEnd=", strD6, ", spaceCompactContent=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceCompactContentTop=", strD8, ", spaceCompactIconVertical=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceExpandedAccessoryEnd=", strD10, ", spaceExpandedAccessoryVertical=");
                AbstractC4079bgY.e(sbD, strD11, ", spaceExpandedContentHorizontal=", strD12, ", spaceExpandedContentVertical=");
                return AbstractC3480bQn.b(sbD, strD13, ", spaceExpandedIconVertical=", strD14, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0012e)) {
                    return false;
                }
                C0012e c0012e = (C0012e) obj;
                return C3770bah.b(this.a, c0012e.a) && C3770bah.b(this.d, c0012e.d) && C3770bah.b(this.b, c0012e.b) && C3770bah.b(this.c, c0012e.c) && C3770bah.b(this.e, c0012e.e) && C3770bah.b(this.k, c0012e.k) && C3770bah.b(this.h, c0012e.h) && C3770bah.b(this.j, c0012e.j) && C3770bah.b(this.i, c0012e.i) && C3770bah.b(this.g, c0012e.g) && C3770bah.b(this.f, c0012e.f) && C3770bah.b(this.f112o, c0012e.f112o) && C3770bah.b(this.m, c0012e.m) && C3770bah.b(this.n, c0012e.n);
            }
        }

        public static final class a {
            public final C1546aWg a;
            public final C1546aWg b;
            public final C1546aWg c;

            public a(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3) {
                this.b = c1546aWg;
                this.c = c1546aWg2;
                this.a = c1546aWg3;
            }

            public final int hashCode() {
                return this.a.hashCode() + aIX.a(this.c, this.b.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.b.equals(aVar.b) && this.c.equals(aVar.c) && this.a.equals(aVar.a);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textBody=");
                sb.append(this.b);
                sb.append(", textHeadline=");
                sb.append(this.c);
                sb.append(", textHeadlineSmall=");
                sb.append(this.a);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class c {
            public final long a;
            public final long c;
            public final long d;

            public c(long j, long j2, long j3) {
                this.d = j;
                this.c = j2;
                this.a = j3;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.a) + AbstractC34853zG.e(Long.hashCode(this.d) * 31, 31, this.c);
            }

            public final String toString() {
                String strG = aFV.g(this.d);
                String strG2 = aFV.g(this.c);
                return AbstractC11247f.d(AbstractC34853zG.d("Colors(border=", strG, ", foreground=", strG2, ", surface="), aFV.g(this.a), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                long j = cVar.d;
                int i = aFV.b;
                return C30372nWu.d(this.d, j) && C30372nWu.d(this.c, cVar.c) && C30372nWu.d(this.a, cVar.a);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.a.equals(eVar.a) && this.b.equals(eVar.b) && this.d.equals(eVar.d);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Banner(colors=");
            sb.append(this.a);
            sb.append(", dimensions=");
            sb.append(this.b);
            sb.append(", typographies=");
            sb.append(this.d);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class f {
        public final b b;
        public final c d;

        public final int hashCode() {
            return this.b.hashCode() + (this.d.hashCode() * 31);
        }

        public static final class c {
            public final long A;
            public final long B;
            public final long C;
            public final long D;
            private long E;
            private long F;
            private long G;
            private long H;
            private long I;
            private long J;
            private long K;
            private long L;
            private long M;
            private long N;
            private long Q;
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            public final long k;
            public final long l;
            public final long m;
            public final long n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final long f113o;
            public final long p;
            public final long q;
            public final long r;
            public final long s;
            public final long t;
            public final long u;
            public final long v;
            public final long w;
            public final long x;
            public final long y;
            public final long z;

            public c(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41) {
                this.b = j;
                this.a = j2;
                this.E = j3;
                this.e = j4;
                this.c = j5;
                this.F = j6;
                this.G = j7;
                this.I = j8;
                this.d = j9;
                this.g = j10;
                this.j = j11;
                this.i = j12;
                this.h = j13;
                this.f = j14;
                this.f113o = j15;
                this.k = j16;
                this.n = j17;
                this.l = j18;
                this.m = j19;
                this.p = j20;
                this.H = j21;
                this.t = j22;
                this.s = j23;
                this.r = j24;
                this.K = j25;
                this.M = j26;
                this.q = j27;
                this.y = j28;
                this.J = j29;
                this.v = j30;
                this.u = j31;
                this.x = j32;
                this.N = j33;
                this.w = j34;
                this.B = j35;
                this.D = j36;
                this.L = j37;
                this.A = j38;
                this.z = j39;
                this.Q = j40;
                this.C = j41;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.C) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.b) * 31, 31, this.a), 31, this.E), 31, this.e), 31, this.c), 31, this.F), 31, this.G), 31, this.I), 31, this.d), 31, this.g), 31, this.j), 31, this.i), 31, this.h), 31, this.f), 31, this.f113o), 31, this.k), 31, this.n), 31, this.l), 31, this.m), 31, this.p), 31, this.H), 31, this.t), 31, this.s), 31, this.r), 31, this.K), 31, this.M), 31, this.q), 31, this.y), 31, this.J), 31, this.v), 31, this.u), 31, this.x), 31, this.N), 31, this.w), 31, this.B), 31, this.D), 31, this.L), 31, this.A), 31, this.z), 31, this.Q);
            }

            public final String toString() {
                String strG = aFV.g(this.b);
                String strG2 = aFV.g(this.a);
                String strG3 = aFV.g(this.E);
                String strG4 = aFV.g(this.e);
                String strG5 = aFV.g(this.c);
                String strG6 = aFV.g(this.F);
                String strG7 = aFV.g(this.G);
                String strG8 = aFV.g(this.I);
                String strG9 = aFV.g(this.d);
                String strG10 = aFV.g(this.g);
                String strG11 = aFV.g(this.j);
                String strG12 = aFV.g(this.i);
                String strG13 = aFV.g(this.h);
                String strG14 = aFV.g(this.f);
                String strG15 = aFV.g(this.f113o);
                String strG16 = aFV.g(this.k);
                String strG17 = aFV.g(this.n);
                String strG18 = aFV.g(this.l);
                String strG19 = aFV.g(this.m);
                String strG20 = aFV.g(this.p);
                String strG21 = aFV.g(this.H);
                String strG22 = aFV.g(this.t);
                String strG23 = aFV.g(this.s);
                String strG24 = aFV.g(this.r);
                String strG25 = aFV.g(this.K);
                String strG26 = aFV.g(this.M);
                String strG27 = aFV.g(this.q);
                String strG28 = aFV.g(this.y);
                String strG29 = aFV.g(this.J);
                String strG30 = aFV.g(this.v);
                String strG31 = aFV.g(this.u);
                String strG32 = aFV.g(this.x);
                String strG33 = aFV.g(this.N);
                String strG34 = aFV.g(this.w);
                String strG35 = aFV.g(this.B);
                String strG36 = aFV.g(this.D);
                String strG37 = aFV.g(this.L);
                String strG38 = aFV.g(this.A);
                String strG39 = aFV.g(this.z);
                String strG40 = aFV.g(this.Q);
                String strG41 = aFV.g(this.C);
                StringBuilder sbD = AbstractC34853zG.d("Colors(borderBrand=", strG, ", borderBrandDisabled=", strG2, ", borderBrandPressed=");
                AbstractC4079bgY.e(sbD, strG3, ", borderSupplemental=", strG4, ", borderSupplementalDisabled=");
                AbstractC4079bgY.e(sbD, strG5, ", borderSupplementalPressed=", strG6, ", foregroundBrand=");
                AbstractC4079bgY.e(sbD, strG7, ", foregroundBrandDisabled=", strG8, ", foregroundDestructive=");
                AbstractC4079bgY.e(sbD, strG9, ", foregroundDestructiveDisabled=", strG10, ", foregroundPrimary=");
                AbstractC4079bgY.e(sbD, strG11, ", foregroundPrimaryDisabled=", strG12, ", foregroundSecondary=");
                AbstractC4079bgY.e(sbD, strG13, ", foregroundSecondaryDisabled=", strG14, ", foregroundSupplemental=");
                AbstractC4079bgY.e(sbD, strG15, ", foregroundSupplementalDisabled=", strG16, ", foregroundTertiary=");
                AbstractC4079bgY.e(sbD, strG17, ", foregroundTertiaryDisabled=", strG18, ", surfaceBrand=");
                AbstractC4079bgY.e(sbD, strG19, ", surfaceBrandDisabled=", strG20, ", surfaceBrandPressed=");
                AbstractC4079bgY.e(sbD, strG21, ", surfaceBrandRipple=", strG22, ", surfaceDestructive=");
                AbstractC4079bgY.e(sbD, strG23, ", surfaceDestructiveDisabled=", strG24, ", surfaceDestructivePressed=");
                AbstractC4079bgY.e(sbD, strG25, ", surfaceDestructiveRipple=", strG26, ", surfacePrimary=");
                AbstractC4079bgY.e(sbD, strG27, ", surfacePrimaryDisabled=", strG28, ", surfacePrimaryPressed=");
                AbstractC4079bgY.e(sbD, strG29, ", surfacePrimaryRipple=", strG30, ", surfaceSecondary=");
                AbstractC4079bgY.e(sbD, strG31, ", surfaceSecondaryDisabled=", strG32, ", surfaceSecondaryPressed=");
                AbstractC4079bgY.e(sbD, strG33, ", surfaceSecondaryRipple=", strG34, ", surfaceSupplemental=");
                AbstractC4079bgY.e(sbD, strG35, ", surfaceSupplementalDisabled=", strG36, ", surfaceSupplementalPressed=");
                AbstractC4079bgY.e(sbD, strG37, ", surfaceSupplementalRipple=", strG38, ", surfaceTertiary=");
                AbstractC4079bgY.e(sbD, strG39, ", surfaceTertiaryPressed=", strG40, ", surfaceTertiaryRipple=");
                return AbstractC11247f.d(sbD, strG41, ")");
            }

            public static c d(c cVar, long j, long j2, long j3, int i) {
                return new c(cVar.b, cVar.a, cVar.E, cVar.e, cVar.c, cVar.F, cVar.G, cVar.I, cVar.d, cVar.g, (i & 1024) != 0 ? cVar.j : j, cVar.i, cVar.h, cVar.f, cVar.f113o, cVar.k, (i & AleCryptoBouncyCastle.MAX_RANDOM_BYTES) != 0 ? cVar.n : j2, (i & 131072) != 0 ? cVar.l : j3, cVar.m, cVar.p, cVar.H, cVar.t, cVar.s, cVar.r, cVar.K, cVar.M, cVar.q, cVar.y, cVar.J, cVar.v, cVar.u, cVar.x, cVar.N, cVar.w, cVar.B, cVar.D, cVar.L, cVar.A, cVar.z, cVar.Q, cVar.C);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                long j = cVar.b;
                int i = aFV.b;
                return C30372nWu.d(this.b, j) && C30372nWu.d(this.a, cVar.a) && C30372nWu.d(this.E, cVar.E) && C30372nWu.d(this.e, cVar.e) && C30372nWu.d(this.c, cVar.c) && C30372nWu.d(this.F, cVar.F) && C30372nWu.d(this.G, cVar.G) && C30372nWu.d(this.I, cVar.I) && C30372nWu.d(this.d, cVar.d) && C30372nWu.d(this.g, cVar.g) && C30372nWu.d(this.j, cVar.j) && C30372nWu.d(this.i, cVar.i) && C30372nWu.d(this.h, cVar.h) && C30372nWu.d(this.f, cVar.f) && C30372nWu.d(this.f113o, cVar.f113o) && C30372nWu.d(this.k, cVar.k) && C30372nWu.d(this.n, cVar.n) && C30372nWu.d(this.l, cVar.l) && C30372nWu.d(this.m, cVar.m) && C30372nWu.d(this.p, cVar.p) && C30372nWu.d(this.H, cVar.H) && C30372nWu.d(this.t, cVar.t) && C30372nWu.d(this.s, cVar.s) && C30372nWu.d(this.r, cVar.r) && C30372nWu.d(this.K, cVar.K) && C30372nWu.d(this.M, cVar.M) && C30372nWu.d(this.q, cVar.q) && C30372nWu.d(this.y, cVar.y) && C30372nWu.d(this.J, cVar.J) && C30372nWu.d(this.v, cVar.v) && C30372nWu.d(this.u, cVar.u) && C30372nWu.d(this.x, cVar.x) && C30372nWu.d(this.N, cVar.N) && C30372nWu.d(this.w, cVar.w) && C30372nWu.d(this.B, cVar.B) && C30372nWu.d(this.D, cVar.D) && C30372nWu.d(this.L, cVar.L) && C30372nWu.d(this.A, cVar.A) && C30372nWu.d(this.z, cVar.z) && C30372nWu.d(this.Q, cVar.Q) && C30372nWu.d(this.C, cVar.C);
            }
        }

        public static final class b {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float g;
            public final float j;

            public b(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
                this.d = f;
                this.c = f2;
                this.e = f3;
                this.b = f4;
                this.a = f5;
                this.j = f6;
                this.g = f7;
            }

            public final int hashCode() {
                return Float.hashCode(this.g) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.d) * 31, this.c, 31), this.e, 31), this.b, 31), this.a, 31), this.j, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.d);
                String strD2 = C3770bah.d(this.c);
                String strD3 = C3770bah.d(this.e);
                String strD4 = C3770bah.d(this.b);
                String strD5 = C3770bah.d(this.a);
                String strD6 = C3770bah.d(this.j);
                String strD7 = C3770bah.d(this.g);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderRadiusLarge=", strD2, ", borderRadiusSmall=");
                AbstractC4079bgY.e(sbD, strD3, ", borderWidth=", strD4, ", space=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceLarge=", strD6, ", spaceSmall=");
                return AbstractC11247f.d(sbD, strD7, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return C3770bah.b(this.d, bVar.d) && C3770bah.b(this.c, bVar.c) && C3770bah.b(this.e, bVar.e) && C3770bah.b(this.b, bVar.b) && C3770bah.b(this.a, bVar.a) && C3770bah.b(this.j, bVar.j) && C3770bah.b(this.g, bVar.g);
            }
        }

        public f(c cVar, b bVar) {
            this.d = cVar;
            this.b = bVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return nZN.c(this.d, fVar.d) && this.b.equals(fVar.b);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ButtonIcon(colors=");
            sb.append(this.d);
            sb.append(", dimensions=");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class h {
        public final a b;
        public final c c;
        public final e e;

        public final int hashCode() {
            int iHashCode = this.b.hashCode();
            return this.c.hashCode() + ((this.e.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            public final long k;
            private long l;
            private long m;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private long f115o;

            public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
                this.c = j;
                this.a = j2;
                this.e = j3;
                this.d = j4;
                this.b = j5;
                this.i = j6;
                this.f = j7;
                this.g = j8;
                this.f115o = j9;
                this.j = j10;
                this.h = j11;
                this.k = j12;
                this.m = j13;
                this.l = j14;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.l) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.c) * 31, 31, this.a), 31, this.e), 31, this.d), 31, this.b), 31, this.i), 31, this.f), 31, this.g), 31, this.f115o), 31, this.j), 31, this.h), 31, this.k), 31, this.m);
            }

            public final String toString() {
                String strG = aFV.g(this.c);
                String strG2 = aFV.g(this.a);
                String strG3 = aFV.g(this.e);
                String strG4 = aFV.g(this.d);
                String strG5 = aFV.g(this.b);
                String strG6 = aFV.g(this.i);
                String strG7 = aFV.g(this.f);
                String strG8 = aFV.g(this.g);
                String strG9 = aFV.g(this.f115o);
                String strG10 = aFV.g(this.j);
                String strG11 = aFV.g(this.h);
                String strG12 = aFV.g(this.k);
                String strG13 = aFV.g(this.m);
                String strG14 = aFV.g(this.l);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", borderDisabled=", strG2, ", foreground=");
                AbstractC4079bgY.e(sbD, strG3, ", foregroundDisabled=", strG4, ", foregroundSelected=");
                AbstractC4079bgY.e(sbD, strG5, ", foregroundSelectedDisabled=", strG6, ", surface=");
                AbstractC4079bgY.e(sbD, strG7, ", surfaceDisabled=", strG8, ", surfacePressed=");
                AbstractC4079bgY.e(sbD, strG9, ", surfaceRipple=", strG10, ", surfaceSelected=");
                AbstractC4079bgY.e(sbD, strG11, ", surfaceSelectedDisabled=", strG12, ", surfaceSelectedPressed=");
                return AbstractC3480bQn.b(sbD, strG13, ", surfaceSelectedRipple=", strG14, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.c;
                int i = aFV.b;
                return C30372nWu.d(this.c, j) && C30372nWu.d(this.a, aVar.a) && C30372nWu.d(this.e, aVar.e) && C30372nWu.d(this.d, aVar.d) && C30372nWu.d(this.b, aVar.b) && C30372nWu.d(this.i, aVar.i) && C30372nWu.d(this.f, aVar.f) && C30372nWu.d(this.g, aVar.g) && C30372nWu.d(this.f115o, aVar.f115o) && C30372nWu.d(this.j, aVar.j) && C30372nWu.d(this.h, aVar.h) && C30372nWu.d(this.k, aVar.k) && C30372nWu.d(this.m, aVar.m) && C30372nWu.d(this.l, aVar.l);
            }

            public static a b(a aVar, long j, long j2, long j3, long j4, long j5, int i) {
                return new a((i & 1) != 0 ? aVar.c : j, aVar.a, (i & 4) != 0 ? aVar.e : j2, aVar.d, (i & 16) != 0 ? aVar.b : j3, aVar.i, (i & 64) != 0 ? aVar.f : j4, aVar.g, aVar.f115o, aVar.j, (i & 1024) != 0 ? aVar.h : j5, aVar.k, aVar.m, aVar.l);
            }
        }

        public static final class e {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            public final float j;
            public final float k;
            public final float l;
            public final float m;
            public final float n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final float f116o;
            private float p;
            private float r;
            public final float t;

            public e(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
                this.p = f;
                this.r = f2;
                this.i = f3;
                this.g = f4;
                this.k = f5;
                this.l = f6;
                this.n = f7;
                this.f116o = f8;
                this.m = f9;
                this.t = f10;
                this.f = f11;
                this.h = f12;
                this.d = f13;
                this.c = f14;
                this.j = f15;
                this.e = f16;
                this.a = f17;
                this.b = f18;
            }

            public final int hashCode() {
                return Float.hashCode(this.b) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.p) * 31, this.r, 31), this.i, 31), this.g, 31), this.k, 31), this.l, 31), this.n, 31), this.f116o, 31), this.m, 31), this.t, 31), this.f, 31), this.h, 31), this.d, 31), this.c, 31), this.j, 31), this.e, 31), this.a, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.p);
                String strD2 = C3770bah.d(this.r);
                String strD3 = C3770bah.d(this.i);
                String strD4 = C3770bah.d(this.g);
                String strD5 = C3770bah.d(this.k);
                String strD6 = C3770bah.d(this.l);
                String strD7 = C3770bah.d(this.n);
                String strD8 = C3770bah.d(this.f116o);
                String strD9 = C3770bah.d(this.m);
                String strD10 = C3770bah.d(this.t);
                String strD11 = C3770bah.d(this.f);
                String strD12 = C3770bah.d(this.h);
                String strD13 = C3770bah.d(this.d);
                String strD14 = C3770bah.d(this.c);
                String strD15 = C3770bah.d(this.j);
                String strD16 = C3770bah.d(this.e);
                String strD17 = C3770bah.d(this.a);
                String strD18 = C3770bah.d(this.b);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderRadiusSmall=", strD2, ", borderWidth=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetweenAccessoryText=", strD4, ", spaceBottom=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceBottomSmall=", strD6, ", spaceHorizontal=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceHorizontalSmall=", strD8, ", spaceTop=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceTopSmall=", strD10, ", borderRadiusTopStart=");
                AbstractC4079bgY.e(sbD, strD11, ", borderRadiusTopEnd=", strD12, ", borderRadiusBottomStart=");
                AbstractC4079bgY.e(sbD, strD13, ", borderRadiusBottomEnd=", strD14, ", borderRadiusSmallTopStart=");
                AbstractC4079bgY.e(sbD, strD15, ", borderRadiusSmallTopEnd=", strD16, ", borderRadiusSmallBottomStart=");
                return AbstractC3480bQn.b(sbD, strD17, ", borderRadiusSmallBottomEnd=", strD18, ")");
            }

            public static e d(e eVar, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i) {
                return new e(eVar.p, eVar.r, eVar.i, eVar.g, (i & 16) != 0 ? eVar.k : f, eVar.l, eVar.n, eVar.f116o, (i & JSONzip.end) != 0 ? eVar.m : f2, eVar.t, f3, f4, f5, f6, (i & CursorWindow.DEFAULT_CURSOR_WINDOW_SIZE) != 0 ? eVar.j : f7, (32768 & i) != 0 ? eVar.e : f8, (65536 & i) != 0 ? eVar.a : f9, (i & 131072) != 0 ? eVar.b : f10);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return C3770bah.b(this.p, eVar.p) && C3770bah.b(this.r, eVar.r) && C3770bah.b(this.i, eVar.i) && C3770bah.b(this.g, eVar.g) && C3770bah.b(this.k, eVar.k) && C3770bah.b(this.l, eVar.l) && C3770bah.b(this.n, eVar.n) && C3770bah.b(this.f116o, eVar.f116o) && C3770bah.b(this.m, eVar.m) && C3770bah.b(this.t, eVar.t) && C3770bah.b(this.f, eVar.f) && C3770bah.b(this.h, eVar.h) && C3770bah.b(this.d, eVar.d) && C3770bah.b(this.c, eVar.c) && C3770bah.b(this.j, eVar.j) && C3770bah.b(this.e, eVar.e) && C3770bah.b(this.a, eVar.a) && C3770bah.b(this.b, eVar.b);
            }
        }

        public static final class c {
            public final C1546aWg a;
            public final C1546aWg d;

            public c(C1546aWg c1546aWg, C1546aWg c1546aWg2) {
                this.a = c1546aWg;
                this.d = c1546aWg2;
            }

            public static c b(c cVar, C1546aWg c1546aWg) {
                return new c(c1546aWg, cVar.d);
            }

            public final int hashCode() {
                return this.d.hashCode() + (this.a.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.a.equals(cVar.a) && this.d.equals(cVar.d);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.a);
                sb.append(", textSmall=");
                sb.append(this.d);
                sb.append(")");
                return sb.toString();
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return nZN.c(this.b, hVar.b) && nZN.c(this.e, hVar.e) && nZN.c(this.c, hVar.c);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Chip(colors=");
            sb.append(this.b);
            sb.append(", dimensions=");
            sb.append(this.e);
            sb.append(", typographies=");
            sb.append(this.c);
            sb.append(")");
            return sb.toString();
        }

        public h(a aVar, e eVar, c cVar) {
            this.b = aVar;
            this.e = eVar;
            this.c = cVar;
        }
    }

    public static final class l {
        public final d b;
        public final b c;
        public final a d;

        public l(a aVar, b bVar, d dVar) {
            this.d = aVar;
            this.c = bVar;
            this.b = dVar;
        }

        public final int hashCode() {
            int iHashCode = this.d.hashCode();
            return this.b.hashCode() + ((this.c.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            private long k;
            public final long l;
            public final long m;
            public final long n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private long f117o;
            private long q;
            private long r;

            public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
                this.c = j;
                this.a = j2;
                this.d = j3;
                this.e = j4;
                this.f117o = j5;
                this.b = j6;
                this.h = j7;
                this.i = j8;
                this.g = j9;
                this.f = j10;
                this.j = j11;
                this.m = j12;
                this.n = j13;
                this.l = j14;
                this.k = j15;
                this.q = j16;
                this.r = j17;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.r) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.c) * 31, 31, this.a), 31, this.d), 31, this.e), 31, this.f117o), 31, this.b), 31, this.h), 31, this.i), 31, this.g), 31, this.f), 31, this.j), 31, this.m), 31, this.n), 31, this.l), 31, this.k), 31, this.q);
            }

            public final String toString() {
                String strG = aFV.g(this.c);
                String strG2 = aFV.g(this.a);
                String strG3 = aFV.g(this.d);
                String strG4 = aFV.g(this.e);
                String strG5 = aFV.g(this.f117o);
                String strG6 = aFV.g(this.b);
                String strG7 = aFV.g(this.h);
                String strG8 = aFV.g(this.i);
                String strG9 = aFV.g(this.g);
                String strG10 = aFV.g(this.f);
                String strG11 = aFV.g(this.j);
                String strG12 = aFV.g(this.m);
                String strG13 = aFV.g(this.n);
                String strG14 = aFV.g(this.l);
                String strG15 = aFV.g(this.k);
                String strG16 = aFV.g(this.q);
                String strG17 = aFV.g(this.r);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", borderDisabled=", strG2, ", borderError=");
                AbstractC4079bgY.e(sbD, strG3, ", borderFocused=", strG4, ", borderFocusedOutline=");
                AbstractC4079bgY.e(sbD, strG5, ", borderSuccess=", strG6, ", borderWarning=");
                AbstractC4079bgY.e(sbD, strG7, ", foreground=", strG8, ", foregroundDescription=");
                AbstractC4079bgY.e(sbD, strG9, ", foregroundDisabled=", strG10, ", foregroundLabel=");
                AbstractC4079bgY.e(sbD, strG11, ", foregroundMessageError=", strG12, ", foregroundMessageSuccess=");
                AbstractC4079bgY.e(sbD, strG13, ", foregroundMessageWarning=", strG14, ", surface=");
                AbstractC4079bgY.e(sbD, strG15, ", surfaceDisabled=", strG16, ", surfaceRipple=");
                return AbstractC11247f.d(sbD, strG17, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.c;
                int i = aFV.b;
                return C30372nWu.d(this.c, j) && C30372nWu.d(this.a, aVar.a) && C30372nWu.d(this.d, aVar.d) && C30372nWu.d(this.e, aVar.e) && C30372nWu.d(this.f117o, aVar.f117o) && C30372nWu.d(this.b, aVar.b) && C30372nWu.d(this.h, aVar.h) && C30372nWu.d(this.i, aVar.i) && C30372nWu.d(this.g, aVar.g) && C30372nWu.d(this.f, aVar.f) && C30372nWu.d(this.j, aVar.j) && C30372nWu.d(this.m, aVar.m) && C30372nWu.d(this.n, aVar.n) && C30372nWu.d(this.l, aVar.l) && C30372nWu.d(this.k, aVar.k) && C30372nWu.d(this.q, aVar.q) && C30372nWu.d(this.r, aVar.r);
            }
        }

        public static final class d {
            public final C1546aWg a;
            private C1546aWg c;
            public final C1546aWg d;
            public final C1546aWg e;

            public d(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3, C1546aWg c1546aWg4) {
                this.e = c1546aWg;
                this.c = c1546aWg2;
                this.a = c1546aWg3;
                this.d = c1546aWg4;
            }

            public final int hashCode() {
                return this.d.hashCode() + aIX.a(this.a, aIX.a(this.c, this.e.hashCode() * 31));
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return this.e.equals(dVar.e) && this.c.equals(dVar.c) && this.a.equals(dVar.a) && this.d.equals(dVar.d);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.e);
                sb.append(", textDescription=");
                sb.append(this.c);
                sb.append(", textMessage=");
                sb.append(this.a);
                sb.append(", textSmall=");
                sb.append(this.d);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class b {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            private float f;
            public final float g;
            public final float h;
            public final float i;
            private float j;
            private float m;
            private float n;

            public b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
                this.a = f;
                this.c = f2;
                this.j = f3;
                this.e = f4;
                this.f = f5;
                this.n = f6;
                this.d = f7;
                this.b = f8;
                this.m = f9;
                this.g = f10;
                this.i = f11;
                this.h = f12;
            }

            public final int hashCode() {
                return Float.hashCode(this.h) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.a) * 31, this.c, 31), this.j, 31), this.e, 31), this.f, 31), this.n, 31), this.d, 31), this.b, 31), this.m, 31), this.g, 31), this.i, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.a);
                String strD2 = C3770bah.d(this.c);
                String strD3 = C3770bah.d(this.j);
                String strD4 = C3770bah.d(this.e);
                String strD5 = C3770bah.d(this.f);
                String strD6 = C3770bah.d(this.n);
                String strD7 = C3770bah.d(this.d);
                String strD8 = C3770bah.d(this.b);
                String strD9 = C3770bah.d(this.m);
                String strD10 = C3770bah.d(this.g);
                String strD11 = C3770bah.d(this.i);
                String strD12 = C3770bah.d(this.h);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderWidth=", strD2, ", borderWidthOutline=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetweenItems=", strD4, ", spaceBetweenValidationIconMessage=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceDescriptionTop=", strD6, ", spaceHorizontal=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceHorizontalSmall=", strD8, ", spaceValidationIconVertical=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceValidationTop=", strD10, ", spaceVertical=");
                return AbstractC3480bQn.b(sbD, strD11, ", spaceVerticalSmall=", strD12, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return C3770bah.b(this.a, bVar.a) && C3770bah.b(this.c, bVar.c) && C3770bah.b(this.j, bVar.j) && C3770bah.b(this.e, bVar.e) && C3770bah.b(this.f, bVar.f) && C3770bah.b(this.n, bVar.n) && C3770bah.b(this.d, bVar.d) && C3770bah.b(this.b, bVar.b) && C3770bah.b(this.m, bVar.m) && C3770bah.b(this.g, bVar.g) && C3770bah.b(this.i, bVar.i) && C3770bah.b(this.h, bVar.h);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return this.d.equals(lVar.d) && this.c.equals(lVar.c) && this.b.equals(lVar.b);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("InputPinCode(colors=");
            sb.append(this.d);
            sb.append(", dimensions=");
            sb.append(this.c);
            sb.append(", typographies=");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class m {
        public final a b;
        public final d c;
        public final e d;

        public m(a aVar, e eVar, d dVar) {
            this.b = aVar;
            this.d = eVar;
            this.c = dVar;
        }

        public final int hashCode() {
            int iHashCode = this.b.hashCode();
            return this.c.hashCode() + ((this.d.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            public final long k;
            public final long l;
            public final long m;
            public final long n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final long f118o;
            private long r;
            public final long s;
            private long t;

            public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
                this.d = j;
                this.b = j2;
                this.e = j3;
                this.c = j4;
                this.a = j5;
                this.g = j6;
                this.f = j7;
                this.j = j8;
                this.i = j9;
                this.h = j10;
                this.m = j11;
                this.l = j12;
                this.f118o = j13;
                this.k = j14;
                this.n = j15;
                this.s = j16;
                this.t = j17;
                this.r = j18;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.r) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.d) * 31, 31, this.b), 31, this.e), 31, this.c), 31, this.a), 31, this.g), 31, this.f), 31, this.j), 31, this.i), 31, this.h), 31, this.m), 31, this.l), 31, this.f118o), 31, this.k), 31, this.n), 31, this.s), 31, this.t);
            }

            public final String toString() {
                String strG = aFV.g(this.d);
                String strG2 = aFV.g(this.b);
                String strG3 = aFV.g(this.e);
                String strG4 = aFV.g(this.c);
                String strG5 = aFV.g(this.a);
                String strG6 = aFV.g(this.g);
                String strG7 = aFV.g(this.f);
                String strG8 = aFV.g(this.j);
                String strG9 = aFV.g(this.i);
                String strG10 = aFV.g(this.h);
                String strG11 = aFV.g(this.m);
                String strG12 = aFV.g(this.l);
                String strG13 = aFV.g(this.f118o);
                String strG14 = aFV.g(this.k);
                String strG15 = aFV.g(this.n);
                String strG16 = aFV.g(this.s);
                String strG17 = aFV.g(this.t);
                String strG18 = aFV.g(this.r);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", borderDisabled=", strG2, ", borderError=");
                AbstractC4079bgY.e(sbD, strG3, ", borderFocused=", strG4, ", borderSuccess=");
                AbstractC4079bgY.e(sbD, strG5, ", borderWarning=", strG6, ", foregroundDescription=");
                AbstractC4079bgY.e(sbD, strG7, ", foregroundFilled=", strG8, ", foregroundFilledDisabled=");
                AbstractC4079bgY.e(sbD, strG9, ", foregroundLabel=", strG10, ", foregroundLabelDisabled=");
                AbstractC4079bgY.e(sbD, strG11, ", foregroundMessageChecking=", strG12, ", foregroundMessageError=");
                AbstractC4079bgY.e(sbD, strG13, ", foregroundMessageSuccess=", strG14, ", foregroundMessageWarning=");
                AbstractC4079bgY.e(sbD, strG15, ", surface=", strG16, ", surfaceDisabled=");
                return AbstractC3480bQn.b(sbD, strG17, ", surfaceRipple=", strG18, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.d;
                int i = aFV.b;
                return C30372nWu.d(this.d, j) && C30372nWu.d(this.b, aVar.b) && C30372nWu.d(this.e, aVar.e) && C30372nWu.d(this.c, aVar.c) && C30372nWu.d(this.a, aVar.a) && C30372nWu.d(this.g, aVar.g) && C30372nWu.d(this.f, aVar.f) && C30372nWu.d(this.j, aVar.j) && C30372nWu.d(this.i, aVar.i) && C30372nWu.d(this.h, aVar.h) && C30372nWu.d(this.m, aVar.m) && C30372nWu.d(this.l, aVar.l) && C30372nWu.d(this.f118o, aVar.f118o) && C30372nWu.d(this.k, aVar.k) && C30372nWu.d(this.n, aVar.n) && C30372nWu.d(this.s, aVar.s) && C30372nWu.d(this.t, aVar.t) && C30372nWu.d(this.r, aVar.r);
            }
        }

        public static final class d {
            public final C1546aWg a;
            public final C1546aWg c;
            public final C1546aWg d;
            public final C1546aWg e;

            public d(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3, C1546aWg c1546aWg4) {
                this.e = c1546aWg;
                this.d = c1546aWg2;
                this.a = c1546aWg3;
                this.c = c1546aWg4;
            }

            public final int hashCode() {
                return this.c.hashCode() + aIX.a(this.a, aIX.a(this.d, this.e.hashCode() * 31));
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return this.e.equals(dVar.e) && this.d.equals(dVar.d) && this.a.equals(dVar.a) && this.c.equals(dVar.c);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textFilled=");
                sb.append(this.e);
                sb.append(", textLabel=");
                sb.append(this.d);
                sb.append(", textLabelFilled=");
                sb.append(this.a);
                sb.append(", textMessage=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class e {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            public final float j;
            private float k;
            public final float n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final float f119o;

            public e(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
                this.e = f;
                this.d = f2;
                this.b = f3;
                this.c = f4;
                this.k = f5;
                this.a = f6;
                this.h = f7;
                this.i = f8;
                this.g = f9;
                this.f = f10;
                this.j = f11;
                this.f119o = f12;
                this.n = f13;
            }

            public final int hashCode() {
                return Float.hashCode(this.n) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.e) * 31, this.d, 31), this.b, 31), this.c, 31), this.k, 31), this.a, 31), this.h, 31), this.i, 31), this.g, 31), this.f, 31), this.j, 31), this.f119o, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.e);
                String strD2 = C3770bah.d(this.d);
                String strD3 = C3770bah.d(this.b);
                String strD4 = C3770bah.d(this.c);
                String strD5 = C3770bah.d(this.k);
                String strD6 = C3770bah.d(this.a);
                String strD7 = C3770bah.d(this.h);
                String strD8 = C3770bah.d(this.i);
                String strD9 = C3770bah.d(this.g);
                String strD10 = C3770bah.d(this.f);
                String strD11 = C3770bah.d(this.j);
                String strD12 = C3770bah.d(this.f119o);
                String strD13 = C3770bah.d(this.n);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderWidth=", strD2, ", spaceBetweenIconText=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetweenValidationIconMessage=", strD4, ", spaceDescriptionTop=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceHorizontal=", strD6, ", spaceHorizontalSmall=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceValidationIconVertical=", strD8, ", spaceValidationTop=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceVertical=", strD10, ", spaceVerticalFilled=");
                AbstractC4079bgY.e(sbD, strD11, ", spaceVerticalFilledSmall=", strD12, ", spaceVerticalSmall=");
                return AbstractC11247f.d(sbD, strD13, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return C3770bah.b(this.e, eVar.e) && C3770bah.b(this.d, eVar.d) && C3770bah.b(this.b, eVar.b) && C3770bah.b(this.c, eVar.c) && C3770bah.b(this.k, eVar.k) && C3770bah.b(this.a, eVar.a) && C3770bah.b(this.h, eVar.h) && C3770bah.b(this.i, eVar.i) && C3770bah.b(this.g, eVar.g) && C3770bah.b(this.f, eVar.f) && C3770bah.b(this.j, eVar.j) && C3770bah.b(this.f119o, eVar.f119o) && C3770bah.b(this.n, eVar.n);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return this.b.equals(mVar.b) && this.d.equals(mVar.d) && this.c.equals(mVar.c);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Input(colors=");
            sb.append(this.b);
            sb.append(", dimensions=");
            sb.append(this.d);
            sb.append(", typographies=");
            sb.append(this.c);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class n {
        public final b a;
        public final d b;
        public final c c;

        public n(c cVar, d dVar, b bVar) {
            this.c = cVar;
            this.b = dVar;
            this.a = bVar;
        }

        public final int hashCode() {
            int iHashCode = this.c.hashCode();
            return this.a.hashCode() + ((this.b.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class d {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            private float j;
            private float k;
            private float l;
            private float m;
            private float n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private float f120o;
            private float p;
            private float q;
            private float r;
            private float s;
            private float t;
            private float u;
            private float v;
            private float w;
            private float x;
            private float y;

            public d(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
                this.a = f;
                this.j = f2;
                this.c = f3;
                this.l = f4;
                this.e = f5;
                this.b = f6;
                this.d = f7;
                this.n = f8;
                this.k = f9;
                this.m = f10;
                this.f = f11;
                this.f120o = f12;
                this.h = f13;
                this.s = f14;
                this.t = f15;
                this.p = f16;
                this.q = f17;
                this.r = f18;
                this.i = f19;
                this.w = f20;
                this.v = f21;
                this.y = f22;
                this.g = f23;
                this.x = f24;
                this.u = f25;
            }

            public final int hashCode() {
                return Float.hashCode(this.u) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.a) * 31, this.j, 31), this.c, 31), this.l, 31), this.e, 31), this.b, 31), this.d, 31), this.n, 31), this.k, 31), this.m, 31), this.f, 31), this.f120o, 31), this.h, 31), this.s, 31), this.t, 31), this.p, 31), this.q, 31), this.r, 31), this.i, 31), this.w, 31), this.v, 31), this.y, 31), this.g, 31), this.x, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.a);
                String strD2 = C3770bah.d(this.j);
                String strD3 = C3770bah.d(this.c);
                String strD4 = C3770bah.d(this.l);
                String strD5 = C3770bah.d(this.e);
                String strD6 = C3770bah.d(this.b);
                String strD7 = C3770bah.d(this.d);
                String strD8 = C3770bah.d(this.n);
                String strD9 = C3770bah.d(this.k);
                String strD10 = C3770bah.d(this.m);
                String strD11 = C3770bah.d(this.f);
                String strD12 = C3770bah.d(this.f120o);
                String strD13 = C3770bah.d(this.h);
                String strD14 = C3770bah.d(this.s);
                String strD15 = C3770bah.d(this.t);
                String strD16 = C3770bah.d(this.p);
                String strD17 = C3770bah.d(this.q);
                String strD18 = C3770bah.d(this.r);
                String strD19 = C3770bah.d(this.i);
                String strD20 = C3770bah.d(this.w);
                String strD21 = C3770bah.d(this.v);
                String strD22 = C3770bah.d(this.y);
                String strD23 = C3770bah.d(this.g);
                String strD24 = C3770bah.d(this.x);
                String strD25 = C3770bah.d(this.u);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderRadiusContent=", strD2, ", borderWidth=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceAround=", strD4, ", spaceAroundCompact=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceAroundExpanded=", strD6, ", spaceBetweenContent=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceBetweenHeader=", strD8, ", spaceBottomContainedCompact=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceBottomPlayback=", strD10, ", spaceEndDismiss=");
                AbstractC4079bgY.e(sbD, strD11, ", spaceEndLogo=", strD12, ", spaceHorizontal=");
                AbstractC4079bgY.e(sbD, strD13, ", spaceHorizontalCompact=", strD14, ", spaceHorizontalContainedCompact=");
                AbstractC4079bgY.e(sbD, strD15, ", spaceStartPlayback=", strD16, ", spaceTop=");
                AbstractC4079bgY.e(sbD, strD17, ", spaceTopContainedCompact=", strD18, ", spaceTopDismiss=");
                AbstractC4079bgY.e(sbD, strD19, ", spaceTopImageContainedCompact=", strD20, ", spaceTopLogo=");
                AbstractC4079bgY.e(sbD, strD21, ", spaceTopPictogramFullscreen=", strD22, ", spaceVertical=");
                AbstractC4079bgY.e(sbD, strD23, ", spaceVerticalCompact=", strD24, ", spaceVerticalPictogram=");
                return AbstractC11247f.d(sbD, strD25, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return C3770bah.b(this.a, dVar.a) && C3770bah.b(this.j, dVar.j) && C3770bah.b(this.c, dVar.c) && C3770bah.b(this.l, dVar.l) && C3770bah.b(this.e, dVar.e) && C3770bah.b(this.b, dVar.b) && C3770bah.b(this.d, dVar.d) && C3770bah.b(this.n, dVar.n) && C3770bah.b(this.k, dVar.k) && C3770bah.b(this.m, dVar.m) && C3770bah.b(this.f, dVar.f) && C3770bah.b(this.f120o, dVar.f120o) && C3770bah.b(this.h, dVar.h) && C3770bah.b(this.s, dVar.s) && C3770bah.b(this.t, dVar.t) && C3770bah.b(this.p, dVar.p) && C3770bah.b(this.q, dVar.q) && C3770bah.b(this.r, dVar.r) && C3770bah.b(this.i, dVar.i) && C3770bah.b(this.w, dVar.w) && C3770bah.b(this.v, dVar.v) && C3770bah.b(this.y, dVar.y) && C3770bah.b(this.g, dVar.g) && C3770bah.b(this.x, dVar.x) && C3770bah.b(this.u, dVar.u);
            }
        }

        public static final class b {
            public final C1546aWg a;
            public final C1546aWg b;
            public final C1546aWg c;
            public final C1546aWg d;

            public b(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3, C1546aWg c1546aWg4) {
                this.b = c1546aWg;
                this.a = c1546aWg2;
                this.c = c1546aWg3;
                this.d = c1546aWg4;
            }

            public final int hashCode() {
                return this.d.hashCode() + aIX.a(this.c, aIX.a(this.a, this.b.hashCode() * 31));
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.b.equals(bVar.b) && this.a.equals(bVar.a) && this.c.equals(bVar.c) && this.d.equals(bVar.d);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textBody=");
                sb.append(this.b);
                sb.append(", textEyebrow=");
                sb.append(this.a);
                sb.append(", textFinePrint=");
                sb.append(this.c);
                sb.append(", textHeadline=");
                sb.append(this.d);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class c {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            private long e;
            private long f;
            private long g;
            private long i;

            public c(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
                this.b = j;
                this.e = j2;
                this.d = j3;
                this.g = j4;
                this.a = j5;
                this.c = j6;
                this.i = j7;
                this.f = j8;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.f) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.b) * 31, 31, this.e), 31, this.d), 31, this.g), 31, this.a), 31, this.c), 31, this.i);
            }

            public final String toString() {
                String strG = aFV.g(this.b);
                String strG2 = aFV.g(this.e);
                String strG3 = aFV.g(this.d);
                String strG4 = aFV.g(this.g);
                String strG5 = aFV.g(this.a);
                String strG6 = aFV.g(this.c);
                String strG7 = aFV.g(this.i);
                String strG8 = aFV.g(this.f);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", borderContent=", strG2, ", foreground=");
                AbstractC4079bgY.e(sbD, strG3, ", foregroundFinePrint=", strG4, ", foregroundHeadline=");
                AbstractC4079bgY.e(sbD, strG5, ", surface=", strG6, ", surfaceContent=");
                return AbstractC3480bQn.b(sbD, strG7, ", surfaceScrim=", strG8, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                long j = cVar.b;
                int i = aFV.b;
                return C30372nWu.d(this.b, j) && C30372nWu.d(this.e, cVar.e) && C30372nWu.d(this.d, cVar.d) && C30372nWu.d(this.g, cVar.g) && C30372nWu.d(this.a, cVar.a) && C30372nWu.d(this.c, cVar.c) && C30372nWu.d(this.i, cVar.i) && C30372nWu.d(this.f, cVar.f);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return this.c.equals(nVar.c) && this.b.equals(nVar.b) && this.a.equals(nVar.a);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Dialog(colors=");
            sb.append(this.c);
            sb.append(", dimensions=");
            sb.append(this.b);
            sb.append(", typographies=");
            sb.append(this.a);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class o {
        public final a a;
        public final c c;
        public final b e;

        public o(a aVar, c cVar, b bVar) {
            this.a = aVar;
            this.c = cVar;
            this.e = bVar;
        }

        public final int hashCode() {
            int iHashCode = this.a.hashCode();
            return this.e.hashCode() + ((this.c.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            public final long k;
            public final long l;
            public final long m;
            public final long n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final long f121o;
            private long p;
            public final long r;

            public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
                this.a = j;
                this.b = j2;
                this.d = j3;
                this.e = j4;
                this.c = j5;
                this.h = j6;
                this.g = j7;
                this.f = j8;
                this.i = j9;
                this.j = j10;
                this.m = j11;
                this.l = j12;
                this.f121o = j13;
                this.n = j14;
                this.k = j15;
                this.p = j16;
                this.r = j17;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.r) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.a) * 31, 31, this.b), 31, this.d), 31, this.e), 31, this.c), 31, this.h), 31, this.g), 31, this.f), 31, this.i), 31, this.j), 31, this.m), 31, this.l), 31, this.f121o), 31, this.n), 31, this.k), 31, this.p);
            }

            public final String toString() {
                String strG = aFV.g(this.a);
                String strG2 = aFV.g(this.b);
                String strG3 = aFV.g(this.d);
                String strG4 = aFV.g(this.e);
                String strG5 = aFV.g(this.c);
                String strG6 = aFV.g(this.h);
                String strG7 = aFV.g(this.g);
                String strG8 = aFV.g(this.f);
                String strG9 = aFV.g(this.i);
                String strG10 = aFV.g(this.j);
                String strG11 = aFV.g(this.m);
                String strG12 = aFV.g(this.l);
                String strG13 = aFV.g(this.f121o);
                String strG14 = aFV.g(this.n);
                String strG15 = aFV.g(this.k);
                String strG16 = aFV.g(this.p);
                String strG17 = aFV.g(this.r);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", borderDisabled=", strG2, ", borderError=");
                AbstractC4079bgY.e(sbD, strG3, ", borderFocused=", strG4, ", borderSuccess=");
                AbstractC4079bgY.e(sbD, strG5, ", borderWarning=", strG6, ", foregroundDescription=");
                AbstractC4079bgY.e(sbD, strG7, ", foregroundFilled=", strG8, ", foregroundFilledDisabled=");
                AbstractC4079bgY.e(sbD, strG9, ", foregroundLabel=", strG10, ", foregroundLabelDisabled=");
                AbstractC4079bgY.e(sbD, strG11, ", foregroundMessageError=", strG12, ", foregroundMessageSuccess=");
                AbstractC4079bgY.e(sbD, strG13, ", foregroundMessageWarning=", strG14, ", surface=");
                AbstractC4079bgY.e(sbD, strG15, ", surfaceDisabled=", strG16, ", surfaceRipple=");
                return AbstractC11247f.d(sbD, strG17, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.a;
                int i = aFV.b;
                return C30372nWu.d(this.a, j) && C30372nWu.d(this.b, aVar.b) && C30372nWu.d(this.d, aVar.d) && C30372nWu.d(this.e, aVar.e) && C30372nWu.d(this.c, aVar.c) && C30372nWu.d(this.h, aVar.h) && C30372nWu.d(this.g, aVar.g) && C30372nWu.d(this.f, aVar.f) && C30372nWu.d(this.i, aVar.i) && C30372nWu.d(this.j, aVar.j) && C30372nWu.d(this.m, aVar.m) && C30372nWu.d(this.l, aVar.l) && C30372nWu.d(this.f121o, aVar.f121o) && C30372nWu.d(this.n, aVar.n) && C30372nWu.d(this.k, aVar.k) && C30372nWu.d(this.p, aVar.p) && C30372nWu.d(this.r, aVar.r);
            }
        }

        public static final class c {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            public final float j;
            public final float k;
            public final float l;
            private float m;
            public final float n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private float f122o;

            public c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
                this.e = f;
                this.d = f2;
                this.c = f3;
                this.a = f4;
                this.b = f5;
                this.f122o = f6;
                this.h = f7;
                this.g = f8;
                this.m = f9;
                this.i = f10;
                this.f = f11;
                this.j = f12;
                this.k = f13;
                this.l = f14;
                this.n = f15;
            }

            public final int hashCode() {
                return Float.hashCode(this.n) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.e) * 31, this.d, 31), this.c, 31), this.a, 31), this.b, 31), this.f122o, 31), this.h, 31), this.g, 31), this.m, 31), this.i, 31), this.f, 31), this.j, 31), this.k, 31), this.l, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.e);
                String strD2 = C3770bah.d(this.d);
                String strD3 = C3770bah.d(this.c);
                String strD4 = C3770bah.d(this.a);
                String strD5 = C3770bah.d(this.b);
                String strD6 = C3770bah.d(this.f122o);
                String strD7 = C3770bah.d(this.h);
                String strD8 = C3770bah.d(this.g);
                String strD9 = C3770bah.d(this.m);
                String strD10 = C3770bah.d(this.i);
                String strD11 = C3770bah.d(this.f);
                String strD12 = C3770bah.d(this.j);
                String strD13 = C3770bah.d(this.k);
                String strD14 = C3770bah.d(this.l);
                String strD15 = C3770bah.d(this.n);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderWidth=", strD2, ", spaceBetweenIconText=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetweenRegion=", strD4, ", spaceBetweenValidationIconMessage=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceDescriptionTop=", strD6, ", spaceHorizontal=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceHorizontalSmall=", strD8, ", spaceTopLabelFilled=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceValidationIconVertical=", strD10, ", spaceValidationTop=");
                AbstractC4079bgY.e(sbD, strD11, ", spaceVertical=", strD12, ", spaceVerticalFilled=");
                AbstractC4079bgY.e(sbD, strD13, ", spaceVerticalFilledSmall=", strD14, ", spaceVerticalSmall=");
                return AbstractC11247f.d(sbD, strD15, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return C3770bah.b(this.e, cVar.e) && C3770bah.b(this.d, cVar.d) && C3770bah.b(this.c, cVar.c) && C3770bah.b(this.a, cVar.a) && C3770bah.b(this.b, cVar.b) && C3770bah.b(this.f122o, cVar.f122o) && C3770bah.b(this.h, cVar.h) && C3770bah.b(this.g, cVar.g) && C3770bah.b(this.m, cVar.m) && C3770bah.b(this.i, cVar.i) && C3770bah.b(this.f, cVar.f) && C3770bah.b(this.j, cVar.j) && C3770bah.b(this.k, cVar.k) && C3770bah.b(this.l, cVar.l) && C3770bah.b(this.n, cVar.n);
            }
        }

        public static final class b {
            public final C1546aWg a;
            public final C1546aWg c;
            public final C1546aWg d;
            public final C1546aWg e;

            public b(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3, C1546aWg c1546aWg4) {
                this.d = c1546aWg;
                this.c = c1546aWg2;
                this.e = c1546aWg3;
                this.a = c1546aWg4;
            }

            public final int hashCode() {
                return this.a.hashCode() + aIX.a(this.e, aIX.a(this.c, this.d.hashCode() * 31));
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.d.equals(bVar.d) && this.c.equals(bVar.c) && this.e.equals(bVar.e) && this.a.equals(bVar.a);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textFilled=");
                sb.append(this.d);
                sb.append(", textLabel=");
                sb.append(this.c);
                sb.append(", textLabelFilled=");
                sb.append(this.e);
                sb.append(", textMessage=");
                sb.append(this.a);
                sb.append(")");
                return sb.toString();
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            o oVar = (o) obj;
            return this.a.equals(oVar.a) && this.c.equals(oVar.c) && this.e.equals(oVar.e);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("InputPhoneNumber(colors=");
            sb.append(this.a);
            sb.append(", dimensions=");
            sb.append(this.c);
            sb.append(", typographies=");
            sb.append(this.e);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class r {
        public final a b;
        public final b d;
        public final e e;

        public r(a aVar, b bVar, e eVar) {
            this.b = aVar;
            this.d = bVar;
            this.e = eVar;
        }

        public final int hashCode() {
            int iHashCode = this.b.hashCode();
            return this.e.hashCode() + ((this.d.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            public final long k;
            private long l;
            public final long m;
            public final long n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private long f123o;
            private long r;
            private long t;

            public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
                this.c = j;
                this.f123o = j2;
                this.a = j3;
                this.d = j4;
                this.b = j5;
                this.e = j6;
                this.g = j7;
                this.j = j8;
                this.l = j9;
                this.i = j10;
                this.r = j11;
                this.h = j12;
                this.f = j13;
                this.m = j14;
                this.k = j15;
                this.n = j16;
                this.t = j17;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.t) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.c) * 31, 31, this.f123o), 31, this.a), 31, this.d), 31, this.b), 31, this.e), 31, this.g), 31, this.j), 31, this.l), 31, this.i), 31, this.r), 31, this.h), 31, this.f), 31, this.m), 31, this.k), 31, this.n);
            }

            public final String toString() {
                String strG = aFV.g(this.c);
                String strG2 = aFV.g(this.f123o);
                String strG3 = aFV.g(this.a);
                String strG4 = aFV.g(this.d);
                String strG5 = aFV.g(this.b);
                String strG6 = aFV.g(this.e);
                String strG7 = aFV.g(this.g);
                String strG8 = aFV.g(this.j);
                String strG9 = aFV.g(this.l);
                String strG10 = aFV.g(this.i);
                String strG11 = aFV.g(this.r);
                String strG12 = aFV.g(this.h);
                String strG13 = aFV.g(this.f);
                String strG14 = aFV.g(this.m);
                String strG15 = aFV.g(this.k);
                String strG16 = aFV.g(this.n);
                String strG17 = aFV.g(this.t);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", borderDisabled=", strG2, ", borderError=");
                AbstractC4079bgY.e(sbD, strG3, ", borderFocused=", strG4, ", borderSuccess=");
                AbstractC4079bgY.e(sbD, strG5, ", borderWarning=", strG6, ", foregroundDescription=");
                AbstractC4079bgY.e(sbD, strG7, ", foregroundFilled=", strG8, ", foregroundFilledDisabled=");
                AbstractC4079bgY.e(sbD, strG9, ", foregroundLabel=", strG10, ", foregroundLabelDisabled=");
                AbstractC4079bgY.e(sbD, strG11, ", foregroundMessageChecking=", strG12, ", foregroundMessageError=");
                AbstractC4079bgY.e(sbD, strG13, ", foregroundMessageSuccess=", strG14, ", foregroundMessageWarning=");
                AbstractC4079bgY.e(sbD, strG15, ", surface=", strG16, ", surfaceDisabled=");
                return AbstractC11247f.d(sbD, strG17, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.c;
                int i = aFV.b;
                return C30372nWu.d(this.c, j) && C30372nWu.d(this.f123o, aVar.f123o) && C30372nWu.d(this.a, aVar.a) && C30372nWu.d(this.d, aVar.d) && C30372nWu.d(this.b, aVar.b) && C30372nWu.d(this.e, aVar.e) && C30372nWu.d(this.g, aVar.g) && C30372nWu.d(this.j, aVar.j) && C30372nWu.d(this.l, aVar.l) && C30372nWu.d(this.i, aVar.i) && C30372nWu.d(this.r, aVar.r) && C30372nWu.d(this.h, aVar.h) && C30372nWu.d(this.f, aVar.f) && C30372nWu.d(this.m, aVar.m) && C30372nWu.d(this.k, aVar.k) && C30372nWu.d(this.n, aVar.n) && C30372nWu.d(this.t, aVar.t);
            }
        }

        public static final class e {
            public final C1546aWg a;
            public final C1546aWg c;
            public final C1546aWg d;
            public final C1546aWg e;

            public e(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3, C1546aWg c1546aWg4) {
                this.d = c1546aWg;
                this.e = c1546aWg2;
                this.a = c1546aWg3;
                this.c = c1546aWg4;
            }

            public final int hashCode() {
                return this.c.hashCode() + aIX.a(this.a, aIX.a(this.e, this.d.hashCode() * 31));
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return this.d.equals(eVar.d) && this.e.equals(eVar.e) && this.a.equals(eVar.a) && this.c.equals(eVar.c);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textFilled=");
                sb.append(this.d);
                sb.append(", textLabel=");
                sb.append(this.e);
                sb.append(", textLabelFilled=");
                sb.append(this.a);
                sb.append(", textMessage=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class b {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            private float j;

            public b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
                this.d = f;
                this.e = f2;
                this.a = f3;
                this.b = f4;
                this.j = f5;
                this.c = f6;
                this.i = f7;
                this.f = f8;
                this.h = f9;
                this.g = f10;
            }

            public final int hashCode() {
                return Float.hashCode(this.g) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.d) * 31, this.e, 31), this.a, 31), this.b, 31), this.j, 31), this.c, 31), this.i, 31), this.f, 31), this.h, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.d);
                String strD2 = C3770bah.d(this.e);
                String strD3 = C3770bah.d(this.a);
                String strD4 = C3770bah.d(this.b);
                String strD5 = C3770bah.d(this.j);
                String strD6 = C3770bah.d(this.c);
                String strD7 = C3770bah.d(this.i);
                String strD8 = C3770bah.d(this.f);
                String strD9 = C3770bah.d(this.h);
                String strD10 = C3770bah.d(this.g);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderWidth=", strD2, ", spaceBetweenIconText=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetweenValidationIconMessage=", strD4, ", spaceDescriptionTop=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceHorizontal=", strD6, ", spaceValidationIconVertical=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceValidationTop=", strD8, ", spaceVertical=");
                return AbstractC3480bQn.b(sbD, strD9, ", spaceVerticalFilled=", strD10, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return C3770bah.b(this.d, bVar.d) && C3770bah.b(this.e, bVar.e) && C3770bah.b(this.a, bVar.a) && C3770bah.b(this.b, bVar.b) && C3770bah.b(this.j, bVar.j) && C3770bah.b(this.c, bVar.c) && C3770bah.b(this.i, bVar.i) && C3770bah.b(this.f, bVar.f) && C3770bah.b(this.h, bVar.h) && C3770bah.b(this.g, bVar.g);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof r)) {
                return false;
            }
            r rVar = (r) obj;
            return this.b.equals(rVar.b) && this.d.equals(rVar.d) && this.e.equals(rVar.e);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("InputTextArea(colors=");
            sb.append(this.b);
            sb.append(", dimensions=");
            sb.append(this.d);
            sb.append(", typographies=");
            sb.append(this.e);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class u {
        public final d b;
        private e e;

        public u(d dVar, e eVar) {
            this.b = dVar;
            this.e = eVar;
        }

        public final int hashCode() {
            return Float.hashCode(this.e.b) + (this.b.hashCode() * 31);
        }

        public static final class d {
            private long A;
            private long C;
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            public final long k;
            private long l;
            public final long m;
            private long n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private long f125o;
            private long p;
            private long q;
            private long r;
            private long s;
            private long t;
            private long u;
            private long v;
            private long w;
            private long x;
            private long y;
            private long z;

            public d(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28) {
                this.e = j;
                this.a = j2;
                this.d = j3;
                this.c = j4;
                this.n = j5;
                this.b = j6;
                this.f125o = j7;
                this.l = j8;
                this.s = j9;
                this.r = j10;
                this.j = j11;
                this.h = j12;
                this.p = j13;
                this.i = j14;
                this.g = j15;
                this.t = j16;
                this.f = j17;
                this.k = j18;
                this.q = j19;
                this.v = j20;
                this.x = j21;
                this.u = j22;
                this.y = j23;
                this.w = j24;
                this.C = j25;
                this.A = j26;
                this.z = j27;
                this.m = j28;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.m) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.e) * 31, 31, this.a), 31, this.d), 31, this.c), 31, this.n), 31, this.b), 31, this.f125o), 31, this.l), 31, this.s), 31, this.r), 31, this.j), 31, this.h), 31, this.p), 31, this.i), 31, this.g), 31, this.t), 31, this.f), 31, this.k), 31, this.q), 31, this.v), 31, this.x), 31, this.u), 31, this.y), 31, this.w), 31, this.C), 31, this.A), 31, this.z);
            }

            public final String toString() {
                String strG = aFV.g(this.e);
                String strG2 = aFV.g(this.a);
                String strG3 = aFV.g(this.d);
                String strG4 = aFV.g(this.c);
                String strG5 = aFV.g(this.n);
                String strG6 = aFV.g(this.b);
                String strG7 = aFV.g(this.f125o);
                String strG8 = aFV.g(this.l);
                String strG9 = aFV.g(this.s);
                String strG10 = aFV.g(this.r);
                String strG11 = aFV.g(this.j);
                String strG12 = aFV.g(this.h);
                String strG13 = aFV.g(this.p);
                String strG14 = aFV.g(this.i);
                String strG15 = aFV.g(this.g);
                String strG16 = aFV.g(this.t);
                String strG17 = aFV.g(this.f);
                String strG18 = aFV.g(this.k);
                String strG19 = aFV.g(this.q);
                String strG20 = aFV.g(this.v);
                String strG21 = aFV.g(this.x);
                String strG22 = aFV.g(this.u);
                String strG23 = aFV.g(this.y);
                String strG24 = aFV.g(this.w);
                String strG25 = aFV.g(this.C);
                String strG26 = aFV.g(this.A);
                String strG27 = aFV.g(this.z);
                String strG28 = aFV.g(this.m);
                StringBuilder sbD = AbstractC34853zG.d("Colors(borderAndroid=", strG, ", borderAndroidDisabled=", strG2, ", foregroundAndroid=");
                AbstractC4079bgY.e(sbD, strG3, ", foregroundAndroidDisabled=", strG4, ", foregroundAndroidSelected=");
                AbstractC4079bgY.e(sbD, strG5, ", foregroundAndroidSelectedDisabled=", strG6, ", foregroundIos=");
                AbstractC4079bgY.e(sbD, strG7, ", foregroundIosDisabled=", strG8, ", foregroundIosSelected=");
                AbstractC4079bgY.e(sbD, strG9, ", foregroundIosSelectedDisabled=", strG10, ", surfaceAndroid=");
                AbstractC4079bgY.e(sbD, strG11, ", surfaceAndroidDisabled=", strG12, ", surfaceAndroidPressed=");
                AbstractC4079bgY.e(sbD, strG13, ", surfaceAndroidSelected=", strG14, ", surfaceAndroidSelectedDisabled=");
                AbstractC4079bgY.e(sbD, strG15, ", surfaceAndroidSelectedPressed=", strG16, ", surfaceAndroidSlider=");
                AbstractC4079bgY.e(sbD, strG17, ", surfaceAndroidSliderDisabled=", strG18, ", surfaceAndroidSliderPressed=");
                AbstractC4079bgY.e(sbD, strG19, ", surfaceAndroidSliderSelected=", strG20, ", surfaceAndroidSliderSelectedDisabled=");
                AbstractC4079bgY.e(sbD, strG21, ", surfaceIos=", strG22, ", surfaceIosDisabled=");
                AbstractC4079bgY.e(sbD, strG23, ", surfaceIosSelected=", strG24, ", surfaceIosSelectedDisabled=");
                AbstractC4079bgY.e(sbD, strG25, ", surfaceIosSlider=", strG26, ", surfaceIosSliderDisabled=");
                return AbstractC3480bQn.b(sbD, strG27, ", surfaceRipple=", strG28, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                long j = dVar.e;
                int i = aFV.b;
                return C30372nWu.d(this.e, j) && C30372nWu.d(this.a, dVar.a) && C30372nWu.d(this.d, dVar.d) && C30372nWu.d(this.c, dVar.c) && C30372nWu.d(this.n, dVar.n) && C30372nWu.d(this.b, dVar.b) && C30372nWu.d(this.f125o, dVar.f125o) && C30372nWu.d(this.l, dVar.l) && C30372nWu.d(this.s, dVar.s) && C30372nWu.d(this.r, dVar.r) && C30372nWu.d(this.j, dVar.j) && C30372nWu.d(this.h, dVar.h) && C30372nWu.d(this.p, dVar.p) && C30372nWu.d(this.i, dVar.i) && C30372nWu.d(this.g, dVar.g) && C30372nWu.d(this.t, dVar.t) && C30372nWu.d(this.f, dVar.f) && C30372nWu.d(this.k, dVar.k) && C30372nWu.d(this.q, dVar.q) && C30372nWu.d(this.v, dVar.v) && C30372nWu.d(this.x, dVar.x) && C30372nWu.d(this.u, dVar.u) && C30372nWu.d(this.y, dVar.y) && C30372nWu.d(this.w, dVar.w) && C30372nWu.d(this.C, dVar.C) && C30372nWu.d(this.A, dVar.A) && C30372nWu.d(this.z, dVar.z) && C30372nWu.d(this.m, dVar.m);
            }
        }

        public static final class e {
            public final float b;

            public e(float f) {
                this.b = f;
            }

            public final int hashCode() {
                return Float.hashCode(this.b);
            }

            public final String toString() {
                return AbstractC11247f.e("Dimensions(spaceToggleStart=", C3770bah.d(this.b), ")");
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof e) && C3770bah.b(this.b, ((e) obj).b);
                }
                return true;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof u)) {
                return false;
            }
            u uVar = (u) obj;
            return this.b.equals(uVar.b) && this.e.equals(uVar.e);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Switch(colors=");
            sb.append(this.b);
            sb.append(", dimensions=");
            sb.append(this.e);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class w {
        public final d b;
        public final e c;
        public final b e;

        public final int hashCode() {
            int iHashCode = this.e.hashCode();
            return this.b.e.hashCode() + ((this.c.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class e {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            public final float j;
            public final float k;
            public final float l;
            public final float m;
            private float n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final float f126o;

            public e(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
                this.c = f;
                this.n = f2;
                this.a = f3;
                this.b = f4;
                this.e = f5;
                this.j = f6;
                this.i = f7;
                this.g = f8;
                this.f = f9;
                this.h = f10;
                this.m = f11;
                this.f126o = f12;
                this.k = f13;
                this.l = f14;
                this.d = f15;
            }

            public final int hashCode() {
                return Float.hashCode(this.d) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.c) * 31, this.n, 31), this.a, 31), this.b, 31), this.e, 31), this.j, 31), this.i, 31), this.g, 31), this.f, 31), this.h, 31), this.m, 31), this.f126o, 31), this.k, 31), this.l, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.c);
                String strD2 = C3770bah.d(this.n);
                String strD3 = C3770bah.d(this.a);
                String strD4 = C3770bah.d(this.b);
                String strD5 = C3770bah.d(this.e);
                String strD6 = C3770bah.d(this.j);
                String strD7 = C3770bah.d(this.i);
                String strD8 = C3770bah.d(this.g);
                String strD9 = C3770bah.d(this.f);
                String strD10 = C3770bah.d(this.h);
                String strD11 = C3770bah.d(this.m);
                String strD12 = C3770bah.d(this.f126o);
                String strD13 = C3770bah.d(this.k);
                String strD14 = C3770bah.d(this.l);
                String strD15 = C3770bah.d(this.d);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadiusTop=", strD, ", spaceBetweenGrabberContainer=", strD2, ", spaceBetweenHeadlineDismiss=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceDismissBottom=", strD4, ", spaceDismissEnd=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceDismissTop=", strD6, ", spaceGrabberBottom=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceGrabberTop=", strD8, ", spaceHeadlineBottom=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceHeadlineCenteredEnd=", strD10, ", spaceHeadlineCenteredStart=");
                AbstractC4079bgY.e(sbD, strD11, ", spaceHeadlineEnd=", strD12, ", spaceHeadlineStart=");
                AbstractC4079bgY.e(sbD, strD13, ", spaceHeadlineTop=", strD14, ", maxWidth=");
                return AbstractC11247f.d(sbD, strD15, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return C3770bah.b(this.c, eVar.c) && C3770bah.b(this.n, eVar.n) && C3770bah.b(this.a, eVar.a) && C3770bah.b(this.b, eVar.b) && C3770bah.b(this.e, eVar.e) && C3770bah.b(this.j, eVar.j) && C3770bah.b(this.i, eVar.i) && C3770bah.b(this.g, eVar.g) && C3770bah.b(this.f, eVar.f) && C3770bah.b(this.h, eVar.h) && C3770bah.b(this.m, eVar.m) && C3770bah.b(this.f126o, eVar.f126o) && C3770bah.b(this.k, eVar.k) && C3770bah.b(this.l, eVar.l) && C3770bah.b(this.d, eVar.d);
            }
        }

        public static final class b {
            private long b;
            public final long d;
            public final long e;

            public b(long j, long j2, long j3) {
                this.d = j;
                this.b = j2;
                this.e = j3;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.e) + AbstractC34853zG.e(Long.hashCode(this.d) * 31, 31, this.b);
            }

            public final String toString() {
                String strG = aFV.g(this.d);
                String strG2 = aFV.g(this.b);
                return AbstractC11247f.d(AbstractC34853zG.d("Colors(foreground=", strG, ", foregroundGrabber=", strG2, ", surface="), aFV.g(this.e), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                long j = bVar.d;
                int i = aFV.b;
                return C30372nWu.d(this.d, j) && C30372nWu.d(this.b, bVar.b) && C30372nWu.d(this.e, bVar.e);
            }
        }

        public static final class d {
            public final C1546aWg e;

            public final int hashCode() {
                return this.e.hashCode();
            }

            public d(C1546aWg c1546aWg) {
                this.e = c1546aWg;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && nZN.c(this.e, ((d) obj).e);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textHeadline=");
                sb.append(this.e);
                sb.append(")");
                return sb.toString();
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof w)) {
                return false;
            }
            w wVar = (w) obj;
            return nZN.c(this.e, wVar.e) && nZN.c(this.c, wVar.c) && nZN.c(this.b, wVar.b);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Sheet(colors=");
            sb.append(this.e);
            sb.append(", dimensions=");
            sb.append(this.c);
            sb.append(", typographies=");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }

        public w(b bVar, e eVar, d dVar) {
            this.e = bVar;
            this.c = eVar;
            this.b = dVar;
        }
    }

    public static HawkinsTheme[] values() {
        return (HawkinsTheme[]) $VALUES.clone();
    }

    public static final class A {
        public final d b;
        public final e c;
        public final c e;

        public A(d dVar, c cVar, e eVar) {
            this.b = dVar;
            this.e = cVar;
            this.c = eVar;
        }

        public final int hashCode() {
            int iHashCode = this.b.hashCode();
            return this.c.hashCode() + ((this.e.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class c {
            private float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            private float i;
            private float j;

            public c(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
                this.d = f;
                this.a = f2;
                this.i = f3;
                this.e = f4;
                this.c = f5;
                this.j = f6;
                this.b = f7;
            }

            public final int hashCode() {
                return Float.hashCode(this.b) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.d) * 31, this.a, 31), this.i, 31), this.e, 31), this.c, 31), this.j, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.d);
                String strD2 = C3770bah.d(this.a);
                String strD3 = C3770bah.d(this.i);
                String strD4 = C3770bah.d(this.e);
                String strD5 = C3770bah.d(this.c);
                String strD6 = C3770bah.d(this.j);
                String strD7 = C3770bah.d(this.b);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", spaceAnchor=", strD2, ", spaceBetweenNotchAnchor=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBottom=", strD4, ", spaceHorizontal=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceNotch=", strD6, ", spaceTop=");
                return AbstractC11247f.d(sbD, strD7, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return C3770bah.b(this.d, cVar.d) && C3770bah.b(this.a, cVar.a) && C3770bah.b(this.i, cVar.i) && C3770bah.b(this.e, cVar.e) && C3770bah.b(this.c, cVar.c) && C3770bah.b(this.j, cVar.j) && C3770bah.b(this.b, cVar.b);
            }
        }

        public static final class d {
            public final long c;
            public final long d;

            public d(long j, long j2) {
                this.d = j;
                this.c = j2;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.c) + (Long.hashCode(this.d) * 31);
            }

            public final String toString() {
                return AbstractC4079bgY.c("Colors(foreground=", aFV.g(this.d), ", surface=", aFV.g(this.c), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                long j = dVar.d;
                int i = aFV.b;
                return C30372nWu.d(this.d, j) && C30372nWu.d(this.c, dVar.c);
            }
        }

        public static final class e {
            public final C1546aWg c;
            public final C1546aWg d;

            public e(C1546aWg c1546aWg, C1546aWg c1546aWg2) {
                this.c = c1546aWg;
                this.d = c1546aWg2;
            }

            public final int hashCode() {
                return this.d.hashCode() + (this.c.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return this.c.equals(eVar.c) && this.d.equals(eVar.d);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.c);
                sb.append(", textHeavy=");
                sb.append(this.d);
                sb.append(")");
                return sb.toString();
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof A)) {
                return false;
            }
            A a = (A) obj;
            return this.b.equals(a.b) && this.e.equals(a.e) && this.c.equals(a.c);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Tooltip(colors=");
            sb.append(this.b);
            sb.append(", dimensions=");
            sb.append(this.e);
            sb.append(", typographies=");
            sb.append(this.c);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class B {
        public final a a;
        public final b b;
        public final c c;

        public B(c cVar, b bVar, a aVar) {
            this.c = cVar;
            this.b = bVar;
            this.a = aVar;
        }

        public final int hashCode() {
            int iHashCode = this.c.hashCode();
            return this.a.hashCode() + ((this.b.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final C1546aWg a;
            public final C1546aWg b;

            public a(C1546aWg c1546aWg, C1546aWg c1546aWg2) {
                this.b = c1546aWg;
                this.a = c1546aWg2;
            }

            public final int hashCode() {
                return this.a.hashCode() + (this.b.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.b.equals(aVar.b) && this.a.equals(aVar.a);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.b);
                sb.append(", textHeavy=");
                sb.append(this.a);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class b {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            private float i;

            public b(float f, float f2, float f3, float f4, float f5, float f6) {
                this.d = f;
                this.i = f2;
                this.b = f3;
                this.e = f4;
                this.c = f5;
                this.a = f6;
            }

            public final int hashCode() {
                return Float.hashCode(this.a) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.d) * 31, this.i, 31), this.b, 31), this.e, 31), this.c, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.d);
                String strD2 = C3770bah.d(this.i);
                String strD3 = C3770bah.d(this.b);
                String strD4 = C3770bah.d(this.e);
                String strD5 = C3770bah.d(this.c);
                String strD6 = C3770bah.d(this.a);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", maxWidth=", strD2, ", spaceBetweenAccessoryText=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceHorizontal=", strD4, ", spaceIconVertical=");
                return AbstractC3480bQn.b(sbD, strD5, ", spaceVertical=", strD6, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return C3770bah.b(this.d, bVar.d) && C3770bah.b(this.i, bVar.i) && C3770bah.b(this.b, bVar.b) && C3770bah.b(this.e, bVar.e) && C3770bah.b(this.c, bVar.c) && C3770bah.b(this.a, bVar.a);
            }
        }

        public static final class c {
            private long a;
            public final long b;
            public final long e;

            public c(long j, long j2, long j3) {
                this.a = j;
                this.e = j2;
                this.b = j3;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.b) + AbstractC34853zG.e(Long.hashCode(this.a) * 31, 31, this.e);
            }

            public final String toString() {
                String strG = aFV.g(this.a);
                String strG2 = aFV.g(this.e);
                return AbstractC11247f.d(AbstractC34853zG.d("Colors(border=", strG, ", foreground=", strG2, ", surface="), aFV.g(this.b), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                long j = cVar.a;
                int i = aFV.b;
                return C30372nWu.d(this.a, j) && C30372nWu.d(this.e, cVar.e) && C30372nWu.d(this.b, cVar.b);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof B)) {
                return false;
            }
            B b2 = (B) obj;
            return this.c.equals(b2.c) && this.b.equals(b2.b) && this.a.equals(b2.a);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Toast(colors=");
            sb.append(this.c);
            sb.append(", dimensions=");
            sb.append(this.b);
            sb.append(", typographies=");
            sb.append(this.a);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$a, reason: case insensitive filesystem */
    public static final class C0248a {
        public final C0008a a;
        public final d b;
        public final c d;

        public C0248a(d dVar, C0008a c0008a, c cVar) {
            this.b = dVar;
            this.a = c0008a;
            this.d = cVar;
        }

        public final int hashCode() {
            int iHashCode = this.b.hashCode();
            return this.d.hashCode() + ((this.a.hashCode() + (iHashCode * 31)) * 31);
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$a$c */
        public static final class c {
            public final C1546aWg a;
            public final C1546aWg b;
            public final C1546aWg c;

            public c(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3) {
                this.b = c1546aWg;
                this.a = c1546aWg2;
                this.c = c1546aWg3;
            }

            public final int hashCode() {
                return this.c.hashCode() + aIX.a(this.a, this.b.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.b.equals(cVar.b) && this.a.equals(cVar.a) && this.c.equals(cVar.c);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.b);
                sb.append(", textLarge=");
                sb.append(this.a);
                sb.append(", textSmall=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$a$d */
        public static final class d {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long i;

            public d(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
                this.b = j;
                this.d = j2;
                this.c = j3;
                this.e = j4;
                this.a = j5;
                this.i = j6;
                this.f = j7;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.f) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.b) * 31, 31, this.d), 31, this.c), 31, this.e), 31, this.a), 31, this.i);
            }

            public final String toString() {
                String strG = aFV.g(this.b);
                String strG2 = aFV.g(this.d);
                String strG3 = aFV.g(this.c);
                String strG4 = aFV.g(this.e);
                String strG5 = aFV.g(this.a);
                String strG6 = aFV.g(this.i);
                String strG7 = aFV.g(this.f);
                StringBuilder sbD = AbstractC34853zG.d("Colors(foregroundFill=", strG, ", foregroundTrack=", strG2, ", surfaceFill=");
                AbstractC4079bgY.e(sbD, strG3, ", surfaceFillPressed=", strG4, ", surfaceRipple=");
                AbstractC4079bgY.e(sbD, strG5, ", surfaceTrack=", strG6, ", surfaceTrackPressed=");
                return AbstractC11247f.d(sbD, strG7, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                long j = dVar.b;
                int i = aFV.b;
                return C30372nWu.d(this.b, j) && C30372nWu.d(this.d, dVar.d) && C30372nWu.d(this.c, dVar.c) && C30372nWu.d(this.e, dVar.e) && C30372nWu.d(this.a, dVar.a) && C30372nWu.d(this.i, dVar.i) && C30372nWu.d(this.f, dVar.f);
            }
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$a$a, reason: collision with other inner class name */
        public static final class C0008a {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float g;
            public final float h;
            public final float i;
            public final float j;
            public final float l;

            public C0008a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
                this.a = f;
                this.c = f2;
                this.b = f3;
                this.e = f4;
                this.d = f5;
                this.g = f6;
                this.f = f7;
                this.i = f8;
                this.j = f9;
                this.h = f10;
                this.l = f11;
            }

            public final int hashCode() {
                return Float.hashCode(this.l) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.a) * 31, this.c, 31), this.b, 31), this.e, 31), this.d, 31), this.g, 31), this.f, 31), this.i, 31), this.j, 31), this.h, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.a);
                String strD2 = C3770bah.d(this.c);
                String strD3 = C3770bah.d(this.b);
                String strD4 = C3770bah.d(this.e);
                String strD5 = C3770bah.d(this.d);
                String strD6 = C3770bah.d(this.g);
                String strD7 = C3770bah.d(this.f);
                String strD8 = C3770bah.d(this.i);
                String strD9 = C3770bah.d(this.j);
                String strD10 = C3770bah.d(this.h);
                String strD11 = C3770bah.d(this.l);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", spaceBetweenIconText=", strD2, ", spaceBottom=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBottomLarge=", strD4, ", spaceBottomSmall=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceHorizontal=", strD6, ", spaceHorizontalLarge=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceHorizontalSmall=", strD8, ", spaceTop=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceTopLarge=", strD10, ", spaceTopSmall=");
                return AbstractC11247f.d(sbD, strD11, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0008a)) {
                    return false;
                }
                C0008a c0008a = (C0008a) obj;
                return C3770bah.b(this.a, c0008a.a) && C3770bah.b(this.c, c0008a.c) && C3770bah.b(this.b, c0008a.b) && C3770bah.b(this.e, c0008a.e) && C3770bah.b(this.d, c0008a.d) && C3770bah.b(this.g, c0008a.g) && C3770bah.b(this.f, c0008a.f) && C3770bah.b(this.i, c0008a.i) && C3770bah.b(this.j, c0008a.j) && C3770bah.b(this.h, c0008a.h) && C3770bah.b(this.l, c0008a.l);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0248a)) {
                return false;
            }
            C0248a c0248a = (C0248a) obj;
            return this.b.equals(c0248a.b) && this.a.equals(c0248a.a) && this.d.equals(c0248a.d);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ButtonCountdown(colors=");
            sb.append(this.b);
            sb.append(", dimensions=");
            sb.append(this.a);
            sb.append(", typographies=");
            sb.append(this.d);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$b, reason: case insensitive filesystem */
    public static final class C0249b {
        public final C0009b b;
        public final e c;
        public final d e;

        public final int hashCode() {
            int iHashCode = this.e.hashCode();
            return this.b.hashCode() + ((this.c.hashCode() + (iHashCode * 31)) * 31);
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$b$b, reason: collision with other inner class name */
        public static final class C0009b {
            public final C1546aWg a;
            public final C1546aWg b;
            public final C1546aWg c;
            public final C1546aWg d;
            public final C1546aWg e;

            public C0009b(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3, C1546aWg c1546aWg4, C1546aWg c1546aWg5) {
                this.b = c1546aWg;
                this.a = c1546aWg2;
                this.d = c1546aWg3;
                this.e = c1546aWg4;
                this.c = c1546aWg5;
            }

            public final int hashCode() {
                return this.c.hashCode() + aIX.a(this.e, aIX.a(this.d, aIX.a(this.a, this.b.hashCode() * 31)));
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0009b)) {
                    return false;
                }
                C0009b c0009b = (C0009b) obj;
                return this.b.equals(c0009b.b) && this.a.equals(c0009b.a) && this.d.equals(c0009b.d) && this.e.equals(c0009b.e) && this.c.equals(c0009b.c);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textPlaceholderExtraLarge=");
                sb.append(this.b);
                sb.append(", textPlaceholderExtraSmall=");
                sb.append(this.a);
                sb.append(", textPlaceholderLarge=");
                sb.append(this.d);
                sb.append(", textPlaceholderMedium=");
                sb.append(this.e);
                sb.append(", textPlaceholderSmall=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$b$d */
        public static final class d {
            public final long a;
            public final long c;
            public final long e;

            public d(long j, long j2, long j3) {
                this.e = j;
                this.a = j2;
                this.c = j3;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.c) + AbstractC34853zG.e(Long.hashCode(this.e) * 31, 31, this.a);
            }

            public final String toString() {
                String strG = aFV.g(this.e);
                String strG2 = aFV.g(this.a);
                return AbstractC11247f.d(AbstractC34853zG.d("Colors(borderPlaceholder=", strG, ", foregroundPlaceholder=", strG2, ", surfacePlaceholder="), aFV.g(this.c), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                long j = dVar.e;
                int i = aFV.b;
                return C30372nWu.d(this.e, j) && C30372nWu.d(this.a, dVar.a) && C30372nWu.d(this.c, dVar.c);
            }
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$b$e */
        public static final class e {
            public final float a;
            public final float d;
            public final float e;

            public e(float f, float f2, float f3) {
                this.d = f;
                this.a = f2;
                this.e = f3;
            }

            public final int hashCode() {
                return Float.hashCode(this.e) + AbstractC11247f.c(Float.hashCode(this.d) * 31, this.a, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.d);
                String strD2 = C3770bah.d(this.a);
                return AbstractC11247f.d(AbstractC34853zG.d("Dimensions(borderRadiusCircle=", strD, ", borderRadiusSquare=", strD2, ", borderWidthPlaceholder="), C3770bah.d(this.e), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return C3770bah.b(this.d, eVar.d) && C3770bah.b(this.a, eVar.a) && C3770bah.b(this.e, eVar.e);
            }
        }

        public C0249b(d dVar, e eVar, C0009b c0009b) {
            this.e = dVar;
            this.c = eVar;
            this.b = c0009b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0249b)) {
                return false;
            }
            C0249b c0249b = (C0249b) obj;
            return this.e.equals(c0249b.e) && nZN.c(this.c, c0249b.c) && this.b.equals(c0249b.b);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Avatar(colors=");
            sb.append(this.e);
            sb.append(", dimensions=");
            sb.append(this.c);
            sb.append(", typographies=");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$d, reason: case insensitive filesystem */
    public static final class C0250d {
        public final a a;
        public final C0011d d;
        public final b e;

        public final int hashCode() {
            int iHashCode = this.a.hashCode();
            return this.d.hashCode() + ((this.e.hashCode() + (iHashCode * 31)) * 31);
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$d$d, reason: collision with other inner class name */
        public static final class C0011d {
            public final C1546aWg a;
            public final C1546aWg b;
            public final C1546aWg d;
            public final C1546aWg e;

            public C0011d(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3, C1546aWg c1546aWg4) {
                this.a = c1546aWg;
                this.e = c1546aWg2;
                this.b = c1546aWg3;
                this.d = c1546aWg4;
            }

            public final int hashCode() {
                return this.d.hashCode() + aIX.a(this.b, aIX.a(this.e, this.a.hashCode() * 31));
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0011d)) {
                    return false;
                }
                C0011d c0011d = (C0011d) obj;
                return this.a.equals(c0011d.a) && this.e.equals(c0011d.e) && this.b.equals(c0011d.b) && this.d.equals(c0011d.d);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textDescription=");
                sb.append(this.a);
                sb.append(", textLabelMedium=");
                sb.append(this.e);
                sb.append(", textLabelSmall=");
                sb.append(this.b);
                sb.append(", textValidation=");
                sb.append(this.d);
                sb.append(")");
                return sb.toString();
            }
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$d$a */
        public static final class a {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            private long f;
            private long g;
            public final long h;
            private long i;

            public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
                this.b = j;
                this.c = j2;
                this.a = j3;
                this.f = j4;
                this.e = j5;
                this.d = j6;
                this.g = j7;
                this.i = j8;
                this.h = j9;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.h) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.b) * 31, 31, this.c), 31, this.a), 31, this.f), 31, this.e), 31, this.d), 31, this.g), 31, this.i);
            }

            public final String toString() {
                String strG = aFV.g(this.b);
                String strG2 = aFV.g(this.c);
                String strG3 = aFV.g(this.a);
                String strG4 = aFV.g(this.f);
                String strG5 = aFV.g(this.e);
                String strG6 = aFV.g(this.d);
                String strG7 = aFV.g(this.g);
                String strG8 = aFV.g(this.i);
                String strG9 = aFV.g(this.h);
                StringBuilder sbD = AbstractC34853zG.d("Colors(foreground=", strG, ", foregroundDescription=", strG2, ", foregroundDisabled=");
                AbstractC4079bgY.e(sbD, strG3, ", foregroundIcon=", strG4, ", foregroundMessageError=");
                AbstractC4079bgY.e(sbD, strG5, ", surface=", strG6, ", surfaceDisabled=");
                AbstractC4079bgY.e(sbD, strG7, ", surfacePressed=", strG8, ", surfacePressedRipple=");
                return AbstractC11247f.d(sbD, strG9, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.b;
                int i = aFV.b;
                return C30372nWu.d(this.b, j) && C30372nWu.d(this.c, aVar.c) && C30372nWu.d(this.a, aVar.a) && C30372nWu.d(this.f, aVar.f) && C30372nWu.d(this.e, aVar.e) && C30372nWu.d(this.d, aVar.d) && C30372nWu.d(this.g, aVar.g) && C30372nWu.d(this.i, aVar.i) && C30372nWu.d(this.h, aVar.h);
            }

            public static a d(a aVar, long j, long j2, int i) {
                return new a((i & 1) != 0 ? aVar.b : j, aVar.c, aVar.a, aVar.f, aVar.e, (i & 32) != 0 ? aVar.d : j2, aVar.g, aVar.i, aVar.h);
            }
        }

        /* JADX INFO: renamed from: com.netflix.hawkins.consumer.tokens.HawkinsTheme$d$b */
        public static final class b {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            private float g;
            public final float h;
            public final float i;
            private float j;

            public b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
                this.e = f;
                this.g = f2;
                this.j = f3;
                this.b = f4;
                this.d = f5;
                this.c = f6;
                this.a = f7;
                this.h = f8;
                this.f = f9;
                this.i = f10;
            }

            public final int hashCode() {
                return Float.hashCode(this.i) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.e) * 31, this.g, 31), this.j, 31), this.b, 31), this.d, 31), this.c, 31), this.a, 31), this.h, 31), this.f, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.e);
                String strD2 = C3770bah.d(this.g);
                String strD3 = C3770bah.d(this.j);
                String strD4 = C3770bah.d(this.b);
                String strD5 = C3770bah.d(this.d);
                String strD6 = C3770bah.d(this.c);
                String strD7 = C3770bah.d(this.a);
                String strD8 = C3770bah.d(this.h);
                String strD9 = C3770bah.d(this.f);
                String strD10 = C3770bah.d(this.i);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderRadiusSurface=", strD2, ", space=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetween=", strD4, ", spaceBetweenText=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceBetweenValidationIconMessage=", strD6, ", spaceHorizontal=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceValidationIconVertical=", strD8, ", spaceVerticalMedium=");
                return AbstractC3480bQn.b(sbD, strD9, ", spaceVerticalSmall=", strD10, ")");
            }

            public static b e(b bVar, float f, float f2, int i) {
                if ((i & 1) != 0) {
                    f = bVar.e;
                }
                float f3 = f;
                float f4 = bVar.g;
                float f5 = bVar.j;
                float f6 = bVar.b;
                float f7 = bVar.d;
                float f8 = bVar.c;
                if ((i & 64) != 0) {
                    f2 = bVar.a;
                }
                return new b(f3, f4, f5, f6, f7, f8, f2, bVar.h, bVar.f, bVar.i);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return C3770bah.b(this.e, bVar.e) && C3770bah.b(this.g, bVar.g) && C3770bah.b(this.j, bVar.j) && C3770bah.b(this.b, bVar.b) && C3770bah.b(this.d, bVar.d) && C3770bah.b(this.c, bVar.c) && C3770bah.b(this.a, bVar.a) && C3770bah.b(this.h, bVar.h) && C3770bah.b(this.f, bVar.f) && C3770bah.b(this.i, bVar.i);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0250d)) {
                return false;
            }
            C0250d c0250d = (C0250d) obj;
            return nZN.c(this.a, c0250d.a) && nZN.c(this.e, c0250d.e) && this.d.equals(c0250d.d);
        }

        public static C0250d b(C0250d c0250d, a aVar, b bVar, int i) {
            if ((i & 1) != 0) {
                aVar = c0250d.a;
            }
            if ((i & 2) != 0) {
                bVar = c0250d.e;
            }
            return new C0250d(aVar, bVar, c0250d.d);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ActionListItem(colors=");
            sb.append(this.a);
            sb.append(", dimensions=");
            sb.append(this.e);
            sb.append(", typographies=");
            sb.append(this.d);
            sb.append(")");
            return sb.toString();
        }

        public C0250d(a aVar, b bVar, C0011d c0011d) {
            this.a = aVar;
            this.e = bVar;
            this.d = c0011d;
        }
    }

    public static final class g {
        public final d a;
        public final a d;
        public final c e;

        public g(a aVar, d dVar, c cVar) {
            this.d = aVar;
            this.a = dVar;
            this.e = cVar;
        }

        public final int hashCode() {
            int iHashCode = this.d.hashCode();
            return this.e.hashCode() + ((this.a.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class c {
            public final C1546aWg a;
            public final C1546aWg e;

            public c(C1546aWg c1546aWg, C1546aWg c1546aWg2) {
                this.e = c1546aWg;
                this.a = c1546aWg2;
            }

            public final int hashCode() {
                return this.a.hashCode() + (this.e.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.e.equals(cVar.e) && this.a.equals(cVar.a);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textLabel=");
                sb.append(this.e);
                sb.append(", textMessage=");
                sb.append(this.a);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class d {
            public final float a;
            public final float b;
            private float c;
            private float d;
            public final float e;

            public d(float f, float f2, float f3, float f4, float f5) {
                this.c = f;
                this.d = f2;
                this.b = f3;
                this.a = f4;
                this.e = f5;
            }

            public final int hashCode() {
                return Float.hashCode(this.e) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.c) * 31, this.d, 31), this.b, 31), this.a, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.c);
                String strD2 = C3770bah.d(this.d);
                String strD3 = C3770bah.d(this.b);
                String strD4 = C3770bah.d(this.a);
                String strD5 = C3770bah.d(this.e);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderWidth=", strD2, ", spaceBetweenText=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetweenValidationIconMessage=", strD4, ", spaceTextTop=");
                return AbstractC11247f.d(sbD, strD5, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return C3770bah.b(this.c, dVar.c) && C3770bah.b(this.d, dVar.d) && C3770bah.b(this.b, dVar.b) && C3770bah.b(this.a, dVar.a) && C3770bah.b(this.e, dVar.e);
            }
        }

        public static final class a {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;
            public final long g;
            public final long h;
            public final long i;
            public final long j;
            public final long k;
            private long l;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final long f114o;

            public a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13) {
                this.c = j;
                this.d = j2;
                this.a = j3;
                this.b = j4;
                this.e = j5;
                this.g = j6;
                this.i = j7;
                this.f = j8;
                this.j = j9;
                this.l = j10;
                this.h = j11;
                this.k = j12;
                this.f114o = j13;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.f114o) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.c) * 31, 31, this.d), 31, this.a), 31, this.b), 31, this.e), 31, this.g), 31, this.i), 31, this.f), 31, this.j), 31, this.l), 31, this.h), 31, this.k);
            }

            public final String toString() {
                String strG = aFV.g(this.c);
                String strG2 = aFV.g(this.d);
                String strG3 = aFV.g(this.a);
                String strG4 = aFV.g(this.b);
                String strG5 = aFV.g(this.e);
                String strG6 = aFV.g(this.g);
                String strG7 = aFV.g(this.i);
                String strG8 = aFV.g(this.f);
                String strG9 = aFV.g(this.j);
                String strG10 = aFV.g(this.l);
                String strG11 = aFV.g(this.h);
                String strG12 = aFV.g(this.k);
                String strG13 = aFV.g(this.f114o);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", borderDisabled=", strG2, ", borderError=");
                AbstractC4079bgY.e(sbD, strG3, ", foreground=", strG4, ", foregroundDescription=");
                AbstractC4079bgY.e(sbD, strG5, ", foregroundDescriptionDisabled=", strG6, ", foregroundLabel=");
                AbstractC4079bgY.e(sbD, strG7, ", foregroundLabelDisabled=", strG8, ", foregroundMessageError=");
                AbstractC4079bgY.e(sbD, strG9, ", surface=", strG10, ", surfaceRipple=");
                AbstractC4079bgY.e(sbD, strG11, ", surfaceSelected=", strG12, ", surfaceSelectedDisabled=");
                return AbstractC11247f.d(sbD, strG13, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.c;
                int i = aFV.b;
                return C30372nWu.d(this.c, j) && C30372nWu.d(this.d, aVar.d) && C30372nWu.d(this.a, aVar.a) && C30372nWu.d(this.b, aVar.b) && C30372nWu.d(this.e, aVar.e) && C30372nWu.d(this.g, aVar.g) && C30372nWu.d(this.i, aVar.i) && C30372nWu.d(this.f, aVar.f) && C30372nWu.d(this.j, aVar.j) && C30372nWu.d(this.l, aVar.l) && C30372nWu.d(this.h, aVar.h) && C30372nWu.d(this.k, aVar.k) && C30372nWu.d(this.f114o, aVar.f114o);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.d.equals(gVar.d) && this.a.equals(gVar.a) && this.e.equals(gVar.e);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Checkbox(colors=");
            sb.append(this.d);
            sb.append(", dimensions=");
            sb.append(this.a);
            sb.append(", typographies=");
            sb.append(this.e);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class i {
        public final b a;
        public final a c;
        public final c d;

        public final int hashCode() {
            int iHashCode = this.a.hashCode();
            return this.c.a.hashCode() + ((this.d.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final C1546aWg a;

            public final int hashCode() {
                return this.a.hashCode();
            }

            public a(C1546aWg c1546aWg) {
                this.a = c1546aWg;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && nZN.c(this.a, ((a) obj).a);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.a);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class b {
            public final long a;
            private long c;
            public final long d;
            public final long e;

            public b(long j, long j2, long j3, long j4) {
                this.a = j;
                this.d = j2;
                this.c = j3;
                this.e = j4;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.e) + AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.a) * 31, 31, this.d), 31, this.c);
            }

            public final String toString() {
                String strG = aFV.g(this.a);
                String strG2 = aFV.g(this.d);
                return AbstractC3480bQn.b(AbstractC34853zG.d("Colors(foreground=", strG, ", foregroundDisabled=", strG2, ", foregroundPressed="), aFV.g(this.c), ", surfaceRipple=", aFV.g(this.e), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                long j = bVar.a;
                int i = aFV.b;
                return C30372nWu.d(this.a, j) && C30372nWu.d(this.d, bVar.d) && C30372nWu.d(this.c, bVar.c) && C30372nWu.d(this.e, bVar.e);
            }
        }

        public static final class c {
            private float a;
            public final float c;
            public final float d;

            public c(float f, float f2, float f3) {
                this.c = f;
                this.d = f2;
                this.a = f3;
            }

            public final int hashCode() {
                return Float.hashCode(this.a) + AbstractC11247f.c(Float.hashCode(this.c) * 31, this.d, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.c);
                String strD2 = C3770bah.d(this.d);
                return AbstractC11247f.d(AbstractC34853zG.d("Dimensions(spaceBetweenIconText=", strD, ", spaceBottom=", strD2, ", spaceHorizontal="), C3770bah.d(this.a), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return C3770bah.b(this.c, cVar.c) && C3770bah.b(this.d, cVar.d) && C3770bah.b(this.a, cVar.a);
            }
        }

        public i(b bVar, c cVar, a aVar) {
            this.a = bVar;
            this.d = cVar;
            this.c = aVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return this.a.equals(iVar.a) && this.d.equals(iVar.d) && nZN.c(this.c, iVar.c);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ButtonIconStacked(colors=");
            sb.append(this.a);
            sb.append(", dimensions=");
            sb.append(this.d);
            sb.append(", typographies=");
            sb.append(this.c);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class j {
        public final c b;

        public j(c cVar) {
            this.b = cVar;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public static final class c {
            public final float a;
            private float b;

            public c(float f, float f2) {
                this.a = f;
                this.b = f2;
            }

            public final int hashCode() {
                return Float.hashCode(this.b) + (Float.hashCode(this.a) * 31);
            }

            public final String toString() {
                return AbstractC4079bgY.c("Dimensions(spaceBetween=", C3770bah.d(this.a), ", spaceHorizontal=", C3770bah.d(this.b), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return C3770bah.b(this.a, cVar.a) && C3770bah.b(this.b, cVar.b);
            }
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof j) && this.b.equals(((j) obj).b);
            }
            return true;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Chips(dimensions=");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class k {
        public final a a;
        public final d d;
        public final c e;

        public k(d dVar, c cVar, a aVar) {
            this.d = dVar;
            this.e = cVar;
            this.a = aVar;
        }

        public final int hashCode() {
            int iHashCode = this.d.hashCode();
            return this.a.c.hashCode() + ((this.e.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final C1546aWg c;

            public a(C1546aWg c1546aWg) {
                this.c = c1546aWg;
            }

            public final int hashCode() {
                return this.c.hashCode();
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && this.c.equals(((a) obj).c);
                }
                return true;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class c {
            public final float b;
            public final float e;

            public c(float f, float f2) {
                this.b = f;
                this.e = f2;
            }

            public final int hashCode() {
                return Float.hashCode(this.e) + (Float.hashCode(this.b) * 31);
            }

            public final String toString() {
                return AbstractC4079bgY.c("Dimensions(borderWidth=", C3770bah.d(this.b), ", spaceBetween=", C3770bah.d(this.e), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return C3770bah.b(this.b, cVar.b) && C3770bah.b(this.e, cVar.e);
            }
        }

        public static final class d {
            public final long a;
            public final long b;
            public final long e;

            public d(long j, long j2, long j3) {
                this.e = j;
                this.a = j2;
                this.b = j3;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.b) + AbstractC34853zG.e(Long.hashCode(this.e) * 31, 31, this.a);
            }

            public final String toString() {
                String strG = aFV.g(this.e);
                String strG2 = aFV.g(this.a);
                return AbstractC11247f.d(AbstractC34853zG.d("Colors(borderHigh=", strG, ", borderLow=", strG2, ", foreground="), aFV.g(this.b), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                long j = dVar.e;
                int i = aFV.b;
                return C30372nWu.d(this.e, j) && C30372nWu.d(this.a, dVar.a) && C30372nWu.d(this.b, dVar.b);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.d.equals(kVar.d) && this.e.equals(kVar.e) && this.a.equals(kVar.a);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Divider(colors=");
            sb.append(this.d);
            sb.append(", dimensions=");
            sb.append(this.e);
            sb.append(", typographies=");
            sb.append(this.a);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class p {
        public final d a;
        public final c b;
        public final e d;

        public p(e eVar, c cVar, d dVar) {
            this.d = eVar;
            this.b = cVar;
            this.a = dVar;
        }

        public final int hashCode() {
            int iHashCode = this.d.hashCode();
            return this.a.a.hashCode() + ((this.b.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class c {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;

            public c(float f, float f2, float f3, float f4, float f5) {
                this.e = f;
                this.a = f2;
                this.b = f3;
                this.c = f4;
                this.d = f5;
            }

            public final int hashCode() {
                return Float.hashCode(this.d) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.e) * 31, this.a, 31), this.b, 31), this.c, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.e);
                String strD2 = C3770bah.d(this.a);
                String strD3 = C3770bah.d(this.b);
                String strD4 = C3770bah.d(this.c);
                String strD5 = C3770bah.d(this.d);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(spaceBetween=", strD, ", spaceBottom=", strD2, ", spaceEnd=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceStart=", strD4, ", spaceTop=");
                return AbstractC11247f.d(sbD, strD5, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return C3770bah.b(this.e, cVar.e) && C3770bah.b(this.a, cVar.a) && C3770bah.b(this.b, cVar.b) && C3770bah.b(this.c, cVar.c) && C3770bah.b(this.d, cVar.d);
            }
        }

        public static final class d {
            public final C1546aWg a;

            public d(C1546aWg c1546aWg) {
                this.a = c1546aWg;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof d) && this.a.equals(((d) obj).a);
                }
                return true;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.a);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class e {
            public final long c;
            public final long d;
            public final long e;

            public e(long j, long j2, long j3) {
                this.c = j;
                this.d = j2;
                this.e = j3;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.e) + AbstractC34853zG.e(Long.hashCode(this.c) * 31, 31, this.d);
            }

            public final String toString() {
                String strG = aFV.g(this.c);
                String strG2 = aFV.g(this.d);
                return AbstractC11247f.d(AbstractC34853zG.d("Colors(foreground=", strG, ", surface=", strG2, ", surfaceLoading="), aFV.g(this.e), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                long j = eVar.c;
                int i = aFV.b;
                return C30372nWu.d(this.c, j) && C30372nWu.d(this.d, eVar.d) && C30372nWu.d(this.e, eVar.e);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            return this.d.equals(pVar.d) && this.b.equals(pVar.b) && this.a.equals(pVar.a);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Placeholder(colors=");
            sb.append(this.d);
            sb.append(", dimensions=");
            sb.append(this.b);
            sb.append(", typographies=");
            sb.append(this.a);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class q {
        public final b b;

        public q(b bVar) {
            this.b = bVar;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public static final class b {
            public final long b;
            public final long c;

            public b(long j, long j2) {
                this.b = j;
                this.c = j2;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.c) + (Long.hashCode(this.b) * 31);
            }

            public final String toString() {
                return AbstractC4079bgY.c("Colors(surfaceAndroid=", aFV.g(this.b), ", surfaceAndroidBrand=", aFV.g(this.c), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                long j = bVar.b;
                int i = aFV.b;
                return C30372nWu.d(this.b, j) && C30372nWu.d(this.c, bVar.c);
            }
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof q) && this.b.equals(((q) obj).b);
            }
            return true;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Loader(colors=");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class s {
        public final d b;
        public final b c;
        public final c e;

        public s(b bVar, c cVar, d dVar) {
            this.c = bVar;
            this.e = cVar;
            this.b = dVar;
        }

        public final int hashCode() {
            int iHashCode = this.c.hashCode();
            return this.b.hashCode() + ((this.e.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class b {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;

            public b(long j, long j2, long j3, long j4, long j5) {
                this.b = j;
                this.e = j2;
                this.c = j3;
                this.d = j4;
                this.a = j5;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.a) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.b) * 31, 31, this.e), 31, this.c), 31, this.d);
            }

            public final String toString() {
                String strG = aFV.g(this.b);
                String strG2 = aFV.g(this.e);
                String strG3 = aFV.g(this.c);
                String strG4 = aFV.g(this.d);
                String strG5 = aFV.g(this.a);
                StringBuilder sbD = AbstractC34853zG.d("Colors(border=", strG, ", foreground=", strG2, ", foregroundBody=");
                AbstractC4079bgY.e(sbD, strG3, ", foregroundEyebrow=", strG4, ", surface=");
                return AbstractC11247f.d(sbD, strG5, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                long j = bVar.b;
                int i = aFV.b;
                return C30372nWu.d(this.b, j) && C30372nWu.d(this.e, bVar.e) && C30372nWu.d(this.c, bVar.c) && C30372nWu.d(this.d, bVar.d) && C30372nWu.d(this.a, bVar.a);
            }
        }

        public static final class d {
            public final C1546aWg a;
            public final C1546aWg d;
            public final C1546aWg e;

            public d(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3) {
                this.d = c1546aWg;
                this.a = c1546aWg2;
                this.e = c1546aWg3;
            }

            public final int hashCode() {
                return this.e.hashCode() + aIX.a(this.a, this.d.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return this.d.equals(dVar.d) && this.a.equals(dVar.a) && this.e.equals(dVar.e);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textBody=");
                sb.append(this.d);
                sb.append(", textEyebrow=");
                sb.append(this.a);
                sb.append(", textHeadline=");
                sb.append(this.e);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class c {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            private float f;
            public final float g;
            private float h;
            private float i;
            private float j;
            private float k;
            private float l;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private float f124o;

            public c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
                this.a = f;
                this.c = f2;
                this.d = f3;
                this.f = f4;
                this.i = f5;
                this.j = f6;
                this.b = f7;
                this.e = f8;
                this.h = f9;
                this.g = f10;
                this.f124o = f11;
                this.l = f12;
                this.k = f13;
            }

            public final int hashCode() {
                return Float.hashCode(this.k) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.a) * 31, this.c, 31), this.d, 31), this.f, 31), this.i, 31), this.j, 31), this.b, 31), this.e, 31), this.h, 31), this.g, 31), this.f124o, 31), this.l, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.a);
                String strD2 = C3770bah.d(this.c);
                String strD3 = C3770bah.d(this.d);
                String strD4 = C3770bah.d(this.f);
                String strD5 = C3770bah.d(this.i);
                String strD6 = C3770bah.d(this.j);
                String strD7 = C3770bah.d(this.b);
                String strD8 = C3770bah.d(this.e);
                String strD9 = C3770bah.d(this.h);
                String strD10 = C3770bah.d(this.g);
                String strD11 = C3770bah.d(this.f124o);
                String strD12 = C3770bah.d(this.l);
                String strD13 = C3770bah.d(this.k);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(borderRadius=", strD, ", borderWidth=", strD2, ", space=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceAround=", strD4, ", spaceBetweenContent=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceBetweenContentActions=", strD6, ", spaceBetweenContentDismiss=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceBetweenHeader=", strD8, ", spaceBetweenNotchAnchor=");
                AbstractC4079bgY.e(sbD, strD9, ", spaceDismissBottom=", strD10, ", spaceDismissEnd=");
                AbstractC4079bgY.e(sbD, strD11, ", spaceDismissStart=", strD12, ", spaceDismissTop=");
                return AbstractC11247f.d(sbD, strD13, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return C3770bah.b(this.a, cVar.a) && C3770bah.b(this.c, cVar.c) && C3770bah.b(this.d, cVar.d) && C3770bah.b(this.f, cVar.f) && C3770bah.b(this.i, cVar.i) && C3770bah.b(this.j, cVar.j) && C3770bah.b(this.b, cVar.b) && C3770bah.b(this.e, cVar.e) && C3770bah.b(this.h, cVar.h) && C3770bah.b(this.g, cVar.g) && C3770bah.b(this.f124o, cVar.f124o) && C3770bah.b(this.l, cVar.l) && C3770bah.b(this.k, cVar.k);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof s)) {
                return false;
            }
            s sVar = (s) obj;
            return this.c.equals(sVar.c) && this.e.equals(sVar.e) && this.b.equals(sVar.b);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Popover(colors=");
            sb.append(this.c);
            sb.append(", dimensions=");
            sb.append(this.e);
            sb.append(", typographies=");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class t {
        public final a b;

        public t(a aVar) {
            this.b = aVar;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public static final class a {
            public final long a;
            public final long b;
            public final long d;

            public a(long j, long j2, long j3) {
                this.d = j;
                this.a = j2;
                this.b = j3;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.b) + AbstractC34853zG.e(Long.hashCode(this.d) * 31, 31, this.a);
            }

            public final String toString() {
                String strG = aFV.g(this.d);
                String strG2 = aFV.g(this.a);
                return AbstractC11247f.d(AbstractC34853zG.d("Colors(surface=", strG, ", surfaceKnob=", strG2, ", surfaceTrack="), aFV.g(this.b), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                long j = aVar.d;
                int i = aFV.b;
                return C30372nWu.d(this.d, j) && C30372nWu.d(this.a, aVar.a) && C30372nWu.d(this.b, aVar.b);
            }
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof t) && this.b.equals(((t) obj).b);
            }
            return true;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Progress(colors=");
            sb.append(this.b);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class v {
        public final a e;

        public v(a aVar) {
            this.e = aVar;
        }

        public final int hashCode() {
            return this.e.hashCode();
        }

        public static final class a {
            public final float b;
            public final float e;

            public a(float f, float f2) {
                this.b = f;
                this.e = f2;
            }

            public final int hashCode() {
                return Float.hashCode(this.e) + (Float.hashCode(this.b) * 31);
            }

            public final String toString() {
                return AbstractC4079bgY.c("Dimensions(spaceBetween=", C3770bah.d(this.b), ", spaceHorizontal=", C3770bah.d(this.e), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return C3770bah.b(this.b, aVar.b) && C3770bah.b(this.e, aVar.e);
            }
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof v) && this.e.equals(((v) obj).e);
            }
            return true;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Tabs(dimensions=");
            sb.append(this.e);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class x {
        public final e a;
        public final a c;
        public final c d;

        public x(c cVar, a aVar, e eVar) {
            this.d = cVar;
            this.c = aVar;
            this.a = eVar;
        }

        public final int hashCode() {
            int iHashCode = this.d.hashCode();
            return this.a.c.hashCode() + ((this.c.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final float a;
            private float c;

            public a(float f, float f2) {
                this.c = f;
                this.a = f2;
            }

            public final int hashCode() {
                return Float.hashCode(this.a) + (Float.hashCode(this.c) * 31);
            }

            public final String toString() {
                return AbstractC4079bgY.c("Dimensions(borderWidthSelected=", C3770bah.d(this.c), ", spaceVertical=", C3770bah.d(this.a), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return C3770bah.b(this.c, aVar.c) && C3770bah.b(this.a, aVar.a);
            }
        }

        public static final class c {
            public final long a;
            private long b;
            public final long c;
            public final long d;
            public final long e;
            private long j;

            public c(long j, long j2, long j3, long j4, long j5, long j6) {
                this.c = j;
                this.d = j2;
                this.b = j3;
                this.j = j4;
                this.e = j5;
                this.a = j6;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.a) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.c) * 31, 31, this.d), 31, this.b), 31, this.j), 31, this.e);
            }

            public final String toString() {
                String strG = aFV.g(this.c);
                String strG2 = aFV.g(this.d);
                String strG3 = aFV.g(this.b);
                String strG4 = aFV.g(this.j);
                String strG5 = aFV.g(this.e);
                String strG6 = aFV.g(this.a);
                StringBuilder sbD = AbstractC34853zG.d("Colors(borderAccent=", strG, ", foreground=", strG2, ", foregroundDisabled=");
                AbstractC4079bgY.e(sbD, strG3, ", foregroundPressed=", strG4, ", foregroundSelected=");
                return AbstractC3480bQn.b(sbD, strG5, ", surfaceRipple=", strG6, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                long j = cVar.c;
                int i = aFV.b;
                return C30372nWu.d(this.c, j) && C30372nWu.d(this.d, cVar.d) && C30372nWu.d(this.b, cVar.b) && C30372nWu.d(this.j, cVar.j) && C30372nWu.d(this.e, cVar.e) && C30372nWu.d(this.a, cVar.a);
            }
        }

        public static final class e {
            public final C1546aWg c;

            public e(C1546aWg c1546aWg) {
                this.c = c1546aWg;
            }

            public final int hashCode() {
                return this.c.hashCode();
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof e) && this.c.equals(((e) obj).c);
                }
                return true;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof x)) {
                return false;
            }
            x xVar = (x) obj;
            return this.d.equals(xVar.d) && this.c.equals(xVar.c) && this.a.equals(xVar.a);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("TabItem(colors=");
            sb.append(this.d);
            sb.append(", dimensions=");
            sb.append(this.c);
            sb.append(", typographies=");
            sb.append(this.a);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class y {
        public final e c;
        public final a d;
        public final b e;

        public final int hashCode() {
            int iHashCode = this.c.hashCode();
            return this.d.hashCode() + ((this.e.hashCode() + (iHashCode * 31)) * 31);
        }

        public static final class a {
            public final C1546aWg a;
            public final C1546aWg b;
            public final C1546aWg c;
            public final C1546aWg d;
            public final C1546aWg e;
            public final C1546aWg j;

            public a(C1546aWg c1546aWg, C1546aWg c1546aWg2, C1546aWg c1546aWg3, C1546aWg c1546aWg4, C1546aWg c1546aWg5, C1546aWg c1546aWg6) {
                this.e = c1546aWg;
                this.a = c1546aWg2;
                this.b = c1546aWg3;
                this.c = c1546aWg4;
                this.d = c1546aWg5;
                this.j = c1546aWg6;
            }

            public final int hashCode() {
                return this.j.hashCode() + aIX.a(this.d, aIX.a(this.c, aIX.a(this.b, aIX.a(this.a, this.e.hashCode() * 31))));
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.e.equals(aVar.e) && this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.c.equals(aVar.c) && this.d.equals(aVar.d) && this.j.equals(aVar.j);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(textLarge=");
                sb.append(this.e);
                sb.append(", textLargeHeavy=");
                sb.append(this.a);
                sb.append(", textMedium=");
                sb.append(this.b);
                sb.append(", textMediumHeavy=");
                sb.append(this.c);
                sb.append(", textSmall=");
                sb.append(this.d);
                sb.append(", textSmallHeavy=");
                sb.append(this.j);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class e {
            public final long c;
            public final long d;

            public e(long j, long j2) {
                this.c = j;
                this.d = j2;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.d) + (Long.hashCode(this.c) * 31);
            }

            public final String toString() {
                return AbstractC4079bgY.c("Colors(foregroundHigh=", aFV.g(this.c), ", foregroundLow=", aFV.g(this.d), ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                long j = eVar.c;
                int i = aFV.b;
                return C30372nWu.d(this.c, j) && C30372nWu.d(this.d, eVar.d);
            }
        }

        public static final class b {
            public final float a;
            public final float b;
            public final float c;
            public final float d;
            public final float e;
            public final float f;
            public final float h;

            public b(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
                this.d = f;
                this.c = f2;
                this.e = f3;
                this.b = f4;
                this.a = f5;
                this.f = f6;
                this.h = f7;
            }

            public final int hashCode() {
                return Float.hashCode(this.h) + AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(AbstractC11247f.c(Float.hashCode(this.d) * 31, this.c, 31), this.e, 31), this.b, 31), this.a, 31), this.f, 31), 2.0f, 31), 1.0f, 31);
            }

            public final String toString() {
                String strD = C3770bah.d(this.d);
                String strD2 = C3770bah.d(this.c);
                String strD3 = C3770bah.d(this.e);
                String strD4 = C3770bah.d(this.b);
                String strD5 = C3770bah.d(this.a);
                String strD6 = C3770bah.d(this.f);
                String strD7 = C3770bah.d(2.0f);
                String strD8 = C3770bah.d(1.0f);
                String strD9 = C3770bah.d(this.h);
                StringBuilder sbD = AbstractC34853zG.d("Dimensions(spaceBetweenAccessoryTextLarge=", strD, ", spaceBetweenAccessoryTextMedium=", strD2, ", spaceBetweenAccessoryTextSmall=");
                AbstractC4079bgY.e(sbD, strD3, ", spaceBetweenItemsLarge=", strD4, ", spaceBetweenItemsMedium=");
                AbstractC4079bgY.e(sbD, strD5, ", spaceBetweenItemsSmall=", strD6, ", spaceIconTopLarge=");
                AbstractC4079bgY.e(sbD, strD7, ", spaceIconTopMedium=", strD8, ", spaceIconTopSmall=");
                return AbstractC11247f.d(sbD, strD9, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return C3770bah.b(this.d, bVar.d) && C3770bah.b(this.c, bVar.c) && C3770bah.b(this.e, bVar.e) && C3770bah.b(this.b, bVar.b) && C3770bah.b(this.a, bVar.a) && C3770bah.b(this.f, bVar.f) && C3770bah.b(2.0f, 2.0f) && C3770bah.b(1.0f, 1.0f) && C3770bah.b(this.h, bVar.h);
            }
        }

        public y(e eVar, b bVar, a aVar) {
            this.c = eVar;
            this.e = bVar;
            this.d = aVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof y)) {
                return false;
            }
            y yVar = (y) obj;
            return this.c.equals(yVar.c) && nZN.c(this.e, yVar.e) && this.d.equals(yVar.d);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("StaticList(colors=");
            sb.append(this.c);
            sb.append(", dimensions=");
            sb.append(this.e);
            sb.append(", typographies=");
            sb.append(this.d);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class z {
        public final a a;
        public final d d;

        public z(d dVar, a aVar) {
            this.d = dVar;
            this.a = aVar;
        }

        public final int hashCode() {
            return this.a.hashCode() + (this.d.hashCode() * 31);
        }

        public static final class a {
            public final C1546aWg c;
            public final C1546aWg e;

            public a(C1546aWg c1546aWg, C1546aWg c1546aWg2) {
                this.e = c1546aWg;
                this.c = c1546aWg2;
            }

            public final int hashCode() {
                return this.c.hashCode() + (this.e.hashCode() * 31);
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.e.equals(aVar.e) && this.c.equals(aVar.c);
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Typographies(text=");
                sb.append(this.e);
                sb.append(", textPressed=");
                sb.append(this.c);
                sb.append(")");
                return sb.toString();
            }
        }

        public static final class d {
            public final long a;
            public final long b;
            public final long c;
            public final long d;
            public final long e;
            public final long f;

            public d(long j, long j2, long j3, long j4, long j5, long j6) {
                this.a = j;
                this.b = j2;
                this.d = j3;
                this.c = j4;
                this.e = j5;
                this.f = j6;
            }

            public final int hashCode() {
                int i = aFV.b;
                return Long.hashCode(this.f) + AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(AbstractC34853zG.e(Long.hashCode(this.a) * 31, 31, this.b), 31, this.d), 31, this.c), 31, this.e);
            }

            public final String toString() {
                String strG = aFV.g(this.a);
                String strG2 = aFV.g(this.b);
                String strG3 = aFV.g(this.d);
                String strG4 = aFV.g(this.c);
                String strG5 = aFV.g(this.e);
                String strG6 = aFV.g(this.f);
                StringBuilder sbD = AbstractC34853zG.d("Colors(foregroundPrimary=", strG, ", foregroundPrimaryDisabled=", strG2, ", foregroundPrimaryPressed=");
                AbstractC4079bgY.e(sbD, strG3, ", foregroundSecondary=", strG4, ", foregroundSecondaryDisabled=");
                return AbstractC3480bQn.b(sbD, strG5, ", foregroundSecondaryPressed=", strG6, ")");
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                long j = dVar.a;
                int i = aFV.b;
                return C30372nWu.d(this.a, j) && C30372nWu.d(this.b, dVar.b) && C30372nWu.d(this.d, dVar.d) && C30372nWu.d(this.c, dVar.c) && C30372nWu.d(this.e, dVar.e) && C30372nWu.d(this.f, dVar.f);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof z)) {
                return false;
            }
            z zVar = (z) obj;
            return this.d.equals(zVar.d) && this.a.equals(zVar.a);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("TextLink(colors=");
            sb.append(this.d);
            sb.append(", typographies=");
            sb.append(this.a);
            sb.append(")");
            return sb.toString();
        }
    }

    public static HawkinsTheme valueOf(String str) {
        return (HawkinsTheme) Enum.valueOf(HawkinsTheme.class, str);
    }

    static {
        $ENTRIES = EnumEntriesKt.b(hawkinsThemeArr);
    }

    private HawkinsTheme() {
        super(str, i);
    }
}
