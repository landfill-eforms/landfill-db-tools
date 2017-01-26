package org.lacitysan.landfill.tools.typescript.gen.model.field;

import org.lacitysan.landfill.tools.typescript.gen.model.clazz.TypeScriptType;

/**
 * @author Alvin Quach
 */
public class TypeScriptSimpleField extends TypeScriptField {

	private TypeScriptType fieldType;
	
	public TypeScriptSimpleField(String fieldName) {
		super(fieldName);
	}

	public TypeScriptType getFieldType() {
		return fieldType;
	}

	public void setFieldType(TypeScriptType fieldType) {
		this.fieldType = fieldType;
	}
	
}
