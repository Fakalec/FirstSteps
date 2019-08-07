package out.muravev.pv.routers

import androidx.fragment.app.Fragment
import out.muravev.pv.R
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.fragments.MainFragment
import out.muravev.pv.fragments.ResultFragment

class FragmentRouterImpl(private val isDeviceTab: DeviceCheckerImpl, private val fragment: Fragment) :
    MainContract.FragmentRouter {

    private val mainScreen = MainFragment()
    private val resultScreen = ResultFragment()

    override fun openResultScreen() {
        val startResultFragmentManager = fragment.activity?.supportFragmentManager
        if (isDeviceTab.isDeviceTablet()) {
            startResultFragmentManager?.beginTransaction()
                ?.replace(R.id.result_container, resultScreen)
                ?.replace(R.id.main_container, mainScreen)
                ?.commit()
        } else
            startResultFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container, resultScreen)
                ?.addToBackStack(null)
                ?.commit()
    }

    override fun openMainScreen() {
        val startMainFragmentManager = fragment.activity?.supportFragmentManager
        if (isDeviceTab.isDeviceTablet()) {
            startMainFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container, mainScreen)
                ?.replace(R.id.result_container, resultScreen)
                ?.commit()
        } else {
//            startMainFragmentManager?.popBackStack()
            startMainFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container, mainScreen)
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}