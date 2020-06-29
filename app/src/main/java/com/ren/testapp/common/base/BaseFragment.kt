package com.ren.testapp.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.ren.testapp.common.ext.observeValue
import com.ren.testapp.common.utils.DialogUtils
import com.ren.testapp.di.AppInjector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    protected lateinit var viewModel: VM
    protected val disposables = CompositeDisposable()

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun provideViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("UNCHECKED_CAST")
        AppInjector.coreComponent.inject(this as BaseFragment<BaseViewModel>)

        viewModel = provideViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeErrorEvents()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            onBackClick()
        }

        return view
    }

    private fun subscribeErrorEvents() {
        viewModel.errorEvent.observeValue(this) {
            showError(it)
        }

        viewModel.noInternetErrorEvent.observeValue(this) {
            showNetworkError(it)
        }
    }

    protected open fun showError(message: String) {
        DialogUtils.showError(
            view,
            message
        )
    }

    protected open fun showNetworkError(message: String) {
        DialogUtils.showError(
            view,
            message
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

    open fun onBackClick() {
        viewModel.onBackClick()
    }

    protected fun Disposable.addDisposable() {
        disposables.add(this)
    }

    protected fun showDialog(dialog: DialogFragment, tag: String) {
        if (isDetached || childFragmentManager.findFragmentByTag(tag)?.isAdded == true) {
            return
        }

        dialog.show(childFragmentManager, tag)
    }
}