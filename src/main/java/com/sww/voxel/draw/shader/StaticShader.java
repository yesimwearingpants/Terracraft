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
package com.sww.voxel.draw.shader;

import org.joml.Matrix4d;
import org.joml.Vector3f;
import org.joml.Vector4f;

import com.sww.voxel.engine.utils.vector.Vector3fExt;
import com.sww.voxel.engine.utils.vector.Vector4fExt;


public class StaticShader extends ShaderProgram {

	private static final String vs = "quad.vs";
	private static final String fs = "quad.fs";
	private int locationTranslationMatrix;
	private int locationuniformColour;
	private int locationuniformOutColour;

	/**
	 * Instantiates a new static shader.
	 */
	public StaticShader() {
		super(vs, fs);
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "texCoords");
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void getAllUniformLocations() {
		locationTranslationMatrix = super.getUniformLocation("translationMatrix");
		locationuniformColour = super.getUniformLocation("uniformColour");
		locationuniformOutColour = super.getUniformLocation("uniformOutColour");
	}

	/**
	 * Load translation matrix.
	 *
	 * @param matrix the matrix
	 */
	public void loadTranslationMatrix(Matrix4d matrix) {
		super.loadMatrix(locationTranslationMatrix, matrix);
	}

	public void loadColourVector(Vector3f colour, Vector4f rGBA) {
		super.loadVector(locationuniformColour, (Vector3fExt) colour);
		super.loadVector(locationuniformOutColour, (Vector4fExt) rGBA);
	}

}
