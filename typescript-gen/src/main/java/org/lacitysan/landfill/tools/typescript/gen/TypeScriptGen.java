package org.lacitysan.landfill.tools.typescript.gen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptClass;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptEnum;

/**
 * Enums currently only support strings, numbers, booleans, and other enums for its properties.
 * @author Alvin Quach
 */
public class TypeScriptGen {

	public static void main(String[] args) {
		Set<TypeScriptClass> generatedClasses = new HashSet<>();
		for (Class<?> clazz : TypeScriptGenConfig.BASE_CLASSES) {
			if (!generatedClasses.stream().anyMatch(c -> c.getClazz() == clazz)) {
				generatedClasses.add(TypeScriptGenUtils.processClass(clazz, generatedClasses));
			}
		}
		for (TypeScriptClass generatedClass : generatedClasses) {
			if (generatedClass instanceof TypeScriptEnum) {
				writeToFile(TypeScriptGenUtils.generateEnum((TypeScriptEnum)generatedClass), generatedClass);
			}
			else if (generatedClass instanceof TypeScriptClass) {
				writeToFile(TypeScriptGenUtils.generateClass((TypeScriptClass)generatedClass), generatedClass);
			}
		}
	}
	
	private static void writeToFile(String contents, TypeScriptClass type) {
		String filename = TypeScriptGenConfig.BASE_DIRECTORY;
		String[] path = type.getClazz().getPackage().getName().replaceFirst(TypeScriptGenConfig.BASE_PACKAGE + ".", "").split("\\.");
		for (String pathSegment : path) {
			filename += pathSegment + File.separator;
		}
		new File(filename).mkdirs();
		filename += TypeScriptGenUtils.getFilenameWithExtension(type);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			bw.write(contents);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(contents);
	}

}
