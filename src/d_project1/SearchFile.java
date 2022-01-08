package d_project1;
import java.io.*;

/********************************************************************************/
public class SearchFile {
	final int NOT_FOUND = -1;
	private file fileObj;
	private int[] buffer;
	private int[] lpBuffer;
	private DataInputStream inFile;
	private int diskAccessMeter;
	
/********************************************************************************/
	public SearchFile(String filename, int key) throws IOException{
		System.out.println();
		System.out.println("Serial Search on disk pages");
		System.out.println("*************************************************");
		fileObj = new file(0);
		buffer = new int[this.fileObj.PAGE_SIZE];
		this.setDiskAccessMeter(0);
		SearchPages(key, filename);
		System.out.println("Disk accesses:"+this.getDiskAccessMeter());
	}
	
/********************************************************************************/
	public void SearchPages(int key, String filename) throws IOException{
		inFile = new DataInputStream(new FileInputStream(filename));
		int i, j, result;
		int lastPageElems;
		for (i=0; i<this.fileObj.PAGES; i++){
			System.out.println("Looking for key:"+key+" on page:"+(i+1));
			this.setDiskAccessMeter(this.getDiskAccessMeter()+1);
			//Reading a page from the disk.
			for (j=0; j<this.fileObj.PAGE_SIZE; j++){
				buffer[j] = inFile.readInt();
			}
			//Looking on the page for the key.
			result = myBinarySearch(key, buffer);
			if (result != NOT_FOUND){
				System.out.println("Found on page:"+(i+1));
				System.out.println("Disk accesses:"+this.getDiskAccessMeter());
				inFile.close();
				return;
			}
		}
		
		// Looking for the key on the last page that has less than 256 integers
		lastPageElems = (this.fileObj.N)-(i*this.fileObj.PAGE_SIZE);
		lpBuffer = new int[lastPageElems];
		System.out.println("Looking for key:"+key+" on page:"+(i+1));
		this.setDiskAccessMeter(this.getDiskAccessMeter()+1);
		for (j=0; j<lastPageElems; j++){
			lpBuffer[j] = inFile.readInt();
		}
		result = myBinarySearch(key, lpBuffer);
		if (result != NOT_FOUND){
			System.out.println("Found on page:"+(i+1));
			inFile.close();
			return;
		}
		System.out.println("The key is not found.");
		inFile.close();
	}
	
/********************************************************************************/
	public int myBinarySearch(int key, int[] auxBuffer) {
		for (int i =0;i< auxBuffer.length;i++){
			if (key == auxBuffer[i]){
				return 1;
			}
		}
		return -1;
	}
	
	
public file getFileObj() {
	return fileObj;
}

public void setFileObj(file fileObj) {
	this.fileObj = fileObj;
}

public int[] getBuffer() {
	return buffer;
}

public void setBuffer(int[] buffer) {
	this.buffer = buffer;
}

public int[] getLpBuffer() {
	return lpBuffer;
}

public void setLpBuffer(int[] lpBuffer) {
	this.lpBuffer = lpBuffer;
}

public DataInputStream getInFile() {
	return inFile;
}

public void setInFile(DataInputStream inFile) {
	this.inFile = inFile;
}

public int getDiskAccessMeter() {
	return diskAccessMeter;
}

public void setDiskAccessMeter(int diskAccessMeter) {
	this.diskAccessMeter = diskAccessMeter;
}

public int getNOT_FOUND() {
	return NOT_FOUND;
}
	
}