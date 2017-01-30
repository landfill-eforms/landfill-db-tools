package org.lacitysan.landfill.tools.typescript.gen.model.field;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;

/**
 * @author Alvin Quach
 */
public class TypeScriptSimpleField extends TypeScriptField {

	private Type fieldType;
	
	public TypeScriptSimpleField(String fieldName) {
		super(fieldName);
	}
	
	public TypeScriptSimpleField(String fieldName, Type fieldType) {
		super(fieldName);
		this.fieldType = fieldType;
	}

	public Type getFieldType() {
		return fieldType;
	}

	public void setFieldType(Type fieldType) {
		this.fieldType = fieldType;
	}
	
}
