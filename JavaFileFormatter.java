
/**
*
* @author Nathaniel McIntyre (Khila/Khila42)
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class JavaFileFormatter
{

    private Scanner in;
    private PrintWriter output;
    public JavaFileFormatter(String fileIn, String fileOut)
    throws FileNotFoundException
    {
        in = new Scanner(new File(fileIn));
        output = new PrintWriter(fileOut);
        //output.println("I'm working!!!!");
        //output.close( );
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
        boolean lineEnd;
        while(in.hasNext())
        {
            String word = in.next();
            lineEnd = false;
            if(word.equals("{"))
            {
                output.println();
                for(int i = 0; i < indents; i++)
                {
                    output.print("    ");
                }
                output.print(word);
                indents++;
                lineEnd = true;
            }
            else if(word.equals("}"))
            {
                output.print("\n" + word);
                indents--;
                lineEnd = true;
            }
            else
            {
                output.print(word + " ");
            }
            if(word.contains(";"))
            {
                lineEnd = true;
            }
            if(lineEnd)
            {
                output.println();
                for(int i = 0; i < indents; i++)
                {
                    output.print("    ");
                }
            }
        }
        output.close( );
    }
}
