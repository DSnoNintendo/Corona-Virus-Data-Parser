import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Test {


    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        System.out.println(temp);
        return temp;
    }

    static void loadData() {

        String pathFile1 = "src/locations.csv";
        String pathFile2 = "src/full_data.csv";
        String row;
        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(pathFile1));

            while ((row = csvReader.readLine()) != null) {
                System.out.println(row);


            }
            csvReader.close();


            csvReader = new BufferedReader(new FileReader(pathFile2));

            while ((row = csvReader.readLine()) != null) {
                //make sure only most recent dates are used
                String[] parsedRow = row.split(",");

            }
            csvReader.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static HashMap<String, Integer> getTotalCases(HashMap<String, Integer> map) {

        String pathFile1 = "src/locations.csv";
        String pathFile2 = "src/full_data.csv";
        String row;
        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(pathFile1));

            while ((row = csvReader.readLine()) != null) {
                System.out.println(row);


            }
            csvReader.close();


            csvReader = new BufferedReader(new FileReader(pathFile2));

            while ((row = csvReader.readLine()) != null) {
                //make sure only most recent dates are used
                String[] parsedRow = row.split(",");
                if ( parsedRow[0].equals("2020-05-03") ) {

                    map.put(parsedRow[1],Integer.parseInt(parsedRow[4]));
                }

            }
            csvReader.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return map;
    }
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        System.out.println("************************************");
        System.out.println("COVID 19 GLOBAL STATISTICS MENU (LAST UPDATE MAY 3RD");
        System.out.println("************************************");
        System.out.println("[1] Load data from files");
        System.out.println("[2] Print continents total cases (lowest to highest)");
        System.out.println("[3] Print continents total cases (highest to lowest)");
        System.out.println("[4] Print continents total deaths (lowest to highest)");
        System.out.println("[5] Print continents total deaths (highest to lowest)");
        System.out.println("[6] Prioritize top countries for testing based on new cases per 1 million");
        System.out.println("[7] Prioritize top countries for testing based on new cases per 1 million");


        HashMap<String, Integer> caseMap= new HashMap<>();
        HashMap<String, Integer> totalCases = new HashMap<>();
        while (true) {
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    loadData();
                    caseMap = getTotalCases(caseMap);
                    break;
                case "2":
                    Map<String, Integer> hm1 = sortByValue(caseMap);
                    for (Map.Entry<String, Integer> en : hm1.entrySet()) {
                        System.out.println(en.getKey() +
                                ", " + en.getValue());
                    }
                    break;

            }
        }




    }
}
