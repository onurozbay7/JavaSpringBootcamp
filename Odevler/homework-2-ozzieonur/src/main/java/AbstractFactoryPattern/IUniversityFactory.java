package AbstractFactoryPattern;

public interface IUniversityFactory {
    IDepartment createDepartment();
    IFaculty createFaculty();
}
