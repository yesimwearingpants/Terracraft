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
 * Created Jul 8, 2015
 */
package com.sww.voxel.engine.utils.vector;

import org.joml.Vector2f;
import org.joml.Vector3f;

public class Vector3fExt extends Vector3f {

	public Vector3fExt(Vector2f vec2, float z) {
		super.x = vec2.x;
		super.y = vec2.y;
		super.z = z;
	}

	public Vector3fExt(float x, float y, float z) {
		super.x = x;
		super.y = y;
		super.z = z;
	}

	public float getX() {
		return super.x;
	}

	public float getY() {
		return super.y;
	}

	public float getZ() {
		return super.z;
	}

}
