package out.muravev.pv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view.view.*

class RecyclerAdapter(private var context: Context, private var dataList: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.stringsView.text = dataList.get(position)
    }

}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val stringsView = view.strings_view
}