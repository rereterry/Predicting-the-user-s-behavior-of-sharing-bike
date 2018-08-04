package com.info7275.info7275_final.merge;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

/**
 * Hello world!
 *
 */
public class CountAverageTuple implements Writable
{

	float registered;
	float casual;
	float count;
	
	
	public float getRegistered() {
		return registered;
	}

	public void setRegistered(float stockAvg) {
		this.registered = stockAvg;
	}
	
	public float getCasual() {
		return casual;
	}

	public void setCasual(float stockAvg) {
		this.casual = stockAvg;
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}

	
	
	
	
	
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeFloat(registered);
		out.writeFloat(casual);
		out.writeFloat(count);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		registered = in.readFloat();
		casual = in.readFloat();
		count = in.readFloat();
	}
	
	public String toString() {
		return (new StringBuilder().append(registered).append("\t").append(casual).append("\t").append(count).toString());
	}


    
}
