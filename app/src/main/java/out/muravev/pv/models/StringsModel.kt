package out.muravev.pv.models

//import out.muravev.pv.databases.StringDataAccessor
import androidx.room.Entity
import out.muravev.pv.algorithms.ListSort
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.contracts.StringDataDao
import out.muravev.pv.databases.DbWorkerThread
import out.muravev.pv.databases.StringData
import out.muravev.pv.databases.StringDataBase
import java.util.*

@Entity
class StringsModel(private val listSort: ListSort, val sqlData: StringDataBase?) {

    private lateinit var listStrings : StringData
    private var resultScreenListener: MainContract.ScreenChangeListener? = null
    private var mainScreenListener: MainContract.ScreenChangeListener? = null
    private var savedString: String = ""
    private val dbWorkerThread = DbWorkerThread("DbThread")
    private val stringDao = sqlData?.stringDao()

    fun putResultListener(screenChangeCallback: MainContract.ScreenChangeListener) {
        resultScreenListener = screenChangeCallback
    }

    fun putMainListener(screenChangeCallback: MainContract.ScreenChangeListener) {
        mainScreenListener = screenChangeCallback
    }

    fun clearResultListener() {
        resultScreenListener = null
    }

    fun clearMainListener() {
        mainScreenListener = null
    }

    fun hasEnteredText() =
        savedString.isNotEmpty()

    fun setTypedText(text: String) {
        savedString = text
    }

    fun resultScreenInitialize() {
        resultScreenListener?.onScreenChanged()
    }

    fun mainScreenInitialize() {
        mainScreenListener?.onScreenChanged()
    }

    fun addNewItem() {
        listStrings.stringItem = savedString
        stringDao?.insert(listStrings)
    }

//    fun deleteItemOnPosition(itemPosition: Int) {
////        sqlData.deleteString(itemPosition)
//    }

    fun clearEnteredText() {
        savedString = ""
    }

    fun getUnsortedList() =
        stringDao?.getAllList()

    fun getSortedList() =
        listSort.getMergingBranchedLists(stringDao!!.getAllList())

    fun isNotEmptyList() =
        stringDao?.getAllList()?.isNotEmpty()

    fun getReverseSortedList() =
        listSort.getMergingBranchedLists(stringDao!!.getAllList()).reversed()

    fun clearLists() {
//        sqlData?.deleteAll(stringData)
    }

    fun initModel() {
        dbWorkerThread.start()
        val task = Runnable {
            stringDao?.getAllList()
        }
        dbWorkerThread.postTask(task)
    }

    fun release() {
        dbWorkerThread.quit()
    }
}