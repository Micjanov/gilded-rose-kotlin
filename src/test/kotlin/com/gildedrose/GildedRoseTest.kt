package com.gildedrose

import com.gildedrose.TestMarkers.GIVEN
import com.gildedrose.TestMarkers.THEN
import com.gildedrose.TestMarkers.WHEN
import com.gildedrose.items.*
import com.gildedrose.items.ItemNames.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class GildedRoseTest {
    @RepeatedTest(10)
    fun `number of items in input should be the same as in output`() {
        GIVEN
        val listSize = Random.nextInt(0, 50)
        val items = List(listSize) {
            val sellIn = Random.nextInt(1, 50)
            val quality = Random.nextInt(0, 50)
            Item("foo", sellIn, quality)
        }

        WHEN
        val app = GildedRose(items)
        app.updateQuality()

        THEN
        val updatedItemsSize = app.items.size
        assertEquals(updatedItemsSize, listSize)
    }

    @Test
    fun `when input contains an item with name 'Aged Brie', it should return the item as type Brie`() {
        GIVEN
        val sellIn = Random.nextInt(1, 50)
        val quality = Random.nextInt(0, 50)
        val item = Item(AGED_BRIE.itemName, sellIn, quality)

        WHEN
        val app = GildedRose(listOf(item))
        app.updateQuality()

        THEN
        val updatedItem = app.items.single()
        assertEquals(AGED_BRIE.itemName, updatedItem.name)
        assertEquals(Brie::class, updatedItem::class)
    }

    @Test
    fun `when input contains an item with name 'Backstage passes to a TAFKAL80ETC concert', it should return the item as type BackstagePasses`() {
        GIVEN
        val sellIn = Random.nextInt(1, 50)
        val quality = Random.nextInt(0, 50)
        val item = Item(BACKSTAGE_PASSES.itemName, sellIn, quality)

        WHEN
        val app = GildedRose(listOf(item))
        app.updateQuality()

        THEN
        val updatedItem = app.items.single()
        assertEquals(BACKSTAGE_PASSES.itemName, updatedItem.name)
        assertEquals(BackstagePasses::class, updatedItem::class)
    }

    @Test
    fun `when input contains an item with name 'Sulfuras, Hand of Ragnaros', it should return the item as type Sulfuras`() {
        GIVEN
        val sellIn = Random.nextInt(1, 50)
        val quality = Random.nextInt(0, 50)
        val item = Item(SULFURAS.itemName, sellIn, quality)

        WHEN
        val app = GildedRose(listOf(item))
        app.updateQuality()

        THEN
        val updatedItem = app.items.single()
        assertEquals(SULFURAS.itemName, updatedItem.name)
        assertEquals(Sulfuras::class, updatedItem::class)
    }

    @Test
    fun `when input contains an item with name 'Conjured Mana Cake', it should return the item as type ConjuredItem`() {
        GIVEN
        val sellIn = Random.nextInt(1, 50)
        val quality = Random.nextInt(0, 50)
        val item = Item(MANA_CAKE.itemName, sellIn, quality)

        WHEN
        val app = GildedRose(listOf(item))
        app.updateQuality()

        THEN
        val updatedItem = app.items.single()
        assertEquals(MANA_CAKE.itemName, updatedItem.name)
        assertEquals(ConjuredItem::class, updatedItem::class)
    }
}


