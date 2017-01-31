package org.lacitysan.landfill.tools.typescript.gen.model.type;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;

/**
 * @author Alvin Quach
 */
public abstract class TypeScriptType {
	
	protected Type type;
	
	protected TypeScriptType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	
	public abstract Class<?> getClazz();

}
