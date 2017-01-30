package org.lacitysan.landfill.tools.typescript.gen;

import java.util.HashSet;
import java.util.Set;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;
import org.lacitysan.landfill.tools.typescript.gen.model.field.TypeScirptObjectField;
import org.lacitysan.landfill.tools.typescript.gen.model.field.TypeScriptArrayField;
import org.lacitysan.landfill.tools.typescript.gen.model.field.TypeScriptEnumField;
import org.lacitysan.landfill.tools.typescript.gen.model.field.TypeScriptField;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptClass;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptComplexType;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptEnum;
import org.lacitysan.landfill.tools.typescript.gen.model.type.TypeScriptType;

/**
 * @author Alvin Quach
 */
public class TypeScriptGen {

	public static void main(String[] args) {
		Set<TypeScriptComplexType> generatedClasses = new HashSet<>();
		for (Class<?> clazz : TypeScriptGenConfig.BASE_CLASSES) {
			if (!generatedClasses.stream().anyMatch(c -> c.getClazz() == clazz)) {
				generatedClasses.add(TypeScriptGenUtils.processClass(clazz, generatedClasses));
			}
		}
		for (TypeScriptComplexType generatedClass : generatedClasses) {
			if (!(generatedClass instanceof TypeScriptClass || generatedClass instanceof TypeScriptEnum)) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			
			// Imported dependencies declarations.
			Set<TypeScriptComplexType> dependencies = generatedClass.getDependencies();
			for (TypeScriptComplexType dependency : dependencies) {
				sb.append("import {");
				sb.append(TypeScriptGenConfig.ADD_SPACES_TO_IMPORT ? " " : "");
				sb.append(dependency.getClazz().getSimpleName());
				sb.append(TypeScriptGenConfig.ADD_SPACES_TO_IMPORT ? " " : "");
				sb.append("} from '");
				sb.append(TypeScriptGenUtils.getRelativePath(generatedClass.getClazz(), dependency.getClazz()));
				sb.append(TypeScriptGenUtils.getFilename(dependency));
				sb.append("';\n");
			}
			
			// Auto-generated class comments.
			if (TypeScriptGenConfig.CLASS_COMMENT.length > 0) {
				sb.append("\n/**\n");
				for (String commentLine : TypeScriptGenConfig.CLASS_COMMENT) {
					sb.append(" * ");
					sb.append(commentLine
							.replaceAll("%type", generatedClass.getType() == Type.ENUM ? "enum" : "class")
							.replaceAll("%classname", generatedClass.getClazz().getSimpleName())
							.replaceAll("%filename", TypeScriptGenUtils.getFilename(generatedClass)));
					sb.append("\n");
				}
				sb.append(" */\n");
			}
			
			
			
			
			if (generatedClass instanceof TypeScriptClass) {
				// Export class declaration.
				sb.append("export class ");
				sb.append(generatedClass.getClazz().getSimpleName());
				sb.append(" {\n");
				
				// Fields
				for (TypeScriptField field : ((TypeScriptClass)generatedClass).getFields()) {
					sb.append("\t");
					sb.append(field.getFieldName());
					sb.append(":");
					if (field instanceof TypeScirptObjectField) {
						sb.append(((TypeScirptObjectField)field).getClassType().getClazz().getSimpleName());
					}
					else if (field instanceof TypeScriptEnumField) {
						sb.append(((TypeScriptEnumField)field).getEnumType().getClazz().getSimpleName());
					}
					else if (field instanceof TypeScriptArrayField) {
						TypeScriptType genericType = ((TypeScriptArrayField)field).getGenericType();
						if (genericType.getType() == Type.OBJECT || genericType.getType() == Type.ENUM) {
							sb.append(genericType.getClazz().getSimpleName());
						}
						else {
							sb.append(genericType.getType().name().toLowerCase());
						}
						sb.append("[]");
					}
					else {
						sb.append(field.getFieldType().name().toLowerCase());
					}
					sb.append(";\n");
				}
				
				// Closing bracket
				sb.append("}");
			}
			else if (generatedClass instanceof TypeScriptEnum) {
				// Export class declaration.
				sb.append("export class ");
				sb.append(generatedClass.getClazz().getSimpleName());
				sb.append(" {\n");
			}
			System.out.println(sb.toString());
		}
	}

}
