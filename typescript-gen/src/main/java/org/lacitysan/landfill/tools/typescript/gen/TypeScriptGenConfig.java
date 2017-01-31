package org.lacitysan.landfill.tools.typescript.gen;

import java.io.File;

/**
 * @author Alvin Quach
 */
public class TypeScriptGenConfig {

	public static final String[] CLASS_COMMENT = new String[] {
			"This %type was automatically generated from %classname.java using typescript-gen.", 
			"https://github.com/landfill-eforms/landfill-tools/tree/master/typescript-gen"
	};

	public static final boolean ADD_SPACES_TO_IMPORT = true;
	
	public static final String BASE_DIRECTORY = System.getProperty("user.dir") + File.separator + "output" + File.separator;

	public static final String BASE_PACKAGE = "org.lacitysan.landfill";

	public static final Class<?>[] BASE_CLASSES = new Class<?>[] {
		org.lacitysan.landfill.server.persistence.entity.User.class,
		org.lacitysan.landfill.server.persistence.entity.UserGroup.class,
		org.lacitysan.landfill.server.persistence.entity.MonitoringPoint.class
	};

}
