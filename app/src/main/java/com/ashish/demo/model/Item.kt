package com.ashish.demo.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Item", strict = false)
data class Item @JvmOverloads constructor(
    @field:Element(name = "ItemType", required = true)
    var itemType: String,
    @field:Element(name = "UrlPrevious", required = true)
    var urlPrevious: String ="",
    @field:Element(name = "UrlPreviousBackUp", required = true)
    var UrlPreviousBackUp: String="",
    @field:Element(name = "StationName", required = true)
    var stationName: String,
    @field:Element(name = "Logo", required = true)
    var logo: String
)