package out.muravev.pv.toasts

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import out.muravev.pv.contracts.SorterContract

class ToastUtilsImpl : SorterContract.ToastUtils {

    override fun errorToast(@StringRes messageResId: Int, context: Context) {
        Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show()
    }
}