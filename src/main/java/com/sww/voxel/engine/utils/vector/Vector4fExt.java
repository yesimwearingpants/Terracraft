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
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class Vector4fExt extends Vector4f {

	public Vector4fExt(Vector2f vec2, float z, float w) {
		super.x = vec2.x;
		super.y = vec2.x;
		super.z = z;
		super.w = w;
	}

	public Vector4fExt(Vector3f vec3, float w) {
		super.x = vec3.x;
		super.y = vec3.y;
		super.z = vec3.z;
		super.w = w;
	}

	public Vector4fExt(Vector3d vec3, float w) {
		super.x = (float) vec3.x;
		super.y = (float) vec3.y;
		super.z = (float) vec3.z;
		super.w = w;
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

	public float getW() {
		return super.w;
	}

}
