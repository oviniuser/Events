package br.com.anibal.events.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.anibal.events.domain.Arguments
import br.com.anibal.events.domain.Arguments.speaker
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.fragment.SpeakerDetailFragment
import br.com.anibal.events.fragment.TalkFragment

class TabsAdapterSpeaker(private val context: Context,
                         fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int = 2

    private fun getTabName(position: Int) = when(position) {
        0 -> MenuItemString.About
        else -> MenuItemString.Talks
    }

    override fun getPageTitle(position: Int): CharSequence {
        val type = getTabName(position)
        return context.getString(type.string)
    }

    override fun getItem(position: Int): Fragment {
        val type = getTabName(position)

        return when (type) {
            MenuItemString.About -> {
                val fragment = SpeakerDetailFragment()
                fragment
            }
            else -> {
                val fragment = TalkFragment()
                Arguments.type = type
                Arguments.putInt(type.toString(), speaker.id)
                fragment
            }
        }
    }
}