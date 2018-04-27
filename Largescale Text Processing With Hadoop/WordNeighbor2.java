

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WordNeighbor2 implements Writable, WritableComparable<WordNeighbor2>{

    Text word;
    Text neighbor;
    Text nextNeighbor;

    public WordNeighbor2() {
	this.word = new Text();
	this.neighbor = new Text();
	this.nextNeighbor = new Text();
    }

    public void setWord(String word){
        this.word.set(word);
    }
    public void setNeighbor(String neighbor){
        this.neighbor.set(neighbor);
    }
    public void setNextNeighbor(String neighbor){
        this.nextNeighbor.set(neighbor);
    }
    public Text getWord(){
        return word;
    }

    public Text getNeighbor() {
        return neighbor;
    }
    
    public Text getNextNeighbor() {
        return nextNeighbor;
    }
    
    @Override
    public void write(DataOutput o) throws IOException {
        word.write(o);
        neighbor.write(o);
        nextNeighbor.write(o);
    }

    @Override
	public int compareTo(WordNeighbor2 o) {
		
    	return((this.word.toString().compareToIgnoreCase(o.word.toString())));
		
	}

	@Override
    public void readFields(DataInput i) throws IOException {
        word.readFields(i);
        neighbor.readFields(i);
        nextNeighbor.readFields(i);
    }

	@Override
	public String toString() {
		return "WordNeighbor2 [word=" + word + ", neighbor=" + neighbor + "nextNeighbor=" + nextNeighbor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nextNeighbor == null) ? 0 :nextNeighbor.hashCode());
		result = prime * result + ((neighbor == null) ? 0 : neighbor.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordNeighbor2 other = (WordNeighbor2) obj;
		if (neighbor == null) {
			if (other.neighbor != null)
				return false;
		} else if (!neighbor.equals(other.neighbor))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
    
   

    
}
