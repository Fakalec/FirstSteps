package out.muravev.pv.utils

import android.content.Context
import android.content.res.Configuration

class DeviceCheckerUtil(private val context: Context) {

    fun isDeviceTablet() =
        context.resources.configuration.screenLayout and
                Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_LARGE
}