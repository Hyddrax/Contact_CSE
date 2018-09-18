import org.easymock.EasyMock;
import org.junit.Test;

public class ContactServiceTest {

	private ContactService service = new ContactService();
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldFailOnShortNames() throws ContactExistsException {
		service.add("ab");
	}
	
	@Test
	public void shouldPass() throws ContactExistsException {
		service.add("abajhgjhg");
	}
	
	@Test(expected=ContactExistsException.class)
	public void shouldFailOnDuplicateNames() throws ContactExistsException {
		service.add("jean");
		service.add("jean");

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldFailOnLongNames() throws ContactExistsException {
		service.add("012345678901234567890123456789012345678901234567890123456789");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldFailOnNullNames() throws ContactExistsException {
		service.add(null);
	}
	
}
