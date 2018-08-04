package com.info7275.info7275_final.count;

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
        String every_hr = fields[5];
        
        System.out.println(fields[16]);
        if(fields[16].equals("cnt")){
			return;
		}
			int x = Integer.parseInt(fields[16]);
			//System.out.println(x);
			if(every_hr.equals("0"))
				every_hr = "24";
			outkey.set(every_hr);
			out_number.set(x);
			
            context.write(outkey, out_number);
            
       
    }
}
