package com.example.rakugaki

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import org.greenrobot.eventbus.EventBus

/** 写真に書き込める文字列を扱うView */
class TextCanvasView constructor(context: Context, var canvasType: PhotoEditCanvasType, val inputText: String?, var color: Int) : EditText(context) {

    private var maxX: Float = Float.MIN_VALUE
    private var minX: Float = Float.MAX_VALUE
    private var maxY: Float = Float.MIN_VALUE
    private var minY: Float = Float.MAX_VALUE
    private var oldrawx: Int = 0
    private var oldrawy: Int = 0

    //複製可能の判定
    private var canCopy: Boolean = false

    private var size = 28.0f

    // ドラッグ中に移動量を取得するための変数
    private var oldx: Float = 0.0f
    private var oldy: Float = 0.0f

    init {
        when (canvasType) {
            PhotoEditCanvasType.EDIT -> {
                this.setTextColor(color)
                this.setTextSize(size)
                this.setBackgroundColor(Color.TRANSPARENT)
                this.setHint("テキストを入力してください。")
                this.setOnFocusChangeListener { view, isFocused ->
                    if (!isFocused) {
                        // ソフトキーボードを非表示にする
                        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
                    }
                }
                this.setBackgroundColor(Color.TRANSPARENT)
                this.setText(inputText)
            }
            PhotoEditCanvasType.MOVE -> {
                this.isEnabled = false
                this.isFocusable = false
                this.isFocusableInTouchMode = false
                this.setBackgroundColor(Color.TRANSPARENT)
                this.setTextColor(color)
                this.setTextSize(size)
                this.setText(inputText)
            }
        }
    }

    fun setRed() {
        color = ContextCompat.getColor(context, R.color.red)
        this.setTextColor(color)
    }

    fun setBlue() {
        color = ContextCompat.getColor(context, R.color.blue)
        this.setTextColor(color)
    }

    fun setBlack() {
        color = ContextCompat.getColor(context, R.color.black)
        this.setTextColor(color)
    }

    fun setWhite() {
        color = ContextCompat.getColor(context, R.color.white)
        this.setTextColor(color)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (canvasType == PhotoEditCanvasType.EDIT) {
            super.onTouchEvent(event)
            return true
        } else if (canvasType == PhotoEditCanvasType.MOVE) {
            val x = event.rawX.toInt()
            val y = event.rawY.toInt()
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    // 今回イベントでのView移動先の位置
                    val left = this.left + (x - oldrawx)
                    val top = this.top + (y - oldrawy)
                    // Viewを移動する
                    this.layout(left, top, left + this.width, top + this.height)

                    EventBus.getDefault().post(RakugakiTapEvent(RakugakiTapEvent.RakugakiEvent.DRAGGING, this))
                }
                MotionEvent.ACTION_UP -> {
                    val lp = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
                    lp.setMargins(this.left, this.top, 0, 0)
                    this.setLayoutParams(lp)

                    EventBus.getDefault().post(RakugakiTapEvent(RakugakiTapEvent.RakugakiEvent.RELEASED, this))
                }
            }
            // 今回のタッチ位置を保持
            oldrawx = x
            oldrawy = y

            super.onTouchEvent(event)
            return true
        }
        return false
    }

    fun createNewMoveCanvas(frameLayout: FrameLayout): TextCanvasView? {
        if (this.text == null || this.text.isEmpty()) {
            return null
        }

        //描画viewの幅、高さを計算
        val lw = this.width
        val lh = this.height

        // 新しいビュー(pcv)の作成と、そのビューへの上のビットマップの描画
        val pcv = makeCanvas(context, PhotoEditCanvasType.MOVE, text.toString(), this.color)
        // 新しい描画viewの位置を指定
        var lp = FrameLayout.LayoutParams(lw, lh)
        lp.leftMargin = this.x.toInt()
        lp.topMargin = this.y.toInt()
        pcv.layoutParams = lp
        frameLayout.addView(pcv)

        return pcv
    }

    companion object {
        fun makeCanvas(context: Context, type: PhotoEditCanvasType, text: String?, color: Int): TextCanvasView {
            return TextCanvasView(context, type, text, color)
        }
    }
}