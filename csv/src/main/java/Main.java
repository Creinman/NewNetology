import java.util.*;
import java.io.*;
import com.opencsv.CSVReader;

public class Main {
    public void main(String[] args){
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = parseCSV(columnMapping, fileName);

        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy =
                    new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping("id", "firstName", "lastName", "country", "age");
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            List<Employee> list = csv.parse();
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = listToJson(list);
        Type listType = new TypeToken<List<T>>() {}.getType();
        String json = gson.toJson(list, listType);
        try (FileWriter file = new
                FileWriter("data.json")) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
