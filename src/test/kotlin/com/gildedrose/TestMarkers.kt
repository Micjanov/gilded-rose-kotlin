package com.gildedrose

object TestMarkers {
    val GIVEN: (description: (String?) -> Any) -> Any = {}
    val WHEN: (description: (String?) -> Any) -> Any = {}
    val THEN: (description: (String?) -> Any) -> Any = {}
}
