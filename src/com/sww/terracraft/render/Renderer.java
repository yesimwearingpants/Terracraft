package com.sww.terracraft.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import com.sww.terracraft.render.models.RawModel;

public class Renderer {
	
	public static void prepare() {
		GL11.glClearColor(0.09f, 0.05f, 0.1f, 1f);
	}
	
	public static void render(RawModel model) {
		GL30.glBindVertexArray(model.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getVertexCount());
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}

}
