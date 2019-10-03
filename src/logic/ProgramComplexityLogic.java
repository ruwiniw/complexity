package logic;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.ProgramStatementComplexity;

public class ProgramComplexityLogic {
	
	private List<ProgramStatementComplexity> controlStructureComplexities;
	private List<ProgramStatementComplexity> nestingLevelComplexities;
	private List<ProgramStatementComplexity> sizeComplexities;
	
	private Map<String, Integer> classInheritanceCounts;
	private List<String> recursionMethods;	
	
	//constructor
	public ProgramComplexityLogic(List<ProgramStatementComplexity> controlStructureComplexities,List<ProgramStatementComplexity> sizeComplexities,Map<String, Integer> classInheritanceCounts,
			List<String> recursionMethods,List<ProgramStatementComplexity> nestingLevelComplexities) {
		super();
		this.controlStructureComplexities = controlStructureComplexities;
		this.nestingLevelComplexities = nestingLevelComplexities;
		this.sizeComplexities = sizeComplexities;
		this.classInheritanceCounts = classInheritanceCounts;
		this.recursionMethods = recursionMethods;
	}

	
	public List<ProgramStatementComplexity> calculateProgramStatementComplexity(BufferedReader br1,BufferedReader br2) {
		
		int index = 0;
		List<ProgramStatementComplexity> totalComplexities = new ArrayList<>();
		System.out.println("I am calculating complexity");
		
		try {					
			
			//getting the inheritance count for each line
			ComplexityMeasurements cm = new ComplexityMeasurements(br1);
			List<ProgramStatementComplexity> inheritanceComplexities = ComplexityMeasurements.getInheritanceCountForStatement(cm, classInheritanceCounts);
			
			ComplexityMeasurements cm1 = new ComplexityMeasurements(br2);
			List<ProgramStatementComplexity> recursionComplexities = ComplexityMeasurements.getRecursionCountforStatement(cm1, recursionMethods);
			
			//assigning the complexity values
			for (ProgramStatementComplexity psc: sizeComplexities) {
				int recursionPoint = 0;
				ProgramStatementComplexity control = controlStructureComplexities.get(index);
				ProgramStatementComplexity nested = nestingLevelComplexities.get(index);				
				ProgramStatementComplexity inheritance = inheritanceComplexities.get(index);
				
				//setting the control structure count for the line
				psc.setControlCount(control.getControlCount());
				
				//setting the nested level count for the line
				psc.setNestedLevelCount(nested.getNestedLevelCount());
				
				//setting the inheritance level count for the line
				psc.setInheritanceCount(inheritance.getInheritanceCount());
				
				//calculating the total weight by adding control structure, nested level and inheritance complexities
				int totalWeight = control.getControlCount() + nested.getNestedLevelCount() + inheritance.getInheritanceCount();
				
				psc.setTotalWeight(totalWeight);
				
				//calculating the Total complexity for the program statement by multiplying the total weight by size complexity count
				int totalComplexity = psc.getSizeCount() * totalWeight;
				
				psc.setTotalComplexity(totalComplexity);
				
				ProgramStatementComplexity recursion = recursionComplexities.get(index);
				
				if (recursion.isRecursionLine()) {
					recursionPoint = totalComplexity * 2;
				}
				psc.setRecursionCount(recursionPoint);
				
				totalComplexities.add(psc);
				index++;			
			}
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
		return totalComplexities;
		}
		
	}

}
