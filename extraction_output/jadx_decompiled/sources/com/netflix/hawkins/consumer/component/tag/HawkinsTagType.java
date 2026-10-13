package com.netflix.hawkins.consumer.component.tag;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import p000o.nYA;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.netflix.hawkins.consumer.component.tag.HawkinsTagType[], still in use, count: 1, list:
  (r0v1 com.netflix.hawkins.consumer.component.tag.HawkinsTagType[]) from 0x002e: INVOKE (r0v1 com.netflix.hawkins.consumer.component.tag.HawkinsTagType[]) STATIC call: kotlin.enums.EnumEntriesKt.b(java.lang.Enum[]):o.nYA A[MD:(java.lang.Enum[]):o.nYA (m), WRAPPED] (LINE:47)
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lcom/netflix/hawkins/consumer/component/tag/HawkinsTagType;", "", "Fill", "Standard", "Supplemental", "Offers"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HawkinsTagType {
    Fill,
    Standard,
    Supplemental,
    Offers;

    private static final /* synthetic */ nYA $ENTRIES;

    public static nYA b() {
        return $ENTRIES;
    }

    public static HawkinsTagType[] values() {
        return (HawkinsTagType[]) $VALUES.clone();
    }

    public static HawkinsTagType valueOf(String str) {
        return (HawkinsTagType) Enum.valueOf(HawkinsTagType.class, str);
    }

    static {
        $ENTRIES = EnumEntriesKt.b(hawkinsTagTypeArr);
    }

    private HawkinsTagType() {
        super(str, i);
    }
}
