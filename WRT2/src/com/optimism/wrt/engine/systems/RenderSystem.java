package com.optimism.wrt.engine.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.optimism.wrt.engine.components.*;


public class RenderSystem extends EntityProcessingSystem {
	
	private SpriteBatch batch;
	
	@Mapper ComponentMapper<Rect> rm;
	@Mapper ComponentMapper<Image> im;
	
	
	@SuppressWarnings("unchecked")
	public RenderSystem() {
		super(Aspect.getAspectForAll(Rect.class, Image.class));
		batch = new SpriteBatch();
	}
	
	@Override
	public void begin() {
		batch.begin();
	}
	
	@Override
	public void process(Entity entity) {
		Image img = im.get(entity);
		Rect rect = rm.get(entity);
		batch.draw(img.texture,
				(float) rect.lowleft.x, (float) rect.lowleft.y,
				(float) rect.size.x, (float) rect.size.y);
	}
	
	@Override
	public void end() {
		batch.end();
	}

}
