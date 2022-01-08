package d_project1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.io.*;
import java.nio.Buffer;
@SuppressWarnings("unused")

public class PoolManager {
	final int ZERO_ACCESSES = 0;
	final int NOT_FOUND = -1;
	final int FOUND = 1;
	final int OFF = 0;
	final int ON = 1;
	final int EMPTY = 0;
	
	file f;
	
	Queue<int[]> bufferPool;
	private int poolSize;
	private int diskAccessMeter;
	private String status;
	
	private int K;
	
	public PoolManager() 
	{

	}
	
	final int FULL = K;	
	//Creating the buffer pool
	public void CreatePool(int length) throws IOException
	{
		f = new file(OFF);
		K = length;
		bufferPool = new LinkedList<int[]>();
		this.setDiskAccessMeter(0);
	}
	//Freeing memory for pool
	public void FreePool()
	{
		bufferPool.clear();
	}
	
	//**************************************************************Setters-Getters
	public file getFileObj() {
		return f;
	}

	public void setFileObj(file fileObj) {
		this.f = fileObj;
	}

	public Queue<int[]> getBufferPool() {
		return bufferPool;
	}

	public void setBufferPool(Queue<int[]> bufferPool) {
		this.bufferPool = bufferPool;
	}

	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}


	public int getDiskAccessMeter() {
		return diskAccessMeter;
	}


	public void setDiskAccessMeter(int diskAccessMeter) {
		this.diskAccessMeter = diskAccessMeter;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getK() {
		return K;
	}


	public void setK(int k) {
		K = k;
	}


	public int getZERO_ACCESSES() {
		return ZERO_ACCESSES;
	}


	public int getNOT_FOUND() {
		return NOT_FOUND;
	}


	public int getFOUND() {
		return FOUND;
	}


	public int getOFF() {
		return OFF;
	}


	public int getON() {
		return ON;
	}


	public int getEMPTY() {
		return EMPTY;
	}

	public int getFULL() {
		return FULL;
	}	
}