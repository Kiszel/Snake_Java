package snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

public class Handlrer implements IHandlrer {
	private Collection<IEntity> entitys = new ArrayList<IEntity>();
	
	@Override
	/** run every tick here call the entity ticks*/
	public void tick() {
		for (int i = 0; i < entitys.size(); i++) {
			IEntity tempEntity = (IEntity) entitys.toArray()[i];
			tempEntity.tick();
		}
	}
	@Override
	/** its call the entitys paint methods */
	public void paint(Graphics g) {
		for (int i = 0; i < entitys.size(); i++) {
			IEntity tempEntity = (IEntity) entitys.toArray()[i];
			tempEntity.paint(g);
		}
	}
	@Override
	/** add a entity to the entity collection @paramn IEntity type entity  */
	public void addEntity(IEntity e) {
		this.entitys.add(e);
	}
	@Override
	/** remove a entity from the entity collectio @paramn IEntity type entity */
	public void removeEntity(IEntity e) {
		this.entitys.remove(e);
	}
	@Override
	/** clear the entity collection */
	public void clearEntitys() {
		this.entitys.clear();
	}
	@Override
	/** get entity from the collection @param integer index */
	public IEntity getEntity(int i) {
		return (IEntity) entitys.toArray()[i];
	}
	@Override
	/** get size of the collection @return integer size */
	public int sizeOfEntitysList() {
		return entitys.size();
	}
}
