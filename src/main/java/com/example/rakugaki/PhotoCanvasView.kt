package com.example.rakugaki

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.support.v4.content.ContextCompat
import android.view.MotionEvent
import android.widget.FrameLayout
import android.widget.ImageView
import org.greenrobot.eventbus.EventBus


/** フリーハンド書き込みを扱うView */
class PhotoCanvasView constructor(context: Context, var canvasType: PhotoEditCanvasType) : ImageView(context) {
    private val paint: Paint by lazy { Paint() }
    private val path: Path by lazy { Path() }

    private var maxX: Float = Float.MIN_VALUE
    private var minX: Float = Float.MAX_VALUE
    private var maxY: Float = Float.MIN_VALUE
    private var minY: Float = Float.MAX_VALUE

    private var writeMinX: Float =  Float.MIN_VALUE
    private var writeMaxX: Float =  Float.MAX_VALUE
    private var writeMinY: Float =  Float.MIN_VALUE
    private var writeMaxY: Float =  Float.MAX_VALUE



    private var oldrawx: Int = 0
    private var oldrawy: Int = 0

    //ペンの太さ
    private val strokeWidth = 10f

    //複製可能の判定
    private var canCopy: Boolean = false

    // ドラッグ中に移動量を取得するための変数
    private var oldx: Float = 0.0f
    private var oldy: Float = 0.0f

    var color:Color? = null

    init {
        paint.color = ContextCompat.getColor(context, R.color.red);
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = strokeWidth
    }

    fun setRed(){
        paint.color = ContextCompat.getColor(context, R.color.red)
    }

    fun setBlue(){
        paint.color = ContextCompat.getColor(context, R.color.blue)
    }


    fun setBlack(){
        paint.color = ContextCompat.getColor(context, R.color.black)
    }


    fun setWhite(){
        paint.color = ContextCompat.getColor(context, R.color.white)
    }

    fun setWriteMinMax(writeMinX:Float,writeMaxX:Float,writeMinY:Float,writeMaxY:Float){
        this.writeMinX = writeMinX
        this.writeMaxX = writeMaxX
        this.writeMinY = writeMinY
        this.writeMaxY = writeMaxY
    }

    override fun onDraw(canvas: Canvas?) {
        when (canvasType) {
            PhotoEditCanvasType.MOVE -> super.onDraw(canvas)
            PhotoEditCanvasType.EDIT -> canvas?.drawPath(path, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val x = event.x
        val y = event.y

        if (canvasType == PhotoEditCanvasType.EDIT) {
            canCopy = true

            println("x:" + x.toString())
            println("y:" + y.toString())

            if(!checkWritable(x,y)) return false

            updateMINMAX(x, y)
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    path.moveTo(x, y)
                    invalidate()
                }
                MotionEvent.ACTION_MOVE -> {
                    path.lineTo(x, y)
                    invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    path.lineTo(x, y)
                    invalidate()
                }
            }
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
                    val lp = FrameLayout.LayoutParams(this.width, this.height)
                    lp.setMargins(this.left, this.top, 0, 0)
                    this.setLayoutParams(lp)

                    EventBus.getDefault().post(RakugakiTapEvent(RakugakiTapEvent.RakugakiEvent.RELEASED,this))
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

    fun checkWritable(x:Float,y:Float):Boolean{
        val stroke = strokeWidth / 2.0

        if(x - stroke >= writeMinX && x + stroke <= writeMaxX && y - stroke >= writeMinY && y + stroke <= writeMaxY){
            return true
        }
        return false
    }

    fun createNewMoveCanvas(frameLayout: FrameLayout): PhotoCanvasView? {
        if (!canCopy) return null

        //ペンの太さの分調整
        val sw = strokeWidth / 2.0f
        minX -= sw
        minY -= sw
        maxX += sw
        maxY += sw

        //描画viewの幅、高さを計算
        val lw = (maxX - minX).toInt()
        val lh = (maxY - minY).toInt()

        // 新しいビュー(pcv)の作成と、そのビューへの上のビットマップの描画
        val pcv = makeCanvas(context, PhotoEditCanvasType.MOVE)
        // 新しい描画viewの位置を指定
        var lp = FrameLayout.LayoutParams(lw, lh)
        lp.leftMargin = minX.toInt()
        lp.topMargin = minY.toInt()
        pcv.layoutParams = lp
        println("lp width:" + lp.width.toString())
        println("lp height:" + lp.height.toString())

        //全体から対象のviewのbitmapをくり抜いて取得
        val captured = BitmapUtils.getViewCapture(this, minX.toInt(), minY.toInt(), lw, lh)
        pcv.setImageBitmap(captured)

        println("pcv width:" + pcv.width.toString())
        println("pcv height:" + pcv.height.toString())

        println("captured width:" + captured.width.toString())
        println("captured height:" + captured.height.toString())

        frameLayout.removeView(this)
        frameLayout.addView(pcv)

        println("pcv width:" + pcv.width.toString())
        println("pcv height:" + pcv.height.toString())

        return pcv
    }

    fun updateMINMAX(x: Float, y: Float) {
        minX = minOf(x, minX)
        maxX = maxOf(x, maxX)
        minY = minOf(y, minY)
        maxY = maxOf(y, maxY)
    }

    companion object {
        fun makeCanvas(context: Context, type: PhotoEditCanvasType): PhotoCanvasView {
            return PhotoCanvasView(context, type)
        }
    }
}
