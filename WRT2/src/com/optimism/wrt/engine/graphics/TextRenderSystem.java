package com.optimism.wrt.engine.graphics;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.*;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.math.Vec;


public class TextRenderSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<Rect> rm;
	@Mapper ComponentMapper<Text> tm;
	
	private SpriteBatch batch;
	private BitmapFont font;
	
	
	@SuppressWarnings("unchecked")
	public TextRenderSystem() {
		super(Aspect.getAspectForAll(Text.class, Rect.class));
		this.batch = new SpriteBatch();
		this.font = loadFont("courier10pitch");
	}
	
	public BitmapFont loadFont(String fontName) {
		FileHandle fontFile = Gdx.files.internal(String.format("fonts/%s.fnt", fontName));
		Texture fontTex = new Texture(String.format("fonts/%s.png", fontName));
		TextureRegion texReg = new TextureRegion(fontTex);
		fontTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		return new BitmapFont(fontFile, texReg, false);
	}
	
	@Override
	public void begin() {
		batch.setProjectionMatrix(Projector.textProjection);
		batch.begin();
	}
	
	@Override
	public void process(Entity entity) {
		Text text = tm.get(entity);
		Vec basePos = rm.get(entity).position(Anchor.TOPLEFT);
		
		Vec pos = Projector.textPositionHack(basePos);
		font.setColor(text.colour);
		font.setScale(text.scale);
		font.draw(batch, text.getText(), (float) pos.x, (float) pos.y);
	}
	
	@Override
	public void end() {
		batch.end();
	}
}
