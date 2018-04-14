import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	public void reduce(Text Key, Iterable<IntWritable> Values, Context context) throws IOException, InterruptedException {
		int sum = 0;
		for(IntWritable Value: Values) {
			sum += Value.get();
		}
		context.write(Key, new IntWritable(sum));
	}

}
