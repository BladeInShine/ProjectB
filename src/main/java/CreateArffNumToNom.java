import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;

import java.io.File;

/**
 * Created by xli on 5/1/16.
 */
public class CreateArffNumToNom {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("\nUsage: CSV2Arff <input.csv> <output.arff>\n");
            System.exit(1);
        }

        // load CSV
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(args[0]));
        Instances data = loader.getDataSet();
        NumericToNominal convert= new NumericToNominal();

        convert.setInputFormat(data);
        Instances newData= Filter.useFilter(data, convert);


        //String[] options= new String[2];
        //options[0]="-R";
        //options[1]="1-2";  //range of variables to make numeric


        // save ARFF
        ArffSaver saver = new ArffSaver();
        saver.setInstances(newData);
        saver.setFile(new File(args[1]));
        saver.setDestination(new File(args[1]));
        saver.writeBatch();
    }
}
