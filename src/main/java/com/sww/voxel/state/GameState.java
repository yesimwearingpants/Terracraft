package com.sww.voxel.state;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_TRUE;

import com.sww.voxel.Main;

public abstract class GameState {

	public abstract void loop();
	   
    public boolean isCloseRequested() {
    	return (glfwWindowShouldClose(Main.getWindow()) == GL_TRUE);
    }

	public static boolean isRunning() {
		return Main.isRunning();
	}

	public static void setRunning(boolean running) {
		Main.setRunning(running);
	}

    public static long getWindow() {
		return Main.getWindow();
    }

	public static int getvSync() {
		return Main.getvSync();
	}

	public static void setvSync(int vSync) {
		Main.setvSync(vSync);
	}
 


}
