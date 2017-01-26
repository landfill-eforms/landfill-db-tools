package org.lacitysan.landfill.tools.typescript.gen.model.field;

import org.lacitysan.landfill.tools.typescript.gen.model.clazz.TypeScriptSimpleType;
import org.lacitysan.landfill.tools.typescript.gen.model.clazz.TypeScriptType;
import org.lacitysan.landfill.tools.typescript.gen.model.enums.BasicType;

/**
 * @author Alvin Quach
 */
public class TypeScriptArrayField extends TypeScriptField {

	private TypeScriptType genericType;
	
	public TypeScriptArrayField(String fieldName) {
		super(fieldName);
	}

	public TypeScriptType getFieldType() {
		return new TypeScriptSimpleType(BasicType.ARRAY);
	}

	public TypeScriptType getGenericType() {
		return genericType;
	}

	public void setGenericType(TypeScriptType genericType) {
		this.genericType = genericType;
	}
	
}
