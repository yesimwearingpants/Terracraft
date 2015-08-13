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
 * Created Jun 17, 2015
 */
package com.sww.voxel;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL;

import com.sww.voxel.engine.Game;
import com.sww.voxel.engine.input.KeyInput;
import com.sww.voxel.engine.input.MouseInput;

public class Main {

    // We need to strongly reference callback instances.
    private GLFWErrorCallback errorCallback;
    private KeyInput keyCallback;
    private MouseInput mouseCallback;	
    
	private static int vSync = 0;
	private final double FRAMECAP = 5000.0;
    private final float red = 0.0307f;
    private final float green = 0.0154f;
    private final float blue = 0.0794f;

    private static boolean isGameRunning = false;
    private static long window;

    public void run() {
        try {
            init();
            loop();
            //TODO: pass loop() as arg or something;

            glfwDestroyWindow(window);
            keyCallback.release();
            mouseCallback.release();
        } finally {
            glfwTerminate();
            errorCallback.release();
        }
    }

    private void init() {
        glfwSetErrorCallback(errorCallback = Callbacks.errorCallbackPrint(System.err));

        if (glfwInit() != GL_TRUE )
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE); // the window will be resizable

        int WIDTH = 720;
        int HEIGHT = 480;

        window = glfwCreateWindow(WIDTH, HEIGHT, "Hello World!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(
            window,
            (GLFWvidmode.width(vidmode) - WIDTH) / 2,
            (GLFWvidmode.height(vidmode) - HEIGHT) / 2
        );

        glfwMakeContextCurrent(window);
        glfwSwapInterval(vSync);
        glfwShowWindow(window);
    }

    public void loop() {
    	GL.createCapabilities(true);
    	Game game = new Game();

        glClearColor(red, green, blue, 0.0f);

        int frames = 0;
        long frameCounter = 0;

        long lastTime = Time.getTime();
        double unprocessedTime = 0;

        setRunning(true);
        while(isRunning()) {
        	boolean render = false;

        	//*		This Code		*//

        	final double frameTime = 1.0 / FRAMECAP;

        	long startTime = Time.getTime();
        	long passedTime = startTime - lastTime;
        	lastTime = startTime;

        	unprocessedTime += passedTime / (double) Time.SECOND;
        	frameCounter += passedTime;

        	while(unprocessedTime > frameTime) {
        		unprocessedTime -= frameTime;
	        	if(isCloseRequested()) {
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

        	//*			I think			*//

        	if(render && !isCloseRequested()) {
        		game.run();

	            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	            glfwSwapBuffers(getWindow());
	            glfwPollEvents();
	            frames++;
        	} else {
        		try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					System.err.println("Can't Sleep Too Much Java");
					e.printStackTrace();
				}
        	}
        }
    }

	public void start() {
    	if(isRunning()) {
    		throw new IllegalStateException("Already Running");
    	}
    	run();
    }

    private void stop() {
    	if(!isRunning()) {
    		return;
    	}
    	setRunning(false);
    }

	private boolean isCloseRequested() {
		return (glfwWindowShouldClose(getWindow()) == GL_TRUE);
	}

    public static void main(String[] args) {
        new Main().run();
    }

    public static long getWindow() {
		return window;
    }

	public static boolean isRunning() {
		return isGameRunning;
	}

	public static void setRunning(boolean running) {
		isGameRunning = running;
	}

	public static int getvSync() {
		return vSync;
	}

	public static void setvSync(int vSync) {
		Main.vSync = vSync;
	}
 
}