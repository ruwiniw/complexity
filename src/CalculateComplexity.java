import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import logic.ComplexityMeasurements;
import logic.ProgramComplexityLogic;
import models.Keywords;
import models.ProgramStatementComplexity;

public class CalculateComplexity {
	
	
@SuppressWarnings("finally")
public static List<ProgramStatementComplexity> getComplexity(String fileName) {
		
		File file = new File(fileName); 
		  
		  BufferedReader br,br1,br2,br3,br4,br5,br6;
		  List<String> java_keywords = Keywords.JAVAKEYWORDS;
		  List<String> relation_operators = Keywords.RELATIONOPERATORS;
		  List<String> arithmetic_operators = Keywords.ARITHMETICOPERATORS;
		  List<String> logical_operators = Keywords.LOGICALOPERATORS;
		  List<String> bitwise_operators = Keywords.BITWISEOPERATORS;
		  List<String> miscellaneous_operators = Keywords.MISCELLANEOUSOPERATORS;
		  List<String> manipulators = Keywords.MANIPULATORS;
		  List<String> return_types = Keywords.RETURNTYPES;
		  List<String> method_definitions = Keywords.METHODDEFINITIONS;
		  List<String> primitive_types = Keywords.PRIMITIVETYPES;
		  List<String> conditional_logical_operations = Keywords.CONDITIONALLOGICALOPERATORS;
		  
		  List<String> variables = new ArrayList<>();
		  List<String> classes = new ArrayList<>();
		  List<String> userDefinedClasses = new ArrayList<>();
		  List<String> userDefinedParentClasses = new ArrayList<>();
		  List<String> packages = new ArrayList<>();
		  List<ProgramStatementComplexity> programStatements = new ArrayList<>();
		  List<ProgramStatementComplexity> total_complexities = new ArrayList<>();
		  
		//use a try for bufferedReader  
		try {
			br = new BufferedReader(new FileReader(file));
			br1 = new BufferedReader(new FileReader(file));
			br2 = new BufferedReader(new FileReader(file));
			br3 = new BufferedReader(new FileReader(file));
			br4 = new BufferedReader(new FileReader(file));
			br5 = new BufferedReader(new FileReader(file));
			br6 = new BufferedReader(new FileReader(file));
			String st; 
			int count = 0;
			ComplexityMeasurements cm = new ComplexityMeasurements(classes, variables, java_keywords, arithmetic_operators, relation_operators, logical_operators, bitwise_operators, miscellaneous_operators, primitive_types, method_definitions);
			
			//checking for size measurements
			while ((st = br.readLine()) != null) {
				int size_count = 0;
				
				count++;
				
				cm.setSizeCount(size_count);
				cm.setString(st);
				
				//for calculating the size count
				ProgramStatementComplexity obj = ComplexityMeasurements.calculateSizeMeasurements(cm, count);
				programStatements.add(obj);
							
			    System.out.println(st);

			  }
			br.close();
			
			
			//checking for inheritance measurements
			ComplexityMeasurements cm1 = new ComplexityMeasurements(userDefinedClasses, userDefinedParentClasses, packages, br1);
			Map<String, Integer> class_inheritance_counts = ComplexityMeasurements.calculateInheritanceMeasurements(cm1);
			
			//checking for control structure measurements
			ComplexityMeasurements cm2 = new ComplexityMeasurements(conditional_logical_operations, br2);
			List<ProgramStatementComplexity> control_structure_complexities = ComplexityMeasurements.calculateControlStructureCount(cm2);
			
			//checking for nesting level measurements
			ComplexityMeasurements cm3 = new ComplexityMeasurements(br3);
			List<ProgramStatementComplexity> nesting_level_complexities = ComplexityMeasurements.calculateComplexityDueToNestingLevels(cm3);
			
			//checking for recursion method measurements
			ComplexityMeasurements cm4 = new ComplexityMeasurements(br4);
			List<String> recursion_methods = ComplexityMeasurements.calculateRecursionMeasurements(cm4);
			
			
			ProgramComplexityLogic pc = new ProgramComplexityLogic(control_structure_complexities, programStatements,class_inheritance_counts,  recursion_methods, nesting_level_complexities);
			total_complexities = pc.calculateProgramStatementComplexity(br5,br6);
			
			

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return total_complexities;
		}

	}
}
