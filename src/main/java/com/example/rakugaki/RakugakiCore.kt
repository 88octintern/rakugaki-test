package com.example.rakugaki

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.ImageView


/**
 * Created by daisuke on 2017/10/23.
 *
 * view management for freehand,blackboard, etc
 */
class RakugakiCore constructor(private var baseView: FrameLayout? = null) {

    //追加されたviewを保持する
    private var views: MutableList<View> = mutableListOf()
    //private var textViews: MutableList<TextCanvasView> = mutableListOf()

    private var freehand: PhotoCanvasView? = null
    private var freetext: TextCanvasView? = null

    fun isFreehandNull(): Boolean {
        if (freehand == null) {
            return true
        }
        return false
    }

    fun isFreetextNull(): Boolean {
        if (freetext == null) {
            return true
        }
        return false
    }

    var baseUrl: String? = null

    var callback: Callback? = null

    //freehandを開始する
    fun freehandStart(): RakugakiCore {
        val base = baseView ?: return this
        val context = baseView?.context ?: return this

        freehand?.let { v ->
            base.removeView(v)
            freehand = null
        }
        freehand = null
        freehand = PhotoCanvasView.makeCanvas(context, PhotoEditCanvasType.EDIT)
        freehand?.setWriteMinMax(base.x, base.x + base.width, base.y, base.y + base.height)
        base.addView(freehand)
        return this
    }

    fun setRedColor(): RakugakiCore {
        freehand?.setRed()
        freetext?.setRed()
        return this
    }

    fun setBlueColor(): RakugakiCore {
        freehand?.setBlue()
        freetext?.setBlue()
        return this
    }

    fun setBlackColor(): RakugakiCore {
        freehand?.setBlack()
        freetext?.setBlack()
        return this
    }

    fun setWhiteColor(): RakugakiCore {
        freehand?.setWhite()
        freetext?.setWhite()
        return this
    }

    fun freetextStart(): RakugakiCore {
        val base = baseView ?: return this
        val context = baseView?.context ?: return this
        freetext?.let { v ->
            base.removeView(v)
            freetext = null
        }
        freetext = null
        freetext = TextCanvasView.makeCanvas(context, PhotoEditCanvasType.EDIT, "", ContextCompat.getColor(context, R.color.red))
        var lp = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        lp.gravity = Gravity.CENTER_HORIZONTAL
        base.addView(freetext, lp)
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS)
        freetext?.requestFocus()
        return this
    }

    fun resetAll() {
        val base = baseView ?: return

        if (views.isNotEmpty()) {
            views.map {
                base.removeView(it)
            }
            views.clear()
        }
        freehand = null
        freetext = null
    }

    fun removeLast() {
        val base = baseView ?: return

        if (views.isNotEmpty()) {

            val v:View
            if(!isFreehandNull()){
                v = views.filter { it is PhotoCanvasView }.last()
            }else if (!isFreetextNull()){
                v = views.filter { it is TextCanvasView }.last()
            }else{
                v = views.last()
            }

            views.remove(v)
            base.removeView(v)
        }
        freehand = null
        freetext = null
    }

    fun remove(view: View) {
        val base = baseView ?: return

        if (views.isNotEmpty()) {
            base.removeView(view)
            views.remove(view)
        }
        freehand = null
        freetext = null
    }

    fun freehandEnd():Boolean {
        val base = baseView ?: return false
        val v = freehand?.createNewMoveCanvas(base) ?: return false
        views.add(v)
        base.removeView(freehand)
        freehand = null

        var observer = v.viewTreeObserver
        val listener = object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                callback?.canSave()
                observer.removeOnGlobalLayoutListener(this)
            }
        }
        observer.addOnGlobalLayoutListener(listener)
        return true
    }

    fun freetextEnd() {
        val base = baseView ?: return

        val v: TextCanvasView? = freetext?.createNewMoveCanvas(base)
        if (v != null) {
            views.add(v)
        }
        base.removeView(freetext)
        freetext = null

        v?.viewTreeObserver?.let { observer ->
            val listener = object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    callback?.canSave()
                    observer.removeOnGlobalLayoutListener(this)
                }
            }
            observer.addOnGlobalLayoutListener(listener)
        }
    }

    fun rewind() {
        println("rewind()")
        val base = baseView ?: return

        if (views.isNotEmpty()) {
            val v = views.filter { it is PhotoCanvasView }.last()
            if(v is PhotoCanvasView) {
                base.removeView(v)
                views.removeAt(views.size - 1)
            }
        }
        freehand = null
        freetext = null
    }

    fun saveImage(imageView: ImageView): String? {
        val base = baseView ?: return null
        val baseView = imageView

        val bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val bgBitmap = BitmapUtils.getViewCapture(baseView, 0, 0, baseView.width, baseView.height)
        val bgCanvas = Canvas(bgBitmap)

        views.map {
            val bitmap = BitmapUtils.getViewCapture(it, 0, 0, it.width, it.height)
            bgCanvas.drawBitmap(bitmap, it.left.toFloat() - imageView.left.toFloat(), it.top.toFloat() - imageView.top.toFloat(), null)
        }

        val url = BitmapUtils.save(baseView.context, bgBitmap)

        views.map {
            base.removeView(it)
        }
        views.clear()

        baseUrl = url

        return url
    }

    interface Callback {
        fun canSave()
    }

    companion object {
        fun create(view: FrameLayout): RakugakiCore {
            val p = RakugakiCore(view)
            return p
        }
    }
}