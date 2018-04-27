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


class PairCooccurrenceMapper extends Mapper<LongWritable, Text, WordNeighbor, IntWritable> {

    WordNeighbor wn = new WordNeighbor();
    IntWritable one = new IntWritable(1);

    @Override
	protected void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException{
	String[] tokens = value.toString().split("\\s+");

	if(tokens.length > 1){
	    for(int i = 0; i < tokens.length; i++){
		for(int j = 0; j < tokens.length; j++){
		    wn.setWord(tokens[i]);
		    wn.setNeighbor(tokens[j]);
		    context.write(wn, one);
		}
	    }
	}
    }
}
