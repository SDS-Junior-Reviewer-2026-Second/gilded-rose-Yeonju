package com.gildedrose;

public class AgedBrieItem extends GildedRoseItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.sellIn < 1) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
