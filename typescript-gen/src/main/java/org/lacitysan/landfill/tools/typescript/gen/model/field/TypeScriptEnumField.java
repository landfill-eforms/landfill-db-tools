package org.lacitysan.landfill.tools.typescript.gen.model.field;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptEnum;

/**
 * @author Alvin Quach
 */
public class TypeScriptEnumField extends TypeScriptField {
	
	private TypeScriptEnum enumType;
	
	public TypeScriptEnumField(String fieldName) {
		super(fieldName);
	}
	
	public TypeScriptEnumField(String fieldName, TypeScriptEnum enumType) {
		super(fieldName);
		this.enumType = enumType;
	}

	public TypeScriptEnum getEnumType() {
		return enumType;
	}

	public void setEnumType(TypeScriptEnum enumType) {
		this.enumType = enumType;
	}

	@Override
	public Type getFieldType() {
		return Type.ENUM;
	}

}
