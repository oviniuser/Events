package br.com.anibal.events.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anibal.events.R
import br.com.anibal.events.R.id.*
import br.com.anibal.events.domain.Arguments
import kotlinx.android.synthetic.main.desc_content.*
import kotlinx.android.synthetic.main.fragment_event_detail.*

class EventDetailFragment : BaseFragment() {

    private val event = Arguments.event

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event_detail, container, false)
    }

    override fun onResume() {
        super.onResume()
        textViewEventName.text = event.name
        textViewStartDate.text = event.startDate
        textViewFinishDate.text = event.finishDate
        textViewDesc.text = event.desc
    }
}
