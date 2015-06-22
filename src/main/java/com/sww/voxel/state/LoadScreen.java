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
package com.sww.voxel.state;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GLContext;

import com.sww.voxel.Main;
import com.sww.voxel.engine.Game;
import com.sww.voxel.engine.Time;

public class LoadScreen extends GameState{

    private final double FRAMECAP = 5000.0;
    private final float red = 0.0307f;
    private final float green = 0.0154f;
    private final float blue = 0.0794f;
    private Game game = new Game();

    public void loop() {
        GLContext.createFromCurrent();

        glClearColor(red, green, blue, 0.0f);

        int frames = 0;
        long frameCounter = 0;

        long lastTime = Time.getTime();
        double unprocessedTime = 0;

        Main.setRunning(true);
        while(Main.isRunning()) {
        	boolean render = false;

        	final double frameTime = 1.0 / FRAMECAP;

        	long startTime = Time.getTime();
        	long passedTime = startTime - lastTime;
        	lastTime = startTime;

        	unprocessedTime += passedTime / (double) Time.SECOND;
        	frameCounter += passedTime;

        	while(unprocessedTime > frameTime) {
        		render = true;
        		unprocessedTime -= frameTime;
	        	if(glfwWindowShouldClose(Main.getWindow()) == GL_TRUE ) {
	        		stop();
	        	}
	        	Time.setDelta(frameTime);

	        	game.input();
	        	game.update();
	        	if(frameCounter >= Time.SECOND) {
	        		System.out.println(frames);
	        		frames = 0;
	        		frameCounter = 0;
	        	}
        	}
        	if(render && glfwWindowShouldClose(Main.getWindow()) == GL_FALSE) {
        		if(frames <= 60) {
        			Main.setRunning(false);
        		}
        		game.render();

	            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	            glfwSwapBuffers(Main.getWindow());
	            glfwWaitEvents();
	            frames++;
        	} else {
        		try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
        }
    }

    private void stop() {
    	if(!Main.isRunning()) {
    		return;
    	}
    	Main.setRunning(false);
    }

}
