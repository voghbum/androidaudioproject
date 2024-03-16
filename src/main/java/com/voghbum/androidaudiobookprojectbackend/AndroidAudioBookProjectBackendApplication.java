package com.voghbum.androidaudiobookprojectbackend;

import com.voghbum.androidaudiobookprojectbackend.data.repository.AuthorRepository;
import com.voghbum.androidaudiobookprojectbackend.data.repository.BookFileRepository;
import com.voghbum.androidaudiobookprojectbackend.data.repository.BookMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AndroidAudioBookProjectBackendApplication implements CommandLineRunner {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookFileRepository bookFileRepository;
	@Autowired
	private BookMetaDataRepository bookMetaDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(AndroidAudioBookProjectBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*		var dostoyevski = new Author();
		dostoyevski.birthDate = LocalDate.of(1821, 11, 11);
		dostoyevski.bookCount = 1;
		dostoyevski.description = "Fyodor Mihayloviç Dostoyevski, Rus roman yazarıdır. 1821 yılında Moskova’da doğdu. " +
				"Çocukluğunu sarhoş bir baba ve hasta bir anne arasında geçirdi. Sibirya sürgünü ve hapishane deneyimi onun yaşamını derinden etkiledi. " +
				"Eserleri, insanın iç dünyasının karmaşıklıklarını ve evrensel temaları işlerSuç ve Ceza, Karamazov Kardeşler," +
				" Yeraltından Notlar gibi klasiklerle tanınır";
		dostoyevski.name = "Dostoyevski";
		dostoyevski.location = "Russia";
		dostoyevski = authorRepository.save(dostoyevski);

		var crimeAndPunishment = new BookMetadata();
		crimeAndPunishment.author = dostoyevski;
		crimeAndPunishment.description = "Suç ve Ceza, Fyodor Mihayloviç Dostoyevski’nin 1866 yılında yayımlanan olgunluk döneminin ilk büyük romanıdır. " +
				"Bu dünya klasikleri arasında yer alan eser, toplumsal kötülüklerin sebeplerini ortaya koyarken kötülükleri yapanların" +
				" cezalarını çekmesi gerektiğini anlatır. Roman, 19. yüzyıl Rusya’sında geçer ve genç bir üniversite öğrencisi olan Raskolnikov’un" +
				" işlediği çifte cinayet üzerine yaşadıklarını konu alır. Raskolnikov, tefeci kadını öldürüp mücevherleri alır," +
				" ancak işlediği cinayete kimsenin tanıklık etmemesi için kız kardeşini de " +
				"öldürmek zorunda kalır. Suç ve Ceza, insanın suç işleyerek hayatta kalma mücadelesi üzerine odaklanmış bir başyapıttır ";
		crimeAndPunishment.insertDateTime = LocalDateTime.now();
		crimeAndPunishment.writtenYear = "1866";
		crimeAndPunishment.name = "Crime and Punishment";
		crimeAndPunishment = bookMetaDataRepository.save(crimeAndPunishment);

		var crimeAndPunishmentTur = new BookFile();
		try(var file = new FileInputStream("src/main/resources/dummyData/crimeAndPunishment.txt")) {
			crimeAndPunishmentTur.bookAudio = file.readAllBytes();
		}
		crimeAndPunishmentTur.body = new BufferedReader(new FileReader("src/main/resources/dummyData/crimeAndPunishment.txt", StandardCharsets.UTF_8)).readLine();
		crimeAndPunishmentTur.bookMetaData = crimeAndPunishment;
		crimeAndPunishmentTur.language = "Turkish";
		crimeAndPunishmentTur = bookFileRepository.save(crimeAndPunishmentTur);*/
	}
}
