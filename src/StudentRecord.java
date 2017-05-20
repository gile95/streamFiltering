/**
 * Razred koji sadrži podatke o jednom studentu u obliku JMBAG, prezime, ime, bodoviMI, bodoviZI, bodoviLAB, ocjena.
 * @author Mislav Gillinger
 * @version 1.0
 */
public class StudentRecord {
	
	/** Studentov jmbag. */
	private String jmbag;
	/** Prezime studenta. */
	private String prezime;
	/** Ime studenta. */
	private String ime;
	/** Bodovi na međuspitu. */
	private double bodoviMI;
	/** Bodovi na završnom ispitu. */
	private double bodoviZI;
	/** Bodovi iz laboratorijskih vježbi. */
	private double bodoviLAB;
	/** Završna ocjena. */
	private int ocjena;
	
	/**
	 * Stvara novi zapis o studentu sa konkretnim podacima.
	 * @param jmbag Studentov jmbag.
	 * @param prezime Prezime studenta.
	 * @param ime Ime studenta.
	 * @param bodoviMI Bodovi na međuspitu.
	 * @param bodoviZI Bodovi na završnom ispitu.
	 * @param bodoviLAB Bodovi iz laboratorijskih vježbi.
	 * @param ocjena Završna ocjena.
	 */
	public StudentRecord(String jmbag, String prezime, String ime, double bodoviMI, double bodoviZI, double bodoviLAB,
			int ocjena) {
		super();
		this.jmbag = jmbag;
		this.prezime = prezime;
		this.ime = ime;
		this.bodoviMI = bodoviMI;
		this.bodoviZI = bodoviZI;
		this.bodoviLAB = bodoviLAB;
		this.ocjena = ocjena;
	}

	/**
	 * Dohvaća jmbag.
	 * @return Jmbag.
	 */
	public String getJmbag() {
		return jmbag;
	}

	/**
	 * Dohvaća prezime.
	 * @return Prezime.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Dohvaća ime.
	 * @return Ime.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Dohvaća bodove sa međuispita.
	 * @return Bodovi sa međuispita.
	 */
	public double getBodoviMI() {
		return bodoviMI;
	}

	/**
	 * Dohvaća bodove sa završnog ispita.
	 * @return Bodovi sa završnog ispita.
	 */
	public double getBodoviZI() {
		return bodoviZI;
	}

	/**
	 * Dohvaća bodove sa laboratorijskih vježbi.
	 * @return Bodovi sa laboratorijskih vježbi.
	 */
	public double getBodoviLAB() {
		return bodoviLAB;
	}

	/**
	 * Dohvaća konačnu ocjenu.
	 * @return Konačna ocjena.
	 */
	public int getOcjena() {
		return ocjena;
	}

	/**
	 * Postavlja bodove na međuispitu.
	 * @param bodoviMI Bodovi na međuispitu.
	 */
	public void setBodoviMI(double bodoviMI) {
		this.bodoviMI = bodoviMI;
	}

	/**
	 * Postavlja bodove na završnom ispitu.
	 * @param bodoviZI Bodovi na završnom ispitu.
	 */
	public void setBodoviZI(double bodoviZI) {
		this.bodoviZI = bodoviZI;
	}

	/**
	 * Postavlja bodove sa laboratorijskih vježbi.
	 * @param bodoviLAB Bodovi sa laboratorijskih vježbi.
	 */
	public void setBodoviLAB(double bodoviLAB) {
		this.bodoviLAB = bodoviLAB;
	}

	/**
	 * Postavlja konačnu ocjenu.
	 * @param ocjena Konačna ocjena.
	 */
	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}	
	
	@Override
	public String toString(){
		return String.format("%s %s %s : %.2f %.2f %.2f; ocj: %d", jmbag, prezime, ime, bodoviMI, bodoviZI, bodoviLAB, 
				ocjena);
	}
	
}
