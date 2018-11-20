import java.io.*;

public class Record{

  private int best;

	public Record(){
		String fileName = "record.txt";
    String line = null;
    try {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while((line = bufferedReader.readLine()) != null) {
					best = Integer.parseInt(line);
          System.out.println(line);
        }
        bufferedReader.close();
    }
    catch(FileNotFoundException ex) {
        System.out.println("Unable to open file '" + fileName + "'");
    }
    catch(IOException ex) {
        System.out.println("Error reading file '" + fileName + "'");
    }
		System.out.println(best);
  }
	public int getRecord(){
		return best;
	}
	public void setRecord(int newr){
		if (best<newr) {
			String fileName = "record.txt";
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Integer.toString(newr));
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '"  + fileName + "'");
        }
		}
	}
}
