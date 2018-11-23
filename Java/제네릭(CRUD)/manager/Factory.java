package manager;

public interface Factory<E extends Manageable> {
	E create();
}
