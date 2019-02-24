package hu.ak_akademia.jegyeld.dto;

public enum Status {

	ACTIVE("A", "Aktív"), DELETED("D", "Törölt");

	private String code;
	private String name;

	private Status(String code, String name) {
		this.code   = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}