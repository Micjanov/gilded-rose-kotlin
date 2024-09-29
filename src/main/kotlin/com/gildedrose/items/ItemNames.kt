package com.gildedrose.items

enum class ItemNames(val itemName: String) {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    MANA_CAKE("Conjured Mana Cake"),
    DEFAULT_ITEM("");

    companion object {
        fun fromString(itemName: String): ItemNames {
            return entries.find { it.itemName == itemName } ?: DEFAULT_ITEM
        }
    }
}