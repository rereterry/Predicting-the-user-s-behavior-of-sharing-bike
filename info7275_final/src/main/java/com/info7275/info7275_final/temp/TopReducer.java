package com.info7275.info7275_final.temp;

import java.io.IOException;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Hello world!
 *
 */
public class TopReducer  extends
						Reducer<NullWritable, Text, NullWritable, Text> {

	private TreeMap<Integer, Text> fatcats = new TreeMap<Integer, Text>();
	
	protected void reduce(NullWritable key, Iterable<Text> values,
					Context context) throws IOException, InterruptedException {
		
		for (Text val : values) {
			System.out.println(val.toString());                
			String v[] = val.toString().split(",");
			               
			System.out.println(v[0]);
			                
			int user_number = Integer.parseInt(v[1]);
			                
			fatcats.put(user_number, new Text(val));
			                
			if (fatcats.size() > 5)
			                    
				fatcats.remove(fatcats.firstKey());
			            
		}
			           
		for (Text text: fatcats.values())
			                 
			context.write(NullWritable.get(), text);
			       
			
		
		
		
	}

}
