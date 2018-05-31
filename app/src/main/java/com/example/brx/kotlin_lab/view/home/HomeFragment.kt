package com.example.brx.kotlin_lab.view.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.brx.kotlin_lab.R

class HomeFragment : Fragment(), HomeContract.View {

    override lateinit var presenter: HomeContract.Presenter

    override var isActive: Boolean = false
        get() = isAdded

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.home_fragment, container, false)

        with(root) {
            // bind elements
        }

        return root
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}