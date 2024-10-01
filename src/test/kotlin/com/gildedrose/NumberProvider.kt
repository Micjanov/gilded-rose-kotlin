package com.gildedrose

class NumberProvider(
    private val sellInRange: IntRange,
    private val qualityRange: IntRange
) {

    private fun createCartesianProduct(): List<Pair<Int, Int>> {
        return sellInRange.flatMap { sellIn ->
            qualityRange.map { quality ->
                sellIn to quality
            }
        }
    }

    fun forEachCombination(
        action: (Int, Int) -> Unit
    ) {
        createCartesianProduct()
            .forEach { (sellIn, quality) ->
                action(sellIn, quality)
            }
    }
}