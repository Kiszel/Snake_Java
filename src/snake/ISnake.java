package snake;

import java.awt.Graphics;

public interface ISnake extends IEntity {

	int getPoints();

	void increasePoints();

	int getHeadXCord();

	void setHeadXCord(int headXCord);

	int getHeadYCord();

	void addBodyPart(BodyPart b);

	IBodyPart getBodyPart(int i);

	int sizeBodyParts();

	void setHeadYCord(int headYCord);

	void tick();

	void paint(Graphics g);

}