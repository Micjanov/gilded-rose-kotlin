package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.Brie
import com.gildedrose.items.Item
import com.gildedrose.items.ItemNames.AGED_BRIE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class BrieTest {
    @Test
    fun `quality increases by 1 if sellIn is greater than 0`() {
        NumberProvider(1..20, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(AGED_BRIE.itemName, sellIn, quality)

                WHEN
                val updatedItem = Brie.fromItem(item).update()

                THEN
                assertEquals(AGED_BRIE.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals((quality + 1).coerceIn(0, 50), updatedItem.quality)
            }
    }

    @Test
    fun `quality increases by 2 if sellIn is 0 or less`() {
        NumberProvider(-10..0, 0..50)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(AGED_BRIE.itemName, sellIn, quality)

                WHEN
                val updatedItem = Brie.fromItem(item).update()

                THEN
                assertEquals(AGED_BRIE.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals((quality + 2).coerceIn(0, 50), updatedItem.quality)
            }
    }

    @Test
    fun `quality cannot be less than 0`() {
        NumberProvider(0..20, -10..-1)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val item = Item(AGED_BRIE.itemName, sellIn, quality)

                WHEN
                val updatedItem = Brie.fromItem(item).update()

                THEN
                assertEquals(AGED_BRIE.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(0, updatedItem.quality)
            }
    }

    @Test
    fun `quality cannot be greater than 50`() {
        NumberProvider(0..20, 51..70)
            .forEachCombination { sellIn, quality ->
                GIVEN
                val sellIn = Random.nextInt(0, 50)
                val quality = Random.nextInt(51, 100)
                val item = Item(AGED_BRIE.itemName, sellIn, quality)

                WHEN
                val updatedItem = Brie.fromItem(item).update()

                THEN
                assertEquals(AGED_BRIE.itemName, updatedItem.name)
                assertEquals(sellIn - 1, updatedItem.sellIn)
                assertEquals(50, updatedItem.quality)
            }
    }
}