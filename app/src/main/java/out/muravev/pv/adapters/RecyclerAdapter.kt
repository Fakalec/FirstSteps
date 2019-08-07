package out.muravev.pv.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import out.muravev.pv.R
import out.muravev.pv.contracts.MainContract

class RecyclerAdapter(private var dataList: List<String>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    private lateinit var presenter: MainContract.MainFragmentPresenter

    override fun getItemCount() =
        dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.stringsView.text = dataList[position]
        holder.deleteButton.setOnClickListener { presenter.onDeleteButtonClicked(position) }
    }

//    private fun removeItem(position: Int) {
//        dataList.remove
//    }
}