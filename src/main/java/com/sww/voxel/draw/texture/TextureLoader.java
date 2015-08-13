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
 * Created Jul 7, 2015
 */
package com.sww.voxel.draw.texture;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.BufferUtils;

import de.matthiasmann.twl.utils.PNGDecoder;

public class TextureLoader {

	protected int target = GL11.GL_TEXTURE_2D;
	
	protected int id;
	protected int width;
	protected int height;

    public static enum Filter {
        NEAREST(GL11.GL_NEAREST),
        LINEAR(GL11.GL_LINEAR);

        final int glValue;
        Filter(int value) {
            this.glValue = value;
        }
    }

    public static enum Wrap {
		CLAMP(GL11.GL_CLAMP),
		CLAMP_TO_EDGE(GL12.GL_CLAMP_TO_EDGE),
		REPEAT(GL11.GL_REPEAT);

		final int glValue;
		Wrap(int value) {
			this.glValue = value;
		}
    }

    public static enum Format {
        ALPHA(GL11.GL_ALPHA, GL11.GL_ALPHA8, PNGDecoder.Format.ALPHA),
        LUMINANCE(GL11.GL_LUMINANCE, GL11.GL_LUMINANCE8, PNGDecoder.Format.LUMINANCE),
        LUMINANCE_ALPHA(GL11.GL_LUMINANCE_ALPHA, GL11.GL_LUMINANCE8_ALPHA8, PNGDecoder.Format.LUMINANCE_ALPHA),
        RGB(GL11.GL_RGB, GL11.GL_RGB8, PNGDecoder.Format.RGB),
        RGB_SMALL(GL11.GL_RGB, GL11.GL_RGB5_A1, PNGDecoder.Format.RGB),
        RGBA(GL11.GL_RGBA, GL11.GL_RGBA8, PNGDecoder.Format.RGBA),
        BGRA(GL12.GL_BGRA, GL11.GL_RGBA8, PNGDecoder.Format.BGRA),
        ABGR(0x8000, GL11.GL_RGBA8, PNGDecoder.Format.ABGR),
        COLOR(-1, -1, null);

        final int glFormat;
        final int glInternalFormat;
        final PNGDecoder.Format pngFormat;

        Format(int fmt, int ifmt, PNGDecoder.Format pf) {
            this.glFormat = fmt;
            this.glInternalFormat = ifmt;
            this.pngFormat = pf;
        }

        public int getPixelSize() {
            return pngFormat.getNumComponents();
        }

        public PNGDecoder.Format getPngFormat() {
            return pngFormat;
        }
    }

	public TextureLoader(Path source) {
		this(source, Filter.NEAREST);
	}

	public TextureLoader(Path source, Filter filter) {
		this(source, filter, Wrap.CLAMP_TO_EDGE, Format.RGBA);
	}

	public TextureLoader(Path source, Filter filter, Wrap wrap) {
		this(source, filter, wrap, Format.RGBA);
	}

	public TextureLoader(Path source, Filter filter, Wrap wrap, Format fmt) {
		try (PNGDecoder decoder = new PNGDecoder(new FileInputStream(source.toFile()))){
			int width = decoder.getWidth();
			int heigth = decoder.getHeight();
			final int BPP = 4;
			ByteBuffer buffer = BufferUtils.createByteBuffer(BPP * width * heigth);
			decoder.decode(buffer, width * BPP, fmt.pngFormat);
			buffer.flip();
			
			GL11.glEnable(target);
			id = GL11.glGenTextures();

			bind();
			setFilter(filter);
			setWrap(wrap);
			upload(fmt, buffer);
		} catch (FileNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
			e.printStackTrace();
		} catch (IOException e1) {
			System.err.println(e1.getLocalizedMessage());
			e1.printStackTrace();
		} catch (Exception e2) {
			System.err.println(e2.getLocalizedMessage());
			e2.printStackTrace();
		}
	}
	
	/** Creates an empty OpenGL texture with the given width and height, where
	 * each pixel is transparent black (0, 0, 0, 0) and the wrap mode is
	 * CLAMP_TO_EDGE and the filter is NEAREST.
	 * 
	 * @param width the width of the texture
	 * @param height the height of the texture */
	public TextureLoader(int width, int height) {
		this(width, height, Filter.NEAREST);
	}

	/** Creates an empty OpenGL texture with the given width and height, where
	 * each pixel is transparent black (0, 0, 0, 0) and the wrap mode is
	 * CLAMP_TO_EDGE.
	 * 
	 * @param width the width of the texture
	 * @param height the height of the texture
	 * @param filter the filter to use */
	public TextureLoader(int width, int height, Filter filter) {
		this(width, height, filter, Wrap.CLAMP_TO_EDGE);
	}

	/** Creates an empty OpenGL texture with the given width and height, where
	 * each pixel is transparent black (0, 0, 0, 0).
	 * 
	 * @param width the width of the texture
	 * @param height the height of the texture
	 * @param filter the filter to use
	 * @param wrap the wrap mode to use */
	public TextureLoader(int width, int height, Filter filter, Wrap wrap) {
		GL11.glEnable(target);
		id = GL11.glGenTextures();
		this.width = width;
		this.height = height;
		bind();
		setFilter(filter);
		setWrap(wrap);
		ByteBuffer buf = BufferUtils.createByteBuffer(width * height * 4);
		upload(Format.RGBA, buf);
	}

	public int getID() {
		return id;
	}

	protected void setUnpackAlignment() {
		GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
		GL11.glPixelStorei(GL11.GL_PACK_ALIGNMENT, 1);
	}

	/** Uploads image data with the dimensions of this Texture.
	 * 
	 * @param fmt the format, e.g. (Format.RGBA = GL_RGBA)
	 * @param data the byte data */
	private void upload(Format fmt, ByteBuffer data) {
		bind();
		setUnpackAlignment();
		GL11.glTexImage2D(target, 0, fmt.glInternalFormat, width, height, 0, fmt.glFormat, GL11.GL_UNSIGNED_BYTE, data);
	}

	/** Uploads a sub-image within this texture.
	 * 
	 * @param x the destination x offset
	 * @param y the destination y offset, with lower-left origin
	 * @param width the width of the sub image data
	 * @param height the height of the sub image data
	 * @param dataFormat the format of the sub image data, e.g. GL_RGBA
	 * @param data the sub image data */
	public void upload(int x, int y, int width, int height, Format fmt, ByteBuffer data) {
		bind();
		setUnpackAlignment();
		GL11.glTexSubImage2D(target, 0, x, y, width, height, fmt.glFormat, GL11.GL_UNSIGNED_BYTE, data);
	}

	private void setFilter(Filter filter) {
		bind();
		GL11.glTexParameteri(target, GL11.GL_TEXTURE_MIN_FILTER, filter.glValue);
		GL11.glTexParameteri(target, GL11.GL_TEXTURE_MAG_FILTER, filter.glValue);
	}

	private void setWrap(Wrap wrap) {
		bind();
		GL11.glTexParameteri(target, GL11.GL_TEXTURE_WRAP_S, wrap.glValue);
		GL11.glTexParameteri(target, GL11.GL_TEXTURE_WRAP_T, wrap.glValue);
	}

	private void bind() {
		if (!valid())
			throw new IllegalStateException("trying to bind a texture that was disposed");
		GL11.glBindTexture(target, id);
	}
	
	public void dispose() {
		if (valid()) {
			GL11.glDeleteTextures(id);
			id = 0;
		}
	}
	
	/**
	 * Returns true if this texture has not been disposed.
	 * @return true if id!=0
	 */
	private boolean valid() {
		return id!=0;
	}

	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}

	public TextureLoader getTexture() {
		return this;
	}

	public float getU() {
		return 0f;
	}

	public float getV() {
		return 0f;
	}

	public float getU2() {
		return 1f;
	}

	public float getV2() {
		return 1f;
	}
}