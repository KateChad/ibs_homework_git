package show;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;
//
public class Functions {
    private static final Scanner scanner = new Scanner(System.in);

    public static void shortInfo(List<Company> companyes) {
        System.out.println("Компания:");
        companyes.forEach(i -> System.out.printf("%s - %s%n", i.getName(), formatDate(i.getFounded())));
    }
    //дописать вывод всх ценных бумаг (код - дата истечения - полное название организации владельца)
    public static void getListofSecurity(List<Company> companies){
        System.out.println("Все ценные бумаги:");
        List<Security> securities = companies.stream().map(Company::getSecurities).flatMap(Collection::stream)
                .collect(Collectors.toList());
        securities.forEach(i -> System.out.printf("%s - %s - %s%n", i.getCode(), i.getDate(), i.getName()));

        System.out.printf("Общее количество ценных бумаг (включая просроченные): %s%n", securities.size());
    }
    public static void expiredDateSecurity(List<Company> companies) {
        System.out.println("\n" + "Просроченные на текущий день ценные бумаги:");
        List<Security> securitiesExpired = companies.stream().map(Company::getSecurities).flatMap(Collection::stream)
                .filter(i -> convertToLocalDate(i.getDate()).isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        securitiesExpired.forEach(i -> System.out.printf("%s - %s - %s%n", i.getCode(), i.getDate(), i.getName()));

        System.out.printf("Количество ценных бумаг просроченных на текущий день: %s%n", securitiesExpired.size());
    }

    public static void сurrencyDate(List<Company> companyes) {
        System.out.println("\nКомпании основанные после даты: ");
        System.out.println("Введите дату (dd.mm.yy, dd.mm.yyyy, dd/mm/yy, dd/mm/yyyy): ");
        String inputDate = scanner.nextLine();
        LocalDate date = convertToLocalDate(inputDate);
        LocalDate dateAfter = LocalDate.parse("1970-12-31");
        LocalDate dateBefor = LocalDate.parse("2071-01-01");
        if (date != null && date.isAfter(dateAfter) && date.isBefore(dateBefor)){
            System.out.printf("Вы ввели: %s%n", date);

            companyes.stream().filter(i -> convertToLocalDate(i.getFounded()).isAfter(date))
                    .forEach(i -> System.out.printf("%s - %s%n", i.getName(), i.getFounded()));
        } else {
            System.out.println("Некоректный ввод данных");
        }
    }

    public static void сurrencySelection(List<Company> companyes) {
        System.out.println("\n" +" Использование валюты : ");
        System.out.println("Введите валюту (rub, eu, usd): ");
        String currency = scanner.nextLine();

        if (currency.equalsIgnoreCase("rub")
                || currency.equalsIgnoreCase("eu")
                || currency.equalsIgnoreCase("usd")){

            List<Security> securitiesUsingCurrency = companyes.stream().map(Company::getSecurities).flatMap(Collection::stream)
                    .filter(i -> i.getCurrency().contains(currency.toUpperCase()))
                    .distinct()
                    .collect(Collectors.toList());

            companyes.stream().filter(i -> i.getSecurities().stream().anyMatch(securitiesUsingCurrency::contains))
                    .peek(i -> System.out.printf("id компании: %s (%s)%n", i.getId(), i.getName()))
                    .map(Company::getSecurities).flatMap(Collection::stream)
                    .filter(securitiesUsingCurrency::contains)
                    .forEach(i -> System.out.printf("%s (%s)%n", i.getCode(), i.getName()));
        } else {
            System.out.println("Некоректный ввод данных");
        }
    }


    private static String formatDate(String inputDate){
        LocalDate date = convertToLocalDate(inputDate);
        if (date != null){
            return date.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        } else{
            return null;
        }
    }

    public static LocalDate convertToLocalDate(String inputDate){
        Map<String, String> patterns = new HashMap<>();
        patterns.put("\\d{1,2}/\\d{1,2}/\\d{2,4}", "dd/M/");
        patterns.put("\\d{1,2}\\.\\d{1,2}\\.\\d{2,4}", "dd.M.");

        DateTimeFormatter formatter = null;
        LocalDate date = null;
        for(Map.Entry<String, String> pattern : patterns.entrySet()){
            if (inputDate.matches(pattern.getKey())){
                formatter = new DateTimeFormatterBuilder()
                        .appendPattern(pattern.getValue())
                        .appendValueReduced(ChronoField.YEAR_OF_ERA, 2, 4, LocalDate.now().minusYears(51))
                        .toFormatter();
                break;
            }
        }
        if (formatter != null){
            try {
                date = LocalDate.parse(inputDate, formatter);
            }
            catch (DateTimeParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public static Companyes parseJson(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        Companyes companyes = null;
        try {
            companyes = mapper.readValue(new File(fileName), Companyes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companyes;
    }

}
