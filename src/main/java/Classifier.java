import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Debug;
import weka.core.Instances;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Created by BladeInShine on 16/4/24.
 */
public class Classifier {

    /**
     * Expects an ARFF file as first argument (class attribute is assumed
     * to be the last attribute).
     *
     * @param args        the commandline arguments
     * @throws Exception  if something goes wrong
     */
    public static void main(String[] args) throws Exception {
        // load data
        Instances data = new Instances(new BufferedReader(new FileReader("src/main/resources/try3_1.arff")));
        data.setClassIndex(data.numAttributes() - 2);

        //J48 cls = new J48();
        RandomForest cls = new RandomForest();
        cls.setNumTrees(20);
        //cls.setNumFeatures();
        cls.buildClassifier(data);

        // display classifier
//        final javax.swing.JFrame jf =
//                new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
//        jf.setSize(500,400);
//        jf.getContentPane().setLayout(new BorderLayout());
//        TreeVisualizer tv = new TreeVisualizer(null,
//                cls.graph(),
//                new PlaceNode2());
//        jf.getContentPane().add(tv, BorderLayout.CENTER);
//        jf.addWindowListener(new java.awt.event.WindowAdapter() {
//            public void windowClosing(java.awt.event.WindowEvent e) {
//                jf.dispose();
//            }
//        });
//
//        jf.setVisible(true);
//        tv.fitToScreen();

        Evaluation eval = new Evaluation(data);
        Debug.Random rand = new Debug.Random(1);  // using seed = 1
        int folds = 10;
        eval.crossValidateModel(cls, data, folds, rand);
        System.out.println(eval.toClassDetailsString());
        System.out.println(eval.toCumulativeMarginDistributionString());
        System.out.println(eval.toSummaryString());
    }

}
