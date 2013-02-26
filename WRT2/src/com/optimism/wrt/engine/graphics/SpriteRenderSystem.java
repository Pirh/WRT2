package com.optimism.wrt.engine.graphics;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.optimism.wrt.engine.components.*;


public class SpriteRenderSystem extends EntityProcessingSystem {
	
	private SpriteBatch batch;
	
	@Mapper ComponentMapper<Rect> rm;
	@Mapper ComponentMapper<Image> im;
	@Mapper ComponentMapper<Orientation> om;
	
	
	@SuppressWarnings("unchecked")
	public SpriteRenderSystem() {
		super(Aspect.getAspectForAll(Rect.class, Image.class));
		batch = new SpriteBatch();
	}
	
	@Override
	public void begin() {
		batch.setProjectionMatrix(Projector.projection);
		batch.begin();
	}
	
	@Override
	public void process(Entity entity) {
		Image img = im.get(entity);
		Rect rect = rm.get(entity);
		Orientation ori = om.getSafe(entity);
		
		if (ori == null) {
			batch.draw(img.texture,
					(float) rect.lowleft.x, (float) rect.lowleft.y,
					(float) rect.size.x, (float) rect.size.y);
		} else {
			/* OK I didn't write this method so don't blame me:
			 * First line is the texture to draw.
			 * Second is the position.
			 * Third is the relative position of the rotation point. (e.g. half the image size)
			 * Fourth is the size of the image.
			 * Fifth is x-scaling, y-scaling, rotation
			 * Sixth is for rendering a part of a texture. Ignore it since we're rendering the full texture.
			 */
			batch.draw(img.texture,
					(float) rect.lowleft.x, (float) rect.lowleft.y,
					(float) rect.size.x/2, (float) rect.size.y/2,
					(float) rect.size.x, (float) rect.size.y,
					1, 1, (float) ori.angle,
					0, 0, img.texture.getWidth(), img.texture.getHeight(), false, false);
		}
	}
	
	@Override
	public void end() {
		batch.end();
	}

}
