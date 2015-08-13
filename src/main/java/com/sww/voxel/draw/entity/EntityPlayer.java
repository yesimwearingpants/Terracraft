package com.sww.voxel.draw.entity;

import com.sww.voxel.engine.utils.vector.Vector3dExt;

public class EntityPlayer extends Entity {

	/** Creates a new Default GuiButton
	 * 
	 * @param position	new Vector3f position
	 */
	public EntityPlayer(Vector3dExt position) {
		super(position, 0, 0, 0.35D, 0.12D);
		super.setRed(0.2);
		super.setGreen(0.2);
		super.setBlue(0.2);
		super.setAlpha(0.3);
	}
	/** Creates a new GuiButton
	 * 
	 * @param position	new Vector3f position
	 * @param scaleX	X Scale Percentage
	 * @param scaleY	Y Scale Percentage
	 */
	public EntityPlayer(Vector3dExt position, int scaleX, int scaleY) {
		super(position, 0, 0, (double) (scaleX/100D), (double) (scaleY/100D));
		super.setRed(0.2);
		super.setGreen(0.2);
		super.setBlue(0.2);
		super.setAlpha(0.3);
	}

}
