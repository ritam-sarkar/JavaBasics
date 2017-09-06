package com.ibm;

public class MatrixDemo {
	
	public static void main(String[] args){
		
		int [][] mat1 = new int[2][3];
		int [][] mat2 = new int[3][2];
		MatrixUtil matUtil = new MatrixUtil();
		matUtil.writeMatrix(mat1);
		matUtil.writeMatrix(mat2);
		System.out.println("before multiplication ");
		matUtil.read(mat1);
		System.out.println("");
		matUtil.read(mat2);
		int [][] result = matUtil.mutiPly(mat1, mat2);
		System.out.println(" after multiplication ");
		matUtil.read(result);
	}

}
class MatrixUtil{
	
	void writeMatrix(int[][] matrix){
		if(matrix != null){
			for(int i = 0;i<matrix.length;i++){
				for(int j = 0;j<matrix[i].length;j++){
					matrix[i][j] = i+j;
				}
			}
		}
		
	}
	void read (int [] [] matrix){
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix[i].length;j++){
				System.out.print(" ");
				System.out.print(matrix[i][j]);
			}
			System.out.println("");
		}
	}
	
	int[][] mutiPly(int[][] mat1,int[][] mat2){
		int row1 =0;
		int row2 = 0;
		int col1 = 0;
		int col2 = 0;
		
		if(mat1 != null){
			row1 = mat1.length;
			if(row1 >0){
				col1 = mat1[0].length;
			}
		}
		if(mat2 != null){
			row2 = mat2.length;
			if(row2 >0){
				col2 = mat2[0].length;
			}
		}
		int result[][] = new int[row1][col2];
		if(col1 == row2){
			
			for(int i=0;i<row1;i++){
				for(int j =0;j<col2;j++){
					for(int k = 0; k<col1;k++){
						result[i][j] += mat1[i][k]*mat2[k][j];	
					}				  				  					
				}
			}
			
			
		}
		return result;
	}
}

