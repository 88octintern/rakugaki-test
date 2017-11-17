package com.example.rakugaki;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0016\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR \u0010%\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b\'\u0010\u000eR \u0010(\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR\u001e\u0010+\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014R \u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b\u00a8\u00062"}, d2 = {"Lcom/example/rakugaki/Photo;", "Ljava/io/Serializable;", "()V", "body", "", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "createdAt", "Ljava/util/Date;", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "id", "", "getId", "()J", "setId", "(J)V", "imageThumbnailUrl", "getImageThumbnailUrl", "setImageThumbnailUrl", "imageUrl", "getImageUrl", "setImageUrl", "isEditableFlg", "", "()Z", "setEditableFlg", "(Z)V", "isSelected", "setSelected", "name", "getName", "setName", "originatedAt", "getOriginatedAt", "setOriginatedAt", "updatedAt", "getUpdatedAt", "setUpdatedAt", "userId", "getUserId", "setUserId", "userName", "getUserName", "setUserName", "Companion", "rakugaki_release"})
public class Photo implements java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "id")
    @com.google.gson.annotations.Expose()
    private long id;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "body")
    @com.google.gson.annotations.Expose()
    private java.lang.String body;
    @com.google.gson.annotations.SerializedName(value = "user_id")
    @com.google.gson.annotations.Expose()
    private long userId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "user_name")
    @com.google.gson.annotations.Expose()
    private java.lang.String userName;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "name")
    @com.google.gson.annotations.Expose()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "image_thumbnail_url")
    @com.google.gson.annotations.Expose()
    private java.lang.String imageThumbnailUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "image_url")
    @com.google.gson.annotations.Expose()
    private java.lang.String imageUrl;
    @com.google.gson.annotations.SerializedName(value = "editable_flg")
    @com.google.gson.annotations.Expose()
    private boolean isEditableFlg;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "created_at")
    @com.google.gson.annotations.Expose()
    private java.util.Date createdAt;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "updated_at")
    @com.google.gson.annotations.Expose()
    private java.util.Date updatedAt;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "originated_at")
    @com.google.gson.annotations.Expose()
    private java.util.Date originatedAt;
    private boolean isSelected;
    public static final com.example.rakugaki.Photo.Companion Companion = null;
    
    public final long getId() {
        return 0L;
    }
    
    public final void setId(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBody() {
        return null;
    }
    
    public final void setBody(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final long getUserId() {
        return 0L;
    }
    
    public final void setUserId(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageThumbnailUrl() {
        return null;
    }
    
    public final void setImageThumbnailUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    public final void setImageUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean isEditableFlg() {
        return false;
    }
    
    public final void setEditableFlg(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getOriginatedAt() {
        return null;
    }
    
    public final void setOriginatedAt(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    public final boolean isSelected() {
        return false;
    }
    
    public final void setSelected(boolean p0) {
    }
    
    public Photo() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/rakugaki/Photo$Companion;", "", "()V", "getPhoto", "Lcom/example/rakugaki/Photo;", "photoid", "", "(Ljava/lang/Long;)Lcom/example/rakugaki/Photo;", "rakugaki_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.rakugaki.Photo getPhoto(@org.jetbrains.annotations.Nullable()
        java.lang.Long photoid) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}