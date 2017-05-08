package org.lacitysan.landfill.tools.typescript.gen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptClass;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptEnum;

/**
 * Enums currently only support strings, numbers, booleans, and other enums for its properties.
 * @author Alvin Quach
 */
public class TypeScriptGen {
	
	private static String baseDirectory = TypeScriptGenConfig.BASE_DIRECTORY;

	public static void main(String[] args) {
		if (args.length > 0) {
			baseDirectory = args[0] + File.separator;
		}
		Set<TypeScriptClass> generatedClasses = new TreeSet<>();
		for (Class<?> clazz : TypeScriptGenConfig.BASE_CLASSES) {
			if (!generatedClasses.stream().anyMatch(c -> c.getClazz() == clazz)) {
				generatedClasses.add(TypeScriptGenUtils.processClass(clazz, generatedClasses));
			}
		}
		for (TypeScriptClass generatedClass : generatedClasses) {
			if (generatedClass instanceof TypeScriptEnum) {
				writeToFile(TypeScriptGenUtils.generateEnum((TypeScriptEnum)generatedClass, true, true), generatedClass);
			}
			else if (generatedClass instanceof TypeScriptClass) {
				writeToFile(TypeScriptGenUtils.generateClass((TypeScriptClass)generatedClass), generatedClass);
			}
		}
	}
	
	private static void writeToFile(String contents, TypeScriptClass type) {
		String filename = baseDirectory;
		String[] path = type.getClazz().getPackage().getName().replaceFirst(TypeScriptGenConfig.BASE_PACKAGE + ".", "").split("\\.");
		for (String pathSegment : path) {
			filename += pathSegment + File.separator;
		}
		new File(filename).mkdirs();
		filename += TypeScriptGenUtils.getFilenameWithExtension(type);
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, false))) {
			bw.write(contents);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(contents);
	}

}
