import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Razred koji radi s objektima tipa {@link StudentRecord}. 
 * @author Mislav Gillinger
 * @version 1.0
 */
public class StudentDemo {

	/**
	 * Ova metoda pokreće program.
	 * @param args Argumenti komandne linije.
	 * @throws IOException Ako dođe do IO Exceptiona.
	 */
	public static void main(String[] args) throws IOException {
	
		List<String> lines = Files.readAllLines(
				Paths.get("./studenti.txt"),
				StandardCharsets.UTF_8
				);
		
		List<StudentRecord> records = new ArrayList<>();
		
		for(String line : lines){
			String[] elements = line.trim().split("\\s+");
			if(elements.length == 7){
				records.add(new StudentRecord(elements[0], elements[1], elements[2], Double.parseDouble(elements[3]),
						Double.parseDouble(elements[4]), Double.parseDouble(elements[5]), Integer.parseInt(elements[6])));
			}
		}
		
		long broj = records.stream()
				.filter(s -> (s.getBodoviMI() + s.getBodoviZI() + s.getBodoviLAB()) > 25)
				.count();
		
		System.out.println("1---------------------------------");
		System.out.println("MI+ZI+LAB imaju više od 25 bodova: " + broj);
		System.out.println("----------------------------------");
		
		long broj5 = records.stream()
				.filter(s -> s.getOcjena() == 5)
				.count();
		
		System.out.println("2---------------------------------");
		System.out.println("ocjena 5: " + broj5);
		System.out.println("----------------------------------");
		
		List<StudentRecord> odlikasi = records.stream()
				.filter(s -> s.getOcjena() == 5)
				.collect(Collectors.toList());
		
		System.out.println("3---------------------------------");
		System.out.println("Studenti koji su dobili 5:");
		for(StudentRecord record : odlikasi) System.out.println(record);
		System.out.println("----------------------------------");
		
		List<StudentRecord> odlikasiSortirano = records.stream()
				.filter(s -> s.getOcjena() == 5)
				.sorted((s1,s2) -> -(Double.valueOf(s1.getBodoviMI()+s1.getBodoviZI()+s1.getBodoviLAB())
						.compareTo(Double.valueOf(s2.getBodoviMI()+s2.getBodoviZI()+s2.getBodoviLAB()))))
				.collect(Collectors.toList());
		
		System.out.println("4---------------------------------");
		System.out.println("Studenti koji su dobili 5, sortirano po bodovima:");
		for(StudentRecord record : odlikasiSortirano) System.out.println(record);
		System.out.println("----------------------------------");
		
		List<String> nepolozeniJMBAGovi = records.stream()
				.filter(s -> s.getOcjena() == 1)
				.sorted((s1,s2) -> (s1.getJmbag().compareTo(s2.getJmbag())))
				.map(StudentRecord :: getJmbag)
				.collect(Collectors.toList());
		
		System.out.println("5---------------------------------");
		System.out.println("Studenti koji nisu položili kolegij, sortirano po JMBAGu:");
		nepolozeniJMBAGovi.forEach(System.out::println);
		System.out.println("----------------------------------");
		
		Map<Integer, List<StudentRecord>> mapaPoOcjenama = records.stream()
				.collect(Collectors.groupingBy(StudentRecord::getOcjena));
		
		System.out.println("6---------------------------------");
		System.out.println("Mapa ciji su kljucevi ocjene, a vrijednosti liste studenata s tim ocjenama:");
		for(Integer key : mapaPoOcjenama.keySet()){
			System.out.println(key);
			mapaPoOcjenama.get(key).forEach(System.out::println);
		}
		System.out.println("----------------------------------");
		
		Map<Integer, Integer> mapaPoOcjenama2 = records.stream()
				.collect(Collectors.toMap(StudentRecord::getOcjena, u -> 1, (u, t) -> u + 1));
		
		System.out.println("7---------------------------------");
		System.out.println("Mapa ciji su kljucevi ocjene, a vrijednosti broj studenata s tim ocjenama:");
		for(Integer key : mapaPoOcjenama2.keySet()) {
			System.out.print(key + ": ");
			System.out.println(mapaPoOcjenama2.get(key));
		}
		System.out.println("----------------------------------");
		
		Map<Boolean, List<StudentRecord>> prolazNeprolaz = records.stream()
				.collect(Collectors.partitioningBy(s -> s.getOcjena() > 1));
		
		System.out.println("8---------------------------------");
		System.out.println("True: studenti koji su prošli, false: studenti koji nisu prošli:");
		for(Boolean key : prolazNeprolaz.keySet()) {
			System.out.println(key);
			prolazNeprolaz.get(key).forEach(System.out::println);
		}
		System.out.println("----------------------------------");
	}

}
