package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.Item
import com.gildedrose.items.ItemNames.SULFURAS
import com.gildedrose.items.Sulfuras
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

internal class SulfurasTest {
    @RepeatedTest(value = 20)
    fun `quality should always be 80 and sellIn does not update`() {
        GIVEN
        val sellIn = Random.nextInt()
        val quality = Random.nextInt()
        val item = Item(SULFURAS.itemName, sellIn, quality)

        WHEN
        val updatedItem = Sulfuras.fromItem(item).update()

        THEN
        assertEquals(SULFURAS.itemName, updatedItem.name)
        assertEquals(sellIn, updatedItem.sellIn)
        assertEquals(80, updatedItem.quality)
    }
}