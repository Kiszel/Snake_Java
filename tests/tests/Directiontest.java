package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import snake.Factory;
import snake.IDirection;

public class Directiontest {
	IDirection d;
	 @Before
	 public void setUp() {
	 d = Factory.createDirection();
	 d.setGoingdown(true);

	}
	@Test
	public void DirectionTestDown() {
		assertEquals(d.isGoingdown(),true);
	}
	@Test
	public void DirectionTestLeft() {
		assertEquals(d.isGoingleft(),false);
	}
}
