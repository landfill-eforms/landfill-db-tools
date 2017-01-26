package org.lacitysan.landfill.tools.typescript.gen.model.clazz;

import org.lacitysan.landfill.tools.typescript.gen.model.enums.BasicType;

/**
 * @author Alvin Quach
 */
public class TypeScriptSimpleType extends TypeScriptType {

	private BasicType type;
	
	public TypeScriptSimpleType(BasicType type) {
		this.type = type;
	}

	public BasicType getType() {
		return type;
	}

	public void setType(BasicType type) {
		this.type = type;
	}
	
}