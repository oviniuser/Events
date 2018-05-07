package br.com.anibal.events.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anibal.events.R
import br.com.anibal.events.domain.Event
import br.com.anibal.events.extension.loadUrl
import kotlinx.android.synthetic.main.adapter_event.view.*

/**
 * Created by user on 21/03/18.
 */

class EventAdapter(val events: List<Event>,
                   val onClick: (Event) -> Unit) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun getItemCount() = this.events.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        val view = holder.itemView

        with(view) {
            textViewEventName.text = event.name
            val urlImage = "http://192.168.1.6:8000" + event.image
//            vieirateam.pythonanywhere.com
            imageViewEvent.loadUrl(urlImage, view.progressBar)
            setOnClickListener { onClick(event) }
        }
    }
}