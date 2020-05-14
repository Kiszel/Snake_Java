package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import snake.Factory;
import snake.IBodyPart;
import snake.ID;
import snake.IDirection;
import snake.IHandlrer;
import snake.IKey;
import snake.ISnake;

public class FactoryTest {
	IDirection d;
	IHandlrer h;
	IBodyPart body;
	IKey key;
	ISnake snake;
	 @BeforeClass
	 public void setUp() {
	
	 
	 
	
	

	}
	@Test
	public void factoryDirectionTest() {
		 d = Factory.createDirection();
		assertNotNull("Nem jött létre a az obejektum",d);
	}
	@Test
	public void factoryHandlerTest() {
		h=Factory.createHandlrer();
		assertNotNull("Nem jött létre a az obejektum",h);
	}
	@Test
	public void factorySnakeBodyPartTest() {
		body=Factory.createBodyPart(10,10,10);
		assertNotNull("Nem jött létre a az obejektum",body);
	}
	@Test
	public void factoryinputKeyTest() {
		key=Factory.createKey(d);
		assertNotNull("Nem jött létre a az obejektum",key);
	}
	@Test
	public void factorySnake() {
		 snake=Factory.createSnake(10 ,ID.Snake, d);
		assertNotNull("Nem jött létre a az obejektum",snake);
	}

}
