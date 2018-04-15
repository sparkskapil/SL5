import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable,Text,Text,IntWritable>{
	private Text Column1 = new Text("Column1");
	private Text Column2 = new Text("Column2");
	
	public void map(LongWritable Key, Text Value, Context context) throws IOException, InterruptedException {
		String line = Value.toString();
		String Cols[] = line.split(",");
		context.write(Column1, new IntWritable(Integer.parseInt(Cols[0])));
		context.write(Column2, new IntWritable(Integer.parseInt(Cols[1])));
	}
}
