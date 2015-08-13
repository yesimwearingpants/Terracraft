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

package com.sww.voxel.engine.utils;

/**
 * The Class ColourHelper converts hexcodes and RGB floats, bytes, or integers.
 * @param <E>
 */
public class ColourHelper {

	private static ByteRGB bRGB;
	private static FloatRGB fRGB;
	private static IntegerRGB iRGB;
	private static HexColour hex;

	private static class ByteRGB {
		private Byte red, green, blue;

		private ByteRGB(byte r, byte g, byte b) {
			this.red = r;
			this.green = g;
			this.blue = b;
		}

		public Byte getRed() {
			return red;
		}

		public Byte getGreen() {
			return green;
		}

		public Byte getBlue() {
			return blue;
		}
	}

	private static class FloatRGB {
		private Float red, green, blue;

		private FloatRGB(float r, float g, float b) {
			this.red = r;
			this.green = g;
			this.blue = b;
		}

		private Float getRed() {
			return red;
		}

		private Float getGreen() {
			return green;
		}

		private Float getBlue() {
			return blue;
		}
	}

	private static class IntegerRGB {
		private Integer red, green, blue;

		private IntegerRGB(int r, int g, int b) {
			this.red = r;
			this.green = g;
			this.blue = b;
		}

		private Integer getRed() {
			return red;
		}

		private Integer getGreen() {
			return green;
		}

		private Integer getBlue() {
			return blue;
		}
	}

	private static class HexColour {
		private String hexColour;

		private HexColour(int colour) {
			this.hexColour = Integer.toHexString(colour);
		}

		private HexColour(String colour) {
			this.hexColour =  colour;
		}

		public String getHexColour() {
			return hexColour;
		}
	}

	private static HexColour createHexColour(int colour) {
		return new HexColour(colour);
	}

	private static FloatRGB createFloatRGB(float r, float g, float b) {
		return new FloatRGB(r, g, b);
	}

	private static ByteRGB createByteRGB(byte r, byte g, byte b) {
		return new ByteRGB(r, g, b);
	}

	private static IntegerRGB createIntegerRGB(int r, int g, int b) {
		return new IntegerRGB(r, g, b);
	}

	public static void setHexColour(float r, float g, float b) {
		int hr = (int) (r * 255);
		int hg = (int) (g * 255);
		int hb = (int) (b * 255);
		String sHex = String.format("#%02x%02x%02x", hr, hg, hb);
		hex = createHexColour(Integer.valueOf(sHex, 16));
	}

	public static void setHexColour(byte r, byte g, byte b) {
		String sHex = String.format("#%02x%02x%02x", r, g, b);
		hex = createHexColour(Integer.valueOf(sHex, 16));
	}

	public static void setHexColour(int r, int g, int b) {
		String sHex = String.format("#%02x%02x%02x", r, g, b);
		hex = createHexColour(Integer.valueOf(sHex, 16));
	}

	public static void setFloatColour(byte r, byte g, byte b) {
		fRGB = createFloatRGB((float) (r / 255), (float) (g / 255), (float) (b / 255));
	}

	public static void setFloatColour(int r, int g, int b) {
		fRGB = createFloatRGB((float) (r / 255), (float) (g / 255), (float) (b / 255));
	}

	public static void setFloatColour(int hexColour) {
		hex = new HexColour(hexColour);
		fRGB = createFloatRGB(Float.valueOf(Integer.valueOf(hex.hexColour.substring(3, 5), 16) / 255),
			Float.valueOf(Integer.valueOf(hex.getHexColour().substring(5, 7), 16) / 255),
			Float.valueOf(Integer.valueOf(hex.getHexColour().substring(7, 9), 16) / 255));
		
	}

	public static void setByteColour(int hexColour) {
		hex = new HexColour(hexColour);
		bRGB = createByteRGB(Byte.valueOf(hex.hexColour.substring(3, 5), 16),
			Byte.valueOf(hex.getHexColour().substring(5, 7), 16),
			Byte.valueOf(hex.getHexColour().substring(7, 9), 16));
	}

	public static void setByteColour(float r, float g, float b) {
		bRGB = createByteRGB((byte) (r * 255), (byte) (g * 255), (byte) (b * 255));
	}

	public static void setByteColour(int r, int g, int b) {
		bRGB = createByteRGB((byte) r, (byte) g, (byte) b);
	}

	public static void setIntegerColour(int hexColour) {
		hex = new HexColour(hexColour);
		iRGB = createIntegerRGB(Integer.valueOf(hex.hexColour.substring(3, 5), 16),
			Integer.valueOf(hex.getHexColour().substring(5, 7), 16),
			Integer.valueOf(hex.getHexColour().substring(7, 9), 16));
	}

	public static void setIntegerColour(float r, float g, float b) {
		iRGB = createIntegerRGB((int) (r * 255), (int) (g * 255), (int) (b * 255));
	}

	public static void setIntegerColour(byte r, byte g, byte b) {
		iRGB = createIntegerRGB((int) r, (int) g, (int) b);
	}

	public static HexColour getHexColour() {
		return hex;
	}

	public static FloatRGB getFloatRGB() {
		return fRGB;
	}

	public static ByteRGB getByteRGB() {
		return bRGB;
	}

	public static IntegerRGB getIntegerRGB() {
		return iRGB;
	}

	@SuppressWarnings("unchecked")
	public <E> E getRed() {
		if(fRGB.getRed() != null) {
			return (E) fRGB.getRed();
		} else if(bRGB.getRed() != null) {
			return (E) bRGB.getRed();
		} else if(iRGB.getRed() != null) {
			return (E) iRGB.getRed();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <E> E getGreen() {
		if(fRGB.getGreen() != null) {
			return (E) fRGB.getGreen();
		} else if(bRGB.getGreen() != null) {
			return (E) bRGB.getGreen();
		} else if(iRGB.getGreen() != null) {
			return (E) iRGB.getGreen();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <E> E getBlue() {
		if(fRGB.getBlue() != null) {
			return (E) fRGB.getBlue();
		} else if(bRGB.getBlue() != null) {
			return (E) bRGB.getBlue();
		} else if(iRGB.getBlue() != null) {
			return (E) iRGB.getBlue();
		}
		return null;
	}

	public int getColour() {
		int iHex = Integer.valueOf(hex.getHexColour(), 16);
		return iHex;
	}

}
