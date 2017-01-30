package org.lacitysan.landfill.tools.typescript.gen.model.type;

import java.util.HashSet;
import java.util.Set;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;

public class TypeScriptComplexType extends TypeScriptType {
	
	private Class<?> clazz;
	
	private Set<TypeScriptComplexType> dependencies = new HashSet<>();

	public TypeScriptComplexType(Class<?> clazz, Type type) {
		super(type);
		this.clazz = clazz;
	}

	@Override
	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Set<TypeScriptComplexType> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<TypeScriptComplexType> dependencies) {
		this.dependencies = dependencies;
	}

}