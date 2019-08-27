package out.muravev.pv.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import out.muravev.pv.R
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.data.TextDateItems

class StringsRecyclerAdapter(
    private var dataList: List<TextDateItems>,
    private var presenter: MainContract.HolderPresenter
) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun getItemCount() =
        dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.stringsView.text = dataList[position].name
        holder.dateView.text = dataList[position].dateFormat()
        holder.idView.text = dataList[position].id.toString()
        holder.deleteButton.setOnClickListener {
            presenter.onDeleteButtonClicked(dataList[position].id)
        }
    }
}