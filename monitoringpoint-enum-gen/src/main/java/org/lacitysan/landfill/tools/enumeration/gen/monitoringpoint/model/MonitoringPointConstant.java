package org.lacitysan.landfill.tools.enumeration.gen.monitoringpoint.model;

import org.lacitysan.landfill.server.persistence.enums.MonitoringPointType;
import org.lacitysan.landfill.server.persistence.enums.Site;

/**
 * @author Alvin Quach
 */
public class MonitoringPointConstant implements Comparable<MonitoringPointConstant> {
	
	private String constantName;
	private String name;
	private Site site;
	private MonitoringPointType type;
	
	public MonitoringPointConstant(String constantName, String name, Site site, MonitoringPointType type) {
		this.constantName = constantName;
		this.name = name;
		this.site = site;
		this.type = type;
	}
	
	public String getConstantName() {
		return constantName;
	}
	public String getName() {
		return name;
	}
	public Site getSite() {
		return site;
	}
	public MonitoringPointType getType() {
		return type;
	}

	@Override
	public int compareTo(MonitoringPointConstant o) {
		
		// Compare by monitoring point type.
		if (type != o.getType()) {
			return type.getName().compareTo(o.getType().getName());
		}
		
		// Compare by site.
		if (site != o.getSite()) {
			return site.getName().compareTo(o.getSite().getName());
		}
		
		// If the names are non-negative integers, then compare them as integers.
		if (name.matches("^\\d+$") && o.getName().matches("^\\d+$")) {
			return Integer.parseInt(name) - Integer.parseInt(o.getName());
		}
		
		// If the names consist of the same letter followed by a non-negative integer, then compare them as integers.
		if (name.matches("([A-Z])\\d+$") && o.getName().matches("([A-Z])\\d+$") && name.charAt(0) == o.getName().charAt(0)) {
			return Integer.parseInt(name.substring(1)) - Integer.parseInt(o.getName().substring(1));
		}
		
		// Compare as strings.
		return name.compareTo(o.getName());
		
	}

}
