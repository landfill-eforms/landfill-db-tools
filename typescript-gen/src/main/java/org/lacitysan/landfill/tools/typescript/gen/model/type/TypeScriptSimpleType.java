package org.lacitysan.landfill.tools.typescript.gen.model.type;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;

public class TypeScriptSimpleType extends TypeScriptType {

	public TypeScriptSimpleType(Type type) {
		super(type);
	}

	@Override
	public Class<?> getClazz() {
		return null;
	}

}
