package out.muravev.pv.toasts

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import out.muravev.pv.contracts.MainContract

class ToastUtilsImpl : MainContract.ToastUtils {

    override fun errorToast(@StringRes messageResId: Int, context: Context?) {
        // todo
        Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show()
    }
}