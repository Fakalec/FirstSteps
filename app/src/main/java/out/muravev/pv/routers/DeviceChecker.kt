package out.muravev.pv.routers

import android.content.Context
import android.content.res.Configuration

class DeviceChecker(private val context: Context) {

    fun isDeviceTablet() =
        context.resources.configuration.screenLayout and
                Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_LARGE
}