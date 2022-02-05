package di

import com.ashish.demo.inputurl.UrlInputViewModel
import com.ashish.demo.stationlist.ItemAdapter
import com.ashish.demo.stationlist.StationListViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { StationListViewModel(get()) }
    factory { UrlInputViewModel() }
}

val adapterModule = module {
    single { ItemAdapter() }
}