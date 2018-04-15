import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
	public void reduce(Text Column, Iterable<IntWritable> Values, Context context) throws IOException, InterruptedException {
		int max = 0;
		for(IntWritable value : Values) {
			int val = value.get();
			if(max<val) {
				max = val;
			}
		}
		context.write(Column,new IntWritable(max));
	}
}
