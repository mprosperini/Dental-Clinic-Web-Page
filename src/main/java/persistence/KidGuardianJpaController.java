package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logic.KidGuardian;
import logic.Patient;
import persistence.exceptions.NonexistentEntityException;

public class KidGuardianJpaController implements Serializable {

    public KidGuardianJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public KidGuardianJpaController() {
        emf = Persistence.createEntityManagerFactory("DentalClinicProjectJava_PU");
    }
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(KidGuardian kidGuardian) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patient aPatient = kidGuardian.getaPatient();
            if (aPatient != null) {
                aPatient = em.getReference(aPatient.getClass(), aPatient.getIdPerson());
                kidGuardian.setaPatient(aPatient);
            }
            em.persist(kidGuardian);
            if (aPatient != null) {
                KidGuardian oldKidGuardianOfAPatient = aPatient.getKidGuardian();
                if (oldKidGuardianOfAPatient != null) {
                    oldKidGuardianOfAPatient.setaPatient(null);
                    oldKidGuardianOfAPatient = em.merge(oldKidGuardianOfAPatient);
                }
                aPatient.setKidGuardian(kidGuardian);
                aPatient = em.merge(aPatient);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(KidGuardian kidGuardian) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            KidGuardian persistentKidGuardian = em.find(KidGuardian.class, kidGuardian.getIdPerson());
            Patient aPatientOld = persistentKidGuardian.getaPatient();
            Patient aPatientNew = kidGuardian.getaPatient();
            if (aPatientNew != null) {
                aPatientNew = em.getReference(aPatientNew.getClass(), aPatientNew.getIdPerson());
                kidGuardian.setaPatient(aPatientNew);
            }
            kidGuardian = em.merge(kidGuardian);
            if (aPatientOld != null && !aPatientOld.equals(aPatientNew)) {
                aPatientOld.setKidGuardian(null);
                aPatientOld = em.merge(aPatientOld);
            }
            if (aPatientNew != null && !aPatientNew.equals(aPatientOld)) {
                KidGuardian oldKidGuardianOfAPatient = aPatientNew.getKidGuardian();
                if (oldKidGuardianOfAPatient != null) {
                    oldKidGuardianOfAPatient.setaPatient(null);
                    oldKidGuardianOfAPatient = em.merge(oldKidGuardianOfAPatient);
                }
                aPatientNew.setKidGuardian(kidGuardian);
                aPatientNew = em.merge(aPatientNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = kidGuardian.getIdPerson();
                if (findKidGuardian(id) == null) {
                    throw new NonexistentEntityException("The kidGuardian with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            KidGuardian kidGuardian;
            try {
                kidGuardian = em.getReference(KidGuardian.class, id);
                kidGuardian.getIdPerson();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kidGuardian with id " + id + " no longer exists.", enfe);
            }
            Patient aPatient = kidGuardian.getaPatient();
            if (aPatient != null) {
                aPatient.setKidGuardian(null);
                aPatient = em.merge(aPatient);
            }
            em.remove(kidGuardian);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<KidGuardian> findKidGuardianEntities() {
        return findKidGuardianEntities(true, -1, -1);
    }

    public List<KidGuardian> findKidGuardianEntities(int maxResults, int firstResult) {
        return findKidGuardianEntities(false, maxResults, firstResult);
    }

    private List<KidGuardian> findKidGuardianEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(KidGuardian.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public KidGuardian findKidGuardian(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(KidGuardian.class, id);
        } finally {
            em.close();
        }
    }

    public int getKidGuardianCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<KidGuardian> rt = cq.from(KidGuardian.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
