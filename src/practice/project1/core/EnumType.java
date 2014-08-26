package practice.project1.core;

public enum EnumType {

    L5_15("L5-15"), L5_20("L5-20"), L5_NEMA("L5-NEMA"), L5_30("L5-30"), L6_15(
	    "L6-15"), L6_20("L6-20"), L6_30("L6-30"), L6_50("L6-50"), PIN_SLEEVE_20(
	    "Pin/Sleeve (20 A)"), PIN_SLEEVE_30("Pin/Sleeve (30 A)"), PIN_SLEEVE_50(
	    "Pin/Sleeve (50 A)"), L14_20("L14-20"), L14_30("L14-30");

    private String name;

    private EnumType(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return this.name;
    }

}
