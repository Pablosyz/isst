package es.upm.dit.isst.gdpr.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.gdpr.model.Solicitud;


public class SolicitudDAOImplementation implements SolicitudDAO{

	
	private static SolicitudDAOImplementation instancia = null;
	private SolicitudDAOImplementation() {}
	@Override
	public void create(Solicitud solicitud) {
		
		Session session = SessionFactoryService.get().openSession();
		try {
			
			session.beginTransaction();
			session.save(solicitud);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.print(e);

		} finally {
			
			session.close();
		}
		
		
	}

	@Override
	public Solicitud read(int id) {
		
		Session session = SessionFactoryService.get().openSession();
		Solicitud solicitud = null;
		try {
			
			session.beginTransaction();
			solicitud = session.load(Solicitud.class, id);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.print(e);

		} finally {
			
			session.close();
		}
		
		return solicitud;
	}

	@Override
	public void update(Solicitud solicitud) {
		
		Session session = SessionFactoryService.get().openSession();
		try {
			
			session.beginTransaction();
			session.saveOrUpdate(solicitud);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.print(e);

		} finally {
			
			session.close();
		}
		
	}

	@Override
	public void delete(Solicitud solicitud) {

		Session session = SessionFactoryService.get().openSession();
		try {
			
			session.beginTransaction();
			session.delete(solicitud);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.print(e);

		} finally {
			
			session.close();
		}		
	}

	@Override
	public Collection<Solicitud> readAll() {
		
		Session session = SessionFactoryService.get().openSession();
		Collection<Solicitud> solicitudes = null;
		try {
			
			session.beginTransaction();
			solicitudes = session.createQuery( "from Solicitud" ).list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.print(e);
			
		} finally {
			
			session.close();
		}
		return solicitudes;
	}

}