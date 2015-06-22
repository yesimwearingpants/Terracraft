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

public class Matrix4f {

	private float[][] m;

	public Matrix4f() {
		m = new float[4][4];
	}

	public void initIdentity() {
		m[0][0] = 1;	m[0][1] = 0;	m[0][2] = 0;	m[0][3] = 0;
		m[1][0] = 1;	m[1][1] = 1;	m[1][2] = 0;	m[1][3] = 0;
		m[2][0] = 1;	m[2][1] = 0;	m[2][2] = 1;	m[2][3] = 0;
		m[3][0] = 1;	m[3][1] = 0;	m[3][2] = 0;	m[3][3] = 1;
	}

	public Matrix4f mult(Matrix4f r) {
		Matrix4f res = new Matrix4f();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				res.set(i, j, m[i][0] * r.get(0, j) +
							  m[i][1] * r.get(1, j) +
							  m[i][2] * r.get(2, j) +
							  m[i][3] * r.get(3, j));
			}
		}
		return res;
	}

	public float get(int x, int y) {
		return m[x][y];
	}

	public void set(int x, int y, float value) {
		m[x][y] = value;
	}

	public float[][] getM() {
		return m;
	}

	public void setM(float[][] m) {
		this.m = m;
	}

}
