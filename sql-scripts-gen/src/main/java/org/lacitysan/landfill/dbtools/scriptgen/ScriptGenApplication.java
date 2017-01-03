package org.lacitysan.landfill.dbtools.scriptgen;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ScriptGenApplication {

	public static void main(String[] args) {

		try {
			
			XSSFWorkbook siteTypeWorkbook = new XSSFWorkbook(new File("D:\\Alvin\\Downloads\\Site and type list.xlsx")); // TODO Un-hardcode the filepath.
			XSSFSheet siteTypeWorksheet = siteTypeWorkbook.getSheetAt(0);
			SiteTypeScriptGen asdf = new SiteTypeScriptGen(siteTypeWorksheet);
			
			// TEST
			System.out.println(asdf.getPointScript(false));
			
			siteTypeWorkbook.close();
			
			// TODO Output file(s).

		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
			return;
		} 

	}

}
