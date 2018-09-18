import java.util.*;

public class ContactDao implements IContactDao{
	
//VARIABLES	
	private List<Contact> contact;

//CONSTRUCTEUR
	public ContactDao(){
		this.contact = new ArrayList<Contact>();
	}
	
//METH PUBLIC
	/* (non-Javadoc)
	 * @see IContactDao#readAll()
	 */
	@Override
	public List<Contact> readAll(){
		return this.contact;
	}
	
	/* (non-Javadoc)
	 * @see IContactDao#findByName(java.lang.String)
	 */
	@Override
	public Contact findByName(String name) {
		for(int i = 0; i < contact.size() ; i++) {
			if(contact.get(i).getName() == name) {
				return contact.get(i);
			}			
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see IContactDao#add(Contact)
	 */
	@Override
	public void add(Contact contact) {
		this.contact.add(contact);
	}
	
	@Override
		public void remove(Contact contact) {
			// TODO Auto-generated method stub
			this.contact.remove(contact);
		}
	

}
