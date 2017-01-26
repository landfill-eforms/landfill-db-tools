package org.lacitysan.landfill.tools.typescript.gen;

import java.util.HashSet;
import java.util.Set;

import org.lacitysan.landfill.tools.typescript.gen.model.clazz.TypeScriptClass;

/**
 * @author Alvin Quach
 */
public class TypeScriptGen {
	
	private static final String BASE_DIRECTORY = "";
	
	private static final String BASE_PACKAGE = "org.lacitysan.landfill";
	
	private static final Class<?>[] BASE_CLASSES = new Class<?>[] {
		org.lacitysan.landfill.server.persistence.entity.User.class,
		org.lacitysan.landfill.server.persistence.entity.UserGroup.class
	};
	
	public static void main(String[] args) {
		
		Set<TypeScriptClass> generatedClasses = new HashSet<>();
		
		for (Class<?> clazz : BASE_CLASSES) {
			generatedClasses.add(processClass(clazz));
		}
		
	}
	
	private static TypeScriptClass processClass(Class<?> clazz) {
		TypeScriptClass result = new TypeScriptClass(clazz.getName());
		return result;
	}

}
