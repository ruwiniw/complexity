<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.io.*,models.*,java.util.*" %>
<head>
    <script src="https://unpkg.com/ag-grid/dist/ag-grid.min.noStyle.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/ag-grid/dist/styles/ag-grid.css">
    <link rel="stylesheet" href="https://unpkg.com/ag-grid/dist/styles/ag-theme-balham.css">
    <link rel="stylesheet" href="External/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap-grid.min.css">    
</head>
<body>

	<% try { %>
   <%   
		List<ProgramStatementComplexity> programComplexity = ( List<ProgramStatementComplexity> ) session.getAttribute("ProgramComplexity");
   		String fileName = session.getAttribute("filePath").toString();
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String statement = null;
		int lineNumber = 0;
		int totalComplexity = 0;
		
		int last = fileName.lastIndexOf("\\");
		String programName = fileName.substring(last + 1);
	%>

    <%@include file="header.jsp" %>

<div id="myGrid" style="height:50px;" class="ag-theme-balham"></div>
	<div class="container">
		<div class="row">		
			<form >
				<table class="table table-striped table-bordered">
					<thead>	
						<tr>
							<th>Line no.</th>
							<th>Statement</th>
							<th>Size Count (Cs)</th>
							<th>Nested Control Count (CnC)</th>
							<th>Control Structure Count (CtC)</th>
							<th>Inheritance Count (Ci)</th>
							<th>Total Weight (TW)</th>
							<th>Program Statement Complexity (Cps)</th>
							<th>Recursion Count (Cr)</th>
						</tr>
					</thead>
					
					<tbody>
					
						<% while ((statement = br.readLine()) != null) { %>
						
						<tr>
							<td><%=(lineNumber + 1) %></td>
							<td><%=statement %></td>
							<td><%=programComplexity.get(lineNumber).getSizeCount() %></td>
							<td><%=programComplexity.get(lineNumber).getNestedLevelCount() %></td>
							<td><%=programComplexity.get(lineNumber).getControlCount() %></td>
							<td><%=programComplexity.get(lineNumber).getInheritanceCount() %></td>
							<td><%=programComplexity.get(lineNumber).getTotalWeight() %></td>
							<td><%=programComplexity.get(lineNumber).getTotalComplexity() %></td>
							<td><%=programComplexity.get(lineNumber).getRecursionCount() %></td>
							<% programComplexity.get(lineNumber).setProgramStatement(statement); %>							
						</tr>
						<% if (programComplexity.get(lineNumber).getRecursionCount() == 0) {
								totalComplexity += programComplexity.get(lineNumber).getTotalComplexity();
							}
						else {
							totalComplexity += programComplexity.get(lineNumber).getRecursionCount();
						}
						%>
						<% lineNumber++; %>								
						<% } %>
						<tr>
							<td>Total Complexity</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><%=totalComplexity %></td>
						</tr>
					</tbody>
				</table>
		
				
			</form>
		</div>
	</div>
	<% } catch (Exception ex) { %>
	<div><%=ex.getMessage() %></div>
	<% } %>

</body>
</html>











<!-- <script type="text/javascript" charset="utf-8">

const columnDefs = [
    {headerName: 'Line', field: 'line', resizable: true, width: 75, suppressSizeToFit: true},
    {headerName: 'Program statement', field: 'stmt', resizable: true, minWidth: 400},
    {headerName: 'Tokens  under the size factor', field: 'token', resizable: true, minWidth: 200},
    {headerName: 'Cs', field: 'cs', resizable: true, width: 50},
    {headerName: 'Ctc', field: 'ctc', resizable: true, width: 50},
    {headerName: 'Cnc', field: 'cnc', resizable: true, width: 50},
    {headerName: 'Ci', field: 'ci', resizable: true, width: 50},
    {headerName: 'TW', field: 'tw', resizable: true, width: 50},
    {headerName: 'Cps', field: 'cps', resizable: true, width: 50},
    {headerName: 'Cr', field: 'cr', resizable: true, width: 50}
];
const rowData = [
                 {line: '1', stmt: 'public class FibonacciMain {', token:'', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '2', stmt: 'public static long fibonacci(long number) {', token: 'long, fibonacci, long, number', cs : 4, ctc : 0, cnc : 0 ,ci : 2 ,tw : 2 ,cps : 8 ,cr : 16},
                 {line: '3', stmt: 'if ((number == 0) || (number == 1)) { // base cases', token: 'if, number, ==, 0, ||, number, ==, 1', cs : 8, ctc : 2, cnc : 1 ,ci : 2 ,tw : 5 ,cps : 40 ,cr : 80},
                 {line: '4', stmt: 'return number;', token: 'number', cs : 1, ctc : 0, cnc : 1 ,ci : 2 ,tw : 3 ,cps : 3 ,cr : 6},
                 {line: '', stmt: '}', token: '', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '5', stmt: 'else {', token: '', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '', stmt: '// recursion step', token: '', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '6', stmt: 'return fibonacci(number - 1) + fibonacci(number - 2);', token: 'fibonacci, number, -, 1, +, fibonacci, number, -, 2', cs : 9, ctc : 0, cnc : 1 ,ci : 2 ,tw : 3 ,cps : 27 ,cr : 54},
                 {line: '', stmt: '}', token: '', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '', stmt: '}', token: '', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '7', stmt: 'public static void main(String args[ ]) {', token: 'void, main, String, args', cs : 4, ctc : 0, cnc : 0 ,ci : 2 ,tw : 2 ,cps : 8 ,cr : ''},
                 {line: '8', stmt: 'for (int count = 0; count <= 10; count++){', token: 'for, int, count, =, 0, count, <=, 10, count, ++', cs : 10, ctc : 2, cnc : 1 ,ci : 2 ,tw : 5 ,cps : 50 ,cr : ''},
                 {line: '9', stmt: 'System.out.println("Fibonacci of " + count + " is " + fibonacci(count));', token: 'System, ., out, ., println, "Fibonacci of ", +, count, +, " is ", +, fibonacci, count', cs : 13, ctc : 0, cnc : 1 ,ci : 2 ,tw : 4 ,cps : 39 ,cr : ''},
                 {line: '', stmt: '}', token: '', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '', stmt: '}', token: '', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '', stmt: '}', token: '', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : ''},
                 {line: '', stmt: '', token: 'Cp', cs : '', ctc : '', cnc : '' ,ci : '' ,tw : '' ,cps : '' ,cr : 253},
                 
];
const gridOptions = {
    columnDefs: columnDefs,
    rowData: rowData
};
const eGridDiv = document.querySelector('#myGrid');
new agGrid.Grid(eGridDiv, gridOptions);
 gridOptions.api.sizeColumnsToFit();

</script> -->


