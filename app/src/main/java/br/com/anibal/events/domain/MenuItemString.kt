package br.com.anibal.events.domain

import br.com.anibal.events.R

enum class MenuItemString(val string: Int) {
    all_events(R.string.nav_all_events),
    subscribed_events(R.string.nav_subscribed_events),
    app_settings(R.string.nav_app_settings),
    app_login(R.string.nav_app_login)
}
