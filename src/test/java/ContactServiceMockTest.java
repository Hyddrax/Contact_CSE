import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

public class ContactServiceMockTest extends EasyMockSupport {

	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDao contactDao;
	
	@Test(expected = ContactExistsException.class)
	public void testAddContact() throws ContactExistsException{
		// 1- Enregistrement des comportement de mock
		Contact contact = new Contact();
		EasyMock.expect(contactDao.findByName("TESTE")).andReturn(contact);
		// 2 - Fin d'enregistrement
		replayAll();
		// 3 - Test
		service.add("TESTE");
	}
	
	@Test(expected=ContactNotExistsException.class)
	public void testDelContactExists() throws ContactNotExistsException, ContactExistsException {
		// 1 - enregistrement des comportement de mocks
		Contact contact = new Contact();
		contact.setName("CAN S");
		EasyMock.expect(contactDao.findByName("CAN S")).andReturn(null);
		// 2 - Fin d'enregistrement
		replayAll();
		// 3 - Test
		service.del("CAN S");
	}
}
