package com.example.brx.kotlin_lab.view.home.component

import android.content.Context
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.MenuItem
import com.example.brx.kotlin_lab.R
import com.example.brx.kotlin_lab.extension.disableShiftMode
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.ionicons_typeface_library.Ionicons


class CustomBottomNavigationView
@JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr:
        Int = 0) : BottomNavigationView(context, attrs, defStyleAttr) {

    private var items = arrayListOf<Item>()

    init {
        setup()
        disableShiftMode()
        setOnNavigationItemSelectedListener(InternalSelectedListener(null))
        setOnNavigationItemReselectedListener(InternalReselectedListener(null))
    }

    override fun setOnNavigationItemSelectedListener(listener: OnNavigationItemSelectedListener?) {
        super.setOnNavigationItemSelectedListener(InternalSelectedListener(listener))
    }

    override fun setOnNavigationItemReselectedListener(listener: OnNavigationItemReselectedListener?) {
        super.setOnNavigationItemReselectedListener(InternalReselectedListener(listener))
    }

    private inner class InternalSelectedListener(val listener: BottomNavigationView
    .OnNavigationItemSelectedListener?) : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            setupIcons(item)
            return listener?.onNavigationItemSelected(item) ?: true
        }
    }

    private inner class InternalReselectedListener(val listener: BottomNavigationView
    .OnNavigationItemReselectedListener?) : BottomNavigationView.OnNavigationItemReselectedListener {
        override fun onNavigationItemReselected(item: MenuItem) {
            setupIcons(item)
        }
    }

    private fun setupIcons(item: MenuItem) {
        val colorAccent = ContextCompat.getColor(context, R.color.colorAccent)
        val colorPrimary = ContextCompat.getColor(context, R.color.colorPrimary)

        for (i in 0 until menu.size()) {

            val iconBuilder = IconicsDrawable(context).sizeDp(24).icon(items.get(i).icon)

            if (menu.getItem(i).itemId == item.itemId)
                menu.getItem(i).icon = iconBuilder.color(colorAccent)
            else
                menu.getItem(i).icon = iconBuilder.color(colorPrimary)
        }
    }

    fun setup() {
        items.add(Item(Ionicons.Icon.ion_arrow_graph_up_right))
        items.add(Item(Ionicons.Icon.ion_android_calendar))
        items.add(Item(Ionicons.Icon.ion_play))
        items.add(Item(Ionicons.Icon.ion_android_favorite))
    }
}

private data class Item(
        val icon: Ionicons.Icon
)