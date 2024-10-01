package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.BackstagePasses
import com.gildedrose.items.Item
import com.gildedrose.items.ItemNames.BACKSTAGE_PASSES
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BackstagePassesTest {
    @Test
    fun `quality increases by 1 if sellIn is greater than 10`() {
        NumberProvider(11..20, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

                WHEN
                val updatedItem = BackstagePasses.fromItem(item).update()

                THEN
                assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals((quality + 1).coerceIn(0, 50), updatedItem.quality)
            }
    }

    @Test
    fun `quality increases by 2 if sellIn is greater than 5 and less than 11`() {
        NumberProvider(6..10, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

                WHEN
                val updatedItem = BackstagePasses.fromItem(item).update()

                THEN
                assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals((quality + 2).coerceIn(0, 50), updatedItem.quality)
            }
    }

    @Test
    fun `quality becomes 0 when sellIn is smaller than or equal to 0`() {
        NumberProvider(-4..0, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

                WHEN
                val updatedItem = BackstagePasses.fromItem(item).update()

                THEN
                assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(0, updatedItem.quality)
            }
    }

    @Test
    fun `quality cannot be less than 0`() {
        NumberProvider(1..20, -15..-1)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

                WHEN
                val updatedItem = BackstagePasses.fromItem(item).update()

                THEN
                assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(0, updatedItem.quality)
            }
    }

    @Test
    fun `quality cannot be greater than 50`() {
        NumberProvider(1..20, 51..70)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

                WHEN
                val updatedItem = BackstagePasses.fromItem(item).update()

                THEN
                assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(50, updatedItem.quality)
            }
    }
}
