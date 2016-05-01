import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.trees.J48;
import weka.core.Debug;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;


public class RFClassifier {

    public static void main(String[] args) throws Exception {
        // load data
        Instances data = new Instances(new BufferedReader(new FileReader("src/main/resources/try_maner_of_death.arff")));
        data.setClassIndex(data.numAttributes() - 2);

        //RandomForest
        RandomForest cls = new RandomForest();
        cls.setNumTrees(20);

        cls.buildClassifier(data);


        Evaluation eval = new Evaluation(data);
        Debug.Random rand = new Debug.Random(1);  // using seed = 1
        int folds = 10;
        eval.crossValidateModel(cls, data, folds, rand);
        System.out.println(eval.toClassDetailsString());
        System.out.println(eval.toCumulativeMarginDistributionString());
        System.out.println(eval.toSummaryString());
    }

}
