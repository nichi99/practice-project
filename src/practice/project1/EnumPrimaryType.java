package practice.project1;

public enum EnumPrimaryType {

    L5_15__15_120("L5-15", 15, 120),
    L5_20__20_120("L5-20", 20, 120),
    L5_NEMA__20_100("L5-NEMA", 20, 100),
    L5_30__30_120("L5-30", 30, 120),
    L6_15__15_208("L6-15", 15, 208),
    L6_20__20_208("L6-20", 20, 208),
    L6_30__30_208("L6-30", 30, 208),
    L6_50__50_208("L6-50", 50, 208),
    PIN_SLEEVE_20__20_208("Pin/Sleeve", 20, 208),
    PIN_SLEEVE_30__30_208("Pin/Sleeve", 30, 208),
    PIN_SLEEVE_50__50_208("Pin/Sleeve", 50, 208),
    L14_20__20_208("L14-20", 20, 208),
    L14_30__30_208("L14-30", 30, 208),
    _3_L15__50_208("3\u03A6 / L15", 50, 208),
    _3_L15__30_250("3\u03A6 / L15", 30, 250),
    _3_L15__50_250("3\u03A6 / L15", 50, 250),
    _3_L21__50_208("3\u03A6 / L21", 30, 208),
    _3_PIN_SLEEVE__30_208("3\u03A6 Pin/Sleeve", 30, 208),
    _3_PIN_SLEEVE__50_208("3\u03A6 Pin/Sleeve", 50, 208),
    _3__20_208("3\u03A6 / 20A", 20, 208),
    _3__30_208("3\u03A6 / 30A", 30, 208),
    __60_480("", 60, 480),
    _3__60_208("3\u03A6 / 60A", 60, 208);

    private String name;
    private int current;
    private int voltage;

    private EnumPrimaryType(String name, int current, int voltage) {
	this.name = name;
	this.current = current;
	this.voltage = voltage;
    }

    public String getName() {
	return this.name;
    }

    public int getCurrent() {
	return this.current;
    }

    public int getVoltage() {
	return this.voltage;
    }

    @Override
    public String toString() {
	return this.name + " (" + this.current + "A" + " " + this.voltage + "V"
		+ ")";
    }

}
