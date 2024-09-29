package com.gildedrose.items

class Sulfuras(
    name: String,
    sellIn: Int,
    quality: Int
) : Item(name, sellIn, quality) {
    fun update(): Sulfuras {
        quality = 80
        return this
    }

    companion object {
        fun fromItem(item: Item): Sulfuras {
            return Sulfuras(
                name = item.name,
                sellIn = item.sellIn,
                quality = item.quality
            )
        }
    }
}
