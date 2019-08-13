package out.muravev.pv.routers

import androidx.fragment.app.Fragment
import out.muravev.pv.R
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.fragments.ResultFragment

class FragmentRouterImpl(private val fragment: Fragment) :
    MainContract.FragmentRouter {

    private val resultScreen = ResultFragment()

    override fun openResultScreen() {
        val startResultFragmentManager = fragment.activity?.supportFragmentManager
        startResultFragmentManager?.beginTransaction()
            ?.replace(R.id.main_container, resultScreen)
            ?.addToBackStack(null)
            ?.commit()
    }

    override fun openMainScreen() {
        val startMainFragmentManager = fragment.activity?.supportFragmentManager
        startMainFragmentManager?.popBackStack()
    }
}