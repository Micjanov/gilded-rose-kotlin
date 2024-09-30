package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.DefaultItem
import com.gildedrose.items.Item
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

internal class DefaultItemTest {
    @RepeatedTest(value = 20)
    fun `quality decreases by 1 if sellIn is greater than 0`() {
        GIVEN
        val sellIn = Random.nextInt(1, 51)
        val quality = Random.nextInt(1, 51)
        val item = Item("foo", sellIn, quality)

        WHEN
        val updatedItem = DefaultItem.fromItem(item).update()

        THEN
        assertEquals("foo", updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality - 1, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality decreases by 2 if sellIn is less than 0`() {
        GIVEN
        val sellIn = -Random.nextInt(0, 51)
        val quality = Random.nextInt(2, 51)
        val item = Item("foo", sellIn, quality)

        WHEN
        val updatedItem = DefaultItem.fromItem(item).update()

        THEN
        assertEquals("foo", updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(quality - 2, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality cannot be less than 0`() {
        GIVEN
        val sellIn = Random.nextInt(0, 50)
        val quality = -Random.nextInt(1, 51)
        val item = Item("foo", sellIn, quality)

        WHEN
        val updatedItem = DefaultItem.fromItem(item).update()

        THEN
        assertEquals("foo", updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(0, updatedItem.quality)
    }

    @RepeatedTest(value = 20)
    fun `quality cannot be greater than 50`() {
        GIVEN
        val sellIn = Random.nextInt(0, 50)
        val quality = Random.nextInt(51, 100)
        val item = Item("foo", sellIn, quality)

        WHEN
        val updatedItem = DefaultItem.fromItem(item).update()

        THEN
        assertEquals("foo", updatedItem.name)
        assertEquals(sellIn - 1, updatedItem.sellIn)
        assertEquals(50, updatedItem.quality)
    }
}