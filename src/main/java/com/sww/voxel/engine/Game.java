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
 * Created Jun 19, 2015
 */
package com.sww.voxel.engine;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFW;

import com.sww.voxel.draw.Loader;
import com.sww.voxel.draw.RawModel;
import com.sww.voxel.draw.entity.Entity;
import com.sww.voxel.draw.render.Renderer;
import com.sww.voxel.draw.shader.StaticShader;
import com.sww.voxel.draw.texture.ModelTexture;
import com.sww.voxel.draw.texture.TexturedModel;
import com.sww.voxel.engine.input.KeyInput;
import com.sww.voxel.engine.utils.vector.Vector3dExt;
import com.sww.voxel.world.Camera;

public class Game {

	Loader load = new Loader();
	Renderer render = new Renderer();
	StaticShader shader = new StaticShader();
	
	float[] vertices = {
			-0.5f,0.5f,-0.5f,	-0.5f,-0.5f,-0.5f,	0.5f,-0.5f,-0.5f,	0.5f,0.5f,-0.5f,
			-0.5f,0.5f,0.5f,	-0.5f,-0.5f,0.5f,	0.5f,-0.5f,0.5f,	0.5f,0.5f,0.5f,
			0.5f,0.5f,-0.5f,	0.5f,-0.5f,-0.5f,	0.5f,-0.5f,0.5f,	0.5f,0.5f,0.5f,
			-0.5f,0.5f,-0.5f,	-0.5f,-0.5f,-0.5f,	-0.5f,-0.5f,0.5f,	-0.5f,0.5f,0.5f,
			-0.5f,0.5f,0.5f,	-0.5f,0.5f,-0.5f,	0.5f,0.5f,-0.5f,	0.5f,0.5f,0.5f,
			-0.5f,-0.5f,0.5f,	-0.5f,-0.5f,-0.5f,	0.5f,-0.5f,-0.5f,	0.5f,-0.5f,0.5f
	};
	
	float[] textureCoords = {
			0,0,	0,1,	1,1,	1,0,	0,0,	0,1,	1,1,	1,0,			
			0,0,	0,1,	1,1,	1,0,	0,0,	0,1,	1,1,	1,0,
			0,0,	0,1,	1,1,	1,0,	0,0,	0,1,	1,1,	1,0
	};
	
	int[] indices = {
			0,1,3,	3,1,2,	4,5,7,	7,5,6,	8,9,11,		11,9,10,	12,13,15,
			15,13,14,	16,17,19,	19,17,18,	20,21,23,	23,21,22
	};
	RawModel rModel = load.loadToVAO(vertices, textureCoords, indices);
	TexturedModel staticModel = new TexturedModel(rModel, new ModelTexture(load.loadTexture("clay.png")));
	Entity entity = new Entity(staticModel, new Vector3dExt(0,0,-1),0,0,0,1);
	Camera camera = new Camera();

	public void input() {
		if(KeyInput.isKeyDown(GLFW_KEY_UP)) {
			
		}
		if(KeyInput.isKeyDown(GLFW_KEY_DOWN)) {
			
		}
		if(KeyInput.isKeyDown(GLFW_KEY_LEFT)) {
					
		}
		if(KeyInput.isKeyDown(GLFW_KEY_RIGHT)) {
			
		}
	}

	public void update() {
		
	}

	public void run() {
		render.prepare();
		shader.start();
		shader.stop();
	}

	public void cleanup() {
		shader.cleanUp();
		load.cleanUp();
	}

}
