package logic;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import models.Keywords;
import models.ProgramStatementComplexity;


public class ComplexityMeasurements {
	
	private BufferedReader br;
	private int sizeCount;
	private String string;	
	private static int Size;
	private List<String> logicalOperators;
	private List<String> bitwiseOperators;
	private List<String> arithmeticOperators;
	private List<String> relationOperators;
	private List<String> miscellaneousOperators;
	private List<String> primitiveTypes;
	private List<String> conditionalLogicalOperations;	
	private List<String> classes;
	private List<String> variables;
	private List<String> javaKeywords;
	private List<String> userDefinedClasses = new ArrayList<>();
	private List<String> userDefinedParentClasses = new ArrayList<>();
	private List<String> methods = new ArrayList<>();
	private List<String> packages = new ArrayList<>();
	
	public ComplexityMeasurements(int sizeCount, String string, List<String> logicalOperators, List<String> bitwiseOperators,List<String> classes, List<String> variables,
			List<String> javaKeywords, List<String> arithmeticOperators,List<String> relationOperators,List<String> miscellaneousOperators,
			List<String> primitiveTypes) {
		super();
		this.sizeCount = sizeCount;
		this.string = string;
		this.logicalOperators = logicalOperators;
		this.bitwiseOperators = bitwiseOperators;		
		this.classes = classes;
		this.variables = variables;
		this.javaKeywords = javaKeywords;
		this.arithmeticOperators = arithmeticOperators;
		this.relationOperators = relationOperators;
		this.miscellaneousOperators = miscellaneousOperators;
		this.primitiveTypes = primitiveTypes;
	}

	public ComplexityMeasurements(List<String> classes, List<String> variables, List<String> java_keywords,
			List<String> arithmetic_operators, List<String> relation_operators, List<String> logical_operators,
			List<String> bitwise_operators, List<String> miscellaneous_operators, List<String> primitive_types, List<String> methods) {
		super();
		this.classes = classes;
		this.variables = variables;
		this.javaKeywords = java_keywords;
		this.arithmeticOperators = arithmetic_operators;
		this.relationOperators = relation_operators;
		this.logicalOperators = logical_operators;
		this.bitwiseOperators = bitwise_operators;
		this.miscellaneousOperators = miscellaneous_operators;
		this.primitiveTypes = primitive_types;
		this.methods = methods;
	}

	public ComplexityMeasurements(String string) {
		super();
		this.string = string;
	}

	public ComplexityMeasurements(BufferedReader br) {
		super();
		this.br = br;
	}
	public ComplexityMeasurements(String st, List<String> user_defined_classes,
			List<String> user_defined_parent_classes) {
		super();
		this.string = st;
		this.userDefinedClasses = user_defined_classes;
		this.userDefinedParentClasses = user_defined_parent_classes;
	}
	public ComplexityMeasurements(List<String> user_defined_classes, List<String> user_defined_parent_classes,
			BufferedReader br) {
		super();
		this.userDefinedClasses = user_defined_classes;
		this.userDefinedParentClasses = user_defined_parent_classes;
		this.br = br;
	}
	public ComplexityMeasurements(List<String> user_defined_classes, List<String> user_defined_parent_classes,
			List<String> packages, BufferedReader br) {
		super();
		this.userDefinedClasses = user_defined_classes;
		this.userDefinedParentClasses = user_defined_parent_classes;
		this.packages = packages;
		this.br = br;
	}
	public ComplexityMeasurements() {
		super();
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		
		this.br = br;
	}
	public ComplexityMeasurements(List<String> conditionalLogicalOperations, BufferedReader br) {
		super();
		this.conditionalLogicalOperations = conditionalLogicalOperations;
		this.br = br;
	}
	public int getSizeCount() {
		return sizeCount;
	}
	public void setSizeCount(int sizeCount) {
		this.sizeCount = sizeCount;
	}

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}
	
	//Get Logical Operations
	public List<String> getConditionalLogicalOperations() {
		return conditionalLogicalOperations;
	}

	public void setConditionalLogicalOperations(List<String> conditionaLogicalOperations) {
		this.conditionalLogicalOperations = conditionaLogicalOperations;
	}
		
	public List<String> getUserDefinedClasses() {
		return userDefinedClasses;
	}

	public void setUserDefinedClasses(List<String> user_defined_classes) {
		this.userDefinedClasses = user_defined_classes;
	}

	public List<String> getUserDefinedParentClasses() {
		return userDefinedParentClasses;
	}

	public void setUserDefinedParentClasses(List<String> user_defined_parent_classes) {
		this.userDefinedParentClasses = user_defined_parent_classes;
	}

	public int getClasses() {
		if (string.contains(" ")) {
			String[] parts = string.split(" ");
			
			for (String part: parts) {
				if (part.contains("(")) {
					String[] mini_parts = part.split(Pattern.quote("("));
					
					if (mini_parts.length > 1) {
						if (mini_parts[0].equals("")) {
							if (!mini_parts[0].equals("")) {
								if (Character.isUpperCase(mini_parts[1].charAt(0))) {
//									System.out.println("There is a class in :" + mini_parts[1]);
									
									if (!classes.contains(mini_parts[1]))
										classes.add(mini_parts[1]);
									sizeCount++;
								}
							}
						}
						else if (!mini_parts[1].equals("")) {
							if (Character.isUpperCase(mini_parts[1].charAt(0))) {
								if (mini_parts[1].contains("[]")) {
									String class_part[] = mini_parts[1].split(Pattern.quote("[]"));
//									System.out.println("There is a class in :" + class_part[0]);
									
									if (!classes.contains(class_part[0]))
										classes.add(class_part[0]);
									sizeCount++;
								}
							}
						}
						else if (Character.isUpperCase(mini_parts[1].charAt(0))) {
							if (mini_parts[1].contains("[]")) {
								String class_part[] = mini_parts[1].split(Pattern.quote("[]"));
//								System.out.println("There is a class in :" + class_part[0]);
								
								if (!classes.contains(class_part[0]))
									classes.add(class_part[0]);
								sizeCount++;
							}
						}
						
						else if (mini_parts[1].contains("\"")) {
							if (Character.isUpperCase(mini_parts[0].charAt(0))) {
//								System.out.println("There is a class in :" + mini_parts[0]);
								
								if (!classes.contains(mini_parts[0]))
									classes.add(mini_parts[0]);
								sizeCount++;
							}
						}
						else {
							System.out.println("No class");
						}
					}
					
					
				}
				else {
					String trimmed = part.trim();
					if (!trimmed.equals("")) {
						if (Character.isUpperCase(trimmed.charAt(0)) && !trimmed.contains("(")) {
//							System.out.println("There is a class in :" + part);
							
							if (!classes.contains(trimmed))
								classes.add(trimmed);
							sizeCount++;
						}
					}
					
				}
			}
		}
		
		//if the statement has "public" or "class" keywords, ignore the size count
		if (string.contains(Keywords.CLASS)) {
			sizeCount = 0;
		}
		return sizeCount;
		
	}
	
	
	
	public int getClassVariables() {
		for (String cl: classes) {
			if (string.contains(cl) && string.contains(" ")) {
				String[] sub_parts = string.split(" ");
				
				int index = 0;
				
				for (String part: sub_parts) {
					if (part.contains(cl) && !part.contains("\"")) {
						if ((index + 1) < sub_parts.length) {
							if (!(sub_parts[index + 1].contains("{"))) {
								if (sub_parts[index + 1].contains(")")) {
									String[] var_part = sub_parts[index + 1].split(Pattern.quote(")"));
									if (!variables.contains(var_part[0]) && !var_part[0].contains(Keywords.EXTENDS) && !var_part[0].contains(Keywords.IMPLEMENTS) && !var_part[0].contains("(")) {
										variables.add(var_part[0]);
									}
									
								}
								else {
									if (!variables.contains(sub_parts[index + 1]) && !sub_parts[index + 1].contains(Keywords.EXTENDS) && !sub_parts[index + 1].contains(Keywords.IMPLEMENTS)) {
										variables.add(sub_parts[index + 1]);
									}
									
								}
								
							}
						}
					}
					index++;
				}
			}
		}
		return sizeCount;
	}
	
public int getPrimitiveVariables() {
		
		String st1, st2, st3;
		boolean isBracketFound = false;
		
		st1 = string.replaceAll(Pattern.quote(")"), " ");
		st2 = st1.replaceAll(Pattern.quote("."), " ");
		
		for (String primitive: primitiveTypes) {
			if (st2.contains(primitive) && st2.contains(" ") && !st2.contains("\"")) {
				String[] sub_parts = st2.split(" ");
				int index = 0;
				
				for (String part: sub_parts) {
					
					if (isBracketFound && !part.contains("\"")) {
						part = part.replaceAll(Pattern.quote("("), " ");
						String[] mini_parts = part.split(" ");
						
						if (mini_parts.length > 1)
							part = mini_parts[1];
					}
					
					if (part.equals(primitive) && !part.contains("\"")) {
						if (!variables.contains(sub_parts[index + 1]) && !sub_parts[index + 1].contains("(")) {
							variables.add(sub_parts[index + 1]);
							isBracketFound = false;
						}
						
						if (sub_parts[index + 1].contains("(")) {
							isBracketFound = true;
						}

					}
					
					if (index < sub_parts.length - 1) {
						if (sub_parts[index + 1].contains("(")) {
							isBracketFound = true;
						}
					}
					index++;
				}
			}
		}
		return sizeCount;
	}
	
	public int getStringValues() {
		
		if (string.contains("\"")) {
			int doubleQuoteCount = string.split(Pattern.quote("\""), -1).length - 1;
			int size = doubleQuoteCount / 2;
			sizeCount += size;
		}
		
		return sizeCount;
	}
	
	public int getMethodNames() {
		
		if (string.contains(Keywords.PUBLIC) || string.contains(Keywords.STATIC)) {
			String[] parts = string.split(" ");

			for (String s: parts) {
				if (s.contains("(")) {
					s = s.split(Pattern.quote("("))[0];
					methods.add(s);
				}
			}
			
		}
		return sizeCount;
	}
	
	public int getJavaKeywords() {
		
		for (String word: javaKeywords) {
			if (string.contains(word+ " ")) {
				
				int occurence_count = (string.split(word, -1).length) - 1;
				sizeCount += occurence_count;

			}
		}
		return sizeCount;
	}
	
	public int getArithmeticOperations() {
		
		String[] parts = string.split(" ");
		
		for (String part: parts) {
			for (String arithemtic: arithmeticOperators) {
				if (part.equals(arithemtic) && !part.contains("\"")) {
					sizeCount++;
				}
				else if (part.contains(arithemtic)) {
					sizeCount++;
				}
			}
		}
		

		return sizeCount;
	}
	
	public int getRelationalOperations() {
		
		String[] parts = string.split(" ");
		
		for (String part: parts) {
			for (String relation: relationOperators) {
				if (part.equals(relation) && !part.contains("\"")) {
					sizeCount++;
				}
			}
		}
		

		return sizeCount;
	}
	
	public int getLogicalOperations() {
		
		String[] parts = string.split(" ");
		
		for (String part: parts) {
			for (String logical: logicalOperators) {
				if (part.equals(logical) && !part.contains("\"")) {
					sizeCount++;
				}
			}
		}
		

		return sizeCount;
	}
	
	public int getBitwiseOperations() {
		
		String[] parts = string.split(" ");
		
		for (String part: parts) {
			for (String bitwise: bitwiseOperators) {
				if (part.equals(bitwise) && !part.contains("\"")) {
					sizeCount++;
				}
			}
		}
		return sizeCount;
	}
	
	public int getMiscellaneousOperations() {
		
		String[] parts = string.split(" ");
		
		for (String part: parts) {
			for (String miscellaneous: miscellaneousOperators) {
				if (part.equals(miscellaneous) && !part.contains("\"")) {
					sizeCount++;
				}
			}
		}
		

		return sizeCount;
	}
	
	public int getDotOperatorSeparations() {
		
		int dot_count = 0;
		
		if (string.contains(Keywords.DOT)) {
			String[] parts = string.split(Pattern.quote(Keywords.DOT));
			dot_count = string.split(Pattern.quote(Keywords.DOT), -1).length - 1;
			String temp_part;
			
			for (String part: parts) {
				if (part.contains("(")) {

					sizeCount += 1;
				}
				
				sizeCount++;
			}
		}
		return sizeCount + dot_count;
	}
	
	public int getNumberCount() {
		
		List<Number> numbers = new ArrayList<>();
		Number num;
		
		string = string.trim();
		
		string = string.replaceAll(Pattern.quote("("), " ");
		string = string.replaceAll(Pattern.quote(")"), " ");
		string = string.replaceAll(Pattern.quote(";"), " ");
		
		for (String aritmetic: arithmeticOperators) {
			
			string = string.replace(aritmetic, " ");
		}
		
		for (String relational: relationOperators) {
			string = string.replace(relational, " ");
		}
		
		
		String[] parts = string.split(" ");
		
		for (String part: parts) {
			try {
				num = Double.parseDouble(part);
				if (!numbers.contains(num)) {
					numbers.add(num);
				}
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		sizeCount += numbers.size();
		return sizeCount;
	}
	
	public int countVariableForReturn() {
		string = string.replaceAll(Pattern.quote("("), " ");
		string = string.replaceAll(Pattern.quote("("), " ");
		
		String[] parts = string.split(" ");
		
		if (parts.length > 0) {
			parts[0] = parts[0].trim();
			
			for (String part: parts) {
				if (variables.contains(part) || methods.contains(part)) {
					sizeCount++;
				}
			}
		}
		
		
		
		return sizeCount;
	}
	
public static ProgramStatementComplexity calculateSizeMeasurements(ComplexityMeasurements cm, int lineNumber) {
		
		Size = cm.getClasses();
		Size = cm.getClassVariables();
		Size = cm.getPrimitiveVariables();
		Size = cm.getStringValues();
		Size = cm.getMethodNames();
		Size = cm.getJavaKeywords();
		Size = cm.getArithmeticOperations();
		Size = cm.getRelationalOperations();
		Size = cm.getLogicalOperations();
		Size = cm.getBitwiseOperations();
		Size = cm.getMiscellaneousOperations();
		Size = cm.getDotOperatorSeparations();
		Size = cm.getNumberCount();
 		Size = cm.countVariableForReturn();
		
 		ProgramStatementComplexity psc = new ProgramStatementComplexity();
		psc.setLineNumber(lineNumber);
		psc.setSizeCount(Size);
		
		return psc;
	}
	
	
	//Calculating Ctc	
	//Calculating According to Type of Control Structures
	public static List<ProgramStatementComplexity> calculateControlStructureCount(ComplexityMeasurements cm) throws IOException{
		BufferedReader br = cm.getBr();
		List<String> cl = cm.getConditionalLogicalOperations();
		String statement = null;
		int lineCount = 1;
		
		List<ProgramStatementComplexity> programStatements = new ArrayList<>();
		
//		statement = br.readLine();
		while((statement = br.readLine()) != null) {
			
			int controlPoints = 0;
			if(statement.contains(" ")) {
				String[] parts = statement.split(" ");
				
				if (parts.length > 0) {
					parts[0] = parts[0].trim();
					
					if(parts[0].contentEquals(Keywords.IF)) {
						controlPoints += 1;
						
					}
					else if(parts[0].equals(Keywords.FOR)) {
						controlPoints += 2;
						
						String[] separations = statement.split(Pattern.quote(";"));
						
						for(String separation: separations) {
							for(String conditional : cl) {
								if(separation.contains(conditional)) {
									int counts = (separation.split(Pattern.quote(conditional)).length)-1;
									counts *= counts;
									controlPoints += counts;
								}
							}
						}
					}
					else if (parts[0].contentEquals(Keywords.WHILE)) {
						controlPoints+=2;
					}
					else if (parts[0].contentEquals(Keywords.DOWHILE)) {
						controlPoints+=2;
					}
					else if (parts[0].contentEquals(Keywords.CATCH)) {
						controlPoints+=1;
					}
				}
				
				
			}
			ProgramStatementComplexity programStatementComplexity = new ProgramStatementComplexity();
			programStatementComplexity.setLineNumber(lineCount);
			programStatementComplexity.setControlCount(controlPoints);
			
			programStatements.add(programStatementComplexity);
			System.out.println("Control Structure measurements:" + controlPoints);
			lineCount ++;
			
		}
		return programStatements;
	}
	
	//Calculating Complexity due to Switch statements.
	
	@SuppressWarnings("finally")
	public int calculateSwitchStatementCount(BufferedReader br) {
		String statement = null;
		int firstLine = 0;
		int count = 1;
		int lastLine =0;
		int leftBraces =0;
		int rightBraces =0;
		int caseCount =0;
		boolean isSwitchFound = false;
		List<ProgramStatementComplexity> programStatements = new ArrayList<>();

		
		try {
			statement = br.readLine();
			while(statement != null) {
				
				if(statement.contains(" ")) {
					String[] parts = statement.trim().split(" ");
					
					if(parts[0].contentEquals(Keywords.SWITCH)) {
						isSwitchFound = true;
						firstLine = count;
					}
				}
				if(isSwitchFound && statement.contains(" ")) {
					String[] parts = statement.trim().split(" ");
					if(parts[0].contains(Keywords.CASE)) {
						caseCount ++;					
					}
				}
				if (!statement.contains("\"") && statement.contains("}") && isSwitchFound) {
					rightBraces++;
				}
				
				if (statement.contains("{") && isSwitchFound) {
					leftBraces++;
				}
				if ((leftBraces == rightBraces) && (leftBraces > 0) && (rightBraces > 0)) {
					System.out.println("Switch method ends at line no. " + count);
					isSwitchFound = false;
					caseCount = 0;
					leftBraces = 0;
					rightBraces = 0;
					lastLine = count;
				}
				count ++ ;
				
			}
			System.out.println("Number of cases: " + caseCount);
			System.out.println("First Line: " + firstLine);
			System.out.println("Last line: " + lastLine);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			int controlPoints = 0 ;	
			controlPoints = caseCount ;
			return controlPoints;
		}
	}
	
	//Calculating Cnc
	//Calculating Complexity due to nesting of Control Structures
	
	public static List<ProgramStatementComplexity> calculateComplexityDueToNestingLevels(ComplexityMeasurements cm) throws IOException , NullPointerException{
		
		BufferedReader br= cm.getBr();
		String statement = null;
		
		String nestedControlVariable = null;
		int leftCurlyBraceCount = 0;
		int rightCurlyBraceCount = 0;
		int lineCount = 1;
		int nestedCount = -1;
		List<ProgramStatementComplexity> programStatements = new ArrayList<>();
//	    statement = br.readLine();
		
		while((statement = br.readLine()) != null) {
			
			//check whether the line contains public or class keywords
			if(!statement.contains("\"")) {
				if(statement.contains((" "))){
					
					String[] parts = statement.split(" ");
					
					if (parts.length > 0) {
						if(parts[0].equalsIgnoreCase(Keywords.PUBLIC) || parts[0].equalsIgnoreCase(Keywords.CLASS)) {
							nestedCount = 0;
						}
					}
					
					
				}
			}
			// check if the line contains for,if,do, while keywords
			if(statement.contains(" ")) {
				String[] parts = statement.split(" ");
				
				if (parts.length > 0) {
					
					parts[0] = parts[0].trim();
					
					if(parts[0].equalsIgnoreCase(Keywords.FOR) || parts[0].equalsIgnoreCase(Keywords.IF) || parts[0].equalsIgnoreCase(Keywords.DO) || parts[0].equalsIgnoreCase(Keywords.WHILE)) {
						
						//checking for nested control variable 
						if(parts[0].equalsIgnoreCase(nestedControlVariable) || nestedControlVariable == null) {
							nestedCount += 1 ;
							nestedControlVariable = parts[0];
							leftCurlyBraceCount += 1;						
						}
					}
				}
			}
			
			//check for right curly braces if the nested control variable is not null
			if(statement.trim().contains("}") && (nestedControlVariable != null)) {
				rightCurlyBraceCount ++ ;
				
				if((rightCurlyBraceCount - leftCurlyBraceCount) == 1) {
					nestedCount -- ;
				}
			}
			
			if(nestedCount <= 0) {
				nestedCount = 0;
			}
			System.out.println("Nested count for line no. " + lineCount + ": " + nestedCount);
			lineCount++;
			
			//adding the nesting level count for the given line
			ProgramStatementComplexity programStatementComplexity = new ProgramStatementComplexity();
			programStatementComplexity.setLineNumber(lineCount);
			programStatementComplexity.setNestedLevelCount(nestedCount);
			
			programStatements.add(programStatementComplexity);
		}
		return programStatements;
		

	}

	//calculating the inheritance for a given program
	public static Map<String, Integer> calculateInheritanceMeasurements(ComplexityMeasurements cm) throws IOException, ClassNotFoundException {
		
		BufferedReader buffer = cm.getBr();
		int line_count = 1;
		String statement;
		Map<Integer, String> classBlocks = new HashMap<>();
		Map<Integer, String> parentClassBlocks = new HashMap<>();
		Map<String, Integer> classInheritanceCount = new HashMap<>();
		List<String> userDefinedClasses = cm.getUserDefinedClasses();
		List<String> userDefinedParentClasses = cm.getUserDefinedParentClasses();
		List<String> packageList = cm.getPackages();
		
		while ((statement = buffer.readLine()) != null) {
			
			//getting the imported package names
			if (statement.contains(" ")) {
				String[] parts = statement.split(" ");
				
				if (parts.length > 0) {
					//checking for "import" keyword
					if (parts[0].contains(Keywords.IMPORT)) {
						
						//checking for "." operator to identify the package name
						if (parts[1].contains(".")) {
							String[] packageParts = parts[1].split(Pattern.quote("."));
							int len = packageParts.length;
							String lastPart = packageParts[len - 1];
							
							//checking for the last part of the package statement to check whether it contains "*;"
							if (lastPart.equals("*;")) {
								String[] packages = parts[1].split(Pattern.quote(".*"));
								System.out.println("Package name: " + packages[0]);
								
								//inserting the package name into the list
								if (!packageList.contains(packages[0])) {
									packageList.add(packages[0]);
								}
							}
							
							//checking whether the last part of the package name is a class name
							if (Character.isUpperCase(lastPart.charAt(0))) {
								String[] packages = parts[1].split(Pattern.quote("." + lastPart.charAt(0)));
								System.out.println("Package name: " + packages[0]);
							}
						}
					}
				}
				
				
			}
		
			//checking for user defined classes and parent classes
			if (statement.contains(" ") && !statement.contains("\"")) {
				String[] parts = statement.split(" ");
				int index = 0;
				
				//looping through the parts of the statement
				for (String part: parts) {
					//if the statement contains "class" keyword
					if (part.equals(Keywords.CLASS)) {
						String class_name = parts[index + 1];
//						System.out.println("User defined class name: " + class_name);
						
						//if a class name is found, add to the class list with the line number if it is not there
						if (!userDefinedClasses.contains(class_name)) {
							userDefinedClasses.add(class_name);
							classBlocks.put(line_count, class_name);
						}
						
					}
					
					//finding the parent class of the given class
					if (part.equals(Keywords.EXTENDS) || part.equalsIgnoreCase(Keywords.IMPLEMENTS)) {
						String class_name = parts[index + 1];
						System.out.println("Parent class: " + class_name);
						
						userDefinedParentClasses.add(class_name);
						parentClassBlocks.put(line_count, class_name);
					}
					index++;
				}
	
			}
			
			line_count++;
		}
		
		Set<Map.Entry<Integer,String>> set = classBlocks.entrySet();
		
		//finding the classes from the map which contains the classes
		for (Map.Entry<Integer, String> entries: set) {
			int class_start_point = entries.getKey();
			String class_name = entries.getValue();
			
			int defaultInheritance = 2;
			int totalInheritance = 0;
			
			//getting the number of ancestor classes and displaying the total inheritance complexity
			int calculated_inheritance = cm.getClassInheritance(class_start_point, class_name, userDefinedClasses, parentClassBlocks, packageList);
			totalInheritance = defaultInheritance + calculated_inheritance;
			
//			System.out.println("Inheritance for class " + class_name + ": " + total_inheritance);
			
			classInheritanceCount.put(class_name, totalInheritance);
			
		}
		
		return classInheritanceCount;
		
	}
	
	//to calculate the inheritance of a given class
	public int getClassInheritance(int start, String class_name, List<String> user_defined_classes, Map<Integer, String> parent_classes, List<String> package_list) throws ClassNotFoundException {
		
		String parent_class = null;
		String default_package = "java.lang";
		String test_package = "test";
		//get the parent class of the given user defined class
		parent_class = parent_classes.get(start);
		
		boolean isParentUserDefined = user_defined_classes.contains(parent_class);
		
		//if the parent class is not null and not user defined, get the number of ancestor classes
		if (parent_class != null && !isParentUserDefined) {
			
			//if the package is java.lang
			if (package_list.size() == 0) {
				
				String qualified_name = default_package + "." + parent_class;
				try {
					Class cl = Class.forName(qualified_name);
					
					int cl2 = getNoOfParentClass(cl);
					if (cl2 == 0) {
						return 1;
					}
					
				} catch (Exception ex) {
					
				}

			}
			
			//if there are other packages imported
			else {
				for (String pk: package_list) {
					String qualified_name = pk + "." + parent_class;
					
					try {
						Class cl = Class.forName(qualified_name);
						
						int cl2 = getNoOfParentClass(cl);
						if (cl2 == 0) {
							return 1;
						}
						
					} catch (Exception ex) {
						
					}

					

				}
			}	
			
		}
		
		//if the parent class is not null and user defined
		else if (parent_class != null && isParentUserDefined) {
			String qualified_name = test_package + "." + parent_class;
			Class cl = Class.forName(qualified_name);
			
			int cl2 = getNoOfParentClass(cl);
			
			if (cl2 == 0) {
				return 1;
			}
		}
		
		return 0;
	}
	
	//to calculate the inheritance of a parent class recursively
	public int getNoOfParentClass(Class obj) {
		int count= 0;
		
		if (obj != null) {
			Class<?> cl2 = obj.getSuperclass();
			
			if (cl2 != null) {
				return count + getNoOfParentClass(cl2);
			}
			return 0;
		}
		else
			return 0;
	}

	public static List<ProgramStatementComplexity> getInheritanceCountForStatement(ComplexityMeasurements cm, Map<String, Integer> classInheritanceCounts) {
		
		BufferedReader br = cm.getBr();
		List<String> userClasses = cm.getUserDefinedClasses();
		String statement = null;
		
		int lineCount = 1;
		int leftBraces = 0;
		int rightBraces =0;
		
		int inheritanceCount = 0;
		boolean isClassFound = false;
		
		List<ProgramStatementComplexity> lineInheritanceCount = new ArrayList<>();
		
	   
	    try {
			while((statement = br.readLine())!= null) {
				if(statement.contains(" ") && statement.contains("\"")) {
					String[] parts = statement.split(" ");
					
					int index = 0;
					
					for(String part: parts) {
						if(part.equals(Keywords.CLASS)) {
							String className = parts[index + 1];
							
							if(classInheritanceCounts.containsKey(className)) {
								isClassFound = true;
								inheritanceCount = classInheritanceCounts.get(className);
							}
						}
						index ++;
					}
					
				}
				
				if(statement.contains("{")) {
					leftBraces ++;
				}
				if(statement.contains("}")) {
					rightBraces ++;
				}
				if ((leftBraces == rightBraces) && (leftBraces > 0) && (rightBraces > 0)) {
					inheritanceCount = 0;
					isClassFound = false;
					leftBraces = 0;
					rightBraces = 0;
				}
				
				ProgramStatementComplexity psc = new ProgramStatementComplexity();
				psc.setLineNumber(lineCount);
				psc.setInheritanceCount(inheritanceCount);
				lineInheritanceCount.add(psc);
				
				lineCount++;
			}
	    } catch (IOException e) {
			e.printStackTrace();
		}
		
		return lineInheritanceCount;

	}

	//calculate control structure measurements
	public static List<String> calculateRecursionMeasurements(ComplexityMeasurements cm) throws IOException{
		
	BufferedReader br= cm.getBr();
	String statement = null;
	int leftBraces =0 ;
	int rightBraces =0;
	List<String> methodList = new ArrayList<>();
	List<String> recursiveMethods = new ArrayList<>();
	boolean isMethodFound = false;
	int count = 0;
	
//	statement  = br.readLine();
	
	while((statement  = br.readLine()) != null) {
		
		boolean isMethod = false;
		boolean isFirstLine = false;
		
		if (!statement.contains("\"") && statement.contains(" ")) {
			String[] parts = statement.split(" ");
			
			if (parts.length > 0) {
				parts[0] = parts[0].trim();
				
				for (String return_type: Keywords.RETURNTYPES) {
					if (parts[0].equals("PUBLIC") || parts[0].equals(Keywords.STATIC) || parts[0].equals(return_type)) {
						statement = statement.replaceAll(Keywords.PUBLIC, " ");
						statement = statement.replaceAll(Keywords.STATIC, " ");
						statement = statement.replaceAll(return_type, " ");
						isMethod = true;
					}
				}
				if (statement.contains("(") && isMethod) {
					String[] method = statement.split(Pattern.quote("("));
					
					if (!method[0].trim().isEmpty()) {
						methodList.add(method[0].trim());
						isMethodFound = true;
						isFirstLine = true;
					}
				}
			}
			
			
		}
		if (!statement.contains("\"") && statement.contains("}") && isMethodFound) {
			rightBraces++;
		}
		
		if (statement.contains("{") && isMethodFound) {
			leftBraces++;
		}
	
		//checking whether the recursive method is called within the scope
		if (statement.contains(" ") && isMethodFound) {
			String[] parts = statement.split(" ");
			
			statement = statement.replaceAll(Pattern.quote("("), " ");
			statement = statement.replaceAll(Pattern.quote(")"), " ");
			
			String[] sub_parts = statement.split(" ");
			
			for (String part: sub_parts) {
				if (methodList.contains(part.trim()) && !part.contains("\"") && !isFirstLine) {
					System.out.println(part + " is a recursive method and recursion was found in line no. " + (count + 1));
					
					//adding the recursive method to the list
					if (!recursiveMethods.contains(part))
						recursiveMethods.add(part);
				}
			}
			if ((leftBraces == rightBraces) && (leftBraces > 0) && (rightBraces > 0)) {
				System.out.println("The method ends at line no. " + (count + 1));
				isMethodFound = false;
				leftBraces = 0;
				rightBraces = 0;
				methodList.clear();
			}
			isFirstLine = false;
			count++;
		}
	}
	return recursiveMethods;
	}
	
	
	public static List<ProgramStatementComplexity> getRecursionCountforStatement(ComplexityMeasurements cm, List<String> recursionMethods) throws IOException {
		
			BufferedReader br = cm.getBr();
			String statement = null;
			int lineCount = 1;
			int leftBraces = 0;
			int rightBraces = 0;
			boolean isRecursionMethodFound = false;
			boolean isRecursionStatement = false;
			boolean isFirstLine = false;
			boolean isMethod = false;
			List<ProgramStatementComplexity> lineRecursionCounts = new ArrayList<>();
			
			while ((statement = br.readLine()) != null) {
				if (statement.contains(" ") && !statement.contains("\"")) {
					String[] parts = statement.split(" ");
					
					if (parts.length > 0) {
						parts[0] = parts[0].trim();
						
//						for (String return_type: Keywords.RETURNTYPES) {
//							if (parts[0].equals(Keywords.PUBLIC) || parts[0].equalsIgnoreCase(Keywords.STATIC) || parts[0].equals(return_type)) {
//								statement = statement.replaceAll(Keywords.PUBLIC, " ");
//								statement = statement.replaceAll(Keywords.STATIC, " ");
//								statement = statement.replaceAll(return_type, " ");
//								isMethod = true;
//							}
//						}
						if (statement.contains("(") && isMethod) {
							String[] method = statement.split(Pattern.quote("("));
							
							for (String methodPart: method) {
								if (!methodPart.isEmpty()) {
									if (recursionMethods.contains(methodPart.trim())) {
										isRecursionStatement = true;
										isRecursionMethodFound = true;
									}
								}
							}

						}
					}
							
					
				}
				
				if (statement.contains("{") && isRecursionMethodFound) {
					leftBraces++;
				}
				
				if (statement.contains("}") && !statement.contains("\"") && isRecursionMethodFound) {
					rightBraces++;
				}
				
				if ((leftBraces == rightBraces) && (leftBraces > 0) && (rightBraces > 0)) {
					isRecursionMethodFound = false;
					isRecursionStatement = false;
					leftBraces = 0;
					rightBraces = 0;
				}
				ProgramStatementComplexity psc = new ProgramStatementComplexity();
				psc.setLineNumber(lineCount);
				psc.setRecursionLine(isRecursionStatement);
				lineRecursionCounts.add(psc);
				
				lineCount++;
	
			}
			return lineRecursionCounts;
	}
	
	
}
