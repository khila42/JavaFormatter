
/**
 *
 * @author Nathaniel McIntyre (Khila/Khila42)
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class JavaFileFormatter 
{

    private Scanner in;
    private PrintWriter out;
    public JavaFileFormatter(String fileIn, String fileOut)
    throws FileNotFoundException
    {
        in = new Scanner(new File(fileIn));
        out = new PrintWriter(fileOut);
    }
    public static void main(String[] args)
    throws FileNotFoundException
    {
        // TODO code application logic here
        Scanner kbd = new Scanner(System.in); 
        System.out.println("What is the name of the file?");
        String fileIn = kbd.next();
        kbd.nextLine();
        System.out.println("What would you like to name the file for this"
                           + " program to write to?");
        String fileOut = kbd.next();
        JavaFileFormatter f = new JavaFileFormatter(fileIn, fileOut);
        f.formatBrackets();
    }
    
    public void formatBrackets()
    {
        int indents = 0;
        for(int i = 0; i <= indents; i++)
        {
            System.out.print("\t");
        }
        while(in.hasNext())
        {
            String word = in.next();
            if(word.equals("{"))
            {
                out.println("\n" + word);
                indents++;
            }
            else if(word.equals("}"))
            {
                out.println("\n" + word);
                indents--;
            }
        }
    }
    
}
