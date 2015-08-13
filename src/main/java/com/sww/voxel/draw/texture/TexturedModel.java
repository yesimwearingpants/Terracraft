/**
 * Jul 6, 2015
 */
package com.sww.voxel.draw.texture;

import com.sww.voxel.draw.RawModel;

/**
 * @author namae
 *
 */
public class TexturedModel {

	private RawModel rModel;
	private ModelTexture tex;

	public TexturedModel(RawModel model, ModelTexture texture) {
		this.rModel = model;
		this.tex = texture;
	}

	public RawModel getModel() {
		return rModel;
	}

	public ModelTexture getTexture() {
		return tex;
	}

}
