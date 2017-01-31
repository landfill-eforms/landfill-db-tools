package org.lacitysan.landfill.tools.typescript.gen.model.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alvin Quach
 */
public class TypeScriptEnumConstant implements Comparable<TypeScriptEnumConstant> {
	
	private String name;
	
	private Integer ordinal;
	
	private Map<String, Object> properties = new HashMap<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	@Override
	public int compareTo(TypeScriptEnumConstant o) {
		return ordinal - o.getOrdinal();
	}

}
