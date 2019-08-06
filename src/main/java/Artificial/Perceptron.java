package Artificial;

import java.util.Random;

public class Perceptron {/*
							 * 
							 * private static int IN = 4; private static int HN = 2; private static int ON =
							 * 1; private static int WWM ; private static int HWM ; private static Random
							 * random; private static final long seed = 3015; private static int P; private
							 * static int[] learnPatternsOrder; private static double[][] weightMatrix;
							 * private static final int epocheCount = 1000; private static double[]
							 * netProgress;
							 * 
							 * public static double[][] generateRandomWeightMatrix(int WX, int WY, double
							 * min, double max) { double range = max-min; // First get the range double[][]
							 * randomWeightMatrix = new double[WX][WY]; for (int i = 0; i < WX; i++) { for
							 * (int j = 0; j < WY; j++) { // nextDouble() returns numbers in [0..1), to
							 * scale it correctly do the following randomWeightMatrix[i][j] =
							 * (random.nextDouble()*range)+min; } } return randomWeightMatrix; }
							 * 
							 * public static void main(String [] args) { WWM = IN + HN +2; HWM =
							 * Math.max(IN, HN);
							 * 
							 * random = new Random(); random.setSeed(seed); learnPatternsOrder = new int[P];
							 * 
							 * for (int i = 0; i < P; i++) { learnPatternsOrder[i] = i; }
							 * 
							 * weightMatrix = generateRandomWeightMatrix(WWM,HWM,-0.5,0.5);
							 * 
							 * mlp myNeuralNet = new mlp(weightMatrix); myNeuralNet.addLayer(IN);
							 * myNeuralNet.addLayer(HN,mlp.Transferfunction.tanh, 0.5);
							 * myNeuralNet.addLayer(ON,mlp.Transferfunction.fermi, 0.2);
							 * 
							 * netProgress = new double[epocheCount];
							 * 
							 * for (int epoche = 0; epoche < epocheCount; epoche++) { netProgress[epoche] =
							 * 0; shuffle(learnPatternsOrder); for (int pattern = 0; pattern < P; pattern++)
							 * { System.out.println();
							 * System.out.format(" > Feeding net with input pattern number %3d%n",
							 * learnPatternsOrder[pattern]);
							 * myNeuralNet.setTeacherOutputVector(learnPatternsOrder[learnPatternsOrder[
							 * pattern]]);
							 * myNeuralNet.propagateInput(learnPatternsOrder[learnPatternsOrder[pattern]]);
							 * System.out.format(" > Overall pattern net output error: %+3.5f%n",
							 * myNeuralNet.getErrorForOnePattern()); netProgress[epoche] +=
							 * myNeuralNet.getErrorForOnePattern(); myNeuralNet.backpropagationOfDelta();
							 * myNeuralNet.updateWeights(); }
							 * System.out.format(" > Overall accumulated epoche error: %+3.5f%n",
							 * netProgress[epoche]); } writeGnuPlotFile("epocheerror.dat"); }
							 */

}
