package out.muravev.pv.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import out.muravev.pv.R
import out.muravev.pv.fragments.MainFragment
import out.muravev.pv.fragments.ResultFragment
import out.muravev.pv.routers.DeviceCheckerImpl


class MainActivity : AppCompatActivity() {

    private val checkDevice = DeviceCheckerImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkDevice.isDeviceTablet()) initializeMainScreenOnTablet() else initializeMainScreenOnPhone()
    }

    private fun initializeMainScreenOnPhone() {
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, MainFragment())
            .commit()
    }

    private fun initializeMainScreenOnTablet() {
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, MainFragment())
            .add(R.id.result_container, ResultFragment())
            .commit()
    }
}