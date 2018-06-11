package br.com.anibal.events.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anibal.events.R
import br.com.anibal.events.domain.Talk
import kotlinx.android.synthetic.main.adapter_talk.view.*

class TalkAdapter(private val talks: List<Talk>,
                  val onClick: (Talk) -> Unit): RecyclerView.Adapter<TalkAdapter.TalkViewHolder>() {

    class TalkViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int = this.talks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TalkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_talk, parent, false)
        return TalkViewHolder(view)
    }

    override fun onBindViewHolder(holder: TalkViewHolder, position: Int) {
        val talk = this.talks[position]
        val view = holder.itemView

        with(view) {
            textViewTalkName.text = talk.name
            textViewDate.text = talk.date
            textViewStartTime.text = talk.startTime
            textViewFinishTime.text = talk.finishTime
            setOnClickListener { onClick(talk) }
        }
    }
}