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
    private val proportionScreen = resources.getInteger(R.integer.proportion)
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

    private fun drawResult(canvas: Canvas, drawList: List<String>) {
        var count = 0
        paint.style = Paint.Style.FILL
        paint.textSize = constantSizeX / proportionScreen / 8

        for (i in 0..drawList.lastIndex) {
            if (count != 0 && count % viewColumns == 0) {
                paint.color = circleColor
                canvas.drawCircle(
                    120 / proportionScreen + constantSizeX * count / proportionScreen,
                    100 / proportionScreen + constantSizeY / 32,
                    constantSizeX / proportionScreen / 10,
                    paint
                )
                count = 0
                constantSizeY += 15000 / proportionScreen
            }
            paint.color = circleColor
            canvas.drawCircle(
                120 / proportionScreen + constantSizeX * count / proportionScreen,
                100 / proportionScreen + constantSizeY / 32,
                constantSizeX / proportionScreen / 10,
                paint
            )
            paint.color = lineColor
            canvas.drawLine(
                130 / proportionScreen + constantSizeX * count / proportionScreen,
                constantSizeY / 30 + 200 / proportionScreen,
                constantSizeX * count / proportionScreen + constantSizeX / proportionScreen / 1.2f,
                constantSizeY / 30 + 200 / proportionScreen,
                paint
            )
            paint.color = textColor
            canvas.drawText(
                drawList[i],
                300 / proportionScreen + constantSizeX * count / proportionScreen,
                125 / proportionScreen + constantSizeY / 32,
                paint
            )
            count++
        }
    }
}