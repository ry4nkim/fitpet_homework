package dev.ry4nkim.fitpet_homework.presentation.view.fragment.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dev.ry4nkim.fitpet_homework.BR
import dev.ry4nkim.fitpet_homework.presentation.view.activity.base.BaseActivity
import dev.ry4nkim.fitpet_homework.presentation.viewmodel.base.BaseViewModel

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes private val layoutId: Int
) : Fragment(layoutId) {
    lateinit var baseActivity: BaseActivity<*, *>
    lateinit var rootView: View

    lateinit var viewDataBinding: VB
    abstract val viewModel: VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            baseActivity = context
            baseActivity.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        rootView = viewDataBinding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewDataBinding.setVariable(BR.viewModel, viewModel)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.executePendingBindings()
        super.onViewCreated(view, savedInstanceState)
    }

    interface Callback {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    fun showMessage(message: String?) {
        baseActivity.showMessage(message)
    }
}