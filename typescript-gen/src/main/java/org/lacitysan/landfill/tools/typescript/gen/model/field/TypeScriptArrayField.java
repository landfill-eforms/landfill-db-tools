package org.lacitysan.landfill.tools.typescript.gen.model.field;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptType;

/**
 * @author Alvin Quach
 */
public class TypeScriptArrayField extends TypeScriptField {

	private TypeScriptType genericType;
	
	public TypeScriptArrayField(String fieldName) {
		super(fieldName);
	}

	public TypeScriptType getGenericType() {
		return genericType;
	}

	public void setGenericType(TypeScriptType genericType) {
		this.genericType = genericType;
	}

	@Override
	public Type getFieldType() {
		return Type.ARRAY;
	}

}
