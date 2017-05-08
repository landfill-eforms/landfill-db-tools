package org.lacitysan.landfill.tools.typescript.gen.model.field;

import org.lacitysan.landfill.tools.typescript.gen.constants.Type;

/**
 * @author Alvin Quach
 */
public abstract class TypeScriptField {
	
	protected String fieldName;
	
	protected boolean readonly = false;
	
	protected boolean _static = false;
	
	protected boolean _transient = false;

	protected TypeScriptField(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public boolean isStatic() {
		return _static;
	}

	public void setStatic(boolean _static) {
		this._static = _static;
	}

	public boolean isTransient() {
		return _transient;
	}

	public void setTransient(boolean _transient) {
		this._transient = _transient;
	}

	abstract public Type getFieldType();
	
}
