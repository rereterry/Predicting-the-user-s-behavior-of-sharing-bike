package com.info7275.info7275_final.temp;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class CountReducer extends Reducer<Text, IntWritable, Text, NullWritable> {

	 
	 private Text result = new Text();
	 
     
	 public void reduce(Text key, Iterable<IntWritable> values, Context context)
             throws IOException, InterruptedException {

		
		 
		 int fieldList = 0;
	        for(IntWritable value : values) {
	        	//String[] fields = value.toString().split(">");
	   		 	//int i = Integer.parseInt(fields[1]);
	        	//if(i !=0)
	            fieldList += value.get();
	        	
	        }
	        result.set(key + "," + String.valueOf(fieldList));
		 
		 context.write(result, NullWritable.get());

	        
	       
	        
     }
 }