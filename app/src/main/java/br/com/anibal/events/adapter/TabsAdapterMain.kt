package br.com.anibal.events.adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.fragment.EventFragment

class TabsAdapterMain(private val context: Context,
                      fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int = 3

    private fun getTabName(position: Int) = when(position) {
        0 -> MenuItemString.NowEvents
        1 -> MenuItemString.NextEvents
        else -> MenuItemString.Events
    }

    override fun getPageTitle(position: Int): CharSequence {
        val type = getTabName(position)
        return context.getString(type.string)
    }

    override fun getItem(position: Int): Fragment {
        val type = getTabName(position)
        val fragment = EventFragment()
        fragment.arguments = Bundle()
        fragment.arguments?.putSerializable("type", type)
        return fragment
    }
}