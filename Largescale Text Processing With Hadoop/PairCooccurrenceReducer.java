import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


class PairCooccurrenceReducer extends Reducer<WordNeighbor, IntWritable, WordNeighbor, IntWritable>{

    IntWritable total = new IntWritable();

    @Override
    public void reduce(WordNeighbor key, Iterable<IntWritable> values, Context context)throws IOException, InterruptedException{
	int count = 0;
	for(IntWritable val : values){
	    count = count + val.get();
	}

	total.set(count);
	context.write(key, total);
    }
}
