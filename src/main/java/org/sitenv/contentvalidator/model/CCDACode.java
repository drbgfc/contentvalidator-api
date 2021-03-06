package org.sitenv.contentvalidator.model;

import org.sitenv.contentvalidator.dto.ContentValidationResult;
import org.sitenv.contentvalidator.dto.enums.ContentValidationResultLevel;

import java.util.ArrayList;

public class CCDACode extends CCDADataElement {
	private String  code;
	private String  codeSystem;
	private String  codeSystemName;
	private String  displayName;
	
	public Boolean matches(CCDACode cd, ArrayList<ContentValidationResult> results, String elementName) {
		
		if( (code != null) && (cd.getCode() != null) &&
			(codeSystem != null) && (cd.getCodeSystem() != null) &&
			(code.equalsIgnoreCase(cd.getCode())) && 
			(codeSystem.equalsIgnoreCase(cd.getCodeSystem()))) {
			return true;
		}
		else
		{
			String error = "The " + elementName + " : Code = " + ((code != null)?code:"None Specified") 
				       + " , CodeSystem = " + ((codeSystem != null)?codeSystem:"None Specified")
				       + " do not match the submitted CCDA : code = " + ((cd.getCode() != null)?cd.getCode():"None Specified") 
				       + " , and CodeSystem = " + ((cd.getCodeSystem() != null)?cd.getCodeSystem():"None Specified");

			ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
			results.add(rs);
			return false;
		}
		
	}
	
	public Boolean codeMatches(CCDACode cd, ArrayList<ContentValidationResult> results, String elementName) {
		
		if( (code != null) && (cd.getCode() != null) && 
			(code.equalsIgnoreCase(cd.getCode())) ) {
			return true;
		}
		else 
		{
			String error = "The " + elementName + " : Code = " + ((code != null)?code:"None Specified") 
				       + " does not match the submitted CCDA : code = " + ((cd.getCode() != null)?cd.getCode():"None Specified"); 
				       
			ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
			results.add(rs);
			return false;
			
		}
	}
	
	public Boolean codeEquals(CCDACode cd) {
		
		if( (code != null) && (cd.getCode() != null) &&
			(codeSystem != null) && (cd.getCodeSystem() != null) &&
			(code.equalsIgnoreCase(cd.getCode())) && 
			(codeSystem.equalsIgnoreCase(cd.getCodeSystem()))) {
			return true;
		}
		return false;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}

	public String getCodeSystemName() {
		return codeSystemName;
	}

	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public CCDACode()
	{
		super();
	}
}
