
import java.io.IOException;


public class Reader {
	
    public static void main(String[] args) throws IOException {

        try {
        	
            System.out.println("Reading file using Buffered Reader");

//            CalculateComplexity.getComplexity("/Users/ASUS/SPM_TestDoc1.txt");
//            CalculateComplexity.getComplexity("/Users/ASUS/SPM_TestDoc2.txt");
//            CalculateComplexity.getComplexity("/Users/ASUS/SPM_TestDoc.txt");
              CalculateComplexity.getComplexity("C:\\Users\\ASUS\\SPM_TestDoc2.txt");

	        
        }catch (Exception e) {
	            e.printStackTrace();
	    }        
    }
}


	
	
	
	
	