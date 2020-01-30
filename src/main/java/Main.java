import model.Alumno;
import model.Clase;
import model.Instituto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("damPersistence");
        EntityManager em = emf.createEntityManager();

        Instituto instituto = new Instituto();
        Clase clase = new Clase();
        Alumno alumno = new Alumno();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Insertar Instituto." +
                "\n2. Insertar Clase." +
                "\n3. Insertar Alumno.");


        boolean query = true;
        int i = 1, numeroAlumnos = 0;

        int option = sc.nextInt();
        em.getTransaction().begin();
        switch (option) {
                case 1:
                    System.out.println("Inserta el id de tu instituto.");
                    instituto.setId(sc.nextInt());
                    sc.nextLine();
                    instituto.setnAlumnos(0);
                    System.out.println("Inserta el nombre de tu instituto.");
                    instituto.setNombre(sc.nextLine());

                    em.persist(instituto);
                    break;

                case 2:
                    System.out.println("Estos son los institutos a los que puedes añadir tu clase.\n");
                    while (query) {
                        try {
                            System.out.println(em.find(Instituto.class, i).toString());
                            i++;
                        } catch (NullPointerException e) {
                            query = false;
                        }
                    }

                    System.out.println("Inserta el id de tu clase.");
                    clase.setId(sc.nextInt());
                    System.out.println("Inserta el id del instituto de tu clase.");
                    clase.setInstitutoId(sc.nextInt());
                    System.out.println("Inserta el numero de alumnos de tu clase.");
                    clase.setnAlumnos(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Inserta el nombre de tu clase.");
                    clase.setNombre(sc.nextLine());
                    System.out.println("Inserta la rama de tu clase.");
                    clase.setRama(sc.nextLine());

                    em.persist(clase);
                    break;

                case 3:
                    System.out.println("Estas son las clases a las que puedes añadir tu alumno.\n");
                    while (query) {
                        try {
                            System.out.println(em.find(Clase.class, i).toString());
                            i++;
                        } catch (NullPointerException e) {
                            query = false;
                        }
                    }

                    System.out.println("Inserta el DNI del alumno.");
                    alumno.setDni(sc.nextInt());
                    System.out.println("Inserta el id de la clase del alumno.");
                    alumno.setClaseId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Inserta el nombre del alumno.");
                    alumno.setNombre(sc.nextLine());

                    em.persist(alumno);
                    break;
            case 4:
                while (query){
                    try {
                        //CORREGIR CONTADORES I Y J?
                        if (em.find(Instituto.class, i).getId() == em.find(Clase.class, i).getInstitutoId()) {
                            numeroAlumnos += em.find(Clase.class, i).getnAlumnos();
                            System.out.println(em.find(Instituto.class, i).getNombre() + " " + numeroAlumnos);
                        }
                        i++;
                    }catch (NullPointerException e){
                        query = false;
                    }
                }
                break;
            }
            em.getTransaction().commit();
            em.close();
    }
}
