package models;

public class ProgramStatementComplexity {

	private int lineNumber;	
	private int controlCount;
	private int nestedLevelCount;		
	private int sizeCount;
	private int inheritanceCount;
	private int recursionCount;
	private boolean isRecursionLine;
	private String programStatement;
	private int totalWeight;
	private int totalComplexity;
	
	
	public ProgramStatementComplexity(int lineNumber, int sizeCount, int controlCount, int nestedLevelCount,
			int inheritanceCount, int recursionCount, int totalWeight, int totalComplexity, boolean isRecursionLine,String programStatement) {
		super();
		this.lineNumber = lineNumber;
		this.sizeCount = sizeCount;
		this.controlCount = controlCount;
		this.nestedLevelCount = nestedLevelCount;
		this.inheritanceCount = inheritanceCount;
		this.recursionCount = recursionCount;
		this.totalWeight = totalWeight;
		this.totalComplexity = totalComplexity;
		this.isRecursionLine = isRecursionLine;
		this.programStatement= programStatement;		
	}
	
	
	public ProgramStatementComplexity() {
		super();
	}
	
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public int getSizeCount() {
		return sizeCount;
	}

	public void setSizeCount(int sizeCount) {
		this.sizeCount = sizeCount;
	}

	public int getControlCount() {
		return controlCount;
	}

	public void setControlCount(int controlCount) {
		this.controlCount = controlCount;
	}

	public int getNestedLevelCount() {
		return nestedLevelCount;
	}

	public void setNestedLevelCount(int nestedLevelCount) {
		this.nestedLevelCount = nestedLevelCount;
	}
	
	public String getProgramStatement() {
		return programStatement;
	}

	public void setProgramStatement(String programStatement) {
		this.programStatement = programStatement;
	}
	public int getInheritanceCount() {
		return inheritanceCount;
	}

	public void setInheritanceCount(int inheritanceCount) {
		this.inheritanceCount = inheritanceCount;
	}

	public int getRecursionCount() {
		return recursionCount;
	}

	public void setRecursionCount(int recursionCount) {
		this.recursionCount = recursionCount;
	}
	
	public int getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}

	public int getTotalComplexity() {
		return totalComplexity;
	}

	public void setTotalComplexity(int totalComplexity) {
		this.totalComplexity = totalComplexity;
	}

	public boolean isRecursionLine() {
		return isRecursionLine;
	}

	public void setRecursionLine(boolean isRecursionLine) {
		this.isRecursionLine = isRecursionLine;
	}
	

}
