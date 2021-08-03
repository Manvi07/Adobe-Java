package com.adobe.prj;
 

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adobe.prj.util.ArrayUtil;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data = {5,4,2};
		int expectedSum = 11;
		assertEquals(expectedSum, ArrayUtil.getSum(data));
	}

	@Test
	public void testGetOccurence() {
		 int[] elems = {5,7,2,5,9,5};
		 int expected = 3;
		 assertEquals(expected, ArrayUtil.getOccurence(elems, 5));
	}

}
