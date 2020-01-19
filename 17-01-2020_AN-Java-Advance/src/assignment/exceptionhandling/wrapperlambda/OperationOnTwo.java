package assignment.exceptionhandling.wrapperlambda;

@FunctionalInterface
public interface OperationOnTwo<K,V> {
	public void doOperation(K a,V b);
}
