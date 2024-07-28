package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarController2 {

    private ScreenController scr = new ScreenController();
    String ANSI_RESET = "\u001B[0m";

    public CarController2(){

    }

    public String carSelection(String hexString) throws NumberFormatException, IOException {
        Map<String, String> carHexMap = new HashMap<>();

        // Popolazione della HashMap con i dati forniti
        carHexMap.put("Car_BMW_F90_2017", "EC E3 27 00");
        carHexMap.put("Car_Audi_R8V10_2016", "87 AE 2B 00");
        carHexMap.put("Car_Nissan_GTR_2017", "B4 09 38 00");
        carHexMap.put("Car_Koenigsegg_Regera_2015", "BD 30 3A 00");
        carHexMap.put("Car_Chevrolet_CorvetteGS_2017", "8C F0 40 00");
        carHexMap.put("Car_Audi_S5_2017", "25 B3 42 00");
        carHexMap.put("StaticAbandon_BMW_M3E30Evo2_1988", "0E 02 43 00");
        carHexMap.put("Car_Nissan_350Z_2006", "7F 8A 66 00");
        carHexMap.put("Car_Chevrolet_C10PickupStepside_1965_SpeedX", "B1 99 71 00");
        carHexMap.put("Car_Plymouth_Barracuda_1970", "A1 99 7E 00");
        carHexMap.put("Car_Chevrolet_C10PickupStepside_1965_BossGoon", "B6 9B 87 00");
        carHexMap.put("Car_Chevrolet_CorvetteGSPolice_2017", "FC 90 8A 00");
        carHexMap.put("Car_MercedesBenz_AMGA45_2016", "8F 74 99 00");
        carHexMap.put("Car_LandRover_Defender110_2017", "3E ED 9B 00");
        carHexMap.put("Car_Pagani_HuayraBC_2017", "FD 62 A2 00");
        carHexMap.put("GoonCar_HighwayHeist_Dodge_ChallengerSRT_2014", "53 2D B4 00");
        carHexMap.put("Car_Porsche_PanameraTurbo_2017", "37 A8 BA 00");
        carHexMap.put("Car_AstonMartin_DB11_2017", "CD 8B BD 00");
        carHexMap.put("Car_Beck_KustomsF132_1932", "C5 EF C4 00");
        carHexMap.put("Car_MercedesBenz_AMGA45_Cinematic", "6E 3B C7 00");
        carHexMap.put("Car_Generic_ArmouredTruck_2009", "CE 5A F1 00");
        carHexMap.put("Car_Dodge_Charger_1969", "FC ED FD 00");
        carHexMap.put("Car_Generic_SemiTruck_2017", "7C A5 02 01");
        carHexMap.put("Car_Generic_MacTruck_2017", "E3 D0 61 01");
        carHexMap.put("TrafficCar_Trailer_2012_Prototype", "2D 1C 6B 01");
        carHexMap.put("Car_Chevrolet_BelAir_1955", "32 32 7B 01");
        carHexMap.put("TrafficCar_Generic_GarbageTruck_2003", "09 98 80 01");
        carHexMap.put("Car_Infiniti_Q60S_2017", "9E 89 92 01");
        carHexMap.put("TrafficCar_Generic_FlatbedTruck_2003", "D7 44 98 01");
        carHexMap.put("Car_Chevrolet_BelAir_1955_SpeedX", "0A 25 9E 01");
        carHexMap.put("Car_MercedesBenz_AMGA45_2016_Racer", "0B AA A5 01");
        carHexMap.put("Car_Nissan_GTR_2017_BossGoon", "DA 7F BF 01");
        carHexMap.put("Car_Generic_ContainerTrailer_2017", "77 45 C7 01");
        carHexMap.put("Car_Ford_GT_2017", "3D A0 D2 01");
        carHexMap.put("Car_Ford_F150Raptor_2017", "F8 D6 DE 01");
        carHexMap.put("GoonCar_BMW_X6M_2016", "D0 1C F3 01");
        carHexMap.put("Car_Volkswagen_Beetle_1963_SpeedX", "42 62 06 02");
        carHexMap.put("TrafficCar_Generic_Limousine_2010", "11 17 12 02");
        carHexMap.put("Car_Buick_GrandNational_1987", "BE 5F 16 02");
        carHexMap.put("Car_Mini_CountrymanJCW_2017", "B4 C8 20 02");
        carHexMap.put("Car_Chevrolet_C10PickupStepside_1965", "6D C5 24 02");
        carHexMap.put("Car_Nissan_Fairlady240ZG_1971_SpeedX", "AF B6 3E 02");
        carHexMap.put("Car_Honda_CivicTypeR_2015", "E8 A9 4E 02");
        carHexMap.put("Car_AstonMartin_Vulcan_2017", "7F EA 59 02");
        carHexMap.put("Car_MercedesBenz_AMGG63_2017", "B8 88 5C 02");
        carHexMap.put("GoonCar_HighwayHeist_BMW_X6M_2016", "A4 67 6B 02");
        carHexMap.put("Car_Volkswagen_Beetle_1963", "0D 59 8E 02");
        carHexMap.put("GoonCar_Dodge_ChallengerSRT_2014", "2E 99 91 02");
        carHexMap.put("TrafficCar_Generic_ArmouredTruck_2009", "60 88 97 02");
        carHexMap.put("Car_Pagani_HuayraBC_2017_BossGoon", "0A 03 AD 02");
        carHexMap.put("Car_Ford_Explorer_2011", "F4 3B AD 02");
        carHexMap.put("Car_Chevrolet_CamaroZ28_2014", "14 2B B7 02");
        carHexMap.put("Car_Chevrolet_CamaroZ28_2014_BossGoon", "14 2B B7 02");
        carHexMap.put("TrafficCar_Generic_TourBus_2006", "99 E6 C7 02");
        carHexMap.put("Car_BMW_M3E30Evo2_1988_Abandon", "D4 7C CA 02");
        carHexMap.put("Car_Volvo_Amazon_1970", "08 BF E0 02");
        carHexMap.put("Car_Volkswagen_GolfGTi_2016", "FA 3D F5 02");
        carHexMap.put("Car_Jaguar_FTypeRCoupe_2015", "6B 94 F8 02");
        carHexMap.put("Car_Porsche_918Spyder_2015", "2C 58 07 03");
        carHexMap.put("Car_BMW_X6M_2016", "1C E1 0C 03");
        carHexMap.put("Car_Mercury_Cougar_1967", "78 37 2B 03");
        carHexMap.put("Car_Nissan_Fairlady240ZG_1971", "70 1B 45 03");
        carHexMap.put("Narrative_Racer_Car_Nissan_Fairlady240ZG_1971", "70 1B 45 03");
        carHexMap.put("Car_Acura_NSX_2017", "4E 17 60 03");
        carHexMap.put("Car_Ford_Hotrod_1932", "E1 34 8F 03");
        carHexMap.put("Car_Ford_Mustang_1965_SpeedX", "6C AA 97 03");
        carHexMap.put("Car_McLaren_P1_2014", "C2 BD 9F 03");
        carHexMap.put("Car_Chevrolet_CamaroSS_1967", "01 D2 A3 03");
        carHexMap.put("GoonCar_BMW_M2_2016", "9D AE AD 03");
        carHexMap.put("Car_Ford_MustangBoss302_1969", "22 CA AD 03");
        carHexMap.put("TrafficCar_BMW_E46328i_1999", "E9 BC 60 07");
        carHexMap.put("Car_Ford_FocusRS_2015", "05 23 9D 08");
        carHexMap.put("TrafficCar_BMW_128i_2009", "2F D2 87 0A");
        carHexMap.put("Car_Volvo_242DL_1975", "2B 41 9E 0F");
        carHexMap.put("Car_Lamborghini_Huracan_2015", "4B 17 F3 1D");
        carHexMap.put("Car_Lamborghini_AventadorLP7004_2014", "27 A2 72 2C");
        carHexMap.put("Car_Nissan_SkylineGTRVSpec_1993", "66 73 D5 31");
        carHexMap.put("Car_Subaru_BRZPremium_2014", "FB 53 C4 36");
        carHexMap.put("Porsche911CarreraRSR", "D0 61 45 3A");
        carHexMap.put("Car_Ford_MustangFoxbody_1990", "99 74 9E 43");
        carHexMap.put("Car_Dodge_ChargerSRT8_2013", "B9 8C D8 44");
        carHexMap.put("TrafficCar_Infinity_G35Coupe_2003", "60 0B 3F 4A");
        carHexMap.put("Car_Porsche_911CarreraS993_1996", "EB AC 77 4C");
        carHexMap.put("TrafficCar_Ford_CrownVictoriaPoliceInterceptor_2008", "26 50 5C 51");
        carHexMap.put("TrafficCar_Ford_F150_2009", "88 D6 5C 52");
        carHexMap.put("Car_Volkswagen_GolfGti_1974", "35 BD EE 53");
        carHexMap.put("Car_Ford_CrownVictoriaPoliceInterceptor_2008", "19 0E FF 55");
        carHexMap.put("Car_Nissan_Fairlady240ZG_1971", "30 07 D3 58");
        carHexMap.put("Car_Porsche_CaymanGT4_2015", "D9 1A F3 59");
        carHexMap.put("Car_BMW_M3E46_2003", "B1 C6 25 5B");
        carHexMap.put("Car_Ford_Mustang_1965", "F2 2E 7A 64");
        carHexMap.put("Car_Lamborghini_MurcielagoSV_2010", "E9 8B 14 6B");
        carHexMap.put("Car_SRT_ViperGTS_2014", "5B 1E 3C 6B");
        carHexMap.put("Car_Honda_CivicTypeR_2000", "E3 8E D2 75");
        carHexMap.put("TrafficCar_GMC_TopKick_2003", "67 FE 27 76");
        carHexMap.put("Car_Mazda_RX7SpiritR_2002", "68 EE 4B 7B");
        carHexMap.put("Car_Honda_S2000UltimateEdition_2009", "4A E0 7E 7D");
        carHexMap.put("Car_Dodge_ChallengerSRT_2014", "4D D0 81 80");
        carHexMap.put("Car_Porsche_911CarreraRSR_1974", "56 BF BE 9E");
        carHexMap.put("Car_Lotus_ExigeS_2006", "56 BF BE 9E");
        carHexMap.put("Car_Lamborghini_DiabloSuperVeloce_1995", "71 DE 86 9F");
        carHexMap.put("Car_Chevrolet_CorvetteZ06_2013", "BD 71 D2 A3");
        carHexMap.put("Car_Nissan_SilviaSpecR_2002", "A6 79 35 A5");
        carHexMap.put("Car_BMW_M3E92Coupe_2012", "34 A8 8A A5");
        carHexMap.put("Car_Subaru_ImprezaWRX_2010", "B5 5F 7A AB");
        carHexMap.put("Car_Nissan_GTRSkylineKPGC10_1971", "7B CE F1 B1");
        carHexMap.put("Car_Chevrolet_CamaroZ28_2014", "7B CE F1 B1");
        carHexMap.put("Car_Nissan_GTRSkylineKPGC10", "96 90 F1 B3");
        carHexMap.put("Car_Nissan_GTRSkylineKPGC10_1971", "FA 49 6A B7");
        carHexMap.put("Car_McLaren_570S_2015", "FA 49 6A B7");
        carHexMap.put("Car_BMW_M4_2015", "16 2E A3 B7");
        carHexMap.put("Car_MercedesBenz_AMGGT_2015", "32 3F AA B8");
        carHexMap.put("Car_Porsche_911CarreraRSR_1974", "B3 4A BA B9");
        carHexMap.put("Car_Mazda_MX5_2015", "B3 4A BA B9");
        carHexMap.put("BMWM3E30Evo2", "70 AA 3C C3");
        carHexMap.put("Car_BMW_M2_2016", "93 D8 D6 C6");
        carHexMap.put("TrafficCar_Ford_Explorer_2011", "98 D8 E8 C6");
        carHexMap.put("Car_Acura_RSXS_2004", "99 1C 0E C8");
        carHexMap.put("Car_Nissan_SkylineGTRNismoZTune_2005", "96 1E 4D CA");
        carHexMap.put("Car_Honda_NSXTypeR_1992", "D1 D5 40 CB");
        carHexMap.put("NissanGTRPremium", "0C 4E 1E CD");
        carHexMap.put("Car_Mazda_MX5_1996", "45 EC 37 D0");
        carHexMap.put("TrafficCar_Dodge_Caliber_2007", "94 62 3E D0");
        carHexMap.put("TrafficCar_Chevrolet_Express_2003", "AD 86 09 D4");
        carHexMap.put("Car_Porsche_991GT3_2015", "36 DD C3 D9");
        carHexMap.put("Car_Ford_MustangGT_2015", "EC 3C 3E DD");
        carHexMap.put("Car_Porsche_CarreraS_2014", "41 FB DF DF");
        carHexMap.put("Car_Mitsubishi_EvolutionMR_2008", "B2 E0 F3 F7");
        carHexMap.put("Nissan180sx", "24 A9 49 FC");



        Scanner scanner = new Scanner(System.in);
        scr.clearScr();
        scr.printTitle();
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_BOLD = "\u001B[1m";
        final String ANSI_LIGHT_BLUE = "\u001B[94m";
        final String ANSI_UNDERLINE = "\u001B[4m";
        final String ANSI_LIGHT_GREEN = "\u001B[92m";
        final String ANSI_GREEN = "\u001B[32m";

        // Stampa del testo formattato
        System.out.println(ANSI_RED + ANSI_BOLD + "\n------------------------WARNING!!!!!----------------------" + ANSI_RESET);
        System.out.println("To use this option you first need to have the specific cars!!");
        System.out.println(ANSI_LIGHT_BLUE + ANSI_BOLD + "\n[HOW IT WORK]" + ANSI_RESET);
        System.out.println("1) Write the name of the car you want to swap " + ANSI_BOLD + "(find it in the .txt file)" + ANSI_RESET);
        System.out.println("2) See if the program find it");
        System.out.println("3) Write the name of the car you want to swap with");
        System.out.println("\u001B[34mWrite "+ANSI_BOLD+"exit" + ANSI_RESET+" \u001B[34mto Exit & Save" +  ANSI_RESET);
        while (true) {
            String hexDiSostituzione;
            System.out.println("\nWhich car do you want to substitute?");
            String macchinaDaSostituire = scanner.nextLine();

            if (macchinaDaSostituire.equalsIgnoreCase("exit")) {
                scr.clearScr();
                break;
            }

            String hexDaSostituire = carHexMap.get(macchinaDaSostituire);

            if (hexDaSostituire != null) {
                System.out.println(ANSI_GREEN + ANSI_BOLD + "(✓) CAR FOUND SUCCESSFULLY IN THE " + ANSI_UNDERLINE + "DATABASE" + ANSI_RESET);

                if (hexString.contains(hexDaSostituire)) {
                    System.out.println(ANSI_GREEN + ANSI_BOLD + "(✓) CAR FOUND SUCCESSFULLY IN THE " + ANSI_UNDERLINE + "SAVE" + ANSI_RESET);
                    while (true) {
                        System.out.println("\nWith which car do you want to substitute it?");
                        String macchinaDiSostituzione = scanner.nextLine();
                        hexDiSostituzione = carHexMap.get(macchinaDiSostituzione);
                        if (hexDiSostituzione != null) {
                            System.out.println(ANSI_GREEN + ANSI_BOLD + "(✓) CAR FOUND SUCCESSFULLY IN THE " + ANSI_UNDERLINE + "DATABASE" + ANSI_RESET);
                            Pattern pattern = Pattern.compile(hexDaSostituire);
                            Matcher matcher = pattern.matcher(hexString);
                            hexString = matcher.replaceFirst(hexDiSostituzione);
                            System.out.println(ANSI_UNDERLINE + "SUBSTITUTION APPLIED SUCCESSFULLY" + ANSI_RESET);
                            break;
                        } else {
                            System.out.println(ANSI_RED + ANSI_BOLD + "(X) CAN'T FIND THE CAR IN THE " + ANSI_UNDERLINE + "DATABASE" + ANSI_RESET + ANSI_RED + ANSI_BOLD +", PLEASE TRY AGAIN/ANOTHER ONE" + ANSI_RESET);
                        }
                    }
                } else {
                    System.out.println(ANSI_RED + ANSI_BOLD + "(X) CAN'T FIND THE CAR IN THE " + ANSI_UNDERLINE + "SAVE" + ANSI_RESET + ANSI_RED + ANSI_BOLD +", PLEASE TRY ANOTHER CAR OR ADD IT IN THE GAME AND TRY AGAIN" + ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED + ANSI_BOLD + "(X) CAN'T FIND THE CAR IN THE " + ANSI_UNDERLINE + "DATABASE" + ANSI_RESET + ANSI_RED + ANSI_BOLD +", PLEASE TRY AGAIN/ANOTHER ONE" + ANSI_RESET);
            }
        }
        return hexString;

    }

}
