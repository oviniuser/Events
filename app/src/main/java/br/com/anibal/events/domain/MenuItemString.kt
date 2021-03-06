package br.com.anibal.events.domain

import br.com.anibal.events.R

/**
 * @author user
 */
enum class MenuItemString(val string: Int) {
    Events(R.string.txt_all),
    NowEvents(R.string.txt_open),
    NextEvents(R.string.txt_next),
    Favorites(R.string.txt_favorites),
    Settings(R.string.txt_settings),
    About(R.string.txt_about),
    Schedule(R.string.txt_schedule),
    Local(R.string.txt_local),
    Speakers(R.string.txt_speakers),
    Talks(R.string.txt_talks)
}
