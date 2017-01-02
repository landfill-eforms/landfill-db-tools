package org.lacitysan.landfill.dbtools.scriptgen;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.lacitysan.landfill.lib.MonitoringPointType;
import org.lacitysan.landfill.lib.Site;

/**
 * Generates the SQL scripts to create and pre-populate the Sites, MonitoringPoints, 
 * and MonitoringPointTypes tables using the Excel spreadsheet that contains sites and types.
 * @author Alvin Quach
 *
 */
public class SiteTypeScriptGen {

	private XSSFSheet siteTypeWorksheet;

	// TODO Move table names to a constant class.
	private String siteTableName;
	private String typeTableName;
	private String pointTableName;

	public SiteTypeScriptGen(XSSFSheet siteTypeWorksheet, String siteTableName, String typeTableName, String pointTableName) {
		this.siteTypeWorksheet = siteTypeWorksheet;
		this.siteTableName = siteTableName;
		this.typeTableName = typeTableName;
		this.pointTableName = pointTableName;
	}

	public String getSiteScript(boolean includePK) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO dbo." + siteTableName + " (");
		if (includePK) {
			sb.append(removeLastS(siteTableName) + "PK, ");
		}
		sb.append("SiteName, ShortName, SiteType, Active)")
		.append("\n")
		.append("VALUES")
		.append("\n\n");
		Site[] sites = Site.values();
		for (Site site : sites) {
			sb.append("\t(");
			if (includePK) {
				sb.append((site.ordinal() + 1) + ", ");
			}
			sb.append("'" + site.getName() + "', '" + site.getShortName() + "', '" + site.getType() + "', " + (site.isActive() ? 1 : 0) + ")");
			sb.append(site.ordinal() + 1 == sites.length ?  ";\n" : ",\n");
		}
		return sb.toString();
	}

	public String getTypeScript(boolean includePK) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO dbo." + typeTableName + " (");
		if (includePK) {
			sb.append(removeLastS(typeTableName) + "PK, ");
		}
		sb.append("TypeName)")
		.append("\n")
		.append("VALUES")
		.append("\n\n");
		MonitoringPointType[] types = MonitoringPointType.values();
		for (MonitoringPointType type : types) {
			sb.append("\t(");
			if (includePK) {
				sb.append((type.ordinal() + 1) + ", ");
			}
			sb.append("'" + type.getName() + "')");
			sb.append(type.ordinal() + 1 == types.length ?  ";\n" : ",\n");
		}
		return sb.toString();
	}

	public String getPointScript(boolean includePK) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO dbo." + pointTableName + " (");
		if (includePK) {
			sb.append(removeLastS(pointTableName) + "PK, ");
		}
		sb.append("MonitoringPointName, " + removeLastS(typeTableName) + "FK, " + removeLastS(siteTableName) + "FK)")
		.append("\n")
		.append("VALUES")
		.append("\n\n");
		int rowIndex = 0;
		for (Row row : siteTypeWorksheet) {
			if (rowIndex++ == 0) {
				continue;
			}
			sb.append("\t(");
			if (includePK) {
				sb.append(rowIndex);
				sb.append(", ");
			}
			sb.append(row.getCell(2).toString())
			.append(", ")
			.append(MonitoringPointType.valueOf(row.getCell(1).getStringCellValue()).ordinal() + 1)
			.append(", ")
			.append(Site.valueOf(row.getCell(0).getStringCellValue()).ordinal() + 1)
			.append("),");
		}
		sb.deleteCharAt(sb.length() - 1).append(";");
		return sb.toString();
	}

	/**
	 * If the input string ends with a lower case 's',
	 * then this method will return a string with the
	 * ending 's' removed.
	 */
	private String removeLastS(String string) {
		if (string.endsWith("s")) {
			return string.substring(0, string.length() - 1);
		}
		return string;
	}

}
