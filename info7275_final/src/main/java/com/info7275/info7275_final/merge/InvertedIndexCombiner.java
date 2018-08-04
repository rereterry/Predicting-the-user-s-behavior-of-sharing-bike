package com.info7275.info7275_final.merge;

import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

import org.apache.hadoop.io.Text;

/**
 * Hello world!
 *
 */
public class InvertedIndexCombiner extends Reducer<Text, Text, Text, Text> {
    
	private Text info = new Text();
    
	public void reduce(Text key, Iterable<Text>values, Context context) throws IOException, InterruptedException {
        
		//统计词频
        int sum = 0;
        
        for(Text value : values) {
            
            context.write(key, value);
        }
        

    }
}