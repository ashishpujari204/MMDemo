package di

import com.ashish.demo.inputurl.UrlInputViewModel
import com.ashish.demo.rest.RepositoryImplementation
import com.ashish.demo.stationlist.ItemAdapter
import com.ashish.demo.stationlist.StationListViewModel
import org.koin.dsl.module

val AdapterModule = module {
    single { ItemAdapter() }
}

val repoImplementation = module {
    factory { RepositoryImplementation(get()) }
}