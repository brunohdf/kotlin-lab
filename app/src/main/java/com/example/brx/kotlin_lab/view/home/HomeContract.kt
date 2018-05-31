package com.example.brx.kotlin_lab.view.home

interface HomeContract {

    interface View {
        var presenter: HomeContract.Presenter
        var isActive: Boolean
    }

    interface Presenter {
        fun start()
    }
}