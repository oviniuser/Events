package br.com.anibal.events.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.fragment.SpeakerFragment
import br.com.anibal.events.fragment.TalkDetailFragment

class TabsAdapterTalk(private val context: Context,
                      fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int = 2

    private fun getTabName(position: Int) = when(position) {
        0 -> MenuItemString.About
        else -> MenuItemString.Speakers
    }

    override fun getPageTitle(position: Int): CharSequence {
        val type = getTabName(position)
        return context.getString(type.string)
    }

    override fun getItem(position: Int): Fragment {
        val type = getTabName(position)

        return when(type) {
            MenuItemString.About -> {
                val fragment = TalkDetailFragment()
                fragment
            }
            else -> {
                val fragment = SpeakerFragment()
                fragment
            }
        }
    }
}