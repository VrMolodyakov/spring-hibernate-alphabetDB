package com.example.HiberTest;


import com.example.HiberTest.Entities.IntegerStat;
import com.example.HiberTest.Entities.subStr;
import com.example.HiberTest.Repositories.daoRepository;
import com.example.HiberTest.Entities.textTable;
import com.example.HiberTest.Repositories.strStatRepoImpl;
import com.example.HiberTest.Repositories.subStrRepoImpl;
import com.example.HiberTest.Statistics.characterStats;
import com.example.HiberTest.Statistics.statRecorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class HiberTestApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(HiberTestApplication.class);



	@Autowired
	subStrRepoImpl subRepo;

	@Autowired
	strStatRepoImpl statRepo;

	@Autowired
	statRecorder recorder;

	@Autowired
	characterStats stats;

	public static void main(String[] args) {
		SpringApplication.run(HiberTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{


		//statRepo.deleteAll();
		//subRepo.deleteAll();
		//recorder.recordTextStatistics(4);
		//recorder.recordAllSubstring();

		//System.out.println(addAlphabetToStr().size());
		//subRepo.addSubStringFromText(addAlphabetToStr());
		/*stats.getTextForStatistics();
		stats.getStatistics();
		stats.printText();*/


		/*stats.getTextForStatistics();
		stats.getSubStringsStatistics();
		stats.printText();*/





		List<Object[]> lst= statRepo.getSumAndGroupByStats();

		PrintWriter writer  = new PrintWriter("resultStatistics.txt","UTF-8");
		writer.print("strId              count           possiblyCount");
		writer.print("\r\n");

		for (Object[] objects :lst){
			/*for (Object object : objects){

				Integer id = (Integer) object;
				writer.format("%8d",object);
			}
			writer.print("\r\n");*/

			for (int i = 0; i < objects.length; i++) {
				if(i == 0){
					Integer id = (Integer) objects[i];
					String str = "'"+ subRepo.findById(id).getStr()+"'"+";";
					writer.format("%4s",str);
				}else{
					writer.format("%11d",objects[i]);
					writer.print(";");
				}
			}
			writer.print("\r\n");
		}
		writer.close();

		// "\""+ subRepo.findById(id).getStr()+"\""+";";


	}


	private static void listToString(List<textTable> lst){


		lst.stream().forEach(System.out::println);
	}

	private static void strListToString(List<subStr> list){
		list.stream().forEach(System.out::println);
	}

	private static List<String> addAlphabetToStr(){
		/*String[] arrayOfSymbols = new String[] {"А","Б", "В", "Г","Д","Е" ,"Ё",
								       "Ж" ,"З" ,"И" ,"Й", "К" ,"Л" ,
									   "М" ,"Н", "О", "П", "Р", "С", "Т", "У" ,"Ф" ,"Х",
									   "Ц","Ч" ,"Ш" ,"Щ" ,"Ъ", "Ы", "Ь", "Э", "Ю" ,"Я","0",
									   "1","2","3","4","5","6","7","8","9" ,".","?",",",":","!","'"," ","\n"};*/


		String[] arrayOfSymbols = new String[] {
				"А","Б", "В", "Г","Д","Е" ,"Ё",
				"Ж" ,"З" ,"И" ,"Й", "К" ,"Л" ,
				"М" ,"Н", "О", "П", "Р", "С", "Т", "У" ,"Ф" ,"Х",
				"Ц","Ч" ,"Ш" ,"Щ" ,"Ъ", "Ы", "Ь", "Э", "Ю" ,"Я","0",
				"1","2","3","4","5","6","7","8","9" ," ",".",",","!","?",":","\"","%","-","+","=","/"};


		System.out.println(arrayOfSymbols.length);
		List<String> alphabetLst = new ArrayList<String >(Arrays.asList(arrayOfSymbols));
		for (int i = 0; i < arrayOfSymbols.length; i++) {
			for (int j = 0; j < arrayOfSymbols.length; j++) {
				//subRepo.save(new subStr(alphabetLst.get(i) + alphabetLst.get(j)));
				alphabetLst.add(arrayOfSymbols[i] + arrayOfSymbols[j]);
				for (int k = 0; k <arrayOfSymbols.length; k++) {
					//subRepo.save(new subStr(alphabetLst.get(i) + alphabetLst.get(j) + alphabetLst.get(k)));
					alphabetLst.add(arrayOfSymbols[i] + arrayOfSymbols[j] + arrayOfSymbols[k]);
				}
			}
		}
		return alphabetLst;

	}

}
