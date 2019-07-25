package out.muravev.pv.toasts

import android.content.Context
import android.widget.Toast
import out.muravev.pv.contracts.SorterContract

class ToastUtilsImpl : SorterContract.ToastUtils {
    override fun errorToast(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}