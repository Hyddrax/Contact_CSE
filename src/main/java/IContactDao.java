import java.util.List;

public interface IContactDao {

	//METH PUBLIC
	List<Contact> readAll();

	Contact findByName(String name);

	void add(Contact contact);

	void remove(Contact contact);

}