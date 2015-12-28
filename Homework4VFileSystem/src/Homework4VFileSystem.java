import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.Parser;
import org.apache.commons.vfs.FileSystemException;

import tasks.TestJarVFS;

/**
 * @author pzoli
 * 
 */
public class Homework4VFileSystem {

    private static String task;
    private static String fileName;
    
    @SuppressWarnings("static-access")
    private static Options getCommandLineOptions() {
        Options options = new Options();
        options.addOption(OptionBuilder.isRequired(true).withArgName("task").withLongOpt("task").hasArg(true).withDescription("filesystem task [testJar]").create());
        options.addOption(OptionBuilder.isRequired(true).withArgName("file").withLongOpt("file").hasArg(true).withDescription("file to print").create());
        return options;
    }
    
    private static void testVFS() throws FileSystemException {
        switch (task) {
        case "testJar":
            TestJarVFS.listFiles(fileName);
        }

    }

    public static void main(String[] args) {
        Parser parser = new GnuParser();
        Options options = getCommandLineOptions();
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse(options, args);
            task = (String) commandLine.getOptionValue("task");
            fileName = (String) commandLine.getOptionValue("file");
            testVFS();
        } catch (ParseException | FileSystemException ex) {
            System.out.println(ex.getLocalizedMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar homework4filesystem.jar", options);
            System.exit(-1);
        }

    }
}
