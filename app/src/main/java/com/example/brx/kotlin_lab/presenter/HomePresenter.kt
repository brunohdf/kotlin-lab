package com.example.brx.kotlin_lab.presenter

import com.example.brx.kotlin_lab.model.repositoty.HomeRepository
import com.example.brx.kotlin_lab.view.home.HomeContract

class HomePresenter(val repository: HomeRepository, val view: HomeContract.View)
    : HomeContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {

    }
}