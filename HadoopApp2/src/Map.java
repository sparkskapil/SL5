import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable>{
	private Text key = new Text();
	private static IntWritable one = new IntWritable(1);
	public void map(LongWritable Key, Text Value,Context context) throws IOException, InterruptedException {
		String line = Value.toString();
		for(int i=0;i<line.length();i++) {
			key.set(Character.toString(line.charAt(i)));
			context.write(key, one);
		}
	}

}
