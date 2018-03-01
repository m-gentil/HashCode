import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class HashCodeMain{

  public static void main(String[] args){
    //inputname
    String inputf=args[0];
	int RAWS=0;
	int COLS=0;
	int NUMV=0;
	int NUMR=0;
	int B=0;
	int T=0;
	int id=0;
	Vehicle[] vs;

	try{
	//reading one input run
	File file=new File(inputf);
	Scanner input=new Scanner(file);
	System.out.println("Parsing input file: "+file);
	String first=input.nextLine(); //read a line
	Scanner line=new Scanner(first);
	RAWS=Integer.parseInt(line.next()); //read the raws value
	COLS=Integer.parseInt(line.next()); //read the cols value
	NUMV=Integer.parseInt(line.next()); //read the vehicle value
	vs=new Vehicle(NUMV);
	NUMR=Integer.parseInt(line.next()); //read the rides value
	B=Integer.parseInt(line.next()); //read the bonus value
	T=Integer.parseInt(line.next()); //read the steps value 
	ArrayList<Ride> rides=new ArrayList<>();

	while(input.hasNextLine()){
	  String ride=input.nextLine(); //read a line
	  line=new Scanner(ride);
	  int sr=Integer.parseInt(line.next()); //read the starting raw
	  int sc=Integer.parseInt(line.next()); //read the starting column
	  int er=Integer.parseInt(line.next()); //read the ending raw
	  int ec=Integer.parseInt(line.next()); //read the ending column
	  int early=Integer.parseInt(line.next()); //read the bonus value
	  int late=Integer.parseInt(line.next()); //read the steps value
	  Ride r=new Ride(id,sr,sc,er,ec,early,late);
	  id++;
	  rides.add(r);
	}
	input.close();
	}
	
	catch(IOException e){
	System.out.println(e);
	System.exit(0);
	}

    System.out.println("Succesfully parsed");

    //Writing the run file for condorcet strategy
    /*String fileName="results/condorcet-fuse.res";
    FileWriter fileWriter=null;
    try{
      fileWriter = new FileWriter(fileName);
    }
    catch(IOException e){
      System.exit(1);
    }
    PrintWriter printWriter = new PrintWriter(fileWriter);
    for(int y=0;y<50;y++){
      condorcet[y].defineRank();
      condorcet[y].reverse();
      printWriter.print(condorcet[y]);
    }
    System.out.println("Output of Condorcet-fuse in file "+fileName);
    printWriter.close();
	
*/

  }
}
