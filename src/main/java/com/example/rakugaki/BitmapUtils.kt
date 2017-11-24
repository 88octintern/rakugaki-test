package com.example.rakugaki

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * Created by 88oct on 2017/10/23.
 */
object BitmapUtils {

    fun getViewCapture(view: View, x: Int, y: Int, w: Int, h: Int): Bitmap? {
        try {
            view.setDrawingCacheEnabled(true)
            view.buildDrawingCache()
            val cache = view.getDrawingCache()
            val screenShot = Bitmap.createBitmap(cache, x, y, w, h)
            view.setDrawingCacheEnabled(false)
            return screenShot
        }catch (e:Exception){
            return null
        }
    }

    fun save(context: Context, bitmap: Bitmap):String? {
        val fileName = System.currentTimeMillis().toString() + ".jpg"
        var file = File(context.externalCacheDir,fileName)

        var out: FileOutputStream? = null
        try {
            out = FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush()
            return file.path
        } catch (e : IOException) {
            e.printStackTrace()
            return null
        } finally {
            try {
                out?.let{ it.close() }
            } catch (e : IOException) {
                e.printStackTrace();
            }
            return file.path
            //return null
        }
    }

    /**
     * フォトギャラリーに画像を保存する
     */
    fun savePictureToAlbum(uri: Uri, context: Context) {
        val imageFileName = System.currentTimeMillis().toString() + ".jpg"
        /** ギャラリーのパス  */
        // FIXME: die name
        val dirPath = Environment.getExternalStorageDirectory().toString() + "/" + "hoge" + "/"

        try {
            val image = File(dirPath + imageFileName)
            image.parentFile.mkdir()
            /** 書き出すアプリ内のパス  */
            val output = FileOutputStream(image)

            val input = context.contentResolver.openInputStream(uri)
            // バッファーを使って画像を書き出す
            val DEFAULT_BUFFER_SIZE = 10240 * 4
            val buf = ByteArray(DEFAULT_BUFFER_SIZE)
            var len: Int

            while(true){
                len = input!!.read(buf)
                if(len <= 0)
                    break
                output.write(buf, 0, len)
            }
            output.flush()
            output.close()
            input?.close()

            // 保存した画像をアンドロイドのデータベースへ登録
            registerDatabase(image.absolutePath, context)
        } catch (ie: IOException) {
            Log.d("BitmapUtils", "local app save error:" + ie.message)
        } catch (e: Exception) {
            Log.d("BitmapUtils", "local app save error:" + e.message)
        }

    }

    private fun registerDatabase(file: String, context: Context) {
        val contentValues = ContentValues()
        val contentResolver = context.contentResolver
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        contentValues.put("_data", file)
        contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues)
    }
}