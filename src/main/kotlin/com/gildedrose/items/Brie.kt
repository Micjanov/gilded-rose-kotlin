package com.gildedrose.items

class Brie(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {
    fun update(): Brie {
        quality = when {
            quality < 0 -> 0
            sellIn <= 0 -> quality + 2
            else -> quality + 1
        }
            .coerceIn(0, 50)
        sellIn -= 1
        return this
    }

    companion object {
        fun fromItem(item: Item): Brie {
            return Brie(
                name = item.name,
                sellIn = item.sellIn,
                quality = item.quality
            )
        }
    }
}
