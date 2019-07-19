package out.muravev.pv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cycler_view.view.*

class CyclerAdapter(val items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) : ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cycler_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.stringsView?.text = items.get(position)
    }

}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val stringsView = view.strings_view
}

