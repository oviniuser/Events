package br.com.anibal.events.activity

import android.os.Bundle
import br.com.anibal.events.R
import br.com.anibal.events.domain.Event
import br.com.anibal.events.domain.Setting
import br.com.anibal.events.extension.loadUrl
import br.com.anibal.events.extension.setupToolBar
import kotlinx.android.synthetic.main.activity_event_content.*
import kotlinx.android.synthetic.main.activity_event_detail.*

class EventDetailActivity : BaseActivity() {

    private val event by lazy { intent.getSerializableExtra("event") as Event }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        setupToolBar(R.id.toolbar, event.name, true)
        initViews()
    }

    private fun initViews() {
        textViewEventName.text = event.name
        textViewDescription.text = event.desc
        textViewEventDate.text = "De " + event.startDate + " a " + event.finishDate
        textViewEventLocal.text = event.latitude + " / " + event.longitude
        textViewSchedule.text = event.talks.toString()
        val urlImage = Setting.server + event.image
        //vieirateam.pythonanywhere.com
        appBarImage.loadUrl(urlImage)
    }
}
