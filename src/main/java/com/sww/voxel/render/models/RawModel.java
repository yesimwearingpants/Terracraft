package com.sww.voxel.render.models;

public class RawModel {
	
	private int vaoID;
	private int vertexCount;
	
	public RawModel(int vao, int vertices) {
		this.vaoID = vao;
		this.vertexCount = vertices;
	}

	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	
	

}
