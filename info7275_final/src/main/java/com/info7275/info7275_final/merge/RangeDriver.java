package com.info7275.info7275_final.merge;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;





public class RangeDriver {

	public static void main(String[] args) throws Exception {
		if (args.length != 3) {
			System.err.println("Usage: MaxSubmittedCharge <input path> <output path>");
			System.exit(-1);
		}

		Path inputPath = new Path(args[0]);
		Path outputDir = new Path(args[1]);
		Path outputsecond = new Path(args[2]);

		// Create configuration
		Configuration conf = new Configuration(true);

		// Create job
		Job job = Job.getInstance(conf);
		//Job job = new Job(conf, "SecondarySort");
		job.setJarByClass(AvgMapper.class);
		

		// Setup MapReduce
		job.setMapperClass(AvgMapper.class);
		job.setReducerClass(AvgReducer.class);
		//job.setPartitionerClass(MonthPartitioner.class);
		job.setNumReduceTasks(1);
		
		// Specify key / value
	
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(CountAverageTuple.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(CountAverageTuple.class);
		// Input
		FileInputFormat.addInputPath(job, inputPath);
		job.setInputFormatClass(TextInputFormat.class);

		// Output
		FileOutputFormat.setOutputPath(job, outputDir);

		// Delete output if exists
		FileSystem hdfs = FileSystem.get(conf);
		if (hdfs.exists(outputDir))
			hdfs.delete(outputDir, true);

		if (!job.waitForCompletion(true)) {
			  System.exit(1);
			}
		
		
		//job2
				Job job2 = Job.getInstance(conf, "sort by frequency");
				job2.setJarByClass(InvertMapper.class);
				job2.setMapperClass(InvertMapper.class);
				job2.setCombinerClass(InvertedIndexCombiner.class);
				job2.setReducerClass(InvertReducer.class);
				job2.setNumReduceTasks(1);
				
				job2.setMapOutputKeyClass(Text.class);
				job2.setMapOutputValueClass(Text.class);
				job2.setOutputKeyClass(Text.class);
				job2.setOutputValueClass(Text.class);
				job2.setInputFormatClass(TextInputFormat.class);
				job2.setOutputFormatClass(TextOutputFormat.class);
				FileInputFormat.addInputPath(job2, outputDir);
				FileOutputFormat.setOutputPath(job2, outputsecond);
				
				// Delete output if exists
				FileSystem hdfs2 = FileSystem.get(conf);
				if (hdfs.exists(outputsecond))
					hdfs.delete(outputsecond, true);
				
				if (!job2.waitForCompletion(true)) {
				  System.exit(1);
				}

	}

}
