package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.ConjuredItem
import com.gildedrose.items.Item
import com.gildedrose.items.ItemNames.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

internal class ConjuredItemTest {
    @RepeatedTest(value = 20)
    fun `quality decreases by 2 before sellByDate`() {
        GIVEN
        val sellIn = Random.nextInt(2, 51)
        val quality = Random.nextInt(2, 51)
        val item = Item(MANA_CAKE.itemName, sellIn, quality)

        WHEN
        val updatedItem = ConjuredItem.fromItem(item).update()

        THEN
        assertEquals(MANA_CAKE.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality - 2, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality decreases by 4 when sellByDate has been passed`() {
        GIVEN
        val sellIn = -Random.nextInt(4, 51)
        val quality = Random.nextInt(4, 51)
        val item = Item(MANA_CAKE.itemName, sellIn, quality)

        WHEN
        val updatedItem = ConjuredItem.fromItem(item).update()

        THEN
        assertEquals(MANA_CAKE.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality - 4, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality cannot be less than 0`() {
        GIVEN
        val sellIn = Random.nextInt(0, 50)
        val quality = -Random.nextInt(1, 51)
        val item = Item(MANA_CAKE.itemName, sellIn, quality)

        WHEN
        val updatedItem = ConjuredItem.fromItem(item).update()

        THEN
        assertEquals(MANA_CAKE.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(0, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality cannot be greater than 50`() {
        GIVEN
        val sellIn = Random.nextInt(0, 50)
        val quality = Random.nextInt(52, 100)
        val item = Item(MANA_CAKE.itemName, sellIn, quality)

        WHEN
        val updatedItem = ConjuredItem.fromItem(item).update()

        THEN
        assertEquals(MANA_CAKE.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(50, updatedItem.quality)
    }
}