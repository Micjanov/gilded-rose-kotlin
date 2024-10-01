package com.gildedrose.items

class BackstagePasses(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {
    fun update(): BackstagePasses {
        quality = when {
            sellIn <= 0 || quality < 0 -> 0
            sellIn in 1..5 -> quality + 3
            sellIn in 6..10 -> quality + 2
            else -> quality + 1
        }
            .coerceIn(0, 50)

        sellIn -= 1
        return this
    }

    companion object {
        fun fromItem(item: Item): BackstagePasses {
            return BackstagePasses(
                name = item.name,
                sellIn = item.sellIn,
                quality = item.quality
            )
        }
    }
}
