package com.ashish.demo.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(strict = false, name = "ListOfItems")
data class Feed @JvmOverloads constructor(
    @field:Element(name = "ItemCount")
    var listItemCount: Int,

    @field:ElementList(
        required = false,
        name = "Item",
        entry = "Item",
        inline = true,
        empty = true
    )
    var itemList: List<Item>
)