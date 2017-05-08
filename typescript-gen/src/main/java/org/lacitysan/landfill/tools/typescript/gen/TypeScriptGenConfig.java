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
	
	public static final String[] AOT_FIX_COMMENT = new String[] {
			"This %type includes a fix for the Ahead-of-Time (AoT) compile bug which prevents compilation if a constructor has to be called within a static variable from a different class.", 
			"As a result, this %type doesn't have a constructor, and its constants are declared directly instead of through a constructor."
	};

	public static final boolean ADD_SPACES_TO_IMPORT = true;
	
	public static final String BASE_DIRECTORY = System.getProperty("user.dir") + File.separator + "output" + File.separator;

	public static final String BASE_PACKAGE = "org.lacitysan.landfill";

	public static final Class<?>[] BASE_CLASSES = new Class<?>[] {
		org.lacitysan.landfill.server.persistence.entity.email.EmailRecipient.class,
		org.lacitysan.landfill.server.persistence.entity.instrument.Instrument.class,
		org.lacitysan.landfill.server.persistence.entity.instrument.InstrumentType.class,
		org.lacitysan.landfill.server.persistence.entity.probe.ProbeData.class,
		org.lacitysan.landfill.server.persistence.entity.report.IndividualReportQuery.class,
		org.lacitysan.landfill.server.persistence.entity.report.ScheduledReportQuery.class,
		org.lacitysan.landfill.server.persistence.entity.scheduled.Schedule.class,
		org.lacitysan.landfill.server.persistence.entity.scheduled.ScheduledNotification.class,
		org.lacitysan.landfill.server.persistence.entity.scheduled.ScheduledReport.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.instantaneous.ImeData.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.instantaneous.ImeNumber.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.instantaneous.ImeRepairData.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.instantaneous.InstantaneousData.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.instantaneous.WarmspotData.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.integrated.IntegratedData.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.integrated.IseData.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.integrated.IseNumber.class,
		org.lacitysan.landfill.server.persistence.entity.surfaceemission.integrated.IseRepairData.class,
		org.lacitysan.landfill.server.persistence.entity.unverified.UnverifiedDataSet.class,
		org.lacitysan.landfill.server.persistence.entity.unverified.UnverifiedInstantaneousData.class,
		org.lacitysan.landfill.server.persistence.entity.user.User.class,
		org.lacitysan.landfill.server.persistence.entity.user.UserActivity.class,
		org.lacitysan.landfill.server.persistence.entity.user.UserGroup.class,
		org.lacitysan.landfill.server.service.report.model.ExceedanceReport.class,
		org.lacitysan.landfill.server.service.report.model.InstantaneousReport.class,
		org.lacitysan.landfill.server.service.report.model.IntegratedReport.class,
		org.lacitysan.landfill.server.service.report.model.ProbeReport.class
	};
	
	/** 
	 * Enum classes that will include the temporary AoT compile fix, which forces the enums to always declare its constants directly instead of using a constructor.
	 * Remove when the fix is not longer necessary. 
	 */
	public static final Class<?>[] AOT_CLASSES = new Class<?>[] {
		org.lacitysan.landfill.server.persistence.enums.user.UserPermission.class
	};
	
	/** 
	 * Whether to use a constructor to declare static constants instead of declaring the constants as objects directly. 
	 * Only applies to enum classes.
	 */
	public static final boolean USE_CONSTRUCTOR = false;

}
