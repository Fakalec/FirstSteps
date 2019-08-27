package out.muravev.pv.data

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class TextDateItems(val name: String, val creationDate: Date, val id: Int) {
    @SuppressLint("SimpleDateFormat")
    fun dateFormat(): String {
        val formatter = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        return formatter.format(creationDate)
    }
}