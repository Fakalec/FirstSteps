package out.muravev.pv.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import out.muravev.pv.R
import out.muravev.pv.data.StringItems

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var drawList: List<StringItems>
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

    fun setText(stringList: List<StringItems>) {
        drawList = stringList
        constantSizeX = (context.resources.displayMetrics.widthPixels).toFloat()
        constantSizeY = (context.resources.displayMetrics.heightPixels).toFloat()
        invalidate()
    }

    private fun drawResult(canvas: Canvas, drawList: List<StringItems>) {
        var count = 0
        paint.style = Paint.Style.FILL
        for (i in 0..drawList.lastIndex) {
            if (count != 0 && count % viewColumns == 0) {
                drawCircleA(canvas, count)
                count = 0
                constantSizeY += resources.getInteger(R.integer.btw_lines_y_distance) / proportionParameter
            }
            drawCircleB(canvas, count)
            drawLine(canvas, count)
            drawText(canvas, drawList, i, count)
            count++
        }
    }

    private fun drawCircleA(canvas: Canvas, count: Int) {
        paint.color = circleColor
        canvas.drawCircle(
            resources.getInteger(R.integer.circle_x_divident) / proportionParameter + constantSizeX * count / proportionParameter,
            resources.getInteger(R.integer.circle_y_divident) / proportionParameter + constantSizeY / resources.getInteger(
                R.integer.circle_y_divider
            ),
            constantSizeX / proportionParameter / resources.getInteger(R.integer.circle_radius_divider),
            paint
        )
    }

    private fun drawCircleB(canvas: Canvas, count: Int) {
        paint.color = circleColor
        canvas.drawCircle(
            resources.getInteger(R.integer.circle_x_divident) / proportionParameter + constantSizeX * count / proportionParameter,
            resources.getInteger(R.integer.circle_y_divident) / proportionParameter + constantSizeY / resources.getInteger(
                R.integer.circle_y_divider
            ),
            constantSizeX / proportionParameter / resources.getInteger(R.integer.circle_radius_divider),
            paint
        )
    }

    private fun drawLine(canvas: Canvas, count: Int) {
        paint.color = lineColor
        canvas.drawLine(
            resources.getInteger(R.integer.line_x_divident) / proportionParameter + constantSizeX * count / proportionParameter,
            constantSizeY / resources.getInteger(R.integer.line_y_divider) + resources.getInteger(R.integer.line_y_divident) / proportionParameter,
            constantSizeX * count / proportionParameter + constantSizeX / proportionParameter / 1.2f,
            constantSizeY / resources.getInteger(R.integer.line_y_divider) + resources.getInteger(R.integer.line_y_divident) / proportionParameter,
            paint
        )
    }

    private fun drawText(canvas: Canvas, drawList: List<StringItems>, position: Int, count: Int) {
        paint.color = textColor
        paint.textSize = constantSizeX / proportionParameter / resources.getInteger(R.integer.date_size_divider)
        canvas.drawText(
            drawList[position].dateFormat(),
            resources.getInteger(R.integer.date_x_divident) / proportionParameter + constantSizeX * count / proportionParameter,
            resources.getInteger(R.integer.date_y_divident) / proportionParameter + constantSizeY / resources.getInteger(
                R.integer.text_y_divider
            ),
            paint
        )
        paint.textSize = constantSizeX / proportionParameter / resources.getInteger(R.integer.string_size_divider)
        canvas.drawText(
            drawList[position].name,
            resources.getInteger(R.integer.string_x_divident) / proportionParameter + constantSizeX * count / proportionParameter,
            resources.getInteger(R.integer.string_y_divident) / proportionParameter + constantSizeY / resources.getInteger(
                R.integer.text_y_divider
            ),
            paint
        )
    }
}