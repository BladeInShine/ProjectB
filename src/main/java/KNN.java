import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Debug;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by BladeInShine on 16/4/27.
 */
public class KNN {

    public static void main(String[] args) throws Exception {
        // load data
        Instances data = new Instances(new BufferedReader(new FileReader("/Users/BladeInShine/Documents/ProjectB/src/main/resources/DeathRecords.arff")));
        data.setClassIndex(data.numAttributes() - 2);

        IBk cls = new IBk();
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
