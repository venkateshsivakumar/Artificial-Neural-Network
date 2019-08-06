package Artificial;

import java.util.Random;

public class Matrix {
	
	int rows;
	
	int cols;
	
	double[][] data;
	
	double[][] result;
	
	Random random = new Random();
	
	Matrix m;
	
	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		data = new double[rows][cols];
		
		for(int i=0;i<rows; i++) {
			for(int j=0;j<cols; j++) {
				data[i][j]=0;
			}
		}
	}
	
	public void add(double n) {
		for(int i=0;i<rows; i++) {
			for(int j=0;j<cols; j++) {
				data[i][j] +=n;
			}
		}
	}
	
	public void add(double[][] n) {
		for(int i=0;i<rows; i++) {
			for(int j=0;j<cols; j++) {
				data[i][j] +=n[i][j];
			}
		}
	}
	
	public static double[][] multiply(double[][] a1, double n) {
		for(int i=0;i<a1.length; i++) {
			for(int j=0;j<a1[0].length; j++) {
				a1[i][j] *=n;
			}
		}
		return a1;
	}
	
	public double[][] multiply( double[][] b) {
		if(data[0].length!= b.length) {
			System.out.println("Unequal rows and column");
			return result;
		}
		else if(data.length == b.length && data[0].length == b[0].length) {
			result = new double[data.length][data[0].length];
			for(int i=0;i<data.length; i++) {
				for(int j=0;j<b[0].length; j++) {
					
					 result[i][j]=data[i][j]*b[i][j];
				}
			}
		}
		else 
		{
		result = new double[data.length][b[0].length];
		for(int i=0;i<data.length; i++) {
			for(int j=0;j<b[0].length; j++) {
				double sum = 0;
				 for(int k=0;k<data[0].length;k++) {
					 sum += data[i][k]*b[k][j];
				 }
				 result[i][j]=sum;
			}
		}
		}
		return result;
	}
	
	public static double[][] multiply(double[][] a, double[][] b) {
		double[][] result = new double[1][1] ;
		 if(a.length == b.length && a[0].length == b[0].length) {
			result = new double[a.length][a[0].length];
			for(int i=0;i<a.length; i++) {
				for(int j=0;j<b[0].length; j++) {
					
					 result[i][j]=a[i][j]*b[i][j];
				}
			}
		}
		else if(a[0].length== b.length)
		{
			result = new double[a.length][b[0].length];
			for(int i=0;i<a.length; i++) {
				for(int j=0;j<b[0].length; j++) {
					double sum = 0;
					 for(int k=0;k<a[0].length;k++) {
						 sum += a[i][k]*b[k][j];
					 }
					 result[i][j]=sum;
				}
			}
		}
		else {
			System.out.println("Unequal rows and column");
		}
		return result;
	}
	
	
	
	public void random(Random random) {
		for(int i=0;i<rows; i++) {
			for(int j=0;j<cols; j++) {
				data[i][j] = random.nextDouble()*2 - 1;
			}
		}
		
	}
	
	public static double[][] transpose(double[][] input) {
		double[][] result = new double[input[0].length][input.length];
		for(int i=0;i<input.length; i++) {
			for(int j=0;j<input[0].length; j++) {
				result[j][i] = input[i][j];
			}
		}
		return result;
	}
	
	public double[][] map() {
		for(int i=0;i<rows; i++) {
			for(int j=0;j<cols; j++) {
				double x = data[i][j];
				data[i][j] = 1/(1+Math.exp(-1*x));
				//data[i][j] = 1/(1+Math.pow(Math.E, -1*x));
			}
		}
		return data;
	}
	
	public static double[][] desigMap(double[][] in) {
		for(int i=0;i<in.length; i++) {
			for(int j=0;j<in[0].length; j++) {
				double x = in[i][j];
				in[i][j] = x*(1-x);
			}
		}
		return in;
	}
	
	// Convert matrix into a array
	public double[] toArray() {
		double[] array = new double[data.length * (data[0].length)];
		int k =0;
		for(int i=0;i<rows; i++) {
			for(int j=0;j<cols; j++) {
				array[k]=data[i][j];
				k++;
			}
		}
		return array;
	}
	
	// Convert array into a matrix
	public static double[][] fromArray(double[] input,double[][] output) {
		
		for(int i=0;i<input.length; i++) {
			
				output[i][0] = input[i];		
			
		}
		return output;
	}
	
	public static double[][] subtract(double[][] in1, double[][] in2) {
		double[][] d = new double[in1.length][in1[0].length]; 
		for(int i=0;i<d.length; i++) {
			for(int j=0;j<d[0].length; j++) {
				d[i][j] =in1[i][j]-in2[i][j];
			}
		}
		return d;
	}
	
	/*
	 * public static double[][] subtract(double in1, double[][] in2) { double[][] d
	 * = new double[in2.length][in2[0].length]; for(int i=0;i<d.length; i++) {
	 * for(int j=0;j<d[0].length; j++) { d[i][j] =in1-in2[i][j]; } } return d; }
	 */
}
