package out.muravev.pv.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

class ToastUtils {

    fun errorToast(@StringRes messageResId: Int, context: Context?) {
        Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show()
    }
}