package fr.istic.vv;

import com.github.javaparser.utils.SourceRoot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    //Chaine contenant l'erreur
    private static String errorStr;

    //Retourne l'ensemble des erreurs 
	public static void addErrorStr(String error) {
		if(errorStr == null) {
			errorStr = new String();
		}
		errorStr += error +"\n";
	}

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.err.println("Should provide the path to the source code");
            System.exit(1);
        }

        File file = new File(args[0]);
        if(!file.exists() || !file.isDirectory() || !file.canRead()) {
            System.err.println("Provide a path to an existing readable directory");
            System.exit(2);
        }


        FileWriter output = new FileWriter("output.txt");
        NoGetter app = new NoGetter();

        SourceRoot root = new SourceRoot(file.toPath());
        PublicElementsPrinter printer = new PublicElementsPrinter();
        root.parse("", (localPath, absolutePath, result) -> {
            result.ifSuccessful(unit -> unit.accept(printer, null));
            return SourceRoot.Callback.Result.DONT_SAVE;
        }); 
        app.compare(printer.getData());
        output.write(errorStr);
        output.close(); 
    }
}

