import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import main.HibernateUtil ;
import org.hibernate.*;

public class Main {
	public static void main(String[] args) {
		Main m=new Main();

		Scanner sc = new Scanner(System.in);
		System.out.println("Izabrati između 1 -  4 ");
		System.out.println("Unijeti 1 za dodati Zaposlenog");
		System.out.println("Unijeti 2 update Zaposlenog");
		System.out.println("Unijeti 3 za brisanje Zaposlenog");
		System.out.println("Unijeti 4 za prikaz Zaposlenog");
		System.out.println("Unijeti 0 za kraj");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			m.dodatiZaposleni();
			break;
		case 2:
			m.updateZaposleni();
			break;
		case 3:
			m.izbrisatiZaposleni();
			break;
		case 4:
			m.prikazZaposleni();
			break;

		default:System.exit(0);
			break;
		}


		sc.close();

	}


	public void dodatiZaposleni() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Unijeti podatke");
		System.out.println("Unijeti ime:");
		String zaposleni_ime = sc.nextLine();
		System.out.println("Unijeti godine");
		int zaposleni_godine = sc2.nextInt();
		System.out.println("Unijeti adresu: ");
		String zaposleni_adresa = sc3.nextLine();
		System.out.println("Unijeti platu:");
		int zaposleni_plata = sc4.nextInt();


		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;


		try {
			transaction = session.beginTransaction();
			Zaposleni zaposleni = new Zaposleni();
			zaposleni.setZaposleni_ime(zaposleni_ime);
			zaposleni.setZaposleni_godine(zaposleni_godine);
			zaposleni.setZaposleni_adresa(zaposleni_adresa);
			zaposleni.setZaposleni_plata(zaposleni_plata);
			session.save(zaposleni);
			transaction.commit();
			System.out.println("Uspiješan unos podataka");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}


	public void prikazZaposleni()

	{

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
						List zaposleni = session.createQuery("from Zaposleni").list();

			for (Iterator iterator = zaposleni.iterator(); iterator.hasNext();)
			{
			Zaposleni zaposleni1 = (Zaposleni)iterator.next();
				System.out.println(zaposleni1.getZaposleni_id()+"  "+zaposleni1.getZaposleni_ime()+"  "+ zaposleni1.getZaposleni_godine()+"   "+zaposleni1.getZaposleni_adresa()+"   "+zaposleni1.getZaposleni_plata());
			}
			transaction.commit();

		} catch (HibernateException e) {

			transaction.rollback();

			e.printStackTrace();

		} finally {

			session.close();

		}
	}
	public  void  izbrisatiZaposleni()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Unijeti ID zaposlenog");
		int zaposleni_id = sc.nextInt();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Zaposleni where zaposleni_id = :zaposleni_id";
			Query query = session.createQuery(queryString);
			query.setInteger("zaposleni_id", zaposleni_id);
			Zaposleni zaposleni=(Zaposleni) query.uniqueResult();
			session.delete(zaposleni);
			System.out.println("Zaposleni je izbrisan");

		} catch (HibernateException e) {

			transaction .rollback();

			e.printStackTrace();

		} finally {

			session.close();

		}
	}
	public  void  updateZaposleni()
	{
		Scanner sc1 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
		System.out.println("Unijeti ID broj zaposlenog kojeg zelimo izmjeniti");
		int zaposleni_id= sc2.nextInt();
			System.out.println("Unijeti iznos plate zaposlenog");

	int staraPlata = sc.nextInt();
	System.out.println("Unijeti iznos plate zaposlenog nova");

		int  novaPlata1 = sc1.nextInt();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {

			String queryString = "from Zaposleni  where zaposleni_plata = :zaposleni_plata";
			Query query = session.createQuery(queryString);
			query.setParameter("zaposleni_plata",staraPlata);
			Zaposleni zaposleni=(Zaposleni) query.uniqueResult();
			zaposleni.setZaposleni_plata(novaPlata1);
			session.saveOrUpdate(zaposleni);
			transaction.commit();
			System.out.println("Zaposleni je izmjenjen!");
		} catch (HibernateException e) {

			transaction .rollback();

			e.printStackTrace();

		} finally {

			session.close();

		}
	}



}





