package demo.shell;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * ProcessTxt
 *
 * @author by gatesma.
 */
public class ProcessTxt {


    public static void main(String[] args) {
        String path = "/Users/gatesma/tencent/sublime_file/20221102/uid.txt";
        // FileInputStream inputStream = null;
        // BufferedReader bufferedReader = null;
        //
        // try {
        //     inputStream = new FileInputStream(path);
        //     bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //
        //     String str = null;
        //     int cnt = 0;
        //     while ((str = bufferedReader.readLine()) != null) {
        //         System.out.println(str);
        //     }
        // } catch (Exception e) {
        // }

        try {
            List<String> lines = FileUtils.readLines(new File(path), StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
        }


    }

}
