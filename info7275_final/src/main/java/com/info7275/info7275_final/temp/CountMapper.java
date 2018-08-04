package com.info7275.info7275_final.temp;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class CountMapper extends Mapper<Object, Text, Text, IntWritable> {

	private Text outkey = new Text();
	private IntWritable out_number = new IntWritable();
	private Text valueInfo = new Text();
	
       
	public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String[] fields = value.toString().split(",");
        String Temp = fields[9];
        
        //System.out.println(fields[15]);
        if(fields[15].equals("cnt")){
			return;
		}
			int x = Integer.parseInt(fields[15]);
			//System.out.println(x);
			
			outkey.set(Temp);
			out_number.set(x);
			
            context.write(outkey, out_number);
            
		
        
      


       
       
    }
}
