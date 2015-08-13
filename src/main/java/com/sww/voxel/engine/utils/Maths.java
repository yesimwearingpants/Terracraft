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
package com.sww.voxel.engine.utils;

import org.joml.Matrix4d;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector4f;

import com.sww.voxel.engine.utils.vector.Vector4fExt;


public class Maths {

	/**
	 * Creates a VAO transformation matrix.
	 *
	 * @param translation the translation
	 * @param rx the X rotation
	 * @param ry the Y rotation
	 * @param rz the Z rotation
	 * @param scale the scale
	 * @return the matrix4f
	 */
	public static Matrix4d createTransformationMatrix(Vector3d translation, double rx, double ry, double scaleX,  double scaleY) {
		Matrix4d matrix = new Matrix4d();
		matrix.identity();
		matrix.translate(translation);
		matrix.rotate(rx, translation);
		matrix.scale(new Vector3d(scaleX, scaleY, 0.0));
		return matrix;
	}

	/**
	 * Creates a Vec3 RGB Colour for use in Shaders
	 * 
	 * @param d
	 * @param e
	 * @param f
	 * @return new Vec3 colour
	 */
	public static Vector3f createColour(float d, float e, float f) {
		return new Vector3f(d, e, f);
	}

	/**
	 * Allows Changing of colours and alpha
	 * 
	 * @param colour RGB Colour
	 * @param alpha
	 * @return new Vec4 RGBA Colour for use is Shaders
	 */
	public static Vector4f updateColourAlpha(Vector3f colour, float alpha) {
		return new Vector4fExt(colour, alpha);
	}

}
