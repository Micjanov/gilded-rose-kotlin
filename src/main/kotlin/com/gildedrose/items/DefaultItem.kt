package com.gildedrose.items

class DefaultItem(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {
    fun update(): DefaultItem {
        quality = when {
            sellIn <= 0 -> quality - 2
            else -> quality - 1
        }
            .coerceIn(0, 50)
        sellIn -= 1

        return this
    }

    companion object {
        fun fromItem(item: Item): DefaultItem {
            return DefaultItem(
                name = item.name,
                sellIn = item.sellIn,
                quality = item.quality
            )
        }
    }
}
