package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadGenerator {
	
	
	
	public static String generateStringPayload(String filename) throws IOException{
	
	
	
	String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\"+filename;
	
return new String(Files.readAllBytes(Paths.get(filePath)));
	
	//return new String(Files.readAllBytes(Paths.get(filePath)));
	
	}

}
