package com.ashish.demo.stationlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ashish.demo.rest.RepositoryImplementation
import com.ashish.demo.rest.Resource
import kotlinx.coroutines.Dispatchers

class StationListViewModel(private val repositoryImplementation: RepositoryImplementation) :
    ViewModel() {

    companion object {
        private const val URL =
            "http://phorus.vtuner.com/setupapp/phorus/asp/browsexml/navXML.asp?gofile=LocationLevelFourCityUS-North%20America-New%20York-ExtraDir-1-Inner-14&bkLvl=9237&mac=a8f58cd9758b710c43a7a63762e755947f83f0ad9194aa294bbaee55e0509e02&dlang=eng&fver=1.4.4.2299%20(20150604)&hw=CAP:%201.4.0.075%20MCU:%201.032%20BT:%200.002"
    }

    fun getFeed(url: String = URL) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repositoryImplementation.getFeeds(url)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}