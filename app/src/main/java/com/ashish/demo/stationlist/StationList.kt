package com.ashish.demo.stationlist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ashish.demo.R
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class StationList : AppCompatActivity() {
    private val stationListViewModel by viewModel<StationListViewModel>()
    private val itemAdapter: ItemAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_station_list)
        getFeed()
    }

    private fun getFeed() {
        stationListViewModel.getFeed().observe(this) { feed ->
            feed?.let {
                Log.e("Feed", "Station list RSS : $it")
            }
        }
    }
}