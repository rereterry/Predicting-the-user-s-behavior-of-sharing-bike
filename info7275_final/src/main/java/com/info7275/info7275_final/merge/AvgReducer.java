package com.info7275.info7275_final.merge;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
 
public class AvgReducer extends
        Reducer<Text, CountAverageTuple, Text, CountAverageTuple> {
	
		private CountAverageTuple result = new CountAverageTuple();
 
	  public void reduce(Text key,Iterable<CountAverageTuple> values,Context context)
	            throws IOException, InterruptedException {
		
		  float sum1 =0;
		  float sum2 =0;
		  int count = 0;
		  for(CountAverageTuple val :values){
			  
			  sum1 += val.getCount()*val.getRegistered();
			  sum2 += val.getCount()*val.getCasual();
	          count += val.getCount();
			  ;
		  }
		  result.setCount(count);
		  result.setRegistered(sum1/count);
		  result.setCasual(sum2/count);
		  context.write(key, result);
		
	       
	    }
}