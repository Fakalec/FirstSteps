package out.muravev.pv.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var texte: ArrayList<String>
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val circleColor = Color.BLUE
    private val lineColor = Color.BLACK
    private var constantSizeX = (context.resources.displayMetrics.widthPixels).toFloat()
    private var constantSizeY = (context.resources.displayMetrics.heightPixels).toFloat()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawKek(canvas, texte)
    }

    fun setText(textik: ArrayList<String>) {
        texte = textik
    }

    private fun drawKek(canvas: Canvas, texte: ArrayList<String>) {
        paint.color = lineColor
        paint.style = Paint.Style.FILL
        paint.textSize = 50f
        paint.color = circleColor
        paint.style = Paint.Style.FILL

        for (i in 0..texte.lastIndex) {
            if () {
                constantSizeY *= 100
            }
            canvas.drawCircle(50 + constantSizeX * i / 3.5f, constantSizeY / 32, constantSizeX / 35, paint)
            canvas.drawLine(
                60 + constantSizeX * i / 3.5f,
                constantSizeY / 32 + constantSizeY / 55,
                50 + constantSizeX * i / 3.5f + constantSizeX / 3.5f,
                constantSizeY / 32 + constantSizeY / 55,
                paint
            )
            canvas.drawText(
                texte[i],
                50 + constantSizeX * i / 3.5f + 50,
                constantSizeY / 32 + constantSizeY / 80,
                paint
            )
        }
    }
}