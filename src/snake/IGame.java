package snake;

public interface IGame {

	IDirection getDirection();

	double elapsedTime();

	void cleartheTimer();

	void fileWritter();

	void tick();

	void render();

	void start();

	void stop();

	void run();

}