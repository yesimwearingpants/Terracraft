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
 * Created Jun 21, 2015
 */
package com.sww.voxel.engine;

public class Quaternion {

	private float x, y, z, w;

	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z + w * w);
	}

	public Quaternion normalize() {
		float length = length();

		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}

	public Quaternion conjugate() {
		return new Quaternion(-x, -y, -z, w);
	}

	public Quaternion mult(Quaternion r) {
		float ww = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();
		float xx = x * r.getW() + w * r.getX() + y * r.getZ() - z * r.getY();
		float yy = y * r.getW() + w * r.getY() + z * r.getX() - x * r.getZ();
		float zz = z * r.getW() + w * r.getZ() + x * r.getY() - y * r.getX();
		
		return new Quaternion(xx, yy, zz, ww);
	}
	
	public Quaternion mult(Vector3f r)
	{
		float ww = -x * r.getX() - y * r.getY() - z * r.getZ();
		float xx =  w * r.getX() + y * r.getZ() - z * r.getY();
		float yy =  w * r.getY() + z * r.getX() - x * r.getZ();
		float zz =  w * r.getZ() + x * r.getY() - y * r.getX();
		
		return new Quaternion(xx, yy, zz, ww);
	}


	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

}
