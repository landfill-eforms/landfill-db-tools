package org.lacitysan.landfill.tools.typescript.gen.model.clazz;

import java.util.HashSet;
import java.util.Set;

import org.lacitysan.landfill.tools.typescript.gen.model.field.TypeScriptField;

/**
 * @author Alvin Quach
 */
public class TypeScriptClass {
	
	private String className;
	
	private String packageName;
	
	private Set<TypeScriptClass> dependencies = new HashSet<>();
	
	private Set<TypeScriptField> fields = new HashSet<>();
	
	public TypeScriptClass(String fullyQualifiedName) {
		int lastPeriodIndex = fullyQualifiedName.lastIndexOf('.');
		this.className = fullyQualifiedName.substring(lastPeriodIndex + 1);
		this.packageName = fullyQualifiedName.substring(0, lastPeriodIndex);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Set<TypeScriptClass> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<TypeScriptClass> dependencies) {
		this.dependencies = dependencies;
	}

	public Set<TypeScriptField> getFields() {
		return fields;
	}

	public void setFields(Set<TypeScriptField> fields) {
		this.fields = fields;
	}
	
	public String getFullyQualifiedName() {
		return packageName + className;
	}
	
}
