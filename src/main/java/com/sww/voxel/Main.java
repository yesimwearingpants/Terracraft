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

import com.sww.voxel.engine.input.KeyInput;
import com.sww.voxel.engine.input.MouseInput;
import com.sww.voxel.state.PlayGame;

public class Main {

    // We need to strongly reference callback instances.
    private GLFWErrorCallback errorCallback;
    private KeyInput keyCallback;
    private MouseInput mouseCallback;	
    
	private static int vSync = 0;

    private static boolean isRunning = false;
    private static long window;

    public void run() {
        try {
            init();
            PlayGame play = new PlayGame();
            play.loop();
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

    public void start() {
    	if(isRunning) {
    		throw new IllegalStateException("Already Running");
    	}
    	run();
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public static long getWindow() {
		return window;
    }

	public static boolean isRunning() {
		return isRunning;
	}

	public static void setRunning(boolean running) {
		isRunning = running;
	}

	public static int getvSync() {
		return vSync;
	}

	public static void setvSync(int vSync) {
		Main.vSync = vSync;
	}
 
}