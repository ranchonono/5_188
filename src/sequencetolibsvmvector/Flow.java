package sequencetolibsvmvector;

import java.io.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author ×ÞÈ¨
 * @version 1.0
 */
public class Flow {
    String inputfile, outputfile, posOrNeg;
    public Flow(String inputfile, String outputfile, String posOrNeg) {
        this.inputfile = inputfile;
        this.outputfile = outputfile;
        this.posOrNeg = posOrNeg;
    }

    public void run() {
        try {   
            BufferedReader br = new BufferedReader(new FileReader("pos2.fasta"));
 
            BufferedWriter bw = new BufferedWriter(new FileWriter("pos2.arff"));
           
            bw.write("@relation Protein");
            bw.newLine();
            for(int i = 1;i<=188;i++){
               String tmp ="@attribute Feature"+String.valueOf(i)+" real";
               bw.write(tmp);
               bw.newLine();
               bw.flush();
           }
           bw.write("@attribute class {1,-1}");
           bw.newLine();
           bw.write("@data");
           bw.newLine();
           

            String line = br.readLine();
            while (br.ready()) {
                if (line.length() != 0 && line.charAt(0) == '>') {
                    @SuppressWarnings("unused")
					String name = line;
                    StringBuffer sb = new StringBuffer();
                    line = br.readLine().trim();
                    while(br.ready()&&line.length()==0)
                        line = br.readLine().trim();
                    while (line.length() != 0 && line.charAt(0) != '>') {
                        sb.append(line);
                        if (br.ready()) {
                            line = br.readLine().trim();
                        } else {
                            break;
                        }
                    }
                    String seq = sb.toString();
                    Sequence s = new Sequence(seq);
                    bw.write(s.run());
                    bw.write(posOrNeg);
                    bw.newLine();
                    bw.flush();



                } else {
                    line = br.readLine();
                }
            }

            br.close();
            bw.close();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            System.exit(0);
        }
    }
}

