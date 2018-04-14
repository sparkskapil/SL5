import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable,Text,Text,IntWritable>{
	private Text key = new Text();
	private final static IntWritable one = new IntWritable(1);
	
	public void map(LongWritable Key, Text Value, Context context) throws IOException, InterruptedException {
		String line  = Value.toString();
		StringTokenizer itr = new StringTokenizer(line);
		while(itr.hasMoreTokens()) {
			key.set(itr.nextToken());
			context.write(key, one);
		}
	}
}
