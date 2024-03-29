package out.muravev.pv.data

import out.muravev.pv.contracts.MainContract
import out.muravev.pv.databases.TextItemDatabase
import out.muravev.pv.databases.TextItemEntity
import out.muravev.pv.threads.DbWorkerThread
import java.util.*

class TextItemModel(private val listMergeSortAlgo: ListMergeSortAlgo, sqlData: TextItemDatabase) {

    private var listStrings = arrayListOf<TextDateItems>()
    private var resultScreenListener: MainContract.ScreenChangeListener? = null
    private var mainScreenListener: MainContract.ScreenChangeListener? = null
    private var savedString: String = ""
    private val dbWorkerThread = DbWorkerThread("DbThread")
    private val stringDao = sqlData.stringDao()
    private var id = -1

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
        if (listStrings.isNotEmpty()) {
            id = listStrings[listStrings.lastIndex].id
        }
        listStrings.add(TextDateItems(savedString, Date(), ++id))
        val stringsEntity = TextItemEntity(
            listStrings[listStrings.lastIndex].creationDate,
            listStrings[listStrings.lastIndex].name,
            listStrings[listStrings.lastIndex].id
        )
        val task = Runnable {
            stringDao.insertString(stringsEntity)
        }
        dbWorkerThread.postTask(task)
    }

    fun deleteItemOnIdKey(idKey: Int) {
        for (i in 0..listStrings.lastIndex) {
            if (idKey == listStrings[i].id) {
                val task = Runnable {
                    stringDao.deleteOnIdKey(listStrings[i].id)
                    listStrings.removeAt(i)
                }
                dbWorkerThread.postTask(task)
                break
            }
        }
    }

    fun clearEnteredText() {
        savedString = ""
    }

    fun getUnsortedList() =
        listStrings

    fun getSortedList(): List<TextDateItems> =
        listMergeSortAlgo.getMergingBranchedLists(listStrings)

    fun isNotEmptyList() =
        listStrings.isNotEmpty()

    fun getReverseSortedList(): List<TextDateItems> =
        listMergeSortAlgo.getMergingBranchedLists(listStrings).reversed()

    fun clearLists() {
        listStrings.clear()
        val task = Runnable {
            stringDao.deleteAllStrings()
        }
        dbWorkerThread.postTask(task)
    }

    fun initModel() {
        dbWorkerThread.start()
        val task = Runnable {
            val list = stringDao.getAllStrings()
            for (i in 0..list.lastIndex) {
                listStrings.add(TextDateItems(list[i].name, list[i].date, list[i].id))
            }
        }
        dbWorkerThread.postTask(task)
    }

    fun release() {
        dbWorkerThread.quit()
    }
}