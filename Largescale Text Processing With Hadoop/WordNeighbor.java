import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WordNeighbor implements Writable, WritableComparable<WordNeighbor>{

    Text word;
    Text neighbor;

    public WordNeighbor() {
	this.word = new Text();
	this.neighbor = new Text();
    }

    public void setWord(String word){
        this.word.set(word);
    }
    public void setNeighbor(String neighbor){
        this.neighbor.set(neighbor);
    }
    public Text getWord() {
        return word;
    }

    public Text getNeighbor() {
        return neighbor;
    }

    public static WordNeighbor read(DataInput in) throws IOException {
        WordNeighbor wn = new WordNeighbor();
        wn.readFields(in);
        return wn;
    }


    @Override
    public int compareTo(WordNeighbor o) {
        return((this.word.toString().compareToIgnoreCase(o.word.toString())));
    }

    @Override
    public void write(DataOutput out) throws IOException {
        word.write(out);
        neighbor.write(out);
    }
    
    @Override
    public void readFields(DataInput in) throws IOException {
        word.readFields(in);
        neighbor.readFields(in);
    }

    
}
