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
 * Created June 15, 2015
 */
package com.sww.voxel.lang;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {

	public final ResourceBundle lang;
	
	public I18n() {
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", Locale.getDefault());
	}

	public I18n(String lang, String country) {
		Locale locale = new Locale(lang, country);
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", locale);
	}
	
	public I18n(Locale locale) {
		this.lang = ResourceBundle.getBundle("com.sww.launcher.lang.", locale);
	}

	

}
