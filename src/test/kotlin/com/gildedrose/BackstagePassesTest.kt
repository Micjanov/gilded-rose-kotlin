package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.BackstagePasses
import com.gildedrose.items.Item
import com.gildedrose.items.ItemNames.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

internal class BackstagePassesTest {
    @RepeatedTest(value = 20)
    fun `quality increases by 1 if sellIn is greater than 10`() {
        GIVEN
        val sellIn = Random.nextInt(11, 50)
        val quality = Random.nextInt(0, 50)
        val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

        WHEN
        val updatedItem = BackstagePasses.fromItem(item).update()

        THEN
        assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality + 1, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality increases by 2 if sellIn is greater than 5 and less than 11`() {
        GIVEN
        val sellIn = Random.nextInt(6, 11)
        val quality = Random.nextInt(0, 49)
        val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

        WHEN
        val updatedItem = BackstagePasses.fromItem(item).update()

        THEN
        assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality + 2, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality increases by 3 when sellIn is greater than 0 and less than 6`() {
        GIVEN
        val sellIn = Random.nextInt(1, 6)
        val quality = Random.nextInt(0, 48)
        val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

        WHEN
        val updatedItem = BackstagePasses.fromItem(item).update()

        THEN
        assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality + 3, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality cannot be less than 0`() {
        GIVEN
        val sellIn = Random.nextInt(0, 50)
        val quality = -Random.nextInt(1, 50)
        val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

        WHEN
        val updatedItem = BackstagePasses.fromItem(item).update()

        THEN
        assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(0, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality cannot be greater than 50`() {
        GIVEN
        val sellIn = Random.nextInt(1, 50)
        val quality = Random.nextInt(51, 100)
        val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

        WHEN
        val updatedItem = BackstagePasses.fromItem(item).update()

        THEN
        assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(50, updatedItem.quality)
    }
}