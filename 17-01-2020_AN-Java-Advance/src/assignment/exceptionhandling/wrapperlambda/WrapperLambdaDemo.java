package assignment.exceptionhandling.wrapperlambda;

import java.util.function.BiConsumer;

public class WrapperLambdaDemo {
	public static void main(String []args) {
		WrapperLambdaDemo mainClass=new WrapperLambdaDemo();
		OperationOnTwo<int[],Integer> operation=mainClass.wrapperLambda((arr,key)->{
			System.out.println(arr[key]);
		});
		int Arr[]=new int[3];
		Arr=null;
		int Key=3;
		mainClass.returnValue(Arr,Key,operation);
		int newArr[]= {1,2,3};
		mainClass.returnValue(newArr,Key,operation);
	}
	
	void returnValue(int arr[],int key,	OperationOnTwo<int[],Integer>operation) {
		operation.doOperation(arr, key);
	}
	
	OperationOnTwo<int[],Integer> wrapperLambda(OperationOnTwo<int[],Integer> operation){	//WrapperLambda
		return (arr,key)->{
			try {
				operation.doOperation(arr, key);
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println(e.toString());
				//e.printStackTrace();
			}
			catch(NullPointerException e) {
				System.out.println(e.toString());
				//e.printStackTrace();
			}
		};
	}
}
