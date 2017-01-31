package org.lacitysan.landfill.tools.typescript.gen.model.type;

import java.util.Set;
import java.util.TreeSet;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;
import org.lacitysan.landfill.tools.typescript.gen.model.constant.TypeScriptEnumConstant;

/**
 * @author Alvin Quach
 */
public class TypeScriptEnum extends TypeScriptClass {
	
	private Set<TypeScriptEnumConstant> constants = new TreeSet<>();
	
	public TypeScriptEnum(Class<?> clazz) {
		super(clazz);
		super.type = Type.ENUM;
	}

	public Set<TypeScriptEnumConstant> getConstants() {
		return constants;
	}

	public void setConstants(Set<TypeScriptEnumConstant> constants) {
		this.constants = constants;
	}
	
}
