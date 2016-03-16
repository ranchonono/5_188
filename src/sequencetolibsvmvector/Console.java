package sequencetolibsvmvector;

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
public class Console {
    public static void main(String[] args) {
        if(args.length==0||args.length>2){
        	for(int i=0;i<args.length;i++)
        	System.out.println(args[i]);
            System.out.println("Usage:");
            
            System.out.println("java -jar sequenceToLibSVMVector.jar inputfilename 1or-1");
        }
        else{
            String s = args[0];
            String negOrpos = "1";
            if (args.length ==2)
                negOrpos = args[1];
            Flow f = new Flow(s, s + ".arff", negOrpos);
            f.run();
            System.out.println("OK!");
        }
    }
}
