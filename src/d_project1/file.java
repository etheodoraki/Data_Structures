package d_project1;

import java.io.*;
import java.util.Random;

/********************************************************************************/
public class file {
	final int ON = 1;
	final int N = 1000000;                //Number of integers
	final int PAGE_SIZE = 128;             //Size of the page
	final int PAGES = N/PAGE_SIZE;         //Number of pages except the last one
	final String FILE_NAME = "My File.bin"; //Name of the file
	private DataOutputStream myFile;
	int[] myBuffer;                        //The basic buffer 
	Random rand = new Random();
	
/********************************************************************************/	
	public file(int enable) throws IOException{
		myBuffer = new int[PAGE_SIZE];
		if (enable == ON){
			System.out.println("Filling the file.Please wait...");
			fillFile();
			System.out.println("The procedure has finished successfully!");
		}
	}

/********************************************************************************/	
	public void fillFile() throws IOException{
		myFile = new DataOutputStream(new FileOutputStream(FILE_NAME));
		int i,j;
		int[] auxBuffer;
		for (i=0; i<PAGES; i++){
			for (j=0; j<PAGE_SIZE; j++){    //Filling the buffer with 128 integers
				this.myBuffer[j] = rand.nextInt(N+1);
			}
			for (j=0; j<PAGE_SIZE; j++){    //Copy elements from the buffer to 
											//the binary file.	
				myFile.writeInt(this.myBuffer[j]);
			}
		}
		int leftPages = N - i*PAGE_SIZE;    //The last page has less than 128 elements.It has leftPages elements. 
		System.out.println(leftPages);      //
		auxBuffer = new int[leftPages];     //We use auxBuffer to copy these elements to the disk.
		                                    
		System.out.println("-------------- Last Page ---------------");
		for (j=0; j<leftPages; j++){
			auxBuffer[j] = rand.nextInt(N+1);
			//System.out.println(auxBuffer[j]);
		}
		for (j=0; j<leftPages; j++){
			myFile.writeInt(auxBuffer[j]);
			System.out.println(auxBuffer[j]);
		}
		myFile.close();
	}

public DataOutputStream getMyFile() {
	return myFile;
}

public void setMyFile(DataOutputStream myFile) {
	this.myFile = myFile;
}

public int[] getMyBuffer() {
	return myBuffer;
}

public void setMyBuffer(int[] myBuffer) {
	this.myBuffer = myBuffer;
}

public int getON() {
	return ON;
}

public int getN() {
	return N;
}

public int getPAGE_SIZE() {
	return PAGE_SIZE;
}

public int getPAGES() {
	return PAGES;
}

public String getFILE_NAME() {
	return FILE_NAME;
}
	
}