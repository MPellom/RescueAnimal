
public class Monkey extends RescueAnimal{

	private String tailLength;
	private String height;
	private String bodyLength;
	private String species;

	public Monkey(String name, String gender, String age, String weight, String acquisitionDate, String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry, String tailLength, String height, String bodyLength, String species) {

		setName(name);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
		this.tailLength = tailLength;
		this.height = height;
		this.bodyLength = bodyLength;
		this.species = species;
		
	}
	public String getTailLength() {
		return tailLength;
	}

	public String getHeight() {
		return height;
	}

	public String getBodyLength() {
		return bodyLength;
	}

	public String getSpecies() {
		return species;
	}

}
