package com.ashish.demo.stationlist

import com.ashish.demo.model.Item

class ItemPresenter(
    private val itemList: ArrayList<Item>? = null
) {

    fun getStationList(): List<ItemPresentation>? {
        return itemList?.map { it.toItemPresentation() }
    }
}

fun Item.toItemPresentation(): ItemPresentation =
    ItemPresentation(
        itemType = itemType,
        stationName = stationName,
        Logo = logo
    )

data class ItemPresentation(
    val itemType: String,
    val stationName: String,
    val Logo: String
)