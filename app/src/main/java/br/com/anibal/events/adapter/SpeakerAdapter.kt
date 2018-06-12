package br.com.anibal.events.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anibal.events.R
import br.com.anibal.events.domain.Setting
import br.com.anibal.events.domain.Speaker
import br.com.anibal.events.extension.loadUrl
import kotlinx.android.synthetic.main.adapter_speaker.view.*

class SpeakerAdapter(private val speakers: List<Speaker>,
                     val onClick: (Speaker) -> Unit): RecyclerView.Adapter<SpeakerAdapter.SpeakerViewHolder>() {
    class SpeakerViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int = this.speakers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_speaker, parent, false)
        return SpeakerViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        val speaker = this.speakers[position]
        val view = holder.itemView

        with(view) {
            textViewSpeakerName.text = speaker.name
            textViewFormation.text = speaker.formation
            val urlImage = Setting.server + speaker.image
            imageViewSpeaker.loadUrl(urlImage)
            setOnClickListener { onClick(speaker) }
        }
    }
}