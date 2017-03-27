package org.lacitysan.landfill.tools.enumeration.gen.monitoringpoint.model;

import org.lacitysan.landfill.server.persistence.enums.MonitoringPointType;
import org.lacitysan.landfill.server.persistence.enums.Site;

/**
 * @author Alvin Quach
 */
public class MonitoringPointConstant implements Comparable<MonitoringPointConstant> {
	
	String constantName;
	String name;
	Site site;
	MonitoringPointType type;
	
	public MonitoringPointConstant(String constantName, String name, Site site, MonitoringPointType type) {
		this.constantName = constantName;
		this.name = name;
		this.site = site;
		this.type = type;
	}
	
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public MonitoringPointType getType() {
		return type;
	}
	public void setType(MonitoringPointType type) {
		this.type = type;
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
