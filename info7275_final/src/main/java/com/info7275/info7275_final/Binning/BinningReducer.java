package com.info7275.info7275_final.Binning;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Hello world!
 *
 */
public class BinningReducer  extends
						Reducer<Text, NullWritable, Text, NullWritable> {

	
	protected void reduce(Text key, Iterable<NullWritable> values,
					Context context) throws IOException, InterruptedException {
			
		
		
		context.write(key, NullWritable.get());
	}

}
