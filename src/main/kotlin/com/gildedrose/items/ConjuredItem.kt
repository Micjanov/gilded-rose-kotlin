package com.gildedrose.items

class ConjuredItem(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {
    fun update(): ConjuredItem {
        quality = when {
            sellIn <= 0 -> quality - 4
            else -> quality - 2
        }
            .coerceIn(0, 50)

        sellIn -= 1

        return this
    }

    companion object {
        fun fromItem(item: Item): ConjuredItem {
            return ConjuredItem(
                name = item.name,
                sellIn = item.sellIn,
                quality = item.quality
            )
        }
    }
}
