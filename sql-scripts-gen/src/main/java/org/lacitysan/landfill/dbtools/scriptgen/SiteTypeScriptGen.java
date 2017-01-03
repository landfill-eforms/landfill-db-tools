package org.lacitysan.landfill.dbtools.scriptgen;

import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.lacitysan.landfill.dbtools.scriptgen.constant.TableName;
import org.lacitysan.landfill.lib.MonitoringPointType;
import org.lacitysan.landfill.lib.Site;

/**
 * Generates the SQL scripts to create and pre-populate the Sites, MonitoringPoints, 
 * and MonitoringPointTypes tables using the Excel spreadsheet that contains sites and types.
 * @author Alvin Quach
 */
public class SiteTypeScriptGen {

	private XSSFSheet siteTypeWorksheet;

	public SiteTypeScriptGen(XSSFSheet siteTypeWorksheet) {
		this.siteTypeWorksheet = siteTypeWorksheet;
	}

	public String getSiteScript(boolean includePK) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO dbo." + TableName.SITES + " (");
		if (includePK) {
			sb.append(removeLastS(TableName.SITES) + "PK, ");
		}
		sb.append("SiteName, ShortName, SiteType, Active)")
		.append("\n")
		.append("VALUES")
		.append("\n");
		Site[] sites = Site.values();
		for (Site site : sites) {
			sb.append("\t(");
			if (includePK) {
				sb.append(site.ordinal() + ", ");
			}
			sb.append("'" + site.getName() + "', '" + site.getShortName() + "', '" + site.getType() + "', " + (site.isActive() ? 1 : 0) + ")");
			sb.append(site.ordinal() + 1 == sites.length ?  ";\n" : ",\n");
		}
		return sb.toString();
	}

	public String getTypeScript(boolean includePK) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO dbo." + TableName.MONITORING_POINT_TYPES + " (");
		if (includePK) {
			sb.append(removeLastS(TableName.MONITORING_POINT_TYPES) + "PK, ");
		}
		sb.append("TypeName)")
		.append("\n")
		.append("VALUES")
		.append("\n");
		MonitoringPointType[] types = MonitoringPointType.values();
		for (MonitoringPointType type : types) {
			sb.append("\t(");
			if (includePK) {
				sb.append(type.ordinal() + ", ");
			}
			sb.append("'" + type.getName() + "')");
			sb.append(type.ordinal() + 1 == types.length ?  ";\n" : ",\n");
		}
		return sb.toString();
	}

	public String getPointScript(boolean includePK) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO dbo." + TableName.MONITORING_POINTS + " (");
		if (includePK) {
			sb.append(removeLastS(TableName.MONITORING_POINTS) + "PK, ");
		}
		sb.append("MonitoringPointName, " + removeLastS(TableName.MONITORING_POINT_TYPES) + "FK, " + removeLastS(TableName.SITES) + "FK)")
		.append("\n")
		.append("VALUES")
		.append("\n");
		for (Row row : siteTypeWorksheet) {
			int rowIndex = row.getRowNum();
			if (rowIndex++ == 0) {
				continue;
			}
			sb.append("\t(");
			if (includePK) {
				sb.append(rowIndex);
				sb.append(", ");
			}
			sb.append("'" + row.getCell(2).toString() + "'")
			.append(", ")
			.append(Arrays.asList(MonitoringPointType.values()).stream().filter(t -> t.getName().equals(row.getCell(1).getStringCellValue())).findFirst().get().ordinal())
			.append(", ")
			.append(Arrays.asList(Site.values()).stream().filter(s -> s.getName().equals(row.getCell(0).getStringCellValue())).findFirst().get().ordinal())
			.append(")");
			if (siteTypeWorksheet.getRow(rowIndex + 1).getCell(0).getCellType() != Cell.CELL_TYPE_BLANK) { 
				sb.append(",\n");
			}
			else {
				sb.append(";");
				break;
			}
		}
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
