
package universidadean.empleo.persistencia;

import java.io.Serializable;
import universidadean.empleo.mundo.Aspirante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AspiranteJpaController implements Serializable{

    private EntityManagerFactory emf = null;
    

    public AspiranteJpaController() {
        emf = Persistence.createEntityManagerFactory("persisPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//     Crear un nuevo Aspirante
    public void crearAspirante(Aspirante aspirante) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = getEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(aspirante);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

//     Leer un Aspirante por cédula
    public Aspirante encontrarAspirante(String cedula) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aspirante.class, cedula);
        } finally {
            em.close();
        }
    }

//     Obtener todos los Aspirantes
    public List<Aspirante> obtenerTodosAspirantes() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Aspirante a", Aspirante.class).getResultList();
        } finally {
            em.close();
        }
    }

//     Actualizar un Aspirante
    public void actualizarAspirante(Aspirante aspirante) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = getEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(aspirante);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

//     Eliminar un Aspirante
    public void eliminarAspirante(String cedula) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = getEntityManager();
            tx = em.getTransaction();
            tx.begin();
            Aspirante aspirante = em.find(Aspirante.class, cedula);
            if (aspirante != null) {
                em.remove(aspirante);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
