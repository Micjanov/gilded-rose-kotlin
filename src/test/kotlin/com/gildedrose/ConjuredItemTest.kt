package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.ConjuredItem
import com.gildedrose.items.Item
import com.gildedrose.items.ItemNames.MANA_CAKE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ConjuredItemTest {
    @Test
    fun `quality decreases by 2 if sellIn is greater than 0`() {
        NumberProvider(1..20, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(MANA_CAKE.itemName, sellIn, quality)

                WHEN
                val updatedItem = ConjuredItem.fromItem(item).update()

                THEN
                assertEquals(MANA_CAKE.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals((quality - 2).coerceIn(0, 50), updatedItem.quality)
            }
    }

    @Test
    fun `quality decreases by 4 if sellIn is 0 or less`() {
        NumberProvider(-20..0, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(MANA_CAKE.itemName, sellIn, quality)

                WHEN
                val updatedItem = ConjuredItem.fromItem(item).update()

                THEN
                assertEquals(MANA_CAKE.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals((quality - 4).coerceIn(0, 50), updatedItem.quality)
            }
    }

    @Test
    fun `quality cannot be less than 0`() {
        NumberProvider(0..20, -20..-1)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(MANA_CAKE.itemName, sellIn, quality)

                WHEN
                val updatedItem = ConjuredItem.fromItem(item).update()

                THEN
                assertEquals(MANA_CAKE.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(0, updatedItem.quality)
            }
    }

    @Test
    fun `quality cannot be greater than 50`() {
        NumberProvider(0..20, 55..70)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(MANA_CAKE.itemName, sellIn, quality)

                WHEN
                val updatedItem = ConjuredItem.fromItem(item).update()

                THEN
                assertEquals(MANA_CAKE.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(50, updatedItem.quality)
            }
    }
}