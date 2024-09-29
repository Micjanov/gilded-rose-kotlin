package com.gildedrose

import com.gildedrose.items.*
import com.gildedrose.items.ItemNames.*

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items = items.map { item ->
            when (ItemNames.fromString(item.name)) {
                DEFAULT_ITEM -> DefaultItem.fromItem(item).update()
                AGED_BRIE -> Brie.fromItem(item).update()
                SULFURAS -> Sulfuras.fromItem(item).update()
                BACKSTAGE_PASSES -> BackstagePasses.fromItem(item).update()
                MANA_CAKE -> ConjuredItem.fromItem(item).update()
            }
        }
    }

}

