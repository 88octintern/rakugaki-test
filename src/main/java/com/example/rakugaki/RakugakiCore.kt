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

    var freehand: PhotoCanvasView? = null
    var freetext: TextCanvasView? = null

    var isEnabled: Boolean = false

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
        if (!isEnabled) return this
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
        if (!isEnabled) return this
        val base = baseView ?: return this
        val context = baseView?.context ?: return this
        freetext?.let { v ->
            base.removeView(v)
            freetext = null
        }
        freetext = TextCanvasView.makeCanvas(context, PhotoEditCanvasType.EDIT, "", ContextCompat.getColor(context, R.color.red), base.width)
        var lp = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        lp.gravity = Gravity.CENTER_HORIZONTAL
        base.addView(freetext, lp)
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS)
        freetext?.requestFocus()
        return this
    }

    fun removeLast() {
        val base = baseView ?: return

        if (views.isNotEmpty()) {

            val v: View
            if (!isFreehandNull()) {
                v = views.filter { it is PhotoCanvasView }.last()
            } else if (!isFreetextNull()) {
                v = views.filter { it is TextCanvasView }.last()
            } else {
                v = views.last()
            }

            views.remove(v)
            base.removeView(v)
        }
        freehand = null
        freetext = null
    }

    fun resumeText(view: View) {
        val base = baseView ?: return

        if (views.contains(view)) {
            val index = views.indexOf(view)
            val v = views.get(index)
            views.remove(v)
            base.removeView(v)
            if (v is TextCanvasView) {
                freetext = v
                views.add(v)
                base.addView(v)
            }
        }
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

    fun freehandEnd(): Boolean {
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

        freetext?.let { textView ->
            //すでにviewが追加されているのか判定
            if (views.contains(textView)) {
                callback?.canSave()
            } else {
                val v: TextCanvasView? = textView.createNewMoveCanvas(base)
                if (v != null) {
                    views.add(v)
                }
                base.removeView(textView)

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
            freetext = null
        }

    }

    fun movable() {
        views.map {
            if (it is PhotoCanvasView) {
                (it as PhotoCanvasView).canvasType = PhotoEditCanvasType.MOVE
            }
            if (it is TextCanvasView) {
                (it as TextCanvasView).canvasType = PhotoEditCanvasType.MOVE
                (it as TextCanvasView).movable()
            }
        }
    }

    fun fixedFreehand() {
        views.map {
            if (it is PhotoCanvasView) {
                (it as PhotoCanvasView).canvasType = PhotoEditCanvasType.FIXED
            }
        }
    }

    fun fixed() {
        views.map {
            if (it is PhotoCanvasView) {
                (it as PhotoCanvasView).canvasType = PhotoEditCanvasType.FIXED
            }
            if (it is TextCanvasView) {
                (it as TextCanvasView).canvasType = PhotoEditCanvasType.FIXED
            }
        }
    }

    fun rewind() {
        println("rewind()")
        val base = baseView ?: return

        if (views.isNotEmpty()) {
            val v = views.filter { it is PhotoCanvasView }.last()
            if (v is PhotoCanvasView) {
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

        BitmapUtils.getViewCapture(baseView, 0, 0, baseView.width, baseView.height)?.let{ bgBitmap ->
            val bgCanvas = Canvas(bgBitmap)

            views.map {
                BitmapUtils.getViewCapture(it, 0, 0, it.width, it.height)?.let { bitmap ->
                    bgCanvas.drawBitmap(bitmap, it.left.toFloat() - imageView.left.toFloat(), it.top.toFloat() - imageView.top.toFloat(), null)
                }
            }

            val url = BitmapUtils.save(baseView.context, bgBitmap)

            views.map {
                base.removeView(it)
            }
            views.clear()

            baseUrl = url

            return url
        }
        return null
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