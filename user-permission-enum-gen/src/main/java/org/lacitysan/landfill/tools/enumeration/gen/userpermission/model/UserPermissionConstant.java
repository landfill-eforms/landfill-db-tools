package org.lacitysan.landfill.tools.enumeration.gen.userpermission.model;

public class UserPermissionConstant implements Comparable<UserPermissionConstant> {

	private int ordinal;
	private String constantName;
	private String description;
	private String category;
	private String categoryAction;
	private String comments;
	
	public UserPermissionConstant(int ordinal, String constantName, String description, String category, String categoryAction, String comments) {
		this.ordinal = ordinal;
		this.constantName = constantName;
		this.description = description;
		this.category = category;
		this.categoryAction = categoryAction;
		this.comments = comments;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
	public String getConstantName() {
		return constantName;
	}
	public String getDescription() {
		return description;
	}
	public String getCategory() {
		return category;
	}
	public String getCategoryAction() {
		return categoryAction;
	}
	public String getComments() {
		return comments;
	}
	
	@Override
	public int compareTo(UserPermissionConstant o) {

		// Compare by ordinal
		if (ordinal != o.getOrdinal()) {
			return ordinal - o.getOrdinal();
		}
		
		// Compare by constant name.
		return constantName.compareTo(o.getConstantName());
		
	}

}