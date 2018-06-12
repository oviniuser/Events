package br.com.anibal.events.web

import br.com.anibal.events.domain.Event
import br.com.anibal.events.domain.MenuItemString
import br.com.anibal.events.domain.Speaker
import br.com.anibal.events.domain.Talk

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

    fun getTalks(success: (talks: List<Talk>) -> Unit,
                 failure: (throwable: Throwable) -> Unit,
                 eventId: Int) {
        val call = RetrofitInitializer().eventService().getTalks(eventId)
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

    fun getSpeakers(success: (speakers: List<Speaker>) -> Unit,
                    failure: (thorowable: Throwable) -> Unit,
                    talkId: Int) {
        val call = RetrofitInitializer().eventService().getSpeakers(talkId)
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