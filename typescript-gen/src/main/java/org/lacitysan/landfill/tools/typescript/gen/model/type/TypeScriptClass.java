package org.lacitysan.landfill.tools.typescript.gen.model.type;

import java.util.HashSet;
import java.util.Set;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;
import org.lacitysan.landfill.tools.typescript.gen.model.field.TypeScriptField;

/**
 * @author Alvin Quach
 */
public class TypeScriptClass extends TypeScriptComplexType {
	
	private Set<TypeScriptField> fields = new HashSet<>();
	
	public TypeScriptClass(Class<?> clazz) {
		super(clazz, Type.OBJECT);
	}

	public Set<TypeScriptField> getFields() {
		return fields;
	}

	public void setFields(Set<TypeScriptField> fields) {
		this.fields = fields;
	}
	
}
