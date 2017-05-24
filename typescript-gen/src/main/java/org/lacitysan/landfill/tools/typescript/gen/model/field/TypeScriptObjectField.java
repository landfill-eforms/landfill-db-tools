package org.lacitysan.landfill.tools.typescript.gen.model.field;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptClass;

/**
 * @author Alvin Quach
 */
public class TypeScriptObjectField extends TypeScriptField {
	
	private TypeScriptClass classType;
	
	public TypeScriptObjectField(String fieldName) {
		super(fieldName);
	}
	
	public TypeScriptObjectField(String fieldName, TypeScriptClass classType) {
		super(fieldName);
		this.classType = classType;
	}

	public TypeScriptClass getClassType() {
		return classType;
	}

	public void setClassType(TypeScriptClass classType) {
		this.classType = classType;
	}

	@Override
	public Type getFieldType() {
		return Type.OBJECT;
	}
	
}
