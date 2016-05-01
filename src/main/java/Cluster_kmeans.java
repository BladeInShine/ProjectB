import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

public class Cluster_kmeans {
    public Cluster_kmeans(String filename) throws Exception {
        System.out.println("k_means");
        ClusterEvaluation eval;
        Instances data;
        String[]                options;
        SimpleKMeans cl;

        data = new Instances(new BufferedReader(new FileReader(filename)));

        // normal
        System.out.println("\n--> normal");
        options    = new String[2];
        options[0] = "-t";
        options[1] = filename;
        cl = new SimpleKMeans();

        //important parameter to set: preserver order, number of cluster.
        cl.setPreserveInstancesOrder(true);
        cl.setNumClusters(3);
        cl.setSeed(3);

        System.out.println(
                ClusterEvaluation.evaluateClusterer(cl, options));

        // manual call

    }

    /**
     * usage:
     *   ClusteringDemo arff-file
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: " + Cluster_kmeans.class.getName() + " <arff-file>");
            System.exit(1);
        }

        new Cluster_kmeans(args[0]);
    }
}