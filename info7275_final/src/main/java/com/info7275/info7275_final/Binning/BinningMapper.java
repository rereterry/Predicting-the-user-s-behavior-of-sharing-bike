package com.info7275.info7275_final.Binning;

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





public class BinningMapper extends Mapper<Object, Text, Text, NullWritable> {

	private Text outkey = new Text();
	private MultipleOutputs<Text, NullWritable> mos = null;
	@Override
	protected void setup(Context context) {
		mos = new MultipleOutputs<Text, NullWritable>(context);
		
	}

	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] field = value.toString().split(",");
		String type = field[2];
			
		System.out.println(type);
		if(type.equals("season")){
			return;
		}
		int t = Integer.parseInt(type);
		if (t==1) {
			outkey.set(field[14] +"," +field[15] + ","+ field[16]);
            mos.write("datatype", value, NullWritable.get(), "01");
        }
        if (t==2) {
        	outkey.set(field[14] +"," +field[15] + ","+ field[16]);
        	mos.write("datatype", value, NullWritable.get(), "02");
        }
        if (t==3) {
        	outkey.set(field[14] +"," +field[15] + ","+ field[16]);
        	mos.write("datatype", value, NullWritable.get(), "03");
        }
        if (t==4) {
        	outkey.set(field[14] +"," +field[15] + ","+ field[16]);
        	mos.write("datatype", value, NullWritable.get(), "04");
        }
        
       
		}

	

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {
		mos.close();
	}
            
            	
                
            
            
	
        
}
