import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Debug;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by xli on 5/1/16.
 */
public class J48Classifier {
    public static void main(String[] args) throws Exception {
        // load data
        Instances data = new Instances(new BufferedReader(new FileReader("src/main/resources/try_maner_of_death.arff")));
        data.setClassIndex(data.numAttributes() - 2);

        //J48
        J48 cls = new J48();
        cls.setMinNumObj(2);

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
