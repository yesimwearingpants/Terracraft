/**
 * Copyright (c) 2015 Greg Wright
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * @author yesimwearingpants
 * Created Jul 2, 2015
 */
package com.sww.voxel.draw.entity;

import com.sww.voxel.draw.RawModel;
import com.sww.voxel.draw.texture.TexturedModel;
import com.sww.voxel.engine.utils.vector.Vector3dExt;

public class Entity {

	/**	The Model */
	private TexturedModel model;
	/** The position. */
	private Vector3dExt position;
	/** The rotations. */
	private double rotX, rotY;
	/** The Scale factors. */
	private double scaleX, scaleY;
	/** The Colours. */
	private float red, green, blue, alpha;

	public Entity(TexturedModel model, Vector3dExt position, double rotX, double rotY, double scalex, double scaley) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.scaleX = scalex;
		this.scaleY = scaley;
	}

	public TexturedModel getModel() {
		return model;
	}

	public RawModel getRawModel() {
		return model.getModel();
	}

	public Vector3dExt getPosition() {
		return position;
	}

	public double getRotX() {
		return rotX;
	}

	public double getRotY() {
		return rotY;
	}

	public double getScaleX() {
		return scaleX;
	}

	public double getScaleY() {
		return scaleY;
	}

	public float getRed() {
		return red;
	}

	public void setRed(float red) {
		this.red = red;
	}

	public float getGreen() {
		return green;
	}

	public void setGreen(float green) {
		this.green = green;
	}

	public float getBlue() {
		return blue;
	}

	public void setBlue(float blue) {
		this.blue = blue;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

}
