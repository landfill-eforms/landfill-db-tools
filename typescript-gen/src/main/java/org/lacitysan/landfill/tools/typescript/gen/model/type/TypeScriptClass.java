package org.lacitysan.landfill.tools.typescript.gen.model.type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;
import org.lacitysan.landfill.tools.typescript.gen.model.field.TypeScriptField;

/**
 * @author Alvin Quach
 */
public class TypeScriptClass extends TypeScriptType {
	
	private List<TypeScriptField> fields = new ArrayList<>();
	
	private Class<?> clazz;
	
	private Set<TypeScriptClass> dependencies = new HashSet<>();
	
	public TypeScriptClass(Class<?> clazz) {
		super(Type.OBJECT);
		this.clazz = clazz;
	}

	public List<TypeScriptField> getFields() {
		return fields;
	}

	public void setFields(List<TypeScriptField> fields) {
		this.fields = fields;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Set<TypeScriptClass> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<TypeScriptClass> dependencies) {
		this.dependencies = dependencies;
	}
	
}
