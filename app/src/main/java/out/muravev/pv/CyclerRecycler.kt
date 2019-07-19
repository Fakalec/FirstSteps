package out.muravev.pv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cycler_recycler.*

class CyclerRecycler : AppCompatActivity() {

    val listStrings: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycler_recycler)
        addStrings()
        cycler_recycler.layoutManager = LinearLayoutManager(this)
        cycler_recycler.adapter = CyclerAdapter(listStrings,this)
    }

    fun addStrings() {
        listStrings.add("1")
        listStrings.add("2")
        listStrings.add("3")
        listStrings.add("4")
        listStrings.add("5")
        listStrings.add("6")
        listStrings.add("7")
        listStrings.add("8")
        listStrings.add("9")
    }

}
