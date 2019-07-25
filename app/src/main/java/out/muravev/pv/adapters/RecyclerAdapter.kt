package out.muravev.pv.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import out.muravev.pv.R

class RecyclerAdapter(private var context: Context, private var dataList: List<String>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.stringsView.text = dataList[position]
    }
}