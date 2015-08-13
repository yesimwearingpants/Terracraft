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
 * Created Jul 6, 2015
 */

package com.sww.voxel.draw.texture;

/**
 * The Class TexturedModel.
 */
public class ModelTexture {

	private int texID;

	public ModelTexture(int id) {
		this.texID = id;
	}

	public int getTexID() {
		return texID;
	}

}
