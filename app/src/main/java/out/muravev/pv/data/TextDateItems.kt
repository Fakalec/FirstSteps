package out.muravev.pv.data

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class TextDateItems(val name: String, val creationDate: Date) {
    @SuppressLint("SimpleDateFormat")
    fun dateFormat(): String {
        val id // todo
        val formatter = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        return formatter.format(creationDate)
    }
}