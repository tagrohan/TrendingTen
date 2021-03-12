package com.example.trendingten.util;

import com.example.trendingten.R;
import com.example.trendingten.models.CardData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utility {

    public static List<CardData> getFirst() {

        List<CardData> data = new ArrayList<>();

        data.add(new CardData("Founders: Top india startup", "", "", R.drawable.main_title));
        data.add(new CardData("Ola Cabs", "Founded by Bhavish Aggarwal in 2010", "10", R.drawable.ola));
        data.add(new CardData("CRED", "Founded by Kunal Shah in 2018", "9", R.drawable.cred));
        data.add(new CardData("FreshtoHome", "Founded by Shan Kadavil in 2010", "8", R.drawable.freshtohome));
        data.add(new CardData("OYO", " Founded by Ritesh Agarwal in 2010", "7", R.drawable.oyo));
        data.add(new CardData("Paytm", "Founded by Vijay Shekhar Sharma in 2010", "6", R.drawable.paytm));
        data.add(new CardData("Cars24", "Founded by Vikram Chopra in 2010", "5", R.drawable.cars24));
        data.add(new CardData("Urban", "Founded by Abhiraj Bhal, Varun Khaitan, Raghav Chandra in 2010", "4", R.drawable.urban));
        data.add(new CardData("Zerodha", "Founded by Nithin Kamath in 2010", "3", R.drawable.zerodha));
        data.add(new CardData("Zomato", "Founded by Goyal, Gunjan Patidar, Guarav Gupta in 2010", "2", R.drawable.zomato));
        data.add(new CardData("Curefit", "Founded by Mukesh Bansal in 2016", "2", R.drawable.curefit));
        data.add(new CardData("Postman", "Founded by Abhinav Asthana, Abhijit Kane, Ankit Sobti in 2014", "1", R.drawable.post));
        return data;
    }


    public static List<CardData> getSecond() {

        List<CardData> data =

                Arrays.asList(new CardData("Indore, Madhya Pradesh", " Indore is a city in west-central India. Proper garbage disposal, waste segregation and conversion of waste to useful products like fuel and compost helped Indore rise above all other Indian cities and grab the top position. The largest and most populous city of Madhya Pradesh, Indore ranked 149 in 2014 in cleanliness ranking, but due to political and administrative will, it now proudly holds the “cleanest city of India” title for the fourth consecutive year!", "1", R.drawable.indore),

                        new CardData("Surat, Gujarat", "Gujarat’s cleanest city, Surat, ranks second in the list of cleanest cities in India 2020 as per the Swach Survekshan results. One of the fastest-growing cities with the help of its Municipal body has transformed completely from a garbage-strewn mess to becoming the 2nd cleanest city in India in 2020", "2", R.drawable.surat),
                        new CardData("Navi Mumbai, Maharashtra", "Navi Mumbai is the 3rd cleanest city in India and one of the cleanest cities in Maharashtra. Although it bagged the 7th position in last year’s rankings, Navi Mumbai has improved its position and claimed the 3rd position in the country.", "3", R.drawable.navi),
                        new CardData("Ambikapur, Chhattisgarh", "Ambikapur, one of the oldest cities in India, has also made it to the list of 20 cleanest cities in India 2020. The city has no dumping yards and is able to generate good income by recycling the waste. It also has put in sincere efforts in segregating at least 90% of the waste generated on a daily basis.", "4", R.drawable.ambikapur),
                        new CardData(" Mysore, Karnataka", "Karnataka’s cleanest city also ranks 5th in the list of top 20 cleanest cities in India 2020. Once ranking on top for 2 consecutive years, Mysuru still continues its pledge to stay clean and generate minimum waste. The zero-waste plant workers ensure to segregate all the household waste into different categories which is why the city has consistently stayed a recurring name in the list of cleanest cities in India.", "5", R.drawable.mysore),
                        new CardData("Vijayawada, Andhra Pradesh", "Vijaywada bags the fourth position in the list of cleanest cities in India, and Andhra Pradesh outclasses other states and joins the list of cleans states in India. With a population of more 10 lakh, Vijayawada has indeed invested well in converting the city into a clean one and also ranking well on the 2020 list of cleanest cities in India.", "6", R.drawable.vijayawada),
                        new CardData("Ahmedabad, Gujarat", "Although ranking 7th in the list of cleanest cities in India, it has grabbed the top spot for the category of cleanest cities with a population of over 40 lakh. Like other cities, even Ahmedabad has put in considerable efforts to create awareness about waste segregation which has been helping the city manage its waste efficiently. Such a step has lead to frequent featuring of Ahmedabad in Swach Survekshan list of cleanest cities in India", "7", R.drawable.ahmedabad),

                        new CardData("New Delhi, Delhi", "New Delhi has grabbed the 8th spot in the Swach Survekshan 2020 list of cleanest cities in India. The commendable efforts of the NDMC has aided New Delhi to climb up the list and secure the 8th spot. Although infamously known for being a polluted city, the efforts of this body has helped New Delhi find a place in this list.", "8", R.drawable.delhi),

                        new CardData("Chandrapur, Maharashtra", "Another city in Maharashtra, Chandrapur has also been named one of the cleanest cities in India 2020 list by Swach Survekshan. It has secured the 9th position.", "9", R.drawable.chandrapur),

                        new CardData("Khargone, Madhya Pradesh", "Another city from the state of Madhya Pradesh, Khargone, has caught the limelight for being one of the cleanest cities in India as announced by Swach Survekshan 2020 results. Khargone was awarded 5158.36 points and ranks 10th in the list.", "10", R.drawable.khargone));

        return data;

    }

//    public static List<CardData> getThird() {
//
//        List<CardData> data = Arrays.asList(
//                new CardData("Agency", "Top 10 intelligence agencies", "", R.drawable.agency),
//
//        new CardData("Research and Analysis Wing", "The primary aim of RAW is to monitor the movement and activities of the neighboring countries. The agency came into being after the Sino-Indian war of 1962 and the India-Pakistan war of 1965, which exposed gaps in intelligence gathering undertaken by the Intelligence Bureau. Prime Minister Indira Gandhi and her government thus felt the need for an agency that would raise an alarm, and protect India before it went to war, or was hit by a terror attack", "1", R.drawable.raw),
//
//        new CardData("Mossad", "Mossad has been a part of some of the most daring undercover operations in the world. This special operation and foreign intelligence agency launched operation 'Wrath of God' to track down and kill all the PLO activists responsible for hostage and killing of 11 Israeli athletes at the Munich Olympics in 1072.", "2", R.drawable.mossad),
//
//        new CardData("Central Intelligence Agency", "The CIA is one major reason behind America’s domination over the world. This agency plays a vital role in maintaining the USA's position as a superpower and mediate foreign policy intelligence and analysis countrywide. For doing the same, the CIA once owned dummy corporation, \"Air America, \" that operated as a civilian airline but was used to conduct military operations in Laos, Indochina border, etc.", "3", R.drawable.cia),
//
//        new CardData("Military Intelligence", "MI6 is one of the oldest intelligence agencies and has existed in various forms since the establishment of a secret service in 1569 by Sir Francis Walsingham, who became secretary of state to Queen Elizabeth I. It was constituted in its present form in 1909 by Commander (later Sir) Mansfield Cumming as part of Britain’s attempt to coordinate intelligence activities prior to the outbreak of World War I. Even today the agency works with top agencies like the CIA to helps them in their missions.", "4", R.drawable.millitery),
//
//        new CardData("Australian Secret Intelligence Service", "Australian Secret Intelligence Service aka ASIS is the Australian government intelligence agency responsible for collecting foreign intelligence, undertaking counter-intelligence activities and cooperation with other intelligence agencies overseas. For more than twenty years, the existence of the agency was a secret even from its own government. However, once came into limelight, it was examined by the Royal Commission thrice for its operations in the year 1974 and 1983  and in 1994.", "5", R.drawable.australia),
//
//        new CardData("Directorate General for External Security", "DGES is the external intelligence agency of France that is operating under the direction of the French ministry of defense. The agency works alongside the DCRI (the Central Directorate of Interior Intelligence) and has one of the most interesting logos. The bird of prey represents the sovereignty, operational capacities, international operational nature, and the efficiency of the DGSE in the logo of the agency. France is depicted as a sanctuary in the logo and the lines depict the networks utilized by the DGES. ", "6", R.drawable.france),
//
//        new CardData("The Bundesnachrichtendienst", "The BND collects and evaluates information on a variety of areas such as international terrorism, WMD proliferation and illegal transfer of technology, etc. Created in April 1956, it absorbed the “Gehlen Organization,” a covert intelligence force which was created by Major general Reinhard Gehlen after World War II and which cooperated with U.S. intelligence agencies.", "7", R.drawable.germany),
//
//        new CardData("Ministry of State Security", "Ministry of State Security is the security agency of the People’s Republic of China whose aim is to ensure the security of the state through effective measures against enemy agents, spies, etc. The Ministry of State Security runs run China Institutes of Contemporary International Relations (CICIR) that has several scholars to do research and analysis as well as consult with foreign officials.", "8", R.drawable.china),
//
//        new CardData("Federal Security Service of the Russian Federation", "FSD is the main domestic security agency of the Russian Federation and is responsible for internal security of the Russian state, counterespionage, and the fight against organized crime, terrorism, and drug smuggling. In 2011, the FSB prevented 94 \"crimes of a terrorist nature\", including eight terrorist attacks and also foiled a planned suicide bombing in Moscow on New Year's Eve.", "9", R.drawable.russia),
//
//        new CardData("Canadian Security Intelligence Service ", "CSIS is the intelligence agency of Canada that looks into the national security of the country. Duties of CSIS include collecting intelligence, running covert operations, and advising the government on potential security threats. The CSIS is also Canada’s representative in the Five Eyes, an intelligence alliance between the US, the UK, Canada, Australia, and New Zealand.", "10", R.drawable.canada)
//        );
//
//
//        return data;
//
//    }


}
