package br.com.anibal.events.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.Arguments.event
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.fragment.EventDetailFragment
import br.com.anibal.events.fragment.EventLocalFragment
import br.com.anibal.events.fragment.TalkFragment

class TabsAdapterEvent(private val context: Context,
                      fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int = 3

    private fun getTabName(position: Int) = when(position) {
        0 -> MenuItemString.About
        1 -> MenuItemString.Schedule
        else -> MenuItemString.Local
    }

    override fun getPageTitle(position: Int): CharSequence {
        val type = getTabName(position)
        return context.getString(type.string)
    }

    override fun getItem(position: Int): Fragment {
        val type = getTabName(position)

        return when(type) {
            MenuItemString.About -> {
                val fragment = EventDetailFragment()
                fragment
            }
            MenuItemString.Schedule -> {
                val fragment = TalkFragment()
                Arguments.type = type
                Arguments.putInt(type.toString(), event.id)
                fragment
            }
            else -> {
                val fragment = EventLocalFragment()
                fragment
            }
        }
    }
}