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
 * Created June 17, 2015
 */
package com.sww.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.Logger;

//Find a Better Way
public class LogFile {
	
	private final FileWriter writer;
	private Logger logger = Logging.log.getLogger();

	public LogFile(String modid) throws IOException {
		writer = new FileWriter(modid, true);
		StringBuilder builder = new StringBuilder();
		builder.append(logger);
		writer.write(builder.toString());
	}

	public LogFile(File log) throws IOException {
		writer = new FileWriter(log, true);
		StringBuilder builder = new StringBuilder();
		builder.append(logger);
		writer.write(builder.toString());
	}

}
