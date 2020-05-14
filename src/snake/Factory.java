package snake;


public final class Factory {
	/** Create a snake object @return Snake Object @param size its the size of the snake @param id its the snake id @param direction this is where store where is going the snake   */
	public static ISnake createSnake(int size ,ID id, IDirection direction) {
		return new Snake(5, ID.Snake, direction);
	}
	/** Create a Apple object @return Apple Object @param size its the size of the apple @param xcordinate its should be random @param ycordinate its should be random @param id its the apple id    */
	public static IApple createApple(int size ,int randomx,int randomy,ID id) {
		return new Apple(size,randomx,randomy,id);
	}
	/** Create a Direction object @return Direction Object*/
	public static IDirection createDirection() {
		return new Direction();
	}
	/** Create a Handler object @return Handler Object*/
	public static IHandlrer createHandlrer() {
		return new Handlrer();
	}
	/** Create a key object @param direction object @return Key Object*/
	public static IKey createKey(IDirection direction) {
		return new Key(direction);
	}
	/** Create a screen object @param width integer @param height integer @param game type object @return Screen Object*/
	public static IScreen createScreen(int width,int height,Game game) {
		return new Screen(width, height, game);
	}
	/** Create a game object  @return game Object*/
	public static IGame createGame() {
		return new Game();
	}
	/** Create a BodyPart object @return BodyPart Object @param size its the size of the BodyPart @param xcordinate  @param ycordinate    */
	public static IBodyPart createBodyPart(int size,int xcord,int ycord) {
		return new BodyPart(size, xcord, ycord);
	}
	/** Create a Menu object @param Game object @param Handler object @return Menu Object*/
	public static Menu createMenu(Game game,IHandlrer hanndlrer) {
		return new Menu(game, hanndlrer);
	}

}
