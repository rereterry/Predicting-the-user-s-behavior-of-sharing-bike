package com.info7275.info7275_final.merge;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Hello world!
 *
 */
public class InvertReducer  extends
						Reducer<Text, Text, Text, Text> {

	private Text result = new Text();
	
	protected void reduce(Text key, Iterable<Text> values,
					Context context) throws IOException, InterruptedException {
			
		
		
		 String fieldList = new String();
	        for(Text value : values) {
	        	//String[] fields = value.toString().split(">");
	   		 	//int i = Integer.parseInt(fields[1]);
	        	//if(i !=0)
	            fieldList += value + "; ";
	        	
	        }
	        result.set(fieldList);
		 
		 context.write(key, result);
	}

}
