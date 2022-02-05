package com.ashish.demo.inputurl

import android.content.Intent
import android.os.Bundle
import com.ashish.demo.databinding.ActivityMainBinding
import com.ashish.demo.stationlist.StationList
import org.koin.androidx.viewmodel.ext.android.viewModel
import utility.BaseActivity

class UrlInputActivity : BaseActivity<ActivityMainBinding>() {

    private val urlInputViewModel by viewModel<UrlInputViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        binding.apply {
            urlInputViewModel.getUrl().observe(this@UrlInputActivity) { url ->
                if (url.isNotEmpty()) {
                    urlInputText.setText(url)
                }
            }
            val enteredUrl = urlInputText.text.toString()
            submitButton.setOnClickListener {
                /*if (enteredUrl.isUrlValid()) {
                    showToast(getString(R.string.url_error_message))
                } else {
                    urlInputViewModel.setUrl(enteredUrl)
                }*/
                startActivity(Intent(this@UrlInputActivity, StationList::class.java))
            }
        }
    }

    override fun onObserve() {
        //No implement
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}