package com.CovidDisclosure.v1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.CovidDisclosure.v1.siddharth.CovidService;

import static org.junit.Assert.assertEquals;

// Import Local classes


@RunWith(SpringRunner.class)
public class TestingGetDays {

	@Test
	public void testReverse()  {
		CovidService c =new CovidService();

		//check if it works by calling its methods
		int[] testDate= {10,20,2020};
		assertEquals(4, c.getDays(testDate));

	}

}

