package facades;

import dtos.ItemTypeDTO;
import entities.ItemType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ItemTypeFacade {

    private static EntityManagerFactory emf;
    private static ItemTypeFacade instance;

    public static ItemTypeFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            instance = new ItemTypeFacade();
            emf = _emf;
        }
        return instance;
    }

    public ItemTypeDTO createItemType(ItemTypeDTO itemTypeDTO) {
        EntityManager em = emf.createEntityManager();
        ItemType itemType = new ItemType(itemTypeDTO);
        try {
            em.getTransaction().begin();
            em.persist(itemType);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new ItemTypeDTO(itemType);
    }

    public ItemTypeDTO getById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            ItemType itemType = em.find(ItemType.class, id);
            return new ItemTypeDTO(itemType);
        } finally {
            em.close();
        }
    }
}
