package out.muravev.pv.model

import out.muravev.pv.SorterContract

class SorterModelImpl : SorterContract.SorterModel {

    override val savedText: ArrayList<String> = arrayListOf()

    override fun saveEditText(inputEditText: String): ArrayList<String> {
        savedText.add(inputEditText)
        return savedText
    }

    override fun cleanSavedText(): ArrayList<String> {
        savedText.clear()
        return savedText
    }
}