package com.example.brx.kotlin_lab

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.brx.kotlin_lab.extension.replaceFragment
import com.example.brx.kotlin_lab.model.repositoty.HomeRepository
import com.example.brx.kotlin_lab.presenter.HomePresenter
import com.example.brx.kotlin_lab.view.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find a fragment inflated instance or create it if null
        val fragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as HomeFragment?
                ?: HomeFragment.newInstance().also { replaceFragment(it, R.id.contentFrame) }

        presenter = HomePresenter(HomeRepository(), fragment)
    }
}