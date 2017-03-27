package org.lacitysan.landfill.tools.enumeration.gen.userpermission.model;

public class UserPermissionConstant implements Comparable<UserPermissionConstant> {

	String constantName;
	String description;
	String category;
	String categoryAction;
	
	public String getConstantName() {
		return constantName;
	}

	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryAction() {
		return categoryAction;
	}

	public void setCategoryAction(String categoryAction) {
		this.categoryAction = categoryAction;
	}

	@Override
	public int compareTo(UserPermissionConstant o) {
		// TODO Auto-generated method stub
		return 0;
	}

}