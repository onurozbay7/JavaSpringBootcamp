package AbstractFactoryPattern;

public class ODTUFactory implements IUniversityFactory {


    @Override
    public IDepartment createDepartment() {
        return new ComputerSienceDepartment();
    }

    @Override
    public IFaculty createFaculty() {
        return new EngineeringFaculty();
    }
}
