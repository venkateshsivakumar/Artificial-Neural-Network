package Artificial;

import java.util.Random;

public class Main {
	NeuralNetwork nn;
	double [] input= new double[2]; 
	double[] output;
	double [] target = new double[1];
	
	public void trigger() {
		nn = new NeuralNetwork(2, 50, 1);
		Matrix mIn = new Matrix(input.length,1);
		Matrix mT = new Matrix(target.length, 1);
		Random random = new Random();
		double[][] in;
		double[][] tar;
		
		for(int i=0; i<150000;i++) {	
		int key = random.nextInt(4);
		
		switch(key) {
			case 0:	input = new double[] {0,0};
		 			target = new double[] {0};
					in = Matrix.fromArray(input, mIn.data);
					tar = Matrix.fromArray(target, mT.data);
					nn.train(in, tar);
					break;
					
			case 1:	input = new double[] {0,1};
		 			target = new double[] {1};
					in = Matrix.fromArray(input, mIn.data);
					tar = Matrix.fromArray(target, mT.data);
					nn.train(in, tar);
					break;
			
			case 2:	input = new double[] {1,1};
		 			target = new double[] {0};
					in = Matrix.fromArray(input, mIn.data);
					tar = Matrix.fromArray(target, mT.data);
					nn.train(in, tar);
					break;
					
			case 3: input = new double[] {1,0};
		 			target = new double[] {1};
					in = Matrix.fromArray(input, mIn.data);
					tar = Matrix.fromArray(target, mT.data);
					nn.train(in, tar);
					break;
				
		}
		/*
		 * List<double[][]> inOutList = new ArrayList<double[][]>();
		 * Map<Integer,List<double[][]>> train = new HashMap<Integer,
		 * List<double[][]>>(); input = new double[] {1,0}; target = new double[] {1};
		 * double[][] in = Matrix.fromArray(input, mIn.data); double [][]tar =
		 * Matrix.fromArray(target, mT.data); inOutList.add(in); inOutList.add(tar);
		 * train.put(0,inOutList);
		 * 
		 * List<double[][]> inOutList1 = new ArrayList<double[][]>(); input = new
		 * double[] {0,1}; target = new double[] {1}; double[][] in1 =
		 * Matrix.fromArray(input, mIn.data); double[][] tar1 = Matrix.fromArray(target,
		 * mT.data); inOutList1.add(in1); inOutList1.add(tar1); train.put(1,inOutList1);
		 * 
		 * List<double[][]> inOutList2 = new ArrayList<double[][]>(); input = new
		 * double[] {0,0}; target = new double[] {0}; double[][] in2 =
		 * Matrix.fromArray(input, mIn.data); double[][] tar2 = Matrix.fromArray(target,
		 * mT.data); inOutList2.add(in2); inOutList.add(tar2); train.put(2,inOutList);
		 * 
		 * inOutList = new ArrayList<double[][]>(); input = new double[] {1,1}; target =
		 * new double[] {0}; double[][] in3 = Matrix.fromArray(input, mIn.data);
		 * double[][] tar3 = Matrix.fromArray(target, mT.data); inOutList.add(in3);
		 * inOutList.add(tar3); train.put(3,inOutList);
		 */
			 
			 
		
			//int key = random.nextInt(4);
			//System.out.print(key+",");
			//List<double[][]> val = train.get(key);
			
			
		}
		
		input = new double[] {1,0};
		double[][] inp = Matrix.fromArray(input, mIn.data);
		double[] out = nn.feedforward(inp);
		System.out.println(out[0]);
		
		input = new double[] {0,1};
		 inp = Matrix.fromArray(input, mIn.data);
		 out = nn.feedforward(inp);
		 System.out.println(out[0]);
		 
		input = new double[] {0,0};
		 inp = Matrix.fromArray(input, mIn.data);
		 out = nn.feedforward(inp);
		 System.out.println(out[0]);
		 
		input = new double[] {1,1};
		 inp = Matrix.fromArray(input, mIn.data);
		 out = nn.feedforward(inp);
		 System.out.println(out[0]);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.trigger();
		//for(double val:main.output)
		//System.out.println(val);
	}
}
