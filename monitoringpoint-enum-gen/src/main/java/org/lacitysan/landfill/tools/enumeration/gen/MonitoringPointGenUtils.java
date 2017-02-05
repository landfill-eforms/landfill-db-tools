package org.lacitysan.landfill.tools.enumeration.gen;

import org.lacitysan.landfill.server.model.MonitoringPointType;
import org.lacitysan.landfill.server.model.Site;

/**
 * @author Alvin Quach
 */
public class MonitoringPointGenUtils {
	
	public static Site getSiteByName(String name) {
		for (Site site : Site.values()) {
			if (site.getName().equals(name)) {
				return site;
			}
		}
		return null;
	}

	public static MonitoringPointType getMonitoringPointTypeByName(String name) {
		for (MonitoringPointType type : MonitoringPointType.values()) {
			if (type.getName().equals(name)) {
				return type;
			}
		}
		return null;
	}
	
}
