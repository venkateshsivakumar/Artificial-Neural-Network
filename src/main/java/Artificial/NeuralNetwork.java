package Artificial;

import java.util.Random;

public class NeuralNetwork {
	Random random = new Random();
	int inputNode;
	int hiddenNode;
	int outputNode;
	//Matrix matrix = new Matrix();
	Matrix weights_ih; 
	Matrix weights_ho;
	Matrix bias_h;
	Matrix bias_o;
	double learningrate =.1;
	
	public NeuralNetwork(int inputNode, int hiddenNode, int outputNode) {
			this.inputNode = inputNode;
			this.hiddenNode = hiddenNode;
			this.outputNode = outputNode;
			this.weights_ih = new Matrix(hiddenNode, inputNode);
			this.weights_ho = new Matrix(outputNode, hiddenNode);
			weights_ih.random(random);
			weights_ho.random(random);
			this.bias_h = new Matrix(this.hiddenNode,1);
			this.bias_o = new Matrix(this.outputNode,1);
			bias_h.random(random);
			bias_o.random(random);
	}
	
	public double[] feedforward(double[][] input) {
		double[][] result=weights_ih.multiply(input);
		bias_h.add(result);
		bias_h.map();
		double[][] out = weights_ho.multiply(bias_h.data);
		bias_o.add(out);
		bias_o.map();
		return bias_o.toArray();
	}
	
	public void train(double[][] input, double[][] targets) {
		double[][] hidden_inputs=weights_ih.multiply(input);
		bias_h.add(hidden_inputs);
		double [][] hidden_output = bias_h.map();
		double[][] output_inputs = weights_ho.multiply(hidden_output);
		bias_o.add(output_inputs);
		double [][] outputs = bias_o.map();		
		double[] out =  bias_o.toArray();
		//Matrix m = new Matrix(out.length, 1);
		//double[][] output = Matrix.fromArray(out, m.data);
		
		double[][] outError= Matrix.subtract(targets, outputs);
		
		double [][] who_t = Matrix.transpose(weights_ho.data); 
		double[][] hidError = Matrix.multiply(who_t,outError);
		/*
		 * for(int i=0;i<outError.length;i++) { for(int j=0;j<outError[0].length;j++) {
		 * System.out.println(outError[i][j]); } }
		 */
		
		//double[][] oneMinSigOut = Matrix.subtract(1, sigOut);
		//double[][] dsigmoid = Matrix.multiply(sigOut, Matrix.subtract(1, sigOut));
		// calculate gradient
		
		double[][] gradients = Matrix.multiply(Matrix.multiply(Matrix.desigMap(outputs), outError),learningrate);
		
		//calculate hiddenGradient
		double[][] hiddenGradients = Matrix.multiply(Matrix.multiply(Matrix.desigMap(hidden_output), hidError),learningrate);
		
		//calculate delta
		double[][] hidden_T = Matrix.transpose(hidden_output);
		double[][] weight_ho_deltas = Matrix.multiply(gradients,hidden_T);
		weights_ho.add(weight_ho_deltas);
		bias_o.add(gradients);
		
		
		
		
		
		/*
		 * for(int i=0;i<hidError.length;i++) { for(int j=0;j<hidError[0].length;j++) {
		 * System.out.println(hidError[i][j]); } }
		 */
		
		
				//calculate delta
				double[][] hidden_input_T = Matrix.transpose(input);
				double[][] deltaW_hidden = Matrix.multiply(hiddenGradients,hidden_input_T);
				weights_ih.add(deltaW_hidden);
				bias_h.add(hiddenGradients);
	}

}
