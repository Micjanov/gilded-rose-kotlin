package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.Brie
import com.gildedrose.items.Item
import com.gildedrose.items.ItemNames.AGED_BRIE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

internal class BrieTest {
    @RepeatedTest(value = 20)
    fun `quality increases by 1 before sellByDate`() {
        GIVEN
        val sellIn = Random.nextInt(1,50)
        val quality = Random.nextInt(0,50)
        val item = Item(AGED_BRIE.itemName, sellIn, quality)

        WHEN
        val updatedItem = Brie.fromItem(item).update()

        THEN
        assertEquals(AGED_BRIE.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality + 1, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality increases by 2 when sellByDate has been passed`() {
        GIVEN
        val sellIn = -Random.nextInt(0,50)
        val quality = Random.nextInt(0,49)
        val item = Item(AGED_BRIE.itemName, sellIn, quality)

        WHEN
        val updatedItem = Brie.fromItem(item).update()

        THEN
        assertEquals(AGED_BRIE.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality + 2, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality cannot be less than 0`() {
        GIVEN
        val sellIn = Random.nextInt(0,50)
        val quality = -Random.nextInt(1,50)
        val item = Item(AGED_BRIE.itemName, sellIn, quality)

        WHEN
        val updatedItem = Brie.fromItem(item).update()

        THEN
        assertEquals(AGED_BRIE.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(0, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality cannot be greater than 50`() {
        GIVEN
        val sellIn = Random.nextInt(0,50)
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