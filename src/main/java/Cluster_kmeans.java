import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by xiaoxiaoli on 4/26/16.
 */
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
        cl.setSeed(3);

        //important parameter to set: preserver order, number of cluster.
        cl.setPreserveInstancesOrder(true);
        cl.setNumClusters(3);

        System.out.println(
                ClusterEvaluation.evaluateClusterer(cl, options));

        // manual call
        System.out.println("\n--> manual");
        cl   = new SimpleKMeans();
        //cl.setSeed(10);

        //important parameter to set: preserver order, number of cluster.
        cl.setPreserveInstancesOrder(true);
        cl.setNumClusters(3);


        cl.buildClusterer(data);
        eval = new ClusterEvaluation();
        eval.setClusterer(cl);
        eval.evaluateClusterer(new Instances(data));
        System.out.println("# of clusters: " + eval.getNumClusters());


        // This array returns the cluster number (starting with 0) for each instance
        // The array has as many elements as the number of instances
        int[] assignments = cl.getAssignments();

        int i=0;
        for(int clusterNum : assignments) {
            //System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
            i++;
        }
        // density based
        //System.out.println("\n--> density (CV)");
        //cl   = new SimpleKMeans();
//        eval = new ClusterEvaluation();
//        eval.setClusterer(cl);
        //eval.crossValidateModel(
        //        cl, data, 10, data.getRandomNumberGenerator(1));
        System.out.println("# of clusters: " + eval.getNumClusters());
    }

    /**
     * usage:
     *   ClusteringDemo arff-file
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: " + Cluster.class.getName() + " <arff-file>");
            System.exit(1);
        }

        new Cluster_kmeans(args[0]);
    }
}
