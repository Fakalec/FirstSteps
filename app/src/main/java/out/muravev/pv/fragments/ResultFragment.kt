package out.muravev.pv.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.result_fragment.*
import out.muravev.pv.R
import out.muravev.pv.contracts.MainContract
import out.muravev.pv.data.ApplicationGlobal
import out.muravev.pv.presenters.ResultFragmentPresenterImpl
import out.muravev.pv.routers.FragmentRouterImpl

class ResultFragment : Fragment(), MainContract.ResultFragment {

    private lateinit var resultPresenter: MainContract.ResultFragmentPresenter
    private lateinit var router: MainContract.FragmentRouter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.result_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        router = FragmentRouterImpl(this)
        resultPresenter = ResultFragmentPresenterImpl(
            (activity?.application as ApplicationGlobal).stringsModel,
            this,
            (activity?.application as ApplicationGlobal).deviceChecker
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        resultPresenter.onResultScreenOpened()
        initListeners()
    }

    override fun onResultScreenDraw(stringsList: List<String>) {
        custom_view.setText(stringsList)
    }

    override fun onDetach() {
        super.onDetach()
        resultPresenter.cleanResultPresenterListener()
    }

    private fun initListeners() {

        sort_button.setOnClickListener {
            resultPresenter.onSortButtonClicked()
        }
        reverse_button.setOnClickListener {
            resultPresenter.onReverseButtonClicked()
        }
        original_button.setOnClickListener {
            resultPresenter.onOriginalButtonClicked()
        }
    }

    override fun backToMainFragment() {
        router.openMainScreen()
    }
}
