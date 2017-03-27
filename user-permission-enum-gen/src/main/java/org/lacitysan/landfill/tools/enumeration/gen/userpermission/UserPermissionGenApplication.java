package org.lacitysan.landfill.tools.enumeration.gen.userpermission;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.lacitysan.landfill.server.persistence.enums.UserPermission;
import org.lacitysan.landfill.tools.enumeration.gen.userpermission.model.UserPermissionConstant;

/**
 * @author Alvin Quach
 */
public class UserPermissionGenApplication {
	
	/** The package of the generated enum. This is set to the same package as the Site enum. */
	private static final String PACKAGE = UserPermission.class.getPackage().getName();
	
	/** The name of the generated enum. */
	private static final String CLASS_NAME = UserPermission.class.getSimpleName();
	
	/** The base output path of the generate enum class. Set this to the <code>src/main/java</code> directory of the server project. */
	private static final String OUTPUT_BASE_PATH = "D:\\Eclipse Workspaces\\Landfill-eForms\\landfill-web-app\\server\\src\\main\\java";
	
	private static final String WORKSHEET_PATH = "D:\\Alvin\\Downloads\\Roles.xlsx";
	
	public static void main(String[] args) {
		
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook(new File(WORKSHEET_PATH));
			XSSFSheet worksheet = workbook.getSheetAt(0);
			
			Set<UserPermissionConstant> userPermissionConstants = parse(worksheet);
			
			writeToFile(generateEnumClass(userPermissionConstants));
			
			workbook.close();

		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
			return;
		} 
		
	}
	
	static Set<UserPermissionConstant> parse(XSSFSheet worksheet) {
		Set<UserPermissionConstant> result = new TreeSet<>();
		for (Row row : worksheet) {
			// TODO Implement this.
		}
		return result;
	}
	
	static String generateEnumClass(Collection<UserPermissionConstant> constants) {
		
		// Create new string builder with package declaration.
		StringBuilder sb = new StringBuilder("package " + PACKAGE + ";");
		
		return sb.toString();
		
	}
	
	static void writeToFile(String contents) {
		String relativePath = PACKAGE.replace(".", File.separator);
		String filePath = OUTPUT_BASE_PATH + File.separator + relativePath;
		System.out.println("OUTPUT PATH: " + filePath + "\n");
		new File(filePath).mkdirs();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath + File.separator + CLASS_NAME + ".java", false))) {
			bw.write(contents);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(contents);
	}

}
