package com.optimism.wrt.engine.components;

import com.artemis.Component;
import com.optimism.wrt.engine.vectors.Vec;


/*
 * A combined position-and-size component - since nothing can have a size without a position really.
 * If something has no size, just pass Vec.zero as the size.
 * 
 * You can also do some nice things with Anchors. For example, easily centre a Rect.
 */
public class Rect extends Component {

	public Vec lowleft;
	public Vec size;
	public Anchor anchor;
	
	public Rect(Vec position, Vec size, Anchor anchor) {
		this.size = size;
		this.anchor = anchor;
		setPosition(position, anchor);
	}
	
	public Rect(Vec position, Vec size) {
		this.lowleft = position;
		this.size = size;
		this.anchor = Anchor.LOWLEFT;
	}
	
	public Vec position(Anchor anchor) {
		return lowleft.add(size.mul(anchor.point));
	}
	
	public Vec position() {
		return position(this.anchor);
	}
	
	public void setPosition(Vec dest, Anchor anchor) {
		this.lowleft = dest.sub(size.mul(anchor.point));
	}
	
	public void setPosition(Vec dest) {
		setPosition(dest, this.anchor);
	}
	
}
