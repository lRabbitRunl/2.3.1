package web.dao;



import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaolmp implements UserDao {



    @PersistenceContext
    private EntityManager entityManager;



    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery("from " + User.class.getName()).getResultList();
    }

    @Override

    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void edit(User user) {
      entityManager.merge(user);
    }

    @Override
    public User getById(Integer id) {
       return entityManager.find(User.class, id);
    }


}
