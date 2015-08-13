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

import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector4d;

public class Vector4dExt extends Vector4d {

	public Vector4dExt(Vector2d vec2, double z, double w) {
		super.x = vec2.x;
		super.y = vec2.y;
		super.z = z;
		super.w = w;
	}

	public Vector4dExt(Vector3d vec3, double w) {
		super.x = vec3.x;
		super.y = vec3.y;
		super.z = vec3.z;
		super.w = w;
	}

	public Vector4dExt(Vector3f vec3, double w) {
		super.x = vec3.x;
		super.y = vec3.y;
		super.z = vec3.z;
		super.w = w;
	}

	public double getX() {
		return super.x;
	}

	public double getY() {
		return super.y;
	}

	public double getZ() {
		return super.z;
	}

	public double getW() {
		return super.w;
	}

}
