public class ContactService {
	
	//VARIABLES
	private IContactDao dao;
	
	//CONSTRUCTEUR
	public ContactService() {
		this.dao = new ContactDao();
	}

	//METH PUBLIC
	public IContactDao getDao() {
		return this.dao;
	}
	
	public void add(String contactName) throws ContactExistsException {
		// Si contactName est valide (<3 et >40)
		if(contactName != null && contactName.length() <= 40 && contactName.length() >= 3) {
			// Java 7 
			Contact contact = dao.findByName(contactName);
			//Si Aucun contact a déjà ce nom
			if(contact != null) {
				throw new ContactExistsException("Name already exists");
			}else {
				dao.add(new Contact(contactName));				
			}
		}else {
			throw new IllegalArgumentException("contact name should be between 3 and 40 chars");
		}
		
		// Java 8 
		/*dao.findByName(contactName)
			.ifPresent(x-> {throw new IllegalArgumentException("name is already present");});
		
		dao.add(new Contact(contactName));
*/
	}
	
	public void del(String contactName) throws ContactNotExistsException {
		if(contactName != null && contactName.length() <= 40 && contactName.length() >= 3) {
			
			Contact contact = dao.findByName(contactName);
			if(contact != null) {
				dao.remove(contact);
			} else {
				throw new ContactNotExistsException("Name not exists");
			}
		}else {
			throw new IllegalArgumentException("contact name should be between 3 and 40 chars");
		}
	}
	

}