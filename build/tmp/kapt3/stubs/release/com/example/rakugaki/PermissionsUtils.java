package com.example.rakugaki;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/rakugaki/PermissionsUtils;", "", "()V", "checkCameraPermission", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "checkReadStoragePermission", "checkWriteStoragePermission", "rakugaki_release"})
public final class PermissionsUtils {
    public static final com.example.rakugaki.PermissionsUtils INSTANCE = null;
    
    public final boolean checkReadStoragePermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return false;
    }
    
    public final boolean checkWriteStoragePermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return false;
    }
    
    public final boolean checkWriteStoragePermission(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment fragment) {
        return false;
    }
    
    public final boolean checkCameraPermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return false;
    }
    
    public final boolean checkCameraPermission(@org.jetbrains.annotations.NotNull()
    android.support.v4.app.Fragment fragment) {
        return false;
    }
    
    private PermissionsUtils() {
        super();
    }
}