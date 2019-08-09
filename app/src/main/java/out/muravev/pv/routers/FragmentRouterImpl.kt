package out.muravev.pv.routers

import androidx.fragment.app.Fragment
import out.muravev.pv.R
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.fragments.MainFragment
import out.muravev.pv.fragments.ResultFragment

class FragmentRouterImpl(private val isDeviceTab: DeviceChecker, private val fragment: Fragment) :
    MainContract.FragmentRouter {

    private val mainScreen = MainFragment()
    private val resultScreen = ResultFragment()

    override fun openResultScreen() {
        val startResultFragmentManager = fragment.activity?.supportFragmentManager
        if (!isDeviceTab.isDeviceTablet()) {
            startResultFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container, resultScreen)
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    override fun openMainScreen() {
        val startMainFragmentManager = fragment.activity?.supportFragmentManager
        if (!isDeviceTab.isDeviceTablet()) {
            startMainFragmentManager?.popBackStackImmediate(R.id.result_container, 1)
            // todo

            startMainFragmentManager?.beginTransaction()   // как вернуть прошую дату?
                ?.replace(R.id.main_container, mainScreen)
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}