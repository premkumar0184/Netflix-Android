package com.netflix.hawkins.consumer.component.avatar;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import p000o.nYA;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.netflix.hawkins.consumer.component.avatar.HawkinsAvatarSize[], still in use, count: 1, list:
  (r0v1 com.netflix.hawkins.consumer.component.avatar.HawkinsAvatarSize[]) from 0x0042: INVOKE (r0v1 com.netflix.hawkins.consumer.component.avatar.HawkinsAvatarSize[]) STATIC call: kotlin.enums.EnumEntriesKt.b(java.lang.Enum[]):o.nYA A[MD:(java.lang.Enum[]):o.nYA (m), WRAPPED] (LINE:67)
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b"}, d2 = {"Lcom/netflix/hawkins/consumer/component/avatar/HawkinsAvatarSize;", "", "Lo/bah;", "size", "F", "getSize-D9Ej5fM", "()F", "ExtraSmall", "Small", "Medium", "Large", "ExtraLarge"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HawkinsAvatarSize {
    ExtraSmall(48.0f),
    Small(56.0f),
    Medium(64.0f),
    Large(100.0f),
    ExtraLarge(128.0f);

    private static final /* synthetic */ nYA $ENTRIES;
    private final float size;

    private HawkinsAvatarSize(float f) {
        super(str, i);
        this.size = f;
    }

    public static nYA a() {
        return $ENTRIES;
    }

    public static HawkinsAvatarSize[] values() {
        return (HawkinsAvatarSize[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: getSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getSize() {
        return this.size;
    }

    public static HawkinsAvatarSize valueOf(String str) {
        return (HawkinsAvatarSize) Enum.valueOf(HawkinsAvatarSize.class, str);
    }

    static {
        $ENTRIES = EnumEntriesKt.b(hawkinsAvatarSizeArr);
    }
}
