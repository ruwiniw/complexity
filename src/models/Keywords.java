package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keywords {

	public static final String EXTENDS = "extends";
	public static final String IMPLEMENTS = "implements";
	public static final String STATIC = "static";
	public static final String PUBLIC = "public";
	public static final String IF = "if";
	public static final String FOR = "for";
	public static final String WHILE = "while";
	public static final String DOWHILE = "do-while";
	public static final String DO = "do";
	public static final String CATCH = "catch";
	public static final String SWITCH = "switch";
	public static final String CASE = "case";
	public static final String CLASS = "class";
	public static final String IMPORT = "import";
	public static final String DOT = ".";
	public static final String INTERFACE = "interface";
	public static final String CONTINUE = "continue";
	public static final String ELSE = "else";
	public static final String SUPER = "super";
	public static final String THROW = "throw";
	public static final String PRIVATE = "private";
	public static final List<String> JAVAKEYWORDS = new ArrayList<>(Arrays.asList("assert","default","final","null","const","this","try","break","synchronized","transient","boolean",
																				  "continue","else","finally","int","new","strict","this","try","true","break","char","default","enum",
																				  "float","implements","interface","package","return","super","throw","void","false","import","long",
																				  "private","short","throws","volatile","null","assert","const","double","final","goto","instanceof","native",
																				  "protected"));
	public static final List<String> RELATIONOPERATORS = new ArrayList<>(Arrays.asList("<",">","<=",">=","==","!="));
	public static final List<String> ARITHMETICOPERATORS = new ArrayList<>(Arrays.asList("+","-","*","/","%"));
	public static final List<String> LOGICALOPERATORS = new ArrayList<>(Arrays.asList("&&","!.","!"));
	public static final List<String> BITWISEOPERATORS =new ArrayList<>(Arrays.asList("|","^","~","<<",">>",">>>","<<<")			);
	public static final List<String> CONDITIONALLOGICALOPERATORS = new ArrayList<>(Arrays.asList("true","false","0","1"));
	public static final List<String> PRIMITIVETYPES =new ArrayList<>(Arrays.asList("boolean","byte","char","short","int","long","float","double"));
	public static final List<String> MISCELLANEOUSOPERATORS = new ArrayList<>(Arrays.asList(",","->",".","::"));
	public static final List<String> RETURNTYPES = new ArrayList<>(Arrays.asList("return"));
	public static final List<String> METHODDEFINITIONS = new ArrayList<>(Arrays.asList());
	public static final List<String> MANIPULATORS = new ArrayList<>(Arrays.asList("endl","\n","etc."));

}



//public static String[] ComplexitySettings = new String[]{ "abstract","byte","class","DO","EXTENDS","FOR","IF","WHILE","DO-WHILE","SWITCH","PUBLIC","IF","STATIC","CASE","CATCH",
//		 "import","long","private","short","throws","volatile","null","assert","const","double","final","goto","instanceof","native","protected",
//		 "synchronized","transient","boolean","continue","else","finally","int","new","strict","this","try","true","break","char","default","enum",
//		 "float","implements","interface","package","return","super","throw","void","false"									  
//		};