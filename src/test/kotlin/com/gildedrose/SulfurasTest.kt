package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.Item
import com.gildedrose.items.ItemNames.SULFURAS
import com.gildedrose.items.Sulfuras
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SulfurasTest {
    @Test
    fun `quality should always be 80 and sellIn does not update`() {
        NumberProvider(-20..20, -20..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(SULFURAS.itemName, sellIn, quality)

                WHEN
                val updatedItem = Sulfuras.fromItem(item).update()

                THEN
                assertEquals(SULFURAS.itemName, updatedItem.name)
                assertEquals(sellIn, updatedItem.sellIn)
                assertEquals(80, updatedItem.quality)
            }
    }
}