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
 * Created Jul 1, 2015
 */
package com.sww.voxel.draw;

public class RawModel {

	/** The vao id. */
	private int vaoID;
	
	/** The vertex count. */
	private int vertexCount;

	/**
	 * Instantiates a new model.
	 *
	 * @param vaoID the vao id
	 * @param vertexCount the vertex count
	 */
	public RawModel(int vaoID, int vertexCount) {
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}

	/**
	 * Gets the vao id.
	 *
	 * @return the vao id
	 */
	public int getVaoID() {
		return vaoID;
	}

	/**
	 * Gets the vertex count.
	 *
	 * @return the vertex count
	 */
	public int getVertexCount() {
		return vertexCount;
	}

}
