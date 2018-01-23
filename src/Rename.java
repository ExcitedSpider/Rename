import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class Rename
{
    public final static String URL="D:\\mb\\2\\";
    //the dir of files
    public static String nameRule="2.*";
    //the rule for finding files
    public static String reNameRule="2.part#.rar";
    //? represent the new name index of files in [1,n], n is the num of old files, by asc order
    public static  void main(String []args)
    {
        File file=new File(URL);
        File []files=file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(nameRule,name);
            }
        });
        System.out.println("There are "+files.length+"(s) files found!");
        System.out.println("Rename Begin!");
        String []s=reNameRule.split("#");

        for(int i=0;i<files.length;i++)
        {
            File newf=new File(URL+s[0]+(i+1)+s[1]);
            files[i].renameTo(newf);
        }
        System.out.println("Rename Complete!");
    }
}