package out.muravev.pv.routers

import android.content.Context
import android.content.res.Configuration
import out.muravev.pv.contracts.MainContract

class DeviceCheckerImpl(private val context: Context) : MainContract.DeviceChecker {

    override fun isDeviceTablet() =
        context.resources.configuration.screenLayout and
                Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_LARGE
}