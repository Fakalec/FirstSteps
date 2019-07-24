package out.muravev.pv.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view.view.*

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val stringsView: TextView = view.strings_view
}