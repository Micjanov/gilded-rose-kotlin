package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.DefaultItem
import com.gildedrose.items.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DefaultItemTest {
    @Test
    fun `quality decreases by 1 if sellIn is greater than 0`() {
        NumberProvider(1..20, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item("foo", sellIn, quality)

                WHEN
                val updatedItem = DefaultItem.fromItem(item).update()

                THEN
                assertEquals("foo", updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals((quality - 1).coerceIn(0, 50), updatedItem.quality)
            }
    }

    @Test
    fun `quality decreases by 2 if sellIn is less than or equal to 0`() {
        NumberProvider(-15..0, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item("foo", sellIn, quality)

                WHEN
                val updatedItem = DefaultItem.fromItem(item).update()

                THEN
                assertEquals("foo", updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals((quality - 2).coerceIn(0, 50), updatedItem.quality)
            }
    }

    @Test
    fun `quality cannot be less than 0`() {
        NumberProvider(0..20, -50..-1)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item("foo", sellIn, quality)

                WHEN
                val updatedItem = DefaultItem.fromItem(item).update()

                THEN
                assertEquals("foo", updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(0, updatedItem.quality)
            }
    }

    @Test
    fun `quality cannot be greater than 50`() {
        NumberProvider(0..20, 53..70)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item("foo", sellIn, quality)

                WHEN
                val updatedItem = DefaultItem.fromItem(item).update()

                THEN
                assertEquals("foo", updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(50, updatedItem.quality)
            }
    }
}