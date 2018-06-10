package br.com.anibal.events.web

import br.com.anibal.events.domain.Event
import br.com.anibal.events.domain.MenuItemString

class WebClient {

    fun getEvents(success: (events: List<Event>) -> Unit,
                  failure: (throwable: Throwable) -> Unit,
                  type: MenuItemString) {
        val call = when(type) {
            MenuItemString.NowEvents -> RetrofitInitializer().eventService().getNowEvents()
            MenuItemString.NextEvents -> RetrofitInitializer().eventService().getNextEvents()
            else -> RetrofitInitializer().eventService().getEvents()
        }

        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }
}