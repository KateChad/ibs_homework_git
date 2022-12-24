package show;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fileName = "src/main/resources/Shares.json";

        Companyes obj = Functions.parseJson(fileName);
        List<Company> companyes;

        if (obj != null){
            companyes = obj.getCompany();

            Functions.shortInfo(companyes);

            Functions.getListofSecurity(companyes);

            Functions.expiredDateSecurity(companyes);

            Functions.сurrencyDate(companyes);

            Functions.сurrencySelection(companyes);
        }
    }

   }