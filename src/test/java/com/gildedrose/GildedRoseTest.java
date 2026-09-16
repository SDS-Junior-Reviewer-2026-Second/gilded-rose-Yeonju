package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseTest {
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String NONAME = "noname";
	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

	@Test
	public void test() {
		Item[] items = new Item[]{
				new Item("naname", 0, 0)
		};
		GildedRose gildedRose = new GildedRose(items);

		gildedRose.updateQuality();

		assertEquals(1, items.length);
		assertEquals(-1, items[0].sellIn);
		//assertEquals(0, items[0].quality);
	}

	// [Step 1] item이 하나도 없는 상태에서 updateQuality 하는 경우
	@Test
	public void should_be_nothing_when_no_item(){
		// given (arrange)
		Item[] items = new Item[]{};
		GildedRose gildedRose = new GildedRose(items);

		// when(act)
		gildedRose.updateQuality();

		// then
		assertEquals(0, items.length);
	}

	// [Step 2] name="noname", sellin=0, quality=0
	@Test
	public void noname_sellin_0_quality_0(){
		// given (arrange)
		Item[] items = new Item[]{new Item(NONAME, 0, 0)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	// [Step 3] name=“noname”, sellin=0, quality=1
	@Test
	public void noname_sellin_0_quality_1 () {
		// given (arrange)
		Item[] items = new Item[]{new Item(NONAME, 0, 1)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	// [Step 4] name=“Sulfuras…”, sellin=0, quality=80
	@Test
	public void sulfuras_sellin_0_quality_80 () {
		// given (arrange)
		Item[] items = new Item[]{new Item(SULFURAS, 0, 80)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(0, items[0].sellIn);
		assertEquals(80, items[0].quality);
	}

	// [Step 6] name="Aged Brie", sellin=0, quality=0
	@Test
	public void agedBrie_sellin_0_quality_0() {
		// given (arrange)
		Item[] items = new Item[]{new Item(AGED_BRIE, 0, 0)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(-1, items[0].sellIn);
		assertEquals(2, items[0].quality);
	}

	// [Step 7] name="Backstage...", sellin=0, quality=0
	@Test
	public void backstage_pass_sellin_0_quality_0() {
		// given (arrange)
		Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 0, 0)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	// [Step 8] name="Backstage...", sellin=0, quality=49
	@Test
	public void backstage_pass_sellin_0_quality_49() {
		// given (arrange)
		Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 0, 49)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(-1, items[0].sellIn);
		assertEquals(0, items[0].quality);
	}

	// [Step 9] name=“Backstage…”, sellin=12, quality=0
	@Test
	public void backstage_pass_sellin_12_quality_0() {
		// given (arrange)
		Item[] items = new Item[]{new Item(BACKSTAGE_PASS, 12, 0)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(11, items[0].sellIn);
		assertEquals(1, items[0].quality);
	}

	// [Step 10] name=“Sulfuras…”, sellin=-2, quality=80
	@Test
	public void sulfuras_sellin_m2_quality_80() {
		// given (arrange)
		Item[] items = new Item[]{new Item(SULFURAS, -2, 80)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(-2, items[0].sellIn);
		assertEquals(80, items[0].quality);
	}

	// [Step 11] name="Aged Brie", sellin=0, quality=50
	@Test
	public void agedBrie_sellin_0_quality_50() {
		// given (arrange)
		Item[] items = new Item[]{new Item(AGED_BRIE, 0, 50)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(-1, items[0].sellIn);
		assertEquals(50, items[0].quality);
	}

	// [Step 12] Branch Coverage 100%를 위해 추가: 일반 아이템의 sellin이 지난 뒤(음수)
	// quality가 한 번 더 감소하는 분기(GildedRose.java 48번째 줄)는 quality가 남아있어야 타므로,
	// 첫 번째 감소 후에도 quality > 0 이 되도록 초기값을 5로 준다.
	// name="noname", sellin=0, quality=5
	@Test
	public void noname_sellin_0_quality_5() {
		// given (arrange)
		Item[] items = new Item[]{new Item(NONAME, 0, 5)};
		GildedRose gildedRose = new GildedRose(items);

		// when (act)
		gildedRose.updateQuality();

		// then (assert)
		assertEquals(-1, items[0].sellIn);
		assertEquals(3, items[0].quality);
	}
}
