import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CharCount {
	public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
		if(args.length<2) {
			System.out.println("Too Few Arguments....");
			System.exit(-1);
		}
		
		Job job = new Job();
		
		job.setJarByClass(CharCount.class);
		job.setJobName("Character Count");
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		if(job.waitForCompletion(true)) {
			System.exit(1);
		}
		else {
			System.exit(0);
		}
		//System.exit(?1:0);
	}
}
