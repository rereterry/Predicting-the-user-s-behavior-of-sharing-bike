package com.info7275.info7275_final.merge;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class AvgMapper extends Mapper<Object, Text, Text, CountAverageTuple> {

	private Text outkey = new Text();
	private CountAverageTuple outCountAverage = new CountAverageTuple();
	private Text out_number = new Text();
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {


        String[] fields = value.toString().split(",");
        String year = fields[3];
        if(year.equals("0")) year = "2011";
        if(year.equals("1")) year = "2012";
        String month = fields[4];
        if(year.equals("yr") || month.equals("mnth")){
			return;
		}
        //System.out.println(fields[15]);
        
			float x = Float.parseFloat(fields[13]);
			float y = Float.parseFloat(fields[14]);
			//System.out.println(x);
			
			outkey.set(year +"(" + month + ")");
			out_number.set(fields[13] + "/t" + fields[14]);
			outCountAverage.setCount(1);
			outCountAverage.setCasual(x);
			outCountAverage.setRegistered(y);
			
            context.write(outkey, outCountAverage);

	}

}