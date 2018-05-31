package com.example.brx.kotlin_lab.extension

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Add fragment to the container using the FragmentManager
 */
fun AppCompatActivity.replaceFragment(fragment: Fragment, @IdRes containerId: Int) {
    supportFragmentManager.beginTransaction().apply {
        replace(containerId, fragment)
    }.commit()
}

