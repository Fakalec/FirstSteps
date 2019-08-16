package out.muravev.pv.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import out.muravev.pv.R

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var drawList: List<String>
    private val viewColumns = resources.getInteger(R.integer.call_column)
    private val proportionParameter = resources.getInteger(R.integer.proportion)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val circleColor = Color.BLUE
    private val textColor = Color.BLACK
    private val lineColor = Color.DKGRAY
    private var constantSizeX = 0f
    private var constantSizeY = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawResult(canvas, drawList)
    }

    fun setText(stringList: List<String>) {
        drawList = stringList
        constantSizeX = (context.resources.displayMetrics.widthPixels).toFloat()
        constantSizeY = (context.resources.displayMetrics.heightPixels).toFloat()
        invalidate()
    }

    // todo
    private fun drawResult(canvas: Canvas, drawList: List<String>) {
        var count = 0
        paint.style = Paint.Style.FILL
        paint.textSize = constantSizeX / proportionParameter / 8

        for (i in 0..drawList.lastIndex) {
            if (count != 0 && count % viewColumns == 0) {
                paint.color = circleColor
                canvas.drawCircle(
                    120 / proportionParameter + constantSizeX * count / proportionParameter,
                    100 / proportionParameter + constantSizeY / 32,
                    constantSizeX / proportionParameter / 10,
                    paint
                )
                count = 0
                constantSizeY += 15000 / proportionParameter
            }
            paint.color = circleColor
            canvas.drawCircle(
                120 / proportionParameter + constantSizeX * count / proportionParameter,
                100 / proportionParameter + constantSizeY / 32,
                constantSizeX / proportionParameter / 10,
                paint
            )
            paint.color = lineColor
            canvas.drawLine(
                130 / proportionParameter + constantSizeX * count / proportionParameter,
                constantSizeY / 30 + 200 / proportionParameter,
                constantSizeX * count / proportionParameter + constantSizeX / proportionParameter / 1.2f,
                constantSizeY / 30 + 200 / proportionParameter,
                paint
            )
            paint.color = textColor
            canvas.drawText(
                drawList[i],
                300 / proportionParameter + constantSizeX * count / proportionParameter,
                125 / proportionParameter + constantSizeY / 32,
                paint
            )
            count++
        }
    }
}