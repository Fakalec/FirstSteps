package out.muravev.pv.data

import out.muravev.pv.contracts.MainContract
import out.muravev.pv.databases.DbWorkerThread
import out.muravev.pv.databases.StringsEntity

class StringsModel(private val listMergeSortAlgo: ListMergeSortAlgo, sqlData: StringDataBase) {

    private var listStrings = arrayListOf<String>()
    private var resultScreenListener: MainContract.ScreenChangeListener? = null
    private var mainScreenListener: MainContract.ScreenChangeListener? = null
    private var savedString: String = ""
    private val dbWorkerThread = DbWorkerThread("DbThread")
    private val stringDao = sqlData.stringDao()

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
        listStrings.add(savedString)
        val stringsEntity = StringsEntity(savedString, listStrings.lastIndex)
        val task = Runnable {
            stringDao.insertString(stringsEntity)
        }
        dbWorkerThread.postTask(task)
    }

    fun deleteItemOnPosition(itemPosition: Int) {
        listStrings.removeAt(itemPosition)
        val task = Runnable {
            stringDao.deleteOnPosition(itemPosition)
        }
        dbWorkerThread.postTask(task)
    }

    fun clearEnteredText() {
        savedString = ""
    }

    fun getUnsortedList() =
        listStrings

    fun getSortedList() =
        listMergeSortAlgo.getMergingBranchedLists(listStrings)

    fun isNotEmptyList() =
        listStrings.isNotEmpty()

    fun getReverseSortedList() =
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
                listStrings.add(list[i].name)
            }
        }
        dbWorkerThread.postTask(task)
    }

    fun release() {
        dbWorkerThread.quit()
    }
}