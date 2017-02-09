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
		org.lacitysan.landfill.server.persistence.entity.instantaneous.IMEData.class,
		org.lacitysan.landfill.server.persistence.entity.instantaneous.IMENumber.class,
		org.lacitysan.landfill.server.persistence.entity.instantaneous.IMERepairData.class,
		org.lacitysan.landfill.server.persistence.entity.instantaneous.InstantaneousData.class,
		org.lacitysan.landfill.server.persistence.entity.instrument.Instrument.class,
		org.lacitysan.landfill.server.persistence.entity.unverified.UnverifiedDataSet.class,
		org.lacitysan.landfill.server.persistence.entity.unverified.UnverifiedIMEData.class,
		org.lacitysan.landfill.server.persistence.entity.unverified.UnverifiedInstantaneousData.class,
		org.lacitysan.landfill.server.persistence.entity.user.User.class,
		org.lacitysan.landfill.server.persistence.entity.user.UserGroup.class,
		org.lacitysan.landfill.server.persistence.entity.user.Person.class
	};

}
