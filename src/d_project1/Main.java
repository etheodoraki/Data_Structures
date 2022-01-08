package d_project1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException{
		final int OFF = 0;
		final int ON = 1;
		Random rand = new Random();
		final int N = 1000000;
		final int SerialSearchTimes = 10000;
		final String filename = "My File.bin";
		
		
		FileManager fm = new FileManager();		
		RandomAccessFile MyFile;
		file f = new file(OFF);
		PoolManager pm;
				
//******************************** MENU ********************************
		
	     int choice = 0;
	     
	     System.out.println("Please select a choice of the above:");
	     System.out.println("1. Create - open file. \n2. Read block.\n3. Read next block.\n4. Read previous block.\n5. Write block.\n6. Write next block.\n7. Append block.\n8. Delete block.\n9. Close file.\n10. Random Serial Search in File.\n11. Search in File using Buffer Pool with K=1000.\n12. Search in File using Buffer Pool with K=10.000.\n13. Exit.");
		 Scanner s = new Scanner(System.in);	
		 choice = s.nextInt();
		 
		 while(choice!=13){
	     switch (choice) {
	            case 1: System.out.println("1. Create - open file.");
	            		fm.createFile("My File.bin");
	            		MyFile = fm.getF();
	            		f = new file(ON);
	                     break;
	            case 2:  System.out.println("2. Read block.");
	            		System.out.println("Which page do you want to read?");
	            		int pagetoread = s.nextInt();
	            		fm.readBlock(pagetoread);
	                     break;
	            case 3:  System.out.println("3. Read next block.");
	            		fm.ReadNextBlock();
	                     break;
	            case 4:  System.out.println("4. Read previous block.");
	            		fm.ReadPrevBlock();
	                     break;
	            case 5:  System.out.println("5. Write block.");
	            		System.out.println("In which page do you want to write?");
	            		int pagetowrite = s.nextInt();
	            		fm.writeBlock(pagetowrite);
	                     break;
	            case 6:  System.out.println("6. Write next block.");
	            		fm.WriteNextBlock();
	                     break;
	            case 7:  System.out.println("7. Append block.");
	            		fm.AppendBlock();
	                     break;
	            case 8:  System.out.println("8. Delete block.");
	            		fm.DeleteBlock();
	                     break;
	            case 9:  System.out.println("9. Close file.");
	            		fm.closeFile();
	                     break;
	            case 10: System.out.println("10. Random Serial Search in File.");
	            		SearchFile search;
	            		for (int k = 0; k < SerialSearchTimes;k++){
	            			int key = rand.nextInt(N+1);
	            			search = new SearchFile(filename,key);
	            		}
	            		 break;
	            case 11: System.out.println("11. Search in File using Buffer Pool with K=1000.");
	            		 pm = new PoolManager ();
	            		 pm.CreatePool(500);
	            		 break;
	            case 12: System.out.println("12. Search in File using Buffer Pool with K=10.000.");
	            		pm = new PoolManager ();
	            		 pm.CreatePool(1000);
	            		 break;
	            case 13: System.out.println("13. Exit.");
	            		 break;
	            default: System.out.println("Invalid choice.");
	                     break;
	        }
	    System.out.println("Please select a choice of the above:");
	     System.out.println("1. Create - open file. \n2. Read block.\n3. Read next block.\n4. Read previous block.\n5. Write block.\n6. Write next block.\n7. Append block.\n8. Delete block.\n9. Close file.\n10. Random Serial Search in File.\n11. Search in File using Buffer Pool with K=1000.\n12. Search in File using Buffer Pool with K=10.000.\n13. Exit.");
		 choice = s.nextInt();

		}
	        
	       
			
			s.close();
	}
}	

