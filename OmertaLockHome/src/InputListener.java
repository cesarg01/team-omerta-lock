import java.util.EventListener;

/**
 * Interface for the input and button listeners.
 *
 */
public interface InputListener extends EventListener
{
	public void inputEventOccurred(InputEvent event);
}
