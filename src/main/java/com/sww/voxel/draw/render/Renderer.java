package com.sww.voxel.draw.render;

import org.joml.Matrix4d;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import com.sww.voxel.draw.RawModel;
import com.sww.voxel.draw.entity.Entity;
import com.sww.voxel.draw.shader.StaticShader;
import com.sww.voxel.draw.texture.TexturedModel;
import com.sww.voxel.engine.utils.Maths;

public class Renderer {

    private final float red = 0.0307f;
    private final float green = 0.0154f;
    private final float blue = 0.0794f;
    
	public void prepare() {
		GL11.glClearColor(red, green, blue, 0.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}

	public void render(Entity quad, StaticShader shader) {
		TexturedModel texturedmodel = quad.getModel();
		RawModel model = quad.getRawModel();
		GL30.glBindVertexArray(model.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedmodel.getTexture().getTexID());
		Matrix4d trans = Maths.createTransformationMatrix(quad.getPosition(), quad.getRotX(), quad.getRotY(), quad.getScaleX(), quad.getScaleY());
		Vector3f colour = Maths.createColour(quad.getRed(), quad.getGreen(), quad.getBlue());
		Vector4f RGBA = Maths.updateColourAlpha(colour, quad.getAlpha());
		shader.loadTranslationMatrix(trans);
		shader.loadColourVector(colour, RGBA);
		GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL30.glBindVertexArray(0);
	}

}
