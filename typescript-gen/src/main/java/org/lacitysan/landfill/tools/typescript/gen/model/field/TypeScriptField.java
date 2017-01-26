package org.lacitysan.landfill.tools.typescript.gen.model.field;

import org.lacitysan.landfill.tools.typescript.gen.model.clazz.TypeScriptType;

/**
 * @author Alvin Quach
 */
public abstract class TypeScriptField {
	
	private String fieldName;

	public TypeScriptField(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	abstract public TypeScriptType getFieldType();
	
}
