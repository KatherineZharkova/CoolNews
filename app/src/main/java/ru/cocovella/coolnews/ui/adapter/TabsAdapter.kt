package ru.cocovella.coolnews.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

class TabsAdapter(manager: FragmentManager?) : FragmentPagerAdapter(manager!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = ArrayList<Fragment>()
    private val tabTitles = ArrayList<String>()

    fun addFragment(fragment: Fragment, tabTitle: String) {
        fragments.add(fragment)
        tabTitles.add(tabTitle)
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence = tabTitles[position]
}