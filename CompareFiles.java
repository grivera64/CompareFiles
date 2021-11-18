// package none;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CompareFiles {

    public static void main(String[] files) throws IOException {

        if (files.length != 2) {

            System.out.println("Usage: java -jar CompareFiles.jar <file1> <file2>");
            System.exit(1);

        }

        File file1 = new File(files[0]);
        File file2 = new File(files[1]);

        if (!(file1.exists() && file1.exists())) {

            System.out.println("ERROR: File(s) do not exist!");
            System.exit(1);

        }

        Scanner inFile1 = new Scanner(file1);
        Scanner inFile2 = new Scanner(file2);

        if (inFile1.hasNext() ^ inFile1.hasNext()) {

            System.out.printf("File %s is empty while File %s is not.\n",
                    (inFile1.hasNext()) ? files[1] : files[0], (inFile2.hasNext()) ? files[0] : files[1]);
            System.exit(0);

        } else if (!inFile1.hasNext() && !inFile2.hasNext()) {

            System.out.printf("%s and %s are identically empty.\n", files[0], files[1]);
            System.exit(0);

        }

        int lineNumber;
        String fileLine1;
        String fileLine2;

        for (lineNumber = 1; inFile1.hasNext() && inFile2.hasNext(); lineNumber++) {

            fileLine1 = inFile1.nextLine();
            fileLine2 = inFile2.nextLine();

            if (!fileLine1.equals(fileLine2)) {

                System.out.printf("Difference on line %d:\n%s: %s\n%s: %s\n",
                        lineNumber, files[0], fileLine1, files[1], fileLine2);
                System.exit(0);

            }

        }

        if (inFile1.hasNext()) {

            System.out.printf("%s is bigger than %s\n.", files[0], files[1]);

        } else if (inFile2.hasNext()) {

            System.out.printf("%s is bigger than %s.\n", files[1], files[0]);

        } else {

            System.out.printf("%s and %s are identical.\n", files[0], files[1]);

        }

    }

}
