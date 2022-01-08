package d_project1;

import java.io.*;

public class FileManager {
	
	private RandomAccessFile f;
	
	final int PAGE_SIZE = 512;  

	
	private static int curPage, fileSize;
	private byte[] b = new byte[PAGE_SIZE];
	
	//Constructor
	public FileManager()
	{
		
	}
	
		//File Handle
	
	public int FileHandle()
	
	{
		return 0 ; //if not successful
	}
	
		//Creating File
	
	public int createFile(String NameOfFile)                       
	{				
		int fileSize = 0;
		try{
			f = new RandomAccessFile(NameOfFile,"rw");
			this.setF(f);
			fileSize = (int) Math.ceil((f.length())/PAGE_SIZE);
		}
		catch(IOException e){
			System.out.println("Error opening the file...");
		}
		return fileSize;
	}
	
		//Opening File
	
	public int openFile(String FILE_NAME)
	{
		
		return 0;      //if not successful
	}

	int readBlock(int page) throws IOException{
		int blockPage = page*PAGE_SIZE;
		f.seek(blockPage);
		f.read(b);
		curPage = blockPage;
		return 0;
	}
	int ReadNextBlock() throws IOException{
		if(curPage < fileSize){
			readBlock(curPage++);
		}
		return 0;
	}

	int ReadPrevBlock() throws IOException{
		if(curPage > 1){
			curPage--;
			readBlock(curPage);
		}
		return 0;
	}
	
	int writeBlock(int page) throws IOException{
		int blockPage = page*PAGE_SIZE;
		if(page <= fileSize){
			f.seek(blockPage);
			f.write(b);
			curPage=blockPage;

		}
		return 0;
	}

	int WriteNextBlock() throws IOException{
		curPage++;
		if(curPage > fileSize){
			fileSize++;
		}	
		writeBlock(curPage);
		return 0;
	}
	
	
	int AppendBlock() throws IOException{
		int xPage = curPage;
		while (curPage!= fileSize) 
		{
			curPage++;
		}
		int w = WriteNextBlock();
		curPage = xPage;
		return 1;
	}
	int DeleteBlock(){
		
		return 1;
	}
	public void closeFile() throws IOException{
		f.close();
	}	
	
	//Setters-Getters
	
	public RandomAccessFile getF() {
		return f;
	}
	public void setF(RandomAccessFile f) {
		this.f = f;
	}	
}
