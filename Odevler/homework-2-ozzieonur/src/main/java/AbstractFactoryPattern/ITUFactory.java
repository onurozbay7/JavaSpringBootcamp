package AbstractFactoryPattern;

public class ITUFactory  implements IUniversityFactory{
    @Override
    public IDepartment createDepartment() {
        return new InteriorArchitectureDepartment();
    }

    @Override
    public IFaculty createFaculty() {
        return new ArchitectureFaculty();
    }
}
