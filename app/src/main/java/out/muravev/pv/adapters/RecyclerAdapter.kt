package out.muravev.pv.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import out.muravev.pv.R
import out.muravev.pv.contracts.MainContract

class RecyclerAdapter(private var dataList: List<String>, private var presenter: MainContract.HolderPresenter) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun getItemCount() =
        dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.stringsView.text = dataList[position]
        holder.deleteButton.setOnClickListener {
            presenter.onDeleteButtonClicked(position)
        }
    }
}