package com.example.rakugaki;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010!\u001a\u0004\u0018\u00010\u00002\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/rakugaki/TextCanvasView;", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "canvasType", "Lcom/example/rakugaki/PhotoEditCanvasType;", "inputText", "", "color", "", "(Landroid/content/Context;Lcom/example/rakugaki/PhotoEditCanvasType;Ljava/lang/String;I)V", "canCopy", "", "getCanvasType", "()Lcom/example/rakugaki/PhotoEditCanvasType;", "setCanvasType", "(Lcom/example/rakugaki/PhotoEditCanvasType;)V", "getColor", "()I", "setColor", "(I)V", "getInputText", "()Ljava/lang/String;", "maxX", "", "maxY", "minX", "minY", "oldrawx", "oldrawy", "oldx", "oldy", "size", "createNewMoveCanvas", "frameLayout", "Landroid/widget/FrameLayout;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setBlack", "", "setBlue", "setRed", "setWhite", "Companion", "rakugaki_release"})
public final class TextCanvasView extends android.widget.EditText {
    private float maxX;
    private float minX;
    private float maxY;
    private float minY;
    private int oldrawx;
    private int oldrawy;
    private boolean canCopy;
    private float size;
    private float oldx;
    private float oldy;
    @org.jetbrains.annotations.NotNull()
    private com.example.rakugaki.PhotoEditCanvasType canvasType;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String inputText = null;
    private int color;
    public static final com.example.rakugaki.TextCanvasView.Companion Companion = null;
    
    public final void setRed() {
    }
    
    public final void setBlue() {
    }
    
    public final void setBlack() {
    }
    
    public final void setWhite() {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.rakugaki.TextCanvasView createNewMoveCanvas(@org.jetbrains.annotations.NotNull()
    android.widget.FrameLayout frameLayout) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rakugaki.PhotoEditCanvasType getCanvasType() {
        return null;
    }
    
    public final void setCanvasType(@org.jetbrains.annotations.NotNull()
    com.example.rakugaki.PhotoEditCanvasType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInputText() {
        return null;
    }
    
    public final int getColor() {
        return 0;
    }
    
    public final void setColor(int p0) {
    }
    
    public TextCanvasView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.rakugaki.PhotoEditCanvasType canvasType, @org.jetbrains.annotations.Nullable()
    java.lang.String inputText, int color) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2 = {"Lcom/example/rakugaki/TextCanvasView$Companion;", "", "()V", "makeCanvas", "Lcom/example/rakugaki/TextCanvasView;", "context", "Landroid/content/Context;", "type", "Lcom/example/rakugaki/PhotoEditCanvasType;", "text", "", "color", "", "rakugaki_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.rakugaki.TextCanvasView makeCanvas(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.example.rakugaki.PhotoEditCanvasType type, @org.jetbrains.annotations.Nullable()
        java.lang.String text, int color) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}