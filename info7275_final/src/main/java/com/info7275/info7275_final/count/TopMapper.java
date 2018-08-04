package com.info7275.info7275_final.count;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class TopMapper extends Mapper<Object, Text, NullWritable, Text> {


	private TreeMap<Integer, Text> repToRecordMap = new TreeMap<Integer, Text>();
       
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
               
           
            String[] fields = value.toString().split(",");
            
            String user = fields[1];
            int x = Integer.parseInt(user);
            //System.out.println(user);
            
			repToRecordMap.put(x,new Text(value));
			if (repToRecordMap.size() > 3) {  
                repToRecordMap.remove(repToRecordMap.firstKey());  
            }

	
        }
	protected void cleanup(Context context) throws IOException, InterruptedException {  
        for (Text text: repToRecordMap.values()) {  
              System.out.println(text.toString());
                
            	context.write(NullWritable.get(), text);  
              
        }  
    }  
}
