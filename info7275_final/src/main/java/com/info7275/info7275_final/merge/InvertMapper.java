package com.info7275.info7275_final.merge;

import java.io.IOException;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;





public class InvertMapper extends Mapper<Object, Text, Text, Text> {

	private Text outkey = new Text();
	private Text valueInfo = new Text();
	

	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] field = value.toString().split("\t");
		String type = field[0];
			
		System.out.println(type);
		
		float x = Float.parseFloat(field[1]);
		float y = Float.parseFloat(field[2]);
		if( x > 1500 && x<=2000){
			outkey.set("Range : 1501~2000");
			valueInfo.set(type);
		}else if (x<=1500){
			outkey.set("Low than 1500 ");
			valueInfo.set(type);
		}else if (x<=3000 && x>2000){
			outkey.set("Range : 2001~3000 ");
			valueInfo.set(type);
		}else if (x<=4000 && x>3000){
			outkey.set("Range : 3001~4000 ");
			valueInfo.set(type);
		}else if (x<=5000 && x>4000){
			outkey.set("Range : 4001~5000 ");
			valueInfo.set(type);
		}else {
			outkey.set("More than 5000 ");
			valueInfo.set(type);
		}
		
        context.write(outkey, valueInfo);
        
       
		}

        
}
