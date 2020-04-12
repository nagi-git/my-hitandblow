package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.Assert;
import junit.framework.TestCase;;


@RunWith(JUnit4.class)
public class CountTest extends TestCase {

	@Test
	public void testHitCount() {
		int[] input1 = new int[] {1, 2, 3, 4};
		int[] input2 = new int[] {2, 4, 3, 1};

		int result = Count.countHit(input1, input2);

		Assert.assertEquals(1, result);
	}

}
