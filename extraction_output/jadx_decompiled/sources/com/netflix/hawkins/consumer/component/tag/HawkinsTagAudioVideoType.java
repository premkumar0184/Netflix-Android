package com.netflix.hawkins.consumer.component.tag;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import p000o.AbstractC10426eka;
import p000o.C34223pkn;
import p000o.fPF;
import p000o.fPH;
import p000o.nYA;
import p000o.pjN;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'AudioDescription' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018"}, d2 = {"Lcom/netflix/hawkins/consumer/component/tag/HawkinsTagAudioVideoType;", "", "Lo/eka;", "representation", "Lo/eka;", "getRepresentation$com_netflix_hawkins_kotlin_hawkins_components", "()Lo/eka;", "Lcom/netflix/hawkins/consumer/component/tag/HawkinsTagType;", "type", "Lcom/netflix/hawkins/consumer/component/tag/HawkinsTagType;", "getType$com_netflix_hawkins_kotlin_hawkins_components", "()Lcom/netflix/hawkins/consumer/component/tag/HawkinsTagType;", "AudioDescription", "DolbyAtmos", "DolbyVision", "DolbyVisionAtmos", "SpatialAudio", "Sdh", "Hd", "Hdr", "FourK", "FourKHdr", "FiveOne", "UltraHd", "Hdr10Plus"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HawkinsTagAudioVideoType {
    private static final /* synthetic */ nYA $ENTRIES;
    private static final /* synthetic */ HawkinsTagAudioVideoType[] $VALUES;
    public static final HawkinsTagAudioVideoType AudioDescription;
    public static final HawkinsTagAudioVideoType DolbyAtmos;
    public static final HawkinsTagAudioVideoType DolbyVision;
    public static final HawkinsTagAudioVideoType DolbyVisionAtmos;
    public static final HawkinsTagAudioVideoType FiveOne;
    public static final HawkinsTagAudioVideoType FourK;
    public static final HawkinsTagAudioVideoType FourKHdr;
    public static final HawkinsTagAudioVideoType Hd;
    public static final HawkinsTagAudioVideoType Hdr;
    public static final HawkinsTagAudioVideoType Hdr10Plus;
    public static final HawkinsTagAudioVideoType Sdh;
    public static final HawkinsTagAudioVideoType SpatialAudio;
    public static final HawkinsTagAudioVideoType UltraHd;
    private final AbstractC10426eka representation;
    private final HawkinsTagType type;

    private HawkinsTagAudioVideoType(String str, int i, AbstractC10426eka abstractC10426eka, HawkinsTagType hawkinsTagType) {
        super(str, i);
        this.representation = abstractC10426eka;
        this.type = hawkinsTagType;
    }

    public static nYA a() {
        return $ENTRIES;
    }

    public static HawkinsTagAudioVideoType[] values() {
        return (HawkinsTagAudioVideoType[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: getRepresentation$com_netflix_hawkins_kotlin_hawkins_components, reason: from getter */
    public final AbstractC10426eka getRepresentation() {
        return this.representation;
    }

    /* JADX INFO: renamed from: getType$com_netflix_hawkins_kotlin_hawkins_components, reason: from getter */
    public final HawkinsTagType getType() {
        return this.type;
    }

    public static HawkinsTagAudioVideoType valueOf(String str) {
        return (HawkinsTagAudioVideoType) Enum.valueOf(HawkinsTagAudioVideoType.class, str);
    }

    static {
        AbstractC10426eka.b bVar = new AbstractC10426eka.b((pjN) fPF.b.c(), (C34223pkn) fPH.l.c());
        HawkinsTagType hawkinsTagType = HawkinsTagType.Supplemental;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType = new HawkinsTagAudioVideoType("AudioDescription", 0, bVar, hawkinsTagType);
        AudioDescription = hawkinsTagAudioVideoType;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType2 = new HawkinsTagAudioVideoType("DolbyAtmos", 1, new AbstractC10426eka.b((pjN) fPF.d.c(), (C34223pkn) fPH.k.c()), hawkinsTagType);
        DolbyAtmos = hawkinsTagAudioVideoType2;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType3 = new HawkinsTagAudioVideoType("DolbyVision", 2, new AbstractC10426eka.b((pjN) fPF.a.c(), (C34223pkn) fPH.f664o.c()), hawkinsTagType);
        DolbyVision = hawkinsTagAudioVideoType3;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType4 = new HawkinsTagAudioVideoType("DolbyVisionAtmos", 3, new AbstractC10426eka.b((pjN) fPF.c.c(), (C34223pkn) fPH.n.c()), hawkinsTagType);
        DolbyVisionAtmos = hawkinsTagAudioVideoType4;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType5 = new HawkinsTagAudioVideoType("SpatialAudio", 4, new AbstractC10426eka.b((pjN) fPF.g.c(), (C34223pkn) fPH.q.c()), hawkinsTagType);
        SpatialAudio = hawkinsTagAudioVideoType5;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType6 = new HawkinsTagAudioVideoType("Sdh", 5, new AbstractC10426eka.b((pjN) fPF.e.c(), (C34223pkn) fPH.t.c()), hawkinsTagType);
        Sdh = hawkinsTagAudioVideoType6;
        AbstractC10426eka.a aVar = new AbstractC10426eka.a("HD", (C34223pkn) fPH.p.c());
        HawkinsTagType hawkinsTagType2 = HawkinsTagType.Standard;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType7 = new HawkinsTagAudioVideoType("Hd", 6, aVar, hawkinsTagType2);
        Hd = hawkinsTagAudioVideoType7;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType8 = new HawkinsTagAudioVideoType("Hdr", 7, new AbstractC10426eka.a("HDR", (C34223pkn) fPH.s.c()), hawkinsTagType2);
        Hdr = hawkinsTagAudioVideoType8;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType9 = new HawkinsTagAudioVideoType("FourK", 8, new AbstractC10426eka.a("4K", (C34223pkn) fPH.f.c()), hawkinsTagType2);
        FourK = hawkinsTagAudioVideoType9;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType10 = new HawkinsTagAudioVideoType("FourKHdr", 9, new AbstractC10426eka.a("4K HDR", (C34223pkn) fPH.g.c()), hawkinsTagType2);
        FourKHdr = hawkinsTagAudioVideoType10;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType11 = new HawkinsTagAudioVideoType("FiveOne", 10, new AbstractC10426eka.a("5.1", (C34223pkn) fPH.m.c()), hawkinsTagType2);
        FiveOne = hawkinsTagAudioVideoType11;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType12 = new HawkinsTagAudioVideoType("UltraHd", 11, new AbstractC10426eka.a("Ultra HD 4K", (C34223pkn) fPH.y.c()), hawkinsTagType2);
        UltraHd = hawkinsTagAudioVideoType12;
        HawkinsTagAudioVideoType hawkinsTagAudioVideoType13 = new HawkinsTagAudioVideoType("Hdr10Plus", 12, new AbstractC10426eka.a("HDR10+", (C34223pkn) fPH.r.c()), hawkinsTagType2);
        Hdr10Plus = hawkinsTagAudioVideoType13;
        HawkinsTagAudioVideoType[] hawkinsTagAudioVideoTypeArr = {hawkinsTagAudioVideoType, hawkinsTagAudioVideoType2, hawkinsTagAudioVideoType3, hawkinsTagAudioVideoType4, hawkinsTagAudioVideoType5, hawkinsTagAudioVideoType6, hawkinsTagAudioVideoType7, hawkinsTagAudioVideoType8, hawkinsTagAudioVideoType9, hawkinsTagAudioVideoType10, hawkinsTagAudioVideoType11, hawkinsTagAudioVideoType12, hawkinsTagAudioVideoType13};
        $VALUES = hawkinsTagAudioVideoTypeArr;
        $ENTRIES = EnumEntriesKt.b(hawkinsTagAudioVideoTypeArr);
    }
}
