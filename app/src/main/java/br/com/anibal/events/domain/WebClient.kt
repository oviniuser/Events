package br.com.anibal.events.domain

class WebClient {

    fun list(success: (events: List<Event>) -> Unit,
             failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().eventService().getEvents()

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