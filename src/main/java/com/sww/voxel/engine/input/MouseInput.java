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
 * Created Jun 22, 2015
 */
package com.sww.voxel.engine.input;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.DoubleBuffer;

import org.joml.Vector2f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import com.sww.voxel.Main;

public class MouseInput extends GLFWMouseButtonCallback {

	private static DoubleBuffer xbuffer = BufferUtils.createDoubleBuffer(1);
	private static DoubleBuffer ybuffer = BufferUtils.createDoubleBuffer(1);
	private boolean[] buttons = new boolean[8];

	/** Mouse buttons. From GLFW */
	public static final int
		MOUSEBUTTON1      = 0x0,
		MOUSEBUTTON2      = 0x1,
		MOUSEBUTTON3      = 0x2,
		MOUSEBUTTON4      = 0x3,
		MOUSEBUTTON5      = 0x4,
		MOUSEBUTTON6      = 0x5,
		MOUSEBUTTON7      = 0x6,
		MOUSEBUTTON8      = 0x7,
		MOUSEBUTTONLAST   = MOUSEBUTTON8,
		MOUSEBUTTONLEFT   = MOUSEBUTTON1,
		MOUSEBUTTONRIGHT  = MOUSEBUTTON2,
		MOUSEBUTTONMIDDLE = MOUSEBUTTON3;

	@Override
	public void invoke(long window, int button, int action, int mods) {
		buttons [button] = action != GLFW_RELEASE;
	}

	public static Vector2f getPosition() {
		glfwGetCursorPos(Main.getWindow(), xbuffer, ybuffer);
		float x = (float) xbuffer.get();
		float y = (float) ybuffer.get();
		return new Vector2f(x, y);
		
	}

	public static void setMousePosition(Vector2f centerPosition) {
		double x = centerPosition.x;
		double y = centerPosition.y;
		glfwSetCursorPos(Main.getWindow(), x, y);
	}

	public static void setCursor(boolean b) {
		// TODO: Mouse Grab
	}

	public static boolean getMouseDown(int i) {
		// TODO: ????
		return false;
	}

}
