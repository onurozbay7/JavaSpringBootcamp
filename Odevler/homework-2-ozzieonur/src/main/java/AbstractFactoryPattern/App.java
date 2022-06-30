package AbstractFactoryPattern;

public class App {


    public static void main(String[] args) {
        IUniversityFactory itu = new ITUFactory();
        IUniversityFactory odtu = new ODTUFactory();

        IDepartment ituDepartment = itu.createDepartment();
        IDepartment odtuDepartment = odtu.createDepartment();

        IFaculty ituFaculty = itu.createFaculty();
        IFaculty odtuFaculty = odtu.createFaculty();


        System.out.println(ituFaculty.getDeanName() + " " + ituDepartment.getNumberOfStudents());

        System.out.println(odtuFaculty.getDeanName() + " " + odtuDepartment.getNumberOfStudents());
    }

}
