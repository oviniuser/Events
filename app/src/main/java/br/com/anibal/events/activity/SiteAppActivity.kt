package br.com.anibal.events.activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import br.com.anibal.events.R
import br.com.anibal.events.extension.setupToolBar
import kotlinx.android.synthetic.main.activity_site_app.*

class SiteAppActivity : BaseActivity() {

    private val URL_ABOUT = "http://www.ifsc.edu.br"

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_app)

        val title = "Sobre"
        setupToolBar(R.id.toolbar, title, true)

        setWebViewClient(webview)
        webview.loadUrl(URL_ABOUT)

        swipeToRefresh.setOnRefreshListener { webview.reload() }
        swipeToRefresh.setColorSchemeColors(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3
        )
    }

    fun setWebViewClient(webview: WebView) {
        webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progress.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {
                progress.visibility = View.INVISIBLE
                swipeToRefresh.isRefreshing = false
            }
        }
    }
}
