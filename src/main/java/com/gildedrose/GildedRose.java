package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.name.equals(AGED_BRIE)) {
                updateQualityForAgedBrie(item);
            } else if (item.name.equals(BACKSTAGE_PASS)) {
                updateQualityForBackstagePasses(item);
            } else if (item.name.equals(SULFURAS)) {
                //updateQualityForSulfuras(item);
            } else {
                updateQualityForNormalItem(item);
            }
            updateSellIn(item);
        }
    }

    private static void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 1) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private static void updateQualityForBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

        }
        if (item.sellIn < 1) {
            item.quality = 0;
        }
    }

    private static void updateQualityForNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        if (item.sellIn < 1) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void updateQualityForSulfuras(Item item){

    }

    private static void updateSellIn(Item item) {
        if (item.name.equals(SULFURAS)) {
        } else {
            item.sellIn = item.sellIn - 1;
        }
    }

}
