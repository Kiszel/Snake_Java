package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import snake.Factory;
import snake.IApple;
import snake.ID;
import snake.IHandlrer;
import snake.ISnake;

public class HandlrerTest {

	IHandlrer h;
	ISnake s;
	IApple a;
	 @Before
	 public void setUp() {
		 s=Factory.createSnake(15, ID.Snake, Factory.createDirection());
		 a=Factory.createApple(10, 10, 10, ID.Apple);
		 h=Factory.createHandlrer();
		 h.addEntity(s);
		 h.addEntity(a);
	}
	@Test
	public void HandlerEntitySizeTest() {
		assertEquals(h.sizeOfEntitysList(),2);
	}
	@Test
	public void HandlerdeleteEntityTest() {
		h.removeEntity(s);
		assertEquals(h.sizeOfEntitysList(),1);
	}
	@Test
	public void HandlerClearEntityListTest() {
		h.clearEntitys();
		assertEquals(h.sizeOfEntitysList(),0);
	}

}
