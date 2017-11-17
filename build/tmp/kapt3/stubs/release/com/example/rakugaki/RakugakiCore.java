package com.example.rakugaki;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002,-B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0000J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0000J\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0017J\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001cJ\u0010\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020\u0000J\u0006\u0010)\u001a\u00020\u0000J\u0006\u0010*\u001a\u00020\u0000J\u0006\u0010+\u001a\u00020\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/example/rakugaki/RakugakiCore;", "", "baseView", "Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "callback", "Lcom/example/rakugaki/RakugakiCore$Callback;", "getCallback", "()Lcom/example/rakugaki/RakugakiCore$Callback;", "setCallback", "(Lcom/example/rakugaki/RakugakiCore$Callback;)V", "freehand", "Lcom/example/rakugaki/PhotoCanvasView;", "freetext", "Lcom/example/rakugaki/TextCanvasView;", "views", "", "Landroid/view/View;", "freehandEnd", "", "freehandStart", "freetextEnd", "", "freetextStart", "isFreehandNull", "isFreetextNull", "remove", "view", "removeLast", "resetAll", "rewind", "saveImage", "imageView", "Landroid/widget/ImageView;", "setBlackColor", "setBlueColor", "setRedColor", "setWhiteColor", "Callback", "Companion", "rakugaki_release"})
public final class RakugakiCore {
    private java.util.List<android.view.View> views;
    private com.example.rakugaki.PhotoCanvasView freehand;
    private com.example.rakugaki.TextCanvasView freetext;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String baseUrl;
    @org.jetbrains.annotations.Nullable()
    private com.example.rakugaki.RakugakiCore.Callback callback;
    private android.widget.FrameLayout baseView;
    public static final com.example.rakugaki.RakugakiCore.Companion Companion = null;
    
    public final boolean isFreehandNull() {
        return false;
    }
    
    public final boolean isFreetextNull() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBaseUrl() {
        return null;
    }
    
    public final void setBaseUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.rakugaki.RakugakiCore.Callback getCallback() {
        return null;
    }
    
    public final void setCallback(@org.jetbrains.annotations.Nullable()
    com.example.rakugaki.RakugakiCore.Callback p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rakugaki.RakugakiCore freehandStart() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rakugaki.RakugakiCore setRedColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rakugaki.RakugakiCore setBlueColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rakugaki.RakugakiCore setBlackColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rakugaki.RakugakiCore setWhiteColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rakugaki.RakugakiCore freetextStart() {
        return null;
    }
    
    public final void resetAll() {
    }
    
    public final void removeLast() {
    }
    
    public final void remove(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final boolean freehandEnd() {
        return false;
    }
    
    public final void freetextEnd() {
    }
    
    public final void rewind() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String saveImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView) {
        return null;
    }
    
    public RakugakiCore(@org.jetbrains.annotations.Nullable()
    android.widget.FrameLayout baseView) {
        super();
    }
    
    public RakugakiCore() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/rakugaki/RakugakiCore$Callback;", "", "canSave", "", "rakugaki_release"})
    public static abstract interface Callback {
        
        public abstract void canSave();
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/rakugaki/RakugakiCore$Companion;", "", "()V", "create", "Lcom/example/rakugaki/RakugakiCore;", "view", "Landroid/widget/FrameLayout;", "rakugaki_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.rakugaki.RakugakiCore create(@org.jetbrains.annotations.NotNull()
        android.widget.FrameLayout view) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}