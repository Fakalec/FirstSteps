package out.muravev.pv.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.result_fragment.*
import out.muravev.pv.R
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.models.ApplicationGlobal
import out.muravev.pv.presenters.ResultFragmentPresenterImpl
import out.muravev.pv.routers.FragmentRouterImpl

class ResultFragment : Fragment(), MainContract.ResultFragment {

    private lateinit var resultPresenter: MainContract.ResultFragmentPresenter
    private lateinit var router: MainContract.FragmentRouter
//    private lateinit var deviceChecker : MainContract.DeviceChecker


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.result_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        deviceChecker = DeviceCheckerImpl(activity?.application as ApplicationGlobal)
        router = FragmentRouterImpl((activity?.application as ApplicationGlobal).deviceChecker, this)
        resultPresenter = ResultFragmentPresenterImpl((activity?.application as ApplicationGlobal).listModel, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        resultPresenter.onScreenOpened()
        initListeners()
    }

    private fun initListeners() {
        back_button.setOnClickListener {
            resultPresenter.onBackButtonClicked()
        }
        sort_button.setOnClickListener {
            resultPresenter.onSortButtonClicked()
        }
        reverse_button.setOnClickListener {
            resultPresenter.onReverseButtonClicked()
        }
    }

    override fun backToMainFragment() {
        router.openMainScreen()
    }

    override fun viewResultText(resultText: String) {
        result_text_view.text = resultText
    }
}
