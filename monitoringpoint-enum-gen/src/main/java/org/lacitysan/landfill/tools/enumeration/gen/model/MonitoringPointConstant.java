package org.lacitysan.landfill.tools.enumeration.gen.model;

import org.lacitysan.landfill.server.model.MonitoringPointType;
import org.lacitysan.landfill.server.model.Site;

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
		if (type != o.getType()) {
			return type.getName().compareTo(o.getType().getName());
		}
		if (site != o.getSite()) {
			return site.getName().compareTo(o.getSite().getName());
		}
		if (name.matches("^-?\\d+$") && o.getName().matches("^-?\\d+$")) {
			return Integer.parseInt(name) - Integer.parseInt(o.getName());
		}
		return name.compareTo(o.getName());
	}

}
