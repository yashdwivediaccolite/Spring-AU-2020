package assignment.triconsumerlambda;

@FunctionalInterface
public interface TriConsumer<T,K,V> {
	public void accept(T a,K b,V c);
}
